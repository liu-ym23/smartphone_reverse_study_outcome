package com.heytap.msp.push.encrypt;

import com.heytap.mcssdk.utils.d;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes23.dex */
public class AESEncrypt {
    private static final String ALGORITHM = "AES";
    private static final String IV_CONNECT = "%IV1%";
    private static final int KEY_BYTE_SIZE = 256;
    public static final String SDK_APP_SECRET = "isvrbeT7qUywVEZ1Ia0/aUVA/TcFaeV0wC8qFLc8rg4=";
    private static final String TRANSFORMATION = "AES/CTR/NoPadding";

    public AESEncrypt() {
    }

    public static String decrypt(String r100, String r101) {
        String[] r102 = r101.split(IV_CONNECT);
        byte[] r103 = a.b(r102[0]);
        byte[] r104 = a.b(r102[1]);
        SecretKeySpec r105 = new SecretKeySpec(a.b(r100), "AES");
        Cipher r106 = Cipher.getInstance(TRANSFORMATION);
        r106.init(2, r105, new IvParameterSpec(r104));
        return new String(r106.doFinal(r103));
    }

    public static String encrypt(String r100) {
        return encrypt(SDK_APP_SECRET, r100);
    L4:
        e = move-exception;
        d.b(e.getLocalizedMessage());
        return "";
    }

    public static String encrypt(String r100, String r101) {
        SecretKeySpec r102 = new SecretKeySpec(a.b(r100), "AES");
        Cipher r103 = Cipher.getInstance(TRANSFORMATION);
        r103.init(1, r102);
        String r104 = a.d(r103.getIV());
        return a.d(r103.doFinal(r101.getBytes())) + IV_CONNECT + r104;
    }

    public static String genKey() {
        KeyGenerator r100 = KeyGenerator.getInstance("AES");
        r100.init(256);
        return a.d(r100.generateKey().getEncoded());
    }
}
