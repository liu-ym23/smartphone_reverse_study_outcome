package com.bytedance.common.wschannel.utils;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes15.dex */
public class TimeCompactUtil {
    public static long getTimeStampNanos() {
        return SystemClock.elapsedRealtimeNanos();
    }
}
