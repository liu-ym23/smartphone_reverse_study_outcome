package com.bytedance.android.shopping.new_cart.container;

import com.bytedance.android.shopping.new_cart.components.CartPageCallBackComponent;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class q implements Runnable {
    public final /* synthetic */ CartFragment a;

    public q(CartFragment r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CartFragment.S90(this.a).e.l.c = false;     // Catch: Throwable -> L6
        CartPageCallBackComponent r0 = this.a.U90();     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.v(false);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
