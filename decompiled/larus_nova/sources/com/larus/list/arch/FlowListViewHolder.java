package com.larus.list.arch;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import ei9.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0016J\u001d\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u001aH\u0016¢\u0006\u0002\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u0016H\u0016J\u001d\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u001aH\u0016¢\u0006\u0002\u0010\u001fJ\b\u0010 \u001a\u00020\u0016H\u0016J\b\u0010!\u001a\u00020\u0016H\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/larus/list/arch/FlowListViewHolder;", "STATE", "Lcom/larus/list/arch/IFlowListCellState;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "listCell", "Lcom/larus/list/arch/IFlowListCell;", "getListCell", "()Lcom/larus/list/arch/IFlowListCell;", "setListCell", "(Lcom/larus/list/arch/IFlowListCell;)V", "cellView", "onCreated", "", "bind", "state", "position", "", "(Lcom/larus/list/arch/IFlowListCellState;I)V", "onViewRecycled", "shouldBindCell", "", "(Lcom/larus/list/arch/IFlowListCellState;I)Z", "onViewAttachedToWindow", "onViewDetachedFromWindow", "list_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class FlowListViewHolder<STATE extends f> extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f355730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IFlowListCell<? super f> f355731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f355732c;

    public void onViewRecycled() {
        IFlowListCell<? super f> r100 = this.f355731b;
        if (r100 == null) goto L6;
        r100.onViewRecycled();
        return;
    }

    public FlowListViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
    }

    public void U3(View r100) {
        this.f355732c = r100;
    }

    public void T3(STATE r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "state");
        IFlowListCell<? super f> r102 = this.f355731b;
        if (r102 != null) goto L5;
        return;
    L5:
        View r103 = this.f355732c;
        if (r103 != null) goto L8;
        return;
    L8:
        r102.onBindViewInternal(r103, r100, r101);
        r102.onBindView(r103, r100, r101);
    }
}
