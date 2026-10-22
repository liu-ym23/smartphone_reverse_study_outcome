package com.bytedance.ee.bear.sheet.filter;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes18.dex */
public final class f0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SubFilterValueFragment f237849a;

    public f0(SubFilterValueFragment r100) {
        this.f237849a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SubFilterValueFragment r100 = this.f237849a;     // Catch: Throwable -> L6
        int r101 = r100.G;     // Catch: Throwable -> L6
        FilterViewModel.c r102 = r100.Z90().getFilterValueDelegate();     // Catch: Throwable -> L6
        if (r102 == null) goto L9;
        r102.a(r101, r100.f237667m, r100.f237666l);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
