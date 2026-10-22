package com.obric.oui.titlebar.behavior;

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

/* JADX INFO: loaded from: classes34.dex */
public abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f403503c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public OverScroller f403504d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f403505e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f403506f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f403507g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f403508h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public VelocityTracker f403509i;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CoordinatorLayout f403510a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final V f403511b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ HeaderBehavior f403512c;

        public final void a() {
            V r100 = this.f403511b;
            if (r100 != null) goto L5;
            return;
        L5:
            if (this.f403512c.f403504d == null) goto L12;
            r100.getClass();
            this.f403512c.f403504d.getCurrY();
            if (this.f403512c.f403504d.computeScrollOffset() == false) goto L9;
            HeaderBehavior r101 = this.f403512c;
            r101.setHeaderTopBottomOffset(this.f403510a, this.f403511b, r101.f403504d.getCurrY());
            ViewCompat.postOnAnimation(this.f403511b, this);
            return;
        L9:
            this.f403512c.onFlingFinished(this.f403510a, this.f403511b);
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(HeaderBehavior r100, CoordinatorLayout r101, V r102) {
            this.f403512c = r100;
            this.f403510a = r101;
            this.f403511b = r102;
        }
    }

    public boolean canDragView(V r100) {
        return false;
    }

    public void onFlingFinished(CoordinatorLayout r100, V r101) {
    }

    public final int getTopAndBottomOffset() {
        d r100 = this.f403517a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.f403532d;
    }

    public int getTopBottomOffsetForScrollingSibling() {
        d r100 = this.f403517a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.f403532d;
    }

    public HeaderBehavior() {
        this.f403506f = -1;
        this.f403508h = -1;
    }

    public int getMaxDragOffset(V r100) {
        return -r100.getHeight();
    }

    public int getScrollRangeForDragFling(V r100) {
        return r100.getHeight();
    }

    public HeaderBehavior(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f403506f = -1;
        this.f403508h = -1;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onInterceptTouchEvent(CoordinatorLayout r100, V r101, MotionEvent r102) {
        if (this.f403508h >= 0) goto L6;
        this.f403508h = ViewConfiguration.get(r100.getContext()).getScaledTouchSlop();
    L6:
        if (r102.getActionMasked() != 2) goto L20;
        if (this.f403505e == false) goto L20;
        int r103 = this.f403506f;
        if (r103 != (-1)) goto L12;
        return false;
    L12:
        int r104 = r102.findPointerIndex(r103);
        if (r104 != (-1)) goto L15;
        return false;
    L15:
        int r105 = (int) r102.getY(r104);
        if (Math.abs(r105 - this.f403507g) <= this.f403508h) goto L20;
        this.f403507g = r105;
        return true;
    L20:
        if (r102.getActionMasked() != 0) goto L38;
        this.f403506f = -1;
        int r106 = (int) r102.getX();
        int r107 = (int) r102.getY();
        if (canDragView(r101) == true) goto L24;
    L26:
        boolean r108 = false;
    L27:
        this.f403505e = r108;
        if (r108 == false) goto L38;
        this.f403507g = r107;
        this.f403506f = r102.getPointerId(0);
        if (this.f403509i != null) goto L32;
        this.f403509i = VelocityTracker.obtain();
    L32:
        OverScroller r109 = this.f403504d;
        if (r109 == null) goto L38;
        if (r109.isFinished() == true) goto L38;
        this.f403504d.abortAnimation();
        return true;
    L24:
        if (r100.isPointInChildBounds(r101, r106, r107) == false) goto L26;
        r108 = true;
    L38:
        VelocityTracker r110 = this.f403509i;
        if (r110 == null) goto L41;
        r110.addMovement(r102);
    L41:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onTouchEvent(CoordinatorLayout r110, V r111, MotionEvent r112) {
        int r100 = r112.getActionMasked();
        if (r100 != 1) goto L5;
        VelocityTracker r101 = this.f403509i;
        if (r101 == null) goto L24;
        r101.addMovement(r112);
        this.f403509i.computeCurrentVelocity(1000);
        float r113 = this.f403509i.getYVelocity(this.f403506f);
        fling(r110, r111, -getScrollRangeForDragFling(r111), 0, r113);
        boolean r114 = true;
    L25:
        this.f403505e = false;
        this.f403506f = -1;
        VelocityTracker r115 = this.f403509i;
        if (r115 == null) goto L28;
        r115.recycle();
        this.f403509i = null;
    L28:
        VelocityTracker r116 = this.f403509i;
        if (r116 == null) goto L32;
        r116.addMovement(r112);
    L32:
        if (this.f403505e == true) goto L37;
        if (r114 == true) goto L38;
        return false;
    L38:
        return true;
    L37:
        return true;
    L24:
        r114 = false;
        goto L25
    L5:
        if (r100 != 2) goto L7;
        int r102 = r112.findPointerIndex(this.f403506f);
        if (r102 != (-1)) goto L19;
        return false;
    L19:
        int r103 = (int) r112.getY(r102);
        int r104 = this.f403507g - r103;
        this.f403507g = r103;
        scroll(r110, r111, r104, getMaxDragOffset(r111), 0);
    L20:
        r114 = false;
        goto L28
    L7:
        if (r100 == 3) goto L24;
        if (r100 != 6) goto L20;
        if (r112.getActionIndex() != 0) goto L14;
        int r117 = 1;
    L15:
        this.f403506f = r112.getPointerId(r117);
        this.f403507g = (int) (r112.getY(r117) + 0.5f);
        goto L20
    L14:
        r117 = 0;
        goto L15
    }

    public final int setHeaderTopBottomOffset(CoordinatorLayout r100, V r101, int r102) {
        return setHeaderTopBottomOffset(r100, r101, r102, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean fling(CoordinatorLayout r110, V r111, int r112, int r113, float r114) {
        a r100 = this.f403503c;
        if (r100 == null) goto L6;
        r111.removeCallbacks(r100);
        this.f403503c = null;
    L6:
        if (this.f403504d != null) goto L8;
        this.f403504d = new OverScroller(r111.getContext());
    L8:
        OverScroller r101 = this.f403504d;
        d r102 = this.f403517a;
        if (r102 == null) goto L11;
        int r103 = r102.f403532d;
    L12:
        r101.fling(0, r103, 0, Math.round(r114), 0, 0, r112, r113);
        if (this.f403504d.computeScrollOffset() == false) goto L16;
        a r104 = new a(this, r110, r111);
        this.f403503c = r104;
        ViewCompat.postOnAnimation(r111, r104);
        return true;
    L16:
        onFlingFinished(r110, r111);
        return false;
    L11:
        r103 = 0;
        goto L12
    }

    public final int scroll(CoordinatorLayout r100, V r101, int r110, int r111, int r112) {
        return setHeaderTopBottomOffset(r100, r101, getTopBottomOffsetForScrollingSibling() - r110, r111, r112);
    }

    public int setHeaderTopBottomOffset(CoordinatorLayout r100, V r101, int r102, int r103, int r104) {
        d r105 = this.f403517a;
        if (r105 == null) goto L5;
        int r106 = r105.f403532d;
    L6:
        if (r103 == 0) goto L19;
        if (r106 < r103) goto L20;
        if (r106 > r104) goto L21;
        int r107 = MathUtils.clamp(r102, r103, r104);
        if (r106 == r107) goto L22;
        d r108 = this.f403517a;
        if (r108 != null) goto L14;
        this.f403518b = r107;
    L18:
        return r106 - r107;
    L14:
        if (r108.f403532d == r107) goto L18;
        r108.f403532d = r107;
        r108.a();
        goto L18
    L22:
        return 0;
    L21:
        return 0;
    L20:
        return 0;
    L19:
        return 0;
    L5:
        r106 = 0;
        goto L6
    }
}
