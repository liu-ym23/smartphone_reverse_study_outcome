package org.bouncycastle.jce.provider;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.CertPathBuilderException;
import java.security.cert.CertPathBuilderSpi;
import java.security.cert.CertPathValidatorException;
import java.security.cert.Certificate;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.X509CRL;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.security.cert.X509Extension;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1String;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x500.RDN;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.style.BCStyle;
import org.bouncycastle.asn1.x509.BasicConstraints;
import org.bouncycastle.asn1.x509.CRLDistPoint;
import org.bouncycastle.asn1.x509.DistributionPoint;
import org.bouncycastle.asn1.x509.DistributionPointName;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.asn1.x509.GeneralSubtree;
import org.bouncycastle.asn1.x509.IssuingDistributionPoint;
import org.bouncycastle.asn1.x509.NameConstraints;
import org.bouncycastle.asn1.x509.PolicyInformation;
import org.bouncycastle.jcajce.PKIXCRLStore;
import org.bouncycastle.jcajce.PKIXCertRevocationChecker;
import org.bouncycastle.jcajce.PKIXCertRevocationCheckerParameters;
import org.bouncycastle.jcajce.PKIXCertStoreSelector;
import org.bouncycastle.jcajce.PKIXExtendedBuilderParameters;
import org.bouncycastle.jcajce.PKIXExtendedParameters;
import org.bouncycastle.jcajce.provider.symmetric.util.ClassUtil;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jce.exception.ExtCertPathValidatorException;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
class RFC3280CertPathUtilities {
    public static final String ANY_POLICY = "2.5.29.32.0";
    public static final String AUTHORITY_KEY_IDENTIFIER = null;
    public static final String BASIC_CONSTRAINTS = null;
    public static final String CERTIFICATE_POLICIES = null;
    public static final String CRL_DISTRIBUTION_POINTS = null;
    public static final String CRL_NUMBER = null;
    protected static final int CRL_SIGN = 6;
    public static final String DELTA_CRL_INDICATOR = null;
    public static final String FRESHEST_CRL = null;
    public static final String INHIBIT_ANY_POLICY = null;
    public static final String ISSUING_DISTRIBUTION_POINT = null;
    protected static final int KEY_CERT_SIGN = 5;
    public static final String KEY_USAGE = null;
    public static final String NAME_CONSTRAINTS = null;
    public static final String POLICY_CONSTRAINTS = null;
    public static final String POLICY_MAPPINGS = null;
    public static final String SUBJECT_ALTERNATIVE_NAME = null;
    protected static final String[] crlReasons = null;
    private static final Class revChkClass = null;

    static {
        revChkClass = ClassUtil.loadClass(RFC3280CertPathUtilities.class, "java.security.cert.PKIXRevocationChecker");
        CERTIFICATE_POLICIES = Extension.certificatePolicies.getId();
        POLICY_MAPPINGS = Extension.policyMappings.getId();
        INHIBIT_ANY_POLICY = Extension.inhibitAnyPolicy.getId();
        ISSUING_DISTRIBUTION_POINT = Extension.issuingDistributionPoint.getId();
        FRESHEST_CRL = Extension.freshestCRL.getId();
        DELTA_CRL_INDICATOR = Extension.deltaCRLIndicator.getId();
        POLICY_CONSTRAINTS = Extension.policyConstraints.getId();
        BASIC_CONSTRAINTS = Extension.basicConstraints.getId();
        CRL_DISTRIBUTION_POINTS = Extension.cRLDistributionPoints.getId();
        SUBJECT_ALTERNATIVE_NAME = Extension.subjectAlternativeName.getId();
        NAME_CONSTRAINTS = Extension.nameConstraints.getId();
        AUTHORITY_KEY_IDENTIFIER = Extension.authorityKeyIdentifier.getId();
        KEY_USAGE = Extension.keyUsage.getId();
        CRL_NUMBER = Extension.cRLNumber.getId();
        crlReasons = new String[]{"unspecified", "keyCompromise", "cACompromise", "affiliationChanged", "superseded", "cessationOfOperation", "certificateHold", "unknown", "removeFromCRL", "privilegeWithdrawn", "aACompromise"};
    }

    public RFC3280CertPathUtilities() {
    }

    private static void checkCRL(PKIXCertRevocationCheckerParameters r210, DistributionPoint r211, PKIXExtendedParameters r212, Date r213, Date r214, X509Certificate r215, X509Certificate r216, PublicKey r217, CertStatus r218, ReasonsMask r219, List r310, JcaJceHelper r311) throws AnnotatedException, RecoverableCertPathValidatorException {
        if (r214.getTime() > r213.getTime()) goto L59;
        Iterator r110 = CertPathValidatorUtilities.getCompleteCRLs(r210, r211, r215, r212, r214).iterator();
        AnnotatedException e100 = null;
        boolean r111 = false;
    L6:
        if (r110.hasNext() == false) goto L54;
        if (r218.getCertStatus() != 11) goto L54;
        if (r219.isAllReasons() == true) goto L54;
        X509CRL r100 = (X509CRL) r110.next();     // Catch: AnnotatedException -> L51
        ReasonsMask r101 = processCRLD(r100, r211);     // Catch: AnnotatedException -> L51
        if (r101.hasNewReasons(r219) == false) goto L6;
        Iterator r220 = r110;
        AnnotatedException r112 = e100;
        PublicKey r102 = processCRLG(r100, processCRLF(r100, r215, r216, r217, r212, r310, r311));     // Catch: AnnotatedException -> L49
        if (r212.isUseDeltasEnabled() == false) goto L20;
        X509CRL r103 = processCRLH(CertPathValidatorUtilities.getDeltaCRLs(r214, r100, r212.getCertStores(), r212.getCRLStores(), r311), r102);     // Catch: AnnotatedException -> L47
    L22:
        if (r212.getValidityModel() != 1) goto L24;
    L28:
        processCRLB1(r211, r215, r100);     // Catch: AnnotatedException -> L47
        processCRLB2(r211, r215, r100);     // Catch: AnnotatedException -> L47
        processCRLC(r103, r100, r212);     // Catch: AnnotatedException -> L47
        processCRLI(r214, r103, r215, r218, r212);     // Catch: AnnotatedException -> L47
        processCRLJ(r214, r100, r215, r218);     // Catch: AnnotatedException -> L47
        if (r218.getCertStatus() != 8) goto L31;
        r218.setCertStatus(11);     // Catch: AnnotatedException -> L47
    L31:
        r219.addReasons(r101);     // Catch: AnnotatedException -> L47
        Set<String> r104 = r100.getCriticalExtensionOIDs();     // Catch: AnnotatedException -> L47
        if (r104 == null) goto L38;
        HashSet r105 = new HashSet(r104);     // Catch: AnnotatedException -> L47
        r105.remove(Extension.issuingDistributionPoint.getId());     // Catch: AnnotatedException -> L47
        r105.remove(Extension.deltaCRLIndicator.getId());     // Catch: AnnotatedException -> L47
        if (r105.isEmpty() == true) goto L38;
        throw new AnnotatedException("CRL contains unsupported critical extensions.");     // Catch: AnnotatedException -> L47
    L38:
        if (r103 == null) goto L46;
        Set<String> r106 = r103.getCriticalExtensionOIDs();     // Catch: AnnotatedException -> L47
        if (r106 == null) goto L46;
        HashSet r107 = new HashSet(r106);     // Catch: AnnotatedException -> L47
        r107.remove(Extension.issuingDistributionPoint.getId());     // Catch: AnnotatedException -> L47
        r107.remove(Extension.deltaCRLIndicator.getId());     // Catch: AnnotatedException -> L47
        if (r107.isEmpty() == true) goto L46;
        throw new AnnotatedException("Delta CRL contains unsupported critical extension.");     // Catch: AnnotatedException -> L47
    L46:
        r110 = r220;
        e100 = r112;
        r111 = true;
        goto L6
    L24:
        if (r215.getNotAfter().getTime() >= r100.getThisUpdate().getTime()) goto L28;
        throw new AnnotatedException("No valid CRL for current time found.");     // Catch: AnnotatedException -> L47
    L47:
        e100 = e;
    L53:
        r110 = r220;
        goto L6
    L20:
        r103 = null;
    L49:
        e100 = e;
    L51:
        e100 = e;
        r220 = r110;
    L54:
        AnnotatedException r113 = e100;
        if (r111 == false) goto L57;
        return;
    L57:
        throw r113;
    L59:
        throw new AnnotatedException("Validation time is in future.");
    }

