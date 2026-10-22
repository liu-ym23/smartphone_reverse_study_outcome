package io5;

import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements c {
    public a() {
    }

    @Override // io5.c
    public final byte[] a(String r6, String r7, byte[] r8) {
        if (r8 != null) goto L12;
        tt5.a.d("AesCbcDecoder", "source data == null");
        return null;
    L12:
        byte[] r2 = new byte[32];     // Catch: Exception -> L9
        System.arraycopy(MessageDigest.getInstance("SHA-256").digest(r6.getBytes()), 0, r2, 0, 32);     // Catch: Exception -> L9
        SecretKeySpec r9 = new SecretKeySpec(r2, "AES");     // Catch: Exception -> L9
        byte[] r3 = new byte[16];     // Catch: Exception -> L9
        System.arraycopy(r8, 0, r3, 0, 16);     // Catch: Exception -> L9
        IvParameterSpec r4 = new IvParameterSpec(r3);     // Catch: Exception -> L9
        int r5 = r8.length - 16;     // Catch: Exception -> L9
        byte[] r10 = new byte[r5];     // Catch: Exception -> L9
        System.arraycopy(r8, 16, r10, 0, r5);     // Catch: Exception -> L9
        Cipher r11 = Cipher.getInstance("AES/CBC/PKCS5Padding");     // Catch: Exception -> L9
        r11.init(2, r9, r4);     // Catch: Exception -> L9
        return r11.doFinal(r10);
    L9:
        e = move-exception;
        tt5.a.e("AESUtils", "decryptByCBC error:", e, false);
        return null;
    }
}
