package com.bytedance.apm.agent.monitor;

import bt3.b;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class MonitorTool {
    public MonitorTool() {
    }

    public static void monitorStart(String r3, long r4, long r6) {
        if (r6 <= r4) goto L11;
        final JSONObject r0 = new JSONObject();     // Catch: Exception -> L6
        r0.put(r3, r6 - r4);     // Catch: Exception -> L6
        final JSONObject r5 = new JSONObject();     // Catch: Exception -> L6
        r5.put("begin_time", r4);     // Catch: Exception -> L6
        r5.put("end_time", r6);     // Catch: Exception -> L6
        b.d.a.e(new AnonymousClass4(r0, r5));     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static void monitorUIAction(final String r2, final String r3, final JSONObject r4) {
        b.d.a.e(new AnonymousClass1(r2, r3, r4));
    }

    public static void reportTraceTime(final String r2, final String r3, final long r4) {
        b.d.a.e(new AnonymousClass5(r3, r4, r2));
    }

    public static void monitorStart(final JSONObject r2, long r3, long r5) {
        final JSONObject r0 = new JSONObject();     // Catch: Exception -> L4
        r0.put("begin_time", r3);     // Catch: Exception -> L4
        r0.put("end_time", r5);     // Catch: Exception -> L4
        r0.put("from", "monitor-plugin");     // Catch: Exception -> L4
        b.d.a.e(new AnonymousClass3(r2, r0));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static void monitorPerformance(final String r2, final JSONObject r3, final JSONObject r4, final JSONObject r5) {
        b.d.a.e(new AnonymousClass2(r2, r3, r4, r5));
    }

    public static void monitorSLA(final long r12, final long r14, final String r16, final String r17, final String r18, final int r19, final JSONObject r20) {
        b.d.a.e(new AnonymousClass6(r12, r14, r16, r17, r18, r19, r20));
    }
}
