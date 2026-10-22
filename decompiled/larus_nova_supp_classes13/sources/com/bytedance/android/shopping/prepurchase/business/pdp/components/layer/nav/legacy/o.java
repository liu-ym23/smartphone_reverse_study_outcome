package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

import com.bytedance.android.shopping.anchorv4.nav.AnchorV4NavArea;
import com.bytedance.android.shopping.anchorv4.nav.AnchorV4TabArea;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class o<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
    public final /* synthetic */ TopNavigationComponentV1 a;

    public o(TopNavigationComponentV1 r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
    public final void onChanged(Object r2) {
        boolean r3 = ((Boolean) r2).booleanValue();
        AnchorV4NavArea r0 = this.a.i2();
        if (r0 == null) goto L5;
        r0.o = r3;
    L5:
        AnchorV4TabArea r1 = this.a.k2();
        if (r1 == null) goto L9;
        r1.h = r3;
        return;
    }
}
