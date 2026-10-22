package com.bytedance.android.livesdk.livecommerce.opt;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements Runnable {
    public final /* synthetic */ String a;

    public b(String r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Map r0 = com.bytedance.android.ec.core.monitor.c.a;     // Catch: Throwable -> L4
        com.bytedance.android.ec.core.monitor.c.d(this.a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
