package com.bytedance.locallife.pdp.container.view.lynx;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f261319a;

    public e(d r100) {
        this.f261319a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d.a(this.f261319a, new LynxLoader.LoadTimeoutException());     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
