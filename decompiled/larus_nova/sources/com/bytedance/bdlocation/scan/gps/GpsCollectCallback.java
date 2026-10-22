package com.bytedance.bdlocation.scan.gps;

/* JADX INFO: loaded from: classes10.dex */
public interface GpsCollectCallback {
    void onFail(int r100);

    void onSuccess(BDScanLocationInfo r100);
}
