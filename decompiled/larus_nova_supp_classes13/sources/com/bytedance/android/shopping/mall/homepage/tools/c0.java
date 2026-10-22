package com.bytedance.android.shopping.mall.homepage.tools;

import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c0 {
    public static Map<String, Object> a;

    static {
    }

    public static String a(Map r3, boolean r4, int r5, Function0 r6) {
        Intrinsics.checkNotNullParameter(r3, "schemaMap");
        Intrinsics.checkNotNullParameter(r6, "onFailure");
        String r0 = "";
        if (r4 == true) goto L5;
    L13:
        if (r4 == true) goto L25;
        if (r3.containsKey("video_click") == false) goto L25;
        if (com.bytedance.forest.utils.h.a("video_click") == false) goto L25;
        String r7 = (String) r3.get("video_click");
        if (r7 == null) goto L23;
        r0 = r7;
    L23:
        return new b0(r0, new z(r5, a)).a();
    L25:
        return (String) r6.invoke();
    L5:
        if (r3.containsKey("product_click") == false) goto L13;
        int r2 = com.bytedance.forest.utils.h.a;
        if (com.bytedance.forest.utils.h.a((String) r3.get("product_click")) == false) goto L13;
        String r8 = (String) r3.get("product_click");
        if (r8 == null) goto L26;
        r0 = r8;
    L26:
        return new b0(r0, new z(r5, a)).a();
    }
}
