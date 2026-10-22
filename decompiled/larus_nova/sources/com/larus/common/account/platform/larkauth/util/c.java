package com.larus.common.account.platform.larkauth.util;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class c {
    static {
    }

    public static Map a(a09.a r100, String r101, boolean r102) {
        if (r100 == null) goto L4;
        LinkedHashMap r103 = new LinkedHashMap();
        String r104 = r100.a();
        if (r104 != null) goto L8;
        r104 = "";
    L8:
        if (r101 != null) goto L10;
    L13:
        boolean r105 = true;
    L15:
        if (r105 == false) goto L17;
    L20:
        r103.put("Authorization", "Bearer ".concat(r104));
    L21:
        if (r102 == false) goto L23;
        r103.put("OfficeSDK", r104);
    L23:
        return r103;
    L17:
        if (Intrinsics.areEqual(r100.c(), "Bearer") == true) goto L20;
        r103.put("DPoP", r101);
        r103.put("Authorization", "DPoP ".concat(r104));
        goto L21
    L10:
        if (r101.length() == 0) goto L13;
        r105 = false;
        goto L15
    L4:
        return MapsKt.emptyMap();
    }
}
