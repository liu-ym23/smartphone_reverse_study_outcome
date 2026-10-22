package org.bouncycastle.pqc.crypto.qtesla;

/* JADX INFO: loaded from: classes42.dex */
public class QTESLASecurityCategory {
    public static final int PROVABLY_SECURE_I = 5;
    public static final int PROVABLY_SECURE_III = 6;

    private QTESLASecurityCategory() {
    }

    public static String getName(int r100) {
        if (r100 != 5) goto L5;
        return "qTESLA-p-I";
    L5:
        if (r100 != 6) goto L9;
        return "qTESLA-p-III";
    L9:
        throw new IllegalArgumentException("unknown security category: " + r100);
    }

    public static int getPrivateSize(int r100) {
        if (r100 != 5) goto L5;
        return 5224;
    L5:
        if (r100 != 6) goto L9;
        return 12392;
    L9:
        throw new IllegalArgumentException("unknown security category: " + r100);
    }

    public static int getPublicSize(int r100) {
        if (r100 != 5) goto L5;
        return 14880;
    L5:
        if (r100 != 6) goto L9;
        return 38432;
    L9:
        throw new IllegalArgumentException("unknown security category: " + r100);
    }

    public static int getSignatureSize(int r100) {
        if (r100 != 5) goto L5;
        return 2592;
    L5:
        if (r100 != 6) goto L9;
        return 5664;
    L9:
        throw new IllegalArgumentException("unknown security category: " + r100);
    }

    public static void validate(int r100) {
        if (r100 != 5) goto L5;
        return;
    L5:
        if (r100 != 6) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("unknown security category: " + r100);
    }
}
