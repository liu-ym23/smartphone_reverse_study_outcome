package org.bouncycastle.jcajce.provider.asymmetric.util;

import java.math.BigInteger;
import java.security.spec.ECField;
import java.security.spec.ECFieldF2m;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.cryptopro.ECGOST3410NamedCurves;
import org.bouncycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import org.bouncycastle.asn1.x9.ECNamedCurveTable;
import org.bouncycastle.asn1.x9.X962Parameters;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.crypto.ec.CustomNamedCurves;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.jcajce.provider.config.ProviderConfiguration;
import org.bouncycastle.jce.ECGOST3410NamedCurveTable;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import org.bouncycastle.jce.spec.ECNamedCurveSpec;
import org.bouncycastle.math.ec.ECAlgorithms;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.field.FiniteField;
import org.bouncycastle.math.field.Polynomial;
import org.bouncycastle.math.field.PolynomialExtensionField;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class EC5Util {
    private static Map customCurves;

    static {
        customCurves = new HashMap();
        Enumeration r100 = CustomNamedCurves.getNames();
    L4:
        if (r100.hasMoreElements() == false) goto L8;
        String r101 = (String) r100.nextElement();
        X9ECParameters r102 = ECNamedCurveTable.getByName(r101);
        if (r102 == null) goto L4;
        customCurves.put(r102.getCurve(), CustomNamedCurves.getByName(r101).getCurve());
        goto L4
    L8:
        ECCurve r103 = CustomNamedCurves.getByName("Curve25519").getCurve();
        customCurves.put(new ECCurve.Fp(r103.getField().getCharacteristic(), r103.getA().toBigInteger(), r103.getB().toBigInteger(), r103.getOrder(), r103.getCofactor()), r103);
    }

    public EC5Util() {
    }

    public static EllipticCurve convertCurve(ECCurve r100, byte[] r101) {
        return new EllipticCurve(convertField(r100.getField()), r100.getA().toBigInteger(), r100.getB().toBigInteger(), null);
    }

    public static ECCurve convertCurve(EllipticCurve r100) {
        ECField r101 = r100.getField();
        BigInteger r102 = r100.getA();
        BigInteger r103 = r100.getB();
        if ((r101 instanceof ECFieldFp) == false) goto L8;
        ECCurve.Fp r104 = new ECCurve.Fp(((ECFieldFp) r101).getP(), r102, r103);
        if (customCurves.containsKey(r104) == true) goto L7;
        return r104;
    L7:
        return (ECCurve) customCurves.get(r104);
    L8:
        ECFieldF2m r105 = (ECFieldF2m) r101;
        int r106 = r105.getM();
        int[] r107 = ECUtil.convertMidTerms(r105.getMidTermsOfReductionPolynomial());
        return new ECCurve.F2m(r106, r107[0], r107[1], r107[2], r102, r103);
    }

    public static ECField convertField(FiniteField r100) {
        if (ECAlgorithms.isFpField(r100) == true) goto L5;
        Polynomial r101 = ((PolynomialExtensionField) r100).getMinimalPolynomial();
        int[] r102 = r101.getExponentsPresent();
        int[] r103 = Arrays.reverse(Arrays.copyOfRange(r102, 1, r102.length - 1));
        return new ECFieldF2m(r101.getDegree(), r103);
    L5:
        return new ECFieldFp(r100.getCharacteristic());
    }

    public static ECPoint convertPoint(org.bouncycastle.math.ec.ECPoint r100) {
        org.bouncycastle.math.ec.ECPoint r101 = r100.normalize();
        return new ECPoint(r101.getAffineXCoord().toBigInteger(), r101.getAffineYCoord().toBigInteger());
    }

    public static org.bouncycastle.math.ec.ECPoint convertPoint(ECParameterSpec r100, ECPoint r101) {
        return convertPoint(convertCurve(r100.getCurve()), r101);
    }

    public static org.bouncycastle.math.ec.ECPoint convertPoint(ECCurve r100, ECPoint r101) {
        return r100.createPoint(r101.getAffineX(), r101.getAffineY());
    }

    public static ECParameterSpec convertSpec(EllipticCurve r100, org.bouncycastle.jce.spec.ECParameterSpec r101) {
        ECPoint r102 = convertPoint(r101.getG());
        if ((r101 instanceof ECNamedCurveParameterSpec) == false) goto L7;
        return new ECNamedCurveSpec(((ECNamedCurveParameterSpec) r101).getName(), r100, r102, r101.getN(), r101.getH());
    L7:
        return new ECParameterSpec(r100, r102, r101.getN(), r101.getH().intValue());
    }

    public static org.bouncycastle.jce.spec.ECParameterSpec convertSpec(ECParameterSpec r100) {
        ECCurve r101 = convertCurve(r100.getCurve());
        org.bouncycastle.math.ec.ECPoint r102 = convertPoint(r101, r100.getGenerator());
        BigInteger r103 = r100.getOrder();
        BigInteger r104 = BigInteger.valueOf(r100.getCofactor());
        byte[] r105 = r100.getCurve().getSeed();
        if ((r100 instanceof ECNamedCurveSpec) == false) goto L7;
        return new ECNamedCurveParameterSpec(((ECNamedCurveSpec) r100).getName(), r101, r102, r103, r104, r105);
    L7:
        return new org.bouncycastle.jce.spec.ECParameterSpec(r101, r102, r103, r104, r105);
    }

    public static ECParameterSpec convertToSpec(X962Parameters r100, ECCurve r101) {
        if (r100.isNamedCurve() == false) goto L11;
        ASN1ObjectIdentifier r102 = (ASN1ObjectIdentifier) r100.getParameters();
        X9ECParameters r103 = ECUtil.getNamedCurveByOid(r102);
        if (r103 != null) goto L9;
        Map r104 = BouncyCastleProvider.CONFIGURATION.getAdditionalECParameters();
        if (r104.isEmpty() == true) goto L9;
        r103 = (X9ECParameters) r104.get(r102);
    L9:
        EllipticCurve r105 = convertCurve(r101, r103.getSeed());
        return new ECNamedCurveSpec(ECUtil.getCurveName(r102), r105, convertPoint(r103.getG()), r103.getN(), r103.getH());
    L11:
        if (r100.isImplicitlyCA() == false) goto L13;
        return null;
    L13:
        ASN1Sequence r106 = ASN1Sequence.getInstance(r100.getParameters());
        if (r106.size() <= 3) goto L19;
        X9ECParameters r107 = X9ECParameters.getInstance(r106);
        EllipticCurve r108 = convertCurve(r101, r107.getSeed());
        if (r107.getH() == null) goto L18;
        ECParameterSpec r109 = new ECParameterSpec(r108, convertPoint(r107.getG()), r107.getN(), r107.getH().intValue());
    L21:
        return r109;
    L18:
        r109 = new ECParameterSpec(r108, convertPoint(r107.getG()), r107.getN(), 1);
        goto L21
    L19:
        GOST3410PublicKeyAlgParameters r110 = GOST3410PublicKeyAlgParameters.getInstance(r106);
        ECNamedCurveParameterSpec r111 = ECGOST3410NamedCurveTable.getParameterSpec(ECGOST3410NamedCurves.getName(r110.getPublicKeyParamSet()));
        EllipticCurve r112 = convertCurve(r111.getCurve(), r111.getSeed());
        r109 = new ECNamedCurveSpec(ECGOST3410NamedCurves.getName(r110.getPublicKeyParamSet()), r112, convertPoint(r111.getG()), r111.getN(), r111.getH());
        goto L21
    }

    public static ECParameterSpec convertToSpec(X9ECParameters r100) {
        return new ECParameterSpec(convertCurve(r100.getCurve(), null), convertPoint(r100.getG()), r100.getN(), r100.getH().intValue());
    }

    public static ECParameterSpec convertToSpec(ECDomainParameters r100) {
        return new ECParameterSpec(convertCurve(r100.getCurve(), null), convertPoint(r100.getG()), r100.getN(), r100.getH().intValue());
    }

    public static ECCurve getCurve(ProviderConfiguration r100, X962Parameters r101) {
        Set r102 = r100.getAcceptableNamedCurves();
        if (r101.isNamedCurve() == false) goto L16;
        ASN1ObjectIdentifier r103 = ASN1ObjectIdentifier.getInstance(r101.getParameters());
        if (r102.isEmpty() == false) goto L7;
    L11:
        X9ECParameters r104 = ECUtil.getNamedCurveByOid(r103);
        if (r104 != null) goto L28;
        r104 = (X9ECParameters) r100.getAdditionalECParameters().get(r103);
    L28:
        return r104.getCurve();
    L7:
        if (r102.contains(r103) == true) goto L11;
        throw new IllegalStateException("named curve not acceptable");
    L16:
        if (r101.isImplicitlyCA() == true) goto L29;
        ASN1Sequence r105 = ASN1Sequence.getInstance(r101.getParameters());
        if (r102.isEmpty() == false) goto L27;
        if (r105.size() <= 3) goto L23;
        X9ECParameters r106 = X9ECParameters.getInstance(r105);
    L25:
        return r106.getCurve();
    L23:
        r106 = ECGOST3410NamedCurves.getByOIDX9(ASN1ObjectIdentifier.getInstance(r105.getObjectAt(0)));
        goto L25
    L27:
        throw new IllegalStateException("encoded parameters not acceptable");
    L29:
        return r100.getEcImplicitlyCa().getCurve();
    }

    public static ECDomainParameters getDomainParameters(ProviderConfiguration r100, ECParameterSpec r101) {
        if (r101 != null) goto L5;
        org.bouncycastle.jce.spec.ECParameterSpec r102 = r100.getEcImplicitlyCa();
        return new ECDomainParameters(r102.getCurve(), r102.getG(), r102.getN(), r102.getH(), r102.getSeed());
    L5:
        return ECUtil.getDomainParameters(r100, convertSpec(r101));
    }
}
