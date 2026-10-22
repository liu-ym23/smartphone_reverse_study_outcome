package com.bytedance.reparo;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f267456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Throwable f267457b;

    @Override // java.lang.Runnable
    public final void run() {
        String r100 = this.f267456a;     // Catch: Throwable -> L6
        Throwable r101 = this.f267457b;     // Catch: Throwable -> L6
        k r102 = k.f267459b;     // Catch: Throwable -> L6
        if (r102 == null) goto L9;
        r102.f267460a.e().g(r100, null, r101, "core_exception_monitor");     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public i(String r100, Throwable r101) {
        this.f267456a = r100;
        this.f267457b = r101;
    }
}
