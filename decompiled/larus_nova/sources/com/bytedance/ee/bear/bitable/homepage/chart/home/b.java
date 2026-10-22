package com.bytedance.ee.bear.bitable.homepage.chart.home;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f212502a;

    public b(a r100) {
        this.f212502a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.a(this.f212502a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
