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

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f240242a = null;

    static {
        f240242a = new a();
    }

    public a() {
    }

    public static d a(String r100) {
        Object r101 = "unknown";
        Object r102 = null;
        if (r100 == null) goto L5;
        String r103 = StringsKt.trim(r100).toString();
    L6:
        if (r103 != null) goto L9;
        r103 = "";
    L9:
        if (r103.length() != 0) goto L11;
        boolean r104 = true;
    L12:
        if (r104 == false) goto L14;
        return null;
    L14:
        if (r103.length() > 65536) goto L65;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L34
        JSONObject r106 = new JSONObject(r103);     // Catch: Throwable -> L34
        JSONObject r107 = r106.optJSONObject("drive_mobile_menu_config");     // Catch: Throwable -> L34
        if (r107 == null) goto L20;
        r106 = r107;
    L20:
        int r108 = r106.optInt("schemaVersion", 1);     // Catch: Throwable -> L34
        if (r108 != 1) goto L30;
        JSONObject r109 = r106.optJSONObject("menu_config");     // Catch: Throwable -> L34
        if (r109 != null) goto L26;
        r109 = r106.optJSONObject("menuConfig");     // Catch: Throwable -> L34
    L26:
        if (r109 == null) goto L30;
        Map r110 = b(r109);     // Catch: Throwable -> L34
        if (r110.isEmpty() == true) goto L30;
        d r111 = new d(r108, r106.optString("configVersion", "unknown"), 1246287447, r110);     // Catch: Throwable -> L34
    L32:
        Object r112 = Result.m9449constructorimpl(r111);     // Catch: Throwable -> L34
    L36:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r112);
        if (r113 == null) goto L55;
        f240242a.getClass();
        JSONObject r114 = new JSONObject(r103).optJSONObject("drive_mobile_menu_config");     // Catch: Throwable -> L47
        if (r114 == null) goto L44;
        String r115 = r114.optString("configVersion", "unknown");     // Catch: Throwable -> L47
        if (r115 == null) goto L44;
    L45:
        Object r116 = Result.m9449constructorimpl(r115);     // Catch: Throwable -> L47
    L50:
        if (Result.m9455isFailureimpl(r116) == true) goto L53;
        r101 = r116;
    L53:
        tt5.a.l("OfficeSpaceMenuConfigParser", "parse menu config failed, len=" + r103.length() + ", runtimeIdHash=1246287447, configVersion=" + ((String) r101), r113);
    L44:
        r115 = new JSONObject(r103).optString("configVersion", "unknown");     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L55:
        if (Result.m9455isFailureimpl(r112) == true) goto L59;
        r102 = r112;
    L59:
        return (d) r102;
    L30:
        r111 = null;
    L34:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L36
    L65:
        return null;
    L11:
        r104 = false;
        goto L12
    L5:
        r103 = null;
        goto L6
    }

    public static Map b(JSONObject r210) {
        Map r100 = MapsKt.createMapBuilder();
        Iterator<String> r101 = r210.keys();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L59;
        String r103 = r101.next();
        if (r102 >= 8) goto L56;
        String r104 = h.f240262a.get(r103);
        if (r104 != null) goto L10;
        r104 = r103;
    L10:
        JSONObject r105 = r210.optJSONObject(r103);
        if (r105 == null) goto L56;
        Intrinsics.checkNotNull(r104);
        f240242a.getClass();
        boolean r106 = r105.optBoolean("enabled", true);
        JSONArray r110 = r105.optJSONArray("groups");
        if (r110 != null) goto L16;
        List r111 = CollectionsKt.emptyList();
        Iterator<String> r112 = r101;
    L30:
        JSONArray r107 = r105.optJSONArray("items");
        if (r107 != null) goto L33;
        List r108 = CollectionsKt.emptyList();
    L55:
        r100.put(r104, new e(r104, r106, r111, r108));
        r102 = r102 + 1;
    L57:
        r101 = r112;
        goto L4
    L33:
        List r109 = CollectionsKt.createListBuilder();
        int r113 = Math.min(r107.length(), 64);
        int r114 = 0;
    L34:
        if (r114 >= r113) goto L54;
        JSONObject r115 = r107.optJSONObject(r114);
        if (r115 != null) goto L38;
        JSONArray r116 = r107;
    L53:
        r114 = r114 + 1;
        r107 = r116;
        goto L34
    L38:
        String r117 = r115.optString("itemId");
        Intrinsics.checkNotNull(r117);
        r116 = r107;
        if ((!StringsKt.isBlank(r117)) == false) goto L41;
        String r211 = r117;
    L42:
        if (r211 == null) goto L53;
        boolean r212 = r115.optBoolean("visible", true);
        String r118 = r115.optString("groupId");
        Intrinsics.checkNotNull(r118);
        if ((!StringsKt.isBlank(r118)) == false) goto L47;
        String r213 = r118;
    L48:
        int r214 = r115.optInt("order", r114);
        String r119 = r115.optString("subMenuId");
        Intrinsics.checkNotNull(r119);
        if ((!StringsKt.isBlank(r119)) == false) goto L51;
        String r215 = r119;
    L52:
        r109.add(new g(r211, r212, r213, r214, r215));
        goto L53
    L51:
        r215 = null;
        goto L52
    L47:
        r213 = null;
        goto L48
    L41:
        r211 = null;
        goto L42
    L54:
        r108 = CollectionsKt.build(r109);
        goto L55
    L16:
        List r120 = CollectionsKt.createListBuilder();
        int r121 = Math.min(r110.length(), 24);
        int r122 = 0;
    L17:
        if (r122 >= r121) goto L29;
        JSONObject r123 = r110.optJSONObject(r122);
        if (r123 != null) goto L21;
        Iterator<String> r124 = r101;
    L28:
        r122 = r122 + 1;
        r121 = r121;
        r110 = r110;
        r101 = r124;
        goto L17
    L21:
        String r125 = r123.optString("groupId");
        Intrinsics.checkNotNull(r125);
        r124 = r101;
        if ((!StringsKt.isBlank(r125)) == false) goto L24;
        String r126 = r125;
    L25:
        if (r126 == null) goto L28;
        r120.add(new f(r126, r123.optBoolean("visible", true), r123.optInt("order", r122)));
        goto L28
    L24:
        r126 = null;
        goto L25
    L29:
        r112 = r101;
        r111 = CollectionsKt.build(r120);
    L56:
        r112 = r101;
        goto L57
    L59:
        return MapsKt.build(r100);
    }
}
