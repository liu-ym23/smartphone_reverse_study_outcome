package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class CertRequest extends ASN1Object {
    private ASN1Integer certReqId;
    private CertTemplate certTemplate;
    private Controls controls;

    public CertRequest(int r100, CertTemplate r101, Controls r102) {
        this(new ASN1Integer(r100), r101, r102);
    }

    public CertRequest(ASN1Integer r100, CertTemplate r101, Controls r102) {
        this.certReqId = r100;
        this.certTemplate = r101;
        this.controls = r102;
    }

    private CertRequest(ASN1Sequence r100) {
        this.certReqId = new ASN1Integer(ASN1Integer.getInstance(r100.getObjectAt(0)).getValue());
        this.certTemplate = CertTemplate.getInstance(r100.getObjectAt(1));
        if (r100.size() <= 2) goto L6;
        this.controls = Controls.getInstance(r100.getObjectAt(2));
        return;
    }

    public static CertRequest getInstance(Object r100) {
        if ((r100 instanceof CertRequest) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new CertRequest(ASN1Sequence.getInstance(r100));
    L5:
        return (CertRequest) r100;
    }

    public ASN1Integer getCertReqId() {
        return this.certReqId;
    }

    public CertTemplate getCertTemplate() {
        return this.certTemplate;
    }

    public Controls getControls() {
        return this.controls;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        r100.add(this.certReqId);
        r100.add(this.certTemplate);
        Controls r101 = this.controls;
        if (r101 == null) goto L6;
        r100.add(r101);
    L6:
        return new DERSequence(r100);
    }
}
