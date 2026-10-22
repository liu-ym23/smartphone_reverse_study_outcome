package com.lynx.tasm.core;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.base.LLog;

/* JADX INFO: loaded from: classes32.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f383265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LynxEngineProxy f383266b;

    @Override // java.lang.Runnable
    public final void run() {
        LynxEngineProxy r100 = this.f383266b;     // Catch: Throwable -> L7
        long r101 = r100.f383244a;     // Catch: Throwable -> L7
        if (r101 != 0) goto L5;
        LLog.e("LynxEngineProxy", "startEventCapture failed since mNativePtr is null");     // Catch: Throwable -> L7
    L12:
        return;
    L5:
        LynxEngineProxy.b(r100, r101, this.f383265a);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L15;
        throw th;
    }

    public a(LynxEngineProxy r100, long r101) {
        this.f383266b = r100;
        this.f383265a = r101;
    }
}
