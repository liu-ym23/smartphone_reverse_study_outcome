package com.ss.android.ugc.aweme.search.common.view;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.camera.video.AudioStats;
import androidx.core.content.ContextCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import com.bytedance.article.common.monitor.stack.a;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.dmt.ui.widget.DoubleColorBallAnimationView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.aweme.search.common.helper.TradeSearchSaasHelper;
import com.ss.android.ugc.aweme.search.common.view.refreshdepend.MaterialProgressDrawable;
import com.ss.android.ugc.aweme.search.common.view.refreshdepend.SwipeRefreshCustomUI;
import com.ss.android.ugc.aweme.search.common.view.refreshdepend.SwipeRefreshLayout;
import em4.k;
import java.util.Objects;

/* JADX INFO: loaded from: classes40.dex */
public class DoubleBallSwipeRefreshLayout extends ViewGroup implements NestedScrollingParent, NestedScrollingChild {
    public static final int[] K = null;
    public boolean A;
    public int B;
    public final int C;
    public final int D;
    public boolean E;
    public float F;
    public final Animation.AnimationListener G;
    public final Animation H;
    public final Animation I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final SwipeRefreshCustomUI f452305J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f452306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f452307b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f452308c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f452309d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f452310e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Scroller f452311f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f452312g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final NestedScrollingParentHelper f452313h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final NestedScrollingChildHelper f452314i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int[] f452315j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int[] f452316k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f452317l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f452318m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f452319n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f452320o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f452321p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f452322q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f452323r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final DecelerateInterpolator f452324s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public DoubleColorBallAnimationView f452325t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f452326u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f452327v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public MaterialProgressDrawable f452328w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Animation f452329x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Animation f452330y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Animation f452331z;

