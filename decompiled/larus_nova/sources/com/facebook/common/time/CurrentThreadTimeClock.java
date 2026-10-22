package com.facebook.common.time;

/* JADX INFO: loaded from: classes22.dex */
public class CurrentThreadTimeClock implements Clock {
    public CurrentThreadTimeClock() {
    }

    @Override // com.facebook.common.time.Clock
    public long now() {
        return android.os.SystemClock.currentThreadTimeMillis();
    }
}
