package com.bytedance.android.shopping.prepurchase.business.pdp.components;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.common.api.usertracker.IECUserTrackerService;
import com.bytedance.android.ec.common.api.usertracker.PostActionType;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.anchorv3.compat.CompatFrameLayout;
import com.bytedance.android.shopping.api.PageDestroyTypeEvent;
import com.bytedance.android.shopping.feed.event.n1;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.ies.uikit.base.AbsActivity;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import vg3.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class LifeCycleNotificationService extends b0 {
    public Object i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public final b n;
    public final PdpRootComponent.a o;
    public final CompatFrameLayout p;
    public final n83.m q;

    public static final class a<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r2) {
            boolean r3 = ((Boolean) r2).booleanValue();
            com.bytedance.android.shopping.service.c.b.a = r3;
            s0.a(new hl.j(r3));
        }
    }

    public static final class b implements com.bytedance.android.shopping.anchorv3.compat.c {
        public final /* synthetic */ LifeCycleNotificationService a;

        public b(LifeCycleNotificationService r1) {
            this.a = r1;
        }

        public final void a(View r2, MotionEvent r3) {
            Intrinsics.checkNotNullParameter(r2, FreqActions.ACTION_VIEW);
            Intrinsics.checkNotNullParameter(r3, "ev");
            s83.c r4 = ih3.g.b.D();
            Object r5 = this.a.i;
            r4.f();
        }
    }

    private final FragmentActivity getActivity() {
        return (FragmentActivity) this.l.getValue();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final List<Class<?>> M1() {
        return CollectionsKt.listOf(new Class[]{d0.class, vg3.u.class});
    }

    public final s83.g c2() {
        return (s83.g) this.j.getValue();
    }

    public final int d2() {
        return ((Number) this.k.getValue()).intValue();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void S1() {
        super.S1();
        s83.g r0 = c2();
        if (r0 == null) goto L5;
        r0.c(d2());
    L5:
        com.bytedance.android.shopping.anchorv3.compat.b.b(a2().getNativeParams().getTaskInfo());
        int r1 = com.bytedance.android.ec.core.opt.b.a;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void T1() {
        super.T1();
        s83.g r0 = c2();
        if (r0 == null) goto L6;
        r0.O(d2());
    L6:
        if (this.o.e() == false) goto L13;
        int r1 = ph.a.a;
        FragmentActivity r2 = getActivity();
        Intrinsics.checkNotNull(r2);
        Intrinsics.checkNotNullParameter(r2, "context");
        if (com.bytedance.android.ec.core.opt.ab.j.a().c() == false) goto L13;
        int r3 = ECSdk.a;
        cj.b r4 = (cj.b) ECSdk.a(cj.b.class);
        if (r4 == null) goto L13;
        r4.e(r2);
    L13:
        if (this.o.a() == false) goto L29;
        if ((getActivity() instanceof AppCompatActivity) == false) goto L29;
        Disposable r5 = com.bytedance.android.shopping.anchorv3.compat.b.a;
        FragmentActivity r6 = getActivity();
        Intrinsics.checkNotNull(r6);
        FragmentActivity r7 = getActivity();
        Intrinsics.checkNotNull(r7);
        if (com.bytedance.android.shopping.anchorv3.compat.b.c(r6, r7.getIntent()) == false) goto L29;
        p83.f r8 = (p83.f) this.m.getValue();
        if (r8 == null) goto L25;
        FragmentActivity r9 = getActivity();
        if (r9 == null) goto L24;
        r8.a((AppCompatActivity) r9);
        goto L25
    L24:
        throw new NullPointerException("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
    L25:
        p83.f r10 = (p83.f) this.m.getValue();
        if (r10 == null) goto L29;
        r10.b();
    L29:
        if (this.o.c() == false) goto L35;
        s83.c r11 = ih3.g.b.D();
        AbsActivity r12 = getActivity();
        if (r12 == null) goto L34;
        r11.b(r12);
        this.i = null;
        this.p.setTouchInterceptor(this.n);
        goto L35
    L34:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.ies.uikit.base.AbsActivity");
    L35:
        Object r13 = O1().getContainerAbility().k7();
        if ((r13 instanceof Activity) == false) goto L39;
        of.b r14 = new of.b((Context) r13, "product_detail", true, null, 24);
    L44:
        if (r14 == null) goto L54;
        int r15 = ECSdk.a;
        IECUserTrackerService r16 = (IECUserTrackerService) ECSdk.a(IECUserTrackerService.class);
        if (r16 == null) goto L48;
        r16.enterPage(r14);
    L48:
        IECUserTrackerService r17 = (IECUserTrackerService) ECSdk.a(IECUserTrackerService.class);
        if (r17 == null) goto L54;
        of.a r18 = r17.getMarketingService();
        if (r18 == null) goto L54;
        r18.a("product_detail_visit_seconds", PostActionType.START_DURATION, "product_detail");
    L54:
        if (((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).a.getNativeParams().getFullMode() == true) goto L56;
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).b.d, this, a.a);
    L56:
        String r19 = a2().getNativeParams().getPdpEventTransparentId();
        if (r19 == null) goto L62;
        s83.g r20 = c2();
        if (r20 == null) goto L62;
        r20.b(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("pdp_event_transparent_id", r19)}));
    L62:
        if (this.o.b() == false) goto L64;
        s0.a(new n1());
    L64:
        s0.a(new hl.c());
        LastPageVideoZoomer r21 = new LastPageVideoZoomer(O1(), R1(), this.q, this.p);
        Intrinsics.checkNotNullParameter(this, "lifecycleOwner");
        CompatFrameLayout r22 = r21.j;
        P1().a(new i(r21, r22));
        r21.d().b.c.b(this, com.bytedance.android.shopping.prepurchase.arch.container.state.j.a(), new j(r21, r22));
        if (r21.e == true) goto L67;
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(r21.d().b.d, this, new k(r21));
    L67:
        Z1(d0.class, new LifeCycleNotificationService$onAttach$4$1(r21, null));
        Z1(vg3.u.class, new LifeCycleNotificationService$onAttach$4$2(r21, null));
        return;
    L39:
        if ((r13 instanceof Fragment) == false) goto L70;
        Context r23 = ((Fragment) r13).getContext();
        if (r23 == null) goto L43;
        r14 = new of.b(r23, "product_detail", true, (DialogFragment) r13, 16);
        goto L44
    L43:
        r14 = null;
        goto L44
    L70:
        throw new IllegalStateException("not activity or fragment " + r13);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void U1() {
        super.U1();
        of.b r1 = null;
        if (this.o.c() == false) goto L7;
        s83.c r0 = ih3.g.b.D();
        FragmentActivity r2 = getActivity();
        Intrinsics.checkNotNull(r2);
        r0.e(r2);
        this.i = null;
        if (Intrinsics.areEqual(this.p.getTouchInterceptor(), this.n) == false) goto L7;
        this.p.setTouchInterceptor(null);
    L7:
        Object r3 = O1().getContainerAbility().k7();
        if ((r3 instanceof Activity) == false) goto L11;
        r1 = new of.b((Context) r3, "product_detail", true, null, 24);
    L15:
        if (r1 == null) goto L25;
        int r4 = ECSdk.a;
        IECUserTrackerService r5 = (IECUserTrackerService) ECSdk.a(IECUserTrackerService.class);
        if (r5 == null) goto L19;
        r5.leavePage(r1);
    L19:
        IECUserTrackerService r6 = (IECUserTrackerService) ECSdk.a(IECUserTrackerService.class);
        if (r6 == null) goto L25;
        of.a r7 = r6.getMarketingService();
        if (r7 == null) goto L25;
        r7.a("product_detail_visit_seconds", PostActionType.END_DURATION, "product_detail");
    L25:
        if (((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).a.getNativeParams().getFullMode() == false) goto L27;
        s0.a(PageDestroyTypeEvent.PRODUCT_DETAIL_FULL);
    L29:
        if (((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).a.getNativeParams().getFullMode() == true) goto L31;
        com.bytedance.android.shopping.service.c.b.a = false;
        s0.a(new hl.j(false));
    L31:
        String r8 = a2().getNativeParams().getPdpEventTransparentId();
        if (r8 == null) goto L36;
        s83.g r9 = c2();
        if (r9 == null) goto L36;
        r9.t(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("pdp_event_transparent_id", r8)}));
    L36:
        s83.g r10 = c2();
        if (r10 == null) goto L42;
        r10.X(d2());
        return;
    L42:
        return;
    L27:
        s0.a(PageDestroyTypeEvent.PRODUCT_DETAIL_HALF);
        goto L29
    L11:
        if ((r3 instanceof Fragment) == false) goto L41;
        Context r11 = ((Fragment) r3).getContext();
        if (r11 == null) goto L15;
        r1 = new of.b(r11, "product_detail", true, (DialogFragment) r3, 16);
        goto L15
    L41:
        throw new IllegalStateException("not activity or fragment " + r3);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void V1() {
        super.V1();
        s83.g r0 = c2();
        if (r0 == null) goto L5;
        r0.I(d2());
    L5:
        com.bytedance.android.shopping.anchorv3.compat.b.a(a2().getNativeParams().getTaskInfo());
    }

    public static final /* synthetic */ FragmentActivity b2(LifeCycleNotificationService r0) {
        return r0.getActivity();
    }

    public LifeCycleNotificationService(PdpRootComponent.a r2, CompatFrameLayout r3, n83.m r4) {
        Intrinsics.checkNotNullParameter(r2, "provider");
        Intrinsics.checkNotNullParameter(r3, "rootView");
        this.o = r2;
        this.p = r3;
        this.q = r4;
        this.j = LazyKt.lazy(LifeCycleNotificationService$hostService$2.INSTANCE);
        this.k = LazyKt.lazy(new LifeCycleNotificationService$instanceId$2(this));
        this.l = LazyKt.lazy(new LifeCycleNotificationService$activity$2(this));
        this.m = LazyKt.lazy(LifeCycleNotificationService$adTurnaroundHelper$2.INSTANCE);
        this.n = new b(this);
    }
}
