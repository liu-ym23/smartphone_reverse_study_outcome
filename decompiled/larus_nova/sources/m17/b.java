package m17;

import kotlin.UByte;

/* JADX INFO: loaded from: classes21.dex */
public final class b {
    public static int a(String r100, int r101) {
        byte[] r102 = r100.getBytes();
        int r103 = r102.length;
        int r104 = r101 ^ r103;
        int r105 = r103 / 4;
        int r106 = 0;
    L4:
        if (r106 >= r105) goto L6;
        int r107 = r106 * 4;
        int r108 = ((((r102[r107 + 0] & UByte.MAX_VALUE) + ((r102[r107 + 1] & UByte.MAX_VALUE) << 8)) + ((r102[r107 + 2] & UByte.MAX_VALUE) << 16)) + ((r102[r107 + 3] & UByte.MAX_VALUE) << 24)) * 1540483477;
        int r109 = r104 * 1540483477;
        r104 = r109 ^ (((r108 >>> 24) ^ r108) * 1540483477);
        r106 = r106 + 1;
        goto L4
    L6:
        int r110 = r103 % 4;
        if (r110 != 1) goto L9;
    L14:
        r104 = ((r102[r103 & (-4)] & UByte.MAX_VALUE) ^ r104) * 1540483477;
    L15:
        int r111 = ((r104 >>> 13) ^ r104) * 1540483477;
        return r111 ^ (r111 >>> 15);
    L9:
        if (r110 == 2) goto L13;
        if (r110 != 3) goto L15;
        r104 = r104 ^ ((r102[(r103 & (-4)) + 2] & UByte.MAX_VALUE) << 16);
    L13:
        r104 = r104 ^ ((r102[(r103 & (-4)) + 1] & UByte.MAX_VALUE) << 8);
        goto L14
    }
}
