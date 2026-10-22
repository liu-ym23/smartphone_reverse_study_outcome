package com.bytedance.ee.bear.drive.biz.comment.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.scaleimageview.areacomment.AreaCoordinate;
import java.io.Serializable;

/* JADX INFO: loaded from: classes16.dex */
public class AreaCommentPayLoadData implements Serializable {
    public static final String PUSH_TYPE = "drive_comment";

    @JSONField(name = "drive_area_coordinate")
    private AreaCoordinate areaCoordinate;

    @JSONField(name = "comment_id")
    private String commentId;
    private String type;

    @JSONField(name = "user_id")
    private String userId;
    private String version;

    public AreaCommentPayLoadData() {
    }

    public AreaCoordinate getAreaCoordinate() {
        return this.areaCoordinate;
    }

    public String getCommentId() {
        return this.commentId;
    }

    public String getType() {
        return this.type;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getVersion() {
        return this.version;
    }

    public void setAreaCoordinate(AreaCoordinate r100) {
        this.areaCoordinate = r100;
    }

    public void setCommentId(String r100) {
        this.commentId = r100;
    }

    public void setType(String r100) {
        this.type = r100;
    }

    public void setUserId(String r100) {
        this.userId = r100;
    }

    public void setVersion(String r100) {
        this.version = r100;
    }
}
