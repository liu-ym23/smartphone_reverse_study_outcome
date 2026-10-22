package org.bouncycastle.jcajce.provider.asymmetric.x509;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CRLException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.util.ASN1Dump;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.CRLDistPoint;
import org.bouncycastle.asn1.x509.CRLNumber;
import org.bouncycastle.asn1.x509.CertificateList;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.asn1.x509.IssuingDistributionPoint;
import org.bouncycastle.asn1.x509.TBSCertList;
import org.bouncycastle.asn1.x509.Time;
import org.bouncycastle.jcajce.CompositePublicKey;
import org.bouncycastle.jcajce.io.OutputStreamFactory;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jce.X509Principal;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes42.dex */
abstract class X509CRLImpl extends X509CRL {
    protected JcaJceHelper bcHelper;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected CertificateList f525371c;
    protected boolean isIndirect;
    protected String sigAlgName;
    protected byte[] sigAlgParams;

    public X509CRLImpl(JcaJceHelper r100, CertificateList r101, String r102, byte[] r103, boolean r104) {
        this.bcHelper = r100;
        this.f525371c = r101;
        this.sigAlgName = r102;
        this.sigAlgParams = r103;
        this.isIndirect = r104;
    }

    private void checkSignature(PublicKey r100, Signature r101, ASN1Encodable r102, byte[] r103) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CRLException {
        if (r102 == null) goto L4;
        X509SignatureUtil.setSignatureParameters(r101, r102);
    L4:
        r101.initVerify(r100);
        BufferedOutputStream r104 = new BufferedOutputStream(OutputStreamFactory.createStream(r101), 512);     // Catch: IOException -> L11
        this.f525371c.getTBSCertList().encodeTo(r104, ASN1Encoding.DER);     // Catch: IOException -> L11
        r104.close();     // Catch: IOException -> L11
        if (r101.verify(r103) == false) goto L10;
        return;
    L10:
        throw new SignatureException("CRL does not verify with supplied public key.");
    L11:
        e = move-exception;
        throw new CRLException(e.toString());
    }

    private void doVerify(PublicKey r110, SignatureCreator r111) throws CRLException, NoSuchAlgorithmException, InvalidKeyException, SignatureException, NoSuchProviderException {
        if (this.f525371c.getSignatureAlgorithm().equals(this.f525371c.getTBSCertList().getSignature()) == false) goto L52;
        int r100 = 0;
        if ((r110 instanceof CompositePublicKey) == false) goto L26;
        if (X509SignatureUtil.isCompositeAlgorithm(this.f525371c.getSignatureAlgorithm()) == false) goto L26;
        List<PublicKey> r112 = ((CompositePublicKey) r110).getPublicKeys();
        ASN1Sequence r101 = ASN1Sequence.getInstance(this.f525371c.getSignatureAlgorithm().getParameters());
        ASN1Sequence r102 = ASN1Sequence.getInstance(DERBitString.getInstance(this.f525371c.getSignature()).getBytes());
        boolean r103 = false;
    L10:
        if (r100 == r112.size()) goto L21;
        if (ListProtector.get(r112, r100) == null) goto L19;
        AlgorithmIdentifier r104 = AlgorithmIdentifier.getInstance(r101.getObjectAt(r100));
        checkSignature((PublicKey) ListProtector.get(r112, r100), r111.createSignature(X509SignatureUtil.getSignatureName(r104)), r104.getParameters(), DERBitString.getInstance(r102.getObjectAt(r100)).getBytes());     // Catch: SignatureException -> L17
        e = null;
        r103 = true;
    L18:
        if (e == null) goto L19;
        throw e;
    L17:
        e = e;
    L19:
        r100 = r100 + 1;
        goto L10
    L21:
        if (r103 == false) goto L24;
        return;
    L24:
        throw new InvalidKeyException("no matching key found");
    L26:
        if (X509SignatureUtil.isCompositeAlgorithm(this.f525371c.getSignatureAlgorithm()) == false) goto L43;
        ASN1Sequence r105 = ASN1Sequence.getInstance(this.f525371c.getSignatureAlgorithm().getParameters());
        ASN1Sequence r106 = ASN1Sequence.getInstance(DERBitString.getInstance(this.f525371c.getSignature()).getBytes());
        boolean r107 = false;
    L29:
        if (r100 == r106.size()) goto L39;
        AlgorithmIdentifier r108 = AlgorithmIdentifier.getInstance(r105.getObjectAt(r100));
        checkSignature(r110, r111.createSignature(X509SignatureUtil.getSignatureName(r108)), r108.getParameters(), DERBitString.getInstance(r106.getObjectAt(r100)).getBytes());     // Catch: SignatureException -> L33 Throwable -> L35
        e = null;
        r107 = true;
    L36:
        if (e != null) goto L38;
        r100 = r100 + 1;
        goto L29
    L38:
        throw e;
    L35:
        e = null;
    L33:
        e = e;
        goto L36
    L39:
        if (r107 == false) goto L42;
        return;
    L42:
        throw new InvalidKeyException("no matching key found");
    L43:
        Signature r113 = r111.createSignature(getSigAlgName());
        byte[] r109 = this.sigAlgParams;
        if (r109 != null) goto L53;
        checkSignature(r110, r113, null, getSignature());
        return;
    L53:
        checkSignature(r110, r113, ASN1Primitive.fromByteArray(r109), getSignature());     // Catch: IOException -> L48
        return;
    L48:
        e = move-exception;
        throw new SignatureException("cannot decode signature parameters: " + e.getMessage());
    L52:
        throw new CRLException("Signature algorithm on CertificateList does not match TBSCertList.");
    }

