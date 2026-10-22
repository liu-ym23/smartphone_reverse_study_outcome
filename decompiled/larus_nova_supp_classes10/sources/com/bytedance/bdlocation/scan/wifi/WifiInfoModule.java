package com.bytedance.bdlocation.scan.wifi;

import com.bytedance.bdlocation.network.model.WifiInfo;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class WifiInfoModule {
    public final long cacheWifiTime;
    public final WifiInfo connectWifi;
    public final List<WifiInfo> wifiInfoList;

    public WifiInfoModule(List<WifiInfo> r1, WifiInfo r2, long r3) {
        this.wifiInfoList = r1;
        this.connectWifi = r2;
        this.cacheWifiTime = r3;
    }
}
