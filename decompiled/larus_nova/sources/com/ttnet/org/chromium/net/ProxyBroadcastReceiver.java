package com.ttnet.org.chromium.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes5.dex */
final class ProxyBroadcastReceiver extends BroadcastReceiver {
    private final ProxyChangeListener mListener;

    public ProxyBroadcastReceiver(ProxyChangeListener r100) {
        this.mListener = r100;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r100, Intent r101) {
        if (r101.getAction().equals("android.intent.action.PROXY_CHANGE") == false) goto L6;
        this.mListener.updateProxyConfigFromConnectivityManager(r101);
        return;
    }
}
