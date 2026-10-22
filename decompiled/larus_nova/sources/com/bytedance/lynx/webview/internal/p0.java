package com.bytedance.lynx.webview.internal;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class p0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TTAdblockContext f265352a;

    @Override // java.lang.Runnable
    public final void run() {
        EventType r100 = EventType.ADBLOCK_EFFECTIVE_DELAY;     // Catch: Throwable -> L4
        this.f265352a.getClass();     // Catch: Throwable -> L4
        EventStatistics.e(r100, Boolean.valueOf(TTAdblockContext.c()));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public p0(TTAdblockContext r100) {
        this.f265352a = r100;
    }
}
