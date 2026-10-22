package com.lynx.tasm.core;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.base.LLog;

/* JADX INFO: loaded from: classes32.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f383291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f383292b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f383293c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ LynxEngineProxy f383294d;

    @Override // java.lang.Runnable
    public final void run() {
        LynxEngineProxy r100 = this.f383294d;     // Catch: Throwable -> L7
        long r101 = r100.f383244a;     // Catch: Throwable -> L7
        if (r101 != 0) goto L5;
        LLog.e("LynxEngineProxy", "invokeLepusApiCallback failed since mNativePtr is null");     // Catch: Throwable -> L7
    L12:
        return;
    L5:
        LynxEngineProxy.k(r100, r101, this.f383291a, this.f383292b, this.f383293c);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L15;
        throw th;
    }

    public k(LynxEngineProxy r100, int r101, String r102, Object r103) {
        this.f383294d = r100;
        this.f383291a = r101;
        this.f383292b = r102;
        this.f383293c = r103;
    }
}
