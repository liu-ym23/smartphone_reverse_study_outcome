package org.bouncycastle.asn1.ess;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.IssuerSerial;

/* JADX INFO: loaded from: classes42.dex */
public class ESSCertID extends ASN1Object {
    private ASN1OctetString certHash;
    private IssuerSerial issuerSerial;

    private ESSCertID(ASN1Sequence r100) {
        if (r100.size() < 1) goto L11;
        if (r100.size() > 2) goto L11;
        this.certHash = ASN1OctetString.getInstance(r100.getObjectAt(0));
        if (r100.size() <= 1) goto L12;
        this.issuerSerial = IssuerSerial.getInstance(r100.getObjectAt(1));
        return;
    L12:
        return;
    L11:
        throw new IllegalArgumentException("Bad sequence size: " + r100.size());
    }

    public ESSCertID(byte[] r100) {
        this.certHash = new DEROctetString(r100);
    }

    public ESSCertID(byte[] r100, IssuerSerial r101) {
        this.certHash = new DEROctetString(r100);
        this.issuerSerial = r101;
    }

    public static ESSCertID getInstance(Object r100) {
        if ((r100 instanceof ESSCertID) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new ESSCertID(ASN1Sequence.getInstance(r100));
    L5:
        return (ESSCertID) r100;
    }

    public byte[] getCertHash() {
        return this.certHash.getOctets();
    }

    public IssuerSerial getIssuerSerial() {
        return this.issuerSerial;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.certHash);
        IssuerSerial r101 = this.issuerSerial;
        if (r101 == null) goto L6;
        r100.add(r101);
    L6:
        return new DERSequence(r100);
    }
}
