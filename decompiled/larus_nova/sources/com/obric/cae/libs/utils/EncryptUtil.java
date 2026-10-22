package com.obric.cae.libs.utils;

import android.util.Base64;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes33.dex */
public class EncryptUtil {
    public EncryptUtil() {
    }

    public static String decrypt(String r100, String r101, String r110, boolean r111) {
        if (r101 != null) goto L5;
    L25:
        return "";
    L5:
        if (r101.isEmpty() == true) goto L25;
        Matcher r102 = PatternProtector.compile(Pattern.quote(ContainerUtils.KEY_VALUE_DELIMITER + r100 + " EN=") + "([A-Za-z0-9+/=]+)").matcher(r101);
        if (r102.find() == true) goto L26;
        return "";
    L26:
        byte[] r103 = Base64.decode(r102.group(1), 2);     // Catch: Exception -> L22
        if (r111 == true) goto L15;
        MessageDigest r112 = MessageDigest.getInstance("SHA-256");     // Catch: Exception -> L22
        byte[] r113 = r110.getBytes(StandardCharsets.UTF_8);     // Catch: Exception -> L22
        r112.update(r113, 0, r113.length);     // Catch: Exception -> L22
        SecretKeySpec r114 = new SecretKeySpec(r112.digest(), "AES/ECB/PKCS5Padding");     // Catch: Exception -> L22
    L20:
        Cipher r115 = Cipher.getInstance("AES/ECB/PKCS5Padding");     // Catch: Exception -> L22
        r115.init(2, r114);     // Catch: Exception -> L22
        return new String(r115.doFinal(r103), StandardCharsets.UTF_8);
    L15:
        if (r103.length < 16) goto L18;
        byte[] r116 = new byte[16];     // Catch: Exception -> L22
        System.arraycopy(r103, 0, r116, 0, 16);     // Catch: Exception -> L22
        int r104 = r103.length - 16;     // Catch: Exception -> L22
        byte[] r105 = new byte[r104];     // Catch: Exception -> L22
        System.arraycopy(r103, 16, r105, 0, r104);     // Catch: Exception -> L22
        MessageDigest r106 = MessageDigest.getInstance("SHA-256");     // Catch: Exception -> L22
        r106.update(r116);     // Catch: Exception -> L22
        byte[] r117 = r110.getBytes(StandardCharsets.UTF_8);     // Catch: Exception -> L22
        r106.update(r117, 0, r117.length);     // Catch: Exception -> L22
        r114 = new SecretKeySpec(r106.digest(), "AES/ECB/PKCS5Padding");     // Catch: Exception -> L22
        r103 = r105;
        goto L20
    L18:
        throw new Exception("Invalid encrypted data: too short to contain salt.");     // Catch: Exception -> L22
    L22:
        e = move-exception;
        LogUtil.e("EncryptUtil-" + r100, "Error decrypting data: ".concat(r101), e);
        return r101;
    }

    public static String encrypt(String r100, String r101, String r102, boolean r103) {
        if (r101 != null) goto L5;
        return "";
    L5:
        if (r101.isEmpty() == true) goto L25;
        if (r103 == true) goto L23;
        byte[] r104 = null;
    L10:
        MessageDigest r105 = MessageDigest.getInstance("SHA-256");     // Catch: Exception -> L18
        if (r104 == null) goto L13;
        r105.update(r104);     // Catch: Exception -> L18
    L13:
        byte[] r106 = r102.getBytes(StandardCharsets.UTF_8);     // Catch: Exception -> L18
        r105.update(r106, 0, r106.length);     // Catch: Exception -> L18
        SecretKeySpec r107 = new SecretKeySpec(r105.digest(), "AES/ECB/PKCS5Padding");     // Catch: Exception -> L18
        Cipher r108 = Cipher.getInstance("AES/ECB/PKCS5Padding");     // Catch: Exception -> L18
        r108.init(1, r107);     // Catch: Exception -> L18
        byte[] r109 = r108.doFinal(r101.getBytes(StandardCharsets.UTF_8));     // Catch: Exception -> L18
        if (r103 == false) goto L16;
        byte[] r110 = new byte[r104.length + r109.length];     // Catch: Exception -> L18
        System.arraycopy(r104, 0, r110, 0, r104.length);     // Catch: Exception -> L18
        System.arraycopy(r109, 0, r110, r104.length, r109.length);     // Catch: Exception -> L18
        r109 = r110;
    L16:
        return ContainerUtils.KEY_VALUE_DELIMITER + r100 + " EN=" + Base64.encodeToString(r109, 2);
    L18:
        e = move-exception;
        LogUtil.e("EncryptUtil-" + r100, "Error encrypting data: ".concat(r101), e);
        return r101;
    L23:
        r104 = new byte[16];     // Catch: Exception -> L18
        new SecureRandom().nextBytes(r104);     // Catch: Exception -> L18
        goto L10
    L25:
        return "";
    }
}
