package com.bytedance.awemeopen.apps.framework.feed.ui.information.poi;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
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
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes14.dex */
public final class m extends com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c<p, q> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public DmtTextView f196278e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f196279f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AoImageView f196280g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ViewGroup f196281h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ViewGroup f196282i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public AoImageView f196283j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public DmtTextView f196284k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ImageView f196285l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ViewGroup f196286m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public AoImageView f196287n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public DmtTextView f196288o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public q.a f196289p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public i f196290q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f196291r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public AnimatorSet f196292s;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MinorTag f196293a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f196294b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f196295c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f196296d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f196293a, r101.f196293a) == true) goto L12;
            return false;
        L12:
            if (this.f196294b == r101.f196294b) goto L15;
            return false;
        L15:
            if (this.f196295c == r101.f196295c) goto L18;
            return false;
        L18:
            if (this.f196296d == r101.f196296d) goto L20;
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
            int r100 = this.f196293a.hashCode() * 31;
            boolean r101 = this.f196294b;
            ?? r102 = r101;
            if (r101 == false) goto L6;
            r102 = 1;
        L6:
            return ((((r100 + r102) * 31) + this.f196295c) * 31) + this.f196296d;
        }

        public final String toString() {
            return "SecondLineTagItem(tag=" + this.f196293a + ", shouldAppendDivider=" + this.f196294b + ", marginStart=" + this.f196295c + ", contentWidth=" + this.f196296d + ')';
        }

        public a(MinorTag r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            this.f196293a = r100;
            this.f196294b = false;
            this.f196295c = r101;
            this.f196296d = r102;
        }
    }

    public final DmtTextView f() {
        DmtTextView r100 = this.f196284k;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mAnchorTag");
        return null;
    }

    public final DmtTextView g() {
        DmtTextView r100 = this.f196288o;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mAnchorTitle");
        return null;
    }

    public final ViewGroup h() {
        ViewGroup r100 = this.f196282i;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mFirstLineContainer");
        return null;
    }

    public final ImageView i() {
        ImageView r100 = this.f196285l;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mIvDividerTop");
        return null;
    }

    public final ViewGroup j() {
        ViewGroup r100 = this.f196286m;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mPoiExtendInfoContainer");
        return null;
    }

    public final ViewGroup k() {
        ViewGroup r100 = this.f196281h;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mPoiInfoOutContainer");
        return null;
    }

    public final DmtTextView l() {
        DmtTextView r100 = this.f196278e;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("poiType");
        return null;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final void c() {
        DmtTextView r100 = (DmtTextView) b().findViewById(R.id.poi_type);
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f196278e = r100;
        ImageView r101 = (ImageView) b().findViewById(R.id.divider_type);
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f196279f = r101;
        AoImageView r102 = (AoImageView) b().findViewById(R.id.service_icon);
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        this.f196280g = r102;
        ViewGroup r103 = (ViewGroup) b().findViewById(R.id.poi_location_out_container);
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        this.f196281h = r103;
        ViewGroup r104 = (ViewGroup) b().findViewById(R.id.poi_location_container);
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        this.f196282i = r104;
        AoImageView r105 = (AoImageView) b().findViewById(R.id.iv_location_special);
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        this.f196283j = r105;
        DmtTextView r106 = (DmtTextView) b().findViewById(R.id.location_2);
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        this.f196284k = r106;
        ImageView r107 = (ImageView) b().findViewById(R.id.divider_top);
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        this.f196285l = r107;
        ViewGroup r108 = (ViewGroup) b().findViewById(R.id.poi_info_container);
        Intrinsics.checkNotNullParameter(r108, "<set-?>");
        this.f196286m = r108;
        AoImageView r109 = (AoImageView) b().findViewById(R.id.iv_right_arrow);
        Intrinsics.checkNotNullParameter(r109, "<set-?>");
        this.f196287n = r109;
        DmtTextView r110 = (DmtTextView) b().findViewById(R.id.type_name);
        Intrinsics.checkNotNullParameter(r110, "<set-?>");
        this.f196288o = r110;
        q r111 = (q) this.f195898c;
        Observer<q.b> r112 = new d(this);
        r111.getClass();
        Intrinsics.checkNotNullParameter(r112, "observer");
        r111.f196301a.a(r112);
        q r113 = (q) this.f195898c;
        Observer<q.a> r114 = new e(this);
        r113.getClass();
        Intrinsics.checkNotNullParameter(r114, "observer");
        r113.f196302b.a(r114);
        b().setOnClickListener(new f(this));
    }

    public static boolean n(com.bytedance.awemeopen.bizmodels.feed.poi.b r100) {
        if ((r100 instanceof com.bytedance.awemeopen.bizmodels.feed.poi.b.d) == false) goto L5;
    L10:
        return true;
    L5:
        if ((r100 instanceof com.bytedance.awemeopen.bizmodels.feed.poi.b.c) == true) goto L10;
        if ((r100 instanceof com.bytedance.awemeopen.bizmodels.feed.poi.b.C2847b) == true) goto L10;
        return false;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final View a(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parentView");
        return LayoutInflater.from(getContext()).inflate(R.layout.layout_video_local_life_anchor, r100, false);
    }

    public final void e(long r100) {
        Object[] r101 = new Object[1];
        StringBuilder r102 = new StringBuilder("ExpandView id:");
        q.a r103 = this.f196289p;
        ViewGroup.MarginLayoutParams r104 = null;
        if (r103 == null) goto L5;
        String r105 = r103.f196303a;
    L6:
        r102.append(r105);
        r102.append(" expendPoiAnchor hasExpanded:");
        r102.append(this.f196291r);
        r102.append(", delayTime = ");
        r102.append(r100);
        r101[0] = r102.toString();
        AoLogger.b("PoiAnchorElementView", r101);
        q.a r106 = this.f196289p;
        if (r106 != null) goto L11;
        this.f196290q = new i(this, r100);
        return;
    L11:
        if (this.f196291r == false) goto L13;
        return;
    L13:
        if (r106.f196304b == true) goto L16;
        return;
    L16:
        if (r100 != 0) goto L24;
        j().setVisibility(0);
        j().setAlpha(0.0f);
        this.f196292s.cancel();
        final ViewGroup r107 = j();
        this.f196292s.cancel();
        r107.setVisibility(0);
        r107.setAlpha(0.0f);
        r107.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int r108 = RangesKt.coerceAtLeast(r107.getMeasuredHeight(), 0);
        ViewGroup r109 = k();
        int r110 = RangesKt.coerceAtLeast((h().getMeasuredHeight() + r109.getPaddingTop()) + r109.getPaddingBottom(), 0);
        int r111 = r108 + r110;
        ViewGroup.LayoutParams r112 = r107.getLayoutParams();
        if ((r112 instanceof ViewGroup.MarginLayoutParams) == false) goto L20;
        r104 = (ViewGroup.MarginLayoutParams) r112;
    L20:
        if (r104 != null) goto L22;
        int r113 = 0;
    L23:
        ValueAnimator r114 = ValueAnimator.ofInt(new int[]{r110, r111 + r113});
        r114.setDuration(320);
        Interpolator r115 = o.f196299a;
        r114.setInterpolator(r115);
        r114.addUpdateListener(new k(this));
        ValueAnimator r116 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r116.setDuration(320);
        r116.setInterpolator(r115);
        r116.addUpdateListener(new l(r107));
        AnimatorSet r117 = new AnimatorSet();
        r117.playTogether(new Animator[]{r114, r116});
        r117.addListener(new n(r107, this));
        r117.start();
        this.f196292s = r117;
        this.f196291r = true;
        return;
    L22:
        r113 = r104.topMargin + r104.bottomMargin;
        goto L23
    L24:
        j().postDelayed(new j(this), r100);
        return;
    L5:
        r105 = null;
        goto L6
    }

    public final int m(View r100) {
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if ((r101 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101;
    L6:
        if (r102 != null) goto L10;
        return 0;
    L10:
        return r102.getMarginStart() + r102.getMarginEnd();
    L5:
        r102 = null;
        goto L6
    }

    public final void p(final List<MinorTag> r110) {
        int r100 = 4;
        int r101 = 6;
        int r102 = -1;
        int r103 = -2;
        AttributeSet r104 = null;
        int r105 = 0;
        if (com.bytedance.awemeopen.apps.framework.feed.ui.information.a.f196005q == true) goto L24;
        j().removeAllViews();
        Iterator<T> r106 = r110.iterator();
        com.bytedance.awemeopen.bizmodels.feed.poi.b r111 = null;
        int r112 = 0;
    L6:
        if (r106.hasNext() == false) goto L23;
        Object r113 = r106.next();
        int r114 = r112 + 1;
        if (r112 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        MinorTag r115 = (MinorTag) r113;
        MinorTagView r116 = new MinorTagView(j().getContext(), r104, r101, r105);
        LinearLayout.LayoutParams r117 = new LinearLayout.LayoutParams(r103, r102);
        j().addView(r116, r117);
        if (r114 >= r110.size()) goto L13;
        com.bytedance.awemeopen.bizmodels.feed.poi.b r107 = ((MinorTag) ListProtector.get(r110, r114)).f198184c;
    L14:
        com.bytedance.awemeopen.bizmodels.feed.poi.b r108 = r115.f198184c;
        Pair r118 = new Pair(Boolean.valueOf(n(r111)), Boolean.valueOf(n(r107)));
        if (r114 != r110.size()) goto L17;
        Pair r109 = Pair.copy$default(r118, null, Boolean.FALSE, 1, null);
    L19:
        if (((Boolean) r118.getFirst()).booleanValue() == true) goto L22;
        if (r112 == 0) goto L22;
        Resources r119 = Resources.getSystem();
        r117.setMarginStart(MathKt.roundToInt(TypedValue.applyDimension(1, 4, WindowDisplayMetricsOverride.apply(r119, r119.getDisplayMetrics()))));
    L22:
        r116.c(r115, ((Boolean) r109.getSecond()).booleanValue());
        r111 = r115.f198184c;
        r112 = r114;
        r102 = -1;
        r103 = -2;
        goto L6
    L17:
        r109 = r118;
        goto L19
    L13:
        r107 = null;
        goto L14
    L23:
        return;
    L24:
        j().removeAllViews();
        if (r110.isEmpty() == false) goto L27;
        return;
    L27:
        int r120 = h().getMeasuredWidth();
        if (r120 > 0) goto L31;
        j().post(new g(this, r110));
        return;
    L31:
        ArrayList r121 = new ArrayList();
        Iterator<T> r122 = r110.iterator();
        int r123 = 0;
    L33:
        if (r122.hasNext() == false) goto L69;
        MinorTag r124 = (MinorTag) r122.next();
        a r125 = (a) CollectionsKt.lastOrNull(r121);
        com.bytedance.awemeopen.bizmodels.feed.poi.b r126 = r124.f198184c;
        if (r125 == null) goto L39;
        MinorTag r127 = r125.f196293a;
        if (r127 == null) goto L39;
        com.bytedance.awemeopen.bizmodels.feed.poi.b r128 = r127.f198184c;
    L41:
        if (((Boolean) new Pair(Boolean.valueOf(n(r128)), Boolean.valueOf(n(null))).getFirst()).booleanValue() == true) goto L44;
        if (r125 == null) goto L44;
        Resources r129 = Resources.getSystem();
        int r130 = MathKt.roundToInt(TypedValue.applyDimension(1, r100, WindowDisplayMetricsOverride.apply(r129, r129.getDisplayMetrics())));
    L45:
        if (r125 == null) goto L54;
        com.bytedance.awemeopen.bizmodels.feed.poi.b r131 = r125.f196293a.f198184c;
        com.bytedance.awemeopen.bizmodels.feed.poi.b r132 = r124.f198184c;
        if (n(r131) == true) goto L49;
    L51:
        boolean r133 = false;
    L52:
        if (r133 == false) goto L54;
        boolean r134 = true;
    L55:
        if (r134 == false) goto L60;
        if (r125 == null) goto L60;
        if (r125.f196294b == true) goto L60;
        int r135 = o(r125.f196293a, true) - r125.f196296d;
    L61:
        int r136 = o(r124, false);
        int r137 = r123 + r135;
        if (((r137 + r130) + r136) > r120) goto L68;
        if (r134 == false) goto L67;
        if (r125 == null) goto L67;
        r125.f196294b = true;
        r125.f196296d += r135;
        r123 = r137;
    L67:
        r121.add(new a(r124, r130, r136));
        r123 = r123 + (r130 + r136);
    L68:
        r100 = 4;
    L60:
        r135 = 0;
        goto L61
    L49:
        if (n(r132) == false) goto L51;
        r133 = true;
    L54:
        r134 = false;
    L44:
        r130 = 0;
    L39:
        r128 = null;
        goto L41
    L69:
        Iterator r138 = r121.iterator();
    L71:
        if (r138.hasNext() == false) goto L73;
        a r139 = (a) r138.next();
        MinorTagView r140 = new MinorTagView(j().getContext(), r104, r101, r105);
        LinearLayout.LayoutParams r141 = new LinearLayout.LayoutParams(-2, -1);
        r141.setMarginStart(r139.f196295c);
        r140.c(r139.f196293a, r139.f196294b);
        j().addView(r140, r141);
        goto L71
    }

    public final int o(MinorTag r100, boolean r101) {
        MinorTagView r102 = new MinorTagView(j().getContext(), null, 6, 0);
        r102.c(r100, r101);
        r102.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return r102.getMeasuredWidth();
    }

    public m(Context r100, p r101, q r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "event");
        Intrinsics.checkNotNullParameter(r102, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        super(r100, r101, r102);
        this.f196292s = new AnimatorSet();
    }

    public final int d(int r100, List r101, DmtTextView r102, DmtTextView r103, List r104) {
        if (r100 > 0) goto L4;
        return Integer.MAX_VALUE;
    L4:
        if (r102.getVisibility() != 0) goto L41;
        List r105 = CollectionsKt.plus(r101, r104);
        ArrayList r106 = new ArrayList();
        Iterator r107 = r105.iterator();
    L7:
        boolean r108 = false;
        boolean r109 = true;
        if (r107.hasNext() == false) goto L14;
        Object r110 = r107.next();
        if (((View) r110).getVisibility() != 0) goto L12;
        r108 = true;
    L12:
        if (r108 == false) goto L7;
        r106.add(r110);
        goto L7
    L14:
        Iterator r111 = r106.iterator();
        int r112 = 0;
    L16:
        if (r111.hasNext() == false) goto L18;
        View r113 = (View) r111.next();
        r112 = r112 + (r113.getMeasuredWidth() + m(r113));
        goto L16
    L18:
        CharSequence r114 = r102.getText();
        if (r114 == null) goto L21;
        String r115 = r114.toString();
    L22:
        if (r115 != null) goto L25;
        r115 = "";
    L25:
        if (r115.length() == 0) goto L28;
        r109 = false;
    L28:
        if (r109 == false) goto L30;
        int r116 = 0;
    L32:
        return RangesKt.coerceAtMost(r116 + m(r102), RangesKt.coerceAtLeast((r100 - r112) - m(r103), 0));
    L30:
        r116 = (int) r102.getPaint().measureText(r115);
        goto L32
    L21:
        r115 = null;
        goto L22
    L41:
        return Integer.MAX_VALUE;
    }
}
