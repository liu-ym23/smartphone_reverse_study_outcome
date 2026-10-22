package com.google.android.gms.common;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes23.dex */
abstract class zzl extends zzj {

    /* JADX INFO: renamed from: zza, reason: collision with root package name */
    private static final WeakReference f274618zza = null;

    /* JADX INFO: renamed from: zzb, reason: collision with root package name */
    private WeakReference f274619zzb;

    public abstract byte[] zzb();

    @Override // com.google.android.gms.common.zzj
    public final byte[] zzf() {
        monitor-enter(this);
        byte[] r100 = (byte[]) this.f274619zzb.get();     // Catch: Throwable -> L8
        if (r100 != null) goto L6;
        r100 = zzb();     // Catch: Throwable -> L8
        this.f274619zzb = new WeakReference(r100);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
        return r100;
    L8:
        th = move-exception;
        throw th;
    }

    static {
        f274618zza = new WeakReference(null);
    }

    public zzl(byte[] r100) {
        super(r100);
        this.f274619zzb = f274618zza;
    }
}
