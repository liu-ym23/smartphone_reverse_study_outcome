package com.bytedance.android.livesdk.livecommerce.iron.ui;

import com.bytedance.android.ec.model.live.t;
import com.larus.apm.impl.protector.RunnableProtector;
import sg2.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f implements Runnable {
    public final /* synthetic */ xi2.j a;
    public final /* synthetic */ gi2.a b;

    public f(xi2.j r1, gi2.a r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        t r0 = this.a.i();     // Catch: Throwable -> L16
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.b() == null) goto L23;
        String r2 = r0.b();     // Catch: Throwable -> L16
        if (r2 != null) goto L10;
        r2 = "";
    L10:
        com.bytedance.android.ec.common.api.jump.model.a r3 = this.b;     // Catch: Throwable -> L16
        if (r3 != null) goto L14;
        r3 = com.bytedance.android.ec.common.api.jump.model.b.a;     // Catch: Throwable -> L16
    L14:
        v r1 = new v(r2, r3);     // Catch: Throwable -> L16
        r1.d(r0.c());     // Catch: Throwable -> L16
        r1.i("a1.b0715.c9204.d242353");     // Catch: Throwable -> L16
        return;
    L23:
        return;
    L16:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L24;
        throw th;
    }
}
