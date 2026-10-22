package org.bouncycastle.jcajce.provider.asymmetric.dsa;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.DSAPublicKey;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.DSAParameters;
import org.bouncycastle.crypto.params.DSAPrivateKeyParameters;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Fingerprint;

/* JADX INFO: loaded from: classes42.dex */
public class DSAUtil {
    public static final ASN1ObjectIdentifier[] dsaOids = null;

    static {
        dsaOids = new ASN1ObjectIdentifier[]{X9ObjectIdentifiers.id_dsa, OIWObjectIdentifiers.dsaWithSHA1, X9ObjectIdentifiers.id_dsa_with_sha1};
    }

    public DSAUtil() {
    }

    public static String generateKeyFingerprint(BigInteger r100, DSAParams r101) {
        return new Fingerprint(Arrays.concatenate(r100.toByteArray(), r101.getP().toByteArray(), r101.getQ().toByteArray(), r101.getG().toByteArray())).toString();
    }

    public static AsymmetricKeyParameter generatePrivateKeyParameter(PrivateKey r100) throws InvalidKeyException {
        if ((r100 instanceof DSAPrivateKey) == false) goto L7;
        DSAPrivateKey r101 = (DSAPrivateKey) r100;
        return new DSAPrivateKeyParameters(r101.getX(), new DSAParameters(r101.getParams().getP(), r101.getParams().getQ(), r101.getParams().getG()));
    L7:
        throw new InvalidKeyException("can't identify DSA private key.");
    }

    public static AsymmetricKeyParameter generatePublicKeyParameter(PublicKey r100) throws InvalidKeyException {
        if ((r100 instanceof BCDSAPublicKey) == false) goto L7;
        return ((BCDSAPublicKey) r100).engineGetKeyParameters();
    L7:
        if ((r100 instanceof DSAPublicKey) == true) goto L9;
        return new BCDSAPublicKey(SubjectPublicKeyInfo.getInstance(r100.getEncoded())).engineGetKeyParameters();
    L13:
        throw new InvalidKeyException("can't identify DSA public key: ".concat(r100.getClass().getName()));
    L9:
        return new BCDSAPublicKey((DSAPublicKey) r100).engineGetKeyParameters();
    }

    public static boolean isDsaOid(ASN1ObjectIdentifier r100) {
        int r101 = 0;
    L3:
        ASN1ObjectIdentifier[] r102 = dsaOids;
        if (r101 == r102.length) goto L10;
        if (r100.equals(r102[r101]) == true) goto L7;
        r101 = r101 + 1;
        goto L3
    L7:
        return true;
    L10:
        return false;
    }

    public static DSAParameters toDSAParameters(DSAParams r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        return new DSAParameters(r100.getP(), r100.getQ(), r100.getG());
    }
}
