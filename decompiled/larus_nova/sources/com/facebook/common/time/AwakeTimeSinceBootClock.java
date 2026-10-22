package com.facebook.common.time;

/* JADX INFO: loaded from: classes22.dex */
public class AwakeTimeSinceBootClock implements MonotonicClock {
    private static final AwakeTimeSinceBootClock INSTANCE = null;

    static {
        INSTANCE = new AwakeTimeSinceBootClock();
    }

    @Override // com.facebook.common.time.MonotonicClock
    public long now() {
        return android.os.SystemClock.uptimeMillis();
    }

    private AwakeTimeSinceBootClock() {
    }

    public static AwakeTimeSinceBootClock get() {
        return INSTANCE;
    }
}
