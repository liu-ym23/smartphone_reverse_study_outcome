package com.ss.android.lark.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes38.dex */
public class FixTouchBugViewPager extends ViewPager {
    public FixTouchBugViewPager(Context r100) {
        super(r100);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r100) {
        return super.onInterceptTouchEvent(r100);
    L4:
        e = move-exception;
        Log.e("FixTouchBugViewPager", e);
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        return super.onTouchEvent(r100);
    L4:
        e = move-exception;
        Log.e("FixTouchBugViewPager", e);
        return false;
    }

    public FixTouchBugViewPager(Context r100, AttributeSet r101) {
        super(r100, r101);
    }
}
