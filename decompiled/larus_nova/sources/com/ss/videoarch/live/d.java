package com.ss.videoarch.live;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

/* JADX INFO: loaded from: classes38.dex */
public final class d extends ConnectivityManager.NetworkCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b.i f458588a;

    public d(b.i r100) {
        this.f458588a = r100;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network r100) {
        if (r100 != null) goto L16;
        return;
    L16:
        NetworkCapabilities r101 = this.f458588a.f458580a.getNetworkCapabilities(r100);     // Catch: Throwable -> L13
        if (r101 != null) goto L7;
    L11:
        b.i r102 = this.f458588a;     // Catch: Throwable -> L13
        b.i.b(r102, r102.f458583d);     // Catch: Throwable -> L13
        return;
    L7:
        if (r101.hasTransport(1) == false) goto L11;
        if (r101.hasCapability(12) == false) goto L11;
        this.f458588a.f458582c = r100.getNetworkHandle();     // Catch: Throwable -> L13
        this.f458588a.f458583d |= 1;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network r100) {
        if (r100 == null) goto L13;
        b.i r101 = this.f458588a;
        if (r101.f458580a == null) goto L14;
        long r102 = r101.f458582c;
        if (r102 != 0) goto L9;
    L11:
        b.i r103 = this.f458588a;
        b.i.b(r103, r103.f458583d);
        return;
    L9:
        if (r102 != r100.getNetworkHandle()) goto L11;
        b.i r104 = this.f458588a;
        r104.f458582c = 0;
        r104.f458583d &= -2;
        goto L11
    L14:
        return;
    }
}
