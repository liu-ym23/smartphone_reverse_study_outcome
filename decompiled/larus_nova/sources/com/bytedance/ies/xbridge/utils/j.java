package com.bytedance.ies.xbridge.utils;

import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.XReadableType;
import com.bytedance.ies.xbridge.u;
import com.bytedance.ies.xbridge.v;
import java.util.ArrayList;
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
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f249563a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f249564a = null;

        static {
            int[] r100 = new int[XReadableType.values().length];
            r100[XReadableType.Array.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r100[XReadableType.Map.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r100[XReadableType.String.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r100[XReadableType.Number.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[XReadableType.Int.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r100[XReadableType.Boolean.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            f249564a = r100;
        }
    }

    static {
    }

    public static List a(JSONArray r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        ArrayList r101 = new ArrayList();
        int r102 = r100.length();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L6;
        r101.add(r100.get(r103));
        r103 = r103 + 1;
        goto L3
    L6:
        return CollectionsKt.toList(r101);
    }

    public static Map b(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L7;
        String r103 = r102.next();
        r101.put(r103, r100.get(r103));
        goto L4
    L7:
        return MapsKt.toMap(r101);
    }

    public static JSONArray c(v r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        JSONArray r101 = new JSONArray();
        Iterator<T> r102 = r100.toList().iterator();
        int r103 = 0;
    L4:
        if (r102.hasNext() == false) goto L22;
        r102.next();
        int r104 = r103 + 1;
        if (r103 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        XReadableType r105 = r100.getType(r103);
        switch(a.f249564a[r105.ordinal()]) {
            case 1: goto L18;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            default: goto L21;
        };
    L11:
        r101.put(r100.getBoolean(r103));
        goto L21
    L12:
        r101.put(r100.getInt(r103));
        goto L21
    L13:
        r101.put(r100.getDouble(r103));
        goto L21
    L14:
        r101.put(r100.getString(r103));
        goto L21
    L15:
        XReadableMap r106 = r100.getMap(r103);
        if (r106 == null) goto L21;
        r101.put(d(r106));
        goto L21
    L18:
        v r107 = r100.getArray(r103);
        if (r107 == null) goto L21;
        r101.put(c(r107));
    L21:
        r103 = r104;
        goto L4
    L22:
        return r101;
    }

    public static JSONObject d(XReadableMap r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        JSONObject r101 = new JSONObject();
        u r102 = r100.keyIterator();
    L4:
        if (r102.hasNextKey() == false) goto L18;
        String r103 = r102.nextKey();
        XReadableType r104 = r100.getType(r103);
        switch(a.f249564a[r104.ordinal()]) {
            case 1: goto L15;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L4;
        };
    L8:
        r101.put(r103, r100.getBoolean(r103));
        goto L4
    L9:
        r101.put(r103, r100.getInt(r103));
        goto L4
    L10:
        r101.put(r103, r100.getDouble(r103));
        goto L4
    L11:
        r101.put(r103, r100.getString(r103));
        goto L4
    L12:
        XReadableMap r105 = r100.getMap(r103);
        if (r105 == null) goto L4;
        r101.put(r103, d(r105));
        goto L4
    L15:
        v r106 = r100.getArray(r103);
        if (r106 == null) goto L4;
        r101.put(r103, c(r106));
        goto L4
    L18:
        return r101;
    }
}
