package com.unionpay.utils;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes41.dex */
public final class g {
    public g() {
    }

    public static Object a(JSONArray r100, int r101) {
        if (r100 != null) goto L4;
    L10:
        return null;
    L4:
        if (r101 >= r100.length()) goto L10;
        if (r101 < 0) goto L10;
        return r100.get(r101);
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    public static String b(JSONObject r100, String r101) {
        if (r100.has(r101) == true) goto L9;
    L7:
        return "";
    L9:
        return JSONObjectProtectorUtils.getString(r100, r101);
    L6:
        g.class.toString();
        goto L7
    }
}
