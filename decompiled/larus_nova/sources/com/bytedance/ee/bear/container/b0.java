package com.bytedance.ee.bear.container;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes16.dex */
public final class b0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ bk5.a f216744a;

    public b0(bk5.a r100) {
        this.f216744a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f216744a.w();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
