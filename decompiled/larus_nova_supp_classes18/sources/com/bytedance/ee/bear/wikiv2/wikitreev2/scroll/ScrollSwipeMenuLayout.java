package com.bytedance.ee.bear.wikiv2.wikitreev2.scroll;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.HorizontalScrollView;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.SwipeMenuLayout;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ScrollSwipeMenuLayout extends SwipeMenuLayout {
    public HorizontalScrollView u;
    public View v;
    public a w;
    public float x;
    public float y;
    public boolean z;

    /* JADX WARN: Multi-variable type inference failed */
    public final void onFinishInflate() {
        super/*android.view.ViewGroup*/.onFinishInflate();
        this.v = findViewById(2131375803);
    }

    public ScrollSwipeMenuLayout(Context r1) {
        super(r1);
        this.z = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean c(MotionEvent r3) {
        int r0 = a.f;
        HorizontalScrollView r1 = a.C0214a.b(this);
        this.u = r1;
        if (r1 == null) goto L12;
        if (this.w == null) goto L12;
        if (r3.getX() >= ((this.w.a(getContext(), this) - getScrollX()) + this.u.getScrollX())) goto L9;
        return true;
    L9:
        return false;
    L12:
        return super.c(r3);
    }

    public final boolean dispatchTouchEvent(MotionEvent r6) {
        int r0 = r6.getAction();
        boolean r1 = false;
        if (r0 == 0) goto L10;
        if (r0 == 1) goto L9;
        if (r0 == 2) goto L10;
        if (r0 == 3) goto L9;
    L15:
        return super.dispatchTouchEvent(r6);
    L9:
        this.z = false;
    L10:
        int r2 = r6.getPointerCount();
        int r4 = a.f;
        if (r2 < 2) goto L13;
        r1 = true;
    L13:
        this.z = r1;
        goto L15
    }

    public final boolean onInterceptTouchEvent(MotionEvent r3) {
        int r0 = r3.getPointerCount();
        int r1 = a.f;
        if (r0 < 2) goto L7;
        return false;
    L7:
        return super.onInterceptTouchEvent(r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTouchEvent(MotionEvent r8) {
        int r0 = r8.getAction();
        boolean r2 = false;
        if (r0 == 0) goto L19;
        if (r0 == 1) goto L18;
        if (r0 != 2) goto L7;
        float r1 = r8.getX();
        if (Math.abs(r1 - this.x) > Math.abs(r8.getY() - this.y)) goto L12;
    L14:
        int r3 = r8.getPointerCount();
        int r4 = a.f;
        if (r3 < 2) goto L17;
        r2 = true;
    L17:
        this.z = r2;
    L24:
        return super/*android.view.ViewGroup*/.onTouchEvent(r8);
    L12:
        if (Math.abs(r1 - this.x) <= ViewConfiguration.get(getContext()).getScaledTouchSlop()) goto L14;
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L14
    L7:
        if (r0 != 3) goto L24;
    L18:
        getParent().requestDisallowInterceptTouchEvent(false);
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = false;
        goto L24
    L19:
        this.x = r8.getX();
        this.y = r8.getY();
        int r5 = r8.getPointerCount();
        int r6 = a.f;
        if (r5 < 2) goto L22;
        r2 = true;
    L22:
        this.z = r2;
        goto L24
    }

    public void setScrollManager(a r1) {
        this.w = r1;
    }

    public ScrollSwipeMenuLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.z = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r4, int r5) {
        super.onMeasure(r4, r5);
        int r6 = getMeasuredWidth();
        int r7 = getMeasuredHeight();
        int r0 = a.f;
        HorizontalScrollView r1 = a.C0214a.b(this);
        this.u = r1;
        if (r1 == null) goto L5;
        int r2 = r1.getScrollX();
    L6:
        a r3 = this.w;
        if (r3 != null) goto L9;
        int r8 = r6;
    L10:
        setMeasuredDimension(Math.max(r8, r6), r7);
        return;
    L9:
        r8 = r3.a(getContext(), this) + r2;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void scrollTo(int r5, int r6) {
        if (this.z == false) goto L5;
        return;
    L5:
        boolean r0 = true;
        boolean r1 = false;
        if (r5 > 0) goto L8;
        this.v.setVisibility(4);
    L11:
        int r2 = a.f;
        WikItemLeafView r3 = a.C0214a.a(this);
        if (r3 != null) goto L14;
    L16:
        r0 = r1;
    L17:
        super/*android.view.ViewGroup*/.scrollTo(r5, r6);
        if (r0 == false) goto L21;
        requestLayout();
        return;
    L21:
        return;
    L14:
        if (r3.r == false) goto L16;
    L8:
        if (this.v.getVisibility() == 0) goto L11;
        this.v.setVisibility(0);
        r1 = true;
        goto L11
    }

    public ScrollSwipeMenuLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.z = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onLayout(boolean r6, int r7, int r8, int r9, int r10) {
        int r11 = getChildCount();
        int r12 = getPaddingLeft();
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L19;
        View r14 = getChildAt(r13);
        if (r14.getVisibility() == 8) goto L18;
        if (r13 != 0) goto L9;
        r14.layout(r12, getPaddingTop(), r14.getMeasuredWidth() + r12, getPaddingTop() + r14.getMeasuredHeight());
        int r15 = r14.getMeasuredWidth();
    L8:
        r12 = r12 + r15;
        goto L18
    L9:
        HorizontalScrollView r0 = this.u;
        if (r0 == null) goto L12;
        int r1 = r0.getScrollX();
    L13:
        HorizontalScrollView r2 = this.u;
        if (r2 == null) goto L16;
        int r3 = r2.getMeasuredWidth();
    L17:
        int r4 = r3 + r1;
        r14.layout(r4, getPaddingTop(), r14.getMeasuredWidth() + r4, getPaddingTop() + r14.getMeasuredHeight());
        r15 = r14.getMeasuredWidth();
        goto L8
    L16:
        r3 = 0;
        goto L17
    L12:
        r1 = 0;
    L18:
        r13 = r13 + 1;
        goto L3
    }
}
