package com.relax.relaxreact;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class y {
    public static final Object a(Object r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r100 != null) goto L6;
        return null;
    L6:
        if (TypeIntrinsics.isMutableMap(r100) == false) goto L8;
        Map r102 = (Map) r100;
    L9:
        if (r102 == null) goto L13;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        return r102.get(r101);
    L13:
        if (TypeIntrinsics.isMutableMap(r100) == false) goto L15;
        Map r103 = (Map) r100;
    L16:
        if (r103 == null) goto L19;
        int r104 = com.bytedance.rts.kmp.foundation.g.f267611a;
        return com.bytedance.rts.kmp.foundation.g.a.a(r103, r101);
    L19:
        return null;
    L15:
        r103 = null;
        goto L16
    L8:
        r102 = null;
        goto L9
    }
}
