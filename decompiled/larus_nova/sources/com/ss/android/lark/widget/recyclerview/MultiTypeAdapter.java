package com.ss.android.lark.widget.recyclerview;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import zdc.c;
import zdc.d;

/* JADX INFO: loaded from: classes38.dex */
public abstract class MultiTypeAdapter<Value> extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements c<Value>, View.OnLongClickListener, View.OnClickListener {

    public static class a<Value> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Value f448177a;

        public a(int r100, Value r101) {
            this.f448177a = r101;
        }
    }

    public RecyclerView.Adapter<?> e() {
        return this;
    }

    public abstract Value getItem(int r100);

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r100) {
        return false;
    }

    public MultiTypeAdapter() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        getItem(r100);
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Value r102 = getItem(r101);
        View r103 = r100.itemView;
        r103.setTag(R.id.multi_type_item_data, new a(r101, r102));
        r103.setOnClickListener(this);
        r103.setOnLongClickListener(this);
        d r104 = (d) r103.getTag(R.id.multi_type_item_holder);
        r104.getClass();
        getItem(r101);
        r104.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        throw null;
    }
}
