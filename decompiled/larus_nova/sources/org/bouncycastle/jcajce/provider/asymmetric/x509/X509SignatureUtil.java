package org.bouncycastle.jcajce.provider.asymmetric.x509;

import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.PSSParameterSpec;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Null;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.edec.EdECObjectIdentifiers;
import org.bouncycastle.asn1.misc.MiscObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.RSASSAPSSparams;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.jcajce.spec.EdDSAParameterSpec;
import org.bouncycastle.jcajce.util.MessageDigestUtils;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes42.dex */
class X509SignatureUtil {
    private static final Map<ASN1ObjectIdentifier, String> algNames = null;
    private static final ASN1Null derNull = null;

    static {
        HashMap r100 = new HashMap();
        algNames = r100;
        r100.put(EdECObjectIdentifiers.id_Ed25519, EdDSAParameterSpec.Ed25519);
        r100.put(EdECObjectIdentifiers.id_Ed448, EdDSAParameterSpec.Ed448);
        r100.put(OIWObjectIdentifiers.dsaWithSHA1, "SHA1withDSA");
        r100.put(X9ObjectIdentifiers.id_dsa_with_sha1, "SHA1withDSA");
        derNull = DERNull.INSTANCE;
    }

    public X509SignatureUtil() {
    }

    private static String findAlgName(ASN1ObjectIdentifier r100) {
        Provider r101 = Security.getProvider("BC");
        if (r101 == null) goto L7;
        String r102 = lookupAlg(r101, r100);
        if (r102 == null) goto L7;
        return r102;
    L7:
        Provider[] r103 = Security.getProviders();
        int r104 = 0;
    L9:
        if (r104 == r103.length) goto L17;
        Provider r105 = r103[r104];
        if (r101 == r105) goto L15;
        String r106 = lookupAlg(r105, r100);
        if (r106 == null) goto L15;
        return r106;
    L15:
        r104 = r104 + 1;
        goto L9
    L17:
        return r100.getId();
    }

    private static String getDigestAlgName(ASN1ObjectIdentifier r100) {
        String r101 = MessageDigestUtils.getDigestName(r100);
        int r102 = r101.indexOf(45);
        if (r102 > 0) goto L5;
        return r101;
    L5:
        if (r101.startsWith("SHA3") == false) goto L7;
        return r101;
    L7:
        return r101.substring(0, r102) + r101.substring(r102 + 1);
    }

    public static String getSignatureName(AlgorithmIdentifier r100) {
        ASN1Encodable r101 = r100.getParameters();
        if (r101 != null) goto L5;
    L14:
        String r102 = algNames.get(r100.getAlgorithm());
        if (r102 == null) goto L18;
        return r102;
    L18:
        return findAlgName(r100.getAlgorithm());
    L5:
        if (derNull.equals(r101) == true) goto L14;
        if (r100.getAlgorithm().equals(PKCSObjectIdentifiers.id_RSASSA_PSS) == false) goto L11;
        return getDigestAlgName(RSASSAPSSparams.getInstance(r101).getHashAlgorithm().getAlgorithm()) + "withRSAandMGF1";
    L11:
        if (r100.getAlgorithm().equals(X9ObjectIdentifiers.ecdsa_with_SHA2) == false) goto L14;
        return getDigestAlgName((ASN1ObjectIdentifier) ASN1Sequence.getInstance(r101).getObjectAt(0)) + "withECDSA";
    }

    public static boolean isCompositeAlgorithm(AlgorithmIdentifier r100) {
        return MiscObjectIdentifiers.id_alg_composite.equals(r100.getAlgorithm());
    }

    private static String lookupAlg(Provider r100, ASN1ObjectIdentifier r101) {
        String r102 = r100.getProperty("Alg.Alias.Signature." + r101);
        if (r102 == null) goto L5;
        return r102;
    L5:
        String r103 = r100.getProperty("Alg.Alias.Signature.OID." + r101);
        if (r103 == null) goto L8;
        return r103;
    L8:
        return null;
    }

    public static void prettyPrintSignature(byte[] r100, StringBuffer r101, String r102) {
        int r103 = r100.length;
        r101.append("            Signature: ");
        if (r103 <= 20) goto L12;
        r101.append(Hex.toHexString(r100, 0, 20));
        r101.append(r102);
        int r104 = 20;
    L6:
        if (r104 >= r100.length) goto L17;
        int r105 = r100.length - 20;
        r101.append("                       ");
        if (r104 >= r105) goto L10;
        String r106 = Hex.toHexString(r100, r104, 20);
    L11:
        r101.append(r106);
        r101.append(r102);
        r104 = r104 + 20;
        goto L6
    L10:
        r106 = Hex.toHexString(r100, r104, r100.length - r104);
        goto L11
    L17:
        return;
    L12:
        r101.append(Hex.toHexString(r100));
        r101.append(r102);
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
