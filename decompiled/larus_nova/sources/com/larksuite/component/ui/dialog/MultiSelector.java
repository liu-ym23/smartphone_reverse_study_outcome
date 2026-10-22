package com.larksuite.component.ui.dialog;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes24.dex */
public class MultiSelector<Value> extends RecyclerView.AdapterDataObserver {
    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeRemoved(int r100, int r101) {
        if (r101 > 0) goto L5;
        return;
    L5:
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeMoved(int r100, int r101, int r102) {
        if (r102 > 0) goto L5;
        return;
    L5:
        throw null;
    }
}
