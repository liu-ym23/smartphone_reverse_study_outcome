package com.bytedance.android.shopping.api.mall.common.tools;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class p {
    public static Gson a;

    public static Gson b() {
        if (a != null) goto L5;
        a = new GsonBuilder().create();
    L5:
        Gson r0 = a;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    static {
    }

    public static String c(Object r1) {
        return GsonProtectorUtils.toJson(b(), r1);
    }

    public static Object a(String r1, Class r2) {
        Intrinsics.checkNotNullParameter(r2, "objectClass");
        return GsonProtectorUtils.fromJson(b(), r1, r2);
    }
}
