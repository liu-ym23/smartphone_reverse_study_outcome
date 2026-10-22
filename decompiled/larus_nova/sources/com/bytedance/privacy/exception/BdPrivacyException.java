package com.bytedance.privacy.exception;

/* JADX INFO: loaded from: classes6.dex */
public class BdPrivacyException extends Exception {
    private int errorCode;

    public int getErrorCode() {
        return this.errorCode;
    }

    public BdPrivacyException(String r100) {
        super(r100);
    }

    public void setErrorCode(int r100) {
        this.errorCode = r100;
    }

    public BdPrivacyException(Throwable r100) {
        super(r100);
    }

    public BdPrivacyException(String r100, int r101) {
        super(r100);
        this.errorCode = r101;
    }

    public BdPrivacyException(String r100, Throwable r101) {
        super(r100, r101);
    }

    public BdPrivacyException(String r100, int r101, Throwable r102) {
        super(r100, r102);
        this.errorCode = r101;
    }
}
