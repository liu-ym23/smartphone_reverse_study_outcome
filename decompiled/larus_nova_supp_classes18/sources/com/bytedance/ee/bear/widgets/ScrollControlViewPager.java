package com.bytedance.ee.bear.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.bytedance.ee.bear.widgets.viewpager.FixPageTransformerViewPager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ScrollControlViewPager extends FixPageTransformerViewPager {
    public boolean V0;
    public int b1;
    public Drawable g1;
    public int h1;
    public boolean k1;

    public ScrollControlViewPager(Context r2) {
        this(r2, null);
        B(r2, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r5) {
        super.dispatchDraw(r5);
        if (this.V0 == false) goto L6;
        this.g1.setBounds(0, 0, getWidth() * this.h1, this.b1);
        this.g1.draw(r5);
        return;
    }

    @Override // com.bytedance.ee.bear.widgets.viewpager.FixPageTransformerViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r2) {
        if (this.k1 == true) goto L7;
        return false;
    L7:
        return super.onInterceptTouchEvent(r2);
    }

    @Override // com.bytedance.ee.bear.widgets.viewpager.FixPageTransformerViewPager, android.view.View
    public final boolean onTouchEvent(MotionEvent r2) {
        if (this.k1 == true) goto L7;
        return false;
    L7:
        return super.onTouchEvent(r2);
    }

    public void setCanScroll(boolean r1) {
        this.k1 = r1;
    }

    @Override // com.bytedance.ee.bear.widgets.viewpager.FixPageTransformerViewPager
    public void setCurrentItem(int r2) {
        w(r2, false);
    }

    public ScrollControlViewPager(Context r3, AttributeSet r4) {
        super(r3, r4);
        this.V0 = false;
        this.b1 = 4;
        this.h1 = 0;
        this.k1 = true;
        B(r3, r4);
    }

    public final void B(Context r4, AttributeSet r5) {
        if (r5 != null) goto L6;
        this.V0 = false;
        return;
    L6:
        int r2 = com.bytedance.ee.util.ui.n.d(4);
        TypedArray r6 = r4.obtainStyledAttributes(r5, new int[]{2130974033, 2130974034, 2130974036, 2130974084});
        this.V0 = r6.getBoolean(3, false);
        this.g1 = r6.getDrawable(0);
        this.b1 = r6.getDimensionPixelSize(1, r2);
        this.h1 = r6.getInteger(2, 1);
        r6.recycle();
    }
}
