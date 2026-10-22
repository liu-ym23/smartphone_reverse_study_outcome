package com.lynx.tasm.core;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.base.LLog;

/* JADX INFO: loaded from: classes32.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f383269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f383270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LynxEngineProxy f383271c;

    @Override // java.lang.Runnable
    public final void run() {
        LynxEngineProxy r100 = this.f383271c;     // Catch: Throwable -> L7
        long r101 = r100.f383244a;     // Catch: Throwable -> L7
        if (r101 != 0) goto L5;
        LLog.e("LynxEngineProxy", "startEventFire failed since mNativePtr is null");     // Catch: Throwable -> L7
    L12:
        return;
    L5:
        LynxEngineProxy.d(r100, r101, this.f383269a, this.f383270b);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L15;
        throw th;
    }

    public c(LynxEngineProxy r100, boolean r101, long r102) {
        this.f383271c = r100;
        this.f383269a = r101;
        this.f383270b = r102;
    }
}