    public static void checkCRLs(PKIXCertRevocationCheckerParameters r210, PKIXExtendedParameters r211, Date r212, Date r213, X509Certificate r214, X509Certificate r215, PublicKey r216, List r310, JcaJceHelper r311) throws AnnotatedException, RecoverableCertPathValidatorException {
        CRLDistPoint r100 = CRLDistPoint.getInstance(CertPathValidatorUtilities.getExtensionValue(r214, CRL_DISTRIBUTION_POINTS));     // Catch: Exception -> L70
        PKIXExtendedParameters.Builder r101 = new PKIXExtendedParameters.Builder(r211);
        Iterator<PKIXCRLStore> r102 = CertPathValidatorUtilities.getAdditionalStoresFromCRLDistributionPoint(r100, r211.getNamedCRLStoreMap(), r213, r311).iterator();     // Catch: AnnotatedException -> L67
    L6:
        if (r102.hasNext() == false) goto L9;
        r101.addCRLStore(r102.next());     // Catch: AnnotatedException -> L67
        goto L6
    L9:
        CertStatus r110 = new CertStatus();
        ReasonsMask r111 = new ReasonsMask();
        PKIXExtendedParameters r112 = r101.build();
        boolean r113 = true;
        int r103 = 11;
        Object r104 = null;
        if (r100 != null) goto L80;
    L33:
        CertStatus r217 = r110;
        int r114 = 11;
        AnnotatedException e100 = null;
        boolean r115 = false;
    L35:
        if (r217.getCertStatus() == r114) goto L77;
    L45:
        r113 = r115;
    L46:
        if (r113 == true) goto L53;
        if ((e100 instanceof AnnotatedException) == false) goto L51;
        throw e100;
    L51:
        throw new AnnotatedException("No valid CRL found.", e100);
    L53:
        if (r217.getCertStatus() == r114) goto L55;
        CertStatus r105 = r217;
        SimpleDateFormat r106 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
        r106.setTimeZone(TimeZone.getTimeZone("UTC"));
        throw new AnnotatedException(("Certificate revocation after " + r106.format(r105.getRevocationDate())) + ", reason: " + crlReasons[r105.getCertStatus()]);
    L55:
        if (r111.isAllReasons() == false) goto L57;
    L59:
        CertStatus r107 = r217;
    L61:
        if (r107.getCertStatus() == 12) goto L64;
        return;
    L64:
        throw new AnnotatedException("Certificate status could not be determined.");
    L57:
        if (r217.getCertStatus() != r114) goto L59;
        r107 = r217;
        r107.setCertStatus(12);
        goto L61
    L77:
        if (r111.isAllReasons() == true) goto L45;
        checkCRL(r210, new DistributionPoint(new DistributionPointName(0, new GeneralNames(new GeneralName(4, PrincipalUtils.getIssuerPrincipal(r214)))), null, null), (PKIXExtendedParameters) r211.clone(), r212, r213, r214, r215, r216, r217, r111, r310, r311);     // Catch: AnnotatedException -> L40
        goto L46
    L42:
        e = move-exception;
        throw new AnnotatedException("Issuer from certificate for CRL could not be reencoded.", e);     // Catch: AnnotatedException -> L40
    L40:
        e100 = e;
        goto L45
    L80:
        DistributionPoint[] r108 = r100.getDistributionPoints();     // Catch: Exception -> L30
        if (r108 == null) goto L33;
        e100 = null;
        int r109 = 0;
        r115 = false;
    L15:
        if (r109 >= r108.length) goto L29;
        if (r110.getCertStatus() != r103) goto L29;
        if (r111.isAllReasons() == true) goto L29;
        int r218 = r109;
        DistributionPoint[] r219 = r108;
        CertStatus r220 = r110;
        checkCRL(r210, r108[r109], r112, r212, r213, r214, r215, r216, r110, r111, r310, r311);     // Catch: AnnotatedException -> L24
        r115 = true;
    L28:
        r109 = r218 + 1;
        r108 = r219;
        r110 = r220;
        r104 = null;
        r103 = 11;
    L24:
        e100 = e;
    L26:
        e100 = e;
        r218 = r109;
        r219 = r108;
        r220 = r110;
    L29:
        r217 = r110;
        r114 = 11;
    L30:
        e = move-exception;
        throw new AnnotatedException("Distribution points could not be read.", e);
    L67:
        e = move-exception;
        throw new AnnotatedException("No additional CRL locations could be decoded from CRL distribution point extension.", e);
    L70:
        e = move-exception;
        throw new AnnotatedException("CRL distribution point extension could not be read.", e);
    }

    public static PKIXPolicyNode prepareCertB(CertPath r110, int r210, List[] r211, PKIXPolicyNode r212, int r213) throws CertPathValidatorException {
        List<? extends Certificate> r100 = r110.getCertificates();
        X509Certificate r101 = (X509Certificate) ListProtector.get(r100, r210);
        int r102 = r100.size() - r210;
        ASN1Sequence r103 = ASN1Sequence.getInstance(CertPathValidatorUtilities.getExtensionValue(r101, POLICY_MAPPINGS));     // Catch: AnnotatedException -> L78
        if (r103 == null) goto L77;
        HashMap r111 = new HashMap();
        HashSet r104 = new HashSet();
        int r105 = 0;
    L7:
        if (r105 >= r103.size()) goto L13;
        ASN1Sequence r106 = (ASN1Sequence) r103.getObjectAt(r105);
        String r107 = ((ASN1ObjectIdentifier) r106.getObjectAt(0)).getId();
        String r108 = ((ASN1ObjectIdentifier) r106.getObjectAt(1)).getId();
        if (r111.containsKey(r107) == true) goto L11;
        HashSet r112 = new HashSet();
        r112.add(r108);
        r111.put(r107, r112);
        r104.add(r107);
    L12:
        r105 = r105 + 1;
        goto L7
    L11:
        ((Set) r111.get(r107)).add(r108);
        goto L12
    L13:
        Iterator r113 = r104.iterator();
        PKIXPolicyNode r114 = r212;
    L15:
        if (r113.hasNext() == false) goto L113;
        String r115 = (String) r113.next();
        if (r213 <= 0) goto L57;
        Iterator r109 = r211[r102].iterator();
    L20:
        if (r109.hasNext() == false) goto L24;
        PKIXPolicyNode r116 = (PKIXPolicyNode) r109.next();
        if (r116.getValidPolicy().equals(r115) == false) goto L20;
        r116.expectedPolicies = (Set) r111.get(r115);
        boolean r117 = true;
    L25:
        if (r117 == true) goto L15;
        Iterator r118 = r211[r102].iterator();
    L28:
        if (r118.hasNext() == false) goto L15;
        PKIXPolicyNode r119 = (PKIXPolicyNode) r118.next();
        if (ANY_POLICY.equals(r119.getValidPolicy()) == false) goto L28;
        Enumeration r120 = ((ASN1Sequence) CertPathValidatorUtilities.getExtensionValue(r101, CERTIFICATE_POLICIES)).getObjects();
    L34:
        if (r120.hasMoreElements() == false) goto L46;
        PolicyInformation r121 = PolicyInformation.getInstance(r120.nextElement());     // Catch: Exception -> L43
        if (ANY_POLICY.equals(r121.getPolicyIdentifier().getId()) == false) goto L34;
        Set r122 = CertPathValidatorUtilities.getQualifierSet(r121.getPolicyQualifiers());     // Catch: CertPathValidatorException -> L40
    L47:
        Set r123 = r122;
        if (r101.getCriticalExtensionOIDs() == null) goto L50;
        boolean r124 = r101.getCriticalExtensionOIDs().contains(CERTIFICATE_POLICIES);
    L51:
        PKIXPolicyNode r125 = (PKIXPolicyNode) r119.getParent();
        if (ANY_POLICY.equals(r125.getValidPolicy()) == false) goto L15;
        PKIXPolicyNode r126 = new PKIXPolicyNode(new ArrayList(), r102, (Set) r111.get(r115), r125, r123, r115, r124);
        r125.addChild(r126);
        r211[r102].add(r126);
        goto L15
    L50:
        r124 = false;
    L40:
        e = move-exception;
        throw new ExtCertPathValidatorException("Policy qualifier info set could not be decoded.", e, r110, r210);
    L43:
        e = move-exception;
        throw new CertPathValidatorException("Policy information could not be decoded.", e, r110, r210);
    L46:
        r122 = null;
    L54:
        e = move-exception;
        throw new ExtCertPathValidatorException("Certificate policies extension could not be decoded.", e, r110, r210);
    L24:
        r117 = false;
        goto L25
    L57:
        if (r213 > 0) goto L15;
        Iterator r127 = r211[r102].iterator();
    L60:
        if (r127.hasNext() == false) goto L15;
        PKIXPolicyNode r128 = (PKIXPolicyNode) r127.next();
        if (r128.getValidPolicy().equals(r115) == false) goto L60;
        ((PKIXPolicyNode) r128.getParent()).removeChild(r128);
        r127.remove();
        int r129 = r102 - 1;
    L64:
        if (r129 < 0) goto L60;
        List r130 = r211[r129];
        PKIXPolicyNode r131 = r114;
        int r132 = 0;
    L67:
        if (r132 >= r130.size()) goto L74;
        PKIXPolicyNode r133 = (PKIXPolicyNode) ListProtector.get(r130, r132);
        if (r133.hasChildren() == true) goto L73;
        r131 = CertPathValidatorUtilities.removePolicyNode(r131, r211, r133);
        if (r131 == null) goto L74;
    L73:
        r132 = r132 + 1;
    L74:
        r114 = r131;
        r129 = r129 - 1;
        goto L64
    L113:
        return r114;
    L77:
        return r212;
    L78:
        e = move-exception;
        throw new ExtCertPathValidatorException("Policy mappings extension could not be decoded.", e, r110, r210);
    }

