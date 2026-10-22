package com.bytedance.ee.bear.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SwipeControlViewPager extends ViewPager {
    public boolean a;

    public SwipeControlViewPager(Context r1) {
        super(r1);
        this.a = false;
    }

    public final boolean onInterceptTouchEvent(MotionEvent r2) {
        if (this.a == false) goto L7;
        return false;
    L7:
        return super.onInterceptTouchEvent(r2);
    }

    public SwipeControlViewPager(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.a = false;
    }
}
