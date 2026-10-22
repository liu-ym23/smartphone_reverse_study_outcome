package com.bytedance.awemeopen.apps.framework.base.view.refresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager.VerticalViewPager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class FeedSwipeRefreshLayout extends DoubleBallSwipeRefreshLayout {
    public VerticalViewPager M;
    public boolean N;
    public RecyclerView O;
    public boolean P;

    public void setInterceptPredicate(j r1) {
    }

    public FeedSwipeRefreshLayout(Context r2) {
        this(r2, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r1) {
        return super.dispatchTouchEvent(r1);
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.DoubleBallSwipeRefreshLayout, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r4) {
        boolean r1 = true;
        if (this.N == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L26;
        VerticalViewPager r2 = this.M;
        if (r2 != null) goto L12;
    L17:
        RecyclerView r3 = this.O;
        if (r3 == null) goto L24;
        if (r3.getLayoutManager() == null) goto L24;
        if (this.O.getLayoutManager().findFirstCompletelyVisibleItemPosition() != 0) goto L26;
    L24:
        if (super.onInterceptTouchEvent(r4) == false) goto L26;
    L27:
        String.valueOf(r1);
        return r1;
    L12:
        if (r2.getAdapter() == null) goto L17;
        if (this.M.getAdapter().getCount() == 0) goto L17;
        if (this.M.getCurrentItem() == 0) goto L17;
    L26:
        r1 = false;
        goto L27
    L5:
        if (this.P == false) goto L7;
        r0 = true;
        goto L8
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.DoubleBallSwipeRefreshLayout, android.view.View
    public final boolean onTouchEvent(MotionEvent r5) {
        if (r5.getAction() != 0) goto L6;
        return false;
    L6:
        if (r5.getAction() == 1) goto L10;
        if (r5.getAction() == 3) goto L10;
    L14:
        VerticalViewPager r0 = this.M;
        if (r0 == null) goto L20;
        if (r0.getCurrentItem() <= 0) goto L20;
        return false;
    L20:
        if (this.N == true) goto L22;
    L24:
        boolean r1 = false;
    L25:
        if (r1 == true) goto L27;
        return false;
    L27:
        if (super.onTouchEvent(r5) == false) goto L31;
        return true;
    L31:
        return false;
    L22:
        if (this.P == false) goto L24;
        r1 = true;
    L10:
        if (this.r == false) goto L14;
        VerticalViewPager r2 = this.M;
        if (r2 == null) goto L14;
        r2.getCurrentItem();
        goto L14
    }

    public void setCanTouch(boolean r1) {
        this.N = r1;
    }

    public void setCanTouchForLimit(boolean r1) {
        this.P = r1;
    }

    public void setRecyclerView(RecyclerView r1) {
        this.O = r1;
    }

    public void setViewPager(VerticalViewPager r1) {
        this.M = r1;
    }

    public FeedSwipeRefreshLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.N = true;
        this.P = true;
    }
}
