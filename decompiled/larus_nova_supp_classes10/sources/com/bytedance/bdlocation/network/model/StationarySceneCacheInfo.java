package com.bytedance.bdlocation.network.model;

import com.bytedance.bdlocation.scan.gps.BDGpsInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
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

    public void setGpsInfo(BDGpsInfo r1) {
        this.gpsInfo = r1;
    }

    public void setLocateId(String r1) {
        this.locateId = r1;
    }

    public void setLocationResult(LocationResult r1) {
        this.locationResult = r1;
    }
}
