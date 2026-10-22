package com.ss.android.lark.contact.base.entity.mobile.item;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import b9b.a;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public class BaseItemAdapter<Item extends a<Item>> extends RecyclerView.Adapter<ItemViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<Item> f418888a;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f418888a.size();
    }

    public BaseItemAdapter() {
        this.f418888a = new ArrayList();
        setHasStableIds(false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int r100) {
        ((a) ListProtector.get(this.f418888a, r100)).getClass();
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        a r101 = (a) ListProtector.get(this.f418888a, r100);
        r101.f18374c = this;
        return r101.f18373b;
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
        if (r102 >= this.f418888a.size()) goto L10;
        ((a) ListProtector.get(this.f418888a, r102)).b(r101);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        ItemViewHolder r102 = (ItemViewHolder) r100;
        a r103 = (a) ListProtector.get(this.f418888a, r101);
        r103.getClass();
        r102.itemView.setOnClickListener(null);
        r102.itemView.setOnLongClickListener(null);
        r103.f18372a = true;
        r103.a(r102, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        int r102 = a.f18371d.get(r101, -1);
        if (r102 == (-1)) goto L7;
        return new ItemViewHolder(LayoutInflater.from(r100.getContext()).inflate(r102, r100, false));
    L7:
        throw new RuntimeException("onCreateViewHolder: get holder from view type failed.");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List r102) {
        ItemViewHolder r103 = (ItemViewHolder) r100;
        if (r102.isEmpty() == false) goto L5;
        super.onBindViewHolder(r103, r101, r102);
        return;
    L5:
        ((a) ListProtector.get(this.f418888a, r101)).getClass();
    }
}
