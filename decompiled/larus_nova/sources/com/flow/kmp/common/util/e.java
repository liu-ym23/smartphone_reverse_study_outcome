package com.flow.kmp.common.util;

import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import ouc.a0;
import ouc.d0;
import ouc.e0;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public static final ouc.b a(JSONArray r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.length() <= 0) goto L5;
        ouc.c r101 = new ouc.c();
        int r102 = r100.length();
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L29;
        if (r100.isNull(r103) == false) goto L11;
        r101.a(a0.INSTANCE);
    L27:
        r103 = r103 + 1;
        goto L7
    L11:
        Object r104 = r100.get(r103);
        if ((r104 instanceof Number) == false) goto L15;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        r101.a(ouc.k.b((Number) r104));
        goto L27
    L15:
        if ((r104 instanceof Boolean) == false) goto L18;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        r101.a(ouc.k.a((Boolean) r104));
        goto L27
    L18:
        if ((r104 instanceof String) == false) goto L21;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        r101.a(ouc.k.c((String) r104));
        goto L27
    L21:
        if ((r104 instanceof JSONObject) == false) goto L24;
        r101.a(b((JSONObject) r104));
        goto L27
    L24:
        if ((r104 instanceof JSONArray) == false) goto L26;
        r101.a(a((JSONArray) r104));
        goto L27
    L26:
        String r105 = r104.toString();
        Intrinsics.checkNotNullParameter(r101, "<this>");
        r101.a(ouc.k.c(r105));
        goto L27
    L29:
        return new ouc.b(r101.f526807a);
    L5:
        return new ouc.b(CollectionsKt.emptyList());
    }

    public static final d0 b(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.length() <= 0) goto L5;
        e0 r101 = new e0();
        Iterator<String> r102 = r100.keys();
    L8:
        if (r102.hasNext() == false) goto L29;
        String r103 = r102.next();
        if (r100.isNull(r103) == true) goto L11;
        Object r104 = r100.get(r103);
        if ((r104 instanceof Number) == true) goto L14;
        if ((r104 instanceof Boolean) == true) goto L17;
        if ((r104 instanceof String) == true) goto L20;
        if ((r104 instanceof JSONArray) == true) goto L23;
        if ((r104 instanceof JSONObject) == true) goto L26;
        Intrinsics.checkNotNull(r103);
        ouc.j.c(r101, r103, r104.toString());
        goto L8
    L26:
        Intrinsics.checkNotNull(r103);
        r101.b(r103, b((JSONObject) r104));
        goto L8
    L23:
        Intrinsics.checkNotNull(r103);
        r101.b(r103, a((JSONArray) r104));
        goto L8
    L20:
        Intrinsics.checkNotNull(r103);
        ouc.j.c(r101, r103, (String) r104);
        goto L8
    L17:
        Intrinsics.checkNotNull(r103);
        ouc.j.a(r101, r103, (Boolean) r104);
        goto L8
    L14:
        Intrinsics.checkNotNull(r103);
        ouc.j.b(r101, r103, (Number) r104);
        goto L8
    L11:
        Intrinsics.checkNotNull(r103);
        r101.b(r103, a0.INSTANCE);
        goto L8
    L29:
        return r101.a();
    L5:
        return new d0(MapsKt.emptyMap());
    }
}
