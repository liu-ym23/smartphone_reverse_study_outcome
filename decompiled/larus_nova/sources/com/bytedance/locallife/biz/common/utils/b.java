package com.bytedance.locallife.biz.common.utils;

import android.text.TextUtils;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Gson f256637a = null;

    static {
        f256637a = new Gson();
    }

    public static Map b(JSONObject r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L10;
        String r103 = r102.next();
        String r104 = "";
        String r105 = r100.optString(r103, "");
        if (r105 == null) goto L9;
        r104 = r105;
    L9:
        r101.put(r103, r104);
        goto L4
    L10:
        return r101;
    }

    public static JSONObject c(Map r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_EXTEND);
        return new JSONObject(com.bytedance.locallife.common.utils.d.b().toJson(r100));
    L6:
        return new JSONObject();
    }

    public static JSONObject e(String r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L7
        if (r100 != null) goto L5;
        r100 = SliceInitService.DEFAULT_SWITCH;
    L5:
        Object r102 = Result.m9449constructorimpl(new JSONObject(r100));     // Catch: Throwable -> L7
    L10:
        if (Result.m9452exceptionOrNullimpl(r102) == null) goto L14;
        r102 = new JSONObject();
    L14:
        return (JSONObject) r102;
    L7:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public static String d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "targetJsonStr");
        Intrinsics.checkNotNullParameter(r101, "jsonStr");
        int r102 = 0;
        JSONObject[] r103 = {e(r100), e(r101)};
        Intrinsics.checkNotNullParameter(r103, "objs");
        JSONObject r104 = new JSONObject();
    L3:
        if (r102 >= 2) goto L10;
        JSONObject r105 = r103[r102];
        Iterator<String> r106 = r105.keys();
    L6:
        if (r106.hasNext() == false) goto L8;
        String r107 = r106.next();
        r104.put(r107, r105.get(r107));
        goto L6
    L8:
        r102 = r102 + 1;
        goto L3
    L10:
        return r104.toString();
    }

    public static void a(Map r100, JSONObject r101, String r102) throws JSONException {
        Intrinsics.checkNotNullParameter(r100, "fieldMap");
        Intrinsics.checkNotNullParameter(r102, "preKey");
        if (r101 != null) goto L5;
        return;
    L5:
        Iterator<String> r103 = r101.keys();
    L7:
        if (r103.hasNext() == false) goto L25;
        String r104 = r103.next();
        if (TextUtils.isEmpty(r102) == false) goto L11;
        String r105 = r104;
    L12:
        Object r106 = r101.get(r104);
        if ((r106 instanceof JSONObject) == true) goto L14;
        if ((r106 instanceof JSONArray) == true) goto L17;
        if (r106 == null) goto L23;
        String r107 = r106.toString();
        if (r107 == null) goto L23;
    L24:
        ((HashMap) r100).put(r105, r107);
    L23:
        r107 = "";
        goto L24
    L17:
        JSONArray r108 = (JSONArray) r106;
        int r109 = r108.length();
        int r110 = 0;
    L18:
        if (r110 >= r109) goto L7;
        a(r100, JSONArrayProtectorUtils.getJSONObject(r108, r110), r105);
        r110 = r110 + 1;
        goto L18
    L14:
        a(r100, (JSONObject) r106, r105);
        goto L7
    L11:
        r105 = r102 + '[' + r104 + ']';
        goto L12
    }
}
