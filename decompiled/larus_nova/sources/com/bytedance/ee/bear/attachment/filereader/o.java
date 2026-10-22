package com.bytedance.ee.bear.attachment.filereader;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes15.dex */
public final class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h.a f206408a;

    public o(h.a r100) {
        this.f206408a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f206408a.a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
