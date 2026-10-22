package com.unionpay.utils;

import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes41.dex */
public final class d {
    public static byte[] a(int r100, byte[] r101, byte[] r102) {
        if (r101.length != 8) goto L5;
    L11:
        if (r102 == null) goto L29;
        Cipher r103 = Cipher.getInstance("DESede/ECB/NoPadding");
        byte[] r104 = new byte[24];
        if (r101.length != 8) goto L16;
        System.arraycopy(r101, 0, r104, 0, 8);
        System.arraycopy(r101, 0, r104, 8, 8);
    L18:
        System.arraycopy(r101, 0, r104, 16, 8);
    L20:
        int r105 = 1;
        if ((r102.length % 8) == 0) goto L23;
        int r106 = ((r102.length / 8) + 1) * 8;
        byte[] r107 = new byte[r106];
        System.arraycopy(r102, 0, r107, 0, r102.length);
        Arrays.fill(r107, r102.length, r106, (byte) 0);
        r102 = r107;
    L23:
        if (r100 != 0) goto L26;
        r105 = 2;
    L26:
        r103.init(r105, new SecretKeySpec(r104, "DESede"));
        return r103.doFinal(r102);
    L16:
        if (r101.length != 16) goto L19;
        System.arraycopy(r101, 0, r104, 0, 16);
        goto L18
    L19:
        System.arraycopy(r101, 0, r104, 0, 24);
        goto L20
    L29:
        throw new IllegalArgumentException();
    L5:
        if (r101.length == 16) goto L11;
        if (r101.length == 24) goto L11;
        throw new IllegalArgumentException();
    }
}
