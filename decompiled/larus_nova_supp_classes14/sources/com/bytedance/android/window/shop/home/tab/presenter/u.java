package com.bytedance.android.window.shop.home.tab.presenter;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.window.shop.product.pinrecyclerview.ECRecyclerViewPinnableLayout;
import com.bytedance.android.window.shop.widget.SortBarView;
import com.bytedance.android.window.shop.widget.ToolBarView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class u implements Runnable {
    public final /* synthetic */ ECWindowTabPresenterDeprecated a;
    public final /* synthetic */ RecyclerView b;

    public u(ECWindowTabPresenterDeprecated r1, ECRecyclerViewPinnableLayout.InnerRecyclerView r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object r0 = com.bytedance.android.window.shop.widget.c.a(this.b, ToolBarView.class);     // Catch: Throwable -> L13
        if ((r0 instanceof ToolBarView) == true) goto L5;
        r0 = null;
    L5:
        ToolBarView r1 = (ToolBarView) r0;     // Catch: Throwable -> L13
        if (r1 == null) goto L16;
        ECWindowTabPresenterDeprecated r2 = this.a;     // Catch: Throwable -> L13
        int r3 = ECWindowTabPresenterDeprecated.x;     // Catch: Throwable -> L13
        r2.getClass();     // Catch: Throwable -> L13
        SortBarView r4 = r1.getSortBarView();     // Catch: Throwable -> L13
        if (r4 == null) goto L11;
        r4.a("resort", new ECWindowTabPresenterDeprecated$onSortBarInitialized$1(r2));     // Catch: Throwable -> L13
    L11:
        ECWindowTabPresenterDeprecated r5 = this.a;     // Catch: Throwable -> L13
        r5.getClass();     // Catch: Throwable -> L13
        r1.setDoEventAction(new ECWindowTabPresenterDeprecated$onLayoutControlInitialized$1(r5));     // Catch: Throwable -> L13
        r1.setLayoutChangeCallback(new ECWindowTabPresenterDeprecated$onLayoutControlInitialized$2(r5));     // Catch: Throwable -> L13
        return;
    L16:
        return;
    L13:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L20;
        throw th;
    }
}
