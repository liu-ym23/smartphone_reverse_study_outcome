package com.bytedance.applet.impl;

import com.bytedance.apm.ApmAgent;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class s1 implements k5.h {
    public s1() {
    }

    public final void b(String r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        com.larus.platform.service.o.a.reportEvent(r2, r3);
    }

    public final void d(String r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        com.larus.platform.service.o.a.reportEvent(r2, r3);
    }

    public final void a(String r2, JSONObject r3, JSONObject r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r2, "event");
        ApmAgent.monitorEvent(r2, r4, r5, r3);
    }

    public final void c(String r2, JSONObject r3, JSONObject r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r2, "errorName");
        ApmAgent.monitorEvent(r2, r4, r5, r3);
    }

    public final void e(String r2, JSONObject r3, JSONObject r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r2, "event");
        ApmAgent.monitorEvent(r2, r4, r5, r3);
    }
}
