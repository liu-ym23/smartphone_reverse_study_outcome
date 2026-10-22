package com.bytedance.android.shopping.store.home.presenter;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class v1 implements Runnable {
    public final /* synthetic */ w1 a;

    public v1(w1 r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        im.b r0 = this.a.T().getLiveManager();     // Catch: Throwable -> L4
        int r1 = im.b.q;     // Catch: Throwable -> L4
        r0.a(false);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
