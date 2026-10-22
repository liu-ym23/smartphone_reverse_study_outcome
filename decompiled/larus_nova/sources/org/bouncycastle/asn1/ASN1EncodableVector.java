package org.bouncycastle.asn1;

/* JADX INFO: loaded from: classes42.dex */
public class ASN1EncodableVector {
    private static final int DEFAULT_CAPACITY = 10;
    static final ASN1Encodable[] EMPTY_ELEMENTS = null;
    private boolean copyOnWrite;
    private int elementCount;
    private ASN1Encodable[] elements;

    static {
        EMPTY_ELEMENTS = new ASN1Encodable[0];
    }

    public ASN1EncodableVector() {
        this(10);
    }

    public ASN1EncodableVector(int r100) {
        if (r100 < 0) goto L10;
        if (r100 != 0) goto L6;
        ASN1Encodable[] r101 = EMPTY_ELEMENTS;
    L7:
        this.elements = r101;
        this.elementCount = 0;
        this.copyOnWrite = false;
        return;
    L6:
        r101 = new ASN1Encodable[r100];
        goto L7
    L10:
        throw new IllegalArgumentException("'initialCapacity' must not be negative");
    }

    public static ASN1Encodable[] cloneElements(ASN1Encodable[] r100) {
        if (r100.length >= 1) goto L6;
        return EMPTY_ELEMENTS;
    L6:
        return (ASN1Encodable[]) r100.clone();
    }

    private void reallocate(int r100) {
        ASN1Encodable[] r101 = new ASN1Encodable[Math.max(this.elements.length, r100 + (r100 >> 1))];
        System.arraycopy(this.elements, 0, r101, 0, this.elementCount);
        this.elements = r101;
        this.copyOnWrite = false;
    }

    public void add(ASN1Encodable r100) {
        if (r100 == null) goto L13;
        int r101 = this.elements.length;
        boolean r102 = true;
        int r103 = this.elementCount + 1;
        if (r103 > r101) goto L8;
        r102 = false;
    L8:
        if ((this.copyOnWrite | r102) == false) goto L10;
        reallocate(r103);
    L10:
        this.elements[this.elementCount] = r100;
        this.elementCount = r103;
        return;
    L13:
        throw new NullPointerException("'element' cannot be null");
    }

    public void addAll(ASN1EncodableVector r100) {
        if (r100 == null) goto L22;
        int r101 = r100.size();
        boolean r102 = true;
        if (r101 >= 1) goto L6;
        return;
    L6:
        int r103 = this.elements.length;
        int r104 = this.elementCount + r101;
        int r105 = 0;
        if (r104 > r103) goto L11;
        r102 = false;
    L11:
        if ((r102 | this.copyOnWrite) == false) goto L13;
        reallocate(r104);
    L13:
        ASN1Encodable r106 = r100.get(r105);
        if (r106 == null) goto L20;
        this.elements[this.elementCount + r105] = r106;
        r105 = r105 + 1;
        if (r105 < r101) goto L13;
        this.elementCount = r104;
        return;
    L20:
        throw new NullPointerException("'other' elements cannot be null");
    L22:
        throw new NullPointerException("'other' cannot be null");
    }

    public ASN1Encodable[] copyElements() {
        int r100 = this.elementCount;
        if (r100 == 0) goto L5;
        ASN1Encodable[] r101 = new ASN1Encodable[r100];
        System.arraycopy(this.elements, 0, r101, 0, r100);
        return r101;
    L5:
        return EMPTY_ELEMENTS;
    }

    public ASN1Encodable get(int r100) {
        if (r100 >= this.elementCount) goto L7;
        return this.elements[r100];
    L7:
        throw new ArrayIndexOutOfBoundsException(r100 + " >= " + this.elementCount);
    }

    public int size() {
        return this.elementCount;
    }

    public ASN1Encodable[] takeElements() {
        int r100 = this.elementCount;
        if (r100 == 0) goto L5;
        ASN1Encodable[] r101 = this.elements;
        if (r101.length != r100) goto L10;
        this.copyOnWrite = true;
        return r101;
    L10:
        ASN1Encodable[] r102 = new ASN1Encodable[r100];
        System.arraycopy(r101, 0, r102, 0, r100);
        return r102;
    L5:
        return EMPTY_ELEMENTS;
    }
}
