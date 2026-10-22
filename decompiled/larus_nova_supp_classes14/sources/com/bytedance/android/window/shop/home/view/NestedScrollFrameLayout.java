package com.bytedance.android.window.shop.home.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u000eB\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/window/shop/home/view/NestedScrollFrameLayout;", "Landroid/widget/FrameLayout;", "Landroidx/core/view/NestedScrollingChild;", "Landroidx/core/view/NestedScrollingParent;", "", "enabled", "", "setNestedScrollingEnabled", "", "getNestedScrollAxes", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NestedScrollFrameLayout extends FrameLayout implements NestedScrollingChild, NestedScrollingParent {
    public final NestedScrollingChildHelper a;
    public final NestedScrollingParentHelper b;
    public final float c;
    public final float d;
    public final float e;
    public final int[] f;
    public final int[] g;
    public int h;
    public int i;
    public VelocityTracker j;
    public boolean k;

    public static final class a {
    }

    static {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View r2, View r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "child");
        Intrinsics.checkNotNullParameter(r3, "target");
        if ((r4 & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.b.getNestedScrollAxes();
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return this.a.hasNestedScrollingParent();
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return this.a.isNestedScrollingEnabled();
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        this.a.stopNestedScroll();
    }

    public NestedScrollFrameLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = new NestedScrollingChildHelper(this);
        this.b = new NestedScrollingParentHelper(this);
        ViewConfiguration r3 = ViewConfiguration.get(r2);
        this.c = r3.getScaledTouchSlop();
        this.d = r3.getScaledMaximumFlingVelocity();
        this.e = r3.getScaledMinimumFlingVelocity();
        this.f = new int[2];
        this.g = new int[2];
        setWillNotDraw(false);
        setNestedScrollingEnabled(true);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View r2) {
        Intrinsics.checkNotNullParameter(r2, "target");
        this.b.onStopNestedScroll(r2);
        stopNestedScroll();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r13) {
        Intrinsics.checkNotNullParameter(r13, "ev");
        MotionEvent r0 = MotionEvent.obtain(r13);
        if (this.j != null) goto L5;
        this.j = VelocityTracker.obtain();
    L5:
        int r1 = r0.getActionMasked();
        int r4 = 0;
        if (r1 != 0) goto L8;
        VelocityTracker r2 = this.j;
        if (r2 == null) goto L69;
        r2.addMovement(r13);
    L69:
        this.h = (int) r0.getY();
        this.i = r0.getPointerId(0);
        startNestedScroll(2);
    L70:
        r0.recycle();
        return true;
    L8:
        if (r1 == 1) goto L51;
        if (r1 != 2) goto L11;
        int r3 = r0.findPointerIndex(this.i);
        if (r3 == (-1)) goto L70;
        int r5 = (int) r0.getY(r3);
        int r6 = this.h - r5;
        if (dispatchNestedPreScroll(0, r6, this.f, this.g) == false) goto L33;
        r6 = r6 - this.f[1];
        r0.offsetLocation(0.0f, this.g[1]);
    L33:
        if (this.k == false) goto L35;
    L43:
        int r10 = r6;
        if (this.k == false) goto L70;
        VelocityTracker r7 = this.j;
        if (r7 == null) goto L48;
        r7.addMovement(r13);
    L48:
        int[] r11 = this.g;
        this.h = r5 - r11[1];
        if (dispatchNestedScroll(0, 0, 0, r10, r11) == false) goto L70;
        int r14 = this.h;
        int r8 = this.g[1];
        this.h = r14 - r8;
        r0.offsetLocation(0.0f, r8);
        goto L70
    L35:
        if (Math.abs(this.h - r5) <= this.c) goto L43;
        ViewParent r9 = getParent();
        if (r9 == null) goto L39;
        r9.requestDisallowInterceptTouchEvent(true);
    L39:
        this.k = true;
        if (r6 <= 0) goto L42;
        r6 = r6 - ((int) this.c);
        goto L43
    L42:
        r6 = r6 + ((int) this.c);
        goto L43
    L11:
        if (r1 == 3) goto L51;
        if (r1 != 5) goto L15;
        int r15 = r0.getActionIndex();
        this.h = (int) r0.getY(r15);
        this.i = r0.getPointerId(r15);
        goto L70
    L15:
        if (r1 != 6) goto L70;
        int r16 = (r0.getAction() & 65280) >> 8;
        if (r0.getPointerId(r16) != this.i) goto L24;
        if (r16 != 0) goto L21;
        r4 = 1;
    L21:
        this.h = (int) r0.getY(r4);
        this.i = r0.getPointerId(r4);
        VelocityTracker r17 = this.j;
        if (r17 == null) goto L24;
        r17.clear();
    L24:
        this.h = (int) r0.getY(r0.findPointerIndex(this.i));
    L51:
        VelocityTracker r18 = this.j;
        if (r18 != null) goto L55;
    L62:
        this.k = false;
        VelocityTracker r19 = this.j;
        if (r19 == null) goto L65;
        r19.recycle();
    L65:
        this.j = null;
        stopNestedScroll();
        goto L70
    L55:
        if (this.k == false) goto L61;
        r18.computeCurrentVelocity(ECDraweeView.SQUARE, this.d);
        int r110 = (int) r18.getYVelocity(this.i);
        if (Math.abs(r110) <= this.e) goto L61;
        float r111 = -r110;
        if (dispatchNestedPreFling(0.0f, r111) == true) goto L61;
        dispatchNestedFling(0.0f, r111, true);
    L61:
        this.i = -1;
        goto L62
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean r2) {
        if (r2 == false) goto L7;
        VelocityTracker r0 = this.j;
        if (r0 == null) goto L6;
        r0.recycle();
    L6:
        this.j = null;
    L7:
        super.requestDisallowInterceptTouchEvent(r2);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean r2) {
        this.a.setNestedScrollingEnabled(r2);
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int r2) {
        return this.a.startNestedScroll(r2);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float r2, float r3) {
        return this.a.dispatchNestedPreFling(r2, r3);
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float r2, float r3, boolean r4) {
        return this.a.dispatchNestedFling(r2, r3, r4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View r2, float r3, float r4) {
        Intrinsics.checkNotNullParameter(r2, "target");
        return dispatchNestedPreFling(r3, r4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View r2, View r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "child");
        Intrinsics.checkNotNullParameter(r3, "target");
        this.b.onNestedScrollAccepted(r2, r3, r4);
        startNestedScroll(2);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int r2, int r3, int[] r4, int[] r5) {
        return this.a.dispatchNestedPreScroll(r2, r3, r4, r5);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View r2, float r3, float r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "target");
        return dispatchNestedFling(r3, r4, r5);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View r2, int r3, int r4, int[] r5) {
        Intrinsics.checkNotNullParameter(r2, "target");
        Intrinsics.checkNotNullParameter(r5, "consumed");
        dispatchNestedPreScroll(r3, r4, r5, null);
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int r7, int r8, int r9, int r10, int[] r11) {
        return this.a.dispatchNestedScroll(r7, r8, r9, r10, r11);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View r8, int r9, int r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r8, "target");
        dispatchNestedScroll(r9, r10, r11, r12, null);
    }
}
