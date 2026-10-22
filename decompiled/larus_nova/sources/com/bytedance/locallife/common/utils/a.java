package com.bytedance.locallife.common.utils;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class a {
    public static final String a(Map<String, ? extends Object> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        Object r102 = r100.get(r101);
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.toString();
    }

    public static final void b(Map<String, String> r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        boolean r103 = false;
        if (r101 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == true) goto L18;
        if (r102 != null) goto L12;
    L13:
        r103 = true;
    L14:
        if (r103 == true) goto L19;
        r100.put(r101, r102);
        return;
    L19:
        return;
    L12:
        if (r102.length() != 0) goto L14;
    L18:
        return;
    L5:
        if (r101.length() == 0) goto L8;
        r104 = false;
        goto L9
    }

    public static final void c(JSONObject r100, String r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L16;
        if (r102 != null) goto L12;
        return;
    L12:
        if (Intrinsics.areEqual(r102, "") == true) goto L18;
        r100.put(r101, r102);
        return;
    L18:
        return;
    L16:
        return;
    L5:
        if (r101.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    public static final <K, V> V d(Map<K, V> r100, K r101, V r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        V r103 = r100.get(r101);
        if (r103 == null) goto L5;
        return r103;
    L5:
        return r100.put(r101, r102);
    }
}
