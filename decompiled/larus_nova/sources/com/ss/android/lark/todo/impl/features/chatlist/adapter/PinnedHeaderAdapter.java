package com.ss.android.lark.todo.impl.features.chatlist.adapter;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.larksuite.component.blockit.hashtag.widget.RecyclerSwipeAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH&J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\b\u001a\u00020\tH&¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/chatlist/adapter/PinnedHeaderAdapter;", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/larksuite/component/blockit/hashtag/widget/RecyclerSwipeAdapter;", "<init>", "()V", "isPinnedPosition", "", "position", "", "pinnedHeaderClick", "", "firstVisiblePos", "getItem", "", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class PinnedHeaderAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerSwipeAdapter<VH> {
    public abstract boolean A2(int r100);

    public abstract void B2(int r100);

    public PinnedHeaderAdapter() {
    }
}
