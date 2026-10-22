package com.bytedance.ee.bear.bitable.homepage.chart;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes15.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f212596a;

    public j(i r100) {
        this.f212596a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i.c(this.f212596a, 0, 0, false, 7);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
