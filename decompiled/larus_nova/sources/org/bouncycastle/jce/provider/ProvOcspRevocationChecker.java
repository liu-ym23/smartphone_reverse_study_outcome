package org.bouncycastle.jce.provider;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.CertPathValidatorException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1String;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.bsi.BSIObjectIdentifiers;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.eac.EACObjectIdentifiers;
import org.bouncycastle.asn1.isara.IsaraObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.ocsp.BasicOCSPResponse;
import org.bouncycastle.asn1.ocsp.CertID;
import org.bouncycastle.asn1.ocsp.OCSPObjectIdentifiers;
import org.bouncycastle.asn1.ocsp.OCSPResponse;
import org.bouncycastle.asn1.ocsp.ResponderID;
import org.bouncycastle.asn1.ocsp.ResponseBytes;
import org.bouncycastle.asn1.ocsp.ResponseData;
import org.bouncycastle.asn1.ocsp.RevokedInfo;
import org.bouncycastle.asn1.ocsp.SingleResponse;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.RSASSAPSSparams;
import org.bouncycastle.asn1.rosstandart.RosstandartObjectIdentifiers;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.X500NameStyle;
import org.bouncycastle.asn1.x500.style.BCStrictStyle;
import org.bouncycastle.asn1.x509.AccessDescription;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.AuthorityInformationAccess;
import org.bouncycastle.asn1.x509.Certificate;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.KeyPurposeId;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.jcajce.PKIXCertRevocationChecker;
import org.bouncycastle.jcajce.PKIXCertRevocationCheckerParameters;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jcajce.util.MessageDigestUtils;
import org.bouncycastle.jce.exception.ExtCertPathValidatorException;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Properties;

/* JADX INFO: loaded from: classes42.dex */
class ProvOcspRevocationChecker implements PKIXCertRevocationChecker {
    private static final int DEFAULT_OCSP_MAX_RESPONSE_SIZE = 32768;
    private static final int DEFAULT_OCSP_TIMEOUT = 15000;
    private static final Map oids = null;
    private final JcaJceHelper helper;
    private boolean isEnabledOCSP;
    private String ocspURL;
    private PKIXCertRevocationCheckerParameters parameters;
    private final ProvRevocationChecker parent;

