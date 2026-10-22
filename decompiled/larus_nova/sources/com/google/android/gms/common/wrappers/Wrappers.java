package com.google.android.gms.common.wrappers;

import android.content.Context;

/* JADX INFO: loaded from: classes23.dex */
public class Wrappers {

    /* JADX INFO: renamed from: zza, reason: collision with root package name */
    private static final Wrappers f274614zza = null;

    /* JADX INFO: renamed from: zzb, reason: collision with root package name */
    private PackageManagerWrapper f274615zzb;

    static {
        f274614zza = new Wrappers();
    }

    public Wrappers() {
        this.f274615zzb = null;
    }

    public static PackageManagerWrapper packageManager(Context r100) {
        return f274614zza.zza(r100);
    }

    public final synchronized PackageManagerWrapper zza(Context r100) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.f274615zzb == null) goto L6;
    L9:
        PackageManagerWrapper r101 = this.f274615zzb;     // Catch: Throwable -> L12
        monitor-exit(this);
        return r101;
    L6:
        if (r100.getApplicationContext() == null) goto L8;
        r100 = r100.getApplicationContext();     // Catch: Throwable -> L12
    L8:
        this.f274615zzb = new PackageManagerWrapper(r100);     // Catch: Throwable -> L12
        goto L9
    }
}
