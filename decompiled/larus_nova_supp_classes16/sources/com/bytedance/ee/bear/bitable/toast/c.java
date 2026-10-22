package com.bytedance.ee.bear.bitable.toast;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements Runnable {
    public final /* synthetic */ b a;

    public c(b r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b.a(this.a);     // Catch: Throwable -> L6
        b.InterfaceC0027b r0 = this.a.c;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.onTimeout();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
