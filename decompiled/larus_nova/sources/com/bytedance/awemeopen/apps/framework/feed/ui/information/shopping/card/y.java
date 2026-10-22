package com.bytedance.awemeopen.apps.framework.feed.ui.information.shopping.card;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.lifecycle.Observer;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView;
import com.bytedance.awemeopen.bizmodels.feed.shopping.card.DetailPromotion;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.writtenlayout.IWrittenLayout;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes14.dex */
public final class y extends com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c<a0, b0> {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Typeface f196447v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final Interpolator f196448w = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LinearLayout f196449e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LinearLayout f196450f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AoImageView f196451g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f196452h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f196453i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f196454j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextView f196455k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public LinearLayout f196456l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public DmtTextView f196457m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public DmtTextView f196458n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public DmtTextView f196459o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public DmtTextView f196460p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public AwemeFeedProductCard f196461q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Map<String, String> f196462r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f196463s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public List<String> f196464t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public AnimatorSet f196465u;

    public static final class a {
    }

    public static final class b extends IWrittenLayout {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ y f196466c;

        @Override // com.bytedance.awemeopen.writtenlayout.IWrittenLayout
        public final View f() {
            ViewGroup.LayoutParams r100 = new ViewGroup.LayoutParams(-2, -2);
            final y r101 = this.f196466c;
            Function1<FrameLayout, Unit> r102 = new ShoppingCardElementView$createView$1$createView$1(r101, this);
            Intrinsics.checkNotNullParameter(r100, "lparams");
            return n(r100, r102);
        }

        public b(y r100, Context r101) {
            this.f196466c = r100;
            super(r101);
        }
    }

    public static final class c extends com.bytedance.awemeopen.apps.framework.utils.o {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ y f196467d;

        @Override // com.bytedance.awemeopen.apps.framework.utils.o
        public final void a() {
            ((a0) this.f196467d.f195897b).f196396a.b(Unit.INSTANCE);
        }

        public c(y r100) {
            this.f196467d = r100;
        }
    }