    public static void prepareNextCertA(CertPath r100, int r101) throws CertPathValidatorException {
        X509Certificate r102 = (X509Certificate) ListProtector.get(r100.getCertificates(), r101);
        ASN1Sequence r103 = ASN1Sequence.getInstance(CertPathValidatorUtilities.getExtensionValue(r102, POLICY_MAPPINGS));     // Catch: AnnotatedException -> L22
        if (r103 == null) goto L21;
        int r104 = 0;
    L7:
        if (r104 >= r103.size()) goto L32;
        ASN1Sequence r105 = ASN1Sequence.getInstance(r103.getObjectAt(r104));     // Catch: Exception -> L18
        ASN1ObjectIdentifier r106 = ASN1ObjectIdentifier.getInstance(r105.getObjectAt(0));     // Catch: Exception -> L18
        ASN1ObjectIdentifier r107 = ASN1ObjectIdentifier.getInstance(r105.getObjectAt(1));     // Catch: Exception -> L18
        if (ANY_POLICY.equals(r106.getId()) == true) goto L17;
        if (ANY_POLICY.equals(r107.getId()) == true) goto L15;
        r104 = r104 + 1;
        goto L7
    L15:
        throw new CertPathValidatorException("SubjectDomainPolicy is anyPolicy", null, r100, r101);
    L17:
        throw new CertPathValidatorException("IssuerDomainPolicy is anyPolicy", null, r100, r101);
    L18:
        e = move-exception;
        throw new ExtCertPathValidatorException("Policy mappings extension contents could not be decoded.", e, r100, r101);
    L32:
        return;
    L21:
        return;
    L22:
        e = move-exception;
        throw new ExtCertPathValidatorException("Policy mappings extension could not be decoded.", e, r100, r101);
    }

    public static void prepareNextCertG(CertPath r100, int r101, PKIXNameConstraintValidator r102) throws CertPathValidatorException {
        X509Certificate r103 = (X509Certificate) ListProtector.get(r100.getCertificates(), r101);
        ASN1Sequence r104 = ASN1Sequence.getInstance(CertPathValidatorUtilities.getExtensionValue(r103, NAME_CONSTRAINTS));     // Catch: Exception -> L27
        if (r104 == null) goto L7;
        NameConstraints r105 = NameConstraints.getInstance(r104);     // Catch: Exception -> L27
    L8:
        if (r105 == null) goto L26;
        GeneralSubtree[] r106 = r105.getPermittedSubtrees();
        if (r106 != null) goto L32;
    L16:
        GeneralSubtree[] r107 = r105.getExcludedSubtrees();
        if (r107 == null) goto L37;
        int r108 = 0;
    L20:
        if (r108 == r107.length) goto L38;
        r102.addExcludedSubtree(r107[r108]);     // Catch: Exception -> L23
        r108 = r108 + 1;
    L23:
        e = move-exception;
        throw new ExtCertPathValidatorException("Excluded subtrees cannot be build from name constraints extension.", e, r100, r101);
    L38:
        return;
    L37:
        return;
    L32:
        r102.intersectPermittedSubtree(r106);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        throw new ExtCertPathValidatorException("Permitted subtrees cannot be build from name constraints extension.", e, r100, r101);
    L26:
        return;
    L7:
        r105 = null;
    L27:
        e = move-exception;
        throw new ExtCertPathValidatorException("Name constraints extension could not be decoded.", e, r100, r101);
    }

    public static int prepareNextCertH1(CertPath r100, int r101, int r102) {
        if (CertPathValidatorUtilities.isSelfIssued((X509Certificate) ListProtector.get(r100.getCertificates(), r101)) == true) goto L7;
        if (r102 != 0) goto L6;
        return r102;
    L6:
        return r102 - 1;
    L7:
        return r102;
    }

    public static int prepareNextCertH2(CertPath r100, int r101, int r102) {
        if (CertPathValidatorUtilities.isSelfIssued((X509Certificate) ListProtector.get(r100.getCertificates(), r101)) == true) goto L7;
        if (r102 != 0) goto L6;
        return r102;
    L6:
        return r102 - 1;
    L7:
        return r102;
    }

    public static int prepareNextCertH3(CertPath r100, int r101, int r102) {
        if (CertPathValidatorUtilities.isSelfIssued((X509Certificate) ListProtector.get(r100.getCertificates(), r101)) == true) goto L7;
        if (r102 != 0) goto L6;
        return r102;
    L6:
        return r102 - 1;
    L7:
        return r102;
    }

    public static int prepareNextCertI1(CertPath r100, int r101, int r102) throws CertPathValidatorException {
        X509Certificate r103 = (X509Certificate) ListProtector.get(r100.getCertificates(), r101);
        ASN1Sequence r104 = ASN1Sequence.getInstance(CertPathValidatorUtilities.getExtensionValue(r103, POLICY_CONSTRAINTS));     // Catch: Exception -> L17
        if (r104 == null) goto L16;
        Enumeration r105 = r104.getObjects();
    L7:
        if (r105.hasMoreElements() == false) goto L16;
        ASN1TaggedObject r106 = ASN1TaggedObject.getInstance(r105.nextElement());     // Catch: IllegalArgumentException -> L13
        if (r106.getTagNo() != 0) goto L7;
        int r107 = ASN1Integer.getInstance(r106, false).intValueExact();     // Catch: IllegalArgumentException -> L13
        if (r107 >= r102) goto L16;
        return r107;
    L13:
        e = move-exception;
        throw new ExtCertPathValidatorException("Policy constraints extension contents cannot be decoded.", e, r100, r101);
    L16:
        return r102;
    L17:
        e = move-exception;
        throw new ExtCertPathValidatorException("Policy constraints extension cannot be decoded.", e, r100, r101);
    }

