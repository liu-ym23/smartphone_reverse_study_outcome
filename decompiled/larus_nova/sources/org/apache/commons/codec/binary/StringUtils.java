package org.apache.commons.codec.binary;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes42.dex */
public class StringUtils {
    public static byte[] getBytesUtf8(String r100) {
        return getBytes(r100, StandardCharsets.UTF_8);
    }

    public static String newStringUtf8(byte[] r100) {
        return newString(r100, StandardCharsets.UTF_8);
    }

    private static byte[] getBytes(String r100, Charset r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getBytes(r101);
    }

    private static String newString(byte[] r100, Charset r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        return new String(r100, r101);
    }
}
