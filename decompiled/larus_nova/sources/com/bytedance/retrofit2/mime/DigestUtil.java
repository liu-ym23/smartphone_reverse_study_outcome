package com.bytedance.retrofit2.mime;

import java.io.InputStream;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes3.dex */
public class DigestUtil {
    private static final char[] DIGITS_UPPER = null;
    private static final int STREAM_BUFFER_LENGTH = 1024;

    public DigestUtil() {
    }

    static {
        DIGITS_UPPER = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    private static char[] encodeHex(byte[] r100) {
        int r101 = r100.length;
        char[] r102 = new char[r101 << 1];
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r103 >= r101) goto L5;
        int r105 = r104 + 1;
        char[] r106 = DIGITS_UPPER;
        byte r107 = r100[r103];
        r102[r104] = r106[(r107 & 240) >>> 4];
        r104 = r105 + 1;
        r102[r105] = r106[r107 & 15];
        r103 = r103 + 1;
        goto L3
    L5:
        return r102;
    }

    public static String md5Hex(InputStream r100) {
        MessageDigest r101 = MessageDigest.getInstance("MD5");     // Catch: Throwable -> L8
        byte[] r102 = new byte[1024];     // Catch: Throwable -> L8
        int r103 = r100.read(r102, 0, 1024);     // Catch: Throwable -> L8
    L4:
        if (r103 <= (-1)) goto L6;
        r101.update(r102, 0, r103);     // Catch: Throwable -> L8
        r103 = r100.read(r102, 0, 1024);     // Catch: Throwable -> L8
        goto L4
    L6:
        return new String(encodeHex(r101.digest()));
    L8:
        return null;
    }

    public static String md5Hex(byte[] r100) {
        return new String(encodeHex(MessageDigest.getInstance("MD5").digest(r100)));
    L4:
        return null;
    }
}
