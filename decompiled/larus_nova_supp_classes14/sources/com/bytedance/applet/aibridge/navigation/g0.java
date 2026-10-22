package com.bytedance.applet.aibridge.navigation;

import com.google.gson.JsonObject;
import com.larus.platform.model.GeoLocationInfo;
import com.larus.platform.model.LocationResult;
import hq9.z2;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g0 implements z2 {
    public g0() {
    }

    public final void a(LocationResult r4, GeoLocationInfo r5) {
        Intrinsics.checkNotNullParameter(r4, "code");
        Intrinsics.checkNotNullParameter(r5, "location");
        JSONObject r6 = new JSONObject();
        r6.put("latitude", r5.getLatitude());
        r6.put("longitude", r5.getLongitude());
        r6.put("altitude", r5.getAltitude());
        r6.put("accuracy", r5.getRadius());
        r6.put("speed", r5.getSpeed());
        Float r0 = r5.getGpsDir();
        if (r0 == null) goto L5;
        double r1 = r0.floatValue();
    L6:
        r6.put("bearing", r1);
        r6.put("timestamp", r5.getGpsTime());
        int r7 = g.a;
        Intrinsics.checkNotNullParameter(r6, "locationJson");
        g.a("flow.onLocationChange", h.a(r6));
        return;
    L5:
        r1 = 0.0d;
        goto L6
    }

    public final void onError(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "code");
        Intrinsics.checkNotNullParameter(r6, "msg");
        int r2 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.b("jsb_start_location", "location error: code=" + r5 + ", msg=" + r6);
        int r3 = g.a;
        Intrinsics.checkNotNullParameter(r5, "code");
        Intrinsics.checkNotNullParameter(r6, "msg");
        JsonObject r0 = new JsonObject();
        r0.addProperty("errorCode", r5);
        r0.addProperty("message", r6);
        Unit r7 = Unit.INSTANCE;
        g.a("flow.onLocationError", r0);
    }
}