    static {
        HashMap r100 = new HashMap();
        oids = r100;
        r100.put(new ASN1ObjectIdentifier("1.2.840.113549.1.1.5"), "SHA1WITHRSA");
        r100.put(PKCSObjectIdentifiers.sha224WithRSAEncryption, "SHA224WITHRSA");
        r100.put(PKCSObjectIdentifiers.sha256WithRSAEncryption, "SHA256WITHRSA");
        r100.put(PKCSObjectIdentifiers.sha384WithRSAEncryption, "SHA384WITHRSA");
        r100.put(PKCSObjectIdentifiers.sha512WithRSAEncryption, "SHA512WITHRSA");
        r100.put(CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_94, "GOST3411WITHGOST3410");
        r100.put(CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_2001, "GOST3411WITHECGOST3410");
        r100.put(RosstandartObjectIdentifiers.id_tc26_signwithdigest_gost_3410_12_256, "GOST3411-2012-256WITHECGOST3410-2012-256");
        r100.put(RosstandartObjectIdentifiers.id_tc26_signwithdigest_gost_3410_12_512, "GOST3411-2012-512WITHECGOST3410-2012-512");
        r100.put(BSIObjectIdentifiers.ecdsa_plain_SHA1, "SHA1WITHPLAIN-ECDSA");
        r100.put(BSIObjectIdentifiers.ecdsa_plain_SHA224, "SHA224WITHPLAIN-ECDSA");
        r100.put(BSIObjectIdentifiers.ecdsa_plain_SHA256, "SHA256WITHPLAIN-ECDSA");
        r100.put(BSIObjectIdentifiers.ecdsa_plain_SHA384, "SHA384WITHPLAIN-ECDSA");
        r100.put(BSIObjectIdentifiers.ecdsa_plain_SHA512, "SHA512WITHPLAIN-ECDSA");
        r100.put(BSIObjectIdentifiers.ecdsa_plain_RIPEMD160, "RIPEMD160WITHPLAIN-ECDSA");
        r100.put(EACObjectIdentifiers.id_TA_ECDSA_SHA_1, "SHA1WITHCVC-ECDSA");
        r100.put(EACObjectIdentifiers.id_TA_ECDSA_SHA_224, "SHA224WITHCVC-ECDSA");
        r100.put(EACObjectIdentifiers.id_TA_ECDSA_SHA_256, "SHA256WITHCVC-ECDSA");
        r100.put(EACObjectIdentifiers.id_TA_ECDSA_SHA_384, "SHA384WITHCVC-ECDSA");
        r100.put(EACObjectIdentifiers.id_TA_ECDSA_SHA_512, "SHA512WITHCVC-ECDSA");
        r100.put(IsaraObjectIdentifiers.id_alg_xmss, "XMSS");
        r100.put(IsaraObjectIdentifiers.id_alg_xmssmt, "XMSSMT");
        r100.put(new ASN1ObjectIdentifier("1.2.840.113549.1.1.4"), "MD5WITHRSA");
        r100.put(new ASN1ObjectIdentifier("1.2.840.113549.1.1.2"), "MD2WITHRSA");
        r100.put(new ASN1ObjectIdentifier("1.2.840.10040.4.3"), "SHA1WITHDSA");
        r100.put(X9ObjectIdentifiers.ecdsa_with_SHA1, "SHA1WITHECDSA");
        r100.put(X9ObjectIdentifiers.ecdsa_with_SHA224, "SHA224WITHECDSA");
        r100.put(X9ObjectIdentifiers.ecdsa_with_SHA256, "SHA256WITHECDSA");
        r100.put(X9ObjectIdentifiers.ecdsa_with_SHA384, "SHA384WITHECDSA");
        r100.put(X9ObjectIdentifiers.ecdsa_with_SHA512, "SHA512WITHECDSA");
        r100.put(OIWObjectIdentifiers.sha1WithRSA, "SHA1WITHRSA");
        r100.put(OIWObjectIdentifiers.dsaWithSHA1, "SHA1WITHDSA");
        r100.put(NISTObjectIdentifiers.dsa_with_sha224, "SHA224WITHDSA");
        r100.put(NISTObjectIdentifiers.dsa_with_sha256, "SHA256WITHDSA");
    }

    public ProvOcspRevocationChecker(ProvRevocationChecker r100, JcaJceHelper r101) {
        this.parent = r100;
        this.helper = r101;
    }

    private static byte[] calcKeyHash(MessageDigest r100, PublicKey r101) {
        return r100.digest(SubjectPublicKeyInfo.getInstance(r101.getEncoded()).getPublicKeyData().getBytes());
    }

    private CertID createCertID(CertID r100, Certificate r101, ASN1Integer r102) throws CertPathValidatorException {
        return createCertID(r100.getHashAlgorithm(), r101, r102);
    }

    private CertID createCertID(AlgorithmIdentifier r100, Certificate r101, ASN1Integer r102) throws CertPathValidatorException {
        MessageDigest r103 = this.helper.createMessageDigest(MessageDigestUtils.getDigestName(r100.getAlgorithm()));     // Catch: Exception -> L4
        return new CertID(r100, new DEROctetString(r103.digest(r101.getSubject().getEncoded(ASN1Encoding.DER))), new DEROctetString(r103.digest(r101.getSubjectPublicKeyInfo().getPublicKeyData().getBytes())), r102);
    L4:
        e = move-exception;
        throw new CertPathValidatorException("problem creating ID: " + e, e);
    }

    private Certificate extractCert() throws CertPathValidatorException {
        return Certificate.getInstance(this.parameters.getSigningCert().getEncoded());
    L4:
        e = move-exception;
        throw new CertPathValidatorException("cannot process signing cert: " + e.getMessage(), e, this.parameters.getCertPath(), this.parameters.getIndex());
    }

