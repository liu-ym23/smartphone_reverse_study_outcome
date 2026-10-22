package com.larus.chat.job.impl.page.edit;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f325224a = 0;

    static {
    }

    public static String a(String r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
        Object r102 = Result.m9449constructorimpl(new JSONTokener(r100).nextValue());     // Catch: Throwable -> L4
    L7:
        if (Result.m9455isFailureimpl(r102) == false) goto L10;
        r102 = null;
    L10:
        if ((r102 instanceof JSONArray) == false) goto L12;
        JSONArray r103 = (JSONArray) r102;
    L13:
        if (r103 != null) goto L15;
        return null;
    L15:
        int r104 = r103.length();
        int r105 = 0;
        String r106 = null;
    L16:
        if (r105 >= r104) goto L40;
        JSONObject r107 = r103.optJSONObject(r105);
        if (r107 == null) goto L39;
        JSONObject r108 = r107.optJSONObject("content");
        if (r108 == null) goto L39;
        JSONObject r109 = r108.optJSONObject("lynx_block");
        if (r109 == null) goto L39;
        String r110 = r109.optString("lynx_data");
        if (r110 == null) goto L39;
        if ((!StringsKt.isBlank(r110)) == true) goto L30;
        r110 = null;
    L30:
        if (r110 == null) goto L39;
        Integer r111 = d(r107, "block_type");
        if (r111 != null) goto L35;
    L37:
        if (r106 != null) goto L39;
        r106 = r110;
        goto L39
    L35:
        if (r111.intValue() != 10067) goto L37;
        return r110;
    L39:
        r105 = r105 + 1;
        goto L16
    L40:
        return r106;
    L12:
        r103 = null;
    L4:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static String b(String... r100) {
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L15;
        String r103 = r100[r102];
        if (r103 != null) goto L7;
    L10:
        boolean r104 = true;
    L12:
        if ((true ^ r104) == true) goto L16;
        r102 = r102 + 1;
    L16:
        if (r103 != null) goto L21;
        return "";
    L21:
        return r103;
    L7:
        if (StringsKt.isBlank(r103) == true) goto L10;
        r104 = false;
        goto L12
    L15:
        r103 = null;
        goto L16
    }

    public static String c(JSONArray r100) {
        int r101 = r100.length();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L11;
        String r103 = r100.optString(r102);
        Intrinsics.checkNotNull(r103);
        if ((!StringsKt.isBlank(r103)) == true) goto L8;
        r103 = null;
    L8:
        if (r103 != null) goto L9;
        r102 = r102 + 1;
        goto L3
    L9:
        return r103;
    L11:
        return "";
    }

    public static JSONObject e(String r100) {
        Object r101 = null;
        if (StringsKt.isBlank(r100) == true) goto L21;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L11
        Object r103 = new JSONTokener(r100).nextValue();     // Catch: Throwable -> L11
        if ((r103 instanceof JSONObject) == false) goto L8;
        JSONObject r104 = (JSONObject) r103;     // Catch: Throwable -> L11
    L9:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L11
    L14:
        if (Result.m9455isFailureimpl(r105) == true) goto L18;
        r101 = r105;
    L18:
        return (JSONObject) r101;
    L8:
        r104 = null;
    L11:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    L21:
        return null;
    }

    public static Integer d(JSONObject r100, String r101) {
        if (r100.has(r101) == true) goto L5;
    L7:
        return null;
    L5:
        if (r100.isNull(r101) == true) goto L7;
        return Integer.valueOf(r100.optInt(r101));
    }
}
