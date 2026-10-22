package com.ss.android.lark.chameleon.widget.emptyview;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.larus.nova.R;
import java.util.Locale;

/* JADX INFO: loaded from: classes35.dex */
public class EmptyView extends LinearLayout implements EmptyViewController, View.OnClickListener {
    private Config mConfig;
    private SpaceEmptyState mEmptyState;
    private LinearLayout mLoadingTip;
    private View mLoadingView;
    private OnRetryListener mOnRetryListener;

    public interface OnRetryListener {
        void onFailedRetry();
    }

    @Override // com.ss.android.lark.chameleon.widget.emptyview.EmptyViewController
    public void hide() {
        setVisibility(4);
    }

    @Override // com.ss.android.lark.chameleon.widget.emptyview.EmptyViewController
    public void show() {
        setVisibility(0);
    }

    @Override // com.ss.android.lark.chameleon.widget.emptyview.EmptyViewController
    public void showLoading() {
        setIsLoadingView(true);
        this.mConfig.getIcons().get(0).intValue();
        CharSequence r100 = this.mConfig.getTips().get(0);
    }

    @Override // com.ss.android.lark.chameleon.widget.emptyview.EmptyViewController
    public void showNoContent() {
        setIsLoadingView(false);
        int r100 = this.mConfig.getIcons().get(1).intValue();
        CharSequence r101 = this.mConfig.getTips().get(1);
        String r102 = getResources().getString(R.string.Doc_Facade_EmptyFolderTip);
        if (r101.toString().equals(r102) == true) goto L5;
    L7:
        this.mEmptyState.setImageRes(Integer.valueOf(r100));
        this.mEmptyState.setDesc(r101);
        this.mEmptyState.setOnClickListener(null);
        this.mEmptyState.setClickable(false);
        return;
    L5:
        if (TextUtils.equals(this.mConfig.getLanguage(), Locale.CHINESE.getLanguage()) == false) goto L7;
        StringBuilder r103 = new StringBuilder(r101);
        r103.insert(r101.length() / 2, "\n");
        r101 = r103.toString();
        goto L7
    }

    @Override // com.ss.android.lark.chameleon.widget.emptyview.EmptyViewController
    public void showNoFound() {
        setIsLoadingView(false);
        this.mEmptyState.setImageRes(this.mConfig.getIcons().get(5));
        this.mEmptyState.setDesc(this.mConfig.getTips().get(5));
        this.mEmptyState.setOnClickListener(null);
    }

    @Override // com.ss.android.lark.chameleon.widget.emptyview.EmptyViewController
    public void showNoNetworkError() {
        setIsLoadingView(false);
        int r100 = this.mConfig.getIcons().get(4).intValue();
        CharSequence r101 = this.mConfig.getTips().get(4);
        this.mEmptyState.setImageRes(Integer.valueOf(r100));
        this.mEmptyState.setDesc(r101);
        this.mEmptyState.setOnClickListener(null);
    }

    @Override // com.ss.android.lark.chameleon.widget.emptyview.EmptyViewController
    public void showNoPermission() {
        setIsLoadingView(false);
        this.mEmptyState.setImageRes(this.mConfig.getIcons().get(99));
        this.mEmptyState.setDesc(this.mConfig.getTips().get(99));
        this.mEmptyState.setOnClickListener(this);
    }

    @Override // com.ss.android.lark.chameleon.widget.emptyview.EmptyViewController
    public void showNoSupport() {
        setIsLoadingView(false);
        this.mEmptyState.setImageRes(this.mConfig.getIcons().get(10));
        this.mEmptyState.setDesc(this.mConfig.getTips().get(10));
        this.mEmptyState.setOnClickListener(this);
    }

    @Override // com.ss.android.lark.chameleon.widget.emptyview.EmptyViewController
    public void showTimeout() {
        setIsLoadingView(false);
        this.mEmptyState.setImageRes(this.mConfig.getIcons().get(7));
        this.mEmptyState.setDesc(this.mConfig.getTips().get(7));
        this.mEmptyState.setOnClickListener(this);
    }

