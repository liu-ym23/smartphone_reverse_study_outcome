package com.bytedance.lynx.webview.internal;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class o0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TTAdblockContext f265345a;

    @Override // java.lang.Runnable
    public final void run() {
        this.f265345a.getClass();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public o0(TTAdblockContext r100, String r101) {
        this.f265345a = r100;
    }
}
