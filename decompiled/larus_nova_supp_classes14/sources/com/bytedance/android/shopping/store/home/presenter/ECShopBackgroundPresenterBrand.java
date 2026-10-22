package com.bytedance.android.shopping.store.home.presenter;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.shopping.store.home.entity.ECShopBrandHeaderStyleDto;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.facebook.drawee.view.GenericDraweeView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECShopBackgroundPresenterBrand extends ECShopBasePresenter {
    public static final /* synthetic */ int G = 0;
    public ECDraweeView A;
    public ViewGroup B;
    public View C;
    public int D;
    public int E;
    public int F;
    public final Lazy u;
    public final Lazy v;
    public final Lazy w;
    public boolean x;
    public final Lazy y;
    public final Lazy z;

    public static final class a<T> implements Observer {
        public final /* synthetic */ ECShopBackgroundPresenterBrand a;
        public final /* synthetic */ View b;

        public a(ECShopBackgroundPresenterBrand r1, View r2) {
            this.a = r1;
            this.b = r2;
        }

        /* JADX WARN: Type inference failed for: r15v0, types: [android.view.View, android.widget.ImageView, com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView, com.facebook.drawee.view.GenericDraweeView] */
        public final void onChanged(Object r19) {
            com.bytedance.android.shopping.store.home.entity.n r1 = (com.bytedance.android.shopping.store.home.entity.n) r19;
            if (r1 == null) goto L111;
            Boolean r5 = null;
            if (r1.d() == false) goto L83;
            View r2 = com.bytedance.android.ec.store.product.presenter.utils.f.a(this.a.w().b(2131371041));
            if (r2 == null) goto L10;
            r2.setVisibility(0);
        L10:
            GenericDraweeView r3 = (ECDraweeView) this.a.u.getValue();
            if (r3 == null) goto L17;
            ECShopBrandHeaderStyleDto r7 = r1.j;
            if (r7 == null) goto L15;
            ECUrlModel r8 = r7.getHeaderBackgroundImg();
        L16:
            com.bytedance.android.ec.core.imagex.h0.d(r3, r8, this.a.T().getImageCallerContext(), null, null, null, null, 120);
            r3.setVisibility(0);
            goto L17
        L15:
            r8 = null;
        L17:
            this.a.y().post(new k(this));
            ECShopBrandHeaderStyleDto r4 = r1.j;
            if (r4 == null) goto L20;
            Boolean r6 = r4.getNeedHeaderBackgroundMask();
        L22:
            if (Intrinsics.areEqual(r6, Boolean.TRUE) == false) goto L24;
            ECShopBackgroundPresenterBrand r9 = this.a;
            ECShopBackgroundPresenterBrand.r0(r9, r9.t0(), 0.0f);
            this.a.T().getUpglideFactor().a(this.a.W(), new l(this), false);
        L24:
            ECShopBackgroundPresenterBrand r10 = this.a;
            ?? r15 = r10.u0();
            ECShopBrandHeaderStyleDto r11 = r1.j;
            if (r11 == null) goto L27;
            ECUrlModel r12 = r11.getHeaderBackgroundMaskImage();
        L28:
            if (r12 == null) goto L30;
            String r13 = r12.getFirstUrl();
        L31:
            if (r15 == 0) goto L43;
            if (r13 != null) goto L35;
        L38:
            boolean r14 = true;
        L39:
            if (r14 == true) goto L43;
            com.bytedance.android.ec.core.imagex.h0.d(r15, r12, r10.T().getImageCallerContext(), null, null, null, null, 120);
            r15.setAlpha(1.0f);
            r15.setVisibility(0);
            boolean r16 = true;
        L48:
            r10.x = r16;
            ECShopBackgroundPresenterBrand r17 = this.a;
            ECDraweeView r18 = r17.u0();
            Float r20 = (Float) this.a.T().getUpglideFactor().getValue();
            if (r20 == null) goto L51;
            float r21 = r20.floatValue();
        L52:
            ECShopBackgroundPresenterBrand.s0(r17, r18, r21);
            this.a.T().getUpglideFactor().a(this.a.W(), new m(this), false);
            this.a.T().getSlideDistance().a(this.a.W(), new n(this), false);
            if (this.a.T().isCroppedStyle() == false) goto L96;
            View r22 = com.bytedance.android.ec.store.product.presenter.utils.f.a(this.a.w().b(2131371041));
            if (r22 == null) goto L57;
            r22.setBackgroundColor(0);
        L57:
            this.a.A = (ECDraweeView) this.b.findViewById(2131371186);
            this.a.B = (ViewGroup) this.b.findViewById(2131371188);
            this.a.C = this.b.findViewById(2131371187);
            ((ViewGroup) this.b.findViewById(2131371057)).setPadding(0, 0, 0, 0);
            ECDraweeView r23 = this.a.A;
            if (r23 != null) goto L60;
            Intrinsics.throwUninitializedPropertyAccessException("topBarBackgroundView");
        L60:
            ECShopBrandHeaderStyleDto r24 = r1.j;
            if (r24 == null) goto L63;
            ECUrlModel r25 = r24.getHeaderBackgroundImg();
        L64:
            com.bytedance.android.ec.core.imagex.h0.d(r23, r25, this.a.T().getImageCallerContext(), null, null, null, null, 120);
            ViewGroup r26 = this.a.B;
            if (r26 != null) goto L67;
            Intrinsics.throwUninitializedPropertyAccessException("topBarBackgroundViewWrapper");
        L67:
            this.a.getClass();
            wg.a.d(r26, com.bytedance.android.ec.core.utils.k1.p() + com.bytedance.android.shopping.extensions.b.b(44));
            r26.setVisibility(0);
            GenericDraweeView r27 = (ECDraweeView) this.a.u.getValue();
            if (r27 == null) goto L70;
            this.a.getClass();
            com.bytedance.android.ec.core.utils.d2.d(r27, 0, -(com.bytedance.android.ec.core.utils.k1.p() + com.bytedance.android.shopping.extensions.b.b(44)), 0, 0);
        L70:
            View r28 = this.a.t0();
            if (r28 == null) goto L73;
            this.a.getClass();
            com.bytedance.android.ec.core.utils.d2.d(r28, 0, -(com.bytedance.android.ec.core.utils.k1.p() + com.bytedance.android.shopping.extensions.b.b(44)), 0, 0);
        L73:
            ViewGroup r29 = this.a.v0();
            if (r29 == null) goto L76;
            ViewExtensionsKt.g(r29, 20.0f, 20.0f, 0.0f, 0.0f);
        L76:
            com.bytedance.android.ec.core.utils.n1.i.getClass();
            float r30 = (com.bytedance.android.ec.core.utils.n1.a.c() - com.bytedance.android.ec.core.utils.n1.a.b()) - com.bytedance.android.ec.core.utils.k1.g();
            ViewGroup r31 = this.a.v0();
            if (r31 == null) goto L79;
            r31.setY(r30);
        L79:
            this.a.T().getSlideDistance().a(this.a.W(), new o(this, r30), false);
            ECShopBackgroundPresenterBrand r32 = this.a;
            View r33 = r32.C;
            if (r33 != null) goto L82;
            Intrinsics.throwUninitializedPropertyAccessException("topbarBackgroundMask");
        L82:
            ECShopBackgroundPresenterBrand.r0(r32, r33, 0.0f);
            this.a.T().getCollapseFactor().a(this.a.W(), new p(this), false);
            this.a.T().getUpglideFactor().a(this.a.W(), new q(this), false);
            goto L96
        L63:
            r25 = null;
        L96:
            ECShopBrandHeaderStyleDto r34 = r1.j;
            if (r34 == null) goto L100;
            r5 = r34.getNeedHeaderBackgroundMask();
        L100:
            if (Intrinsics.areEqual(r5, Boolean.TRUE) == false) goto L104;
            View r35 = this.a.t0();
            if (r35 == null) goto L108;
            r35.setVisibility(0);
            return;
        L108:
            return;
        L104:
            View r36 = this.a.t0();
            if (r36 == null) goto L110;
            r36.setVisibility(8);
            return;
        L110:
            return;
        L51:
            r21 = 0.0f;
            goto L52
        L35:
            if (r13.length() == 0) goto L38;
            r14 = false;
        L43:
            if (r15 == 0) goto L45;
            r15.setController(null);
        L45:
            if (r15 == 0) goto L47;
            r15.setVisibility(8);
        L47:
            r16 = false;
            goto L48
        L30:
            r13 = null;
            goto L31
        L27:
            r12 = null;
            goto L28
        L20:
            r6 = null;
            goto L22
        L83:
            View r37 = com.bytedance.android.ec.store.product.presenter.utils.f.a(this.a.w().b(2131371041));
            if (r37 == null) goto L86;
            r37.setVisibility(8);
        L86:
            GenericDraweeView r38 = (ECDraweeView) this.a.u.getValue();
            if (r38 == null) goto L89;
            r38.setVisibility(8);
        L89:
            View r39 = this.a.t0();
            if (r39 == null) goto L92;
            r39.setVisibility(8);
        L92:
            GenericDraweeView r40 = this.a.u0();
            if (r40 == null) goto L95;
            r40.setVisibility(8);
        L95:
            this.a.x = false;
            goto L96
        }
    }

    public final View t0() {
        return (View) this.v.getValue();
    }

    public final ECDraweeView u0() {
        return (ECDraweeView) this.w.getValue();
    }

    public final ViewGroup v0() {
        return (ViewGroup) this.y.getValue();
    }

    public ECShopBackgroundPresenterBrand(Fragment r1) {
        super(r1);
        this.u = LazyKt.lazy(new ECShopBackgroundPresenterBrand$background$2(this));
        this.v = LazyKt.lazy(new ECShopBackgroundPresenterBrand$backgroundMask$2(this));
        this.w = LazyKt.lazy(new ECShopBackgroundPresenterBrand$backgroundMaskImage$2(this));
        this.y = LazyKt.lazy(new ECShopBackgroundPresenterBrand$backgroundWrapper$2(this));
        this.z = LazyKt.lazy(new ECShopBackgroundPresenterBrand$backgroundBottomGradient$2(this));
    }

    public static final void q0(ECShopBackgroundPresenterBrand r2) {
        GenericDraweeView r0 = (ECDraweeView) r2.u.getValue();
        if (r0 == null) goto L19;
        Integer r1 = Integer.valueOf(r0.getMeasuredHeight());
        if (r1.intValue() <= 0) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == true) goto L11;
        r1 = null;
    L11:
        if (r1 == null) goto L20;
        int r4 = r1.intValue();
        View r5 = r2.t0();
        if (r5 == null) goto L15;
        wg.a.d(r5, r4);
    L15:
        GenericDraweeView r6 = r2.u0();
        if (r6 == null) goto L21;
        wg.a.d(r6, r4);
        return;
    L21:
        return;
    L20:
        return;
    L7:
        r3 = false;
        goto L8
    }

    public final void A(QModel r4) {
        View r5 = o0();
        T().getHeaderArea().a(W(), new a(this, r5), false);
    }

    public static final void r0(ECShopBackgroundPresenterBrand r4, View r5, float r6) {
        r4.getClass();
        if (r5 == null) goto L7;
        int r7 = (int) (51 + (102 * r6));
        GradientDrawable r8 = new GradientDrawable();
        r8.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        r8.setColors(new int[]{(r7 << 24) | 0, (int) 3254779904L, (int) 4278190080L});
        r8.setGradientCenter(0.5f, 0.5f);
        r8.setGradientType(0);
        r8.setShape(0);
        Intrinsics.checkNotNullParameter(r5, "$this$setBackgroundCompat");
        r5.setBackground(r8);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void s0(ECShopBackgroundPresenterBrand r1, ECDraweeView r2, float r3) {
        if (r1.x == false) goto L12;
        if (r2 == 0) goto L13;
        float r4 = RangesKt.coerceIn(1.0f - RangesKt.coerceIn(r3, 0.0f, 1.0f), 0.0f, 1.0f);
        r2.setAlpha(r4);
        if (r4 > 0.01f) goto L9;
        int r5 = 8;
    L10:
        r2.setVisibility(r5);
        return;
    L9:
        r5 = 0;
        goto L10
    L13:
        return;
    }
}
