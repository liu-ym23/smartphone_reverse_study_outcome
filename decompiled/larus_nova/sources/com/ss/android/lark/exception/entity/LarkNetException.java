package com.ss.android.lark.exception.entity;

import com.larksuite.framework.callback.Entity.ErrorResult;

/* JADX INFO: loaded from: classes35.dex */
public class LarkNetException extends LarkException {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Exception f420646e;
    private int errorCode;
    private String msg;

    public ErrorResult getErrorResult() {
        return new ErrorResult(this.errorCode, this.msg, null, null, this.f420646e);
    }

    public int getErrCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.msg;
    }

    public Exception getException() {
        return this.f420646e;
    }

    public LarkNetException(ErrorResult r100) {
        super(r100.getException());
        this.errorCode = r100.getErrorCode();
        this.msg = r100.getDisplayMsg();
        this.f420646e = r100.getException();
    }

    public LarkNetException(int r100, String r101, Exception r102) {
        super(r102);
        this.errorCode = r100;
        this.msg = r101;
        this.f420646e = r102;
    }
}
