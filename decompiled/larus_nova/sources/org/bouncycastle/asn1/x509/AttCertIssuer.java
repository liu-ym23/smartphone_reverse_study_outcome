package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;

/* JADX INFO: loaded from: classes42.dex */
public class AttCertIssuer extends ASN1Object implements ASN1Choice {
    ASN1Primitive choiceObj;
    ASN1Encodable obj;

    public AttCertIssuer(GeneralNames r100) {
        this.obj = r100;
        this.choiceObj = r100.toASN1Primitive();
    }

    public AttCertIssuer(V2Form r100) {
        this.obj = r100;
        this.choiceObj = new DERTaggedObject(false, 0, r100);
    }

    public static AttCertIssuer getInstance(Object r100) {
        if (r100 == null) goto L25;
        if ((r100 instanceof AttCertIssuer) == true) goto L25;
        if ((r100 instanceof V2Form) == false) goto L11;
        return new AttCertIssuer(V2Form.getInstance(r100));
    L11:
        if ((r100 instanceof GeneralNames) == false) goto L15;
        return new AttCertIssuer((GeneralNames) r100);
    L15:
        if ((r100 instanceof ASN1TaggedObject) == false) goto L19;
        return new AttCertIssuer(V2Form.getInstance((ASN1TaggedObject) r100, false));
    L19:
        if ((r100 instanceof ASN1Sequence) == false) goto L23;
        return new AttCertIssuer(GeneralNames.getInstance(r100));
    L23:
        throw new IllegalArgumentException("unknown object in factory: ".concat(r100.getClass().getName()));
    L25:
        return (AttCertIssuer) r100;
    }

    public static AttCertIssuer getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(r100.getObject());
    }

    public ASN1Encodable getIssuer() {
        return this.obj;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.choiceObj;
    }
}
