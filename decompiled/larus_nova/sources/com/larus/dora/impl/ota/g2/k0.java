package com.larus.dora.impl.ota.g2;

import com.byted.cast.common.TeaEventTrack;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class k0 {
    private String networkId;
    private l0 signature;

    public k0() {
    }

    public final synchronized void a(String r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "networkId");     // Catch: Throwable -> L6
        this.networkId = r100;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean b(String r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "networkId");     // Catch: Throwable -> L13
        if (Intrinsics.areEqual(this.networkId, r100) == true) goto L9;
        monitor-exit(this);
        return false;
    L9:
        this.networkId = null;     // Catch: Throwable -> L13
        this.signature = null;     // Catch: Throwable -> L13
        monitor-exit(this);
        return true;
    L13:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean c(l0 r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, TeaEventTrack.ACTION_DRAMA_NEXT);     // Catch: Throwable -> L10
        if (Intrinsics.areEqual(this.signature, r100) == true) goto L6;
        boolean r101 = true;
    L7:
        this.networkId = r100.b();     // Catch: Throwable -> L10
        this.signature = r100;     // Catch: Throwable -> L10
        monitor-exit(this);
        return r101;
    L6:
        r101 = false;
    L10:
        th = move-exception;
        throw th;
    }
}
