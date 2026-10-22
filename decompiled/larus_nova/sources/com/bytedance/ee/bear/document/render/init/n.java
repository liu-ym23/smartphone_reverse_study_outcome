package com.bytedance.ee.bear.document.render.init;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes16.dex */
public final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ bk5.a f221311a;

    public n(bk5.a r100) {
        this.f221311a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f221311a.w();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
