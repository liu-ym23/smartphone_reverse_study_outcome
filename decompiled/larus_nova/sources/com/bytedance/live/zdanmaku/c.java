package com.bytedance.live.zdanmaku;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes19.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DanmakuController f255831a;

    public c(DanmakuController r100) {
        this.f255831a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DanmakuController r100 = this.f255831a;     // Catch: Throwable -> L6
        r100.f255820j = true;     // Catch: Throwable -> L6
        i r101 = r100.f255811a;     // Catch: Throwable -> L6
        if (r101 == null) goto L9;
        r101.stop();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
