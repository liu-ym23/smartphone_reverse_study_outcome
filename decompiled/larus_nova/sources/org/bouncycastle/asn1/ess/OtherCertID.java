package org.bouncycastle.asn1.ess;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.DigestInfo;
import org.bouncycastle.asn1.x509.IssuerSerial;

/* JADX INFO: loaded from: classes42.dex */
public class OtherCertID extends ASN1Object {
    private IssuerSerial issuerSerial;
    private ASN1Encodable otherCertHash;

    private OtherCertID(ASN1Sequence r100) {
        if (r100.size() < 1) goto L15;
        if (r100.size() > 2) goto L15;
        boolean r101 = r100.getObjectAt(0).toASN1Primitive() instanceof ASN1OctetString;
        ASN1Encodable r102 = r100.getObjectAt(0);
        if (r101 == false) goto L9;
        ASN1Encodable r103 = ASN1OctetString.getInstance(r102);
    L10:
        this.otherCertHash = r103;
        if (r100.size() <= 1) goto L16;
        this.issuerSerial = IssuerSerial.getInstance(r100.getObjectAt(1));
        return;
    L16:
        return;
    L9:
        r103 = DigestInfo.getInstance(r102);
    L15:
        throw new IllegalArgumentException("Bad sequence size: " + r100.size());
    }

    public OtherCertID(AlgorithmIdentifier r100, byte[] r101) {
        this.otherCertHash = new DigestInfo(r100, r101);
    }

    public OtherCertID(AlgorithmIdentifier r100, byte[] r101, IssuerSerial r102) {
        this.otherCertHash = new DigestInfo(r100, r101);
        this.issuerSerial = r102;
    }

    public static OtherCertID getInstance(Object r100) {
        if ((r100 instanceof OtherCertID) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new OtherCertID(ASN1Sequence.getInstance(r100));
    L5:
        return (OtherCertID) r100;
    }

    public AlgorithmIdentifier getAlgorithmHash() {
        if ((this.otherCertHash.toASN1Primitive() instanceof ASN1OctetString) == false) goto L7;
        return new AlgorithmIdentifier(OIWObjectIdentifiers.idSHA1);
    L7:
        return DigestInfo.getInstance(this.otherCertHash).getAlgorithmId();
    }

    public byte[] getCertHash() {
        if ((this.otherCertHash.toASN1Primitive() instanceof ASN1OctetString) == false) goto L7;
        return ((ASN1OctetString) this.otherCertHash.toASN1Primitive()).getOctets();
    L7:
        return DigestInfo.getInstance(this.otherCertHash).getDigest();
    }

    public IssuerSerial getIssuerSerial() {
        return this.issuerSerial;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.otherCertHash);
        IssuerSerial r101 = this.issuerSerial;
        if (r101 == null) goto L6;
        r100.add(r101);
    L6:
        return new DERSequence(r100);
    }
}
