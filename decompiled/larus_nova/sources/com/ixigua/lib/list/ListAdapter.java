package com.ixigua.lib.list;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.ixigua.lib.list.simple.ListViewHolder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/ixigua/lib/list/ListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liblist_release"}, k = 1, mv = {1, 4, 0})
public final class ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f278489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f278490b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public wx7.b f278491c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Object> f278492d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f278493e;

    public ListAdapter() {
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f278490b.getItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        Object r101 = this.f278490b.a(r100);
        return this.f278489a.a(r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final boolean onFailedToRecycleView(RecyclerView.ViewHolder r100) {
        b r101 = this.f278489a;
        r101.getClass();
        return r101.b(r100.getItemViewType()).e(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r100) {
        b r101 = this.f278489a;
        r101.getClass();
        r101.b(r100.getItemViewType()).b(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r100) {
        b r101 = this.f278489a;
        r101.getClass();
        r101.b(r100.getItemViewType()).c(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder r100) {
        b r101 = this.f278489a;
        r101.getClass();
        r101.b(r100.getItemViewType()).onViewRecycled(r100);
    }

    public ListAdapter(ay7.b r100, List r101) {
        this.f278493e = r100;
        ArrayList r102 = new ArrayList();
        this.f278492d = r102;
        ListAgency r103 = ListAgency.f278497d;
        Context r104 = r100.f16755a;
        r103.getClass();
        if (ListAgency.f278496c != null) goto L5;
        ListAgency.f278496c = r104.getApplicationContext();
    L5:
        this.f278490b = new yx7.a(this);
        b r105 = new b(this, r101);
        this.f278489a = r105;
        r102.add(r105);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        b r102 = this.f278489a;
        Object r103 = this.f278490b.a(r101);
        if (r103 == null) goto L9;
        a<?, ?> r104 = r102.b(r102.a(r103));
        if ((r100 instanceof ListViewHolder) == false) goto L7;
        ListViewHolder r105 = (ListViewHolder) r100;
        ListAdapter r106 = r102.f278503f;
        r105.f278524b = r106;
        r105.f278526d = r106.f278493e;
        e r107 = r106.f278490b;
        r105.getClass();
        r105.f278525c = r104;
    L7:
        r104.d(r100, r103);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        b r102 = this.f278489a;
        return r102.b(r101).a(r102.f278498a, r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List<? extends Object> r102) {
        b r103 = this.f278489a;
        Object r104 = this.f278490b.a(r101);
        if (r104 == null) goto L15;
        r103.getClass();
        if (r102.isEmpty() == false) goto L10;
        a<?, ?> r105 = r103.b(r103.a(r104));
        if ((r100 instanceof ListViewHolder) == false) goto L9;
        ListViewHolder r106 = (ListViewHolder) r100;
        ListAdapter r107 = r103.f278503f;
        r106.f278524b = r107;
        r106.f278526d = r107.f278493e;
        e r108 = r107.f278490b;
        r106.getClass();
        r106.f278525c = r105;
    L9:
        r105.d(r100, r104);
        return;
    L10:
        a<?, ?> r109 = r103.b(r103.a(r104));
        if ((r100 instanceof ListViewHolder) == false) goto L13;
        ListViewHolder r110 = (ListViewHolder) r100;
        ListAdapter r111 = r103.f278503f;
        r110.f278524b = r111;
        r110.f278526d = r111.f278493e;
        e r112 = r111.f278490b;
        r110.getClass();
        r110.f278525c = r109;
    L13:
        r109.f(r100, r104, r102);
        return;
    }
}
