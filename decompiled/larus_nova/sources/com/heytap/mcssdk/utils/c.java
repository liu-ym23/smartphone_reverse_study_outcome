package com.heytap.mcssdk.utils;

import android.util.Base64;
import java.nio.charset.Charset;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/* JADX INFO: loaded from: classes23.dex */
public abstract class c {
    public c() {
    }

    public static String a(String r100, String r101) {
        Cipher r102 = Cipher.getInstance("DES");
        r102.init(2, a(r101));
        return new String(r102.doFinal(Base64.decode(r100, 0)), Charset.defaultCharset()).trim();
    }

    private static Key a(String r100) {
        DESKeySpec r101 = new DESKeySpec(Base64.decode(r100, 0));
        return SecretKeyFactory.getInstance("DES").generateSecret(r101);
    }
}
