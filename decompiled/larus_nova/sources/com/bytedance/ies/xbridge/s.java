package com.bytedance.ies.xbridge;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class s {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f249532a = null;

        static {
            int[] r100 = new int[XReadableType.values().length];
            r100[XReadableType.String.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r100[XReadableType.Number.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r100[XReadableType.Boolean.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r100[XReadableType.Int.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[XReadableType.Map.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r100[XReadableType.Array.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            f249532a = r100;
        }
    }

    public static final List<Object> g(v r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ArrayList r101 = new ArrayList();
        int r102 = r100.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L18;
        XReadableType r104 = r100.getType(r103);
        switch(a.f249532a[r104.ordinal()]) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L10;
            case 6: goto L7;
            default: goto L17;
        };
    L7:
        v r105 = r100.getArray(r103);
        if (r105 == null) goto L17;
        r101.add(g(r105));
        goto L17
    L10:
        XReadableMap r106 = r100.getMap(r103);
        if (r106 == null) goto L17;
        r101.add(h(r106));
        goto L17
    L13:
        r101.add(Integer.valueOf(r100.getInt(r103)));
        goto L17
    L14:
        r101.add(Boolean.valueOf(r100.getBoolean(r103)));
        goto L17
    L15:
        r101.add(Double.valueOf(r100.getDouble(r103)));
        goto L17
    L16:
        r101.add(r100.getString(r103));
    L17:
        r103 = r103 + 1;
        goto L3
    L18:
        return r101;
    }

    public static final Map<String, Object> h(XReadableMap r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        LinkedHashMap r101 = new LinkedHashMap();
        u r102 = r100.keyIterator();
    L4:
        if (r102.hasNextKey() == false) goto L18;
        String r103 = r102.nextKey();
        XReadableType r104 = r100.getType(r103);
        switch(a.f249532a[r104.ordinal()]) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L11;
            case 6: goto L8;
            default: goto L4;
        };
    L8:
        v r105 = r100.getArray(r103);
        if (r105 == null) goto L4;
        r101.put(r103, g(r105));
        goto L4
    L11:
        XReadableMap r106 = r100.getMap(r103);
        if (r106 == null) goto L4;
        r101.put(r103, h(r106));
        goto L4
    L14:
        r101.put(r103, Integer.valueOf(r100.getInt(r103)));
        goto L4
    L15:
        r101.put(r103, Boolean.valueOf(r100.getBoolean(r103)));
        goto L4
    L16:
        r101.put(r103, Double.valueOf(r100.getDouble(r103)));
        goto L4
    L17:
        r101.put(r103, r100.getString(r103));
        goto L4
    L18:
        return r101;
    }

    public static v a(XReadableMap r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "name");
        if (r100.hasKey(r101) == false) goto L8;
        t r102 = r100.get(r101);
        if (r102.getType() != XReadableType.Array) goto L8;
        return r102.asArray();
    L8:
        return null;
    }

    public static XReadableMap e(XReadableMap r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "name");
        if (r100.hasKey(r101) == false) goto L8;
        t r102 = r100.get(r101);
        if (r102.getType() != XReadableType.Map) goto L8;
        return r102.asMap();
    L8:
        return null;
    }

    public static final boolean b(XReadableMap r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "name");
        if (r100.hasKey(r101) == true) goto L5;
        return r102;
    L5:
        t r103 = r100.get(r101);
        if (r103.getType() == XReadableType.Boolean) goto L8;
        return r102;
    L8:
        return r103.asBoolean();
    }

    public static final double c(XReadableMap r100, String r101, double r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "name");
        if (r100.hasKey(r101) == true) goto L5;
        return r102;
    L5:
        t r103 = r100.get(r101);
        if (r103.getType() == XReadableType.Number) goto L8;
        return r102;
    L8:
        return r103.asDouble();
    }

    public static final int d(XReadableMap r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "name");
        if (r100.hasKey(r101) == true) goto L5;
        return r102;
    L5:
        t r103 = r100.get(r101);
        if (r103.getType() == XReadableType.Int) goto L8;
        return r102;
    L8:
        return r103.asInt();
    }

    public static final String f(XReadableMap r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "defaultValue");
        if (r100.hasKey(r101) == true) goto L5;
        return r102;
    L5:
        t r103 = r100.get(r101);
        if (r103.getType() == XReadableType.String) goto L8;
        return r102;
    L8:
        return r103.asString();
    }
}
