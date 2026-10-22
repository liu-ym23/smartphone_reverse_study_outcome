package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

import com.bytedance.android.shopping.anchorv4.nav.controls.TopRightControlsVO;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class v<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
    public final /* synthetic */ TopNavigationComponentV1 a;

    public v(TopNavigationComponentV1 r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
    public final void onChanged(Object r3) {
        TopRightControlsVO r4 = (TopRightControlsVO) r3;
        if (r4 == null) goto L7;
        TopNavigationComponentV1 r0 = this.a;
        TopNavigationComponentV1.h2(r0, r4, r0.p.a());
        return;
    }
}