    public static int prepareNextCertI2(CertPath r100, int r101, int r102) throws CertPathValidatorException {
        X509Certificate r103 = (X509Certificate) ListProtector.get(r100.getCertificates(), r101);
        ASN1Sequence r104 = ASN1Sequence.getInstance(CertPathValidatorUtilities.getExtensionValue(r103, POLICY_CONSTRAINTS));     // Catch: Exception -> L17
        if (r104 == null) goto L16;
        Enumeration r105 = r104.getObjects();
    L7:
        if (r105.hasMoreElements() == false) goto L16;
        ASN1TaggedObject r106 = ASN1TaggedObject.getInstance(r105.nextElement());     // Catch: IllegalArgumentException -> L13
        if (r106.getTagNo() != 1) goto L7;
        int r107 = ASN1Integer.getInstance(r106, false).intValueExact();     // Catch: IllegalArgumentException -> L13
        if (r107 >= r102) goto L16;
        return r107;
    L13:
        e = move-exception;
        throw new ExtCertPathValidatorException("Policy constraints extension contents cannot be decoded.", e, r100, r101);
    L16:
        return r102;
    L17:
        e = move-exception;
        throw new ExtCertPathValidatorException("Policy constraints extension cannot be decoded.", e, r100, r101);
    }

    public static int prepareNextCertJ(CertPath r100, int r101, int r102) throws CertPathValidatorException {
        X509Certificate r103 = (X509Certificate) ListProtector.get(r100.getCertificates(), r101);
        ASN1Integer r104 = ASN1Integer.getInstance(CertPathValidatorUtilities.getExtensionValue(r103, INHIBIT_ANY_POLICY));     // Catch: Exception -> L9
        if (r104 == null) goto L8;
        int r105 = r104.intValueExact();
        if (r105 >= r102) goto L8;
        return r105;
    L8:
        return r102;
    L9:
        e = move-exception;
        throw new ExtCertPathValidatorException("Inhibit any-policy extension cannot be decoded.", e, r100, r101);
    }

    public static void prepareNextCertK(CertPath r100, int r101) throws CertPathValidatorException {
        X509Certificate r102 = (X509Certificate) ListProtector.get(r100.getCertificates(), r101);
        BasicConstraints r103 = BasicConstraints.getInstance(CertPathValidatorUtilities.getExtensionValue(r102, BASIC_CONSTRAINTS));     // Catch: Exception -> L13
        if (r103 == null) goto L12;
        if (r103.isCA() == false) goto L10;
        return;
    L10:
        throw new CertPathValidatorException("Not a CA certificate", null, r100, r101);
    L12:
        throw new CertPathValidatorException("Intermediate certificate lacks BasicConstraints", null, r100, r101);
    L13:
        e = move-exception;
        throw new ExtCertPathValidatorException("Basic constraints extension cannot be decoded.", e, r100, r101);
    }

    public static int prepareNextCertL(CertPath r100, int r101, int r102) throws CertPathValidatorException {
        if (CertPathValidatorUtilities.isSelfIssued((X509Certificate) ListProtector.get(r100.getCertificates(), r101)) == true) goto L9;
        if (r102 <= 0) goto L8;
        return r102 - 1;
    L8:
        throw new ExtCertPathValidatorException("Max path length not greater than zero", null, r100, r101);
    L9:
        return r102;
    }

    public static int prepareNextCertM(CertPath r100, int r101, int r102) throws CertPathValidatorException {
        X509Certificate r103 = (X509Certificate) ListProtector.get(r100.getCertificates(), r101);
        BasicConstraints r104 = BasicConstraints.getInstance(CertPathValidatorUtilities.getExtensionValue(r103, BASIC_CONSTRAINTS));     // Catch: Exception -> L11
        if (r104 == null) goto L10;
        BigInteger r105 = r104.getPathLenConstraint();
        if (r105 == null) goto L10;
        int r106 = r105.intValue();
        if (r106 >= r102) goto L10;
        return r106;
    L10:
        return r102;
    L11:
        e = move-exception;
        throw new ExtCertPathValidatorException("Basic constraints extension cannot be decoded.", e, r100, r101);
    }

