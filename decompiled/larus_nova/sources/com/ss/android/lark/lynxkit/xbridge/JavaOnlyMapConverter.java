package com.ss.android.lark.lynxkit.xbridge;

import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u0001J\u0014\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0002J\u001a\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007*\u00020\u0010H\u0002J\u0014\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000e*\u00020\u0012H\u0002¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/lynxkit/xbridge/JavaOnlyMapConverter;", "", "<init>", "()V", "toLynxMap", "Lcom/lynx/react/bridge/JavaOnlyMap;", "map", "", "", "toLynxValue", "value", "toLynxArray", "Lcom/lynx/react/bridge/JavaOnlyArray;", "list", "", "toMap", "Lorg/json/JSONObject;", "toList", "Lorg/json/JSONArray;", "lark-lynx-xbridge_chinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class JavaOnlyMapConverter {
    public static final JavaOnlyMapConverter INSTANCE = null;

    static {
        INSTANCE = new JavaOnlyMapConverter();
    }

    private JavaOnlyMapConverter() {
    }

    private final List<Object> toList(JSONArray r100) {
        IntRange r101 = RangesKt.until(0, r100.length());
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<Integer> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r102.add(r100.opt(((IntIterator) r103).nextInt()));
        goto L4
    L6:
        return r102;
    }

    private final JavaOnlyArray toLynxArray(List<?> r100) {
        JavaOnlyArray r101 = new JavaOnlyArray();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        Object r103 = r102.next();
        Object r104 = INSTANCE.toLynxValue(r103);
        if (r104 == null) goto L7;
        r101.add(r104);
        goto L4
    L7:
        r101.pushNull();
        goto L4
    L9:
        return r101;
    }

    private final Map<String, Object> toMap(JSONObject r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L6;
        String r103 = r102.next();
        r101.put(r103, r100.opt(r103));
        goto L4
    L6:
        return r101;
    }

    public final JavaOnlyMap toLynxMap(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        JavaOnlyMap r101 = new JavaOnlyMap();
        Iterator<Map.Entry<String, ? extends Object>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        Map.Entry<String, ? extends Object> r103 = r102.next();
        String r104 = r103.getKey();
        Object r105 = r103.getValue();
        Object r106 = INSTANCE.toLynxValue(r105);
        if (r106 == null) goto L7;
        r101.put(r104, r106);
        goto L4
    L7:
        r101.putNull(r104);
        goto L4
    L9:
        return r101;
    }

    public final Object toLynxValue(Object r100) {
        if (r100 != JSONObject.NULL) goto L6;
        return null;
    L6:
        if ((r100 instanceof JSONObject) == false) goto L9;
        return toLynxMap(toMap((JSONObject) r100));
    L9:
        if ((r100 instanceof JSONArray) == false) goto L12;
        return toLynxArray(toList((JSONArray) r100));
    L12:
        if ((r100 instanceof Map) == false) goto L19;
        Set r101 = ((Map) r100).entrySet();
        LinkedHashMap r102 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r101, 10)), 16));
        Iterator r103 = r101.iterator();
    L15:
        if (r103.hasNext() == false) goto L26;
        Map.Entry r104 = (Map.Entry) r103.next();
        Object r105 = r104.getKey();
        Object r106 = r104.getValue();
        Pair r107 = TuplesKt.to(String.valueOf(r105), r106);
        r102.put(r107.getFirst(), r107.getSecond());
        goto L15
    L26:
        return toLynxMap(r102);
    L19:
        if ((r100 instanceof List) == true) goto L21;
        return r100;
    L21:
        return toLynxArray((List) r100);
    }
}
