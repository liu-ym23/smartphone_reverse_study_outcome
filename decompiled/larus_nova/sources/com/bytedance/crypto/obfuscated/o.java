package com.bytedance.crypto.obfuscated;

import com.byted.cast.linkcommon.security.SecurityUtil;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

/* JADX INFO: loaded from: classes15.dex */
public abstract class o {
    public static String a(byte[] r100) {
        StringBuilder r101 = new StringBuilder();
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L6;
        r101.append(String.format("%02x", new Object[]{Byte.valueOf(r100[r103])}));
        r103 = r103 + 1;
        goto L3
    L6:
        return r101.toString();
    }

    public static byte[] a(int r100, SecretKey r101, byte[] r102, byte[] r103, byte[] r104) {
        "aesGcmXcrypt enter, aad:".concat(new String(r102, StandardCharsets.UTF_8));
        byte[] r105 = new byte[0];
        Cipher r106 = Cipher.getInstance(SecurityUtil.ENCRYPT_GCM);     // Catch: Exception -> L10
        r106.init(r100, r101, new GCMParameterSpec(128, r103));     // Catch: Exception -> L10
        if (r102 != null) goto L6;
    L8:
        return r106.doFinal(r104);
    L6:
        if (r102.length <= 0) goto L8;
        r106.updateAAD(r102);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        e.getMessage();
        return r105;
    }

    public static byte[] a(String r100) {
        if ((r100.length() % 2) != 0) goto L6;
        int r101 = r100.length() / 2;
        byte[] r102 = new byte[r101];
        int r103 = 0;
    L8:
        if (r103 >= r101) goto L14;
        int r104 = r103 * 2;
        r102[r103] = (byte) CastIntegerProtector.parseInt(r100.substring(r104, r104 + 2), 16);     // Catch: Exception -> L12
        r103 = r103 + 1;
    L12:
        e = move-exception;
        e.getMessage();
        goto L6
    L14:
        return r102;
    L6:
        return new byte[0];
    }
}
