package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

import kotlin.jvm.internal.Intrinsics;
import vg3.d0;
import vg3.n0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class w<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
    public final /* synthetic */ TopNavigationComponentV1 a;

    public w(TopNavigationComponentV1 r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
    public final void onChanged(Object r3) {
        n0 r4 = (n0) r3;
        Intrinsics.checkNotNullParameter(r4, "it");
        if (r4.c == false) goto L8;
        d0 r0 = (d0) this.a.N1(d0.class);
        if (r0 == null) goto L9;
        r0.scrollTo(r4.b);
        return;
    L9:
        return;
    }
}
