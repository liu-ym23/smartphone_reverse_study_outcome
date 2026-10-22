package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
    public final /* synthetic */ d a;
    public final /* synthetic */ z b;
    public final /* synthetic */ ug3.c c;

    public g(d r1, z r2, ug3.c r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
    public final void onChanged(Object r4) {
        Intrinsics.checkNotNullParameter((Map) r4, "it");
        vg3.o r5 = (vg3.o) this.a.o.getService(vg3.o.class);
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.isEnable() != true) goto L15;
        d r6 = this.a;
        r6.f += 1000;
        com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.j r7 = r6.m.e().r().h0(this.b, this.c, Integer.valueOf(this.a.f));
        ProductDetailInfoAdapter r0 = this.a.a;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L9:
        r0.getClass();
        Intrinsics.checkNotNullParameter(r7, "adapter");
        r0.L = r7;
        ProductDetailInfoAdapter r8 = this.a.a;
        if (r8 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L12:
        r8.notifyDataSetChanged();
        return;
    }
}
