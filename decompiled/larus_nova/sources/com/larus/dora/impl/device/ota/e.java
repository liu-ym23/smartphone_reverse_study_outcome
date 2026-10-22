package com.larus.dora.impl.device.ota;

import com.larus.utils.logger.FLogger;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes27.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f334191a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f334192b = null;

    static {
        f334191a = LazyKt.lazy(new a());
        f334192b = LazyKt.lazy(new b());
    }

    public static boolean a() {
        return ((Boolean) f334191a.getValue()).booleanValue();
    }

    public static void b(boolean r100) {
        g49.d.d("DoraOTAManagement", "[TEST] onOTAFinished isSuccess: " + r100);
        if (r100 == true) goto L5;
        g49.d.a("DoraOTAManagement", "[TEST] start upload alog");
        FLogger.f375446a.uploadAllLog("OTA-Autotest", new c());
    L5:
        g49.d.a("DoraOTAManagement", "[TEST] scheduleNextOtaTest after 300s");
        ((ScheduledExecutorService) f334192b.getValue()).schedule(new d(), 300000, TimeUnit.MILLISECONDS);
    }
}
