package com.bytedance.applog.priority;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
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

    public PriorityHttpResponse(int r1, String r2, String r3) {
        this.code = r1;
        this.errMsg = r2;
        this.data = r3;
    }
}
