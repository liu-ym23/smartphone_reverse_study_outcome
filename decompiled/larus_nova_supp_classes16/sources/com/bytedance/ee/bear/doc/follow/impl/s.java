package com.bytedance.ee.bear.doc.follow.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class s {
    public static String[] a(String r5) {
        JSONArray r6 = JSON.parseArray(r5);
        if (r6 != null) goto L5;
        int r1 = 0;
    L6:
        String[] r2 = new String[r1];
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L12;
        r2[r3] = JSON.toJSONString(r6.get(r3));     // Catch: Exception -> L10
        r3 = r3 + 1;
    L10:
        e = move-exception;
        tt5.a.e("CCMFollow_DataUtils", "objArray2StringArray", e, false);
    L12:
        return r2;
    L5:
        r1 = r6.size();
        goto L6
    }
}
