package org.bouncycastle.jce.provider;

import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.PSSParameterSpec;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Null;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.RSASSAPSSparams;
import org.bouncycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;

/* JADX INFO: loaded from: classes42.dex */
class X509SignatureUtil {
    private static final ASN1Null derNull = null;

    static {
        derNull = DERNull.INSTANCE;
    }

    public X509SignatureUtil() {
    }

    private static String getDigestAlgName(ASN1ObjectIdentifier r100) {
        if (PKCSObjectIdentifiers.f525058md5.equals(r100) == false) goto L7;
        return "MD5";
    L7:
        if (OIWObjectIdentifiers.idSHA1.equals(r100) == false) goto L11;
        return "SHA1";
    L11:
        if (NISTObjectIdentifiers.id_sha224.equals(r100) == false) goto L15;
        return "SHA224";
    L15:
        if (NISTObjectIdentifiers.id_sha256.equals(r100) == false) goto L19;
        return "SHA256";
    L19:
        if (NISTObjectIdentifiers.id_sha384.equals(r100) == false) goto L23;
        return "SHA384";
    L23:
        if (NISTObjectIdentifiers.id_sha512.equals(r100) == false) goto L27;
        return "SHA512";
    L27:
        if (TeleTrusTObjectIdentifiers.ripemd128.equals(r100) == false) goto L31;
        return "RIPEMD128";
    L31:
        if (TeleTrusTObjectIdentifiers.ripemd160.equals(r100) == false) goto L35;
        return "RIPEMD160";
    L35:
        if (TeleTrusTObjectIdentifiers.ripemd256.equals(r100) == false) goto L39;
        return "RIPEMD256";
    L39:
        if (CryptoProObjectIdentifiers.gostR3411.equals(r100) == false) goto L43;
        return "GOST3411";
    L43:
        return r100.getId();
    }

    public static String getSignatureName(AlgorithmIdentifier r100) {
        ASN1Encodable r101 = r100.getParameters();
        if (r101 == null) goto L15;
        if (derNull.equals(r101) == true) goto L15;
        if (r100.getAlgorithm().equals(PKCSObjectIdentifiers.id_RSASSA_PSS) == false) goto L11;
        return getDigestAlgName(RSASSAPSSparams.getInstance(r101).getHashAlgorithm().getAlgorithm()) + "withRSAandMGF1";
    L11:
        if (r100.getAlgorithm().equals(X9ObjectIdentifiers.ecdsa_with_SHA2) == false) goto L15;
        return getDigestAlgName(ASN1ObjectIdentifier.getInstance(ASN1Sequence.getInstance(r101).getObjectAt(0))) + "withECDSA";
    L15:
        return r100.getAlgorithm().getId();
    }

    public static void setSignatureParameters(Signature r100, ASN1Encodable r101) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        if (r101 != null) goto L4;
        return;
    L4:
        if (derNull.equals(r101) == true) goto L22;
        AlgorithmParameters r102 = AlgorithmParameters.getInstance(r100.getAlgorithm(), r100.getProvider());
        r102.init(r101.toASN1Primitive().getEncoded());     // Catch: IOException -> L14
        if (r100.getAlgorithm().endsWith("MGF1") == false) goto L23;
        r100.setParameter(r102.getParameterSpec(PSSParameterSpec.class));     // Catch: GeneralSecurityException -> L11
        return;
    L11:
        e = move-exception;
        throw new SignatureException("Exception extracting parameters: " + e.getMessage());
    L23:
        return;
    L14:
        e = move-exception;
        throw new SignatureException("IOException decoding parameters: " + e.getMessage());
    }
}
