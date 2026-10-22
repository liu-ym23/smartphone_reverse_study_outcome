package com.bytedance.crypto.cloudtrans;

/* JADX INFO: loaded from: classes6.dex */
public class CloudTransException extends Exception {
    private int errorCode;

    public CloudTransException(String r100) {
        super(r100);
    }

    public CloudTransException(String r100, int r101) {
        super(r100);
        this.errorCode = r101;
    }

    public CloudTransException(String r100, Throwable r101) {
        super(r100, r101);
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(int r100) {
        this.errorCode = r100;
    }
}
