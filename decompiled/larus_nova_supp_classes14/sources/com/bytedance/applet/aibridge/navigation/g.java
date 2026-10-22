package com.bytedance.applet.aibridge.navigation;

import com.google.gson.JsonObject;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r2, JsonObject r3) {
        int r0 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.d("js_event", "publishEvent: ".concat(r2));
        com.larus.navigation.api.c.a("nav_protocol_trace", "[H5_EVENT/" + r2 + "] fieldCount=" + r3.entrySet().size());
        Lazy r1 = l3.d.a;
        l3.d.c(new l3.a(r2, r3, 4));
        int r4 = com.larus.navigation.api.j.a;
        String r5 = StringsKt.take(r3.toString(), 300);
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r5, "params");
    }
}
