package com.bytedance.android.shopping.anchorv4.voavhs.head.holder;

import android.content.Context;
import android.view.View;
import com.bytedance.android.shopping.anchorv4.voavhs.head.view.AnchorV4FeaturedShowView;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c extends com.bytedance.android.shopping.anchorv4.voavhs.head.base.b<d> {
    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.j
    public final com.bytedance.android.shopping.anchorv4.voavhs.head.base.m g(com.bytedance.android.shopping.anchorv4.voavhs.head.c r3) {
        Intrinsics.checkNotNullParameter(r3, "nodeVO");
        return new d(r3.k, r3.u);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.b
    public final View w(com.bytedance.android.shopping.anchorv4.voavhs.head.base.m r6) {
        AnchorV4FeaturedShowView r0 = new AnchorV4FeaturedShowView(getContext(), null, 6, 0);
        r0.a((d) r6, this.g, false);
        return r0;
    }

    public c(Context r2, com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.b
    public final List v(com.bytedance.android.shopping.anchorv4.voavhs.head.base.m r13, Function0 r14) {
        d r15 = (d) r13;
        Intrinsics.checkNotNullParameter(r14, "rootView");
        AnchorV4FeaturedShowView r2 = new AnchorV4FeaturedShowView(getContext(), null, 6, 0);
        r2.a(r15, this.g, true);
        if (r15 == null) goto L5;
        String r7 = r15.b;
    L7:
        return CollectionsKt.listOf(new com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f(r2, null, null, null, null, r7, false, null, null, 1982));
    L5:
        r7 = null;
        goto L7
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.b
    public final void z(Context r1, View r2, com.bytedance.android.shopping.anchorv4.voavhs.head.base.m r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "rootView");
        Intrinsics.checkNotNullParameter((d) r3, "headNodeVO");
    }
}
