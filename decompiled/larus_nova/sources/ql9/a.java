package ql9;

import android.util.Base64;
import com.alipay.sdk.m.n.d;
import com.baidu.mapauto.auth.util.RSAUtil;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

/* JADX INFO: loaded from: classes30.dex */
public final class a {
    public static void a(String r100, String r101) {
        if (r100 == null) goto L12;
        if (r101 == null) goto L13;
        int r102 = b.f533825a;     // Catch: Exception -> L7
        byte[] r103 = r101.getBytes();     // Catch: Exception -> L7
        X509EncodedKeySpec r104 = new X509EncodedKeySpec(Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCrp4sMcJjY9hb2J3sHWlwIEBrJlw2Cimv+rZAQmR8V3EI+0PUK14pL8OcG7CY79li30IHwYGWwUapADKA01nKgNeq7+rSciMYZv6ByVq+ocxKY8az78HwIppwxKWpQ+ziqYavvfE5+iHIzAc8RvGj9lL6xx1zhoPkdaA0agAyuMQIDAQAB", 0));     // Catch: Exception -> L7
        PublicKey r105 = KeyFactory.getInstance(d.f25615a).generatePublic(r104);     // Catch: Exception -> L7
        Signature r106 = Signature.getInstance(RSAUtil.SIGNATURE_ALGORITHM);     // Catch: Exception -> L7
        r106.initVerify(r105);     // Catch: Exception -> L7
        r106.update(r103);     // Catch: Exception -> L7
        r106.verify(Base64.decode(r100, 0));     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    L13:
        return;
    }
}
