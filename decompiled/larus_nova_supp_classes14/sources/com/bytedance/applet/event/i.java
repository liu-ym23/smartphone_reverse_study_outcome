package com.bytedance.applet.event;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i {
    public static final List<String> a = null;

    static {
        a = CollectionsKt.listOf(new String[]{"db_app_4PuJFXO", "db_app_4PM0PUQ"});
    }

    public static String a(JsonObject r1, String r2) {
        JsonElement r3 = r1.get(r2);
        String r4 = null;
        if (r3 != null) goto L5;
    L10:
        if (r4 != null) goto L13;
        return "";
    L13:
        return r4;
    L5:
        if (r3.isJsonPrimitive() == true) goto L8;
        r3 = null;
    L8:
        if (r3 == null) goto L10;
        r4 = r3.getAsString();
        goto L10
    }
}
