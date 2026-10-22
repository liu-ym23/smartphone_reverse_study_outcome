package com.bytedance.ee.bear.middleground.comment.export.bean;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes18.dex */
public class SwitchCardBean implements NonProguard {
    private String commentId;

    public SwitchCardBean() {
    }

    public String toString() {
        return "SwitchCardBean{commentId='" + this.commentId + "'}";
    }

    public String getCommentId() {
        return this.commentId;
    }

    public void setCommentId(String r100) {
        this.commentId = r100;
    }
}
