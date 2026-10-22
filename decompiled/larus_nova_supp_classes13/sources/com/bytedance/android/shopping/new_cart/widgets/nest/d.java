package com.bytedance.android.shopping.new_cart.widgets.nest;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d implements Runnable {
    public final /* synthetic */ CartLinkedScrollViewV2 a;

    public d(CartLinkedScrollViewV2 r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CartLinkedScrollViewV2.p(this.a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
