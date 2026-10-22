package com.bytedance.ee.bear.widgets.menuconfig;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public static d a(String r9) {
        Object r2 = "unknown";
        Object r3 = null;
        if (r9 == null) goto L5;
        String r10 = StringsKt.trim(r9).toString();
    L6:
        if (r10 != null) goto L9;
        r10 = "";
    L9:
        if (r10.length() != 0) goto L11;
        boolean r4 = true;
    L12:
        if (r4 == false) goto L14;
        return null;
    L14:
        if (r10.length() > 65536) goto L65;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L34
        JSONObject r6 = new JSONObject(r10);     // Catch: Throwable -> L34
        JSONObject r7 = r6.optJSONObject("drive_mobile_menu_config");     // Catch: Throwable -> L34
        if (r7 == null) goto L20;
        r6 = r7;
    L20:
        int r8 = r6.optInt("schemaVersion", 1);     // Catch: Throwable -> L34
        if (r8 != 1) goto L30;
        JSONObject r11 = r6.optJSONObject("menu_config");     // Catch: Throwable -> L34
        if (r11 != null) goto L26;
        r11 = r6.optJSONObject("menuConfig");     // Catch: Throwable -> L34
    L26:
        if (r11 == null) goto L30;
        Map r12 = b(r11);     // Catch: Throwable -> L34
        if (r12.isEmpty() == true) goto L30;
        d r13 = new d(r8, r6.optString("configVersion", "unknown"), 1246287447, r12);     // Catch: Throwable -> L34
    L32:
        Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L34
    L36:
        Throwable r15 = Result.exceptionOrNull-impl(r14);
        if (r15 == null) goto L55;
        a.getClass();
        JSONObject r0 = new JSONObject(r10).optJSONObject("drive_mobile_menu_config");     // Catch: Throwable -> L47
        if (r0 == null) goto L44;
        String r1 = r0.optString("configVersion", "unknown");     // Catch: Throwable -> L47
        if (r1 == null) goto L44;
    L45:
        Object r16 = Result.constructor-impl(r1);     // Catch: Throwable -> L47
    L50:
        if (Result.isFailure-impl(r16) == true) goto L53;
        r2 = r16;
    L53:
        tt5.a.l("OfficeSpaceMenuConfigParser", "parse menu config failed, len=" + r10.length() + ", runtimeIdHash=1246287447, configVersion=" + ((String) r2), r15);
    L44:
        r1 = new JSONObject(r10).optString("configVersion", "unknown");     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
    L55:
        if (Result.isFailure-impl(r14) == true) goto L59;
        r3 = r14;
    L59:
        return (d) r3;
    L30:
        r13 = null;
    L34:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L36
    L65:
        return null;
    L11:
        r4 = false;
        goto L12
    L5:
        r10 = null;
        goto L6
    }

    public static Map b(JSONObject r26) {
        Map r0 = MapsKt.createMapBuilder();
        Iterator<String> r1 = r26.keys();
        int r3 = 0;
    L4:
        if (r1.hasNext() == false) goto L59;
        String r4 = r1.next();
        if (r3 >= 8) goto L56;
        String r5 = h.a.get(r4);
        if (r5 != null) goto L10;
        r5 = r4;
    L10:
        JSONObject r6 = r26.optJSONObject(r4);
        if (r6 == null) goto L56;
        Intrinsics.checkNotNull(r5);
        a.getClass();
        boolean r8 = r6.optBoolean("enabled", true);
        JSONArray r10 = r6.optJSONArray("groups");
        if (r10 != null) goto L16;
        List r11 = CollectionsKt.emptyList();
        Iterator<String> r19 = r1;
    L30:
        JSONArray r2 = r6.optJSONArray("items");
        if (r2 != null) goto L33;
        List r7 = CollectionsKt.emptyList();
    L55:
        r0.put(r5, new e(r5, r8, r11, r7));
        r3 = r3 + 1;
    L57:
        r1 = r19;
        goto L4
    L33:
        List r9 = CollectionsKt.createListBuilder();
        int r12 = Math.min(r2.length(), 64);
        int r13 = 0;
    L34:
        if (r13 >= r12) goto L54;
        JSONObject r14 = r2.optJSONObject(r13);
        if (r14 != null) goto L38;
        JSONArray r17 = r2;
    L53:
        r13 = r13 + 1;
        r2 = r17;
        goto L34
    L38:
        String r15 = r14.optString("itemId");
        Intrinsics.checkNotNull(r15);
        r17 = r2;
        if ((!StringsKt.isBlank(r15)) == false) goto L41;
        String r21 = r15;
    L42:
        if (r21 == null) goto L53;
        boolean r22 = r14.optBoolean("visible", true);
        String r16 = r14.optString("groupId");
        Intrinsics.checkNotNull(r16);
        if ((!StringsKt.isBlank(r16)) == false) goto L47;
        String r23 = r16;
    L48:
        int r24 = r14.optInt("order", r13);
        String r18 = r14.optString("subMenuId");
        Intrinsics.checkNotNull(r18);
        if ((!StringsKt.isBlank(r18)) == false) goto L51;
        String r25 = r18;
    L52:
        r9.add(new g(r21, r22, r23, r24, r25));
        goto L53
    L51:
        r25 = null;
        goto L52
    L47:
        r23 = null;
        goto L48
    L41:
        r21 = null;
        goto L42
    L54:
        r7 = CollectionsKt.build(r9);
        goto L55
    L16:
        List r110 = CollectionsKt.createListBuilder();
        int r20 = Math.min(r10.length(), 24);
        int r111 = 0;
    L17:
        if (r111 >= r20) goto L29;
        JSONObject r27 = r10.optJSONObject(r111);
        if (r27 != null) goto L21;
        Iterator<String> r112 = r1;
    L28:
        r111 = r111 + 1;
        r20 = r20;
        r10 = r10;
        r1 = r112;
        goto L17
    L21:
        String r113 = r27.optString("groupId");
        Intrinsics.checkNotNull(r113);
        r112 = r1;
        if ((!StringsKt.isBlank(r113)) == false) goto L24;
        String r28 = r113;
    L25:
        if (r28 == null) goto L28;
        r110.add(new f(r28, r27.optBoolean("visible", true), r27.optInt("order", r111)));
        goto L28
    L24:
        r28 = null;
        goto L25
    L29:
        r19 = r1;
        r11 = CollectionsKt.build(r110);
    L56:
        r19 = r1;
        goto L57
    L59:
        return MapsKt.build(r0);
    }
}
