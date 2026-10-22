package com.bytedance.bdlocation.scan.networklistener;

import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;

/* JADX INFO: loaded from: classes10.dex */
public interface WifiChangeListener {
    void notifyWifiChanged(Network r100, NetworkCapabilities r101);

    void notifyWifiChangedTwo(NetworkInfo r100);
}
