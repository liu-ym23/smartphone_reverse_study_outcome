package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product;

import com.bytedance.android.shopping.anchorv3.AnchorV3GridLayoutManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class w extends com.bytedance.android.shopping.prepurchase.arch.container.ability.b {
    public final /* synthetic */ ProductDetailInfoComponent c;
    public final /* synthetic */ vg3.e d;

    @Override // java.lang.Runnable
    public final void run() {
        d r0 = this.c.p;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mainFeedInitializer");
    L5:
        ((AnchorV3GridLayoutManager) r0.e.getValue()).setItemPrefetchEnabled(true);
        ProductDetailInfoComponent r1 = this.c;
        vg3.e r2 = this.d;
        r1.m2(r2);
        r2.V0(new ProductDetailInfoComponent$watchBottomBarHeightChange$1(r1, r2));
    }

    public w(ProductDetailInfoComponent r1, vg3.e r2) {
        this.c = r1;
        this.d = r2;
        super("updateRecyclerViewVisibleArea");
    }
}
