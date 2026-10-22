package com.bytedance.ee.bear.widgets.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.bytedance.ee.bear.widgets.viewpager.viewpager2.widget.ViewPager2;
import op5.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class VerticalViewPager extends ViewPager2 {
    public int a;
    public int b;

    public int getBaseScrollX() {
        return this.a;
    }

    public VerticalViewPager(Context r1) {
        super(r1);
        registerOnPageChangeCallback(new e(this));
        setOverScrollMode(0);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r1) {
        return super.onInterceptTouchEvent(r1);
    }

    public void setBaseScrollX(int r1) {
        this.a = r1;
    }

    public VerticalViewPager(Context r1, AttributeSet r2) {
        super(r1, r2);
        registerOnPageChangeCallback(new e(this));
        setOverScrollMode(0);
    }

    @Override // android.view.View
    public final void onScrollChanged(int r3, int r4, int r5, int r6) {
        super.onScrollChanged(r3, r4, r5, r6);
        tt5.a.b("VerticalViewPager", "onScrollChanged " + r3 + "," + r4 + "," + r5 + "," + r6);
        if (this.b != 0) goto L6;
        this.a = getScrollX();
        return;
    }
}
