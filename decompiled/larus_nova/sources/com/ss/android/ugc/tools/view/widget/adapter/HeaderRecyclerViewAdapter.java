package com.ss.android.ugc.tools.view.widget.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/tools/view/widget/adapter/HeaderRecyclerViewAdapter;", "Lcom/ss/android/ugc/tools/view/widget/adapter/GridAwareAdapter;", "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
public abstract class HeaderRecyclerViewAdapter extends GridAwareAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f455127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView.Adapter<RecyclerView.ViewHolder> f455128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f455129c;

    public abstract void A2(RecyclerView.ViewHolder r100);

    public abstract RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup r100);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f455128b.getItemCount() + z2();
    }

    public final int z2() {
        int r100 = this.f455128b.getItemCount();
        if (this.f455129c == false) goto L6;
        if (r100 != 0) goto L6;
    L7:
        return 0;
    L6:
        if (this.f455127a == false) goto L7;
        return 1;
    }

    public final void B2(boolean r100) {
        if (this.f455127a != r100) goto L6;
        return;
    L6:
        if (this.f455129c == true) goto L8;
    L10:
        this.f455127a = r100;
        if (r100 == false) goto L13;
        notifyItemInserted(0);
        return;
    L13:
        notifyItemRemoved(0);
        return;
    L8:
        if (this.f455128b.getItemCount() != 0) goto L10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        if (this.f455127a == false) goto L7;
        if (r100 != 0) goto L7;
        return -2147483646;
    L7:
        return this.f455128b.getItemViewType(r100 - z2());
    }

    public HeaderRecyclerViewAdapter(DataListAdapter r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        this.f455128b = r100;
        this.f455129c = r101;
        r100.registerAdapterDataObserver(new AnonymousClass1(this));
        this.f455127a = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        if (getItemViewType(r101) != (-2147483646)) goto L5;
        A2(r100);
        return;
    L5:
        this.f455128b.onBindViewHolder(r100, r101 - z2());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if ((-2147483646) != r101) goto L6;
        return onCreateHeaderViewHolder(r100);
    L6:
        return this.f455128b.onCreateViewHolder(r100, r101);
    }

    @Override // com.ss.android.ugc.tools.view.widget.adapter.GridAwareAdapter
    public int y2(int r100, GridLayoutManager r101) {
        Intrinsics.checkNotNullParameter(r101, "gridLayoutManager");
        if (getItemViewType(r100) == (-2147483646)) goto L10;
        RecyclerView.Adapter<RecyclerView.ViewHolder> r102 = this.f455128b;
        if ((r102 instanceof GridAwareAdapter) == true) goto L11;
        return 1;
    L11:
        return ((GridAwareAdapter) r102).y2(r100 - z2(), r101);
    L10:
        return r101.getSpanCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List<Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r102, "payloads");
        if (getItemViewType(r101) != (-2147483646)) goto L5;
        onBindViewHolder(r100, r101);
        return;
    L5:
        this.f455128b.onBindViewHolder(r100, r101 - z2(), r102);
    }
}
