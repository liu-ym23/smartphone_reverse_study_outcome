package com.bytedance.android.shopping.store.router.hybridpage.view;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i {
    public static final Map<String, Boolean> a = null;

    static {
        a = new LinkedHashMap();
    }

    public static boolean a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "customElementName");
        Boolean r2 = (Boolean) ((LinkedHashMap) a).get(r1);
        if (r2 != null) goto L7;
        return false;
    L7:
        return r2.booleanValue();
    }

    public static void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "customElementName");
        a.put(r2, Boolean.TRUE);
    }
}
