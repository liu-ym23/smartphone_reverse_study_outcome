package com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ecom.arch.slice.SlcContext;
import com.bytedance.android.ecom.arch.slice.slices.SlcBaseViewHolder;
import com.bytedance.android.ecom.arch.slice.slices.group.SlcGroupViewHolder;
import com.bytedance.android.shopping.anchorv3.detail.StaggeredGridDoubleColumnDecoration;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.z;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j implements e {
    public com.bytedance.android.ecom.arch.slice.adapter.e a;
    public final SlcContext b;
    public final com.bytedance.android.ecom.arch.slice.f c;
    public final com.bytedance.android.shopping.anchorv4.voavhs.lynx.d d;
    public final Integer e;

    public final com.bytedance.android.ecom.arch.slice.adapter.e e() {
        if (this.a == null) goto L5;
    L9:
        com.bytedance.android.ecom.arch.slice.adapter.e r0 = this.a;
        Intrinsics.checkNotNull(r0);
        return r0;
    L5:
        if (this.e == null) goto L7;
        com.bytedance.android.ecom.arch.slice.adapter.e r1 = new com.bytedance.android.ecom.arch.slice.adapter.e(this.e.intValue());
    L8:
        this.a = r1;
        goto L9
    L7:
        r1 = this.b.s0;
        goto L8
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.e
    public final Integer b(com.bytedance.android.ecom.arch.slice.adapter.b r2) {
        if ((r2 instanceof com.bytedance.android.ecom.arch.slice.g) == false) goto L8;
        com.bytedance.android.ecom.arch.slice.g r3 = (com.bytedance.android.ecom.arch.slice.g) r2;
        if (com.bytedance.android.shopping.extensions.k.c(r3.getViewType()) == true) goto L7;
        return null;
    L7:
        return Integer.valueOf(e().c(r3));
    L8:
        return null;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.e
    public final void c(RecyclerView.ViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        e().d(r2);
    }

    public final void f(com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.f r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        com.bytedance.android.ecom.arch.slice.adapter.e r1 = e();
        i r2 = new i(r4);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "listener");
        com.bytedance.android.ecom.arch.slice.adapter.f r5 = r1.c;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r2, "listener");
        r5.a.add(r2);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.e
    public final SlcBaseViewHolder a(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        SlcGroupViewHolder r5 = e().b(this.b, r4, this.c);
        if ((r5 instanceof SlcGroupViewHolder) == false) goto L5;
        r5.g.setItemAnimator(null);
    L5:
        return r5;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.e
    public final boolean d(RecyclerView.ViewHolder r8, com.bytedance.android.ecom.arch.slice.adapter.b r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "holder");
        Object r1 = null;
        if ((r9 instanceof com.bytedance.android.ecom.arch.slice.adapter.b) == true) goto L5;
        com.bytedance.android.ecom.arch.slice.adapter.b r0 = null;
    L7:
        if (r0 != null) goto L10;
        return false;
    L10:
        if ((r9 instanceof com.bytedance.android.ecom.arch.slice.g) == true) goto L12;
        com.bytedance.android.ecom.arch.slice.adapter.b r3 = null;
    L13:
        com.bytedance.android.ecom.arch.slice.g r4 = (com.bytedance.android.ecom.arch.slice.g) r3;
        if (r4 == null) goto L16;
        Object r5 = r4.getConfig("show_water_fall");
    L18:
        if ((r5 instanceof String) == true) goto L20;
        r5 = null;
    L20:
        boolean r6 = !com.bytedance.android.shopping.extensions.k.c((String) r5);
        com.bytedance.android.ecom.arch.slice.adapter.e r7 = e();
        int r11 = com.bytedance.android.ecom.arch.slice.adapter.e.e;
        if (r7.a(r8, r0, r10, true) == true) goto L23;
        return false;
    L23:
        if ((r8 instanceof SlcBaseViewHolder) == false) goto L38;
        if (r6 == true) goto L26;
        StaggeredGridDoubleColumnDecoration.a r12 = StaggeredGridDoubleColumnDecoration.g;
        View r2 = r8.itemView;
        r12.getClass();
        StaggeredGridDoubleColumnDecoration.a.b(r2, true);
    L26:
        Object r13 = r8.itemView.getTag(2131382095);
        if ((r13 instanceof com.bytedance.android.shopping.slice.a) == false) goto L31;
        r1 = r13;
    L31:
        if (((com.bytedance.android.shopping.slice.a) r1) != null) goto L33;
        com.bytedance.android.shopping.slice.a r14 = new com.bytedance.android.shopping.slice.a((SlcBaseViewHolder) r8);
        this.d.b(r14, r9);
        r8.itemView.setTag(2131382095, r14);
    L33:
        SlcBaseViewHolder r15 = (SlcBaseViewHolder) r8;
        if (ECAppInfoService.e.i() == false) goto L38;
        cl.d r16 = com.bytedance.android.ec.sdk.helper.k.a();
        if (r16 == null) goto L38;
        r16.q();
    L38:
        return true;
    L16:
        r5 = null;
        goto L18
    L12:
        r3 = r9;
        goto L13
    L5:
        r0 = r9;
        goto L7
    }

    public j(SlcContext r2, z r3, ug3.c r4, Integer r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "recyclerViewDelegate");
        Intrinsics.checkNotNullParameter(r4, "exposureService");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
