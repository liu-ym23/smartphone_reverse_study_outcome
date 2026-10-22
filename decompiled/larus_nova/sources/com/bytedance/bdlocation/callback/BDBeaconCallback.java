package com.bytedance.bdlocation.callback;

import com.bytedance.bdlocation.exception.BDLocationException;

/* JADX INFO: loaded from: classes10.dex */
public interface BDBeaconCallback {
    void onFail(BDLocationException r100);

    void onSuccess();
}
