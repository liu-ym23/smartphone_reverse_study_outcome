package com.bytedance.bdlocation.api;

import com.bytedance.bdlocation.callback.BDBeaconCallback;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface IBeaconManager extends IManager {
    void startBeaconTask(String r1, BDBeaconCallback r2);

    void stopBeaconTask();
}
