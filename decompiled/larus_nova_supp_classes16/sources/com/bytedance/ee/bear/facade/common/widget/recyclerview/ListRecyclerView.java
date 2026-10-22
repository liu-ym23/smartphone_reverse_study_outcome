package com.bytedance.ee.bear.facade.common.widget.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import com.bytedance.ee.bear.appsetting.c;
import com.bytedance.ee.bear.document.offline.file.upload.UploadResult;
import com.bytedance.ee.bear.widgets.BaseRecyclerView;
import tt5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ListRecyclerView extends BaseRecyclerView {
    public float l;
    public VelocityTracker m;
    public boolean n;
    public boolean o;
    public int p;
    public int q;

    public final void u() {
        this.n = c.a.a.g("ccm.mobile.slide_rollback_fix_enable");
        a.h("ListRecyclerView", "fixSlideRollback: " + this.n);
    }

    public ListRecyclerView(Context r1) {
        super(r1);
        this.n = false;
        this.o = false;
        u();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onInterceptTouchEvent(MotionEvent r7) {
        if (this.n == false) goto L6;
        boolean r0 = super/*androidx.recyclerview.widget.RecyclerView*/.onInterceptTouchEvent(r7);
        this.l = r7.getRawY();
        return r0;
    L6:
        int r1 = r7.getAction();
        if (r1 == 0) goto L23;
        if (r1 != 2) goto L28;
        if (this.o == false) goto L28;
        int r2 = (int) (r7.getRawX() + 0.5f);
        int r3 = (int) (r7.getRawY() + 0.5f);
        int r4 = this.p - r2;
        int r5 = this.q - r3;
        boolean r6 = getLayoutManager().canScrollHorizontally();
        boolean r8 = getLayoutManager().canScrollVertically();
        if (r6 == true) goto L15;
    L17:
        if (r8 == true) goto L19;
    L21:
        return false;
    L19:
        if (Math.abs(r5) <= 30) goto L21;
    L15:
        if (Math.abs(r4) <= 30) goto L17;
    L28:
        return super/*androidx.recyclerview.widget.RecyclerView*/.onInterceptTouchEvent(r7);
    L23:
        if (2 != getScrollState()) goto L26;
        getParent().requestDisallowInterceptTouchEvent(true);
        stopScroll();
        this.o = true;
        this.p = (int) (r7.getRawX() + 0.5f);
        this.q = (int) (r7.getRawY() + 0.5f);
        return false;
    L26:
        this.o = false;
        goto L28
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTouchEvent(MotionEvent r7) {
        if (this.n == false) goto L45;
        if (getScrollState() != 2) goto L7;
        boolean r0 = true;
    L8:
        int r4 = r7.getAction();
        if (r4 != 0) goto L11;
        if (r0 == false) goto L43;
        getParent().requestDisallowInterceptTouchEvent(true);
        VelocityTracker r1 = this.m;
        if (r1 != null) goto L39;
        this.m = VelocityTracker.obtain();
    L40:
        this.m.addMovement(r7);
        this.l = r7.getRawY();
        return true;
    L39:
        r1.clear();
    L43:
        return super/*androidx.recyclerview.widget.RecyclerView*/.onTouchEvent(r7);
    L11:
        if (r4 == 1) goto L28;
        if (r4 != 2) goto L14;
        if (r0 == true) goto L24;
        if (this.m == null) goto L43;
    L24:
        if (this.m != null) goto L26;
        this.m = VelocityTracker.obtain();
    L26:
        this.m.addMovement(r7);
        scrollBy(0, (int) (this.l - r7.getRawY()));
        this.l = r7.getRawY();
        getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    L14:
        if (r4 != 3) goto L43;
        VelocityTracker r2 = this.m;
        if (r2 == null) goto L43;
        r2.recycle();
        this.m = null;
        getParent().requestDisallowInterceptTouchEvent(false);
        return true;
    L28:
        VelocityTracker r3 = this.m;
        if (r3 == null) goto L43;
        r3.computeCurrentVelocity(UploadResult.UPLOAD_CACELL);
        float r8 = this.m.getYVelocity();
        this.m.recycle();
        this.m = null;
        if (Math.abs(r8) <= 300.0f) goto L33;
        fling(0, (int) (-r8));
    L33:
        getParent().requestDisallowInterceptTouchEvent(false);
        return true;
    L7:
        r0 = false;
        goto L8
    L45:
        return super/*androidx.recyclerview.widget.RecyclerView*/.onTouchEvent(r7);
    }

    public ListRecyclerView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.n = false;
        this.o = false;
        u();
    }

    public ListRecyclerView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.n = false;
        this.o = false;
        u();
    }
}
