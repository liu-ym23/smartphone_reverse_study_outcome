package com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i implements com.bytedance.android.ecom.arch.slice.adapter.c {
    public final /* synthetic */ h a;

    public final void onViewRecycled(RecyclerView.ViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
    }

    public i(com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.f r1) {
        this.a = r1;
    }

    public final void a(RecyclerView.ViewHolder r1, com.bytedance.android.ecom.arch.slice.adapter.b r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "holder");
        this.a.a(r1, r2);
    }
}
