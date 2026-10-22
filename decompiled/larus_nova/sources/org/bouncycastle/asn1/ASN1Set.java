package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import kotlin.UByte;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Iterable;

/* JADX INFO: loaded from: classes42.dex */
public abstract class ASN1Set extends ASN1Primitive implements Iterable<ASN1Encodable> {
    protected final ASN1Encodable[] elements;
    protected final boolean isSorted;

    public ASN1Set() {
        this.elements = ASN1EncodableVector.EMPTY_ELEMENTS;
        this.isSorted = true;
    }

    public ASN1Set(ASN1Encodable r100) {
        if (r100 == null) goto L7;
        this.elements = new ASN1Encodable[]{r100};
        this.isSorted = true;
        return;
    L7:
        throw new NullPointerException("'element' cannot be null");
    }

    public ASN1Set(ASN1EncodableVector r100, boolean r101) {
        if (r100 == null) goto L20;
        if (r101 == true) goto L7;
    L9:
        ASN1Encodable[] r102 = r100.takeElements();
    L10:
        this.elements = r102;
        if (r101 == false) goto L13;
    L16:
        boolean r103 = true;
    L17:
        this.isSorted = r103;
        return;
    L13:
        if (r102.length < 2) goto L16;
        r103 = false;
        goto L17
    L7:
        if (r100.size() < 2) goto L9;
        r102 = r100.copyElements();
        sort(r102);
        goto L10
    L20:
        throw new NullPointerException("'elementVector' cannot be null");
    }

    public ASN1Set(boolean r100, ASN1Encodable[] r101) {
        this.elements = r101;
        if (r100 == false) goto L5;
    L8:
        boolean r102 = true;
    L9:
        this.isSorted = r102;
        return;
    L5:
        if (r101.length < 2) goto L8;
        r102 = false;
        goto L9
    }

    public ASN1Set(ASN1Encodable[] r100, boolean r101) {
        if (Arrays.isNullOrContainsNull(r100) == true) goto L19;
        ASN1Encodable[] r102 = ASN1EncodableVector.cloneElements(r100);
        if (r101 == true) goto L7;
    L9:
        this.elements = r102;
        if (r101 == false) goto L12;
    L15:
        boolean r103 = true;
    L16:
        this.isSorted = r103;
        return;
    L12:
        if (r102.length < 2) goto L15;
        r103 = false;
        goto L16
    L7:
        if (r102.length < 2) goto L9;
        sort(r102);
        goto L9
    L19:
        throw new NullPointerException("'elements' cannot be null, or contain null");
    }

    private static byte[] getDEREncoded(ASN1Encodable r100) {
        return r100.toASN1Primitive().getEncoded(ASN1Encoding.DER);
    L5:
        throw new IllegalArgumentException("cannot encode object added to SET");
    }

    public static ASN1Set getInstance(Object r100) {
        if (r100 == null) goto L26;
        if ((r100 instanceof ASN1Set) == true) goto L26;
        if ((r100 instanceof ASN1SetParser) == false) goto L11;
        return getInstance(((ASN1SetParser) r100).toASN1Primitive());
    L11:
        if ((r100 instanceof byte[]) == false) goto L18;
        return getInstance(ASN1Primitive.fromByteArray((byte[]) r100));
    L14:
        e = move-exception;
        throw new IllegalArgumentException("failed to construct set from byte[]: " + e.getMessage());
    L18:
        if ((r100 instanceof ASN1Encodable) == false) goto L24;
        ASN1Primitive r101 = ((ASN1Encodable) r100).toASN1Primitive();
        if ((r101 instanceof ASN1Set) == false) goto L24;
        return (ASN1Set) r101;
    L24:
        throw new IllegalArgumentException("unknown object in getInstance: ".concat(r100.getClass().getName()));
    L26:
        return (ASN1Set) r100;
    }

    public static ASN1Set getInstance(ASN1TaggedObject r100, boolean r101) {
        if (r101 == true) goto L4;
        ASN1Primitive r102 = r100.getObject();
        if (r100.isExplicit() == false) goto L18;
        if ((r100 instanceof BERTaggedObject) == false) goto L16;
        return new BERSet(r102);
    L16:
        return new DLSet(r102);
    L18:
        if ((r102 instanceof ASN1Set) == false) goto L25;
        ASN1Set r103 = (ASN1Set) r102;
        if ((r100 instanceof BERTaggedObject) == false) goto L23;
        return r103;
    L23:
        return (ASN1Set) r103.toDLObject();
    L25:
        if ((r102 instanceof ASN1Sequence) == false) goto L33;
        ASN1Encodable[] r104 = ((ASN1Sequence) r102).toArrayInternal();
        if ((r100 instanceof BERTaggedObject) == false) goto L31;
        return new BERSet(false, r104);
    L31:
        return new DLSet(false, r104);
    L33:
        throw new IllegalArgumentException("unknown object in getInstance: ".concat(r100.getClass().getName()));
    L4:
        if (r100.isExplicit() == false) goto L8;
        return getInstance(r100.getObject());
    L8:
        throw new IllegalArgumentException("object implicit - explicit expected.");
    }

