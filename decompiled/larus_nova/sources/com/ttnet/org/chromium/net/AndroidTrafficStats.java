package com.ttnet.org.chromium.net;

import android.net.TrafficStats;
import android.os.Process;
import com.ttnet.org.chromium.base.annotations.JNINamespace;

/* JADX INFO: loaded from: classes41.dex */
@JNINamespace("net::android::traffic_stats")
public class AndroidTrafficStats {
    private AndroidTrafficStats() {
    }

    private static long getCurrentUidRxBytes() {
        long r100 = TrafficStats.getUidRxBytes(Process.myUid());
        if (r100 != (-1)) goto L7;
        return 0;
    L7:
        return r100;
    }

    private static long getCurrentUidTxBytes() {
        long r100 = TrafficStats.getUidTxBytes(Process.myUid());
        if (r100 != (-1)) goto L7;
        return 0;
    L7:
        return r100;
    }

    private static long getTotalRxBytes() {
        long r100 = TrafficStats.getTotalRxBytes();
        if (r100 != (-1)) goto L7;
        return 0;
    L7:
        return r100;
    }

    private static long getTotalTxBytes() {
        long r100 = TrafficStats.getTotalTxBytes();
        if (r100 != (-1)) goto L7;
        return 0;
    L7:
        return r100;
    }
}
