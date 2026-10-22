package com.lynx.tasm;

import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.core.LynxThreadPool;
import com.lynx.tasm.eventreport.LynxEventReporter;

/* JADX INFO: loaded from: classes32.dex */
public final class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f383807a = 0;

    static {
    }

    public static void a(final e0 r110, long r111) {
        final n0 r100 = n0.f383491c;
        r100.getClass();
        TraceEvent.beginSection("GlobalMemoryUsage.query");
        final long r112 = System.currentTimeMillis();
        if (r111 <= 0) goto L5;
        final long r113 = r111;
    L7:
        if (LynxEnv.inst().isNativeLibraryLoaded() == true) goto L9;
        LynxThreadPool.a().execute(new g0(r110, r112, r113));
        TraceEvent.endSection("GlobalMemoryUsage.query");
        return;
    L9:
        final long r101 = r113;
        LynxEventReporter.runOnReportThread(new h0(r100, r110, r112, r101));
        TraceEvent.endSection("GlobalMemoryUsage.query");
        return;
    L5:
        r113 = 2000;
        goto L7
    }
}
