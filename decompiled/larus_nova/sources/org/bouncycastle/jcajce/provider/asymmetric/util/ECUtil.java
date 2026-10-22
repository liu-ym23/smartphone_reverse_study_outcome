package org.bouncycastle.jcajce.provider.asymmetric.util;

import java.math.BigInteger;
import java.security.AccessController;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.ECNamedCurveTable;
import org.bouncycastle.asn1.x9.X962Parameters;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.crypto.ec.CustomNamedCurves;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECNamedDomainParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.jcajce.provider.config.ProviderConfiguration;
import org.bouncycastle.jce.interfaces.ECPrivateKey;
import org.bouncycastle.jce.interfaces.ECPublicKey;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import org.bouncycastle.jce.spec.ECParameterSpec;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.FixedPointCombMultiplier;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Fingerprint;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes42.dex */
public class ECUtil {
    public ECUtil() {
    }

    public static int[] convertMidTerms(int[] r100) {
        int[] r101 = new int[3];
        if (r100.length != 1) goto L6;
        r101[0] = r100[0];
    L25:
        return r101;
    L6:
        if (r100.length != 3) goto L27;
        int r102 = r100[0];
        int r103 = r100[1];
        if (r102 >= r103) goto L15;
        int r104 = r100[2];
        if (r102 >= r104) goto L15;
        r101[0] = r102;
        if (r103 >= r104) goto L14;
        r101[1] = r103;
        r101[2] = r104;
        goto L25
    L14:
        r101[1] = r104;
        r101[2] = r100[1];
    L15:
        int r105 = r100[2];
        if (r103 >= r105) goto L21;
        r101[0] = r103;
        int r106 = r100[0];
        if (r106 >= r105) goto L20;
        r101[1] = r106;
        r101[2] = r105;
        goto L25
    L20:
        r101[1] = r105;
        r101[2] = r106;
        goto L25
    L21:
        r101[0] = r105;
        int r107 = r100[0];
        if (r107 >= r103) goto L24;
        r101[1] = r107;
        r101[2] = r100[1];
        goto L25
    L24:
        r101[1] = r103;
        r101[2] = r107;
        goto L25
    L27:
        throw new IllegalArgumentException("Only Trinomials and pentanomials supported");
    }

    public static String generateKeyFingerprint(ECPoint r100, ECParameterSpec r101) {
        ECCurve r102 = r101.getCurve();
        ECPoint r103 = r101.getG();
        if (r102 == null) goto L7;
        return new Fingerprint(Arrays.concatenate(r100.getEncoded(false), r102.getA().getEncoded(), r102.getB().getEncoded(), r103.getEncoded(false))).toString();
    L7:
        return new Fingerprint(r100.getEncoded(false)).toString();
    }

    public static AsymmetricKeyParameter generatePrivateKeyParameter(PrivateKey r110) throws InvalidKeyException {
        if ((r110 instanceof ECPrivateKey) == false) goto L14;
        ECPrivateKey r111 = (ECPrivateKey) r110;
        ECParameterSpec r100 = r111.getParameters();
        if (r100 != null) goto L8;
        r100 = BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa();
    L8:
        if ((r111.getParameters() instanceof ECNamedCurveParameterSpec) == false) goto L12;
        return new ECPrivateKeyParameters(r111.getD(), new ECNamedDomainParameters(ECNamedCurveTable.getOID(((ECNamedCurveParameterSpec) r111.getParameters()).getName()), r100.getCurve(), r100.getG(), r100.getN(), r100.getH(), r100.getSeed()));
    L12:
        return new ECPrivateKeyParameters(r111.getD(), new ECDomainParameters(r100.getCurve(), r100.getG(), r100.getN(), r100.getH(), r100.getSeed()));
    L14:
        if ((r110 instanceof java.security.interfaces.ECPrivateKey) == false) goto L30;
        java.security.interfaces.ECPrivateKey r112 = (java.security.interfaces.ECPrivateKey) r110;
        ECParameterSpec r101 = EC5Util.convertSpec(r112.getParams());
        return new ECPrivateKeyParameters(r112.getS(), new ECDomainParameters(r101.getCurve(), r101.getG(), r101.getN(), r101.getH(), r101.getSeed()));
    L30:
        byte[] r113 = r110.getEncoded();     // Catch: Exception -> L27
        if (r113 == null) goto L26;
        PrivateKey r114 = BouncyCastleProvider.getPrivateKey(PrivateKeyInfo.getInstance(r113));     // Catch: Exception -> L27
        if ((r114 instanceof java.security.interfaces.ECPrivateKey) == false) goto L24;
        return generatePrivateKeyParameter(r114);
    L24:
        throw new InvalidKeyException("can't identify EC private key.");
    L26:
        throw new InvalidKeyException("no encoding for EC private key");     // Catch: Exception -> L27
    L27:
        e = move-exception;
        throw new InvalidKeyException("cannot identify EC private key: " + e.toString());
    }

