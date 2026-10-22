package com.ss.lark.android.encryption.exception;

import java.io.IOException;

/* JADX INFO: loaded from: classes40.dex */
public class CipherException extends IOException {
    protected int mErrorCode;

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public CipherException(int r100) {
        this.mErrorCode = r100;
    }
}
