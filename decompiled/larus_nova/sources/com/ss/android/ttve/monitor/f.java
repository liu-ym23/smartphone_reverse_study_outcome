package com.ss.android.ttve.monitor;

import android.content.Context;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes38.dex */
public final class f implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        Object r100 = g.f449938d;     // Catch: Throwable -> L11
        monitor-enter(r100);     // Catch: Throwable -> L11
        g.f449937c = true;     // Catch: Throwable -> L8
        r100.notifyAll();     // Catch: Throwable -> L8
        monitor-exit(r100);     // Catch: Throwable -> L8
    L14:
        return;
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L20;
        throw th;
    }

    public f(Context r100, String r101) {
    }
}
