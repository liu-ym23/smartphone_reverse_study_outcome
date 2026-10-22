package com.bytedance.android.shopping.store.hybridproduct.presenter;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f0 implements sm.n {
    public final /* synthetic */ ShopSlicedProductCardPresenter a;

    public f0(ShopSlicedProductCardPresenter r1) {
        this.a = r1;
    }

    public final void a(Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r3, "dataCtx");
        ShopSlicedProductCardPresenter r0 = this.a;
        com.bytedance.android.ecom.arch.slice.render.r r1 = r0.p;
        if (r1 == null) goto L6;
        r1.a(r3, r0.m);
        return;
    }
}
