package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.android.ec.base.api.ai.IECAIHostService;
import com.bytedance.android.ec.base.api.ai.framework.component.BackComponent;
import com.bytedance.android.ec.core.anchorv3.PdpPerfOpt;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.anchorv4.components.TopGuideGaussComponent;
import com.bytedance.android.shopping.anchorv4.experiment.PdpAB;
import com.bytedance.android.shopping.anchorv4.voavhs.head.base.LengthenedCompatDraweeView;
import com.bytedance.android.shopping.anchorv4.voavhs.headgausee.HeadGaussItemView;
import com.bytedance.android.shopping.anchorv4.widgets.WireFrameViewV2;
import com.bytedance.android.shopping.api.anchorv3.WireFrameSchemaInfo;
import com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent;
import com.bytedance.android.shopping.prepurchase.arch.container.intf.j;
import com.bytedance.android.shopping.prepurchase.arch.container.intf.k;
import com.bytedance.android.shopping.prepurchase.arch.container.state.d;
import com.bytedance.android.shopping.prepurchase.arch.container.state.e;
import com.bytedance.android.shopping.prepurchase.arch.container.state.g;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.PdpBottomOverlayPaddingDelegate;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.m;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import s73.c;
import vg3.f;
import vg3.s;
import vg3.u;
import vg3.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class LoadingComponent extends m implements s {
    public static final /* synthetic */ int z = 0;
    public final Pair<String, Boolean> m;
    public boolean n;
    public CloseableReference<Bitmap> o;
    public final d<Boolean> p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public final Lazy v;
    public final PdpBottomOverlayPaddingDelegate w;
    public HeadGaussItemView x;
    public View y;

    public static final class a<T> implements g {
        public final /* synthetic */ LoadingComponent a;

        public a(LoadingComponent r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r6) {
            k r7 = (k) r6;
            Intrinsics.checkNotNullParameter(r7, "it");
            boolean r1 = false;
            if ((r7 instanceof k.c.b) == false) goto L5;
        L40:
            LoadingComponent r8 = this.a;
            if ((r8.O1().d().q0().a() instanceof k.d.a) == false) goto L44;
            r8.e2().setVisibility(8);
            r8.p.g(Boolean.FALSE);
            return;
        L44:
            if (r8.e2().getVisibility() != 8) goto L46;
            r1 = true;
        L46:
            if (r1 == true) goto L60;
            r8.e2().setVisibility(8);
            r8.p.g(Boolean.FALSE);
            return;
        L60:
            return;
        L5:
            if ((r7 instanceof k.d) == true) goto L40;
            if ((r7 instanceof k.a) == false) goto L10;
            final LoadingComponent r0 = this.a;
            k.a r9 = (k.a) r7;
            final int r2 = r9.a;
            final String r10 = r9.b;
            r0.getClass();
            com.bytedance.android.shopping.prepurchase.arch.utils.a.a(new LoadingComponent$showErrorView$1(r0, r10, r2));
            return;
        L10:
            LoadingComponent r11 = this.a;
            WireFrameViewV2 r3 = (WireFrameViewV2) r11.r.getValue();
            if (r3 == null) goto L13;
            r3.setVisibility(0);
        L13:
            r11.e2().setBackgroundColor((int) 4294309625L);
            if (r11.i2() == false) goto L51;
            int r4 = ECSdk.a;
            IECHostService r5 = (IECHostService) ECSdk.a(IECHostService.class);
            if (r5 == null) goto L18;
            IECAIHostService r12 = r5.getECHostAIService();
        L19:
            if (r12 != null) goto L21;
        L34:
            View r13 = (View) r11.s.getValue();
            if (r13 == null) goto L37;
            r13.setVisibility(0);
        L37:
            View r14 = (View) r11.s.getValue();
            if (r14 == null) goto L54;
            r14.setOnClickListener(new b(r11));
            return;
        L54:
            return;
        L21:
            if (r12.isInApplet() != true) goto L34;
            if (r12.isLandingPage() == true) goto L57;
            ViewGroup r15 = (ViewGroup) r11.t.getValue();
            if (r15 == null) goto L58;
            BackComponent r16 = r12.createBackComponent(r15.getContext());
            if (r16 == null) goto L52;
            r16.setOnClickListener(new com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.a(r11));
            View r17 = r16.getView();
            if (r17 == null) goto L59;
            r15.setVisibility(0);
            r15.addView(r17);
            return;
        L59:
            return;
        L52:
            return;
        L58:
            return;
        L57:
            return;
        L18:
            r12 = null;
            goto L19
        }
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final List<Class<?>> M1() {
        return CollectionsKt.listOf(new Class[]{j.class, u.class, f.class});
    }

    public final LengthenedCompatDraweeView h2() {
        return (LengthenedCompatDraweeView) this.q.getValue();
    }

    @Override // vg3.s
    public final CloseableReference<Bitmap> s0() {
        this.n = true;
        return this.o;
    }

    @Override // vg3.s
    public final String E1() {
        Pair<String, Boolean> r0 = this.m;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (String) r0.first;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void T1() {
        super.T1();
        if (i2() == false) goto L12;
        SimpleDraweeView r0 = h2();
        if (r0 == null) goto L16;
        ViewGroup.LayoutParams r3 = r0.getLayoutParams();
        if ((r3 instanceof ViewGroup.MarginLayoutParams) == true) goto L9;
        r3 = null;
    L9:
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) r3;
        if (r4 == null) goto L16;
        r4.topMargin = 0;
        r0.setLayoutParams(r4);
    L16:
        Pair<String, Boolean> r1 = this.m;
        if (r1 == null) goto L20;
        String r2 = (String) r1.first;
        if (r2 == null) goto L20;
    L21:
        String r5 = r2;
        Pair<String, Boolean> r6 = this.m;
        if (r6 == null) goto L24;
        Boolean r7 = (Boolean) r6.second;
    L26:
        if (Intrinsics.areEqual(r7, Boolean.TRUE) == false) goto L30;
        LengthenedCompatDraweeView r8 = h2();
        if (r8 == null) goto L30;
        r8.setHeightRatio(1.33f);
    L30:
        WireFrameSchemaInfo r9 = g2().getNativeParams().getWireFrameSchemaInfo();
        if (r9 != null) goto L34;
    L35:
        Float r10 = null;
    L40:
        if (r10 == null) goto L44;
        float r11 = r10.floatValue();
        LengthenedCompatDraweeView r12 = h2();
        if (r12 == null) goto L44;
        r12.setHeightRatio(r11);
    L44:
        SimpleDraweeView r13 = h2();
        if (r13 == null) goto L47;
        r13.setScaleType(ImageView.ScaleType.CENTER_CROP);
    L47:
        LengthenedCompatDraweeView r14 = h2();
        if (r14 == null) goto L50;
        ImageExtensionsKt.D(r14, new r("ec_detail", "ec_product_header_image"));
    L50:
        boolean r15 = i2();
        WireFrameSchemaInfo r16 = g2().getNativeParams().getWireFrameSchemaInfo();
        if (r16 != null) goto L53;
    L57:
        boolean r17 = false;
    L59:
        if (i2() == false) goto L69;
        com.bytedance.android.shopping.anchorv4.perf.preload.g r18 = com.bytedance.android.shopping.anchorv4.perf.preload.g.b;
        if (r18 == null) goto L63;
        Integer r19 = r18.c();
    L64:
        if (r19 != null) goto L67;
        boolean r20 = PdpAB.b();
    L79:
        if (r20 == true) goto L84;
        if (r17 == false) goto L83;
        if (r15 == false) goto L84;
    L83:
        final boolean r21 = false;
    L85:
        if (r21 == true) goto L87;
    L88:
        if (r5 == null) goto L90;
        int r22 = r.h;
        ImageExtensionsKt.f(r5, r.a.a("ec_product_cover_image"), null, null, null, new LoadingComponent$initCoverView$2(this, r21), 110);
    L90:
        Z1(y.class, new LoadingComponent$initCoverView$3(this, r21, null));
    L91:
        e.a.a(O1().d().q0(), this, new a(this));
        Lazy r23 = TopGuideGaussComponent.e;
        if (TopGuideGaussComponent.a.a() == true) goto L94;
    L98:
        AbsComponent.Y1(this, s.class, this, false, 12);
        Z1(f.class, new LoadingComponent$observeBottomOverlayInset$1(this, null));
        return;
    L94:
        if (i2() == false) goto L98;
        ViewGroup r24 = (ViewGroup) this.u.getValue();
        if (r24 == null) goto L98;
        HeadGaussItemView r25 = new HeadGaussItemView(r24.getContext());
        this.x = r25;
        r24.addView(r25, 0);
        goto L98
    L87:
        if (PdpPerfOpt.b().l() == false) goto L91;
    L84:
        r21 = true;
        goto L85
    L67:
        if (r19.intValue() == 1) goto L77;
    L78:
        r20 = false;
    L77:
        r20 = true;
        goto L79
    L63:
        r19 = null;
        goto L64
    L69:
        com.bytedance.android.shopping.anchorv4.perf.preload.g r26 = com.bytedance.android.shopping.anchorv4.perf.preload.g.b;
        if (r26 == null) goto L72;
        Integer r27 = r26.d();
    L73:
        if (r27 != null) goto L76;
        r20 = PdpAB.b();
        goto L79
    L76:
        if (r27.intValue() != 1) goto L78;
    L72:
        r27 = null;
        goto L73
    L53:
        if (r16.getHalPdpOptimizeStyle() != 1) goto L57;
        if (r16.getHalfPdpHeadScaleParam() != 0.0f) goto L57;
        r17 = true;
        goto L59
    L34:
        if (r9.getHalPdpOptimizeStyle() != 1) goto L35;
        if (r9.getHalfPdpHeadScaleParam() != 0.0f) goto L39;
        r10 = Float.valueOf(0.6666667f);
        goto L40
    L39:
        r10 = Float.valueOf(r9.getHalfPdpHeadScaleParam());
        goto L40
    L24:
        r7 = null;
    L20:
        r2 = g2().getNativeParams().getFrameCovImage();
        goto L21
    L12:
        int r28 = ((com.bytedance.android.shopping.prepurchase.business.pdp.e) O1().f().b).b.b;
        ViewGroup.LayoutParams r29 = e2().getLayoutParams();
        if (r29 == null) goto L15;
        r29.height = r28;
    L15:
        e2().requestLayout();
        goto L16
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void U1() {
        super.U1();
        CloseableReference<Bitmap> r0 = this.o;
        if (r0 == null) goto L6;
        r0.close();
        return;
    }

    public final boolean i2() {
        return g2().getNativeParams().getFullMode();
    }

    @Override // vg3.s
    public final d a0() {
        return this.p;
    }

    public LoadingComponent(c r3) {
        if (r3 == null) goto L5;
        Pair<String, Boolean> r4 = r3.a;
    L6:
        this.m = r4;
        this.p = new d(Boolean.TRUE);
        this.q = LazyKt.lazy(new LoadingComponent$previewImageView$2(this));
        this.r = LazyKt.lazy(new LoadingComponent$frameView$2(this));
        this.s = LazyKt.lazy(new LoadingComponent$closeBtn$2(this));
        this.t = LazyKt.lazy(new LoadingComponent$closeBtnApplet$2(this));
        this.u = LazyKt.lazy(new LoadingComponent$frameContainer$2(this));
        this.v = LazyKt.lazy(LoadingComponent$networkErrorConfigMap$2.INSTANCE);
        this.w = new PdpBottomOverlayPaddingDelegate(LoadingComponent$bottomOverlayMarginDelegate$1.INSTANCE, new LoadingComponent$bottomOverlayMarginDelegate$2(this));
        return;
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.Component
    public final View c2(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "container");
        if (PdpPerfOpt.b().j() == false) goto L6;
        ShoppingAsyncInflater.a r0 = ShoppingAsyncInflater.e;
        Context r6 = r4.getContext();
        r0.getClass();
        return ShoppingAsyncInflater.a.a(r6).aU(2131560799, r5, false);
    L6:
        return r4.inflate(2131560799, r5, false);
    }
}
