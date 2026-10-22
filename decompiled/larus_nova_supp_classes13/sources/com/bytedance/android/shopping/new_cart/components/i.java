package com.bytedance.android.shopping.new_cart.components;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i implements Runnable {
    public final /* synthetic */ CartPageCallBackComponent a;

    public i(CartPageCallBackComponent r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [android.widget.FrameLayout, com.bytedance.android.shopping.new_cart.widgets.nest.CartLinkedScrollViewV2] */
    @Override // java.lang.Runnable
    public final void run() {
        CartBodyComponent r0 = this.a.p();     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        ?? r1 = r0.p();     // Catch: Throwable -> L6
        r1.post(new com.bytedance.android.shopping.new_cart.widgets.nest.e(r1));     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
