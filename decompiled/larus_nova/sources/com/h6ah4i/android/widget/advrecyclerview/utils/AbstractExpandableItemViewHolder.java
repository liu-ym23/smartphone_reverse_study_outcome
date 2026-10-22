package com.h6ah4i.android.widget.advrecyclerview.utils;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import aw7.d;

/* JADX INFO: loaded from: classes23.dex */
public abstract class AbstractExpandableItemViewHolder extends RecyclerView.ViewHolder implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f276053a;

    @Override // aw7.d
    public final int p3() {
        return this.f276053a;
    }

    public AbstractExpandableItemViewHolder(View r100) {
        super(r100);
    }

    @Override // aw7.d
    public final void j1(int r100) {
        this.f276053a = r100;
    }
}
