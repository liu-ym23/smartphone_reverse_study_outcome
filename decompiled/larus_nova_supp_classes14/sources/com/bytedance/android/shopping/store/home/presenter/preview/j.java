package com.bytedance.android.shopping.store.home.presenter.preview;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j implements Runnable {
    public final /* synthetic */ ECShopLivePreviewPresenter a;

    public j(ECShopLivePreviewPresenter r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        im.b r0 = this.a.p0();     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        int r1 = im.b.q;     // Catch: Throwable -> L6
        r0.a(false);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
