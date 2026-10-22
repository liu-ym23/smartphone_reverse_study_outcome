package com.bytedance.crash.dumper;

import com.larus.dora.impl.ota.g2.j0;

/* JADX INFO: loaded from: classes3.dex */
public final class p {
    public static String a(long r100) {
        if (r100 > 52428800) goto L6;
        return "0 - 50M";
    L6:
        if (r100 > j0.G2_OTA_SPACE_CHECK_BYTES) goto L9;
        return "50M - 100M";
    L9:
        if (r100 > 1073741824) goto L11;
        return "100M - 1G";
    L11:
        return "1G - ";
    }
}
