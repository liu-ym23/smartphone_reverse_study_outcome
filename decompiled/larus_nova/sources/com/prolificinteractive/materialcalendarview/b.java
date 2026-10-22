package com.prolificinteractive.materialcalendarview;

import android.content.Context;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: classes34.dex */
public final class b extends ViewPager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f404467a;

    public b(Context r100) {
        super(r100);
        this.f404467a = true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final boolean canScrollHorizontally(int r100) {
        if (this.f404467a == true) goto L5;
    L7:
        return false;
    L5:
        if (super.canScrollHorizontally(r100) == false) goto L7;
        return true;
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int r100) {
        if (this.f404467a == true) goto L5;
    L7:
        return false;
    L5:
        if (super.canScrollVertically(r100) == false) goto L7;
        return true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f404467a == true) goto L5;
    L7:
        return false;
    L5:
        if (super.onInterceptTouchEvent(r100) == false) goto L7;
        return true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f404467a == true) goto L5;
    L7:
        return false;
    L5:
        if (super.onTouchEvent(r100) == false) goto L7;
        return true;
    }
}
