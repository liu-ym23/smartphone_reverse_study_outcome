package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

import com.bytedance.android.shopping.anchorv4.nav.AnchorV4NavArea;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class p<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
    public final /* synthetic */ TopNavigationComponentV1 a;

    public p(TopNavigationComponentV1 r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
    public final void onChanged(Object r2) {
        float r3 = ((Number) r2).floatValue();
        AnchorV4NavArea r0 = this.a.i2();
        if (r0 == null) goto L6;
        r0.f(r3);
        return;
    }
}
