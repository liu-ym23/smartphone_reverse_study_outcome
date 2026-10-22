package org.bouncycastle.asn1.esf;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class CompleteRevocationRefs extends ASN1Object {
    private ASN1Sequence crlOcspRefs;

    private CompleteRevocationRefs(ASN1Sequence r100) {
        Enumeration r101 = r100.getObjects();
    L4:
        if (r101.hasMoreElements() == false) goto L6;
        CrlOcspRef.getInstance(r101.nextElement());
        goto L4
    L6:
        this.crlOcspRefs = r100;
    }

    public CompleteRevocationRefs(CrlOcspRef[] r100) {
        this.crlOcspRefs = new DERSequence(r100);
    }

    public static CompleteRevocationRefs getInstance(Object r100) {
        if ((r100 instanceof CompleteRevocationRefs) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new CompleteRevocationRefs(ASN1Sequence.getInstance(r100));
    L5:
        return (CompleteRevocationRefs) r100;
    }

    public CrlOcspRef[] getCrlOcspRefs() {
        int r100 = this.crlOcspRefs.size();
        CrlOcspRef[] r101 = new CrlOcspRef[r100];
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L5;
        r101[r102] = CrlOcspRef.getInstance(this.crlOcspRefs.getObjectAt(r102));
        r102 = r102 + 1;
        goto L3
    L5:
        return r101;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.crlOcspRefs;
    }
}
