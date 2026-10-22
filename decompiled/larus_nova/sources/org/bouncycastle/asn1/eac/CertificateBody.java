package org.bouncycastle.asn1.eac;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1ApplicationSpecific;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERApplicationSpecific;
import org.bouncycastle.asn1.DEROctetString;

/* JADX INFO: loaded from: classes42.dex */
public class CertificateBody extends ASN1Object {
    private static final int CAR = 2;
    private static final int CEfD = 32;
    private static final int CExD = 64;
    private static final int CHA = 16;
    private static final int CHR = 8;
    private static final int CPI = 1;
    private static final int PK = 4;
    public static final int profileType = 127;
    public static final int requestType = 13;
    private ASN1ApplicationSpecific certificateEffectiveDate;
    private ASN1ApplicationSpecific certificateExpirationDate;
    private CertificateHolderAuthorization certificateHolderAuthorization;
    private ASN1ApplicationSpecific certificateHolderReference;
    private ASN1ApplicationSpecific certificateProfileIdentifier;
    private int certificateType;
    private ASN1ApplicationSpecific certificationAuthorityReference;
    private PublicKeyDataObject publicKey;
    ASN1InputStream seq;

    private CertificateBody(ASN1ApplicationSpecific r100) throws IOException {
        this.certificateType = 0;
        setIso7816CertificateBody(r100);
    }

    public CertificateBody(ASN1ApplicationSpecific r100, CertificationAuthorityReference r101, PublicKeyDataObject r102, CertificateHolderReference r103, CertificateHolderAuthorization r104, PackedDate r105, PackedDate r106) {
        this.certificateType = 0;
        setCertificateProfileIdentifier(r100);
        setCertificationAuthorityReference(new DERApplicationSpecific(2, r101.getEncoded()));
        setPublicKey(r102);
        setCertificateHolderReference(new DERApplicationSpecific(32, r103.getEncoded()));
        setCertificateHolderAuthorization(r104);
        setCertificateEffectiveDate(new DERApplicationSpecific(false, 37, new DEROctetString(r105.getEncoding())));     // Catch: IOException -> L5
        setCertificateExpirationDate(new DERApplicationSpecific(false, 36, new DEROctetString(r106.getEncoding())));     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        throw new IllegalArgumentException("unable to encode dates: " + e.getMessage());
    }

