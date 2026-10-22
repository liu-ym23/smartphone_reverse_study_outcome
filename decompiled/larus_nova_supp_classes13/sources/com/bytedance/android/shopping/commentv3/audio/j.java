package com.bytedance.android.shopping.commentv3.audio;

import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j {
    public static final Map<String, WeakReference<i>> a = null;

    static {
        a = new LinkedHashMap();
    }

    public static void a(String r2, i r3) {
        Intrinsics.checkNotNullParameter(r3, "provider");
        if (r2 != null) goto L5;
        return;
    L5:
        Map<String, WeakReference<i>> r0 = a;
        WeakReference r1 = (WeakReference) ((LinkedHashMap) r0).get(r2);
        if (r1 == null) goto L8;
        i r4 = (i) r1.get();
    L10:
        if (Intrinsics.areEqual(r4, r3) == false) goto L13;
        r0.remove(r2);
        return;
    L13:
        return;
    L8:
        r4 = null;
        goto L10
    }
}
