package org.bouncycastle.pqc.math.linearalgebra;

/* JADX INFO: loaded from: classes42.dex */
public final class CharUtils {
    private CharUtils() {
    }

    public static char[] clone(char[] r100) {
        char[] r101 = new char[r100.length];
        System.arraycopy(r100, 0, r101, 0, r100.length);
        return r101;
    }

    public static boolean equals(char[] r100, char[] r101) {
        if (r100.length == r101.length) goto L5;
        return false;
    L5:
        int r102 = r100.length - 1;
        boolean r103 = true;
    L6:
        if (r102 < 0) goto L12;
        if (r100[r102] != r101[r102]) goto L10;
        boolean r104 = true;
    L11:
        r103 = r103 & r104;
        r102 = r102 - 1;
        goto L6
    L10:
        r104 = false;
        goto L11
    L12:
        return r103;
    }

    public static byte[] toByteArray(char[] r100) {
        byte[] r101 = new byte[r100.length];
        int r102 = r100.length - 1;
    L3:
        if (r102 < 0) goto L5;
        r101[r102] = (byte) r100[r102];
        r102 = r102 - 1;
        goto L3
    L5:
        return r101;
    }

    public static byte[] toByteArrayForPBE(char[] r100) {
        int r101 = r100.length;
        byte[] r102 = new byte[r101];
        int r103 = 0;
    L4:
        if (r103 >= r100.length) goto L6;
        r102[r103] = (byte) r100[r103];
        r103 = r103 + 1;
        goto L4
    L6:
        int r104 = r101 * 2;
        byte[] r105 = new byte[r104 + 2];
        int r106 = 0;
    L7:
        if (r106 >= r101) goto L9;
        int r107 = r106 * 2;
        r105[r107] = 0;
        r105[r107 + 1] = r102[r106];
        r106 = r106 + 1;
        goto L7
    L9:
        r105[r104] = 0;
        r105[r104 + 1] = 0;
        return r105;
    }
}
