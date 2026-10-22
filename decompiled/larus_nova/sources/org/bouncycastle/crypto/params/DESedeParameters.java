package org.bouncycastle.crypto.params;

/* JADX INFO: loaded from: classes42.dex */
public class DESedeParameters extends DESParameters {
    public static final int DES_EDE_KEY_LENGTH = 24;

    public DESedeParameters(byte[] r100) {
        super(r100);
        if (isWeakKey(r100, 0, r100.length) == true) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("attempt to create weak DESede key");
    }

    public static boolean isReal2Key(byte[] r100, int r101) {
        boolean r102 = false;
        int r103 = r101;
    L4:
        if (r103 == (r101 + 8)) goto L9;
        if (r100[r103] == r100[r103 + 8]) goto L8;
        r102 = true;
    L8:
        r103 = r103 + 1;
        goto L4
    L9:
        return r102;
    }

    public static boolean isReal3Key(byte[] r100, int r110) {
        int r101 = r110;
        boolean r102 = false;
        boolean r103 = false;
        boolean r104 = false;
    L3:
        boolean r105 = true;
        if (r101 == (r110 + 8)) goto L18;
        byte r106 = r100[r101];
        byte r107 = r100[r101 + 8];
        if (r106 == r107) goto L8;
        boolean r108 = true;
    L9:
        r102 = r102 | r108;
        byte r109 = r100[r101 + 16];
        if (r106 == r109) goto L12;
        boolean r111 = true;
    L13:
        r103 = r103 | r111;
        if (r107 != r109) goto L17;
        r105 = false;
    L17:
        r104 = r104 | r105;
        r101 = r101 + 1;
        goto L3
    L12:
        r111 = false;
        goto L13
    L8:
        r108 = false;
        goto L9
    L18:
        if (r102 == false) goto L26;
        if (r103 == false) goto L27;
        if (r104 == false) goto L28;
        return true;
    L28:
        return false;
    L27:
        return false;
    L26:
        return false;
    }

    public static boolean isRealEDEKey(byte[] r100, int r101) {
        if (r100.length != 16) goto L6;
        return isReal2Key(r100, r101);
    L6:
        return isReal3Key(r100, r101);
    }

    public static boolean isWeakKey(byte[] r100, int r101) {
        return isWeakKey(r100, r101, r100.length - r101);
    }

    public static boolean isWeakKey(byte[] r100, int r101, int r102) {
    L2:
        if (r101 >= r102) goto L8;
        if (DESParameters.isWeakKey(r100, r101) == true) goto L5;
        r101 = r101 + 8;
        goto L2
    L5:
        return true;
    L8:
        return false;
    }
}
