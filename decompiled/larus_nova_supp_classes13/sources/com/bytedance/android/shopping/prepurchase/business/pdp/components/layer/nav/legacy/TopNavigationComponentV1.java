package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ec.core.anchorv3.PdpPerfOpt;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.anchorv3.widget.AnchorV3SearchEditView;
import com.bytedance.android.shopping.anchorv4.dto.components.TagsScrollBoxComponent;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.nav.AnchorV4NavArea;
import com.bytedance.android.shopping.anchorv4.nav.AnchorV4SearchEditView;
import com.bytedance.android.shopping.anchorv4.nav.AnchorV4TabArea;
import com.bytedance.android.shopping.anchorv4.nav.ShareComponentV2;
import com.bytedance.android.shopping.anchorv4.nav.ShareMeta;
import com.bytedance.android.shopping.anchorv4.nav.controls.TopRightControlsMeta;
import com.bytedance.android.shopping.anchorv4.nav.controls.TopRightControlsVO;
import com.bytedance.android.shopping.anchorv4.voavhs.base.components.TagsScrollBoxComponentView;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import vg3.d0;
import vg3.e0;
import vg3.i0;
import vg3.n0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class TopNavigationComponentV1 extends com.bytedance.android.shopping.prepurchase.business.pdp.components.m implements i0 {
    public static final /* synthetic */ int y = 0;
    public final com.bytedance.android.shopping.prepurchase.arch.container.state.d<n0> m;
    public final CompositeDisposable n;
    public Boolean o;
    public final com.bytedance.android.shopping.prepurchase.arch.container.state.d<List<String>> p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final c t;
    public boolean u;
    public long v;
    public final TopNavigationComponentV1$dependency$1 w;
    public final b x;

    public static final class a implements View.OnLayoutChangeListener {
        public final /* synthetic */ TopNavigationComponentV1 a;
        public final /* synthetic */ Function1 b;

        public a(TopNavigationComponentV1 r1, Function1 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            r1.removeOnLayoutChangeListener(this);
            this.b.invoke(new Rect(this.a.e2().getLeft(), this.a.e2().getTop(), this.a.e2().getRight(), this.a.e2().getBottom()));
        }
    }

    public static final class b implements j73.g {
        public final /* synthetic */ TopNavigationComponentV1 a;

        public final void C(String r2) {
            Intrinsics.checkNotNullParameter(r2, "groupId");
        }

        public final void N(int r1) {
        }

        public final Boolean d() {
            return null;
        }

        public final void s(boolean r1) {
        }

        public final boolean u() {
            return false;
        }

        public final Boolean i() {
            return this.a.o;
        }

        public final Pair<com.bytedance.android.shopping.anchorv3.i, com.bytedance.android.shopping.anchorv3.widget.f> r0() {
            return new Pair(null, null);
        }

        public b(TopNavigationComponentV1 r1) {
            this.a = r1;
        }

        public final void h(List<String> r2) {
            Intrinsics.checkNotNullParameter(r2, "extraElementId");
            this.a.h(r2);
        }
    }

    public static final class c implements com.bytedance.android.shopping.anchorv4.vm.c {
        public final /* synthetic */ TopNavigationComponentV1 a;

        public final void Y8(int r1) {
        }

        public final void Z8(int r1, Bitmap r2) {
        }

        public final void a9(boolean r1) {
        }

        public final void X8() {
            AnchorV4NavArea r0 = this.a.i2();
            if (r0 == null) goto L6;
            r0.c();
            return;
        }

        public c(TopNavigationComponentV1 r1) {
            this.a = r1;
        }

        public final void W8(int r1, Bitmap r2) {
            Intrinsics.checkNotNullParameter(r2, "bitmap");
            Intrinsics.checkNotNullParameter(r2, "bitmap");
        }

        public final void b9(boolean r2, Integer r3, Integer r4, boolean r5) {
            AnchorV4NavArea r0 = this.a.i2();
            if (r0 == null) goto L6;
            r0.b(r2, r3, r4, r5);
            return;
        }
    }

    @Override // vg3.i0
    public final com.bytedance.android.shopping.prepurchase.business.pdp.view.i H(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sliceKey");
        return null;
    }

    @Override // vg3.i0
    public final View K(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return null;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final List<Class<?>> M1() {
        return CollectionsKt.listOf(new Class[]{vg3.l.class, d0.class, vg3.w.class, vg3.u.class, vg3.s.class, vg3.m.class, e0.class});
    }

    @Override // vg3.i0
    public final void R0() {
    }

    public final AnchorV4NavArea i2() {
        return (AnchorV4NavArea) this.q.getValue();
    }

    public final TopRightControlsComponent j2() {
        return (TopRightControlsComponent) this.s.getValue();
    }

    public final AnchorV4TabArea k2() {
        return (AnchorV4TabArea) this.r.getValue();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void U1() {
        vg3.l r0 = (vg3.l) N1(vg3.l.class);
        if (r0 == null) goto L5;
        r0.m1(this.t);
    L5:
        CompositeDisposable r1 = this.n;
        if (r1.isDisposed() == false) goto L9;
        r1 = null;
    L9:
        if (r1 == null) goto L11;
        r1.dispose();
    L11:
        j2().getClass();
        super.U1();
    }

    public TopNavigationComponentV1() {
        this.m = new com.bytedance.android.shopping.prepurchase.arch.container.state.d();
        this.n = new CompositeDisposable();
        this.p = new com.bytedance.android.shopping.prepurchase.arch.container.state.d();
        this.q = LazyKt.lazy(new TopNavigationComponentV1$navArea$2(this));
        this.r = LazyKt.lazy(new TopNavigationComponentV1$tabArea$2(this));
        this.s = LazyKt.lazy(new TopNavigationComponentV1$rightBtn$2(this));
        this.t = new c(this);
        this.w = new TopNavigationComponentV1$dependency$1(this);
        this.x = new b(this);
    }

    @Override // vg3.i0
    public final View N() {
        return j2().f;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void S1() {
        super.S1();
        this.v = SystemClock.uptimeMillis();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void T1() {
        super.T1();
        this.m.e(this, new w(this));
        AnchorV4TabArea r0 = k2();
        if (r0 == null) goto L5;
        Function2<String, Integer, Unit> r1 = new TopNavigationComponentV1$initView$2(this);
        Intrinsics.checkNotNullParameter(r1, "watchCB");
        r0.c = r1;
    L5:
        AnchorV4NavArea r2 = i2();
        if (r2 == null) goto L8;
        r2.setCloseListener(new TopNavigationComponentV1$initView$3(this));
    L8:
        AnchorV4NavArea r3 = i2();
        if (r3 == null) goto L11;
        r3.setNavBlurTabDepend(new x(this));
    L11:
        AnchorV4NavArea r4 = i2();
        if (r4 == null) goto L14;
        r4.setupWithFullMode(g2().getNativeParams().getFullMode());
    L14:
        AnchorV4NavArea r5 = i2();
        if (r5 == null) goto L17;
        TopNavigationComponentV1$initView$5 r6 = new TopNavigationComponentV1$initView$5(this);
        Intrinsics.checkNotNullParameter(r6, "sla");
        AnchorV4SearchEditView r7 = r5.getSearchEditView();
        r7.getClass();
        Intrinsics.checkNotNullParameter(r6, "sla");
        ((AnchorV3SearchEditView) r7).d = r6;
    L17:
        Z1(d0.class, new TopNavigationComponentV1$initData$1(this, null));
        Z1(vg3.l.class, new TopNavigationComponentV1$initData$2(this, null));
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(O1().d().getData().a(), this, new q(this));
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(O1().d().q0(), this, new r(this));
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(this.p, this, new s(this));
        Z1(e0.class, new TopNavigationComponentV1$initData$6(this, null));
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a((com.bytedance.android.shopping.prepurchase.arch.container.state.e) O1().d().getData().j.getValue(), this, new t(this));
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a((com.bytedance.android.shopping.prepurchase.arch.container.state.e) O1().d().getData().f.getValue(), this, new u(this));
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a((com.bytedance.android.shopping.prepurchase.arch.container.state.e) O1().d().getData().h.getValue(), this, new v(this));
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).b.d, this, new o(this));
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).b.c, this, new p(this));
        Z1(vg3.s.class, new TopNavigationComponentV1$initData$12(this, null));
        AnchorV4TabArea r8 = k2();
        if (r8 == null) goto L20;
        Function1<String, Unit> r9 = new TopNavigationComponentV1$initData$13(this);
        Intrinsics.checkNotNullParameter(r9, "lcb");
        r8.e = r9;
    L20:
        AbsComponent.Y1(this, i0.class, this, true, 4);
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

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void V1() {
        super.V1();
    }

    @Override // vg3.i0
    public final j73.g b() {
        return this.x;
    }

    @Override // vg3.i0
    public final Boolean i() {
        return this.o;
    }

    @Override // vg3.i0
    public final com.bytedance.android.shopping.prepurchase.arch.container.state.d q1() {
        return this.m;
    }

    @Override // vg3.i0
    public final void h(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "extraElementId");
        this.p.g(r2);
    }

    @Override // vg3.i0
    public final void j0(View r46) {
        Intrinsics.checkNotNullParameter(r46, FreqActions.ACTION_VIEW);
        TopRightControlsVO r1 = (TopRightControlsVO) ((com.bytedance.android.shopping.prepurchase.arch.container.state.e) O1().d().getData().h.getValue()).a();
        if (r1 == null) goto L9;
        TopRightControlsMeta r2 = r1.getTopRightControlsMeta();
        if (r2 == null) goto L9;
        ShareMeta r3 = r2.getShareMeta();
        if (r3 == null) goto L9;
        ShareMeta r5 = r3.fillCommonMeta(this.w.a());
    L10:
        if (r5 == null) goto L12;
        String r4 = r5.getProductId();
    L13:
        String r39 = Intrinsics.stringPlus(r4, "_" + System.currentTimeMillis());
        if (r5 == null) goto L16;
        ShareMeta r6 = ShareMeta.copy$default(r5, null, null, null, null, null, 0, null, null, 0, null, null, null, null, null, false, null, null, 0, null, null, null, null, null, 0, null, false, null, null, null, null, null, r39, "product_detail", null, Integer.MAX_VALUE, 2, null);
    L17:
        if (r6 == null) goto L20;
        new ShareComponentV2(new n(this.w), r46, r6, "gallery", null).a();
        return;
    L20:
        return;
    L16:
        r6 = null;
        goto L17
    L12:
        r4 = null;
    L9:
        r5 = null;
        goto L10
    }

    @Override // vg3.i0
    public final void r1(Function1<? super Rect, Unit> r6) {
        Intrinsics.checkNotNullParameter(r6, "function");
        View r0 = e2();
        if (ViewCompat.isLaidOut(r0) == true) goto L5;
    L7:
        r0.addOnLayoutChangeListener(new a(this, r6));
        return;
    L5:
        if (r0.isLayoutRequested() == true) goto L7;
        r6.invoke(new Rect(e2().getLeft(), e2().getTop(), e2().getRight(), e2().getBottom()));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.Component
    public final View c2(LayoutInflater r7, ViewGroup r8) {
        Intrinsics.checkNotNullParameter(r7, "inflater");
        Intrinsics.checkNotNullParameter(r8, "container");
        FrameLayout r9 = new FrameLayout(r7.getContext());
        AnchorV4NavArea r10 = new AnchorV4NavArea(r9.getContext(), null, 6, 0);
        r10.setId(2131362900);
        Unit r0 = Unit.INSTANCE;
        r9.addView(r10, -1, -2);
        AnchorV4TabArea r11 = new AnchorV4TabArea(r9.getContext(), null, 6, 0);
        r11.setId(2131362905);
        LinearLayout.LayoutParams r1 = new LinearLayout.LayoutParams(-1, -2);
        r1.topMargin = com.bytedance.android.shopping.extensions.b.b(80);
        r9.addView(r11, r1);
        return r9;
    }

    public static final void h2(TopNavigationComponentV1 r7, TopRightControlsVO r8, List r9) {
        r7.getClass();
        r8.setShowExtraElement(r9);
        r7.getClass();
        vg3.y r10 = (vg3.y) r7.N1(vg3.y.class);
        if (r10 == null) goto L7;
        com.bytedance.android.shopping.anchorv4.perf.monitor.c r0 = r10.V();
        if (r0 == null) goto L7;
        r0.h();
    L7:
        TopRightControlsComponent r1 = r7.j2();
        r1.a = r8;
        Lazy r2 = ECAppInfoService.a;
        ShareMeta r4 = null;
        if (we.a.a == false) goto L21;
        CommonMeta r3 = r1.c.a();
        if (r3 == null) goto L12;
        String r5 = r3.getSearchPageSchema();
    L13:
        if (r5 != null) goto L15;
    L18:
        boolean r6 = true;
    L19:
        if (r6 == false) goto L21;
        boolean r11 = true;
    L22:
        CommonMeta r12 = r1.c.a();
        if (r12 != null) goto L25;
    L26:
        CommonMeta r13 = r1.c.a();
        if (r13 != null) goto L29;
    L30:
        if (r11 == false) goto L40;
    L31:
        AnchorV3SearchEditView r14 = r1.i;
        if (r14 == null) goto L34;
        r14.setVisibility(4);
    L34:
        AnchorV3SearchEditView r15 = r1.i;
        if (r15 == null) goto L37;
        r15.setOnClickListener(null);
    L37:
        TextView r16 = r1.j;
        if (r16 == null) goto L47;
        r16.setVisibility(0);
    L47:
        if (PdpPerfOpt.d() == true) goto L49;
    L99:
        r1.a(r8);
    L100:
        TopRightControlsMeta r17 = r8.getTopRightControlsMeta();
        if (r17 == null) goto L104;
        r4 = r17.getShareMeta();
    L104:
        if (r7.u == true) goto L108;
        if (r4 == null) goto L108;
        r7.u = true;
        r7.O1().b().n0(new TopNavigationComponentV1$processShareButton$1(r7, r4));
    L108:
        if (r10 == null) goto L113;
        com.bytedance.android.shopping.anchorv4.perf.monitor.c r18 = r10.V();
        if (r18 == null) goto L114;
        r18.i();
        return;
    L114:
        return;
    L113:
        return;
    L49:
        if (r1.c.n() == true) goto L99;
        ViewGroup r19 = r1.g;
        if (r19 == null) goto L53;
        r19.setVisibility(8);
    L53:
        ViewGroup r20 = r1.d;
        if (r20 == null) goto L56;
        r20.setVisibility(8);
    L56:
        TagsScrollBoxComponent r21 = r8.getDarkElements();
        if (r21 == null) goto L59;
        List r22 = r21.getButtonList();
    L60:
        List r23 = r22;
        if (r23 != null) goto L63;
    L66:
        boolean r24 = true;
    L67:
        if (r24 == true) goto L100;
        TagsScrollBoxComponent r25 = r8.getLightElements();
        if (r25 == null) goto L71;
        List r26 = r25.getButtonList();
    L72:
        List r27 = r26;
        if (r27 != null) goto L75;
    L78:
        boolean r28 = true;
    L79:
        if (r28 == true) goto L100;
        if (r1.c.e() == true) goto L85;
        r1.c.t(new y(r1, r8));
        goto L100
    L85:
        if (com.bytedance.android.shopping.anchorv4.experiment.e.a() == false) goto L92;
        ViewGroup r29 = r1.d;
        if (r29 == null) goto L89;
        r29.setVisibility(0);
    L89:
        TagsScrollBoxComponentView r30 = r1.e;
        if (r30 == null) goto L98;
        TagsScrollBoxComponentView.b(r30, r8.getLightElements(), r8.getShowExtraElement(), 12);
    L98:
        r1.c.t(new z(r1, r8));
        goto L100
    L92:
        ViewGroup r31 = r1.g;
        if (r31 == null) goto L95;
        r31.setVisibility(0);
    L95:
        TagsScrollBoxComponentView r32 = r1.h;
        if (r32 == null) goto L98;
        TagsScrollBoxComponentView.b(r32, r8.getDarkElements(), r8.getShowExtraElement(), 12);
        goto L98
    L75:
        if (r27.isEmpty() == true) goto L78;
        r28 = false;
        goto L79
    L71:
        r26 = null;
        goto L72
    L63:
        if (r23.isEmpty() == true) goto L66;
        r24 = false;
        goto L67
    L59:
        r22 = null;
        goto L60
    L40:
        AnchorV3SearchEditView r33 = r1.i;
        if (r33 == null) goto L43;
        r33.setVisibility(0);
    L43:
        TextView r34 = r1.j;
        if (r34 == null) goto L47;
        r34.setVisibility(8);
        goto L47
    L29:
        if (r13.isLuban() == true) goto L31;
    L25:
        if (r12.getThirdParty() == true) goto L31;
    L15:
        if (r5.length() == 0) goto L18;
        r6 = false;
        goto L19
    L12:
        r5 = null;
    L21:
        r11 = false;
        goto L22
    }
}
