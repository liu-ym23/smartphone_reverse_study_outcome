package com.larus.dispatcher.askhuman.handler;

import com.android.ttcjpaysdk.base.ui.dialog.CJPayLynxStandardKeepActivity;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes27.dex */
public final class h {
    public static final f b(JSONObject r100) {
        JSONObject r101 = r100.optJSONObject("vm_takeover_params");
        Object r102 = r100.opt("is_vm");
        if ((r102 instanceof Boolean) == false) goto L6;
        boolean r103 = ((Boolean) r102).booleanValue();
    L9:
        String r104 = a(r100, "vm_take_over_url");
        String r105 = a(r100, "activePageId");
        if (r105 != null) goto L21;
        String r106 = a(r100, "active_page_id");
        if (r106 != null) goto L20;
        if (r101 == null) goto L15;
        r106 = a(r101, "activePageId");
    L16:
        if (r106 != null) goto L20;
        if (r101 == null) goto L19;
        r105 = a(r101, "active_page_id");
        goto L21
    L19:
        r105 = null;
        goto L21
    L15:
        r106 = null;
    L20:
        r105 = r106;
    L21:
        if (r103 == true) goto L26;
        if (r104 != null) goto L26;
        if (r105 != null) goto L26;
        return null;
    L26:
        return new f(r103, r104, r105);
    L6:
        if ((r102 instanceof String) == false) goto L8;
        r103 = StringsKt.equals(StringsKt.trim((String) r102).toString(), "true", true);
        goto L9
    L8:
        r103 = false;
        goto L9
    }

    public static final Object c(Object r100) {
        if (Intrinsics.areEqual(r100, JSONObject.NULL) == false) goto L6;
        return null;
    L6:
        if ((r100 instanceof JSONObject) == false) goto L9;
        return e((JSONObject) r100);
    L9:
        if ((r100 instanceof JSONArray) == false) goto L18;
        JSONArray r101 = (JSONArray) r100;
        List r102 = CollectionsKt.createListBuilder(r101.length());
        int r103 = r101.length();
        int r104 = 0;
    L11:
        if (r104 >= r103) goto L14;
        r102.add(c(r101.opt(r104)));
        r104 = r104 + 1;
        goto L11
    L14:
        return CollectionsKt.build(r102);
    L18:
        return r100;
    }

    public static final List<String> d(JSONArray r100) {
        List r101 = CollectionsKt.createListBuilder(r100.length());
        int r102 = r100.length();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L12;
        String r104 = r100.optString(r103);
        Intrinsics.checkNotNull(r104);
        if ((!StringsKt.isBlank(r104)) == true) goto L8;
        r104 = null;
    L8:
        if (r104 == null) goto L10;
        r101.add(r104);
    L10:
        r103 = r103 + 1;
        goto L3
    L12:
        return CollectionsKt.build(r101);
    }

    public static final Map<String, Object> e(JSONObject r100) {
        Map r101 = MapsKt.createMapBuilder();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L7;
        String r103 = r102.next();
        Intrinsics.checkNotNull(r103);
        r101.put(r103, c(r100.opt(r103)));
        goto L4
    L7:
        return MapsKt.build(r101);
    }

    public static final t f(k r110) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        String r111 = r110.f330888b.getSchemaPayload();
        if (r111 == null) goto L5;
        JSONObject r100 = new JSONObject(r111);     // Catch: Exception -> L43
        JSONObject r112 = r100.optJSONObject("server_option");     // Catch: Exception -> L43
        String r101 = r100.optString("tool_call_id");     // Catch: Exception -> L43
        Intrinsics.checkNotNull(r101);     // Catch: Exception -> L43
        Map<String, Object> r102 = null;
        if ((!StringsKt.isBlank(r101)) == false) goto L9;
        String r103 = r101;
    L10:
        String r104 = r100.optString("sandbox_id");     // Catch: Exception -> L43
        Intrinsics.checkNotNull(r104);     // Catch: Exception -> L43
        if ((!StringsKt.isBlank(r104)) == false) goto L13;
        String r105 = r104;
    L14:
        String r106 = r100.optString("command");     // Catch: Exception -> L43
        Intrinsics.checkNotNull(r106);     // Catch: Exception -> L43
        if ((!StringsKt.isBlank(r106)) == false) goto L17;
        String r107 = r106;
    L18:
        JSONArray r108 = r100.optJSONArray("folders");     // Catch: Exception -> L43
        if (r108 == null) goto L24;
        List<String> r109 = d(r108);     // Catch: Exception -> L43
        if (r109 == null) goto L24;
        List<String> r113 = r109;
    L35:
        if (r112 == null) goto L40;
        String r114 = r112.optString(CJPayLynxStandardKeepActivity.INTENT_CALLBACK_ID);     // Catch: Exception -> L43
        Integer r115 = Integer.valueOf(r112.optInt("scene"));     // Catch: Exception -> L43
        JSONObject r116 = r112.optJSONObject("params");     // Catch: Exception -> L43
        if (r116 == null) goto L39;
        r102 = e(r116);     // Catch: Exception -> L43
    L39:
        u r117 = new u(r114, r115, r102);     // Catch: Exception -> L43
    L41:
        return new t(r103, r105, r107, r113, r117, b(r100));
    L40:
        r117 = null;
    L24:
        String r118 = r100.optString("folders");     // Catch: Exception -> L43
        Intrinsics.checkNotNull(r118);     // Catch: Exception -> L43
        if ((!StringsKt.isBlank(r118)) == true) goto L29;
        r118 = null;
    L29:
        if (r118 != null) goto L46;
        r113 = null;
        goto L35
    L46:
        List<String> r119 = d(new JSONArray(r118));     // Catch: Exception -> L32
    L33:
        r113 = r119;
        goto L35
    L32:
        r119 = CollectionsKt.listOf(r118);     // Catch: Exception -> L43
        goto L33
    L17:
        r107 = null;
        goto L18
    L13:
        r105 = null;
        goto L14
    L9:
        r103 = null;
    L43:
        e = move-exception;
        FLogger.f375446a.e("QuickReplyClickInterceptorManager", "[transformSchemaPayload] parse schemaPayload failed, errorType=".concat(e.getClass().getSimpleName()));
        return new t();
    L5:
        return new t();
    }

    public static final String a(JSONObject r100, String r101) {
        Object r102 = r100.opt(r101);
        if ((r102 instanceof String) == false) goto L5;
        String r103 = (String) r102;
    L6:
        if (r103 == null) goto L16;
        String r104 = StringsKt.trim(r103).toString();
        if (r104 != null) goto L10;
        return null;
    L10:
        if (r104.length() <= 0) goto L12;
        boolean r105 = true;
    L13:
        if (r105 == true) goto L15;
        return null;
    L15:
        return r104;
    L12:
        r105 = false;
        goto L13
    L16:
        return null;
    L5:
        r103 = null;
        goto L6
    }
}
