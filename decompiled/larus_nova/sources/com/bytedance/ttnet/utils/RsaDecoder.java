package com.bytedance.ttnet.utils;

import android.util.Base64;
import com.alipay.sdk.m.n.d;
import com.bytedance.crypto.utils.CryptoConst;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes22.dex */
public class RsaDecoder {
    private static final String PUB_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDQwuhlG2hSvAH1pxaCawFQTHQPEa+MLm0muwhkPd6hCTxmodQOCTbwWzaZazk8GDtV4AwBAM8jIeHP7z9bYxmZeT/lKjgvbplEWURevOQ4O6rYahjL8i4vyf431ocW+POx+kQbJ8Tr4EAuqjEUmP2nw6WUQ6/hMjQv/CS6SfqpEQIDAQAB";

    public RsaDecoder() {
    }

    public static String decodeSign(String r100) throws Throwable {
        X509EncodedKeySpec r101 = new X509EncodedKeySpec(Base64.decode(PUB_KEY, 0));
        PublicKey r102 = KeyFactory.getInstance(d.f25615a).generatePublic(r101);
        Cipher r103 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        r103.init(2, r102);
        return new String(r103.doFinal(Base64.decode(r100, 0)));
    }

    public static byte[] encode(byte[] r100) throws Throwable {
        X509EncodedKeySpec r101 = new X509EncodedKeySpec(Base64.decode(PUB_KEY, 0));
        PublicKey r102 = KeyFactory.getInstance(d.f25615a).generatePublic(r101);
        Cipher r103 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        r103.init(1, r102);
        return r103.doFinal(r100);
    }

    public static byte[] aesEncrpt(byte[] r100, String r101) throws Exception {
        SecretKeySpec r102 = new SecretKeySpec(r100, CryptoConst.ALGORITHM_AES);
        Cipher r103 = Cipher.getInstance("AES/CBC/PKCS5Padding");
        r103.init(1, r102);
        byte[] r104 = r103.doFinal(r101.getBytes("UTF-8"));
        byte[] r105 = new byte[r104.length + 16];
        System.arraycopy(r103.getIV(), 0, r105, 0, 16);
        System.arraycopy(r104, 0, r105, 16, r104.length);
        return r105;
    }
}
