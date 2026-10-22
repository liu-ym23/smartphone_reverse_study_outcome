package com.huawei.hms.api;

import android.content.Intent;

/* JADX INFO: loaded from: classes23.dex */
public class HuaweiServicesRepairableException extends UserRecoverableException {
    private final int statusCode;

    public int getConnectionStatusCode() {
        return this.statusCode;
    }

    public HuaweiServicesRepairableException(int r100, String r101, Intent r102) {
        super(r101, r102);
        this.statusCode = r100;
    }
}
