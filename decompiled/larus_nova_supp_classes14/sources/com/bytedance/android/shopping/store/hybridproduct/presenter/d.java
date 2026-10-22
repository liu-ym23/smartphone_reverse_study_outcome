package com.bytedance.android.shopping.store.hybridproduct.presenter;

import android.view.View;
import com.bytedance.android.ec.store.window.popup.ShopPopupWindowManager;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d implements Runnable {
    public final /* synthetic */ View a;
    public final /* synthetic */ ECShopHorizonSortBarPresenter b;
    public final /* synthetic */ dj3.c c;

    public d(View r1, ECShopHorizonSortBarPresenter r2, dj3.c r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r0 = ShopPopupWindowManager.a;     // Catch: Throwable -> L4
        ShopPopupWindowManager.a(this.a, t.a(this.c), this.b.Y().e(), ShopPopupWindowManager.PopupPosition.BELOW);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
