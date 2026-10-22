package com.bytedance.bdlocation.network.model;

import com.bytedance.bdlocation.scan.gps.BDGpsInfo;

/* JADX INFO: loaded from: classes10.dex */
public class StationarySceneCacheInfo {
    private BDGpsInfo gpsInfo;
    private String locateId;
    private LocationResult locationResult;

    public StationarySceneCacheInfo() {
    }

    public BDGpsInfo getGpsInfo() {
        return this.gpsInfo;
    }

    public String getLocateId() {
        return this.locateId;
    }

    public LocationResult getLocationResult() {
        return this.locationResult;
    }

    public void setGpsInfo(BDGpsInfo r100) {
        this.gpsInfo = r100;
    }

    public void setLocateId(String r100) {
        this.locateId = r100;
    }

    public void setLocationResult(LocationResult r100) {
        this.locationResult = r100;
    }
}
