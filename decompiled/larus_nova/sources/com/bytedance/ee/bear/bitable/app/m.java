package com.bytedance.ee.bear.bitable.app;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes15.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableAppUIContainer f206946a;

    public m(BitableAppUIContainer r100) {
        this.f206946a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f206946a.p();     // Catch: Throwable -> L4
        this.f206946a.q();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
