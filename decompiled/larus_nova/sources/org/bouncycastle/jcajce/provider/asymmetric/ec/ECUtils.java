package org.bouncycastle.jcajce.provider.asymmetric.ec;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.PublicKey;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.x9.X962Parameters;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.asn1.x9.X9ECPoint;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.bouncycastle.jce.spec.ECNamedCurveSpec;
import org.bouncycastle.math.ec.ECCurve;

/* JADX INFO: loaded from: classes42.dex */
class ECUtils {
    public ECUtils() {
    }

    public static AsymmetricKeyParameter generatePublicKeyParameter(PublicKey r100) throws InvalidKeyException {
        if ((r100 instanceof BCECPublicKey) == false) goto L6;
        return ((BCECPublicKey) r100).engineGetKeyParameters();
    L6:
        return ECUtil.generatePublicKeyParameter(r100);
    }

    public static X9ECParameters getDomainParametersFromGenSpec(ECGenParameterSpec r100) {
        return getDomainParametersFromName(r100.getName());
    }

    public static X962Parameters getDomainParametersFromName(ECParameterSpec r100, boolean r101) {
        if ((r100 instanceof ECNamedCurveSpec) == false) goto L8;
        ECNamedCurveSpec r102 = (ECNamedCurveSpec) r100;
        ASN1ObjectIdentifier r103 = ECUtil.getNamedCurveOid(r102.getName());
        if (r103 != null) goto L12;
        r103 = new ASN1ObjectIdentifier(r102.getName());
    L12:
        return new X962Parameters(r103);
    L8:
        if (r100 == null) goto L13;
        ECCurve r104 = EC5Util.convertCurve(r100.getCurve());
        return new X962Parameters(new X9ECParameters(r104, new X9ECPoint(EC5Util.convertPoint(r104, r100.getGenerator()), r101), r100.getOrder(), BigInteger.valueOf(r100.getCofactor()), r100.getCurve().getSeed()));
    L13:
        return new X962Parameters(DERNull.INSTANCE);
    }

    public static X9ECParameters getDomainParametersFromName(String r100) {
        if (r100.charAt(0) < '0') goto L9;
        if (r100.charAt(0) > '2') goto L9;
        return ECUtil.getNamedCurveByOid(new ASN1ObjectIdentifier(r100));
    L9:
        if (r100.indexOf(32) <= 0) goto L17;
        r100 = r100.substring(r100.indexOf(32) + 1);     // Catch: IllegalArgumentException -> L13
    L17:
        return ECUtil.getNamedCurveByName(r100);
    L14:
        return ECUtil.getNamedCurveByName(r100);
    }
}
