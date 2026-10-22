package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class u<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
    public final /* synthetic */ ProductDetailInfoComponent a;

    public u(ProductDetailInfoComponent r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
    public final void onChanged(Object r2) {
        if (((Number) r2).floatValue() <= 0) goto L8;
        Function0<Unit> r3 = this.a.v;
        if (r3 == null) goto L9;
        Unit r4 = (Unit) r3.invoke();
        return;
    L9:
        return;
    }
}
