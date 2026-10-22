package com.bytedance.ee.bear.rn;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;

/* JADX INFO: loaded from: classes18.dex */
public final class u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f236632a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map<String, Object> f236633b;

    public u(Map r100) {
        this.f236632a = "dev_performance_rn_error";
        this.f236633b = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.ee.bear.contract.d r100 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.v(this.f236632a, this.f236633b);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
