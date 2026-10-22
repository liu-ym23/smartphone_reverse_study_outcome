package org.bouncycastle.asn1.x509;

import com.ss.android.lark.widget.codeblock.entity.LineContent;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes42.dex */
public class DistributionPoint extends ASN1Object {
    GeneralNames cRLIssuer;
    DistributionPointName distributionPoint;
    ReasonFlags reasons;

    public DistributionPoint(ASN1Sequence r100) {
        int r101 = 0;
    L4:
        if (r101 == r100.size()) goto L16;
        ASN1TaggedObject r102 = ASN1TaggedObject.getInstance(r100.getObjectAt(r101));
        int r103 = r102.getTagNo();
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L9;
        this.reasons = new ReasonFlags(DERBitString.getInstance(r102, false));
    L15:
        r101 = r101 + 1;
        goto L4
    L9:
        if (r103 != 2) goto L12;
        this.cRLIssuer = GeneralNames.getInstance(r102, false);
        goto L15
    L12:
        throw new IllegalArgumentException("Unknown tag encountered in structure: " + r102.getTagNo());
    L14:
        this.distributionPoint = DistributionPointName.getInstance(r102, true);
        goto L15
    }

    public DistributionPoint(DistributionPointName r100, ReasonFlags r101, GeneralNames r102) {
        this.distributionPoint = r100;
        this.reasons = r101;
        this.cRLIssuer = r102;
    }

    private void appendObject(StringBuffer r100, String r101, String r102, String r103) {
        r100.append(LineContent.FOUR_SPACE);
        r100.append(r102);
        r100.append(":");
        r100.append(r101);
        r100.append(LineContent.FOUR_SPACE);
        r100.append(LineContent.FOUR_SPACE);
        r100.append(r103);
        r100.append(r101);
    }

    public static DistributionPoint getInstance(Object r100) {
        if (r100 == null) goto L13;
        if ((r100 instanceof DistributionPoint) == true) goto L13;
        if ((r100 instanceof ASN1Sequence) == false) goto L11;
        return new DistributionPoint((ASN1Sequence) r100);
    L11:
        throw new IllegalArgumentException("Invalid DistributionPoint: ".concat(r100.getClass().getName()));
    L13:
        return (DistributionPoint) r100;
    }

    public static DistributionPoint getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public GeneralNames getCRLIssuer() {
        return this.cRLIssuer;
    }

    public DistributionPointName getDistributionPoint() {
        return this.distributionPoint;
    }

    public ReasonFlags getReasons() {
        return this.reasons;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        DistributionPointName r101 = this.distributionPoint;
        if (r101 == null) goto L5;
        r100.add(new DERTaggedObject(0, r101));
    L5:
        ReasonFlags r102 = this.reasons;
        if (r102 == null) goto L8;
        r100.add(new DERTaggedObject(false, 1, r102));
    L8:
        GeneralNames r103 = this.cRLIssuer;
        if (r103 == null) goto L12;
        r100.add(new DERTaggedObject(false, 2, r103));
    L12:
        return new DERSequence(r100);
    }

    public String toString() {
        String r100 = Strings.lineSeparator();
        StringBuffer r101 = new StringBuffer();
        r101.append("DistributionPoint: [");
        r101.append(r100);
        DistributionPointName r102 = this.distributionPoint;
        if (r102 == null) goto L5;
        appendObject(r101, r100, "distributionPoint", r102.toString());
    L5:
        ReasonFlags r103 = this.reasons;
        if (r103 == null) goto L8;
        appendObject(r101, r100, "reasons", r103.toString());
    L8:
        GeneralNames r104 = this.cRLIssuer;
        if (r104 == null) goto L11;
        appendObject(r101, r100, "cRLIssuer", r104.toString());
    L11:
        r101.append("]");
        r101.append(r100);
        return r101.toString();
    }
}
