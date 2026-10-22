package com.bytedance.sdk.xbridge.cn.utils;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b2\u0006\u0010\u0005\u001a\u00020\nJ \u0010\u000b\u001a\u00020\u00062\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00042\b\b\u0002\u0010\r\u001a\u00020\u000eJ&\u0010\u000f\u001a\u00020\n2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b2\b\b\u0002\u0010\r\u001a\u00020\u000eJ\u001c\u0010\u0011\u001a\u00020\u0012*\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000eH\u0002J$\u0010\u0011\u001a\u00020\u0012*\u00020\n2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000eH\u0002¨\u0006\u0017"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/utils/ConvertUtils;", "", "()V", "jsonToList", "", "json", "Lorg/json/JSONArray;", "jsonToMap", "", "", "Lorg/json/JSONObject;", "listToJSON", "list", "bigIntStrategy", "", "mapToJSON", "map", "putLongWithStrategy", "", "value", "", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "key", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class ConvertUtils {
    public static final ConvertUtils INSTANCE = null;

    static {
        INSTANCE = new ConvertUtils();
    }

    private ConvertUtils() {
    }

    public final List<Object> jsonToList(JSONArray r100) {
        Intrinsics.checkNotNullParameter(r100, "json");
        ArrayList r101 = new ArrayList();
        int r102 = r100.length();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L27;
        Object r104 = r100.opt(r103);
        if ((r104 instanceof Long) == false) goto L8;
        r101.add(Long.valueOf(r100.optLong(r103)));
    L26:
        r103 = r103 + 1;
        goto L3
    L8:
        if ((r104 instanceof Double) == false) goto L11;
        r101.add(Double.valueOf(r100.optDouble(r103)));
        goto L26
    L11:
        if ((r104 instanceof Integer) == false) goto L14;
        r101.add(Integer.valueOf(JSONArrayProtectorUtils.getInt(r100, r103)));
        goto L26
    L14:
        if ((r104 instanceof String) == false) goto L17;
        r101.add(r100.optString(r103));
        goto L26
    L17:
        if ((r104 instanceof JSONObject) == false) goto L20;
        r101.add(INSTANCE.jsonToMap(r100.optJSONObject(r103)));
        goto L26
    L20:
        if ((r104 instanceof JSONArray) == false) goto L23;
        r101.add(INSTANCE.jsonToList(r100.optJSONArray(r103)));
        goto L26
    L23:
        if ((r104 instanceof Boolean) == false) goto L25;
        r101.add(Boolean.valueOf(r100.optBoolean(r103)));
        goto L26
    L25:
        r101.add(null);
        goto L26
    L27:
        return r101;
    }

    public final Map<String, Object> jsonToMap(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "json");
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L27;
        String r103 = r102.next();
        Object r104 = r100.opt(r103);
        if ((r104 instanceof Long) == true) goto L7;
        if ((r104 instanceof Double) == true) goto L10;
        if ((r104 instanceof Integer) == true) goto L13;
        if ((r104 instanceof String) == true) goto L16;
        if ((r104 instanceof JSONObject) == true) goto L19;
        if ((r104 instanceof JSONArray) == true) goto L22;
        if ((r104 instanceof Boolean) == true) goto L25;
        r101.put(r103, null);
        goto L4
    L25:
        r101.put(r103, Boolean.valueOf(r100.optBoolean(r103)));
        goto L4
    L22:
        r101.put(r103, INSTANCE.jsonToList(r100.optJSONArray(r103)));
        goto L4
    L19:
        r101.put(r103, INSTANCE.jsonToMap(r100.optJSONObject(r103)));
        goto L4
    L16:
        r101.put(r103, r100.optString(r103));
        goto L4
    L13:
        r101.put(r103, Integer.valueOf(r100.optInt(r103)));
        goto L4
    L10:
        r101.put(r103, Double.valueOf(r100.optDouble(r103)));
        goto L4
    L7:
        r101.put(r103, Long.valueOf(r100.optLong(r103)));
        goto L4
    L27:
        return r101;
    }

    public final JSONArray listToJSON(List<? extends Object> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "list");
        JSONArray r102 = new JSONArray();
        Iterator<T> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L34;
        Object r104 = r103.next();
        if ((r104 instanceof Float) == true) goto L7;
        if ((r104 instanceof Long) == true) goto L10;
        if ((r104 instanceof Integer) == true) goto L13;
        if ((r104 instanceof Double) == true) goto L16;
        if ((r104 instanceof String) == true) goto L19;
        if ((r104 instanceof Boolean) == true) goto L22;
        if ((r104 instanceof Map) == false) goto L29;
        ConvertUtils r105 = INSTANCE;     // Catch: Exception -> L27
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");     // Catch: Exception -> L27
        r102.put(r105.mapToJSON((Map) r104, r101));     // Catch: Exception -> L27
        goto L4
    L29:
        if ((r104 instanceof List) == true) goto L30;
        if (r104 != null) goto L4;
        r102.put(JSONObject.NULL);
        goto L4
    L30:
        ConvertUtils r106 = INSTANCE;     // Catch: Exception -> L27
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");     // Catch: Exception -> L27
        r102.put(r106.listToJSON((List) r104, r101));     // Catch: Exception -> L27
        goto L4
    L22:
        r102.put(((Boolean) r104).booleanValue());
        goto L4
    L19:
        r102.put(r104);
        goto L4
    L16:
        r102.put(((Number) r104).doubleValue());
        goto L4
    L13:
        r102.put(((Number) r104).intValue());
        goto L4
    L10:
        INSTANCE.putLongWithStrategy(r102, ((Number) r104).longValue(), r101);
        goto L4
    L7:
        r102.put(((Number) r104).floatValue());
        goto L4
    L34:
        return r102;
    }

    public final JSONObject mapToJSON(Map<String, ? extends Object> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "map");
        JSONObject r102 = new JSONObject();
        Iterator<Map.Entry<String, ? extends Object>> r103 = r100.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L40;
        Map.Entry<String, ? extends Object> r104 = r103.next();
        String r105 = r104.getKey();
        Object r106 = r104.getValue();
        if ((r106 instanceof Long) == true) goto L7;
        if ((r106 instanceof Float) == true) goto L10;
        if ((r106 instanceof Integer) == true) goto L13;
        if ((r106 instanceof Double) == true) goto L16;
        if ((r106 instanceof String) == true) goto L19;
        if ((r106 instanceof Boolean) == true) goto L22;
        if ((r106 instanceof JSONObject) == true) goto L25;
        if ((r106 instanceof JSONArray) == true) goto L28;
        if ((r106 instanceof Map) == false) goto L35;
        r102.put(r105, INSTANCE.mapToJSON((Map) r106, r101));     // Catch: Exception -> L33
        goto L4
    L35:
        if ((r106 instanceof List) == true) goto L36;
        if (r106 != null) goto L4;
        r102.put(r105, JSONObject.NULL);
        goto L4
    L36:
        r102.put(r105, INSTANCE.listToJSON((List) r106, r101));     // Catch: Exception -> L33
        goto L4
    L28:
        r102.put(r105, r106);
        goto L4
    L25:
        r102.put(r105, r106);
        goto L4
    L22:
        r102.put(r105, ((Boolean) r106).booleanValue());
        goto L4
    L19:
        r102.put(r105, r106);
        goto L4
    L16:
        r102.put(r105, ((Number) r106).doubleValue());
        goto L4
    L13:
        r102.put(r105, ((Number) r106).intValue());
        goto L4
    L10:
        r102.put(r105, ((Number) r106).floatValue());
        goto L4
    L7:
        INSTANCE.putLongWithStrategy(r102, r105, ((Number) r106).longValue(), r101);
        goto L4
    L40:
        return r102;
    }

    private final void putLongWithStrategy(JSONArray r100, long r101, int r102) {
        if (r102 != 0) goto L4;
        r100.put(r101);
        return;
    L4:
        if (r102 != 1) goto L6;
        r100.put(String.valueOf(r101));
        return;
    L6:
        if (r102 != 2) goto L14;
        r100.put(r101);
        return;
    }

    private final void putLongWithStrategy(JSONObject r100, String r101, long r102, int r103) {
        if (r103 != 0) goto L4;
        r100.put(r101, r102);
        return;
    L4:
        if (r103 != 1) goto L6;
        r100.put(r101, String.valueOf(r102));
        return;
    L6:
        if (r103 != 2) goto L14;
        r100.put(r101, r102);
        return;
    }

    public static /* synthetic */ JSONArray listToJSON$default(ConvertUtils r100, List r101, int r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = 0;
    L6:
        return r100.listToJSON(r101, r102);
    }

    public static /* synthetic */ JSONObject mapToJSON$default(ConvertUtils r100, Map r101, int r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = 0;
    L6:
        return r100.mapToJSON(r101, r102);
    }
}
