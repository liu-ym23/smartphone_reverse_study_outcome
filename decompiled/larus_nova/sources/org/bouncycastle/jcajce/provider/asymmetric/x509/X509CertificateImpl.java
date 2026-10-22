package org.bouncycastle.jcajce.provider.asymmetric.x509;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1String;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.misc.MiscObjectIdentifiers;
import org.bouncycastle.asn1.misc.NetscapeCertType;
import org.bouncycastle.asn1.misc.NetscapeRevocationURL;
import org.bouncycastle.asn1.misc.VerisignCzagExtension;
import org.bouncycastle.asn1.util.ASN1Dump;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.style.RFC4519Style;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.BasicConstraints;
import org.bouncycastle.asn1.x509.Certificate;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.KeyUsage;
import org.bouncycastle.asn1.x509.TBSCertificate;
import org.bouncycastle.jcajce.CompositePublicKey;
import org.bouncycastle.jcajce.interfaces.BCX509Certificate;
import org.bouncycastle.jcajce.io.OutputStreamFactory;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jce.X509Principal;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Properties;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes42.dex */
abstract class X509CertificateImpl extends X509Certificate implements BCX509Certificate {
    protected BasicConstraints basicConstraints;
    protected JcaJceHelper bcHelper;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected Certificate f525372c;
    protected boolean[] keyUsage;
    protected String sigAlgName;
    protected byte[] sigAlgParams;

    public X509CertificateImpl(JcaJceHelper r100, Certificate r101, BasicConstraints r102, boolean[] r103, String r104, byte[] r105) {
        this.bcHelper = r100;
        this.f525372c = r101;
        this.basicConstraints = r102;
        this.keyUsage = r103;
        this.sigAlgName = r104;
        this.sigAlgParams = r105;
    }

