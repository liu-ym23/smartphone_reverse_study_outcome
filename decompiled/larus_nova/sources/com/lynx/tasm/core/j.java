package com.lynx.tasm.core;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.base.LLog;

/* JADX INFO: loaded from: classes32.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f383287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f383288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f383289c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ LynxEngineProxy f383290d;

    @Override // java.lang.Runnable
    public final void run() {
        LynxEngineProxy r100 = this.f383290d;     // Catch: Throwable -> L7
        long r101 = r100.f383244a;     // Catch: Throwable -> L7
        if (r101 != 0) goto L5;
        LLog.e("LynxEngineProxy", "OnPseudoStatusChanged failed since mNativePtr is null");     // Catch: Throwable -> L7
    L12:
        return;
    L5:
        LynxEngineProxy.j(r100, r101, this.f383287a, this.f383288b, this.f383289c);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L15;
        throw th;
    }

    public j(LynxEngineProxy r100, int r101, int r102, int r103) {
        this.f383290d = r100;
        this.f383287a = r101;
        this.f383288b = r102;
        this.f383289c = r103;
    }
}
