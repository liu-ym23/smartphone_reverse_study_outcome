package com.facebook.battery.reporter.core;

import com.facebook.battery.metrics.core.SystemMetrics;

/* JADX INFO: loaded from: classes22.dex */
public interface SystemMetricsReporter<T extends SystemMetrics<T>> {

    public interface Event {
        void acquireEvent(String r100, String r101);

        void add(String r100, double r101);

        void add(String r100, int r101);

        void add(String r100, long r101);

        void add(String r100, String r101);

        boolean isSampled();

        void logAndRelease();
    }

    void reportTo(T r100, Event r101);
}
