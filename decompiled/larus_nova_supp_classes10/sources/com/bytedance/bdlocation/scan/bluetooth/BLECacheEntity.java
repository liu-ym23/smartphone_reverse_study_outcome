package com.bytedance.bdlocation.scan.bluetooth;

import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
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

    public void setBleInfoList(List<BDBleInfo> r1) {
        this.bleInfoList = r1;
    }

    public void setTimeStamp(long r1) {
        this.timeStamp = r1;
    }
}
