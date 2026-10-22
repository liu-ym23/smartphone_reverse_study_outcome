package com.bytedance.bdlocation.trace;

import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.callback.LocateCallback;
import com.bytedance.bdlocation.exception.BDLocationException;

/* JADX INFO: loaded from: classes10.dex */
public interface TraceCallback extends LocateCallback {
    void onError(BDLocationException r100);

    void onLocationChanged(BDLocation r100);

    void onStart(LocationTrace r100);

    void onStop();
}
