package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

import com.bytedance.android.shopping.anchorv4.nav.controls.TopRightControlsVO;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class s<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
    public final /* synthetic */ TopNavigationComponentV1 a;

    public s(TopNavigationComponentV1 r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
    public final void onChanged(Object r3) {
        List r4 = (List) r3;
        TopRightControlsVO r0 = (TopRightControlsVO) ((com.bytedance.android.shopping.prepurchase.arch.container.state.e) this.a.O1().d().getData().h.getValue()).a();
        if (r0 == null) goto L7;
        TopNavigationComponentV1.h2(this.a, r0, r4);
        return;
    }
}
