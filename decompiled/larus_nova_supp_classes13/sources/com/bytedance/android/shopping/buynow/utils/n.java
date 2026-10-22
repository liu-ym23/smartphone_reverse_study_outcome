package com.bytedance.android.shopping.buynow.utils;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import java.util.Map;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class n {
    public static final /* synthetic */ int a = 0;

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object, java.util.Map, java.util.Map<java.lang.String, ? extends java.lang.Object>] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v2 */
    @JvmStatic
    public static final Object a(Map<String, ? extends Object> r5, List<String> r6, int r7) {
        List<String> r0 = r6;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L12;
        return r5;
    L12:
        if (r7 < r6.size()) goto L14;
        return null;
    L14:
        String r3 = (String) ListProtector.get(r6, r7);
        if (r3.length() != 0) goto L17;
        r1 = true;
    L17:
        if (r1 == true) goto L23;
        if (r5 == 0) goto L21;
        r5 = r5.get(r3);
        goto L23
    L21:
        r5 = 0;
    L23:
        if (r7 == (r6.size() - 1)) goto L25;
        if (r5 != 0) goto L35;
        return null;
    L35:
        if ((r5 instanceof Map) == true) goto L37;
        return null;
    L37:
        return a((Map) r5, r6, r7 + 1);
    L25:
        if ((r5 instanceof Map) == true) goto L27;
        return r5;
    L27:
        if (((Map) r5).isEmpty() == false) goto L30;
        return null;
    L30:
        return r5;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r2 = false;
        goto L9
    }
}
