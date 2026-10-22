package com.bytedance.awemeopen.apps.framework.feed.follow;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes14.dex */
public class NoScrollViewPager extends DmtViewPager {
    @Override // com.bytedance.awemeopen.apps.framework.feed.follow.DmtViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        return false;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.follow.DmtViewPager, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        return false;
    }

    public NoScrollViewPager(Context r100) {
        super(r100);
    }

    public NoScrollViewPager(Context r100, AttributeSet r101) {
        super(r100, r101);
    }
}
