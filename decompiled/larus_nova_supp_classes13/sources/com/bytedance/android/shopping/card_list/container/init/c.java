package com.bytedance.android.shopping.card_list.container.init;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c {
    public static final Map<LauncherBizType, Function0<f>> a = null;
    public static final Map<LauncherBizType, f> b = null;

    static {
        a = new LinkedHashMap();
        b = new LinkedHashMap();
    }

    public static final f a(LauncherBizType r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Map<LauncherBizType, f> r0 = b;
        if (((LinkedHashMap) r0).get(r2) != null) goto L10;
        Function0 r1 = (Function0) ((LinkedHashMap) a).get(r2);
        if (r1 == null) goto L10;
        f r3 = (f) r1.invoke();
        if (r3 == null) goto L10;
        r0.put(r2, r3);
    L10:
        return (f) ((LinkedHashMap) r0).get(r2);
    }
}
