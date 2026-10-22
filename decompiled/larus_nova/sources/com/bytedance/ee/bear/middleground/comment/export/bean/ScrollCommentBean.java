package com.bytedance.ee.bear.middleground.comment.export.bean;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes18.dex */
public class ScrollCommentBean implements NonProguard {
    public static final String HEAD = "IN_HEADER";
    public String cur_comment_id;
    public String replyId;
    public float replyPercentage;
    public String token;

    public ScrollCommentBean() {
    }

    public String toString() {
        return "ScrollCommentBean{, cur_comment_id='" + this.cur_comment_id + "', replyId='" + this.replyId + "', replyPercentage=" + this.replyPercentage + '}';
    }

    public String getCur_comment_id() {
        return this.cur_comment_id;
    }

    public String getReplyId() {
        return this.replyId;
    }

    public float getReplyPercentage() {
        return this.replyPercentage;
    }

    public String getToken() {
        return this.token;
    }
}
