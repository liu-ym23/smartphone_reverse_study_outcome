package com.bytedance.apm.trace.model.cross;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import dt3.b;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class TracingCrossManager {
    private static Map<Long, b> sCrossTracingContext;

    public TracingCrossManager() {
    }

    static {
        sCrossTracingContext = new ConcurrentHashMap();
    }

    public static void unRegisterCross(long r1) {
        sCrossTracingContext.remove(Long.valueOf(r1));
    }

    public static void registerCross(long r1, b r3) {
        sCrossTracingContext.put(Long.valueOf(r1), r3);
    }

    public static void onPassBackAsChild(String r2, String r3, ArrayList<NativeSpan> r4) {
        b r5 = sCrossTracingContext.get(Long.valueOf(CastLongProtector.parseLong(r2)));
        if (r5 == null) goto L8;
        sCrossTracingContext.remove(Long.valueOf(CastLongProtector.parseLong(r2)));
        monitor-enter(r5);
        monitor-exit(r5);
        return;
    }

    public static void onPassBackAsReference(String r2, String r3, ArrayList<NativeSpan> r4) {
        b r5 = sCrossTracingContext.get(Long.valueOf(CastLongProtector.parseLong(r2)));
        if (r5 == null) goto L8;
        sCrossTracingContext.remove(Long.valueOf(CastLongProtector.parseLong(r2)));
        monitor-enter(r5);
        monitor-exit(r5);
        return;
    }
}
