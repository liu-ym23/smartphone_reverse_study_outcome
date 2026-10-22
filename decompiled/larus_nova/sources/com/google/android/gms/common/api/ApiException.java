package com.google.android.gms.common.api;

/* JADX INFO: loaded from: classes23.dex */
public class ApiException extends Exception {
    protected final Status mStatus;

    public Status getStatus() {
        return this.mStatus;
    }

    public int getStatusCode() {
        return this.mStatus.getStatusCode();
    }

    public String getStatusMessage() {
        return this.mStatus.getStatusMessage();
    }

    public ApiException(Status r100) {
        int r101 = r100.getStatusCode();
        if (r100.getStatusMessage() == null) goto L5;
        String r102 = r100.getStatusMessage();
    L6:
        super(r101 + ": " + r102);
        this.mStatus = r100;
        return;
    L5:
        r102 = "";
        goto L6
    }
}
