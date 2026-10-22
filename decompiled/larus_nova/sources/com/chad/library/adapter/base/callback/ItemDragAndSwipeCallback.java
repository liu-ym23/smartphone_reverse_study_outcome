package com.chad.library.adapter.base.callback;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.DraggableController;
import com.chad.library.adapter.base.listener.IDraggableListener;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes22.dex */
public class ItemDragAndSwipeCallback extends ItemTouchHelper.Callback {
    private BaseItemDraggableAdapter mBaseItemDraggableAdapter;
    private int mDragMoveFlags;
    private IDraggableListener mDraggableListener;
    private float mMoveThreshold;
    private int mSwipeMoveFlags;
    private float mSwipeThreshold;

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isItemViewSwipeEnabled() {
        BaseItemDraggableAdapter r100 = this.mBaseItemDraggableAdapter;
        if (r100 != null) goto L5;
        IDraggableListener r101 = this.mDraggableListener;
        if (r101 != null) goto L9;
        return false;
    L9:
        return r101.isItemSwipeEnable();
    L5:
        return r100.isItemSwipeEnable();
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isLongPressDragEnabled() {
        BaseItemDraggableAdapter r100 = this.mBaseItemDraggableAdapter;
        if (r100 != null) goto L5;
        IDraggableListener r101 = this.mDraggableListener;
        if (r101 != null) goto L14;
        return false;
    L14:
        if (r101.isItemDraggable() == true) goto L16;
    L18:
        return false;
    L16:
        if (this.mDraggableListener.hasToggleView() == true) goto L18;
        return true;
    L5:
        if (r100.isItemDraggable() == true) goto L7;
    L9:
        return false;
    L7:
        if (this.mBaseItemDraggableAdapter.hasToggleView() == true) goto L9;
        return true;
    }

    public ItemDragAndSwipeCallback(BaseItemDraggableAdapter r100) {
        this.mMoveThreshold = 0.1f;
        this.mSwipeThreshold = 0.7f;
        this.mDragMoveFlags = 15;
        this.mSwipeMoveFlags = 32;
        this.mBaseItemDraggableAdapter = r100;
    }

    private boolean isViewCreateByAdapter(RecyclerView.ViewHolder r100) {
        int r101 = r100.getItemViewType();
        if (r101 != 273) goto L5;
    L12:
        return true;
    L5:
        if (r101 == 546) goto L12;
        if (r101 == 819) goto L12;
        if (r101 == 1365) goto L12;
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public float getMoveThreshold(RecyclerView.ViewHolder r100) {
        return this.mMoveThreshold;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public float getSwipeThreshold(RecyclerView.ViewHolder r100) {
        return this.mSwipeThreshold;
    }

    public void setDragMoveFlags(int r100) {
        this.mDragMoveFlags = r100;
    }

    public void setMoveThreshold(float r100) {
        this.mMoveThreshold = r100;
    }

    public void setSwipeMoveFlags(int r100) {
        this.mSwipeMoveFlags = r100;
    }

    public void setSwipeThreshold(float r100) {
        this.mSwipeThreshold = r100;
    }

    public ItemDragAndSwipeCallback(DraggableController r100) {
        this.mMoveThreshold = 0.1f;
        this.mSwipeThreshold = 0.7f;
        this.mDragMoveFlags = 15;
        this.mSwipeMoveFlags = 32;
        this.mDraggableListener = r100;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void clearView(RecyclerView r100, RecyclerView.ViewHolder r101) {
        super.clearView(r100, r101);
        if (isViewCreateByAdapter(r101) == false) goto L6;
        return;
    L6:
        if (r101.itemView.getTag(R.id.BaseQuickAdapter_dragging_support) == null) goto L17;
        if (((Boolean) r101.itemView.getTag(R.id.BaseQuickAdapter_dragging_support)).booleanValue() == false) goto L17;
        BaseItemDraggableAdapter r102 = this.mBaseItemDraggableAdapter;
        if (r102 == null) goto L12;
        r102.onItemDragEnd(r101);
    L15:
        r101.itemView.setTag(R.id.BaseQuickAdapter_dragging_support, Boolean.FALSE);
        goto L17
    L12:
        IDraggableListener r103 = this.mDraggableListener;
        if (r103 == null) goto L15;
        r103.onItemDragEnd(r101);
    L17:
        if (r101.itemView.getTag(R.id.BaseQuickAdapter_swiping_support) != null) goto L19;
        return;
    L19:
        if (((Boolean) r101.itemView.getTag(R.id.BaseQuickAdapter_swiping_support)).booleanValue() == false) goto L29;
        BaseItemDraggableAdapter r104 = this.mBaseItemDraggableAdapter;
        if (r104 == null) goto L23;
        r104.onItemSwipeClear(r101);
    L26:
        r101.itemView.setTag(R.id.BaseQuickAdapter_swiping_support, Boolean.FALSE);
        return;
    L23:
        IDraggableListener r105 = this.mDraggableListener;
        if (r105 == null) goto L26;
        r105.onItemSwipeClear(r101);
        goto L26
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int getMovementFlags(RecyclerView r100, RecyclerView.ViewHolder r101) {
        if (isViewCreateByAdapter(r101) == false) goto L7;
        return ItemTouchHelper.Callback.makeMovementFlags(0, 0);
    L7:
        return ItemTouchHelper.Callback.makeMovementFlags(this.mDragMoveFlags, this.mSwipeMoveFlags);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSelectedChanged(RecyclerView.ViewHolder r100, int r101) {
        if (r101 != 2) goto L14;
        if (isViewCreateByAdapter(r100) == true) goto L14;
        BaseItemDraggableAdapter r102 = this.mBaseItemDraggableAdapter;
        if (r102 == null) goto L9;
        r102.onItemDragStart(r100);
    L12:
        r100.itemView.setTag(R.id.BaseQuickAdapter_dragging_support, Boolean.TRUE);
    L24:
        super.onSelectedChanged(r100, r101);
        return;
    L9:
        IDraggableListener r103 = this.mDraggableListener;
        if (r103 == null) goto L12;
        r103.onItemDragStart(r100);
    L14:
        if (r101 != 1) goto L24;
        if (isViewCreateByAdapter(r100) == true) goto L24;
        BaseItemDraggableAdapter r104 = this.mBaseItemDraggableAdapter;
        if (r104 == null) goto L20;
        r104.onItemSwipeStart(r100);
    L23:
        r100.itemView.setTag(R.id.BaseQuickAdapter_swiping_support, Boolean.TRUE);
        goto L24
    L20:
        IDraggableListener r105 = this.mDraggableListener;
        if (r105 == null) goto L23;
        r105.onItemSwipeStart(r100);
        goto L23
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(RecyclerView.ViewHolder r100, int r101) {
        if (isViewCreateByAdapter(r100) == true) goto L11;
        BaseItemDraggableAdapter r102 = this.mBaseItemDraggableAdapter;
        if (r102 == null) goto L7;
        r102.onItemSwiped(r100);
        return;
    L7:
        IDraggableListener r103 = this.mDraggableListener;
        if (r103 == null) goto L13;
        r103.onItemSwiped(r100);
        return;
    L13:
        return;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(RecyclerView r100, RecyclerView.ViewHolder r101, RecyclerView.ViewHolder r102) {
        if (r101.getItemViewType() != r102.getItemViewType()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onChildDrawOver(Canvas r100, RecyclerView r101, RecyclerView.ViewHolder r110, float r111, float r112, int r113, boolean r114) {
        super.onChildDrawOver(r100, r101, r110, r111, r112, r113, r114);
        if (r113 == 1) goto L5;
        return;
    L5:
        if (isViewCreateByAdapter(r110) == true) goto L19;
        View r102 = r110.itemView;
        r100.save();
        if (r111 <= 0.0f) goto L9;
        r100.clipRect(r102.getLeft(), r102.getTop(), r102.getLeft() + r111, r102.getBottom());
        r100.translate(r102.getLeft(), r102.getTop());
    L10:
        BaseItemDraggableAdapter r103 = this.mBaseItemDraggableAdapter;
        if (r103 == null) goto L13;
        r103.onItemSwiping(r100, r110, r111, r112, r114);
    L16:
        r100.restore();
        return;
    L13:
        IDraggableListener r104 = this.mDraggableListener;
        if (r104 == null) goto L16;
        r104.onItemSwiping(r100, r110, r111, r112, r114);
        goto L16
    L9:
        r100.clipRect(r102.getRight() + r111, r102.getTop(), r102.getRight(), r102.getBottom());
        r100.translate(r102.getRight() + r111, r102.getTop());
        goto L10
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onMoved(RecyclerView r100, RecyclerView.ViewHolder r101, int r102, RecyclerView.ViewHolder r103, int r104, int r105, int r106) {
        super.onMoved(r100, r101, r102, r103, r104, r105, r106);
        BaseItemDraggableAdapter r107 = this.mBaseItemDraggableAdapter;
        if (r107 == null) goto L5;
        r107.onItemDragMoving(r101, r103);
        return;
    L5:
        IDraggableListener r108 = this.mDraggableListener;
        if (r108 == null) goto L10;
        r108.onItemDragMoving(r101, r103);
        return;
    }
}
