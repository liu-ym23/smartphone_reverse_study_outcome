package com.bytedance.bdlocation.scan.networklistener;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.bytedance.bdlocation.log.Logger;

/* JADX INFO: loaded from: classes10.dex */
public class NetworkCallbackImpl extends ConnectivityManager.NetworkCallback {
    private Network lastNetWork;

    public NetworkCallbackImpl() {
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network r100) {
        super.onAvailable(r100);
        Logger.i("NetworkCallback:onAvailable: 网络已连接");
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLost(Network r100) {
        super.onLost(r100);
        Logger.i("NetworkCallback:onLost: 网络已断开");
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onCapabilitiesChanged(Network r100, NetworkCapabilities r101) {
        super.onCapabilitiesChanged(r100, r101);
        if (r100 == null) goto L20;
        if (r101 == null) goto L21;
        Logger.i(NetworkManager.TAG + ":NetworkCallback:onCapabilitiesChanged network：" + r100.toString());
        if (this.lastNetWork == null) goto L10;
        Logger.i(NetworkManager.TAG + ":NetworkCallback:onCapabilitiesChanged lastNetWork：" + this.lastNetWork.toString());
    L10:
        if (r100.equals(this.lastNetWork) == false) goto L18;
        Logger.i(NetworkManager.TAG + ":NetworkCallback:onCapabilitiesChanged: 相同network");
        return;
    L18:
        Logger.i(NetworkManager.TAG + ":NetworkCallback:resetPollUploadScheduleNetWorkChange");     // Catch: Exception -> L15
        NetworkManager.getInstance().notifyWifiChanged(r100, r101);     // Catch: Exception -> L15
        this.lastNetWork = r100;     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        Logger.e(NetworkManager.TAG + ":NetworkCallback:onCapabilitiesChanged error", e);
        return;
    L21:
        return;
    }
}
