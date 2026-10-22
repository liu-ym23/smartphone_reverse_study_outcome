package com.bytedance.android.shopping.storev3.category.adapter;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/storev3/category/adapter/WrapContentLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WrapContentLinearLayoutManager extends LinearLayoutManager {
    public final void onLayoutChildren(RecyclerView.Recycler r1, RecyclerView.State r2) {
        super.onLayoutChildren(r1, r2);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }
}
