package com.bytedance.privacy.pcc;

import android.util.Base64;
import com.byted.cast.linkcommon.security.SecurityUtil;
import com.bytedance.crypto.utils.CryptoConst;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.UByte;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f266695a = null;

    public a() {
    }

    static {
        f266695a = a.class.getSimpleName();
    }

    public static byte[] b(PublicKey r100) {
        ECPoint r101 = ((ECPublicKey) r100).getW();
        byte[] r102 = new byte[65];
        r102[0] = 4;
        System.arraycopy(d(r101.getAffineX()), 0, r102, 1, 32);
        System.arraycopy(d(r101.getAffineY()), 0, r102, 33, 32);
        return r102;
    }

    public static byte[] d(BigInteger r100) {
        byte[] r101 = r100.toByteArray();
        if (r101.length != 32) goto L5;
        return r101;
    L5:
        byte[] r102 = new byte[32];
        if (r101.length <= 32) goto L8;
        System.arraycopy(r101, r101.length - 32, r102, 0, 32);
    L9:
        return r102;
    L8:
        System.arraycopy(r101, 0, r102, 32 - r101.length, r101.length);
        goto L9
    }

    public static String e(byte[] r100) {
        if (r100 != null) goto L5;
        return "null";
    L5:
        StringBuilder r101 = new StringBuilder(r100.length * 2);
        int r102 = r100.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L9;
        r101.append(String.format("%02x", new Object[]{Integer.valueOf(r100[r103] & UByte.MAX_VALUE)}));
        r103 = r103 + 1;
        goto L6
    L9:
        return r101.toString();
    }

    public static byte[] a(byte[] r100, byte[] r101, byte[] r102) throws Exception {
        Cipher r103 = Cipher.getInstance(SecurityUtil.ENCRYPT_GCM);
        r103.init(1, new SecretKeySpec(r100, CryptoConst.ALGORITHM_AES), new GCMParameterSpec(128, r101));
        return r103.doFinal(r102);
    }

    public static boolean f(String r100, byte[] r101, byte[] r102) throws Exception {
        byte[] r103 = r100.getBytes(StandardCharsets.UTF_8);
        X509Certificate r104 = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(r103));
        Signature r105 = Signature.getInstance("SHA256withECDSA");
        r105.initVerify(r104.getPublicKey());
        r105.update(r101);
        return r105.verify(r102);
    }

    public static byte[] c(PrivateKey r110, byte[] r111, String r112, byte[] r113, byte[] r114) throws Exception {
        PublicKey r115 = KeyFactory.getInstance(CryptoConst.ALGORITHM_EC).generatePublic(new X509EncodedKeySpec(Base64.decode(r112, 8)));
        KeyAgreement r100 = KeyAgreement.getInstance("ECDH");
        r100.init(r110);
        r100.doPhase(r115, true);
        byte[] r101 = r100.generateSecret();
        String r102 = f266695a;
        k67.b.a(r102, "eciesWrapKey sharedSecret=" + e(r101));
        byte[] r116 = b(r115);
        MessageDigest r103 = MessageDigest.getInstance("SHA-1");
        r103.update(r111);
        byte[] r117 = r103.digest();
        r103.reset();
        r103.update(r116);
        byte[] r118 = r103.digest();
        byte[] r104 = new byte[r117.length + r118.length];
        System.arraycopy(r117, 0, r104, 0, r117.length);
        System.arraycopy(r118, 0, r104, r117.length, r118.length);
        k67.b.a(r102, "eciesWrapKey SHA1(clientPK)=" + e(r117) + " SHA1(serverPK)=" + e(r118));
        StringBuilder r119 = new StringBuilder("eciesWrapKey salt=");
        r119.append(e(r113));
        k67.b.a(r102, r119.toString());
        Mac r120 = Mac.getInstance("HmacSHA512");
        if (r113.length > 0) goto L6;
        r113 = new byte[64];
    L6:
        r120.init(new SecretKeySpec(r113, "HmacSHA512"));
        byte[] r121 = r120.doFinal(r101);
        byte[] r105 = new byte[44];
        byte[] r106 = new byte[0];
        int r107 = 0;
        int r108 = 1;
    L7:
        if (r107 >= 44) goto L9;
        r120.init(new SecretKeySpec(r121, "HmacSHA512"));
        r120.update(r106);
        r120.update(r104);
        r120.update((byte) r108);
        r106 = r120.doFinal();
        int r109 = Math.min(r106.length, 44 - r107);
        System.arraycopy(r106, 0, r105, r107, r109);
        r107 = r107 + r109;
        r108 = r108 + 1;
        goto L7
    L9:
        byte[] r122 = Arrays.copyOf(r105, 32);
        byte[] r123 = Arrays.copyOfRange(r105, 32, 44);
        k67.b.a(r102, "eciesWrapKey KEK=" + e(r122) + " IV=" + e(r123));
        return a(r122, r123, r114);
    }
}
