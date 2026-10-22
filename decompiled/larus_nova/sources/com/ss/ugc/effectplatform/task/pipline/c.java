package com.ss.ugc.effectplatform.task.pipline;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes36.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f457901a;

    @Override // java.lang.Runnable
    public final void run() {
        this.f457901a.getClass();     // Catch: Throwable -> L4
        throw null;     // Catch: Throwable -> L4
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(b r100, int r101, long r102) {
        this.f457901a = r100;
    }
}
