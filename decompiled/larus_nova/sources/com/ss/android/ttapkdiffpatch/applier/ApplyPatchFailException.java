package com.ss.android.ttapkdiffpatch.applier;

/* JADX INFO: loaded from: classes38.dex */
public class ApplyPatchFailException extends Exception {
    private final int mErrorCode;

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public ApplyPatchFailException(int r100, String r101) {
        super(r101);
        this.mErrorCode = r100;
    }

    public ApplyPatchFailException(int r100, Throwable r101) {
        super(r101);
        this.mErrorCode = r100;
    }
}
