package com.facebook.common.time;

/* JADX INFO: loaded from: classes3.dex */
public class SystemClock implements Clock {
    private static final SystemClock INSTANCE = null;

    static {
        INSTANCE = new SystemClock();
    }

    @Override // com.facebook.common.time.Clock
    public long now() {
        return System.currentTimeMillis();
    }

    private SystemClock() {
    }

    public static SystemClock get() {
        return INSTANCE;
    }
}
