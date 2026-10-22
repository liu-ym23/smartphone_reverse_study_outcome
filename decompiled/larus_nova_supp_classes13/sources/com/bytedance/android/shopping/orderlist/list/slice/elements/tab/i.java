package com.bytedance.android.shopping.orderlist.list.slice.elements.tab;

import android.widget.PopupWindow;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i implements PopupWindow.OnDismissListener {
    public final /* synthetic */ PopupWindow a;
    public final /* synthetic */ OrderListTabLayout b;

    public i(PopupWindow r1, OrderListTabLayout r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        if (Intrinsics.areEqual(this.b.j, this.a) == false) goto L6;
        OrderListTabLayout r0 = this.b;
        r0.j = null;
        r0.k = null;
        r0.l = false;
        return;
    }
}
