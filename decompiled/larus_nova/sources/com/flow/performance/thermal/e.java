package com.flow.performance.thermal;

import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public final class e implements f09.a.b {
    public e() {
    }

    @Override // f09.a.b
    public final void onAllActivityDestroyed() {
    }

    @Override // f09.a.b
    public final void onAppBackground() {
    }

    @Override // f09.a.b
    public final void onAppForeground() {
        Iterator<JSONObject> r100 = d.f274206g.iterator();
    L4:
        if (r100.hasNext() == false) goto L18;
        JSONObject r101 = r100.next();
        d r102 = d.f274201b;
        if (r101 != null) goto L8;
        final JSONObject r103 = new JSONObject();
    L9:
        monitor-enter(r102);
        Intrinsics.checkNotNullParameter("monitor_honor_thermal", "serviceName");     // Catch: Throwable -> L15
        Intrinsics.checkNotNullParameter(r103, "category");     // Catch: Throwable -> L15
        t0.a(new b(r103));     // Catch: Throwable -> L15
        monitor-exit(r102);
        if (AppHost.f326268a.isDebug() == false) goto L4;
        FLogger.f375446a.d("HonorThermalMonitor", "Current thermal data is : " + r101);
    L15:
        th = move-exception;
        throw th;
    L8:
        r103 = r101;
        goto L9
    L18:
        d.f274206g.clear();
    }
}
