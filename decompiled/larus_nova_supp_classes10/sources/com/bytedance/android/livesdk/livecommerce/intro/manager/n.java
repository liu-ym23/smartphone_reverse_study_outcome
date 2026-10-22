package com.bytedance.android.livesdk.livecommerce.intro.manager;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class n implements Runnable {
    public final /* synthetic */ com.bytedance.android.livesdk.livecommerce.intro.controller.b a;
    public final /* synthetic */ uh2.a b;
    public final /* synthetic */ boolean c;

    public n(com.bytedance.android.livesdk.livecommerce.intro.controller.b r1, uh2.a r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.android.livesdk.livecommerce.intro.controller.b.a.a(this.a, null, null, false, this.c, 7);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
