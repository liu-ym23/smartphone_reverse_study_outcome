package com.bytedance.ee.bear.middleground.comment.export.bean;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class CommentMentionAuthorize$Response implements NonProguard {
    private int code;
    private CommentMentionAuthorize$ResponseData data;
    private String msg;

    public CommentMentionAuthorize$Response() {
    }

    public String toString() {
        return "CommentMentionAuthorize#Response@" + hashCode() + "{code: " + this.code + ", msg: " + this.msg + ", data: " + this.data + "}";
    }

    public int getCode() {
        return this.code;
    }

    public CommentMentionAuthorize$ResponseData getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(int r1) {
        this.code = r1;
    }

    public void setData(CommentMentionAuthorize$ResponseData r1) {
        this.data = r1;
    }

    public void setMsg(String r1) {
        this.msg = r1;
    }
}
