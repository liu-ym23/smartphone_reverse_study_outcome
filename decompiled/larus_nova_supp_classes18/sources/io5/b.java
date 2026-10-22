package io5;

import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements c {
    public b() {
    }

    @Override // io5.c
    public final byte[] a(String r5, String r6, byte[] r7) {
        if (r7 != null) goto L10;
        tt5.a.d("AesGcmDecoder", "decodeToByte() sourceData == null");
    L10:
        Cipher r1 = Cipher.getInstance("AES/GCM/NoPadding");     // Catch: Exception -> L7
        byte[] r8 = Base64.decode(r5, 0);     // Catch: Exception -> L7
        byte[] r9 = Base64.decode(r6, 0);     // Catch: Exception -> L7
        r1.init(2, new SecretKeySpec(r8, "AES"), new GCMParameterSpec(128, r9));     // Catch: Exception -> L7
        return r1.doFinal(r7);
    L7:
        e = move-exception;
        tt5.a.e("AESUtils", "decrypt error ", e, false);
        return null;
    }
}
