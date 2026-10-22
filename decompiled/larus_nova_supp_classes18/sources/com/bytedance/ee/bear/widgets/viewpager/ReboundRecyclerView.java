package com.bytedance.ee.bear.widgets.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ReboundRecyclerView extends FrameLayout {
    public OverScroller a;
    public VelocityTracker b;
    public int c;
    public int d;
    public int e;
    public int f;
    public float g;
    public RecyclerView h;
    public float i;
    public boolean j;

    private int getYVelocity() {
        VelocityTracker r0 = this.b;
        if (r0 == null) goto L6;
        r0.computeCurrentVelocity(600, this.d);
        return (int) this.b.getYVelocity();
    L6:
        return 0;
    }

    @Override // android.view.View
    public final void computeScroll() {
        if (this.a.computeScrollOffset() == false) goto L6;
        scrollTo(this.a.getCurrX(), this.a.getCurrY());
        invalidate();
        return;
    }

    public int getMaxReboundAnimDuration() {
        return this.f;
    }

    public RecyclerView getRecyclerView() {
        return this.h;
    }

    public float getScrollRatio() {
        return this.g;
    }

    public ReboundRecyclerView(Context r2) {
        super(r2);
        this.f = 300;
        this.g = 0.55f;
        this.j = false;
        a(r2);
    }

    public final void a(Context r2) {
        this.a = new OverScroller(r2);
        ViewConfiguration r3 = ViewConfiguration.get(r2);
        this.c = r3.getScaledMinimumFlingVelocity();
        this.d = r3.getScaledMaximumFlingVelocity();
        this.e = r3.getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r4) {
        int r0 = r4.getAction();
        if (r0 == 0) goto L13;
        if (r0 != 1) goto L6;
        this.j = false;
    L20:
        return super.onInterceptTouchEvent(r4);
    L6:
        if (r0 != 2) goto L20;
        float r1 = r4.getY();
        float r2 = this.i - r1;
        this.i = r1;
        if (Math.abs(r2) < this.e) goto L20;
        return true;
    L13:
        if (this.j == true) goto L16;
        this.j = true;
    L16:
        if (this.a.isFinished() == true) goto L18;
        this.a.forceFinished(true);
    L18:
        this.h.stopScroll();
        this.i = r4.getY();
        goto L20
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r11) {
        if (this.b != null) goto L5;
        this.b = VelocityTracker.obtain();
    L5:
        this.b.addMovement(r11);
        int r0 = r11.getAction();
        if (r0 != 0) goto L8;
        this.i = r11.getY();
    L46:
        return true;
    L8:
        if (r0 == 1) goto L30;
        if (r0 != 2) goto L46;
        float r12 = r11.getY();
        int r1 = (int) (this.i - r12);
        this.i = r12;
        int r13 = this.h.computeVerticalScrollOffset();
        int r3 = (this.h.computeVerticalScrollRange() - r13) - this.h.getMeasuredHeight();
        int r4 = -getScrollY();
        if (r1 >= 0) goto L21;
        if (r4 >= 0) goto L17;
        int r5 = Math.max(r1, r4);
        scrollBy(0, (int) (r5 * this.g));
        r1 = r1 - r5;
        if (r1 >= 0) goto L46;
    L17:
        int r14 = Math.max(r1, -r13);
        this.h.scrollBy(0, r14);
        int r2 = r1 - r14;
        if (r2 >= 0) goto L46;
        scrollBy(0, (int) (r2 * this.g));
        goto L46
    L21:
        if (r1 <= 0) goto L46;
        if (r4 <= 0) goto L26;
        int r15 = Math.min(r1, r4);
        scrollBy(0, (int) (r15 * this.g));
        r1 = r1 - r15;
        if (r1 <= 0) goto L46;
    L26:
        int r16 = Math.min(r1, r3);
        this.h.scrollBy(0, r16);
        int r6 = r1 - r16;
        if (r6 <= 0) goto L46;
        scrollBy(0, (int) (r6 * this.g));
        goto L46
    L30:
        int r17 = getYVelocity();
        if (Math.abs(r17) <= this.c) goto L39;
        int r7 = this.h.computeVerticalScrollOffset();
        int r8 = (this.h.computeVerticalScrollRange() - r7) - this.h.getMeasuredHeight();
        if (r17 <= 0) goto L35;
        if (r7 <= 0) goto L35;
    L37:
        this.h.fling(0, -r17);
    L35:
        if (r17 >= 0) goto L39;
        if (r8 > 0) goto L37;
    L39:
        if (getScrollY() == 0) goto L42;
        this.a.startScroll(0, getScrollY(), 0, -getScrollY(), Math.min(Math.max(Math.abs(getScrollY()) * 2, 300), this.f));
        invalidate();
    L42:
        VelocityTracker r18 = this.b;
        if (r18 == null) goto L46;
        r18.recycle();
        this.b = null;
        goto L46
    }

    public void setMaxReboundAnimDuration(int r1) {
        this.f = r1;
    }

    public void setRecyclerView(RecyclerView r3) {
        this.h = r3;
        r3.setVerticalScrollBarEnabled(false);
        this.h.setNestedScrollingEnabled(false);
        addView(this.h, new FrameLayout.LayoutParams(-1, -1));
    }

    public void setScrollRatio(float r1) {
        this.g = r1;
    }

    public ReboundRecyclerView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.f = 300;
        this.g = 0.55f;
        this.j = false;
        a(r1);
    }

    public ReboundRecyclerView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.f = 300;
        this.g = 0.55f;
        this.j = false;
        a(r1);
    }
}
