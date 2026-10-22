package com.bytedance.ee.bear.bitable.homepage.chart.home.edit;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000fH\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016J \u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0013H\u0016J\u001a\u0010\u001b\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001c\u001a\u00020\u000fH\u0016J\u0018\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/chart/home/edit/ChartTouchCallback;", "Landroidx/recyclerview/widget/ItemTouchHelper$SimpleCallback;", "<init>", "()V", "canDragToSort", "", "getCanDragToSort", "()Z", "setCanDragToSort", "(Z)V", "moveListener", "Lcom/bytedance/ee/bear/bitable/homepage/chart/home/edit/ChartItemTouchMoveListener;", "setMoveListener", "", "getMovementFlags", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onSwiped", "direction", "isLongPressDragEnabled", "isItemViewSwipeEnabled", "onMove", "srcHolder", "targetHolder", "onSelectedChanged", "actionState", "clearView", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChartTouchCallback extends ItemTouchHelper.SimpleCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f212536a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f212537b;

    public ChartTouchCallback() {
        super(0, 0);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final boolean isItemViewSwipeEnabled() {
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final boolean isLongPressDragEnabled() {
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final void onSwiped(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "viewHolder");
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final void clearView(RecyclerView r100, RecyclerView.ViewHolder r101) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        Intrinsics.checkNotNullParameter(r101, "viewHolder");
        super.clearView(r100, r101);
        a r102 = this.f212537b;
        if (r102 == null) goto L6;
        r102.c(r100, r101);
        return;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.SimpleCallback, androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final int getMovementFlags(RecyclerView r100, RecyclerView.ViewHolder r101) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        Intrinsics.checkNotNullParameter(r101, "viewHolder");
        if (this.f212536a == false) goto L5;
        int r102 = 3;
    L7:
        return ItemTouchHelper.Callback.makeMovementFlags(r102, 0);
    L5:
        r102 = 0;
        goto L7
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final void onSelectedChanged(RecyclerView.ViewHolder r100, int r101) {
        super.onSelectedChanged(r100, r101);
        a r102 = this.f212537b;
        if (r102 == null) goto L6;
        r102.a();
        return;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final boolean onMove(RecyclerView r100, RecyclerView.ViewHolder r101, RecyclerView.ViewHolder r102) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        Intrinsics.checkNotNullParameter(r101, "srcHolder");
        Intrinsics.checkNotNullParameter(r102, "targetHolder");
        a r103 = this.f212537b;
        if (r103 != null) goto L5;
    L7:
        boolean r104 = false;
    L8:
        if (r104 == true) goto L10;
        return false;
    L10:
        a r105 = this.f212537b;
        if (r105 == null) goto L13;
        r105.b(r101.getBindingAdapterPosition(), r102.getBindingAdapterPosition());
        return true;
    L13:
        return false;
    L5:
        if (r103.d(r100, r101, r102) != true) goto L7;
        r104 = true;
        goto L8
    }
}
