package com.bytedance.android.shopping.orderlist.list.slice.elements.tab;

import com.bytedance.android.ui.base.widget.button.CornersButton;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h implements Runnable {
    public final /* synthetic */ OrderListTabItemView a;

    public h(OrderListTabItemView r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CornersButton r0 = this.a.c;     // Catch: Throwable -> L4
        r0.setMinWidth(r0.getHeight());     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
