package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j implements com.bytedance.android.ecom.arch.slice.slices.b<List<? extends com.bytedance.android.ecom.arch.slice.g>> {
    public final /* synthetic */ d a;

    public final Object provide() {
        ProductDetailInfoAdapter r0 = this.a.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L6:
        return r0.E2();
    }

    public j(d r1) {
        this.a = r1;
    }
}
