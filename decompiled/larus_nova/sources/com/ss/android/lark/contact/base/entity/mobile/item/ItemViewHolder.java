package com.ss.android.lark.contact.base.entity.mobile.item;

import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes35.dex */
public class ItemViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray<View> f418889a;

    public ItemViewHolder(View r100) {
        super(r100);
        this.f418889a = new SparseArray();
    }

    public final <T extends View> T T3(int r100) {
        T r101 = (T) this.f418889a.get(r100);
        if (r101 != null) goto L6;
        T r102 = (T) this.itemView.findViewById(r100);
        this.f418889a.put(r100, r102);
        return r102;
    L6:
        return r101;
    }
}
