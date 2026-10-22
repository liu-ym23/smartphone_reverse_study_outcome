package com.unicom.online.account.kernel;

import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.crypto.utils.CryptoConst;
import java.util.UUID;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes5.dex */
public final class n {
    public static String a() {
        String r100 = UUID.randomUUID().toString().replace("-", "");     // Catch: Exception -> L9
        if (TextUtils.isEmpty(r100) == false) goto L6;
    L7:
        return ak.c().substring(0, 32);
    L6:
        if (r100.length() < 32) goto L7;
        return r100;
    L9:
        e = move-exception;
        aj.a(e);
        return "";
    }

    public static String a(String r100, String r101, String r102) {
        return d(r100, r101, r102);
    L4:
        e = move-exception;
        aj.a(e);
        return null;
    }

    public static String b(String r100, String r101, String r102) {
        return c(r100, r101, r102);
    L4:
        e = move-exception;
        aj.a(e);
        return null;
    }

    private static String c(String r100, String r101, String r102) {
        if (r100 != null) goto L27;
        return null;
    L27:
    L22:
        e = move-exception;
        throw new Exception("Encrypt error", e);
    L5:
        if (r100.length() != 0) goto L7;
        return null;
    L7:
        if (r100.trim().length() == 0) goto L29;
        if (r101 == null) goto L21;
        if (r101.length() != 16) goto L19;
        if (r102.length() != 16) goto L17;
        Cipher r103 = Cipher.getInstance("AES/CBC/PKCS5Padding");     // Catch: Exception -> L22
        r103.init(1, new SecretKeySpec(r101.getBytes(XML.CHARSET_UTF8), CryptoConst.ALGORITHM_AES), new IvParameterSpec(r102.getBytes(XML.CHARSET_UTF8)));     // Catch: Exception -> L22
        return o.a(r103.doFinal(r100.getBytes(XML.CHARSET_UTF8)));
    L17:
        throw new Exception(" iv encrypt key length error");     // Catch: Exception -> L22
    L19:
        throw new Exception("encrypt key length error");     // Catch: Exception -> L22
    L21:
        throw new Exception("encrypt key is null");     // Catch: Exception -> L22
    L29:
        return null;
    }

    private static String d(String r100, String r101, String r102) {
        if (r100 != null) goto L27;
        return null;
    L27:
    L22:
        e = move-exception;
        throw new Exception("decrypt error", e);
    L5:
        if (r100.length() != 0) goto L7;
        return null;
    L7:
        if (r100.trim().length() == 0) goto L29;
        if (r101 == null) goto L21;
        if (r101.length() != 16) goto L19;
        if (r102.length() != 16) goto L17;
        byte[] r103 = o.b(r100);     // Catch: Exception -> L22
        Cipher r104 = Cipher.getInstance("AES/CBC/PKCS5Padding");     // Catch: Exception -> L22
        r104.init(2, new SecretKeySpec(r101.getBytes(XML.CHARSET_UTF8), CryptoConst.ALGORITHM_AES), new IvParameterSpec(r102.getBytes(XML.CHARSET_UTF8)));     // Catch: Exception -> L22
        return new String(r104.doFinal(r103), XML.CHARSET_UTF8);
    L17:
        throw new Exception(" iv decrypt key length error");     // Catch: Exception -> L22
    L19:
        throw new Exception("decrypt key length error");     // Catch: Exception -> L22
    L21:
        throw new Exception("decrypt key is null");     // Catch: Exception -> L22
    L29:
        return null;
    }
}
