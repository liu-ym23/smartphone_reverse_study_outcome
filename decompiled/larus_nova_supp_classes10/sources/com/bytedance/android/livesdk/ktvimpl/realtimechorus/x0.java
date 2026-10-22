package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class x0 implements Runnable {
    public final /* synthetic */ RealTimeChorusMainViewWidget a;

    public x0(RealTimeChorusMainViewWidget r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        RealTimeChorusMainViewWidget r0 = this.a;     // Catch: Throwable -> L6
        RealTimeChorusOperateView r1 = r0.t;     // Catch: Throwable -> L6
        if (r1 == null) goto L9;
        r1.U5(r0.Cq());     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
