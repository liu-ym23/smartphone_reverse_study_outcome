package com.bytedance.ee.bear.attachment.filereader;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes15.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h.a f206399a;

    @Override // java.lang.Runnable
    public final void run() {
        h.a r100 = this.f206399a;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.c();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public g(h.a r100) {
        this.f206399a = r100;
    }
}
