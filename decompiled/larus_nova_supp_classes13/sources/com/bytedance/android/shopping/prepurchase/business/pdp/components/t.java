package com.bytedance.android.shopping.prepurchase.business.pdp.components;

import vg3.k0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class t implements com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.b {
    public final /* synthetic */ PdpRootComponent a;

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.b
    public final boolean onBackPressed() {
        PdpRootComponent r0 = this.a;
        r0.getClass();
        vg3.g r1 = (vg3.g) r0.N1(vg3.g.class);
        if (r1 != null) goto L5;
        boolean r2 = false;
    L7:
        if (r2 == false) goto L9;
        return true;
    L9:
        this.a.v0(new k0(true, true, 2));
        return true;
    L5:
        r2 = r1.W0();
        goto L7
    }

    public t(PdpRootComponent r1) {
        this.a = r1;
    }
}
