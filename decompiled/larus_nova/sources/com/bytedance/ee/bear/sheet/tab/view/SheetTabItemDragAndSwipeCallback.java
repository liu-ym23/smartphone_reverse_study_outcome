package com.bytedance.ee.bear.sheet.tab.view;

import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;

/* JADX INFO: loaded from: classes18.dex */
public class SheetTabItemDragAndSwipeCallback extends ItemDragAndSwipeCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f238405a;

    @Override // com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback, androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final boolean isLongPressDragEnabled() {
        return this.f238405a;
    }

    public SheetTabItemDragAndSwipeCallback(SheetTabAdapter r100) {
        super(r100);
        this.f238405a = false;
    }
}
