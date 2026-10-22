package com.xiaomi.push;

import android.text.TextUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes41.dex */
public class az {
    public static String a(String r100) {
        MessageDigest r101 = MessageDigest.getInstance("MD5");     // Catch: NoSuchAlgorithmException -> L9
        StringBuffer r102 = new StringBuffer();
        int r103 = 0;
        r101.update(r100.getBytes(), 0, r100.length());
        byte[] r104 = r101.digest();
    L5:
        if (r103 >= r104.length) goto L8;
        r102.append(a(r104[r103]));
        r103 = r103 + 1;
        goto L5
    L8:
        return r102.toString();
    L9:
        return null;
    }

    public static String b(String r100) {
        return a(r100).subSequence(8, 24).toString();
    }

    private static String a(byte r100) {
        int r101 = r100 & ByteCompanionObject.MAX_VALUE;
        if (r100 >= 0) goto L5;
        int r102 = 128;
    L6:
        int r103 = r101 + r102;
        StringBuilder r104 = new StringBuilder();
        if (r103 >= 16) goto L9;
        String r105 = "0";
    L10:
        r104.append(r105);
        r104.append(Integer.toHexString(r103).toLowerCase());
        return r104.toString();
    L9:
        r105 = "";
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static byte[] m8830a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L9;
        return null;
    L9:
        MessageDigest r101 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L8
        r101.update(r100.getBytes());     // Catch: Exception -> L8
        return r101.digest();
    L11:
        return null;
    }
}
