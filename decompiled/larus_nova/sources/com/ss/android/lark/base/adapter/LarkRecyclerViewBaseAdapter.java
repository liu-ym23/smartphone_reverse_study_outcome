package com.ss.android.lark.base.adapter;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public abstract class LarkRecyclerViewBaseAdapter<VH extends RecyclerView.ViewHolder, Data> extends RecyclerView.Adapter<VH> {
    protected List<Data> items;

    public class DiffCallback extends DiffUtil.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<Data> f409736a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<Data> f409737b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final a<Data> f409738c;

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final int getNewListSize() {
            return this.f409737b.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final int getOldListSize() {
            return this.f409736a.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final boolean areContentsTheSame(int r100, int r101) {
            if (this.f409738c != null) goto L6;
            return true;
        L6:
            Object r102 = ListProtector.get(this.f409736a, r100);
            Object r103 = ListProtector.get(this.f409737b, r101);
            return this.f409738c.areContentsTheSame((Data) r102, (Data) r103);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final boolean areItemsTheSame(int r100, int r101) {
            return ListProtector.get(this.f409736a, r100).equals(ListProtector.get(this.f409737b, r101));
        }

        public DiffCallback(List r100, List r101, a r102) {
            this.f409736a = r100;
            this.f409737b = r101;
            this.f409738c = r102;
        }
    }

    public interface a<Data> {
        boolean areContentsTheSame(Data r100, Data r101);
    }

    public void clear() {
        this.items.clear();
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    public LarkRecyclerViewBaseAdapter() {
        this.items = new ArrayList();
        setHasStableIds(true);
    }

    public List<Data> getItems() {
        return this.items;
    }

    public void add(Data r100) {
        getItems().add(r100);
        notifyItemInserted(getItems().size() - 1);
    }

    public void addAll(Collection<? extends Data> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == true) goto L8;
        this.items.addAll(r100);
        notifyDataSetChanged();
        return;
    }

    public void diff(Collection<? extends Data> r100) {
        diff(r100, null);
    }

    public int getIndex(Data r100) {
        return this.items.indexOf(r100);
    }

    public Data getItem(int r100) {
        return (Data) ListProtector.get(this.items, r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int r100) {
        return getItem(r100).hashCode();
    }

    public void notifyItemChanged(Data r100) {
        notifyItemChanged(this.items.indexOf(r100));
    }

    public void remove(Data r100) {
        if (getItems().contains(r100) == false) goto L6;
        int r101 = getItems().indexOf(r100);
        getItems().remove(r100);
        notifyItemRemoved(r101);
        return;
    }

    public void resetAll(Collection<? extends Data> r100) {
        this.items.clear();
        if (r100 != null) goto L5;
    L7:
        notifyDataSetChanged();
        return;
    L5:
        if (r100.isEmpty() == true) goto L7;
        this.items.addAll(r100);
        goto L7
    }

    public void addAll(Data... r100) {
        addAll(Arrays.asList(r100));
    }

    public void add(int r100, Data r101) {
        ListProtector.add(this.items, r100, r101);
        notifyDataSetChanged();
    }

    public void diff(Collection<? extends Data> r100, a<Data> r101) {
        ArrayList r102 = new ArrayList(r100);
        if (this.items.size() != 0) goto L6;
        this.items.addAll(r102);
        notifyDataSetChanged();
        return;
    L6:
        DiffUtil.calculateDiff(new DiffCallback(this.items, r102, r101), false).dispatchUpdatesTo(this);
        this.items.clear();
        this.items.addAll(r102);
    }

    public void remove(int r100, int r101) {
        if (r100 >= 0) goto L4;
        return;
    L4:
        if (r101 >= getItemCount()) goto L10;
        int r102 = r101 - 1;
    L6:
        if (r102 < r100) goto L11;
        remove(getItem(r102));
        r102 = r102 - 1;
        goto L6
    L11:
        return;
    }
}
