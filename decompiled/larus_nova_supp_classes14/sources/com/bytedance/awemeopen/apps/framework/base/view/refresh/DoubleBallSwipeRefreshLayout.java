package com.bytedance.awemeopen.apps.framework.base.view.refresh;

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
import android.view.animation.Transformation;
import android.widget.Scroller;
import androidx.core.content.ContextCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import com.bytedance.awemeopen.apps.framework.utils.n0;
import com.bytedance.awemeopen.servicesapi.context.AoHostService;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class DoubleBallSwipeRefreshLayout extends ViewGroup implements NestedScrollingParent, NestedScrollingChild, i {
    public static final int[] L = null;
    public com.bytedance.awemeopen.apps.framework.base.view.refresh.e A;
    public boolean B;
    public int C;
    public final int D;
    public final int E;
    public h F;
    public boolean G;
    public final a H;
    public final c I;
    public final d J;
    public final e K;
    public View a;
    public g b;
    public boolean c;
    public final int d;
    public float e;
    public boolean f;
    public final Scroller g;
    public float h;
    public final NestedScrollingParentHelper i;
    public final NestedScrollingChildHelper j;
    public final int[] k;
    public final int[] l;
    public boolean m;
    public final int n;
    public float o;
    public float p;
    public float q;
    public boolean r;
    public int s;
    public final DecelerateInterpolator t;
    public DoubleColorBallAnimationView u;
    public final int v;
    public final int w;
    public MaterialProgressDrawable x;
    public com.bytedance.awemeopen.apps.framework.base.view.refresh.c y;
    public com.bytedance.awemeopen.apps.framework.base.view.refresh.e z;

    public class a implements Animation.AnimationListener {
        public final /* synthetic */ DoubleBallSwipeRefreshLayout a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r1) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r1) {
        }

        public a(DoubleBallSwipeRefreshLayout r1) {
            this.a = r1;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r3) {
            DoubleBallSwipeRefreshLayout r4 = this.a;
            if (r4.c == false) goto L9;
            r4.K.b(false);
            MaterialProgressDrawable r5 = this.a.x;
            r5.b.u = 255;
            r5.start();
            DoubleBallSwipeRefreshLayout r6 = this.a;
            if (r6.B == false) goto L11;
            g r7 = r6.b;
            if (r7 == null) goto L12;
            r7.onRefresh();
            return;
        L12:
            return;
        L11:
            return;
        L9:
            r4.d();
        }
    }

    public class b implements Animation.AnimationListener {
        public final /* synthetic */ DoubleBallSwipeRefreshLayout a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r1) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r1) {
        }

        public b(DoubleBallSwipeRefreshLayout r1) {
            this.a = r1;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r4) {
            this.a.getClass();
            DoubleBallSwipeRefreshLayout r5 = this.a;
            r5.getClass();
            com.bytedance.awemeopen.apps.framework.base.view.refresh.d r0 = new com.bytedance.awemeopen.apps.framework.base.view.refresh.d(r5);
            r5.getClass();
            r0.setDuration(150);
        }
    }

    public class c extends Animation {
        public final /* synthetic */ DoubleBallSwipeRefreshLayout a;

        public c(DoubleBallSwipeRefreshLayout r1) {
            this.a = r1;
        }

        @Override // android.view.animation.Animation
        public final void applyTransformation(float r2, Transformation r3) {
            this.a.getClass();
            DoubleBallSwipeRefreshLayout r4 = this.a;
            int r0 = r4.w;
            Math.abs(r4.v);
            float r1 = 1.0f - r2;
            MaterialProgressDrawable.c r5 = this.a.x.b;
            if (r1 == r5.q) goto L6;
            r5.q = r1;
            r5.a();
            return;
        }
    }

    public class d extends Animation {
        public final /* synthetic */ DoubleBallSwipeRefreshLayout a;

        public d(DoubleBallSwipeRefreshLayout r1) {
            this.a = r1;
        }

        @Override // android.view.animation.Animation
        public final void applyTransformation(float r1, Transformation r2) {
            this.a.getClass();
        }
    }

    public class e extends t {
        @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.t
        public final void a() {
        }

        public e() {
        }
    }

    public interface f {
    }

    public interface g {
        void onRefresh();
    }

    public interface h {
        void onOverScroll(float r1, float r2);

        void onRefreshFinish();

        void onRefreshStartManually();

        void onReleaseAndRefresh();

        void onReleaseAndScrollBack();
    }

    public void setAnimationProgress(float r1) {
    }

    public void setColorScheme(int... r1) {
    }

    public void setOnChildScrollUpCallback(f r1) {
    }

    static {
        n0.a(j64.a.a(AoHostService.class).getHostApplication(), 16.0f);
        n0.a(j64.a.a(AoHostService.class).getHostApplication(), 20.0f);
        L = new int[]{R.attr.enabled};
    }

    public final void a() {
        if (this.a != null) goto L11;
        int r0 = 0;
    L6:
        if (r0 >= getChildCount()) goto L15;
        View r1 = getChildAt(r0);
        if (r1.equals(this.u) == false) goto L9;
        r0 = r0 + 1;
        goto L6
    L9:
        this.a = r1;
        return;
    L15:
        return;
    }

    @Override // android.view.View
    public final void computeScroll() {
        if (this.g.computeScrollOffset() == false) goto L6;
        scrollTo(this.g.getCurrX(), this.g.getCurrY());
        invalidate();
        return;
    }

    public final void d() {
        this.K.b(true);
        this.x.stop();
        setColorViewAlpha(255);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.i.getNestedScrollAxes();
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return this.j.hasNestedScrollingParent();
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return this.j.isNestedScrollingEnabled();
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        this.j.stopNestedScroll();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d();
    }

    public int getProgressCircleDiameter() {
        return this.C;
    }

    public int getProgressViewEndOffset() {
        return this.w;
    }

    public int getProgressViewStartOffset() {
        return this.v;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.i
    public final boolean isRefreshing() {
        return this.c;
    }

    public DoubleBallSwipeRefreshLayout(Context r2) {
        this(r2, null);
    }

    private void setColorViewAlpha(int r2) {
        this.x.b.u = r2;
    }

    public final void b(float r7) {
        if (r7 <= this.e) goto L5;
        e(true, true);
        return;
    L5:
        this.c = false;
        MaterialProgressDrawable r0 = this.x;
        MaterialProgressDrawable.c r1 = r0.b;
        r1.e = 0.0f;
        r1.a();
        MaterialProgressDrawable.c r2 = r0.b;
        r2.f = 0.0f;
        r2.a();
        b r3 = new b(this);
        e r4 = this.K;
        r4.getClass();
        s r5 = new s(r4, r3);
        e r6 = this.K;
        r6.getClass();
        Objects.toString(r5);
        r6.b(false);
        this.J.reset();
        this.J.setDuration(200);
        this.J.setInterpolator(this.t);
        r5.onAnimationEnd(this.I);
        MaterialProgressDrawable.c r8 = this.x.b;
        if (r8.o == false) goto L8;
        r8.o = false;
        r8.a();
    L8:
        h r9 = this.F;
        if (r9 != null) goto L11;
        this.g.startScroll(0, getScrollY(), 0, -getScrollY(), Math.abs(getScrollY() * 2));
        invalidate();
        this.u.d();
        return;
    L11:
        r9.onReleaseAndScrollBack();
    }

    public final void c(float r14) {
        MaterialProgressDrawable.c r0 = this.x.b;
        boolean r2 = true;
        if (r0.o == true) goto L5;
        r0.o = true;
        r0.a();
    L5:
        float r1 = r14 / this.e;
        float r3 = (((float) Math.max(((double) Math.min(1.0f, Math.abs(r1))) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float r4 = Math.abs(r14) - this.e;
        float r5 = this.w;
        double r7 = Math.max(0.0f, Math.min(r4, r5 * 2.0f) / r5) / 4.0f;
        float r6 = ((float) (r7 - Math.pow(r7, 2.0d))) * 2.0f;
        if (r14 >= this.e) goto L20;
        if (this.x.b.u <= 76) goto L31;
        com.bytedance.awemeopen.apps.framework.base.view.refresh.e r8 = this.z;
        if (r8 != null) goto L12;
    L16:
        r2 = false;
    L17:
        if (r2 == true) goto L31;
        com.bytedance.awemeopen.apps.framework.base.view.refresh.e r9 = new com.bytedance.awemeopen.apps.framework.base.view.refresh.e(this, this.x.b.u, 76);
        r9.setDuration(300);
        this.z = r9;
        goto L31
    L12:
        if (r8.hasStarted() == false) goto L16;
        if (r8.hasEnded() == true) goto L16;
    L31:
        h r10 = this.F;
        if (r10 != null) goto L34;
        float r15 = (float) Math.atan(r1);
        scrollTo(0, (int) ((-this.e) * r15));
        this.u.setProgress(Math.max(0.0f, Math.min(1.0f, r15 - 0.5f)));
    L35:
        MaterialProgressDrawable r11 = this.x;
        float r16 = Math.min(0.8f, r3 * 0.8f);
        MaterialProgressDrawable.c r12 = r11.b;
        r12.e = 0.0f;
        r12.a();
        MaterialProgressDrawable.c r13 = r11.b;
        r13.f = r16;
        r13.a();
        MaterialProgressDrawable r17 = this.x;
        float r18 = Math.min(1.0f, r3);
        MaterialProgressDrawable.c r19 = r17.b;
        if (r18 == r19.q) goto L38;
        r19.q = r18;
        r19.a();
    L38:
        MaterialProgressDrawable.c r110 = this.x.b;
        r110.g = (((r3 * 0.4f) - 0.25f) + (r6 * 2.0f)) * 0.5f;
        r110.a();
        e r111 = this.K;
        r111.getClass();
        r111.b(false);
        return;
    L34:
        r10.onOverScroll(Math.min(r14, this.e), Math.min(r1, 1.0f));
        goto L35
    L20:
        if (this.x.b.u >= 255) goto L31;
        com.bytedance.awemeopen.apps.framework.base.view.refresh.e r20 = this.A;
        if (r20 != null) goto L24;
    L28:
        r2 = false;
    L29:
        if (r2 == true) goto L31;
        com.bytedance.awemeopen.apps.framework.base.view.refresh.e r21 = new com.bytedance.awemeopen.apps.framework.base.view.refresh.e(this, this.x.b.u, 255);
        r21.setDuration(300);
        this.A = r21;
        goto L31
    L24:
        if (r20.hasStarted() == false) goto L28;
        if (r20.hasEnded() == true) goto L28;
        goto L28
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r6) {
        a();
        int r0 = MotionEventCompat.getActionMasked(r6);
        int r2 = 0;
        if (isEnabled() == true) goto L5;
    L40:
        return false;
    L5:
        if (ViewCompat.canScrollVertically(this.a, -1) == true) goto L40;
        if (this.c == true) goto L40;
        if (this.m == true) goto L40;
        if (r0 != 0) goto L13;
        int r1 = r6.getPointerId(0);
        this.s = r1;
        this.r = false;
        int r3 = r6.findPointerIndex(r1);
        if (r3 >= 0) goto L37;
        return false;
    L37:
        this.p = r6.getY(r3);
        this.q = r6.getX(r3);
    L39:
        return this.r;
    L13:
        if (r0 != 1) goto L15;
    L33:
        this.r = false;
        this.s = -1;
        goto L39
    L15:
        if (r0 != 2) goto L17;
        int r4 = this.s;
        if (r4 != (-1)) goto L29;
        return false;
    L29:
        int r5 = r6.findPointerIndex(r4);
        if (r5 >= 0) goto L32;
        return false;
    L32:
        f(r6.getX(r5), r6.getY(r5));
        goto L39
    L17:
        if (r0 == 3) goto L33;
        if (r0 != 6) goto L39;
        int r7 = MotionEventCompat.getActionIndex(r6);
        if (r6.getPointerId(r7) != this.s) goto L39;
        if (r7 != 0) goto L25;
        r2 = 1;
    L25:
        this.s = r6.getPointerId(r2);
        goto L39
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View r3) {
        this.i.onStopNestedScroll(r3);
        this.m = false;
        float r4 = this.h;
        if (r4 <= 0.0f) goto L5;
        b(r4);
        this.h = 0.0f;
    L5:
        stopNestedScroll();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r7) {
        int r0 = MotionEventCompat.getActionMasked(r7);
        int r2 = 0;
        if (isEnabled() == true) goto L5;
    L53:
        return false;
    L5:
        if (ViewCompat.canScrollVertically(this.a, -1) == true) goto L53;
        if (this.c == true) goto L53;
        if (this.m == true) goto L53;
        if (r0 != 0) goto L14;
        this.s = r7.getPointerId(0);
        this.r = false;
    L52:
        return true;
    L14:
        if (r0 != 1) goto L16;
    L43:
        int r1 = r7.findPointerIndex(this.s);
        if (r1 >= 0) goto L47;
        return false;
    L47:
        if (this.r == false) goto L49;
        float r8 = (r7.getY(r1) - this.o) * 0.5f;
        this.r = false;
        b(r8);
    L49:
        this.s = -1;
        return false;
    L16:
        if (r0 != 2) goto L18;
        int r3 = r7.findPointerIndex(this.s);
        if (r3 >= 0) goto L36;
        return false;
    L36:
        float r4 = r7.getX(r3);
        float r9 = r7.getY(r3);
        f(r4, r9);
        if (this.r == false) goto L52;
        float r10 = (r9 - this.o) * 0.5f;
        if (r10 <= 0.0f) goto L41;
        c(r10);
        goto L52
    L41:
        c(0.0f);
        return false;
    L18:
        if (r0 == 3) goto L43;
        if (r0 != 5) goto L22;
        int r5 = MotionEventCompat.getActionIndex(r7);
        if (r5 >= 0) goto L32;
        return false;
    L32:
        this.s = r7.getPointerId(r5);
        goto L52
    L22:
        if (r0 != 6) goto L52;
        int r6 = MotionEventCompat.getActionIndex(r7);
        if (r7.getPointerId(r6) != this.s) goto L52;
        if (r6 != 0) goto L28;
        r2 = 1;
    L28:
        this.s = r7.getPointerId(r2);
        goto L52
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean r1) {
        super.requestDisallowInterceptTouchEvent(r1);
    }

    public void setColorSchemeColors(int... r2) {
        a();
        MaterialProgressDrawable.c r0 = this.x.b;
        r0.j = r2;
        r0.k = 0;
        r0.k = 0;
    }

    public void setColorSchemeResources(int... r5) {
        Context r0 = getContext();
        int[] r1 = new int[r5.length];
        int r2 = 0;
    L4:
        if (r2 >= r5.length) goto L6;
        r1[r2] = ContextCompat.getColor(r0, r5[r2]);
        r2 = r2 + 1;
        goto L4
    L6:
        setColorSchemeColors(r1);
    }

    public void setDistanceToTriggerSync(int r1) {
        this.e = r1;
    }

    public void setDoNotCatchException(boolean r1) {
        this.f = r1;
    }

    public void setEnableDeltaX(boolean r1) {
        this.G = r1;
    }

    @Override // android.view.View
    public void setEnabled(boolean r1) {
        super.setEnabled(r1);
        if (r1 == true) goto L6;
        d();
        return;
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean r2) {
        this.j.setNestedScrollingEnabled(r2);
    }

    public void setOnRefreshListener(g r1) {
        this.b = r1;
    }

    public void setOnSwipeChangeListener(h r1) {
        this.F = r1;
    }

    public void setProgressBackgroundColor(int r1) {
        setProgressBackgroundColorSchemeResource(r1);
    }

    public void setProgressBackgroundColorSchemeColor(int r2) {
        this.x.b.w = r2;
    }

    public void setProgressBackgroundColorSchemeResource(int r2) {
        setProgressBackgroundColorSchemeColor(ContextCompat.getColor(getContext(), r2));
    }

    public void setRefreshing(boolean r5) {
        if (r5 == true) goto L5;
    L13:
        e(r5, false);
        return;
    L5:
        if (this.c == r5) goto L13;
        this.c = r5;
        this.B = false;
        h r6 = this.F;
        if (r6 == null) goto L9;
        r6.onRefreshStartManually();
        return;
    L9:
        a r7 = this.H;
        this.x.b.u = 255;
        com.bytedance.awemeopen.apps.framework.base.view.refresh.c r1 = new com.bytedance.awemeopen.apps.framework.base.view.refresh.c(this);
        this.y = r1;
        r1.setDuration(this.n);
        if (r7 == null) goto L12;
        r7.onAnimationEnd(this.y);
    L12:
        this.u.c();
        this.g.startScroll(0, getScrollY(), 0, (int) (-this.e));
    }

    public void setSize(int r3) {
        if (r3 != 0) goto L4;
    L6:
        Resources r0 = getResources();
        DisplayMetrics r1 = WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics());
        if (r3 != 0) goto L9;
        this.C = (int) (r1.density * 56.0f);
    L10:
        this.x.b(r3);
        return;
    L9:
        this.C = (int) (r1.density * 40.0f);
        goto L10
    L4:
        if (r3 == 1) goto L6;
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int r2) {
        return this.j.startNestedScroll(r2);
    }

    public DoubleBallSwipeRefreshLayout(Context r7, AttributeSet r8) {
        super(r7, r8);
        this.c = false;
        this.e = -1.0f;
        this.f = true;
        this.k = new int[2];
        this.l = new int[2];
        this.s = -1;
        this.G = false;
        this.H = new a(this);
        this.I = new c(this);
        this.J = new d(this);
        this.K = new e();
        this.d = ViewConfiguration.get(r7).getScaledTouchSlop();
        this.g = new Scroller(r7, new AccelerateDecelerateInterpolator());
        this.n = getResources().getInteger(R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.t = new DecelerateInterpolator(2.0f);
        Resources r2 = getResources();
        DisplayMetrics r3 = WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics());
        float r4 = r3.density;
        this.C = (int) (40.0f * r4);
        this.D = (int) (r4 * 56.0f);
        this.E = (int) (r4 * 32.0f);
        MaterialProgressDrawable r5 = new MaterialProgressDrawable(getContext(), this);
        this.x = r5;
        r5.b.w = -328966;
        ViewCompat.setChildrenDrawingOrderEnabled(this, true);
        int r6 = (int) (r3.density * 56.0f);
        this.w = r6;
        this.e = r6;
        this.i = new NestedScrollingParentHelper(this);
        this.j = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        this.v = -this.C;
        TypedArray r9 = r7.obtainStyledAttributes(r8, L);
        setEnabled(r9.getBoolean(0, true));
        r9.recycle();
        DoubleColorBallAnimationView r10 = new DoubleColorBallAnimationView(getContext());
        this.u = r10;
        addView(r10);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float r2, float r3) {
        return this.j.dispatchNestedPreFling(r2, r3);
    }

    public final void e(boolean r7, boolean r8) {
        this.K.getClass();
        if (this.c == r7) goto L17;
        this.B = r8;
        a();
        this.c = r7;
        if (r7 == false) goto L12;
        a r9 = this.H;
        e r0 = this.K;
        r0.getClass();
        Objects.toString(r9);
        r0.b(false);
        this.I.reset();
        this.I.setDuration(200);
        this.I.setInterpolator(this.t);
        h r1 = this.F;
        if (r1 != null) goto L9;
        this.u.setCycleBias(1);
        this.u.c();
        this.g.startScroll(0, getScrollY(), 0, (-getScrollY()) - this.D, Math.abs(((-getScrollY()) - this.D) * 2));
        invalidate();
    L10:
        if (r9 == null) goto L18;
        r9.onAnimationEnd(this.I);
        return;
    L18:
        return;
    L9:
        r1.onReleaseAndRefresh();
        goto L10
    L12:
        h r10 = this.F;
        if (r10 != null) goto L15;
        this.g.forceFinished(true);
        this.g.startScroll(0, getScrollY(), 0, -getScrollY(), Math.abs(getScrollY() * 2));
        invalidate();
        this.u.d();
        return;
    L15:
        r10.onRefreshFinish();
        return;
    }

    public final void f(float r4, float r5) {
        float r6 = r5 - this.p;
        float r7 = Math.abs(r4 - this.q);
        if (this.G == true) goto L5;
    L8:
        boolean r8 = true;
    L9:
        int r0 = this.d;
        if (r6 > r0) goto L12;
        return;
    L12:
        if (this.r == true) goto L17;
        if (r8 == false) goto L18;
        this.o = this.p + r0;
        this.r = true;
        this.x.b.u = 76;
        return;
    L18:
        return;
    L17:
        return;
    L5:
        if ((r7 / r6) < 1.0f) goto L8;
        r8 = false;
        goto L9
    }

    @Override // android.view.View
    public final void onMeasure(int r4, int r5) {
        super.onMeasure(r4, r5);
        if (this.a != null) goto L5;
        a();
    L5:
        View r6 = this.a;
        if (r6 != null) goto L17;
        return;
    L17:
        r6.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));     // Catch: IllegalStateException -> L11
    L14:
        this.u.measure(View.MeasureSpec.makeMeasureSpec(this.E, 1073741824), View.MeasureSpec.makeMeasureSpec(this.E, 1073741824));
        return;
    L11:
        e = move-exception;
        if (this.f == false) goto L14;
        throw e;
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float r2, float r3, boolean r4) {
        return this.j.dispatchNestedFling(r2, r3, r4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View r1, float r2, float r3) {
        return dispatchNestedPreFling(r2, r3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View r2, View r3, int r4) {
        this.i.onNestedScrollAccepted(r2, r3, r4);
        startNestedScroll(r4 & 2);
        this.h = 0.0f;
        this.m = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View r1, View r2, int r3) {
        if (isEnabled() == true) goto L5;
    L9:
        return false;
    L5:
        if (this.c == true) goto L9;
        if ((r3 & 2) == 0) goto L9;
        return true;
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int r2, int r3, int[] r4, int[] r5) {
        return this.j.dispatchNestedPreScroll(r2, r3, r4, r5);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View r1, float r2, float r3, boolean r4) {
        return dispatchNestedFling(r2, r3, r4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View r5, int r6, int r7, int[] r8) {
        if (r7 <= 0) goto L11;
        float r0 = this.h;
        if (r0 <= 0.0f) goto L11;
        float r2 = r7;
        if (r2 <= r0) goto L9;
        r8[1] = r7 - ((int) r0);
        this.h = 0.0f;
    L10:
        c(this.h);
        goto L11
    L9:
        this.h = r0 - r2;
        r8[1] = r7;
    L11:
        int[] r1 = this.k;
        if (dispatchNestedPreScroll(r6 - r8[0], r7 - r8[1], r1, null) == false) goto L15;
        r8[0] = r8[0] + r1[0];
        r8[1] = r8[1] + r1[1];
        return;
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int r7, int r8, int r9, int r10, int[] r11) {
        return this.j.dispatchNestedScroll(r7, r8, r9, r10, r11);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r3, int r4, int r5, int r6, int r7) {
        int r8 = getMeasuredWidth();
        int r9 = getMeasuredHeight();
        if (getChildCount() != 0) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
        a();
    L8:
        View r10 = this.a;
        if (r10 != null) goto L11;
        return;
    L11:
        int r11 = getPaddingLeft();
        int r12 = getPaddingTop();
        int r0 = (r8 - getPaddingLeft()) - getPaddingRight();
        r10.layout(r11, r12, r0 + r11, ((r9 - getPaddingTop()) - getPaddingBottom()) + r12);     // Catch: Exception -> L14
    L17:
        int r13 = this.u.getMeasuredWidth();
        int r14 = this.u.getMeasuredHeight();
        int r15 = (r8 - r13) / 2;
        int r16 = (this.D + r14) / 2;
        this.u.layout(r15, -r16, r13 + r15, 0);
        return;
    L14:
        e = move-exception;
        if (this.f == false) goto L17;
        throw e;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View r7, int r8, int r9, int r10, int r11) {
        dispatchNestedScroll(r8, r9, r10, r11, this.l);
        int r12 = r11 + this.l[1];
        if (r12 < 0) goto L5;
        return;
    L5:
        if (ViewCompat.canScrollVertically(this.a, -1) == true) goto L9;
        float r13 = this.h + Math.abs(r12);
        this.h = r13;
        c(r13);
        return;
    }
}
