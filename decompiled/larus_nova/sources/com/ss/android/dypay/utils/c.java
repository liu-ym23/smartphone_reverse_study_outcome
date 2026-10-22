package com.ss.android.dypay.utils;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.TypeCastException;
import kotlin.UByte;
import kotlin.jvm.JvmStatic;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes34.dex */
public final class c {
    @JvmStatic
    public static final String a(String r100) {
        int r101 = 0;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L27;
        return "";
    L27:
        MessageDigest r103 = MessageDigest.getInstance("MD5");     // Catch: NoSuchAlgorithmException -> L24
        StringBuilder r104 = new StringBuilder();     // Catch: NoSuchAlgorithmException -> L24
        Charset r105 = Charsets.UTF_8;     // Catch: NoSuchAlgorithmException -> L24
        if (r100 == null) goto L23;
        byte[] r106 = r103.digest(r100.getBytes(r105));     // Catch: NoSuchAlgorithmException -> L24
        int r107 = r106.length;     // Catch: NoSuchAlgorithmException -> L24
    L15:
        if (r101 >= r107) goto L21;
        String r108 = Integer.toHexString(r106[r101] & UByte.MAX_VALUE);     // Catch: NoSuchAlgorithmException -> L24
        if (r108.length() != 1) goto L19;
        r108 = '0' + r108;     // Catch: NoSuchAlgorithmException -> L24
    L19:
        r104.append(r108);     // Catch: NoSuchAlgorithmException -> L24
        r101 = r101 + 1;     // Catch: NoSuchAlgorithmException -> L24
        goto L15
    L21:
        return r104.toString();
    L23:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");     // Catch: NoSuchAlgorithmException -> L24
    L24:
        e = move-exception;
        e.printStackTrace();
        return "";
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L10
    }
}
