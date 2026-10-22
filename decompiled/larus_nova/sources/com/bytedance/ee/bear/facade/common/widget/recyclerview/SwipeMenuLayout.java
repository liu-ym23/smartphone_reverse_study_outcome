package com.bytedance.ee.bear.facade.common.widget.recyclerview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public class SwipeMenuLayout extends ViewGroup {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static boolean f226686s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static SwipeMenuLayout f226687t;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f226688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f226689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f226690c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f226691d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f226692e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f226693f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final PointF f226694g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f226695h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f226696i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f226697j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f226698k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public VelocityTracker f226699l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ValueAnimator f226700m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ValueAnimator f226701n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public DocsLinearLayoutManager f226702o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final List<c> f226703p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public d f226704q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f226705r;

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SwipeMenuLayout f226706a;

        public a(SwipeMenuLayout r100) {
            this.f226706a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            SwipeMenuLayout r101 = this.f226706a;
            r101.f226698k = true;
            r101.d(true);
        }
    }

    public class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SwipeMenuLayout f226707a;

        public b(SwipeMenuLayout r100) {
            this.f226707a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            SwipeMenuLayout r101 = this.f226707a;
            r101.f226698k = false;
            r101.d(false);
        }
    }

    public interface c {
        void a(boolean r100);
    }

    public interface d {
        void a(SwipeMenuLayout r100, boolean r101);
    }

    public final void b() {
        f226687t = null;
        DocsLinearLayoutManager r100 = this.f226702o;
        if (r100 == null) goto L5;
        r100.f226663a = true;
    L5:
        View r101 = this.f226693f;
        if (r101 == null) goto L8;
        r101.setLongClickable(true);
    L8:
        a();
        ValueAnimator r102 = ValueAnimator.ofInt(new int[]{getScrollX(), 0});
        this.f226701n = r102;
        r102.addUpdateListener(new wa5.b(this));
        this.f226701n.setInterpolator(new AccelerateInterpolator());
        this.f226701n.addListener(new b(this));
        this.f226701n.setDuration(120).start();
        d r103 = this.f226704q;
        if (r103 == null) goto L12;
        r103.a(this, false);
        return;
    }

    public final void a() {
        ValueAnimator r100 = this.f226701n;
        if (r100 != null) goto L5;
    L7:
        ValueAnimator r101 = this.f226700m;
        if (r101 != null) goto L10;
        return;
    L10:
        if (r101.isRunning() == false) goto L14;
        this.f226700m.cancel();
        return;
    L14:
        return;
    L5:
        if (r100.isRunning() == false) goto L7;
        this.f226701n.cancel();
        goto L7
    }

    public final void e() {
        f226687t = this;
        DocsLinearLayoutManager r100 = this.f226702o;
        if (r100 == null) goto L5;
        r100.f226663a = false;
    L5:
        View r101 = this.f226693f;
        if (r101 == null) goto L8;
        r101.setLongClickable(false);
    L8:
        a();
        ValueAnimator r102 = ValueAnimator.ofInt(new int[]{getScrollX(), this.f226691d});
        this.f226700m = r102;
        r102.addUpdateListener(new wa5.c(this));
        this.f226700m.setInterpolator(new OvershootInterpolator());
        this.f226700m.addListener(new a(this));
        this.f226700m.setDuration(300).start();
        d r103 = this.f226704q;
        if (r103 == null) goto L12;
        r103.a(this, true);
        return;
    }

    public final void f() {
        DocsLinearLayoutManager r100 = this.f226702o;
        if (r100 == null) goto L6;
        r100.f226663a = true;
    L6:
        if (this != f226687t) goto L9;
        a();
        f226687t.scrollTo(0, 0);
        f226687t = null;
        this.f226698k = false;
        d(false);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        SwipeMenuLayout r100 = f226687t;
        if (this != r100) goto L5;
        r100.f();
        f226687t = null;
    L5:
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final boolean performLongClick() {
        if (getScrollX() <= this.f226688a) goto L7;
        return false;
    L7:
        return super.performLongClick();
    }

    public static SwipeMenuLayout getViewCache() {
        return f226687t;
    }

    public boolean getSwipeEnable() {
        return this.f226697j;
    }

    public SwipeMenuLayout(Context r100) {
        this(r100, null);
    }

    public boolean c(MotionEvent r100) {
        if (r100.getX() >= (getWidth() - getScrollX())) goto L5;
        return true;
    L5:
        return false;
    }

    public final void d(boolean r100) {
        Iterator r101 = ((ArrayList) this.f226703p).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((c) r101.next()).a(r100);
        goto L4
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r100) {
        if (this.f226697j == false) goto L66;
        if (this.f226699l != null) goto L7;
        this.f226699l = VelocityTracker.obtain();
    L7:
        this.f226699l.addMovement(r100);
        int r101 = r100.getAction();
        if (r101 == 0) goto L57;
        if (r101 == 1) goto L32;
        if (r101 == 2) goto L16;
        if (r101 == 3) goto L32;
    L16:
        if (this.f226696i == true) goto L66;
        float r102 = r100.getRawX() - this.f226694g.x;
        if (Math.abs(r102) <= this.f226688a) goto L21;
    L22:
        this.f226695h = true;
        int r103 = (int) (getScrollX() - r102);
        if (r103 >= 0) goto L25;
        r103 = 0;
    L28:
        scrollTo(r103, 0);
        this.f226694g.set(r100.getRawX(), r100.getRawY());
        DocsLinearLayoutManager r104 = this.f226702o;
        if (r104 == null) goto L66;
        r104.f226663a = false;
        goto L66
    L25:
        int r105 = this.f226691d;
        if (r103 <= r105) goto L28;
        r103 = r105;
        goto L28
    L21:
        if (this.f226695h == false) goto L66;
    L32:
        if (this.f226696i == false) goto L34;
    L51:
        VelocityTracker r106 = this.f226699l;
        if (r106 == null) goto L54;
        r106.clear();
        this.f226699l.recycle();
        this.f226699l = null;
    L54:
        f226686s = false;
        DocsLinearLayoutManager r107 = this.f226702o;
        if (r107 == null) goto L66;
        r107.f226663a = true;
        goto L66
    L34:
        if (this.f226695h == false) goto L51;
        this.f226699l.computeCurrentVelocity(500);
        float r108 = this.f226699l.getXVelocity(this.f226689b);
        if (r108 < 2000.0f) goto L39;
        b();
        goto L51
    L39:
        if (r108 <= 0.0f) goto L45;
        if (getScrollX() >= (this.f226691d - this.f226692e)) goto L43;
        b();
        goto L51
    L43:
        e();
        goto L51
    L45:
        if (r108 > (-2000.0f)) goto L47;
        e();
        goto L51
    L47:
        if (getScrollX() <= this.f226692e) goto L49;
        e();
        goto L51
    L49:
        b();
        goto L51
    L57:
        this.f226695h = false;
        this.f226696i = false;
        if (f226686s == false) goto L60;
        return false;
    L60:
        f226686s = true;
        this.f226694g.set(r100.getRawX(), r100.getRawY());
        SwipeMenuLayout r109 = f226687t;
        if (r109 == null) goto L64;
        if (r109 == this) goto L64;
        r109.b();
        this.f226696i = true;
    L64:
        this.f226689b = r100.getPointerId(0);
    L66:
        return super.dispatchTouchEvent(r100);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new ViewGroup.MarginLayoutParams(getContext(), r100);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f226697j == false) goto L27;
        int r101 = r100.getAction();
        if (r101 == 1) goto L13;
        if (r101 != 2) goto L24;
        if (this.f226695h == false) goto L24;
        return true;
    L24:
        if (this.f226696i == false) goto L27;
        return true;
    L13:
        if (getScrollX() <= this.f226688a) goto L21;
        if (c(r100) == false) goto L21;
        if (this.f226695h == true) goto L19;
        b();
    L19:
        return true;
    L21:
        if (this.f226695h == false) goto L24;
        return true;
    L27:
        return super.onInterceptTouchEvent(r100);
    }

    public void setDefaultMenuWidths(int r100) {
        this.f226705r = r100;
    }

    public void setLayoutManager(DocsLinearLayoutManager r100) {
        this.f226702o = r100;
    }

    public void setOnUserSwipeMenuListener(d r100) {
        this.f226704q = r100;
    }

    public void setSwipeEnable(boolean r100) {
        this.f226697j = r100;
    }

    public SwipeMenuLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public void onMeasure(int r110, int r111) {
        super.onMeasure(r110, r111);
        setClickable(true);
        this.f226691d = 0;
        this.f226690c = 0;
        int r100 = getChildCount();
        if (View.MeasureSpec.getMode(r111) == 1073741824) goto L5;
        boolean r101 = true;
    L6:
        int r102 = 0;
        int r103 = 0;
        boolean r104 = false;
    L8:
        if (r102 >= r100) goto L21;
        View r112 = getChildAt(r102);
        r112.setClickable(true);
        if (r112.getVisibility() == 8) goto L20;
        measureChild(r112, r110, r111);
        ViewGroup.MarginLayoutParams r113 = (ViewGroup.MarginLayoutParams) r112.getLayoutParams();
        this.f226690c = Math.max(this.f226690c, r112.getMeasuredHeight());
        if (r101 == true) goto L14;
    L16:
        if (r102 <= 0) goto L18;
        this.f226691d += r112.getMeasuredWidth();
        goto L20
    L18:
        this.f226693f = r112;
        r103 = r112.getMeasuredWidth();
        goto L20
    L14:
        if (r113.height != (-1)) goto L16;
        r104 = true;
    L20:
        r102 = r102 + 1;
        goto L8
    L21:
        setMeasuredDimension((getPaddingLeft() + getPaddingRight()) + r103, (this.f226690c + getPaddingTop()) + getPaddingBottom());
        this.f226692e = this.f226691d / 5;
        if (r104 == false) goto L31;
        int r105 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        int r114 = 0;
    L24:
        if (r114 >= r100) goto L40;
        View r106 = getChildAt(r114);
        if (r106.getVisibility() == 8) goto L30;
        ViewGroup.MarginLayoutParams r115 = (ViewGroup.MarginLayoutParams) r106.getLayoutParams();
        if (r115.height != (-1)) goto L30;
        int r116 = r115.width;
        r115.width = r106.getMeasuredWidth();
        measureChildWithMargins(r106, r110, 0, r105, 0);
        r115.width = r116;
    L30:
        r114 = r114 + 1;
        goto L24
    L40:
        return;
    L31:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public SwipeMenuLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f226694g = new PointF();
        this.f226697j = true;
        this.f226703p = new ArrayList();
        this.f226688a = ViewConfiguration.get(r100).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        int r105 = getChildCount();
        int r106 = getPaddingLeft();
        int r107 = 0;
    L3:
        if (r107 >= r105) goto L11;
        View r108 = getChildAt(r107);
        if (r108.getVisibility() == 8) goto L10;
        if (r107 != 0) goto L8;
        r108.layout(r106, getPaddingTop(), r108.getMeasuredWidth() + r106, getPaddingTop() + r108.getMeasuredHeight());
        int r109 = r108.getMeasuredWidth();
    L9:
        r106 = r106 + r109;
        goto L10
    L8:
        r108.layout(r106, getPaddingTop(), r108.getMeasuredWidth() + r106, getPaddingTop() + r108.getMeasuredHeight());
        r109 = r108.getMeasuredWidth();
    L10:
        r107 = r107 + 1;
        goto L3
    }
}
