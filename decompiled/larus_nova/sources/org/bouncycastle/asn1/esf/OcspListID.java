package org.bouncycastle.asn1.esf;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class OcspListID extends ASN1Object {
    private ASN1Sequence ocspResponses;

    private OcspListID(ASN1Sequence r100) {
        if (r100.size() != 1) goto L10;
        ASN1Sequence r101 = (ASN1Sequence) r100.getObjectAt(0);
        this.ocspResponses = r101;
        Enumeration r102 = r101.getObjects();
    L6:
        if (r102.hasMoreElements() == false) goto L8;
        OcspResponsesID.getInstance(r102.nextElement());
        goto L6
    L8:
        return;
    L10:
        throw new IllegalArgumentException("Bad sequence size: " + r100.size());
    }

    public OcspListID(OcspResponsesID[] r100) {
        this.ocspResponses = new DERSequence(r100);
    }

    public static OcspListID getInstance(Object r100) {
        if ((r100 instanceof OcspListID) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new OcspListID(ASN1Sequence.getInstance(r100));
    L5:
        return (OcspListID) r100;
    }

    public OcspResponsesID[] getOcspResponses() {
        int r100 = this.ocspResponses.size();
        OcspResponsesID[] r101 = new OcspResponsesID[r100];
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L5;
        r101[r102] = OcspResponsesID.getInstance(this.ocspResponses.getObjectAt(r102));
        r102 = r102 + 1;
        goto L3
    L5:
        return r101;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.ocspResponses);
    }
}
