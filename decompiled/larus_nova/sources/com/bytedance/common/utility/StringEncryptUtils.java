package com.bytedance.common.utility;

import java.security.MessageDigest;

/* JADX INFO: loaded from: classes15.dex */
public final class StringEncryptUtils {
    public static String bytes2Hex(byte[] r100) {
        if (r100 != null) goto L11;
        return null;
    L11:
        StringBuilder r101 = new StringBuilder();     // Catch: Throwable -> L10
        int r102 = r100.length;     // Catch: Throwable -> L10
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L8;
        r101.append(String.format("%02x", new Object[]{Byte.valueOf(r100[r103])}));     // Catch: Throwable -> L10
        r103 = r103 + 1;     // Catch: Throwable -> L10
        goto L6
    L8:
        return r101.toString();
    L10:
        return null;
    }

    public static String encrypt(String r100, String r101) {
        byte[] r102 = r100.getBytes();
    L8:
        return null;
    L4:
        if (StringUtils.isEmpty(r101) == false) goto L6;
        r101 = "SHA-256";
    L6:
        MessageDigest r103 = MessageDigest.getInstance(r101);     // Catch: Throwable -> L8
        r103.update(r102);     // Catch: Throwable -> L8
        return bytes2Hex(r103.digest());
    }
}
