package com.cmic.ida.sdk;

import android.util.Base64;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.byted.cast.linkcommon.security.SecurityUtil;
import com.bytedance.crypto.utils.CryptoConst;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes22.dex */
public class a {
    public static String a(byte[] r100, String r101) {
        SecretKeySpec r102 = new SecretKeySpec(r100, CryptoConst.ALGORITHM_AES);     // Catch: Exception -> L4
        Cipher r103 = Cipher.getInstance(SecurityUtil.ENCRYPT_GCM);     // Catch: Exception -> L4
        r103.init(1, r102, new GCMParameterSpec(128, Arrays.copyOf(r100, 12)));     // Catch: Exception -> L4
        return Base64.encodeToString(r103.doFinal(r101.getBytes(XML.CHARSET_UTF8)), 2);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static String a(byte[] r100, String r101, byte[] r102) {
        byte[] r103 = Base64.decode(r101, 0);     // Catch: Exception -> L5
        SecretKeySpec r104 = new SecretKeySpec(r100, CryptoConst.ALGORITHM_AES);     // Catch: Exception -> L5
        Cipher r105 = Cipher.getInstance("AES/CBC/PKCS5Padding");     // Catch: Exception -> L5
        r105.init(2, r104, new IvParameterSpec(r102));     // Catch: Exception -> L5
        return new String(r105.doFinal(r103), XML.CHARSET_UTF8);
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static String b(byte[] r100, String r101, byte[] r102) {
        SecretKeySpec r103 = new SecretKeySpec(r100, CryptoConst.ALGORITHM_AES);     // Catch: Exception -> L4
        Cipher r104 = Cipher.getInstance("AES/CBC/PKCS5Padding");     // Catch: Exception -> L4
        r104.init(1, r103, new IvParameterSpec(r102));     // Catch: Exception -> L4
        return Base64.encodeToString(r104.doFinal(r101.getBytes(XML.CHARSET_UTF8)), 0);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
