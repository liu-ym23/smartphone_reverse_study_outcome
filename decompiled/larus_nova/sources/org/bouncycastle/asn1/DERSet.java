package org.bouncycastle.asn1;

import java.io.IOException;

/* JADX INFO: loaded from: classes42.dex */
public class DERSet extends ASN1Set {
    private int bodyLength;

    public DERSet() {
        this.bodyLength = -1;
    }

    public DERSet(ASN1Encodable r100) {
        super(r100);
        this.bodyLength = -1;
    }

    public DERSet(ASN1EncodableVector r100) {
        super(r100, true);
        this.bodyLength = -1;
    }

    public DERSet(boolean r100, ASN1Encodable[] r101) {
        super(checkSorted(r100), r101);
        this.bodyLength = -1;
    }

    public DERSet(ASN1Encodable[] r100) {
        super(r100, true);
        this.bodyLength = -1;
    }

    private static boolean checkSorted(boolean r100) {
        if (r100 == false) goto L5;
        return r100;
    L5:
        throw new IllegalStateException("DERSet elements should always be in sorted order");
    }

    public static DERSet convert(ASN1Set r100) {
        return (DERSet) r100.toDERObject();
    }

    private int getBodyLength() throws IOException {
        if (this.bodyLength >= 0) goto L9;
        int r100 = this.elements.length;
        int r101 = 0;
        int r102 = 0;
    L5:
        if (r101 >= r100) goto L7;
        r102 = r102 + this.elements[r101].toASN1Primitive().toDERObject().encodedLength();
        r101 = r101 + 1;
        goto L5
    L7:
        this.bodyLength = r102;
    L9:
        return this.bodyLength;
    }

    @Override // org.bouncycastle.asn1.ASN1Set, org.bouncycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream r100, boolean r101) throws IOException {
        if (r101 == false) goto L4;
        r100.write(49);
    L4:
        DEROutputStream r102 = r100.getDERSubStream();
        int r103 = this.elements.length;
        int r104 = 0;
        if (this.bodyLength < 0) goto L7;
    L15:
        r100.writeLength(getBodyLength());
    L16:
        if (r104 >= r103) goto L22;
        this.elements[r104].toASN1Primitive().toDERObject().encode(r102, true);
        r104 = r104 + 1;
        goto L16
    L22:
        return;
    L7:
        if (r103 > 16) goto L15;
        ASN1Primitive[] r105 = new ASN1Primitive[r103];
        int r106 = 0;
        int r107 = 0;
    L10:
        if (r106 >= r103) goto L12;
        ASN1Primitive r108 = this.elements[r106].toASN1Primitive().toDERObject();
        r105[r106] = r108;
        r107 = r107 + r108.encodedLength();
        r106 = r106 + 1;
        goto L10
    L12:
        this.bodyLength = r107;
        r100.writeLength(r107);
    L13:
        if (r104 >= r103) goto L18;
        r105[r104].encode(r102, true);
        r104 = r104 + 1;
        goto L13
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public int encodedLength() throws IOException {
        int r100 = getBodyLength();
        return (StreamUtil.calculateBodyLength(r100) + 1) + r100;
    }

    @Override // org.bouncycastle.asn1.ASN1Set, org.bouncycastle.asn1.ASN1Primitive
    public ASN1Primitive toDERObject() {
        if (this.isSorted == false) goto L6;
        return this;
    L6:
        return super.toDERObject();
    }

    @Override // org.bouncycastle.asn1.ASN1Set, org.bouncycastle.asn1.ASN1Primitive
    public ASN1Primitive toDLObject() {
        return this;
    }
}
