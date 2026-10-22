package com.bytedance.sync.exc;

/* JADX INFO: loaded from: classes22.dex */
public class SyncApiException extends Exception implements a {
    private int errorCode;

    @Override // com.bytedance.sync.exc.a
    public String getErrorMsg() {
        return getMessage();
    }

    @Override // com.bytedance.sync.exc.a
    public int getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(int r100) {
        this.errorCode = r100;
    }

    public SyncApiException(int r100, String r101) {
        super(r101);
        this.errorCode = r100;
    }
}