    /* JADX INFO: renamed from: com.ss.android.ugc.aweme.search.common.view.DoubleBallSwipeRefreshLayout$1, reason: invalid class name */
    public class AnonymousClass1 implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoubleBallSwipeRefreshLayout f452332a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r100) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r100) {
        }

        public AnonymousClass1(DoubleBallSwipeRefreshLayout r100) {
            this.f452332a = r100;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r100) {
            DoubleBallSwipeRefreshLayout r101 = this.f452332a;
            if (r101.f452307b == false) goto L7;
            r101.f452305J.c(false);
            this.f452332a.f452328w.setAlpha(255);
            DoubleBallSwipeRefreshLayout r102 = this.f452332a;
            if (r102.A == false) goto L9;
            r102.getClass();
            this.f452332a.getClass();
            return;
        L9:
            return;
        L7:
            r101.d();
        }
    }

    public interface OnChildScrollUpCallback {
    }

    public interface OnRefreshStateListener {
    }

    public void setAnimationProgress(float r100) {
    }

    public void setColorScheme(int... r100) {
    }

    public void setOnChildScrollUpCallback(OnChildScrollUpCallback r100) {
    }

    public void setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener r100) {
    }

    public void setOnRefreshStateListener(OnRefreshStateListener r100) {
    }

    public void setOnSwipeChangeListener(SwipeRefreshLayout.OnSwipeChangeListener r100) {
    }

    public final void a() {
        if (this.f452306a != null) goto L11;
        int r100 = 0;
    L6:
        if (r100 >= getChildCount()) goto L15;
        View r101 = getChildAt(r100);
        if (r101.equals(this.f452325t) == false) goto L9;
        r100 = r100 + 1;
        goto L6
    L9:
        this.f452306a = r101;
        return;
    L15:
        return;
    }

    @Override // android.view.View
    public final void computeScroll() {
        if (this.f452311f.computeScrollOffset() == false) goto L6;
        scrollTo(this.f452311f.getCurrX(), this.f452311f.getCurrY());
        invalidate();
        return;
    }

    public final void d() {
        this.f452305J.c(true);
        setColorViewAlpha(255);
        invalidate();
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.f452313h.getNestedScrollAxes();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean hasNestedScrollingParent() {
        return this.f452314i.hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean isNestedScrollingEnabled() {
        return this.f452314i.isNestedScrollingEnabled();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final void stopNestedScroll() {
        this.f452314i.stopNestedScroll();
    }

    static {
        UIUtils.dip2Px(TradeSearchSaasHelper.a(), 16.0f);
        UIUtils.dip2Px(TradeSearchSaasHelper.a(), 14.0f);
        K = new int[]{R.attr.enabled};
    }

    public int getViewScrollYForRefreshLayout() {
        return getScrollY();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d();
    }

    public float getDistanceToTrigger() {
        return this.f452309d;
    }

    public float getMoveSpinnerRate() {
        return this.F;
    }

    public int getProgressCircleDiameter() {
        return this.B;
    }

    public int getProgressViewEndOffset() {
        return this.f452327v;
    }

    public int getProgressViewStartOffset() {
        return this.f452326u;
    }

    public DoubleBallSwipeRefreshLayout(Context r100) {
        this(r100, null);
    }

    private void setColorViewAlpha(int r100) {
        this.f452328w.setAlpha(r100);
    }

    public final void b(float r100) {
        if ((r100 * this.F) <= this.f452309d) goto L5;
        e(true, true);
        return;
    L5:
        this.f452307b = false;
        this.f452328w.f(0.0f);
        Animation.AnimationListener r101 = new AnonymousClass5(this);
        Animation.AnimationListener r102 = this.f452305J.a(r101);
        SwipeRefreshCustomUI r103 = this.f452305J;
        r103.getClass();
        Objects.toString(r102);
        r103.c(false);
        this.I.reset();
        this.I.setDuration(200);
        this.I.setInterpolator(this.f452324s);
        r102.onAnimationEnd(this.H);
        this.f452328w.g(false);
        this.f452311f.startScroll(0, getScrollY(), 0, -getScrollY(), Math.abs(getScrollY() * 2));
        invalidate();
        DoubleColorBallAnimationView r104 = this.f452325t;
        r104.getClass();
        k.a("widget/DoubleColorBallAnimationView>>>stopAnimate");
        r104.f248442a.b();
    }

    public final void c(float r110) {
        float r100 = this.F;
        if (r100 == 1.0f) goto L5;
        r110 = r110 * r100;
    L5:
        boolean r101 = true;
        this.f452328w.g(true);
        float r102 = r110 / this.f452309d;
        float r103 = (((float) Math.max(((double) Math.min(1.0f, Math.abs(r102))) - 0.4d, AudioStats.AUDIO_AMPLITUDE_NONE)) * 5.0f) / 3.0f;
        float r104 = Math.abs(r110) - this.f452309d;
        float r105 = this.f452327v;
        double r106 = Math.max(0.0f, Math.min(r104, r105 * 2.0f) / r105) / 4.0f;
        float r107 = ((float) (r106 - Math.pow(r106, 2.0d))) * 2.0f;
        if (r110 >= this.f452309d) goto L19;
        final int r108 = 76;
        if (this.f452328w.getAlpha() <= 76) goto L31;
        Animation r111 = this.f452330y;
        if (r111 != null) goto L12;
    L16:
        r101 = false;
    L17:
        if (r101 == true) goto L31;
        final int r112 = this.f452328w.getAlpha();
        Animation r109 = new AnonymousClass4(this, r112, r108);
        r109.setDuration(300);
        this.f452330y = r109;
        goto L31
    L12:
        if (r111.hasStarted() == false) goto L16;
        if (r111.hasEnded() == true) goto L16;
    L31:
        float r113 = (float) Math.atan(r102);
        scrollTo(0, (int) ((-this.f452309d) * r113));
        this.f452325t.setProgress(Math.max(0.0f, Math.min(1.0f, r113 - 0.5f)));
        this.f452328w.f(Math.min(0.8f, r103 * 0.8f));
        this.f452328w.a(Math.min(1.0f, r103));
        this.f452328w.d((((r103 * 0.4f) - 0.25f) + (r107 * 2.0f)) * 0.5f);
        invalidate();
        SwipeRefreshCustomUI r114 = this.f452305J;
        r114.getClass();
        r114.c(false);
        return;
    L19:
        final int r115 = 255;
        if (this.f452328w.getAlpha() >= 255) goto L31;
        Animation r116 = this.f452331z;
        if (r116 != null) goto L24;
    L28:
        r101 = false;
    L29:
        if (r101 == true) goto L31;
        final int r117 = this.f452328w.getAlpha();
        Animation r118 = new AnonymousClass4(this, r117, r115);
        r118.setDuration(300);
        this.f452331z = r118;
        goto L31
    L24:
        if (r116.hasStarted() == false) goto L28;
        if (r116.hasEnded() == true) goto L28;
        goto L28
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        a();
        int r101 = MotionEventCompat.getActionMasked(r100);
        int r102 = 0;
        if (isEnabled() == true) goto L5;
    L39:
        return false;
    L5:
        if (ViewCompat.canScrollVertically(this.f452306a, -1) == true) goto L39;
        if (this.f452307b == true) goto L39;
        if (this.f452317l == true) goto L39;
        if (r101 != 0) goto L12;
        int r103 = r100.getPointerId(0);
        this.f452323r = r103;
        this.f452322q = false;
        int r104 = r100.findPointerIndex(r103);
        if (r104 >= 0) goto L36;
        return false;
    L36:
        this.f452320o = r100.getY(r104);
        this.f452321p = r100.getX(r104);
    L38:
        return this.f452322q;
    L12:
        if (r101 != 1) goto L14;
    L32:
        this.f452322q = false;
        this.f452323r = -1;
        goto L38
    L14:
        if (r101 != 2) goto L16;
        int r105 = this.f452323r;
        if (r105 != (-1)) goto L28;
        return false;
    L28:
        int r106 = r100.findPointerIndex(r105);
        if (r106 >= 0) goto L31;
        return false;
    L31:
        f(r100.getX(r106), r100.getY(r106));
        goto L38
    L16:
        if (r101 == 3) goto L32;
        if (r101 != 6) goto L38;
        int r107 = MotionEventCompat.getActionIndex(r100);
        if (r100.getPointerId(r107) != this.f452323r) goto L38;
        if (r107 != 0) goto L24;
        r102 = 1;
    L24:
        this.f452323r = r100.getPointerId(r102);
        goto L38
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onStopNestedScroll(View r100) {
        this.f452313h.onStopNestedScroll(r100);
        this.f452317l = false;
        float r101 = this.f452312g;
        if (r101 <= 0.0f) goto L5;
        b(r101);
        this.f452312g = 0.0f;
    L5:
        stopNestedScroll();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        int r101 = MotionEventCompat.getActionMasked(r100);
        int r102 = 0;
        if (isEnabled() == true) goto L5;
    L52:
        return false;
    L5:
        if (ViewCompat.canScrollVertically(this.f452306a, -1) == true) goto L52;
        if (this.f452307b == true) goto L52;
        if (this.f452317l == true) goto L52;
        if (r101 != 0) goto L13;
        this.f452323r = r100.getPointerId(0);
        this.f452322q = false;
    L51:
        return true;
    L13:
        if (r101 != 1) goto L15;
    L42:
        int r103 = r100.findPointerIndex(this.f452323r);
        if (r103 >= 0) goto L46;
        return false;
    L46:
        if (this.f452322q == false) goto L48;
        float r104 = (r100.getY(r103) - this.f452319n) * 0.5f;
        this.f452322q = false;
        b(r104);
    L48:
        this.f452323r = -1;
        return false;
    L15:
        if (r101 != 2) goto L17;
        int r105 = r100.findPointerIndex(this.f452323r);
        if (r105 >= 0) goto L35;
        return false;
    L35:
        float r106 = r100.getX(r105);
        float r107 = r100.getY(r105);
        f(r106, r107);
        if (this.f452322q == false) goto L51;
        float r108 = (r107 - this.f452319n) * 0.5f;
        if (r108 <= 0.0f) goto L40;
        c(r108);
        goto L51
    L40:
        c(0.0f);
        return false;
    L17:
        if (r101 == 3) goto L42;
        if (r101 != 5) goto L21;
        int r109 = MotionEventCompat.getActionIndex(r100);
        if (r109 >= 0) goto L31;
        return false;
    L31:
        this.f452323r = r100.getPointerId(r109);
        goto L51
    L21:
        if (r101 != 6) goto L51;
        int r110 = MotionEventCompat.getActionIndex(r100);
        if (r100.getPointerId(r110) != this.f452323r) goto L51;
        if (r110 != 0) goto L27;
        r102 = 1;
    L27:
        this.f452323r = r100.getPointerId(r102);
        goto L51
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean r100) {
        super.requestDisallowInterceptTouchEvent(r100);
    }

    public void setColorSchemeColors(int... r100) {
        a();
        this.f452328w.c(r100);
    }

    public void setColorSchemeResources(int... r100) {
        Context r101 = getContext();
        int[] r102 = new int[r100.length];
        int r103 = 0;
    L4:
        if (r103 >= r100.length) goto L6;
        r102[r103] = ContextCompat.getColor(r101, r100[r103]);
        r103 = r103 + 1;
        goto L4
    L6:
        setColorSchemeColors(r102);
    }

    public void setDistanceToTriggerSync(int r100) {
        this.f452309d = r100;
    }

    public void setDoNotCatchException(boolean r100) {
        this.f452310e = r100;
    }

    public void setEnableDeltaX(boolean r100) {
        this.E = r100;
    }

    @Override // android.view.View
    public void setEnabled(boolean r100) {
        super.setEnabled(r100);
        if (r100 == true) goto L6;
        d();
        return;
    }

    public void setMoveSpinnerRate(float r100) {
        this.F = r100;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean r100) {
        this.f452314i.setNestedScrollingEnabled(r100);
    }

    public void setProgressBackgroundColor(int r100) {
        setProgressBackgroundColorSchemeResource(r100);
    }

    public void setProgressBackgroundColorSchemeColor(int r100) {
        this.f452328w.b(r100);
    }

    public void setProgressBackgroundColorSchemeResource(int r100) {
        setProgressBackgroundColorSchemeColor(ContextCompat.getColor(getContext(), r100));
    }

    public void setRefreshing(boolean r100) {
        if (r100 == true) goto L5;
    L10:
        e(r100, false);
        return;
    L5:
        if (this.f452307b == r100) goto L10;
        this.f452307b = r100;
        invalidate();
        this.A = false;
        Animation.AnimationListener r101 = this.G;
        this.f452328w.setAlpha(255);
        Animation r102 = new AnonymousClass2(this);
        this.f452329x = r102;
        r102.setDuration(this.f452318m);
        if (r101 == null) goto L9;
        ((AnonymousClass1) r101).onAnimationEnd(this.f452329x);
    L9:
        DoubleColorBallAnimationView r103 = this.f452325t;
        r103.getClass();
        k.a("widget/DoubleColorBallAnimationView>>>startAnimate");
        r103.f248442a.f();
        this.f452311f.startScroll(0, getScrollY(), 0, (int) (-this.f452309d));
    }

    public void setSize(int r100) {
        if (r100 != 0) goto L4;
    L6:
        Resources r101 = getResources();
        DisplayMetrics r102 = WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics());
        if (r100 != 0) goto L9;
        this.B = (int) (r102.density * 56.0f);
    L10:
        this.f452328w.i(r100);
        return;
    L9:
        this.B = (int) (r102.density * 40.0f);
        goto L10
    L4:
        if (r100 == 1) goto L6;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean startNestedScroll(int r100) {
        return this.f452314i.startNestedScroll(r100);
    }

    public DoubleBallSwipeRefreshLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f452307b = false;
        this.f452309d = -1.0f;
        this.f452310e = false;
        this.f452315j = new int[2];
        this.f452316k = new int[2];
        this.f452323r = -1;
        this.E = false;
        this.F = 1.0f;
        this.G = new AnonymousClass1(this);
        this.H = new AnonymousClass6(this);
        this.I = new AnonymousClass7(this);
        this.f452305J = new AnonymousClass9();
        this.f452308c = ViewConfiguration.get(r100).getScaledTouchSlop();
        this.f452311f = new Scroller(r100, new AccelerateDecelerateInterpolator());
        this.f452318m = getResources().getInteger(R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.f452324s = new DecelerateInterpolator(2.0f);
        Resources r102 = getResources();
        DisplayMetrics r103 = WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics());
        float r104 = r103.density;
        this.B = (int) (40.0f * r104);
        this.C = (int) (r104 * 56.0f);
        this.D = (int) (r104 * 32.0f);
        MaterialProgressDrawable r105 = new MaterialProgressDrawable(getContext(), this);
        this.f452328w = r105;
        r105.b(-328966);
        ViewCompat.setChildrenDrawingOrderEnabled(this, true);
        int r106 = (int) (r103.density * 56.0f);
        this.f452327v = r106;
        this.f452309d = r106;
        this.f452313h = new NestedScrollingParentHelper(this);
        this.f452314i = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        this.f452326u = -this.B;
        TypedArray r107 = r100.obtainStyledAttributes(r101, K);
        setEnabled(r107.getBoolean(0, true));
        r107.recycle();
        DoubleColorBallAnimationView r108 = new DoubleColorBallAnimationView(getContext(), null, 0, "swipe_refresh_layout");
        this.f452325t = r108;
        r108.setStartAnimationAfterAttach(false);
        addView(this.f452325t);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedPreFling(float r100, float r101) {
        return this.f452314i.dispatchNestedPreFling(r100, r101);
    }

    public final void e(boolean r100, boolean r101) {
        this.f452305J.getClass();
        if (this.f452307b == r100) goto L13;
        this.A = r101;
        a();
        this.f452307b = r100;
        if (r100 == false) goto L9;
        Animation.AnimationListener r102 = this.G;
        SwipeRefreshCustomUI r103 = this.f452305J;
        r103.getClass();
        Objects.toString(r102);
        r103.c(false);
        this.H.reset();
        this.H.setDuration(200);
        this.H.setInterpolator(this.f452324s);
        this.f452325t.setCycleBias(1);
        DoubleColorBallAnimationView r104 = this.f452325t;
        r104.getClass();
        k.a("widget/DoubleColorBallAnimationView>>>startAnimate");
        r104.f248442a.f();
        this.f452311f.startScroll(0, getScrollY(), 0, (-getScrollY()) - this.C, Math.abs(((-getScrollY()) - this.C) * 2));
        invalidate();
        if (r102 == null) goto L14;
        AnonymousClass1 r105 = (AnonymousClass1) r102;
        r105.onAnimationEnd(this.H);
        return;
    L14:
        return;
    L9:
        this.f452311f.forceFinished(true);
        this.f452311f.startScroll(0, getScrollY(), 0, -getScrollY(), Math.abs(getScrollY() * 2));
        invalidate();
        DoubleColorBallAnimationView r106 = this.f452325t;
        if (r106 == null) goto L16;
        k.a("widget/DoubleColorBallAnimationView>>>stopAnimate");
        r106.f248442a.b();
        return;
    L16:
        return;
    }

    public final void f(float r100, float r101) {
        float r102 = r101 - this.f452320o;
        float r103 = Math.abs(r100 - this.f452321p);
        if (this.E == true) goto L5;
    L8:
        boolean r104 = true;
    L9:
        int r105 = this.f452308c;
        if (r102 > r105) goto L12;
        return;
    L12:
        if (this.f452322q == true) goto L17;
        if (r104 == false) goto L18;
        this.f452319n = this.f452320o + r105;
        this.f452322q = true;
        this.f452328w.setAlpha(76);
        return;
    L18:
        return;
    L17:
        return;
    L5:
        if ((r103 / r102) < 1.0f) goto L8;
        r104 = false;
        goto L9
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (this.f452306a != null) goto L5;
        a();
    L5:
        View r102 = this.f452306a;
        if (r102 != null) goto L19;
        return;
    L19:
        r102.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));     // Catch: IllegalStateException -> L11
    L14:
        DoubleColorBallAnimationView r103 = this.f452325t;
        if (r103 == null) goto L21;
        r103.measure(View.MeasureSpec.makeMeasureSpec(this.D, 1073741824), View.MeasureSpec.makeMeasureSpec(this.D, 1073741824));
        return;
    L21:
        return;
    L11:
        e = move-exception;
        a.a(e, "DoubleBallSwipeRefreshLayout");
        if (this.f452310e == false) goto L14;
        throw e;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedFling(float r100, float r101, boolean r102) {
        return this.f452314i.dispatchNestedFling(r100, r101, r102);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedPreFling(View r100, float r101, float r102) {
        return dispatchNestedPreFling(r101, r102);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedScrollAccepted(View r100, View r101, int r102) {
        this.f452313h.onNestedScrollAccepted(r100, r101, r102);
        startNestedScroll(r102 & 2);
        this.f452312g = 0.0f;
        this.f452317l = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onStartNestedScroll(View r100, View r101, int r102) {
        if (isEnabled() == true) goto L5;
    L9:
        return false;
    L5:
        if (this.f452307b == true) goto L9;
        if ((r102 & 2) == 0) goto L9;
        return true;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedPreScroll(int r100, int r101, int[] r102, int[] r103) {
        return this.f452314i.dispatchNestedPreScroll(r100, r101, r102, r103);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedFling(View r100, float r101, float r102, boolean r103) {
        return dispatchNestedFling(r101, r102, r103);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedPreScroll(View r100, int r101, int r102, int[] r103) {
        if (r102 <= 0) goto L11;
        float r104 = this.f452312g;
        if (r104 <= 0.0f) goto L11;
        float r105 = r102;
        if (r105 <= r104) goto L9;
        r103[1] = r102 - ((int) r104);
        this.f452312g = 0.0f;
    L10:
        c(this.f452312g);
        goto L11
    L9:
        this.f452312g = r104 - r105;
        r103[1] = r102;
    L11:
        int[] r106 = this.f452315j;
        if (dispatchNestedPreScroll(r101 - r103[0], r102 - r103[1], r106, null) == false) goto L15;
        r103[0] = r103[0] + r106[0];
        r103[1] = r103[1] + r106[1];
        return;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedScroll(int r100, int r101, int r102, int r110, int[] r111) {
        return this.f452314i.dispatchNestedScroll(r100, r101, r102, r110, r111);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        int r105 = getMeasuredWidth();
        int r106 = getMeasuredHeight();
        if (getChildCount() != 0) goto L6;
        return;
    L6:
        if (this.f452306a != null) goto L8;
        a();
    L8:
        View r107 = this.f452306a;
        if (r107 != null) goto L11;
        return;
    L11:
        int r108 = getPaddingLeft();
        int r109 = getPaddingTop();
        int r110 = (r105 - getPaddingLeft()) - getPaddingRight();
        r107.layout(r108, r109, r110 + r108, ((r106 - getPaddingTop()) - getPaddingBottom()) + r109);     // Catch: Exception -> L14
    L17:
        int r111 = this.f452325t.getMeasuredWidth();
        int r112 = this.f452325t.getMeasuredHeight();
        int r113 = (r105 - r111) / 2;
        int r114 = (this.C + r112) / 2;
        this.f452325t.layout(r113, -r114, r111 + r113, 0);
        return;
    L14:
        e = move-exception;
        a.a(e, "DoubleBallSwipeRefreshLayout");
        if (this.f452310e == false) goto L17;
        throw e;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedScroll(View r100, int r101, int r102, int r110, int r111) {
        dispatchNestedScroll(r101, r102, r110, r111, this.f452316k);
        int r112 = r111 + this.f452316k[1];
        if (r112 < 0) goto L5;
        return;
    L5:
        if (ViewCompat.canScrollVertically(this.f452306a, -1) == true) goto L9;
        float r103 = this.f452312g + Math.abs(r112);
        this.f452312g = r103;
        c(r103);
        return;
    }
}
