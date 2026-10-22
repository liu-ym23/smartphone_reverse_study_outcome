package org.bouncycastle.asn1.x509;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class TargetInformation extends ASN1Object {
    private ASN1Sequence targets;

    private TargetInformation(ASN1Sequence r100) {
        this.targets = r100;
    }

    public TargetInformation(Targets r100) {
        this.targets = new DERSequence(r100);
    }

    public TargetInformation(Target[] r100) {
        this(new Targets(r100));
    }

    public static TargetInformation getInstance(Object r100) {
        if ((r100 instanceof TargetInformation) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new TargetInformation(ASN1Sequence.getInstance(r100));
    L5:
        return (TargetInformation) r100;
    }

    public Targets[] getTargetsObjects() {
        Targets[] r100 = new Targets[this.targets.size()];
        Enumeration r101 = this.targets.getObjects();
        int r102 = 0;
    L4:
        if (r101.hasMoreElements() == false) goto L6;
        r100[r102] = Targets.getInstance(r101.nextElement());
        r102 = r102 + 1;
        goto L4
    L6:
        return r100;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.targets;
    }
}
