package com.facebook.imageformat;

import com.facebook.common.internal.Preconditions;

/* JADX INFO: loaded from: classes3.dex */
public class ImageFormatCheckerUtils {
    private ImageFormatCheckerUtils() {
    }

    public static byte[] asciiBytes(String r100) {
        Preconditions.checkNotNull(r100);
        return r100.getBytes("ASCII");
    L5:
        e = move-exception;
        throw new RuntimeException("ASCII not found!", e);
    }

    public static boolean startsWithPattern(byte[] r100, byte[] r101) {
        Preconditions.checkNotNull(r100);
        Preconditions.checkNotNull(r101);
        if (r101.length <= r100.length) goto L5;
        return false;
    L5:
        int r102 = 0;
    L7:
        if (r102 >= r101.length) goto L12;
        if (r100[r102] != r101[r102]) goto L10;
        r102 = r102 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }

    public static int indexOfPattern(byte[] r100, int r101, byte[] r110, int r111) {
        Preconditions.checkNotNull(r100);
        Preconditions.checkNotNull(r110);
        if (r111 <= r101) goto L5;
        return -1;
    L5:
        int r102 = 0;
        byte r103 = r110[0];
        int r104 = r101 - r111;
    L6:
        if (r102 > r104) goto L23;
        int r105 = 1;
        if (r100[r102] == r103) goto L14;
    L9:
        r102 = r102 + 1;
        if (r102 > r104) goto L14;
        if (r100[r102] != r103) goto L9;
    L14:
        if (r102 > r104) goto L22;
        int r106 = r102 + 1;
        int r107 = (r106 + r111) - 1;
    L16:
        if (r106 >= r107) goto L20;
        if (r100[r106] != r110[r105]) goto L20;
        r106 = r106 + 1;
        r105 = r105 + 1;
    L20:
        if (r106 != r107) goto L22;
        return r102;
    L22:
        r102 = r102 + 1;
        goto L6
    L23:
        return -1;
    }
}
