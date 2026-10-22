package com.larus.dora.impl.core;

import android.net.ConnectivityManager;
import android.net.Network;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes27.dex */
public final class w0 extends ConnectivityManager.NetworkCallback {
    public w0() {
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network r100) {
        Intrinsics.checkNotNullParameter(r100, "network");
        super.onAvailable(r100);
        g49.d.a("DoraSyncManager", "Network is connected");
        CoroutineScope r101 = DoraSyncManager.f332165a;
        DoraSyncManager.c("4");
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network r100) {
        Intrinsics.checkNotNullParameter(r100, "network");
        super.onLost(r100);
        g49.d.a("DoraSyncManager", "Network is disconnected");
    }
}
