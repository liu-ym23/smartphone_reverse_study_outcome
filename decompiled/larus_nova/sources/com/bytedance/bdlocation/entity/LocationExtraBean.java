package com.bytedance.bdlocation.entity;

import com.bytedance.bdlocation.scan.bluetooth.BDBleInfo;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class LocationExtraBean {
    private List<BDBleInfo> bleInfoList;
    private LogIdCacheEntity logIdCacheEntity;

    public LocationExtraBean() {
    }

    public List<BDBleInfo> getBleInfoList() {
        return this.bleInfoList;
    }

    public LogIdCacheEntity getLogIdCacheEntity() {
        return this.logIdCacheEntity;
    }

    public void setBleInfoList(List<BDBleInfo> r100) {
        this.bleInfoList = r100;
    }

    public void setLogIdCacheEntity(LogIdCacheEntity r100) {
        this.logIdCacheEntity = r100;
    }
}