    public final void e() {
        AoLogger.g("doFirstDelayAnimation", new Object[0]);
        final LinearLayout r100 = this.f196449e;
        if (r100 == null) goto L115;
        final LinearLayout r101 = this.f196456l;
        if (r101 != null) goto L7;
        return;
    L7:
        if (h() == true) goto L34;
        DmtTextView r102 = this.f196458n;
        if (r102 == null) goto L18;
        CharSequence r103 = r102.getText();
        if (r103 == null) goto L18;
        if (r103.length() <= 0) goto L15;
        boolean r104 = true;
    L16:
        if (r104 != true) goto L18;
        boolean r105 = true;
    L19:
        if (r105 == true) goto L34;
        DmtTextView r106 = this.f196460p;
        if (r106 == null) goto L30;
        CharSequence r107 = r106.getText();
        if (r107 == null) goto L30;
        if (r107.length() <= 0) goto L27;
        boolean r108 = true;
    L28:
        if (r108 != true) goto L30;
        boolean r109 = true;
    L31:
        if (r109 == true) goto L34;
        boolean r110 = false;
    L35:
        if (r110 == true) goto L38;
        return;
    L38:
        if (r100.getWidth() != 0) goto L40;
        r100.post(new l(this));
        return;
    L40:
        AoLogger.g("doFirstDelayAnimation, tags visible", new Object[0]);
        boolean r111 = h();
        if (r111 == true) goto L55;
        DmtTextView r112 = this.f196458n;
        if (r112 == null) goto L52;
        CharSequence r113 = r112.getText();
        if (r113 == null) goto L52;
        if (r113.length() <= 0) goto L49;
        boolean r114 = true;
    L50:
        if (r114 != true) goto L52;
        boolean r115 = true;
    L53:
        if (r115 == false) goto L55;
        boolean r116 = true;
    L56:
        if (r111 == true) goto L70;
        DmtTextView r117 = this.f196460p;
        if (r117 == null) goto L67;
        CharSequence r118 = r117.getText();
        if (r118 == null) goto L67;
        if (r118.length() <= 0) goto L64;
        boolean r119 = true;
    L65:
        if (r119 != true) goto L67;
        boolean r120 = true;
    L68:
        if (r120 == false) goto L70;
        boolean r121 = true;
    L71:
        DmtTextView r122 = this.f196457m;
        int r123 = 8;
        if (r122 == null) goto L78;
        if (r111 == false) goto L76;
        int r124 = 0;
    L77:
        r122.setVisibility(r124);
        goto L78
    L76:
        r124 = 8;
    L78:
        DmtTextView r125 = this.f196458n;
        if (r125 == null) goto L85;
        if (r116 == false) goto L83;
        int r126 = 0;
    L84:
        r125.setVisibility(r126);
        goto L85
    L83:
        r126 = 8;
    L85:
        DmtTextView r127 = this.f196460p;
        if (r127 == null) goto L92;
        if (r121 == false) goto L90;
        int r128 = 0;
    L91:
        r127.setVisibility(r128);
        goto L92
    L90:
        r128 = 8;
    L92:
        DmtTextView r129 = this.f196459o;
        if (r129 == null) goto L99;
        if (r116 == false) goto L98;
        if (r121 == false) goto L98;
        r123 = 0;
    L98:
        r129.setVisibility(r123);
    L99:
        AnimatorSet r130 = this.f196465u;
        if (r130 == null) goto L102;
        r130.cancel();
    L102:
        r101.clearAnimation();
        r101.setVisibility(0);
        r101.setAlpha(0.0f);
        r101.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int r131 = RangesKt.coerceAtLeast(r101.getMeasuredHeight(), r101.getMinimumHeight());
        LinearLayout r132 = this.f196450f;
        if (r132 == null) goto L105;
        int r133 = r132.getMeasuredHeight();
    L106:
        int r134 = RangesKt.coerceAtLeast((r133 + r100.getPaddingTop()) + r100.getPaddingBottom(), 0);
        int r135 = r131 + r134;
        ViewGroup.LayoutParams r136 = r101.getLayoutParams();
        if ((r136 instanceof ViewGroup.MarginLayoutParams) == false) goto L109;
        ViewGroup.MarginLayoutParams r137 = (ViewGroup.MarginLayoutParams) r136;
    L110:
        if (r137 != null) goto L112;
        int r138 = 0;
    L113:
        ValueAnimator r139 = ValueAnimator.ofInt(new int[]{r134, r135 + r138});
        r139.setDuration(320);
        Interpolator r140 = f196448w;
        r139.setInterpolator(r140);
        r139.addUpdateListener(new n(r100));
        ValueAnimator r141 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r141.setDuration(320);
        r141.setInterpolator(r140);
        r141.addUpdateListener(new o(r101));
        AnimatorSet r142 = new AnimatorSet();
        r142.playTogether(new Animator[]{r139, r141});
        r142.addListener(new z(r101, r100, this));
        r142.start();
        this.f196465u = r142;
        return;
    L112:
        r138 = r137.topMargin + r137.bottomMargin;
        goto L113
    L109:
        r137 = null;
        goto L110
    L105:
        r133 = 0;
        goto L106
    L64:
        r119 = false;
    L67:
        r120 = false;
    L70:
        r121 = false;
        goto L71
    L49:
        r114 = false;
    L52:
        r115 = false;
    L55:
        r116 = false;
        goto L56
    L27:
        r108 = false;
    L30:
        r109 = false;
        goto L31
    L15:
        r104 = false;
    L18:
        r105 = false;
    L34:
        r110 = true;
        goto L35
    }

