package com.obric.assistant.zeus.plugin;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class b extends ConnectivityManager.NetworkCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ConnectivityManager f395035a;

    public b(ConnectivityManager r100) {
        this.f395035a = r100;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network r100) {
        Intrinsics.checkNotNullParameter(r100, "network");
        super.onAvailable(r100);
        NetworkCapabilities r101 = this.f395035a.getNetworkCapabilities(r100);
        if (r101 == null) goto L7;
        boolean r102 = true;
        if (r101.hasTransport(1) != true) goto L7;
    L8:
        if (r102 == true) goto L10;
        return;
    L10:
        if (r101.hasCapability(11) == false) goto L14;
        FLogger.f375446a.i("ZeusAutoFetchManager", "Connected to unmetered WiFi, triggering fetch for all plugins");
        c r103 = c.f395036a;
        c.c("unmetered_wifi_available");
        return;
    L14:
        return;
    L7:
        r102 = false;
        goto L8
    }
}
