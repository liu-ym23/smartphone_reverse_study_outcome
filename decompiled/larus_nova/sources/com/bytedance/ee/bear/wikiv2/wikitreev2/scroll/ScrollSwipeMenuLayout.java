package com.bytedance.ee.bear.wikiv2.wikitreev2.scroll;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.HorizontalScrollView;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.SwipeMenuLayout;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class ScrollSwipeMenuLayout extends SwipeMenuLayout {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public HorizontalScrollView f241642u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public View f241643v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public a f241644w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f241645x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f241646y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f241647z;

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f241643v = findViewById(R.id.item_menu);
    }

    public ScrollSwipeMenuLayout(Context r100) {
        super(r100);
        this.f241647z = false;
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.recyclerview.SwipeMenuLayout
    public final boolean c(MotionEvent r100) {
        int r101 = a.f241670f;
        HorizontalScrollView r102 = a.C3461a.b(this);
        this.f241642u = r102;
        if (r102 == null) goto L12;
        if (this.f241644w == null) goto L12;
        if (r100.getX() >= ((this.f241644w.a(getContext(), this) - getScrollX()) + this.f241642u.getScrollX())) goto L9;
        return true;
    L9:
        return false;
    L12:
        return super.c(r100);
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.recyclerview.SwipeMenuLayout, android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        int r101 = r100.getAction();
        boolean r102 = false;
        if (r101 == 0) goto L10;
        if (r101 == 1) goto L9;
        if (r101 == 2) goto L10;
        if (r101 == 3) goto L9;
    L15:
        return super.dispatchTouchEvent(r100);
    L9:
        this.f241647z = false;
    L10:
        int r103 = r100.getPointerCount();
        int r104 = a.f241670f;
        if (r103 < 2) goto L13;
        r102 = true;
    L13:
        this.f241647z = r102;
        goto L15
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.recyclerview.SwipeMenuLayout, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        int r101 = r100.getPointerCount();
        int r102 = a.f241670f;
        if (r101 < 2) goto L7;
        return false;
    L7:
        return super.onInterceptTouchEvent(r100);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        int r101 = r100.getAction();
        boolean r102 = false;
        if (r101 == 0) goto L19;
        if (r101 == 1) goto L18;
        if (r101 != 2) goto L7;
        float r103 = r100.getX();
        if (Math.abs(r103 - this.f241645x) > Math.abs(r100.getY() - this.f241646y)) goto L12;
    L14:
        int r104 = r100.getPointerCount();
        int r105 = a.f241670f;
        if (r104 < 2) goto L17;
        r102 = true;
    L17:
        this.f241647z = r102;
    L24:
        return super.onTouchEvent(r100);
    L12:
        if (Math.abs(r103 - this.f241645x) <= ViewConfiguration.get(getContext()).getScaledTouchSlop()) goto L14;
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L14
    L7:
        if (r101 != 3) goto L24;
    L18:
        getParent().requestDisallowInterceptTouchEvent(false);
        this.f241645x = 0.0f;
        this.f241646y = 0.0f;
        this.f241647z = false;
        goto L24
    L19:
        this.f241645x = r100.getX();
        this.f241646y = r100.getY();
        int r106 = r100.getPointerCount();
        int r107 = a.f241670f;
        if (r106 < 2) goto L22;
        r102 = true;
    L22:
        this.f241647z = r102;
        goto L24
    }

    public void setScrollManager(a r100) {
        this.f241644w = r100;
    }

    public ScrollSwipeMenuLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f241647z = false;
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.recyclerview.SwipeMenuLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = getMeasuredWidth();
        int r103 = getMeasuredHeight();
        int r104 = a.f241670f;
        HorizontalScrollView r105 = a.C3461a.b(this);
        this.f241642u = r105;
        if (r105 == null) goto L5;
        int r106 = r105.getScrollX();
    L6:
        a r107 = this.f241644w;
        if (r107 != null) goto L9;
        int r108 = r102;
    L10:
        setMeasuredDimension(Math.max(r108, r102), r103);
        return;
    L9:
        r108 = r107.a(getContext(), this) + r106;
        goto L10
    L5:
        r106 = 0;
        goto L6
    }

    @Override // android.view.View
    public final void scrollTo(int r100, int r101) {
        if (this.f241647z == false) goto L5;
        return;
    L5:
        boolean r102 = true;
        boolean r103 = false;
        if (r100 > 0) goto L8;
        this.f241643v.setVisibility(4);
    L11:
        int r104 = a.f241670f;
        WikItemLeafView r105 = a.C3461a.a(this);
        if (r105 != null) goto L14;
    L16:
        r102 = r103;
    L17:
        super.scrollTo(r100, r101);
        if (r102 == false) goto L21;
        requestLayout();
        return;
    L21:
        return;
    L14:
        if (r105.f242239r == false) goto L16;
    L8:
        if (this.f241643v.getVisibility() == 0) goto L11;
        this.f241643v.setVisibility(0);
        r103 = true;
        goto L11
    }

    public ScrollSwipeMenuLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f241647z = false;
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.recyclerview.SwipeMenuLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r110) {
        int r104 = getChildCount();
        int r105 = getPaddingLeft();
        int r106 = 0;
    L3:
        if (r106 >= r104) goto L19;
        View r111 = getChildAt(r106);
        if (r111.getVisibility() == 8) goto L18;
        if (r106 != 0) goto L9;
        r111.layout(r105, getPaddingTop(), r111.getMeasuredWidth() + r105, getPaddingTop() + r111.getMeasuredHeight());
        int r112 = r111.getMeasuredWidth();
    L8:
        r105 = r105 + r112;
        goto L18
    L9:
        HorizontalScrollView r107 = this.f241642u;
        if (r107 == null) goto L12;
        int r108 = r107.getScrollX();
    L13:
        HorizontalScrollView r109 = this.f241642u;
        if (r109 == null) goto L16;
        int r113 = r109.getMeasuredWidth();
    L17:
        int r114 = r113 + r108;
        r111.layout(r114, getPaddingTop(), r111.getMeasuredWidth() + r114, getPaddingTop() + r111.getMeasuredHeight());
        r112 = r111.getMeasuredWidth();
        goto L8
    L16:
        r113 = 0;
        goto L17
    L12:
        r108 = 0;
    L18:
        r106 = r106 + 1;
        goto L3
    }
}