    private Set getExtensionOIDs(boolean r100) {
        if (getVersion() != 2) goto L13;
        Extensions r101 = this.f525371c.getTBSCertList().getExtensions();
        if (r101 == null) goto L20;
        HashSet r102 = new HashSet();
        Enumeration r103 = r101.oids();
    L8:
        if (r103.hasMoreElements() == false) goto L12;
        ASN1ObjectIdentifier r104 = (ASN1ObjectIdentifier) r103.nextElement();
        if (r100 != r101.getExtension(r104).isCritical()) goto L8;
        r102.add(r104.getId());
        goto L8
    L12:
        return r102;
    L20:
        return null;
    L13:
        return null;
    }

    public static byte[] getExtensionOctets(CertificateList r100, String r101) {
        ASN1OctetString r102 = getExtensionValue(r100, r101);
        if (r102 != null) goto L5;
        return null;
    L5:
        return r102.getOctets();
    }

    public static ASN1OctetString getExtensionValue(CertificateList r100, String r101) {
        Extensions r102 = r100.getTBSCertList().getExtensions();
        if (r102 == null) goto L8;
        Extension r103 = r102.getExtension(new ASN1ObjectIdentifier(r101));
        if (r103 != null) goto L7;
        return null;
    L7:
        return r103.getExtnValue();
    L8:
        return null;
    }

    private Set loadCRLEntries() {
        HashSet r100 = new HashSet();
        Enumeration r101 = this.f525371c.getRevokedCertificateEnumeration();
        X500Name r102 = null;
    L4:
        if (r101.hasMoreElements() == false) goto L12;
        TBSCertList.CRLEntry r103 = (TBSCertList.CRLEntry) r101.nextElement();
        r100.add(new X509CRLEntryObject(r103, this.isIndirect, r102));
        if (this.isIndirect == false) goto L4;
        if (r103.hasExtensions() == false) goto L4;
        Extension r104 = r103.getExtensions().getExtension(Extension.certificateIssuer);
        if (r104 == null) goto L4;
        r102 = X500Name.getInstance(GeneralNames.getInstance(r104.getParsedValue()).getNames()[0].getName());
        goto L4
    L12:
        return r100;
    }

    @Override // java.security.cert.X509Extension
    public Set getCriticalExtensionOIDs() {
        return getExtensionOIDs(true);
    }

    @Override // java.security.cert.X509CRL
    public byte[] getEncoded() throws CRLException {
        return this.f525371c.getEncoded(ASN1Encoding.DER);
    L4:
        e = move-exception;
        throw new CRLException(e.toString());
    }

    @Override // java.security.cert.X509Extension
    public byte[] getExtensionValue(String r100) {
        ASN1OctetString r101 = getExtensionValue(this.f525371c, r100);
        if (r101 != null) goto L11;
        return null;
    L11:
        return r101.getEncoded();
    L6:
        e = move-exception;
        throw new IllegalStateException("error parsing " + e.toString());
    }

    @Override // java.security.cert.X509CRL
    public Principal getIssuerDN() {
        return new X509Principal(X500Name.getInstance(this.f525371c.getIssuer().toASN1Primitive()));
    }

    @Override // java.security.cert.X509CRL
    public X500Principal getIssuerX500Principal() {
        return new X500Principal(this.f525371c.getIssuer().getEncoded());
    L5:
        throw new IllegalStateException("can't encode issuer DN");
    }

    @Override // java.security.cert.X509CRL
    public Date getNextUpdate() {
        Time r100 = this.f525371c.getNextUpdate();
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.getDate();
    }

