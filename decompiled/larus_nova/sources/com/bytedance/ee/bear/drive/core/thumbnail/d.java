package com.bytedance.ee.bear.drive.core.thumbnail;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes16.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f224368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f224369b;

    public d(b r100, int r101) {
        this.f224368a = r100;
        this.f224369b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b r100 = this.f224368a;     // Catch: Throwable -> L4
        r100.f224366i = null;     // Catch: Throwable -> L4
        r100.a(this.f224369b, false);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
