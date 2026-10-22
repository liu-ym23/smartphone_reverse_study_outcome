package com.obric.assistant.common.utils;

import android.os.PowerManager;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f387874a = 0;

    static {
    }

    public static boolean a() {
        Object r100 = AppHost.f326268a.getApplication().getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.os.PowerManager");
        return ((PowerManager) r100).isInteractive();
    }

    public static void b() {
        Object r100 = AppHost.f326268a.getApplication().getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);     // Catch: Throwable -> L8
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.os.PowerManager");     // Catch: Throwable -> L8
        FLogger.f375446a.i("Utils", "turnOnScreen");     // Catch: Throwable -> L8
        PowerManager.WakeLock r101 = ((PowerManager) r100).newWakeLock(268435466, "AssistantWakeLock:TurnOnScreen");     // Catch: Throwable -> L8
        if (fna.g.d() == true) goto L6;
        r101.acquire(100);     // Catch: Throwable -> L8
    L11:
        return;
    L6:
        r101.acquire(100);     // Catch: Throwable -> L8
        com.obric.performance.power.monitor.cpu.d.a(r101);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        FLogger.f375446a.e("Utils", "turnScreenOn error!", th);
    }
}
