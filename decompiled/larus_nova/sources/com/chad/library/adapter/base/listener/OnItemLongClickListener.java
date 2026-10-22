package com.chad.library.adapter.base.listener;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;

/* JADX INFO: loaded from: classes22.dex */
public abstract class OnItemLongClickListener extends SimpleClickListener {
    @Override // com.chad.library.adapter.base.listener.SimpleClickListener
    public void onItemChildClick(BaseQuickAdapter r100, View r101, int r102) {
    }

    @Override // com.chad.library.adapter.base.listener.SimpleClickListener
    public void onItemChildLongClick(BaseQuickAdapter r100, View r101, int r102) {
    }

    @Override // com.chad.library.adapter.base.listener.SimpleClickListener
    public void onItemClick(BaseQuickAdapter r100, View r101, int r102) {
    }

    public abstract void onSimpleItemLongClick(BaseQuickAdapter r100, View r101, int r102);

    public OnItemLongClickListener() {
    }

    @Override // com.chad.library.adapter.base.listener.SimpleClickListener
    public void onItemLongClick(BaseQuickAdapter r100, View r101, int r102) {
        onSimpleItemLongClick(r100, r101, r102);
    }
}
