package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product;

import com.bytedance.android.shopping.anchorv3.widget.FixedRecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class r<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
    public final /* synthetic */ ProductDetailInfoComponent a;

    public r(ProductDetailInfoComponent r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
    public final void onChanged(Object r3) {
        Integer r4 = com.bytedance.android.ec.core.utils.s.b((String) r3);
        if (r4 == null) goto L5;
        int r5 = r4.intValue();
    L6:
        ProductDetailInfoComponent.h2(this.a).setBackgroundColor(r5);
        FixedRecyclerView r0 = this.a.o;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("topRecycleView");
    L9:
        r0.setBackgroundColor(r5);
        return;
    L5:
        r5 = -592135;
        goto L6
    }
}
