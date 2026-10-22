package com.lynx.tasm.behavior.ui.scroll;

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

/* JADX INFO: loaded from: classes32.dex */
public class NestedHorizontalScrollView extends HorizontalScrollView implements NestedScrollingParent2, NestedScrollingChild2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f382874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f382875b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f382876c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f382877d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f382878e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f382879f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f382880g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f382881h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f382882i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f382883j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int[] f382884k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int[] f382885l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final UIScrollView f382886m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public OverScroller f382887n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public VelocityTracker f382888o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public NestedScrollingParentHelper f382889p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public NestedScrollingChildHelper f382890q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public g7a.b f382891r;

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
        if (this.f382874a == false) goto L36;
        OverScroller r100 = getHScroller();
        if (r100 == null) goto L36;
        if (r100.computeScrollOffset() == false) goto L28;
        int r110 = r100.getCurrX();
        int r111 = r110 - this.f382883j;
        if (dispatchNestedPreScroll(r111, 0, this.f382885l, null, 1) == false) goto L12;
        r111 = r111 - this.f382885l[0];
    L12:
        int r101 = r111;
        if (r101 == 0) goto L26;
        int r112 = this.f382886m.u0();
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
        this.f382883j = r110;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L28:
        if (hasNestedScrollingParent(1) == false) goto L30;
        stopNestedScroll(1);
    L30:
        this.f382883j = 0;
        g7a.b r107 = this.f382891r;
        if (r107 != null) goto L33;
        return;
    L33:
        if (this.f382876c == false) goto L40;
        r107.a();
        return;
    L40:
        return;
    L36:
        super.computeScroll();
    }

    public OverScroller getHScroller() {
        OverScroller r100 = this.f382887n;
        if (r100 == null) goto L15;
        return r100;
    L15:
        Field r101 = HorizontalScrollView.class.getDeclaredField("mScroller");     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L12
        if (r101 == null) goto L14;
        r101.setAccessible(true);     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L12
        Object r102 = r101.get(this);     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L12
        if ((r102 instanceof OverScroller) == false) goto L14;
        this.f382887n = (OverScroller) r102;     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L12
    L14:
        return this.f382887n;
    L11:
        LLog.e("LynxNestedHorizontalScrollView", "Failed to get mScroller of HorizontalScrollView!");
    L12:
        LLog.e("LynxNestedHorizontalScrollView", "Failed to get mScroller field of HorizontalScrollView!");
        goto L14
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.f382889p.getNestedScrollAxes();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean isNestedScrollingEnabled() {
        return this.f382890q.isNestedScrollingEnabled();
    }

    public final void a(MotionEvent r100) {
        int r101 = r100.getActionIndex();
        if (r100.getPointerId(r101) != this.f382877d) goto L11;
        if (r101 != 0) goto L6;
        int r102 = 1;
    L7:
        this.f382878e = (int) r100.getX(r102);
        this.f382877d = r100.getPointerId(r102);
        VelocityTracker r103 = this.f382888o;
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
        if (this.f382874a == false) goto L11;
        OverScroller r100 = getHScroller();
        if (r100 == null) goto L11;
        if (getChildCount() <= 0) goto L13;
        startNestedScroll(1, 1);
        r100.fling(getScrollX(), getScrollY(), r110, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0, 0, 0);
        ViewCompat.postInvalidateOnAnimation(this);
        this.f382883j = getScrollX();
        return;
    L13:
        return;
    L11:
        super.fling(r110);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean hasNestedScrollingParent(int r100) {
        return this.f382890q.hasNestedScrollingParent(r100);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r110) {
        if (this.f382874a == true) goto L7;
        return super.onInterceptTouchEvent(r110);
    L7:
        if (this.f382876c == false) goto L13;
        g7a.b r100 = this.f382891r;
        if (r100 == null) goto L13;
        return r100.b();
    L13:
        if (r110.getAction() == 2) goto L15;
    L17:
        int r101 = r110.getActionMasked();
        if (r101 != 0) goto L20;
        int r102 = (int) r110.getX();
        int r103 = (int) r110.getY();
        if (getChildCount() <= 0) goto L65;
        int r104 = getScrollX();
        View r105 = getChildAt(0);
        if (r103 < r105.getTop()) goto L65;
        if (r103 >= r105.getBottom()) goto L65;
        if (r102 < (r105.getLeft() - r104)) goto L65;
        if (r102 >= (r105.getRight() - r104)) goto L65;
        boolean r106 = true;
    L66:
        if (r106 == true) goto L70;
        this.f382875b = false;
        VelocityTracker r111 = this.f382888o;
        if (r111 == null) goto L79;
        r111.recycle();
        this.f382888o = null;
    L79:
        return this.f382875b;
    L70:
        VelocityTracker r107 = this.f382888o;
        if (r107 != null) goto L73;
        this.f382888o = VelocityTracker.obtain();
    L74:
        this.f382888o.addMovement(r110);
        this.f382877d = r110.getPointerId(0);
        this.f382878e = r102;
        OverScroller r112 = getHScroller();
        if (r112 == null) goto L77;
        r112.computeScrollOffset();
        this.f382875b = !getHScroller().isFinished();
    L77:
        startNestedScroll(1, 0);
        goto L79
    L73:
        r107.clear();
    L65:
        r106 = false;
        goto L66
    L20:
        if (r101 == 1) goto L45;
        if (r101 != 2) goto L23;
        int r108 = this.f382877d;
        if (r108 == (-1)) goto L79;
        int r109 = r110.findPointerIndex(r108);
        if (r109 == (-1)) goto L79;
        int r113 = (int) r110.getX(r109);
        if (Math.abs(r113 - this.f382878e) <= this.f382879f) goto L79;
        if ((getNestedScrollAxes() & 1) != 0) goto L79;
        this.f382875b = true;
        this.f382878e = r113;
        if (this.f382888o != null) goto L41;
        this.f382888o = VelocityTracker.obtain();
    L41:
        this.f382888o.addMovement(r110);
        ViewParent r114 = getParent();
        if (r114 == null) goto L44;
        r114.requestDisallowInterceptTouchEvent(true);
    L44:
        this.f382882i = 0;
        goto L79
    L23:
        if (r101 == 3) goto L45;
        if (r101 != 6) goto L79;
        a(r110);
    L45:
        this.f382875b = false;
        this.f382877d = -1;
        VelocityTracker r115 = this.f382888o;
        if (r115 == null) goto L48;
        r115.recycle();
        this.f382888o = null;
    L48:
        int r116 = this.f382886m.u0();
        if (getHScroller() != null) goto L51;
    L53:
        stopNestedScroll(0);
        goto L79
    L51:
        if (getHScroller().springBack(getScrollX(), getScrollY(), 0, r116, 0, 0) == false) goto L53;
        ViewCompat.postInvalidateOnAnimation(this);
        goto L53
    L15:
        if (this.f382875b == false) goto L17;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onStopNestedScroll(View r100) {
        onStopNestedScroll(r100, 0);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent r110) {
        if (this.f382874a == true) goto L7;
        return super.onTouchEvent(r110);
    L7:
        if (this.f382876c == true) goto L9;
    L11:
        int r100 = r110.getActionMasked();
        if (this.f382888o != null) goto L14;
        this.f382888o = VelocityTracker.obtain();
    L14:
        MotionEvent r101 = MotionEvent.obtain(r110);
        if (r100 != 0) goto L17;
        this.f382882i = 0;
    L17:
        r101.offsetLocation(this.f382882i, 0.0f);
        if (r100 == 0) goto L110;
        if (r100 != 1) goto L22;
        VelocityTracker r111 = this.f382888o;
        r111.computeCurrentVelocity(1000, this.f382881h);
        int r112 = -((int) r111.getXVelocity(this.f382877d));
        int r113 = this.f382886m.u0();
        OverScroller r102 = getHScroller();
        if (getChildCount() > 0) goto L88;
    L105:
        this.f382875b = false;
        this.f382877d = -1;
        VelocityTracker r114 = this.f382888o;
        if (r114 == null) goto L108;
        r114.recycle();
        this.f382888o = null;
    L108:
        stopNestedScroll(0);
    L121:
        VelocityTracker r115 = this.f382888o;
        if (r115 == null) goto L124;
        r115.addMovement(r101);
    L124:
        r101.recycle();
        return true;
    L88:
        if (Math.abs(r112) > this.f382880g) goto L90;
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
        int r105 = r110.findPointerIndex(this.f382877d);
        if (r105 == (-1)) goto L121;
        int r116 = (int) r110.getX(r105);
        int r106 = this.f382878e - r116;
        if (dispatchNestedPreScroll(r106, 0, this.f382885l, this.f382884k, 0) == false) goto L54;
        r106 = r106 - this.f382885l[0];
        r101.offsetLocation(this.f382884k[0], 0.0f);
        this.f382882i += this.f382884k[0];
    L54:
        if (this.f382875b == true) goto L64;
        if (Math.abs(r106) <= this.f382879f) goto L64;
        this.f382875b = true;
        ViewParent r107 = getParent();
        if (r107 == null) goto L60;
        r107.requestDisallowInterceptTouchEvent(true);
    L60:
        if (r106 <= 0) goto L62;
        r106 = r106 - this.f382879f;
        goto L64
    L62:
        r106 = r106 + this.f382879f;
    L64:
        if (this.f382875b == false) goto L121;
        this.f382878e = r116 - this.f382884k[0];
        int r108 = this.f382886m.u0();
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
        if (dispatchNestedScroll(r121, 0, r106 - r121, 0, this.f382884k, 0) == false) goto L121;
        int r122 = this.f382878e;
        int r123 = this.f382884k[0];
        this.f382878e = r122 - r123;
        this.f382882i += r123;
        r101.offsetLocation(r123, 0.0f);
        goto L121
    L80:
        if (hasNestedScrollingParent(0) == true) goto L82;
        this.f382888o.clear();
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
        int r124 = this.f382886m.u0();
        OverScroller r125 = getHScroller();
        if (this.f382875b == true) goto L38;
    L43:
        this.f382875b = false;
        this.f382877d = -1;
        VelocityTracker r126 = this.f382888o;
        if (r126 == null) goto L46;
        r126.recycle();
        this.f382888o = null;
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
        this.f382878e = (int) r110.getX(r127);
        this.f382877d = r110.getPointerId(r127);
        goto L121
    L28:
        if (r100 != 6) goto L121;
        a(r110);
        int r128 = r110.findPointerIndex(this.f382877d);
        if (r128 == (-1)) goto L121;
        this.f382878e = (int) r110.getX(r128);
        goto L121
    L110:
        if (getChildCount() != 0) goto L112;
        return false;
    L112:
        OverScroller r129 = getHScroller();
        if (r129 == null) goto L120;
        boolean r130 = !r129.isFinished();
        this.f382875b = r130;
        if (r130 == false) goto L119;
        ViewParent r131 = getParent();
        if (r131 == null) goto L119;
        r131.requestDisallowInterceptTouchEvent(true);
    L119:
        r129.abortAnimation();
    L120:
        this.f382878e = (int) r110.getX();
        this.f382877d = r110.getPointerId(0);
        startNestedScroll(1, 0);
        goto L121
    L9:
        if (this.f382891r == null) goto L11;
        return false;
    }

    public void setEnableNewBounce(boolean r100) {
        this.f382876c = r100;
    }

    public void setEnableNewNested(boolean r100) {
        this.f382874a = r100;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean r100) {
        this.f382890q.setNestedScrollingEnabled(r100);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean startNestedScroll(int r100) {
        return startNestedScroll(r100, 0);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final void stopNestedScroll(int r100) {
        this.f382890q.stopNestedScroll(r100);
    }

    public NestedHorizontalScrollView(Context r100, UIScrollView r101) {
        super(r100);
        this.f382874a = false;
        this.f382875b = false;
        this.f382876c = false;
        this.f382877d = -1;
        this.f382884k = new int[2];
        this.f382885l = new int[2];
        this.f382886m = r101;
        this.f382889p = new NestedScrollingParentHelper(this);
        this.f382890q = new NestedScrollingChildHelper(this);
        this.f382891r = new g7a.b(this, false, this.f382889p);
        ViewConfiguration r102 = ViewConfiguration.get(getContext());
        this.f382879f = r102.getScaledTouchSlop();
        this.f382880g = r102.getScaledMinimumFlingVelocity();
        this.f382881h = r102.getScaledMaximumFlingVelocity();
        setNestedScrollingEnabled(false);
    }

    public final void b(int r100, int r101) {
        if (this.f382874a == true) goto L5;
    L7:
        super.smoothScrollTo(r100, r101);
        return;
    L5:
        if (getHScroller() == null) goto L7;
        this.f382883j = getScrollX();
        goto L7
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float r100, float r101) {
        return this.f382890q.dispatchNestedPreFling(r100, r101);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onStopNestedScroll(View r100, int r101) {
        if (this.f382876c == false) goto L8;
        g7a.b r102 = this.f382891r;
        if (r102 == null) goto L8;
        r102.e(r101);
        return;
    L8:
        this.f382889p.onStopNestedScroll(r100, r101);
        stopNestedScroll(r101);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean startNestedScroll(int r100, int r101) {
        return this.f382890q.startNestedScroll(r100, r101);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float r100, float r101, boolean r102) {
        return this.f382890q.dispatchNestedFling(r100, r101, r102);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedPreFling(View r100, float r101, float r102) {
        if (this.f382876c == false) goto L9;
        g7a.b r103 = this.f382891r;
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
        if (this.f382876c == false) goto L8;
        g7a.b r105 = this.f382891r;
        if (r105 == null) goto L8;
        r105.getClass();
        return false;
    L8:
        if (r103 == true) goto L21;
        int r106 = getScrollX();
        int r107 = this.f382886m.u0();
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
        if (this.f382876c == false) goto L8;
        g7a.b r104 = this.f382891r;
        if (r104 == null) goto L8;
        r104.f480343g.onNestedScrollAccepted(r100, r101, r102, r103);
        return;
    L8:
        this.f382889p.onNestedScrollAccepted(r100, r101, r102, r103);
        startNestedScroll(1, r103);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final boolean onStartNestedScroll(View r100, View r101, int r102, int r103) {
        if (this.f382876c == false) goto L15;
        g7a.b r104 = this.f382891r;
        if (r104 == null) goto L15;
        if (r104.f480337a == false) goto L9;
        int r105 = 2;
    L11:
        if ((r105 & r102) == 0) goto L18;
        return true;
    L18:
        return false;
    L9:
        r105 = 1;
    L15:
        if ((r102 & 1) == 0) goto L19;
        return true;
    L19:
        return false;
    }

    public boolean dispatchNestedPreScroll(int r100, int r101, int[] r102, int[] r110, int r111) {
        return this.f382890q.dispatchNestedPreScroll(r100, r101, r102, r110, r111);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int r100, int r101, int r110, int r111, int[] r112) {
        return dispatchNestedScroll(r100, r101, r110, r111, r112, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedPreScroll(View r100, int r110, int r111, int[] r112, int r113) {
        if (this.f382876c == false) goto L8;
        g7a.b r101 = this.f382891r;
        if (r101 == null) goto L8;
        r101.c(r100, r110, r111, r112, r113);
        return;
    L8:
        dispatchNestedPreScroll(r110, r111, r112, null, r113);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedScroll(View r100, int r101, int r110, int r111, int r112) {
        onNestedScroll(r100, r101, r110, r111, r112, 0);
    }

    public boolean dispatchNestedScroll(int r100, int r101, int r110, int r111, int[] r112, int r113) {
        return this.f382890q.dispatchNestedScroll(r100, r101, r110, r111, r112, r113);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScroll(View r100, int r101, int r110, int r111, int r112, int r113) {
        if (this.f382876c == false) goto L8;
        g7a.b r102 = this.f382891r;
        if (r102 == null) goto L8;
        r102.d(r101, r110, r111, r112, r113);
        return;
    L8:
        int r103 = getScrollX();
        scrollBy(r111, 0);
        int r104 = getScrollX() - r103;
        dispatchNestedScroll(r104, 0, r111 - r104, 0, null, r113);
    }
}
