package org.bouncycastle.asn1.x509;

import com.ss.android.lark.widget.codeblock.entity.LineContent;
import org.bouncycastle.asn1.ASN1Boolean;
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
public class IssuingDistributionPoint extends ASN1Object {
    private DistributionPointName distributionPoint;
    private boolean indirectCRL;
    private boolean onlyContainsAttributeCerts;
    private boolean onlyContainsCACerts;
    private boolean onlyContainsUserCerts;
    private ReasonFlags onlySomeReasons;
    private ASN1Sequence seq;

    private IssuingDistributionPoint(ASN1Sequence r100) {
        this.seq = r100;
        int r101 = 0;
    L4:
        if (r101 == r100.size()) goto L25;
        ASN1TaggedObject r102 = ASN1TaggedObject.getInstance(r100.getObjectAt(r101));
        int r103 = r102.getTagNo();
        if (r103 == 0) goto L23;
        if (r103 != 1) goto L9;
        this.onlyContainsUserCerts = ASN1Boolean.getInstance(r102, false).isTrue();
    L24:
        r101 = r101 + 1;
        goto L4
    L9:
        if (r103 != 2) goto L11;
        this.onlyContainsCACerts = ASN1Boolean.getInstance(r102, false).isTrue();
        goto L24
    L11:
        if (r103 != 3) goto L13;
        this.onlySomeReasons = new ReasonFlags(DERBitString.getInstance(r102, false));
        goto L24
    L13:
        if (r103 != 4) goto L15;
        this.indirectCRL = ASN1Boolean.getInstance(r102, false).isTrue();
        goto L24
    L15:
        if (r103 != 5) goto L18;
        this.onlyContainsAttributeCerts = ASN1Boolean.getInstance(r102, false).isTrue();
        goto L24
    L18:
        throw new IllegalArgumentException("unknown tag in IssuingDistributionPoint");
    L23:
        this.distributionPoint = DistributionPointName.getInstance(r102, true);
        goto L24
    }

    public IssuingDistributionPoint(DistributionPointName r100, boolean r101, boolean r110) {
        this(r100, false, false, null, r101, r110);
    }

    public IssuingDistributionPoint(DistributionPointName r100, boolean r101, boolean r102, ReasonFlags r103, boolean r104, boolean r110) {
        this.distributionPoint = r100;
        this.indirectCRL = r104;
        this.onlyContainsAttributeCerts = r110;
        this.onlyContainsCACerts = r102;
        this.onlyContainsUserCerts = r101;
        this.onlySomeReasons = r103;
        ASN1EncodableVector r105 = new ASN1EncodableVector(6);
        if (r100 == null) goto L5;
        r105.add(new DERTaggedObject(true, 0, r100));
    L5:
        if (r101 == false) goto L7;
        r105.add(new DERTaggedObject(false, 1, ASN1Boolean.getInstance(true)));
    L7:
        if (r102 == false) goto L9;
        r105.add(new DERTaggedObject(false, 2, ASN1Boolean.getInstance(true)));
    L9:
        if (r103 == null) goto L11;
        r105.add(new DERTaggedObject(false, 3, r103));
    L11:
        if (r104 == false) goto L13;
        r105.add(new DERTaggedObject(false, 4, ASN1Boolean.getInstance(true)));
    L13:
        if (r110 == false) goto L15;
        r105.add(new DERTaggedObject(false, 5, ASN1Boolean.getInstance(true)));
    L15:
        this.seq = new DERSequence(r105);
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

    private String booleanToString(boolean r100) {
        if (r100 == false) goto L4;
        return "true";
    L4:
        return "false";
    }

    public static IssuingDistributionPoint getInstance(Object r100) {
        if ((r100 instanceof IssuingDistributionPoint) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new IssuingDistributionPoint(ASN1Sequence.getInstance(r100));
    L5:
        return (IssuingDistributionPoint) r100;
    }

    public static IssuingDistributionPoint getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public DistributionPointName getDistributionPoint() {
        return this.distributionPoint;
    }

    public ReasonFlags getOnlySomeReasons() {
        return this.onlySomeReasons;
    }

    public boolean isIndirectCRL() {
        return this.indirectCRL;
    }

    public boolean onlyContainsAttributeCerts() {
        return this.onlyContainsAttributeCerts;
    }

    public boolean onlyContainsCACerts() {
        return this.onlyContainsCACerts;
    }

    public boolean onlyContainsUserCerts() {
        return this.onlyContainsUserCerts;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.seq;
    }

    public String toString() {
        String r100 = Strings.lineSeparator();
        StringBuffer r101 = new StringBuffer();
        r101.append("IssuingDistributionPoint: [");
        r101.append(r100);
        DistributionPointName r102 = this.distributionPoint;
        if (r102 == null) goto L5;
        appendObject(r101, r100, "distributionPoint", r102.toString());
    L5:
        boolean r103 = this.onlyContainsUserCerts;
        if (r103 == false) goto L8;
        appendObject(r101, r100, "onlyContainsUserCerts", booleanToString(r103));
    L8:
        boolean r104 = this.onlyContainsCACerts;
        if (r104 == false) goto L11;
        appendObject(r101, r100, "onlyContainsCACerts", booleanToString(r104));
    L11:
        ReasonFlags r105 = this.onlySomeReasons;
        if (r105 == null) goto L14;
        appendObject(r101, r100, "onlySomeReasons", r105.toString());
    L14:
        boolean r106 = this.onlyContainsAttributeCerts;
        if (r106 == false) goto L17;
        appendObject(r101, r100, "onlyContainsAttributeCerts", booleanToString(r106));
    L17:
        boolean r107 = this.indirectCRL;
        if (r107 == false) goto L20;
        appendObject(r101, r100, "indirectCRL", booleanToString(r107));
    L20:
        r101.append("]");
        r101.append(r100);
        return r101.toString();
    }
}