    private static String getDigestName(ASN1ObjectIdentifier r100) {
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

    public static URI getOcspResponderURI(X509Certificate r100) {
        byte[] r101 = r100.getExtensionValue(Extension.authorityInfoAccess.getId());
        if (r101 != null) goto L5;
        return null;
    L5:
        AccessDescription[] r102 = AuthorityInformationAccess.getInstance(ASN1OctetString.getInstance(r101).getOctets()).getAccessDescriptions();
        int r103 = 0;
    L7:
        if (r103 == r102.length) goto L15;
        AccessDescription r104 = r102[r103];
        if (AccessDescription.id_ad_ocsp.equals(r104.getAccessMethod()) == false) goto L14;
        GeneralName r105 = r104.getAccessLocation();
        if (r105.getTagNo() != 6) goto L14;
        return new URI(((ASN1String) r105.getName()).getString());
    L14:
        r103 = r103 + 1;
        goto L7
    L15:
        return null;
    }

    private static String getSignatureName(AlgorithmIdentifier r100) {
        ASN1Encodable r101 = r100.getParameters();
        if (r101 != null) goto L5;
    L10:
        Map r102 = oids;
        boolean r103 = r102.containsKey(r100.getAlgorithm());
        ASN1ObjectIdentifier r104 = r100.getAlgorithm();
        if (r103 == false) goto L15;
        return (String) r102.get(r104);
    L15:
        return r104.getId();
    L5:
        if (DERNull.INSTANCE.equals(r101) == true) goto L10;
        if (r100.getAlgorithm().equals(PKCSObjectIdentifiers.id_RSASSA_PSS) == false) goto L10;
        return getDigestName(RSASSAPSSparams.getInstance(r101).getHashAlgorithm().getAlgorithm()) + "WITHRSAANDMGF1";
    }

    private static X509Certificate getSignerCert(BasicOCSPResponse r100, X509Certificate r101, X509Certificate r102, JcaJceHelper r103) throws NoSuchProviderException, NoSuchAlgorithmException {
        ResponderID r104 = r100.getTbsResponseData().getResponderID();
        byte[] r105 = r104.getKeyHash();
        if (r105 == null) goto L13;
        MessageDigest r106 = r103.createMessageDigest("SHA1");
        if (r102 != null) goto L7;
    L9:
        if (r101 != null) goto L11;
        return null;
    L11:
        if (Arrays.areEqual(r105, calcKeyHash(r106, r101.getPublicKey())) == false) goto L24;
        return r101;
    L24:
        return null;
    L7:
        if (Arrays.areEqual(r105, calcKeyHash(r106, r102.getPublicKey())) == false) goto L9;
        return r102;
    L13:
        X500NameStyle r107 = BCStrictStyle.INSTANCE;
        X500Name r108 = X500Name.getInstance(r107, r104.getName());
        if (r102 != null) goto L16;
    L18:
        if (r101 != null) goto L20;
        return null;
    L20:
        if (r108.equals(X500Name.getInstance(r107, r101.getSubjectX500Principal().getEncoded())) == false) goto L26;
        return r101;
    L26:
        return null;
    L16:
        if (r108.equals(X500Name.getInstance(r107, r102.getSubjectX500Principal().getEncoded())) == false) goto L18;
        return r102;
    }

    private static boolean responderMatches(ResponderID r100, X509Certificate r101, JcaJceHelper r102) throws NoSuchProviderException, NoSuchAlgorithmException {
        byte[] r103 = r100.getKeyHash();
        if (r103 != null) goto L5;
        X500NameStyle r104 = BCStrictStyle.INSTANCE;
        return X500Name.getInstance(r104, r100.getName()).equals(X500Name.getInstance(r104, r101.getSubjectX500Principal().getEncoded()));
    L5:
        return Arrays.areEqual(r103, calcKeyHash(r102.createMessageDigest("SHA1"), r101.getPublicKey()));
    }

    public static boolean validatedOcspResponse(BasicOCSPResponse r100, PKIXCertRevocationCheckerParameters r101, byte[] r102, X509Certificate r103, JcaJceHelper r110) throws CertPathValidatorException {
        ASN1Sequence r104 = r100.getCerts();     // Catch: IOException -> L34 GeneralSecurityException -> L37 CertPathValidatorException -> L40
        Signature r105 = r110.createSignature(getSignatureName(r100.getSignatureAlgorithm()));     // Catch: IOException -> L34 GeneralSecurityException -> L37 CertPathValidatorException -> L40
        X509Certificate r106 = getSignerCert(r100, r101.getSigningCert(), r103, r110);     // Catch: IOException -> L34 GeneralSecurityException -> L37 CertPathValidatorException -> L40
        if (r106 != null) goto L10;
        if (r104 != null) goto L10;
        throw new CertPathValidatorException("OCSP responder certificate not found");     // Catch: IOException -> L34 GeneralSecurityException -> L37 CertPathValidatorException -> L40
    L10:
        if (r106 == null) goto L12;
        r105.initVerify(r106.getPublicKey());     // Catch: IOException -> L34 GeneralSecurityException -> L37 CertPathValidatorException -> L40
    L19:
        r105.update(r100.getTbsResponseData().getEncoded(ASN1Encoding.DER));     // Catch: IOException -> L34 GeneralSecurityException -> L37 CertPathValidatorException -> L40
        if (r105.verify(r100.getSignature().getBytes()) == false) goto L29;
        if (r102 != null) goto L23;
        return true;
    L23:
        if (Arrays.areEqual(r102, r100.getTbsResponseData().getResponseExtensions().getExtension(OCSPObjectIdentifiers.id_pkix_ocsp_nonce).getExtnValue().getOctets()) == false) goto L26;
        return true;
    L26:
        throw new CertPathValidatorException("nonce mismatch in OCSP response", null, r101.getCertPath(), r101.getIndex());     // Catch: IOException -> L34 GeneralSecurityException -> L37 CertPathValidatorException -> L40
    L29:
        return false;
    L12:
        X509Certificate r107 = (X509Certificate) r110.createCertificateFactory("X.509").generateCertificate(new ByteArrayInputStream(r104.getObjectAt(0).toASN1Primitive().getEncoded()));     // Catch: IOException -> L34 GeneralSecurityException -> L37 CertPathValidatorException -> L40
        r107.verify(r101.getSigningCert().getPublicKey());     // Catch: IOException -> L34 GeneralSecurityException -> L37 CertPathValidatorException -> L40
        r107.checkValidity(r101.getValidDate());     // Catch: IOException -> L34 GeneralSecurityException -> L37 CertPathValidatorException -> L40
        if (responderMatches(r100.getTbsResponseData().getResponderID(), r107, r110) == false) goto L33;
        List<String> r111 = r107.getExtendedKeyUsage();     // Catch: IOException -> L34 GeneralSecurityException -> L37 CertPathValidatorException -> L40
        if (r111 == null) goto L31;
        if (r111.contains(KeyPurposeId.id_kp_OCSPSigning.getId()) == false) goto L31;
        r105.initVerify(r107);     // Catch: IOException -> L34 GeneralSecurityException -> L37 CertPathValidatorException -> L40
    L31:
        throw new CertPathValidatorException("responder certificate not valid for signing OCSP responses", null, r101.getCertPath(), r101.getIndex());     // Catch: IOException -> L34 GeneralSecurityException -> L37 CertPathValidatorException -> L40
    L33:
        throw new CertPathValidatorException("responder certificate does not match responderID", null, r101.getCertPath(), r101.getIndex());     // Catch: IOException -> L34 GeneralSecurityException -> L37 CertPathValidatorException -> L40
    L34:
        e = move-exception;
        throw new CertPathValidatorException("OCSP response failure: " + e.getMessage(), e, r101.getCertPath(), r101.getIndex());
    L40:
        e = move-exception;
        throw e;
    L37:
        e = move-exception;
        throw new CertPathValidatorException("OCSP response failure: " + e.getMessage(), e, r101.getCertPath(), r101.getIndex());
    }

    @Override // org.bouncycastle.jcajce.PKIXCertRevocationChecker
    public void check(java.security.cert.Certificate r110) throws CertPathValidatorException {
        X509Certificate r111 = (X509Certificate) r110;
        Map<X509Certificate, byte[]> r100 = this.parent.getOcspResponses();
        URI r101 = this.parent.getOcspResponder();
        if (r101 == null) goto L5;
    L12:
        URI r102 = r101;
        int r103 = 0;
        if (r100.get(r111) != null) goto L30;
        if (r102 == null) goto L30;
        if (this.ocspURL != null) goto L92;
        if (this.parent.getOcspResponder() != null) goto L92;
        if (this.isEnabledOCSP == true) goto L92;
        throw new RecoverableCertPathValidatorException("OCSP disabled by \"ocsp.enable\" setting", null, this.parameters.getCertPath(), this.parameters.getIndex());
    L92:
        r100.put(r111, OcspCache.getOcspResponse(createCertID(new AlgorithmIdentifier(OIWObjectIdentifiers.idSHA1), extractCert(), new ASN1Integer(r111.getSerialNumber())), this.parameters, r102, this.parent.getOcspResponderCert(), this.parent.getOcspExtensions(), this.helper).getEncoded());     // Catch: IOException -> L27
        byte[] r104 = null;
        boolean r105 = true;
    L39:
        if (r100.isEmpty() == true) goto L89;
        OCSPResponse r106 = OCSPResponse.getInstance(r100.get(r111));
        ASN1Integer r107 = new ASN1Integer(r111.getSerialNumber());
        if (r106 == null) goto L87;
        if (r106.getResponseStatus().getIntValue() != 0) goto L85;
        ResponseBytes r112 = ResponseBytes.getInstance(r106.getResponseBytes());
        if (r112.getResponseType().equals(OCSPObjectIdentifiers.id_pkix_ocsp_basic) == true) goto L94;
        return;
    L94:
        BasicOCSPResponse r113 = BasicOCSPResponse.getInstance(r112.getResponse().getOctets());     // Catch: Exception -> L78 CertPathValidatorException -> L81
        if (r105 == false) goto L49;
    L50:
        ASN1Sequence r114 = ResponseData.getInstance(r113.getTbsResponseData()).getResponses();     // Catch: Exception -> L78 CertPathValidatorException -> L81
        CertID r108 = null;
    L52:
        if (r103 == r114.size()) goto L104;
        SingleResponse r109 = SingleResponse.getInstance(r114.getObjectAt(r103));     // Catch: Exception -> L78 CertPathValidatorException -> L81
        if (r107.equals(r109.getCertID().getSerialNumber()) == false) goto L77;
        ASN1GeneralizedTime r115 = r109.getNextUpdate();     // Catch: Exception -> L78 CertPathValidatorException -> L81
        if (r115 != null) goto L58;
    L62:
        if (r108 != null) goto L64;
    L65:
        r108 = createCertID(r109.getCertID(), extractCert(), r107);     // Catch: Exception -> L78 CertPathValidatorException -> L81
    L67:
        if (r108.equals(r109.getCertID()) == false) goto L77;
        if (r109.getCertStatus().getTagNo() != 0) goto L72;
        return;
    L72:
        if (r109.getCertStatus().getTagNo() != 1) goto L76;
        RevokedInfo r116 = RevokedInfo.getInstance(r109.getCertStatus().getStatus());     // Catch: Exception -> L78 CertPathValidatorException -> L81
        throw new CertPathValidatorException("certificate revoked, reason=(" + r116.getRevocationReason() + "), date=" + r116.getRevocationTime().getDate(), null, this.parameters.getCertPath(), this.parameters.getIndex());     // Catch: Exception -> L78 CertPathValidatorException -> L81
    L76:
        throw new CertPathValidatorException("certificate revoked, details unknown", null, this.parameters.getCertPath(), this.parameters.getIndex());     // Catch: Exception -> L78 CertPathValidatorException -> L81
    L64:
        if (r108.getHashAlgorithm().equals(r109.getCertID().getHashAlgorithm()) == true) goto L67;
    L58:
        if (this.parameters.getValidDate().after(r115.getDate()) == false) goto L62;
        throw new ExtCertPathValidatorException("OCSP response expired");     // Catch: Exception -> L78 CertPathValidatorException -> L81
    L77:
        r103 = r103 + 1;
        goto L52
    L104:
        return;
    L49:
        if (validatedOcspResponse(r113, this.parameters, r104, this.parent.getOcspResponderCert(), this.helper) == true) goto L50;
        return;
    L81:
        e = move-exception;
        throw e;
    L78:
        e = move-exception;
        throw new CertPathValidatorException("unable to process OCSP response", e, this.parameters.getCertPath(), this.parameters.getIndex());
    L85:
        throw new CertPathValidatorException("OCSP response failed: " + r106.getResponseStatus().getValue(), null, this.parameters.getCertPath(), this.parameters.getIndex());
    L87:
        throw new RecoverableCertPathValidatorException("no OCSP response found for certificate", null, this.parameters.getCertPath(), this.parameters.getIndex());
    L89:
        throw new RecoverableCertPathValidatorException("no OCSP response found for any certificate", null, this.parameters.getCertPath(), this.parameters.getIndex());
    L27:
        e = move-exception;
        throw new CertPathValidatorException("unable to encode OCSP response", e, this.parameters.getCertPath(), this.parameters.getIndex());
    L30:
        List<java.security.cert.Extension> r117 = this.parent.getOcspExtensions();
        r104 = null;
        int r118 = 0;
    L32:
        if (r118 == r117.size()) goto L37;
        java.security.cert.Extension r119 = (java.security.cert.Extension) ListProtector.get(r117, r118);
        byte[] r120 = r119.getValue();
        if (OCSPObjectIdentifiers.id_pkix_ocsp_nonce.getId().equals(r119.getId()) == false) goto L36;
        r104 = r120;
    L36:
        r118 = r118 + 1;
        goto L32
    L37:
        r105 = false;
        goto L39
    L5:
        if (this.ocspURL != null) goto L90;
        r101 = getOcspResponderURI(r111);
        goto L12
    L90:
        r101 = new URI(this.ocspURL);     // Catch: URISyntaxException -> L8
    L8:
        e = move-exception;
        throw new CertPathValidatorException("configuration error: " + e.getMessage(), e, this.parameters.getCertPath(), this.parameters.getIndex());
    }

    public List<CertPathValidatorException> getSoftFailExceptions() {
        return null;
    }

    public Set<String> getSupportedExtensions() {
        return null;
    }

    public void init(boolean r100) throws CertPathValidatorException {
        if (r100 == true) goto L6;
        this.parameters = null;
        this.isEnabledOCSP = Properties.isOverrideSet("ocsp.enable");
        this.ocspURL = Properties.getPropertyValue("ocsp.responderURL");
        return;
    L6:
        throw new CertPathValidatorException("forward checking not supported");
    }

    @Override // org.bouncycastle.jcajce.PKIXCertRevocationChecker
    public void initialize(PKIXCertRevocationCheckerParameters r100) {
        this.parameters = r100;
        this.isEnabledOCSP = Properties.isOverrideSet("ocsp.enable");
        this.ocspURL = Properties.getPropertyValue("ocsp.responderURL");
    }

    public boolean isForwardCheckingSupported() {
        return false;
    }

    @Override // org.bouncycastle.jcajce.PKIXCertRevocationChecker
    public void setParameter(String r100, Object r101) {
    }
}
