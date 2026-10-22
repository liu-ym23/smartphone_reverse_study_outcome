package com.bytedance.ee.bear.widgets.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes18.dex */
public class ReboundRecyclerView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OverScroller f240411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public VelocityTracker f240412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f240413c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f240414d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f240415e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f240416f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f240417g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RecyclerView f240418h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f240419i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f240420j;

    private int getYVelocity() {
        VelocityTracker r100 = this.f240412b;
        if (r100 == null) goto L6;
        r100.computeCurrentVelocity(600, this.f240414d);
        return (int) this.f240412b.getYVelocity();
    L6:
        return 0;
    }

    @Override // android.view.View
    public final void computeScroll() {
        if (this.f240411a.computeScrollOffset() == false) goto L6;
        scrollTo(this.f240411a.getCurrX(), this.f240411a.getCurrY());
        invalidate();
        return;
    }

    public int getMaxReboundAnimDuration() {
        return this.f240416f;
    }

    public RecyclerView getRecyclerView() {
        return this.f240418h;
    }

    public float getScrollRatio() {
        return this.f240417g;
    }

    public ReboundRecyclerView(Context r100) {
        super(r100);
        this.f240416f = 300;
        this.f240417g = 0.55f;
        this.f240420j = false;
        a(r100);
    }

    public final void a(Context r100) {
        this.f240411a = new OverScroller(r100);
        ViewConfiguration r101 = ViewConfiguration.get(r100);
        this.f240413c = r101.getScaledMinimumFlingVelocity();
        this.f240414d = r101.getScaledMaximumFlingVelocity();
        this.f240415e = r101.getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        int r101 = r100.getAction();
        if (r101 == 0) goto L13;
        if (r101 != 1) goto L6;
        this.f240420j = false;
    L20:
        return super.onInterceptTouchEvent(r100);
    L6:
        if (r101 != 2) goto L20;
        float r102 = r100.getY();
        float r103 = this.f240419i - r102;
        this.f240419i = r102;
        if (Math.abs(r103) < this.f240415e) goto L20;
        return true;
    L13:
        if (this.f240420j == true) goto L16;
        this.f240420j = true;
    L16:
        if (this.f240411a.isFinished() == true) goto L18;
        this.f240411a.forceFinished(true);
    L18:
        this.f240418h.stopScroll();
        this.f240419i = r100.getY();
        goto L20
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        if (this.f240412b != null) goto L5;
        this.f240412b = VelocityTracker.obtain();
    L5:
        this.f240412b.addMovement(r110);
        int r100 = r110.getAction();
        if (r100 != 0) goto L8;
        this.f240419i = r110.getY();
    L46:
        return true;
    L8:
        if (r100 == 1) goto L30;
        if (r100 != 2) goto L46;
        float r111 = r110.getY();
        int r101 = (int) (this.f240419i - r111);
        this.f240419i = r111;
        int r112 = this.f240418h.computeVerticalScrollOffset();
        int r102 = (this.f240418h.computeVerticalScrollRange() - r112) - this.f240418h.getMeasuredHeight();
        int r103 = -getScrollY();
        if (r101 >= 0) goto L21;
        if (r103 >= 0) goto L17;
        int r104 = Math.max(r101, r103);
        scrollBy(0, (int) (r104 * this.f240417g));
        r101 = r101 - r104;
        if (r101 >= 0) goto L46;
    L17:
        int r113 = Math.max(r101, -r112);
        this.f240418h.scrollBy(0, r113);
        int r105 = r101 - r113;
        if (r105 >= 0) goto L46;
        scrollBy(0, (int) (r105 * this.f240417g));
        goto L46
    L21:
        if (r101 <= 0) goto L46;
        if (r103 <= 0) goto L26;
        int r114 = Math.min(r101, r103);
        scrollBy(0, (int) (r114 * this.f240417g));
        r101 = r101 - r114;
        if (r101 <= 0) goto L46;
    L26:
        int r115 = Math.min(r101, r102);
        this.f240418h.scrollBy(0, r115);
        int r106 = r101 - r115;
        if (r106 <= 0) goto L46;
        scrollBy(0, (int) (r106 * this.f240417g));
        goto L46
    L30:
        int r116 = getYVelocity();
        if (Math.abs(r116) <= this.f240413c) goto L39;
        int r107 = this.f240418h.computeVerticalScrollOffset();
        int r108 = (this.f240418h.computeVerticalScrollRange() - r107) - this.f240418h.getMeasuredHeight();
        if (r116 <= 0) goto L35;
        if (r107 <= 0) goto L35;
    L37:
        this.f240418h.fling(0, -r116);
    L35:
        if (r116 >= 0) goto L39;
        if (r108 > 0) goto L37;
    L39:
        if (getScrollY() == 0) goto L42;
        this.f240411a.startScroll(0, getScrollY(), 0, -getScrollY(), Math.min(Math.max(Math.abs(getScrollY()) * 2, 300), this.f240416f));
        invalidate();
    L42:
        VelocityTracker r117 = this.f240412b;
        if (r117 == null) goto L46;
        r117.recycle();
        this.f240412b = null;
        goto L46
    }

    public void setMaxReboundAnimDuration(int r100) {
        this.f240416f = r100;
    }

    public void setRecyclerView(RecyclerView r100) {
        this.f240418h = r100;
        r100.setVerticalScrollBarEnabled(false);
        this.f240418h.setNestedScrollingEnabled(false);
        addView(this.f240418h, new FrameLayout.LayoutParams(-1, -1));
    }

    public void setScrollRatio(float r100) {
        this.f240417g = r100;
    }

    public ReboundRecyclerView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f240416f = 300;
        this.f240417g = 0.55f;
        this.f240420j = false;
        a(r100);
    }

    public ReboundRecyclerView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f240416f = 300;
        this.f240417g = 0.55f;
        this.f240420j = false;
        a(r100);
    }
}
