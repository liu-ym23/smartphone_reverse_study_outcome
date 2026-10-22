package com.bytedance.android.shopping.anchorv4.voavhs.head.holder;

import android.content.Context;
import android.view.View;
import com.bytedance.android.shopping.anchorv4.dto.elements.KolReviewElement;
import com.bytedance.android.shopping.anchorv4.voavhs.base.components.KolGridComponentView;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k extends com.bytedance.android.shopping.anchorv4.voavhs.head.base.b<l> {
    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.j
    public final com.bytedance.android.shopping.anchorv4.voavhs.head.base.m g(com.bytedance.android.shopping.anchorv4.voavhs.head.c r4) {
        Intrinsics.checkNotNullParameter(r4, "nodeVO");
        return new l(r4.u, this.g, r4.A);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.b
    public final View w(com.bytedance.android.shopping.anchorv4.voavhs.head.base.m r6) {
        l r7 = (l) r6;
        List<KolReviewElement> r4 = null;
        final KolGridComponentView r0 = new KolGridComponentView(getContext(), null, 6, 0);
        if (r7 == null) goto L5;
        r4 = r7.c;
    L5:
        r0.a(r4, new PioneerHolderBuilder$layerView$1$1(r0));
        return r0;
    }

    public k(Context r2, com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }
}
