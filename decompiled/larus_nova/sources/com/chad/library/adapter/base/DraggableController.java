package com.chad.library.adapter.base;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.chad.library.adapter.base.listener.IDraggableListener;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.chad.library.adapter.base.listener.OnItemSwipeListener;
import com.larus.nova.R;
import java.util.Collections;

/* JADX INFO: loaded from: classes22.dex */
public class DraggableController implements IDraggableListener {
    private static final int NO_TOGGLE_VIEW = 0;
    private boolean itemDragEnabled;
    private boolean itemSwipeEnabled;
    private BaseQuickAdapter mAdapter;
    private boolean mDragOnLongPress;
    private ItemTouchHelper mItemTouchHelper;
    private OnItemDragListener mOnItemDragListener;
    private OnItemSwipeListener mOnItemSwipeListener;
    private View.OnLongClickListener mOnToggleViewLongClickListener;
    private View.OnTouchListener mOnToggleViewTouchListener;
    private int mToggleViewId;

    public void disableDragItem() {
        this.itemDragEnabled = false;
        this.mItemTouchHelper = null;
    }

    public void disableSwipeItem() {
        this.itemSwipeEnabled = false;
    }

    public void enableSwipeItem() {
        this.itemSwipeEnabled = true;
    }

    @Override // com.chad.library.adapter.base.listener.IDraggableListener
    public boolean hasToggleView() {
        if (this.mToggleViewId == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.chad.library.adapter.base.listener.IDraggableListener
    public boolean isItemDraggable() {
        return this.itemDragEnabled;
    }

    @Override // com.chad.library.adapter.base.listener.IDraggableListener
    public boolean isItemSwipeEnable() {
        return this.itemSwipeEnabled;
    }

    public DraggableController(BaseQuickAdapter r100) {
        this.mToggleViewId = 0;
        this.itemDragEnabled = false;
        this.itemSwipeEnabled = false;
        this.mDragOnLongPress = true;
        this.mAdapter = r100;
    }

    public static /* synthetic */ ItemTouchHelper access$000(DraggableController r100) {
        return r100.mItemTouchHelper;
    }

    public static /* synthetic */ boolean access$100(DraggableController r100) {
        return r100.itemDragEnabled;
    }

    public static /* synthetic */ boolean access$200(DraggableController r100) {
        return r100.mDragOnLongPress;
    }

    private boolean inRange(int r100) {
        if (r100 >= 0) goto L4;
    L6:
        return false;
    L4:
        if (r100 >= this.mAdapter.getData().size()) goto L6;
        return true;
    }

    public void enableDragItem(ItemTouchHelper r100) {
        enableDragItem(r100, 0, true);
    }

    public int getViewHolderPosition(RecyclerView.ViewHolder r100) {
        return r100.getAdapterPosition() - this.mAdapter.getHeaderLayoutCount();
    }

    public void initView(BaseViewHolder r100) {
        int r101 = r100.getItemViewType();
        if (this.mItemTouchHelper != null) goto L5;
        return;
    L5:
        if (this.itemDragEnabled == true) goto L7;
        return;
    L7:
        if (r101 != 546) goto L9;
        return;
    L9:
        if (r101 != 273) goto L11;
        return;
    L11:
        if (r101 != 1365) goto L13;
        return;
    L13:
        if (r101 != 819) goto L15;
        return;
    L15:
        if (hasToggleView() == false) goto L29;
        View r102 = r100.getView(this.mToggleViewId);
        if (r102 == null) goto L30;
        r102.setTag(R.id.BaseQuickAdapter_viewholder_support, r100);
        if (this.mDragOnLongPress == false) goto L21;
        r102.setOnLongClickListener(this.mOnToggleViewLongClickListener);
        return;
    L21:
        r102.setOnTouchListener(this.mOnToggleViewTouchListener);
        return;
    L30:
        return;
    }

    @Override // com.chad.library.adapter.base.listener.IDraggableListener
    public void onItemDragEnd(RecyclerView.ViewHolder r100) {
        OnItemDragListener r101 = this.mOnItemDragListener;
        if (r101 != null) goto L5;
        return;
    L5:
        if (this.itemDragEnabled == false) goto L9;
        r101.onItemDragEnd(r100, getViewHolderPosition(r100));
        return;
    }

    @Override // com.chad.library.adapter.base.listener.IDraggableListener
    public void onItemDragStart(RecyclerView.ViewHolder r100) {
        OnItemDragListener r101 = this.mOnItemDragListener;
        if (r101 != null) goto L5;
        return;
    L5:
        if (this.itemDragEnabled == false) goto L9;
        r101.onItemDragStart(r100, getViewHolderPosition(r100));
        return;
    }

    @Override // com.chad.library.adapter.base.listener.IDraggableListener
    public void onItemSwipeClear(RecyclerView.ViewHolder r100) {
        OnItemSwipeListener r101 = this.mOnItemSwipeListener;
        if (r101 != null) goto L5;
        return;
    L5:
        if (this.itemSwipeEnabled == false) goto L9;
        r101.clearView(r100, getViewHolderPosition(r100));
        return;
    }

    @Override // com.chad.library.adapter.base.listener.IDraggableListener
    public void onItemSwipeStart(RecyclerView.ViewHolder r100) {
        OnItemSwipeListener r101 = this.mOnItemSwipeListener;
        if (r101 != null) goto L5;
        return;
    L5:
        if (this.itemSwipeEnabled == false) goto L9;
        r101.onItemSwipeStart(r100, getViewHolderPosition(r100));
        return;
    }

    @Override // com.chad.library.adapter.base.listener.IDraggableListener
    public void onItemSwiped(RecyclerView.ViewHolder r100) {
        OnItemSwipeListener r101 = this.mOnItemSwipeListener;
        if (r101 != null) goto L5;
    L7:
        int r102 = getViewHolderPosition(r100);
        if (inRange(r102) == false) goto L11;
        ListProtector.remove(this.mAdapter.getData(), r102);
        this.mAdapter.notifyItemRemoved(r100.getAdapterPosition());
        return;
    L11:
        return;
    L5:
        if (this.itemSwipeEnabled == false) goto L7;
        r101.onItemSwiped(r100, getViewHolderPosition(r100));
        goto L7
    }

    public void setOnItemDragListener(OnItemDragListener r100) {
        this.mOnItemDragListener = r100;
    }

    public void setOnItemSwipeListener(OnItemSwipeListener r100) {
        this.mOnItemSwipeListener = r100;
    }

    public void setToggleDragOnLongPress(boolean r100) {
        this.mDragOnLongPress = r100;
        if (r100 == false) goto L5;
        this.mOnToggleViewTouchListener = null;
        this.mOnToggleViewLongClickListener = new AnonymousClass1(this);
        return;
    L5:
        this.mOnToggleViewTouchListener = new AnonymousClass2(this);
        this.mOnToggleViewLongClickListener = null;
    }

    public void setToggleViewId(int r100) {
        this.mToggleViewId = r100;
    }

    public void enableDragItem(ItemTouchHelper r100, int r101) {
        enableDragItem(r100, r101, true);
    }

    @Override // com.chad.library.adapter.base.listener.IDraggableListener
    public void onItemDragMoving(RecyclerView.ViewHolder r100, RecyclerView.ViewHolder r101) {
        int r102 = getViewHolderPosition(r100);
        int r103 = getViewHolderPosition(r101);
        if (inRange(r102) == true) goto L5;
    L14:
        OnItemDragListener r104 = this.mOnItemDragListener;
        if (r104 != null) goto L17;
        return;
    L17:
        if (this.itemDragEnabled == false) goto L23;
        r104.onItemDragMoving(r100, r102, r101, r103);
        return;
    L23:
        return;
    L5:
        if (inRange(r103) == false) goto L14;
        if (r102 >= r103) goto L10;
        int r105 = r102;
    L8:
        if (r105 >= r103) goto L13;
        int r106 = r105 + 1;
        Collections.swap(this.mAdapter.getData(), r105, r106);
        r105 = r106;
    L13:
        this.mAdapter.notifyItemMoved(r100.getAdapterPosition(), r101.getAdapterPosition());
        goto L14
    L10:
        int r107 = r102;
    L11:
        if (r107 <= r103) goto L13;
        Collections.swap(this.mAdapter.getData(), r107, r107 - 1);
        r107 = r107 - 1;
        goto L11
    }

    public void enableDragItem(ItemTouchHelper r100, int r101, boolean r102) {
        this.itemDragEnabled = true;
        this.mItemTouchHelper = r100;
        setToggleViewId(r101);
        setToggleDragOnLongPress(r102);
    }

    @Override // com.chad.library.adapter.base.listener.IDraggableListener
    public void onItemSwiping(Canvas r100, RecyclerView.ViewHolder r101, float r102, float r110, boolean r111) {
        OnItemSwipeListener r103 = this.mOnItemSwipeListener;
        if (r103 != null) goto L5;
        return;
    L5:
        if (this.itemSwipeEnabled == false) goto L9;
        r103.onItemSwipeMoving(r100, r101, r102, r110, r111);
        return;
    }
}
