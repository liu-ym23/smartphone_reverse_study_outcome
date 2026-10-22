package com.bytedance.android.shopping.new_cart.eventcenter.event;

import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class q implements Runnable {
    public final /* synthetic */ AndroidYaTaInstance a;
    public final /* synthetic */ SelfOpenHalfHybridView$onExecuteAsync$2.a b;

    public q(AndroidYaTaInstance r1, SelfOpenHalfHybridView$onExecuteAsync$2.a r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.k().d(com.bytedance.kmp.ec.yata.event.common.e.a.a(this.a, null, this.b.a.$input.k(), "DidDismiss", null, "SelfOpenHalfHybridView"));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
