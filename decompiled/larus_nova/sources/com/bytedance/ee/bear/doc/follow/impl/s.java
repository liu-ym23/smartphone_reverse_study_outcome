package com.bytedance.ee.bear.doc.follow.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

/* JADX INFO: loaded from: classes16.dex */
public final class s {
    public static String[] a(String r100) {
        JSONArray r101 = JSON.parseArray(r100);
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        String[] r103 = new String[r102];
        int r104 = 0;
    L7:
        if (r104 >= r102) goto L12;
        r103[r104] = JSON.toJSONString(r101.get(r104));     // Catch: Exception -> L10
        r104 = r104 + 1;
    L10:
        e = move-exception;
        tt5.a.e("CCMFollow_DataUtils", "objArray2StringArray", e, false);
    L12:
        return r103;
    L5:
        r102 = r101.size();
        goto L6
    }
}
