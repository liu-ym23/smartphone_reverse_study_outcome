package com.bytedance.android.shopping.store.live;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements Runnable {
    public final /* synthetic */ ECShopFloatLivePresenter.b a;

    public a(ECShopFloatLivePresenter.b r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    L3:
        if (com.bytedance.android.shopping.store.settings.a.a() == false) goto L5;
        this.a.a.T().getLiveManager().f(true);     // Catch: Throwable -> L7
    L5:
        im.b r0 = this.a.a.T().getLiveManager();     // Catch: Throwable -> L7
        int r1 = im.b.q;     // Catch: Throwable -> L7
        r0.a(false);     // Catch: Throwable -> L7
    }
}
