package com.vivo.push.util;

import android.util.Base64;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

/* JADX INFO: loaded from: classes41.dex */
public final class ab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f462535a = "RSA";

    public static PublicKey a(String r100) throws Exception {
        byte[] r101 = Base64.decode(r100, 2);     // Catch: NullPointerException -> L5 InvalidKeySpecException -> L7 NoSuchAlgorithmException -> L9
        return KeyFactory.getInstance(f462535a).generatePublic(new X509EncodedKeySpec(r101));
    L6:
        throw new Exception("公钥数据为空");
    L10:
        throw new Exception("无此算法");
    L8:
        throw new Exception("公钥非法");
    }

    public static String a(Key r100) {
        return Base64.encodeToString(r100.getEncoded(), 2);
    }

    public static boolean a(byte[] r100, PublicKey r101, byte[] r102) throws Exception {
        Signature r103 = Signature.getInstance("MD5withRSA");
        r103.initVerify(r101);
        r103.update(r100);
        return r103.verify(r102);
    }
}
