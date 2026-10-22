package com.bytedance.ee.bear.drive.core.thumbnail;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements Runnable {
    public final /* synthetic */ b a;
    public final /* synthetic */ int b;

    public d(b r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b r0 = this.a;     // Catch: Throwable -> L4
        r0.i = null;     // Catch: Throwable -> L4
        r0.a(this.b, false);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
