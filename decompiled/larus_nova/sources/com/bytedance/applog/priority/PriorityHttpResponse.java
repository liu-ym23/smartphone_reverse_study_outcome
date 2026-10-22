package com.bytedance.applog.priority;

/* JADX INFO: loaded from: classes14.dex */
public class PriorityHttpResponse {
    private final int code;
    private final String data;
    private final String errMsg;

    public String toString() {
        return "code: " + this.code + ", errMsg: " + this.errMsg + ", data: " + this.data;
    }

    public int getCode() {
        return this.code;
    }

    public String getData() {
        return this.data;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public PriorityHttpResponse(int r100, String r101, String r102) {
        this.code = r100;
        this.errMsg = r101;
        this.data = r102;
    }
}
