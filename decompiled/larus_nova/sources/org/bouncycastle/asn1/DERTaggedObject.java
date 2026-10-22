package org.bouncycastle.asn1;

import java.io.IOException;

/* JADX INFO: loaded from: classes42.dex */
public class DERTaggedObject extends ASN1TaggedObject {
    public DERTaggedObject(int r100, ASN1Encodable r101) {
        super(true, r100, r101);
    }

    public DERTaggedObject(boolean r100, int r101, ASN1Encodable r102) {
        super(r100, r101, r102);
    }

    @Override // org.bouncycastle.asn1.ASN1TaggedObject, org.bouncycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream r100, boolean r101) throws IOException {
        ASN1Primitive r102 = this.obj.toASN1Primitive().toDERObject();
        if (this.explicit == false) goto L5;
    L8:
        int r103 = 160;
    L9:
        r100.writeTag(r101, r103, this.tagNo);
        if (this.explicit == false) goto L12;
        r100.writeLength(r102.encodedLength());
    L12:
        r102.encode(r100.getDERSubStream(), this.explicit);
        return;
    L5:
        if (r102.isConstructed() == true) goto L8;
        r103 = 128;
        goto L9
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public int encodedLength() throws IOException {
        int r100 = this.obj.toASN1Primitive().toDERObject().encodedLength();
        if (this.explicit == false) goto L7;
        int r101 = StreamUtil.calculateTagLength(this.tagNo) + StreamUtil.calculateBodyLength(r100);
    L6:
        return r101 + r100;
    L7:
        r100 = r100 - 1;
        r101 = StreamUtil.calculateTagLength(this.tagNo);
        goto L6
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        if (this.explicit == false) goto L5;
    L8:
        return true;
    L5:
        if (this.obj.toASN1Primitive().toDERObject().isConstructed() == true) goto L8;
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1TaggedObject, org.bouncycastle.asn1.ASN1Primitive
    public ASN1Primitive toDERObject() {
        return this;
    }

    @Override // org.bouncycastle.asn1.ASN1TaggedObject, org.bouncycastle.asn1.ASN1Primitive
    public ASN1Primitive toDLObject() {
        return this;
    }
}
