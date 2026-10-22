package com.bytedance.bdlocation.callback;

import com.bytedance.bdlocation.network.model.WifiInfo;
import com.bytedance.bdlocation.network.response.LocationResp;

/* JADX INFO: loaded from: classes10.dex */
public interface LocationUploadCallback {
    void onError(String r100);

    void onSuccess(LocationResp r100, boolean r101, WifiInfo r102);
}
