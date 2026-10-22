package com.bytedance.awemeopen.apps.framework.framework.loadmoreadapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class RecyclerViewWithFooterAdapter extends RecyclerView.Adapter {
    public boolean a;

    public abstract int getBasicItemCount();

    public int getBasicItemViewType(int r1) {
        return 0;
    }

    public abstract void onBindBasicViewHolder(RecyclerView.ViewHolder r1, int r2);

    public abstract void onBindFooterViewHolder(RecyclerView.ViewHolder r1);

    public abstract RecyclerView.ViewHolder onCreateBasicViewHolder(ViewGroup r1, int r2);

    public abstract RecyclerView.ViewHolder onCreateFooterViewHolder(ViewGroup r1);

    public int getItemCount() {
        if (this.a == false) goto L6;
        return getBasicItemCount() + 1;
    L6:
        return getBasicItemCount();
    }

    public RecyclerViewWithFooterAdapter() {
        this.a = true;
    }

    public final int getItemViewType(int r2) {
        if (this.a == false) goto L9;
        if (r2 != getBasicItemCount()) goto L9;
        return Integer.MIN_VALUE;
    L9:
        return getBasicItemViewType(r2);
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        if (getItemViewType(r4) != Integer.MIN_VALUE) goto L5;
        onBindFooterViewHolder(r3);
        return;
    L5:
        onBindBasicViewHolder(r3, r4);
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        if (Integer.MIN_VALUE != r3) goto L7;
        return onCreateFooterViewHolder(r2);
    L7:
        return onCreateBasicViewHolder(r2, r3);
    }
}
