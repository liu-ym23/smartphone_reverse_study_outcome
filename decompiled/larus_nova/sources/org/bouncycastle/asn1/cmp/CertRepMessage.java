package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

/* JADX INFO: loaded from: classes42.dex */
public class CertRepMessage extends ASN1Object {
    private ASN1Sequence caPubs;
    private ASN1Sequence response;

    private CertRepMessage(ASN1Sequence r100) {
        int r101 = 0;
        if (r100.size() <= 1) goto L5;
        this.caPubs = ASN1Sequence.getInstance((ASN1TaggedObject) r100.getObjectAt(0), true);
        r101 = 1;
    L5:
        this.response = ASN1Sequence.getInstance(r100.getObjectAt(r101));
    }

    public CertRepMessage(CMPCertificate[] r100, CertResponse[] r101) {
        if (r101 == null) goto L9;
        if (r100 == null) goto L6;
        this.caPubs = new DERSequence(r100);
    L6:
        this.response = new DERSequence(r101);
        return;
    L9:
        throw new IllegalArgumentException("'response' cannot be null");
    }

    public static CertRepMessage getInstance(Object r100) {
        if ((r100 instanceof CertRepMessage) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new CertRepMessage(ASN1Sequence.getInstance(r100));
    L5:
        return (CertRepMessage) r100;
    }

    public CMPCertificate[] getCaPubs() {
        ASN1Sequence r100 = this.caPubs;
        if (r100 != null) goto L6;
        return null;
    L6:
        int r101 = r100.size();
        CMPCertificate[] r102 = new CMPCertificate[r101];
        int r103 = 0;
    L7:
        if (r103 == r101) goto L9;
        r102[r103] = CMPCertificate.getInstance(this.caPubs.getObjectAt(r103));
        r103 = r103 + 1;
        goto L7
    L9:
        return r102;
    }

    public CertResponse[] getResponse() {
        int r100 = this.response.size();
        CertResponse[] r101 = new CertResponse[r100];
        int r102 = 0;
    L3:
        if (r102 == r100) goto L5;
        r101[r102] = CertResponse.getInstance(this.response.getObjectAt(r102));
        r102 = r102 + 1;
        goto L3
    L5:
        return r101;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        ASN1Sequence r101 = this.caPubs;
        if (r101 == null) goto L5;
        r100.add(new DERTaggedObject(true, 1, r101));
    L5:
        r100.add(this.response);
        return new DERSequence(r100);
    }
}
