package com.ss.android.bytedcert.face;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes34.dex */
public final class t implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ksa.a.InterfaceC6605a f407430a;

    @Override // java.lang.Runnable
    public final void run() {
        this.f407430a.onStopped();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public t(s r100) {
        this.f407430a = r100;
    }
}
