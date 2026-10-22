package com.obric.sva.sdk.service;

import android.os.PowerManager;
import com.bytedance.apm.constant.UploadTypeInf;
import com.obric.sva.sdk.utils.LogUtils;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import java.util.Timer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\u0010\u0006\u001a\u00060\u0007R\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\u000fJ\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\rH\u0002J\u0006\u0010\u0014\u001a\u00020\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00060\u0007R\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/sva/sdk/service/WakeupDisplayController;", "", "tag", "", "powerManager", "Landroid/os/PowerManager;", "wakeLock", "Landroid/os/PowerManager$WakeLock;", "displayOnDurationMs", "", "<init>", "(Ljava/lang/String;Landroid/os/PowerManager;Landroid/os/PowerManager$WakeLock;I)V", "wakelockTimer", "Ljava/util/Timer;", "turnOnDisplay", "", "startWakelockTimer", "stopWakelockTimer", "", UploadTypeInf.TIMER, "release", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WakeupDisplayController {
    private final int displayOnDurationMs;
    private final PowerManager powerManager;
    private final String tag;
    private final PowerManager.WakeLock wakeLock;
    private Timer wakelockTimer;

    public final synchronized void release() {
        monitor-enter(this);
        stopWakelockTimer();     // Catch: Throwable -> L8
        if (this.wakeLock.isHeld() == false) goto L6;
        INVOKEVIRTUAL_com_obric_sva_sdk_service_WakeupDisplayController_com_obric_performance_power_monitor_cpu_WakeLockLancet_release(this.wakeLock);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final synchronized void startWakelockTimer() {
        monitor-enter(this);
        LogUtils.d(this.tag, "startWakelockTimer: enter", new Object[0]);     // Catch: Throwable -> L6
        stopWakelockTimer();     // Catch: Throwable -> L6
        final PthreadTimer r100 = new PthreadTimer("WakeupDisplayController");     // Catch: Throwable -> L6
        this.wakelockTimer = r100;     // Catch: Throwable -> L6
        r100.schedule(new AnonymousClass1(this, r100), this.displayOnDurationMs);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void stopWakelockTimer() {
        monitor-enter(this);
        stopWakelockTimer(this.wakelockTimer);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void turnOnDisplay() {
        monitor-enter(this);
        LogUtils.d(this.tag, "turnOnDisplay: enter - acquireWakelock", new Object[0]);     // Catch: Throwable -> L19
        if (this.wakeLock.isHeld() == true) goto L6;
        INVOKEVIRTUAL_com_obric_sva_sdk_service_WakeupDisplayController_com_obric_performance_power_monitor_cpu_WakeLockLancet_acquire(this.wakeLock);     // Catch: Throwable -> L19
    L16:
        LogUtils.d(this.tag, "turnOnDisplay: exit", new Object[0]);     // Catch: Throwable -> L19
        startWakelockTimer();     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L6:
        PowerManager r100 = this.powerManager;     // Catch: Throwable -> L19
        if (r100 == null) goto L16;
        if (r100.isInteractive() == true) goto L16;
        LogUtils.d(this.tag, "turnOnDisplay: no interactive", new Object[0]);     // Catch: Throwable -> L19
        INVOKEVIRTUAL_com_obric_sva_sdk_service_WakeupDisplayController_com_obric_performance_power_monitor_cpu_WakeLockLancet_release(this.wakeLock);     // Catch: Exception -> L13 Throwable -> L19
    L15:
        INVOKEVIRTUAL_com_obric_sva_sdk_service_WakeupDisplayController_com_obric_performance_power_monitor_cpu_WakeLockLancet_acquire(this.wakeLock);     // Catch: Throwable -> L19
        goto L16
    L13:
        e = move-exception;
        LogUtils.e(this.tag, e.getMessage(), new Object[0]);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    public static void INVOKEVIRTUAL_com_obric_sva_sdk_service_WakeupDisplayController_com_obric_performance_power_monitor_cpu_WakeLockLancet_acquire(PowerManager.WakeLock r100) {
        if (fna.g.d() == true) goto L6;
        r100.acquire();
        return;
    L6:
        r100.acquire();
        com.obric.performance.power.monitor.cpu.d.a(r100);
    }

    public static void INVOKEVIRTUAL_com_obric_sva_sdk_service_WakeupDisplayController_com_obric_performance_power_monitor_cpu_WakeLockLancet_release(PowerManager.WakeLock r100) {
        if (fna.g.d() == true) goto L6;
        r100.release();
        return;
    L6:
        r100.release();
        com.obric.performance.power.monitor.cpu.d.b(r100);
    }

    public static final /* synthetic */ String access$getTag$p(WakeupDisplayController r100) {
        return r100.tag;
    }

    public static final /* synthetic */ PowerManager.WakeLock access$getWakeLock$p(WakeupDisplayController r100) {
        return r100.wakeLock;
    }

    private final synchronized boolean stopWakelockTimer(Timer r100) {
        monitor-enter(this);
        if (r100 != null) goto L18;
    L16:
        monitor-exit(this);
        return false;
    L18:
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.wakelockTimer != r100) goto L16;
        r100.cancel();     // Catch: Throwable -> L13
        int r101 = r100.purge();     // Catch: Throwable -> L13
        LogUtils.d(this.tag, "stopWakelockTimer: numPurgedTasks= " + r101, new Object[0]);     // Catch: Throwable -> L13
        this.wakelockTimer = null;     // Catch: Throwable -> L13
        monitor-exit(this);
        return true;
    }

    public static final /* synthetic */ boolean access$stopWakelockTimer(WakeupDisplayController r100, Timer r101) {
        return r100.stopWakelockTimer(r101);
    }

    public WakeupDisplayController(String r100, PowerManager r101, PowerManager.WakeLock r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r102, "wakeLock");
        this.tag = r100;
        this.powerManager = r101;
        this.wakeLock = r102;
        this.displayOnDurationMs = r103;
    }
}
