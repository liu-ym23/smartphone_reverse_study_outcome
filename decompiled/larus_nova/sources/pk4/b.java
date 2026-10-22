package pk4;

import kotlin.UByte;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static int a(byte[] r100) {
        int r101 = r100.length;
        int r102 = 65535;
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L12;
        r102 = r102 ^ (r100[r103] & UByte.MAX_VALUE);
        int r104 = 0;
    L6:
        if (r104 >= 8) goto L11;
        int r105 = r102 & 1;
        r102 = r102 >> 1;
        if (r105 != 1) goto L10;
        r102 = r102 ^ 40961;
    L10:
        r104 = r104 + 1;
        goto L6
    L11:
        r103 = r103 + 1;
        goto L3
    L12:
        return r102;
    }
}
