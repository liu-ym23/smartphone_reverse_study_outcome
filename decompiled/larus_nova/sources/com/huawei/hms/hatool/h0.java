package com.huawei.hms.hatool;

import android.util.Base64;
import com.facebook.net.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: loaded from: classes23.dex */
public class h0 {
    public static String a(String r100, String r101) {
        return a(r100, r101.getBytes("UTF-8"));
    L4:
        v.c("hmsSdk", "Unsupported encoding exception,utf-8");
        return "";
    }

    public static String a(String r100, byte[] r101) {
        if (r101 != null) goto L5;
    L14:
        v.f("hmsSdk", "encrypt: content is empty or null");
        return "";
    L5:
        if (r101.length == 0) goto L14;
        return HexUtil.byteArray2HexStr(a(r101, a(Base64.decode(r100, 0))));
    L11:
        String r102 = "encrypt(): getInstance - No such algorithm,transformation";
    L12:
        v.f("hmsSdk", r102);
        return "";
    L10:
        r102 = "encrypt(): Invalid key specification";
        goto L12
    }

    private static PublicKey a(byte[] r100) {
        X509EncodedKeySpec r101 = new X509EncodedKeySpec(r100);
        return KeyFactory.getInstance(com.alipay.sdk.m.n.d.f25615a).generatePublic(r101);
    }

    private static byte[] a(byte[] r100, PublicKey r101) {
        if (r101 == null) goto L7;
        Cipher r102 = Cipher.getInstance(EncryptUtil.ANDROID_TRANSFORMATION);     // Catch: IllegalBlockSizeException -> L8 BadPaddingException -> L9 NoSuchPaddingException -> L10 InvalidKeyException -> L11 NoSuchAlgorithmException -> L12 UnsupportedEncodingException -> L13
        r102.init(1, r101);     // Catch: IllegalBlockSizeException -> L8 BadPaddingException -> L9 NoSuchPaddingException -> L10 InvalidKeyException -> L11 NoSuchAlgorithmException -> L12 UnsupportedEncodingException -> L13
        return r102.doFinal(r100);
    L7:
        throw new UnsupportedEncodingException("The loaded public key is null");     // Catch: IllegalBlockSizeException -> L8 BadPaddingException -> L9 NoSuchPaddingException -> L10 InvalidKeyException -> L11 NoSuchAlgorithmException -> L12 UnsupportedEncodingException -> L13
    L13:
        String r103 = "rsaEncrypt(): getBytes - Unsupported coding format!";
    L14:
        v.f("hmsSdk", r103);
        return new byte[0];
    L11:
        r103 = "rsaEncrypt(): init - Invalid key!";
    L12:
        r103 = "rsaEncrypt(): getInstance - No such algorithm,transformation";
    L9:
        r103 = "rsaEncrypt():False filling parameters!";
    L8:
        r103 = "rsaEncrypt(): doFinal - The provided block is not filled with";
    L10:
        r103 = "rsaEncrypt():  No such filling parameters ";
        goto L14
    }
}
