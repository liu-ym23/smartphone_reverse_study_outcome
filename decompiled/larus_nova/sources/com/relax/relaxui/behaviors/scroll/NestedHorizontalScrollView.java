package com.relax.relaxui.behaviors.scroll;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.HorizontalScrollView;
import android.widget.OverScroller;
import androidx.core.math.MathUtils;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import com.lynx.tasm.base.LLog;
import java.lang.reflect.Field;
import opa.b;

/* JADX INFO: loaded from: classes34.dex */
public class NestedHorizontalScrollView extends HorizontalScrollView implements NestedScrollingParent2, NestedScrollingChild2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f405636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f405637b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f405638c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f405639d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f405640e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f405641f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f405642g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f405643h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f405644i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f405645j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int[] f405646k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int[] f405647l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final UIScrollView f405648m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public OverScroller f405649n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public VelocityTracker f405650o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public NestedScrollingParentHelper f405651p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public NestedScrollingChildHelper f405652q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public b f405653r;

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final void stopNestedScroll() {
        stopNestedScroll(0);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final void computeScroll() {
        if (this.f405636a == false) goto L43;
        OverScroller r100 = getHScroller();
        if (r100 == null) goto L43;
        if (r100.computeScrollOffset() == false) goto L28;
        int r110 = r100.getCurrX();
        int r111 = r110 - this.f405645j;
        if (dispatchNestedPreScroll(r111, 0, this.f405647l, null, 1) == false) goto L12;
        r111 = r111 - this.f405647l[0];
    L12:
        int r101 = r111;
        if (r101 == 0) goto L26;
        int r112 = this.f405648m.j0();
        int r102 = getScrollX();
        int r103 = r102 + r101;
        if (r103 < 0) goto L19;
        if (r103 > r112) goto L19;
        boolean r104 = false;
    L20:
        int r105 = MathUtils.clamp(r103, 0, r112);
        if (r104 == true) goto L23;
    L25:
        super.scrollTo(r105, getScrollY());
        int r106 = getScrollX() - r102;
        dispatchNestedScroll(r106, 0, r101 - r106, 0, null, 1);
        goto L26
    L23:
        if (hasNestedScrollingParent(1) == true) goto L25;
        r100.springBack(r105, 0, 0, r112, 0, 0);
    L19:
        r104 = true;
    L26:
        this.f405645j = r110;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L28:
        if (hasNestedScrollingParent(1) == false) goto L30;
        stopNestedScroll(1);
    L30:
        this.f405645j = 0;
        b r107 = this.f405653r;
        if (r107 != null) goto L33;
        return;
    L33:
        if (this.f405638c == false) goto L47;
        r107.f524798c.getScrollX();
        int r108 = r107.f524798c.getScrollY();
        View r109 = r107.f524798c;
        if ((r109 instanceof NestedHorizontalScrollView) == false) goto L48;
        NestedHorizontalScrollView r113 = (NestedHorizontalScrollView) r109;
        if (r107.f524796a == false) goto L40;
        r113.b(r107.f524800e, r108);
        r107.f524796a = false;
        return;
    L40:
        if (r107.f524797b == false) goto L50;
        r113.b(r107.f524800e, r108);
        r107.f524797b = false;
        return;
    L50:
        return;
    L48:
        return;
    L47:
        return;
    L43:
        super.computeScroll();
    }

    public OverScroller getHScroller() {
        OverScroller r100 = this.f405649n;
        if (r100 == null) goto L15;
        return r100;
    L15:
        Field r101 = HorizontalScrollView.class.getDeclaredField("mScroller");     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L12
        if (r101 == null) goto L14;
        r101.setAccessible(true);     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L12
        Object r102 = r101.get(this);     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L12
        if ((r102 instanceof OverScroller) == false) goto L14;
        this.f405649n = (OverScroller) r102;     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L12
    L14:
        return this.f405649n;
    L11:
        LLog.e("LynxNestedHorizontalScrollView", "Failed to get mScroller of HorizontalScrollView!");
    L12:
        LLog.e("LynxNestedHorizontalScrollView", "Failed to get mScroller field of HorizontalScrollView!");
        goto L14
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.f405651p.getNestedScrollAxes();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean isNestedScrollingEnabled() {
        return this.f405652q.isNestedScrollingEnabled();
    }

    public final void a(MotionEvent r100) {
        int r101 = r100.getActionIndex();
        if (r100.getPointerId(r101) != this.f405639d) goto L11;
        if (r101 != 0) goto L6;
        int r102 = 1;
    L7:
        this.f405640e = (int) r100.getX(r102);
        this.f405639d = r100.getPointerId(r102);
        VelocityTracker r103 = this.f405650o;
        if (r103 == null) goto L12;
        r103.clear();
        return;
    L12:
        return;
    L6:
        r102 = 0;
        goto L7
    }

    @Override // android.widget.HorizontalScrollView
    public void fling(int r110) {
        if (this.f405636a == false) goto L11;
        OverScroller r100 = getHScroller();
        if (r100 == null) goto L11;
        if (getChildCount() <= 0) goto L13;
        startNestedScroll(1, 1);
        r100.fling(getScrollX(), getScrollY(), r110, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0, 0, 0);
        ViewCompat.postInvalidateOnAnimation(this);
        this.f405645j = getScrollX();
        return;
    L13:
        return;
    L11:
        super.fling(r110);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean hasNestedScrollingParent(int r100) {
        return this.f405652q.hasNestedScrollingParent(r100);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r110) {
        if (this.f405636a == true) goto L7;
        return super.onInterceptTouchEvent(r110);
    L7:
        if (this.f405638c == false) goto L19;
        b r100 = this.f405653r;
        if (r100 == null) goto L19;
        View r111 = r100.f524798c;
        if ((r111 instanceof NestedHorizontalScrollView) == false) goto L86;
        OverScroller r112 = ((NestedHorizontalScrollView) r111).getHScroller();
        if (r112 != null) goto L15;
        return false;
    L15:
        if (r112.isFinished() == true) goto L88;
        return true;
    L88:
        return false;
    L86:
        return false;
    L19:
        if (r110.getAction() == 2) goto L21;
    L23:
        int r101 = r110.getActionMasked();
        if (r101 != 0) goto L26;
        int r102 = (int) r110.getX();
        int r103 = (int) r110.getY();
        if (getChildCount() <= 0) goto L71;
        int r104 = getScrollX();
        View r105 = getChildAt(0);
        if (r103 < r105.getTop()) goto L71;
        if (r103 >= r105.getBottom()) goto L71;
        if (r102 < (r105.getLeft() - r104)) goto L71;
        if (r102 >= (r105.getRight() - r104)) goto L71;
        boolean r106 = true;
    L72:
        if (r106 == true) goto L76;
        this.f405637b = false;
        VelocityTracker r113 = this.f405650o;
        if (r113 == null) goto L85;
        r113.recycle();
        this.f405650o = null;
    L85:
        return this.f405637b;
    L76:
        VelocityTracker r107 = this.f405650o;
        if (r107 != null) goto L79;
        this.f405650o = VelocityTracker.obtain();
    L80:
        this.f405650o.addMovement(r110);
        this.f405639d = r110.getPointerId(0);
        this.f405640e = r102;
        OverScroller r114 = getHScroller();
        if (r114 == null) goto L83;
        r114.computeScrollOffset();
        this.f405637b = !getHScroller().isFinished();
    L83:
        startNestedScroll(1, 0);
        goto L85
    L79:
        r107.clear();
    L71:
        r106 = false;
        goto L72
    L26:
        if (r101 == 1) goto L51;
        if (r101 != 2) goto L29;
        int r108 = this.f405639d;
        if (r108 == (-1)) goto L85;
        int r109 = r110.findPointerIndex(r108);
        if (r109 == (-1)) goto L85;
        int r115 = (int) r110.getX(r109);
        if (Math.abs(r115 - this.f405640e) <= this.f405641f) goto L85;
        if ((getNestedScrollAxes() & 1) != 0) goto L85;
        this.f405637b = true;
        this.f405640e = r115;
        if (this.f405650o != null) goto L47;
        this.f405650o = VelocityTracker.obtain();
    L47:
        this.f405650o.addMovement(r110);
        ViewParent r116 = getParent();
        if (r116 == null) goto L50;
        r116.requestDisallowInterceptTouchEvent(true);
    L50:
        this.f405644i = 0;
        goto L85
    L29:
        if (r101 == 3) goto L51;
        if (r101 != 6) goto L85;
        a(r110);
    L51:
        this.f405637b = false;
        this.f405639d = -1;
        VelocityTracker r117 = this.f405650o;
        if (r117 == null) goto L54;
        r117.recycle();
        this.f405650o = null;
    L54:
        int r118 = this.f405648m.j0();
        if (getHScroller() != null) goto L57;
    L59:
        stopNestedScroll(0);
        goto L85
    L57:
        if (getHScroller().springBack(getScrollX(), getScrollY(), 0, r118, 0, 0) == false) goto L59;
        ViewCompat.postInvalidateOnAnimation(this);
        goto L59
    L21:
        if (this.f405637b == false) goto L23;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onStopNestedScroll(View r100) {
        onStopNestedScroll(r100, 0);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent r110) {
        if (this.f405636a == true) goto L7;
        return super.onTouchEvent(r110);
    L7:
        if (this.f405638c == true) goto L9;
    L11:
        int r100 = r110.getActionMasked();
        if (this.f405650o != null) goto L14;
        this.f405650o = VelocityTracker.obtain();
    L14:
        MotionEvent r101 = MotionEvent.obtain(r110);
        if (r100 != 0) goto L17;
        this.f405644i = 0;
    L17:
        r101.offsetLocation(this.f405644i, 0.0f);
        if (r100 == 0) goto L110;
        if (r100 != 1) goto L22;
        VelocityTracker r111 = this.f405650o;
        r111.computeCurrentVelocity(1000, this.f405643h);
        int r112 = -((int) r111.getXVelocity(this.f405639d));
        int r113 = this.f405648m.j0();
        OverScroller r102 = getHScroller();
        if (getChildCount() > 0) goto L88;
    L105:
        this.f405637b = false;
        this.f405639d = -1;
        VelocityTracker r114 = this.f405650o;
        if (r114 == null) goto L108;
        r114.recycle();
        this.f405650o = null;
    L108:
        stopNestedScroll(0);
    L121:
        VelocityTracker r115 = this.f405650o;
        if (r115 == null) goto L124;
        r115.addMovement(r101);
    L124:
        r101.recycle();
        return true;
    L88:
        if (Math.abs(r112) > this.f405642g) goto L90;
        if (r102 == null) goto L105;
        if (r102.springBack(getScrollX(), getScrollY(), 0, r113, 0, 0) == false) goto L105;
        ViewCompat.postInvalidateOnAnimation(this);
        goto L105
    L90:
        if (getScrollX() > 0) goto L93;
        if (r112 > 0) goto L93;
    L96:
        boolean r103 = false;
    L98:
        float r104 = r112;
        if (dispatchNestedPreFling(r104, 0.0f) == true) goto L105;
        dispatchNestedFling(r104, 0.0f, r103);
        fling(r112);
    L93:
        if (getScrollX() < r113) goto L97;
        if (r112 >= 0) goto L96;
    L97:
        r103 = true;
        goto L98
    L22:
        if (r100 != 2) goto L24;
        int r105 = r110.findPointerIndex(this.f405639d);
        if (r105 == (-1)) goto L121;
        int r116 = (int) r110.getX(r105);
        int r106 = this.f405640e - r116;
        if (dispatchNestedPreScroll(r106, 0, this.f405647l, this.f405646k, 0) == false) goto L54;
        r106 = r106 - this.f405647l[0];
        r101.offsetLocation(this.f405646k[0], 0.0f);
        this.f405644i += this.f405646k[0];
    L54:
        if (this.f405637b == true) goto L64;
        if (Math.abs(r106) <= this.f405641f) goto L64;
        this.f405637b = true;
        ViewParent r107 = getParent();
        if (r107 == null) goto L60;
        r107.requestDisallowInterceptTouchEvent(true);
    L60:
        if (r106 <= 0) goto L62;
        r106 = r106 - this.f405641f;
        goto L64
    L62:
        r106 = r106 + this.f405641f;
    L64:
        if (this.f405637b == false) goto L121;
        this.f405640e = r116 - this.f405646k[0];
        int r108 = this.f405648m.j0();
        int r117 = getScrollX();
        int r109 = r117 + r106;
        if (r109 < 0) goto L70;
        if (r109 > r108) goto L70;
        boolean r118 = false;
    L71:
        int r119 = MathUtils.clamp(r109, 0, r108);
        OverScroller r120 = getHScroller();
        if (r118 == true) goto L74;
    L77:
        super.scrollTo(r119, getScrollY());
        if (r118 == true) goto L80;
    L82:
        int r121 = getScrollX() - r117;
        if (dispatchNestedScroll(r121, 0, r106 - r121, 0, this.f405646k, 0) == false) goto L121;
        int r122 = this.f405640e;
        int r123 = this.f405646k[0];
        this.f405640e = r122 - r123;
        this.f405644i += r123;
        r101.offsetLocation(r123, 0.0f);
        goto L121
    L80:
        if (hasNestedScrollingParent(0) == true) goto L82;
        this.f405650o.clear();
        goto L82
    L74:
        if (hasNestedScrollingParent(1) == true) goto L77;
        if (r120 == null) goto L77;
        r120.springBack(r119, 0, 0, r108, 0, 0);
    L70:
        r118 = true;
        goto L71
    L24:
        if (r100 != 3) goto L26;
        int r124 = this.f405648m.j0();
        OverScroller r125 = getHScroller();
        if (this.f405637b == true) goto L38;
    L43:
        this.f405637b = false;
        this.f405639d = -1;
        VelocityTracker r126 = this.f405650o;
        if (r126 == null) goto L46;
        r126.recycle();
        this.f405650o = null;
    L46:
        stopNestedScroll(0);
        goto L121
    L38:
        if (getChildCount() <= 0) goto L43;
        if (r125 == null) goto L43;
        if (r125.springBack(getScrollX(), getScrollY(), 0, r124, 0, 0) == false) goto L43;
        ViewCompat.postInvalidateOnAnimation(this);
        goto L43
    L26:
        if (r100 != 5) goto L28;
        int r127 = r110.getActionIndex();
        this.f405640e = (int) r110.getX(r127);
        this.f405639d = r110.getPointerId(r127);
        goto L121
    L28:
        if (r100 != 6) goto L121;
        a(r110);
        int r128 = r110.findPointerIndex(this.f405639d);
        if (r128 == (-1)) goto L121;
        this.f405640e = (int) r110.getX(r128);
        goto L121
    L110:
        if (getChildCount() != 0) goto L112;
        return false;
    L112:
        OverScroller r129 = getHScroller();
        if (r129 == null) goto L120;
        boolean r130 = !r129.isFinished();
        this.f405637b = r130;
        if (r130 == false) goto L119;
        ViewParent r131 = getParent();
        if (r131 == null) goto L119;
        r131.requestDisallowInterceptTouchEvent(true);
    L119:
        r129.abortAnimation();
    L120:
        this.f405640e = (int) r110.getX();
        this.f405639d = r110.getPointerId(0);
        startNestedScroll(1, 0);
        goto L121
    L9:
        if (this.f405653r == null) goto L11;
        return false;
    }

    public void setEnableNewBounce(boolean r100) {
        this.f405638c = r100;
    }

    public void setEnableNewNested(boolean r100) {
        this.f405636a = r100;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean r100) {
        this.f405652q.setNestedScrollingEnabled(r100);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean startNestedScroll(int r100) {
        return startNestedScroll(r100, 0);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final void stopNestedScroll(int r100) {
        this.f405652q.stopNestedScroll(r100);
    }

    public NestedHorizontalScrollView(Context r100, UIScrollView r101) {
        super(r100);
        this.f405636a = false;
        this.f405637b = false;
        this.f405638c = false;
        this.f405639d = -1;
        this.f405646k = new int[2];
        this.f405647l = new int[2];
        this.f405648m = r101;
        this.f405651p = new NestedScrollingParentHelper(this);
        this.f405652q = new NestedScrollingChildHelper(this);
        AndroidScrollView.CustomHorizontalScrollView r102 = (AndroidScrollView.CustomHorizontalScrollView) this;
        this.f405653r = new b(r102, this.f405651p);
        ViewConfiguration r103 = ViewConfiguration.get(getContext());
        this.f405641f = r103.getScaledTouchSlop();
        this.f405642g = r103.getScaledMinimumFlingVelocity();
        this.f405643h = r103.getScaledMaximumFlingVelocity();
        setNestedScrollingEnabled(false);
    }

    public final void b(int r100, int r101) {
        if (this.f405636a == true) goto L5;
    L7:
        super.smoothScrollTo(r100, r101);
        return;
    L5:
        if (getHScroller() == null) goto L7;
        this.f405645j = getScrollX();
        goto L7
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float r100, float r101) {
        return this.f405652q.dispatchNestedPreFling(r100, r101);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onStopNestedScroll(View r100, int r101) {
        if (this.f405638c == false) goto L16;
        b r102 = this.f405653r;
        if (r102 == null) goto L16;
        int r103 = r102.f524798c.getScrollX();
        int r104 = r102.f524798c.getScrollY();
        if (1 == r101) goto L19;
        View r105 = r102.f524798c;
        if ((r105 instanceof NestedHorizontalScrollView) == false) goto L18;
        NestedHorizontalScrollView r106 = (NestedHorizontalScrollView) r105;
        int r107 = r102.f524800e;
        if (r103 == r107) goto L14;
        r106.b(r107, r104);
    L14:
        r106.stopNestedScroll(r101);
        return;
    L18:
        return;
    L19:
        return;
    L16:
        this.f405651p.onStopNestedScroll(r100, r101);
        stopNestedScroll(r101);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean startNestedScroll(int r100, int r101) {
        return this.f405652q.startNestedScroll(r100, r101);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float r100, float r101, boolean r102) {
        return this.f405652q.dispatchNestedFling(r100, r101, r102);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedPreFling(View r100, float r101, float r102) {
        if (this.f405638c == false) goto L9;
        b r103 = this.f405653r;
        if (r103 == null) goto L9;
        r103.getClass();
        return false;
    L9:
        return dispatchNestedPreFling(r101, r102);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedScrollAccepted(View r100, View r101, int r102) {
        onNestedScrollAccepted(r100, r101, r102, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onStartNestedScroll(View r100, View r101, int r102) {
        return onStartNestedScroll(r100, r101, r102, 0);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int r100, int r101, int[] r102, int[] r110) {
        return dispatchNestedPreScroll(r100, r101, r102, r110, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedFling(View r100, float r101, float r102, boolean r103) {
        boolean r104 = false;
        if (this.f405638c == false) goto L8;
        b r105 = this.f405653r;
        if (r105 == null) goto L8;
        r105.getClass();
        return false;
    L8:
        if (r103 == true) goto L21;
        int r106 = getScrollX();
        int r107 = this.f405648m.j0();
        if (r106 <= 0) goto L12;
    L13:
        if (r106 >= r107) goto L15;
    L16:
        r104 = true;
    L18:
        if (dispatchNestedPreFling(r101, 0.0f) == true) goto L20;
        dispatchNestedFling(r101, 0.0f, r104);
        fling((int) r101);
    L20:
        return true;
    L15:
        if (r101 >= 0.0f) goto L18;
    L12:
        if (r101 <= 0.0f) goto L18;
    L21:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedPreScroll(View r100, int r101, int r102, int[] r110) {
        dispatchNestedPreScroll(r101, r102, r110, null, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScrollAccepted(View r100, View r101, int r102, int r103) {
        if (this.f405638c == false) goto L8;
        b r104 = this.f405653r;
        if (r104 == null) goto L8;
        r104.f524801f.onNestedScrollAccepted(r100, r101, r102, r103);
        return;
    L8:
        this.f405651p.onNestedScrollAccepted(r100, r101, r102, r103);
        startNestedScroll(1, r103);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final boolean onStartNestedScroll(View r100, View r101, int r102, int r103) {
        if (this.f405638c == false) goto L11;
        if (this.f405653r == null) goto L11;
        if ((r102 & 1) == 0) goto L14;
        return true;
    L14:
        return false;
    L11:
        if ((r102 & 1) == 0) goto L15;
        return true;
    L15:
        return false;
    }

    public boolean dispatchNestedPreScroll(int r100, int r101, int[] r102, int[] r110, int r111) {
        return this.f405652q.dispatchNestedPreScroll(r100, r101, r102, r110, r111);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int r100, int r101, int r110, int r111, int[] r112) {
        return dispatchNestedScroll(r100, r101, r110, r111, r112, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedPreScroll(View r110, int r111, int r112, int[] r113, int r114) {
        if (this.f405638c == false) goto L43;
        b r100 = this.f405653r;
        if (r100 == null) goto L43;
        if (1 == r114) goto L50;
        int r101 = r100.f524798c.getScrollX();
        int r102 = r100.f524798c.getScrollY();
        View r103 = r100.f524798c;
        if ((r103 instanceof NestedHorizontalScrollView) == false) goto L45;
        NestedHorizontalScrollView r104 = (NestedHorizontalScrollView) r103;
        int r105 = r100.f524799d;
        int r106 = r100.f524800e;
        if (r110.canScrollHorizontally(-1) == true) goto L19;
        if (r111 >= 0) goto L19;
        if ((r101 + r111) >= 0) goto L17;
        r104.scrollTo(0, r102);
    L18:
        r113[0] = r111;
    L27:
        if (r110.canScrollHorizontally(1) == true) goto L34;
        if (r111 <= 0) goto L34;
        if ((r101 + r111) <= r105) goto L32;
        r104.scrollTo(r105, r102);
    L33:
        r113[0] = r111;
        return;
    L32:
        r104.requestDisallowInterceptTouchEvent(true);
        r104.scrollBy(r111, 0);
    L34:
        if (r106 >= r101) goto L47;
        if (r101 > r105) goto L48;
        if (r111 >= 0) goto L49;
        r104.requestDisallowInterceptTouchEvent(true);
        if ((r101 + r111) >= r106) goto L40;
        r104.scrollBy(r106 - r101, 0);
    L41:
        r113[0] = r111;
        return;
    L40:
        r104.scrollBy(r111, 0);
        goto L41
    L49:
        return;
    L48:
        return;
    L47:
        return;
    L17:
        r104.requestDisallowInterceptTouchEvent(true);
        r104.scrollBy(r111, 0);
    L19:
        if (r101 >= r106) goto L27;
        if (r111 <= 0) goto L27;
        r104.requestDisallowInterceptTouchEvent(true);
        if ((r101 + r111) <= r106) goto L24;
        r104.scrollBy(r106 - r101, 0);
    L25:
        r113[0] = r111;
        goto L27
    L24:
        r104.scrollBy(r111, 0);
        goto L25
    L45:
        return;
    L50:
        return;
    L43:
        dispatchNestedPreScroll(r111, r112, r113, null, r114);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedScroll(View r100, int r101, int r110, int r111, int r112) {
        onNestedScroll(r100, r101, r110, r111, r112, 0);
    }

    public boolean dispatchNestedScroll(int r100, int r101, int r110, int r111, int[] r112, int r113) {
        return this.f405652q.dispatchNestedScroll(r100, r101, r110, r111, r112, r113);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScroll(View r100, int r101, int r110, int r111, int r112, int r113) {
        if (this.f405638c == false) goto L34;
        b r102 = this.f405653r;
        if (r102 == null) goto L34;
        if (r113 == 0) goto L41;
        int r114 = r102.f524798c.getScrollX();
        int r115 = r102.f524798c.getScrollY();
        View r103 = r102.f524798c;
        if ((r103 instanceof NestedHorizontalScrollView) == false) goto L36;
        NestedHorizontalScrollView r104 = (NestedHorizontalScrollView) r103;
        OverScroller r105 = r104.getHScroller();
        if (r105 == null) goto L42;
        int r106 = r102.f524799d;
        int r107 = r102.f524800e;
        boolean r108 = r102.f524796a;
        if (r108 == true) goto L18;
        if (r101 >= 0) goto L18;
        if (r111 >= 0) goto L18;
        r104.b(0, r115);
        r102.f524796a = true;
    L23:
        boolean r109 = r102.f524797b;
        if (r109 == true) goto L28;
        if (r101 <= 0) goto L28;
        if (r111 <= 0) goto L28;
        r104.b(r106, r115);
        r102.f524797b = true;
        return;
    L28:
        if (r109 == false) goto L38;
        if (r114 == r106) goto L31;
        return;
    L31:
        if (r105.isFinished() == false) goto L40;
        r104.b(r107, r115);
        r102.f524797b = false;
        return;
    L40:
        return;
    L38:
        return;
    L18:
        if (r108 == false) goto L23;
        if (r114 != 0) goto L23;
        if (r105.isFinished() == false) goto L23;
        r104.b(r107, r115);
        r102.f524796a = false;
        goto L23
    L42:
        return;
    L36:
        return;
    L41:
        return;
    L34:
        int r116 = getScrollX();
        scrollBy(r111, 0);
        int r117 = getScrollX() - r116;
        dispatchNestedScroll(r117, 0, r111 - r117, 0, null, r113);
    }
}
