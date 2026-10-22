package com.bytedance.ee.bear.document.comment.bean;

import java.io.Serializable;

/* JADX INFO: loaded from: classes16.dex */
public class CommentResultBean implements Serializable {
    private String action;
    private long code;
    private String msg;
    private String token;

    public CommentResultBean() {
    }

    public String toString() {
        return "CommentResultBean{token='', action='" + this.action + "', code=" + this.code + ", msg='" + this.msg + "'}";
    }

    public String getAction() {
        return this.action;
    }

    public long getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getToken() {
        return this.token;
    }

    public void setAction(String r100) {
        this.action = r100;
    }

    public void setCode(long r100) {
        this.code = r100;
    }

    public void setMsg(String r100) {
        this.msg = r100;
    }

    public void setToken(String r100) {
        this.token = r100;
    }
}
