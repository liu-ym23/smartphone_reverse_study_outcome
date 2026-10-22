package io5;

import android.util.Base64;
import com.byted.cast.linkcommon.security.SecurityUtil;
import com.bytedance.crypto.utils.CryptoConst;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements c {
    public b() {
    }

    @Override // io5.c
    public final byte[] a(String r100, String r101, byte[] r102) {
        if (r102 != null) goto L10;
        tt5.a.d("AesGcmDecoder", "decodeToByte() sourceData == null");
    L10:
        Cipher r103 = Cipher.getInstance(SecurityUtil.ENCRYPT_GCM);     // Catch: Exception -> L7
        byte[] r104 = Base64.decode(r100, 0);     // Catch: Exception -> L7
        byte[] r105 = Base64.decode(r101, 0);     // Catch: Exception -> L7
        r103.init(2, new SecretKeySpec(r104, CryptoConst.ALGORITHM_AES), new GCMParameterSpec(128, r105));     // Catch: Exception -> L7
        return r103.doFinal(r102);
    L7:
        e = move-exception;
        tt5.a.e("AESUtils", "decrypt error ", e, false);
        return null;
    }
}
