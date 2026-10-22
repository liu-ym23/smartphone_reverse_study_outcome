package com.ss.android.lark.monitor.traffic;

import android.net.TrafficStats;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes36.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f432482a;

    public final void a() {
        i r100 = this.f432482a;
        r100.getClass();
        Log.i("TrafficMonitorVerify", "getUidTxBytes = " + TrafficStats.getUidTxBytes(r100.f432483a) + ", getUidRxBytes = " + TrafficStats.getUidRxBytes(r100.f432483a));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.w("Verify", "getCurrentAppTrafficStats have exceptoin " + e.getMessage());
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

    public h(i r100) {
        this.f432482a = r100;
    }
}
