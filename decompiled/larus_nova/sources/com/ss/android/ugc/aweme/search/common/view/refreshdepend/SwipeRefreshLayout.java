package com.ss.android.ugc.aweme.search.common.view.refreshdepend;

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
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import androidx.camera.video.AudioStats;
import androidx.core.content.ContextCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import com.bytedance.article.common.monitor.stack.a;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Objects;

/* JADX INFO: loaded from: classes40.dex */
public class SwipeRefreshLayout extends ViewGroup implements NestedScrollingParent, NestedScrollingChild {
    public static final int[] I = null;
    public Animation A;
    public Animation B;
    public boolean C;
    public int D;
    public final Animation.AnimationListener E;
    public final Animation F;
    public final Animation G;
    public final SwipeRefreshCustomUI H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f452431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f452432b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f452433c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f452434d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f452435e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f452436f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final NestedScrollingParentHelper f452437g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final NestedScrollingChildHelper f452438h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int[] f452439i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int[] f452440j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f452441k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f452442l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f452443m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f452444n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f452445o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f452446p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f452447q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final DecelerateInterpolator f452448r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public CircleImageView f452449s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f452450t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f452451u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f452452v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f452453w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public MaterialProgressDrawable f452454x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Animation f452455y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Animation f452456z;

    /* JADX INFO: renamed from: com.ss.android.ugc.aweme.search.common.view.refreshdepend.SwipeRefreshLayout$3, reason: invalid class name */
    class AnonymousClass3 extends Animation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SwipeRefreshLayout f452459a;

        public AnonymousClass3(SwipeRefreshLayout r100) {
            this.f452459a = r100;
        }

