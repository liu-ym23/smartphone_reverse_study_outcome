package com.bytedance.sdk.open.aweme.commonbase.net.interceptor;

/* JADX INFO: loaded from: classes22.dex */
public class OpenException extends Exception {
    private int errCode;
    private String errMsg;

    public OpenException(int r100, String r101) {
        this.errCode = r100;
        this.errMsg = r101;
    }

    public int getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }
}
