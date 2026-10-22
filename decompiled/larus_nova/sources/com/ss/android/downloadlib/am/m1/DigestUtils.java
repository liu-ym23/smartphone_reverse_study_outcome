package com.ss.android.downloadlib.am.m1;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes34.dex */
public class DigestUtils {
    public static final String ALGORITHM_MD5 = "MD5";

    public DigestUtils() {
    }

    public static byte[] get(InputStream r100, String r101) throws Exception {
        MessageDigest r102 = MessageDigest.getInstance(r101);
        byte[] r103 = new byte[4096];
    L3:
        int r104 = r100.read(r103);
        if (r104 <= 0) goto L6;
        r102.update(r103, 0, r104);
        goto L3
    L6:
        return r102.digest();
    }

    public static byte[] get(CharSequence r100, String r101) throws Exception {
        return get(r100.toString().getBytes(), r101);
    }

    public static byte[] get(byte[] r100, String r101) throws Exception {
        return get(new ByteArrayInputStream(r100), r101);
    }
}
