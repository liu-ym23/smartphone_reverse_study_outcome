package org.bouncycastle.crypto.modes;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
class GOST3413CipherUtil {
    public GOST3413CipherUtil() {
    }

    public static byte[] LSB(byte[] r100, int r101) {
        byte[] r102 = new byte[r101];
        System.arraycopy(r100, r100.length - r101, r102, 0, r101);
        return r102;
    }

    public static byte[] MSB(byte[] r100, int r101) {
        return Arrays.copyOf(r100, r101);
    }

    public static byte[] copyFromInput(byte[] r100, int r101, int r102) {
        if (r100.length >= (r101 + r102)) goto L5;
        r101 = r100.length - r102;
    L5:
        byte[] r103 = new byte[r101];
        System.arraycopy(r100, r102, r103, 0, r101);
        return r103;
    }

    public static byte[] sum(byte[] r100, byte[] r101) {
        byte[] r102 = new byte[r100.length];
        int r103 = 0;
    L4:
        if (r103 >= r100.length) goto L6;
        r102[r103] = (byte) (r100[r103] ^ r101[r103]);
        r103 = r103 + 1;
        goto L4
    L6:
        return r102;
    }
}
