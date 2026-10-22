package com.bytedance.android.shopping.mall.homepage.tools;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a0 {
    public final Map<String, Object> a;

    public a0(Map<String, ? extends Object> r1) {
        this.a = r1;
    }

    public final String a(Map<String, String> r4, boolean r5, int r6, Map<String, ? extends Object> r7, Function0<String> r8) {
        Intrinsics.checkNotNullParameter(r4, "schemaMap");
        Intrinsics.checkNotNullParameter(r8, "onFailure");
        if (r7 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        Map<String, Object> r9 = this.a;
    L15:
        String r1 = "";
        if (r5 == true) goto L18;
    L26:
        if (r5 == true) goto L38;
        if (r4.containsKey("video_click") == false) goto L38;
        int r2 = com.bytedance.forest.utils.h.a;
        if (com.bytedance.forest.utils.h.a(r4.get("video_click")) == false) goto L38;
        String r10 = r4.get("video_click");
        if (r10 == null) goto L36;
        r1 = r10;
    L36:
        return new b0(r1, new z(r6, r9)).a();
    L38:
        return (String) r8.invoke();
    L18:
        if (r4.containsKey("product_click") == false) goto L26;
        int r3 = com.bytedance.forest.utils.h.a;
        if (com.bytedance.forest.utils.h.a(r4.get("product_click")) == false) goto L26;
        String r11 = r4.get("product_click");
        if (r11 == null) goto L39;
        r1 = r11;
    L39:
        return new b0(r1, new z(r6, r9)).a();
    L11:
        LinkedHashMap r12 = new LinkedHashMap();
        Map<String, Object> r13 = this.a;
        if (r13 == null) goto L14;
        r12.putAll(r13);
    L14:
        r12.putAll(r7);
        r9 = r12;
        goto L15
    L5:
        if (r7.isEmpty() == true) goto L8;
        r0 = false;
        goto L9
    }
}
