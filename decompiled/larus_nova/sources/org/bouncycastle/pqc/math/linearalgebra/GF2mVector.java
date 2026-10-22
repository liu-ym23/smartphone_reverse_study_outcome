package org.bouncycastle.pqc.math.linearalgebra;

import kotlin.UByte;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class GF2mVector extends Vector {
    private GF2mField field;
    private int[] vector;

    public GF2mVector(GF2mField r110, byte[] r111) {
        this.field = new GF2mField(r110);
        int r100 = 8;
        int r101 = 1;
    L4:
        if (r110.getDegree() <= r100) goto L7;
        r101 = r101 + 1;
        r100 = r100 + 8;
        goto L4
    L7:
        if ((r111.length % r101) != 0) goto L21;
        int r102 = r111.length / r101;
        this.length = r102;
        this.vector = new int[r102];
        int r103 = 0;
        int r104 = 0;
    L10:
        if (r103 >= this.vector.length) goto L19;
        int r105 = 0;
    L12:
        if (r105 >= r100) goto L15;
        int[] r106 = this.vector;
        int r107 = r106[r103];
        int r108 = r104 + 1;
        r106[r103] = ((r111[r104] & UByte.MAX_VALUE) << r105) | r107;
        r105 = r105 + 8;
        r104 = r108;
        goto L12
    L15:
        if (r110.isElementOfThisField(this.vector[r103]) == false) goto L18;
        r103 = r103 + 1;
        goto L10
    L18:
        throw new IllegalArgumentException("Byte array is not an encoded vector over the given finite field.");
    L19:
        return;
    L21:
        throw new IllegalArgumentException("Byte array is not an encoded vector over the given finite field.");
    }

    public GF2mVector(GF2mField r100, int[] r101) {
        this.field = r100;
        this.length = r101.length;
        int r102 = r101.length - 1;
    L3:
        if (r102 < 0) goto L9;
        if (r100.isElementOfThisField(r101[r102]) == false) goto L8;
        r102 = r102 - 1;
        goto L3
    L8:
        throw new ArithmeticException("Element array is not specified over the given finite field.");
    L9:
        this.vector = IntUtils.clone(r101);
    }

    public GF2mVector(GF2mVector r100) {
        this.field = new GF2mField(r100.field);
        this.length = r100.length;
        this.vector = IntUtils.clone(r100.vector);
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.Vector
    public Vector add(Vector r100) {
        throw new RuntimeException("not implemented");
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.Vector
    public boolean equals(Object r100) {
        if ((r100 instanceof GF2mVector) == true) goto L5;
        return false;
    L5:
        GF2mVector r101 = (GF2mVector) r100;
        if (this.field.equals(r101.field) == true) goto L9;
        return false;
    L9:
        return IntUtils.equals(this.vector, r101.vector);
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.Vector
    public byte[] getEncoded() {
        int r100 = 8;
        int r101 = 1;
    L4:
        if (this.field.getDegree() <= r100) goto L6;
        r101 = r101 + 1;
        r100 = r100 + 8;
        goto L4
    L6:
        byte[] r102 = new byte[this.vector.length * r101];
        int r103 = 0;
        int r104 = 0;
    L8:
        if (r103 >= this.vector.length) goto L13;
        int r105 = 0;
    L10:
        if (r105 >= r100) goto L12;
        r102[r104] = (byte) (this.vector[r103] >>> r105);
        r105 = r105 + 8;
        r104 = r104 + 1;
        goto L10
    L12:
        r103 = r103 + 1;
        goto L8
    L13:
        return r102;
    }

    public GF2mField getField() {
        return this.field;
    }

    public int[] getIntArrayForm() {
        return IntUtils.clone(this.vector);
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.Vector
    public int hashCode() {
        return (this.field.hashCode() * 31) + Arrays.hashCode(this.vector);
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.Vector
    public boolean isZero() {
        int r100 = this.vector.length - 1;
    L3:
        if (r100 < 0) goto L9;
        if (this.vector[r100] != 0) goto L6;
        r100 = r100 - 1;
        goto L3
    L6:
        return false;
    L9:
        return true;
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.Vector
    public Vector multiply(Permutation r100) {
        int[] r101 = r100.getVector();
        int r102 = this.length;
        if (r102 != r101.length) goto L11;
        int[] r103 = new int[r102];
        int r104 = 0;
    L6:
        if (r104 >= r101.length) goto L9;
        r103[r104] = this.vector[r101[r104]];
        r104 = r104 + 1;
        goto L6
    L9:
        return new GF2mVector(this.field, r103);
    L11:
        throw new ArithmeticException("permutation size and vector size mismatch");
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.Vector
    public String toString() {
        StringBuffer r100 = new StringBuffer();
        int r101 = 0;
    L4:
        if (r101 >= this.vector.length) goto L15;
        int r102 = 0;
    L7:
        if (r102 >= this.field.getDegree()) goto L13;
        if (((1 << (r102 & 31)) & this.vector[r101]) == 0) goto L11;
        char r103 = '1';
    L12:
        r100.append(r103);
        r102 = r102 + 1;
        goto L7
    L11:
        r103 = '0';
        goto L12
    L13:
        r100.append(' ');
        r101 = r101 + 1;
        goto L4
    L15:
        return r100.toString();
    }
}
