package com.bytedance.bdlocation.api;

import com.bytedance.bdlocation.callback.RegionUploadCallback;
import com.bytedance.bdlocation.entity.region.RegionBean;

/* JADX INFO: loaded from: classes10.dex */
public interface IRegionDataCore extends IManager {
    RegionBean getRegion(boolean r100);

    RegionBean getRegion(boolean r100, boolean r101);

    void init();

    boolean uploadRegionInfo();

    void uploadRegionInfoAsync(RegionUploadCallback r100);
}
