package com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class UserProfileViewPager extends RtlViewPager {
    public boolean H1;
    public float L1;
    public float M1;

    public UserProfileViewPager(Context r2) {
        super(r2);
        this.H1 = true;
        ViewConfiguration.get(r2).getScaledPagingTouchSlop();
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DmtViewPager, android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r2) {
        if (this.H1 == true) goto L5;
    L8:
        return true;
    L5:
        if (super.dispatchTouchEvent(r2) == true) goto L8;
        return false;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.RtlViewPager, com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DmtViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r1) {
        return super.onInterceptTouchEvent(r1);
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.RtlViewPager, com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DmtViewPager, android.view.View
    public final boolean onTouchEvent(MotionEvent r4) {
        boolean r0 = super.onTouchEvent(r4);
        int r1 = r4.getActionMasked();
        if (r1 != 0) goto L5;
        this.L1 = r4.getX();
        this.M1 = r4.getY();
    L10:
        float r2 = r4.getX();
        float r5 = r4.getY();
        Math.abs(r2 - this.L1);
        Math.abs(r5 - this.M1);
    L11:
        return r0;
    L5:
        if (r1 == 1) goto L10;
        if (r1 == 3) goto L10;
        goto L10
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.RtlViewPager
    public void setScrollable(boolean r1) {
        this.H1 = r1;
    }

    public UserProfileViewPager(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.H1 = true;
        ViewConfiguration.get(r1).getScaledPagingTouchSlop();
    }
}
