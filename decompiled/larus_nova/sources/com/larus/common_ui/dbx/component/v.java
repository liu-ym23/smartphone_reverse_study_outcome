package com.larus.common_ui.dbx.component;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;
import com.larus.nova.R;
import com.lynx.textra.PlatformFontCaps;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class v extends FrameLayout {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Rect f327052x = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f327053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f327054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Path f327055c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final t f327056d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public WeakReference<View> f327057e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f327058f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Integer f327059g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final FrameLayout f327060h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final FrameLayout f327061i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final FrameLayout f327062j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f327063k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final FrameLayout f327064l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final w f327065m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final u f327066n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final d f327067o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final d f327068p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Rect f327069q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f327070r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public CharSequence f327071s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f327072t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f327073u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f327074v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public CharSequence f327075w;

    public static final class a {
        public static Pair a(int r100, int r101) {
            int r102 = Math.max(0, r100);
            float r103 = r102;
            int r104 = (int) (0.5f * r103);
            int r105 = Math.max(r102 - RangesKt.coerceIn(r101, 0, r102), (int) (r103 * 0.9f));
            return TuplesKt.to(Integer.valueOf(Math.min(r104, r105)), Integer.valueOf(r105));
        }
    }

    static {
        f327052x = new Rect(0, 0, 0, 0);
    }

    public final void a() {
        if (this.f327065m.getChildCount() <= 0) goto L5;
        boolean r100 = true;
    L6:
        Rect r101 = this.f327069q;
        int r102 = r101.bottom + this.f327063k;
        FrameLayout r103 = this.f327061i;
        int r104 = r101.left;
        int r105 = r101.top;
        int r106 = r101.right;
        if (r100 == false) goto L9;
        int r107 = 0;
    L10:
        r103.setPadding(r104, r105, r106, r107);
        if (this.f327070r == false) goto L13;
        Rect r108 = this.f327069q;
    L14:
        FrameLayout r109 = this.f327062j;
        int r110 = r108.left;
        int r111 = r108.right;
        if (r100 == true) goto L18;
        r102 = 0;
    L18:
        r109.setPadding(r110, 0, r111, r102);
        return;
    L13:
        r108 = f327052x;
        goto L14
    L9:
        r107 = r102;
        goto L10
    L5:
        r100 = false;
        goto L6
    }

    public final void e() {
        this.f327054b.setText(this.f327071s);
        TextView r100 = this.f327054b;
        CharSequence r101 = this.f327071s;
        int r102 = 0;
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        r102 = 4;
    L11:
        r100.setVisibility(r102);
        return;
    L5:
        if (r101.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        View r100 = this.f327057e.get();
        if (r100 == null) goto L5;
        r100.removeOnLayoutChangeListener(this.f327056d);
    L5:
        this.f327065m.removeCallbacks(this.f327066n);
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        View r100 = this.f327057e.get();
        if (r100 == null) goto L5;
        r100.removeOnLayoutChangeListener(this.f327056d);
        r100.addOnLayoutChangeListener(this.f327056d);
    L5:
        d(true);
    }

    public final boolean getAppliesFooterInsets() {
        return this.f327070r;
    }

    public final CharSequence getCloseAccessibilityLabel() {
        return this.f327075w;
    }

    public final ImageButton getCloseButton() {
        return this.f327068p;
    }

    public final Rect getContentInsets() {
        return this.f327069q;
    }

    public final FrameLayout getContentView() {
        return this.f327064l;
    }

    public final FrameLayout getFooterView() {
        return this.f327065m;
    }

    public final boolean getShowsCloseButton() {
        return this.f327074v;
    }

    public final CharSequence getTitle() {
        return this.f327071s;
    }

    public final boolean getWrapsContentHeight() {
        return this.f327073u;
    }

    public final void b(View r100) {
        Intrinsics.checkNotNullParameter(r100, "relativeTo");
        View r101 = this.f327057e.get();
        if (r101 == r100) goto L7;
        if (r101 == null) goto L6;
        r101.removeOnLayoutChangeListener(this.f327056d);
    L6:
        r100.addOnLayoutChangeListener(this.f327056d);
    L7:
        this.f327057e = new WeakReference(r100);
        d(true);
    }

    public final int c(int r100) {
        Resources r101 = getResources();
        return (int) ((r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f);
    }

    public final void d(boolean r100) {
        View r101 = this.f327057e.get();
        if (r101 != null) goto L5;
        return;
    L5:
        int r102 = r101.getHeight();
        if (r102 > 0) goto L8;
        return;
    L8:
        WindowInsetsCompat r103 = ViewCompat.getRootWindowInsets(r101);
        int r104 = 0;
        if (r103 == null) goto L13;
        Insets r105 = r103.getInsets(WindowInsetsCompat.Type.systemBars());
        if (r105 == null) goto L13;
        int r106 = r105.top;
    L14:
        Pair r107 = a.a(r102, r106);
        int r108 = ((Number) r107.component1()).intValue();
        int r109 = ((Number) r107.component2()).intValue();
        if (this.f327058f != r108) goto L23;
        Integer r110 = this.f327059g;
        if (r110 == null) goto L23;
        if (r110.intValue() != r109) goto L23;
        boolean r111 = false;
    L24:
        this.f327058f = r108;
        this.f327059g = Integer.valueOf(r109);
        if (this.f327073u == true) goto L28;
        r104 = r108;
    L28:
        setMinimumHeight(r104);
        if (r111 == false) goto L33;
        if (r100 == false) goto L34;
        requestLayout();
        return;
    L34:
        return;
    L33:
        return;
    L23:
        r111 = true;
    L13:
        r106 = 0;
        goto L14
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        int r101 = r100.save();
        r100.clipPath(this.f327055c);
        super.dispatchDraw(r100);
        r100.restoreToCount(r101);
    }

    public final void setAppliesFooterInsets(boolean r100) {
        this.f327070r = r100;
        a();
    }

    public final void setCloseAccessibilityLabel(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        if ((!StringsKt.isBlank(r100)) == false) goto L7;
        this.f327075w = r100;
        this.f327068p.setContentDescription(r100);
        return;
    L7:
        throw new IllegalArgumentException("关闭按钮必须提供非空无障碍文案".toString());
    }

    public final void setContentInsets(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f327069q = new Rect(r100);
        a();
    }

    public final void setHeightResizable(boolean r100) {
        this.f327072t = r100;
        View r101 = this.f327053a;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public final void setOnCloseRequestListener$common_ui_mainlandRelease(Function0<Unit> r100) {
        this.f327067o.f327027a = r100;
    }

    public final void setShowsCloseButton(boolean r100) {
        this.f327074v = r100;
        d r101 = this.f327068p;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public final void setTitle(CharSequence r100) {
        this.f327071s = r100;
        e();
    }

    public final void setWrapsContentHeight(boolean r100) {
        if (this.f327073u != r100) goto L5;
        return;
    L5:
        this.f327073u = r100;
        d(true);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = 0;
        d(false);
        Integer r103 = this.f327059g;
        if (r103 == null) goto L15;
        int r104 = r103.intValue();
        if (this.f327073u == true) goto L8;
        r102 = Math.min(this.f327058f, r104);
    L8:
        int r105 = View.MeasureSpec.getSize(r101);
        int r106 = View.MeasureSpec.getMode(r101);
        if (r106 != Integer.MIN_VALUE) goto L11;
        r101 = View.MeasureSpec.makeMeasureSpec(Math.min(r105, r104), Integer.MIN_VALUE);
        goto L15
    L11:
        if (r106 == 1073741824) goto L13;
        r101 = View.MeasureSpec.makeMeasureSpec(r104, Integer.MIN_VALUE);
        goto L15
    L13:
        r101 = View.MeasureSpec.makeMeasureSpec(RangesKt.coerceIn(r105, r102, r104), 1073741824);
    L15:
        super.onMeasure(r100, r101);
    }

    /* JADX WARN: Type inference failed for: r12v0, types: [com.larus.common_ui.dbx.component.u] */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.larus.common_ui.dbx.component.t] */
    public v(FragmentActivity r110, CharSequence r210, CharSequence r211, boolean r212) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r210, "closeAccessibilityLabel");
        super(r110);
        View r100 = new View(r110);
        this.f327053a = r100;
        TextView r101 = new TextView(r110);
        this.f327054b = r101;
        this.f327055c = new Path();
        this.f327056d = new t(this);
        this.f327057e = new WeakReference(null);
        LinearLayout r102 = new LinearLayout(r110);
        FrameLayout r103 = new FrameLayout(r110);
        this.f327060h = r103;
        FrameLayout r104 = new FrameLayout(r110);
        this.f327061i = r104;
        FrameLayout r105 = new FrameLayout(r110);
        this.f327062j = r105;
        FrameLayout r111 = new FrameLayout(r110);
        this.f327064l = r111;
        w r112 = new w(r110, this);
        this.f327065m = r112;
        this.f327066n = new u(this);
        d r113 = new d(r110);
        this.f327067o = r113;
        this.f327068p = r113;
        int r114 = 0;
        this.f327069q = new Rect(0, 0, 0, 0);
        this.f327070r = true;
        this.f327071s = r211;
        this.f327072t = r212;
        this.f327074v = true;
        this.f327075w = r210;
        if ((!StringsKt.isBlank(r210)) == false) goto L41;
        GradientDrawable r115 = new GradientDrawable();
        r115.setColor(com.larus.common_ui.dbx.theme.a.b(getContext(), R.attr.larus_dbx_bg_subtle_3));
        float r106 = c(24);
        r115.setCornerRadii(new float[]{r106, r106, r106, r106, 0.0f, 0.0f, 0.0f, 0.0f});
        setBackground(r115);
        r102.setOrientation(1);
        addView(r102, new FrameLayout.LayoutParams(-1, -1));
        r102.addView(r103, new LinearLayout.LayoutParams(-1, c(56)));
        r104.addView(r111, new FrameLayout.LayoutParams(-1, -1));
        r102.addView(r104, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        r105.addView(r112, new FrameLayout.LayoutParams(-1, -2));
        r102.addView(r105, new LinearLayout.LayoutParams(-1, -2));
        r101.setGravity(17);
        r101.setMaxLines(1);
        r101.setEllipsize(TextUtils.TruncateAt.END);
        r101.setIncludeFontPadding(false);
        if (Build.VERSION.SDK_INT < 28) goto L7;
        Typeface r107 = Typeface.create(Typeface.create(PlatformFontCaps.DEFAULT_FAMILY_NAME, 0), 600, false);
        Intrinsics.checkNotNull(r107);
    L8:
        r101.setTypeface(r107);
        r101.setTextSize(2, 17.0f);
        r101.setTextColor(com.larus.common_ui.dbx.theme.a.b(getContext(), R.attr.larus_dbx_text_100));
        FrameLayout.LayoutParams r108 = new FrameLayout.LayoutParams(c(166), c(44), 49);
        r108.topMargin = c(12);
        Unit r109 = Unit.INSTANCE;
        r103.addView(r101, r108);
        GradientDrawable r116 = new GradientDrawable();
        r116.setColor(com.larus.common_ui.dbx.theme.a.b(getContext(), R.attr.larus_dbx_text_transparent_4));
        r116.setShape(1);
        r113.setBackground(new InsetDrawable(r116, c(4)));
        c19.a r117 = c19.a.f22072a;
        int r118 = c(20);
        int r119 = com.larus.common_ui.dbx.theme.a.b(getContext(), R.attr.larus_dbx_text_100);
        Intrinsics.checkNotNullParameter("close", "name");
        monitor-enter(r117);
        Intrinsics.checkNotNullParameter("close", "name");     // Catch: Throwable -> L37
        Integer r120 = (Integer) ((Map) c19.f.f22101d.getValue()).get("close");     // Catch: Throwable -> L37
        if (r120 == null) goto L23;
        int r121 = r120.intValue();     // Catch: Throwable -> L37
        SparseArray<c19.b> r122 = c19.a.f22073b;     // Catch: Throwable -> L37
        c19.b r123 = r122.get(r121);     // Catch: Throwable -> L37
        if (r123 == null) goto L16;
        monitor-exit(r117);
        c19.b r124 = r123;
    L25:
        if (r124 != null) goto L28;
        c19.c r125 = null;
    L31:
        r113.setImageDrawable(r125);
        r113.setScaleType(ImageView.ScaleType.CENTER);
        r113.setPadding(0, 0, 0, 0);
        r113.setMinimumWidth(0);
        r113.setMinimumHeight(0);
        r113.setClickable(true);
        r113.setFocusable(true);
        FrameLayout.LayoutParams r126 = new FrameLayout.LayoutParams(c(44), c(44), 8388659);
        r126.setMarginStart(c(12));
        r126.topMargin = c(12);
        r103.addView(r113, r126);
        GradientDrawable r127 = new GradientDrawable();
        r127.setColor(com.larus.common_ui.dbx.theme.a.b(getContext(), R.attr.larus_dbx_text_transparent_10));
        r127.setCornerRadius(c(2));
        r100.setBackground(r127);
        FrameLayout.LayoutParams r128 = new FrameLayout.LayoutParams(c(36), c(4), 49);
        r128.topMargin = c(6);
        r103.addView(r100, r128);
        e();
        if (this.f327072t == true) goto L35;
        r114 = 8;
    L35:
        r100.setVisibility(r114);
        a();
        r113.setContentDescription(r210);
        return;
    L28:
        if (r118 > 0) goto L30;
        r118 = 1;
    L30:
        Intrinsics.checkNotNullParameter("close", "name");
        r125 = new c19.c(r124, r119, r118, c19.f.f22100c.contains("close"));
        goto L31
    L16:
        r124 = c19.f.a(r121);     // Catch: Throwable -> L37
        if (r124 != null) goto L20;
        monitor-exit(r117);
    L24:
        r124 = null;
        goto L25
    L20:
        r122.put(r121, r124);     // Catch: Throwable -> L37
        monitor-exit(r117);
        goto L25
    L23:
        monitor-exit(r117);
    L37:
        th = move-exception;
        throw th;
    L7:
        r107 = Typeface.create("sans-serif-medium", 0);
        Intrinsics.checkNotNull(r107);
        goto L8
    L41:
        throw new IllegalArgumentException("关闭按钮必须提供非空无障碍文案".toString());
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        float r104 = c(24);
        this.f327055c.reset();
        this.f327055c.addRoundRect(new RectF(0.0f, 0.0f, r100, r101), new float[]{r104, r104, r104, r104, 0.0f, 0.0f, 0.0f, 0.0f}, Path.Direction.CW);
    }
}
