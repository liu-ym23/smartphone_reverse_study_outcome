package com.bytedance.android.shopping.anchorv4.voavhs.head.gallery;

import com.bytedance.android.shopping.anchorv4.voavhs.head.base.HeadViewType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g {
    public static int a;
    public static final Map<String, String> b = null;

    static {
        a = 100;
        b = new LinkedHashMap();
    }

    public static int a(String r2, String r3) {
        HeadViewType r0 = HeadViewType.PICTURE;
        if (Intrinsics.areEqual(r2, r0.getType()) == false) goto L8;
        if (com.bytedance.android.shopping.extensions.k.c(r3) == false) goto L8;
        return 5;
    L8:
        if (Intrinsics.areEqual(r2, r0.getType()) == false) goto L11;
        return 0;
    L11:
        if (Intrinsics.areEqual(r2, HeadViewType.SKU.getType()) == false) goto L13;
        return 6;
    L13:
        int r4 = a;
        a = r4 + 1;
        return r4;
    }
}
