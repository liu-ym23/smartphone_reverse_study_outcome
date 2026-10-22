package com.larksuite.framework.utils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.UByte;

/* JADX INFO: loaded from: classes24.dex */
public final class s {
    public static String a(byte[] r100) {
        StringBuffer r101 = new StringBuffer();
        MessageDigest r102 = MessageDigest.getInstance("MD5");     // Catch: NoSuchAlgorithmException -> L11
        r102.reset();     // Catch: NoSuchAlgorithmException -> L11
        r102.update(r100);     // Catch: NoSuchAlgorithmException -> L11
        byte[] r103 = r102.digest();     // Catch: NoSuchAlgorithmException -> L11
        int r104 = 0;
    L4:
        if (r104 >= r103.length) goto L14;
        if (Integer.toHexString(r103[r104] & UByte.MAX_VALUE).length() != 1) goto L9;
        r101.append("0");     // Catch: NoSuchAlgorithmException -> L11
        r101.append(Integer.toHexString(r103[r104] & UByte.MAX_VALUE));     // Catch: NoSuchAlgorithmException -> L11
    L10:
        r104 = r104 + 1;
        goto L4
    L9:
        r101.append(Integer.toHexString(r103[r104] & UByte.MAX_VALUE));     // Catch: NoSuchAlgorithmException -> L11
    L14:
        return r101.toString();
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }

    public static String b(String r100) {
        if (r100 != null) goto L11;
    L9:
        return null;
    L11:
        if (r100.length() == 0) goto L9;
        MessageDigest r101 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L10
        r101.update(r100.getBytes("UTF-8"));     // Catch: Exception -> L10
        return a(r101.digest());
    }

    public static String c(String r100) {
        MessageDigest r101 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L8
        r101.update(r100.getBytes(StandardCharsets.UTF_8));     // Catch: Exception -> L8
        String r102 = new BigInteger(1, r101.digest()).toString(16);     // Catch: Exception -> L8
    L4:
        if (r102.length() >= 32) goto L7;
        r102 = "0" + r102;     // Catch: Exception -> L8
        goto L4
    L7:
        return r102;
    L8:
        return r100;
    }
}
