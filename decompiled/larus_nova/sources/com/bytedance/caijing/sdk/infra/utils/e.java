package com.bytedance.caijing.sdk.infra.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.UByte;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    static {
    }

    @JvmStatic
    public static final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        int r101 = 0;
        if (r100.length() != 0) goto L5;
        boolean r102 = true;
    L7:
        if (r102 == false) goto L20;
        return "";
    L20:
        MessageDigest r103 = MessageDigest.getInstance("MD5");     // Catch: NoSuchAlgorithmException -> L17
        StringBuilder r104 = new StringBuilder();     // Catch: NoSuchAlgorithmException -> L17
        byte[] r105 = r103.digest(r100.getBytes(Charsets.UTF_8));     // Catch: NoSuchAlgorithmException -> L17
        int r106 = r105.length;     // Catch: NoSuchAlgorithmException -> L17
    L10:
        if (r101 >= r106) goto L15;
        String r107 = Integer.toHexString(r105[r101] & UByte.MAX_VALUE);     // Catch: NoSuchAlgorithmException -> L17
        if (r107.length() != 1) goto L14;
        r107 = '0' + r107;     // Catch: NoSuchAlgorithmException -> L17
    L14:
        r104.append(r107);     // Catch: NoSuchAlgorithmException -> L17
        r101 = r101 + 1;     // Catch: NoSuchAlgorithmException -> L17
        goto L10
    L15:
        return r104.toString();
    L17:
        e = move-exception;
        e.printStackTrace();
        return "";
    L5:
        r102 = false;
        goto L7
    }
}
