package com.bytedance.sdk.open.aweme.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public class CommonStatusView extends FrameLayout {
    public static final int STATUS_EMPTY = 1;
    public static final int STATUS_ERROR = 2;
    public static final int STATUS_LOADING = 0;
    public static final int STATUS_NONE = -1;
    private boolean mHasLoadSuccess;
    private int mStatus;
    List<View> mStatusViews;

    public static class Builder {
        Context mContext;
        View mEmptyView;
        View mErrorView;
        View mLoadingView;

        public Builder(Context r100) {
            if (r100 == null) goto L7;
            this.mContext = r100;
            return;
        L7:
            throw new IllegalArgumentException("CommonStatusView.Builder:Context can not be null");
        }

        public static Builder createDefaultBuilder(Context r100) {
            return new Builder(r100).useDefaultLoadingView();
        }

        private View createDefaultLoadingView() {
            CommonLoadingLayout r100 = new CommonLoadingLayout(this.mContext);
            r100.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            return r100;
        }

        public Builder setEmptyView(View r100) {
            this.mEmptyView = r100;
            r100.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            return this;
        }

        public Builder setErrorView(View r100) {
            this.mErrorView = r100;
            r100.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            return this;
        }

        public Builder setLoadingView(View r100) {
            this.mLoadingView = r100;
            r100.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            return this;
        }

        public Builder useDefaultLoadingView() {
            setLoadingView(createDefaultLoadingView());
            return this;
        }
    }

    public CommonStatusView(Context r100) {
        this(r100, null, 0);
    }

    public CommonStatusView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public CommonStatusView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.mStatus = -1;
        this.mStatusViews = new ArrayList(3);
        this.mHasLoadSuccess = false;
    }

    public View getStatusView(int r100) {
        if (r100 >= 0) goto L4;
        return null;
    L4:
        if (r100 < this.mStatusViews.size()) goto L7;
        return null;
    L7:
        return (View) ListProtector.get(this.mStatusViews, r100);
    }

    public boolean isLoading() {
        if (this.mStatus != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isShowingEmpty() {
        if (this.mStatus == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isShowingError() {
        if (this.mStatus != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
    }

    public void reset() {
        int r100 = this.mStatus;
        if (r100 != (-1)) goto L5;
        return;
    L5:
        View r101 = getStatusView(r100);
        if (r101 == null) goto L8;
        r101.setVisibility(4);
    L8:
        setVisibility(4);
        this.mStatus = -1;
    }

    public void setBuilder(Builder r100) {
        if (r100 != null) goto L4;
        r100 = Builder.createDefaultBuilder(getContext());
    L4:
        this.mStatusViews.clear();
        this.mStatusViews.add(r100.mLoadingView);
        this.mStatusViews.add(r100.mEmptyView);
        this.mStatusViews.add(r100.mErrorView);
        removeAllViews();
        int r101 = 0;
    L6:
        if (r101 >= this.mStatusViews.size()) goto L12;
        View r102 = (View) ListProtector.get(this.mStatusViews, r101);
        if (r102 == null) goto L11;
        r102.setVisibility(4);
        addView(r102);
    L11:
        r101 = r101 + 1;
        goto L6
    }

    public void setLoadSucceed() {
        this.mHasLoadSuccess = true;
    }

    public void setStatus(int r100) {
        int r101 = this.mStatus;
        if (r101 != r100) goto L6;
        return;
    L6:
        if (r101 < 0) goto L10;
        View r102 = getStatusView(r101);
        if (r102 == null) goto L10;
        r102.setVisibility(4);
    L10:
        if (r100 < 0) goto L14;
        setVisibility(0);
        View r103 = getStatusView(r100);
        if (r103 == null) goto L15;
        r103.setVisibility(0);
    L15:
        this.mStatus = r100;
        return;
    L14:
        setVisibility(4);
        goto L15
    }

    public void showEmpty() {
        setVisibility(0);
        setStatus(1);
    }

    public void showEmpty(boolean r100) {
        if (r100 == true) goto L4;
    L5:
        showEmpty();
        return;
    L4:
        if (this.mHasLoadSuccess == false) goto L5;
    }

    public void showError() {
        setVisibility(0);
        setStatus(2);
    }

    public void showError(boolean r100) {
        if (this.mHasLoadSuccess == false) goto L5;
        reset();
        return;
    L5:
        showError();
    }

    public void showLoading() {
        setVisibility(0);
        setStatus(0);
    }
}
