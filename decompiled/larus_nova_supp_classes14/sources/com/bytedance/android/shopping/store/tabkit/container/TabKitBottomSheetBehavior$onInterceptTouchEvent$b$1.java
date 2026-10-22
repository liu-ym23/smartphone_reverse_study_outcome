package com.bytedance.android.shopping.store.tabkit.container;

import androidx.customview.widget.ViewDragHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class TabKitBottomSheetBehavior$onInterceptTouchEvent$b$1 extends MutablePropertyReference0Impl {
    public TabKitBottomSheetBehavior$onInterceptTouchEvent$b$1(TabKitBottomSheetBehavior r7) {
        super(r7, TabKitBottomSheetBehavior.class, "dragHelper", "getDragHelper()Landroidx/customview/widget/ViewDragHelper;", 0);
    }

    public Object get() {
        return TabKitBottomSheetBehavior.a((TabKitBottomSheetBehavior) ((CallableReference) this).receiver);
    }

    public void set(Object r2) {
        ViewDragHelper r3 = (ViewDragHelper) r2;
        ((TabKitBottomSheetBehavior) ((CallableReference) this).receiver).t = r3;
    }
}
