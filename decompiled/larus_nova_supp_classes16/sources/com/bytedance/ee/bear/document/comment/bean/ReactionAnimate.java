package com.bytedance.ee.bear.document.comment.bean;

import com.bytedance.ee.bear.jsbridge.jsapi.entity.BaseJSModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ReactionAnimate implements BaseJSModel {
    private String reactionKey;

    public ReactionAnimate() {
    }

    public String toString() {
        return "ReactionAnimate{reactionKey='" + this.reactionKey + "'}";
    }

    public String getReactionKey() {
        return this.reactionKey;
    }

    public void setReactionKey(String r1) {
        this.reactionKey = r1;
    }
}
