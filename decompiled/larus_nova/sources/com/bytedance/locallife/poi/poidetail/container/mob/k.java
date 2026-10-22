package com.bytedance.locallife.poi.poidetail.container.mob;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class k {
    public static final void a(mq6.c r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        if (com.bytedance.locallife.common.utils.j.a(r102) == true) goto L6;
        r100 = null;
    L6:
        if (r100 == null) goto L9;
        r100.d(r101, r102);
        return;
    }
}
