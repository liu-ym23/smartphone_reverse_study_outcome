package com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.defaulttrigger;

import android.os.SystemClock;
import com.flow.performance.thermal.SystemBatteryRecoder;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadScheduledThreadPoolExecutor;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PollingTrigger f271624a;

    public e(PollingTrigger r100) {
        this.f271624a = r100;
    }

    public final void a() {
        this.f271624a.c(SystemBatteryRecoder.BatteryRecordReason.POLLING);
        PollingTrigger r100 = this.f271624a;
        PThreadScheduledThreadPoolExecutor r101 = yk7.f.f568242a;
        r100.f271613f = yk7.f.a(r100.d(), this.f271624a.f271618k);
        this.f271624a.f271614g.set(false);
        PollingTrigger r102 = this.f271624a;
        r102.f271610c = SystemClock.elapsedRealtime();
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
