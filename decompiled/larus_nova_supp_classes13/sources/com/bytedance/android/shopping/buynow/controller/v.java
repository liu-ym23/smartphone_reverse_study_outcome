package com.bytedance.android.shopping.buynow.controller;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class v implements Runnable {
    public final /* synthetic */ w a;

    public v(w r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        w r0 = this.a;     // Catch: Throwable -> L4
        r0.a = false;     // Catch: Throwable -> L4
        w.a(r0, false);     // Catch: Throwable -> L4
        this.a.f.setPadding(0, 0, 0, 0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
