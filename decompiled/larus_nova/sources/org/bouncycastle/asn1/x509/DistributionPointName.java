package org.bouncycastle.asn1.x509;

import com.ss.android.lark.widget.codeblock.entity.LineContent;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes42.dex */
public class DistributionPointName extends ASN1Object implements ASN1Choice {
    public static final int FULL_NAME = 0;
    public static final int NAME_RELATIVE_TO_CRL_ISSUER = 1;
    ASN1Encodable name;
    int type;

    public DistributionPointName(int r100, ASN1Encodable r101) {
        this.type = r100;
        this.name = r101;
    }

    public DistributionPointName(ASN1TaggedObject r100) {
        int r101 = r100.getTagNo();
        this.type = r101;
        if (r101 != 0) goto L5;
        ASN1Encodable r102 = GeneralNames.getInstance(r100, false);
    L6:
        this.name = r102;
        return;
    L5:
        r102 = ASN1Set.getInstance(r100, false);
        goto L6
    }

    public DistributionPointName(GeneralNames r100) {
        this(0, r100);
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

    public static DistributionPointName getInstance(Object r100) {
        if (r100 == null) goto L13;
        if ((r100 instanceof DistributionPointName) == true) goto L13;
        if ((r100 instanceof ASN1TaggedObject) == false) goto L11;
        return new DistributionPointName((ASN1TaggedObject) r100);
    L11:
        throw new IllegalArgumentException("unknown object in factory: ".concat(r100.getClass().getName()));
    L13:
        return (DistributionPointName) r100;
    }

    public static DistributionPointName getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1TaggedObject.getInstance(r100, true));
    }

    public ASN1Encodable getName() {
        return this.name;
    }

    public int getType() {
        return this.type;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(false, this.type, this.name);
    }

    public String toString() {
        String r100 = Strings.lineSeparator();
        StringBuffer r101 = new StringBuffer();
        r101.append("DistributionPointName: [");
        r101.append(r100);
        if (this.type != 0) goto L5;
        String r102 = this.name.toString();
        String r103 = "fullName";
    L6:
        appendObject(r101, r100, r103, r102);
        r101.append("]");
        r101.append(r100);
        return r101.toString();
    L5:
        r102 = this.name.toString();
        r103 = "nameRelativeToCRLIssuer";
        goto L6
    }
}
