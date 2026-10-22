package org.bouncycastle.asn1.x509;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

/* JADX INFO: loaded from: classes42.dex */
public class NameConstraints extends ASN1Object {
    private GeneralSubtree[] excluded;
    private GeneralSubtree[] permitted;

    private NameConstraints(ASN1Sequence r100) {
        Enumeration r101 = r100.getObjects();
    L4:
        if (r101.hasMoreElements() == false) goto L13;
        ASN1TaggedObject r102 = ASN1TaggedObject.getInstance(r101.nextElement());
        int r103 = r102.getTagNo();
        if (r103 != 0) goto L8;
        this.permitted = createArray(ASN1Sequence.getInstance(r102, false));
        goto L4
    L8:
        if (r103 != 1) goto L11;
        this.excluded = createArray(ASN1Sequence.getInstance(r102, false));
        goto L4
    L11:
        throw new IllegalArgumentException("Unknown tag encountered: " + r102.getTagNo());
    }

    public NameConstraints(GeneralSubtree[] r100, GeneralSubtree[] r101) {
        this.permitted = cloneSubtree(r100);
        this.excluded = cloneSubtree(r101);
    }

    private static GeneralSubtree[] cloneSubtree(GeneralSubtree[] r100) {
        if (r100 == null) goto L5;
        int r101 = r100.length;
        GeneralSubtree[] r102 = new GeneralSubtree[r101];
        System.arraycopy(r100, 0, r102, 0, r101);
        return r102;
    L5:
        return null;
    }

    private GeneralSubtree[] createArray(ASN1Sequence r100) {
        int r101 = r100.size();
        GeneralSubtree[] r102 = new GeneralSubtree[r101];
        int r103 = 0;
    L3:
        if (r103 == r101) goto L5;
        r102[r103] = GeneralSubtree.getInstance(r100.getObjectAt(r103));
        r103 = r103 + 1;
        goto L3
    L5:
        return r102;
    }

    public static NameConstraints getInstance(Object r100) {
        if ((r100 instanceof NameConstraints) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new NameConstraints(ASN1Sequence.getInstance(r100));
    L5:
        return (NameConstraints) r100;
    }

    public GeneralSubtree[] getExcludedSubtrees() {
        return cloneSubtree(this.excluded);
    }

    public GeneralSubtree[] getPermittedSubtrees() {
        return cloneSubtree(this.permitted);
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        GeneralSubtree[] r101 = this.permitted;
        if (r101 == null) goto L5;
        r100.add(new DERTaggedObject(false, 0, new DERSequence(r101)));
    L5:
        GeneralSubtree[] r102 = this.excluded;
        if (r102 == null) goto L9;
        r100.add(new DERTaggedObject(false, 1, new DERSequence(r102)));
    L9:
        return new DERSequence(r100);
    }
}
