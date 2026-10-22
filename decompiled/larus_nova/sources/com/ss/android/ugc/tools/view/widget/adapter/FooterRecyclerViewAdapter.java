package com.ss.android.ugc.tools.view.widget.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/tools/view/widget/adapter/FooterRecyclerViewAdapter;", "Lcom/ss/android/ugc/tools/view/widget/adapter/GridAwareAdapter;", "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
public abstract class FooterRecyclerViewAdapter extends GridAwareAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f455122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView.Adapter<RecyclerView.ViewHolder> f455123b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f455124c;

    public abstract void onBindFooterViewHolder(RecyclerView.ViewHolder r100);

    public abstract RecyclerView.ViewHolder onCreateFooterViewHolder(ViewGroup r100);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        int r100 = this.f455123b.getItemCount();
        if (this.f455124c == false) goto L6;
        if (r100 != 0) goto L6;
        return r100;
    L6:
        if (this.f455122a == true) goto L9;
        return r100;
    L9:
        return r100 + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        if (r100 != this.f455123b.getItemCount()) goto L8;
        if (this.f455122a == false) goto L8;
        return Integer.MIN_VALUE;
    L8:
        return this.f455123b.getItemViewType(r100);
    }

    @Override // com.ss.android.ugc.tools.view.widget.adapter.GridAwareAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        super.onViewAttachedToWindow(r100);
        ViewGroup.LayoutParams r101 = r100.itemView.getLayoutParams();
        if (r101 != null) goto L5;
        return;
    L5:
        if ((r101 instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L13;
        StaggeredGridLayoutManager.LayoutParams r102 = (StaggeredGridLayoutManager.LayoutParams) r101;
        if (getItemViewType(r100.getLayoutPosition()) != Integer.MIN_VALUE) goto L9;
        boolean r103 = true;
    L10:
        r102.setFullSpan(r103);
        return;
    L9:
        r103 = false;
        goto L10
    }

    public FooterRecyclerViewAdapter(RecyclerView.Adapter<RecyclerView.ViewHolder> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        this.f455123b = r100;
        this.f455124c = r101;
        Intrinsics.checkNotNullParameter(r100, "$this$registerAdapterDataObserverCompletelyDelegate");
        Intrinsics.checkNotNullParameter(this, PickerReporterConstants.KEY.TARGET);
        r100.registerAdapterDataObserver(new AdapterFunctionsKt$registerAdapterDataObserverCompletelyDelegate$1(this));
        this.f455122a = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        if (getItemViewType(r101) != Integer.MIN_VALUE) goto L5;
        onBindFooterViewHolder(r100);
        return;
    L5:
        this.f455123b.onBindViewHolder(r100, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (Integer.MIN_VALUE != r101) goto L6;
        return onCreateFooterViewHolder(r100);
    L6:
        return this.f455123b.onCreateViewHolder(r100, r101);
    }

    @Override // com.ss.android.ugc.tools.view.widget.adapter.GridAwareAdapter
    public int y2(int r100, GridLayoutManager r101) {
        Intrinsics.checkNotNullParameter(r101, "gridLayoutManager");
        if (getItemViewType(r100) == Integer.MIN_VALUE) goto L10;
        RecyclerView.Adapter<RecyclerView.ViewHolder> r102 = this.f455123b;
        if ((r102 instanceof GridAwareAdapter) == true) goto L11;
        return 1;
    L11:
        return ((GridAwareAdapter) r102).y2(r100, r101);
    L10:
        return r101.getSpanCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List<Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r102, "payloads");
        if (getItemViewType(r101) != Integer.MIN_VALUE) goto L5;
        onBindViewHolder(r100, r101);
        return;
    L5:
        this.f455123b.onBindViewHolder(r100, r101, r102);
    }
}
