package com.larksuite.framework.thread;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes24.dex */
public final class u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v f285803a;

    @Override // java.lang.Runnable
    public final void run() {
        this.f285803a.f285808e.incrementAndGet();     // Catch: Throwable -> L6
        v r100 = this.f285803a;     // Catch: Throwable -> L6
        v.a r101 = r100.f285807d;     // Catch: Throwable -> L6
        if (r101 == null) goto L9;
        r101.a(r100.f285808e);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public u(v r100) {
        this.f285803a = r100;
    }
}