    public static void prepareNextCertN(CertPath r100, int r101) throws CertPathValidatorException {
        boolean[] r102 = ((X509Certificate) ListProtector.get(r100.getCertificates(), r101)).getKeyUsage();
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.length <= 5) goto L10;
        if (r102[5] == false) goto L10;
        return;
    L10:
        throw new ExtCertPathValidatorException("Issuer certificate keyusage extension is critical and does not permit key signing.", null, r100, r101);
    }

    public static void prepareNextCertO(CertPath r100, int r101, Set r102, List r103) throws CertPathValidatorException {
        X509Certificate r104 = (X509Certificate) ListProtector.get(r100.getCertificates(), r101);
        Iterator r105 = r103.iterator();
    L4:
        if (r105.hasNext() == false) goto L11;
        ((PKIXCertPathChecker) r105.next()).check(r104, r102);     // Catch: CertPathValidatorException -> L7
    L7:
        e = move-exception;
        throw new CertPathValidatorException(e.getMessage(), e.getCause(), r100, r101);
    L11:
        if (r102.isEmpty() == false) goto L14;
        return;
    L14:
        throw new ExtCertPathValidatorException("Certificate has unsupported critical extension: " + r102, null, r100, r101);
    }

    public static void processCRLB1(DistributionPoint r100, Object r101, X509CRL r102) throws AnnotatedException {
        ASN1Primitive r103 = CertPathValidatorUtilities.getExtensionValue(r102, ISSUING_DISTRIBUTION_POINT);
        boolean r104 = true;
        int r105 = 0;
        if (r103 != null) goto L5;
    L7:
        boolean r106 = false;
    L45:
        byte[] r107 = PrincipalUtils.getIssuerPrincipal(r102).getEncoded();     // Catch: IOException -> L40
        if (r100.getCRLIssuer() == null) goto L33;
        GeneralName[] r108 = r100.getCRLIssuer().getNames();
        boolean r109 = false;
    L13:
        if (r105 >= r108.length) goto L23;
        if (r108[r105].getTagNo() != 4) goto L22;
        if (Arrays.areEqual(r108[r105].getName().toASN1Primitive().getEncoded(), r107) == false) goto L22;
        r109 = true;
    L19:
        e = move-exception;
        throw new AnnotatedException("CRL issuer information from distribution point cannot be decoded.", e);
    L22:
        r105 = r105 + 1;
        goto L13
    L23:
        if (r109 == false) goto L28;
        if (r106 == true) goto L28;
        throw new AnnotatedException("Distribution point contains cRLIssuer field but CRL is not indirect.");
    L28:
        if (r109 == false) goto L31;
        r104 = r109;
    L36:
        if (r104 == false) goto L39;
        return;
    L39:
        throw new AnnotatedException("Cannot find matching CRL issuer for certificate.");
    L31:
        throw new AnnotatedException("CRL issuer of CRL does not match CRL issuer of distribution point.");
    L33:
        if (PrincipalUtils.getIssuerPrincipal(r102).equals(PrincipalUtils.getEncodedIssuerPrincipal(r101)) == true) goto L36;
        r104 = false;
    L40:
        e = move-exception;
        throw new AnnotatedException("Exception encoding CRL issuer: " + e.getMessage(), e);
    L5:
        if (IssuingDistributionPoint.getInstance(r103).isIndirectCRL() == false) goto L7;
        r106 = true;
        goto L45
    }

    public static void processCRLB2(DistributionPoint r100, Object r110, X509CRL r111) throws AnnotatedException {
        IssuingDistributionPoint r101 = IssuingDistributionPoint.getInstance(CertPathValidatorUtilities.getExtensionValue(r111, ISSUING_DISTRIBUTION_POINT));     // Catch: Exception -> L105
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getDistributionPoint() == null) goto L112;
        DistributionPointName r102 = IssuingDistributionPoint.getInstance(r101).getDistributionPoint();
        ArrayList r103 = new ArrayList();
        boolean r104 = false;
        if (r102.getType() != 0) goto L13;
        GeneralName[] r105 = GeneralNames.getInstance(r102.getName()).getNames();
        int r106 = 0;
    L10:
        if (r106 >= r105.length) goto L13;
        r103.add(r105[r106]);
        r106 = r106 + 1;
    L13:
        if (r102.getType() != 1) goto L25;
        ASN1EncodableVector r107 = new ASN1EncodableVector();
        Enumeration r112 = ASN1Sequence.getInstance(PrincipalUtils.getIssuerPrincipal(r111)).getObjects();     // Catch: Exception -> L21
    L17:
        if (r112.hasMoreElements() == false) goto L20;
        r107.add((ASN1Encodable) r112.nextElement());     // Catch: Exception -> L21
        goto L17
    L20:
        r107.add(r102.getName());
        r103.add(new GeneralName(X500Name.getInstance(new DERSequence(r107))));
    L21:
        e = move-exception;
        throw new AnnotatedException("Could not read CRL issuer.", e);
    L25:
        if (r100.getDistributionPoint() == null) goto L63;
        DistributionPointName r113 = r100.getDistributionPoint();
        if (r113.getType() != 0) goto L29;
        GeneralName[] r108 = GeneralNames.getInstance(r113.getName()).getNames();
    L31:
        if (r113.getType() == 1) goto L33;
    L50:
        if (r108 == null) goto L58;
        int r109 = 0;
    L53:
        if (r109 >= r108.length) goto L58;
        if (r103.contains(r108[r109]) == true) goto L56;
        r109 = r109 + 1;
        goto L53
    L56:
        r104 = true;
    L58:
        if (r104 == true) goto L112;
        throw new AnnotatedException("No match for certificate CRL issuing distribution point name to cRLIssuer CRL distribution point.");
    L33:
        if (r100.getCRLIssuer() == null) goto L36;
        GeneralName[] r114 = r100.getCRLIssuer().getNames();
    L35:
        r108 = r114;
        int r115 = 0;
    L41:
        if (r115 >= r108.length) goto L50;
        Enumeration r116 = ASN1Sequence.getInstance(r108[r115].getName().toASN1Primitive()).getObjects();
        ASN1EncodableVector r117 = new ASN1EncodableVector();
    L44:
        if (r116.hasMoreElements() == false) goto L46;
        r117.add((ASN1Encodable) r116.nextElement());
        goto L44
    L46:
        r117.add(r113.getName());
        r108[r115] = new GeneralName(X500Name.getInstance(new DERSequence(r117)));
        r115 = r115 + 1;
        goto L41
    L36:
        r114 = new GeneralName[1];
        r114[0] = new GeneralName(PrincipalUtils.getEncodedIssuerPrincipal(r110));     // Catch: Exception -> L47
    L47:
        e = move-exception;
        throw new AnnotatedException("Could not read certificate issuer.", e);
    L29:
        r108 = null;
        goto L31
    L63:
        if (r100.getCRLIssuer() == null) goto L76;
        GeneralName[] r118 = r100.getCRLIssuer().getNames();
        int r119 = 0;
    L66:
        if (r119 >= r118.length) goto L71;
        if (r103.contains(r118[r119]) == true) goto L69;
        r119 = r119 + 1;
        goto L66
    L69:
        r104 = true;
    L71:
        if (r104 == true) goto L112;
        throw new AnnotatedException("No match for certificate CRL issuing distribution point name to cRLIssuer CRL distribution point.");
    L76:
        throw new AnnotatedException("Either the cRLIssuer or the distributionPoint field must be contained in DistributionPoint.");
    L112:
        BasicConstraints r120 = BasicConstraints.getInstance(CertPathValidatorUtilities.getExtensionValue((X509Extension) r110, BASIC_CONSTRAINTS));     // Catch: Exception -> L101
        if ((r110 instanceof X509Certificate) == false) goto L97;
        if (r101.onlyContainsUserCerts() == false) goto L89;
        if (r120 == null) goto L89;
        if (r120.isCA() == false) goto L89;
        throw new AnnotatedException("CA Cert CRL only contains user certificates.");
    L89:
        if (r101.onlyContainsCACerts() == false) goto L97;
        if (r120 == null) goto L95;
        if (r120.isCA() == true) goto L97;
    L95:
        throw new AnnotatedException("End CRL only contains CA certificates.");
    L97:
        if (r101.onlyContainsAttributeCerts() == true) goto L100;
        return;
    L100:
        throw new AnnotatedException("onlyContainsAttributeCerts boolean is asserted.");
    L101:
        e = move-exception;
        throw new AnnotatedException("Basic constraints extension could not be decoded.", e);
    L105:
        e = move-exception;
        throw new AnnotatedException("Issuing distribution point extension could not be decoded.", e);
    }

    public static void processCRLC(X509CRL r100, X509CRL r101, PKIXExtendedParameters r102) throws AnnotatedException {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.hasUnsupportedCriticalExtension() == true) goto L52;
        String r103 = ISSUING_DISTRIBUTION_POINT;     // Catch: Exception -> L48
        IssuingDistributionPoint r104 = IssuingDistributionPoint.getInstance(CertPathValidatorUtilities.getExtensionValue(r101, r103));     // Catch: Exception -> L48
        if (r102.isUseDeltasEnabled() == true) goto L10;
        return;
    L10:
        if (PrincipalUtils.getIssuerPrincipal(r100).equals(PrincipalUtils.getIssuerPrincipal(r101)) == false) goto L46;
        IssuingDistributionPoint r105 = IssuingDistributionPoint.getInstance(CertPathValidatorUtilities.getExtensionValue(r100, r103));     // Catch: Exception -> L42
        boolean r106 = true;
        if (r104 != null) goto L17;
        if (r105 == null) goto L20;
    L19:
        r106 = false;
    L20:
        if (r106 == false) goto L41;
        String r107 = AUTHORITY_KEY_IDENTIFIER;     // Catch: AnnotatedException -> L37
        ASN1Primitive r108 = CertPathValidatorUtilities.getExtensionValue(r101, r107);     // Catch: AnnotatedException -> L37
        ASN1Primitive r109 = CertPathValidatorUtilities.getExtensionValue(r100, r107);     // Catch: AnnotatedException -> L34
        if (r108 == null) goto L33;
        if (r109 == null) goto L31;
        if (r108.equals(r109) == false) goto L29;
        return;
    L29:
        throw new AnnotatedException("Delta CRL authority key identifier does not match complete CRL authority key identifier.");
    L31:
        throw new AnnotatedException("Delta CRL authority key identifier is null.");
    L33:
        throw new AnnotatedException("CRL authority key identifier is null.");
    L34:
        e = move-exception;
        throw new AnnotatedException("Authority key identifier extension could not be extracted from delta CRL.", e);
    L37:
        e = move-exception;
        throw new AnnotatedException("Authority key identifier extension could not be extracted from complete CRL.", e);
    L41:
        throw new AnnotatedException("Issuing distribution point extension from delta CRL and complete CRL does not match.");
    L17:
        if (r104.equals(r105) == false) goto L19;
    L42:
        e = move-exception;
        throw new AnnotatedException("Issuing distribution point extension from delta CRL could not be decoded.", e);
    L46:
        throw new AnnotatedException("Complete CRL issuer does not match delta CRL issuer.");
    L48:
        e = move-exception;
        throw new AnnotatedException("Issuing distribution point extension could not be decoded.", e);
    L52:
        throw new AnnotatedException("delta CRL has unsupported critical extensions");
    }

    public static ReasonsMask processCRLD(X509CRL r100, DistributionPoint r101) throws AnnotatedException {
        IssuingDistributionPoint r102 = IssuingDistributionPoint.getInstance(CertPathValidatorUtilities.getExtensionValue(r100, ISSUING_DISTRIBUTION_POINT));     // Catch: Exception -> L26
        if (r102 != null) goto L5;
    L10:
        if (r102 == null) goto L14;
        if (r102.getOnlySomeReasons() == null) goto L14;
    L18:
        if (r101.getReasons() != null) goto L20;
        ReasonsMask r103 = ReasonsMask.allReasons;
    L21:
        if (r102 != null) goto L23;
        ReasonsMask r104 = ReasonsMask.allReasons;
    L25:
        return r103.intersect(r104);
    L23:
        r104 = new ReasonsMask(r102.getOnlySomeReasons());
        goto L25
    L20:
        r103 = new ReasonsMask(r101.getReasons());
    L14:
        if (r101.getReasons() != null) goto L18;
        return ReasonsMask.allReasons;
    L5:
        if (r102.getOnlySomeReasons() == null) goto L10;
        if (r101.getReasons() == null) goto L10;
        return new ReasonsMask(r101.getReasons()).intersect(new ReasonsMask(r102.getOnlySomeReasons()));
    L26:
        e = move-exception;
        throw new AnnotatedException("Issuing distribution point extension could not be decoded.", e);
    }

    public static Set processCRLF(X509CRL r100, Object r101, X509Certificate r110, PublicKey r111, PKIXExtendedParameters r112, List r113, JcaJceHelper r114) throws AnnotatedException {
        X509CertSelector r102 = new X509CertSelector();
        r102.setSubject(PrincipalUtils.getIssuerPrincipal(r100).getEncoded());     // Catch: IOException -> L58
        PKIXCertStoreSelector<? extends Certificate> r103 = new PKIXCertStoreSelector.Builder(r102).build();
        LinkedHashSet r104 = new LinkedHashSet();
        CertPathValidatorUtilities.findCertificates(r104, r103, r112.getCertificateStores());     // Catch: AnnotatedException -> L55
        CertPathValidatorUtilities.findCertificates(r104, r103, r112.getCertStores());     // Catch: AnnotatedException -> L55
        r104.add(r110);
        Iterator r105 = r104.iterator();
        ArrayList r106 = new ArrayList();
        ArrayList r107 = new ArrayList();
    L7:
        int r108 = 0;
        if (r105.hasNext() == false) goto L31;
        X509Certificate r109 = (X509Certificate) r105.next();
        if (r109.equals(r110) == true) goto L11;
        if (revChkClass == null) goto L15;
        CertPathBuilderSpi r115 = new PKIXCertPathBuilderSpi_8(true);     // Catch: Exception -> L22 CertPathValidatorException -> L25 CertPathBuilderException -> L28
    L16:
        X509CertSelector r116 = new X509CertSelector();     // Catch: Exception -> L22 CertPathValidatorException -> L25 CertPathBuilderException -> L28
        r116.setCertificate(r109);     // Catch: Exception -> L22 CertPathValidatorException -> L25 CertPathBuilderException -> L28
        PKIXExtendedParameters.Builder r117 = new PKIXExtendedParameters.Builder(r112).setTargetConstraints(new PKIXCertStoreSelector.Builder(r116).build());     // Catch: Exception -> L22 CertPathValidatorException -> L25 CertPathBuilderException -> L28
        if (r113.contains(r109) == false) goto L19;
        r117.setRevocationEnabled(false);     // Catch: Exception -> L22 CertPathValidatorException -> L25 CertPathBuilderException -> L28
    L20:
        List<? extends Certificate> r118 = r115.engineBuild(new PKIXExtendedBuilderParameters.Builder(r117.build()).build()).getCertPath().getCertificates();     // Catch: Exception -> L22 CertPathValidatorException -> L25 CertPathBuilderException -> L28
        r106.add(r109);     // Catch: Exception -> L22 CertPathValidatorException -> L25 CertPathBuilderException -> L28
        r107.add(CertPathValidatorUtilities.getNextWorkingKey(r118, 0, r114));     // Catch: Exception -> L22 CertPathValidatorException -> L25 CertPathBuilderException -> L28
        goto L7
    L19:
        r117.setRevocationEnabled(true);     // Catch: Exception -> L22 CertPathValidatorException -> L25 CertPathBuilderException -> L28
        goto L20
    L15:
        r115 = new PKIXCertPathBuilderSpi(true);     // Catch: Exception -> L22 CertPathValidatorException -> L25 CertPathBuilderException -> L28
        goto L16
    L28:
        e = move-exception;
        throw new AnnotatedException("CertPath for CRL signer failed to validate.", e);
    L25:
        e = move-exception;
        throw new AnnotatedException("Public key of issuer certificate of CRL could not be retrieved.", e);
    L22:
        e = move-exception;
        throw new AnnotatedException(e.getMessage());
    L11:
        r106.add(r109);
        r107.add(r111);
        goto L7
    L31:
        HashSet r119 = new HashSet();
        AnnotatedException r120 = null;
    L33:
        if (r108 >= r106.size()) goto L44;
        boolean[] r121 = ((X509Certificate) ListProtector.get(r106, r108)).getKeyUsage();
        if (r121 != null) goto L37;
    L41:
        r119.add(ListProtector.get(r107, r108));
    L42:
        r108 = r108 + 1;
        goto L33
    L37:
        if (r121.length > 6) goto L39;
    L40:
        r120 = new AnnotatedException("Issuer certificate key usage extension does not permit CRL signing.");
        goto L42
    L39:
        if (r121[6] == true) goto L41;
    L44:
        if (r119.isEmpty() == false) goto L50;
        if (r120 != null) goto L50;
        throw new AnnotatedException("Cannot find a valid issuer certificate.");
    L50:
        if (r119.isEmpty() == false) goto L54;
        if (r120 == null) goto L54;
        throw r120;
    L54:
        return r119;
    L55:
        e = move-exception;
        throw new AnnotatedException("Issuer certificate for CRL cannot be searched.", e);
    L58:
        e = move-exception;
        throw new AnnotatedException("Subject criteria for certificate selector to find issuer certificate for CRL could not be set.", e);
    }

    public static PublicKey processCRLG(X509CRL r100, Set r101) throws AnnotatedException {
        Iterator r102 = r101.iterator();
        Exception e100 = null;
    L4:
        if (r102.hasNext() == false) goto L11;
        PublicKey r103 = (PublicKey) r102.next();
        r100.verify(r103);     // Catch: Exception -> L8
        return r103;
    L8:
        e100 = e;
        goto L4
    L11:
        throw new AnnotatedException("Cannot verify CRL.", e100);
    }

    public static X509CRL processCRLH(Set r100, PublicKey r101) throws AnnotatedException {
        Iterator r102 = r100.iterator();
        Exception e100 = null;
    L4:
        if (r102.hasNext() == false) goto L10;
        X509CRL r103 = (X509CRL) r102.next();
        r103.verify(r101);     // Catch: Exception -> L8
        return r103;
    L8:
        e100 = e;
        goto L4
    L10:
        if (e100 != null) goto L13;
        return null;
    L13:
        throw new AnnotatedException("Cannot verify delta CRL.", e100);
    }

    public static void processCRLI(Date r100, X509CRL r101, Object r102, CertStatus r103, PKIXExtendedParameters r104) throws AnnotatedException {
        if (r104.isUseDeltasEnabled() == false) goto L7;
        if (r101 == null) goto L8;
        CertPathValidatorUtilities.getCertStatus(r100, r101, r102, r103);
        return;
    L8:
        return;
    }

    public static void processCRLJ(Date r100, X509CRL r101, Object r102, CertStatus r103) throws AnnotatedException {
        if (r103.getCertStatus() != 11) goto L6;
        CertPathValidatorUtilities.getCertStatus(r100, r101, r102, r103);
        return;
    }

    public static void processCertA(CertPath r110, PKIXExtendedParameters r111, Date r112, PKIXCertRevocationChecker r113, int r114, PublicKey r115, boolean r116, X500Name r210, X509Certificate r211) throws CertPathValidatorException {
        X509Certificate r117 = (X509Certificate) ListProtector.get(r110.getCertificates(), r114);
        if (r116 == true) goto L28;
        CertPathValidatorUtilities.verifyX509Certificate(r117, r115, r111.getSigProvider());     // Catch: GeneralSecurityException -> L6
    L6:
        e = move-exception;
        throw new ExtCertPathValidatorException("Could not validate certificate signature.", e, r110, r114);
    L28:
        Date r100 = CertPathValidatorUtilities.getValidCertDateFromValidityModel(r112, r111.getValidityModel(), r110, r114);     // Catch: AnnotatedException -> L25
        r117.checkValidity(r100);     // Catch: CertificateNotYetValidException -> L19 CertificateExpiredException -> L22
        if (r113 == null) goto L14;
        r113.initialize(new PKIXCertRevocationCheckerParameters(r111, r100, r110, r114, r211, r115));
        r113.check(r117);
    L14:
        X500Name r101 = PrincipalUtils.getIssuerPrincipal(r117);
        if (r101.equals(r210) == false) goto L18;
        return;
    L18:
        throw new ExtCertPathValidatorException("IssuerName(" + r101 + ") does not match SubjectName(" + r210 + ") of signing certificate.", null, r110, r114);
    L22:
        e = move-exception;
        throw new ExtCertPathValidatorException("Could not validate certificate: " + e.getMessage(), e, r110, r114);
    L19:
        e = move-exception;
        throw new ExtCertPathValidatorException("Could not validate certificate: " + e.getMessage(), e, r110, r114);
    L25:
        e = move-exception;
        throw new ExtCertPathValidatorException("Could not validate time of certificate.", e, r110, r114);
    }

    public static void processCertBC(CertPath r100, int r101, PKIXNameConstraintValidator r102, boolean r103) throws CertPathValidatorException {
        List<? extends Certificate> r104 = r100.getCertificates();
        X509Certificate r105 = (X509Certificate) ListProtector.get(r104, r101);
        int r106 = r104.size();
        int r107 = r106 - r101;
        if (CertPathValidatorUtilities.isSelfIssued(r105) == false) goto L47;
        if (r107 < r106) goto L31;
        if (r103 == false) goto L47;
        return;
    L31:
        return;
    L47:
        ASN1Sequence r108 = ASN1Sequence.getInstance(PrincipalUtils.getSubjectPrincipal(r105));     // Catch: Exception -> L38
        r102.checkPermittedDN(r108);     // Catch: PKIXNameConstraintValidatorException -> L35
        r102.checkExcludedDN(r108);     // Catch: PKIXNameConstraintValidatorException -> L35
        GeneralNames r109 = GeneralNames.getInstance(CertPathValidatorUtilities.getExtensionValue(r105, SUBJECT_ALTERNATIVE_NAME));     // Catch: Exception -> L32
        RDN[] r110 = X500Name.getInstance(r108).getRDNs(BCStyle.EmailAddress);
        int r111 = 0;
        int r112 = 0;
    L12:
        if (r112 == r110.length) goto L19;
        GeneralName r113 = new GeneralName(1, ((ASN1String) r110[r112].getFirst().getValue()).getString());
        r102.checkPermitted(r113);     // Catch: PKIXNameConstraintValidatorException -> L16
        r102.checkExcluded(r113);     // Catch: PKIXNameConstraintValidatorException -> L16
        r112 = r112 + 1;
    L16:
        e = move-exception;
        throw new CertPathValidatorException("Subtree check for certificate subject alternative email failed.", e, r100, r101);
    L19:
        if (r109 == null) goto L56;
        GeneralName[] r114 = r109.getNames();     // Catch: Exception -> L28
    L22:
        if (r111 >= r114.length) goto L57;
        r102.checkPermitted(r114[r111]);     // Catch: PKIXNameConstraintValidatorException -> L25
        r102.checkExcluded(r114[r111]);     // Catch: PKIXNameConstraintValidatorException -> L25
        r111 = r111 + 1;
    L25:
        e = move-exception;
        throw new CertPathValidatorException("Subtree check for certificate subject alternative name failed.", e, r100, r101);
    L57:
        return;
    L28:
        e = move-exception;
        throw new CertPathValidatorException("Subject alternative name contents could not be decoded.", e, r100, r101);
    L56:
        return;
    L32:
        e = move-exception;
        throw new CertPathValidatorException("Subject alternative name extension could not be decoded.", e, r100, r101);
    L35:
        e = move-exception;
        throw new CertPathValidatorException("Subtree check for certificate subject failed.", e, r100, r101);
    L38:
        e = move-exception;
        throw new CertPathValidatorException("Exception extracting subject name when checking subtrees.", e, r100, r101);
    }

    public static PKIXPolicyNode processCertD(CertPath r110, int r111, Set r210, PKIXPolicyNode r211, List[] r212, int r213, boolean r214) throws CertPathValidatorException {
        List<? extends Certificate> r100 = r110.getCertificates();
        X509Certificate r101 = (X509Certificate) ListProtector.get(r100, r111);
        int r102 = r100.size();
        int r112 = r102 - r111;
        ASN1Sequence r103 = ASN1Sequence.getInstance(CertPathValidatorUtilities.getExtensionValue(r101, CERTIFICATE_POLICIES));     // Catch: AnnotatedException -> L84
        if (r103 == null) goto L82;
        if (r211 == null) goto L125;
        Enumeration r104 = r103.getObjects();
        HashSet r105 = new HashSet();
    L8:
        if (r104.hasMoreElements() == false) goto L19;
        PolicyInformation r106 = PolicyInformation.getInstance(r104.nextElement());
        ASN1ObjectIdentifier r113 = r106.getPolicyIdentifier();
        r105.add(r113.getId());
        if (ANY_POLICY.equals(r113.getId()) == true) goto L8;
        Set r107 = CertPathValidatorUtilities.getQualifierSet(r106.getPolicyQualifiers());     // Catch: CertPathValidatorException -> L15
        if (CertPathValidatorUtilities.processCertD1i(r112, r212, r113, r107) == true) goto L8;
        CertPathValidatorUtilities.processCertD1ii(r112, r212, r113, r107);
    L15:
        e = move-exception;
        throw new ExtCertPathValidatorException("Policy qualifier info set could not be build.", e, r110, r111);
    L19:
        if (r210.isEmpty() == false) goto L21;
    L30:
        r210.clear();
        r210.addAll(r105);
    L31:
        if (r213 > 0) goto L36;
        if (r112 < r102) goto L35;
        if (r214 == true) goto L35;
    L63:
        int r108 = r112 - 1;
        PKIXPolicyNode r109 = r211;
    L64:
        if (r108 < 0) goto L75;
        List r114 = r212[r108];
        int r115 = 0;
    L67:
        if (r115 >= r114.size()) goto L74;
        PKIXPolicyNode r116 = (PKIXPolicyNode) ListProtector.get(r114, r115);
        if (r116.hasChildren() == true) goto L73;
        r109 = CertPathValidatorUtilities.removePolicyNode(r109, r212, r116);
        if (r109 == null) goto L74;
    L73:
        r115 = r115 + 1;
    L74:
        r108 = r108 - 1;
        goto L64
    L75:
        Set<String> r117 = r101.getCriticalExtensionOIDs();
        if (r117 == null) goto L81;
        boolean r118 = r117.contains(CERTIFICATE_POLICIES);
        List r119 = r212[r112];
        int r120 = 0;
    L79:
        if (r120 >= r119.size()) goto L81;
        ((PKIXPolicyNode) ListProtector.get(r119, r120)).setCritical(r118);
        r120 = r120 + 1;
    L81:
        return r109;
    L35:
        if (CertPathValidatorUtilities.isSelfIssued(r101) == false) goto L63;
    L36:
        Enumeration r121 = r103.getObjects();
    L38:
        if (r121.hasMoreElements() == false) goto L63;
        PolicyInformation r122 = PolicyInformation.getInstance(r121.nextElement());
        if (ANY_POLICY.equals(r122.getPolicyIdentifier().getId()) == false) goto L38;
        Set r123 = CertPathValidatorUtilities.getQualifierSet(r122.getPolicyQualifiers());
        List r124 = r212[r112 - 1];
        int r125 = 0;
    L43:
        if (r125 >= r124.size()) goto L63;
        PKIXPolicyNode r126 = (PKIXPolicyNode) ListProtector.get(r124, r125);
        Iterator r127 = r126.getExpectedPolicies().iterator();
    L46:
        if (r127.hasNext() == false) goto L62;
        Object r128 = r127.next();
        if ((r128 instanceof String) == true) goto L49;
        if ((r128 instanceof ASN1ObjectIdentifier) == false) goto L46;
        String r129 = ((ASN1ObjectIdentifier) r128).getId();
    L50:
        String r130 = r129;
        Iterator r131 = r126.getChildren();
        boolean r132 = false;
    L56:
        if (r131.hasNext() == false) goto L60;
        if (r130.equals(((PKIXPolicyNode) r131.next()).getValidPolicy()) == false) goto L56;
        r132 = true;
        goto L56
    L60:
        if (r132 == true) goto L46;
        HashSet r133 = new HashSet();
        r133.add(r130);
        PKIXPolicyNode r134 = new PKIXPolicyNode(new ArrayList(), r112, r133, r126, r123, r130, false);
        r126.addChild(r134);
        r212[r112].add(r134);
        goto L46
    L49:
        r129 = (String) r128;
        goto L50
    L62:
        r125 = r125 + 1;
        goto L43
    L21:
        if (r210.contains(ANY_POLICY) == true) goto L30;
        Iterator r135 = r210.iterator();
        HashSet r136 = new HashSet();
    L25:
        if (r135.hasNext() == false) goto L29;
        Object r137 = r135.next();
        if (r105.contains(r137) == false) goto L25;
        r136.add(r137);
        goto L25
    L29:
        r210.clear();
        r210.addAll(r136);
        goto L31
    L125:
        return null;
    L82:
        return null;
    L84:
        e = move-exception;
        throw new ExtCertPathValidatorException("Could not read certificate policies extension from certificate.", e, r110, r111);
    }

    public static PKIXPolicyNode processCertE(CertPath r100, int r101, PKIXPolicyNode r102) throws CertPathValidatorException {
        X509Certificate r103 = (X509Certificate) ListProtector.get(r100.getCertificates(), r101);
        if (ASN1Sequence.getInstance(CertPathValidatorUtilities.getExtensionValue(r103, CERTIFICATE_POLICIES)) != null) goto L12;
        return null;
    L12:
        return r102;
    L7:
        e = move-exception;
        throw new ExtCertPathValidatorException("Could not read certificate policies extension from certificate.", e, r100, r101);
    }

    public static void processCertF(CertPath r100, int r101, PKIXPolicyNode r102, int r103) throws CertPathValidatorException {
        if (r103 > 0) goto L7;
        if (r102 == null) goto L6;
        return;
    L6:
        throw new ExtCertPathValidatorException("No valid policy tree found when one expected.", null, r100, r101);
    }

    public static int wrapupCertA(int r100, X509Certificate r101) {
        if (CertPathValidatorUtilities.isSelfIssued(r101) == true) goto L7;
        if (r100 != 0) goto L6;
        return r100;
    L6:
        return r100 - 1;
    L7:
        return r100;
    }

    public static int wrapupCertB(CertPath r100, int r101, int r102) throws CertPathValidatorException {
        X509Certificate r103 = (X509Certificate) ListProtector.get(r100.getCertificates(), r101);
        ASN1Sequence r104 = ASN1Sequence.getInstance(CertPathValidatorUtilities.getExtensionValue(r103, POLICY_CONSTRAINTS));     // Catch: AnnotatedException -> L19
        if (r104 == null) goto L18;
        Enumeration r105 = r104.getObjects();
    L7:
        if (r105.hasMoreElements() == false) goto L18;
        ASN1TaggedObject r106 = (ASN1TaggedObject) r105.nextElement();
        if (r106.getTagNo() != 0) goto L7;
        if (ASN1Integer.getInstance(r106, false).intValueExact() != 0) goto L7;
        return 0;
    L15:
        e = move-exception;
        throw new ExtCertPathValidatorException("Policy constraints requireExplicitPolicy field could not be decoded.", e, r100, r101);
    L18:
        return r102;
    L19:
        e = move-exception;
        throw new ExtCertPathValidatorException("Policy constraints could not be decoded.", e, r100, r101);
    }

    public static void wrapupCertF(CertPath r100, int r101, List r102, Set r103) throws CertPathValidatorException {
        X509Certificate r104 = (X509Certificate) ListProtector.get(r100.getCertificates(), r101);
        Iterator r105 = r102.iterator();
    L4:
        if (r105.hasNext() == false) goto L14;
        ((PKIXCertPathChecker) r105.next()).check(r104, r103);     // Catch: Exception -> L7 CertPathValidatorException -> L10
    L10:
        e = move-exception;
        throw new ExtCertPathValidatorException(e.getMessage(), e, r100, r101);
    L7:
        e = move-exception;
        throw new CertPathValidatorException("Additional certificate path checker failed.", e, r100, r101);
    L14:
        if (r103.isEmpty() == false) goto L17;
        return;
    L17:
        throw new ExtCertPathValidatorException("Certificate has unsupported critical extension: " + r103, null, r100, r101);
    }

    public static PKIXPolicyNode wrapupCertG(CertPath r100, PKIXExtendedParameters r101, Set r102, int r103, List[] r110, PKIXPolicyNode r111, Set r112) throws CertPathValidatorException {
        int r104 = r100.getCertificates().size();
        if (r111 != null) goto L10;
        if (r101.isExplicitPolicyRequired() == true) goto L8;
        return null;
    L8:
        throw new ExtCertPathValidatorException("Explicit policy requested but none available.", null, r100, r103);
    L10:
        if (CertPathValidatorUtilities.isAnyPolicy(r102) == true) goto L12;
        HashSet r105 = new HashSet();
        int r106 = 0;
    L48:
        if (r106 >= r110.length) goto L62;
        List r107 = r110[r106];
        int r113 = 0;
    L51:
        if (r113 >= r107.size()) goto L61;
        PKIXPolicyNode r108 = (PKIXPolicyNode) ListProtector.get(r107, r113);
        if (ANY_POLICY.equals(r108.getValidPolicy()) == false) goto L60;
        Iterator r109 = r108.getChildren();
    L56:
        if (r109.hasNext() == false) goto L60;
        PKIXPolicyNode r114 = (PKIXPolicyNode) r109.next();
        if (ANY_POLICY.equals(r114.getValidPolicy()) == true) goto L56;
        r105.add(r114);
    L60:
        r113 = r113 + 1;
        goto L51
    L61:
        r106 = r106 + 1;
        goto L48
    L62:
        Iterator r115 = r105.iterator();
    L64:
        if (r115.hasNext() == false) goto L68;
        PKIXPolicyNode r116 = (PKIXPolicyNode) r115.next();
        if (r102.contains(r116.getValidPolicy()) == true) goto L64;
        r111 = CertPathValidatorUtilities.removePolicyNode(r111, r110, r116);
        goto L64
    L68:
        if (r111 == null) goto L79;
        int r117 = r104 - 1;
    L70:
        if (r117 < 0) goto L79;
        List r118 = r110[r117];
        int r119 = 0;
    L73:
        if (r119 >= r118.size()) goto L78;
        PKIXPolicyNode r120 = (PKIXPolicyNode) ListProtector.get(r118, r119);
        if (r120.hasChildren() == true) goto L77;
        r111 = CertPathValidatorUtilities.removePolicyNode(r111, r110, r120);
    L77:
        r119 = r119 + 1;
        goto L73
    L78:
        r117 = r117 - 1;
    L79:
        return r111;
    L12:
        if (r101.isExplicitPolicyRequired() == false) goto L79;
        if (r112.isEmpty() == true) goto L44;
        HashSet r121 = new HashSet();
        int r122 = 0;
    L17:
        if (r122 >= r110.length) goto L29;
        List r123 = r110[r122];
        int r124 = 0;
    L20:
        if (r124 >= r123.size()) goto L28;
        PKIXPolicyNode r125 = (PKIXPolicyNode) ListProtector.get(r123, r124);
        if (ANY_POLICY.equals(r125.getValidPolicy()) == false) goto L27;
        Iterator r126 = r125.getChildren();
    L25:
        if (r126.hasNext() == false) goto L27;
        r121.add(r126.next());
    L27:
        r124 = r124 + 1;
        goto L20
    L28:
        r122 = r122 + 1;
        goto L17
    L29:
        Iterator r127 = r121.iterator();
    L31:
        if (r127.hasNext() == false) goto L33;
        r112.contains(((PKIXPolicyNode) r127.next()).getValidPolicy());
        goto L31
    L33:
        int r128 = r104 - 1;
    L34:
        if (r128 < 0) goto L79;
        List r129 = r110[r128];
        int r130 = 0;
    L37:
        if (r130 >= r129.size()) goto L42;
        PKIXPolicyNode r131 = (PKIXPolicyNode) ListProtector.get(r129, r130);
        if (r131.hasChildren() == true) goto L41;
        r111 = CertPathValidatorUtilities.removePolicyNode(r111, r110, r131);
    L41:
        r130 = r130 + 1;
        goto L37
    L42:
        r128 = r128 - 1;
        goto L34
    L44:
        throw new ExtCertPathValidatorException("Explicit policy requested but none available.", null, r100, r103);
    }
}
