package com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes14.dex */
public class UserProfileViewPager extends RtlViewPager {
    public boolean H1;
    public float L1;
    public float M1;

    public UserProfileViewPager(Context r100) {
        super(r100);
        this.H1 = true;
        ViewConfiguration.get(r100).getScaledPagingTouchSlop();
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DmtViewPager, android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        if (this.H1 == true) goto L5;
    L8:
        return true;
    L5:
        if (super.dispatchTouchEvent(r100) == true) goto L8;
        return false;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.RtlViewPager, com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DmtViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        return super.onInterceptTouchEvent(r100);
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.RtlViewPager, com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DmtViewPager, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        boolean r101 = super.onTouchEvent(r100);
        int r102 = r100.getActionMasked();
        if (r102 != 0) goto L5;
        this.L1 = r100.getX();
        this.M1 = r100.getY();
    L10:
        float r103 = r100.getX();
        float r104 = r100.getY();
        Math.abs(r103 - this.L1);
        Math.abs(r104 - this.M1);
    L11:
        return r101;
    L5:
        if (r102 == 1) goto L10;
        if (r102 == 3) goto L10;
        goto L10
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.RtlViewPager
    public void setScrollable(boolean r100) {
        this.H1 = r100;
    }

    public UserProfileViewPager(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.H1 = true;
        ViewConfiguration.get(r100).getScaledPagingTouchSlop();
    }
}
