package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;

/* JADX INFO: loaded from: classes42.dex */
public class Target extends ASN1Object implements ASN1Choice {
    public static final int targetGroup = 1;
    public static final int targetName = 0;
    private GeneralName targGroup;
    private GeneralName targName;

    public Target(int r100, GeneralName r101) {
        this(new DERTaggedObject(r100, r101));
    }

    private Target(ASN1TaggedObject r100) {
        int r101 = r100.getTagNo();
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        this.targGroup = GeneralName.getInstance(r100, true);
        return;
    L7:
        throw new IllegalArgumentException("unknown tag: " + r100.getTagNo());
    L8:
        this.targName = GeneralName.getInstance(r100, true);
    }

    public static Target getInstance(Object r100) {
        if (r100 == null) goto L13;
        if ((r100 instanceof Target) == true) goto L13;
        if ((r100 instanceof ASN1TaggedObject) == false) goto L11;
        return new Target((ASN1TaggedObject) r100);
    L11:
        throw new IllegalArgumentException("unknown object in factory: " + r100.getClass());
    L13:
        return (Target) r100;
    }

    public GeneralName getTargetGroup() {
        return this.targGroup;
    }

    public GeneralName getTargetName() {
        return this.targName;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        GeneralName r100 = this.targName;
        if (r100 == null) goto L7;
        return new DERTaggedObject(true, 0, r100);
    L7:
        return new DERTaggedObject(true, 1, this.targGroup);
    }
}
