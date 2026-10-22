package org.bouncycastle.asn1.est;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class CsrAttrs extends ASN1Object {
    private final AttrOrOID[] attrOrOIDs;

    private CsrAttrs(ASN1Sequence r100) {
        this.attrOrOIDs = new AttrOrOID[r100.size()];
        int r101 = 0;
    L4:
        if (r101 == r100.size()) goto L6;
        this.attrOrOIDs[r101] = AttrOrOID.getInstance(r100.getObjectAt(r101));
        r101 = r101 + 1;
        goto L4
    }

    public CsrAttrs(AttrOrOID r100) {
        this.attrOrOIDs = new AttrOrOID[]{r100};
    }

    public CsrAttrs(AttrOrOID[] r100) {
        this.attrOrOIDs = Utils.clone(r100);
    }

    public static CsrAttrs getInstance(Object r100) {
        if ((r100 instanceof CsrAttrs) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new CsrAttrs(ASN1Sequence.getInstance(r100));
    L5:
        return (CsrAttrs) r100;
    }

    public static CsrAttrs getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public AttrOrOID[] getAttrOrOIDs() {
        return Utils.clone(this.attrOrOIDs);
    }

    public int size() {
        return this.attrOrOIDs.length;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.attrOrOIDs);
    }
}
