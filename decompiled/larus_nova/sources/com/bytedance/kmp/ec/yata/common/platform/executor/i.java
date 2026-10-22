package com.bytedance.kmp.ec.yata.common.platform.executor;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes19.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f251534a;

    @Override // java.lang.Runnable
    public final void run() {
    L25:
        h r100 = this.f251534a;     // Catch: Throwable -> L16
        monitor-enter(r100);     // Catch: Throwable -> L16
        f r101 = r100.c();     // Catch: Throwable -> L13
        monitor-exit(r100);     // Catch: Throwable -> L16
        if (r101 == null) goto L28;
        h.a(this.f251534a, r101);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.f251534a.f251527a.execute(this);     // Catch: Throwable -> L16
        throw th;     // Catch: Throwable -> L16
    L28:
        return;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L20;
        return;
    L20:
        throw th;
    }

    public i(h r100) {
        this.f251534a = r100;
    }
}
