package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {
    private static final int INVALID_POINTER = -1;
    private int activePointerId;
    private Runnable flingRunnable;
    private boolean isBeingDragged;
    private int lastMotionY;
    OverScroller scroller;
    private int touchSlop;
    private VelocityTracker velocityTracker;

    public class FlingRunnable implements Runnable {
        private final V layout;
        private final CoordinatorLayout parent;
        final /* synthetic */ HeaderBehavior this$0;

        @Override // java.lang.Runnable
        public void run() {
            com_google_android_material_appbar_HeaderBehavior$FlingRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_google_android_material_appbar_HeaderBehavior$FlingRunnable__run$___twin___() {
            if (this.layout == null) goto L11;
            OverScroller r100 = this.this$0.scroller;
            if (r100 != null) goto L7;
            return;
        L7:
            if (r100.computeScrollOffset() == false) goto L9;
            HeaderBehavior r101 = this.this$0;
            r101.setHeaderTopBottomOffset(this.parent, this.layout, r101.scroller.getCurrY());
            ViewCompat.postOnAnimation(this.layout, this);
            return;
        L9:
            this.this$0.onFlingFinished(this.parent, this.layout);
            return;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_google_android_material_appbar_HeaderBehavior$FlingRunnable_com_larus_apm_impl_protector_RunnableLancet_run(FlingRunnable r100) {
            r100.com_google_android_material_appbar_HeaderBehavior$FlingRunnable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public FlingRunnable(HeaderBehavior r100, CoordinatorLayout r101, V r102) {
            this.this$0 = r100;
            this.parent = r101;
            this.layout = r102;
        }
    }

    public boolean canDragView(V r100) {
        return false;
    }

    public void onFlingFinished(CoordinatorLayout r100, V r101) {
    }

    private void ensureVelocityTracker() {
        if (this.velocityTracker != null) goto L6;
        this.velocityTracker = VelocityTracker.obtain();
        return;
    }

    public HeaderBehavior() {
        this.activePointerId = -1;
        this.touchSlop = -1;
    }

    public int getTopBottomOffsetForScrollingSibling() {
        return getTopAndBottomOffset();
    }

    public int getMaxDragOffset(V r100) {
        return -r100.getHeight();
    }

    public int getScrollRangeForDragFling(V r100) {
        return r100.getHeight();
    }

    public HeaderBehavior(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.activePointerId = -1;
        this.touchSlop = -1;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout r100, V r101, MotionEvent r102) {
        if (this.touchSlop >= 0) goto L6;
        this.touchSlop = ViewConfiguration.get(r100.getContext()).getScaledTouchSlop();
    L6:
        if (r102.getAction() == 2) goto L8;
    L10:
        int r103 = r102.getActionMasked();
        if (r103 != 0) goto L13;
        this.isBeingDragged = false;
        int r104 = (int) r102.getX();
        int r105 = (int) r102.getY();
        if (canDragView(r101) == true) goto L33;
    L35:
        VelocityTracker r106 = this.velocityTracker;
        if (r106 == null) goto L39;
        r106.addMovement(r102);
    L39:
        return this.isBeingDragged;
    L33:
        if (r100.isPointInChildBounds(r101, r104, r105) == false) goto L35;
        this.lastMotionY = r105;
        this.activePointerId = r102.getPointerId(0);
        ensureVelocityTracker();
        goto L35
    L13:
        if (r103 == 1) goto L27;
        if (r103 != 2) goto L16;
        int r107 = this.activePointerId;
        if (r107 == (-1)) goto L35;
        int r108 = r102.findPointerIndex(r107);
        if (r108 == (-1)) goto L35;
        int r109 = (int) r102.getY(r108);
        if (Math.abs(r109 - this.lastMotionY) <= this.touchSlop) goto L35;
        this.isBeingDragged = true;
        this.lastMotionY = r109;
        goto L35
    L16:
        if (r103 != 3) goto L35;
    L27:
        this.isBeingDragged = false;
        this.activePointerId = -1;
        VelocityTracker r110 = this.velocityTracker;
        if (r110 == null) goto L35;
        r110.recycle();
        this.velocityTracker = null;
        goto L35
    L8:
        if (this.isBeingDragged == false) goto L10;
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout r110, V r111, MotionEvent r112) {
        if (this.touchSlop >= 0) goto L5;
        this.touchSlop = ViewConfiguration.get(r110.getContext()).getScaledTouchSlop();
    L5:
        int r100 = r112.getActionMasked();
        if (r100 != 0) goto L8;
        int r101 = (int) r112.getX();
        int r102 = (int) r112.getY();
        if (r110.isPointInChildBounds(r111, r101, r102) == true) goto L37;
    L43:
        return false;
    L37:
        if (canDragView(r111) == false) goto L43;
        this.lastMotionY = r102;
        this.activePointerId = r112.getPointerId(0);
        ensureVelocityTracker();
    L39:
        VelocityTracker r113 = this.velocityTracker;
        if (r113 == null) goto L42;
        r113.addMovement(r112);
    L42:
        return true;
    L8:
        if (r100 != 1) goto L10;
        VelocityTracker r103 = this.velocityTracker;
        if (r103 == null) goto L31;
        r103.addMovement(r112);
        this.velocityTracker.computeCurrentVelocity(1000);
        float r114 = this.velocityTracker.getYVelocity(this.activePointerId);
        fling(r110, r111, -getScrollRangeForDragFling(r111), 0, r114);
    L31:
        this.isBeingDragged = false;
        this.activePointerId = -1;
        VelocityTracker r115 = this.velocityTracker;
        if (r115 == null) goto L39;
        r115.recycle();
        this.velocityTracker = null;
        goto L39
    L10:
        if (r100 != 2) goto L12;
        int r104 = r112.findPointerIndex(this.activePointerId);
        if (r104 != (-1)) goto L17;
        return false;
    L17:
        int r105 = (int) r112.getY(r104);
        int r106 = this.lastMotionY - r105;
        if (this.isBeingDragged == true) goto L25;
        int r107 = Math.abs(r106);
        int r108 = this.touchSlop;
        if (r107 <= r108) goto L25;
        this.isBeingDragged = true;
        if (r106 <= 0) goto L24;
        r106 = r106 - r108;
        goto L25
    L24:
        r106 = r106 + r108;
    L25:
        int r109 = r106;
        if (this.isBeingDragged == false) goto L39;
        this.lastMotionY = r105;
        scroll(r110, r111, r109, getMaxDragOffset(r111), 0);
        goto L39
    L12:
        if (r100 == 3) goto L31;
        goto L31
    }

    public int setHeaderTopBottomOffset(CoordinatorLayout r100, V r101, int r102) {
        return setHeaderTopBottomOffset(r100, r101, r102, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public final boolean fling(CoordinatorLayout r110, V r111, int r112, int r113, float r114) {
        Runnable r100 = this.flingRunnable;
        if (r100 == null) goto L6;
        r111.removeCallbacks(r100);
        this.flingRunnable = null;
    L6:
        if (this.scroller != null) goto L8;
        this.scroller = new OverScroller(r111.getContext());
    L8:
        this.scroller.fling(0, getTopAndBottomOffset(), 0, Math.round(r114), 0, 0, r112, r113);
        if (this.scroller.computeScrollOffset() == false) goto L12;
        FlingRunnable r101 = new FlingRunnable(this, r110, r111);
        this.flingRunnable = r101;
        ViewCompat.postOnAnimation(r111, r101);
        return true;
    L12:
        onFlingFinished(r110, r111);
        return false;
    }

    public final int scroll(CoordinatorLayout r100, V r101, int r110, int r111, int r112) {
        return setHeaderTopBottomOffset(r100, r101, getTopBottomOffsetForScrollingSibling() - r110, r111, r112);
    }

    public int setHeaderTopBottomOffset(CoordinatorLayout r100, V r101, int r102, int r103, int r104) {
        int r105 = getTopAndBottomOffset();
        if (r103 == 0) goto L9;
        if (r105 < r103) goto L9;
        if (r105 > r104) goto L9;
        int r106 = MathUtils.clamp(r102, r103, r104);
        if (r105 == r106) goto L9;
        setTopAndBottomOffset(r106);
        return r105 - r106;
    L9:
        return 0;
    }
}
