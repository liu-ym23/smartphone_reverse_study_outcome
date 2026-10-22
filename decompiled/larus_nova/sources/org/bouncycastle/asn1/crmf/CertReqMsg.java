package org.bouncycastle.asn1.crmf;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class CertReqMsg extends ASN1Object {
    private CertRequest certReq;
    private ProofOfPossession pop;
    private ASN1Sequence regInfo;

    private CertReqMsg(ASN1Sequence r100) {
        Enumeration r101 = r100.getObjects();
        this.certReq = CertRequest.getInstance(r101.nextElement());
    L4:
        if (r101.hasMoreElements() == false) goto L12;
        Object r102 = r101.nextElement();
        if ((r102 instanceof ASN1TaggedObject) == true) goto L11;
        if ((r102 instanceof ProofOfPossession) == true) goto L11;
        this.regInfo = ASN1Sequence.getInstance(r102);
    L11:
        this.pop = ProofOfPossession.getInstance(r102);
        goto L4
    }

    public CertReqMsg(CertRequest r100, ProofOfPossession r101, AttributeTypeAndValue[] r102) {
        if (r100 == null) goto L9;
        this.certReq = r100;
        this.pop = r101;
        if (r102 == null) goto L10;
        this.regInfo = new DERSequence(r102);
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("'certReq' cannot be null");
    }

    private void addOptional(ASN1EncodableVector r100, ASN1Encodable r101) {
        if (r101 == null) goto L5;
        r100.add(r101);
        return;
    }

    public static CertReqMsg getInstance(Object r100) {
        if ((r100 instanceof CertReqMsg) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new CertReqMsg(ASN1Sequence.getInstance(r100));
    L5:
        return (CertReqMsg) r100;
    }

    public static CertReqMsg getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public CertRequest getCertReq() {
        return this.certReq;
    }

    public ProofOfPossession getPop() {
        return this.pop;
    }

    public ProofOfPossession getPopo() {
        return this.pop;
    }

    public AttributeTypeAndValue[] getRegInfo() {
        ASN1Sequence r100 = this.regInfo;
        if (r100 != null) goto L6;
        return null;
    L6:
        int r101 = r100.size();
        AttributeTypeAndValue[] r102 = new AttributeTypeAndValue[r101];
        int r103 = 0;
    L7:
        if (r103 == r101) goto L9;
        r102[r103] = AttributeTypeAndValue.getInstance(this.regInfo.getObjectAt(r103));
        r103 = r103 + 1;
        goto L7
    L9:
        return r102;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        r100.add(this.certReq);
        addOptional(r100, this.pop);
        addOptional(r100, this.regInfo);
        return new DERSequence(r100);
    }
}
