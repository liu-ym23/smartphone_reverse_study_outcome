package vj7;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* JADX INFO: loaded from: classes22.dex */
public final class a extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f555420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f555421b;

    public a(b r100) {
        this.f555421b = r100;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        NetworkInfo r102 = ((ConnectivityManager) r100.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L14
        if (r102 == null) goto L7;
        if (r102.isConnected() == false) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == false) goto L17;
        long r104 = System.currentTimeMillis();
        if ((r104 - this.f555420a) >= 1000) goto L12;
        return;
    L12:
        this.f555420a = r104;
        this.f555421b.a("networkChange");
        return;
    L17:
        return;
    L7:
        r103 = false;
        goto L8
    }
}
