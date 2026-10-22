package com.lynx.tasm.behavior.ui.scroll;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.core.math.MathUtils;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import com.lynx.tasm.base.LLog;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes32.dex */
public class NestedScrollView extends ScrollView implements NestedScrollingParent2, NestedScrollingChild2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NestedScrollingParentHelper f382892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NestedScrollingChildHelper f382893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final UIScrollView f382894c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f382895d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f382896e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f382897f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int[] f382898g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public OverScroller f382899h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final g7a.b f382900i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f382901j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f382902k;

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    public void setPanInterceptAncestors(boolean r100) {
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final void stopNestedScroll() {
        stopNestedScroll(0);
    }

    @Override // android.widget.ScrollView, android.view.View
    public void computeScroll() {
        if (this.f382895d == false) goto L36;
        OverScroller r100 = getVScroller();
        if (r100 == null) goto L36;
        if (r100.computeScrollOffset() == false) goto L28;
        int r110 = r100.getCurrY();
        int r111 = r110 - this.f382897f;
        if (dispatchNestedPreScroll(0, r111, this.f382898g, null, 1) == false) goto L12;
        r111 = r111 - this.f382898g[1];
    L12:
        int r101 = r111;
        if (r101 == 0) goto L26;
        int r112 = this.f382894c.u0();
        int r102 = getScrollY();
        int r103 = r102 + r101;
        if (r103 < 0) goto L19;
        if (r103 > r112) goto L19;
        boolean r104 = false;
    L20:
        int r105 = MathUtils.clamp(r103, 0, r112);
        if (r104 == true) goto L23;
    L25:
        super.scrollTo(getScrollX(), r105);
        int r106 = getScrollY() - r102;
        dispatchNestedScroll(0, r106, 0, r101 - r106, null, 1);
        goto L26
    L23:
        if (hasNestedScrollingParent(1) == true) goto L25;
        r100.springBack(0, r105, 0, 0, 0, r112);
    L19:
        r104 = true;
    L26:
        this.f382897f = r110;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L28:
        if (hasNestedScrollingParent(1) == false) goto L30;
        stopNestedScroll(1);
    L30:
        this.f382897f = 0;
        g7a.b r107 = this.f382900i;
        if (r107 != null) goto L33;
        return;
    L33:
        if (this.f382896e == false) goto L40;
        r107.a();
        return;
    L40:
        return;
    L36:
        super.computeScroll();
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.f382892a.getNestedScrollAxes();
    }

    public OverScroller getVScroller() {
        OverScroller r100 = this.f382899h;
        if (r100 == null) goto L15;
        return r100;
    L15:
        Field r101 = ScrollView.class.getDeclaredField("mScroller");     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L12
        if (r101 == null) goto L14;
        r101.setAccessible(true);     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L12
        Object r102 = r101.get(this);     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L12
        if ((r102 instanceof OverScroller) == false) goto L14;
        this.f382899h = (OverScroller) r102;     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L12
    L14:
        return this.f382899h;
    L11:
        LLog.e("LynxNestedScrollView", "Failed to get mScroller of ScrollView!");
    L12:
        LLog.e("LynxNestedScrollView", "Failed to get mScroller field of ScrollView!");
        goto L14
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean isNestedScrollingEnabled() {
        return this.f382893b.isNestedScrollingEnabled();
    }

    @Override // android.widget.ScrollView
    public void fling(int r110) {
        LLog.i("LynxNestedScrollView", "fling with vel = " + r110);
        if (this.f382895d == false) goto L11;
        OverScroller r100 = getVScroller();
        if (r100 == null) goto L11;
        if (getChildCount() <= 0) goto L13;
        startNestedScroll(2, 1);
        r100.fling(getScrollX(), getScrollY(), 0, r110, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
        ViewCompat.postInvalidateOnAnimation(this);
        this.f382897f = getScrollY();
        return;
    L13:
        return;
    L11:
        super.fling(r110);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean hasNestedScrollingParent(int r100) {
        return this.f382893b.hasNestedScrollingParent(r100);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f382896e == false) goto L9;
        g7a.b r101 = this.f382900i;
        if (r101 == null) goto L9;
        return r101.b();
    L9:
        return super.onInterceptTouchEvent(r100);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onStopNestedScroll(View r100) {
        onStopNestedScroll(r100, 0);
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        if (this.f382896e == false) goto L9;
        g7a.b r101 = this.f382900i;
        if (r101 == null) goto L9;
        r101.getClass();
        return false;
    L9:
        return super.onTouchEvent(r100);
    }

    public void setEnableNewBounce(boolean r100) {
        this.f382896e = r100;
    }

    public void setEnableNewNested(boolean r100) {
        this.f382895d = r100;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean r100) {
        this.f382893b.setNestedScrollingEnabled(r100);
    }

    public void setPanInterceptDescendants(boolean r100) {
        this.f382902k = r100;
    }

    public void setPanInterceptSelf(boolean r100) {
        this.f382901j = r100;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean startNestedScroll(int r100) {
        return startNestedScroll(r100, 0);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final void stopNestedScroll(int r100) {
        this.f382893b.stopNestedScroll(r100);
    }

    public NestedScrollView(Context r100, UIScrollView r101) {
        super(r100);
        this.f382895d = false;
        this.f382896e = false;
        this.f382898g = new int[2];
        this.f382901j = false;
        this.f382902k = false;
        this.f382894c = r101;
        NestedScrollingParentHelper r102 = new NestedScrollingParentHelper(this);
        this.f382892a = r102;
        this.f382893b = new NestedScrollingChildHelper(this);
        this.f382900i = new g7a.b(this, true, r102);
        setNestedScrollingEnabled(true);
    }

    public final void a(int r100, int r101) {
        if (this.f382895d == true) goto L5;
    L7:
        super.smoothScrollTo(r100, r101);
        return;
    L5:
        if (getVScroller() == null) goto L7;
        this.f382897f = getScrollY();
        goto L7
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float r100, float r101) {
        return this.f382893b.dispatchNestedPreFling(r100, r101);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onStopNestedScroll(View r100, int r101) {
        if (this.f382896e == false) goto L8;
        g7a.b r102 = this.f382900i;
        if (r102 == null) goto L8;
        r102.e(r101);
        return;
    L8:
        this.f382892a.onStopNestedScroll(r100, r101);
        stopNestedScroll(r101);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean startNestedScroll(int r100, int r101) {
        return this.f382893b.startNestedScroll(r100, r101);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float r100, float r101, boolean r102) {
        return this.f382893b.dispatchNestedFling(r100, r101, r102);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedPreFling(View r100, float r101, float r102) {
        if (this.f382896e == false) goto L9;
        g7a.b r103 = this.f382900i;
        if (r103 == null) goto L9;
        r103.getClass();
        return false;
    L9:
        return dispatchNestedPreFling(r101, r102);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedScrollAccepted(View r100, View r101, int r102) {
        onNestedScrollAccepted(r100, r101, r102, 0);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onStartNestedScroll(View r100, View r101, int r102) {
        return onStartNestedScroll(r100, r101, r102, 0);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int r100, int r101, int[] r102, int[] r110) {
        return dispatchNestedPreScroll(r100, r101, r102, r110, 0);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedFling(View r100, float r101, float r102, boolean r103) {
        boolean r104 = false;
        if (this.f382896e == false) goto L8;
        g7a.b r105 = this.f382900i;
        if (r105 == null) goto L8;
        r105.getClass();
        return false;
    L8:
        if (r103 == true) goto L21;
        int r106 = getScrollY();
        int r107 = this.f382894c.u0();
        if (r106 <= 0) goto L12;
    L13:
        if (r106 >= r107) goto L15;
    L16:
        r104 = true;
    L18:
        if (dispatchNestedPreFling(0.0f, r102) == true) goto L20;
        dispatchNestedFling(0.0f, r102, r104);
        fling((int) r102);
    L20:
        return true;
    L15:
        if (r102 >= 0.0f) goto L18;
    L12:
        if (r102 <= 0.0f) goto L18;
    L21:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedPreScroll(View r100, int r101, int r102, int[] r110) {
        dispatchNestedPreScroll(r101, r102, r110, null, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScrollAccepted(View r100, View r101, int r102, int r103) {
        if (this.f382896e == false) goto L8;
        g7a.b r104 = this.f382900i;
        if (r104 == null) goto L8;
        r104.f480343g.onNestedScrollAccepted(r100, r101, r102, r103);
        return;
    L8:
        this.f382892a.onNestedScrollAccepted(r100, r101, r102, r103);
        startNestedScroll(2, r103);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final boolean onStartNestedScroll(View r100, View r101, int r102, int r103) {
        int r104 = 2;
        if (this.f382896e == false) goto L15;
        g7a.b r105 = this.f382900i;
        if (r105 == null) goto L15;
        if (r105.f480337a == true) goto L11;
        r104 = 1;
    L11:
        if ((r102 & r104) == 0) goto L18;
        return true;
    L18:
        return false;
    L15:
        if ((r102 & 2) == 0) goto L19;
        return true;
    L19:
        return false;
    }

    public boolean dispatchNestedPreScroll(int r100, int r101, int[] r102, int[] r110, int r111) {
        return this.f382893b.dispatchNestedPreScroll(r100, r101, r102, r110, r111);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int r100, int r101, int r110, int r111, int[] r112) {
        return dispatchNestedScroll(r100, r101, r110, r111, r112, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedPreScroll(View r100, int r110, int r111, int[] r112, int r113) {
        if (this.f382896e == false) goto L8;
        g7a.b r101 = this.f382900i;
        if (r101 == null) goto L8;
        r101.c(r100, r110, r111, r112, r113);
        return;
    L8:
        dispatchNestedPreScroll(r110, r111, r112, null, r113);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedScroll(View r100, int r101, int r110, int r111, int r112) {
        onNestedScroll(r100, r101, r110, r111, r112, 0);
    }

    public boolean dispatchNestedScroll(int r100, int r101, int r110, int r111, int[] r112, int r113) {
        return this.f382893b.dispatchNestedScroll(r100, r101, r110, r111, r112, r113);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScroll(View r100, int r101, int r110, int r111, int r112, int r113) {
        if (this.f382896e == false) goto L8;
        g7a.b r102 = this.f382900i;
        if (r102 == null) goto L8;
        r102.d(r101, r110, r111, r112, r113);
        return;
    L8:
        int r103 = getScrollY();
        scrollBy(0, r112);
        int r104 = getScrollY() - r103;
        dispatchNestedScroll(0, r104, 0, r112 - r104, null, r113);
    }
}
