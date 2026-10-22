package com.unicom.online.account.kernel;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes41.dex */
public final class v {
    public v() {
    }

    public static byte[] a(byte[] r100, byte[] r101, byte[] r102, int r103) {
        if (r100 == null) goto L37;
        if (r100.length != 16) goto L37;
        if (r102 == null) goto L35;
        if (r101 == null) goto L33;
        int r104 = r102.length;
        if (r103 != 1) goto L13;
        if (r104 > 0) goto L17;
        throw new w(q.f462082n);
    L17:
        if (r101.length != 16) goto L29;
        new SecretKeySpec(r100, "SM4");
        IvParameterSpec r105 = new IvParameterSpec(r101);
        Cipher r106 = Cipher.getInstance("SM4/CBC/PKCS5Padding", "BC");     // Catch: Exception -> L21
        r106.init(r103, new SecretKeySpec(r100, "SM4"), r105);     // Catch: Exception -> L21
        return r106.doFinal(r102);
    L21:
        e = move-exception;
        if (r103 != 1) goto L27;
        throw new w(q.f462076h, e);
    L27:
        throw new w(q.f462077i, e);
    L29:
        throw new w(q.f462085q);
    L13:
        if (r104 <= 0) goto L31;
        if ((r102.length % 16) == 0) goto L17;
    L31:
        throw new w(q.f462083o);
    L33:
        throw new w(q.f462085q);
    L35:
        throw new w(q.f462078j);
    L37:
        throw new w(q.f462084p);
    }
}
