package com.bytedance.ee.bear.sheet.filter;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f0 implements Runnable {
    public final /* synthetic */ SubFilterValueFragment a;

    public f0(SubFilterValueFragment r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SubFilterValueFragment r0 = this.a;     // Catch: Throwable -> L6
        int r1 = r0.G;     // Catch: Throwable -> L6
        FilterViewModel.c r2 = r0.Z90().getFilterValueDelegate();     // Catch: Throwable -> L6
        if (r2 == null) goto L9;
        r2.a(r1, r0.m, r0.l);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
