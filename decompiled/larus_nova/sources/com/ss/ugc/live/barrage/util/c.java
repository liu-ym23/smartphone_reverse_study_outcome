package com.ss.ugc.live.barrage.util;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes36.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f458149a;

    public c(d r100) {
        this.f458149a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f458149a.getClass();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
