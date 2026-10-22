package com.bytedance.crypto.engine;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes6.dex */
public class HKDFHelper {
    private static final String HMAC_ALGORITHM = "HmacSHA256";

    public HKDFHelper() {
    }

    public static byte[] deriveKey(byte[] r100, byte[] r101, byte[] r102) {
        return expand(extract(r101, r100), r102, 32);
    }

    private static byte[] expand(byte[] r100, byte[] r101, int r110) {
        Mac r102 = Mac.getInstance(HMAC_ALGORITHM);
        r102.init(new SecretKeySpec(r100, HMAC_ALGORITHM));
        byte[] r103 = new byte[r110];
        byte[] r104 = new byte[0];
        int r105 = (int) Math.ceil(((double) r110) / ((double) r102.getMacLength()));
        int r106 = 1;
        int r107 = 0;
    L3:
        if (r106 > r105) goto L5;
        r102.reset();
        r102.update(r104);
        r102.update(r101);
        r102.update((byte) r106);
        r104 = r102.doFinal();
        System.arraycopy(r104, 0, r103, r107, Math.min(r104.length, r110 - r107));
        r107 = r107 + r104.length;
        r106 = r106 + 1;
        goto L3
    L5:
        return r103;
    }

    private static byte[] extract(byte[] r100, byte[] r101) {
        if (r100 != null) goto L4;
    L5:
        r100 = new byte[32];
    L6:
        Mac r102 = Mac.getInstance(HMAC_ALGORITHM);
        r102.init(new SecretKeySpec(r100, HMAC_ALGORITHM));
        return r102.doFinal(r101);
    L4:
        if (r100.length != 0) goto L6;
        goto L5
    }
}
