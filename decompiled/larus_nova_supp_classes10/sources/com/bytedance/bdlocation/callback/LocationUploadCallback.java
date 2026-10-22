package com.bytedance.bdlocation.callback;

import com.bytedance.bdlocation.network.model.WifiInfo;
import com.bytedance.bdlocation.network.response.LocationResp;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface LocationUploadCallback {
    void onError(String r1);

    void onSuccess(LocationResp r1, boolean r2, WifiInfo r3);
}
