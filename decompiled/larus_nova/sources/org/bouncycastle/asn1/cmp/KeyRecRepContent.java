package org.bouncycastle.asn1.cmp;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

/* JADX INFO: loaded from: classes42.dex */
public class KeyRecRepContent extends ASN1Object {
    private ASN1Sequence caCerts;
    private ASN1Sequence keyPairHist;
    private CMPCertificate newSigCert;
    private PKIStatusInfo status;

    private KeyRecRepContent(ASN1Sequence r100) {
        Enumeration r101 = r100.getObjects();
        this.status = PKIStatusInfo.getInstance(r101.nextElement());
    L4:
        if (r101.hasMoreElements() == false) goto L16;
        ASN1TaggedObject r102 = ASN1TaggedObject.getInstance(r101.nextElement());
        int r103 = r102.getTagNo();
        if (r103 != 0) goto L8;
        this.newSigCert = CMPCertificate.getInstance(r102.getObject());
        goto L4
    L8:
        if (r103 != 1) goto L10;
        this.caCerts = ASN1Sequence.getInstance(r102.getObject());
        goto L4
    L10:
        if (r103 != 2) goto L13;
        this.keyPairHist = ASN1Sequence.getInstance(r102.getObject());
        goto L4
    L13:
        throw new IllegalArgumentException("unknown tag number: " + r102.getTagNo());
    }

    private void addOptional(ASN1EncodableVector r100, int r101, ASN1Encodable r102) {
        if (r102 == null) goto L5;
        r100.add(new DERTaggedObject(true, r101, r102));
        return;
    }

    public static KeyRecRepContent getInstance(Object r100) {
        if ((r100 instanceof KeyRecRepContent) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new KeyRecRepContent(ASN1Sequence.getInstance(r100));
    L5:
        return (KeyRecRepContent) r100;
    }

    public CMPCertificate[] getCaCerts() {
        ASN1Sequence r100 = this.caCerts;
        if (r100 != null) goto L6;
        return null;
    L6:
        int r101 = r100.size();
        CMPCertificate[] r102 = new CMPCertificate[r101];
        int r103 = 0;
    L7:
        if (r103 == r101) goto L9;
        r102[r103] = CMPCertificate.getInstance(this.caCerts.getObjectAt(r103));
        r103 = r103 + 1;
        goto L7
    L9:
        return r102;
    }

    public CertifiedKeyPair[] getKeyPairHist() {
        ASN1Sequence r100 = this.keyPairHist;
        if (r100 != null) goto L6;
        return null;
    L6:
        int r101 = r100.size();
        CertifiedKeyPair[] r102 = new CertifiedKeyPair[r101];
        int r103 = 0;
    L7:
        if (r103 == r101) goto L9;
        r102[r103] = CertifiedKeyPair.getInstance(this.keyPairHist.getObjectAt(r103));
        r103 = r103 + 1;
        goto L7
    L9:
        return r102;
    }

    public CMPCertificate getNewSigCert() {
        return this.newSigCert;
    }

    public PKIStatusInfo getStatus() {
        return this.status;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(4);
        r100.add(this.status);
        addOptional(r100, 0, this.newSigCert);
        addOptional(r100, 1, this.caCerts);
        addOptional(r100, 2, this.keyPairHist);
        return new DERSequence(r100);
    }
}
