package com.bytedance.android.shopping.store.home.presenter.preview;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i implements Runnable {
    public final /* synthetic */ ECShopLivePreviewPresenter a;

    public i(ECShopLivePreviewPresenter r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ECShopLivePreviewPresenter r0 = this.a;     // Catch: Throwable -> L8
        if (r0.v == true) goto L11;
        im.b r1 = r0.p0();     // Catch: Throwable -> L8
        if (r1 == null) goto L15;
        im.b.i(r1, false, false, 3);     // Catch: Throwable -> L8
        return;
    L15:
        return;
    L11:
        return;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
