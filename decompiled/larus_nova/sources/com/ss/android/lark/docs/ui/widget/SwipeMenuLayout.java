package com.ss.android.lark.docs.ui.widget;

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

/* JADX INFO: loaded from: classes35.dex */
public class SwipeMenuLayout extends ViewGroup {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static boolean f420502p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static SwipeMenuLayout f420503q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f420504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f420505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f420506c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f420507d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f420508e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f420509f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final PointF f420510g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f420511h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f420512i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f420513j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public VelocityTracker f420514k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ValueAnimator f420515l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ValueAnimator f420516m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public DocsLinearLayoutManager f420517n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List<c> f420518o;

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SwipeMenuLayout f420519a;

        public a(SwipeMenuLayout r100) {
            this.f420519a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            SwipeMenuLayout r101 = this.f420519a;
            boolean r102 = SwipeMenuLayout.f420502p;
            r101.getClass();
            this.f420519a.c(true);
        }
    }

    public class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SwipeMenuLayout f420520a;

        public b(SwipeMenuLayout r100) {
            this.f420520a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            SwipeMenuLayout r101 = this.f420520a;
            boolean r102 = SwipeMenuLayout.f420502p;
            r101.getClass();
            this.f420520a.c(false);
        }
    }

    public interface c {
        void a();
    }

    public interface d {
    }

    public final void b() {
        f420503q = null;
        DocsLinearLayoutManager r100 = this.f420517n;
        if (r100 == null) goto L5;
        r100.f420501a = true;
    L5:
        View r101 = this.f420509f;
        if (r101 == null) goto L8;
        r101.setLongClickable(true);
    L8:
        a();
        ValueAnimator r102 = ValueAnimator.ofInt(new int[]{getScrollX(), 0});
        this.f420516m = r102;
        r102.addUpdateListener(new tbb.a(this));
        this.f420516m.setInterpolator(new AccelerateInterpolator());
        this.f420516m.addListener(new b(this));
        this.f420516m.setDuration(120).start();
    }

    public void setDefaultMenuWidths(int r100) {
    }

    public void setOnUserSwipeMenuListener(d r100) {
    }

    public final void a() {
        ValueAnimator r100 = this.f420516m;
        if (r100 != null) goto L5;
    L7:
        ValueAnimator r101 = this.f420515l;
        if (r101 != null) goto L10;
        return;
    L10:
        if (r101.isRunning() == false) goto L14;
        this.f420515l.cancel();
        return;
    L14:
        return;
    L5:
        if (r100.isRunning() == false) goto L7;
        this.f420516m.cancel();
        goto L7
    }

    public final void d() {
        f420503q = this;
        DocsLinearLayoutManager r100 = this.f420517n;
        if (r100 == null) goto L5;
        r100.f420501a = false;
    L5:
        View r101 = this.f420509f;
        if (r101 == null) goto L8;
        r101.setLongClickable(false);
    L8:
        a();
        ValueAnimator r102 = ValueAnimator.ofInt(new int[]{getScrollX(), this.f420507d});
        this.f420515l = r102;
        r102.addUpdateListener(new tbb.b(this));
        this.f420515l.setInterpolator(new OvershootInterpolator());
        this.f420515l.addListener(new a(this));
        this.f420515l.setDuration(300).start();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        SwipeMenuLayout r100 = f420503q;
        if (this != r100) goto L8;
        DocsLinearLayoutManager r101 = r100.f420517n;
        if (r101 == null) goto L7;
        r101.f420501a = true;
    L7:
        r100.a();
        f420503q.scrollTo(0, 0);
        f420503q = null;
        r100.c(false);
        f420503q = null;
    L8:
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final boolean performLongClick() {
        if (getScrollX() <= this.f420504a) goto L7;
        return false;
    L7:
        return super.performLongClick();
    }

    public boolean getSwipeEnable() {
        return this.f420513j;
    }

    public SwipeMenuLayout(Context r100) {
        this(r100, null);
    }

    public final void c(boolean r100) {
        Iterator r101 = ((ArrayList) this.f420518o).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((c) r101.next()).a();
        goto L4
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        if (this.f420513j == false) goto L66;
        if (this.f420514k != null) goto L7;
        this.f420514k = VelocityTracker.obtain();
    L7:
        this.f420514k.addMovement(r100);
        int r101 = r100.getAction();
        if (r101 == 0) goto L57;
        if (r101 == 1) goto L32;
        if (r101 == 2) goto L16;
        if (r101 == 3) goto L32;
    L16:
        if (this.f420512i == true) goto L66;
        float r102 = r100.getRawX() - this.f420510g.x;
        if (Math.abs(r102) <= this.f420504a) goto L21;
    L22:
        this.f420511h = true;
        int r103 = (int) (getScrollX() - r102);
        if (r103 >= 0) goto L25;
        r103 = 0;
    L28:
        scrollTo(r103, 0);
        this.f420510g.set(r100.getRawX(), r100.getRawY());
        DocsLinearLayoutManager r104 = this.f420517n;
        if (r104 == null) goto L66;
        r104.f420501a = false;
        goto L66
    L25:
        int r105 = this.f420507d;
        if (r103 <= r105) goto L28;
        r103 = r105;
        goto L28
    L21:
        if (this.f420511h == false) goto L66;
    L32:
        if (this.f420512i == false) goto L34;
    L51:
        VelocityTracker r106 = this.f420514k;
        if (r106 == null) goto L54;
        r106.clear();
        this.f420514k.recycle();
        this.f420514k = null;
    L54:
        f420502p = false;
        DocsLinearLayoutManager r107 = this.f420517n;
        if (r107 == null) goto L66;
        r107.f420501a = true;
        goto L66
    L34:
        if (this.f420511h == false) goto L51;
        this.f420514k.computeCurrentVelocity(500);
        float r108 = this.f420514k.getXVelocity(this.f420505b);
        if (r108 < 2000.0f) goto L39;
        b();
        goto L51
    L39:
        if (r108 <= 0.0f) goto L45;
        if (getScrollX() >= (this.f420507d - this.f420508e)) goto L43;
        b();
        goto L51
    L43:
        d();
        goto L51
    L45:
        if (r108 > (-2000.0f)) goto L47;
        d();
        goto L51
    L47:
        if (getScrollX() <= this.f420508e) goto L49;
        d();
        goto L51
    L49:
        b();
        goto L51
    L57:
        this.f420511h = false;
        this.f420512i = false;
        if (f420502p == false) goto L60;
        return false;
    L60:
        f420502p = true;
        this.f420510g.set(r100.getRawX(), r100.getRawY());
        SwipeMenuLayout r109 = f420503q;
        if (r109 == null) goto L64;
        if (r109 == this) goto L64;
        r109.b();
        this.f420512i = true;
    L64:
        this.f420505b = r100.getPointerId(0);
    L66:
        return super.dispatchTouchEvent(r100);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new ViewGroup.MarginLayoutParams(getContext(), r100);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f420513j == false) goto L30;
        int r101 = r100.getAction();
        if (r101 == 1) goto L13;
        if (r101 != 2) goto L27;
        if (this.f420511h == false) goto L27;
        return true;
    L27:
        if (this.f420512i == false) goto L30;
        return true;
    L13:
        if (getScrollX() <= this.f420504a) goto L24;
        if (r100.getX() >= (getWidth() - getScrollX())) goto L17;
        boolean r102 = true;
    L18:
        if (r102 == false) goto L24;
        if (this.f420511h == true) goto L22;
        b();
    L22:
        return true;
    L17:
        r102 = false;
    L24:
        if (this.f420511h == false) goto L27;
        return true;
    L30:
        return super.onInterceptTouchEvent(r100);
    }

    public void setLayoutManager(DocsLinearLayoutManager r100) {
        this.f420517n = r100;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r100) {
        super.setOnClickListener(r100);
    }

    public void setSwipeEnable(boolean r100) {
        this.f420513j = r100;
    }

    public SwipeMenuLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r110, int r111) {
        super.onMeasure(r110, r111);
        setClickable(true);
        this.f420507d = 0;
        this.f420506c = 0;
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
        this.f420506c = Math.max(this.f420506c, r112.getMeasuredHeight());
        if (r101 == true) goto L14;
    L16:
        if (r102 <= 0) goto L18;
        this.f420507d += r112.getMeasuredWidth();
        goto L20
    L18:
        this.f420509f = r112;
        r103 = r112.getMeasuredWidth();
        goto L20
    L14:
        if (r113.height != (-1)) goto L16;
        r104 = true;
    L20:
        r102 = r102 + 1;
        goto L8
    L21:
        setMeasuredDimension((getPaddingLeft() + getPaddingRight()) + r103, (this.f420506c + getPaddingTop()) + getPaddingBottom());
        this.f420508e = this.f420507d / 5;
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
        this.f420510g = new PointF();
        this.f420513j = true;
        this.f420518o = new ArrayList();
        this.f420504a = ViewConfiguration.get(r100).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
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
