package com.bytedance.bdlocation.scan.bluetooth;

import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class BLECacheEntity {
    private List<BDBleInfo> bleInfoList;
    private long timeStamp;

    public BLECacheEntity() {
    }

    public List<BDBleInfo> getBleInfoList() {
        return this.bleInfoList;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public void setBleInfoList(List<BDBleInfo> r100) {
        this.bleInfoList = r100;
    }

    public void setTimeStamp(long r100) {
        this.timeStamp = r100;
    }
}
