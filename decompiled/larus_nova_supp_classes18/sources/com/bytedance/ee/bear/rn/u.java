package com.bytedance.ee.bear.rn;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class u implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ Map<String, Object> b;

    public u(Map r2) {
        this.a = "dev_performance_rn_error";
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.ee.bear.contract.d r0 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.v(this.a, this.b);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
