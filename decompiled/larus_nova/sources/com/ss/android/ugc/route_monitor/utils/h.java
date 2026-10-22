package com.ss.android.ugc.route_monitor.utils;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes40.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f454772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Throwable f454773b;

    public h(com.ss.android.ugc.route_monitor.impl.route_out.b r100, Throwable r101) {
        this.f454772a = r100;
        this.f454773b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f454772a.e(this.f454773b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
