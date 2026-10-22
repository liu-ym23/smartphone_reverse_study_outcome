package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.live;

import com.bytedance.android.shopping.anchorv4.components.l0;
import com.bytedance.android.shopping.anchorv4.params.AnchorV4Param;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.b0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends b0 {
    public final l0 i;
    public boolean j;

    public a() {
        this.i = new l0();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void S1() {
        super.S1();
        this.j = true;
        this.i.d(null);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void T1() {
        super.T1();
        this.i.h(true, this.j);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void U1() {
        super.U1();
        l0 r0 = this.i;
        AnchorV4Param r1 = a2();
        r0.getClass();
        l0.a(null, r1);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void V1() {
        super.V1();
        this.j = false;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void X1() {
        super.X1();
        this.i.f(null, O1().getContainerAbility().mo2525getContext());
    }
}
