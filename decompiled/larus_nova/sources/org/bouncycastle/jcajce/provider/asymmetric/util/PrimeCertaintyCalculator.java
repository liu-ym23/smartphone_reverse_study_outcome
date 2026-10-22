package org.bouncycastle.jcajce.provider.asymmetric.util;

/* JADX INFO: loaded from: classes42.dex */
public class PrimeCertaintyCalculator {
    private PrimeCertaintyCalculator() {
    }

    public static int getDefaultCertainty(int r100) {
        if (r100 > 1024) goto L6;
        return 80;
    L6:
        return (((r100 - 1) / 1024) * 16) + 96;
    }
}
