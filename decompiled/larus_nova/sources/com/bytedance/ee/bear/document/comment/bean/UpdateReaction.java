package com.bytedance.ee.bear.document.comment.bean;

import com.bytedance.ee.bear.jsbridge.jsapi.entity.BaseJSModel;

/* JADX INFO: loaded from: classes16.dex */
public class UpdateReaction implements BaseJSModel {
    private String reactionKey;

    public UpdateReaction() {
    }

    public String toString() {
        return "UpdateReaction{reactionKey='" + this.reactionKey + "'}";
    }

    public String getReactionKey() {
        return this.reactionKey;
    }

    public void setReactionKey(String r100) {
        this.reactionKey = r100;
    }
}
