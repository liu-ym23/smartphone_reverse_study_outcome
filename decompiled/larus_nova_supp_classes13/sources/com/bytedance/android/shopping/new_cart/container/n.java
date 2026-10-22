package com.bytedance.android.shopping.new_cart.container;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class n implements Runnable {
    public final /* synthetic */ CartFragment a;

    public n(CartFragment r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CartFragment.S90(this.a).e.l.b = false;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
