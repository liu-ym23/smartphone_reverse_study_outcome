package com.bytedance.applet.aibridge.navigation;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class n {
    public static final boolean a(double r5, double r7) {
        if (Double.isInfinite(r5) == false) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == true) goto L10;
    L31:
        return false;
    L10:
        if (Double.isInfinite(r7) == false) goto L12;
    L14:
        boolean r1 = false;
    L15:
        if (r1 == false) goto L31;
        if ((-90.0d) <= r5) goto L19;
    L21:
        boolean r6 = false;
    L22:
        if (r6 == false) goto L31;
        if ((-180.0d) <= r7) goto L26;
    L28:
        boolean r8 = false;
    L29:
        if (r8 == false) goto L31;
        return true;
    L26:
        if (r7 > 180.0d) goto L28;
        r8 = true;
        goto L29
    L19:
        if (r5 > 90.0d) goto L21;
        r6 = true;
        goto L22
    L12:
        if (Double.isNaN(r7) == true) goto L14;
        r1 = true;
        goto L15
    L5:
        if (Double.isNaN(r5) == true) goto L7;
        r0 = true;
        goto L8
    }

    public static final Double b(JsonObject r2, String r3) {
        JsonElement r4 = r2.get(r3);
        Object r5 = null;
        if (r4 != null) goto L5;
        return null;
    L5:
        if ((!r4.isJsonNull()) == true) goto L8;
        r4 = null;
    L8:
        if (r4 == null) goto L23;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L12
        Object r6 = Result.constructor-impl(Double.valueOf(r4.getAsDouble()));     // Catch: Throwable -> L12
    L15:
        if (Result.isFailure-impl(r6) == true) goto L19;
        r5 = r6;
    L19:
        return (Double) r5;
    L12:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L23:
        return null;
    }

    public static final String c(JsonObject r2, String r3) {
        JsonElement r4 = r2.get(r3);
        if (r4 == null) goto L28;
        boolean r1 = true;
        if ((!r4.isJsonNull()) == true) goto L8;
        r4 = null;
    L8:
        if (r4 == null) goto L31;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L12
        Object r5 = Result.constructor-impl(r4.getAsString());     // Catch: Throwable -> L12
    L15:
        if (Result.isFailure-impl(r5) == false) goto L17;
        r5 = null;
    L17:
        String r6 = (String) r5;
        if (r6 != null) goto L20;
        return null;
    L20:
        if (r6.length() > 0) goto L23;
        r1 = false;
    L23:
        if (r1 == true) goto L25;
        return null;
    L25:
        return r6;
    L12:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L31:
        return null;
    L28:
        return null;
    }

    public static final List<com.larus.navigation.api.y> d(JsonArray r19, Function1<? super String, Unit> r20) {
        Intrinsics.checkNotNullParameter(r20, "onInvalid");
        if (r19 != null) goto L6;
        return null;
    L6:
        if (r19.size() <= 15) goto L9;
        r20.invoke("too_many_way_points");
        return null;
    L9:
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r19, 10));
        Iterator r0 = r19.iterator();
        int r4 = 0;
    L11:
        if (r0.hasNext() == false) goto L43;
        Object r5 = r0.next();
        int r6 = r4 + 1;
        if (r4 >= 0) goto L15;
        CollectionsKt.throwIndexOverflow();
    L15:
        JsonElement r7 = (JsonElement) r5;
        if (r7.isJsonObject() == true) goto L20;
        r7 = null;
    L20:
        if (r7 == null) goto L41;
        JsonObject r8 = r7.getAsJsonObject();
        if (r8 == null) goto L41;
        Double r10 = b(r8, "latitude");
        if (r10 == null) goto L39;
        double r12 = r10.doubleValue();
        Double r11 = b(r8, "longitude");
        if (r11 == null) goto L37;
        double r14 = r11.doubleValue();
        if (a(r12, r14) == false) goto L30;
        r3.add(new com.larus.navigation.api.y(r12, r14, c(r8, "poiId"), c(r8, "poiType"), c(r8, "poiName")));
        r4 = r6;
    L34:
        e = move-exception;
        int r9 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.b("nav_jsb_helper", "waypoints[" + r4 + "] invalid: type=" + e.getClass().getSimpleName());
        r20.invoke("invalid_way_point_coordinates");
        return null;
    L30:
        int r1 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.a("nav_jsb_helper", "waypoints[" + r4 + "] coordinate out of range");
        r20.invoke("invalid_way_point_coordinates");
        return null;
    L37:
        int r2 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.a("nav_jsb_helper", "waypoints[" + r4 + "].longitude is null");
        r20.invoke("invalid_way_point_coordinates");
        return null;
    L39:
        int r13 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.a("nav_jsb_helper", "waypoints[" + r4 + "].latitude is null");
        r20.invoke("invalid_way_point_coordinates");
        return null;
    L41:
        int r15 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.a("nav_jsb_helper", "waypoints[" + r4 + "] is not an object");
        r20.invoke("invalid_way_point_coordinates");
        return null;
    L43:
        return r3;
    }
}
