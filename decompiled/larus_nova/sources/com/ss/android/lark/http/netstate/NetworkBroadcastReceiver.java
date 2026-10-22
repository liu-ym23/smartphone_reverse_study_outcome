package com.ss.android.lark.http.netstate;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes36.dex */
public class NetworkBroadcastReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static NetworkBroadcastReceiver f425864a;

    public NetworkBroadcastReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        if (r100 == null) goto L16;
        if (r101 != null) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r101.getAction()) == false) goto L10;
        return;
    L10:
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(r101.getAction()) == false) goto L17;
        NetworkUtils.NetworkType r102 = NetworkUtils.a(r100);     // Catch: Exception -> L13
        Log.i("NetworkBroadcastReceiver", "network change: " + r102.toString());     // Catch: Exception -> L13
        c.a.f425872a.b(r102);     // Catch: Exception -> L13
        return;
    L19:
        return;
    L17:
        return;
    }
}
