package com.larus.bmhome.chat.search.adapter;

import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.im.bean.message.ItemData;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/larus/bmhome/chat/search/adapter/SearchBaseCardAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/im/bean/message/ItemData;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "<init>", "()V", "getItemViewType", "", "position", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class SearchBaseCardAdapter extends ListAdapter<ItemData, RecyclerView.ViewHolder> {
    public SearchBaseCardAdapter() {
        super(new SearchItemCallback());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        return getItem(r100).getSearchItemType().getType();
    }
}
