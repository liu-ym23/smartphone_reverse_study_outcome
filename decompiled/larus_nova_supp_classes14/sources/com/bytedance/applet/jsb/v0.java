package com.bytedance.applet.jsb;

import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.google.gson.JsonObject;
import com.larus.platform.model.GeoLocationInfo;
import com.larus.platform.model.LocationResult;
import hq9.z2;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class v0 implements z2 {
    public v0() {
    }

    public final void a(LocationResult r13, GeoLocationInfo r14) {
        Intrinsics.checkNotNullParameter(r13, "code");
        Intrinsics.checkNotNullParameter(r14, "location");
        Pair[] r2 = new Pair[2];
        r2[0] = TuplesKt.to("code", 1);
        Pair[] r0 = new Pair[5];
        Boolean r5 = Boolean.TRUE;
        r0[0] = TuplesKt.to("enable", r5);
        r0[1] = TuplesKt.to("latitude", Double.valueOf(r14.getLatitude()));
        r0[2] = TuplesKt.to("longitude", Double.valueOf(r14.getLongitude()));
        r0[3] = TuplesKt.to("accuracy", Integer.valueOf(r14.getAccuracyLevel()));
        String r1 = r14.getCity();
        String r9 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0[4] = TuplesKt.to("city", r1);
        r2[1] = TuplesKt.to("data", MapsKt.mutableMapOf(r0));
        JSONObject r15 = new JSONObject(MapsKt.mapOf(r2));
        EventCenter.enqueueEvent(new Event("appletLocationChange", System.currentTimeMillis(), new f66.d(r15)));
        Lazy r3 = l3.d.a;
        JsonObject r4 = new JsonObject();
        r4.addProperty("enable", r5);
        r4.addProperty("latitude", Double.valueOf(r14.getLatitude()));
        r4.addProperty("longitude", Double.valueOf(r14.getLongitude()));
        r4.addProperty("accuracy", Integer.valueOf(r14.getAccuracyLevel()));
        String r16 = r14.getCity();
        if (r16 == null) goto L9;
        r9 = r16;
    L9:
        r4.addProperty("city", r9);
        Unit r17 = Unit.INSTANCE;
        l3.d.c(new l3.a("appletLocationChange", r4, 4));
    }

    public final void onError(String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "code");
        Intrinsics.checkNotNullParameter(r9, "msg");
        EventCenter.enqueueEvent(new Event("appletLocationChange", System.currentTimeMillis(), new f66.d(new JSONObject(MapsKt.mapOf(new Pair[]{TuplesKt.to("code", r8), TuplesKt.to("msg", r9)})))));
        Lazy r3 = l3.d.a;
        JsonObject r4 = new JsonObject();
        r4.addProperty("code", r8);
        r4.addProperty("msg", r9);
        Unit r10 = Unit.INSTANCE;
        l3.d.c(new l3.a("appletLocationChange", r4, 4));
    }
}
