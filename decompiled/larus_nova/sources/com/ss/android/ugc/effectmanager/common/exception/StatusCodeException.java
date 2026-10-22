package com.ss.android.ugc.effectmanager.common.exception;

/* JADX INFO: loaded from: classes40.dex */
public class StatusCodeException extends Exception {
    private int mStatusCode;

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public void setStatusCode(int r100) {
        this.mStatusCode = r100;
    }

    public StatusCodeException(int r100, String r101) {
        super(r101);
        this.mStatusCode = r100;
    }
}
