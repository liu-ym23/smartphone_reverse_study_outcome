package com.bytedance.crypto.monitor;

import android.util.EventsUtils;
import com.bytedance.crypto.monitor.proto.CryptoSDKInfo;
import com.bytedance.crypto.utils.LogUtils;

/* JADX INFO: loaded from: classes15.dex */
public class Monitor {
    private static final String TAG = "Monitor";

    public Monitor() {
    }

    public static void writeEvent(CryptoSDKInfo.Builder r100) {
        LogUtils.d(TAG, "writeEvent cryptoSDKInfo: " + r100.toString());
        EventsUtils.writePbEventSinlgeFile(System.currentTimeMillis(), 99, r100.build().toByteArray());
    }
}
