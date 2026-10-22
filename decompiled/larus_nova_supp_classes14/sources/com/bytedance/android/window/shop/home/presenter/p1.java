package com.bytedance.android.window.shop.home.presenter;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class p1 implements Runnable {
    public final /* synthetic */ q1 a;

    public p1(q1 r1) {
        this.a = r1;
    }

    public final void a() {
        uq3.a r0 = (uq3.a) this.a.a.O().getHeaderResponse().getValue();
        if (r0 == null) goto L8;
        uq3.o r1 = r0.c;
        if (r1 == null) goto L8;
        if (r1.a() != true) goto L8;
    L9:
        yn.d r2 = this.a.a.O().getLiveManager();
        int r3 = yn.d.q;
        r2.b(false);
        return;
    L8:
        yn.d r4 = this.a.a.O().getLiveManager();
        int r5 = yn.d.q;
        r4.h(true);
        goto L9
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
