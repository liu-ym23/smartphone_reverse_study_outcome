package org.bouncycastle.jce.provider;

import java.security.cert.CertPathValidatorException;
import java.security.cert.Certificate;
import java.security.cert.PKIXRevocationChecker;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.bsi.BSIObjectIdentifiers;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.eac.EACObjectIdentifiers;
import org.bouncycastle.asn1.isara.IsaraObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.rosstandart.RosstandartObjectIdentifiers;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.jcajce.PKIXCertRevocationChecker;
import org.bouncycastle.jcajce.PKIXCertRevocationCheckerParameters;
import org.bouncycastle.jcajce.util.JcaJceHelper;

/* JADX INFO: loaded from: classes42.dex */
class ProvRevocationChecker extends PKIXRevocationChecker implements PKIXCertRevocationChecker {
    private static final int DEFAULT_OCSP_MAX_RESPONSE_SIZE = 32768;
    private static final int DEFAULT_OCSP_TIMEOUT = 15000;
    private static final Map oids = null;
    private final ProvCrlRevocationChecker crlChecker;
    private final JcaJceHelper helper;
    private final ProvOcspRevocationChecker ocspChecker;
    private PKIXCertRevocationCheckerParameters parameters;

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

    public ProvRevocationChecker(JcaJceHelper r100) {
        this.helper = r100;
        this.crlChecker = new ProvCrlRevocationChecker(r100);
        this.ocspChecker = new ProvOcspRevocationChecker(this, r100);
    }

    private boolean hasOption(PKIXRevocationChecker.Option r100) {
        return getOptions().contains(r100);
    }

    @Override // java.security.cert.PKIXCertPathChecker
    public void check(Certificate r100, Collection<String> r101) throws CertPathValidatorException {
        X509Certificate r102 = (X509Certificate) r100;
        if (hasOption(PKIXRevocationChecker.Option.ONLY_END_ENTITY) == false) goto L8;
        if (r102.getBasicConstraints() == (-1)) goto L8;
        return;
    L8:
        if (hasOption(PKIXRevocationChecker.Option.PREFER_CRLS) == true) goto L26;
        this.ocspChecker.check(r100);     // Catch: RecoverableCertPathValidatorException -> L18
        return;
    L18:
        e = move-exception;
        if (hasOption(PKIXRevocationChecker.Option.NO_FALLBACK) == true) goto L23;
        this.crlChecker.check(r100);
        return;
    L23:
        throw e;
    L26:
        this.crlChecker.check(r100);     // Catch: RecoverableCertPathValidatorException -> L11
        return;
    L11:
        e = move-exception;
        if (hasOption(PKIXRevocationChecker.Option.NO_FALLBACK) == true) goto L15;
        this.ocspChecker.check(r100);
        return;
    L15:
        throw e;
    }

    @Override // java.security.cert.PKIXRevocationChecker
    public List<CertPathValidatorException> getSoftFailExceptions() {
        return this.ocspChecker.getSoftFailExceptions();
    }

    @Override // java.security.cert.PKIXCertPathChecker
    public Set<String> getSupportedExtensions() {
        return null;
    }

    @Override // java.security.cert.PKIXCertPathChecker, java.security.cert.CertPathChecker
    public void init(boolean r100) throws CertPathValidatorException {
        this.parameters = null;
        this.crlChecker.init(r100);
        this.ocspChecker.init(r100);
    }

    @Override // org.bouncycastle.jcajce.PKIXCertRevocationChecker
    public void initialize(PKIXCertRevocationCheckerParameters r100) {
        this.parameters = r100;
        this.crlChecker.initialize(r100);
        this.ocspChecker.initialize(r100);
    }

    @Override // java.security.cert.PKIXCertPathChecker, java.security.cert.CertPathChecker
    public boolean isForwardCheckingSupported() {
        return false;
    }

    @Override // org.bouncycastle.jcajce.PKIXCertRevocationChecker
    public void setParameter(String r100, Object r101) {
    }
}
