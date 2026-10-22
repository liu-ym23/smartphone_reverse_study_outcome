package com.bytedance.bdlocation.callback;

import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.exception.BDLocationException;

/* JADX INFO: loaded from: classes3.dex */
public interface LocateCallback {
    void onLocateChange(String r100, BDLocation r101);

    void onLocateError(String r100, BDLocationException r101);

    void onLocateStart(String r100);

    void onLocateStop(String r100);
}
