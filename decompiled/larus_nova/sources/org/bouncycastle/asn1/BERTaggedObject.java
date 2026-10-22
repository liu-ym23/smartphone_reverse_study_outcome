package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes42.dex */
public class BERTaggedObject extends ASN1TaggedObject {
    public BERTaggedObject(int r100) {
        super(false, r100, new BERSequence());
    }

    public BERTaggedObject(int r100, ASN1Encodable r101) {
        super(true, r100, r101);
    }

    public BERTaggedObject(boolean r100, int r101, ASN1Encodable r102) {
        super(r100, r101, r102);
    }

    @Override // org.bouncycastle.asn1.ASN1TaggedObject, org.bouncycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream r100, boolean r101) throws IOException {
        r100.writeTag(r101, 160, this.tagNo);
        r100.write(128);
        if (this.explicit == true) goto L19;
        ASN1Encodable r102 = this.obj;
        if ((r102 instanceof ASN1OctetString) == false) goto L11;
        if ((r102 instanceof BEROctetString) == false) goto L9;
        Enumeration r103 = ((BEROctetString) r102).getObjects();
    L16:
        r100.writeElements(r103);
    L20:
        r100.write(0);
        r100.write(0);
        return;
    L9:
        r103 = new BEROctetString(((ASN1OctetString) r102).getOctets()).getObjects();
        goto L16
    L11:
        if ((r102 instanceof ASN1Sequence) == false) goto L14;
        r103 = ((ASN1Sequence) r102).getObjects();
        goto L16
    L14:
        if ((r102 instanceof ASN1Set) == false) goto L18;
        r103 = ((ASN1Set) r102).getObjects();
        goto L16
    L18:
        throw new ASN1Exception("not implemented: ".concat(this.obj.getClass().getName()));
    L19:
        r100.writePrimitive(this.obj.toASN1Primitive(), true);
        goto L20
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public int encodedLength() throws IOException {
        int r100 = this.obj.toASN1Primitive().encodedLength();
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
        if (this.obj.toASN1Primitive().isConstructed() == true) goto L8;
        return false;
    }
}
