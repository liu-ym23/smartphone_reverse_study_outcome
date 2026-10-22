package com.chad.library.adapter.base.loadmore;

import com.chad.library.adapter.base.BaseViewHolder;

/* JADX INFO: loaded from: classes22.dex */
public abstract class LoadMoreView {
    public static final int STATUS_DEFAULT = 1;
    public static final int STATUS_END = 4;
    public static final int STATUS_FAIL = 3;
    public static final int STATUS_LOADING = 2;
    private boolean mLoadMoreEndGone;
    private int mLoadMoreStatus;

    public abstract int getLayoutId();

    public abstract int getLoadEndViewId();

    public abstract int getLoadFailViewId();

    public abstract int getLoadingViewId();

    public LoadMoreView() {
        this.mLoadMoreStatus = 1;
        this.mLoadMoreEndGone = false;
    }

    public final boolean isLoadEndMoreGone() {
        if (getLoadEndViewId() != 0) goto L7;
        return true;
    L7:
        return this.mLoadMoreEndGone;
    }

    public int getLoadMoreStatus() {
        return this.mLoadMoreStatus;
    }

    public boolean isLoadEndGone() {
        return this.mLoadMoreEndGone;
    }

    public void convert(BaseViewHolder r100) {
        int r101 = this.mLoadMoreStatus;
        if (r101 != 1) goto L5;
        visibleLoading(r100, false);
        visibleLoadFail(r100, false);
        visibleLoadEnd(r100, false);
        return;
    L5:
        if (r101 != 2) goto L7;
        visibleLoading(r100, true);
        visibleLoadFail(r100, false);
        visibleLoadEnd(r100, false);
        return;
    L7:
        if (r101 != 3) goto L9;
        visibleLoading(r100, false);
        visibleLoadFail(r100, true);
        visibleLoadEnd(r100, false);
        return;
    L9:
        if (r101 != 4) goto L19;
        visibleLoading(r100, false);
        visibleLoadFail(r100, false);
        visibleLoadEnd(r100, true);
        return;
    }

    public final void setLoadMoreEndGone(boolean r100) {
        this.mLoadMoreEndGone = r100;
    }

    public void setLoadMoreStatus(int r100) {
        this.mLoadMoreStatus = r100;
    }

    private void visibleLoadEnd(BaseViewHolder r100, boolean r101) {
        int r102 = getLoadEndViewId();
        if (r102 == 0) goto L6;
        r100.setGone(r102, r101);
        return;
    }

    private void visibleLoadFail(BaseViewHolder r100, boolean r101) {
        r100.setGone(getLoadFailViewId(), r101);
    }

    private void visibleLoading(BaseViewHolder r100, boolean r101) {
        r100.setGone(getLoadingViewId(), r101);
    }
}
