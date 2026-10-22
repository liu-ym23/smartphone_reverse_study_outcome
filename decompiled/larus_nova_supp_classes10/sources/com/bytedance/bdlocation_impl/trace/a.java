package com.bytedance.bdlocation_impl.trace;

import af6.b;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.lbs.trace.contract.TraceLevel;
import java.util.HashMap;
import java.util.Map;
import xe6.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public a() {
    }

    public static void a(LocationTraceManager.d r6, String r7, LocationTraceManager.Level r8, Long r9, Map r10) {
        af6.a r2 = new af6.a(r6.a, r6.b, r6.c, r6.d);     // Catch: Throwable -> L9
        if (r8 != LocationTraceManager.Level.ERROR) goto L6;
        TraceLevel r11 = TraceLevel.ERROR;     // Catch: Throwable -> L9
    L7:
        d.b(r2, new b(r7, r11, r9, r10));     // Catch: Throwable -> L9
        Logger.i("BDLbsTrace", "TraceSdk.report returned for event=" + r7 + ", fields=" + ((HashMap) r10).keySet() + ", durationMs=" + r9);     // Catch: Throwable -> L9
        return;
    L6:
        r11 = TraceLevel.INFO;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Logger.e("BDLbsTrace", "BdLbsTraceEventReporter.report failed", th);
    }
}
