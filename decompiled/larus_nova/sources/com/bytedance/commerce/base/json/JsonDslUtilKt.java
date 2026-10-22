package com.bytedance.commerce.base.json;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class JsonDslUtilKt {
    public static final JSONObject a(a... r100) {
        JSONObject r101 = new JSONObject();
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r100[r103].f202802a.invoke(r101);
        r103 = r103 + 1;
        goto L3
    L5:
        return r101;
    }

    public static final a b(final long r100) {
        final String r101 = com.bytedance.android.ec.core.event.a.KEY_SORD_TYPE;
        return new a(new JsonDslUtilKt$objto$4(r101, r100));
    }

    public static final a c(final String r100, final int r101) {
        return new a(new JsonDslUtilKt$objto$1(r100, r101));
    }

    public static final a d(final String r100, final String r101) {
        return new a(new JsonDslUtilKt$objto$3(r100, r101));
    }
}
