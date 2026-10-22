package com.bytedance.crash.monitor;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes6.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f203314a;

    @Override // java.lang.Runnable
    public final void run() {
        this.f203314a.u();     // Catch: Throwable -> L10
        g.d r100 = this.f203314a.f203304t;     // Catch: Throwable -> L10
        monitor-enter(r100);     // Catch: Throwable -> L10
        r100.notifyAll();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
    L13:
        return;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L18;
        throw th;
    }

    public i(g r100) {
        this.f203314a = r100;
    }
}
