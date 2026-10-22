package com.bytedance.bdlocation.callback;

import com.bytedance.bdlocation.exception.BDLocationException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface BDBeaconCallback {
    void onFail(BDLocationException r1);

    void onSuccess();
}
