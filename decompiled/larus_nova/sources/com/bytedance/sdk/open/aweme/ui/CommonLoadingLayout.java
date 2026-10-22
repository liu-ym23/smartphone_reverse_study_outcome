package com.bytedance.sdk.open.aweme.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes22.dex */
public class CommonLoadingLayout extends FrameLayout {
    private int mIgnoreHeight;
    private View mProgress;
    private FrameLayout mProgressBarLayout;
    private boolean mUseScreenHeight;

    public CommonLoadingLayout(Context r100) {
        this(r100, null);
    }

    public CommonLoadingLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public CommonLoadingLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        init(r100);
    }

    private void adjustTopMargin() {
    }

    private void init(Context r100) {
        View r101 = LayoutInflater.from(r100).inflate(R.layout.aweme_open_loading_layout, this, true);
        this.mProgress = r101.findViewById(R.id.double_loading_view);
        this.mProgressBarLayout = (FrameLayout) r101.findViewById(R.id.progressBarLayout);
    }

    @Override // android.view.View
    public void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        adjustTopMargin();
    }

    public void setProgressBarInfo(int r100) {
        if (r100 <= 0) goto L5;
        FrameLayout.LayoutParams r101 = (FrameLayout.LayoutParams) this.mProgress.getLayoutParams();
        r101.width = r100;
        r101.height = r100;
        this.mProgress.setLayoutParams(r101);
        return;
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        View r101 = this.mProgress;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setVisibility(r100);
    }
}
