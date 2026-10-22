package com.bytedance.locallife.live.card;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f259244a;

    public k(String r100) {
        this.f259244a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r100 = com.bytedance.locallife.live.util.l.f260717d;     // Catch: Throwable -> L4
        com.bytedance.locallife.live.util.l.a.d(this.f259244a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
