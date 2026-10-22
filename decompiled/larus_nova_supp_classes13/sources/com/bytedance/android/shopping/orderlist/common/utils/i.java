package com.bytedance.android.shopping.orderlist.common.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i {
    public static Gson a;

    public static Gson a() {
        if (a != null) goto L5;
        a = new GsonBuilder().serializeNulls().create();
    L5:
        Gson r0 = a;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    static {
    }
}
