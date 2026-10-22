package com.google.crypto.tink.subtle;

import com.alipay.sdk.m.n.d;
import com.bytedance.crypto.utils.CryptoConst;
import java.io.BufferedReader;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.ECKey;
import java.security.interfaces.RSAKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.annotation.Nullable;
import lv7.b;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
public final enum PemKeyType extends Enum<PemKeyType> {
    public static final PemKeyType ECDSA_P256_SHA256 = null;
    public static final PemKeyType ECDSA_P384_SHA384 = null;
    public static final PemKeyType ECDSA_P521_SHA512 = null;
    public static final PemKeyType RSA_PSS_2048_SHA256 = null;
    public static final PemKeyType RSA_PSS_3072_SHA256 = null;
    public static final PemKeyType RSA_PSS_4096_SHA256 = null;
    public static final PemKeyType RSA_PSS_4096_SHA512 = null;
    public static final PemKeyType RSA_SIGN_PKCS1_2048_SHA256 = null;
    public static final PemKeyType RSA_SIGN_PKCS1_3072_SHA256 = null;
    public static final PemKeyType RSA_SIGN_PKCS1_4096_SHA256 = null;
    public static final PemKeyType RSA_SIGN_PKCS1_4096_SHA512 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PemKeyType[] f275911a = null;
    public final String algorithm;
    public final Enums$HashType hash;
    public final int keySizeInBits;
    public final String keyType;

    static {
        Enums$HashType r110 = Enums$HashType.SHA256;
        PemKeyType r100 = new PemKeyType("RSA_PSS_2048_SHA256", 0, d.f25615a, "RSASSA-PSS", 2048, r110);
        RSA_PSS_2048_SHA256 = r100;
        PemKeyType r101 = new PemKeyType("RSA_PSS_3072_SHA256", 1, d.f25615a, "RSASSA-PSS", 3072, r110);
        RSA_PSS_3072_SHA256 = r101;
        PemKeyType r102 = new PemKeyType("RSA_PSS_4096_SHA256", 2, d.f25615a, "RSASSA-PSS", 4096, r110);
        RSA_PSS_4096_SHA256 = r102;
        Enums$HashType r103 = Enums$HashType.SHA512;
        PemKeyType r104 = new PemKeyType("RSA_PSS_4096_SHA512", 3, d.f25615a, "RSASSA-PSS", 4096, r103);
        RSA_PSS_4096_SHA512 = r104;
        PemKeyType r105 = new PemKeyType("RSA_SIGN_PKCS1_2048_SHA256", 4, d.f25615a, "RSASSA-PKCS1-v1_5", 2048, r110);
        RSA_SIGN_PKCS1_2048_SHA256 = r105;
        PemKeyType r106 = new PemKeyType("RSA_SIGN_PKCS1_3072_SHA256", 5, d.f25615a, "RSASSA-PKCS1-v1_5", 3072, r110);
        RSA_SIGN_PKCS1_3072_SHA256 = r106;
        PemKeyType r107 = new PemKeyType("RSA_SIGN_PKCS1_4096_SHA256", 6, d.f25615a, "RSASSA-PKCS1-v1_5", 4096, r110);
        RSA_SIGN_PKCS1_4096_SHA256 = r107;
        PemKeyType r111 = new PemKeyType("RSA_SIGN_PKCS1_4096_SHA512", 7, d.f25615a, "RSASSA-PKCS1-v1_5", 4096, r103);
        RSA_SIGN_PKCS1_4096_SHA512 = r111;
        PemKeyType r112 = new PemKeyType("ECDSA_P256_SHA256", 8, CryptoConst.ALGORITHM_EC, "ECDSA", 256, r110);
        ECDSA_P256_SHA256 = r112;
        PemKeyType r113 = new PemKeyType("ECDSA_P384_SHA384", 9, CryptoConst.ALGORITHM_EC, "ECDSA", 384, Enums$HashType.SHA384);
        ECDSA_P384_SHA384 = r113;
        PemKeyType r114 = new PemKeyType("ECDSA_P521_SHA512", 10, CryptoConst.ALGORITHM_EC, "ECDSA", 521, r103);
        ECDSA_P521_SHA512 = r114;
        f275911a = new PemKeyType[]{r100, r101, r102, r104, r105, r106, r107, r111, r112, r113, r114};
    }

    public static PemKeyType[] values() {
        return (PemKeyType[]) f275911a.clone();
    }

    public static PemKeyType valueOf(String r100) {
        return (PemKeyType) a.a(PemKeyType.class, r100);
    }

    public final Key a(byte[] r100) throws GeneralSecurityException {
        PrivateKey r101 = b.f510968d.a(this.keyType).generatePrivate(new PKCS8EncodedKeySpec(r100));
        c(r101);
        return r101;
    }

    public final Key b(byte[] r100) throws GeneralSecurityException {
        PublicKey r101 = b.f510968d.a(this.keyType).generatePublic(new X509EncodedKeySpec(r100));
        c(r101);
        return r101;
    }

    public final void c(Key r100) throws GeneralSecurityException {
        if (this.keyType.equals(d.f25615a) == false) goto L9;
        int r101 = ((RSAKey) r100).getModulus().bitLength();
        if (r101 != this.keySizeInBits) goto L8;
        return;
    L8:
        throw new GeneralSecurityException(String.format("invalid RSA key size, want %d got %d", new Object[]{Integer.valueOf(this.keySizeInBits), Integer.valueOf(r101)}));
    L9:
        ECParameterSpec r102 = ((ECKey) r100).getParams();
        if (EllipticCurves.e(r102) == false) goto L17;
        int r103 = EllipticCurves.b(r102.getCurve());
        if (r103 != this.keySizeInBits) goto L15;
        return;
    L15:
        throw new GeneralSecurityException(String.format("invalid EC key size, want %d got %d", new Object[]{Integer.valueOf(this.keySizeInBits), Integer.valueOf(r103)}));
    L17:
        throw new GeneralSecurityException("unsupport EC spec: " + r102.toString());
    }

    @Nullable
    public Key readKey(BufferedReader r100) throws IOException {
        String r101 = r100.readLine();
    L3:
        if (r101 == null) goto L8;
        if (r101.startsWith("-----BEGIN ") == true) goto L8;
        r101 = r100.readLine();
    L8:
        if (r101 != null) goto L10;
        return null;
    L10:
        String r102 = r101.trim().substring(11);
        int r103 = r102.indexOf("-----");
        if (r103 >= 0) goto L13;
        return null;
    L13:
        String r104 = r102.substring(0, r103);
        String r105 = "-----END " + r104 + "-----";
        StringBuilder r106 = new StringBuilder();
    L14:
        String r107 = r100.readLine();
        if (r107 != null) goto L17;
    L33:
        byte[] r108 = lv7.a.a(r106.toString());     // Catch: Throwable -> L32
        if (r104.contains("PUBLIC KEY") == false) goto L28;
        return b(r108);
    L28:
        if (r104.contains("PRIVATE KEY") == false) goto L31;
        return a(r108);
    L31:
        return null;
    L17:
        if (r107.indexOf(":") > 0) goto L14;
        if (r107.contains(r105) == true) goto L33;
        r106.append(r107);
        goto L14
    }

    public PemKeyType(String r100, int r101, String r102, String r103, int r104, Enums$HashType r105) {
        super(r100, r101);
        this.keyType = r102;
        this.algorithm = r103;
        this.keySizeInBits = r104;
        this.hash = r105;
    }
}
