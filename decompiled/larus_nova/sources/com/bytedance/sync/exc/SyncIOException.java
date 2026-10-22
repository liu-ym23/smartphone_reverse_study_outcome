package com.bytedance.sync.exc;

import java.io.IOException;

/* JADX INFO: loaded from: classes22.dex */
public class SyncIOException extends IOException implements a {
    int errorCode;

    @Override // com.bytedance.sync.exc.a
    public String getErrorMsg() {
        return getMessage();
    }

    @Override // com.bytedance.sync.exc.a
    public int getErrorCode() {
        return this.errorCode;
    }

    public SyncIOException(int r100, String r101, Throwable r102) {
        super(r101, r102);
        this.errorCode = r100;
    }
}