    @Override // java.security.cert.X509Extension
    public Set getNonCriticalExtensionOIDs() {
        return getExtensionOIDs(false);
    }

    @Override // java.security.cert.X509CRL
    public X509CRLEntry getRevokedCertificate(BigInteger r100) {
        Enumeration r101 = this.f525371c.getRevokedCertificateEnumeration();
        X500Name r102 = null;
    L4:
        if (r101.hasMoreElements() == false) goto L16;
        TBSCertList.CRLEntry r103 = (TBSCertList.CRLEntry) r101.nextElement();
        if (r103.getUserCertificate().hasValue(r100) == true) goto L8;
        if (this.isIndirect == false) goto L4;
        if (r103.hasExtensions() == false) goto L4;
        Extension r104 = r103.getExtensions().getExtension(Extension.certificateIssuer);
        if (r104 == null) goto L4;
        r102 = X500Name.getInstance(GeneralNames.getInstance(r104.getParsedValue()).getNames()[0].getName());
        goto L4
    L8:
        return new X509CRLEntryObject(r103, this.isIndirect, r102);
    L16:
        return null;
    }

    @Override // java.security.cert.X509CRL
    public Set getRevokedCertificates() {
        Set r100 = loadCRLEntries();
        if (r100.isEmpty() == false) goto L5;
        return null;
    L5:
        return Collections.unmodifiableSet(r100);
    }

    @Override // java.security.cert.X509CRL
    public String getSigAlgName() {
        return this.sigAlgName;
    }

    @Override // java.security.cert.X509CRL
    public String getSigAlgOID() {
        return this.f525371c.getSignatureAlgorithm().getAlgorithm().getId();
    }

    @Override // java.security.cert.X509CRL
    public byte[] getSigAlgParams() {
        return Arrays.clone(this.sigAlgParams);
    }

    @Override // java.security.cert.X509CRL
    public byte[] getSignature() {
        return this.f525371c.getSignature().getOctets();
    }

    @Override // java.security.cert.X509CRL
    public byte[] getTBSCertList() throws CRLException {
        return this.f525371c.getTBSCertList().getEncoded(ASN1Encoding.DER);
    L4:
        e = move-exception;
        throw new CRLException(e.toString());
    }

    @Override // java.security.cert.X509CRL
    public Date getThisUpdate() {
        return this.f525371c.getThisUpdate().getDate();
    }

    @Override // java.security.cert.X509CRL
    public int getVersion() {
        return this.f525371c.getVersionNumber();
    }

    @Override // java.security.cert.X509Extension
    public boolean hasUnsupportedCriticalExtension() {
        Set r100 = getCriticalExtensionOIDs();
        if (r100 != null) goto L6;
        return false;
    L6:
        r100.remove(Extension.issuingDistributionPoint.getId());
        r100.remove(Extension.deltaCRLIndicator.getId());
        return !r100.isEmpty();
    }

    @Override // java.security.cert.CRL
    public boolean isRevoked(Certificate r100) {
        if (r100.getType().equals("X.509") == false) goto L32;
        Enumeration r101 = this.f525371c.getRevokedCertificateEnumeration();
        X500Name r102 = this.f525371c.getIssuer();
        if (r101.hasMoreElements() == false) goto L30;
        X509Certificate r103 = (X509Certificate) r100;
        BigInteger r104 = r103.getSerialNumber();
    L8:
        if (r101.hasMoreElements() == false) goto L30;
        TBSCertList.CRLEntry r105 = TBSCertList.CRLEntry.getInstance(r101.nextElement());
        if (this.isIndirect == false) goto L17;
        if (r105.hasExtensions() == false) goto L17;
        Extension r106 = r105.getExtensions().getExtension(Extension.certificateIssuer);
        if (r106 == null) goto L17;
        r102 = X500Name.getInstance(GeneralNames.getInstance(r106.getParsedValue()).getNames()[0].getName());
    L17:
        if (r105.getUserCertificate().hasValue(r104) == false) goto L8;
        if ((r100 instanceof X509Certificate) == false) goto L33;
        X500Name r107 = X500Name.getInstance(r103.getIssuerX500Principal().getEncoded());
    L23:
        if (r102.equals(r107) == true) goto L25;
        return false;
    L25:
        return true;
    L33:
        r107 = org.bouncycastle.asn1.x509.Certificate.getInstance(r100.getEncoded()).getIssuer();     // Catch: CertificateEncodingException -> L27
    L27:
        e = move-exception;
        throw new IllegalArgumentException("Cannot process certificate: " + e.getMessage());
    L30:
        return false;
    L32:
        throw new IllegalArgumentException("X.509 CRL used with non X.509 Cert");
    }

