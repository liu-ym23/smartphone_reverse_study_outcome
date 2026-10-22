package org.apache.commons.compress.utils;

import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes42.dex */
public class ArchiveUtils {
    public static boolean isArrayZero(byte[] r100, int r101) {
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L8;
        if (r100[r102] != 0) goto L6;
        r102 = r102 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    public static boolean matchAsciiBuffer(String r100, byte[] r101, int r110, int r111) {
        byte[] r102 = r100.getBytes("US-ASCII");     // Catch: UnsupportedEncodingException -> L5
        return isEqual(r102, 0, r102.length, r101, r110, r111, false);
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static boolean isEqual(byte[] r100, int r101, int r102, byte[] r103, int r104, int r110, boolean r111) {
        if (r102 >= r110) goto L4;
        int r105 = r102;
    L5:
        int r106 = 0;
    L6:
        if (r106 >= r105) goto L12;
        if (r100[r101 + r106] != r103[r104 + r106]) goto L9;
        r106 = r106 + 1;
        goto L6
    L9:
        return false;
    L12:
        if (r102 != r110) goto L14;
        return true;
    L14:
        if (r111 == false) goto L27;
        if (r102 <= r110) goto L21;
    L16:
        if (r110 >= r102) goto L26;
        if (r100[r101 + r110] != 0) goto L19;
        r110 = r110 + 1;
        goto L16
    L19:
        return false;
    L26:
        return true;
    L21:
        if (r102 >= r110) goto L26;
        if (r103[r104 + r102] != 0) goto L24;
        r102 = r102 + 1;
        goto L21
    L24:
        return false;
    L27:
        return false;
    L4:
        r105 = r110;
        goto L5
    }
}
