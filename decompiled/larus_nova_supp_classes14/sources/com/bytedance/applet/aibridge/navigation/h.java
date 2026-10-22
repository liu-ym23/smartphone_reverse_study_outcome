package com.bytedance.applet.aibridge.navigation;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h {
    public static final JsonObject a(JSONObject r2) {
        JsonObject r3 = new JsonParser().parse(r2.toString()).getAsJsonObject();     // Catch: Exception -> L4
        Intrinsics.checkNotNull(r3);     // Catch: Exception -> L4
        return r3;
    L4:
        e = move-exception;
        int r0 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.b("js_event", "toGsonJsonObject failed: type=".concat(e.getClass().getSimpleName()));
        JsonObject r4 = new JsonObject();
        r4.addProperty("_error", "json_conversion_failed");
        return r4;
    }
}
