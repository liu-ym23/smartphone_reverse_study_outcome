package com.bytedance.awemeopen.apps.framework.feed.ui.information.poi;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.lifecycle.Observer;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView;
import com.bytedance.awemeopen.bizmodels.feed.poi.MinorTag;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class m extends com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c<p, q> {
    public DmtTextView e;
    public ImageView f;
    public AoImageView g;
    public ViewGroup h;
    public ViewGroup i;
    public AoImageView j;
    public DmtTextView k;
    public ImageView l;
    public ViewGroup m;
    public AoImageView n;
    public DmtTextView o;
    public q.a p;
    public i q;
    public boolean r;
    public AnimatorSet s;

    public static final class a {
        public final MinorTag a;
        public boolean b;
        public final int c;
        public int d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v5 */
        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            boolean r1 = this.b;
            ?? r2 = r1;
            if (r1 == false) goto L6;
            r2 = 1;
        L6:
            return ((((r0 + r2) * 31) + this.c) * 31) + this.d;
        }

        public final String toString() {
            return "SecondLineTagItem(tag=" + this.a + ", shouldAppendDivider=" + this.b + ", marginStart=" + this.c + ", contentWidth=" + this.d + ')';
        }

        public a(MinorTag r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "tag");
            this.a = r2;
            this.b = false;
            this.c = r3;
            this.d = r4;
        }
    }

    public final DmtTextView f() {
        DmtTextView r0 = this.k;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mAnchorTag");
        return null;
    }

    public final DmtTextView g() {
        DmtTextView r0 = this.o;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mAnchorTitle");
        return null;
    }

    public final ViewGroup h() {
        ViewGroup r0 = this.i;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mFirstLineContainer");
        return null;
    }

    public final ImageView i() {
        ImageView r0 = this.l;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mIvDividerTop");
        return null;
    }

    public final ViewGroup j() {
        ViewGroup r0 = this.m;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mPoiExtendInfoContainer");
        return null;
    }

    public final ViewGroup k() {
        ViewGroup r0 = this.h;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mPoiInfoOutContainer");
        return null;
    }

    public final DmtTextView l() {
        DmtTextView r0 = this.e;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("poiType");
        return null;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final void c() {
        DmtTextView r0 = (DmtTextView) b().findViewById(2131382741);
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        this.e = r0;
        ImageView r1 = (ImageView) b().findViewById(2131369249);
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        this.f = r1;
        AoImageView r2 = b().findViewById(2131385946);
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.g = r2;
        ViewGroup r3 = (ViewGroup) b().findViewById(2131382660);
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        this.h = r3;
        ViewGroup r4 = (ViewGroup) b().findViewById(2131382658);
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.i = r4;
        AoImageView r5 = b().findViewById(2131376383);
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.j = r5;
        DmtTextView r6 = (DmtTextView) b().findViewById(2131379126);
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        this.k = r6;
        ImageView r7 = (ImageView) b().findViewById(2131369248);
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        this.l = r7;
        ViewGroup r8 = (ViewGroup) b().findViewById(2131382641);
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        this.m = r8;
        AoImageView r9 = b().findViewById(2131376558);
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        this.n = r9;
        DmtTextView r10 = (DmtTextView) b().findViewById(2131391763);
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.o = r10;
        q r11 = (q) this.c;
        Observer<q.b> r12 = new d(this);
        r11.getClass();
        Intrinsics.checkNotNullParameter(r12, "observer");
        r11.a.a(r12);
        q r13 = (q) this.c;
        Observer<q.a> r14 = new e(this);
        r13.getClass();
        Intrinsics.checkNotNullParameter(r14, "observer");
        r13.b.a(r14);
        b().setOnClickListener(new f(this));
    }

    public static boolean n(com.bytedance.awemeopen.bizmodels.feed.poi.b r1) {
        if ((r1 instanceof com.bytedance.awemeopen.bizmodels.feed.poi.b.d) == false) goto L5;
    L10:
        return true;
    L5:
        if ((r1 instanceof com.bytedance.awemeopen.bizmodels.feed.poi.b.c) == true) goto L10;
        if ((r1 instanceof com.bytedance.awemeopen.bizmodels.feed.poi.b.b) == true) goto L10;
        return false;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final View a(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "parentView");
        return LayoutInflater.from(getContext()).inflate(2131563424, r4, false);
    }

    public final void e(long r8) {
        Object[] r1 = new Object[1];
        StringBuilder r2 = new StringBuilder("ExpandView id:");
        q.a r3 = this.p;
        ViewGroup.MarginLayoutParams r4 = null;
        if (r3 == null) goto L5;
        String r5 = r3.a;
    L6:
        r2.append(r5);
        r2.append(" expendPoiAnchor hasExpanded:");
        r2.append(this.r);
        r2.append(", delayTime = ");
        r2.append(r8);
        r1[0] = r2.toString();
        AoLogger.b("PoiAnchorElementView", r1);
        q.a r6 = this.p;
        if (r6 != null) goto L11;
        this.q = new i(this, r8);
        return;
    L11:
        if (this.r == false) goto L13;
        return;
    L13:
        if (r6.b == true) goto L16;
        return;
    L16:
        if (r8 != 0) goto L24;
        j().setVisibility(0);
        j().setAlpha(0.0f);
        this.s.cancel();
        final ViewGroup r9 = j();
        this.s.cancel();
        r9.setVisibility(0);
        r9.setAlpha(0.0f);
        r9.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int r10 = RangesKt.coerceAtLeast(r9.getMeasuredHeight(), 0);
        ViewGroup r7 = k();
        int r11 = RangesKt.coerceAtLeast((h().getMeasuredHeight() + r7.getPaddingTop()) + r7.getPaddingBottom(), 0);
        int r12 = r10 + r11;
        ViewGroup.LayoutParams r13 = r9.getLayoutParams();
        if ((r13 instanceof ViewGroup.MarginLayoutParams) == false) goto L20;
        r4 = (ViewGroup.MarginLayoutParams) r13;
    L20:
        if (r4 != null) goto L22;
        int r14 = 0;
    L23:
        ValueAnimator r15 = ValueAnimator.ofInt(new int[]{r11, r12 + r14});
        r15.setDuration(320);
        Interpolator r16 = o.a;
        r15.setInterpolator(r16);
        r15.addUpdateListener(new k(this));
        ValueAnimator r17 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r17.setDuration(320);
        r17.setInterpolator(r16);
        r17.addUpdateListener(new l(r9));
        AnimatorSet r18 = new AnimatorSet();
        r18.playTogether(new Animator[]{r15, r17});
        r18.addListener(new n(r9, this));
        r18.start();
        this.s = r18;
        this.r = true;
        return;
    L22:
        r14 = r4.topMargin + r4.bottomMargin;
        goto L23
    L24:
        j().postDelayed(new j(this), r8);
        return;
    L5:
        r5 = null;
        goto L6
    }

    public final int m(View r2) {
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        if ((r3 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) r3;
    L6:
        if (r4 != null) goto L10;
        return 0;
    L10:
        return r4.getMarginStart() + r4.getMarginEnd();
    L5:
        r4 = null;
        goto L6
    }

    public final void p(final List<MinorTag> r19) {
        int r3 = 4;
        int r5 = -1;
        int r6 = -2;
        if (com.bytedance.awemeopen.apps.framework.feed.ui.information.a.q == true) goto L24;
        j().removeAllViews();
        Iterator<T> r2 = r19.iterator();
        com.bytedance.awemeopen.bizmodels.feed.poi.b r11 = null;
        int r10 = 0;
    L6:
        if (r2.hasNext() == false) goto L23;
        Object r12 = r2.next();
        int r13 = r10 + 1;
        if (r10 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        MinorTag r14 = (MinorTag) r12;
        MinorTagView r15 = new MinorTagView(j().getContext(), null, 6, 0);
        LinearLayout.LayoutParams r16 = new LinearLayout.LayoutParams(r6, r5);
        j().addView(r15, r16);
        if (r13 >= r19.size()) goto L13;
        com.bytedance.awemeopen.bizmodels.feed.poi.b r7 = ((MinorTag) ListProtector.get(r19, r13)).c;
    L14:
        com.bytedance.awemeopen.bizmodels.feed.poi.b r8 = r14.c;
        Pair r17 = new Pair(Boolean.valueOf(n(r11)), Boolean.valueOf(n(r7)));
        if (r13 != r19.size()) goto L17;
        Pair r9 = Pair.copy$default(r17, null, Boolean.FALSE, 1, null);
    L19:
        if (((Boolean) r17.getFirst()).booleanValue() == true) goto L22;
        if (r10 == 0) goto L22;
        Resources r18 = Resources.getSystem();
        r16.setMarginStart(MathKt.roundToInt(TypedValue.applyDimension(1, 4, WindowDisplayMetricsOverride.apply(r18, r18.getDisplayMetrics()))));
    L22:
        r15.c(r14, ((Boolean) r9.getSecond()).booleanValue());
        r11 = r14.c;
        r10 = r13;
        r5 = -1;
        r6 = -2;
        goto L6
    L17:
        r9 = r17;
        goto L19
    L13:
        r7 = null;
        goto L14
    L23:
        return;
    L24:
        j().removeAllViews();
        if (r19.isEmpty() == false) goto L27;
        return;
    L27:
        int r4 = h().getMeasuredWidth();
        if (r4 > 0) goto L31;
        j().post(new g(this, r19));
        return;
    L31:
        ArrayList r20 = new ArrayList();
        Iterator<T> r1 = r19.iterator();
        int r21 = 0;
    L33:
        if (r1.hasNext() == false) goto L69;
        MinorTag r110 = (MinorTag) r1.next();
        a r111 = (a) CollectionsKt.lastOrNull(r20);
        com.bytedance.awemeopen.bizmodels.feed.poi.b r112 = r110.c;
        if (r111 == null) goto L39;
        MinorTag r113 = r111.a;
        if (r113 == null) goto L39;
        com.bytedance.awemeopen.bizmodels.feed.poi.b r114 = r113.c;
    L41:
        if (((Boolean) new Pair(Boolean.valueOf(n(r114)), Boolean.valueOf(n(null))).getFirst()).booleanValue() == true) goto L44;
        if (r111 == null) goto L44;
        Resources r115 = Resources.getSystem();
        int r116 = MathKt.roundToInt(TypedValue.applyDimension(1, r3, WindowDisplayMetricsOverride.apply(r115, r115.getDisplayMetrics())));
    L45:
        if (r111 == null) goto L54;
        com.bytedance.awemeopen.bizmodels.feed.poi.b r117 = r111.a.c;
        com.bytedance.awemeopen.bizmodels.feed.poi.b r118 = r110.c;
        if (n(r117) == true) goto L49;
    L51:
        boolean r119 = false;
    L52:
        if (r119 == false) goto L54;
        boolean r120 = true;
    L55:
        if (r120 == false) goto L60;
        if (r111 == null) goto L60;
        if (r111.b == true) goto L60;
        int r121 = o(r111.a, true) - r111.d;
    L61:
        int r122 = o(r110, false);
        int r123 = r21 + r121;
        if (((r123 + r116) + r122) > r4) goto L68;
        if (r120 == false) goto L67;
        if (r111 == null) goto L67;
        r111.b = true;
        r111.d += r121;
        r21 = r123;
    L67:
        r20.add(new a(r110, r116, r122));
        r21 = r21 + (r116 + r122);
    L68:
        r3 = 4;
    L60:
        r121 = 0;
        goto L61
    L49:
        if (n(r118) == false) goto L51;
        r119 = true;
    L54:
        r120 = false;
    L44:
        r116 = 0;
    L39:
        r114 = null;
        goto L41
    L69:
        Iterator r22 = r20.iterator();
    L71:
        if (r22.hasNext() == false) goto L73;
        a r23 = (a) r22.next();
        MinorTagView r24 = new MinorTagView(j().getContext(), null, 6, 0);
        LinearLayout.LayoutParams r25 = new LinearLayout.LayoutParams(-2, -1);
        r25.setMarginStart(r23.c);
        r24.c(r23.a, r23.b);
        j().addView(r24, r25);
        goto L71
    }

    public final int o(MinorTag r6, boolean r7) {
        MinorTagView r0 = new MinorTagView(j().getContext(), null, 6, 0);
        r0.c(r6, r7);
        r0.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return r0.getMeasuredWidth();
    }

    public m(Context r2, p r3, q r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r4, "model");
        super(r2, r3, r4);
        this.s = new AnimatorSet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int d(int r5, List r6, DmtTextView r7, DmtTextView r8, List r9) {
        if (r5 > 0) goto L4;
        return Integer.MAX_VALUE;
    L4:
        if (r7.getVisibility() != 0) goto L41;
        List r10 = CollectionsKt.plus(r6, r9);
        ArrayList r11 = new ArrayList();
        Iterator r12 = r10.iterator();
    L7:
        boolean r1 = false;
        boolean r2 = true;
        if (r12.hasNext() == false) goto L14;
        Object r0 = r12.next();
        if (((View) r0).getVisibility() != 0) goto L12;
        r1 = true;
    L12:
        if (r1 == false) goto L7;
        r11.add(r0);
        goto L7
    L14:
        Iterator r13 = r11.iterator();
        int r14 = 0;
    L16:
        if (r13.hasNext() == false) goto L18;
        View r3 = (View) r13.next();
        r14 = r14 + (r3.getMeasuredWidth() + m(r3));
        goto L16
    L18:
        CharSequence r15 = r7.getText();
        if (r15 == null) goto L21;
        String r16 = r15.toString();
    L22:
        if (r16 != null) goto L25;
        r16 = "";
    L25:
        if (r16.length() == 0) goto L28;
        r2 = false;
    L28:
        if (r2 == false) goto L30;
        int r17 = 0;
    L32:
        return RangesKt.coerceAtMost(r17 + m(r7), RangesKt.coerceAtLeast((r5 - r14) - m(r8), 0));
    L30:
        r17 = (int) r7.getPaint().measureText(r16);
        goto L32
    L21:
        r16 = null;
        goto L22
    L41:
        return Integer.MAX_VALUE;
    }
}
