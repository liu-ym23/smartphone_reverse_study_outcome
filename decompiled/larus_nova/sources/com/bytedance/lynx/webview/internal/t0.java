package com.bytedance.lynx.webview.internal;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class t0 implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        Setting.f265160l = true;     // Catch: Throwable -> L5
        g.e().h();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L9;
        return;
    L9:
        throw th;
    }

    public t0() {
    }
}
