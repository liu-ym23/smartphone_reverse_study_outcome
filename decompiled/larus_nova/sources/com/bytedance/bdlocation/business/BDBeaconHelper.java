package com.bytedance.bdlocation.business;

import com.bytedance.bdlocation.callback.BDBeaconCallback;
import com.bytedance.bdlocation.service.BDLocationExtrasService;

/* JADX INFO: loaded from: classes10.dex */
public class BDBeaconHelper {
    public BDBeaconHelper() {
    }

    public static void stopBeaconTask() {
        BDLocationExtrasService.getBeaconManager().stopBeaconTask();
    }

    public static void startBeaconTask(String r100, BDBeaconCallback r101) {
        BDLocationExtrasService.getBeaconManager().startBeaconTask(r100, r101);
    }
}
