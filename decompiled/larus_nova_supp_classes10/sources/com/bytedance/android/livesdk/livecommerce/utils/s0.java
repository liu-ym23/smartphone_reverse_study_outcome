package com.bytedance.android.livesdk.livecommerce.utils;

import android.os.Handler;
import com.bytedance.bdlocation.sensor.SensorBatchGpsCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class s0 {
    public static long a;

    public static boolean a() {
        Handler r0 = k.a;
        long r1 = System.currentTimeMillis();
        if (Math.abs(r1 - a) < SensorBatchGpsCollector.DEFAULT_NETWORK_FALLBACK_TIMEOUT_MS) goto L6;
        a = r1;
        return true;
    L6:
        return false;
    }
}
