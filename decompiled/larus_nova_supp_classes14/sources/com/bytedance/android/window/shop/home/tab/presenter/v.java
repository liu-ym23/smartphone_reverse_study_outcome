package com.bytedance.android.window.shop.home.tab.presenter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.window.shop.product.pinrecyclerview.ECRecyclerViewPinnableLayout;
import com.bytedance.android.window.shop.widget.category.CategoryScrollView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class v implements Runnable {
    public final /* synthetic */ ECWindowTabPresenterDeprecated a;
    public final /* synthetic */ RecyclerView b;

    public v(ECWindowTabPresenterDeprecated r1, ECRecyclerViewPinnableLayout.InnerRecyclerView r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View r0 = com.bytedance.android.window.shop.widget.c.a(this.b, CategoryScrollView.class);     // Catch: Throwable -> L9
        if ((r0 instanceof CategoryScrollView) == true) goto L5;
        r0 = null;
    L5:
        CategoryScrollView r1 = (CategoryScrollView) r0;     // Catch: Throwable -> L9
        if (r1 == null) goto L12;
        ECWindowTabPresenterDeprecated.e0(this.a, r1);     // Catch: Throwable -> L9
        return;
    L12:
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
