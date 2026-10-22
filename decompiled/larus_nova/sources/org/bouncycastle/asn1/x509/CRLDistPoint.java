package org.bouncycastle.asn1.x509;

import com.ss.android.lark.widget.codeblock.entity.LineContent;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes42.dex */
public class CRLDistPoint extends ASN1Object {
    ASN1Sequence seq;

    private CRLDistPoint(ASN1Sequence r100) {
        this.seq = r100;
    }

    public CRLDistPoint(DistributionPoint[] r100) {
        this.seq = null;
        this.seq = new DERSequence(r100);
    }

    public static CRLDistPoint fromExtensions(Extensions r100) {
        return getInstance(Extensions.getExtensionParsedValue(r100, Extension.cRLDistributionPoints));
    }

    public static CRLDistPoint getInstance(Object r100) {
        if ((r100 instanceof CRLDistPoint) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new CRLDistPoint(ASN1Sequence.getInstance(r100));
    L5:
        return (CRLDistPoint) r100;
    }

    public static CRLDistPoint getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public DistributionPoint[] getDistributionPoints() {
        DistributionPoint[] r100 = new DistributionPoint[this.seq.size()];
        int r101 = 0;
    L4:
        if (r101 == this.seq.size()) goto L6;
        r100[r101] = DistributionPoint.getInstance(this.seq.getObjectAt(r101));
        r101 = r101 + 1;
        goto L4
    L6:
        return r100;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.seq;
    }

    public String toString() {
        StringBuffer r100 = new StringBuffer("CRLDistPoint:");
        String r101 = Strings.lineSeparator();
        r100.append(r101);
        DistributionPoint[] r102 = getDistributionPoints();
        int r103 = 0;
    L4:
        if (r103 == r102.length) goto L7;
        r100.append(LineContent.FOUR_SPACE);
        r100.append(r102[r103]);
        r100.append(r101);
        r103 = r103 + 1;
        goto L4
    L7:
        return r100.toString();
    }
}