    @Override // java.security.cert.CRL
    public String toString() {
        StringBuffer r100 = new StringBuffer();
        String r101 = Strings.lineSeparator();
        r100.append("              Version: ");
        r100.append(getVersion());
        r100.append(r101);
        r100.append("             IssuerDN: ");
        r100.append(getIssuerDN());
        r100.append(r101);
        r100.append("          This update: ");
        r100.append(getThisUpdate());
        r100.append(r101);
        r100.append("          Next update: ");
        r100.append(getNextUpdate());
        r100.append(r101);
        r100.append("  Signature Algorithm: ");
        r100.append(getSigAlgName());
        r100.append(r101);
        X509SignatureUtil.prettyPrintSignature(getSignature(), r100, r101);
        Extensions r102 = this.f525371c.getTBSCertList().getExtensions();
        if (r102 == null) goto L35;
        Enumeration r103 = r102.oids();
        if (r103.hasMoreElements() == false) goto L10;
        String r104 = "           Extensions: ";
    L7:
        r100.append(r104);
        r100.append(r101);
    L10:
        if (r103.hasMoreElements() == false) goto L35;
        ASN1ObjectIdentifier r105 = (ASN1ObjectIdentifier) r103.nextElement();
        Extension r106 = r102.getExtension(r105);
        if (r106.getExtnValue() != null) goto L13;
        r100.append(r101);
        goto L10
    L13:
        ASN1InputStream r107 = new ASN1InputStream(r106.getExtnValue().getOctets());
        r100.append("                       critical(");
        r100.append(r106.isCritical());
        r100.append(") ");
        if (r105.equals(Extension.cRLNumber) == false) goto L20;
        Object r108 = new CRLNumber(ASN1Integer.getInstance(r107.readObject()).getPositiveValue());     // Catch: Exception -> L34
    L17:
        r100.append(r108);     // Catch: Exception -> L34
    L18:
        r100.append(r101);     // Catch: Exception -> L34
        goto L10
    L20:
        if (r105.equals(Extension.deltaCRLIndicator) == false) goto L24;
        String r109 = "Base CRL: " + new CRLNumber(ASN1Integer.getInstance(r107.readObject()).getPositiveValue());     // Catch: Exception -> L34
    L22:
        r100.append(r109);     // Catch: Exception -> L34
        goto L18
    L24:
        if (r105.equals(Extension.issuingDistributionPoint) == false) goto L27;
        r108 = IssuingDistributionPoint.getInstance(r107.readObject());     // Catch: Exception -> L34
        goto L17
    L27:
        if (r105.equals(Extension.cRLDistributionPoints) == false) goto L30;
        r108 = CRLDistPoint.getInstance(r107.readObject());     // Catch: Exception -> L34
        goto L17
    L30:
        if (r105.equals(Extension.freshestCRL) == false) goto L32;
        r108 = CRLDistPoint.getInstance(r107.readObject());     // Catch: Exception -> L34
        goto L17
    L32:
        r100.append(r105.getId());     // Catch: Exception -> L34
        r100.append(" value = ");     // Catch: Exception -> L34
        r109 = ASN1Dump.dumpAsString(r107.readObject());     // Catch: Exception -> L34
    L34:
        r100.append(r105.getId());
        r100.append(" value = ");
        r104 = "*****";
        goto L7
    L46:
        r100.append(r105.getId());
        r100.append(" value = ");
        r104 = "*****";
    L35:
        Set r110 = getRevokedCertificates();
        if (r110 == null) goto L42;
        Iterator r111 = r110.iterator();
    L39:
        if (r111.hasNext() == false) goto L42;
        r100.append(r111.next());
        r100.append(r101);
    L42:
        return r100.toString();
    }

    @Override // java.security.cert.X509CRL
    public void verify(PublicKey r100) throws CRLException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        doVerify(r100, new AnonymousClass1(this));
    }

    @Override // java.security.cert.X509CRL
    public void verify(PublicKey r100, final String r101) throws CRLException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        doVerify(r100, new AnonymousClass2(this, r101));
    }

    @Override // java.security.cert.X509CRL
    public void verify(PublicKey r100, final Provider r101) throws CRLException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        doVerify(r100, new AnonymousClass3(this, r101));     // Catch: NoSuchProviderException -> L4
        return;
    L4:
        e = move-exception;
        throw new NoSuchAlgorithmException("provider issue: " + e.getMessage());
    }
}
