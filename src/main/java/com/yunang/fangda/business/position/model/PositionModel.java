package com.yunang.fangda.business.position.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Table;
import org.springframework.data.annotation.Transient;
import org.springframework.data.annotation.Version;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: LD
 * @date:
 * @description:
 */
@ApiModel(value = "职位表")
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "position_table")
@Table(comment = "职位表", appliesTo = "position_table")
@JsonIgnoreProperties(ignoreUnknown = true)
public class PositionModel implements Serializable {

    @ApiModelProperty(value = "主键", example = "除新增外必填，由后台自动生成")
    @Id
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @GeneratedValue(generator = "system-uuid")
    private String uuid;

    @ApiModelProperty(value = "职位名称", example = "最大32位字符串")
    @Column(name = "pos_name", length = 32)
    private String posName;

    @ApiModelProperty(value = "职位父级", example = "最大32位字符串")
    @Column(name = "pos_parent", length = 32)
    private String posParent;

    @Transient
    private List<PositionModel> modelList = new ArrayList<>();

    @Version
    private Long version;

}
