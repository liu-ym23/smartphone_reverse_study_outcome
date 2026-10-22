package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(String r7) {
        if (r7 == null) goto L6;
        List r8 = StringsKt.split$default(r7, new String[]{"·"}, false, 0, 6, null);
        if (r8 == null) goto L6;
        return (String) CollectionsKt.getOrNull(r8, 1);
    L6:
        return null;
    }

    public static boolean b(int r1, c0 r2) {
        Intrinsics.checkNotNullParameter(r2, "tab");
        int r0 = r2.a;
        if (r0 <= r1) goto L5;
    L7:
        return false;
    L5:
        if (r1 >= (r0 + r2.b)) goto L7;
        return true;
    }
}
