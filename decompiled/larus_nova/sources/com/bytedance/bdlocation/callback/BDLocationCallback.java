package com.bytedance.bdlocation.callback;

import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.exception.BDLocationException;

/* JADX INFO: loaded from: classes10.dex */
public interface BDLocationCallback {
    void onError(BDLocationException r100);

    void onLocationChanged(BDLocation r100);
}
