package com.ss.android.lark.widget.recyclerview.itemtouch;

import android.graphics.Canvas;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.widget.recyclerview.FoldedLayoutManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u0001+B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0007J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J \u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0016H\u0016J\u0018\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0012H\u0016J\u0018\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u001a\u0010\u001d\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001e\u001a\u00020\u0012H\u0016J(\u0010\u001f\u001a\u00020 2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#H\u0016J@\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020'2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020#2\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u0007H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/ss/android/lark/widget/recyclerview/itemtouch/DefaultItemTouchHelperCallback;", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "onItemTouchCallbackListener", "Lcom/ss/android/lark/widget/recyclerview/itemtouch/DefaultItemTouchHelperCallback$OnItemTouchCallbackListener;", "<init>", "(Lcom/ss/android/lark/widget/recyclerview/itemtouch/DefaultItemTouchHelperCallback$OnItemTouchCallbackListener;)V", "isCanDrag", "", "isCanSwipe", "setOnItemTouchCallbackListener", "", "setDragEnable", "canDrag", "setSwipeEnable", "canSwipe", "isLongPressDragEnabled", "isItemViewSwipeEnabled", "getMovementFlags", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onMove", "srcViewHolder", "targetViewHolder", "onSwiped", "direction", "clearView", "onSelectedChanged", "actionState", "getAnimationDuration", "", "animationType", "animateDx", "", "animateDy", "onChildDraw", "c", "Landroid/graphics/Canvas;", "dX", "dY", "isCurrentlyActive", "OnItemTouchCallbackListener", "widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class DefaultItemTouchHelperCallback extends ItemTouchHelper.Callback {
    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final boolean isItemViewSwipeEnabled() {
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final boolean isLongPressDragEnabled() {
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final boolean onMove(RecyclerView r100, RecyclerView.ViewHolder r101, RecyclerView.ViewHolder r102) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        Intrinsics.checkNotNullParameter(r101, "srcViewHolder");
        Intrinsics.checkNotNullParameter(r102, "targetViewHolder");
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
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final int getMovementFlags(RecyclerView r100, RecyclerView.ViewHolder r101) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        Intrinsics.checkNotNullParameter(r101, "viewHolder");
        RecyclerView.LayoutManager r102 = r100.getLayoutManager();
        int r103 = 0;
        if ((r102 instanceof GridLayoutManager) == true) goto L5;
        int r104 = 12;
        if ((r102 instanceof LinearLayoutManager) == false) goto L18;
        int r105 = ((LinearLayoutManager) r102).getOrientation();
        if (r105 != 0) goto L11;
        r103 = 12;
        r104 = 3;
    L16:
        return ItemTouchHelper.Callback.makeMovementFlags(r103, r104);
    L11:
        if (r105 == 1) goto L13;
        r104 = 0;
        goto L16
    L13:
        r103 = 3;
        goto L16
    L18:
        if ((r102 instanceof FoldedLayoutManager) == true) goto L20;
        return 0;
    L20:
        return ItemTouchHelper.Callback.makeMovementFlags(12, 3);
    L5:
        return ItemTouchHelper.Callback.makeMovementFlags(15, 0);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final void onSelectedChanged(RecyclerView.ViewHolder r100, int r101) {
        super.onSelectedChanged(r100, r101);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final long getAnimationDuration(RecyclerView r100, int r101, float r102, float r103) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        return super.getAnimationDuration(r100, r101, r102, r103);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final void onChildDraw(Canvas r100, RecyclerView r101, RecyclerView.ViewHolder r102, float r103, float r104, int r105, boolean r106) {
        Intrinsics.checkNotNullParameter(r100, "c");
        Intrinsics.checkNotNullParameter(r101, "recyclerView");
        Intrinsics.checkNotNullParameter(r102, "viewHolder");
        super.onChildDraw(r100, r101, r102, r103, r104, r105, r106);
    }
}
