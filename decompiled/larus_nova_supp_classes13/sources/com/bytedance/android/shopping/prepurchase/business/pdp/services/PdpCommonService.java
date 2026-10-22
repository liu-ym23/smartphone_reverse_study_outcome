package com.bytedance.android.shopping.prepurchase.business.pdp.services;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.shopping.anchorv4.video.AnchorV4PlayerStateManager;
import com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.b0;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import vg3.f0;
import vg3.h0;
import vg3.u;
import vg3.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class PdpCommonService extends b0 {
    public static final /* synthetic */ int l = 0;
    public final Lazy i;
    public Integer j;
    public final a k;

    public static final class a implements h0 {
        public final /* synthetic */ PdpCommonService a;

        public a(PdpCommonService r1) {
            this.a = r1;
        }

        @Override // vg3.h0
        public final void A0(int r2) {
            PdpCommonService r0 = this.a;
            r0.j = Integer.valueOf(r2);
        }
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final List<Class<?>> M1() {
        return CollectionsKt.listOf(new Class[]{x.class, u.class});
    }

    public final AVCoordinationServiceImpl b2() {
        return (AVCoordinationServiceImpl) this.i.getValue();
    }

    public PdpCommonService() {
        this.i = LazyKt.lazy(new PdpCommonService$avCoordinationService$2(this));
        this.k = new a(this);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void S1() {
        super.S1();
        b2().p().s();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void T1() {
        super.T1();
        AbsComponent.Y1(this, f0.class, new e(O1()), false, 12);
        AbsComponent.Y1(this, vg3.a.class, b2(), false, 12);
        O1().e().r().J1(h0.class, this.k);
        AnchorV4PlayerStateManager r0 = b2().p();
        AnchorV4PlayerStateManager.b r1 = AnchorV4PlayerStateManager.t;
        boolean r2 = r0.p.a();
        r1.getClass();
        AnchorV4PlayerStateManager.b.b();
        r0.d = Boolean.valueOf(r2);
        FragmentActivity r3 = O1().getContainerAbility().mo2525getContext();
        r1.getClass();
        AnchorV4PlayerStateManager.b.a(r3);
        b2().p().p();
        Z1(u.class, new PdpCommonService$onAttach$1(this, null));
        Z1(x.class, new PdpCommonService$onAttach$2(this, null));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void U1() {
        super.U1();
        b2().p().q();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void V1() {
        super.V1();
        b2().p().r();
    }
}
