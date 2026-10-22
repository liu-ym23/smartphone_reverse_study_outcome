package com.bytedance.android.shopping.buynow.controller;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements Runnable {
    public final /* synthetic */ BuyNowElevatorGuideController a;
    public final /* synthetic */ com.bytedance.kmp.ec.yata.store.node.c b;

    public c(BuyNowElevatorGuideController r1, com.bytedance.kmp.ec.yata.store.node.c r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BuyNowElevatorGuideController r0 = this.a;     // Catch: Throwable -> L6
        if (r0.a == false) goto L9;
        r0.b.setVisibility(8);     // Catch: Throwable -> L6
        this.a.c(this.b, "hide_elevator_event_name", "onAutoDisappear");     // Catch: Throwable -> L6
        this.a.a = false;     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
