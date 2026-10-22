package com.bytedance.applet.impl;

import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.google.gson.JsonObject;
import kotlin.Lazy;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final /* synthetic */ class i1 implements Function1 {
    public /* synthetic */ i1() {
    }

    public final Object invoke(Object r7) {
        int r8 = ((Integer) r7).intValue();
        int r0 = MainlandAppletServiceImpl.d;
        long r1 = System.currentTimeMillis();
        JSONObject r2 = new JSONObject();
        r2.put("status", r8);
        Unit r4 = Unit.INSTANCE;
        EventCenter.enqueueEvent(new Event("AccountStatusChanged", r1, new f66.d(new JSONObject(MapsKt.mapOf(TuplesKt.to("data", r2))))));
        Lazy r3 = l3.d.a;
        JsonObject r5 = new JsonObject();
        r5.addProperty("status", Integer.valueOf(r8));
        l3.d.c(new l3.a("AccountStatusChanged", r5, 4));
        return Unit.INSTANCE;
    }
}
