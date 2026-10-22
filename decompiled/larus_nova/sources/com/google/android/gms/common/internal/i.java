package com.google.android.gms.common.internal;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes23.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f274541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f274542b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BaseGmsClient f274543c;

    public i(BaseGmsClient r100, Object r101) {
        this.f274543c = r100;
        this.f274541a = r101;
        this.f274542b = false;
    }

    public abstract void a();

    public abstract void b();

    public final void c() {
        monitor-enter(this);
        this.f274541a = null;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void d() {
        c();
        ArrayList r100 = BaseGmsClient.zzf(this.f274543c);
        monitor-enter(r100);
        BaseGmsClient.zzf(this.f274543c).remove(this);     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
