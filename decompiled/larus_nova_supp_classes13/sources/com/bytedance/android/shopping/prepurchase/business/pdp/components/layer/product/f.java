package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ecom.arch.slice.slices.SlcBaseViewHolder;
import com.bytedance.android.shopping.prepurchase.arch.exposure.ExposureEngine;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f implements com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.h {
    public final /* synthetic */ d a;

    public f(d r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.h
    public final void a(RecyclerView.ViewHolder r3, com.bytedance.android.ecom.arch.slice.adapter.b r4) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        if ((r4 instanceof com.bytedance.android.ecom.arch.slice.g) == true) goto L5;
        return;
    L5:
        if ((r3 instanceof SlcBaseViewHolder) == false) goto L21;
        d r0 = this.a;
        SlcBaseViewHolder r5 = (SlcBaseViewHolder) r3;
        r0.getClass();
        String r6 = ((com.bytedance.android.ecom.arch.slice.g) r4).getSliceId();
        if (r6 != null) goto L10;
        r6 = "";
    L10:
        if (r6.length() != 0) goto L12;
        boolean r1 = true;
    L13:
        if (r1 == true) goto L22;
        vg3.m r2 = (vg3.m) r0.o.getService(vg3.m.class);
        if (r2 == null) goto L23;
        ExposureEngine r7 = r2.x0();
        if (r7 == null) goto L24;
        ExposureEngine.a(r7, ((RecyclerView.ViewHolder) r5).itemView, r6);
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L12:
        r1 = false;
        goto L13
    }
}
