package com.ss.android.lark.widget.recyclerview.item;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import bec.a;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public class BaseItemAdapter<Item extends a> extends RecyclerView.Adapter<ItemViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<Item> f448189a;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f448189a.size();
    }

    public BaseItemAdapter() {
        setHasStableIds(false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int r100) {
        ((a) ListProtector.get(this.f448189a, r100)).getClass();
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        a r101 = (a) ListProtector.get(this.f448189a, r100);
        r101.f18800b = this;
        return r101.f18799a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(RecyclerView r100) {
        super.onAttachedToRecyclerView(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder r100) {
        ItemViewHolder r101 = (ItemViewHolder) r100;
        super.onViewRecycled(r101);
        int r102 = r101.getAdapterPosition();
        if (r102 >= 0) goto L5;
        return;
    L5:
        if (r102 >= this.f448189a.size()) goto L10;
        ((a) ListProtector.get(this.f448189a, r102)).getClass();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        ItemViewHolder r102 = (ItemViewHolder) r100;
        a r103 = (a) ListProtector.get(this.f448189a, r101);
        r103.getClass();
        r102.itemView.setOnClickListener(null);
        r102.itemView.setOnLongClickListener(null);
        r103.a(r102, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        int r102 = a.f18797c.get(r101, -1);
        if (r102 != (-1)) goto L11;
        View r103 = a.f18798d.get(r101);
        if (r103 == null) goto L10;
        return new ItemViewHolder(r103);
    L10:
        throw new RuntimeException("onCreateViewHolder: get holder from view type failed.");
    L11:
        return new ItemViewHolder(LayoutInflater.from(r100.getContext()).inflate(r102, r100, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List r102) {
        ItemViewHolder r103 = (ItemViewHolder) r100;
        if (r102.isEmpty() == false) goto L5;
        super.onBindViewHolder(r103, r101, r102);
        return;
    L5:
        ((a) ListProtector.get(this.f448189a, r101)).getClass();
    }
}
