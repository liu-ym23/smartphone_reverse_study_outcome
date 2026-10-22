package com.bytedance.ies.uikit.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes19.dex */
public class SwipeControlledViewPager extends SSViewPager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f249248a;

    public SwipeControlledViewPager(Context r100) {
        super(r100);
        this.f249248a = true;
    }

    @Override // com.bytedance.ies.uikit.viewpager.SSViewPager, androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f249248a == true) goto L5;
        return false;
    L5:
        return super.onInterceptTouchEvent(r100);
    }

    @Override // com.bytedance.ies.uikit.viewpager.SSViewPager, androidx.viewpager.widget.ViewPager, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f249248a == true) goto L5;
        return false;
    L5:
        return super.onTouchEvent(r100);
    }

    public void setSwipeEnabled(boolean r100) {
        this.f249248a = r100;
    }

    public SwipeControlledViewPager(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f249248a = true;
    }
}
