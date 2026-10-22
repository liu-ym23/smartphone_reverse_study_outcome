package com.bytedance.ee.bear.drive.core.fragment;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class o implements Runnable {
    public final /* synthetic */ k a;

    public o(k r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        k.b(this.a);     // Catch: Throwable -> L6
        this.a.j();     // Catch: Throwable -> L6
        k r0 = this.a;     // Catch: Throwable -> L6
        if (r0.p == null) goto L9;
        r0.e();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
