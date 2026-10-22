package com.google.android.gms.common;

import android.content.Intent;

/* JADX INFO: loaded from: classes23.dex */
public class UserRecoverableException extends Exception {

    /* JADX INFO: renamed from: zza, reason: collision with root package name */
    private final Intent f274464zza;

    public Intent getIntent() {
        return new Intent(this.f274464zza);
    }

    public UserRecoverableException(String r100, Intent r101) {
        super(r100);
        this.f274464zza = r101;
    }
}
