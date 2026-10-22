package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.core.anchorv3.PdpPerfOpt;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.action.n;
import com.bytedance.android.ecom.arch.slice.p;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.dto.meta.PageMeta;
import com.bytedance.android.shopping.anchorv4.topnav.AnchorV4TopNavComponent;
import com.bytedance.android.shopping.anchorv4.topnav.Config;
import com.bytedance.android.shopping.anchorv4.topnav.TopNavVO;
import com.bytedance.android.shopping.anchorv4.topnav.TransitionNode;
import com.bytedance.android.shopping.anchorv4.voavhs.ComponentIDs;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent;
import com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.l;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.m;
import com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataStore;
import com.bytedance.android.shopping.prepurchase.business.pdp.services.event.ProductDetailEventService;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.google.gson.internal.LinkedTreeMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import vg3.d0;
import vg3.e0;
import vg3.i0;
import vg3.n0;
import vg3.s;
import vg3.w;
import vg3.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class TopNavigationComponentV2 extends m implements l, i0 {
    public static final /* synthetic */ int A = 0;
    public TopNavVO m;
    public final ComponentIDs n;
    public Float o;
    public int p;
    public final com.bytedance.android.shopping.prepurchase.arch.container.state.d<n0> q;
    public List<com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.g> r;
    public com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.g s;
    public final IdentityHashMap<com.bytedance.android.ecom.arch.slice.g, com.bytedance.android.ecom.arch.slice.h> t;
    public boolean u;
    public final Map<String, Object> v;
    public boolean w;
    public a x;
    public final b y;
    public com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.e z;

    public static final class a extends com.bytedance.android.shopping.prepurchase.arch.container.ability.b {
        public final /* synthetic */ TopNavigationComponentV2 c;
        public final /* synthetic */ TopNavVO d;

        @Override // java.lang.Runnable
        public final void run() {
            this.c.i2(this.d);
        }

        public a(TopNavigationComponentV2 r1, TopNavVO r2) {
            this.c = r1;
            this.d = r2;
            super("bind_top_nav");
        }
    }

    public static final class b implements j73.g {
        public final /* synthetic */ TopNavigationComponentV2 a;

        public final void h(List<String> r2) {
            Intrinsics.checkNotNullParameter(r2, "extraElementId");
        }

        public final Boolean i() {
            return null;
        }

        public final Boolean d() {
            TopNavVO r0 = this.a.m;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.isDisplayShareTouchPoint();
        }

        public final Pair<com.bytedance.android.shopping.anchorv3.i, com.bytedance.android.shopping.anchorv3.widget.f> r0() {
            com.bytedance.android.shopping.anchorv3.i r1 = (com.bytedance.android.shopping.anchorv3.i) ((com.bytedance.android.shopping.prepurchase.arch.container.state.e) this.a.O1().d().getData().j.getValue()).a();
            CommonMeta r2 = this.a.O1().d().getData().a().a();
            boolean r3 = true;
            Map r4 = null;
            if (r2 == null) goto L8;
            if (r2.getProductDeleted() != true) goto L8;
        L32:
            return new Pair(r1, r4);
        L8:
            if (r2 == null) goto L10;
            Boolean r7 = Boolean.valueOf(r2.isLuban());
        L11:
            if (r2 == null) goto L13;
            Boolean r8 = Boolean.valueOf(r2.getThirdParty());
        L14:
            if (r2 == null) goto L16;
            String r9 = r2.getProductId();
        L17:
            Boolean r6 = ((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(this.a.O1())).b.d.a();
            if (r6 == null) goto L20;
            r3 = r6.booleanValue();
        L20:
            Boolean r10 = Boolean.valueOf(r3);
            if (r2 == null) goto L23;
            String r11 = r2.getSourcePage();
        L25:
            if (r2 == null) goto L27;
            String r14 = r2.getSearchPageSchema();
        L28:
            if (r2 == null) goto L30;
            r4 = r2.getSearchPageParams();
        L30:
            r4 = new com.bytedance.android.shopping.anchorv3.widget.f(r7, r8, r9, r10, r11, null, null, r14, r4, 224);
            goto L32
        L27:
            r14 = null;
            goto L28
        L23:
            r11 = null;
            goto L25
        L16:
            r9 = null;
            goto L17
        L13:
            r8 = null;
            goto L14
        L10:
            r7 = null;
            goto L11
        }

        public final boolean u() {
            Object r0 = this.a.v.get("collected");
            if ((r0 instanceof Boolean) == true) goto L6;
            r0 = null;
        L6:
            return Intrinsics.areEqual((Boolean) r0, Boolean.TRUE);
        }

        public b(TopNavigationComponentV2 r1) {
            this.a = r1;
        }

        public final void C(String r3) {
            Intrinsics.checkNotNullParameter(r3, "groupId");
            this.a.p2(r3, true);
        }

        public final void N(int r8) {
            TopNavigationComponentV2 r0 = this.a;
            TopNavVO r1 = r0.m;
            if (r1 == null) goto L7;
            com.bytedance.android.ecom.arch.slice.g r2 = r1.getTopSlice();
            if (r2 == null) goto L7;
            String r3 = r2.getSliceId();
        L9:
            if (TextUtils.equals(r3, "supermarket_pop_top_nav") == false) goto L42;
            TopNavVO r4 = r0.m;
            if (r4 == null) goto L24;
            com.bytedance.android.ecom.arch.slice.g r5 = r4.getTopSlice();
            if (r5 == null) goto L24;
            Map r6 = r5.getData();
            if (r6 == null) goto L24;
            Object r7 = r6.get("cart_num");
            if (r7 == null) goto L24;
            String r9 = r7.toString();
            if (r9 == null) goto L24;
            Double r10 = StringsKt.toDoubleOrNull(r9);
            if (r10 == null) goto L24;
            int r11 = (int) r10.doubleValue();
        L25:
            if (r8 == r11) goto L43;
            LinkedHashMap r12 = new LinkedHashMap();
            if (r11 != 0) goto L31;
            if (r8 <= 0) goto L31;
            int r13 = 1;
        L35:
            r12.put("cart_num", Integer.valueOf(r8));
            r12.put("animation_type", Integer.valueOf(r13));
            TopNavVO r14 = r0.m;
            if (r14 == null) goto L40;
            com.bytedance.android.ecom.arch.slice.g r15 = r14.getTopSlice();
            if (r15 == null) goto L40;
            com.bytedance.android.ecom.arch.slice.g.a.a(r15, r12, false, 6);
        L40:
            r0.h2(null);
            return;
        L31:
            if (r11 <= 0) goto L34;
            if (r8 != 0) goto L34;
            r13 = 2;
        L34:
            r13 = 0;
            goto L35
        L43:
            return;
        L24:
            r11 = 0;
            goto L25
        L42:
            return;
        L7:
            r3 = null;
            goto L9
        }

        public final void s(boolean r10) {
            TopNavigationComponentV2 r0 = this.a;
            boolean r1 = true;
            r0.u = true;
            r0.v.put("collected", Boolean.valueOf(r10));
            View r2 = null;
            this.a.h2(null);
            com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.e r3 = this.a.z;
            if (r3 == null) goto L29;
            FrameLayout r4 = r3.b;
            if (r4 != null) goto L7;
        L15:
            View r5 = null;
        L17:
            if ((r5 instanceof ECDraweeView) == false) goto L20;
            r2 = r5;
        L20:
            ECDraweeView r6 = (ECDraweeView) r2;
            if (r6 == null) goto L30;
            if (r10 == false) goto L24;
            String r11 = r3.d;
        L25:
            String r7 = r11;
            if (r7 == null) goto L31;
            h0.e(r6, r7, null, null, null, 120);
            return;
        L31:
            return;
        L24:
            r11 = r3.c;
            goto L25
        L30:
            return;
        L7:
            if (r4.getChildCount() > 0) goto L10;
            r1 = false;
        L10:
            if (r1 == true) goto L13;
            r4 = null;
        L13:
            if (r4 == null) goto L15;
            r5 = r4.getChildAt(0);
            goto L17
        }
    }

    public static final class c implements View.OnLayoutChangeListener {
        public final /* synthetic */ TopNavigationComponentV2 a;
        public final /* synthetic */ Function1 b;

        public c(TopNavigationComponentV2 r1, Function1 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            r1.removeOnLayoutChangeListener(this);
            this.b.invoke(new Rect(this.a.e2().getLeft(), this.a.e2().getTop(), this.a.e2().getRight(), this.a.e2().getBottom()));
        }
    }

    public static final class d<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
        public final /* synthetic */ TopNavigationComponentV2 a;

        public d(TopNavigationComponentV2 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r5) {
            TopNavVO r6 = (TopNavVO) r5;
            if (r6 == null) goto L23;
            y r0 = (y) this.a.N1(y.class);
            if (r0 == null) goto L10;
            com.bytedance.android.shopping.anchorv4.perf.monitor.c r1 = r0.V();
            if (r1 == null) goto L10;
            r1.h();
        L10:
            this.a.h2(r6);
            TopNavigationComponentV2 r2 = this.a;
            r2.getClass();
            final com.bytedance.android.ecom.arch.slice.g r3 = r6.getTopSlice();
            if (r3 == null) goto L13;
            r2.n2(r3);
            r2.O1().e().r().p("top_nav", new TopNavigationComponentV2$addExtraSlices$1$1(r3));
        L13:
            TopNavigationComponentV2 r4 = this.a;
            if (r4.w == true) goto L16;
            r4.w = true;
            r4.O1().b().n0(new TopNavigationComponentV2$processShareButton$1(r4, r6));
        L16:
            if (r0 == null) goto L21;
            com.bytedance.android.shopping.anchorv4.perf.monitor.c r7 = r0.V();
            if (r7 == null) goto L22;
            r7.i();
            return;
        L22:
            return;
        L21:
            return;
        }
    }

    public static final class e<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
        public final /* synthetic */ TopNavigationComponentV2 a;

        public e(TopNavigationComponentV2 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r5) {
            com.bytedance.android.shopping.anchorv4.vm.a r6 = (com.bytedance.android.shopping.anchorv4.vm.a) r5;
            if (r6 != null) goto L5;
        L7:
            boolean r7 = false;
        L9:
            if ((true ^ Intrinsics.areEqual(Boolean.valueOf(r7), this.a.v.get("collapsed"))) == false) goto L12;
            this.a.v.put("collapsed", Boolean.valueOf(r7));
            this.a.h2(null);
            return;
        L12:
            return;
        L5:
            if (r6.a != true) goto L7;
            r7 = true;
            goto L9
        }
    }

    public static final class f<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
        public final /* synthetic */ TopNavigationComponentV2 a;

        public f(TopNavigationComponentV2 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r8) {
            com.bytedance.android.shopping.anchorv3.i r9 = (com.bytedance.android.shopping.anchorv3.i) r8;
            if (r9 == null) goto L28;
            this.a.v.put("search_key", r9.a);
            CommonMeta r1 = null;
            this.a.h2(null);
            TopNavigationComponentV2 r0 = this.a;
            PageMeta r2 = (PageMeta) r0.O1().d().getData().b.a();
            if (r2 == null) goto L7;
            r1 = r2.getCommonMeta();
        L7:
            if (r1 == null) goto L29;
            String r3 = r1.getProductId();
            if (r3 == null) goto L34;
            LinkedTreeMap r4 = r2.getTrackMeta();
            if (r4 == null) goto L17;
            Object r5 = r4.get(PdpOpenThirdParam.KEY_PAGE_NAME);
            if (r5 == null) goto L17;
            String r6 = r5.toString();
            if (r6 == null) goto L17;
        L18:
            String r7 = r6 + "_" + r1.getSourcePage();
            if (Intrinsics.areEqual(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(r0.O1())).b.d.a(), Boolean.TRUE) == false) goto L30;
            w r10 = (w) r0.N1(w.class);
            if (r10 == null) goto L31;
            ProductDetailEventService.b r11 = r10.m();
            if (r11 == null) goto L32;
            com.bytedance.android.shopping.prepurchase.arch.container.ability.m r12 = r11.d(MapsKt.mapOf(new Pair[]{TuplesKt.to("words_source", "search_bar_outer"), TuplesKt.to("words_content", r9.a), TuplesKt.to("impr_id", r9.c), TuplesKt.to(SimilarProductParam.ENTER_FROM, "search_product_detail"), TuplesKt.to("enter_from_second", r7), TuplesKt.to("group_id", r9.b), TuplesKt.to("from_gid", r3), TuplesKt.to("enter_group_id", r3)}));
            if (r12 == null) goto L33;
            com.bytedance.android.shopping.prepurchase.arch.container.ability.m.a.a(r12, "trending_words_show", false, null, null, 12);
            return;
        L33:
            return;
        L32:
            return;
        L31:
            return;
        L30:
            return;
        L17:
            r6 = "";
            goto L18
        L34:
            return;
        L29:
            return;
        }
    }

    public static final class g<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
        public final /* synthetic */ TopNavigationComponentV2 a;

        public g(TopNavigationComponentV2 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r2) {
            float r3 = ((Number) r2).floatValue();
            this.a.m2(r3);
        }
    }

    public static final class h<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
        public final /* synthetic */ TopNavigationComponentV2 a;

        public h(TopNavigationComponentV2 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r3) {
            n0 r4 = (n0) r3;
            Intrinsics.checkNotNullParameter(r4, "it");
            if (r4.c == false) goto L8;
            d0 r0 = (d0) this.a.N1(d0.class);
            if (r0 == null) goto L9;
            r0.scrollTo(r4.b);
            return;
        L9:
            return;
        }
    }

    public static final class i extends com.bytedance.android.shopping.prepurchase.arch.container.ability.b {
        public final /* synthetic */ TopNavigationComponentV2 c;

        @Override // java.lang.Runnable
        public final void run() {
            this.c.o2();
        }

        public i(TopNavigationComponentV2 r1) {
            this.c = r1;
            super("top_nav_show_action");
        }
    }

    public static final class j implements com.bytedance.android.ecom.arch.slice.h {
        public final /* synthetic */ TopNavigationComponentV2 a;

        public j(TopNavigationComponentV2 r1) {
            this.a = r1;
        }

        public final void f1(boolean r2) {
            this.a.h2(null);
        }
    }

    public static float k2(float r1) {
        if (r1 > 0) goto L7;
        return 0.0f;
    L7:
        if (r1 < 1) goto L10;
        return 1.0f;
    L10:
        return 0.5f;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final List<Class<?>> M1() {
        return CollectionsKt.listOf(new Class[]{d0.class, vg3.l.class, w.class, w.class, e0.class, s.class});
    }

    @Override // vg3.i0
    public final void h(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "extraElementId");
    }

    @Override // vg3.i0
    public final Boolean i() {
        return null;
    }

    @Override // vg3.i0
    public final View N() {
        IAction r2 = null;
        if (this.z != null) goto L11;
        Context r4 = e2().getContext();
        TopNavVO r3 = this.m;
        if (r3 == null) goto L9;
        com.bytedance.android.ecom.arch.slice.g r5 = r3.getTopSlice();
        if (r5 == null) goto L9;
        Map r6 = r5.getData();
    L10:
        this.z = new com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.e(r4, r6, Boolean.valueOf(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).b.a), new TopNavigationComponentV2$provideTopRightViews$1(this), new TopNavigationComponentV2$provideTopRightViews$2(this));
    L9:
        r6 = null;
    L11:
        com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.e r1 = this.z;
        if (r1 == null) goto L58;
        LinearLayout r7 = r1.a;
        if (r7 != null) goto L16;
    L17:
        int r8 = com.bytedance.android.shopping.utils.y.a;
        float r9 = com.bytedance.android.shopping.extensions.b.d(Integer.valueOf(com.bytedance.android.shopping.utils.y.e(null, r1.g, 1))) / 390.0f;
        int r10 = com.bytedance.android.shopping.extensions.b.a(Float.valueOf(30 * r9));
        int r11 = com.bytedance.android.shopping.extensions.b.a(Float.valueOf(38 * r9));
        Context r12 = r1.e;
        int r13 = AnchorV4TopNavComponent.q;
        List r14 = AnchorV4TopNavComponent.b.a(r1.f);
        if (r14 == null) goto L66;
        Iterator r15 = r14.iterator();
    L21:
        if (r15.hasNext() == false) goto L66;
        Map r16 = (Map) r15.next();
        if (Intrinsics.areEqual(r16.get("show_in_comment"), Boolean.TRUE) == false) goto L56;
        Object r17 = r16.get("btn_id");
        if ((r17 instanceof String) == true) goto L27;
        r17 = r2;
    L27:
        String r18 = (String) r17;
        Object r19 = r16.get("black_icon");
        if ((r19 instanceof String) == true) goto L30;
        r19 = r2;
    L30:
        String r20 = (String) r19;
        Object r21 = r16.get("collected_black_icon");
        if ((r21 instanceof String) == true) goto L33;
        r21 = r2;
    L33:
        String r22 = (String) r21;
        Object r23 = r16.get("click_action");
        if (r23 == null) goto L36;
        IAction r110 = n.a(r23);
    L37:
        if (r20 == null) goto L56;
        if (r110 == null) goto L56;
        if (Intrinsics.areEqual(r18, "collect_btn") == false) goto L45;
        r1.c = r20;
        r1.d = r22;
        if (((Boolean) r1.h.invoke()).booleanValue() == false) goto L45;
        if (r22 == null) goto L45;
        String r111 = r22;
    L47:
        if (r1.a != null) goto L50;
        LinearLayout r24 = new LinearLayout(r1.e);
        r24.setOrientation(0);
        r24.setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
        r24.setGravity(16);
        Unit r25 = Unit.INSTANCE;
        r1.a = r24;
    L50:
        FrameLayout r112 = new FrameLayout(r12);
        ECDraweeView r26 = new ECDraweeView(r12, null, 0, 6, null);
        h0.e(r26, r111, null, null, null, 120);
        FrameLayout.LayoutParams r27 = new FrameLayout.LayoutParams(r10, r10);
        r27.gravity = 17;
        Unit r28 = Unit.INSTANCE;
        r26.setLayoutParams(r27);
        r112.addView(r26);
        r112.setOnClickListener(new com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.d(r112, r110, r1));
        LinearLayout r29 = r1.a;
        if (r29 == null) goto L54;
        r29.addView(r112, r11, r11);
    L54:
        if (Intrinsics.areEqual(r18, "collect_btn") == false) goto L56;
        r1.b = r112;
    L45:
        r111 = r20;
        goto L47
    L36:
        r110 = r2;
    L56:
        r2 = null;
    L66:
        return r1.a;
    L16:
        if (r7.getChildCount() != 0) goto L66;
    L58:
        return null;
    }

    @Override // vg3.i0
    public final void R0() {
        this.v.put("cart_animating", Boolean.TRUE);
        h2(null);
        this.v.put("cart_animating", Boolean.FALSE);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.l
    public final void b1() {
        Float r0 = this.o;
        if (r0 == null) goto L5;
        m2(r0.floatValue());
    L5:
        l2(this.p);
        if (PdpPerfOpt.b().e() == false) goto L8;
        O1().b().e1(new i(this));
        return;
    L8:
        o2();
    }

    public final void j2() {
        Iterator<T> r0 = this.t.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.android.ecom.arch.slice.g) r0.next()).setSliceRebindTarget(null);
        goto L4
    L6:
        this.t.clear();
    }

    public final void o2() {
        TopNavVO r0 = this.m;
        if (r0 == null) goto L7;
        com.bytedance.android.ecom.arch.slice.g r1 = r0.getTopSlice();
        if (r1 == null) goto L7;
        IAction r2 = r1.getShowAction();
    L8:
        View r3 = e2();
        if (r2 == null) goto L13;
        if (r3 == null) goto L14;
        O1().e().r().O0(null, r2, r3, null);
        return;
    L14:
        return;
    L13:
        return;
    L7:
        r2 = null;
        goto L8
    }

    public TopNavigationComponentV2() {
        this.n = ComponentIDs.HEAD_SLIDES;
        this.q = new com.bytedance.android.shopping.prepurchase.arch.container.state.d();
        this.t = new IdentityHashMap();
        Boolean r1 = Boolean.FALSE;
        this.v = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("collapsed", r1), TuplesKt.to("current_tab_index", 0), TuplesKt.to("closed_sku", r1), TuplesKt.to("collected", r1), TuplesKt.to("is_android", Boolean.TRUE), TuplesKt.to("tab_visible", r1), TuplesKt.to("scroll_fraction", Float.valueOf(0.0f))});
        this.y = new b(this);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void T1() {
        super.T1();
        float r1 = 0.0f;
        if (((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).a.getNativeParams().getFullMode() == true) goto L5;
        this.o = Float.valueOf(0.0f);
    L5:
        Map<String, Object> r0 = this.v;
        r0.put("current_group_id", this.n);
        if (((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).a.getNativeParams().getFullMode() == false) goto L8;
        r1 = 1.0f;
    L8:
        r0.put("trans_fraction", Float.valueOf(r1));
        FragmentActivity r2 = O1().getContainerAbility().mo2525getContext();
        boolean r3 = ((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).b.a;
        if (r2 == null) goto L13;
        com.bytedance.android.shopping.anchorv4.helper.w.b.getClass();
        if (com.bytedance.android.shopping.anchorv4.helper.w.a.b(r2, r3) == false) goto L13;
        int r4 = com.bytedance.android.shopping.extensions.b.e(Integer.valueOf(com.bytedance.android.shopping.utils.d0.a()));
        r0.put("status_bar_height", Integer.valueOf(r4 + 6));
        float r5 = r4;
        r0.put("status_bar_scale_height", Float.valueOf(r5 + (28 - (22 * O1().e().r().b1()))));
    L13:
        com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.g r6 = this.s;
        if (r6 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("sliceView");
    L16:
        r6.setOnViewReadyCallback(this);
        AbsComponent.Y1(this, i0.class, this, false, 12);
        PdpDataStore r7 = O1().d().getData();
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a((com.bytedance.android.shopping.prepurchase.arch.container.state.e) r7.e.getValue(), this, new d(this));
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a((com.bytedance.android.shopping.prepurchase.arch.container.state.e) r7.f.getValue(), this, new e(this));
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a((com.bytedance.android.shopping.prepurchase.arch.container.state.e) r7.j.getValue(), this, new f(this));
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).b.c, this, new g(this));
        Z1(d0.class, new TopNavigationComponentV2$onAttach$5(this, null));
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(this.q, this, new h(this));
        Z1(e0.class, new TopNavigationComponentV2$onAttach$7(this, null));
        Z1(s.class, new TopNavigationComponentV2$onAttach$8(this, null));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void U1() {
        j2();
        super.U1();
    }

    @Override // vg3.i0
    public final Rect a1() {
        View r0 = e2();
        return new Rect(r0.getLeft(), r0.getTop(), r0.getLeft() + r0.getWidth(), r0.getTop() + r0.getHeight());
    }

    @Override // vg3.i0
    public final View getContentView() {
        return e2();
    }

    @Override // vg3.i0
    public final j73.g b() {
        return this.y;
    }

    @Override // vg3.i0
    public final com.bytedance.android.shopping.prepurchase.arch.container.state.d q1() {
        return this.q;
    }

    @Override // vg3.i0
    public final com.bytedance.android.shopping.prepurchase.business.pdp.view.i H(String r3) {
        Intrinsics.checkNotNullParameter(r3, "sliceKey");
        com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.g r0 = this.s;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("sliceView");
    L5:
        View r4 = r0.a(r3);
        if (r4 != null) goto L10;
        return null;
    L10:
        return new com.bytedance.android.shopping.prepurchase.business.pdp.view.n(r4);
    }

    @Override // vg3.i0
    public final View K(String r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.g r0 = this.s;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("sliceView");
    L6:
        return r0.a(r3);
    }

    public final void h2(TopNavVO r3) {
        if (PdpPerfOpt.b().m(1) == true) goto L5;
    L10:
        i2(r3);
        return;
    L5:
        if (g2().getNativeParams().getFullMode() == true) goto L10;
        a r0 = this.x;
        if (r0 == null) goto L9;
        r0.a.set(true);
    L9:
        a r1 = new a(this, r3);
        O1().b().e1(r1);
        Unit r4 = Unit.INSTANCE;
        this.x = r1;
    }

    public final void i2(TopNavVO r8) {
        PdpDataStore r0 = O1().d().getData();
        boolean r1 = false;
        if (r8 != null) goto L5;
    L7:
        boolean r3 = false;
    L9:
        if (r8 == null) goto L24;
        TopNavVO r5 = this.m;
        if (r5 == null) goto L23;
        com.bytedance.android.ecom.arch.slice.g r6 = r5.getTopSlice();
        if (r6 == null) goto L23;
        if (r6 == r8.getTopSlice()) goto L17;
        boolean r7 = true;
    L18:
        if (r7 == true) goto L21;
        r6 = null;
    L21:
        if (r6 == null) goto L23;
        j2();
        goto L23
    L17:
        r7 = false;
    L23:
        this.m = r8;
    L24:
        TopNavVO r9 = this.m;
        if (r9 == null) goto L29;
        com.bytedance.android.ecom.arch.slice.g r10 = r9.getTopSlice();
        if (r10 == null) goto L29;
        n2(r10);
    L29:
        if (r3 == false) goto L38;
        com.bytedance.android.shopping.anchorv4.vm.a r11 = (com.bytedance.android.shopping.anchorv4.vm.a) ((com.bytedance.android.shopping.prepurchase.arch.container.state.e) r0.f.getValue()).a();
        Map<String, Object> r4 = this.v;
        if (r11 != null) goto L33;
    L35:
        boolean r12 = false;
    L36:
        r4.put("collapsed", Boolean.valueOf(r12));
        goto L38
    L33:
        if (r11.a != true) goto L35;
        r12 = true;
    L38:
        if (this.u == true) goto L45;
        Map<String, Object> r13 = this.v;
        CommonMeta r2 = r0.a().a();
        if (r2 != null) goto L42;
    L44:
        r13.put("collected", Boolean.valueOf(r1));
        goto L45
    L42:
        if (r2.isCollected() != true) goto L44;
        r1 = true;
    L45:
        Map<String, ? extends Object> r14 = MapsKt.mapOf(TuplesKt.to("native", this.v));
        com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.g r15 = this.s;
        if (r15 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("sliceView");
    L48:
        TopNavVO r16 = this.m;
        if (r16 == null) goto L51;
        com.bytedance.android.ecom.arch.slice.g r17 = r16.getTopSlice();
    L52:
        r15.b(r17, r14, null);
        return;
    L51:
        r17 = null;
        goto L52
    L5:
        if (this.m != null) goto L7;
        r3 = true;
        goto L9
    }

    @Override // vg3.i0
    public final void j0(View r6) {
        Intrinsics.checkNotNullParameter(r6, FreqActions.ACTION_VIEW);
        TopNavVO r0 = this.m;
        if (r0 == null) goto L7;
        com.bytedance.android.ecom.arch.slice.g r1 = r0.getTopSlice();
        if (r1 == null) goto L7;
        Map r2 = r1.getData();
    L8:
        if (r2 == null) goto L10;
        Object r3 = r2.get("nav");
    L12:
        if ((r3 instanceof Map) == true) goto L14;
        r3 = null;
    L14:
        Map r4 = (Map) r3;
        if (r4 == null) goto L17;
        Object r5 = r4.get("right_btns");
    L19:
        if ((r5 instanceof List) == true) goto L21;
        r5 = null;
    L21:
        List r7 = (List) r5;
        if (r7 == null) goto L45;
        Iterator r8 = r7.iterator();
    L25:
        if (r8.hasNext() == false) goto L32;
        Object r9 = r8.next();
        Object r10 = ((Map) r9).get("btn_id");
        if ((r10 instanceof String) == true) goto L30;
        r10 = null;
    L30:
        if (Intrinsics.areEqual((String) r10, "share_btn") == false) goto L25;
    L33:
        Map r11 = (Map) r9;
        if (r11 == null) goto L46;
        Object r12 = r11.get("click_action");
        if (r12 == null) goto L38;
        IAction r13 = n.a(r12);
    L39:
        if (r13 == null) goto L47;
        O1().e().r().O0(null, r13, r6, MapsKt.mapOf(TuplesKt.to("location", "gallery")));
        return;
    L47:
        return;
    L38:
        r13 = null;
        goto L39
    L46:
        return;
    L32:
        r9 = null;
        goto L33
    L45:
        return;
    L17:
        r5 = null;
        goto L19
    L10:
        r3 = null;
    L7:
        r2 = null;
        goto L8
    }

    public final void l2(int r12) {
        this.p = r12;
        float r0 = r12;
        vg3.l r1 = (vg3.l) N1(vg3.l.class);
        float r2 = 0.0f;
        if (r1 == null) goto L5;
        float r3 = r1.B1();
    L6:
        float r4 = r0 / r3;
        TopNavVO r5 = this.m;
        if (r5 == null) goto L11;
        Config r6 = r5.getConfig();
        if (r6 == null) goto L11;
        List<TransitionNode> r7 = r6.getScrollNodes();
    L12:
        q2(r7, r4);
        TopNavVO r8 = this.m;
        if (r8 == null) goto L17;
        Config r9 = r8.getConfig();
        if (r9 == null) goto L17;
        List r10 = r9.getSpecialScrollNodes();
    L19:
        if (r10 == null) goto L38;
        Iterator r11 = r10.iterator();
    L22:
        if (r11.hasNext() == false) goto L38;
        TransitionNode r13 = (TransitionNode) r11.next();
        com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.g r14 = this.s;
        if (r14 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("sliceView");
    L26:
        View r15 = r14.a(r13.getSliceKey());
        if (r15 == null) goto L22;
        if (r12 < com.bytedance.android.shopping.extensions.b.b(Float.valueOf(r13.getStartEdge()))) goto L34;
        if (r12 > com.bytedance.android.shopping.extensions.b.b(Float.valueOf(r13.getEndEdge()))) goto L34;
        float r16 = (r0 - com.bytedance.android.shopping.extensions.b.b(Float.valueOf(r13.getStartEdge()))) / (com.bytedance.android.shopping.extensions.b.b(Float.valueOf(r13.getEndEdge())) - com.bytedance.android.shopping.extensions.b.b(Float.valueOf(r13.getStartEdge())));
    L37:
        r15.setAlpha(r16);
    L34:
        if (r12 >= com.bytedance.android.shopping.extensions.b.b(Float.valueOf(r13.getStartEdge()))) goto L36;
        r16 = 0.0f;
        goto L37
    L36:
        com.bytedance.android.shopping.extensions.b.b(Float.valueOf(r13.getEndEdge()));
        r16 = 1.0f;
    L38:
        com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.g r17 = this.s;
        if (r17 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("sliceView");
    L41:
        View r18 = r17.a("tab_bar");
        boolean r19 = true;
        if (r18 != null) goto L44;
    L50:
        boolean r110 = false;
    L51:
        float r20 = k2(r4);
        Object r21 = this.v.get("scroll_fraction");
        if ((r21 instanceof Float) == true) goto L54;
        r21 = null;
    L54:
        Float r22 = (Float) r21;
        if (r22 == null) goto L57;
        float r23 = r22.floatValue();
    L59:
        if (r20 == k2(r23)) goto L68;
        Map<String, Object> r111 = this.v;
        if (r4 > 0) goto L64;
    L67:
        r111.put("scroll_fraction", Float.valueOf(r2));
    L69:
        if (r19 == false) goto L77;
        h2(null);
        return;
    L77:
        return;
    L64:
        if (r4 < 1) goto L66;
        r2 = 1.0f;
        goto L67
    L66:
        r2 = r4;
        goto L67
    L68:
        r19 = r110;
        goto L69
    L57:
        r23 = 0.0f;
        goto L59
    L44:
        if (r18.getAlpha() <= 0) goto L46;
        boolean r112 = true;
    L48:
        if ((!Intrinsics.areEqual(Boolean.valueOf(r112), this.v.get("tab_visible"))) == false) goto L50;
        this.v.put("tab_visible", Boolean.valueOf(r112));
        r110 = true;
        goto L51
    L46:
        r112 = false;
    L17:
        r10 = null;
    L11:
        r7 = null;
        goto L12
    L5:
        r3 = 0.0f;
        goto L6
    }

    public final void m2(float r9) {
        this.o = Float.valueOf(r9);
        boolean r0 = false;
        float r1 = 0;
        if (r9 <= r1) goto L7;
        a r2 = this.x;
        if (r2 == null) goto L7;
        r2.run();
    L7:
        TopNavVO r3 = this.m;
        if (r3 == null) goto L12;
        Config r4 = r3.getConfig();
        if (r4 == null) goto L12;
        List<TransitionNode> r5 = r4.getTransitionNodes();
    L13:
        q2(r5, r9);
        com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.g r6 = this.s;
        if (r6 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("sliceView");
    L17:
        if (r9 != 0.0f) goto L19;
        r0 = true;
    L19:
        r6.setDisableTouchEvent(r0);
        float r7 = k2(r9);
        Object r8 = this.v.get("trans_fraction");
        if ((r8 instanceof Float) == true) goto L22;
        r8 = null;
    L22:
        Float r10 = (Float) r8;
        if (r10 == null) goto L25;
        float r11 = r10.floatValue();
    L27:
        if (r7 == k2(r11)) goto L36;
        Map<String, Object> r12 = this.v;
        if (r9 > r1) goto L32;
        r9 = 0.0f;
    L34:
        r12.put("trans_fraction", Float.valueOf(r9));
        h2(null);
        return;
    L32:
        if (r9 < 1) goto L34;
        r9 = 1.0f;
        goto L34
    L36:
        return;
    L25:
        r11 = 0.0f;
    L12:
        r5 = null;
        goto L13
    }

    public final void n2(com.bytedance.android.ecom.arch.slice.g r3) {
        if (this.t.containsKey(r3) == false) goto L5;
        return;
    L5:
        j r0 = new j(this);
        r3.setSliceRebindTarget(r0);
        this.t.put(r3, r0);
        if ((r3 instanceof p) == false) goto L13;
        List r4 = ((p) r3).a();
        if (r4 == null) goto L15;
        Iterator r5 = r4.iterator();
    L11:
        if (r5.hasNext() == false) goto L16;
        n2((com.bytedance.android.ecom.arch.slice.g) r5.next());
        goto L11
    L16:
        return;
    L15:
        return;
    }

    @Override // vg3.i0
    public final void r1(Function1<? super Rect, Unit> r6) {
        Intrinsics.checkNotNullParameter(r6, "function");
        View r0 = e2();
        if (ViewCompat.isLaidOut(r0) == true) goto L5;
    L7:
        r0.addOnLayoutChangeListener(new c(this, r6));
        return;
    L5:
        if (r0.isLayoutRequested() == true) goto L7;
        r6.invoke(new Rect(e2().getLeft(), e2().getTop(), e2().getRight(), e2().getBottom()));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.Component
    public final View c2(LayoutInflater r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        Intrinsics.checkNotNullParameter(r3, "container");
        com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.c r4 = O1().e().r().l0();
        this.s = r4;
        r4.setId(2131389191);
        return r4;
    }

    public final void p2(String r8, boolean r9) {
        com.bytedance.android.shopping.prepurchase.arch.container.component.b.a(this, "trySelectTab " + r8 + ' ' + r9 + " lastIs=" + this.v + "[KEY_SLC_CUR_GROUP_ID]");
        if (Intrinsics.areEqual(this.v.get("current_group_id"), r8) == false) goto L5;
        return;
    L5:
        boolean r0 = Intrinsics.areEqual(this.v.get("collapsed"), Boolean.TRUE);
        if (this.r != null) goto L12;
        TopNavVO r2 = this.m;
        if (r2 == null) goto L10;
        List<com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.g> r3 = r2.getTabList();
    L11:
        this.r = r3;
        goto L12
    L10:
        r3 = null;
    L12:
        List<com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.g> r4 = this.r;
        if (r4 == null) goto L24;
        Iterator<T> r5 = r4.iterator();
        int r6 = 0;
    L16:
        if (r5.hasNext() == false) goto L24;
        com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.g r7 = (com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.g) r5.next();
        if (Intrinsics.areEqual(r7.a, r8) == true) goto L25;
        if (r0 == false) goto L23;
        if (Intrinsics.areEqual(r7.b, Boolean.TRUE) == false) goto L16;
    L23:
        r6 = r6 + 1;
    L25:
        if (r6 >= 0) goto L27;
        return;
    L27:
        this.v.put("current_group_id", r8);
        this.v.put("current_tab_index", Integer.valueOf(r6));
        h2(null);
        this.q.g(new n0(r6, r8, r9));
        return;
    L24:
        r6 = -1;
        goto L25
    }

    public final void q2(List<TransitionNode> r6, float r7) {
        if (r6 == null) goto L25;
        Iterator<T> r8 = r6.iterator();
    L5:
        if (r8.hasNext() == false) goto L34;
        TransitionNode r0 = (TransitionNode) r8.next();
        com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.g r1 = this.s;
        if (r1 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("sliceView");
    L9:
        View r2 = r1.a(r0.getSliceKey());
        if (r2 == null) goto L5;
        if ((r0.getEnd() - r0.getStart()) > 0) goto L15;
        float r3 = r7;
    L22:
        if (r0.getReverse() == true) goto L23;
        r2.setAlpha(r3);
        goto L5
    L23:
        r2.setAlpha(1 - r3);
        goto L5
    L15:
        if (r7 >= r0.getStart()) goto L18;
        r3 = 0.0f;
        goto L22
    L18:
        if (r7 <= r0.getEnd()) goto L20;
        r3 = 1.0f;
        goto L22
    L20:
        r3 = (r7 - r0.getStart()) / (r0.getEnd() - r0.getStart());
        goto L22
    L34:
        return;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.Component
    public final void b2(ViewGroup r3, ViewGroup.LayoutParams r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "parentView");
        if (r4 != null) goto L5;
        super.b2(r3, new ViewGroup.LayoutParams(-1, -2), r5);
        return;
    L5:
        super.b2(r3, r4, r5);
    }
}
