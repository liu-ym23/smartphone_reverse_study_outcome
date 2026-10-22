package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product;

import com.bytedance.android.shopping.anchorv4.dto.Control;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class q extends com.bytedance.android.shopping.prepurchase.arch.container.ability.b {
    public final /* synthetic */ ProductDetailInfoComponent c;

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.android.shopping.prepurchase.arch.container.state.e r0 = (com.bytedance.android.shopping.prepurchase.arch.container.state.e) this.c.O1().d().getData().F.getValue();
        com.bytedance.android.shopping.prepurchase.arch.container.component.b.a(this.c, "controlObservable " + ((Control) r0.getValue()) + ", " + ((Control) r0.a()));
        Control r1 = (Control) r0.a();
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.getGulControl() != true) goto L9;
        this.c.l2();
        return;
    }

    public q(ProductDetailInfoComponent r1) {
        this.c = r1;
        super("lazy_load_gul");
    }
}
