package com.larus.dora.impl.device.scan;

import com.bytedance.dora.device.DoraDevice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class k {
    public static final j a(DoraDevice r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r102 = r100.f204389mac;
        if (r102 != null) goto L5;
        String r103 = "";
    L6:
        String r104 = r100.name;
        if (r104 != null) goto L9;
        String r105 = "";
    L10:
        String r106 = r100.f204390sn;
        if (r106 != null) goto L13;
        String r107 = "";
    L14:
        String r108 = r103;
        String r109 = r105;
        String r110 = r107;
        return new j(r108, r109, r110, r100.sku, r101, r100.type);
    L13:
        r107 = r106;
        goto L14
    L9:
        r105 = r104;
        goto L10
    L5:
        r103 = r102;
        goto L6
    }
}
