package com.bytedance.sdk.xbridge.cn.utils;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes22.dex */
public final class b {
    public static final <T> List<T> a(JSONArray r100, Function1<Object, ? extends T> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "cb");
        ArrayList r102 = new ArrayList();
        int r103 = r100.length();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        r102.add(r101.invoke(r100.opt(r104)));
        r104 = r104 + 1;
        goto L3
    L5:
        return r102;
    }
}
