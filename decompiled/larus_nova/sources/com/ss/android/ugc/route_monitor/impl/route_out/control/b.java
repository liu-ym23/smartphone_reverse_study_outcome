package com.ss.android.ugc.route_monitor.impl.route_out.control;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes40.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f454611a;

    public b(c r100) {
        this.f454611a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        mhc.b r100 = j.f454635a;     // Catch: Throwable -> L10
        c r101 = this.f454611a;     // Catch: Throwable -> L10
        e r102 = j.f454637c;     // Catch: Throwable -> L10
        monitor-enter(r102);     // Catch: Throwable -> L10
        r102.remove(r101);     // Catch: Throwable -> L7
        monitor-exit(r102);     // Catch: Throwable -> L10
        return;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L18;
        throw th;
    }
}
