package com.larksuite.framework.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: classes24.dex */
public class ViewPagerWithoutScroll extends ViewPager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f285832a;

    public ViewPagerWithoutScroll(Context r100) {
        super(r100);
        this.f285832a = false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f285832a == true) goto L5;
    L7:
        return false;
    L5:
        if (super.onInterceptTouchEvent(r100) == false) goto L7;
        return true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f285832a == true) goto L5;
    L7:
        return false;
    L5:
        if (super.onTouchEvent(r100) == false) goto L7;
        return true;
    }

    public void setPagingEnabled(boolean r100) {
        this.f285832a = r100;
    }

    public ViewPagerWithoutScroll(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f285832a = false;
    }
}
