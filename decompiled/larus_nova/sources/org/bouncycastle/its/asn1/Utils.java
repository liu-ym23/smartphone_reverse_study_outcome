package org.bouncycastle.its.asn1;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
class Utils {
    public Utils() {
    }

    public static byte[] octetStringFixed(byte[] r100) {
        if (r100.length < 1) goto L9;
        if (r100.length > 32) goto L9;
        return Arrays.clone(r100);
    L9:
        throw new IllegalArgumentException("octet string out of range");
    }

    public static byte[] octetStringFixed(byte[] r100, int r101) {
        if (r100.length != r101) goto L6;
        return r100;
    L6:
        throw new IllegalArgumentException("octet string out of range");
    }
}
