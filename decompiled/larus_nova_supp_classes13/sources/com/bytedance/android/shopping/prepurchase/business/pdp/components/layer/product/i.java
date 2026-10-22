package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i implements com.bytedance.android.shopping.anchorv3.g {
    public final /* synthetic */ d a;

    public final void t() {
    }

    public final void s() {
        Boolean r0 = Boolean.valueOf(this.a.k.r());
        if (r0.booleanValue() == true) goto L6;
        r0 = null;
    L6:
        if (r0 == null) goto L9;
        r0.booleanValue();
        com.bytedance.android.shopping.prepurchase.arch.container.ability.m.a.a(this.a.m.a().m(), "product_detail_refresh", false, null, null, 12);
        return;
    }

    public i(d r1) {
        this.a = r1;
    }
}
