package com.unicom.online.account.kernel;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes41.dex */
public final class s {
    public static String a(String r100, String r101) {
        X509EncodedKeySpec r102 = new X509EncodedKeySpec(o.b(r101));
        PublicKey r103 = KeyFactory.getInstance(com.alipay.sdk.m.n.d.f25615a).generatePublic(r102);
        Cipher r104 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        r104.init(1, r103);
        return o.a(r104.doFinal(r100.getBytes()));
    }
}
