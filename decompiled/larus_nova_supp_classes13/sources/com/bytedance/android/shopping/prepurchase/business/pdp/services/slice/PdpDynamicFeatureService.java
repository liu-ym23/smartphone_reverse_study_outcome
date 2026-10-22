package com.bytedance.android.shopping.prepurchase.business.pdp.services.slice;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.core.utils.UIUtils;
import com.bytedance.android.shopping.anchorv3.utils.a0;
import com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl;
import com.bytedance.android.shopping.anchorv4.event_chain.custom_event.v2.PdpEventRegistry;
import com.bytedance.android.shopping.anchorv4.params.AnchorV4Param;
import com.bytedance.android.shopping.anchorv4.params.V4NativeParams;
import com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent;
import com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.DynamicFeatureComponent;
import com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.LynxAbilityImpl;
import com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.o;
import com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataStore;
import com.bytedance.kmp.ec.yata.chain.core.EventChain;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONObject;
import vg3.f0;
import vg3.v;
import vg3.w;
import vg3.x;
import vg3.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class PdpDynamicFeatureService extends DynamicFeatureComponent<com.bytedance.android.shopping.prepurchase.business.pdp.e, PdpDataStore> implements v {
    public static final /* synthetic */ int v = 0;
    public boolean m;
    public List<? extends com.bytedance.android.ecom.arch.slice.adapter.b> n;
    public c o;
    public Boolean p;
    public boolean q;
    public Runnable r;
    public String s;
    public final Lazy t;
    public final Lazy u;

    public static final class a implements com.bytedance.android.shopping.anchorv4.voavhs.e {
        public final /* synthetic */ PdpDynamicFeatureService a;

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.e
        public final String getSessionId() {
            return this.a.O1().f().a.b;
        }

        public a(PdpDynamicFeatureService r1) {
            this.a = r1;
        }
    }

    public static final class b implements com.bytedance.android.shopping.anchorv4.event_chain.custom_event.v2.g {
        public final /* synthetic */ PdpDynamicFeatureService a;

        public b(PdpDynamicFeatureService r1) {
            this.a = r1;
        }

        public final void a(AbsCommonChainEventImpl r3) {
            Intrinsics.checkNotNullParameter(r3, "eventImpl");
            o r1 = this.a.b2();
            r1.getClass();
            Intrinsics.checkNotNullParameter(r3, "eventImpl");
            EventChain r0 = r1.e;
            if (r0 == null) goto L6;
            r0.g(r3);
            return;
        }
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final List<Class<?>> M1() {
        return CollectionsKt.listOf(new Class[]{y.class, f0.class, w.class, vg3.o.class});
    }

    @Override // vg3.v
    public final d C() {
        return new d(this);
    }

    @Override // vg3.v
    public final t96.a t0() {
        Intrinsics.checkNotNullParameter("PDPPopoverMask", "eventName");
        o r2 = b2();
        r2.getClass();
        Intrinsics.checkNotNullParameter("PDPPopoverMask", "eventName");
        EventChain r1 = r2.e;
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.c("PDPPopoverMask");
    }

    public PdpDynamicFeatureService() {
        this.m = true;
        this.t = LazyKt.lazy(new PdpDynamicFeatureService$lynxCardPreloadHelper$2(this));
        this.u = LazyKt.lazy(new PdpDynamicFeatureService$indexActionHelper$2(this));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.DynamicFeatureComponent, com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void T1() {
        super.T1();
        Z1(x.class, new PdpDynamicFeatureService$listenAndResetServerTime$1(this, null));
        Z1(x.class, new PdpDynamicFeatureService$initActionStorage$1(this, null));
        if (((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).a.getNativeParams().getFullMode() == true) goto L5;
        ((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).b.d.b(this, com.bytedance.android.shopping.prepurchase.arch.container.state.j.a(), new e(this));
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).b.d, this, new f(this));
    L5:
        b2().M0(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("is_in_split", Boolean.valueOf(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).b.a))}));
        b2().J1("pdp_service_for_slice", new a(this));
        AbsComponent.Y1(this, v.class, this, false, 12);
        Z1(y.class, new PdpDynamicFeatureService$registerPdpShowEvent$1(this, null));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.DynamicFeatureComponent, com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void U1() {
        LynxAbilityImpl r0 = a2();
        JSONObject r1 = new JSONObject();
        AnchorV4Param r2 = ((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).a;
        if (r2 == null) goto L7;
        V4NativeParams r3 = r2.getNativeParams();
        if (r3 == null) goto L7;
        String r4 = r3.getPdpEventTransparentId();
    L8:
        r1.put("pdp_event_transparent_id", String.valueOf(r4));
        Unit r5 = Unit.INSTANCE;
        r0.B("ecom.pdp.close", r1);
        Runnable r6 = this.r;
        if (r6 == null) goto L11;
        Lazy r7 = UIUtils.a;
        UIUtils.c().removeCallbacks(r6);
    L11:
        super.U1();
        return;
    L7:
        r4 = null;
        goto L8
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void X1() {
        super.X1();
        a0 r0 = a0.a;
        BuildersKt.launch$default(Q1(), null, null, new PdpDynamicFeatureService$onStop$1(this, null), 3, null);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void S1() {
        super.S1();
    }

    @Override // vg3.v
    public final void J0(boolean r2) {
        if (this.q != r2) goto L5;
        return;
    L5:
        this.q = r2;
        this.p = null;
    }

    @Override // vg3.v
    public final boolean Y0(boolean r7) {
        boolean r2 = false;
        if (Intrinsics.areEqual(this.p, Boolean.valueOf(r7)) == false) goto L6;
        dm.a.a("PdpSnapshotTransition").b("screen mode update expanded=" + r7 + " dispatched=false reason=duplicate", null);
        return false;
    L6:
        c r0 = this.o;
        if (r0 != null) goto L10;
        dm.a.a("PdpSnapshotTransition").b("screen mode update expanded=" + r7 + " dispatched=false reason=action_not_ready", null);
        return false;
    L10:
        if (r7 == false) goto L15;
        e73.a r5 = r0.a;
        if (r5 == null) goto L19;
        r2 = r0.b(r5.e());
    L19:
        if (r2 == false) goto L21;
        this.p = Boolean.valueOf(r7);
    L21:
        dm.a.a("PdpSnapshotTransition").b("screen mode update expanded=" + r7 + " dispatched=" + r2, null);
        return r2;
    L15:
        e73.a r6 = r0.a;
        if (r6 == null) goto L19;
        r2 = r0.b(r6.d());
        goto L19
    }

    @Override // vg3.v
    public final p73.c S(p73.d r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "param");
        Intrinsics.checkNotNullParameter(r3, "componentId");
        return ((p73.e) this.t.getValue()).a(r2, r3);
    }

    @Override // vg3.v
    public final void i1(com.bytedance.android.ecom.arch.slice.action.v r3, j73.d r4) {
        Intrinsics.checkNotNullParameter(r3, "provider");
        Intrinsics.checkNotNullParameter(r4, "dependency");
        b r0 = new b(this);
        FragmentActivity r1 = O1().getContainerAbility().mo2525getContext();
        if (r1 != null) goto L5;
        return;
    L5:
        PdpEventRegistry.a(r0, r3, r1, r4);
    }
}
