package org.bouncycastle.asn1.esf;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class CrlListID extends ASN1Object {
    private ASN1Sequence crls;

    private CrlListID(ASN1Sequence r100) {
        ASN1Sequence r101 = (ASN1Sequence) r100.getObjectAt(0);
        this.crls = r101;
        Enumeration r102 = r101.getObjects();
    L4:
        if (r102.hasMoreElements() == false) goto L6;
        CrlValidatedID.getInstance(r102.nextElement());
        goto L4
    }

    public CrlListID(CrlValidatedID[] r100) {
        this.crls = new DERSequence(r100);
    }

    public static CrlListID getInstance(Object r100) {
        if ((r100 instanceof CrlListID) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new CrlListID(ASN1Sequence.getInstance(r100));
    L5:
        return (CrlListID) r100;
    }

    public CrlValidatedID[] getCrls() {
        int r100 = this.crls.size();
        CrlValidatedID[] r101 = new CrlValidatedID[r100];
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L5;
        r101[r102] = CrlValidatedID.getInstance(this.crls.getObjectAt(r102));
        r102 = r102 + 1;
        goto L3
    L5:
        return r101;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.crls);
    }
}
