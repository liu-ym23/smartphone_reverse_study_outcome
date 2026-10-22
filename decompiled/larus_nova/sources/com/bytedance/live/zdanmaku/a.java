package com.bytedance.live.zdanmaku;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DanmakuController f255829a;

    public a(DanmakuController r100) {
        this.f255829a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DanmakuController r100 = this.f255829a;     // Catch: Throwable -> L8
        if (r100.f255820j == true) goto L11;
        i r101 = r100.f255811a;     // Catch: Throwable -> L8
        if (r101 == null) goto L15;
        r101.start();     // Catch: Throwable -> L8
        return;
    L15:
        return;
    L11:
        return;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
