package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;

/* JADX INFO: loaded from: classes42.dex */
public class BodyPartReference extends ASN1Object implements ASN1Choice {
    private final BodyPartID bodyPartID;
    private final BodyPartPath bodyPartPath;

    public BodyPartReference(BodyPartID r100) {
        this.bodyPartID = r100;
        this.bodyPartPath = null;
    }

    public BodyPartReference(BodyPartPath r100) {
        this.bodyPartID = null;
        this.bodyPartPath = r100;
    }

    public static BodyPartReference getInstance(Object r100) {
        if ((r100 instanceof BodyPartReference) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        if ((r100 instanceof ASN1Encodable) == false) goto L18;
        ASN1Primitive r101 = ((ASN1Encodable) r100).toASN1Primitive();
        if ((r101 instanceof ASN1Integer) == false) goto L14;
        return new BodyPartReference(BodyPartID.getInstance(r101));
    L14:
        if ((r101 instanceof ASN1Sequence) == false) goto L18;
        return new BodyPartReference(BodyPartPath.getInstance(r101));
    L18:
        if ((r100 instanceof byte[]) == false) goto L24;
        return getInstance(ASN1Primitive.fromByteArray((byte[]) r100));
    L22:
        throw new IllegalArgumentException("unknown encoding in getInstance()");
    L24:
        throw new IllegalArgumentException("unknown object in getInstance(): ".concat(r100.getClass().getName()));
    L5:
        return (BodyPartReference) r100;
    }

    public BodyPartID getBodyPartID() {
        return this.bodyPartID;
    }

    public BodyPartPath getBodyPartPath() {
        return this.bodyPartPath;
    }

    public boolean isBodyPartID() {
        if (this.bodyPartID == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        BodyPartID r100 = this.bodyPartID;
        if (r100 == null) goto L7;
        return r100.toASN1Primitive();
    L7:
        return this.bodyPartPath.toASN1Primitive();
    }
}
