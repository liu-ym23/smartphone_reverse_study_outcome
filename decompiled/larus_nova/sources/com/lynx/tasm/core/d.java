package com.lynx.tasm.core;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes32.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxEngineProxy f383272a;

    @Override // java.lang.Runnable
    public final void run() {
        LynxEngineProxy r100 = this.f383272a;     // Catch: Throwable -> L4
        LynxEngineProxy.a(r100, r100.f383244a);     // Catch: Throwable -> L4
        this.f383272a.f383244a = 0;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public d(LynxEngineProxy r100) {
        this.f383272a = r100;
    }
}
