package com.larus.browsertakeover.ui;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.common_ui.dbx.component.DbxButton;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.downloadlib.addownload.AdQuickAppManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes26.dex */
public final class b extends FrameLayout {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final float[] f319773n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f319774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f319775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f319776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f319777d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<ObjectAnimator> f319778e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<AppCompatImageView> f319779f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinearLayout f319780g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AppCompatImageView f319781h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f319782i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final DbxButton f319783j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final LinearLayout f319784k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final C4141b f319785l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Function0<Unit> f319786m;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.browsertakeover.ui.b$b, reason: collision with other inner class name */
    public static final class C4141b extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f319787a;

        @Override // android.database.ContentObserver
        public final void onChange(boolean r100) {
            this.f319787a.d();
        }

        public C4141b(b r100, Handler r101) {
            this.f319787a = r100;
            super(r101);
        }
    }

    static {
        f319773n = new float[]{1.0f, 0.6f, 0.3f};
    }

    public final void c() {
        Iterator<T> r100 = this.f319778e.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((ObjectAnimator) r100.next()).cancel();
        goto L4
    L6:
        this.f319778e.clear();
        Iterator<T> r101 = this.f319779f.iterator();
        int r102 = 0;
    L8:
        if (r101.hasNext() == false) goto L13;
        Object r103 = r101.next();
        int r104 = r102 + 1;
        if (r102 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        ((AppCompatImageView) r103).setAlpha(f319773n[r102]);
        r102 = r104;
        goto L8
    }

    public final void d() {
        if (this.f319775b == true) goto L5;
    L33:
        c();
        return;
    L5:
        if (this.f319776c == false) goto L33;
        if (isAttachedToWindow() == false) goto L33;
        if (isShown() == false) goto L33;
        if (getWindowVisibility() != 0) goto L33;
        if (Build.VERSION.SDK_INT < 26) goto L36;
        boolean r100 = ValueAnimator.areAnimatorsEnabled();
    L20:
        if (r100 == false) goto L33;
        if ((!this.f319778e.isEmpty()) == false) goto L25;
        return;
    L25:
        PathInterpolator r101 = new PathInterpolator(0.42f, 0.0f, 0.58f, 1.0f);
        Iterator<T> r102 = this.f319779f.iterator();
        int r103 = 0;
    L27:
        if (r102.hasNext() == false) goto L32;
        Object r104 = r102.next();
        int r105 = r103 + 1;
        if (r103 >= 0) goto L31;
        CollectionsKt.throwIndexOverflow();
    L31:
        AppCompatImageView r106 = (AppCompatImageView) r104;
        r106.setAlpha(0.3f);
        Keyframe r110 = Keyframe.ofFloat(0.2f, 1.0f);
        r110.setInterpolator(r101);
        Unit r111 = Unit.INSTANCE;
        Keyframe r112 = Keyframe.ofFloat(0.6f, 0.3f);
        r112.setInterpolator(r101);
        Keyframe r107 = Keyframe.ofFloat(1.0f, 0.3f);
        r107.setInterpolator(new LinearInterpolator());
        PropertyValuesHolder r108 = PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[]{Keyframe.ofFloat(0.0f, 0.3f), r110, r112, r107});
        List<ObjectAnimator> r113 = this.f319778e;
        ObjectAnimator r109 = ObjectAnimator.ofPropertyValuesHolder(r106, new PropertyValuesHolder[]{r108});
        r109.setDuration(AdQuickAppManager.DEFAULT_QUICK_APP_CHECK_TIME);
        r109.setStartDelay(((long) r103) * 200);
        r109.setInterpolator(new LinearInterpolator());
        r109.setRepeatCount(-1);
        r109.setRepeatMode(1);
        r109.start();
        r113.add(r109);
        r103 = r105;
        goto L27
    L32:
        return;
    L36:
        if (Settings.Global.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0f) <= 0.0f) goto L19;
        r100 = true;
    L19:
        r100 = false;
        goto L20
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        if (this.f319777d == false) goto L5;
        getContext().getContentResolver().unregisterContentObserver(this.f319785l);
        this.f319777d = false;
    L5:
        c();
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        getContext().getContentResolver().registerContentObserver(Settings.Global.getUriFor("animator_duration_scale"), false, this.f319785l);     // Catch: SecurityException -> L5
        this.f319777d = true;     // Catch: SecurityException -> L5
    L6:
        d();
        return;
    L5:
        FLogger.f375446a.i("BrowserConnectionStatus", "animation_scale_observer_unavailable");
        goto L6
    }

    public final Function0<Unit> getOnRetry() {
        return this.f319786m;
    }

    public b(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(com.larus.common_ui.dbx.theme.a.c(r110));
        this.f319778e = new ArrayList();
        List<AppCompatImageView> r100 = CollectionsKt.listOf(new AppCompatImageView[]{b(R.drawable.larus_takeover_ic_status_dots_left), b(R.drawable.larus_takeover_ic_status_dots_middle), b(R.drawable.larus_takeover_ic_status_dots_right)});
        this.f319779f = r100;
        LinearLayout r101 = new LinearLayout(getContext());
        r101.setOrientation(0);
        r101.setGravity(16);
        r101.setImportantForAccessibility(4);
        float r111 = 40;
        r101.addView(b(R.drawable.larus_takeover_ic_status_mobile), new LinearLayout.LayoutParams(a(r111), a(r111)));
        FrameLayout r102 = new FrameLayout(r110);
        Iterator<T> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r102.addView((AppCompatImageView) r103.next(), new FrameLayout.LayoutParams(a(20.9375f), a(5), 17));
        goto L4
    L6:
        float r104 = 24;
        LinearLayout.LayoutParams r105 = new LinearLayout.LayoutParams(a(r104), a(r104));
        float r106 = 20;
        r105.setMarginStart(a(r106));
        Unit r112 = Unit.INSTANCE;
        r101.addView(r102, r105);
        AppCompatImageView r107 = b(R.drawable.larus_takeover_ic_status_computer);
        LinearLayout.LayoutParams r108 = new LinearLayout.LayoutParams(a(r111), a(r111));
        r108.setMarginStart(a(r106));
        r101.addView(r107, r108);
        this.f319780g = r101;
        AppCompatImageView r109 = b(R.drawable.larus_takeover_ic_status_failure);
        this.f319781h = r109;
        TextView r113 = new TextView(getContext());
        r113.setTextSize(17.0f);
        if (Build.VERSION.SDK_INT < 28) goto L9;
        Typeface r114 = Typeface.create(Typeface.DEFAULT, 600, false);
    L10:
        r113.setTypeface(r114);
        r113.setTextColor(-1);
        r113.setGravity(17);
        r113.setIncludeFontPadding(false);
        r113.setMinimumHeight(a(26));
        r113.setLineSpacing(0.0f, 1.5f);
        r113.setAccessibilityLiveRegion(1);
        this.f319782i = r113;
        final DbxButton r115 = new DbxButton(getContext(), null, 6, 0);
        r115.b(DbxButton.Style.SOLID, DbxButton.Size.L);
        r115.setLeadingIcon(null);
        r115.setTrailingIcon(null);
        r115.setMinimumWidth(a(116));
        r115.setOnClickListener(new com.larus.browsertakeover.ui.a(this, r115));
        this.f319783j = r115;
        LinearLayout r116 = new LinearLayout(getContext());
        r116.setOrientation(1);
        r116.setGravity(1);
        FrameLayout r117 = new FrameLayout(r110);
        float r118 = 144;
        r117.addView(r101, new FrameLayout.LayoutParams(a(r118), a(r111), 17));
        r117.addView(r109, new FrameLayout.LayoutParams(a(r111), a(r111), 17));
        r116.addView(r117, new LinearLayout.LayoutParams(a(r118), a(r111)));
        LinearLayout.LayoutParams r119 = new LinearLayout.LayoutParams(-1, -2);
        float r120 = 16;
        r119.topMargin = a(r120);
        r116.addView(r113, r119);
        LinearLayout.LayoutParams r121 = new LinearLayout.LayoutParams(-2, -2);
        r121.topMargin = a(r120);
        r116.addView(r115, r121);
        this.f319784k = r116;
        this.f319785l = new C4141b(this, new Handler(Looper.getMainLooper()));
        setBackgroundColor(-16777216);
        setClickable(true);
        setFocusable(false);
        setImportantForAccessibility(2);
        FrameLayout.LayoutParams r122 = new FrameLayout.LayoutParams(-1, -2);
        float r123 = 32;
        r122.leftMargin = a(r123);
        r122.rightMargin = a(r123);
        addView(r116, r122);
        this.f319774a = true;
        this.f319775b = false;
        setVisibility(8);
        c();
        return;
    L9:
        r114 = Typeface.create("sans-serif-medium", 0);
        goto L10
    }

    public final int a(float r100) {
        Resources r101 = getResources();
        return MathKt.roundToInt(r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density);
    }

    public final AppCompatImageView b(int r100) {
        AppCompatImageView r101 = new AppCompatImageView(getContext());
        r101.setScaleType(ImageView.ScaleType.FIT_CENTER);
        r101.setImageResource(r100);
        r101.setImportantForAccessibility(2);
        return r101;
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int r100) {
        super.onWindowVisibilityChanged(r100);
        if (this.f319774a == false) goto L6;
        d();
        return;
    }

    public final void setHostActive(boolean r100) {
        this.f319776c = r100;
        d();
    }

    public final void setOnRetry(Function0<Unit> r100) {
        this.f319786m = r100;
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "changedView");
        super.onVisibilityChanged(r100, r101);
        if (this.f319774a == false) goto L6;
        d();
        return;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        int r105 = RangesKt.coerceIn(MathKt.roundToInt(((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.36437246f), 0, RangesKt.coerceAtLeast(((getHeight() - getPaddingTop()) - getPaddingBottom()) - this.f319784k.getMeasuredHeight(), 0));
        int r106 = (getWidth() - this.f319784k.getMeasuredWidth()) / 2;
        this.f319784k.layout(r106, getPaddingTop() + r105, this.f319784k.getMeasuredWidth() + r106, (getPaddingTop() + r105) + this.f319784k.getMeasuredHeight());
    }
}
