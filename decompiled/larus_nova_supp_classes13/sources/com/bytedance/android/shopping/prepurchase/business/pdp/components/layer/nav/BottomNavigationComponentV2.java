package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.model.sku.CartNumWithBusinessLine;
import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.shopping.anchorv4.bottom.AddCartMeta;
import com.bytedance.android.shopping.anchorv4.bottom.BottomButtonMeta;
import com.bytedance.android.shopping.anchorv4.bottom.BottomButtonVO;
import com.bytedance.android.shopping.anchorv4.helper.BasePdpAddCartAnimation;
import com.bytedance.android.shopping.anchorv4.helper.PdpAddCartAnimationV1;
import com.bytedance.android.shopping.anchorv4.helper.PdpAddCartAnimationV2;
import com.bytedance.android.shopping.anchorv4.helper.PdpAddCartAnimationV3;
import com.bytedance.android.shopping.anchorv4.helper.o;
import com.bytedance.android.shopping.anchorv4.helper.p;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent;
import com.bytedance.android.shopping.prepurchase.arch.container.component.ViewModel;
import com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.DynamicViewWidgetOpt;
import com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataStore;
import com.bytedance.android.shopping.prepurchase.business.pdp.view.i;
import com.bytedance.android.shopping.prepurchase.business.pdp.view.n;
import fi3.q;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;
import ti.l;
import vg3.d0;
import vg3.e0;
import vg3.f0;
import vg3.i0;
import vg3.s;
import vg3.u;
import vg3.w;
import vg3.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class BottomNavigationComponentV2 extends com.bytedance.android.shopping.prepurchase.arch.container.component.h<com.bytedance.android.shopping.prepurchase.business.pdp.e, PdpDataStore, c> implements vg3.e {
    public static final /* synthetic */ int s = 0;
    public com.bytedance.android.shopping.prepurchase.arch.container.ability.h n;
    public final PdpBottomOverlayPaddingDelegate o;
    public final Lazy p;
    public float q;
    public final b r;

    public static final class a implements View.OnLayoutChangeListener {
        public final /* synthetic */ Function2 a;

        public a(Function2 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            Rect r10 = new Rect(r2, r3, r4, r5);
            Rect r11 = new Rect(r6, r7, r8, r9);
            this.a.invoke(r10, r11);
        }
    }

    public static final class b implements j73.c {
        public final /* synthetic */ BottomNavigationComponentV2 a;

        public final int W() {
            return 2099;
        }

        public final void k(SkuRestoreState r2) {
            Intrinsics.checkNotNullParameter(r2, "state");
        }

        public final boolean k0() {
            return false;
        }

        public final BottomButtonMeta D() {
            BottomButtonVO r0 = BottomNavigationComponentV2.i2(this.a).i;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.getBottomButtonMeta();
        }

        public b(BottomNavigationComponentV2 r1) {
            this.a = r1;
        }

        public final void Y(JSONObject r4) {
            Intrinsics.checkNotNullParameter("edit_cart_combo_num", "eventName");
            com.bytedance.android.shopping.prepurchase.arch.container.ability.h r0 = this.a.n;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("dynamicView");
        L5:
            r0.a("edit_cart_combo_num", r4);
        }

        public final void s0(q r7) {
            com.bytedance.android.shopping.prepurchase.arch.container.ability.h r0 = this.a.n;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("dynamicView");
        L5:
            l r1 = r0.c();
            if (r1 == null) goto L10;
            View r2 = r1.getHybridView();
            if (r2 != null) goto L11;
            r2 = r1.b();
        L11:
            if (r2 != null) goto L13;
            return;
        L13:
            d0 r3 = (d0) this.a.N1(d0.class);
            if (r3 == null) goto L37;
            Rect r4 = r3.O();
            if (r4 == null) goto L39;
            Context r5 = r2.getContext();
            int r6 = (r4.left + r4.right) / 2;
            int r8 = ((r4.top + r4.bottom) / 2) - this.a.O1().getContainerAbility().i7().c;
            if (r5 == null) goto L38;
            PdpAddCartAnimationV2 r9 = o.a(r5);
            if (r7 == null) goto L23;
            String r10 = r7.d;
        L24:
            ((BasePdpAddCartAnimation) r9).c = r10;
            Point r11 = new Point(r6, r8);
            int r12 = p.a;
            int r13 = 0;
            if (r7 == null) goto L29;
            Integer r14 = r7.b;
            if (r14 == null) goto L29;
            int r15 = r14.intValue();
        L30:
            int r16 = com.bytedance.android.shopping.extensions.b.a(Integer.valueOf(r15));
            if (r7 == null) goto L35;
            Integer r17 = r7.c;
            if (r17 == null) goto L35;
            r13 = r17.intValue();
        L35:
            int r18 = com.bytedance.android.shopping.extensions.b.a(Integer.valueOf(r13));
            Intrinsics.checkNotNullParameter(r2, "lynxView");
            Point r19 = p.a(r2, r16, r2.getHeight() - r18);
            ((BasePdpAddCartAnimation) r9).a = r11;
            ((BasePdpAddCartAnimation) r9).b = r19;
            r9.c(null);
            return;
        L29:
            r15 = 0;
            goto L30
        L23:
            r10 = null;
            goto L24
        L38:
            return;
        L39:
            return;
        L37:
            return;
        L10:
            r2 = null;
            goto L11
        }
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final List<Class<?>> M1() {
        return CollectionsKt.listOf(new Class[]{e0.class, u.class, d0.class, f0.class, y.class, e0.class, w.class, s.class, i0.class, vg3.f.class});
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void U1() {
        com.bytedance.android.shopping.prepurchase.arch.container.ability.h r0 = this.n;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dynamicView");
    L5:
        r0.release();
        s0.e(this);
        super.U1();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.h
    public final ViewModel f2() {
        return new c();
    }

    public final View j2() {
        i0 r0 = (i0) N1(i0.class);
        if (r0 == null) goto L6;
        View r1 = r0.K("right_btn_black_cart_btn");
        if (r1 == null) goto L6;
        return r1;
    L6:
        if (r0 != null) goto L11;
        return null;
    L11:
        return r0.K("right_btn_white_cart_btn");
    }

    public BottomNavigationComponentV2() {
        this.o = new PdpBottomOverlayPaddingDelegate(new BottomNavigationComponentV2$bottomOverlayPaddingDelegate$1(this));
        this.p = LazyKt.lazy(new BottomNavigationComponentV2$toaster$2(this));
        this.r = new b(this);
    }

    @Override // vg3.e
    public final boolean Q0() {
        BottomButtonVO r0 = g2().i;
        if (r0 == null) goto L5;
        Float r1 = r0.getBottomValidHeightRatio();
    L6:
        if (r1 == null) goto L8;
        float r2 = r1.floatValue();
    L9:
        int r3 = d1();
        int r4 = O1().getContainerAbility().i7().b;
        if (r3 != 0) goto L12;
    L15:
        return true;
    L12:
        if (r3 < (r2 * r4)) goto L15;
        return false;
    L8:
        r2 = 0.5f;
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void S1() {
        super.S1();
        l2(true);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void T1() {
        super.T1();
        s0.c(this);
        c r0 = g2();
        Function1<c.a, Unit> r1 = new BottomNavigationComponentV2$initData$1(this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "function");
        r0.g = r1;
        c r2 = g2();
        Function2<String, Map<String, ? extends Object>, Unit> r3 = new BottomNavigationComponentV2$initData$2(this);
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "function");
        r2.h = r3;
        c r4 = g2();
        Function1<SlcCommonAction, Unit> r5 = new BottomNavigationComponentV2$initData$3(this);
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "function");
        r4.f = r5;
        c r6 = g2();
        com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.a r7 = new com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.a(this);
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, FreqActions.ACTION_VIEW);
        r6.e = r7;
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).b.c, this, new com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.b(this));
        AbsComponent.Y1(this, vg3.e.class, this, false, 12);
        Z1(vg3.f.class, new BottomNavigationComponentV2$observeBottomOverlayInset$1(this, null));
        com.bytedance.android.shopping.prepurchase.arch.container.ability.g.b(O1().e(), "instant_cart_list_visible_change", true, new BottomNavigationComponentV2$onAttach$1(this));
        Z1(u.class, new BottomNavigationComponentV2$onAttach$2(this, null));
        Z1(s.class, new BottomNavigationComponentV2$onAttach$3(this, null));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void V1() {
        super.V1();
        l2(false);
    }

    @Override // vg3.e
    public final int d1() {
        return e2().getHeight();
    }

    public final boolean k2() {
        BottomButtonVO r0 = (BottomButtonVO) ((com.bytedance.android.shopping.prepurchase.arch.container.state.e) O1().d().getData().l.getValue()).a();
        if (r0 == null) goto L11;
        BottomButtonMeta r1 = r0.getBottomButtonMeta();
        if (r1 == null) goto L11;
        AddCartMeta r2 = r1.getAddCartMeta();
        if (r2 == null) goto L11;
        Boolean r3 = r2.getAddCartOptimize();
        if (r3 == null) goto L11;
        return r3.booleanValue();
    L11:
        return false;
    }

    @Override // vg3.e
    public final j73.c b() {
        return this.r;
    }

    public static final /* synthetic */ c i2(BottomNavigationComponentV2 r0) {
        return r0.g2();
    }

    @Override // vg3.e
    public final i H(String r3) {
        Intrinsics.checkNotNullParameter(r3, "sliceKey");
        com.bytedance.android.shopping.prepurchase.arch.container.ability.h r0 = this.n;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dynamicView");
    L5:
        View r4 = r0.f(r3);
        if (r4 != null) goto L10;
        return null;
    L10:
        return new n(r4);
    }

    @Override // vg3.e
    public final void V0(Function2<? super Rect, ? super Rect, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "function");
        e2().addOnLayoutChangeListener(new a(r3));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void addShopCartSuccessEvent(hl.b r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        c r1 = g2();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r10, "event");
        if (r1.k == false) goto L5;
        return;
    L5:
        if (r10.o == true) goto L70;
        Integer r0 = r10.c;
        if (r0 != null) goto L11;
    L12:
        Integer r2 = r10.c;
        if (r2 != null) goto L16;
        return;
    L16:
        if (r2.intValue() != 102) goto L72;
    L18:
        AddCartMeta r3 = r1.i();
        if (r3 == null) goto L23;
        IAction r4 = r3.getAddCartAfterAction();
        if (r4 == null) goto L23;
        com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.f.a.b(r1.getContext().e().r(), null, r4, null, 8);
    L23:
        String r5 = r10.b;
        if (r5 != null) goto L28;
        if (r3 == null) goto L27;
        r5 = r3.getAddCartCover();
        goto L28
    L27:
        r5 = null;
    L28:
        if (r3 == null) goto L30;
        int r6 = r3.getAddCartAnimationStyle();
    L31:
        int r7 = r10.a;
        List r8 = r10.e;
        if (r8 == null) goto L47;
        Iterator r9 = r8.iterator();
    L35:
        if (r9.hasNext() == false) goto L47;
        CartNumWithBusinessLine r11 = (CartNumWithBusinessLine) r9.next();
        Integer r12 = r11.getCartBusinessLineId();
        if (r12 == null) goto L35;
        int r13 = r12.intValue();
        if (r13 <= 0) goto L35;
        AddCartMeta r14 = r1.i();
        if (r14 == null) goto L35;
        if (r13 != r14.getCartBusinessLineId()) goto L35;
        Integer r15 = r11.getNum();
        if (r15 == null) goto L35;
        r7 = r15.intValue();
    L47:
        if (r6 == 0) goto L53;
        if (r5 == null) goto L53;
        f r16 = r1.e;
        if (r16 == null) goto L54;
        r16.a(r5, r7, null, r10.r);
    L54:
        r1.g(r10.m);
        r1.j(r10.p, r10.q);
        return;
    L53:
        r1.m(r7);
        goto L54
    L30:
        r6 = 0;
        goto L31
    L72:
        return;
    L11:
        if (r0.intValue() == 101) goto L18;
    }

    public final void l2(boolean r5) {
        JSONObject r0 = new JSONObject();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Result.constructor-impl(r0.put("visible", r5));     // Catch: Throwable -> L5
    L7:
        Unit r2 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter("pageVisibilityChange", "eventName");
        com.bytedance.android.shopping.prepurchase.arch.container.ability.h r3 = this.n;
        if (r3 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("dynamicView");
    L10:
        r3.a("pageVisibilityChange", r0);
        if (r5 == true) goto L16;
        O1().e().D0().B("androidInstantProductDetailHide", new JSONObject());
        return;
    L16:
        return;
    L5:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void pdpAddShopCartSuccessEvent(hl.l r9) {
        Intrinsics.checkNotNullParameter(r9, "event");
        c r1 = g2();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r9, "event");
        r1.j(r9.j, r9.k);
        if (r1.k == true) goto L55;
        String r0 = r9.b;
        List r2 = r9.c;
        if (r2 == null) goto L30;
        Iterator r3 = r2.iterator();
    L9:
        if (r3.hasNext() == false) goto L24;
        Object r4 = r3.next();
        CartNumWithBusinessLine r5 = (CartNumWithBusinessLine) r4;
        Integer r6 = r5.getCartBusinessLineId();
        boolean r7 = false;
        if (r6 == null) goto L13;
        int r8 = r6.intValue();
    L14:
        if (r8 <= 0) goto L22;
        Integer r10 = r5.getCartBusinessLineId();
        AddCartMeta r11 = r1.i();
        if (r11 == null) goto L18;
        Integer r12 = Integer.valueOf(r11.getCartBusinessLineId());
    L20:
        if (Intrinsics.areEqual(r10, r12) == false) goto L22;
        r7 = true;
        goto L22
    L18:
        r12 = null;
    L22:
        if (r7 == false) goto L9;
    L25:
        CartNumWithBusinessLine r13 = (CartNumWithBusinessLine) r4;
        if (r13 == null) goto L30;
        Integer r14 = r13.getNum();
        if (r14 == null) goto L30;
        int r15 = r14.intValue();
    L32:
        if (r9.d == false) goto L39;
        if (r0 == null) goto L39;
        f r16 = r1.e;
        if (r16 == null) goto L45;
        r16.a(r0, r15, r9.e, null);
    L45:
        if (r9.h == true) goto L54;
        r1.g(r9.i);
        return;
    L54:
        return;
    L39:
        if (r9.f == false) goto L41;
        r1.l();
    L41:
        r1.m(r15);
        hl.i r17 = r9.e;
        if (r17 == null) goto L45;
        r17.onAnimationEnd();
        goto L45
    L13:
        r8 = 0;
        goto L14
    L24:
        r4 = null;
    L30:
        r15 = r9.a;
        goto L32
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.Component
    public final View c2(LayoutInflater r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        Intrinsics.checkNotNullParameter(r3, "container");
        DynamicViewWidgetOpt r4 = O1().e().b0(r2.getContext());
        this.n = r4;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dynamicView");
    L5:
        com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.c r5 = r4.b;
        r5.setId(2131364492);
        r5.setOrientation(1);
        return r5;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.Component
    public final void b2(ViewGroup r3, ViewGroup.LayoutParams r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "parentView");
        ViewGroup.LayoutParams r6 = r4;
        if (r4 != null) goto L5;
        FrameLayout.LayoutParams r7 = new FrameLayout.LayoutParams(-1, -2);
        r7.gravity = 80;
        r6 = r7;
    L5:
        super.b2(r3, r6, r5);
    }

    public static final void h2(final BottomNavigationComponentV2 r3, String r4, final int r5, final hl.i r6, boolean r7, float[] r8) {
        if (r3.k2() == false) goto L8;
        if (Intrinsics.areEqual(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(r3.O1())).b.d.a(), Boolean.FALSE) == false) goto L8;
        return;
    L8:
        if (r3.k2() == false) goto L11;
        if (r8 == null) goto L11;
        int r0 = p.a;
        Intrinsics.checkNotNullParameter(r8, "loc");
        Point r1 = new Point((int) r8[0], ((int) r8[1]) - com.bytedance.android.shopping.utils.d0.a());
    L18:
        if (r3.k2() == false) goto L22;
        View r9 = r3.j2();
        if (r9 != null) goto L29;
        return;
    L29:
        if (r3.k2() == false) goto L31;
        Point r2 = p.b(r9);
    L32:
        final Context r10 = r9.getContext();
        if (r10 != null) goto L36;
        return;
    L36:
        if (r7 == true) goto L38;
        WeakReference r11 = o.a;
        Intrinsics.checkNotNullParameter(r10, "context");
        PdpAddCartAnimationV3 r12 = new PdpAddCartAnimationV1(r10);
    L42:
        ((BasePdpAddCartAnimation) r12).c = r4;
        ((BasePdpAddCartAnimation) r12).a = r1;
        ((BasePdpAddCartAnimation) r12).b = r2;
        r12.c(new BottomNavigationComponentV2$doAddCartThrowAnimationNew$2(r3, r6, r5, r10));
        return;
    L38:
        if (r3.k2() == false) goto L40;
        WeakReference r13 = o.a;
        Intrinsics.checkNotNullParameter(r10, "context");
        r12 = new PdpAddCartAnimationV3(r10);
        goto L42
    L40:
        r12 = o.a(r10);
        goto L42
    L31:
        r2 = p.b(r9);
        goto L32
    L22:
        com.bytedance.android.shopping.prepurchase.arch.container.ability.h r14 = r3.n;
        if (r14 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("dynamicView");
    L25:
        r9 = r14.b();
        if (r9 != null) goto L29;
        return;
    L11:
        d0 r15 = (d0) r3.N1(d0.class);
        if (r15 == null) goto L44;
        Rect r16 = r15.O();
        if (r16 == null) goto L46;
        int r17 = (r16.left + r16.right) / 2;
        r1 = new Point(r17, r17 - r3.O1().getContainerAbility().i7().c);
        goto L18
    L46:
        return;
    }
}
