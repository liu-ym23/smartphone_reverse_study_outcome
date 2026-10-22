package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class r<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
    public final /* synthetic */ TopNavigationComponentV1 a;

    public r(TopNavigationComponentV1 r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
    public final void onChanged(Object r2) {
        com.bytedance.android.shopping.prepurchase.arch.container.intf.k r3 = (com.bytedance.android.shopping.prepurchase.arch.container.intf.k) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        if ((r3 instanceof com.bytedance.android.shopping.prepurchase.arch.container.intf.k.d) == false) goto L6;
        this.a.j2().L();
    L6:
        if ((r3 instanceof com.bytedance.android.shopping.prepurchase.arch.container.intf.k.a) == false) goto L9;
        this.a.j2().M(0);
        return;
    }
}