        @Override // android.view.animation.Animation
        public final void applyTransformation(float r100, Transformation r101) {
            this.f452459a.setAnimationProgress(1.0f - r100);
        }
    }

    public interface OnChildScrollUpCallback {
    }

    public interface OnRefreshListener {
    }

    public interface OnSwipeChangeListener {
    }

    public void setOnChildScrollUpCallback(OnChildScrollUpCallback r100) {
    }

    public void setOnRefreshListener(OnRefreshListener r100) {
    }

    public void setOnSwipeChangeListener(OnSwipeChangeListener r100) {
    }

    static {
        I = new int[]{R.attr.enabled};
    }

    public final void a() {
        if (this.f452431a != null) goto L11;
        int r100 = 0;
    L6:
        if (r100 >= getChildCount()) goto L15;
        View r101 = getChildAt(r100);
        if (r101.equals(this.f452449s) == false) goto L9;
        r100 = r100 + 1;
        goto L6
    L9:
        this.f452431a = r101;
        return;
    L15:
        return;
    }

    public final void e() {
        this.H.c(true);
        this.f452449s.clearAnimation();
        this.f452454x.stop();
        this.f452449s.setVisibility(8);
        setColorViewAlpha(255);
        g(this.f452452v - this.f452443m);
        this.f452443m = this.f452449s.getTop();
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.f452437g.getNestedScrollAxes();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean hasNestedScrollingParent() {
        return this.f452438h.hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean isNestedScrollingEnabled() {
        return this.f452438h.isNestedScrollingEnabled();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final void stopNestedScroll() {
        this.f452438h.stopNestedScroll();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
    }

    public int getProgressCircleDiameter() {
        return this.D;
    }

    public int getProgressViewEndOffset() {
        return this.f452453w;
    }

    public int getProgressViewStartOffset() {
        return this.f452452v;
    }

    public SwipeRefreshLayout(Context r100) {
        this(r100, null);
    }

    private void setColorViewAlpha(int r100) {
        this.f452449s.getBackground().setAlpha(r100);
        this.f452454x.setAlpha(r100);
    }

    public final void b(float r100) {
        if (r100 <= this.f452434d) goto L5;
        f(true, true);
        return;
    L5:
        this.f452432b = false;
        this.f452454x.f(0.0f);
        Animation.AnimationListener r101 = new AnonymousClass5(this);
        int r102 = this.f452443m;
        SwipeRefreshCustomUI r103 = this.H;
        r103.getClass();
        SwipeRefreshCustomUI.AnonymousClass1 r104 = new SwipeRefreshCustomUI.AnonymousClass1(r103, r101);
        SwipeRefreshCustomUI r105 = this.H;
        r105.getClass();
        Objects.toString(r104);
        r105.c(false);
        this.f452451u = r102;
        this.G.reset();
        this.G.setDuration(200);
        this.G.setInterpolator(this.f452448r);
        CircleImageView r106 = this.f452449s;
        r106.f452382a = r104;
        r106.clearAnimation();
        this.f452449s.startAnimation(this.G);
        this.f452454x.g(false);
    }

    public final void c(float r110) {
        boolean r100 = true;
        this.f452454x.g(true);
        float r101 = Math.min(1.0f, Math.abs(r110 / this.f452434d));
        float r102 = (((float) Math.max(((double) r101) - 0.4d, AudioStats.AUDIO_AMPLITUDE_NONE)) * 5.0f) / 3.0f;
        float r103 = Math.abs(r110) - this.f452434d;
        float r104 = this.f452453w;
        double r105 = Math.max(0.0f, Math.min(r103, r104 * 2.0f) / r104) / 4.0f;
        float r106 = ((float) (r105 - Math.pow(r105, 2.0d))) * 2.0f;
        int r107 = this.f452452v + ((int) ((r104 * r101) + ((r104 * r106) * 2.0f)));
        if (this.f452449s.getVisibility() == 0) goto L5;
        this.f452449s.setVisibility(0);
    L5:
        ViewCompat.setScaleX(this.f452449s, 1.0f);
        ViewCompat.setScaleY(this.f452449s, 1.0f);
        if (r110 >= this.f452434d) goto L19;
        final int r108 = 76;
        if (this.f452454x.getAlpha() <= 76) goto L31;
        Animation r111 = this.A;
        if (r111 != null) goto L12;
    L16:
        r100 = false;
    L17:
        if (r100 == true) goto L31;
        final int r112 = this.f452454x.getAlpha();
        Animation r109 = new AnonymousClass4(this, r112, r108);
        r109.setDuration(300);
        CircleImageView r113 = this.f452449s;
        r113.f452382a = null;
        r113.clearAnimation();
        this.f452449s.startAnimation(r109);
        this.A = r109;
        goto L31
    L12:
        if (r111.hasStarted() == false) goto L16;
        if (r111.hasEnded() == true) goto L16;
    L31:
        this.f452454x.f(Math.min(0.8f, r102 * 0.8f));
        this.f452454x.a(Math.min(1.0f, r102));
        this.f452454x.d((((r102 * 0.4f) - 0.25f) + (r106 * 2.0f)) * 0.5f);
        g(r107 - this.f452443m);
        SwipeRefreshCustomUI r114 = this.H;
        r114.getClass();
        r114.c(false);
        return;
    L19:
        final int r115 = 255;
        if (this.f452454x.getAlpha() >= 255) goto L31;
        Animation r116 = this.B;
        if (r116 != null) goto L24;
    L28:
        r100 = false;
    L29:
        if (r100 == true) goto L31;
        final int r117 = this.f452454x.getAlpha();
        Animation r118 = new AnonymousClass4(this, r117, r115);
        r118.setDuration(300);
        CircleImageView r119 = this.f452449s;
        r119.f452382a = null;
        r119.clearAnimation();
        this.f452449s.startAnimation(r118);
        this.B = r118;
        goto L31
    L24:
        if (r116.hasStarted() == false) goto L28;
        if (r116.hasEnded() == true) goto L28;
        goto L28
    }

    public final void d(float r100) {
        int r101 = this.f452451u;
        g((r101 + ((int) ((this.f452452v - r101) * r100))) - this.f452449s.getTop());
    }

    public final void g(int r100) {
        this.f452449s.bringToFront();
        ViewCompat.offsetTopAndBottom(this.f452449s, r100);
        this.f452443m = this.f452449s.getTop();
    }

    public final void h(float r100) {
        float r101 = this.f452445o;
        float r102 = r100 - r101;
        int r103 = this.f452433c;
        if (r102 > r103) goto L5;
        return;
    L5:
        if (this.f452446p == true) goto L9;
        this.f452444n = r101 + r103;
        this.f452446p = true;
        this.f452454x.setAlpha(76);
        return;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        a();
        int r101 = MotionEventCompat.getActionMasked(r100);
        int r102 = 0;
        if (isEnabled() == true) goto L5;
    L40:
        return false;
    L5:
        if (ViewCompat.canScrollVertically(this.f452431a, -1) == true) goto L40;
        if (this.f452432b == true) goto L40;
        if (this.f452441k == true) goto L40;
        if (r101 != 0) goto L13;
        g(this.f452452v - this.f452449s.getTop());
        int r103 = r100.getPointerId(0);
        this.f452447q = r103;
        this.f452446p = false;
        int r104 = r100.findPointerIndex(r103);
        if (r104 >= 0) goto L37;
        return false;
    L37:
        this.f452445o = r100.getY(r104);
    L39:
        return this.f452446p;
    L13:
        if (r101 != 1) goto L15;
    L33:
        this.f452446p = false;
        this.f452447q = -1;
        goto L39
    L15:
        if (r101 != 2) goto L17;
        int r105 = this.f452447q;
        if (r105 != (-1)) goto L29;
        return false;
    L29:
        int r106 = r100.findPointerIndex(r105);
        if (r106 >= 0) goto L32;
        return false;
    L32:
        h(r100.getY(r106));
        goto L39
    L17:
        if (r101 == 3) goto L33;
        if (r101 != 6) goto L39;
        int r107 = MotionEventCompat.getActionIndex(r100);
        if (r100.getPointerId(r107) != this.f452447q) goto L39;
        if (r107 != 0) goto L25;
        r102 = 1;
    L25:
        this.f452447q = r100.getPointerId(r102);
        goto L39
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onStopNestedScroll(View r100) {
        this.f452437g.onStopNestedScroll(r100);
        this.f452441k = false;
        float r101 = this.f452436f;
        if (r101 <= 0.0f) goto L5;
        b(r101);
        this.f452436f = 0.0f;
    L5:
        stopNestedScroll();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        int r101 = MotionEventCompat.getActionMasked(r100);
        int r102 = 0;
        if (isEnabled() == true) goto L5;
    L53:
        return false;
    L5:
        if (ViewCompat.canScrollVertically(this.f452431a, -1) == true) goto L53;
        if (this.f452432b == true) goto L53;
        if (this.f452441k == true) goto L53;
        if (r101 != 0) goto L14;
        this.f452447q = r100.getPointerId(0);
        this.f452446p = false;
    L52:
        return true;
    L14:
        if (r101 != 1) goto L16;
    L43:
        int r103 = r100.findPointerIndex(this.f452447q);
        if (r103 >= 0) goto L47;
        return false;
    L47:
        if (this.f452446p == false) goto L49;
        float r104 = (r100.getY(r103) - this.f452444n) * 0.5f;
        this.f452446p = false;
        b(r104);
    L49:
        this.f452447q = -1;
        return false;
    L16:
        if (r101 != 2) goto L18;
        int r105 = r100.findPointerIndex(this.f452447q);
        if (r105 >= 0) goto L36;
        return false;
    L36:
        float r106 = r100.getY(r105);
        h(r106);
        if (this.f452446p == false) goto L52;
        float r107 = (r106 - this.f452444n) * 0.5f;
        if (r107 <= 0.0f) goto L41;
        c(r107);
        goto L52
    L41:
        c(0.0f);
        return false;
    L18:
        if (r101 == 3) goto L43;
        if (r101 != 5) goto L22;
        int r108 = MotionEventCompat.getActionIndex(r100);
        if (r108 >= 0) goto L32;
        return false;
    L32:
        this.f452447q = r100.getPointerId(r108);
        goto L52
    L22:
        if (r101 != 6) goto L52;
        int r109 = MotionEventCompat.getActionIndex(r100);
        if (r100.getPointerId(r109) != this.f452447q) goto L52;
        if (r109 != 0) goto L28;
        r102 = 1;
    L28:
        this.f452447q = r100.getPointerId(r102);
        goto L52
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean r100) {
        super.requestDisallowInterceptTouchEvent(r100);
    }

    public void setAnimationProgress(float r100) {
        ViewCompat.setScaleX(this.f452449s, r100);
        ViewCompat.setScaleY(this.f452449s, r100);
    }

    public void setColorScheme(int... r100) {
        setColorSchemeResources(r100);
    }

    public void setColorSchemeColors(int... r100) {
        a();
        this.f452454x.c(r100);
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
        this.f452434d = r100;
    }

    public void setDoNotCatchException(boolean r100) {
        this.f452435e = r100;
    }

    @Override // android.view.View
    public void setEnabled(boolean r100) {
        super.setEnabled(r100);
        if (r100 == true) goto L6;
        e();
        return;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean r100) {
        this.f452438h.setNestedScrollingEnabled(r100);
    }

    public void setProgressBackgroundColor(int r100) {
        setProgressBackgroundColorSchemeResource(r100);
    }

    public void setProgressBackgroundColorSchemeColor(int r100) {
        this.f452449s.setBackgroundColor(r100);
        this.f452454x.f452387b.f452424w = r100;
    }

    public void setProgressBackgroundColorSchemeResource(int r100) {
        setProgressBackgroundColorSchemeColor(ContextCompat.getColor(getContext(), r100));
    }

    public void setRefreshing(boolean r100) {
        if (r100 == true) goto L5;
    L10:
        f(r100, false);
        return;
    L5:
        if (this.f452432b == r100) goto L10;
        this.f452432b = r100;
        g((this.f452453w + this.f452452v) - this.f452443m);
        this.C = false;
        Animation.AnimationListener r101 = this.E;
        this.f452449s.setVisibility(0);
        this.f452454x.setAlpha(255);
        Animation r102 = new AnonymousClass2(this);
        this.f452455y = r102;
        r102.setDuration(this.f452442l);
        if (r101 == null) goto L9;
        this.f452449s.f452382a = r101;
    L9:
        this.f452449s.clearAnimation();
        this.f452449s.startAnimation(this.f452455y);
    }

    public void setSize(int r100) {
        if (r100 != 0) goto L4;
    L6:
        Resources r101 = getResources();
        DisplayMetrics r102 = WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics());
        if (r100 != 0) goto L9;
        this.D = (int) (r102.density * 56.0f);
    L10:
        this.f452449s.setImageDrawable(null);
        this.f452454x.i(r100);
        this.f452449s.setImageDrawable(this.f452454x);
        return;
    L9:
        this.D = (int) (r102.density * 40.0f);
        goto L10
    L4:
        if (r100 == 1) goto L6;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean startNestedScroll(int r100) {
        return this.f452438h.startNestedScroll(r100);
    }

    public SwipeRefreshLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f452432b = false;
        this.f452434d = -1.0f;
        this.f452435e = false;
        this.f452439i = new int[2];
        this.f452440j = new int[2];
        this.f452447q = -1;
        this.f452450t = -1;
        this.E = new AnonymousClass1(this);
        this.F = new AnonymousClass6(this);
        this.G = new AnonymousClass7(this);
        this.H = new AnonymousClass9();
        this.f452433c = ViewConfiguration.get(r100).getScaledTouchSlop();
        this.f452442l = getResources().getInteger(R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.f452448r = new DecelerateInterpolator(2.0f);
        Resources r102 = getResources();
        DisplayMetrics r103 = WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics());
        this.D = (int) (r103.density * 40.0f);
        this.f452449s = new CircleImageView(getContext());
        MaterialProgressDrawable r104 = new MaterialProgressDrawable(getContext(), this);
        this.f452454x = r104;
        r104.f452387b.f452424w = -328966;
        this.f452449s.setImageDrawable(r104);
        this.f452449s.setVisibility(8);
        addView(this.f452449s);
        ViewCompat.setChildrenDrawingOrderEnabled(this, true);
        int r105 = (int) (r103.density * 64.0f);
        this.f452453w = r105;
        this.f452434d = r105;
        this.f452437g = new NestedScrollingParentHelper(this);
        this.f452438h = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        int r106 = -this.D;
        this.f452443m = r106;
        this.f452452v = r106;
        d(1.0f);
        TypedArray r107 = r100.obtainStyledAttributes(r101, I);
        setEnabled(r107.getBoolean(0, true));
        r107.recycle();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedPreFling(float r100, float r101) {
        return this.f452438h.dispatchNestedPreFling(r100, r101);
    }

    public final void f(boolean r100, boolean r101) {
        this.H.getClass();
        if (this.f452432b == r100) goto L12;
        this.C = r101;
        a();
        this.f452432b = r100;
        if (r100 == false) goto L10;
        int r102 = this.f452443m;
        Animation.AnimationListener r103 = this.E;
        SwipeRefreshCustomUI r104 = this.H;
        r104.getClass();
        Objects.toString(r103);
        r104.c(false);
        this.f452451u = r102;
        this.F.reset();
        this.F.setDuration(200);
        this.F.setInterpolator(this.f452448r);
        if (r103 == null) goto L9;
        this.f452449s.f452382a = r103;
    L9:
        this.f452449s.clearAnimation();
        this.f452449s.startAnimation(this.F);
        return;
    L10:
        Animation.AnimationListener r105 = this.E;
        AnonymousClass3 r106 = new AnonymousClass3(this);
        this.f452456z = r106;
        r106.setDuration(150);
        CircleImageView r107 = this.f452449s;
        r107.f452382a = r105;
        r107.clearAnimation();
        this.f452449s.startAnimation(this.f452456z);
        return;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int r100, int r101) {
        int r102 = this.f452450t;
        if (r102 >= 0) goto L6;
        return r101;
    L6:
        if (r101 != (r100 - 1)) goto L8;
        return r102;
    L8:
        if (r101 >= r102) goto L10;
        return r101;
    L10:
        return r101 + 1;
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (this.f452431a != null) goto L5;
        a();
    L5:
        View r102 = this.f452431a;
        if (r102 != null) goto L23;
        return;
    L23:
        r102.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));     // Catch: IllegalStateException -> L11
    L14:
        this.f452449s.measure(View.MeasureSpec.makeMeasureSpec(this.D, 1073741824), View.MeasureSpec.makeMeasureSpec(this.D, 1073741824));
        this.f452450t = -1;
        int r103 = 0;
    L16:
        if (r103 >= getChildCount()) goto L27;
        if (getChildAt(r103) == this.f452449s) goto L19;
        r103 = r103 + 1;
        goto L16
    L19:
        this.f452450t = r103;
        return;
    L27:
        return;
    L11:
        e = move-exception;
        a.a(e, "SwipeRefreshLayout");
        if (this.f452435e == false) goto L14;
        throw e;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedFling(float r100, float r101, boolean r102) {
        return this.f452438h.dispatchNestedFling(r100, r101, r102);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedPreFling(View r100, float r101, float r102) {
        return dispatchNestedPreFling(r101, r102);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedScrollAccepted(View r100, View r101, int r102) {
        this.f452437g.onNestedScrollAccepted(r100, r101, r102);
        startNestedScroll(r102 & 2);
        this.f452436f = 0.0f;
        this.f452441k = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onStartNestedScroll(View r100, View r101, int r102) {
        if (isEnabled() == true) goto L5;
    L9:
        return false;
    L5:
        if (this.f452432b == true) goto L9;
        if ((r102 & 2) == 0) goto L9;
        return true;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedPreScroll(int r100, int r101, int[] r102, int[] r103) {
        return this.f452438h.dispatchNestedPreScroll(r100, r101, r102, r103);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedFling(View r100, float r101, float r102, boolean r103) {
        return dispatchNestedFling(r101, r102, r103);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedPreScroll(View r100, int r101, int r102, int[] r103) {
        if (r102 <= 0) goto L11;
        float r104 = this.f452436f;
        if (r104 <= 0.0f) goto L11;
        float r105 = r102;
        if (r105 <= r104) goto L9;
        r103[1] = r102 - ((int) r104);
        this.f452436f = 0.0f;
    L10:
        c(this.f452436f);
        goto L11
    L9:
        this.f452436f = r104 - r105;
        r103[1] = r102;
    L11:
        int[] r106 = this.f452439i;
        if (dispatchNestedPreScroll(r101 - r103[0], r102 - r103[1], r106, null) == false) goto L15;
        r103[0] = r103[0] + r106[0];
        r103[1] = r103[1] + r106[1];
        return;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedScroll(int r100, int r101, int r102, int r110, int[] r111) {
        return this.f452438h.dispatchNestedScroll(r100, r101, r102, r110, r111);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        int r105 = getMeasuredWidth();
        int r106 = getMeasuredHeight();
        if (getChildCount() != 0) goto L6;
        return;
    L6:
        if (this.f452431a != null) goto L8;
        a();
    L8:
        View r107 = this.f452431a;
        if (r107 != null) goto L11;
        return;
    L11:
        int r108 = getPaddingLeft();
        int r109 = getPaddingTop();
        int r110 = (r105 - getPaddingLeft()) - getPaddingRight();
        r107.layout(r108, r109, r110 + r108, ((r106 - getPaddingTop()) - getPaddingBottom()) + r109);     // Catch: Exception -> L14
    L17:
        int r111 = this.f452449s.getMeasuredWidth();
        int r112 = this.f452449s.getMeasuredHeight();
        int r113 = r105 / 2;
        int r114 = r111 / 2;
        int r115 = this.f452443m;
        this.f452449s.layout(r113 - r114, r115, r113 + r114, r112 + r115);
        return;
    L14:
        e = move-exception;
        a.a(e, "SwipeRefreshLayout");
        if (this.f452435e == false) goto L17;
        throw e;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedScroll(View r100, int r101, int r102, int r110, int r111) {
        dispatchNestedScroll(r101, r102, r110, r111, this.f452440j);
        int r112 = r111 + this.f452440j[1];
        if (r112 < 0) goto L5;
        return;
    L5:
        if (ViewCompat.canScrollVertically(this.f452431a, -1) == true) goto L9;
        float r103 = this.f452436f + Math.abs(r112);
        this.f452436f = r103;
        c(r103);
        return;
    }
}
