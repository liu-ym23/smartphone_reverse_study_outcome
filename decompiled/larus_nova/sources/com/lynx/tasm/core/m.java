package com.lynx.tasm.core;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes32.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FutureTask f383297a;

    @Override // java.lang.Runnable
    public final void run() {
        this.f383297a.run();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public m(FutureTask r100) {
        this.f383297a = r100;
    }
}
