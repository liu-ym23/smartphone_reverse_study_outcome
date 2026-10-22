package com.bytedance.applog.priority.original;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class q {
    public final int a;
    public final int b;
    public final String c;
    public final String d;
    public final List<String> e;
    public final String f;
    public final r g;

    public q(JSONObject r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r5, "json");
        Intrinsics.checkNotNullParameter(r6, "defaultReportHost");
        Intrinsics.checkNotNullParameter(r7, "defaultReportPath");
        this.a = r5.optInt("global_priority", 0);
        this.b = RangesKt.coerceAtLeast(r5.optInt("interval", 0), 0);
        this.c = r5.optString("report_host", r6);
        this.d = r5.optString("report_path", r7);
        this.e = new ArrayList();
        this.f = r5.optString("event_priority", "P2");
        JSONObject r8 = r5.optJSONObject("filter");
        if (r8 == null) goto L5;
        r r9 = new r(r8);
    L6:
        this.g = r9;
        JSONArray r10 = r5.optJSONArray("support_event_types");
        if (r10 == null) goto L20;
        int r11 = r10.length();
        int r12 = 0;
    L9:
        if (r12 >= r11) goto L24;
        String r0 = r10.optString(r12);
        if (r0 != null) goto L13;
    L16:
        boolean r2 = true;
    L17:
        if (r2 == true) goto L19;
        List<String> r3 = this.e;
        ArrayList r4 = (ArrayList) r3;
        r4.add(r0.toLowerCase(Locale.ROOT));
    L19:
        r12 = r12 + 1;
        goto L9
    L13:
        if (r0.length() == 0) goto L16;
        r2 = false;
        goto L17
    L24:
        return;
    L20:
        return;
    L5:
        r9 = null;
        goto L6
    }
}
