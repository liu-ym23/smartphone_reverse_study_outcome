package com.bytedance.ies.sdk.widgets.inflater;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes19.dex */
public class InflateRequest {
    private androidx.asynclayoutinflater.view.AsyncLayoutInflater.OnInflateFinishedListener mCallback;
    private PriorityAsyncLayoutInflater mInflater;
    private ViewGroup mParent;
    private int mResId;
    private View mView;

    public void release() {
        this.mInflater = null;
        this.mResId = 0;
        this.mParent = null;
        this.mCallback = null;
        this.mView = null;
    }

    public boolean isValid() {
        if (this.mInflater != null) goto L5;
    L9:
        return false;
    L5:
        if (this.mResId <= 0) goto L9;
        if (this.mCallback == null) goto L9;
        return true;
    }

    public androidx.asynclayoutinflater.view.AsyncLayoutInflater.OnInflateFinishedListener getCallback() {
        return this.mCallback;
    }

    public PriorityAsyncLayoutInflater getInflater() {
        return this.mInflater;
    }

    public ViewGroup getParent() {
        return this.mParent;
    }

    public int getResId() {
        return this.mResId;
    }

    public View getView() {
        return this.mView;
    }

    public void setView(View r100) {
        this.mView = r100;
    }

    public InflateRequest(PriorityAsyncLayoutInflater r100, int r101, ViewGroup r102, androidx.asynclayoutinflater.view.AsyncLayoutInflater.OnInflateFinishedListener r103) {
        this.mInflater = r100;
        this.mResId = r101;
        this.mParent = r102;
        this.mCallback = r103;
    }

    public void reBind(PriorityAsyncLayoutInflater r100, int r101, ViewGroup r102, androidx.asynclayoutinflater.view.AsyncLayoutInflater.OnInflateFinishedListener r103) {
        this.mInflater = r100;
        this.mResId = r101;
        this.mParent = r102;
        this.mCallback = r103;
        this.mView = null;
    }
}
