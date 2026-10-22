package com.bytedance.ee.bear.list.homepage.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class HomeViewPager extends ViewPager {
    public final boolean onInterceptTouchEvent(MotionEvent r1) {
        return false;
    }

    public final boolean onTouchEvent(MotionEvent r1) {
        return false;
    }

    public HomeViewPager(Context r1) {
        super(r1);
    }

    public HomeViewPager(Context r1, AttributeSet r2) {
        super(r1, r2);
    }
}
