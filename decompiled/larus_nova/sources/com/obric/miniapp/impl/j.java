package com.obric.miniapp.impl;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
public final class j {
    public static final Long a(JSONObject r100, String... r101) {
        if (r100 == null) goto L15;
        int r102 = r101.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L15;
        Object r104 = r100.opt(r101[r103]);
        if ((r104 instanceof Number) == true) goto L22;
        if ((r104 instanceof String) == false) goto L14;
        Long r105 = StringsKt.toLongOrNull(StringsKt.trim((String) r104).toString());
        if (r105 == null) goto L14;
        return Long.valueOf(r105.longValue());
    L14:
        r103 = r103 + 1;
        goto L5
    L22:
        return Long.valueOf(((Number) r104).longValue());
    L15:
        return null;
    }

    public static final String b(JSONObject r100, String... r101) {
        if (r100 == null) goto L12;
        int r102 = r101.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L12;
        String r104 = r100.optString(r101[r103]);
        Intrinsics.checkNotNull(r104);
        if ((!StringsKt.isBlank(r104)) == false) goto L11;
        if (Intrinsics.areEqual(r104, "null") == true) goto L11;
        return r104;
    L11:
        r103 = r103 + 1;
    L12:
        return null;
    }
}
