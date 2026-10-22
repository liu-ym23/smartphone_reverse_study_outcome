package com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.webp;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d implements Runnable {
    public final /* synthetic */ WebpAnimatedWidget a;

    public d(WebpAnimatedWidget r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.k = null;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
