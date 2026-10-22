package com.xiaomi.push;

import com.bytedance.crypto.utils.CryptoConst;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes41.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f463936a = null;

    static {
        f463936a = new byte[]{100, 23, 84, 114, 72, 0, 4, 97, 73, 97, 2, 52, 84, 102, 18, 32};
    }

    private static Cipher a(byte[] r100, int r101) {
        SecretKeySpec r102 = new SecretKeySpec(r100, CryptoConst.ALGORITHM_AES);
        IvParameterSpec r103 = new IvParameterSpec(f463936a);
        Cipher r104 = Cipher.getInstance("AES/CBC/PKCS5Padding");
        r104.init(r101, r102, r103);
        return r104;
    }

    public static byte[] b(byte[] r100, byte[] r101) {
        return a(r100, 1).doFinal(r101);
    }

    public static byte[] a(byte[] r100, byte[] r101) {
        return a(r100, 2).doFinal(r101);
    }
}
