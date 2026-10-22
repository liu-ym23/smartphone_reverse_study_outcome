package com.bytedance.awemeopen.apps.framework.base.view.refresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager.VerticalViewPager;

/* JADX INFO: loaded from: classes14.dex */
public class FeedSwipeRefreshLayout extends DoubleBallSwipeRefreshLayout {
    public VerticalViewPager M;
    public boolean N;
    public RecyclerView O;
    public boolean P;

    public void setInterceptPredicate(j r100) {
    }

    public FeedSwipeRefreshLayout(Context r100) {
        this(r100, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        return super.dispatchTouchEvent(r100);
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.DoubleBallSwipeRefreshLayout, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        boolean r101 = true;
        if (this.N == true) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L26;
        VerticalViewPager r103 = this.M;
        if (r103 != null) goto L12;
    L17:
        RecyclerView r104 = this.O;
        if (r104 == null) goto L24;
        if (((GridLayoutManager) r104.getLayoutManager()) == null) goto L24;
        if (((GridLayoutManager) this.O.getLayoutManager()).findFirstCompletelyVisibleItemPosition() != 0) goto L26;
    L24:
        if (super.onInterceptTouchEvent(r100) == false) goto L26;
    L27:
        String.valueOf(r101);
        return r101;
    L12:
        if (r103.getAdapter() == null) goto L17;
        if (this.M.getAdapter().getCount() == 0) goto L17;
        if (this.M.getCurrentItem() == 0) goto L17;
    L26:
        r101 = false;
        goto L27
    L5:
        if (this.P == false) goto L7;
        r102 = true;
        goto L8
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.DoubleBallSwipeRefreshLayout, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (r100.getAction() != 0) goto L6;
        return false;
    L6:
        if (r100.getAction() == 1) goto L10;
        if (r100.getAction() == 3) goto L10;
    L14:
        VerticalViewPager r101 = this.M;
        if (r101 == null) goto L20;
        if (r101.getCurrentItem() <= 0) goto L20;
        return false;
    L20:
        if (this.N == true) goto L22;
    L24:
        boolean r102 = false;
    L25:
        if (r102 == true) goto L27;
        return false;
    L27:
        if (super.onTouchEvent(r100) == false) goto L31;
        return true;
    L31:
        return false;
    L22:
        if (this.P == false) goto L24;
        r102 = true;
    L10:
        if (this.f193316r == false) goto L14;
        VerticalViewPager r103 = this.M;
        if (r103 == null) goto L14;
        r103.getCurrentItem();
        goto L14
    }

    public void setCanTouch(boolean r100) {
        this.N = r100;
    }

    public void setCanTouchForLimit(boolean r100) {
        this.P = r100;
    }

    public void setRecyclerView(RecyclerView r100) {
        this.O = r100;
    }

    public void setViewPager(VerticalViewPager r100) {
        this.M = r100;
    }

    public FeedSwipeRefreshLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.N = true;
        this.P = true;
    }
}
