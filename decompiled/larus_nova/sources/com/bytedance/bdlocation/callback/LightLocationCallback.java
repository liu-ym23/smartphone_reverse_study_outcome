package com.bytedance.bdlocation.callback;

import com.bytedance.bdlocation.network.model.LocationUploadExtra;
import com.bytedance.bdlocation.network.response.LocationResp;

/* JADX INFO: loaded from: classes10.dex */
public interface LightLocationCallback {
    void onError(String r100, String r101);

    void onSuccess(LocationResp r100, LocationUploadExtra r101);
}
