package org.bouncycastle.crypto.digests;

/* JADX INFO: loaded from: classes42.dex */
public class XofUtils {
    public XofUtils() {
    }

    public static byte[] leftEncode(long r100) {
        int r101 = 1;
        byte r102 = 1;
        long r103 = r100;
    L3:
        r103 = r103 >> 8;
        if (r103 == 0) goto L6;
        r102 = (byte) (r102 + 1);
        goto L3
    L6:
        byte[] r104 = new byte[r102 + 1];
        r104[0] = r102;
    L7:
        if (r101 > r102) goto L9;
        r104[r101] = (byte) (r100 >> ((r102 - r101) * 8));
        r101 = r101 + 1;
        goto L7
    L9:
        return r104;
    }

    public static byte[] rightEncode(long r100) {
        byte r101 = 1;
        long r102 = r100;
    L3:
        r102 = r102 >> 8;
        if (r102 == 0) goto L6;
        r101 = (byte) (r101 + 1);
        goto L3
    L6:
        byte[] r103 = new byte[r101 + 1];
        r103[r101] = r101;
        int r104 = 0;
    L7:
        if (r104 >= r101) goto L9;
        r103[r104] = (byte) (r100 >> (((r101 - r104) - 1) * 8));
        r104 = r104 + 1;
        goto L7
    L9:
        return r103;
    }
}
