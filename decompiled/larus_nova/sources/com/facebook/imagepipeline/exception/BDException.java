package com.facebook.imagepipeline.exception;

/* JADX INFO: loaded from: classes23.dex */
public class BDException extends IllegalStateException implements IBDException {
    private final int mErrorCode;
    private final String mErrorMessage;

    @Override // com.facebook.imagepipeline.exception.IBDException
    public int getErrorCode() {
        return this.mErrorCode;
    }

    @Override // com.facebook.imagepipeline.exception.IBDException
    public String getErrorMessage() {
        return this.mErrorMessage;
    }

    public BDException(int r100, String r101) {
        super(r101);
        this.mErrorCode = r100;
        this.mErrorMessage = r101;
    }

    public BDException(int r100, String r101, Throwable r102) {
        super(r101, r102);
        this.mErrorCode = r100;
        this.mErrorMessage = r101;
    }
}
