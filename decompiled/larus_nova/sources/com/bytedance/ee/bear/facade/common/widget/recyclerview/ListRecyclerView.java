package com.bytedance.ee.bear.facade.common.widget.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import com.bytedance.ee.bear.appsetting.c;
import com.bytedance.ee.bear.widgets.BaseRecyclerView;
import tt5.a;

/* JADX INFO: loaded from: classes16.dex */
public class ListRecyclerView extends BaseRecyclerView {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f226664l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public VelocityTracker f226665m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f226666n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f226667o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f226668p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f226669q;

    public final void u() {
        this.f226666n = c.a.f206237a.g("ccm.mobile.slide_rollback_fix_enable");
        a.h("ListRecyclerView", "fixSlideRollback: " + this.f226666n);
    }

    public ListRecyclerView(Context r100) {
        super(r100);
        this.f226666n = false;
        this.f226667o = false;
        u();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f226666n == false) goto L6;
        boolean r101 = super.onInterceptTouchEvent(r100);
        this.f226664l = r100.getRawY();
        return r101;
    L6:
        int r102 = r100.getAction();
        if (r102 == 0) goto L23;
        if (r102 != 2) goto L28;
        if (this.f226667o == false) goto L28;
        int r103 = (int) (r100.getRawX() + 0.5f);
        int r104 = (int) (r100.getRawY() + 0.5f);
        int r105 = this.f226668p - r103;
        int r106 = this.f226669q - r104;
        boolean r107 = getLayoutManager().canScrollHorizontally();
        boolean r108 = getLayoutManager().canScrollVertically();
        if (r107 == true) goto L15;
    L17:
        if (r108 == true) goto L19;
    L21:
        return false;
    L19:
        if (Math.abs(r106) <= 30) goto L21;
    L15:
        if (Math.abs(r105) <= 30) goto L17;
    L28:
        return super.onInterceptTouchEvent(r100);
    L23:
        if (2 != getScrollState()) goto L26;
        getParent().requestDisallowInterceptTouchEvent(true);
        stopScroll();
        this.f226667o = true;
        this.f226668p = (int) (r100.getRawX() + 0.5f);
        this.f226669q = (int) (r100.getRawY() + 0.5f);
        return false;
    L26:
        this.f226667o = false;
        goto L28
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f226666n == false) goto L45;
        if (getScrollState() != 2) goto L7;
        boolean r101 = true;
    L8:
        int r102 = r100.getAction();
        if (r102 != 0) goto L11;
        if (r101 == false) goto L43;
        getParent().requestDisallowInterceptTouchEvent(true);
        VelocityTracker r103 = this.f226665m;
        if (r103 != null) goto L39;
        this.f226665m = VelocityTracker.obtain();
    L40:
        this.f226665m.addMovement(r100);
        this.f226664l = r100.getRawY();
        return true;
    L39:
        r103.clear();
    L43:
        return super.onTouchEvent(r100);
    L11:
        if (r102 == 1) goto L28;
        if (r102 != 2) goto L14;
        if (r101 == true) goto L24;
        if (this.f226665m == null) goto L43;
    L24:
        if (this.f226665m != null) goto L26;
        this.f226665m = VelocityTracker.obtain();
    L26:
        this.f226665m.addMovement(r100);
        scrollBy(0, (int) (this.f226664l - r100.getRawY()));
        this.f226664l = r100.getRawY();
        getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    L14:
        if (r102 != 3) goto L43;
        VelocityTracker r104 = this.f226665m;
        if (r104 == null) goto L43;
        r104.recycle();
        this.f226665m = null;
        getParent().requestDisallowInterceptTouchEvent(false);
        return true;
    L28:
        VelocityTracker r105 = this.f226665m;
        if (r105 == null) goto L43;
        r105.computeCurrentVelocity(1000);
        float r106 = this.f226665m.getYVelocity();
        this.f226665m.recycle();
        this.f226665m = null;
        if (Math.abs(r106) <= 300.0f) goto L33;
        fling(0, (int) (-r106));
    L33:
        getParent().requestDisallowInterceptTouchEvent(false);
        return true;
    L7:
        r101 = false;
        goto L8
    L45:
        return super.onTouchEvent(r100);
    }

    public ListRecyclerView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f226666n = false;
        this.f226667o = false;
        u();
    }

    public ListRecyclerView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f226666n = false;
        this.f226667o = false;
        u();
    }
}
