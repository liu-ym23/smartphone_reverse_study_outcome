package com.bytedance.android.shopping.sameproduct.viewholder;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d extends com.bytedance.android.ec.core.widget.d {
    public final /* synthetic */ SingleSimilarProductCardVH g;
    public final /* synthetic */ rd3.a h;

    public final void a(View r4) {
        Intrinsics.checkNotNullParameter(r4, "v");
        SingleSimilarProductCardVH r0 = this.g;
        r0.n.invoke(this.h, Integer.valueOf(r0.getAdapterPosition() - 1), r4);
    }

    public d(SingleSimilarProductCardVH r2, rd3.a r3) {
        this.g = r2;
        this.h = r3;
        super(null, "bind_product_flow_card", 1);
    }
}
