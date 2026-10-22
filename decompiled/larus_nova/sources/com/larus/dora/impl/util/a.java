package com.larus.dora.impl.util;

import java.security.MessageDigest;
import kotlin.UByte;

/* JADX INFO: loaded from: classes27.dex */
public final class a {
    public static String a(byte[] r100) {
        MessageDigest r101 = MessageDigest.getInstance("SHA-256");     // Catch: Exception -> L11
        r101.update(r100);     // Catch: Exception -> L11
        byte[] r102 = r101.digest();     // Catch: Exception -> L11
        StringBuilder r103 = new StringBuilder();     // Catch: Exception -> L11
        int r104 = r102.length;     // Catch: Exception -> L11
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L9;
        String r106 = Integer.toHexString(r102[r105] & UByte.MAX_VALUE);     // Catch: Exception -> L11
    L6:
        if (r106.length() >= 2) goto L8;
        r106 = "0" + r106;     // Catch: Exception -> L11
        goto L6
    L8:
        r103.append(r106);     // Catch: Exception -> L11
        r105 = r105 + 1;     // Catch: Exception -> L11
        goto L3
    L9:
        return r103.toString();
    L11:
        e = move-exception;
        e.printStackTrace();
        return "";
    }
}
