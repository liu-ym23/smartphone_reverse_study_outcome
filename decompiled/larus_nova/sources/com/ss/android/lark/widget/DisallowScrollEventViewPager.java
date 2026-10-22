package com.ss.android.lark.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes38.dex */
public class DisallowScrollEventViewPager extends ViewPager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f445574a;

    public DisallowScrollEventViewPager(Context r100) {
        super(r100);
        this.f445574a = 0.0f;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        int r101 = r100.getAction();
        if (r101 != 0) goto L5;
        this.f445574a = r100.getX();
        getParent().requestDisallowInterceptTouchEvent(true);
    L29:
        return super.dispatchTouchEvent(r100);
    L26:
        e = move-exception;
        Log.e("DisallowScrollEventViewPager", "dispatchTouchEvent called. e:" + e);
        return false;
    L5:
        if (r101 != 2) goto L29;
        if (r100.getX() <= this.f445574a) goto L10;
        boolean r102 = true;
    L12:
        if (getAdapter() != null) goto L15;
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L29
    L15:
        if (getAdapter().getCount() != (getCurrentItem() + 1)) goto L19;
        if (r102 == true) goto L19;
        getParent().requestDisallowInterceptTouchEvent(false);
    L19:
        if (getCurrentItem() != 0) goto L22;
        if (r102 == false) goto L22;
        getParent().requestDisallowInterceptTouchEvent(false);
    L22:
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L29
    L10:
        r102 = false;
        goto L12
    }

    public DisallowScrollEventViewPager(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f445574a = 0.0f;
    }
}
