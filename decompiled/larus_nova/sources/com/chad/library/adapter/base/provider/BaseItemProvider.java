package com.chad.library.adapter.base.provider;

import android.content.Context;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public abstract class BaseItemProvider<T, V extends BaseViewHolder> {
    public Context mContext;
    public List<T> mData;

    public BaseItemProvider() {
    }

    public abstract void convert(V r100, T r101, int r102);

    public void convertPayloads(V r100, T r101, int r102, List<Object> r103) {
    }

    public abstract int layout();

    public void onClick(V r100, T r101, int r102) {
    }

    public boolean onLongClick(V r100, T r101, int r102) {
        return false;
    }

    public abstract int viewType();
}
