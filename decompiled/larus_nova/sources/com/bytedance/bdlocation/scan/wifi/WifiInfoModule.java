package com.bytedance.bdlocation.scan.wifi;

import com.bytedance.bdlocation.network.model.WifiInfo;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class WifiInfoModule {
    public final long cacheWifiTime;
    public final WifiInfo connectWifi;
    public final List<WifiInfo> wifiInfoList;

    public WifiInfoModule(List<WifiInfo> r100, WifiInfo r101, long r102) {
        this.wifiInfoList = r100;
        this.connectWifi = r101;
        this.cacheWifiTime = r102;
    }
}
