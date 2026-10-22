package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class v extends com.bytedance.android.shopping.prepurchase.arch.container.ability.b {
    public final /* synthetic */ ProductDetailInfoComponent c;

    @Override // java.lang.Runnable
    public final void run() {
        Function0<Unit> r0 = this.c.v;
        if (r0 == null) goto L6;
        Unit r1 = (Unit) r0.invoke();
        return;
    }

    public v(ProductDetailInfoComponent r1) {
        this.c = r1;
        super("updateRecyclerViewVisibleArea");
    }
}
