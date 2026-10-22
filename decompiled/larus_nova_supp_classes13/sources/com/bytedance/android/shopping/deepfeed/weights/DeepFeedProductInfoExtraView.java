package com.bytedance.android.shopping.deepfeed.weights;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.Observer;
import com.bytedance.android.shopping.deepfeed.data.api.Coupon;
import com.bytedance.android.shopping.deepfeed.data.api.CouponData;
import com.bytedance.android.shopping.deepfeed.data.api.CouponMeta;
import com.bytedance.android.shopping.deepfeed.weights.common.DeepFeedCountDownRecView;
import com.bytedance.android.shopping.deepfeed.weights.common.ProductPriceView;
import com.bytedance.android.shopping.deepfeed.weights.common.ProductQcpxTimeView;
import com.bytedance.android.shopping.deepfeed.weights.common.ProductRecommendView;
import com.bytedance.android.shopping.deepfeed.weights.common.ProductTextView;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductPackData;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductPackDataElements;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import he3.e1;
import he3.p0;
import he3.q1;
import he3.r1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedProductInfoExtraView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedProductInfoExtraView extends ConstraintLayout {
    public final ProductPriceView a;
    public final ProductTextView b;
    public final SalesViewContainer c;
    public final ProductRecommendView d;
    public final ProductRecommendView e;
    public final ProductRecommendView f;
    public final ProductRecommendView g;
    public final ProductRecommendView h;
    public final ProductRecommendView i;
    public final DeepFeedProductInfoMarqueeView j;
    public final ProductQcpxTimeView k;
    public final DeepFeedCountDownRecView l;
    public final View m;
    public InFeedProductV2 n;

    public static final class a implements Runnable {
        public final /* synthetic */ DeepFeedProductInfoExtraView a;

        public a(DeepFeedProductInfoExtraView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.requestLayout();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ DeepFeedProductInfoExtraView a;

        public b(DeepFeedProductInfoExtraView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r11) {
            uc3.c r12 = (uc3.c) r11;
            CouponData r0 = r12.a();
            Integer r1 = null;
            if (r0 == null) goto L5;
            Coupon r2 = r0.getCoupon();
        L6:
            InFeedProductV2 r3 = this.a.n;
            if (r3 == null) goto L19;
            InFeedProductPackData r4 = r3.getPackData();
            if (r4 == null) goto L19;
            InFeedProductPackDataElements r5 = r4.getElements();
            if (r5 == null) goto L19;
            List<p0> r6 = r5.getProducts();
            if (r6 == null) goto L19;
            p0 r7 = (p0) CollectionsKt.firstOrNull(r6);
            if (r7 == null) goto L19;
            e1 r8 = r7.b();
            if (r8 == null) goto L19;
            String r9 = r8.a();
        L20:
            CouponData r10 = r12.a();
            if (r10 == null) goto L25;
            CouponMeta r13 = r10.getCouponMeta();
            if (r13 == null) goto L25;
            String r14 = r13.getProductId();
        L27:
            if (Intrinsics.areEqual(r9, r14) == false) goto L64;
            if (r2 == null) goto L64;
            if (com.bytedance.android.shopping.deepfeed.utlis.a.g(r2) != true) goto L64;
            this.a.k.setVisibility(0);
            ProductQcpxTimeView r15 = this.a.k;
            r15.getClass();
            CouponData r16 = r12.a();
            if (r16 == null) goto L34;
            Coupon r17 = r16.getCoupon();
        L35:
            if (r16 == null) goto L37;
            CouponMeta r18 = r16.getCouponMeta();
        L38:
            if (r17 == null) goto L40;
            r1 = r17.getStatus();
        L40:
            if (r1 == null) goto L61;
            if (r1.intValue() != 1) goto L61;
            if (r17.getCountDown() == null) goto L61;
            long r19 = 0;
            if (r17.getCountDown().longValue() <= 0) goto L61;
            r15.setVisibility(0);
            if (r18 == null) goto L53;
            Long r20 = r18.getThreshold();
            if (r20 == null) goto L53;
            long r21 = r20.longValue();
        L54:
            long r22 = 100;
            long r23 = r21 / r22;
            if (r18 == null) goto L59;
            Long r110 = r18.getCredit();
            if (r110 == null) goto L59;
            r19 = r110.longValue();
        L59:
            r15.b.setText("满" + r23 + 20943 + (r19 / r22) + " · ");
            r15.c = r17.getCountDown().longValue();
            r15.removeCallbacks(r15.d);
            r15.a();
            r15.postDelayed(r15.d, 1000);
        L53:
            r21 = 0;
        L61:
            if (tc3.f.b() == false) goto L63;
            DeepFeedProductInfoExtraView r111 = this.a;
            InFeedProductV2 r24 = r111.n;
            Intrinsics.checkNotNull(r24);
            r111.V5(r24, MarqueeViewItemType.HAS_QCPX_VIEW);
            return;
        L63:
            this.a.l.setVisibility(8);
            this.a.d.setVisibility(8);
            this.a.e.setVisibility(8);
            return;
        L37:
            r18 = null;
            goto L38
        L34:
            r17 = null;
        L64:
            this.a.k.setVisibility(8);
            if (tc3.f.b() == false) goto L67;
            DeepFeedProductInfoExtraView r112 = this.a;
            InFeedProductV2 r25 = r112.n;
            Intrinsics.checkNotNull(r25);
            r112.V5(r25, MarqueeViewItemType.TWO_REC_REASON_VIEW);
            return;
        L67:
            DeepFeedProductInfoExtraView r113 = this.a;
            InFeedProductV2 r26 = r113.n;
            Intrinsics.checkNotNull(r26);
            r113.S5(r26);
            return;
        L25:
            r14 = null;
        L19:
            r9 = null;
            goto L20
        L5:
            r2 = null;
            goto L6
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ DeepFeedProductInfoExtraView a;

        public c(DeepFeedProductInfoExtraView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.requestLayout();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ DeepFeedProductInfoExtraView a;

        public d(DeepFeedProductInfoExtraView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.j.requestLayout();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ DeepFeedProductInfoExtraView a;

        public e(DeepFeedProductInfoExtraView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.j.requestLayout();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public DeepFeedProductInfoExtraView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DeepFeedProductInfoExtraView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public static Pair U5(InFeedProductV2 r3) {
        he3.l r4 = r3.getDynamicData().d;
        if (r4 == null) goto L20;
        Map<Long, he3.j> r5 = r4.b();
        if (r5 == null) goto L22;
        Collection<he3.j> r6 = r5.values();
        if (r6 == null) goto L23;
        he3.j r7 = (he3.j) CollectionsKt.firstOrNull(r6);
        if (r7 == null) goto L24;
        he3.i r0 = r7.b();
        if (r0 == null) goto L25;
        String r8 = r7.a();
        if (r8 == null) goto L17;
        Long r9 = StringsKt.toLongOrNull(r8);
        if (r9 == null) goto L17;
        long r1 = r9.longValue();
    L19:
        return TuplesKt.to(r0, Long.valueOf(r1));
    L17:
        r1 = -1;
        goto L19
    L25:
        return null;
    L24:
        return null;
    L23:
        return null;
    L22:
        return null;
    L20:
        return null;
    }

    public final void S5(InFeedProductV2 r6) {
        InFeedProductPackData r0 = r6.getPackData();
        if (r0 == null) goto L52;
        InFeedProductPackDataElements r1 = r0.getElements();
        if (r1 == null) goto L53;
        List<p0> r2 = r1.getProducts();
        if (r2 == null) goto L54;
        p0 r3 = (p0) CollectionsKt.firstOrNull(r2);
        if (r3 != null) goto L12;
        return;
    L12:
        if (U5(r6) == null) goto L14;
        boolean r7 = true;
    L16:
        if (r7 == false) goto L19;
        this.d.setVisibility(8);
        this.e.setVisibility(8);
        this.k.setVisibility(8);
        return;
    L19:
        this.l.setVisibility(8);
        r1 r8 = r3.m();
        if (r8 == null) goto L50;
        List<q1> r9 = r8.a();
        if (r9 == null) goto L50;
        if (r9.size() < 2) goto L41;
        r1 r10 = r3.m();
        if (r10 == null) goto L32;
        List<q1> r11 = r10.a();
        if (r11 == null) goto L32;
        q1 r12 = (q1) CollectionsKt.getOrNull(r11, 1);
        if (r12 == null) goto L32;
        this.d.a(r12);
        this.d.setVisibility(0);
    L33:
        r1 r13 = r3.m();
        if (r13 == null) goto L40;
        List<q1> r14 = r13.a();
        if (r14 == null) goto L40;
        q1 r15 = (q1) CollectionsKt.getOrNull(r14, 0);
        if (r15 == null) goto L40;
        this.e.a(r15);
        this.e.setVisibility(0);
        return;
    L40:
        this.e.setVisibility(8);
        return;
    L32:
        this.d.setVisibility(8);
        goto L33
    L41:
        r1 r16 = r3.m();
        if (r16 == null) goto L48;
        List<q1> r17 = r16.a();
        if (r17 == null) goto L48;
        q1 r18 = (q1) CollectionsKt.getOrNull(r17, 0);
        if (r18 == null) goto L48;
        this.d.a(r18);
        this.d.setVisibility(0);
    L49:
        this.e.setVisibility(8);
        return;
    L48:
        this.d.setVisibility(8);
    L50:
        this.d.setVisibility(8);
        this.e.setVisibility(8);
        return;
    L14:
        r7 = false;
        goto L16
    L54:
        return;
    L53:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void V5(InFeedProductV2 r4, MarqueeViewItemType r5) {
        int r6 = l.a[r5.ordinal()];
        if (r6 != 1) goto L5;
        this.j.setVisibility(8);
        this.k.setVisibility(8);
        post(new c(this));
        return;
    L5:
        if (r6 != 2) goto L7;
        this.j.setVisibility(8);
        this.l.setVisibility(8);
        post(new d(this));
        return;
    L7:
        if (r6 != 3) goto L15;
        this.j.setVisibility(0);
        this.f.setVisibility(0);
        this.g.setVisibility(0);
        this.h.setVisibility(0);
        this.i.setVisibility(0);
        this.k.setVisibility(8);
        this.l.setVisibility(8);
        T5(r4, 0, this.f, this.g);
        T5(r4, 1, this.h, this.i);
        this.j.post(new e(this));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v3, types: [android.view.ViewGroup, com.bytedance.android.shopping.deepfeed.weights.DeepFeedProductInfoMarqueeView] */
    public final void onMeasure(int r14, int r15) {
        super.onMeasure(r14, r15);
        int r16 = View.MeasureSpec.getSize(r14);
        Iterator r0 = com.bytedance.commerce.base.view.b.a(this).iterator();
        int r2 = 0;
        boolean r3 = false;
        int r4 = 0;
        int r5 = 0;
    L4:
        if (r0.hasNext() == false) goto L91;
        Object r6 = r0.next();
        int r7 = r4 + 1;
        if (r4 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        ConstraintLayout r8 = (View) r6;
        if (r8.getVisibility() != 0) goto L11;
        boolean r9 = true;
    L12:
        if (r9 == false) goto L90;
        ViewGroup.LayoutParams r10 = null;
        if ((r8 instanceof DeepFeedCountDownRecView) == false) goto L28;
        ConstraintLayout r11 = (DeepFeedCountDownRecView) r8;
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        if ((r12 instanceof ViewGroup.MarginLayoutParams) == true) goto L19;
        r12 = null;
    L19:
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r12;
        int r17 = getPaddingTop() + getPaddingBottom();
        if (r13 == null) goto L22;
        int r18 = r13.topMargin;
    L23:
        int r19 = r17 + r18;
        if (r13 == null) goto L26;
        int r110 = r13.bottomMargin;
    L27:
        r8.measure(View.MeasureSpec.makeMeasureSpec(r16, 0), ViewGroup.getChildMeasureSpec(r15, r19 + r110, r11.getLayoutParams().height));
    L30:
        if ((r8 instanceof DeepFeedProductInfoMarqueeView) == false) goto L63;
        ?? r20 = (DeepFeedProductInfoMarqueeView) r8;
        View r21 = r20.a;
        if (r21 == null) goto L35;
        List r22 = com.bytedance.commerce.base.view.b.a(r21);
        if (r22 == null) goto L35;
    L36:
        View r23 = r20.b;
        if (r23 == null) goto L40;
        List r24 = com.bytedance.commerce.base.view.b.a(r23);
        if (r24 == null) goto L40;
    L41:
        Pair r25 = DeepFeedProductInfoMarqueeView.S5(r22, r16, r5, r15);
        int r111 = ((Number) r25.component1()).intValue();
        boolean r26 = ((Boolean) r25.component2()).booleanValue();
        Pair r27 = DeepFeedProductInfoMarqueeView.S5(r24, r16, r5, r15);
        int r28 = ((Number) r27.component1()).intValue();
        boolean r29 = ((Boolean) r27.component2()).booleanValue();
        Integer r30 = Integer.valueOf(Math.max(r111, r28));
        if (r26 == true) goto L46;
        if (r29 == true) goto L46;
        boolean r31 = false;
    L47:
        Pair r32 = TuplesKt.to(r30, Boolean.valueOf(r31));
        int r33 = ((Number) r32.component1()).intValue();
        boolean r34 = ((Boolean) r32.component2()).booleanValue();
        ViewGroup.LayoutParams r35 = r20.getLayoutParams();
        if ((r35 instanceof ViewGroup.MarginLayoutParams) == false) goto L51;
        r10 = r35;
    L51:
        ViewGroup.MarginLayoutParams r36 = (ViewGroup.MarginLayoutParams) r10;
        if (r36 == null) goto L54;
        int r37 = r36.leftMargin;
    L55:
        int r38 = r33 + r37;
        if (r36 == null) goto L58;
        int r39 = r36.rightMargin;
    L59:
        int r40 = r38 + r39;
        if (r34 == false) goto L62;
        r2 = r40;
    L87:
        r5 = r2;
        r3 = true;
        goto L90
    L62:
        r2 = r40;
    L89:
        r5 = r2;
        goto L90
    L58:
        r39 = 0;
        goto L59
    L54:
        r37 = 0;
    L46:
        r31 = true;
    L40:
        r24 = CollectionsKt.emptyList();
    L35:
        r22 = CollectionsKt.emptyList();
        goto L36
    L63:
        ViewGroup.LayoutParams r41 = r8.getLayoutParams();
        if ((r41 instanceof ViewGroup.MarginLayoutParams) == false) goto L67;
        r10 = r41;
    L67:
        ViewGroup.MarginLayoutParams r42 = (ViewGroup.MarginLayoutParams) r10;
        if (r4 != 0) goto L76;
        int r43 = r8.getMeasuredWidth();
        if (r42 == null) goto L72;
        int r44 = r42.leftMargin;
    L73:
        int r45 = r43 + r44;
        if (r42 == null) goto L83;
        int r46 = r42.rightMargin;
    L84:
        int r47 = r45 + r46;
        int r48 = r5 + r47;
        if (r48 <= r16) goto L88;
        r8.setVisibility(8);
        r2 = r48 - r47;
        goto L87
    L88:
        r2 = r48;
    L83:
        r46 = 0;
        goto L84
    L72:
        r44 = 0;
        goto L73
    L76:
        int r49 = r8.getMeasuredWidth();
        if (r42 == null) goto L79;
        int r50 = r42.leftMargin;
    L80:
        r45 = r49 + r50;
        if (r42 == null) goto L83;
        r46 = r42.rightMargin;
        goto L84
    L79:
        r50 = 0;
        goto L80
    L26:
        r110 = 0;
        goto L27
    L22:
        r18 = 0;
        goto L23
    L28:
        r8.measure(View.MeasureSpec.makeMeasureSpec(r16, 0), r15);
    L90:
        r4 = r7;
        goto L4
    L11:
        r9 = false;
        goto L12
    L91:
        setMeasuredDimension(r2, getMeasuredHeight());
        if (r3 == false) goto L99;
        post(new a(this));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [android.view.View, android.view.ViewGroup, androidx.constraintlayout.widget.ConstraintLayout, com.bytedance.android.shopping.deepfeed.weights.DeepFeedProductInfoMarqueeView] */
    /* JADX WARN: Type inference failed for: r6v3, types: [android.view.View, android.widget.TextView, androidx.appcompat.widget.AppCompatTextView, com.bytedance.android.shopping.deepfeed.weights.common.ProductTextView] */
    /* JADX WARN: Type inference failed for: r9v10, types: [android.view.View, com.bytedance.android.shopping.deepfeed.weights.common.DeepFeedCountDownRecView] */
    public DeepFeedProductInfoExtraView(Context r23, AttributeSet r24, int r25) {
        Intrinsics.checkNotNullParameter(r23, "context");
        super(r23, r24, r25);
        ProductPriceView r2 = new ProductPriceView(r23, null, 6, 0);
        r2.setId(ViewCompat.generateViewId());
        r2.setGravity(80);
        Unit r6 = Unit.INSTANCE;
        this.a = r2;
        ?? r7 = new ProductTextView(r23, null, 6, 0);
        r7.setId(ViewCompat.generateViewId());
        r7.setIncludeFontPadding(false);
        r7.setMaxLines(1);
        com.bytedance.android.shopping.deepfeed.ui.view.a r8 = com.bytedance.android.shopping.deepfeed.ui.view.a.e;
        r7.setTextSize(0, com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r23, 12));
        r7.setTextColor(ColorProtector.parseColor("#FFFF3344"));
        this.b = r7;
        SalesViewContainer r9 = new SalesViewContainer(r23, null, 6, 0);
        this.c = r9;
        ProductRecommendView r10 = new ProductRecommendView(r23, null, 6, 0);
        r10.setId(ViewCompat.generateViewId());
        r10.setGravity(17);
        this.d = r10;
        ProductRecommendView r11 = new ProductRecommendView(r23, null, 6, 0);
        r11.setId(ViewCompat.generateViewId());
        r11.setGravity(17);
        this.e = r11;
        ProductRecommendView r12 = new ProductRecommendView(r23, null, 6, 0);
        r12.setId(ViewCompat.generateViewId());
        r12.setGravity(17);
        this.f = r12;
        ProductRecommendView r13 = new ProductRecommendView(r23, null, 6, 0);
        r13.setId(ViewCompat.generateViewId());
        r13.setGravity(17);
        this.g = r13;
        ProductRecommendView r14 = new ProductRecommendView(r23, null, 6, 0);
        r14.setId(ViewCompat.generateViewId());
        r14.setGravity(17);
        this.h = r14;
        ProductRecommendView r15 = new ProductRecommendView(r23, null, 6, 0);
        r15.setId(ViewCompat.generateViewId());
        r15.setGravity(17);
        this.i = r15;
        ?? r4 = new DeepFeedProductInfoMarqueeView(r23, null);
        r4.setId(ViewCompat.generateViewId());
        this.j = r4;
        ConstraintLayout r3 = new ConstraintLayout(r23);
        r3.setId(ViewCompat.generateViewId());
        r3.setLayoutParams(new ConstraintLayout.LayoutParams(-2, com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r23, 16)));
        ConstraintLayout r5 = new ConstraintLayout(r23);
        r5.setId(ViewCompat.generateViewId());
        r5.setLayoutParams(new ConstraintLayout.LayoutParams(-2, com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r23, 16)));
        ProductQcpxTimeView r16 = new ProductQcpxTimeView(r23, null, 6, 0);
        r16.setId(ViewCompat.generateViewId());
        r16.setGravity(17);
        r16.setVisibility(8);
        this.k = r16;
        ?? r17 = new DeepFeedCountDownRecView(r23, null, 6, 0);
        this.l = r17;
        View r18 = new View(r23);
        r18.setId(ViewCompat.generateViewId());
        r18.setBackgroundColor(ColorProtector.parseColor("#F8F8F8"));
        this.m = r18;
        new b(this);
        ConstraintLayout.LayoutParams r1 = new ConstraintLayout.LayoutParams(-2, -2);
        r1.leftToLeft = 0;
        r1.bottomToBottom = 0;
        r1.rightToLeft = r7.getId();
        addView(r2, r1);
        boolean r19 = tc3.f.d();
        Double r110 = Double.valueOf(0.5d);
        if (r19 == true) goto L5;
        ProductRecommendView r20 = r11;
        SalesViewContainer r21 = r9;
        ConstraintLayout.LayoutParams r111 = new ConstraintLayout.LayoutParams(-2, com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(getContext(), 16));
        r111.bottomToBottom = 0;
        r111.leftToRight = r7.getId();
        ((ViewGroup.MarginLayoutParams) r111).leftMargin = com.bytedance.android.shopping.extensions.b.b(4);
        addView(r21, r111);
        if (tc3.f.b() == false) goto L16;
        R5(r3, r12, r13);
        R5(r5, r14, r15);
        r4.R5(r3, r5);
        int r112 = 16;
        int r113 = -2;
        ConstraintLayout.LayoutParams r22 = new ConstraintLayout.LayoutParams(-2, com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(getContext(), 16));
        int r114 = 0;
        r22.bottomToBottom = 0;
        r22.rightToRight = 0;
        ((ViewGroup.MarginLayoutParams) r22).leftMargin = com.bytedance.android.shopping.extensions.b.b(12);
        addView(r4, r22);
        ProductRecommendView r115 = r10;
    L17:
        ConstraintLayout.LayoutParams r26 = new ConstraintLayout.LayoutParams(r113, com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(getContext(), r112));
        r26.bottomToBottom = r114;
        r26.rightToRight = r114;
        addView(r16, r26);
        ConstraintLayout.LayoutParams r27 = new ConstraintLayout.LayoutParams(r113, com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(getContext(), r112));
        r27.bottomToBottom = r114;
        r27.leftToRight = r2.getId();
        r27.rightToLeft = r21.getId();
        ((ViewGroup.MarginLayoutParams) r27).leftMargin = com.bytedance.android.shopping.extensions.b.b(2);
        ((ViewGroup.MarginLayoutParams) r27).bottomMargin = com.bytedance.android.shopping.extensions.b.b(r110);
        addView(r7, r27);
        ConstraintLayout.LayoutParams r28 = new ConstraintLayout.LayoutParams(com.bytedance.android.shopping.extensions.b.b(180), -2);
        r28.leftToLeft = 0;
        r28.topToTop = 0;
        r28.bottomToBottom = 0;
        addView(r18, r28);
        ConstraintLayout.LayoutParams r29 = new ConstraintLayout.LayoutParams(-2, com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(getContext(), 16));
        r29.rightToRight = 0;
        r29.bottomToBottom = 0;
        addView(r17, r29);
    L19:
        if (tc3.f.e() == false) goto L41;
        Integer r30 = tc3.f.c();
        if (r30 != null) goto L25;
    L27:
        Integer r31 = tc3.f.c();
        if (r31 != null) goto L31;
    L33:
        o.a(r21, 20);
        if (tc3.f.b() == true) goto L37;
        o.a(r20, 20);
        o.a(r115, 20);
    L37:
        if (tc3.f.b() == false) goto L40;
        o.a(r4, 20);
        o.a(r3, 20);
        o.a(r5, 20);
        return;
    L40:
        return;
    L31:
        if (r31.intValue() != 2) goto L33;
        o.a(r2, 23);
        goto L33
    L25:
        if (r30.intValue() != 1) goto L27;
        o.a(r2, 29);
        goto L33
    L41:
        return;
    L16:
        ConstraintLayout.LayoutParams r116 = new ConstraintLayout.LayoutParams(-2, com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(getContext(), 16));
        r116.bottomToBottom = 0;
        r116.rightToLeft = r10.getId();
        ((ViewGroup.MarginLayoutParams) r116).rightMargin = com.bytedance.android.shopping.extensions.b.b(8);
        ((ViewGroup.MarginLayoutParams) r116).leftMargin = com.bytedance.android.shopping.extensions.b.b(12);
        addView(r20, r116);
        r112 = 16;
        r113 = -2;
        ConstraintLayout.LayoutParams r32 = new ConstraintLayout.LayoutParams(-2, com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(getContext(), 16));
        r114 = 0;
        r32.bottomToBottom = 0;
        r32.rightToRight = 0;
        r115 = r10;
        addView(r115, r32);
        goto L17
    L5:
        if (tc3.f.b() == false) goto L7;
        R5(r3, r12, r13);
        R5(r5, r14, r15);
        r4.R5(r3, r5);
        int r117 = -2;
        ConstraintLayout.LayoutParams r33 = new ConstraintLayout.LayoutParams(-2, com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(getContext(), 16));
        r33.bottomToBottom = 0;
        r33.leftToRight = r7.getId();
        ((ViewGroup.MarginLayoutParams) r33).leftMargin = com.bytedance.android.shopping.extensions.b.b(12);
        addView(r4, r33);
        r20 = r11;
        int r118 = 0;
        int r119 = 16;
    L8:
        ConstraintLayout.LayoutParams r120 = new ConstraintLayout.LayoutParams(r117, com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(getContext(), r119));
        r120.bottomToBottom = r118;
        r120.rightToRight = r118;
        ((ViewGroup.MarginLayoutParams) r120).leftMargin = com.bytedance.android.shopping.extensions.b.b(4);
        r21 = r9;
        addView(r21, r120);
        ConstraintLayout.LayoutParams r121 = new ConstraintLayout.LayoutParams(r117, com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(getContext(), r119));
        r121.bottomToBottom = 0;
        r121.leftToRight = r7.getId();
        ((ViewGroup.MarginLayoutParams) r121).leftMargin = com.bytedance.android.shopping.extensions.b.b(12);
        addView(r16, r121);
        ConstraintLayout.LayoutParams r122 = new ConstraintLayout.LayoutParams(r117, com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(getContext(), r119));
        r122.bottomToBottom = 0;
        r122.leftToRight = r2.getId();
        if (tc3.f.b() == false) goto L11;
        int r123 = r4.getId();
    L12:
        r122.rightToLeft = r123;
        ((ViewGroup.MarginLayoutParams) r122).leftMargin = com.bytedance.android.shopping.extensions.b.b(2);
        ((ViewGroup.MarginLayoutParams) r122).bottomMargin = com.bytedance.android.shopping.extensions.b.b(r110);
        addView(r7, r122);
        ConstraintLayout.LayoutParams r124 = new ConstraintLayout.LayoutParams(com.bytedance.android.shopping.extensions.b.b(180), -2);
        r124.leftToLeft = 0;
        r124.topToTop = 0;
        r124.bottomToBottom = 0;
        addView(r18, r124);
        ConstraintLayout.LayoutParams r34 = new ConstraintLayout.LayoutParams(-2, com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(getContext(), 16));
        r34.leftToRight = r7.getId();
        r34.bottomToBottom = 0;
        ((ViewGroup.MarginLayoutParams) r34).leftMargin = com.bytedance.android.shopping.extensions.b.b(12);
        addView(r17, r34);
        r115 = r10;
        goto L19
    L11:
        r123 = r20.getId();
        goto L12
    L7:
        ConstraintLayout.LayoutParams r125 = new ConstraintLayout.LayoutParams(-2, com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(getContext(), 16));
        r125.bottomToBottom = 0;
        r125.leftToRight = r7.getId();
        r125.rightToLeft = r10.getId();
        ((ViewGroup.MarginLayoutParams) r125).leftMargin = com.bytedance.android.shopping.extensions.b.b(12);
        r20 = r11;
        addView(r20, r125);
        r119 = 16;
        ConstraintLayout.LayoutParams r126 = new ConstraintLayout.LayoutParams(-2, com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(getContext(), 16));
        r126.bottomToBottom = 0;
        r126.leftToRight = r20.getId();
        ((ViewGroup.MarginLayoutParams) r126).leftMargin = com.bytedance.android.shopping.extensions.b.b(8);
        addView(r10, r126);
        r118 = 0;
        r117 = -2;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(ConstraintLayout r6, ProductRecommendView r7, ProductRecommendView r8) {
        if (tc3.f.e() == false) goto L5;
        int r0 = 20;
    L6:
        com.bytedance.android.shopping.deepfeed.ui.view.a r2 = com.bytedance.android.shopping.deepfeed.ui.view.a.e;
        ViewGroup.LayoutParams r1 = new ConstraintLayout.LayoutParams(-2, com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(getContext(), r0));
        ((ConstraintLayout.LayoutParams) r1).topToTop = 0;
        ((ConstraintLayout.LayoutParams) r1).bottomToBottom = 0;
        ((ConstraintLayout.LayoutParams) r1).leftToLeft = 0;
        ((ConstraintLayout.LayoutParams) r1).rightToLeft = r7.getId();
        Unit r4 = Unit.INSTANCE;
        r6.addView(r8, r1);
        ConstraintLayout.LayoutParams r3 = new ConstraintLayout.LayoutParams(-2, com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(getContext(), r0));
        r3.topToTop = 0;
        r3.bottomToBottom = 0;
        r3.leftToRight = r8.getId();
        ((ViewGroup.MarginLayoutParams) r3).leftMargin = com.bytedance.android.shopping.extensions.b.b(8);
        r6.addView(r7, r3);
        return;
    L5:
        r0 = 16;
        goto L6
    }

    public final void Y5(InFeedProductV2 r2, com.bytedance.android.shopping.deepfeed.action.h r3, boolean r4) {
        InFeedProductPackData r5 = r2.getPackData();
        if (r5 == null) goto L9;
        InFeedProductPackDataElements r6 = r5.getElements();
        if (r6 == null) goto L9;
        List<p0> r7 = r6.getProducts();
        if (r7 == null) goto L9;
        p0 r8 = (p0) CollectionsKt.firstOrNull(r7);
    L10:
        U5(r2);
        r3.d();
        System.currentTimeMillis();
        if (r8 != null) goto L13;
        this.l.setVisibility(8);
        this.d.setVisibility(8);
        this.e.setVisibility(8);
        return;
    L13:
        if (tc3.f.b() == false) goto L15;
        V5(r2, MarqueeViewItemType.TWO_REC_REASON_VIEW);
    L16:
        this.l.setVisibility(8);
        this.c.setVisibility(0);
        return;
    L15:
        S5(r2);
    L9:
        r8 = null;
        goto L10
    }

    public /* synthetic */ DeepFeedProductInfoExtraView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public static void T5(InFeedProductV2 r5, int r6, ProductRecommendView r7, ProductRecommendView r8) {
        InFeedProductPackData r9 = r5.getPackData();
        if (r9 == null) goto L52;
        InFeedProductPackDataElements r10 = r9.getElements();
        if (r10 == null) goto L53;
        List<p0> r11 = r10.getProducts();
        if (r11 == null) goto L54;
        p0 r12 = (p0) CollectionsKt.firstOrNull(r11);
        if (r12 == null) goto L58;
        r1 r13 = r12.m();
        if (r13 == null) goto L27;
        List<q1> r14 = r13.a();
        if (r14 == null) goto L27;
        ArrayList r2 = new ArrayList();
        Iterator<T> r15 = r14.iterator();
    L17:
        if (r15.hasNext() == false) goto L29;
        Object r3 = r15.next();
        Integer r4 = ((q1) r3).a();
        if (r4 != null) goto L22;
    L24:
        boolean r16 = false;
    L25:
        if (r16 == false) goto L17;
        r2.add(r3);
        goto L17
    L22:
        if (r4.intValue() != r6) goto L24;
        r16 = true;
    L29:
        if (r2 != null) goto L31;
        r7.setVisibility(8);
        r8.setVisibility(8);
        return;
    L31:
        if (r2.size() < 2) goto L40;
        q1 r17 = (q1) CollectionsKt.getOrNull(r2, 1);
        if (r17 == null) goto L35;
        r7.a(r17);
        r7.setVisibility(0);
    L36:
        q1 r18 = (q1) CollectionsKt.getOrNull(r2, 0);
        if (r18 == null) goto L39;
        r8.a(r18);
        r8.setVisibility(0);
        return;
    L39:
        r8.setVisibility(8);
        return;
    L35:
        r7.setVisibility(8);
        goto L36
    L40:
        q1 r19 = (q1) CollectionsKt.getOrNull(r2, 0);
        if (r19 == null) goto L43;
        r8.a(r19);
        r8.setVisibility(0);
    L44:
        r7.setVisibility(8);
        return;
    L43:
        r8.setVisibility(8);
    L27:
        r2 = null;
        goto L29
    L58:
        return;
    L54:
        return;
    L53:
        return;
    }
}
