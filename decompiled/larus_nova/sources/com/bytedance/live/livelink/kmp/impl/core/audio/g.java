package com.bytedance.live.livelink.kmp.impl.core.audio;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes19.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f255378a;

    public g(f r100) {
        this.f255378a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        StringBuilder r100 = this.f255378a.f255372b;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.setLength(0);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