    static {
        f196447v = Typeface.create("sans-serif-medium", 0);
        f196448w = PathInterpolatorCompat.create(0.0f, 0.4f, 0.2f, 1.0f);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final void c() {
        LinearLayout r100 = this.f196449e;
        if (r100 == null) goto L5;
        r100.setOnClickListener(new c(this));
    L5:
        b0 r101 = (b0) this.f195898c;
        Observer<com.bytedance.awemeopen.infra.base.image.b> r102 = new k(this);
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "observer");
        r101.f196402a.a(r102);
        b0 r103 = (b0) this.f195898c;
        Observer<Triple<String, String, String>> r104 = new p(this);
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "observer");
        r103.f196403b.a(r104);
        b0 r105 = (b0) this.f195898c;
        Observer<List<String>> r106 = new q(this);
        r105.getClass();
        Intrinsics.checkNotNullParameter(r106, "observer");
        r105.f196405d.a(r106);
        b0 r107 = (b0) this.f195898c;
        Observer<Map<String, String>> r108 = new r(this);
        r107.getClass();
        Intrinsics.checkNotNullParameter(r108, "observer");
        r107.f196404c.a(r108);
        b0 r109 = (b0) this.f195898c;
        Observer<Boolean> r110 = new s(this);
        r109.getClass();
        Intrinsics.checkNotNullParameter(r110, "observer");
        r109.f196406e.a(r110);
        b0 r111 = (b0) this.f195898c;
        Observer<List<DetailPromotion>> r112 = new t(this);
        r111.getClass();
        Intrinsics.checkNotNullParameter(r112, "observer");
        r111.f196407f.a(r112);
        b0 r113 = (b0) this.f195898c;
        Observer<Unit> r114 = new u(this);
        r113.getClass();
        Intrinsics.checkNotNullParameter(r114, "observer");
        r113.f196408g.a(r114);
        b0 r115 = (b0) this.f195898c;
        Observer<Unit> r116 = new v(this);
        r115.getClass();
        Intrinsics.checkNotNullParameter(r116, "observer");
        r115.f196410i.a(r116);
    }

    public final boolean h() {
        DmtTextView r100 = this.f196457m;
        if (r100 == null) goto L12;
        CharSequence r101 = r100.getText();
        if (r101 == null) goto L12;
        if (r101.length() <= 0) goto L9;
        boolean r102 = true;
    L10:
        if (r102 != true) goto L12;
        boolean r103 = true;
    L13:
        if (r103 == false) goto L26;
        Map<String, String> r104 = this.f196462r;
        if (r104 == null) goto L17;
        String r105 = r104.get("anchor_coupon_info");
    L18:
        if (r105 != null) goto L20;
    L23:
        boolean r106 = true;
    L24:
        if (r106 == false) goto L26;
        return true;
    L20:
        if (r105.length() == 0) goto L23;
        r106 = false;
        goto L24
    L17:
        r105 = null;
    L26:
        return false;
    L9:
        r102 = false;
    L12:
        r103 = false;
        goto L13
    }

    public final void i() {
        Map<String, String> r100 = this.f196462r;
        TextView r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.get("anchor_coupon_info");
    L6:
        boolean r103 = true;
        if (r102 != null) goto L9;
    L12:
        boolean r104 = true;
    L14:
        if (r104 == true) goto L22;
        TextView r105 = this.f196455k;
        if (r105 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("suffixTextView");
        r105 = null;
    L18:
        x54.b.d(r105);
        TextView r106 = this.f196455k;
        if (r106 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("suffixTextView");
        r106 = null;
    L21:
        r106.setText(" · " + r102);
    L45:
        final LinearLayout r107 = this.f196449e;
        if (r107 == null) goto L64;
        LinearLayout r108 = this.f196450f;
        if (r108 == null) goto L51;
        ViewGroup.LayoutParams r109 = r108.getLayoutParams();
    L52:
        if (r109 == null) goto L55;
        r109.width = -2;
    L55:
        TextView r110 = this.f196454j;
        if (r110 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
    L59:
        r101.setMaxWidth(Integer.MAX_VALUE);
        r107.setMinimumWidth(0);
        LinearLayout r111 = this.f196450f;
        if (r111 == null) goto L62;
        r111.requestLayout();
    L62:
        r107.post(new m(this, r107));
        return;
    L58:
        r101 = r110;
        goto L59
    L51:
        r109 = null;
        goto L52
    L64:
        return;
    L22:
        String r112 = this.f196463s;
        if (r112 != null) goto L25;
    L28:
        if (r103 == true) goto L41;
        TextView r113 = this.f196454j;
        if (r113 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
        r113 = null;
    L33:
        if (r113.getVisibility() != 0) goto L41;
        TextView r114 = this.f196455k;
        if (r114 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("suffixTextView");
        r114 = null;
    L37:
        x54.b.d(r114);
        TextView r115 = this.f196455k;
        if (r115 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("suffixTextView");
        r115 = null;
    L40:
        r115.setText(" · " + this.f196463s);
    L41:
        TextView r116 = this.f196455k;
        if (r116 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("suffixTextView");
        r116 = null;
    L44:
        x54.b.a(r116);
        goto L45
    L25:
        if (r112.length() == 0) goto L28;
        r103 = false;
        goto L28
    L9:
        if (r102.length() == 0) goto L12;
        r104 = false;
        goto L14
    L5:
        r102 = null;
        goto L6
    }

    public final void j() {
        Map<String, String> r100 = this.f196462r;
        if (r100 == null) goto L5;
        String r101 = r100.get("anchor_coupon_info");
    L6:
        int r102 = 0;
        if (r101 != null) goto L9;
    L12:
        boolean r103 = true;
    L14:
        if ((!r103) == true) goto L16;
        return;
    L16:
        List<String> r104 = this.f196464t;
        if (r104 != null) goto L19;
    L21:
        boolean r105 = false;
    L22:
        String r106 = this.f196463s;
        if (r106 != null) goto L25;
    L28:
        boolean r107 = true;
    L29:
        String r108 = "";
        if (r107 == true) goto L49;
        DmtTextView r109 = this.f196458n;
        if (r109 == null) goto L35;
        r109.setText(this.f196463s);
    L35:
        if (r105 == false) goto L45;
        DmtTextView r110 = this.f196460p;
        if (r110 == null) goto L86;
        List<String> r111 = this.f196464t;
        if (r111 == null) goto L44;
        String r112 = (String) CollectionsKt.firstOrNull(r111);
        if (r112 == null) goto L44;
        r108 = r112;
    L44:
        r110.setText(r108);
        return;
    L86:
        return;
    L45:
        DmtTextView r113 = this.f196460p;
        if (r113 == null) goto L87;
        r113.setText("");
        return;
    L87:
        return;
    L49:
        if (r105 == false) goto L74;
        DmtTextView r114 = this.f196458n;
        if (r114 == null) goto L60;
        List<String> r115 = this.f196464t;
        if (r115 == null) goto L58;
        String r116 = (String) CollectionsKt.firstOrNull(r115);
        if (r116 == null) goto L58;
    L59:
        r114.setText(r116);
    L58:
        r116 = "";
    L60:
        DmtTextView r117 = this.f196460p;
        if (r117 == null) goto L88;
        List<String> r118 = this.f196464t;
        if (r118 == null) goto L66;
        r102 = r118.size();
    L66:
        if (r102 <= 1) goto L73;
        List<String> r119 = this.f196464t;
        if (r119 == null) goto L73;
        String r120 = (String) CollectionsKt.getOrNull(r119, 1);
        if (r120 == null) goto L73;
        r108 = r120;
    L73:
        r117.setText(r108);
        return;
    L88:
        return;
    L74:
        DmtTextView r121 = this.f196458n;
        if (r121 == null) goto L78;
        r121.setText("");
    L78:
        DmtTextView r122 = this.f196460p;
        if (r122 == null) goto L89;
        r122.setText("");
        return;
    L89:
        return;
    L25:
        if (r106.length() == 0) goto L28;
        r107 = false;
        goto L29
    L19:
        if ((!r104.isEmpty()) != true) goto L21;
        r105 = true;
        goto L22
    L9:
        if (r101.length() == 0) goto L12;
        r103 = false;
        goto L14
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final View a(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parentView");
        return new b(this, getContext()).j();
    }

    public final int f(View r100) {
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

    public final void g(boolean r100) {
        AnimatorSet r101 = this.f196465u;
        if (r101 == null) goto L5;
        r101.cancel();
    L5:
        this.f196465u = null;
        if (r100 == false) goto L8;
        this.f196462r = null;
        this.f196463s = null;
        this.f196464t = null;
    L8:
        LinearLayout r102 = this.f196449e;
        if (r102 == null) goto L11;
        r102.setVisibility(0);
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        r103.height = -2;
        r102.setLayoutParams(r103);
        r102.requestLayout();
    L11:
        LinearLayout r104 = this.f196456l;
        if (r104 == null) goto L14;
        r104.setAlpha(0.0f);
        r104.setVisibility(8);
        r104.requestLayout();
    L14:
        DmtTextView r105 = this.f196457m;
        if (r105 == null) goto L19;
        r105.setVisibility(8);
        if (r100 == false) goto L19;
        r105.setText("");
    L19:
        DmtTextView r106 = this.f196458n;
        if (r106 == null) goto L24;
        r106.setVisibility(8);
        if (r100 == false) goto L24;
        r106.setText("");
    L24:
        DmtTextView r107 = this.f196460p;
        if (r107 == null) goto L29;
        r107.setVisibility(8);
        if (r100 == false) goto L29;
        r107.setText("");
    L29:
        DmtTextView r108 = this.f196459o;
        if (r108 == null) goto L34;
        r108.setVisibility(8);
        return;
    }

    public y(Context r100, a0 r101, b0 r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "event");
        Intrinsics.checkNotNullParameter(r102, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        super(r100, r101, r102);
    }

    public final int d(int r100, List<? extends View> r101, TextView r102, View r103) {
        if (r100 > 0) goto L4;
        return Integer.MAX_VALUE;
    L4:
        if (r102.getVisibility() != 0) goto L41;
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r101.iterator();
    L7:
        boolean r106 = false;
        boolean r107 = true;
        if (r105.hasNext() == false) goto L14;
        Object r108 = r105.next();
        if (((View) r108).getVisibility() != 0) goto L12;
        r106 = true;
    L12:
        if (r106 == false) goto L7;
        r104.add(r108);
        goto L7
    L14:
        Iterator r109 = r104.iterator();
        int r110 = 0;
    L16:
        if (r109.hasNext() == false) goto L18;
        View r111 = (View) r109.next();
        r110 = r110 + (r111.getMeasuredWidth() + f(r111));
        goto L16
    L18:
        CharSequence r112 = r102.getText();
        if (r112 == null) goto L21;
        String r113 = r112.toString();
    L22:
        if (r113 != null) goto L25;
        r113 = "";
    L25:
        if (r113.length() == 0) goto L28;
        r107 = false;
    L28:
        if (r107 == false) goto L30;
        int r114 = 0;
    L32:
        return RangesKt.coerceAtMost(r114 + f(r102), RangesKt.coerceAtLeast((r100 - r110) - f(r103), 0));
    L30:
        r114 = (int) r102.getPaint().measureText(r113);
        goto L32
    L21:
        r113 = null;
        goto L22
    L41:
        return Integer.MAX_VALUE;
    }
}
