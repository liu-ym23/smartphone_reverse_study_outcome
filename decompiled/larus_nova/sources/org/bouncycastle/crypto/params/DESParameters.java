package org.bouncycastle.crypto.params;

/* JADX INFO: loaded from: classes42.dex */
public class DESParameters extends KeyParameter {
    public static final int DES_KEY_LENGTH = 8;
    private static byte[] DES_weak_keys = null;
    private static final int N_DES_WEAK_KEYS = 16;

    static {
        DES_weak_keys = new byte[]{1, 1, 1, 1, 1, 1, 1, 1, 31, 31, 31, 31, 14, 14, 14, 14, -32, -32, -32, -32, -15, -15, -15, -15, -2, -2, -2, -2, -2, -2, -2, -2, 1, -2, 1, -2, 1, -2, 1, -2, 31, -32, 31, -32, 14, -15, 14, -15, 1, -32, 1, -32, 1, -15, 1, -15, 31, -2, 31, -2, 14, -2, 14, -2, 1, 31, 1, 31, 1, 14, 1, 14, -32, -2, -32, -2, -15, -2, -15, -2, -2, 1, -2, 1, -2, 1, -2, 1, -32, 31, -32, 31, -15, 14, -15, 14, -32, 1, -32, 1, -15, 1, -15, 1, -2, 31, -2, 31, -2, 14, -2, 14, 31, 1, 31, 1, 14, 1, 14, 1, -2, -32, -2, -32, -2, -15, -2, -15};
    }

    public DESParameters(byte[] r100) {
        super(r100);
        if (isWeakKey(r100, 0) == true) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("attempt to create weak DES key");
    }

    public static boolean isWeakKey(byte[] r100, int r101) {
        if ((r100.length - r101) < 8) goto L17;
        int r102 = 0;
    L6:
        if (r102 >= 16) goto L15;
        int r103 = 0;
    L8:
        if (r103 >= 8) goto L13;
        if (r100[r103 + r101] != DES_weak_keys[(r102 * 8) + r103]) goto L11;
        r103 = r103 + 1;
        goto L8
    L11:
        r102 = r102 + 1;
        goto L6
    L13:
        return true;
    L15:
        return false;
    L17:
        throw new IllegalArgumentException("key material too short.");
    }

    public static void setOddParity(byte[] r100) {
        int r101 = 0;
    L4:
        if (r101 >= r100.length) goto L6;
        byte r102 = r100[r101];
        int r103 = r102 & 254;
        int r104 = (((((r102 >> 1) ^ (r102 >> 2)) ^ (r102 >> 3)) ^ (r102 >> 4)) ^ (r102 >> 5)) ^ (r102 >> 6);
        r100[r101] = (byte) (((((r102 >> 7) ^ r104) ^ 1) & 1) | r103);
        r101 = r101 + 1;
        goto L4
    }
}
