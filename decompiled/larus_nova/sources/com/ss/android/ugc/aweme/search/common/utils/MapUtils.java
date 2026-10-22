package com.ss.android.ugc.aweme.search.common.utils;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/utils/MapUtils;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MapUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MapUtils f452260a = null;

    private MapUtils() {
    }

    static {
        f452260a = new MapUtils();
    }

    public static JSONArray a(List r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        JSONArray r101 = new JSONArray();
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L45;
        Object r103 = r102.next();
        if ((r103 instanceof Float) == true) goto L7;
        if ((r103 instanceof Long) == true) goto L10;
        if ((r103 instanceof Integer) == true) goto L13;
        if ((r103 instanceof Double) == true) goto L16;
        if ((r103 instanceof String) == true) goto L19;
        if ((r103 instanceof Boolean) == true) goto L22;
        if ((r103 instanceof Map) == false) goto L35;
        MapUtils r104 = f452260a;     // Catch: ClassCastException -> L30 JSONException -> L32
        if (r103 != null) goto L27;
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");     // Catch: ClassCastException -> L30 JSONException -> L32
    L27:
        r104.getClass();     // Catch: ClassCastException -> L30 JSONException -> L32
        r101.put(b((Map) r103));     // Catch: ClassCastException -> L30 JSONException -> L32
    L30:
        e = move-exception;
        e.getMessage();
    L32:
        e = move-exception;
        e.getMessage();
        goto L4
    L35:
        if ((r103 instanceof List) == false) goto L4;
        MapUtils r105 = f452260a;     // Catch: ClassCastException -> L41 JSONException -> L43
        if (r103 != null) goto L38;
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");     // Catch: ClassCastException -> L41 JSONException -> L43
    L38:
        r105.getClass();     // Catch: ClassCastException -> L41 JSONException -> L43
        r101.put(a((List) r103));     // Catch: ClassCastException -> L41 JSONException -> L43
    L41:
        e = move-exception;
        e.getMessage();
    L43:
        e = move-exception;
        e.getMessage();
        goto L4
    L22:
        r101.put(((Boolean) r103).booleanValue());
        goto L4
    L19:
        r101.put(r103);
        goto L4
    L16:
        r101.put(((Number) r103).doubleValue());
        goto L4
    L13:
        r101.put(((Number) r103).intValue());
        goto L4
    L10:
        r101.put(((Number) r103).longValue());
        goto L4
    L7:
        r101.put(((Number) r103).floatValue());
        goto L4
    L45:
        return r101;
    }

    public static JSONObject b(Map r100) {
        JSONObject r101 = new JSONObject();
        if (r100 != null) goto L5;
        return r101;
    L5:
        Iterator r102 = r100.entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L42;
        Map.Entry r103 = (Map.Entry) r102.next();
        String r104 = (String) r103.getKey();
        Object r105 = r103.getValue();
        if ((r105 instanceof Long) == true) goto L10;
        if ((r105 instanceof Float) == true) goto L13;
        if ((r105 instanceof Integer) == true) goto L16;
        if ((r105 instanceof Double) == true) goto L19;
        if ((r105 instanceof String) == true) goto L22;
        if ((r105 instanceof Boolean) == true) goto L25;
        if ((r105 instanceof Map) == false) goto L35;
        f452260a.getClass();     // Catch: ClassCastException -> L30 JSONException -> L32
        r101.put(r104, b((Map) r105));     // Catch: ClassCastException -> L30 JSONException -> L32
    L30:
        e = move-exception;
        e.getMessage();
    L32:
        e = move-exception;
        e.getMessage();
        goto L7
    L35:
        if ((r105 instanceof List) == false) goto L7;
        f452260a.getClass();     // Catch: ClassCastException -> L38 JSONException -> L40
        r101.put(r104, a((List) r105));     // Catch: ClassCastException -> L38 JSONException -> L40
    L38:
        e = move-exception;
        e.getMessage();
    L40:
        e = move-exception;
        e.getMessage();
        goto L7
    L25:
        r101.put(r104, ((Boolean) r105).booleanValue());
        goto L7
    L22:
        r101.put(r104, r105);
        goto L7
    L19:
        r101.put(r104, ((Number) r105).doubleValue());
        goto L7
    L16:
        r101.put(r104, ((Number) r105).intValue());
        goto L7
    L13:
        r101.put(r104, ((Number) r105).floatValue());
        goto L7
    L10:
        r101.put(r104, ((Number) r105).longValue());
        goto L7
    L42:
        return r101;
    }
}
