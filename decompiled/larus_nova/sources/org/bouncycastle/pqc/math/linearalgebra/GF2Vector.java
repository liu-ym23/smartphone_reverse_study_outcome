package org.bouncycastle.pqc.math.linearalgebra;

import java.security.SecureRandom;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class GF2Vector extends Vector {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int[] f525607v;

    public GF2Vector(int r100) {
        if (r100 < 0) goto L7;
        this.length = r100;
        this.f525607v = new int[(r100 + 31) >> 5];
        return;
    L7:
        throw new ArithmeticException("Negative length.");
    }

    public GF2Vector(int r100, int r101, SecureRandom r102) {
        if (r101 > r100) goto L11;
        this.length = r100;
        this.f525607v = new int[(r100 + 31) >> 5];
        int[] r103 = new int[r100];
        int r104 = 0;
        int r105 = 0;
    L5:
        if (r105 >= r100) goto L7;
        r103[r105] = r105;
        r105 = r105 + 1;
    L7:
        if (r104 >= r101) goto L9;
        int r106 = RandUtils.nextInt(r102, r100);
        setBit(r103[r106]);
        r100 = r100 - 1;
        r103[r106] = r103[r100];
        r104 = r104 + 1;
        goto L7
    L9:
        return;
    L11:
        throw new ArithmeticException("The hamming weight is greater than the length of vector.");
    }

    public GF2Vector(int r100, SecureRandom r101) {
        this.length = r100;
        int r102 = (r100 + 31) >> 5;
        this.f525607v = new int[r102];
        int r103 = r102 - 1;
        int r104 = r103;
    L3:
        if (r104 < 0) goto L5;
        this.f525607v[r104] = r101.nextInt();
        r104 = r104 - 1;
        goto L3
    L5:
        int r105 = r100 & 31;
        if (r105 == 0) goto L10;
        int[] r106 = this.f525607v;
        r106[r103] = ((1 << r105) - 1) & r106[r103];
        return;
    }

    public GF2Vector(int r100, int[] r101) {
        if (r100 < 0) goto L13;
        this.length = r100;
        int r102 = (r100 + 31) >> 5;
        if (r101.length != r102) goto L11;
        int[] r103 = IntUtils.clone(r101);
        this.f525607v = r103;
        int r104 = r100 & 31;
        if (r104 == 0) goto L14;
        int r105 = r102 - 1;
        int r106 = (1 << r104) - 1;
        r103[r105] = r106 & r103[r105];
        return;
    L14:
        return;
    L11:
        throw new ArithmeticException("length mismatch");
    L13:
        throw new ArithmeticException("negative length");
    }

    public GF2Vector(GF2Vector r100) {
        this.length = r100.length;
        this.f525607v = IntUtils.clone(r100.f525607v);
    }

    public GF2Vector(int[] r100, int r101) {
        this.f525607v = r100;
        this.length = r101;
    }

    public static GF2Vector OS2VP(int r100, byte[] r101) {
        if (r100 < 0) goto L10;
        int r102 = (r100 + 7) >> 3;
        if (r101.length > r102) goto L8;
        return new GF2Vector(r100, LittleEndianConversions.toIntArray(r101));
    L8:
        throw new ArithmeticException("length mismatch");
    L10:
        throw new ArithmeticException("negative length");
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.Vector
    public Vector add(Vector r100) {
        if ((r100 instanceof GF2Vector) == false) goto L14;
        GF2Vector r101 = (GF2Vector) r100;
        if (this.length != r101.length) goto L12;
        int[] r102 = IntUtils.clone(r101.f525607v);
        int r103 = r102.length - 1;
    L7:
        if (r103 < 0) goto L10;
        r102[r103] = r102[r103] ^ this.f525607v[r103];
        r103 = r103 - 1;
        goto L7
    L10:
        return new GF2Vector(this.length, r102);
    L12:
        throw new ArithmeticException("length mismatch");
    L14:
        throw new ArithmeticException("vector is not defined over GF(2)");
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.Vector
    public boolean equals(Object r100) {
        if ((r100 instanceof GF2Vector) == true) goto L5;
        return false;
    L5:
        GF2Vector r101 = (GF2Vector) r100;
        if (this.length == r101.length) goto L8;
        return false;
    L8:
        if (IntUtils.equals(this.f525607v, r101.f525607v) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public GF2Vector extractLeftVector(int r100) {
        int r101 = this.length;
        if (r100 > r101) goto L12;
        if (r100 == r101) goto L6;
        GF2Vector r102 = new GF2Vector(r100);
        int r103 = r100 >> 5;
        int r104 = r100 & 31;
        System.arraycopy(this.f525607v, 0, r102.f525607v, 0, r103);
        if (r104 == 0) goto L10;
        int r105 = (1 << r104) - 1;
        r102.f525607v[r103] = r105 & this.f525607v[r103];
    L10:
        return r102;
    L6:
        return new GF2Vector(this);
    L12:
        throw new ArithmeticException("invalid length");
    }

    public GF2Vector extractRightVector(int r100) {
        int r101 = this.length;
        if (r100 > r101) goto L18;
        if (r100 == r101) goto L6;
        GF2Vector r102 = new GF2Vector(r100);
        int r103 = this.length;
        int r104 = (r103 - r100) >> 5;
        int r105 = (r103 - r100) & 31;
        int r106 = (r100 + 31) >> 5;
        int r107 = 0;
        if (r105 == 0) goto L15;
    L9:
        int r108 = r106 - 1;
        if (r107 >= r108) goto L12;
        int[] r109 = r102.f525607v;
        int[] r110 = this.f525607v;
        int r111 = r104 + 1;
        r109[r107] = (r110[r104] >>> r105) | (r110[r111] << (32 - r105));
        r107 = r107 + 1;
        r104 = r111;
        goto L9
    L12:
        int[] r112 = r102.f525607v;
        int[] r113 = this.f525607v;
        int r114 = r104 + 1;
        int r115 = r113[r104] >>> r105;
        r112[r108] = r115;
        if (r114 >= r113.length) goto L16;
        r112[r108] = (r113[r114] << (32 - r105)) | r115;
    L16:
        return r102;
    L15:
        System.arraycopy(this.f525607v, r104, r102.f525607v, 0, r106);
        goto L16
    L6:
        return new GF2Vector(this);
    L18:
        throw new ArithmeticException("invalid length");
    }

    public GF2Vector extractVector(int[] r100) {
        int r101 = r100.length;
        if (r100[r101 - 1] > this.length) goto L12;
        GF2Vector r102 = new GF2Vector(r101);
        int r103 = 0;
    L5:
        if (r103 >= r101) goto L10;
        int[] r104 = this.f525607v;
        int r105 = r100[r103];
        if ((r104[r105 >> 5] & (1 << (r105 & 31))) == 0) goto L9;
        int[] r106 = r102.f525607v;
        int r107 = r103 >> 5;
        r106[r107] = (1 << (r103 & 31)) | r106[r107];
    L9:
        r103 = r103 + 1;
        goto L5
    L10:
        return r102;
    L12:
        throw new ArithmeticException("invalid index set");
    }

    public int getBit(int r100) {
        if (r100 >= this.length) goto L7;
        int r101 = r100 >> 5;
        int r102 = r100 & 31;
        return (this.f525607v[r101] & (1 << r102)) >>> r102;
    L7:
        throw new IndexOutOfBoundsException();
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.Vector
    public byte[] getEncoded() {
        int r100 = (this.length + 7) >> 3;
        return LittleEndianConversions.toByteArray(this.f525607v, r100);
    }

    public int getHammingWeight() {
        int r100 = 0;
        int r101 = 0;
    L3:
        int[] r102 = this.f525607v;
        if (r100 >= r102.length) goto L13;
        int r103 = r102[r100];
        int r104 = 0;
    L7:
        if (r104 >= 32) goto L12;
        if ((r103 & 1) == 0) goto L11;
        r101 = r101 + 1;
    L11:
        r103 = r103 >>> 1;
        r104 = r104 + 1;
        goto L7
    L12:
        r100 = r100 + 1;
        goto L3
    L13:
        return r101;
    }

    public int[] getVecArray() {
        return this.f525607v;
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.Vector
    public int hashCode() {
        return (this.length * 31) + Arrays.hashCode(this.f525607v);
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.Vector
    public boolean isZero() {
        int r100 = this.f525607v.length - 1;
    L3:
        if (r100 < 0) goto L9;
        if (this.f525607v[r100] != 0) goto L6;
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
        if (r102 != r101.length) goto L13;
        GF2Vector r103 = new GF2Vector(r102);
        int r104 = 0;
    L6:
        if (r104 >= r101.length) goto L11;
        int[] r105 = this.f525607v;
        int r106 = r101[r104];
        if ((r105[r106 >> 5] & (1 << (r106 & 31))) == 0) goto L10;
        int[] r107 = r103.f525607v;
        int r108 = r104 >> 5;
        int r109 = 1 << (r104 & 31);
        r107[r108] = r109 | r107[r108];
    L10:
        r104 = r104 + 1;
        goto L6
    L11:
        return r103;
    L13:
        throw new ArithmeticException("length mismatch");
    }

    public void setBit(int r100) {
        if (r100 >= this.length) goto L7;
        int[] r101 = this.f525607v;
        int r102 = r100 >> 5;
        int r103 = 1 << (r100 & 31);
        r101[r102] = r103 | r101[r102];
        return;
    L7:
        throw new IndexOutOfBoundsException();
    }

    public GF2mVector toExtensionFieldVector(GF2mField r100) {
        int r101 = r100.getDegree();
        int r102 = this.length;
        if ((r102 % r101) != 0) goto L16;
        int r103 = r102 / r101;
        int[] r104 = new int[r103];
        int r105 = r103 - 1;
        int r106 = 0;
    L5:
        if (r105 < 0) goto L14;
        int r107 = r100.getDegree() - 1;
    L7:
        if (r107 < 0) goto L12;
        if (((this.f525607v[r106 >>> 5] >>> (r106 & 31)) & 1) != 1) goto L11;
        r104[r105] = r104[r105] ^ (1 << r107);
    L11:
        r106 = r106 + 1;
        r107 = r107 - 1;
        goto L7
    L12:
        r105 = r105 - 1;
        goto L5
    L14:
        return new GF2mVector(r100, r104);
    L16:
        throw new ArithmeticException("conversion is impossible");
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.Vector
    public String toString() {
        StringBuffer r100 = new StringBuffer();
        int r101 = 0;
    L4:
        if (r101 >= this.length) goto L15;
        if (r101 != 0) goto L7;
    L9:
        int[] r102 = this.f525607v;
        if ((r102[r101 >> 5] & (1 << (r101 & 31))) != 0) goto L12;
        char r103 = '0';
    L13:
        r100.append(r103);
        r101 = r101 + 1;
        goto L4
    L12:
        r103 = '1';
        goto L13
    L7:
        if ((r101 & 31) != 0) goto L9;
        r100.append(' ');
        goto L9
    L15:
        return r100.toString();
    }
}
