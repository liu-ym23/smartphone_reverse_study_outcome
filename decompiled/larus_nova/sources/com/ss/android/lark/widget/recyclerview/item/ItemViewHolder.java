package com.ss.android.lark.widget.recyclerview.item;

import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes38.dex */
public class ItemViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray<View> f448190a;

    public ItemViewHolder(View r100) {
        super(r100);
        this.f448190a = new SparseArray();
    }

    public final <T extends View> T T3(int r100) {
        T r101 = (T) this.f448190a.get(r100);
        if (r101 != null) goto L6;
        T r102 = (T) this.itemView.findViewById(r100);
        this.f448190a.put(r100, r102);
        return r102;
    L6:
        return r101;
    }
}
