package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.bytedance.android.shopping.anchorv4.bottom.BottomButtonMeta;
import com.bytedance.android.shopping.anchorv4.bottom.BottomButtonVO;
import com.bytedance.android.shopping.anchorv4.helper.BasePdpAddCartAnimation;
import com.bytedance.android.shopping.anchorv4.helper.PdpAddCartAnimationV2;
import com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.PdpBottomOverlayPaddingDelegate;
import com.bytedance.android.shopping.prepurchase.business.pdp.view.BottomButtonView;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import vg3.d0;
import vg3.e0;
import vg3.i0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class BottomNavigationComponentV1 extends com.bytedance.android.shopping.prepurchase.business.pdp.components.m implements vg3.e {
    public static final /* synthetic */ int v = 0;
    public BottomButtonVO m;
    public BottomButtonComponent n;
    public BottomButtonView o;
    public final com.bytedance.android.shopping.prepurchase.arch.container.state.d<com.bytedance.android.shopping.anchorv4.bottom.b> p;
    public final CompositeDisposable q;
    public final PdpBottomOverlayPaddingDelegate r;
    public long s;
    public final BottomNavigationComponentV1$componentDepend$1 t;
    public final b u;

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
        public final /* synthetic */ BottomNavigationComponentV1 a;

        public final boolean k0() {
            return false;
        }

        public final BottomButtonMeta D() {
            return this.a.t.D();
        }

        public final int W() {
            BottomButtonView r0 = BottomNavigationComponentV1.h2(this.a).h;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.getLynxLocationY();
        }

        public b(BottomNavigationComponentV1 r1) {
            this.a = r1;
        }

        public final void Y(JSONObject r4) {
            Intrinsics.checkNotNullParameter("edit_cart_combo_num", "eventName");
            BottomButtonComponent r2 = BottomNavigationComponentV1.h2(this.a);
            r2.getClass();
            Intrinsics.checkNotNullParameter("edit_cart_combo_num", "eventName");
            BottomButtonView r3 = r2.h;
            if (r3 == null) goto L8;
            Intrinsics.checkNotNullParameter("edit_cart_combo_num", "eventName");
            ti.l r1 = r3.i;
            if (r1 == null) goto L9;
            r1.sendJsEvent("edit_cart_combo_num", r4);
            return;
        L9:
            return;
        }

        public final void k(SkuRestoreState r2) {
            Intrinsics.checkNotNullParameter(r2, "state");
            this.a.t.k(r2);
        }

        public final void s0(fi3.q r7) {
            BottomButtonView r0 = BottomNavigationComponentV1.h2(this.a).h;
            if (r0 == null) goto L5;
            View r1 = r0.getSuperMarketLynxView();
        L6:
            if (r1 != null) goto L8;
            return;
        L8:
            d0 r2 = (d0) this.a.N1(d0.class);
            if (r2 == null) goto L32;
            Rect r3 = r2.O();
            if (r3 == null) goto L34;
            Context r4 = r1.getContext();
            int r5 = (r3.left + r3.right) / 2;
            int r6 = ((r3.top + r3.bottom) / 2) - this.a.O1().getContainerAbility().i7().c;
            if (r4 == null) goto L33;
            PdpAddCartAnimationV2 r8 = com.bytedance.android.shopping.anchorv4.helper.o.a(r4);
            if (r7 == null) goto L18;
            String r9 = r7.d;
        L19:
            ((BasePdpAddCartAnimation) r8).c = r9;
            Point r10 = new Point(r5, r6);
            int r11 = com.bytedance.android.shopping.anchorv4.helper.p.a;
            int r12 = 0;
            if (r7 == null) goto L24;
            Integer r13 = r7.b;
            if (r13 == null) goto L24;
            int r14 = r13.intValue();
        L25:
            int r15 = com.bytedance.android.shopping.extensions.b.a(Integer.valueOf(r14));
            if (r7 == null) goto L30;
            Integer r16 = r7.c;
            if (r16 == null) goto L30;
            r12 = r16.intValue();
        L30:
            int r17 = com.bytedance.android.shopping.extensions.b.a(Integer.valueOf(r12));
            Intrinsics.checkNotNullParameter(r1, "lynxView");
            Point r18 = com.bytedance.android.shopping.anchorv4.helper.p.a(r1, r15, r1.getHeight() - r17);
            ((BasePdpAddCartAnimation) r8).a = r10;
            ((BasePdpAddCartAnimation) r8).b = r18;
            r8.c(null);
            return;
        L24:
            r14 = 0;
            goto L25
        L18:
            r9 = null;
            goto L19
        L33:
            return;
        L34:
            return;
        L32:
            return;
        L5:
            r1 = null;
            goto L6
        }
    }

    @Override // vg3.e
    public final com.bytedance.android.shopping.prepurchase.business.pdp.view.i H(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sliceKey");
        return null;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final List<Class<?>> M1() {
        return CollectionsKt.listOf(new Class[]{vg3.y.class, e0.class, vg3.u.class, d0.class, i0.class, vg3.x.class, vg3.h.class, vg3.w.class, vg3.m.class, vg3.f.class});
    }

    @Override // vg3.e
    public final boolean Q0() {
        BottomButtonVO r0 = this.m;
        if (r0 == null) goto L7;
        Float r1 = r0.getBottomValidHeightRatio();
        if (r1 == null) goto L7;
        float r2 = r1.floatValue();
    L8:
        int r3 = d1();
        int r4 = O1().getContainerAbility().i7().b;
        if (r3 != 0) goto L11;
    L14:
        return true;
    L11:
        if (r3 < (r2 * r4)) goto L14;
        return false;
    L7:
        r2 = 0.5f;
        goto L8
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void U1() {
        BottomButtonComponent r0 = this.n;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("realComponent");
    L5:
        r0.getClass();
        s0.e(r0);
        BottomButtonView r1 = r0.h;
        if (r1 == null) goto L8;
        r1.d();
    L8:
        CompositeDisposable r2 = this.q;
        if (r2.isDisposed() == false) goto L12;
        r2 = null;
    L12:
        if (r2 == null) goto L14;
        r2.dispose();
    L14:
        super.U1();
    }

    public BottomNavigationComponentV1() {
        this.p = new com.bytedance.android.shopping.prepurchase.arch.container.state.d();
        this.q = new CompositeDisposable();
        this.r = new PdpBottomOverlayPaddingDelegate(new BottomNavigationComponentV1$bottomOverlayPaddingDelegate$1(this));
        this.t = new BottomNavigationComponentV1$componentDepend$1(this);
        this.u = new b(this);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void S1() {
        super.S1();
        this.s = SystemClock.uptimeMillis();
        BottomButtonComponent r0 = this.n;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("realComponent");
    L5:
        r0.e = false;
        BottomButtonView r1 = r0.h;
        if (r1 == null) goto L9;
        r1.f(true);
        return;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void T1() {
        super.T1();
        BottomNavigationComponentV1$componentDepend$1 r1 = this.t;
        FragmentManager r2 = O1().getContainerAbility().g7();
        BottomButtonView r3 = this.o;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bottomView");
    L5:
        this.n = new BottomButtonComponent(r1, r2, r3);
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a((com.bytedance.android.shopping.prepurchase.arch.container.state.e) O1().d().getData().l.getValue(), this, new e(this));
        com.bytedance.android.shopping.prepurchase.arch.container.ability.g.b(O1().e(), "instant_cart_list_visible_change", true, new BottomNavigationComponentV1$initData$2(this));
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(this.p, this, new f(this));
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).b.d, this, new g(this));
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).b.c, this, new h(this));
        Z1(vg3.f.class, new BottomNavigationComponentV1$observeBottomOverlayInset$1(this, null));
        AbsComponent.Y1(this, vg3.e.class, this, true, 4);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void V1() {
        super.V1();
        BottomButtonComponent r0 = this.n;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("realComponent");
    L5:
        r0.e = true;
        BottomButtonView r1 = r0.h;
        if (r1 == null) goto L9;
        r1.f(false);
        return;
    }

    @Override // vg3.e
    public final int d1() {
        return e2().getHeight();
    }

    @Override // vg3.e
    public final j73.c b() {
        return this.u;
    }

    public static final /* synthetic */ BottomButtonComponent h2(BottomNavigationComponentV1 r1) {
        BottomButtonComponent r2 = r1.n;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("realComponent");
    L5:
        return r2;
    }

    @Override // vg3.e
    public final void V0(Function2<? super Rect, ? super Rect, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "function");
        e2().addOnLayoutChangeListener(new a(r3));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.Component
    public final View c2(LayoutInflater r5, ViewGroup r6) {
        Intrinsics.checkNotNullParameter(r5, "inflater");
        Intrinsics.checkNotNullParameter(r6, "container");
        FrameLayout r7 = new FrameLayout(r5.getContext());
        r7.setId(2131364492);
        BottomButtonView r8 = new BottomButtonView(r7.getContext(), null, 6, 0);
        r8.setId(2131362749);
        this.o = r8;
        Unit r0 = Unit.INSTANCE;
        r7.addView(r8, -1, -2);
        return r7;
    }
}
