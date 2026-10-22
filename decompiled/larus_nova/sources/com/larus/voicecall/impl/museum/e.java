package com.larus.voicecall.impl.museum;

import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class e {
    public static final a b(String r110) {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L8
        if (r110 != null) goto L5;
        String r101 = "";
    L6:
        Object r102 = Result.m9449constructorimpl(new JSONObject(r101));     // Catch: Throwable -> L8
    L11:
        if (Result.m9455isFailureimpl(r102) == false) goto L13;
        r102 = null;
    L13:
        JSONObject r103 = (JSONObject) r102;
        if (r103 != null) goto L17;
        return null;
    L17:
        if (Intrinsics.areEqual(r103.optString("scene"), "museum_extension_banner") == true) goto L19;
        return null;
    L19:
        JSONObject r104 = a(r103, "data");
        if (r104 != null) goto L23;
        return null;
    L23:
        if (Intrinsics.areEqual(r104.optString("banner_source"), "museum_extend_pack") == true) goto L25;
        return null;
    L25:
        JSONObject r105 = a(r104, "ext");
        if (r105 != null) goto L28;
        r105 = new JSONObject();
    L28:
        String r111 = r105.optString("stage");
        if (SetsKt.setOf(new String[]{"start_session_auto", "warning", "no_quota", "hangup"}).contains(r111) == true) goto L31;
        return null;
    L31:
        String r106 = r104.optString("button_text");
        Intrinsics.checkNotNull(r106);
        if ((!StringsKt.isBlank(r106)) == false) goto L34;
        String r112 = r106;
    L35:
        if (r112 != null) goto L37;
        return null;
    L37:
        JSONObject r107 = a(r104, "policy");
        String r108 = r103.optString("title");
        String r109 = r103.optString("content");
        String r113 = r103.optString("icon");
        String r114 = r105.optString("museum");
        Intrinsics.checkNotNull(r111);
        Integer r115 = StringsKt.toIntOrNull(r104.optString("priority"));
        if (r115 == null) goto L40;
        int r116 = r115.intValue();
    L41:
        int r117 = r116;
        if (r107 == null) goto L44;
        long r118 = r107.optLong("auto_dismiss_seconds");
    L45:
        long r119 = r118;
        String r120 = r104.optString("conversation_id");
        Intrinsics.checkNotNull(r120);
        if ((!StringsKt.isBlank(r120)) == false) goto L48;
        String r121 = r120;
    L49:
        String r122 = r105.optString("call_id");
        Intrinsics.checkNotNull(r122);
        if ((!StringsKt.isBlank(r122)) == false) goto L52;
        String r123 = r122;
    L54:
        return new a(r108, r109, r113, r114, r111, r112, r117, r119, r121, r123);
    L52:
        r123 = null;
        goto L54
    L48:
        r121 = null;
        goto L49
    L44:
        r118 = r104.optLong(RemoteMessageConst.TTL, 15);
        goto L45
    L40:
        r116 = r104.optInt("priority", 0);
        goto L41
    L34:
        r112 = null;
        goto L35
    L5:
        r101 = r110;
    L8:
        th = move-exception;
        Result.Companion r124 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public static final String c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        switch(r100.hashCode()) {
            case -1224574323: goto L18;
            case 145397365: goto L14;
            case 991992442: goto L10;
            case 1124446108: goto L6;
            default: goto L25;
        };
    L25:
        return r100;
    L6:
        if (r100.equals("warning") == false) goto L26;
        return "75_percent";
    L26:
        return r100;
    L10:
        if (r100.equals("no_quota") == false) goto L27;
        return "wall";
    L27:
        return r100;
    L14:
        if (r100.equals("start_session_auto") == false) goto L28;
        return "scan_wall_auto";
    L28:
        return r100;
    L18:
        if (r100.equals("hangup") == false) goto L29;
        return "post_call";
    L29:
        return r100;
    }

    public static final JSONObject a(JSONObject r100, String r101) {
        Object r102 = r100.opt(r101);
        if ((r102 instanceof JSONObject) == true) goto L20;
        Object r103 = null;
        if ((r102 instanceof String) == false) goto L17;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L9
        Object r105 = Result.m9449constructorimpl(new JSONObject((String) r102));     // Catch: Throwable -> L9
    L12:
        if (Result.m9455isFailureimpl(r105) == true) goto L21;
        r103 = r105;
    L21:
        return (JSONObject) r103;
    L9:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    L17:
        return null;
    L20:
        return (JSONObject) r102;
    }
}
