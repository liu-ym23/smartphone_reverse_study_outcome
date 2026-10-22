package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class l<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
    public final /* synthetic */ d a;

    public l(d r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
    public final void onChanged(Object r3) {
        boolean r4 = ((Boolean) r3).booleanValue();
        ProductDetailInfoAdapter r0 = this.a.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L5:
        r0.F2(r4);
        BaseInfoServiceSnapshotTransitionController r1 = this.a.b;
        if (r1 == null) goto L9;
        r1.h(r4);
        return;
    }
}
