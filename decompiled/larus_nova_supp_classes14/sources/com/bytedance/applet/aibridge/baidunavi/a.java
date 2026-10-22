package com.bytedance.applet.aibridge.baidunavi;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import kotlin.Lazy;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(int r2, String r3, dv3.c r4) {
        Lazy r0 = l3.d.a;
        JsonObject r1 = new JsonObject();
        r1.addProperty("status", Integer.valueOf(r2));
        r1.addProperty("message", r3);
        r1.add("result", GsonProtectorUtils.toJsonTree(new Gson(), r4));
        Unit r5 = Unit.INSTANCE;
        l3.d.c(new l3.a("flow.onNavStatusChanged", r1, 4));
    }
}
