package com.bytedance.ee.bear.middleground.like.export;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ClearLikeResponse implements Serializable {
    private int code;
    private DATA data;
    private String msg;

    public static class DATA implements Serializable {
        private String id;

        public DATA() {
        }

        public String toString() {
            return "DATA{id='" + this.id + "'}";
        }

        public String getId() {
            return this.id;
        }

        public void setId(String r1) {
            this.id = r1;
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

    public void setCode(int r1) {
        this.code = r1;
    }

    public void setData(DATA r1) {
        this.data = r1;
    }

    public void setMsg(String r1) {
        this.msg = r1;
    }
}
