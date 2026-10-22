package com.facebook.battery.metrics.core;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes22.dex */
public final class SystemMetricsLogger {
    private static final AtomicReference<Delegate> DELEGATE = null;

    public interface Delegate {
        void wtf(String r100, String r101, Throwable r102);
    }

    public SystemMetricsLogger() {
    }

    static {
        DELEGATE = new AtomicReference();
    }

    public static void setDelegate(Delegate r100) {
        DELEGATE.set(r100);
    }

    public static void wtf(String r100, String r101) {
        wtf(r100, r101, null);
    }

    public static void wtf(String r100, String r101, Throwable r102) {
        Delegate r103 = DELEGATE.get();
        if (r103 == null) goto L6;
        r103.wtf(r100, r101, r102);
        return;
    }
}