    @Override // com.ss.android.lark.chameleon.widget.emptyview.EmptyViewController
    public void showWikiDeleted() {
        setIsLoadingView(false);
        this.mEmptyState.setImageRes(this.mConfig.getIcons().get(9));
        this.mEmptyState.setDesc(this.mConfig.getTips().get(9));
        this.mEmptyState.setOnClickListener(this);
    }

    public void hideLoading() {
        this.mLoadingTip.setVisibility(8);
        this.mEmptyState.setVisibility(8);
    }

    public Config getConfig() {
        return this.mConfig;
    }

    public EmptyView(Context r100) {
        super(r100);
        init(r100, null);
    }

    private void setIsLoadingView(boolean r100) {
        LinearLayout r101 = this.mLoadingTip;
        int r102 = 0;
        if (r100 == false) goto L5;
        int r103 = 0;
    L6:
        r101.setVisibility(r103);
        SpaceEmptyState r104 = this.mEmptyState;
        if (r100 == false) goto L9;
        int r105 = 8;
    L10:
        r104.setVisibility(r105);
        if (this.mEmptyState.getImageView() == null) goto L16;
        View r106 = this.mEmptyState.getImageView();
        if (r100 == false) goto L15;
        r102 = 8;
    L15:
        r106.setVisibility(r102);
    L16:
        this.mEmptyState.showDescription(!r100);
        return;
    L9:
        r105 = 0;
        goto L10
    L5:
        r103 = 8;
        goto L6
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r100) {
        OnRetryListener r101 = this.mOnRetryListener;
        if (r101 == null) goto L6;
        r101.onFailedRetry();
        return;
    }

    public void setConfig(Config r100) {
        setConfig(r100, null);
    }

    public void setLoadViewMarginTop(int r100) {
        if (this.mLoadingView != null) goto L5;
        this.mLoadingView = findViewById(R.id.lark_loading_view);
    L5:
        LinearLayout.LayoutParams r101 = (LinearLayout.LayoutParams) this.mLoadingView.getLayoutParams();
        r101.topMargin = r100;
        this.mLoadingView.setLayoutParams(r101);
    }

    public void setOnRetryListener(OnRetryListener r100) {
        this.mOnRetryListener = r100;
    }

    @Override // com.ss.android.lark.chameleon.widget.emptyview.EmptyViewController
    public void showLoadError(Throwable r100) {
        setIsLoadingView(false);
        this.mEmptyState.setImageRes(this.mConfig.getIcons().get(3));
        this.mEmptyState.setDesc(this.mConfig.getTips().get(3));
        setOnClickListener(this);
    }

    public EmptyView(Context r100, AttributeSet r101) {
        super(r100, r101);
        init(r100, r101);
    }

    private void init(Context r100, AttributeSet r101) {
        int r102 = R.layout.chameleonv1_facade_common_empty;
        if (r101 == null) goto L5;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.content});
        r102 = r103.getResourceId(0, R.layout.chameleonv1_facade_common_empty);
        r103.recycle();
    L5:
        LayoutInflater.from(r100).inflate(r102, this);
        this.mLoadingTip = (LinearLayout) findViewById(R.id.ll_loading);
        this.mEmptyState = (SpaceEmptyState) findViewById(R.id.facade_no_data_empty_state);
        this.mConfig = new DefaultConfig(r100).getDefault().invoke();
    }

    public void setConfig(Config r100, ViewGroup.LayoutParams r101) {
        this.mConfig = r100;
        int r102 = r100.getLoadingView();
        if (r102 <= 0) goto L9;
        this.mLoadingTip.removeAllViews();
        View r103 = LayoutInflater.from(getContext()).inflate(r102, null);
        if (r101 == null) goto L7;
        this.mLoadingTip.addView(r103, r101);
        return;
    L7:
        this.mLoadingTip.addView(r103);
        return;
    }

    @Override // com.ss.android.lark.chameleon.widget.emptyview.EmptyViewController
    public void showCustomError(int r100, CharSequence r101) {
        setIsLoadingView(false);
        this.mEmptyState.setImageRes(Integer.valueOf(r100));
        this.mEmptyState.setDesc(r101);
        setOnClickListener(this);
    }

    public EmptyView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        init(r100, r101);
    }
}
