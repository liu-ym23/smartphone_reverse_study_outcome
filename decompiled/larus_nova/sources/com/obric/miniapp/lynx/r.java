package com.obric.miniapp.lynx;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
public final class r {
    public static final String a(JSONObject r100, String... r101) {
        int r102 = r101.length;
        int r103 = 0;
    L3:
        String r104 = null;
        if (r103 >= r102) goto L11;
        String r105 = r100.optString(r101[r103]);
        Intrinsics.checkNotNull(r105);
        if ((!StringsKt.isBlank(r105)) == false) goto L8;
        r104 = r105;
    L8:
        if (r104 != null) goto L11;
        r103 = r103 + 1;
    L11:
        return r104;
    }
}
