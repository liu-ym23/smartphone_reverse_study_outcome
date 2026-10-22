package com.google.android.gms.common;

import android.content.Intent;

/* JADX INFO: loaded from: classes23.dex */
public class GooglePlayServicesRepairableException extends UserRecoverableException {

    /* JADX INFO: renamed from: zza, reason: collision with root package name */
    private final int f274459zza;

    public int getConnectionStatusCode() {
        return this.f274459zza;
    }

    public GooglePlayServicesRepairableException(int r100, String r101, Intent r102) {
        super(r101, r102);
        this.f274459zza = r100;
    }
}
