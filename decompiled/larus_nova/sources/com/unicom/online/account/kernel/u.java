package com.unicom.online.account.kernel;

import kotlin.UByte;

/* JADX INFO: loaded from: classes41.dex */
public final class u {
    public static String a(byte[] r100) {
        StringBuilder r101 = new StringBuilder();
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        String r104 = Integer.toHexString(r100[r103] & UByte.MAX_VALUE);
        if (r104.length() != 1) goto L7;
        r104 = "0".concat(r104);
    L7:
        r101.append(r104);
        r103 = r103 + 1;
        goto L3
    L9:
        return r101.toString();
    }
}
