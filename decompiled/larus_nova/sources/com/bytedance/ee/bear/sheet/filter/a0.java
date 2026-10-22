package com.bytedance.ee.bear.sheet.filter;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes18.dex */
public final class a0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeSubFilterValueFragment f237836a;

    public a0(OfficeSubFilterValueFragment r100) {
        this.f237836a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        OfficeSubFilterValueFragment r100 = this.f237836a;     // Catch: Throwable -> L6
        int r101 = r100.G;     // Catch: Throwable -> L6
        FilterViewModel.c r102 = r100.Z90().getFilterValueDelegate();     // Catch: Throwable -> L6
        if (r102 == null) goto L9;
        r102.a(r101, r100.f237727m, r100.f237726l);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
