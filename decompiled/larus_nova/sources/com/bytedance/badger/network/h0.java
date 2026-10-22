package com.bytedance.badger.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes47.dex */
public final class h0 extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f199108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j0 f199109b;

    public h0(j0 r100) {
        this.f199109b = r100;
        this.f199108a = true;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        boolean r102 = false;
        if (this.f199108a == false) goto L6;
        this.f199108a = false;
        return;
    L6:
        if (r101 != null) goto L9;
        return;
    L9:
        if (r101.getBooleanExtra("noConnectivity", false) == false) goto L26;
        return;
    L26:
        NetworkInfo r103 = ((ConnectivityManager) this.f199109b.f199112c.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L25
        if (r103 == null) goto L17;
        if (r103.isConnected() == false) goto L17;
        r102 = true;
    L17:
        if (r102 == false) goto L24;
        j0 r104 = this.f199109b;
        r104.getClass();
        Iterator r105 = new ArrayList(r104.f199110a).iterator();
    L20:
        if (r105.hasNext() == false) goto L33;
        i0 r106 = (i0) ((WeakReference) r105.next()).get();
        if (r106 == null) goto L20;
        r106.a();
        goto L20
    L33:
        return;
    }
}
