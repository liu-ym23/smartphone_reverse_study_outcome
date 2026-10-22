package com.bytedance.badger.network;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes47.dex */
public final class s0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t0 f199144a;

    public s0(t0 r100) {
        this.f199144a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f199144a.f199146b.invoke();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
