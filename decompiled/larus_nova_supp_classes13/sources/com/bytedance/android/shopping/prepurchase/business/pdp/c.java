package com.bytedance.android.shopping.prepurchase.business.pdp;

import com.bytedance.android.shopping.anchorv4.params.AnchorV4Param;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.PdpRootComponent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements PdpRootComponent.a {
    public final AnchorV4Param a;

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.PdpRootComponent.a
    public final boolean a() {
        return false;
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.PdpRootComponent.a
    public final boolean b() {
        return false;
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.PdpRootComponent.a
    public final boolean c() {
        return false;
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.PdpRootComponent.a
    public final boolean d() {
        return true;
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.PdpRootComponent.a
    public final boolean e() {
        return true;
    }

    public c(AnchorV4Param r2) {
        Intrinsics.checkNotNullParameter(r2, "param");
        this.a = r2;
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.PdpRootComponent.a
    public final int f(int r4) {
        int r0 = this.a.getNativeParams().getPanelHeight();
        if (r0 > 0) goto L12;
        Integer r1 = this.a.getNativeParams().getPanelHeightPercent();
        if (r1 != null) goto L7;
    L11:
        r0 = 0;
        goto L12
    L7:
        if (r1.intValue() <= 0) goto L11;
        if (r4 <= 0) goto L11;
        r0 = (int) (r4 * (r1.intValue() / 100.0f));
    L12:
        if (r0 <= 0) goto L14;
        return r0;
    L14:
        return (int) (r4 * 0.73f);
    }
}
