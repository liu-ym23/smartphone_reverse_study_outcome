package com.chad.library.adapter.base.diff;

import androidx.recyclerview.widget.ListUpdateCallback;
import com.chad.library.adapter.base.BaseQuickAdapter;

/* JADX INFO: loaded from: classes22.dex */
public final class BaseQuickAdapterListUpdateCallback implements ListUpdateCallback {
    private final BaseQuickAdapter mAdapter;

    public BaseQuickAdapterListUpdateCallback(BaseQuickAdapter r100) {
        this.mAdapter = r100;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onInserted(int r100, int r101) {
        BaseQuickAdapter r102 = this.mAdapter;
        r102.notifyItemRangeInserted(r100 + r102.getHeaderLayoutCount(), r101);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onMoved(int r100, int r101) {
        BaseQuickAdapter r102 = this.mAdapter;
        r102.notifyItemMoved(r100 + r102.getHeaderLayoutCount(), r101 + this.mAdapter.getHeaderLayoutCount());
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onRemoved(int r100, int r101) {
        BaseQuickAdapter r102 = this.mAdapter;
        r102.notifyItemRangeRemoved(r100 + r102.getHeaderLayoutCount(), r101);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onChanged(int r100, int r101, Object r102) {
        BaseQuickAdapter r103 = this.mAdapter;
        r103.notifyItemRangeChanged(r100 + r103.getHeaderLayoutCount(), r101, r102);
    }
}
