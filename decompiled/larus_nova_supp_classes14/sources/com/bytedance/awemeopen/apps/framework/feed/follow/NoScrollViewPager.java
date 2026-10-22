package com.bytedance.awemeopen.apps.framework.feed.follow;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class NoScrollViewPager extends DmtViewPager {
    @Override // com.bytedance.awemeopen.apps.framework.feed.follow.DmtViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r1) {
        return false;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.follow.DmtViewPager, android.view.View
    public final boolean onTouchEvent(MotionEvent r1) {
        return false;
    }

    public NoScrollViewPager(Context r1) {
        super(r1);
    }

    public NoScrollViewPager(Context r1, AttributeSet r2) {
        super(r1, r2);
    }
}
