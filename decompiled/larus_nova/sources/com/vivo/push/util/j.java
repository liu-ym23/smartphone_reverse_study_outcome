package com.vivo.push.util;

/* JADX INFO: loaded from: classes41.dex */
public final class j {
    public static String a(byte[] r100) {
        int r101 = r100.length;
        char[] r102 = new char[r101];
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L6;
        r102[r103] = (char) (r100[r103] ^ 16);
        r103 = r103 + 1;
        goto L3
    L6:
        return new String(r102);
    }
}
