package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class CAKeyUpdAnnContent extends ASN1Object {
    private CMPCertificate newWithNew;
    private CMPCertificate newWithOld;
    private CMPCertificate oldWithNew;

    private CAKeyUpdAnnContent(ASN1Sequence r100) {
        this.oldWithNew = CMPCertificate.getInstance(r100.getObjectAt(0));
        this.newWithOld = CMPCertificate.getInstance(r100.getObjectAt(1));
        this.newWithNew = CMPCertificate.getInstance(r100.getObjectAt(2));
    }

    public CAKeyUpdAnnContent(CMPCertificate r100, CMPCertificate r101, CMPCertificate r102) {
        this.oldWithNew = r100;
        this.newWithOld = r101;
        this.newWithNew = r102;
    }

    public static CAKeyUpdAnnContent getInstance(Object r100) {
        if ((r100 instanceof CAKeyUpdAnnContent) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new CAKeyUpdAnnContent(ASN1Sequence.getInstance(r100));
    L5:
        return (CAKeyUpdAnnContent) r100;
    }

    public CMPCertificate getNewWithNew() {
        return this.newWithNew;
    }

    public CMPCertificate getNewWithOld() {
        return this.newWithOld;
    }

    public CMPCertificate getOldWithNew() {
        return this.oldWithNew;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        r100.add(this.oldWithNew);
        r100.add(this.newWithOld);
        r100.add(this.newWithNew);
        return new DERSequence(r100);
    }
}
