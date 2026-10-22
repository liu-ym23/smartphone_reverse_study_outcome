package com.bytedance.common.utility;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkConnectChangeReceiver extends BroadcastReceiver {
    public NetworkConnectChangeReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r100, Intent r101) {
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(r101.getAction()) == false) goto L5;
    L8:
        NetworkUtils.setNetworkType(NetworkUtils.getNetworkType(r100));
        return;
    L5:
        if ("android.net.wifi.WIFI_STATE_CHANGED".equals(r101.getAction()) == true) goto L8;
        if ("android.net.wifi.STATE_CHANGE".equals(r101.getAction()) == true) goto L8;
    }
}
