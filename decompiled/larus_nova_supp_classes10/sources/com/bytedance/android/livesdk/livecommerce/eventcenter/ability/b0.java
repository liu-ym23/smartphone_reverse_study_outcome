package com.bytedance.android.livesdk.livecommerce.eventcenter.ability;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b0 implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ Map b;

    public b0(String r1, Map r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r1 = this.a;     // Catch: Throwable -> L7
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        com.bytedance.android.livesdk.livecommerce.event.c r0 = new com.bytedance.android.livesdk.livecommerce.event.c(r1);     // Catch: Throwable -> L7
        r0.g(this.b);     // Catch: Throwable -> L7
        r0.k();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
