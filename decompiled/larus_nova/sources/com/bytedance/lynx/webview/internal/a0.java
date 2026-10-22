package com.bytedance.lynx.webview.internal;

import android.util.Base64;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

/* JADX INFO: loaded from: classes21.dex */
public final class a0 {
    public static boolean a(String r100, String r101) {
        PublicKey r102 = KeyFactory.getInstance(com.alipay.sdk.m.n.d.f25615a).generatePublic(new X509EncodedKeySpec(Base64.decode("MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAJ9Z9a6Yn/vYSp7bytaE0ILOke8/0czT69fnKC5hmTQ5P3SLYRqdhC0Lvv6Jt2UHzw6MQsSI7Zqp59gpFK4GDiMCAwEAAQ==", 0)));     // Catch: Throwable -> L5
        System.out.println("CheckWithRsa = " + r101);     // Catch: Throwable -> L5
        byte[] r103 = Base64.decode(r101, 0);     // Catch: Throwable -> L5
        Signature r104 = Signature.getInstance("SHA1withRSA");     // Catch: Throwable -> L5
        r104.initVerify(r102);     // Catch: Throwable -> L5
        r104.update(r100.getBytes());     // Catch: Throwable -> L5
        boolean r105 = r104.verify(r103);     // Catch: Throwable -> L5
    L7:
        l17.k.d(new String[]{"CheckWithRsa ret is = " + r105});
        return r105;
    L5:
        th = move-exception;
        l17.k.b(new String[]{"CheckWithRsa", th.toString()});
        r105 = false;
        goto L7
    }
}
