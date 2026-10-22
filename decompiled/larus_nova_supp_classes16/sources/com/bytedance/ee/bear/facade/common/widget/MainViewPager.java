package com.bytedance.ee.bear.facade.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class MainViewPager extends ViewPager {
    public boolean a;

    public MainViewPager(Context r2) {
        this(r2, null);
    }

    public final boolean onInterceptTouchEvent(MotionEvent r2) {
        if (this.a == true) goto L7;
        return false;
    L7:
        return super.onInterceptTouchEvent(r2);
    }

    public final boolean onTouchEvent(MotionEvent r2) {
        if (this.a == true) goto L7;
        return false;
    L7:
        return super.onTouchEvent(r2);
    }

    public void setCanScroll(boolean r1) {
        this.a = r1;
    }

    public void setCurrentItem(int r2) {
        super.setCurrentItem(r2, false);
    }

    public MainViewPager(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.a = false;
    }
}
