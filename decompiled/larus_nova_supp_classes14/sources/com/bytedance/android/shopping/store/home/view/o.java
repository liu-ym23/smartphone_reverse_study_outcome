package com.bytedance.android.shopping.store.home.view;

import android.view.ViewGroup;
import com.bytedance.android.ec.store.common.bubble.ECBubbleControllerManager;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class o implements Runnable {
    public final /* synthetic */ n a;

    public o(n r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        n r0 = this.a;     // Catch: Throwable -> L7
        ViewGroup r1 = r0.g;     // Catch: Throwable -> L7
        if (r1 == null) goto L5;
        r1.removeView(r0);     // Catch: Throwable -> L7
    L5:
        com.bytedance.android.ec.store.common.bubble.c r2 = ECBubbleControllerManager.b.a(r0.e);     // Catch: Throwable -> L7
        r2.d();     // Catch: Throwable -> L7
        com.bytedance.android.ec.store.common.bubble.c.e(r2);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
