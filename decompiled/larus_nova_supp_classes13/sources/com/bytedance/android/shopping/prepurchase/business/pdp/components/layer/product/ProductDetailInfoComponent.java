package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product;

import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.anchorv3.PdpPerfOpt;
import com.bytedance.android.ec.core.async.DisposableScope;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.shopping.anchorv3.AnchorV3GridLayoutManager;
import com.bytedance.android.shopping.anchorv3.detail.StaggeredGridDoubleColumnDecoration;
import com.bytedance.android.shopping.anchorv3.widget.BasePdpRecyclerView;
import com.bytedance.android.shopping.anchorv3.widget.FixedRecyclerView;
import com.bytedance.android.shopping.anchorv4.components.TabBindAndScrollReactComponent;
import com.bytedance.android.shopping.anchorv4.components.a0;
import com.bytedance.android.shopping.anchorv4.components.b0;
import com.bytedance.android.shopping.anchorv4.dto.business.ComponentDTO;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.experiment.PdpAB;
import com.bytedance.android.shopping.anchorv4.params.AnchorV4Param;
import com.bytedance.android.shopping.anchorv4.voavhs.unifiedtips.UnifiedTipItemDecoration;
import com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent;
import com.bytedance.android.shopping.prepurchase.arch.container.component.Component;
import com.bytedance.android.shopping.prepurchase.arch.container.component.ViewModel;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.gul.GULSDKComponent;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.gul.OldGulService;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.header.HeaderComponent;
import com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataStore;
import com.bytedance.android.shopping.prepurchase.business.pdp.services.event.ProductDetailEventService;
import com.bytedance.android.shopping.prepurchase.business.pdp.view.MultiRecyclerNestedScrollView;
import fi3.c0;
import fi3.w0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import vg3.d0;
import vg3.e0;
import vg3.o0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ProductDetailInfoComponent extends com.bytedance.android.shopping.prepurchase.arch.container.component.h<com.bytedance.android.shopping.prepurchase.business.pdp.e, PdpDataStore, ProductDetailInfoViewModel> implements d0 {
    public static final int A = 0;
    public MultiRecyclerNestedScrollView n;
    public FixedRecyclerView o;
    public d p;
    public final DisposableScope q;
    public Function0<Integer> r;
    public final com.bytedance.android.shopping.prepurchase.arch.container.state.d<com.bytedance.android.ecom.arch.slice.adapter.b> s;
    public final Lazy t;
    public AbsComponent<?, ?> u;
    public Function0<Unit> v;
    public final int[] w;
    public final int[] x;
    public boolean y;
    public final b z;

    public static final class a {
    }

    public static final class b implements j73.e {
        public final /* synthetic */ ProductDetailInfoComponent a;

        public final void O() {
            vg3.w r0 = (vg3.w) this.a.R1().getService(vg3.w.class);
            if (r0 == null) goto L7;
            ProductDetailEventService.b r1 = r0.m();
            if (r1 == null) goto L7;
            com.bytedance.android.shopping.prepurchase.arch.container.ability.m.a.a(r1, "back_to_top_button_click", false, null, null, 14);
        L7:
            MultiRecyclerNestedScrollView r2 = ProductDetailInfoComponent.h2(this.a);
            this.a.getClass();
            r2.l(0, 0);
        }

        public final HashMap<String, Boolean> b0() {
            tg3.a r0 = this.a.g2().e;
            if (r0 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("asyncFetchActionHandler");
        L6:
            return r0.a;
        }

        public final void i0() {
            FixedRecyclerView r0 = this.a.o;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("topRecycleView");
        L5:
            RecyclerView.Adapter r1 = r0.getAdapter();
            if (r1 == null) goto L9;
            r1.notifyDataSetChanged();
            return;
        }

        public final void y() {
            ProductDetailInfoViewModel r1 = this.a.g2();
            List<com.bytedance.android.ecom.arch.slice.adapter.b> r2 = r1.getContext().d().getData().b().a();
            int r4 = 0;
            if (r2 == null) goto L25;
            ArrayList r8 = new ArrayList();
            Iterator<T> r7 = r2.iterator();
        L6:
            if (r7.hasNext() == false) goto L26;
            Object r9 = r7.next();
            com.bytedance.android.shopping.anchorv4.voavhs.lynx.a r10 = (com.bytedance.android.ecom.arch.slice.adapter.b) r9;
            if ((r10 instanceof com.bytedance.android.shopping.anchorv4.voavhs.lynx.a) == false) goto L22;
            com.bytedance.android.shopping.anchorv4.voavhs.lynx.a r11 = r10;
            ComponentDTO r12 = r11.f;
            if (r12 == null) goto L12;
            String r13 = r12.getComponentId();
        L14:
            if (Intrinsics.areEqual(r13, "id_above_pd") == false) goto L22;
            ComponentDTO r14 = r11.f;
            if (r14 == null) goto L18;
            Boolean r15 = r14.isHide();
        L20:
            if (Intrinsics.areEqual(r15, Boolean.TRUE) == false) goto L22;
            boolean r16 = true;
        L23:
            if (r16 == false) goto L6;
            r8.add(r9);
            goto L6
        L18:
            r15 = null;
            goto L20
        L12:
            r13 = null;
        L22:
            r16 = false;
        L26:
            if (r8 == null) goto L28;
            r4 = r8.size();
        L28:
            if (r4 <= 0) goto L51;
            ArrayList r5 = new ArrayList();
            if (r2 == null) goto L48;
            Iterator<T> r3 = r2.iterator();
        L33:
            if (r3.hasNext() == false) goto L48;
            com.bytedance.android.shopping.anchorv4.voavhs.lynx.a r17 = (com.bytedance.android.ecom.arch.slice.adapter.b) r3.next();
            if ((r17 instanceof com.bytedance.android.shopping.anchorv4.voavhs.lynx.a) == false) goto L47;
            com.bytedance.android.shopping.anchorv4.voavhs.lynx.a r18 = r17;
            ComponentDTO r19 = r18.f;
            if (r19 == null) goto L39;
            String r20 = r19.getComponentId();
        L41:
            if (Intrinsics.areEqual(r20, "id_above_pd") == false) goto L47;
            ComponentDTO r110 = r18.f;
            if (r110 == null) goto L45;
            ComponentDTO r21 = ComponentDTO.copy$default(r110, null, null, 0, null, null, Boolean.FALSE, null, null, null, null, null, null, null, 8159, null);
        L46:
            r5.add(com.bytedance.android.shopping.anchorv4.voavhs.lynx.a.a(r18, r21));
            goto L33
        L45:
            r21 = null;
            goto L46
        L39:
            r20 = null;
        L47:
            r5.add(r17);
        L48:
            vg3.x r6 = (vg3.x) ViewModel.a(r1, vg3.x.class);
            if (r6 == null) goto L51;
            r6.h1(r5);
        L51:
            r1.k = true;
            return;
        L25:
            r8 = null;
            goto L26
        }

        public b(ProductDetailInfoComponent r1) {
            this.a = r1;
        }

        public final void c0(w0 r6) {
            Intrinsics.checkNotNullParameter(r6, "data");
            ProductDetailInfoViewModel r0 = this.a.g2();
            r0.getClass();
            Intrinsics.checkNotNullParameter(r6, "titleSingleLineData");
            com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.o r1 = r0.getContext().e().r();
            Map r2 = r1.a.u0;
            if (r2 == null) goto L6;
            Object r3 = r2.get("title_single_line");
            if (r3 == null) goto L6;
        L8:
            if (Intrinsics.areEqual(Boolean.valueOf(r6.a), r3) == true) goto L18;
            r1.M0(MapsKt.mapOf(TuplesKt.to("title_single_line", Boolean.valueOf(r6.a))));
            List<String> r7 = r6.b;
            if (r7 == null) goto L16;
            Iterator<T> r8 = r7.iterator();
        L14:
            if (r8.hasNext() == false) goto L19;
            String r4 = (String) r8.next();
            int r5 = c0.e;
            r1.y0(c0.a.a(r4, MapsKt.mapOf(TuplesKt.to("empty_refresh_event", Boolean.TRUE)), null, 10), new com.bytedance.android.ecom.arch.slice.action.c(null, null), null);
            goto L14
        L19:
            return;
        L16:
            return;
        L18:
            return;
        L6:
            r3 = Boolean.FALSE;
            goto L8
        }
    }

    public static final class c implements View.OnLayoutChangeListener {
        public final /* synthetic */ ProductDetailInfoComponent a;
        public final /* synthetic */ String b;

        public c(ProductDetailInfoComponent r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            if (ProductDetailInfoComponent.h2(this.a).getHeight() <= 0) goto L6;
            ProductDetailInfoComponent.h2(this.a).removeOnLayoutChangeListener(this);
            this.a.j2(this.b, false);
            return;
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // vg3.d0
    public final Rect O() {
        int[] r0 = new int[2];
        NestedScrollView r1 = this.n;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("nestedScrollView");
    L5:
        r1.getLocationOnScreen(r0);
        NestedScrollView r2 = this.n;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("nestedScrollView");
    L8:
        int r3 = r2.getWidth();
        NestedScrollView r4 = this.n;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("nestedScrollView");
    L11:
        int r5 = r4.getHeight();
        int r6 = r0[0];
        int r7 = r0[1];
        return new Rect(r6, r7, r3 + r6, r5 + r7);
    }

    static {
        A = com.bytedance.android.shopping.extensions.b.a(60);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final List<Class<?>> M1() {
        return CollectionsKt.listOf(new Class[]{vg3.x.class, vg3.e.class, vg3.l.class, vg3.w.class, vg3.j.class, vg3.n.class, vg3.m.class, e0.class, vg3.v.class, vg3.o.class});
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void T1() {
        super.T1();
        HeaderComponent r0 = new HeaderComponent();
        Intrinsics.checkNotNullParameter(r0, "service");
        d2().d(r0);
        O1().b().e1(new q(this));
        FixedRecyclerView r1 = this.o;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("topRecycleView");
    L5:
        d r8 = new d(r1, g2(), O1(), this, R1(), this.q);
        this.p = r8;
        Function1<List<? extends com.bytedance.android.ecom.arch.slice.adapter.b>, Unit> r2 = new ProductDetailInfoComponent$initView$1(this);
        Intrinsics.checkNotNullParameter(r2, "listener");
        r8.d = r2;
        final d r3 = this.p;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mainFeedInitializer");
    L8:
        r3.getClass();
        z r4 = new z(r3.k, new j(r3));
        Object r5 = r3.m.getContainerAbility().k7();
        if (r5 == null) goto L59;
        LifecycleOwner r11 = (LifecycleOwner) r5;
        ug3.c r6 = new ug3.c(r3.o);
        com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.j r12 = r3.m.e().r().h0(r4, r6, null);
        r12.f(new f(r3));
        r3.a = new ProductDetailInfoAdapter(r11, r12, r3.m, r3.o, r6, r3.k, r3.p);
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(r3.l.j, r3.n, new g(r3, r4, r6));
        r3.k.setItemAnimator(null);
        BasePdpRecyclerView r7 = r3.k;
        ProductDetailInfoAdapter r9 = r3.a;
        if (r9 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L13:
        r9.setShowFooter(false);
        r9.d = com.bytedance.android.shopping.extensions.j.b(2131100048);
        r9.c = com.bytedance.android.shopping.extensions.j.b(2131100048);
        r9.h = com.bytedance.android.shopping.extensions.b.b(50);
        r9.showLoadMoreLoading();
        Unit r10 = Unit.INSTANCE;
        r7.setAdapter(r9);
        List<WeakReference<RecyclerView>> r13 = p.a;
        final BasePdpRecyclerView r14 = r3.k;
        Intrinsics.checkNotNullParameter(r14, "recyclerView");
        com.bytedance.android.shopping.prepurchase.arch.utils.a.a(new PdpRecyclerViewPoolTrimManager$register$1(r14));
        r3.k.setLayoutManager((AnchorV3GridLayoutManager) r3.e.getValue());
        boolean r15 = !((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(r3.m)).a.getNativeParams().getFullMode();
        if (r15 == false) goto L16;
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a((com.bytedance.android.shopping.prepurchase.arch.container.state.e) r3.m.d().getData().G.getValue(), r3.n, new k(r3));
    L16:
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(r3.m)).b.d, r3.n, new l(r3));
        if (r15 == false) goto L20;
        ((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(r3.m)).b.c.b(r3.n, com.bytedance.android.shopping.prepurchase.arch.container.state.j.a(), new m(r3));
        r3.m.b().n0(new n(r3));
    L20:
        Pair r16 = (Pair) r3.m.d().getData().c.a();
        if (r16 == null) goto L25;
        CommonMeta r17 = (CommonMeta) r16.getFirst();
        if (r17 == null) goto L25;
        Boolean r18 = Boolean.valueOf(r17.getEnablePDPOptimize());
    L27:
        if (com.bytedance.android.shopping.extensions.k.i(r18) == false) goto L29;
        float r19 = 12.0f;
    L30:
        r3.k.addItemDecoration(new StaggeredGridDoubleColumnDecoration(8.0f, r19, 8.0f, 8.0f, 8.0f, new MainFeedInitializer$initRecyclerView$4(r3)));
        r3.k.addItemDecoration(new UnifiedTipItemDecoration());
        r3.k.addOnScrollListener(r3.g);
        ji3.i r20 = new ji3.i(0);
        BasePdpRecyclerView r21 = r3.k;
        Intrinsics.checkNotNullParameter(r21, "$this$setPdpCountdownTimer");
        Intrinsics.checkNotNullParameter(r20, "timer");
        r21.setTag(2131382092, r20);
        r3.n.getLifecycle().a(new h(r20));
        AnchorV3GridLayoutManager r22 = (AnchorV3GridLayoutManager) r3.e.getValue();
        i r23 = new i(r3);
        r22.getClass();
        Intrinsics.checkNotNullParameter(r23, "watch");
        r22.a.add(r23);
        if (PdpPerfOpt.b().b() <= 0) goto L37;
        DetailImagePreloader r24 = new DetailImagePreloader(PdpPerfOpt.b());
        ProductDetailInfoAdapter r25 = r3.a;
        if (r25 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L36:
        Intrinsics.checkNotNullParameter(r25, "adapter");
        r24.b = r25;
        r3.k.addOnScrollListener(r24);
    L37:
        BasePdpRecyclerView r26 = r3.k;
        AnchorV4Param r27 = ((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(r3.m)).a;
        if (r27.getNativeParams().getFullMode() == false) goto L41;
        String r28 = MonitorScenes.FPS_SCENE_EC_PRODUCT_DETAIL_FULL_SCREEN.getSceneName();
    L44:
        jh.b.a r29 = jh.b.c;
        com.bytedance.android.ec.core.monitor.q r30 = new com.bytedance.android.ec.core.monitor.q(r28);
        r29.getClass();
        jh.b.a.c(r30).c(r26);
        ProductDetailInfoAdapter r31 = r3.a;
        if (r31 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L47:
        Function0<Unit> r32 = new MainFeedInitializer$init$1(r3);
        r31.getClass();
        Intrinsics.checkNotNullParameter(r32, "function");
        r31.w = r32;
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(r3.l.h, r3.n, new e(r3));
        FixedRecyclerView r33 = this.o;
        if (r33 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("topRecycleView");
    L50:
        Z1(vg3.e.class, new ProductDetailInfoComponent$initView$$inlined$let$lambda$1(r33, null, this));
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).b.c, this, new u(this));
        Z1(vg3.y.class, new ProductDetailInfoComponent$initView$4(this, null));
        MultiRecyclerNestedScrollView r34 = this.n;
        if (r34 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("nestedScrollView");
    L53:
        r34.setOnScrollDistanceChangeListener(new ProductDetailInfoComponent$initView$5(this));
        MultiRecyclerNestedScrollView r35 = this.n;
        if (r35 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("nestedScrollView");
    L56:
        r35.setCoverAreaHeight(new ProductDetailInfoComponent$initView$6(this));
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a((com.bytedance.android.shopping.prepurchase.arch.container.state.e) O1().d().getData().g.getValue(), this, new r(this));
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(R(), this, new s(this));
        O1().b().e1(new t(this));
        AbsComponent.Y1(this, d0.class, this, false, 12);
        return;
    L41:
        if (r27.getNativeParams().getFromLive() != true) goto L43;
        r28 = MonitorScenes.FPS_SCENE_EC_PRODUCT_DETAIL_HALF_SCREEN_LIVE.getSceneName();
        goto L44
    L43:
        r28 = MonitorScenes.FPS_SCENE_EC_PRODUCT_DETAIL_HALF_SCREEN.getSceneName();
        goto L44
    L29:
        r19 = 8.0f;
    L25:
        r18 = null;
        goto L27
    L59:
        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void U1() {
        d r0 = this.p;
        if (r0 == null) goto L7;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mainFeedInitializer");
    L6:
        r0.a();
    L7:
        super.U1();
        this.q.clearDisposable();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.h
    public final ViewModel f2() {
        return new ProductDetailInfoViewModel(this);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final int i2() {
        NestedScrollView r0 = this.n;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("nestedScrollView");
    L5:
        r0.getLocationInWindow(this.x);
        Function0<Integer> r1 = this.r;
        if (r1 == null) goto L10;
        Integer r2 = (Integer) r1.invoke();
        if (r2 == null) goto L10;
        int r3 = r2.intValue();
    L11:
        int r4 = r3 - this.x[1];
        if (r4 <= 0) goto L14;
        return r4;
    L14:
        int[] r5 = new int[2];
        FixedRecyclerView r6 = this.o;
        if (r6 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("topRecycleView");
    L17:
        r6.getLocationInWindow(r5);
        if (r5[0] <= 0) goto L20;
        int r7 = TabBindAndScrollReactComponent.F;
        return TabBindAndScrollReactComponent.F;
    L20:
        int r8 = TabBindAndScrollReactComponent.F;
        return TabBindAndScrollReactComponent.G;
    L10:
        r3 = 0;
        goto L11
    }

    public final void l2() {
        AbsComponent<?, ?> r0 = this.u;
        if (r0 == null) goto L8;
        if (d2().f(r0) == false) goto L8;
        return;
    L8:
        if (PdpAB.b == false) goto L13;
        GULSDKComponent r1 = new GULSDKComponent();
        NestedScrollView r2 = this.n;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("nestedScrollView");
    L12:
        Component.a2(this, r2, r1, null, 12);
        Unit r3 = Unit.INSTANCE;
        AbsComponent<?, ?> r4 = r1;
    L14:
        this.u = r4;
        return;
    L13:
        OldGulService r5 = new OldGulService();
        Intrinsics.checkNotNullParameter(r5, "service");
        d2().d(r5);
        Unit r6 = Unit.INSTANCE;
        r4 = r5;
        goto L14
    }

    public ProductDetailInfoComponent() {
        this.q = new DisposableScope();
        this.s = new com.bytedance.android.shopping.prepurchase.arch.container.state.d(null);
        this.t = LazyKt.lazy(ProductDetailInfoComponent$theGULTitleVO$2.INSTANCE);
        this.w = new int[2];
        this.x = new int[2];
        this.z = new b(this);
    }

    @Override // vg3.d0
    public final com.bytedance.android.shopping.prepurchase.arch.container.state.d R() {
        return g2().l;
    }

    @Override // vg3.d0
    public final com.bytedance.android.shopping.prepurchase.arch.container.state.e<o0> x1() {
        return g2().m;
    }

    @Override // vg3.d0
    public final b b() {
        return this.z;
    }

    @Override // vg3.d0
    public final com.bytedance.android.shopping.prepurchase.arch.container.state.d z0() {
        return this.s;
    }

    public static final /* synthetic */ MultiRecyclerNestedScrollView h2(ProductDetailInfoComponent r1) {
        MultiRecyclerNestedScrollView r2 = r1.n;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("nestedScrollView");
    L5:
        return r2;
    }

    @Override // vg3.d0
    public final void X0(Function0<Integer> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.r = r2;
    }

    @Override // vg3.d0
    public final void f0(com.bytedance.android.shopping.anchorv3.widget.d r3) {
        FixedRecyclerView r0 = this.o;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("topRecycleView");
    L5:
        r0.setInterceptHandler(r3);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View, com.bytedance.android.shopping.prepurchase.business.pdp.view.MultiRecyclerNestedScrollView] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void k2(int r5) {
        ?? r0 = this.n;
        if (r0 != 0) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("nestedScrollView");
    L5:
        r0.setPadding(r0.getPaddingLeft(), r0.getPaddingTop(), r0.getPaddingRight(), r5);
        r0.a.requestLayout();
    }

    public final void m2(vg3.e r4) {
        int r0 = r4.d1();
        NestedScrollView r1 = this.n;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("nestedScrollView");
    L6:
        if (Math.abs(r0 - r1.getPaddingBottom()) > 1) goto L8;
        return;
    L8:
        if (r4.Q0() == false) goto L12;
        k2(r0);
        return;
    }

    @Override // vg3.d0
    public final void p0(RecyclerView.OnScrollListener r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        FixedRecyclerView r0 = this.o;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("topRecycleView");
    L5:
        r0.addOnScrollListener(r3);
    }

    @Override // vg3.d0
    public final void scrollTo(String r2) {
        Intrinsics.checkNotNullParameter(r2, "componentId");
        j2(r2, true);
    }

    /* JADX WARN: Type inference failed for: r7v1, types: [android.view.View, android.widget.FrameLayout, com.bytedance.android.shopping.prepurchase.business.pdp.view.MultiRecyclerNestedScrollView] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.Component
    public final View c2(LayoutInflater r6, ViewGroup r7) {
        Intrinsics.checkNotNullParameter(r6, "inflater");
        Intrinsics.checkNotNullParameter(r7, "container");
        ?? r8 = new MultiRecyclerNestedScrollView(r6.getContext());
        r8.setClipToPadding(true);
        r8.setBackgroundColor(-592135);
        FixedRecyclerView r1 = new FixedRecyclerView(r6.getContext(), null, 6, 0);
        r1.setClipToPadding(false);
        r1.setBackgroundColor(-592135);
        r1.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.n = r8;
        this.o = r1;
        if (r8.b != null) goto L5;
        r8.b = r1;
        r8.a.addView(r1, 0);
        r1.addOnScrollListener(r8.j);
        r1.addOnLayoutChangeListener(new com.bytedance.android.shopping.prepurchase.business.pdp.view.j(r8, r1));
    L5:
        NestedScrollView r9 = this.n;
        if (r9 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("nestedScrollView");
    L8:
        r9.setPadding(0, 0, 0, A);
        return r8;
    }

    public final void j2(String r6, boolean r7) {
        int r1 = 0;
        if (Intrinsics.areEqual(r6, "id_recommend") == false) goto L20;
        l2();
        vg3.j r0 = (vg3.j) N1(vg3.j.class);
        if (r0 == null) goto L7;
        r0.u0();
    L7:
        MultiRecyclerNestedScrollView r2 = this.n;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("nestedScrollView");
    L11:
        if (r2.c == null) goto L13;
        boolean r3 = true;
    L14:
        if (r3 == false) goto L20;
        MultiRecyclerNestedScrollView r8 = this.n;
        if (r8 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("nestedScrollView");
    L18:
        r8.k();
        return;
    L13:
        r3 = false;
    L20:
        FixedRecyclerView r4 = this.o;
        if (r4 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("topRecycleView");
    L23:
        RecyclerView.Adapter r5 = r4.getAdapter();
        a0 r9 = null;
        if ((r5 instanceof b0) == true) goto L26;
        r5 = null;
    L26:
        b0 r10 = (b0) r5;
        if (r10 == null) goto L29;
        r9 = r10.F0(r6);
    L29:
        if (r9 == null) goto L37;
        int r11 = r9.a;
        MultiRecyclerNestedScrollView r12 = this.n;
        if (r12 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("nestedScrollView");
    L33:
        if (r11 == 0) goto L36;
        r1 = i2();
    L36:
        r12.l(r11, r1);
        return;
    L37:
        if (r7 == false) goto L44;
        NestedScrollView r13 = this.n;
        if (r13 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("nestedScrollView");
    L41:
        r13.addOnLayoutChangeListener(new c(this, r6));
        return;
    }
}
