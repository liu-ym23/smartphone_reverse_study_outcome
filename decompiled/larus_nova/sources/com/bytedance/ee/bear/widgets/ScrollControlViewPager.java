package com.bytedance.ee.bear.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.bytedance.ee.bear.widgets.viewpager.FixPageTransformerViewPager;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class ScrollControlViewPager extends FixPageTransformerViewPager {
    public boolean V0;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public int f240125b1;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public Drawable f240126g1;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public int f240127h1;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public boolean f240128k1;

    public ScrollControlViewPager(Context r100) {
        this(r100, null);
        B(r100, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        super.dispatchDraw(r100);
        if (this.V0 == false) goto L6;
        this.f240126g1.setBounds(0, 0, getWidth() * this.f240127h1, this.f240125b1);
        this.f240126g1.draw(r100);
        return;
    }

    @Override // com.bytedance.ee.bear.widgets.viewpager.FixPageTransformerViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f240128k1 == true) goto L7;
        return false;
    L7:
        return super.onInterceptTouchEvent(r100);
    }

    @Override // com.bytedance.ee.bear.widgets.viewpager.FixPageTransformerViewPager, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f240128k1 == true) goto L7;
        return false;
    L7:
        return super.onTouchEvent(r100);
    }

    public void setCanScroll(boolean r100) {
        this.f240128k1 = r100;
    }

    @Override // com.bytedance.ee.bear.widgets.viewpager.FixPageTransformerViewPager
    public void setCurrentItem(int r100) {
        w(r100, false);
    }

    public ScrollControlViewPager(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.V0 = false;
        this.f240125b1 = 4;
        this.f240127h1 = 0;
        this.f240128k1 = true;
        B(r100, r101);
    }

    public final void B(Context r100, AttributeSet r101) {
        if (r101 != null) goto L6;
        this.V0 = false;
        return;
    L6:
        int r102 = com.bytedance.ee.util.ui.n.d(4);
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.shadow_drawable, R.attr.shadow_height, R.attr.shadow_page_size, R.attr.show_shadow});
        this.V0 = r103.getBoolean(3, false);
        this.f240126g1 = r103.getDrawable(0);
        this.f240125b1 = r103.getDimensionPixelSize(1, r102);
        this.f240127h1 = r103.getInteger(2, 1);
        r103.recycle();
    }
}
