package io5;

import com.bytedance.crypto.utils.CryptoConst;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements c {
    public a() {
    }

    @Override // io5.c
    public final byte[] a(String r100, String r101, byte[] r102) {
        if (r102 != null) goto L12;
        tt5.a.d("AesCbcDecoder", "source data == null");
        return null;
    L12:
        byte[] r103 = new byte[32];     // Catch: Exception -> L9
        System.arraycopy(MessageDigest.getInstance("SHA-256").digest(r100.getBytes()), 0, r103, 0, 32);     // Catch: Exception -> L9
        SecretKeySpec r104 = new SecretKeySpec(r103, CryptoConst.ALGORITHM_AES);     // Catch: Exception -> L9
        byte[] r105 = new byte[16];     // Catch: Exception -> L9
        System.arraycopy(r102, 0, r105, 0, 16);     // Catch: Exception -> L9
        IvParameterSpec r106 = new IvParameterSpec(r105);     // Catch: Exception -> L9
        int r107 = r102.length - 16;     // Catch: Exception -> L9
        byte[] r108 = new byte[r107];     // Catch: Exception -> L9
        System.arraycopy(r102, 16, r108, 0, r107);     // Catch: Exception -> L9
        Cipher r109 = Cipher.getInstance("AES/CBC/PKCS5Padding");     // Catch: Exception -> L9
        r109.init(2, r104, r106);     // Catch: Exception -> L9
        return r109.doFinal(r108);
    L9:
        e = move-exception;
        tt5.a.e("AESUtils", "decryptByCBC error:", e, false);
        return null;
    }
}
