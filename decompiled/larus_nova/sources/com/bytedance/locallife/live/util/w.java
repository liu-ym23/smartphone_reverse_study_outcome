package com.bytedance.locallife.live.util;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class w {

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/locallife/live/util/w$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
    public static final class a extends TypeToken<List<Object>> {
        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001¨\u0006\u0005"}, d2 = {"com/bytedance/locallife/live/util/w$b", "Lcom/google/gson/reflect/TypeToken;", "", "", "", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
    public static final class b extends TypeToken<Map<String, Object>> {
        public b() {
        }
    }

    public static final List<Object> g(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Gson r101 = LiveLifeSaaSUtil.r();
        Type r102 = new a().getType();
        return (List) r101.fromJson(GsonProtectorUtils.toJson(r101, r100), r102);
    L6:
        return new ArrayList();
    }

    public static final Map<String, Object> h(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Gson r101 = LiveLifeSaaSUtil.r();
        Type r102 = new b().getType();
        if ((r100 instanceof String) == false) goto L5;
        String r103 = (String) r100;
    L10:
        return (Map) r101.fromJson(r103, r102);
    L9:
        return new LinkedHashMap();
    L5:
        r103 = GsonProtectorUtils.toJson(r101, r100);
        goto L10
    }

    public static final Map<String, Object> i(JSONObject r100) throws JSONException {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        HashMap r101 = new HashMap();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L12;
        String r103 = r102.next();
        Object r104 = r100.get(r103);
        if ((r104 instanceof JSONArray) == false) goto L9;
        r104 = g(r104);
    L11:
        r101.put(r103, r104);
        goto L4
    L9:
        if ((r104 instanceof JSONObject) == false) goto L11;
        r104 = i((JSONObject) r104);
        goto L11
    L12:
        return r101;
    }

    public static final Float a(Map<String, ? extends Object> r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r100 == null) goto L5;
        Object r102 = r100.get(r101);
    L7:
        if ((r102 instanceof Double) == false) goto L10;
        return Float.valueOf((float) ((Number) r102).doubleValue());
    L10:
        if ((r102 instanceof Integer) == false) goto L13;
        return Float.valueOf(((Number) r102).intValue());
    L13:
        if ((r102 instanceof Long) == false) goto L16;
        return Float.valueOf(((Number) r102).longValue());
    L16:
        if ((r102 instanceof Float) == true) goto L18;
        return null;
    L18:
        return (Float) r102;
    L5:
        r102 = null;
        goto L7
    }

    public static final Integer b(Map<String, ? extends Object> r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r100 == null) goto L5;
        Object r102 = r100.get(r101);
    L7:
        if ((r102 instanceof Double) == false) goto L10;
        return Integer.valueOf((int) ((Number) r102).doubleValue());
    L10:
        if ((r102 instanceof Float) == false) goto L13;
        return Integer.valueOf((int) ((Number) r102).floatValue());
    L13:
        if ((r102 instanceof Long) == false) goto L16;
        return Integer.valueOf((int) ((Number) r102).longValue());
    L16:
        if ((r102 instanceof Integer) == true) goto L18;
        return null;
    L18:
        return (Integer) r102;
    L5:
        r102 = null;
        goto L7
    }

    public static final Long c(Map<String, ? extends Object> r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r100 == null) goto L5;
        Object r102 = r100.get(r101);
    L7:
        if ((r102 instanceof Double) == false) goto L10;
        return Long.valueOf((long) ((Number) r102).doubleValue());
    L10:
        if ((r102 instanceof Float) == false) goto L13;
        return Long.valueOf((long) ((Number) r102).floatValue());
    L13:
        if ((r102 instanceof Integer) == false) goto L16;
        return Long.valueOf(((Number) r102).intValue());
    L16:
        if ((r102 instanceof Long) == true) goto L18;
        return null;
    L18:
        return (Long) r102;
    L5:
        r102 = null;
        goto L7
    }

    public static final Map<String, Object> d(Map<String, ? extends Object> r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r100 == null) goto L5;
        Object r102 = r100.get(r101);
    L7:
        if ((r102 instanceof Map) == true) goto L9;
        return null;
    L9:
        return (Map) r102;
    L5:
        r102 = null;
        goto L7
    }

    public static final Map<String, Object> e(Map<String, ? extends Object> r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r100 == null) goto L5;
        Object r102 = r100.get(r101);
    L7:
        if (TypeIntrinsics.isMutableMap(r102) == true) goto L9;
        return null;
    L9:
        return (Map) r102;
    L5:
        r102 = null;
        goto L7
    }

    public static final String f(Map<String, ? extends Object> r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r100 == null) goto L5;
        Object r102 = r100.get(r101);
    L7:
        if ((r102 instanceof String) == true) goto L9;
        return null;
    L9:
        return (String) r102;
    L5:
        r102 = null;
        goto L7
    }
}
