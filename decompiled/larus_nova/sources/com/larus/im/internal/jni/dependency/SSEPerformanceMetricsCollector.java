package com.larus.im.internal.jni.dependency;

import android.os.Debug;
import android.os.Process;
import android.os.SystemClock;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ouc.d0;
import ouc.e0;
import ouc.i;
import ouc.j;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\nJ\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/larus/im/internal/jni/dependency/SSEPerformanceMetricsCollector;", "", "<init>", "()V", "EVENT_NAME", "", "lastProcessCpuMs", "", "lastElapsedMs", "enrich", "Lkotlinx/serialization/json/JsonObject;", "event", "params", "enrichSSEPerformance", "omnisdk-foundation_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class SSEPerformanceMetricsCollector {
    private static final String EVENT_NAME = "flow_im_sse_performance_sample";
    public static final SSEPerformanceMetricsCollector INSTANCE = null;
    private static long lastElapsedMs;
    private static long lastProcessCpuMs;

    private SSEPerformanceMetricsCollector() {
    }

    static {
        INSTANCE = new SSEPerformanceMetricsCollector();
        lastProcessCpuMs = -1;
        lastElapsedMs = -1;
    }

    private final d0 enrichSSEPerformance(d0 r110) {
        long r100 = Process.getElapsedCpuTime();
        long r101 = SystemClock.elapsedRealtime();
        long r102 = lastProcessCpuMs;
        long r103 = lastElapsedMs;
        lastProcessCpuMs = r100;
        lastElapsedMs = r101;
        e0 r104 = new e0();
        Iterator<Map.Entry<String, i>> r111 = r110.entrySet().iterator();
    L4:
        if (r111.hasNext() == false) goto L6;
        Map.Entry<String, i> r105 = r111.next();
        r104.b(r105.getKey(), r105.getValue());
        goto L4
    L6:
        j.b(r104, "memory_app_use", Long.valueOf(Debug.getPss() / 1024));
        long r106 = r101 - r103;
        if (r102 < 0) goto L12;
        if (r106 <= 0) goto L12;
        j.b(r104, "cpu_app_process_usage", Double.valueOf(((r100 - r102) / r106) * 100.0d));
    L12:
        return r104.a();
    }

    public final d0 enrich(String r100, d0 r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "params");
        if (Intrinsics.areEqual(r100, EVENT_NAME) == true) goto L5;
        return r101;
    L5:
        monitor-enter(this);
        d0 r102 = INSTANCE.enrichSSEPerformance(r101);     // Catch: Throwable -> L9
        monitor-exit(this);
        return r102;
    L9:
        th = move-exception;
        throw th;
    }
}
