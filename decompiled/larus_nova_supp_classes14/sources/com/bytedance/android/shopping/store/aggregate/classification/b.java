package com.bytedance.android.shopping.store.aggregate.classification;

import com.bytedance.android.ui.base.widget.tablayout.ECTabLayout;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements Runnable {
    public final /* synthetic */ ShopClassificationFilterPresenter a;
    public final /* synthetic */ ECTabLayout b;

    public b(ShopClassificationFilterPresenter r1, ECTabLayout r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.selectTabWithoutAnimation(this.a.k);     // Catch: Throwable -> L4
        ShopClassificationFilterPresenter.D(this.a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
