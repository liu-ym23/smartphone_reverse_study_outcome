package com.obric.assistant.ipc;

import android.net.ConnectivityManager;
import android.net.Network;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class j extends ConnectivityManager.NetworkCallback {
    public j() {
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network r100) {
        Intrinsics.checkNotNullParameter(r100, "network");
        k.f389988a.getClass();
        k.b("network_available");
    }
}
