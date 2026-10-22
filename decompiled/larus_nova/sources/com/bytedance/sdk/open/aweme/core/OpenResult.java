package com.bytedance.sdk.open.aweme.core;

/* JADX INFO: loaded from: classes22.dex */
public class OpenResult<T> {
    private T data;
    private int errCode;
    private String msg;

    public OpenResult(int r100, String r101) {
        this.errCode = r100;
        this.msg = r101;
    }

    public OpenResult(int r100, String r101, T r102) {
        this.errCode = r100;
        this.msg = r101;
        this.data = r102;
    }

    public T getData() {
        return this.data;
    }

    public int getErrCode() {
        return this.errCode;
    }

    public String getMsg() {
        return this.msg;
    }

    public boolean isSuccess() {
        if (this.errCode != 0) goto L5;
        return true;
    L5:
        return false;
    }
}
