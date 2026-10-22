package com.bytedance.awemeopen.apps.framework.landscape.ui;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k {
    public static final String a(Long r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "placeholder");
        if (r5 != null) goto L5;
    L9:
        return r6;
    L5:
        if (r5.longValue() <= 0) goto L9;
        int r7 = com.bytedance.awemeopen.infra.util.k.a;
        return com.bytedance.awemeopen.infra.util.k.b(r5.longValue());
    }

    public static final Long b(Long r2, boolean r3, boolean r4) {
        if (r2 == null) goto L8;
        if (r3 == false) goto L8;
        if (r4 == true) goto L8;
        return Long.valueOf(r2.longValue() - 1);
    L8:
        if (r3 == true) goto L15;
        if (r4 == false) goto L16;
        if (r2 != null) goto L14;
        return 1L;
    L14:
        return Long.valueOf(r2.longValue() + 1);
    L16:
        return r2;
    L15:
        return r2;
    }
}