    private static boolean lessThanOrEqual(byte[] r100, byte[] r101) {
        int r102 = r100[0] & (-33);
        int r103 = r101[0] & (-33);
        if (r102 == r103) goto L7;
        if (r102 >= r103) goto L22;
        return true;
    L22:
        return false;
    L7:
        int r104 = Math.min(r100.length, r101.length) - 1;
        int r105 = 1;
    L8:
        if (r105 >= r104) goto L17;
        byte r106 = r100[r105];
        byte r107 = r101[r105];
        if (r106 != r107) goto L12;
        r105 = r105 + 1;
        goto L8
    L12:
        if ((r106 & UByte.MAX_VALUE) >= (r107 & UByte.MAX_VALUE)) goto L23;
        return true;
    L23:
        return false;
    L17:
        if ((r100[r104] & UByte.MAX_VALUE) > (r101[r104] & UByte.MAX_VALUE)) goto L24;
        return true;
    L24:
        return false;
    }

    private static void sort(ASN1Encodable[] r110) {
        int r100 = r110.length;
        int r101 = 2;
        if (r100 >= 2) goto L5;
        return;
    L5:
        ASN1Encodable r102 = r110[0];
        ASN1Encodable r103 = r110[1];
        byte[] r104 = getDEREncoded(r102);
        byte[] r105 = getDEREncoded(r103);
        if (lessThanOrEqual(r105, r104) == false) goto L8;
        r103 = r102;
        r102 = r103;
        r105 = r104;
        r104 = r105;
    L8:
        if (r101 >= r100) goto L24;
        ASN1Encodable r106 = r110[r101];
        byte[] r107 = getDEREncoded(r106);
        if (lessThanOrEqual(r105, r107) == false) goto L13;
        r110[r101 - 2] = r102;
        r102 = r103;
        r104 = r105;
        r103 = r106;
        r105 = r107;
    L23:
        r101 = r101 + 1;
        goto L8
    L13:
        if (lessThanOrEqual(r104, r107) == false) goto L15;
        r110[r101 - 2] = r102;
        r102 = r106;
        r104 = r107;
        goto L23
    L15:
        int r108 = r101 - 1;
    L16:
        r108 = r108 - 1;
        if (r108 <= 0) goto L22;
        ASN1Encodable r111 = r110[r108 - 1];
        if (lessThanOrEqual(getDEREncoded(r111), r107) == true) goto L22;
        r110[r108] = r111;
    L22:
        r110[r108] = r106;
        goto L23
    L24:
        r110[r100 - 2] = r102;
        r110[r100 - 1] = r103;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive r100) {
        if ((r100 instanceof ASN1Set) == true) goto L5;
        return false;
    L5:
        ASN1Set r101 = (ASN1Set) r100;
        int r102 = size();
        if (r101.size() == r102) goto L8;
        return false;
    L8:
        DERSet r103 = (DERSet) toDERObject();
        DERSet r104 = (DERSet) r101.toDERObject();
        int r105 = 0;
    L9:
        if (r105 >= r102) goto L16;
        ASN1Primitive r106 = r103.elements[r105].toASN1Primitive();
        ASN1Primitive r107 = r104.elements[r105].toASN1Primitive();
        if (r106 == r107) goto L15;
        if (r106.asn1Equals(r107) == true) goto L15;
        return false;
    L15:
        r105 = r105 + 1;
        goto L9
    L16:
        return true;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public abstract void encode(ASN1OutputStream r100, boolean r101) throws IOException;

    public ASN1Encodable getObjectAt(int r100) {
        return this.elements[r100];
    }

    public Enumeration getObjects() {
        return new AnonymousClass1(this);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive, org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        int r100 = this.elements.length;
        int r101 = r100 + 1;
    L3:
        r100 = r100 - 1;
        if (r100 < 0) goto L6;
        r101 = r101 + this.elements[r100].toASN1Primitive().hashCode();
        goto L3
    L6:
        return r101;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        return true;
    }

    @Override // org.bouncycastle.util.Iterable, java.lang.Iterable
    public Iterator<ASN1Encodable> iterator() {
        return new Arrays.Iterator(toArray());
    }

    public ASN1SetParser parser() {
        final int r100 = size();
        return new AnonymousClass2(this, r100);
    }

    public int size() {
        return this.elements.length;
    }

    public ASN1Encodable[] toArray() {
        return ASN1EncodableVector.cloneElements(this.elements);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public ASN1Primitive toDERObject() {
        if (this.isSorted == false) goto L5;
        ASN1Encodable[] r100 = this.elements;
    L7:
        return new DERSet(true, r100);
    L5:
        r100 = (ASN1Encodable[]) this.elements.clone();
        sort(r100);
        goto L7
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public ASN1Primitive toDLObject() {
        return new DLSet(this.isSorted, this.elements);
    }

    public String toString() {
        int r100 = size();
        if (r100 != 0) goto L6;
        return "[]";
    L6:
        StringBuffer r101 = new StringBuffer("[");
        int r102 = 0;
    L7:
        r101.append(this.elements[r102]);
        r102 = r102 + 1;
        if (r102 >= r100) goto L9;
        r101.append(", ");
        goto L7
    L9:
        r101.append(']');
        return r101.toString();
    }
}
