package com.bytedance.bdlocation.callback;

import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.exception.BDLocationException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface BDLocationCallback {
    void onError(BDLocationException r1);

    void onLocationChanged(BDLocation r1);
}
