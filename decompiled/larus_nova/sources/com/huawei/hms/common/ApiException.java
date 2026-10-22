package com.huawei.hms.common;

import com.huawei.hms.support.api.client.Status;

/* JADX INFO: loaded from: classes23.dex */
public class ApiException extends Exception {
    protected final Status mStatus;

    public int getStatusCode() {
        return this.mStatus.getStatusCode();
    }

    public String getStatusMessage() {
        return this.mStatus.getStatusMessage();
    }

    public ApiException(Status r100) {
        StringBuilder r101 = new StringBuilder();
        r101.append(r100.getStatusCode());
        r101.append(": ");
        if (r100.getStatusMessage() == null) goto L5;
        String r102 = r100.getStatusMessage();
    L6:
        r101.append(r102);
        super(r101.toString());
        this.mStatus = r100;
        return;
    L5:
        r102 = "";
        goto L6
    }
}
