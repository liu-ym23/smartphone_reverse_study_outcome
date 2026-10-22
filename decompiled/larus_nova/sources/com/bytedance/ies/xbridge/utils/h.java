package com.bytedance.ies.xbridge.utils;

import com.bytedance.ies.xbridge.exception.IllegalOutputParamException;
import com.bytedance.ies.xbridge.model.idl.XBaseModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f249561a = 0;

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.util.LinkedHashMap, java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.Object] */
    public static Object b(Object r100, Class r101, Class r102) {
        if (Intrinsics.areEqual(r102, Object.class) == false) goto L8;
        if ((r100 instanceof b) == false) goto L8;
        return ((b) r100).getValue();
    L8:
        if ((r100 instanceof Integer) == false) goto L10;
        return r100;
    L10:
        if ((r100 instanceof String) == false) goto L12;
        return r100;
    L12:
        if ((r100 instanceof Number) == false) goto L14;
        return r100;
    L14:
        if ((r100 instanceof Boolean) == true) goto L46;
        if (r100 != null) goto L18;
        return r100;
    L18:
        if ((r100 instanceof List) == false) goto L25;
        Iterable r103 = (Iterable) r100;
        ?? r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator r105 = r103.iterator();
    L21:
        if (r105.hasNext() == false) goto L47;
        r104.add(b(r105.next(), r101, r102));
    L47:
        return r104;
    L25:
        if ((r100 instanceof Map) == false) goto L31;
        Map r106 = (Map) r100;
        r104 = new LinkedHashMap(MapsKt.mapCapacity(r106.size()));
        Iterator r107 = r106.entrySet().iterator();
    L28:
        if (r107.hasNext() == false) goto L47;
        Map.Entry r108 = (Map.Entry) r107.next();
        r104.put(r108.getKey(), b(r108.getValue(), r101, r102));
        goto L28
    L31:
        if ((r100 instanceof JSONObject) == false) goto L33;
        return r100;
    L33:
        if ((r100 instanceof JSONArray) == true) goto L51;
        XBaseModel r109 = (XBaseModel) r101.cast(r100);
        if (r109 != null) goto L49;
        return null;
    L49:
        return r109.convert();
    L51:
        return r100;
    L46:
        return r100;
    }

    public static void a(boolean r100, List r101, Object r102, String r103) {
        if (r100 == false) goto L26;
        boolean r104 = false;
        if ((r102 instanceof Collection) == false) goto L19;
        Iterable r105 = (Iterable) r102;
        if ((r105 instanceof Collection) == true) goto L8;
    L10:
        Iterator r106 = r105.iterator();
    L12:
        if (r106.hasNext() == false) goto L22;
        Object r107 = r106.next();
        if (r101 != null) goto L16;
        boolean r108 = false;
    L17:
        if (r108 == false) goto L12;
        r104 = true;
        goto L22
    L16:
        r108 = !CollectionsKt.contains(r101, r107);
    L22:
        if (r104 == true) goto L25;
        return;
    L25:
        throw new IllegalOutputParamException(r103 + " is not valid");
    L8:
        if (((Collection) r105).isEmpty() == false) goto L10;
    L19:
        if (r101 == null) goto L22;
        r104 = !CollectionsKt.contains(r101, r102);
        goto L22
    }
}
