package com.xiaomi.push;

import android.text.TextUtils;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

/* JADX INFO: loaded from: classes41.dex */
public class ba {
    public static String a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L9;
        return "";
    L9:
        MessageDigest r101 = MessageDigest.getInstance("MD5");     // Catch: NoSuchAlgorithmException -> L8
        r101.update(m8846a(r100));     // Catch: NoSuchAlgorithmException -> L8
        return String.format("%1$032X", new Object[]{new BigInteger(1, r101.digest())});
    L11:
        return r100;
    }

    public static String b(String r100) {
        if (r100 != null) goto L8;
        return null;
    L8:
        MessageDigest r101 = MessageDigest.getInstance("SHA1");     // Catch: NoSuchAlgorithmException -> L7
        r101.update(m8846a(r100));     // Catch: NoSuchAlgorithmException -> L7
        return String.format("%1$032X", new Object[]{new BigInteger(1, r101.digest())});
    L10:
        return r100;
    }

    public static String a(byte[] r100) {
        MessageDigest r101 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L4
        r101.update(r100);     // Catch: Exception -> L4
        String r102 = String.format("%1$032X", new Object[]{new BigInteger(1, r101.digest())});     // Catch: Exception -> L4
    L6:
        return r102.toLowerCase();
    L4:
        r102 = "";
        goto L6
    }

    public static String b(byte[] r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.length <= 0) goto L13;
        return new String(r100, "UTF-8");
    L8:
        return new String(r100);
    L13:
        return null;
    }

    public static String a(int r100) {
        Random r101 = new Random();
        StringBuffer r102 = new StringBuffer();
        int r103 = 0;
    L3:
        if (r103 >= r100) goto L6;
        r102.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".charAt(r101.nextInt(62)));
        r103 = r103 + 1;
        goto L3
    L6:
        return r102.toString();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m8845a(String r100) {
        if (r100 == null) goto L13;
        int r101 = 0;
    L5:
        if (r101 >= r100.length()) goto L18;
        char r102 = r100.charAt(r101);
        if (r102 < 0) goto L12;
        if (r102 > 127) goto L12;
        r101 = r101 + 1;
    L12:
        return false;
    L18:
        return true;
    L13:
        return true;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static byte[] m8846a(String r100) {
        return r100.getBytes("UTF-8");
    L5:
        return r100.getBytes();
    }

    public static String a(Iterator<?> r100, String r101) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r100.hasNext() == true) goto L9;
        return "";
    L9:
        Object r102 = r100.next();
        if (r100.hasNext() == false) goto L12;
        StringBuffer r103 = new StringBuffer(256);
        if (r102 == null) goto L17;
        r103.append(r102);
    L17:
        if (r100.hasNext() == false) goto L24;
        if (r101 == null) goto L20;
        r103.append(r101);
    L20:
        Object r104 = r100.next();
        if (r104 == null) goto L17;
        r103.append(r104);
        goto L17
    L24:
        return r103.toString();
    L12:
        return r102.toString();
    }

    public static String a(String r100, int r101) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return "";
    L6:
        StringBuilder r102 = new StringBuilder();
        int r103 = r100.length();
        if (r101 <= 0) goto L9;
        if (r103 < r101) goto L9;
    L16:
        int r104 = 0;
    L17:
        if (r104 >= r103) goto L24;
        int r105 = r104 + 1;
        if ((r105 % r101) != 0) goto L21;
        r102.append("*");
    L22:
        r104 = r105;
        goto L17
    L21:
        r102.append(r100.charAt(r104));
        goto L22
    L24:
        return r102.toString();
    L9:
        r101 = r103 / 3;
        if (r101 > 1) goto L14;
        r101 = 1;
    L14:
        if (r101 <= 3) goto L16;
        r101 = 3;
        goto L16
    }

    public static String a(Collection<?> r100, String r101) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return a(r100.iterator(), r101);
    }

    public static String a(Object[] r100, String r101) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return a(r100, r101, 0, r100.length);
    }

    public static String a(Object[] r100, String r101, int r102, int r103) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        int r104 = r103 - r102;
        if (r104 > 0) goto L11;
        return "";
    L11:
        Object r105 = r100[r102];
        if (r105 != null) goto L14;
        int r106 = 16;
    L15:
        StringBuffer r107 = new StringBuffer(r104 * (r106 + r101.length()));
        int r108 = r102;
    L16:
        if (r108 >= r103) goto L24;
        if (r108 <= r102) goto L19;
        r107.append(r101);
    L19:
        Object r109 = r100[r108];
        if (r109 == null) goto L22;
        r107.append(r109);
    L22:
        r108 = r108 + 1;
        goto L16
    L24:
        return r107.toString();
    L14:
        r106 = r105.toString().length();
        goto L15
    }
}
