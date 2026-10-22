package com.bytedance.android.livesdk.ktvimpl.realtimechorus.midi;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class p implements Runnable {
    public final /* synthetic */ RealTimeChorusMidiWidget a;

    public p(RealTimeChorusMidiWidget r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b r0 = this.a.n;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.c();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
