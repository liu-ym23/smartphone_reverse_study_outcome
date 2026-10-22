package com.larksuite.component.ui.dialog;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.ui.dialog.SelectableViewHolder;

/* JADX INFO: loaded from: classes24.dex */
public abstract class SelectableAdapter<Value, T extends SelectableViewHolder> extends RecyclerView.Adapter<T> {
    public abstract SelectableViewHolder y2();

    public SelectableAdapter() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        SelectableViewHolder r102 = y2();
        r102.getClass();
        return r102;
    }
}
