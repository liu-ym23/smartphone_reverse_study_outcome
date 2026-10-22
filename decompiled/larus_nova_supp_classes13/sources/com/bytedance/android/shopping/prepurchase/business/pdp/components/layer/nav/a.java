package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav;

import com.bytedance.android.shopping.anchorv4.bottom.AddCartMeta;
import hl.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements f {
    public final /* synthetic */ BottomNavigationComponentV2 a;

    public a(BottomNavigationComponentV2 r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.f
    public final void a(String r8, int r9, i r10, float[] r11) {
        Intrinsics.checkNotNullParameter(r8, "coverImage");
        AddCartMeta r0 = BottomNavigationComponentV2.i2(this.a).i();
        if (r0 != null) goto L5;
    L7:
        BottomNavigationComponentV2.h2(this.a, r8, r9, r10, false, r11);
        return;
    L5:
        if (r0.getAddCartAnimationV2() != true) goto L7;
        BottomNavigationComponentV2.h2(this.a, r8, r9, r10, true, r11);
    }
}
