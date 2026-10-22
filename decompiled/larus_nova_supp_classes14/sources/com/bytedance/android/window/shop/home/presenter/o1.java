package com.bytedance.android.window.shop.home.presenter;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class o1 implements Runnable {
    public final /* synthetic */ q1 a;

    public o1(q1 r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ECWindowLinkageHeaderLivePresenter r0 = this.a.a;     // Catch: Throwable -> L6
        if (r0.p == true) goto L9;
        yn.d.i(r0.O().getLiveManager(), false, 3);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
