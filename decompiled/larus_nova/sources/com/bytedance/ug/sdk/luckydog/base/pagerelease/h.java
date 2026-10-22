package com.bytedance.ug.sdk.luckydog.base.pagerelease;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes22.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PageReleaseManager f271817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f271818b;

    public h(PageReleaseManager r100, c r101, String r102, f r103) {
        this.f271817a = r100;
        this.f271818b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PageReleaseManager r100 = this.f271817a;     // Catch: Throwable -> L4
        c r101 = this.f271818b;     // Catch: Throwable -> L4
        r100.getClass();     // Catch: Throwable -> L4
        r101.getClass();     // Catch: Throwable -> L4
        throw null;     // Catch: Throwable -> L4
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
