package org.apache.commons.compress.utils;

import java.io.DataInput;
import java.io.IOException;

/* JADX INFO: loaded from: classes42.dex */
public final class ByteUtils {
    private static final void checkReadLength(int r100) {
        if (r100 > 8) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("can't read more than eight bytes into a long value");
    }

    public static long fromLittleEndian(DataInput r100, int r101) throws IOException {
        checkReadLength(r101);
        long r102 = 0;
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L5;
        r102 = r102 | (((long) r100.readUnsignedByte()) << (r103 * 8));
        r103 = r103 + 1;
        goto L3
    L5:
        return r102;
    }

    public static long fromLittleEndian(byte[] r100, int r101, int r102) {
        checkReadLength(r102);
        long r103 = 0;
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L5;
        r103 = r103 | ((((long) r100[r101 + r104]) & 255) << (r104 * 8));
        r104 = r104 + 1;
        goto L3
    L5:
        return r103;
    }

    public static void toLittleEndian(byte[] r100, long r101, int r102, int r103) {
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        r100[r102 + r104] = (byte) (255 & r101);
        r101 = r101 >> 8;
        r104 = r104 + 1;
        goto L3
    }
}
