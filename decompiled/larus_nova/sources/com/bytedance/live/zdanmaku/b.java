package com.bytedance.live.zdanmaku;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DanmakuController f255830a;

    public b(DanmakuController r100) {
        this.f255830a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i r100 = this.f255830a.f255811a;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.stop();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
