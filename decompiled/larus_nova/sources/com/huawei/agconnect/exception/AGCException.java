package com.huawei.agconnect.exception;

/* JADX INFO: loaded from: classes23.dex */
public abstract class AGCException extends Exception {
    private int code;
    private String errMsg;

    public AGCException(String r100, int r101) {
        this.code = r101;
        this.errMsg = r100;
    }

    public int getCode() {
        return this.code;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return " code: " + this.code + " message: " + this.errMsg;
    }
}
