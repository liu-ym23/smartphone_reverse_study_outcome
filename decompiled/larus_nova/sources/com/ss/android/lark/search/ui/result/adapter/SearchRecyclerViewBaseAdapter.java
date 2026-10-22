package com.ss.android.lark.search.ui.result.adapter;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b&\u0018\u0000 \r*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004:\u0001\rB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/search/ui/result/adapter/SearchRecyclerViewBaseAdapter;", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Data", "Lcom/ss/android/lark/base/adapter/LarkRecyclerViewBaseAdapter;", "<init>", "()V", "onBindViewHolder", "", "holder", "position", "", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "Companion", "search-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class SearchRecyclerViewBaseAdapter<VH extends RecyclerView.ViewHolder, Data> extends LarkRecyclerViewBaseAdapter<VH, Data> {

    public static final class a {
    }

    static {
    }

    public SearchRecyclerViewBaseAdapter() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(VH r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Log.d("LarkSearch.Common.SearchRecyclerViewBaseAdapter", "onBindViewHolder, position: " + r101);
    }
}
