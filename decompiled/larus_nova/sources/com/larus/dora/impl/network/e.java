package com.larus.dora.impl.network;

import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes27.dex */
public final class e implements hm9.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f336163a = null;

    static {
        f336163a = new e();
    }

    public e() {
    }

    @Override // hm9.v
    public final synchronized void X0(boolean r100) {
        monitor-enter(this);
        if (r100 == true) goto L15;
    L8:
        boolean r101 = false;
    L9:
        FLogger.f375446a.i("DoraBackgroundConnectionStrict", "onNetworkBlockStateChanged: pool=" + r101);     // Catch: Throwable -> L12
        com.larus.network.ttnet.h.f360237a.b(r101);     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    L15:
        if (hm9.j.f485966h.f485996z == false) goto L8;
        r101 = true;
        goto L9
    }
}
