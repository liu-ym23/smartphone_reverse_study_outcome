package com.ss.cast.discovery.ssdp;

import com.byted.cast.linkcommon.cybergarage.util.ThreadCore;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes40.dex */
public final class a extends ThreadCore {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CastDevice f456410a;

    @Override // com.byted.cast.linkcommon.cybergarage.util.ThreadCore, java.lang.Runnable
    public final void run() {
        long r100 = this.f456410a.getLeaseTime();     // Catch: Throwable -> L9
    L3:
        if (isRunnable() == false) goto L21;
        Thread.sleep(1000 * r100);     // Catch: InterruptedException -> L14 Throwable -> L9
    L7:
        this.f456410a.announce();     // Catch: Throwable -> L9
        goto L3
    L21:
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L13;
        return;
    L13:
        throw th;
    }

    public a(CastDevice r100) {
        this.f456410a = r100;
    }
}
