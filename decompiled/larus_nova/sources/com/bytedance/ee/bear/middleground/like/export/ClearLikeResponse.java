package com.bytedance.ee.bear.middleground.like.export;

import java.io.Serializable;

/* JADX INFO: loaded from: classes18.dex */
public class ClearLikeResponse implements Serializable {
    private int code;
    private DATA data;
    private String msg;

    public static class DATA implements Serializable {

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private String f232801id;

        public DATA() {
        }

        public String toString() {
            return "DATA{id='" + this.f232801id + "'}";
        }

        public String getId() {
            return this.f232801id;
        }

        public void setId(String r100) {
            this.f232801id = r100;
        }
    }

    public ClearLikeResponse() {
    }

    public String toString() {
        return "AddLikeResponse{code=" + this.code + ", msg='" + this.msg + "', data=" + this.data + '}';
    }

    public int getCode() {
        return this.code;
    }

    public DATA getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(int r100) {
        this.code = r100;
    }

    public void setData(DATA r100) {
        this.data = r100;
    }

    public void setMsg(String r100) {
        this.msg = r100;
    }
}
