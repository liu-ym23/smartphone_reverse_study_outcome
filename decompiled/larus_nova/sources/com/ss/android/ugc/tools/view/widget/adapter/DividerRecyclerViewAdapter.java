package com.ss.android.ugc.tools.view.widget.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/ss/android/ugc/tools/view/widget/adapter/DividerRecyclerViewAdapter;", "DATA", "Lcom/ss/android/ugc/tools/view/widget/adapter/GridAwareAdapter;", "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
public abstract class DividerRecyclerViewAdapter<DATA> extends GridAwareAdapter {

    /* JADX INFO: renamed from: com.ss.android.ugc.tools.view.widget.adapter.DividerRecyclerViewAdapter$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/ss/android/ugc/tools/view/widget/adapter/DividerRecyclerViewAdapter$1", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
    public final class AnonymousClass1 extends RecyclerView.AdapterDataObserver {
        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onChanged() {
            throw null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int r100, int r101) {
            throw null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeInserted(int r100, int r101) {
            throw null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeRemoved(int r100, int r101) {
            throw null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int r100, int r101, Object r102) {
            throw null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeMoved(int r100, int r101, int r102) {
            throw null;
        }
    }

    public abstract RecyclerView.ViewHolder z2();

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        if (getItemViewType(r101) != (-2147483647)) goto L5;
        throw null;
    L5:
        new LinkedHashMap();
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if ((-2147483647) != r101) goto L7;
        return z2();
    L7:
        throw null;
    }

    @Override // com.ss.android.ugc.tools.view.widget.adapter.GridAwareAdapter
    public final int y2(int r100, GridLayoutManager r101) {
        Intrinsics.checkNotNullParameter(r101, "gridLayoutManager");
        if (getItemViewType(r100) == (-2147483647)) goto L7;
        return 1;
    L7:
        return r101.getSpanCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List<Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r102, "payloads");
        if (getItemViewType(r101) != (-2147483647)) goto L6;
        onBindViewHolder(r100, r101);
        return;
    L6:
        new LinkedHashMap();
        throw null;
    }
}
