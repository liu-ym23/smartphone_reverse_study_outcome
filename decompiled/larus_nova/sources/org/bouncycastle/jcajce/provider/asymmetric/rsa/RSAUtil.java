package org.bouncycastle.jcajce.provider.asymmetric.rsa;

import java.math.BigInteger;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters;
import org.bouncycastle.util.Fingerprint;

/* JADX INFO: loaded from: classes42.dex */
public class RSAUtil {
    public static final ASN1ObjectIdentifier[] rsaOids = null;

    static {
        rsaOids = new ASN1ObjectIdentifier[]{PKCSObjectIdentifiers.rsaEncryption, X509ObjectIdentifiers.id_ea_rsa, PKCSObjectIdentifiers.id_RSAES_OAEP, PKCSObjectIdentifiers.id_RSASSA_PSS};
    }

    public RSAUtil() {
    }

    public static String generateExponentFingerprint(BigInteger r100) {
        return new Fingerprint(r100.toByteArray(), 32).toString();
    }

    public static String generateKeyFingerprint(BigInteger r100) {
        return new Fingerprint(r100.toByteArray()).toString();
    }

    public static RSAKeyParameters generatePrivateKeyParameter(RSAPrivateKey r110) {
        if ((r110 instanceof BCRSAPrivateKey) == false) goto L7;
        return ((BCRSAPrivateKey) r110).engineGetKeyParameters();
    L7:
        if ((r110 instanceof RSAPrivateCrtKey) == false) goto L11;
        RSAPrivateCrtKey r111 = (RSAPrivateCrtKey) r110;
        return new RSAPrivateCrtKeyParameters(r111.getModulus(), r111.getPublicExponent(), r111.getPrivateExponent(), r111.getPrimeP(), r111.getPrimeQ(), r111.getPrimeExponentP(), r111.getPrimeExponentQ(), r111.getCrtCoefficient());
    L11:
        return new RSAKeyParameters(true, r110.getModulus(), r110.getPrivateExponent());
    }

    public static RSAKeyParameters generatePublicKeyParameter(RSAPublicKey r100) {
        if ((r100 instanceof BCRSAPublicKey) == false) goto L7;
        return ((BCRSAPublicKey) r100).engineGetKeyParameters();
    L7:
        return new RSAKeyParameters(false, r100.getModulus(), r100.getPublicExponent());
    }

    public static boolean isRsaOid(ASN1ObjectIdentifier r100) {
        int r101 = 0;
    L3:
        ASN1ObjectIdentifier[] r102 = rsaOids;
        if (r101 == r102.length) goto L10;
        if (r100.equals(r102[r101]) == true) goto L7;
        r101 = r101 + 1;
        goto L3
    L7:
        return true;
    L10:
        return false;
    }
}
