package com.bytedance.lynx.webview.adblock;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TTAdblockClient f265055a;

    @Override // java.lang.Runnable
    public final void run() {
        TTAdblockClient r100 = this.f265055a;     // Catch: Throwable -> L4
        r100.g(r100.e());     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(TTAdblockClient r100) {
        this.f265055a = r100;
    }
}
