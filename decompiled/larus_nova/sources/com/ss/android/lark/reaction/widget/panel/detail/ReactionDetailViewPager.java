package com.ss.android.lark.reaction.widget.panel.detail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: classes37.dex */
public class ReactionDetailViewPager extends ViewPager {
    public ReactionDetailViewPager(Context r100) {
        super(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        int r101 = r100.getAction();
        if (r101 != 0) goto L5;
        getParent().requestDisallowInterceptTouchEvent(true);
    L16:
        return super.dispatchTouchEvent(r100);
    L5:
        if (r101 != 2) goto L16;
        if (getAdapter().getCount() != (getCurrentItem() + 1)) goto L10;
    L13:
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L16
    L10:
        if (getCurrentItem() == 0) goto L13;
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L16
    }

    public ReactionDetailViewPager(Context r100, AttributeSet r101) {
        super(r100, r101);
    }
}
