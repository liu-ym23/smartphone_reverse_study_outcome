package com.lynx.tasm.behavior;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes32.dex */
public final class c0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d0 f382000a;

    @Override // java.lang.Runnable
    public final void run() {
        this.f382000a.f382001v.clear();     // Catch: Throwable -> L4
        this.f382000a.c();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c0(d0 r100) {
        this.f382000a = r100;
    }
}
