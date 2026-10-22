package org.bouncycastle.pqc.crypto.gmss.util;

import kotlin.UByte;

/* JADX INFO: loaded from: classes42.dex */
public class GMSSUtil {
    public GMSSUtil() {
    }

    public int bytesToIntLittleEndian(byte[] r100) {
        int r101 = ((r100[0] & UByte.MAX_VALUE) | ((r100[1] & UByte.MAX_VALUE) << 8)) | ((r100[2] & UByte.MAX_VALUE) << 16);
        return ((r100[3] & UByte.MAX_VALUE) << 24) | r101;
    }

    public int bytesToIntLittleEndian(byte[] r100, int r101) {
        int r102 = r101 + 1;
        int r103 = r102 + 1;
        int r104 = (r100[r101] & UByte.MAX_VALUE) | ((r100[r102] & UByte.MAX_VALUE) << 8);
        int r105 = r103 + 1;
        int r106 = r104 | ((r100[r103] & UByte.MAX_VALUE) << 16);
        return ((r100[r105] & UByte.MAX_VALUE) << 24) | r106;
    }

    public byte[] concatenateArray(byte[][] r100) {
        byte[] r101 = new byte[r100.length * r100[0].length];
        int r102 = 0;
        int r103 = 0;
    L4:
        if (r102 >= r100.length) goto L6;
        byte[] r104 = r100[r102];
        System.arraycopy(r104, 0, r101, r103, r104.length);
        r103 = r103 + r100[r102].length;
        r102 = r102 + 1;
        goto L4
    L6:
        return r101;
    }

    public int getLog(int r100) {
        int r101 = 1;
        int r102 = 2;
    L3:
        if (r102 >= r100) goto L5;
        r102 = r102 << 1;
        r101 = r101 + 1;
        goto L3
    L5:
        return r101;
    }

    public byte[] intToBytesLittleEndian(int r100) {
        return new byte[]{(byte) (r100 & 255), (byte) ((r100 >> 8) & 255), (byte) ((r100 >> 16) & 255), (byte) ((r100 >> 24) & 255)};
    }

    public void printArray(String r100, byte[] r101) {
        System.out.println(r100);
        int r102 = 0;
        int r103 = 0;
    L4:
        if (r102 >= r101.length) goto L6;
        System.out.println(r103 + "; " + r101[r102]);
        r103 = r103 + 1;
        r102 = r102 + 1;
        goto L4
    }

    public void printArray(String r100, byte[][] r101) {
        System.out.println(r100);
        int r102 = 0;
        int r103 = 0;
    L4:
        if (r102 >= r101.length) goto L10;
        int r104 = 0;
    L7:
        if (r104 >= r101[0].length) goto L9;
        System.out.println(r103 + "; " + r101[r102][r104]);
        r103 = r103 + 1;
        r104 = r104 + 1;
        goto L7
    L9:
        r102 = r102 + 1;
        goto L4
    }

    public boolean testPowerOfTwo(int r100) {
        int r101 = 1;
    L3:
        if (r101 >= r100) goto L5;
        r101 = r101 << 1;
        goto L3
    L5:
        if (r100 != r101) goto L7;
        return true;
    L7:
        return false;
    }
}
