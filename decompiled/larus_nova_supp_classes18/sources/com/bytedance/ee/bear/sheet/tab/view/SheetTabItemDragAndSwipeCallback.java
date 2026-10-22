package com.bytedance.ee.bear.sheet.tab.view;

import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SheetTabItemDragAndSwipeCallback extends ItemDragAndSwipeCallback {
    public boolean a;

    public final boolean isLongPressDragEnabled() {
        return this.a;
    }

    public SheetTabItemDragAndSwipeCallback(SheetTabAdapter r1) {
        super(r1);
        this.a = false;
    }
}
