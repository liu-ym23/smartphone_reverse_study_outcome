package com.huawei.agconnect.config.impl;

import com.bytedance.crypto.utils.CryptoConst;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes23.dex */
public class j {
    public static SecretKey a(d r100) throws NoSuchAlgorithmException, InvalidKeySpecException {
        if (r100 == null) goto L8;
        if (r100.a() == false) goto L8;
        r100.g();
        String r101 = Hex.encodeHexString(a(Hex.decodeHexString(r100.b()), Hex.decodeHexString(r100.c()), Hex.decodeHexString(r100.d())));
        return new SecretKeySpec(SecretKeyFactory.getInstance(r100.f()).generateSecret(new PBEKeySpec(r101.toCharArray(), Hex.decodeHexString(r100.e()), r100.g(), r100.h() * 8)).getEncoded(), CryptoConst.ALGORITHM_AES);
    L8:
        throw new IllegalArgumentException("invalid data for generating the key.");
    }

    public static byte[] a(SecretKey r100, byte[] r101) throws GeneralSecurityException {
        if (r100 == null) goto L7;
        if (r101 == null) goto L7;
        byte[] r102 = Arrays.copyOfRange(r101, 1, 17);
        Cipher r103 = Cipher.getInstance("AES/CBC/PKCS5Padding");
        r103.init(2, r100, new IvParameterSpec(r102));
        return r103.doFinal(r101, r102.length + 1, (r101.length - r102.length) - 1);
    L7:
        throw new NullPointerException("key or cipherText must not be null.");
    }

    private static byte[] a(byte[] r100, int r101) {
        if (r100 == null) goto L12;
        int r102 = 0;
    L5:
        if (r102 >= r100.length) goto L10;
        if (r101 >= 0) goto L8;
        r100[r102] = (byte) (r100[r102] << (-r101));
    L9:
        r102 = r102 + 1;
        goto L5
    L8:
        r100[r102] = (byte) (r100[r102] >> r101);
        goto L9
    L10:
        return r100;
    L12:
        throw new NullPointerException("bytes must not be null.");
    }

    private static byte[] a(byte[] r100, byte[] r101) {
        if (r100 == null) goto L14;
        if (r101 == null) goto L14;
        if (r100.length != r101.length) goto L12;
        byte[] r102 = new byte[r100.length];
        int r103 = 0;
    L8:
        if (r103 >= r100.length) goto L10;
        r102[r103] = (byte) (r100[r103] ^ r101[r103]);
        r103 = r103 + 1;
        goto L8
    L10:
        return r102;
    L12:
        throw new IllegalArgumentException("left and right must be the same length.");
    L14:
        throw new NullPointerException("left or right must not be null.");
    }

    public static byte[] a(byte[] r100, byte[] r101, byte[] r102) {
        return a(a(a(a(r100, -4), r101), 6), r102);
    }
}