    public static AsymmetricKeyParameter generatePublicKeyParameter(PublicKey r100) throws InvalidKeyException {
        if ((r100 instanceof ECPublicKey) == false) goto L7;
        ECPublicKey r101 = (ECPublicKey) r100;
        ECParameterSpec r102 = r101.getParameters();
        return new ECPublicKeyParameters(r101.getQ(), new ECDomainParameters(r102.getCurve(), r102.getG(), r102.getN(), r102.getH(), r102.getSeed()));
    L7:
        if ((r100 instanceof java.security.interfaces.ECPublicKey) == false) goto L23;
        java.security.interfaces.ECPublicKey r103 = (java.security.interfaces.ECPublicKey) r100;
        ECParameterSpec r104 = EC5Util.convertSpec(r103.getParams());
        return new ECPublicKeyParameters(EC5Util.convertPoint(r103.getParams(), r103.getW()), new ECDomainParameters(r104.getCurve(), r104.getG(), r104.getN(), r104.getH(), r104.getSeed()));
    L23:
        byte[] r105 = r100.getEncoded();     // Catch: Exception -> L20
        if (r105 == null) goto L19;
        PublicKey r106 = BouncyCastleProvider.getPublicKey(SubjectPublicKeyInfo.getInstance(r105));     // Catch: Exception -> L20
        if ((r106 instanceof java.security.interfaces.ECPublicKey) == false) goto L17;
        return generatePublicKeyParameter(r106);
    L17:
        throw new InvalidKeyException("cannot identify EC public key.");
    L19:
        throw new InvalidKeyException("no encoding for EC public key");     // Catch: Exception -> L20
    L20:
        e = move-exception;
        throw new InvalidKeyException("cannot identify EC public key: " + e.toString());
    }

    public static String getCurveName(ASN1ObjectIdentifier r100) {
        return ECNamedCurveTable.getName(r100);
    }

    public static ECDomainParameters getDomainParameters(ProviderConfiguration r100, X962Parameters r101) {
        if (r101.isNamedCurve() == false) goto L9;
        ASN1ObjectIdentifier r102 = ASN1ObjectIdentifier.getInstance(r101.getParameters());
        X9ECParameters r103 = getNamedCurveByOid(r102);
        if (r103 != null) goto L14;
        r103 = (X9ECParameters) r100.getAdditionalECParameters().get(r102);
    L14:
        return new ECNamedDomainParameters(r102, r103);
    L9:
        if (r101.isImplicitlyCA() == false) goto L11;
        ECParameterSpec r104 = r100.getEcImplicitlyCa();
        ECDomainParameters r105 = new ECDomainParameters(r104.getCurve(), r104.getG(), r104.getN(), r104.getH(), r104.getSeed());
    L13:
        return r105;
    L11:
        X9ECParameters r106 = X9ECParameters.getInstance(r101.getParameters());
        r105 = new ECDomainParameters(r106.getCurve(), r106.getG(), r106.getN(), r106.getH(), r106.getSeed());
        goto L13
    }