    private void checkSignature(PublicKey r100, Signature r101, ASN1Encodable r102, byte[] r103) throws CertificateException, NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        if (isAlgIdEqual(this.f525372c.getSignatureAlgorithm(), this.f525372c.getTBSCertificate().getSignature()) == false) goto L15;
        X509SignatureUtil.setSignatureParameters(r101, r102);
        r101.initVerify(r100);
        BufferedOutputStream r104 = new BufferedOutputStream(OutputStreamFactory.createStream(r101), 512);     // Catch: IOException -> L11
        this.f525372c.getTBSCertificate().encodeTo(r104, ASN1Encoding.DER);     // Catch: IOException -> L11
        r104.close();     // Catch: IOException -> L11
        if (r101.verify(r103) == false) goto L10;
        return;
    L10:
        throw new SignatureException("certificate does not verify with supplied key");
    L11:
        e = move-exception;
        throw new CertificateEncodingException(e.toString());
    L15:
        throw new CertificateException("signature algorithm in TBS cert not same as outer cert");
    }

    private void doVerify(PublicKey r110, SignatureCreator r111) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, SignatureException, NoSuchProviderException {
        boolean r100 = r110 instanceof CompositePublicKey;
        int r101 = 0;
        if (r100 == false) goto L24;
        if (X509SignatureUtil.isCompositeAlgorithm(this.f525372c.getSignatureAlgorithm()) == false) goto L24;
        List<PublicKey> r112 = ((CompositePublicKey) r110).getPublicKeys();
        ASN1Sequence r102 = ASN1Sequence.getInstance(this.f525372c.getSignatureAlgorithm().getParameters());
        ASN1Sequence r103 = ASN1Sequence.getInstance(DERBitString.getInstance(this.f525372c.getSignature()).getBytes());
        boolean r104 = false;
    L8:
        if (r101 == r112.size()) goto L19;
        if (ListProtector.get(r112, r101) == null) goto L17;
        AlgorithmIdentifier r105 = AlgorithmIdentifier.getInstance(r102.getObjectAt(r101));
        checkSignature((PublicKey) ListProtector.get(r112, r101), r111.createSignature(X509SignatureUtil.getSignatureName(r105)), r105.getParameters(), DERBitString.getInstance(r103.getObjectAt(r101)).getBytes());     // Catch: SignatureException -> L15
        e = null;
        r104 = true;
    L16:
        if (e == null) goto L17;
        throw e;
    L15:
        e = e;
    L17:
        r101 = r101 + 1;
        goto L8
    L19:
        if (r104 == false) goto L22;
        return;
    L22:
        throw new InvalidKeyException("no matching key found");
    L24:
        if (X509SignatureUtil.isCompositeAlgorithm(this.f525372c.getSignatureAlgorithm()) == false) goto L41;
        ASN1Sequence r106 = ASN1Sequence.getInstance(this.f525372c.getSignatureAlgorithm().getParameters());
        ASN1Sequence r107 = ASN1Sequence.getInstance(DERBitString.getInstance(this.f525372c.getSignature()).getBytes());
        boolean r108 = false;
    L27:
        if (r101 == r107.size()) goto L37;
        AlgorithmIdentifier r109 = AlgorithmIdentifier.getInstance(r106.getObjectAt(r101));
        checkSignature(r110, r111.createSignature(X509SignatureUtil.getSignatureName(r109)), r109.getParameters(), DERBitString.getInstance(r107.getObjectAt(r101)).getBytes());     // Catch: SignatureException -> L31 Throwable -> L33
        e = null;
        r108 = true;
    L34:
        if (e != null) goto L36;
        r101 = r101 + 1;
        goto L27
    L36:
        throw e;
    L33:
        e = null;
    L31:
        e = e;
        goto L34
    L37:
        if (r108 == false) goto L40;
        return;
    L40:
        throw new InvalidKeyException("no matching key found");
    L41:
        Signature r113 = r111.createSignature(X509SignatureUtil.getSignatureName(this.f525372c.getSignatureAlgorithm()));
        if (r100 == false) goto L51;
        List<PublicKey> r114 = ((CompositePublicKey) r110).getPublicKeys();
    L45:
        if (r101 == r114.size()) goto L50;
        checkSignature((PublicKey) ListProtector.get(r114, r101), r113, this.f525372c.getSignatureAlgorithm().getParameters(), getSignature());     // Catch: InvalidKeyException -> L48
        return;
    L48:
        r101 = r101 + 1;
        goto L45
    L50:
        throw new InvalidKeyException("no matching signature found");
    L51:
        checkSignature(r110, r113, this.f525372c.getSignatureAlgorithm().getParameters(), getSignature());
    }

    private static Collection getAlternativeNames(Certificate r100, String r101) throws CertificateParsingException {
        byte[] r102 = getExtensionOctets(r100, r101);
        if (r102 != null) goto L31;
        return null;
    L31:
        ArrayList r103 = new ArrayList();     // Catch: Exception -> L27
        Enumeration r104 = ASN1Sequence.getInstance(r102).getObjects();     // Catch: Exception -> L27
    L7:
        if (r104.hasMoreElements() == false) goto L23;
        GeneralName r105 = GeneralName.getInstance(r104.nextElement());     // Catch: Exception -> L27
        ArrayList r106 = new ArrayList();     // Catch: Exception -> L27
        r106.add(Integers.valueOf(r105.getTagNo()));     // Catch: Exception -> L27
        switch(r105.getTagNo()) {
            case 0: goto L18;
            case 1: goto L17;
            case 2: goto L17;
            case 3: goto L18;
            case 4: goto L16;
            case 5: goto L18;
            case 6: goto L17;
            case 7: goto L32;
            case 8: goto L11;
            default: goto L21;
        };     // Catch: Exception -> L27
    L32:
        String r107 = InetAddress.getByAddress(ASN1OctetString.getInstance(r105.getName()).getOctets()).getHostAddress();     // Catch: UnknownHostException -> L30 Exception -> L27
    L12:
        r106.add(r107);     // Catch: Exception -> L27
    L19:
        r103.add(Collections.unmodifiableList(r106));     // Catch: Exception -> L27
        goto L7
    L21:
        throw new IOException("Bad tag number: " + r105.getTagNo());     // Catch: Exception -> L27
    L11:
        r107 = ASN1ObjectIdentifier.getInstance(r105.getName()).getId();     // Catch: Exception -> L27
        goto L12
    L16:
        r107 = X500Name.getInstance(RFC4519Style.INSTANCE, r105.getName()).toString();     // Catch: Exception -> L27
        goto L12
    L17:
        r107 = ((ASN1String) r105.getName()).getString();     // Catch: Exception -> L27
        goto L12
    L18:
        r106.add(r105.getEncoded());     // Catch: Exception -> L27
        goto L19
    L23:
        if (r103.size() != 0) goto L26;
        return null;
    L26:
        return Collections.unmodifiableCollection(r103);
    L27:
        e = move-exception;
        throw new CertificateParsingException(e.getMessage());
    }

    public static byte[] getExtensionOctets(Certificate r100, String r101) {
        ASN1OctetString r102 = getExtensionValue(r100, r101);
        if (r102 != null) goto L5;
        return null;
    L5:
        return r102.getOctets();
    }

    public static ASN1OctetString getExtensionValue(Certificate r100, String r101) {
        Extensions r102 = r100.getTBSCertificate().getExtensions();
        if (r102 == null) goto L8;
        Extension r103 = r102.getExtension(new ASN1ObjectIdentifier(r101));
        if (r103 != null) goto L7;
        return null;
    L7:
        return r103.getExtnValue();
    L8:
        return null;
    }

    private boolean isAlgIdEqual(AlgorithmIdentifier r100, AlgorithmIdentifier r101) {
        if (r100.getAlgorithm().equals(r101.getAlgorithm()) == true) goto L6;
        return false;
    L6:
        if (Properties.isOverrideSet("org.bouncycastle.x509.allow_absent_equiv_NULL") == false) goto L24;
        if (r100.getParameters() != null) goto L16;
        if (r101.getParameters() != null) goto L12;
    L14:
        return true;
    L12:
        if (r101.getParameters().equals(DERNull.INSTANCE) == true) goto L14;
        return false;
    L16:
        if (r101.getParameters() != null) goto L24;
        if (r100.getParameters() != null) goto L20;
    L22:
        return true;
    L20:
        if (r100.getParameters().equals(DERNull.INSTANCE) == true) goto L22;
        return false;
    L24:
        if (r100.getParameters() == null) goto L28;
        return r100.getParameters().equals(r101.getParameters());
    L28:
        if (r101.getParameters() != null) goto L30;
        return true;
    L30:
        return r101.getParameters().equals(r100.getParameters());
    }

    @Override // java.security.cert.X509Certificate
    public void checkValidity() throws CertificateExpiredException, CertificateNotYetValidException {
        checkValidity(new Date());
    }

    @Override // java.security.cert.X509Certificate
    public void checkValidity(Date r100) throws CertificateExpiredException, CertificateNotYetValidException {
        if (r100.getTime() > getNotAfter().getTime()) goto L10;
        if (r100.getTime() < getNotBefore().getTime()) goto L8;
        return;
    L8:
        throw new CertificateNotYetValidException("certificate not valid till " + this.f525372c.getStartDate().getTime());
    L10:
        throw new CertificateExpiredException("certificate expired on " + this.f525372c.getEndDate().getTime());
    }

    @Override // java.security.cert.X509Certificate
    public int getBasicConstraints() {
        BasicConstraints r100 = this.basicConstraints;
        if (r100 != null) goto L5;
    L12:
        return -1;
    L5:
        if (r100.isCA() == false) goto L12;
        if (this.basicConstraints.getPathLenConstraint() != null) goto L11;
        return Integer.MAX_VALUE;
    L11:
        return this.basicConstraints.getPathLenConstraint().intValue();
    }

    @Override // java.security.cert.X509Extension
    public Set getCriticalExtensionOIDs() {
        if (getVersion() != 3) goto L13;
        HashSet r100 = new HashSet();
        Extensions r101 = this.f525372c.getTBSCertificate().getExtensions();
        if (r101 == null) goto L20;
        Enumeration r102 = r101.oids();
    L8:
        if (r102.hasMoreElements() == false) goto L12;
        ASN1ObjectIdentifier r103 = (ASN1ObjectIdentifier) r102.nextElement();
        if (r101.getExtension(r103).isCritical() == false) goto L8;
        r100.add(r103.getId());
        goto L8
    L12:
        return r100;
    L20:
        return null;
    L13:
        return null;
    }

    @Override // java.security.cert.Certificate
    public byte[] getEncoded() throws CertificateEncodingException {
        return this.f525372c.getEncoded(ASN1Encoding.DER);
    L4:
        e = move-exception;
        throw new CertificateEncodingException(e.toString());
    }

    @Override // java.security.cert.X509Certificate
    public List getExtendedKeyUsage() throws CertificateParsingException {
        byte[] r100 = getExtensionOctets(this.f525372c, "2.5.29.37");
        if (r100 != null) goto L14;
        return null;
    L14:
        ASN1Sequence r101 = ASN1Sequence.getInstance(ASN1Primitive.fromByteArray(r100));     // Catch: Exception -> L12
        ArrayList r102 = new ArrayList();     // Catch: Exception -> L12
        int r103 = 0;
    L8:
        if (r103 == r101.size()) goto L10;
        r102.add(((ASN1ObjectIdentifier) r101.getObjectAt(r103)).getId());     // Catch: Exception -> L12
        r103 = r103 + 1;     // Catch: Exception -> L12
        goto L8
    L10:
        return Collections.unmodifiableList(r102);
    L13:
        throw new CertificateParsingException("error processing extended key usage extension");
    }

    @Override // java.security.cert.X509Extension
    public byte[] getExtensionValue(String r100) {
        ASN1OctetString r101 = getExtensionValue(this.f525372c, r100);
        if (r101 != null) goto L11;
        return null;
    L11:
        return r101.getEncoded();
    L6:
        e = move-exception;
        throw new IllegalStateException("error parsing " + e.toString());
    }

    @Override // java.security.cert.X509Certificate
    public Collection getIssuerAlternativeNames() throws CertificateParsingException {
        return getAlternativeNames(this.f525372c, Extension.issuerAlternativeName.getId());
    }

    @Override // java.security.cert.X509Certificate
    public Principal getIssuerDN() {
        return new X509Principal(this.f525372c.getIssuer());
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getIssuerUniqueID() {
        DERBitString r100 = this.f525372c.getTBSCertificate().getIssuerUniqueId();
        if (r100 == null) goto L12;
        byte[] r101 = r100.getBytes();
        int r102 = (r101.length * 8) - r100.getPadBits();
        boolean[] r103 = new boolean[r102];
        int r104 = 0;
    L5:
        if (r104 == r102) goto L11;
        if ((r101[r104 / 8] & (128 >>> (r104 % 8))) == 0) goto L9;
        boolean r105 = true;
    L10:
        r103[r104] = r105;
        r104 = r104 + 1;
        goto L5
    L9:
        r105 = false;
        goto L10
    L11:
        return r103;
    L12:
        return null;
    }

    @Override // org.bouncycastle.jcajce.interfaces.BCX509Certificate
    public X500Name getIssuerX500Name() {
        return this.f525372c.getIssuer();
    }

    @Override // java.security.cert.X509Certificate
    public X500Principal getIssuerX500Principal() {
        return new X500Principal(this.f525372c.getIssuer().getEncoded(ASN1Encoding.DER));
    L5:
        throw new IllegalStateException("can't encode issuer DN");
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getKeyUsage() {
        return Arrays.clone(this.keyUsage);
    }

    @Override // java.security.cert.X509Extension
    public Set getNonCriticalExtensionOIDs() {
        if (getVersion() != 3) goto L13;
        HashSet r100 = new HashSet();
        Extensions r101 = this.f525372c.getTBSCertificate().getExtensions();
        if (r101 == null) goto L20;
        Enumeration r102 = r101.oids();
    L8:
        if (r102.hasMoreElements() == false) goto L12;
        ASN1ObjectIdentifier r103 = (ASN1ObjectIdentifier) r102.nextElement();
        if (r101.getExtension(r103).isCritical() == true) goto L8;
        r100.add(r103.getId());
        goto L8
    L12:
        return r100;
    L20:
        return null;
    L13:
        return null;
    }

    @Override // java.security.cert.X509Certificate
    public Date getNotAfter() {
        return this.f525372c.getEndDate().getDate();
    }

    @Override // java.security.cert.X509Certificate
    public Date getNotBefore() {
        return this.f525372c.getStartDate().getDate();
    }

    @Override // java.security.cert.Certificate
    public PublicKey getPublicKey() {
        return BouncyCastleProvider.getPublicKey(this.f525372c.getSubjectPublicKeyInfo());
    L4:
        return null;
    }

    @Override // java.security.cert.X509Certificate
    public BigInteger getSerialNumber() {
        return this.f525372c.getSerialNumber().getValue();
    }

    @Override // java.security.cert.X509Certificate
    public String getSigAlgName() {
        return this.sigAlgName;
    }

    @Override // java.security.cert.X509Certificate
    public String getSigAlgOID() {
        return this.f525372c.getSignatureAlgorithm().getAlgorithm().getId();
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getSigAlgParams() {
        return Arrays.clone(this.sigAlgParams);
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getSignature() {
        return this.f525372c.getSignature().getOctets();
    }

    @Override // java.security.cert.X509Certificate
    public Collection getSubjectAlternativeNames() throws CertificateParsingException {
        return getAlternativeNames(this.f525372c, Extension.subjectAlternativeName.getId());
    }

    @Override // java.security.cert.X509Certificate
    public Principal getSubjectDN() {
        return new X509Principal(this.f525372c.getSubject());
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getSubjectUniqueID() {
        DERBitString r100 = this.f525372c.getTBSCertificate().getSubjectUniqueId();
        if (r100 == null) goto L12;
        byte[] r101 = r100.getBytes();
        int r102 = (r101.length * 8) - r100.getPadBits();
        boolean[] r103 = new boolean[r102];
        int r104 = 0;
    L5:
        if (r104 == r102) goto L11;
        if ((r101[r104 / 8] & (128 >>> (r104 % 8))) == 0) goto L9;
        boolean r105 = true;
    L10:
        r103[r104] = r105;
        r104 = r104 + 1;
        goto L5
    L9:
        r105 = false;
        goto L10
    L11:
        return r103;
    L12:
        return null;
    }

    @Override // org.bouncycastle.jcajce.interfaces.BCX509Certificate
    public X500Name getSubjectX500Name() {
        return this.f525372c.getSubject();
    }

    @Override // java.security.cert.X509Certificate
    public X500Principal getSubjectX500Principal() {
        return new X500Principal(this.f525372c.getSubject().getEncoded(ASN1Encoding.DER));
    L5:
        throw new IllegalStateException("can't encode subject DN");
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getTBSCertificate() throws CertificateEncodingException {
        return this.f525372c.getTBSCertificate().getEncoded(ASN1Encoding.DER);
    L4:
        e = move-exception;
        throw new CertificateEncodingException(e.toString());
    }

    @Override // org.bouncycastle.jcajce.interfaces.BCX509Certificate
    public TBSCertificate getTBSCertificateNative() {
        return this.f525372c.getTBSCertificate();
    }

    @Override // java.security.cert.X509Certificate
    public int getVersion() {
        return this.f525372c.getVersionNumber();
    }

    @Override // java.security.cert.X509Extension
    public boolean hasUnsupportedCriticalExtension() {
        if (getVersion() != 3) goto L36;
        Extensions r100 = this.f525372c.getTBSCertificate().getExtensions();
        if (r100 == null) goto L64;
        Enumeration r101 = r100.oids();
    L8:
        if (r101.hasMoreElements() == false) goto L65;
        ASN1ObjectIdentifier r102 = (ASN1ObjectIdentifier) r101.nextElement();
        if (r102.equals(Extension.keyUsage) == true) goto L8;
        if (r102.equals(Extension.certificatePolicies) == true) goto L8;
        if (r102.equals(Extension.policyMappings) == true) goto L8;
        if (r102.equals(Extension.inhibitAnyPolicy) == true) goto L8;
        if (r102.equals(Extension.cRLDistributionPoints) == true) goto L8;
        if (r102.equals(Extension.issuingDistributionPoint) == true) goto L8;
        if (r102.equals(Extension.deltaCRLIndicator) == true) goto L8;
        if (r102.equals(Extension.policyConstraints) == true) goto L8;
        if (r102.equals(Extension.basicConstraints) == true) goto L8;
        if (r102.equals(Extension.subjectAlternativeName) == true) goto L8;
        if (r102.equals(Extension.nameConstraints) == true) goto L8;
        if (r100.getExtension(r102).isCritical() == false) goto L8;
        return true;
    L65:
        return false;
    L64:
        return false;
    L36:
        return false;
    }

    @Override // java.security.cert.Certificate
    public String toString() {
        StringBuffer r100 = new StringBuffer();
        String r101 = Strings.lineSeparator();
        r100.append("  [0]         Version: ");
        r100.append(getVersion());
        r100.append(r101);
        r100.append("         SerialNumber: ");
        r100.append(getSerialNumber());
        r100.append(r101);
        r100.append("             IssuerDN: ");
        r100.append(getIssuerDN());
        r100.append(r101);
        r100.append("           Start Date: ");
        r100.append(getNotBefore());
        r100.append(r101);
        r100.append("           Final Date: ");
        r100.append(getNotAfter());
        r100.append(r101);
        r100.append("            SubjectDN: ");
        r100.append(getSubjectDN());
        r100.append(r101);
        r100.append("           Public Key: ");
        r100.append(getPublicKey());
        r100.append(r101);
        r100.append("  Signature Algorithm: ");
        r100.append(getSigAlgName());
        r100.append(r101);
        X509SignatureUtil.prettyPrintSignature(getSignature(), r100, r101);
        Extensions r102 = this.f525372c.getTBSCertificate().getExtensions();
        if (r102 == null) goto L34;
        Enumeration r103 = r102.oids();
        if (r103.hasMoreElements() == false) goto L8;
        r100.append("       Extensions: \n");
    L8:
        if (r103.hasMoreElements() == false) goto L34;
        ASN1ObjectIdentifier r104 = (ASN1ObjectIdentifier) r103.nextElement();
        Extension r105 = r102.getExtension(r104);
        if (r105.getExtnValue() == null) goto L32;
        ASN1InputStream r106 = new ASN1InputStream(r105.getExtnValue().getOctets());
        r100.append("                       critical(");
        r100.append(r105.isCritical());
        r100.append(") ");
        if (r104.equals(Extension.basicConstraints) == false) goto L18;
        Object r107 = BasicConstraints.getInstance(r106.readObject());     // Catch: Exception -> L31
    L15:
        r100.append(r107);     // Catch: Exception -> L31
    L16:
        r100.append(r101);     // Catch: Exception -> L31
        goto L8
    L18:
        if (r104.equals(Extension.keyUsage) == false) goto L21;
        r107 = KeyUsage.getInstance(r106.readObject());     // Catch: Exception -> L31
        goto L15
    L21:
        if (r104.equals(MiscObjectIdentifiers.netscapeCertType) == false) goto L24;
        r107 = new NetscapeCertType(DERBitString.getInstance(r106.readObject()));     // Catch: Exception -> L31
        goto L15
    L24:
        if (r104.equals(MiscObjectIdentifiers.netscapeRevocationURL) == false) goto L27;
        r107 = new NetscapeRevocationURL(DERIA5String.getInstance(r106.readObject()));     // Catch: Exception -> L31
        goto L15
    L27:
        if (r104.equals(MiscObjectIdentifiers.verisignCzagExtension) == false) goto L29;
        r107 = new VerisignCzagExtension(DERIA5String.getInstance(r106.readObject()));     // Catch: Exception -> L31
        goto L15
    L29:
        r100.append(r104.getId());     // Catch: Exception -> L31
        r100.append(" value = ");     // Catch: Exception -> L31
        r100.append(ASN1Dump.dumpAsString(r106.readObject()));     // Catch: Exception -> L31
    L31:
        r100.append(r104.getId());
        r100.append(" value = ");
        r100.append("*****");
    L32:
        r100.append(r101);
    L34:
        return r100.toString();
    }

    @Override // java.security.cert.Certificate
    public final void verify(PublicKey r100) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        doVerify(r100, new AnonymousClass1(this));
    }

    @Override // java.security.cert.Certificate
    public final void verify(PublicKey r100, final String r101) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        doVerify(r100, new AnonymousClass2(this, r101));
    }

    @Override // java.security.cert.X509Certificate, java.security.cert.Certificate
    public final void verify(PublicKey r100, final Provider r101) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        doVerify(r100, new AnonymousClass3(this, r101));     // Catch: NoSuchProviderException -> L4
        return;
    L4:
        e = move-exception;
        throw new NoSuchAlgorithmException("provider issue: " + e.getMessage());
    }
}
