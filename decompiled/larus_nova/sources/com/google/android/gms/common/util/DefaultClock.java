package com.google.android.gms.common.util;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes23.dex */
public class DefaultClock implements Clock {

    /* JADX INFO: renamed from: zza, reason: collision with root package name */
    private static final DefaultClock f274603zza = null;

    static {
        f274603zza = new DefaultClock();
    }

    private DefaultClock() {
    }

    public static Clock getInstance() {
        return f274603zza;
    }

    @Override // com.google.android.gms.common.util.Clock
    public final long currentThreadTimeMillis() {
        return SystemClock.currentThreadTimeMillis();
    }

    @Override // com.google.android.gms.common.util.Clock
    public final long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    @Override // com.google.android.gms.common.util.Clock
    public final long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }

    @Override // com.google.android.gms.common.util.Clock
    public final long nanoTime() {
        return System.nanoTime();
    }
}
