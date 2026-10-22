package com.bytedance.bdlocation_impl.trace;

import af6.b;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.lbs.trace.contract.TraceLevel;
import java.util.HashMap;
import java.util.Map;
import xe6.d;

/* JADX INFO: loaded from: classes10.dex */
public final class a {
    public a() {
    }

    public static void a(LocationTraceManager.d r100, String r101, LocationTraceManager.Level r102, Long r103, Map r110) {
        af6.a r104 = new af6.a(r100.f199965a, r100.f199966b, r100.f199967c, r100.f199968d);     // Catch: Throwable -> L9
        if (r102 != LocationTraceManager.Level.ERROR) goto L6;
        TraceLevel r105 = TraceLevel.ERROR;     // Catch: Throwable -> L9
    L7:
        d.b(r104, new b(r101, r105, r103, r110));     // Catch: Throwable -> L9
        Logger.i("BDLbsTrace", "TraceSdk.report returned for event=" + r101 + ", fields=" + ((HashMap) r110).keySet() + ", durationMs=" + r103);     // Catch: Throwable -> L9
        return;
    L6:
        r105 = TraceLevel.INFO;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Logger.e("BDLbsTrace", "BdLbsTraceEventReporter.report failed", th);
    }
}
