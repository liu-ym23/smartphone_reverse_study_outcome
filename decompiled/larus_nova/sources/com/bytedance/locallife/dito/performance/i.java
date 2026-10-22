package com.bytedance.locallife.dito.performance;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DitoPagePerformancePlugin f258553a;

    public i(DitoPagePerformancePlugin r100) {
        this.f258553a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f258553a.f258526c.g(Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
