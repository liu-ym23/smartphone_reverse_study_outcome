package com.bytedance.privacy.sdid;

import com.alipay.sdk.m.u.i;

/* JADX INFO: loaded from: classes21.dex */
public class SDIDException extends Exception {
    private String errMsg;
    private int errorCode;

    @Override // java.lang.Throwable
    public String toString() {
        return "SDIDException{errCode=" + this.errorCode + ", errMsg=" + this.errMsg + i.f25855d;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public SDIDException(int r100, String r101) {
        super(r101);
        this.errorCode = r100;
        this.errMsg = r101;
    }
}
