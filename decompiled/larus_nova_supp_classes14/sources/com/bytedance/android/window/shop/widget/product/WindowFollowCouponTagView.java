package com.bytedance.android.window.shop.widget.product;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ec.core.utils.q;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import lq3.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0004\fB\u000f\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#R+\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\u0010\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0013\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000fR\u001b\u0010\u0018\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u0017R4\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00192\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00198\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006$"}, d2 = {"Lcom/bytedance/android/window/shop/widget/product/WindowFollowCouponTagView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "<set-?>", "b", "Lkotlin/properties/ReadWriteProperty;", "getLargeMode", "()Z", "setLargeMode", "(Z)V", "largeMode", "Landroid/widget/TextView;", "c", "Lkotlin/Lazy;", "getCouponDescTagView", "()Landroid/widget/TextView;", "couponDescTagView", "d", "getCouponActionDescView", "couponActionDescView", "Landroid/view/View;", "e", "getRecoverView", "()Landroid/view/View;", "recoverView", "Llq3/b;", "Llq3/d;", "i", "Llq3/b;", "getFansCouponSceneParam", "()Llq3/b;", "fansCouponSceneParam", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowFollowCouponTagView extends ConstraintLayout {
    public static final /* synthetic */ KProperty[] j = null;
    public static final b k = null;
    public static final b l = null;
    public static final int m = 0;
    public static final int n = 0;
    public static final int o = 0;
    public static final int p = 0;
    public static final int q = 0;
    public b a;
    public final a b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final ECDraweeView f;
    public final ECDraweeView g;
    public final FrameLayout h;
    public lq3.b<d> i;

    public static final class a extends ObservableProperty<Boolean> {
        public final /* synthetic */ Object a;
        public final /* synthetic */ WindowFollowCouponTagView b;

        public a(Object r1, Object r2, WindowFollowCouponTagView r3) {
            this.a = r1;
            this.b = r3;
            super(r2);
        }

        public final void afterChange(KProperty<?> r2, Boolean r3, Boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "property");
            boolean r5 = r4.booleanValue();
            if (r3.booleanValue() == r5) goto L10;
            WindowFollowCouponTagView r6 = this.b;
            if (r5 == false) goto L7;
            b r7 = WindowFollowCouponTagView.k;
        L8:
            r6.a = r7;
            WindowFollowCouponTagView.R5(r6);
            return;
        L7:
            r7 = WindowFollowCouponTagView.l;
            goto L8
        }
    }

    public static final class b {
        public final int a;
        public final int b;
        public final float c;
        public final int d;
        public final int e;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L16;
            b r4 = (b) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L10;
            return false;
        L10:
            if (Float.compare(this.c, r4.c) == 0) goto L12;
            return false;
        L12:
            if (this.d == r4.d) goto L14;
            return false;
        L14:
            if (this.e == r4.e) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        public final int hashCode() {
            return (((((((this.a * 31) + this.b) * 31) + Float.floatToIntBits(this.c)) * 31) + this.d) * 31) + this.e;
        }

        public final String toString() {
            return "Appearance(leftSideDrawableResId=" + this.a + ", height=" + this.b + ", textSize=" + this.c + ", couponBackgroundColor=" + this.d + ", dashVerticalMargin=" + this.e + ")";
        }

        public b(int r1, int r2, float r3, int r4, int r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    public static final class c {
    }

    static {
        j = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(WindowFollowCouponTagView.class, "largeMode", "getLargeMode()Z", 0))};
        k = new b(2131234872, 24, 11.0f, 234830674, 4);
        l = new b(2131234873, 14, 10.0f, 536820562, 0);
        m = ViewCompat.generateViewId();
        n = ViewCompat.generateViewId();
        o = ViewCompat.generateViewId();
        p = ViewCompat.generateViewId();
        q = ViewCompat.generateViewId();
    }

    private final TextView getCouponActionDescView() {
        return (TextView) this.d.getValue();
    }

    private final TextView getCouponDescTagView() {
        return (TextView) this.c.getValue();
    }

    private final View getRecoverView() {
        return (View) this.e.getValue();
    }

    public final boolean getLargeMode() {
        return ((Boolean) this.b.getValue(this, j[0])).booleanValue();
    }

    public final void setLargeMode(boolean r4) {
        this.b.setValue(this, j[0], Boolean.valueOf(r4));
    }

    public final lq3.b<d> getFansCouponSceneParam() {
        return this.i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v9, types: [android.view.View, android.widget.ImageView, com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView] */
    /* JADX WARN: Type inference failed for: r3v3, types: [android.view.View, android.widget.ImageView, com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView] */
    public WindowFollowCouponTagView(final Context r11) {
        Intrinsics.checkNotNullParameter(r11, "context");
        super(r11, null);
        this.a = l;
        Delegates r1 = Delegates.INSTANCE;
        Boolean r2 = Boolean.FALSE;
        this.b = new a(r2, r2, this);
        this.c = LazyKt.lazy(new WindowFollowCouponTagView$couponDescTagView$2(this, r11));
        this.d = LazyKt.lazy(new WindowFollowCouponTagView$couponActionDescView$2(this, r11));
        this.e = LazyKt.lazy(new WindowFollowCouponTagView$recoverView$2(this, r11));
        ?? r3 = new ECDraweeView(r11, null, 0, 6, null);
        r3.setAdjustMode(1);
        r3.setId(m);
        Unit r4 = Unit.INSTANCE;
        this.f = r3;
        ?? r5 = new ECDraweeView(r11, null, 0, 6, null);
        r5.setId(n);
        r5.setAdjustMode(1);
        r5.setScaleX(-1.0f);
        this.g = r5;
        FrameLayout r6 = new FrameLayout(r11, null);
        r6.setBackgroundColor(this.a.d);
        CouponVerticalDashView r7 = new CouponVerticalDashView(r11, null);
        r7.setConfig(new CouponVerticalDashView.a(q.a(2), q.a(2), q.a(Double.valueOf(-0.8d))));
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(RangesKt.coerceAtLeast(com.bytedance.android.shopping.extensions.b.b(1), 1), -1);
        int r8 = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(this.a.e));
        r0.setMargins(0, r8, 0, r8);
        r0.gravity = 17;
        r6.addView(r7, r0);
        r6.setId(q);
        this.h = r6;
        ImageView r9 = new ImageView(r11);
        r9.setScaleType(ImageView.ScaleType.FIT_XY);
        r9.setImageResource(2131234900);
        T5(r3);
        ConstraintLayout.LayoutParams r12 = new ConstraintLayout.LayoutParams(-2, -1);
        r12.leftToLeft = 0;
        r12.topToTop = 0;
        r12.bottomToBottom = 0;
        addView(r3, r12);
        T5(r5);
        ConstraintLayout.LayoutParams r13 = new ConstraintLayout.LayoutParams(-2, -1);
        r13.rightToRight = 0;
        r13.topToTop = 0;
        r13.bottomToBottom = 0;
        addView(r5, r13);
        TextView r14 = getCouponDescTagView();
        ConstraintLayout.LayoutParams r10 = new ConstraintLayout.LayoutParams(-2, -1);
        r10.leftToRight = r3.getId();
        r10.topToTop = 0;
        r10.bottomToBottom = 0;
        addView(r14, r10);
        ConstraintLayout.LayoutParams r15 = new ConstraintLayout.LayoutParams(com.bytedance.android.shopping.extensions.b.b(10), -1);
        r15.leftToRight = getCouponDescTagView().getId();
        r15.topToTop = 0;
        r15.bottomToBottom = 0;
        addView(r6, r15);
        TextView r16 = getCouponActionDescView();
        ConstraintLayout.LayoutParams r17 = new ConstraintLayout.LayoutParams(-2, -1);
        r17.leftToRight = r6.getId();
        r17.topToTop = 0;
        r17.bottomToBottom = 0;
        addView(r16, r17);
        View r18 = getRecoverView();
        ConstraintLayout.LayoutParams r19 = new ConstraintLayout.LayoutParams(0, -1);
        r19.leftToRight = getCouponActionDescView().getId();
        r19.rightToLeft = r5.getId();
        r19.topToTop = 0;
        r19.bottomToBottom = 0;
        addView(r18, r19);
        ConstraintLayout.LayoutParams r110 = new ConstraintLayout.LayoutParams(com.bytedance.android.shopping.extensions.b.b(12), com.bytedance.android.shopping.extensions.b.b(12));
        r110.leftToRight = getCouponActionDescView().getId();
        r110.topToTop = 0;
        r110.bottomToBottom = 0;
        addView(r9, r110);
    }

    public static final void R5(WindowFollowCouponTagView r3) {
        r3.getCouponDescTagView().setBackgroundColor(r3.a.d);
        r3.getCouponDescTagView().setTextSize(1, r3.a.c);
        r3.getCouponActionDescView().setBackgroundColor(r3.a.d);
        r3.getCouponActionDescView().setTextSize(1, r3.a.c);
        r3.getRecoverView().setBackgroundColor(r3.a.d);
        r3.T5(r3.f);
        r3.T5(r3.g);
        r3.h.setBackgroundColor(r3.a.d);
        View r0 = r3.h.getChildAt(0);
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
        if (r2 == null) goto L7;
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) r2;
        int r5 = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r3.a.e));
        r4.setMargins(0, r5, 0, r5);
        Unit r6 = Unit.INSTANCE;
        r0.setLayoutParams(r4);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final void T5(ECDraweeView r3) {
        r3.setAdjustMode(1);
        ImageRequest r0 = ImageRequestBuilder.newBuilderWithResourceId(this.a.a).build();
        r3.setController(Fresco.newDraweeControllerBuilder().setImageRequest(r0).build());
    }

    public final void S5(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "discountMsg");
        Intrinsics.checkNotNullParameter(r3, "actionMsg");
        Intrinsics.checkNotNullParameter(r4, "couponId");
        Intrinsics.checkNotNullParameter(r5, "promotionId");
        getCouponDescTagView().setText(r2);
        getCouponActionDescView().setText(r3);
        this.i = new lq3.b(lq3.c.a, new d(r4, r5));
    }
}
