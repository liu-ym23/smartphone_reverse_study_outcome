package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

import com.bytedance.android.shopping.anchorv4.nav.AnchorV4NavArea;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class t<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
    public final /* synthetic */ TopNavigationComponentV1 a;

    public t(TopNavigationComponentV1 r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
    public final void onChanged(Object r2) {
        com.bytedance.android.shopping.anchorv3.i r3 = (com.bytedance.android.shopping.anchorv3.i) r2;
        if (r3 == null) goto L10;
        AnchorV4NavArea r0 = this.a.i2();
        if (r0 == null) goto L9;
        r0.h(r3);
        return;
    L9:
        return;
    }
}
