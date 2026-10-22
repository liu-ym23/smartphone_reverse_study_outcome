package com.obric.assistant.performance;

import com.obric.assistant.ObricMemoryMonitorConfig;
import com.obric.assistant.ObricPerformanceMonitorConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f391037a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f391038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static float f391039c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f391040d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile JvmMemoryinfo f391041e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile PssMemoryinfo f391042f;

    static {
        f391037a = LazyKt.lazy(new e());
        f391038b = true;
        f391039c = 0.6f;
        f391040d = 800;
        f391041e = new JvmMemoryinfo(Float.valueOf(0.0f), 0L, 0L, 0L);
        f391042f = new PssMemoryinfo(0, 0);
    }

    public static void a(ObricPerformanceMonitorConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        ObricMemoryMonitorConfig r101 = r100.getMemoryMonitorConfig();
        if (r101 == null) goto L5;
        boolean r102 = r101.getMemoryMonitorEnabled();
    L6:
        f391038b = r102;
        ObricMemoryMonitorConfig r103 = r100.getMemoryMonitorConfig();
        if (r103 == null) goto L9;
        f391039c = Float.valueOf(r103.getMemoryJvmLeakThresholdInPercent()).floatValue();
    L9:
        ObricMemoryMonitorConfig r104 = r100.getMemoryMonitorConfig();
        if (r104 == null) goto L13;
        f391040d = Integer.valueOf(r104.getMemoryPssLeakThresholdInMb()).intValue();
        return;
    L13:
        return;
    L5:
        r102 = true;
        goto L6
    }
}
