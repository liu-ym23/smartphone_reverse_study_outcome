package org.bouncycastle.asn1;

import java.io.IOException;

/* JADX INFO: loaded from: classes42.dex */
public abstract class ASN1TaggedObject extends ASN1Primitive implements ASN1TaggedObjectParser {
    final boolean explicit;
    final ASN1Encodable obj;
    final int tagNo;

    public ASN1TaggedObject(boolean r100, int r101, ASN1Encodable r102) {
        if (r102 == null) goto L14;
        this.tagNo = r101;
        if (r100 == false) goto L7;
    L10:
        boolean r103 = true;
    L11:
        this.explicit = r103;
        this.obj = r102;
        return;
    L7:
        if ((r102 instanceof ASN1Choice) == true) goto L10;
        r103 = false;
        goto L11
    L14:
        throw new NullPointerException("'obj' cannot be null");
    }

    public static ASN1TaggedObject getInstance(Object r100) {
        if (r100 == null) goto L16;
        if ((r100 instanceof ASN1TaggedObject) == true) goto L16;
        if ((r100 instanceof byte[]) == false) goto L14;
        return getInstance(ASN1Primitive.fromByteArray((byte[]) r100));
    L10:
        e = move-exception;
        throw new IllegalArgumentException("failed to construct tagged object from byte[]: " + e.getMessage());
    L14:
        throw new IllegalArgumentException("unknown object in getInstance: ".concat(r100.getClass().getName()));
    L16:
        return (ASN1TaggedObject) r100;
    }

    public static ASN1TaggedObject getInstance(ASN1TaggedObject r100, boolean r101) {
        if (r101 == false) goto L6;
        return getInstance(r100.getObject());
    L6:
        throw new IllegalArgumentException("implicitly tagged tagged object");
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive r100) {
        if ((r100 instanceof ASN1TaggedObject) == true) goto L5;
        return false;
    L5:
        ASN1TaggedObject r101 = (ASN1TaggedObject) r100;
        if (this.tagNo == r101.tagNo) goto L8;
        return false;
    L8:
        if (this.explicit != r101.explicit) goto L18;
        ASN1Primitive r102 = this.obj.toASN1Primitive();
        ASN1Primitive r103 = r101.obj.toASN1Primitive();
        if (r102 != r103) goto L13;
    L14:
        return true;
    L13:
        if (r102.asn1Equals(r103) == true) goto L14;
        return false;
    L18:
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public abstract void encode(ASN1OutputStream r100, boolean r101) throws IOException;

    @Override // org.bouncycastle.asn1.InMemoryRepresentable
    public ASN1Primitive getLoadedObject() {
        return toASN1Primitive();
    }

    public ASN1Primitive getObject() {
        return this.obj.toASN1Primitive();
    }

    @Override // org.bouncycastle.asn1.ASN1TaggedObjectParser
    public ASN1Encodable getObjectParser(int r100, boolean r101) throws IOException {
        if (r100 == 4) goto L18;
        if (r100 == 16) goto L16;
        if (r100 == 17) goto L14;
        if (r101 == false) goto L12;
        return getObject();
    L12:
        throw new ASN1Exception("implicit tagging not implemented for tag: " + r100);
    L14:
        return ASN1Set.getInstance(this, r101).parser();
    L16:
        return ASN1Sequence.getInstance(this, r101).parser();
    L18:
        return ASN1OctetString.getInstance(this, r101).parser();
    }

    @Override // org.bouncycastle.asn1.ASN1TaggedObjectParser
    public int getTagNo() {
        return this.tagNo;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive, org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        int r100 = this.tagNo;
        if (this.explicit == false) goto L5;
        int r101 = 15;
    L7:
        return (r100 ^ r101) ^ this.obj.toASN1Primitive().hashCode();
    L5:
        r101 = 240;
        goto L7
    }

    public boolean isExplicit() {
        return this.explicit;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public ASN1Primitive toDERObject() {
        return new DERTaggedObject(this.explicit, this.tagNo, this.obj);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public ASN1Primitive toDLObject() {
        return new DLTaggedObject(this.explicit, this.tagNo, this.obj);
    }

    public String toString() {
        return "[" + this.tagNo + "]" + this.obj;
    }
}
