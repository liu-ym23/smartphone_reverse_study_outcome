package com.bytedance.ies.xbridge.utils;

import com.bytedance.ies.xbridge.model.idl.IDLXDynamic;
import com.bytedance.ies.xbridge.model.idl.XBaseModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final JSONArray a(List<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        JSONArray r101 = new JSONArray();
        List r102 = CollectionsKt.filterNotNull(r100);
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L34;
        Object r105 = r104.next();
        if ((r105 instanceof Integer) == true) goto L33;
        if ((r105 instanceof Long) == true) goto L33;
        if ((r105 instanceof String) == true) goto L33;
        if ((r105 instanceof Boolean) == true) goto L33;
        if ((r105 instanceof Double) == true) goto L33;
        if ((r105 instanceof List) == false) goto L24;
        r105 = a((List) r105);
        goto L33
    L24:
        if ((r105 instanceof Map) == false) goto L27;
        r105 = b((Map) r105);
        goto L33
    L27:
        if ((r105 instanceof IDLXDynamic) == false) goto L30;
        r105 = h66.a.b((IDLXDynamic) r105);
        goto L33
    L30:
        if ((r105 instanceof XBaseModel) == false) goto L32;
        r105 = ((XBaseModel) r105).toJSON();
        goto L33
    L32:
        r105 = null;
    L33:
        r103.add(r105);
        goto L4
    L34:
        Iterator r106 = r103.iterator();
    L36:
        if (r106.hasNext() == false) goto L40;
        Object r107 = r106.next();
        if (r107 == null) goto L36;
        r101.put(r107);
        goto L36
    L40:
        return r101;
    }

    @JvmStatic
    public static final JSONObject b(Map<?, ?> r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        JSONObject r101 = new JSONObject();
        ArrayList r102 = new ArrayList(r100.size());
        Iterator<Map.Entry<?, ?>> r103 = r100.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L34;
        Map.Entry<?, ?> r104 = r103.next();
        Object r105 = r104.getValue();
        Object r106 = r104.getKey();
        if ((r105 instanceof Integer) == true) goto L33;
        if ((r105 instanceof Long) == true) goto L33;
        if ((r105 instanceof String) == true) goto L33;
        if ((r105 instanceof Boolean) == true) goto L33;
        if ((r105 instanceof Double) == true) goto L33;
        if ((r105 instanceof List) == false) goto L24;
        r105 = a((List) r105);
        goto L33
    L24:
        if ((r105 instanceof Map) == false) goto L27;
        r105 = b((Map) r105);
        goto L33
    L27:
        if ((r105 instanceof IDLXDynamic) == false) goto L30;
        r105 = h66.a.b((IDLXDynamic) r105);
        goto L33
    L30:
        if ((r105 instanceof XBaseModel) == false) goto L32;
        r105 = ((XBaseModel) r105).toJSON();
        goto L33
    L32:
        r105 = null;
    L33:
        r102.add(TuplesKt.to(r106, r105));
        goto L4
    L34:
        Iterator r107 = r102.iterator();
    L36:
        if (r107.hasNext() == false) goto L42;
        Pair r108 = (Pair) r107.next();
        Object r109 = r108.getFirst();
        if (r109 == null) goto L36;
        if ((r109 instanceof String) == false) goto L36;
        r101.put((String) r109, r108.getSecond());
        goto L36
    L42:
        return r101;
    }
}
