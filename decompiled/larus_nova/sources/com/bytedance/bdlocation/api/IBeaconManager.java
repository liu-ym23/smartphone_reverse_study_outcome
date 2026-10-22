package com.bytedance.bdlocation.api;

import com.bytedance.bdlocation.callback.BDBeaconCallback;

/* JADX INFO: loaded from: classes10.dex */
public interface IBeaconManager extends IManager {
    void startBeaconTask(String r100, BDBeaconCallback r101);

    void stopBeaconTask();
}
