package com.bytedance.android.shopping.new_cart.widgets.nest;

import com.bytedance.android.shopping.new_cart.components.CartBackToTopBtnManageComponent;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e implements Runnable {
    public final /* synthetic */ CartLinkedScrollViewV2 a;

    public e(CartLinkedScrollViewV2 r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L14:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L22;
        throw th;
    L22:
        return;
    L3:
        if (this.a.canScrollVertically(-1) == false) goto L5;
    L10:
        CartBackToTopBtnManageComponent r0 = CartLinkedScrollViewV2.l(this.a);     // Catch: Throwable -> L14
        if (r0 == null) goto L19;
        r0.n(true);     // Catch: Throwable -> L14
    L19:
        return;
    L5:
        if (this.a.p.canScrollVertically(-1) == true) goto L10;
        CartBackToTopBtnManageComponent r1 = CartLinkedScrollViewV2.l(this.a);     // Catch: Throwable -> L14
        if (r1 == null) goto L19;
        r1.n(false);     // Catch: Throwable -> L14
        goto L19
    }
}
