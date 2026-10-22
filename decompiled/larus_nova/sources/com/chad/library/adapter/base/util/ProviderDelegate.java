package com.chad.library.adapter.base.util;

import android.util.SparseArray;
import com.chad.library.adapter.base.provider.BaseItemProvider;

/* JADX INFO: loaded from: classes22.dex */
public class ProviderDelegate {
    private SparseArray<BaseItemProvider> mItemProviders;

    public ProviderDelegate() {
        this.mItemProviders = new SparseArray();
    }

    public SparseArray<BaseItemProvider> getItemProviders() {
        return this.mItemProviders;
    }

    public void registerProvider(BaseItemProvider r100) {
        if (r100 == null) goto L8;
        int r101 = r100.viewType();
        if (this.mItemProviders.get(r101) != null) goto L9;
        this.mItemProviders.put(r101, r100);
        return;
    L9:
        return;
    L8:
        throw new ItemProviderException("ItemProvider can not be null");
    }
}
