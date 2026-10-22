package com.bytedance.android.shopping.prepurchase.business.pdp.components;

import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.monitor.param.ECParamTrackerCenter;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.host.api.split.ECFoldStatus;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.anchorv3.compat.CompatFrameLayout;
import com.bytedance.android.shopping.anchorv3.compat.UserInteractFrameLayout;
import com.bytedance.android.shopping.anchorv4.ai.PdpAIComponent;
import com.bytedance.android.shopping.anchorv4.ai.PdpAIServiceProvider;
import com.bytedance.android.shopping.anchorv4.ai.l0;
import com.bytedance.android.shopping.anchorv4.ai.p0;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.helper.PdpBottomNavBarHelper;
import com.bytedance.android.shopping.anchorv4.helper.PdpFragmentWatcher;
import com.bytedance.android.shopping.anchorv4.log.AdLogUtils;
import com.bytedance.android.shopping.anchorv4.widgets.TopRoundFrameLayout;
import com.bytedance.android.shopping.buynow.data.model.PageScrollStatus;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.LoadingComponent;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.live.HalfStrandComponent;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.live.LiveSearchComponent;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.BottomNavigationComponentV2;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.TopNavigationComponentV2;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.ProductDetailInfoComponent;
import com.bytedance.android.shopping.prepurchase.business.pdp.debug.ProductDetailDebugComponent;
import com.bytedance.android.shopping.prepurchase.business.pdp.services.InstantService;
import com.bytedance.android.shopping.prepurchase.business.pdp.services.InstantService$dependency$1;
import com.bytedance.android.shopping.prepurchase.business.pdp.services.PdpCommonService;
import com.bytedance.android.shopping.prepurchase.business.pdp.services.PdpNotifyHostService;
import com.bytedance.android.shopping.prepurchase.business.pdp.services.countdown.AuctionCountDownService;
import com.bytedance.android.shopping.prepurchase.business.pdp.services.event.ProductDetailEventService;
import com.bytedance.android.shopping.prepurchase.business.pdp.services.sku.PdpSKUService;
import com.bytedance.android.shopping.prepurchase.business.pdp.view.PdpCoordinateLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;
import vg3.d0;
import vg3.e0;
import vg3.f0;
import vg3.i0;
import vg3.k0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class PdpRootComponent extends m implements vg3.u {
    public static final /* synthetic */ int y = 0;
    public TopRoundFrameLayout m;
    public final int n;
    public u o;
    public final PdpFragmentWatcher p;
    public final Lazy q;
    public long r;
    public int s;
    public final List<Function1<k0, Boolean>> t;
    public final List<Function0<Unit>> u;
    public final PdpRootComponent$dependency$1 v;
    public final CompositeDisposable w;
    public final a x;

    public interface a {
        boolean a();

        boolean b();

        boolean c();

        boolean d();

        boolean e();

        int f(int r1);
    }

    @Override // vg3.u
    public final PdpRootComponent k() {
        return this;
    }

    @Override // vg3.u
    public final com.bytedance.android.shopping.prepurchase.business.pdp.services.slice.h C() {
        com.bytedance.android.shopping.prepurchase.arch.container.ability.a r0 = N1(vg3.w.class);
        Intrinsics.checkNotNull(r0);
        vg3.w r1 = (vg3.w) r0;
        vg3.x r2 = (vg3.x) N1(vg3.x.class);
        com.bytedance.android.shopping.prepurchase.arch.container.ability.a r3 = N1(e0.class);
        Intrinsics.checkNotNull(r3);
        PdpSKUService.b r7 = ((e0) r3).b();
        Function0<j73.g> r8 = new PdpRootComponent$createEventChainDependency$topEventChainDependency$1(this);
        Function0<j73.c> r9 = new PdpRootComponent$createEventChainDependency$bottomEventChainDependency$1(this);
        com.bytedance.android.shopping.prepurchase.arch.container.ability.a r4 = N1(vg3.n.class);
        Intrinsics.checkNotNull(r4);
        InstantService$dependency$1 r10 = ((vg3.n) r4).b();
        com.bytedance.android.shopping.prepurchase.arch.container.ability.a r5 = N1(d0.class);
        Intrinsics.checkNotNull(r5);
        ProductDetailInfoComponent.b r11 = ((d0) r5).b();
        com.bytedance.android.shopping.prepurchase.arch.container.ability.a r6 = N1(vg3.v.class);
        Intrinsics.checkNotNull(r6);
        com.bytedance.android.shopping.prepurchase.business.pdp.services.slice.d r13 = ((vg3.v) r6).C();
        int r12 = com.bytedance.android.shopping.prepurchase.business.pdp.services.slice.b.a;
        PdpRootComponent$dependency$1 r14 = this.v;
        com.bytedance.android.shopping.prepurchase.arch.container.component.j r15 = R1();
        Intrinsics.checkNotNullParameter(r1, "eventAbility");
        Intrinsics.checkNotNullParameter(r14, "pdpContainerAbility");
        Intrinsics.checkNotNullParameter(r7, "skuEventChainDependency");
        Intrinsics.checkNotNullParameter(r8, "topEventChainDependency");
        Intrinsics.checkNotNullParameter(r9, "bottomEventChainDependency");
        Intrinsics.checkNotNullParameter(r10, "instantDependency");
        Intrinsics.checkNotNullParameter(r11, "mainFeedDependency");
        Intrinsics.checkNotNullParameter(r15, "serviceRegistry");
        Intrinsics.checkNotNullParameter(r13, "dynamicFeatureDependency");
        return new com.bytedance.android.shopping.prepurchase.business.pdp.services.slice.h(new com.bytedance.android.shopping.prepurchase.business.pdp.services.slice.i(r1), new com.bytedance.android.shopping.prepurchase.business.pdp.services.slice.g(r2), r14, r7, r8, r9, r10, r11, r15, r13);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final List<Class<?>> M1() {
        return CollectionsKt.listOf(new Class[]{vg3.s.class, d0.class, f0.class, vg3.w.class, vg3.a0.class, vg3.x.class, e0.class, i0.class, vg3.u.class, vg3.e.class, vg3.n.class, vg3.l.class, vg3.q.class, vg3.v.class, vg3.g.class, vg3.i.class});
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void S1() {
        com.bytedance.android.shopping.prepurchase.arch.container.component.b.a(this, "onAppear " + g2().getSessionId());
        super.S1();
        this.r = SystemClock.uptimeMillis();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0, types: [android.view.View, com.bytedance.android.shopping.anchorv4.widgets.TopRoundFrameLayout, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v24, types: [android.view.View, android.widget.FrameLayout, com.bytedance.android.shopping.anchorv3.compat.UserInteractFrameLayout, com.bytedance.android.shopping.anchorv4.widgets.TopRoundFrameLayout] */
    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void T1() {
        com.bytedance.android.shopping.prepurchase.arch.container.component.b.a(this, "onAttach " + g2().getSessionId());
        super.T1();
        AbsComponent.Y1(this, vg3.u.class, this, false, 12);
        O1().e().r().J1(vg3.u.class, this);
        s0.c(this);
        com.bytedance.android.shopping.prepurchase.arch.container.intf.b r1 = O1().getContainerAbility();
        Intrinsics.checkNotNullParameter(r1, "$this$getContainerHeight");
        ((com.bytedance.android.shopping.prepurchase.business.pdp.e) O1().f().b).b.b = this.x.f(r1.i7().b);
        PdpBottomNavBarHelper r2 = new PdpBottomNavBarHelper(this.p);
        Object r3 = O1().getContainerAbility().k7();
        Map r4 = PdpBottomNavBarHelper.c;
        PdpBottomNavBarHelper.a.a(r3, -1);
        Z1(f0.class, new PdpRootComponent$initData$1(this, r2, null));
        O1().b().e1(new PdpRootComponent$checkLawAndTrackEnterProductDetail$1(this));
        n r5 = (n) this.q.getValue();
        CompatFrameLayout r6 = e2();
        if (r6 == null) goto L98;
        CompatFrameLayout r7 = r6;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r7, FreqActions.ACTION_VIEW);
        r5.i.d(new ProductDetailEventService());
        r5.i.d(new com.bytedance.android.shopping.prepurchase.business.pdp.services.d());
        r5.i.d(new PdpCommonService());
        r5.i.d(new PdpSKUService());
        r5.i.d(new AuctionCountDownService());
        r5.i.d(new InstantService());
        r5.i.d(new LifeCycleNotificationService(r5.j, r7, r5.k));
        com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.f.b(r5.f, new PdpComponentsLoader$doOnAttach$1(r5, null));
        r5.g.b().e1(new o(r5));
        com.bytedance.android.shopping.prepurchase.business.pdp.e r8 = (com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(r5.g);
        Intrinsics.checkNotNullParameter(r8, "$this$nativeParams");
        if (r8.a.getNativeParams().getFullMode() == true) goto L7;
        r5.i.d(new PdpNotifyHostService());
    L7:
        n r9 = (n) this.q.getValue();
        CompatFrameLayout r10 = e2();
        if (r10 == null) goto L96;
        CompatFrameLayout r11 = r10;
        int r12 = com.bytedance.android.ec.core.utils.s.a;
        Integer r13 = com.bytedance.android.ec.core.utils.s.b(g2().getNativeParams().getMaskColor());
        if (r13 == null) goto L12;
        r11.setBackgroundColor(r13.intValue());
    L12:
        Z1(vg3.s.class, new PdpRootComponent$initView$2(this, r11, null));
        FrameLayout r14 = new FrameLayout(e2().getContext());
        r14.setId(2131382091);
        r14.setOnClickListener(new v(this));
        View r15 = new View(e2().getContext());
        r15.setId(2131362888);
        r15.setBackgroundColor(-1);
        r15.setAlpha(0.0f);
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).b.c, this, new w(r15, this));
        r14.addView(r15, new ViewGroup.LayoutParams(-1, O1().getContainerAbility().i7().c));
        r11.addView(r14, new CoordinatorLayout.LayoutParams(-1, -1));
        CoordinatorLayout r16 = new PdpCoordinateLayout(e2().getContext(), null, 6, 0);
        r16.setId(2131370220);
        ?? r17 = new TopRoundFrameLayout(e2().getContext());
        r17.setId(2131370219);
        Function0<Unit> r18 = new PdpRootComponent$initView$$inlined$also$lambda$3(this);
        Intrinsics.checkNotNullParameter(r18, "trackCB");
        ((UserInteractFrameLayout) r17).a = r18;
        Z1(vg3.y.class, new PdpRootComponent$initView$draggableViewParent$1$1$2(r17, null));
        Unit r19 = Unit.INSTANCE;
        this.m = r17;
        r16.addView(r17, new CoordinatorLayout.LayoutParams(-1, -1));
        final e r20 = new e(O1(), this, this);
        ?? r110 = this.m;
        if (r110 != 0) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("draggableView");
    L15:
        boolean r111 = g2().getNativeParams().getFullMode();
        Integer r112 = g2().getNativeParams().getPanelHeightPercent();
        if (r112 == null) goto L18;
        int r113 = r112.intValue();
    L19:
        Intrinsics.checkNotNullParameter(r110, "bottomSheetView");
        if (r111 == true) goto L22;
        int r114 = 4;
    L23:
        r20.d = r114;
        if (((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(r20.e)).a.getNativeParams().getFullMode() == false) goto L26;
        ((com.bytedance.android.shopping.prepurchase.business.pdp.e) r20.e.f().b).b.c.g(Float.valueOf(1.0f));
        ((com.bytedance.android.shopping.prepurchase.business.pdp.e) r20.e.f().b).b.d.g(Boolean.TRUE);
    L42:
        Function1<Integer, Unit> r21 = new PdpRootComponent$initView$$inlined$also$lambda$4(this);
        r21.invoke(Integer.valueOf(this.n));
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).b.c, this, new x(r21, this));
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).b.d, this, new y(r21, this));
        r11.addView(r16, new ViewGroup.LayoutParams(-1, -1));
        FrameLayout r22 = new FrameLayout(r11.getContext());
        r22.setId(2131382094);
        r11.addView(r22, new ViewGroup.LayoutParams(-1, -1));
        z r23 = new z(this, r22, r14);
        r9.getClass();
        Intrinsics.checkNotNullParameter(r23, FreqActions.ACTION_VIEW);
        if (r9.j.d() == false) goto L45;
        LiveSearchComponent r24 = new LiveSearchComponent();
        n.b(r9, r14, r24, null, 0, 12);
        ((ArrayList) r9.a).add(r24);
    L45:
        UserInteractFrameLayout r25 = r23.a();
        n.b(r9, r25, new ProductDetailInfoComponent(), null, 0, 12);
        com.bytedance.android.shopping.anchorv4.helper.u r26 = r9.l;
        if (r26 == null) goto L48;
        s73.c r27 = r26.b;
    L49:
        n.b(r9, r25, new LoadingComponent(r27), null, 0, 12);
        Ref.ObjectRef r28 = new Ref.ObjectRef();
        TopNavigationComponentV2 r115 = new TopNavigationComponentV2();
        r28.element = r115;
        r9.d = r115;
        n.b(r9, r22, r115, null, 0, 12);
        Ref.ObjectRef r29 = new Ref.ObjectRef();
        BottomNavigationComponentV2 r116 = new BottomNavigationComponentV2();
        r29.element = r116;
        n.b(r9, r22, r116, null, 0, 12);
        r9.g.b().e1(new p(r9, r22, r28));
        Ref.BooleanRef r117 = new Ref.BooleanRef();
        r117.element = false;
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(r9.g.d().q0(), r9.f, new q(r9, r117, r22, r28, r29));
        if (r9.j.d() == false) goto L52;
        HalfStrandComponent r30 = new HalfStrandComponent();
        n.b(r9, r22, r30, new FrameLayout.LayoutParams(-1, -2), 0, 8);
        ((ArrayList) r9.a).add(r30);
    L52:
        ECAppInfoService r31 = ECAppInfoService.e;
        if (r31.isDebug() == false) goto L55;
    L56:
        r9.i.a(r22, new ProductDetailDebugComponent(), null, -1);
    L57:
        r9.g.b().n0(new r(r9, r22));
        r9.g.b().e1(new s(r9, r22));
        View r32 = e2();
        if (r32 == null) goto L92;
        r9.c((FrameLayout) r32);
        View r33 = e2();
        if (r33 == null) goto L90;
        FrameLayout r34 = (FrameLayout) r33;
        l0.a("createV2ComponentFactory called");
        p0 r35 = (p0) PdpAIServiceProvider.a.getValue();
        Intrinsics.checkNotNullParameter(r35, "gateway");
        if (r35.isEnabled() == true) goto L64;
        PdpAIComponent r118 = null;
    L65:
        if (r118 == null) goto L68;
        r9.e = r118;
        n.b(r9, r34, r118, new FrameLayout.LayoutParams(-1, -1), 0, 8);
    L68:
        if ((!((ArrayList) r9.a).isEmpty()) == false) goto L70;
        ul.b.b(r9);
    L70:
        Function1<k0, Boolean> r36 = new PdpRootComponent$initCloseAction$1(this);
        Intrinsics.checkNotNullParameter(r36, "interceptor");
        ((ArrayList) this.t).add(r36);
        com.bytedance.android.shopping.prepurchase.business.pdp.components.a r37 = new com.bytedance.android.shopping.prepurchase.business.pdp.components.a(O1().d(), (f0) N1(f0.class));
        Intrinsics.checkNotNullParameter(r37, "interceptor");
        ((ArrayList) this.t).add(r37);
        O1().getContainerAbility().a(new t(this));
        if (g2().getNativeParams().getFullMode() == true) goto L83;
        FragmentActivity r38 = O1().getContainerAbility().mo2525getContext();
        Ref.ObjectRef r39 = new Ref.ObjectRef();
        if (r38 != null) goto L75;
        ECFoldStatus r40 = ECFoldStatus.UNKNOWN;
    L79:
        r39.element = r40;
        u r41 = new u();
        nj.d r42 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r42 == null) goto L82;
        r42.b();
    L82:
        this.o = r41;
        goto L83
    L75:
        nj.d r43 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r43 == null) goto L78;
        r43.getFoldStatus();
    L78:
        r40 = ECFoldStatus.UNKNOWN;
    L83:
        com.bytedance.android.shopping.prepurchase.business.pdp.services.slice.h r44 = C();
        com.bytedance.android.ecom.arch.slice.action.v r45 = O1().e().r().F0();
        if (r45 == null) goto L87;
        Z1(vg3.v.class, new PdpRootComponent$initSliceEventChainActions$1(this, r45, r44, null));
    L87:
        this.p.a(O1().getContainerAbility().k7());
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).b.d, this, new a0(this));
        Z1(vg3.y.class, new PdpRootComponent$onAttach$1(null));
        return;
    L64:
        r118 = new PdpAIComponent(r35, r34);
        goto L65
    L90:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
    L92:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
    L55:
        if (r31.isLocalTest() == false) goto L57;
    L48:
        r27 = null;
        goto L49
    L26:
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(r20.e.d().getData().c, r20.g, new b(r20));
        CoordinatorLayout.LayoutParams r119 = r110.getLayoutParams();
        if (r119 == null) goto L94;
        CoordinatorLayout.LayoutParams r120 = r119;
        if (r120.getBehavior() != null) goto L32;
        r120.setBehavior(new ToggleBottomSheetBehavior());
        r110.setLayoutParams(r120);
    L32:
        if (r113 >= 80) goto L34;
    L36:
        boolean r121 = false;
    L37:
        BottomSheetBehavior<View> r122 = BottomSheetBehavior.from(r110);
        r20.a = r122;
        if ((r122 instanceof ToggleBottomSheetBehavior) == true) goto L40;
        BottomSheetBehavior<View> r123 = null;
    L41:
        ViewCompat.setAccessibilityDelegate(r110, new DraggableViewHelper$setup$2(r20));
        r110.setOnTouchListener(c.a);
        r122.setBottomSheetCallback(new d(r20, r122, (ToggleBottomSheetBehavior) r123, r110, r121));
        r122.setPeekHeight(((com.bytedance.android.shopping.prepurchase.business.pdp.e) r20.e.f().b).b.b);
        r122.setSkipCollapsed(false);
        r122.setState(4);
        r122.setHideable(true);
        ((com.bytedance.android.shopping.prepurchase.business.pdp.e) r20.e.f().b).b.d.g(Boolean.FALSE);
        goto L42
    L40:
        r123 = r122;
        goto L41
    L34:
        if (ECSettingKeys.A0().d() == false) goto L36;
        r121 = true;
        goto L37
    L94:
        throw new NullPointerException("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
    L22:
        r114 = 3;
        goto L23
    L18:
        r113 = 0;
        goto L19
    L96:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv3.compat.CompatFrameLayout");
    L98:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv3.compat.CompatFrameLayout");
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void U1() {
        com.bytedance.android.shopping.prepurchase.arch.container.component.b.a(this, "onDetach " + g2().getSessionId());
        n r0 = (n) this.q.getValue();
        if ((!((ArrayList) r0.a).isEmpty()) == false) goto L6;
        ul.b.a(r0);
    L6:
        if (this.s > 0) goto L14;
        vg3.w r1 = (vg3.w) N1(vg3.w.class);
        if (r1 == null) goto L14;
        ProductDetailEventService.b r2 = r1.m();
        if (r2 == null) goto L14;
        com.bytedance.android.shopping.prepurchase.arch.container.ability.m r3 = r2.d(MapsKt.mapOf(TuplesKt.to("btm", "a1.b8094.c0.d0")));
        if (r3 == null) goto L14;
        com.bytedance.android.shopping.prepurchase.arch.container.ability.m.a.a(r3, "pd_no_action", false, null, r1.getPageFinder(), 6);
    L14:
        PdpFragmentWatcher r4 = this.p;
        Object r5 = O1().getContainerAbility().k7();
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "container");
        Lambda r6 = r4.b;
        if (r6 == null) goto L17;
        Unit r7 = (Unit) r6.invoke();
    L17:
        r4.b = null;
        this.w.clear();
        s0.e(this);
        if (this.o == null) goto L22;
        nj.d r8 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r8 == null) goto L22;
        r8.e();
    L22:
        vg3.w r9 = (vg3.w) N1(vg3.w.class);
        if (r9 == null) goto L29;
        ProductDetailEventService.b r10 = r9.m();
        if (r10 == null) goto L29;
        com.bytedance.android.shopping.prepurchase.arch.container.ability.m r11 = r10.d(MapsKt.mapOf(TuplesKt.to("close_method", PageScrollStatus.slide)));
        if (r11 == null) goto L29;
        com.bytedance.android.shopping.prepurchase.arch.container.ability.m.a.a(r11, "close_product_detail", false, null, null, 14);
    L29:
        super.U1();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void W1() {
        com.bytedance.android.shopping.prepurchase.arch.container.component.b.a(this, "onStart " + g2().getSessionId());
        super.W1();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void X1() {
        com.bytedance.android.shopping.prepurchase.arch.container.component.b.a(this, "onStop " + g2().getSessionId());
        super.X1();
    }

    @Override // vg3.u
    public final long P0() {
        return this.r;
    }

    @Override // vg3.u
    public final void d0(FragmentManager.FragmentLifecycleCallbacks r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.p.b(r2);
    }

    @Override // vg3.u
    public final void j1(FragmentManager.FragmentLifecycleCallbacks r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        PdpFragmentWatcher r1 = this.p;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "callback");
        ((ArrayList) r1.a).remove(r3);
    }

    @Override // vg3.u
    public final void l1(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((ArrayList) this.u).add(r2);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onProductDetailHalfPageCloseEvent(r83.b r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        v0(new k0(false, false, 7));
    }

    @Override // vg3.u
    public final void v0(k0 r4) {
        Intrinsics.checkNotNullParameter(r4, "options");
        List<Function1<k0, Boolean>> r0 = this.t;
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator r1 = ((ArrayList) r0).iterator();
    L9:
        if (r1.hasNext() == false) goto L13;
        if (((Boolean) ((Function1) r1.next()).invoke(r4)).booleanValue() == false) goto L9;
        boolean r5 = true;
    L14:
        if (r5 == false) goto L16;
        return;
    L16:
        Iterator r6 = ((ArrayList) this.u).iterator();
    L18:
        if (r6.hasNext() == false) goto L20;
        ((Function0) r6.next()).invoke();
        goto L18
    L20:
        String r2 = null;
        Z1(vg3.w.class, new PdpRootComponent$realLogAndCloseAnchorV4$1(null));
        CommonMeta r7 = O1().d().getData().a().a();
        if (r7 == null) goto L30;
        String r3 = h73.a.b(r7);
        if (r3 == null) goto L30;
        s83.g r8 = AdLogUtils.a;
        String r9 = r7.getEntranceInfo();
        if (r9 == null) goto L29;
        JSONObject r10 = com.bytedance.android.shopping.extensions.k.w(r9);
        if (r10 == null) goto L29;
        r2 = r10.optString("log_extra");
    L29:
        AdLogUtils.c(r3, r2, h73.a.a(r7));
    L30:
        Map r11 = ECParamTrackerCenter.a;
        ECParamTrackerCenter.a(g2().getSessionId());
        O1().getContainerAbility().H();
        return;
    L13:
        r5 = false;
        goto L14
    L5:
        if (((ArrayList) r0).isEmpty() == false) goto L7;
        goto L7
    }

    /* JADX WARN: Type inference failed for: r2v9, types: [com.bytedance.android.shopping.prepurchase.business.pdp.components.PdpRootComponent$dependency$1] */
    public PdpRootComponent(a r2, final com.bytedance.android.shopping.anchorv4.helper.u r3, final n83.m r4) {
        Intrinsics.checkNotNullParameter(r2, "provider");
        this.x = r2;
        this.n = com.bytedance.android.shopping.extensions.b.b(20);
        this.p = new PdpFragmentWatcher();
        this.q = LazyKt.lazy(new PdpRootComponent$componentsLoader$2(this, r4, r3));
        this.t = new ArrayList();
        this.u = new ArrayList();
        this.v = new PdpRootComponent$dependency$1(this);
        this.w = new CompositeDisposable();
    }

    @Override // vg3.u
    public final void o(String r11, Map<String, Object> r12, Long r13) {
        Intrinsics.checkNotNullParameter(r11, "url");
        Intrinsics.checkNotNullParameter(r12, "queryParams");
        BuildersKt.launch$default(com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.f.a(P1()), Dispatchers.getMain(), null, new PdpRootComponent$showPdpLynxToast$1(this, r11, r12, r13, null), 2, null);
    }
}
