package com.bytedance.ee.bear.attachment.filereader;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes15.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h.a f206398a;

    @Override // java.lang.Runnable
    public final void run() {
        h.a r100 = this.f206398a;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.b();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public f(h.a r100, int r101) {
        this.f206398a = r100;
    }
}
