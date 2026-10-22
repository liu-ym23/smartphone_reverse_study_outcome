package com.bytedance.ies.sdk.widgets.inflater;

import android.content.Context;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes19.dex */
public final class AsyncLayoutInflater implements IAsyncInflater {
    private androidx.asynclayoutinflater.view.AsyncLayoutInflater realInflater;

    public AsyncLayoutInflater(Context r100) {
        this.realInflater = new androidx.asynclayoutinflater.view.AsyncLayoutInflater(r100);
    }

    @Override // com.bytedance.ies.sdk.widgets.inflater.IAsyncInflater
    public void inflate(int r100, ViewGroup r101, androidx.asynclayoutinflater.view.AsyncLayoutInflater.OnInflateFinishedListener r102) {
        this.realInflater.inflate(r100, r101, r102);
    }
}
