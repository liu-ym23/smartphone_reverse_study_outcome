package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class AttributeCertificateInfo extends ASN1Object {
    private AttCertValidityPeriod attrCertValidityPeriod;
    private ASN1Sequence attributes;
    private Extensions extensions;
    private Holder holder;
    private AttCertIssuer issuer;
    private DERBitString issuerUniqueID;
    private ASN1Integer serialNumber;
    private AlgorithmIdentifier signature;
    private ASN1Integer version;

    private AttributeCertificateInfo(ASN1Sequence r100) {
        if (r100.size() < 6) goto L24;
        if (r100.size() > 9) goto L24;
        int r101 = 0;
        if ((r100.getObjectAt(0) instanceof ASN1Integer) == false) goto L9;
        this.version = ASN1Integer.getInstance(r100.getObjectAt(0));
        r101 = 1;
    L10:
        this.holder = Holder.getInstance(r100.getObjectAt(r101));
        this.issuer = AttCertIssuer.getInstance(r100.getObjectAt(r101 + 1));
        this.signature = AlgorithmIdentifier.getInstance(r100.getObjectAt(r101 + 2));
        this.serialNumber = ASN1Integer.getInstance(r100.getObjectAt(r101 + 3));
        this.attrCertValidityPeriod = AttCertValidityPeriod.getInstance(r100.getObjectAt(r101 + 4));
        this.attributes = ASN1Sequence.getInstance(r100.getObjectAt(r101 + 5));
        int r102 = r101 + 6;
    L12:
        if (r102 >= r100.size()) goto L22;
        ASN1Encodable r103 = r100.getObjectAt(r102);
        if ((r103 instanceof DERBitString) == false) goto L17;
        this.issuerUniqueID = DERBitString.getInstance(r100.getObjectAt(r102));
    L21:
        r102 = r102 + 1;
        goto L12
    L17:
        if ((r103 instanceof ASN1Sequence) == false) goto L19;
    L20:
        this.extensions = Extensions.getInstance(r100.getObjectAt(r102));
        goto L21
    L19:
        if ((r103 instanceof Extensions) == false) goto L21;
    L22:
        return;
    L9:
        this.version = new ASN1Integer(0);
    L24:
        throw new IllegalArgumentException("Bad sequence size: " + r100.size());
    }

    public static AttributeCertificateInfo getInstance(Object r100) {
        if ((r100 instanceof AttributeCertificateInfo) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new AttributeCertificateInfo(ASN1Sequence.getInstance(r100));
    L5:
        return (AttributeCertificateInfo) r100;
    }

    public static AttributeCertificateInfo getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public AttCertValidityPeriod getAttrCertValidityPeriod() {
        return this.attrCertValidityPeriod;
    }

    public ASN1Sequence getAttributes() {
        return this.attributes;
    }

    public Extensions getExtensions() {
        return this.extensions;
    }

    public Holder getHolder() {
        return this.holder;
    }

    public AttCertIssuer getIssuer() {
        return this.issuer;
    }

    public DERBitString getIssuerUniqueID() {
        return this.issuerUniqueID;
    }

    public ASN1Integer getSerialNumber() {
        return this.serialNumber;
    }

    public AlgorithmIdentifier getSignature() {
        return this.signature;
    }

    public ASN1Integer getVersion() {
        return this.version;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(9);
        if (this.version.intValueExact() == 0) goto L5;
        r100.add(this.version);
    L5:
        r100.add(this.holder);
        r100.add(this.issuer);
        r100.add(this.signature);
        r100.add(this.serialNumber);
        r100.add(this.attrCertValidityPeriod);
        r100.add(this.attributes);
        DERBitString r101 = this.issuerUniqueID;
        if (r101 == null) goto L8;
        r100.add(r101);
    L8:
        Extensions r102 = this.extensions;
        if (r102 == null) goto L12;
        r100.add(r102);
    L12:
        return new DERSequence(r100);
    }
}
