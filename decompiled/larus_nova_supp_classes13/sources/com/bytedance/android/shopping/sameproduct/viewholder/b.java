package com.bytedance.android.shopping.sameproduct.viewholder;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b extends com.bytedance.android.ec.core.widget.d {
    public final /* synthetic */ MainProductCardVH g;

    public b(MainProductCardVH r3) {
        this.g = r3;
        super(null, "bind_product_flow_card", 1);
    }

    public final void a(View r4) {
        Intrinsics.checkNotNullParameter(r4, "v");
        MainProductCardVH r0 = this.g;
        r0.n.invoke(r0.r, Integer.valueOf(r0.getAdapterPosition()), r4);
    }
}
