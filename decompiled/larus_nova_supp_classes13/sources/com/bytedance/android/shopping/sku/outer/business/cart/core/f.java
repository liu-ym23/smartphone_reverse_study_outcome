package com.bytedance.android.shopping.sku.outer.business.cart.core;

import com.bytedance.android.shopping.sku.common.monitor.chain.SkuYataAddCartChain;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ SkuOuterAddToCartHelper a;

    public f(SkuOuterAddToCartHelper r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        Throwable r6 = (Throwable) r5;
        String r0 = this.a.c.f();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == true) goto L12;
        int r2 = b.a;
        b.b(null, this.a.c.f(), false);
    L13:
        this.a.c(null);
        this.a.f.b(null, r6);
        mh3.a r3 = this.a.a;
        if (r3 != null) goto L16;
        return;
    L16:
        if (r3.e == null) goto L20;
        SkuYataAddCartChain.b(null, r6);
        return;
    L20:
        return;
    L12:
        int r4 = b.a;
        b.a(null, Integer.valueOf(this.a.c.e()), this.a.c.c(), this.a.c.d());
        goto L13
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L10
    }
}
