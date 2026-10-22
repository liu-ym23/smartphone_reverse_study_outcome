package com.ss.android.ugc.tools.view.widget.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/tools/view/widget/adapter/DelegateStickyHeaderAdapter;", "Lcom/ss/android/ugc/tools/view/widget/adapter/GridAwareAdapter;", "", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
public abstract class DelegateStickyHeaderAdapter extends GridAwareAdapter {
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
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        throw null;
    }

    @Override // com.ss.android.ugc.tools.view.widget.adapter.GridAwareAdapter
    public final int y2(int r100, GridLayoutManager r101) {
        Intrinsics.checkNotNullParameter(r101, "gridLayoutManager");
        Intrinsics.checkNotNullParameter(r101, "gridLayoutManager");
        return 1;
    }
}
