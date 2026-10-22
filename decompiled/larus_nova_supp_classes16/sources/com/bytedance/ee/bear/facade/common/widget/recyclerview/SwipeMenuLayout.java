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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SwipeMenuLayout extends ViewGroup {
    public static boolean s;
    public static SwipeMenuLayout t;
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public View f;
    public final PointF g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public VelocityTracker l;
    public ValueAnimator m;
    public ValueAnimator n;
    public DocsLinearLayoutManager o;
    public final List<c> p;
    public d q;
    public int r;

    public class a extends AnimatorListenerAdapter {
        public final /* synthetic */ SwipeMenuLayout a;

        public a(SwipeMenuLayout r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            SwipeMenuLayout r3 = this.a;
            r3.k = true;
            r3.d(true);
        }
    }

    public class b extends AnimatorListenerAdapter {
        public final /* synthetic */ SwipeMenuLayout a;

        public b(SwipeMenuLayout r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            SwipeMenuLayout r3 = this.a;
            r3.k = false;
            r3.d(false);
        }
    }

    public interface c {
        void a(boolean r1);
    }

    public interface d {
        void a(SwipeMenuLayout r1, boolean r2);
    }

    public final void b() {
        t = null;
        DocsLinearLayoutManager r0 = this.o;
        if (r0 == null) goto L5;
        r0.a = true;
    L5:
        View r1 = this.f;
        if (r1 == null) goto L8;
        r1.setLongClickable(true);
    L8:
        a();
        ValueAnimator r2 = ValueAnimator.ofInt(new int[]{getScrollX(), 0});
        this.n = r2;
        r2.addUpdateListener(new wa5.b(this));
        this.n.setInterpolator(new AccelerateInterpolator());
        this.n.addListener(new b(this));
        this.n.setDuration(120).start();
        d r3 = this.q;
        if (r3 == null) goto L12;
        r3.a(this, false);
        return;
    }

    public final void a() {
        ValueAnimator r0 = this.n;
        if (r0 != null) goto L5;
    L7:
        ValueAnimator r1 = this.m;
        if (r1 != null) goto L10;
        return;
    L10:
        if (r1.isRunning() == false) goto L14;
        this.m.cancel();
        return;
    L14:
        return;
    L5:
        if (r0.isRunning() == false) goto L7;
        this.n.cancel();
        goto L7
    }

    public final void e() {
        t = this;
        DocsLinearLayoutManager r0 = this.o;
        if (r0 == null) goto L5;
        r0.a = false;
    L5:
        View r1 = this.f;
        if (r1 == null) goto L8;
        r1.setLongClickable(false);
    L8:
        a();
        ValueAnimator r2 = ValueAnimator.ofInt(new int[]{getScrollX(), this.d});
        this.m = r2;
        r2.addUpdateListener(new wa5.c(this));
        this.m.setInterpolator(new OvershootInterpolator());
        this.m.addListener(new a(this));
        this.m.setDuration(300).start();
        d r3 = this.q;
        if (r3 == null) goto L12;
        r3.a(this, true);
        return;
    }

    public final void f() {
        DocsLinearLayoutManager r0 = this.o;
        if (r0 == null) goto L6;
        r0.a = true;
    L6:
        if (this != t) goto L9;
        a();
        t.scrollTo(0, 0);
        t = null;
        this.k = false;
        d(false);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        SwipeMenuLayout r0 = t;
        if (this != r0) goto L5;
        r0.f();
        t = null;
    L5:
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final boolean performLongClick() {
        if (getScrollX() <= this.a) goto L7;
        return false;
    L7:
        return super.performLongClick();
    }

    public static SwipeMenuLayout getViewCache() {
        return t;
    }

    public boolean getSwipeEnable() {
        return this.j;
    }

    public SwipeMenuLayout(Context r2) {
        this(r2, null);
    }

    public boolean c(MotionEvent r3) {
        if (r3.getX() >= (getWidth() - getScrollX())) goto L5;
        return true;
    L5:
        return false;
    }

    public final void d(boolean r3) {
        Iterator r0 = ((ArrayList) this.p).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).a(r3);
        goto L4
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r6) {
        if (this.j == false) goto L66;
        if (this.l != null) goto L7;
        this.l = VelocityTracker.obtain();
    L7:
        this.l.addMovement(r6);
        int r0 = r6.getAction();
        if (r0 == 0) goto L57;
        if (r0 == 1) goto L32;
        if (r0 == 2) goto L16;
        if (r0 == 3) goto L32;
    L16:
        if (this.i == true) goto L66;
        float r1 = r6.getRawX() - this.g.x;
        if (Math.abs(r1) <= this.a) goto L21;
    L22:
        this.h = true;
        int r2 = (int) (getScrollX() - r1);
        if (r2 >= 0) goto L25;
        r2 = 0;
    L28:
        scrollTo(r2, 0);
        this.g.set(r6.getRawX(), r6.getRawY());
        DocsLinearLayoutManager r3 = this.o;
        if (r3 == null) goto L66;
        r3.a = false;
        goto L66
    L25:
        int r4 = this.d;
        if (r2 <= r4) goto L28;
        r2 = r4;
        goto L28
    L21:
        if (this.h == false) goto L66;
    L32:
        if (this.i == false) goto L34;
    L51:
        VelocityTracker r5 = this.l;
        if (r5 == null) goto L54;
        r5.clear();
        this.l.recycle();
        this.l = null;
    L54:
        s = false;
        DocsLinearLayoutManager r7 = this.o;
        if (r7 == null) goto L66;
        r7.a = true;
        goto L66
    L34:
        if (this.h == false) goto L51;
        this.l.computeCurrentVelocity(500);
        float r8 = this.l.getXVelocity(this.b);
        if (r8 < 2000.0f) goto L39;
        b();
        goto L51
    L39:
        if (r8 <= 0.0f) goto L45;
        if (getScrollX() >= (this.d - this.e)) goto L43;
        b();
        goto L51
    L43:
        e();
        goto L51
    L45:
        if (r8 > (-2000.0f)) goto L47;
        e();
        goto L51
    L47:
        if (getScrollX() <= this.e) goto L49;
        e();
        goto L51
    L49:
        b();
        goto L51
    L57:
        this.h = false;
        this.i = false;
        if (s == false) goto L60;
        return false;
    L60:
        s = true;
        this.g.set(r6.getRawX(), r6.getRawY());
        SwipeMenuLayout r9 = t;
        if (r9 == null) goto L64;
        if (r9 == this) goto L64;
        r9.b();
        this.i = true;
    L64:
        this.b = r6.getPointerId(0);
    L66:
        return super.dispatchTouchEvent(r6);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r3) {
        return new ViewGroup.MarginLayoutParams(getContext(), r3);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r4) {
        if (this.j == false) goto L27;
        int r0 = r4.getAction();
        if (r0 == 1) goto L13;
        if (r0 != 2) goto L24;
        if (this.h == false) goto L24;
        return true;
    L24:
        if (this.i == false) goto L27;
        return true;
    L13:
        if (getScrollX() <= this.a) goto L21;
        if (c(r4) == false) goto L21;
        if (this.h == true) goto L19;
        b();
    L19:
        return true;
    L21:
        if (this.h == false) goto L24;
        return true;
    L27:
        return super.onInterceptTouchEvent(r4);
    }

    public void setDefaultMenuWidths(int r1) {
        this.r = r1;
    }

    public void setLayoutManager(DocsLinearLayoutManager r1) {
        this.o = r1;
    }

    public void setOnUserSwipeMenuListener(d r1) {
        this.q = r1;
    }

    public void setSwipeEnable(boolean r1) {
        this.j = r1;
    }

    public SwipeMenuLayout(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    @Override // android.view.View
    public void onMeasure(int r17, int r18) {
        super.onMeasure(r17, r18);
        setClickable(true);
        this.d = 0;
        this.c = 0;
        int r7 = getChildCount();
        if (View.MeasureSpec.getMode(r18) == 1073741824) goto L5;
        boolean r2 = true;
    L6:
        int r4 = 0;
        int r5 = 0;
        boolean r8 = false;
    L8:
        if (r4 >= r7) goto L21;
        View r11 = getChildAt(r4);
        r11.setClickable(true);
        if (r11.getVisibility() == 8) goto L20;
        measureChild(r11, r17, r18);
        ViewGroup.MarginLayoutParams r10 = (ViewGroup.MarginLayoutParams) r11.getLayoutParams();
        this.c = Math.max(this.c, r11.getMeasuredHeight());
        if (r2 == true) goto L14;
    L16:
        if (r4 <= 0) goto L18;
        this.d += r11.getMeasuredWidth();
        goto L20
    L18:
        this.f = r11;
        r5 = r11.getMeasuredWidth();
        goto L20
    L14:
        if (r10.height != (-1)) goto L16;
        r8 = true;
    L20:
        r4 = r4 + 1;
        goto L8
    L21:
        setMeasuredDimension((getPaddingLeft() + getPaddingRight()) + r5, (this.c + getPaddingTop()) + getPaddingBottom());
        this.e = this.d / 5;
        if (r8 == false) goto L31;
        int r9 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        int r12 = 0;
    L24:
        if (r12 >= r7) goto L40;
        View r1 = getChildAt(r12);
        if (r1.getVisibility() == 8) goto L30;
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r1.getLayoutParams();
        if (r13.height != (-1)) goto L30;
        int r14 = r13.width;
        r13.width = r1.getMeasuredWidth();
        measureChildWithMargins(r1, r17, 0, r9, 0);
        r13.width = r14;
    L30:
        r12 = r12 + 1;
        goto L24
    L40:
        return;
    L31:
        return;
    L5:
        r2 = false;
        goto L6
    }

    public SwipeMenuLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.g = new PointF();
        this.j = true;
        this.p = new ArrayList();
        this.a = ViewConfiguration.get(r1).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r4, int r5, int r6, int r7, int r8) {
        int r9 = getChildCount();
        int r10 = getPaddingLeft();
        int r11 = 0;
    L3:
        if (r11 >= r9) goto L11;
        View r12 = getChildAt(r11);
        if (r12.getVisibility() == 8) goto L10;
        if (r11 != 0) goto L8;
        r12.layout(r10, getPaddingTop(), r12.getMeasuredWidth() + r10, getPaddingTop() + r12.getMeasuredHeight());
        int r13 = r12.getMeasuredWidth();
    L9:
        r10 = r10 + r13;
        goto L10
    L8:
        r12.layout(r10, getPaddingTop(), r12.getMeasuredWidth() + r10, getPaddingTop() + r12.getMeasuredHeight());
        r13 = r12.getMeasuredWidth();
    L10:
        r11 = r11 + 1;
        goto L3
    }
}
