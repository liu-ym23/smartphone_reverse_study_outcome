package com.lynx.animax.util;

import com.lynx.animax.base.bridge.ReadableMap;
import com.lynx.animax.service.IAnimaXMonitorService;
import java.util.Map;
import v4a.c;

/* JADX INFO: loaded from: classes32.dex */
public class AnimaXMetricsCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IAnimaXMonitorService f380468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f380469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f380470c;

    public void onMetricsReady(ReadableMap r100, ReadableMap r101) {
        this.f380468a.reportPerformanceMetrics(new c(r100, r101, this.f380470c, this.f380469b));
    }

    public AnimaXMetricsCallback(IAnimaXMonitorService r100, String r101, Map<String, Object> r102) {
        this.f380468a = r100;
        this.f380469b = r101;
        this.f380470c = r102;
    }
}
