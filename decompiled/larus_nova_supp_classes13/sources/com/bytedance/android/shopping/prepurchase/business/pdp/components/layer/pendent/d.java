package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent;

import com.bytedance.android.shopping.anchorv4.components.k0;
import com.bytedance.android.shopping.anchorv4.video.AnchorV4PlayerStateManager;
import com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.LifecycleOwnerDelegate;
import kotlin.jvm.internal.Intrinsics;
import vg3.f0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d implements com.bytedance.android.shopping.prepurchase.business.pdp.view.l {
    public final /* synthetic */ LivingIconComponent a;

    public final boolean a() {
        if (k0.a(this.a.g2()) == true) goto L8;
        AnchorV4PlayerStateManager.t.getClass();
        if (AnchorV4PlayerStateManager.b.c() == true) goto L8;
        return false;
    L8:
        return true;
    }

    public final com.bytedance.android.shopping.prepurchase.arch.container.intf.a b() {
        return this.a.O1().getContainerAbility().i7();
    }

    public final int c() {
        return ((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(this.a.O1())).b.b;
    }

    public final com.bytedance.android.shopping.anchorv4.video.f d() {
        vg3.a r0 = (vg3.a) this.a.N1(vg3.a.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.e();
    }

    public final boolean e() {
        vg3.l r0 = (vg3.l) this.a.N1(vg3.l.class);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.s();
    }

    public final boolean f() {
        return !Intrinsics.areEqual(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(this.a.O1())).b.d.a(), Boolean.FALSE);
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.view.l
    public final LifecycleOwnerDelegate getLifecycleOwner() {
        return com.bytedance.android.shopping.prepurchase.arch.container.state.f.a(this.a);
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.view.l
    public final boolean isFullScreen() {
        return this.a.g2().getNativeParams().getFullMode();
    }

    public d(LivingIconComponent r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.view.l
    public final void openSchema(String r3) {
        if (r3 == null) goto L7;
        f0 r0 = (f0) this.a.N1(f0.class);
        if (r0 == null) goto L8;
        r0.openSchema(r3);
        return;
    L8:
        return;
    }
}
