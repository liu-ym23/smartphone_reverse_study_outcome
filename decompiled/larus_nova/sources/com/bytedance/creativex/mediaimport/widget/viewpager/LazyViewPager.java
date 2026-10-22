package com.bytedance.creativex.mediaimport.widget.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes15.dex */
public class LazyViewPager extends ViewPager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LazyPagerAdapter<?> f204224a;

    public LazyViewPager(Context r100) {
        super(r100);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        return super.onInterceptTouchEvent(r100);
    L8:
        e = move-exception;
        FLogger.f375446a.e("LazyViewPager", "onInterceptTouchEvent: IllegalArgumentException", e);
        return false;
    L5:
        e = move-exception;
        FLogger.f375446a.e("LazyViewPager", "onInterceptTouchEvent: Unexpected exception", e);
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        return super.onTouchEvent(r100);
    L8:
        e = move-exception;
        FLogger.f375446a.e("LazyViewPager", "onTouchEvent: IllegalArgumentException", e);
        return false;
    L5:
        e = move-exception;
        FLogger.f375446a.e("LazyViewPager", "onTouchEvent: Unexpected exception", e);
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setAdapter(PagerAdapter r100) {
        super.setAdapter(r100);
        if ((r100 instanceof LazyPagerAdapter) == false) goto L5;
        LazyPagerAdapter<?> r101 = (LazyPagerAdapter) r100;
    L6:
        this.f204224a = r101;
        return;
    L5:
        r101 = null;
        goto L6
    }

    public LazyViewPager(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public final void h(int r100, float r101) {
        if (r101 >= 0.1f) goto L5;
        return;
    L5:
        if (this.f204224a.f204222a.get(r100) == null) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == false) goto L12;
        this.f204224a.startUpdate(this);
        this.f204224a.f(this, r100);
        this.f204224a.finishUpdate(this);
        return;
    L12:
        return;
    L7:
        r102 = false;
        goto L8
    }

    @Override // androidx.viewpager.widget.ViewPager
    public final void onPageScrolled(int r100, float r101, int r102) {
        if (this.f204224a != null) goto L5;
    L10:
        super.onPageScrolled(r100, r101, r102);
        return;
    L5:
        if (getCurrentItem() != r100) goto L8;
        h(r100 + 1, r101);
        goto L10
    L8:
        if (getCurrentItem() <= r100) goto L10;
        h(r100, 1.0f - r101);
        goto L10
    }
}
