package com.larus.bmhome.chat.cotdetail.list.viewholder.base;

import androidx.recyclerview.widget.RecyclerView;
import ie8.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u0004\u0018\u00010\u000bR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/larus/bmhome/chat/cotdetail/list/viewholder/base/BaseThreadMsgViewHolder;", "STATE", "Lcom/larus/bmhome/chat/cotdetail/list/cellstate/base/ThreadMsgCellState;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Lcom/larus/bmhome/chat/cotdetail/list/view/base/BaseThreadMsgCell;", "<init>", "(Lcom/larus/bmhome/chat/cotdetail/list/view/base/BaseThreadMsgCell;)V", "getView", "()Lcom/larus/bmhome/chat/cotdetail/list/view/base/BaseThreadMsgCell;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "bindData", "", "state", "onViewRecycled", "getAttachedRecyclerView", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseThreadMsgViewHolder<STATE extends a> extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final le8.a<STATE> f302073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RecyclerView f302074b;

    public BaseThreadMsgViewHolder(le8.a<STATE> r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
        this.f302073a = r100;
    }
}
