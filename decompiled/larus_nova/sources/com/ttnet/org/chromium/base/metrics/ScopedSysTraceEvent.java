package com.ttnet.org.chromium.base.metrics;

import android.os.Trace;

/* JADX INFO: loaded from: classes41.dex */
public class ScopedSysTraceEvent implements AutoCloseable {
    @Override // java.lang.AutoCloseable
    public void close() {
        Trace.endSection();
    }

    private ScopedSysTraceEvent(String r100) {
        Trace.beginSection(r100);
    }

    public static ScopedSysTraceEvent scoped(String r100) {
        return new ScopedSysTraceEvent(r100);
    }
}
