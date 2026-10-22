package com.facebook.battery.metrics.core;

import com.facebook.battery.metrics.core.SystemMetrics;
import java.io.Serializable;

/* JADX INFO: loaded from: classes22.dex */
public abstract class SystemMetrics<T extends SystemMetrics<T>> implements Serializable {
    public SystemMetrics() {
    }

    public abstract T diff(T r100, T r101);

    public abstract T set(T r100);

    public abstract T sum(T r100, T r101);

    public T diff(T r100) {
        return (T) diff(r100, null);
    }

    public T sum(T r100) {
        return (T) sum(r100, null);
    }
}