    public static ECDomainParameters getDomainParameters(ProviderConfiguration r110, ECParameterSpec r111) {
        if ((r111 instanceof ECNamedCurveParameterSpec) == false) goto L5;
        ECNamedCurveParameterSpec r112 = (ECNamedCurveParameterSpec) r111;
        return new ECNamedDomainParameters(getNamedCurveOid(r112.getName()), r112.getCurve(), r112.getG(), r112.getN(), r112.getH(), r112.getSeed());
    L5:
        if (r111 != null) goto L8;
        ECParameterSpec r113 = r110.getEcImplicitlyCa();
        return new ECDomainParameters(r113.getCurve(), r113.getG(), r113.getN(), r113.getH(), r113.getSeed());
    L8:
        return new ECDomainParameters(r111.getCurve(), r111.getG(), r111.getN(), r111.getH(), r111.getSeed());
    }

    public static String getNameFrom(final AlgorithmParameterSpec r100) {
        return (String) AccessController.doPrivileged(new AnonymousClass1(r100));
    }

    public static X9ECParameters getNamedCurveByName(String r100) {
        X9ECParameters r101 = CustomNamedCurves.getByName(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        return ECNamedCurveTable.getByName(r100);
    }

    public static X9ECParameters getNamedCurveByOid(ASN1ObjectIdentifier r100) {
        X9ECParameters r101 = CustomNamedCurves.getByOID(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        return ECNamedCurveTable.getByOID(r100);
    }

    public static ASN1ObjectIdentifier getNamedCurveOid(String r100) {
        int r101 = r100.indexOf(32);
        if (r101 <= 0) goto L15;
        r100 = r100.substring(r101 + 1);
    L15:
        if (r100.charAt(0) < '0') goto L13;
        if (r100.charAt(0) > '2') goto L13;
        return new ASN1ObjectIdentifier(r100);
    L13:
        return ECNamedCurveTable.getOID(r100);
    }

    public static ASN1ObjectIdentifier getNamedCurveOid(ECParameterSpec r100) {
        Enumeration r101 = ECNamedCurveTable.getNames();
    L4:
        if (r101.hasMoreElements() == false) goto L15;
        String r102 = (String) r101.nextElement();
        X9ECParameters r103 = ECNamedCurveTable.getByName(r102);
        if (r103.getN().equals(r100.getN()) == false) goto L4;
        if (r103.getH().equals(r100.getH()) == false) goto L4;
        if (r103.getCurve().equals(r100.getCurve()) == false) goto L4;
        if (r103.getG().equals(r100.getG()) == false) goto L4;
        return ECNamedCurveTable.getOID(r102);
    L15:
        return null;
    }

    public static int getOrderBitLength(ProviderConfiguration r100, BigInteger r101, BigInteger r102) {
        if (r101 != null) goto L10;
        ECParameterSpec r103 = r100.getEcImplicitlyCa();
        if (r103 != null) goto L8;
        return r102.bitLength();
    L8:
        return r103.getN().bitLength();
    L10:
        return r101.bitLength();
    }

    public static String privateKeyToString(String r100, BigInteger r101, ECParameterSpec r102) {
        StringBuffer r103 = new StringBuffer();
        String r104 = Strings.lineSeparator();
        ECPoint r105 = new FixedPointCombMultiplier().multiply(r102.getG(), r101).normalize();
        r103.append(r100);
        r103.append(" Private Key [");
        r103.append(generateKeyFingerprint(r105, r102));
        r103.append("]");
        r103.append(r104);
        r103.append("            X: ");
        r103.append(r105.getAffineXCoord().toBigInteger().toString(16));
        r103.append(r104);
        r103.append("            Y: ");
        r103.append(r105.getAffineYCoord().toBigInteger().toString(16));
        r103.append(r104);
        return r103.toString();
    }

    public static String publicKeyToString(String r100, ECPoint r101, ECParameterSpec r102) {
        StringBuffer r103 = new StringBuffer();
        String r104 = Strings.lineSeparator();
        r103.append(r100);
        r103.append(" Public Key [");
        r103.append(generateKeyFingerprint(r101, r102));
        r103.append("]");
        r103.append(r104);
        r103.append("            X: ");
        r103.append(r101.getAffineXCoord().toBigInteger().toString(16));
        r103.append(r104);
        r103.append("            Y: ");
        r103.append(r101.getAffineYCoord().toBigInteger().toString(16));
        r103.append(r104);
        return r103.toString();
    }
}
