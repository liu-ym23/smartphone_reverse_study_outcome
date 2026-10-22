package com.relax.relaxui.behaviors.scroll;

import android.view.MotionEvent;
import android.view.View;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.ViewCompat;
import com.lynx.tasm.base.LLog;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes34.dex */
public class NestedScrollView extends ScrollView implements NestedScrollingParent2, NestedScrollingChild2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f405654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f405655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f405656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public OverScroller f405657d;

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final void stopNestedScroll() {
        stopNestedScroll(0);
    }

    @Override // android.widget.ScrollView, android.view.View
    public final void computeScroll() {
        if (this.f405654a == false) goto L20;
        OverScroller r100 = getVScroller();
        if (r100 == null) goto L20;
        if (r100.computeScrollOffset() == false) goto L16;
        int r101 = r100.getCurrY();
        int r102 = r101 - this.f405656c;
        if (dispatchNestedPreScroll(0, r102, null, null, 1) == true) goto L14;
        if (r102 != 0) goto L13;
        this.f405656c = r101;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L13:
        throw null;
    L14:
        throw null;
    L16:
        if (hasNestedScrollingParent(1) == false) goto L18;
        stopNestedScroll(1);
    L18:
        this.f405656c = 0;
        return;
    L20:
        super.computeScroll();
    }

    public OverScroller getVScroller() {
        OverScroller r100 = this.f405657d;
        if (r100 == null) goto L15;
        return r100;
    L15:
        Field r101 = ScrollView.class.getDeclaredField("mScroller");     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L12
        if (r101 == null) goto L14;
        r101.setAccessible(true);     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L12
        Object r102 = r101.get(this);     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L12
        if ((r102 instanceof OverScroller) == false) goto L14;
        this.f405657d = (OverScroller) r102;     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L12
    L14:
        return this.f405657d;
    L11:
        LLog.e("LynxNestedScrollView", "Failed to get mScroller of ScrollView!");
    L12:
        LLog.e("LynxNestedScrollView", "Failed to get mScroller field of ScrollView!");
        goto L14
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        throw null;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean isNestedScrollingEnabled() {
        throw null;
    }

    @Override // android.widget.ScrollView
    public final void fling(int r110) {
        LLog.i("LynxNestedScrollView", "fling with vel = " + r110);
        if (this.f405654a == false) goto L11;
        OverScroller r100 = getVScroller();
        if (r100 == null) goto L11;
        if (getChildCount() <= 0) goto L13;
        startNestedScroll(2, 1);
        r100.fling(getScrollX(), getScrollY(), 0, r110, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
        ViewCompat.postInvalidateOnAnimation(this);
        this.f405656c = getScrollY();
        return;
    L13:
        return;
    L11:
        super.fling(r110);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean hasNestedScrollingParent(int r100) {
        throw null;
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        boolean r101 = this.f405655b;
        return super.onInterceptTouchEvent(r100);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onStopNestedScroll(View r100) {
        onStopNestedScroll(r100, 0);
    }

    @Override // android.widget.ScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        boolean r101 = this.f405655b;
        return super.onTouchEvent(r100);
    }

    public void setEnableNewBounce(boolean r100) {
        this.f405655b = r100;
    }

    public void setEnableNewNested(boolean r100) {
        this.f405654a = r100;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean r100) {
        throw null;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean startNestedScroll(int r100) {
        return startNestedScroll(r100, 0);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final void stopNestedScroll(int r100) {
        throw null;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedPreFling(float r100, float r101) {
        throw null;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onStopNestedScroll(View r100, int r101) {
        boolean r102 = this.f405655b;
        throw null;
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean startNestedScroll(int r100, int r101) {
        throw null;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedFling(float r100, float r101, boolean r102) {
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedPreFling(View r100, float r101, float r102) {
        boolean r103 = this.f405655b;
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
    public final boolean dispatchNestedPreScroll(int r100, int r101, int[] r102, int[] r110) {
        return dispatchNestedPreScroll(r100, r101, r102, r110, 0);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedFling(View r100, float r101, float r102, boolean r103) {
        boolean r104 = this.f405655b;
        if (r103 == false) goto L6;
        return false;
    L6:
        getScrollY();
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedPreScroll(View r100, int r101, int r102, int[] r110) {
        dispatchNestedPreScroll(r101, r102, r110, null, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScrollAccepted(View r100, View r101, int r102, int r103) {
        boolean r104 = this.f405655b;
        throw null;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final boolean onStartNestedScroll(View r100, View r101, int r102, int r103) {
        boolean r104 = this.f405655b;
        if ((r102 & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean dispatchNestedPreScroll(int r100, int r101, int[] r102, int[] r103, int r104) {
        throw null;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedScroll(int r100, int r101, int r110, int r111, int[] r112) {
        return dispatchNestedScroll(r100, r101, r110, r111, r112, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedPreScroll(View r100, int r101, int r102, int[] r110, int r111) {
        boolean r103 = this.f405655b;
        dispatchNestedPreScroll(r101, r102, r110, null, r111);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedScroll(View r100, int r101, int r110, int r111, int r112) {
        onNestedScroll(r100, r101, r110, r111, r112, 0);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean dispatchNestedScroll(int r100, int r101, int r102, int r103, int[] r104, int r105) {
        throw null;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScroll(View r100, int r101, int r110, int r111, int r112, int r113) {
        boolean r102 = this.f405655b;
        int r103 = getScrollY();
        scrollBy(0, r112);
        int r104 = getScrollY() - r103;
        dispatchNestedScroll(0, r104, 0, r112 - r104, null, r113);
    }
}
