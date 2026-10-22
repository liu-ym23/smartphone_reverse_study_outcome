package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Iterable;

/* JADX INFO: loaded from: classes42.dex */
public abstract class ASN1Sequence extends ASN1Primitive implements Iterable<ASN1Encodable> {
    ASN1Encodable[] elements;

    public ASN1Sequence() {
        this.elements = ASN1EncodableVector.EMPTY_ELEMENTS;
    }

    public ASN1Sequence(ASN1Encodable r100) {
        if (r100 == null) goto L7;
        this.elements = new ASN1Encodable[]{r100};
        return;
    L7:
        throw new NullPointerException("'element' cannot be null");
    }

    public ASN1Sequence(ASN1EncodableVector r100) {
        if (r100 == null) goto L7;
        this.elements = r100.takeElements();
        return;
    L7:
        throw new NullPointerException("'elementVector' cannot be null");
    }

    public ASN1Sequence(ASN1Encodable[] r100) {
        if (Arrays.isNullOrContainsNull(r100) == true) goto L7;
        this.elements = ASN1EncodableVector.cloneElements(r100);
        return;
    L7:
        throw new NullPointerException("'elements' cannot be null, or contain null");
    }

    public ASN1Sequence(ASN1Encodable[] r100, boolean r101) {
        if (r101 == false) goto L5;
        r100 = ASN1EncodableVector.cloneElements(r100);
    L5:
        this.elements = r100;
    }

    public static ASN1Sequence getInstance(Object r100) {
        if (r100 == null) goto L26;
        if ((r100 instanceof ASN1Sequence) == true) goto L26;
        if ((r100 instanceof ASN1SequenceParser) == false) goto L11;
        return getInstance(((ASN1SequenceParser) r100).toASN1Primitive());
    L11:
        if ((r100 instanceof byte[]) == false) goto L18;
        return getInstance(ASN1Primitive.fromByteArray((byte[]) r100));
    L14:
        e = move-exception;
        throw new IllegalArgumentException("failed to construct sequence from byte[]: " + e.getMessage());
    L18:
        if ((r100 instanceof ASN1Encodable) == false) goto L24;
        ASN1Primitive r101 = ((ASN1Encodable) r100).toASN1Primitive();
        if ((r101 instanceof ASN1Sequence) == false) goto L24;
        return (ASN1Sequence) r101;
    L24:
        throw new IllegalArgumentException("unknown object in getInstance: ".concat(r100.getClass().getName()));
    L26:
        return (ASN1Sequence) r100;
    }

    public static ASN1Sequence getInstance(ASN1TaggedObject r100, boolean r101) {
        if (r101 == true) goto L4;
        ASN1Primitive r102 = r100.getObject();
        if (r100.isExplicit() == false) goto L18;
        if ((r100 instanceof BERTaggedObject) == false) goto L16;
        return new BERSequence(r102);
    L16:
        return new DLSequence(r102);
    L18:
        if ((r102 instanceof ASN1Sequence) == false) goto L25;
        ASN1Sequence r103 = (ASN1Sequence) r102;
        if ((r100 instanceof BERTaggedObject) == false) goto L23;
        return r103;
    L23:
        return (ASN1Sequence) r103.toDLObject();
    L25:
        throw new IllegalArgumentException("unknown object in getInstance: ".concat(r100.getClass().getName()));
    L4:
        if (r100.isExplicit() == false) goto L8;
        return getInstance(r100.getObject());
    L8:
        throw new IllegalArgumentException("object implicit - explicit expected.");
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive r100) {
        if ((r100 instanceof ASN1Sequence) == true) goto L5;
        return false;
    L5:
        ASN1Sequence r101 = (ASN1Sequence) r100;
        int r102 = size();
        if (r101.size() == r102) goto L8;
        return false;
    L8:
        int r103 = 0;
    L9:
        if (r103 >= r102) goto L16;
        ASN1Primitive r104 = this.elements[r103].toASN1Primitive();
        ASN1Primitive r105 = r101.elements[r103].toASN1Primitive();
        if (r104 == r105) goto L15;
        if (r104.asn1Equals(r105) == true) goto L15;
        return false;
    L15:
        r103 = r103 + 1;
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
        r101 = (r101 * 257) ^ this.elements[r100].toASN1Primitive().hashCode();
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
        return new Arrays.Iterator(this.elements);
    }

    public ASN1SequenceParser parser() {
        final int r100 = size();
        return new AnonymousClass2(this, r100);
    }

    public int size() {
        return this.elements.length;
    }

    public ASN1Encodable[] toArray() {
        return ASN1EncodableVector.cloneElements(this.elements);
    }

    public ASN1Encodable[] toArrayInternal() {
        return this.elements;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public ASN1Primitive toDERObject() {
        return new DERSequence(this.elements, false);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public ASN1Primitive toDLObject() {
        return new DLSequence(this.elements, false);
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