    public static CertificateBody getInstance(Object r100) throws IOException {
        if ((r100 instanceof CertificateBody) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new CertificateBody(ASN1ApplicationSpecific.getInstance(r100));
    L5:
        return (CertificateBody) r100;
    }

    private ASN1Primitive profileToASN1Object() throws IOException {
        ASN1EncodableVector r100 = new ASN1EncodableVector(7);
        r100.add(this.certificateProfileIdentifier);
        r100.add(this.certificationAuthorityReference);
        r100.add(new DERApplicationSpecific(false, 73, this.publicKey));
        r100.add(this.certificateHolderReference);
        r100.add(this.certificateHolderAuthorization);
        r100.add(this.certificateEffectiveDate);
        r100.add(this.certificateExpirationDate);
        return new DERApplicationSpecific(78, r100);
    }

    private ASN1Primitive requestToASN1Object() throws IOException {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        r100.add(this.certificateProfileIdentifier);
        r100.add(new DERApplicationSpecific(false, 73, this.publicKey));
        r100.add(this.certificateHolderReference);
        return new DERApplicationSpecific(78, r100);
    }

    private void setCertificateEffectiveDate(ASN1ApplicationSpecific r100) throws IllegalArgumentException {
        if (r100.getApplicationTag() != 37) goto L7;
        this.certificateEffectiveDate = r100;
        this.certificateType |= 32;
        return;
    L7:
        throw new IllegalArgumentException("Not an Iso7816Tags.APPLICATION_EFFECTIVE_DATE tag :" + EACTags.encodeTag(r100));
    }

    private void setCertificateExpirationDate(ASN1ApplicationSpecific r100) throws IllegalArgumentException {
        if (r100.getApplicationTag() != 36) goto L7;
        this.certificateExpirationDate = r100;
        this.certificateType |= 64;
        return;
    L7:
        throw new IllegalArgumentException("Not an Iso7816Tags.APPLICATION_EXPIRATION_DATE tag");
    }

    private void setCertificateHolderAuthorization(CertificateHolderAuthorization r100) {
        this.certificateHolderAuthorization = r100;
        this.certificateType |= 16;
    }

    private void setCertificateHolderReference(ASN1ApplicationSpecific r100) throws IllegalArgumentException {
        if (r100.getApplicationTag() != 32) goto L7;
        this.certificateHolderReference = r100;
        this.certificateType |= 8;
        return;
    L7:
        throw new IllegalArgumentException("Not an Iso7816Tags.CARDHOLDER_NAME tag");
    }

    private void setCertificateProfileIdentifier(ASN1ApplicationSpecific r100) throws IllegalArgumentException {
        if (r100.getApplicationTag() != 41) goto L7;
        this.certificateProfileIdentifier = r100;
        this.certificateType |= 1;
        return;
    L7:
        throw new IllegalArgumentException("Not an Iso7816Tags.INTERCHANGE_PROFILE tag :" + EACTags.encodeTag(r100));
    }

    private void setCertificationAuthorityReference(ASN1ApplicationSpecific r100) throws IllegalArgumentException {
        if (r100.getApplicationTag() != 2) goto L7;
        this.certificationAuthorityReference = r100;
        this.certificateType |= 2;
        return;
    L7:
        throw new IllegalArgumentException("Not an Iso7816Tags.ISSUER_IDENTIFICATION_NUMBER tag");
    }

    private void setIso7816CertificateBody(ASN1ApplicationSpecific r100) throws IOException {
        if (r100.getApplicationTag() != 78) goto L37;
        ASN1InputStream r101 = new ASN1InputStream(r100.getContents());
    L5:
        ASN1Primitive r102 = r101.readObject();
        if (r102 == null) goto L34;
        if ((r102 instanceof ASN1ApplicationSpecific) == false) goto L33;
        ASN1ApplicationSpecific r103 = (ASN1ApplicationSpecific) r102;
        int r104 = r103.getApplicationTag();
        if (r104 != 2) goto L12;
        setCertificationAuthorityReference(r103);
        goto L5
    L12:
        if (r104 != 32) goto L14;
        setCertificateHolderReference(r103);
        goto L5
    L14:
        if (r104 != 41) goto L16;
        setCertificateProfileIdentifier(r103);
        goto L5
    L16:
        if (r104 != 73) goto L18;
        setPublicKey(PublicKeyDataObject.getInstance(r103.getObject(16)));
        goto L5
    L18:
        if (r104 != 76) goto L20;
        setCertificateHolderAuthorization(new CertificateHolderAuthorization(r103));
        goto L5
    L20:
        if (r104 != 36) goto L22;
        setCertificateExpirationDate(r103);
        goto L5
    L22:
        if (r104 != 37) goto L24;
        setCertificateEffectiveDate(r103);
        goto L5
    L24:
        this.certificateType = 0;
        throw new IOException("Not a valid iso7816 ASN1ApplicationSpecific tag " + r103.getApplicationTag());
    L33:
        throw new IOException("Not a valid iso7816 content : not a ASN1ApplicationSpecific Object :" + EACTags.encodeTag(r100) + r102.getClass());
    L34:
        r101.close();
        return;
    L37:
        throw new IOException("Bad tag : not an iso7816 CERTIFICATE_CONTENT_TEMPLATE");
    }

    private void setPublicKey(PublicKeyDataObject r100) {
        this.publicKey = PublicKeyDataObject.getInstance(r100);
        this.certificateType |= 4;
    }

    public PackedDate getCertificateEffectiveDate() {
        if ((this.certificateType & 32) == 32) goto L5;
        return null;
    L5:
        return new PackedDate(this.certificateEffectiveDate.getContents());
    }

    public PackedDate getCertificateExpirationDate() throws IOException {
        if ((this.certificateType & 64) != 64) goto L7;
        return new PackedDate(this.certificateExpirationDate.getContents());
    L7:
        throw new IOException("certificate Expiration Date not set");
    }

    public CertificateHolderAuthorization getCertificateHolderAuthorization() throws IOException {
        if ((this.certificateType & 16) != 16) goto L7;
        return this.certificateHolderAuthorization;
    L7:
        throw new IOException("Certificate Holder Authorisation not set");
    }

    public CertificateHolderReference getCertificateHolderReference() {
        return new CertificateHolderReference(this.certificateHolderReference.getContents());
    }

    public ASN1ApplicationSpecific getCertificateProfileIdentifier() {
        return this.certificateProfileIdentifier;
    }

    public int getCertificateType() {
        return this.certificateType;
    }

    public CertificationAuthorityReference getCertificationAuthorityReference() throws IOException {
        if ((this.certificateType & 2) != 2) goto L7;
        return new CertificationAuthorityReference(this.certificationAuthorityReference.getContents());
    L7:
        throw new IOException("Certification authority reference not set");
    }

    public PublicKeyDataObject getPublicKey() {
        return this.publicKey;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        int r100 = this.certificateType;     // Catch: IOException -> L11
        if (r100 != 127) goto L8;
        return profileToASN1Object();
    L8:
        if (r100 == 13) goto L10;
        return null;
    L10:
        return requestToASN1Object();
    L14:
        return null;
    }
}
