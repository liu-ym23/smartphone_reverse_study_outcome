package org.bouncycastle.pqc.math.linearalgebra;

import java.lang.reflect.Array;
import kotlin.UByte;

/* JADX INFO: loaded from: classes42.dex */
public class GF2mMatrix extends Matrix {
    protected GF2mField field;
    protected int[][] matrix;

    public GF2mMatrix(GF2mField r110, byte[] r111) {
        this.field = r110;
        int r100 = 8;
        int r101 = 1;
    L4:
        if (r110.getDegree() <= r100) goto L7;
        r101 = r101 + 1;
        r100 = r100 + 8;
        goto L4
    L7:
        if (r111.length < 5) goto L31;
        int r112 = ((((r111[3] & UByte.MAX_VALUE) << 24) ^ ((r111[2] & UByte.MAX_VALUE) << 16)) ^ ((r111[1] & UByte.MAX_VALUE) << 8)) ^ (r111[0] & UByte.MAX_VALUE);
        this.numRows = r112;
        int r102 = r101 * r112;
        if (r112 <= 0) goto L29;
        int r103 = 4;
        if (((r111.length - 4) % r102) != 0) goto L29;
        int r104 = (r111.length - 4) / r102;
        this.numColumns = r104;
        this.matrix = (int[][]) Array.newInstance(Integer.TYPE, new int[]{r112, r104});
        int r113 = 0;
    L14:
        if (r113 >= this.numRows) goto L27;
        int r105 = 0;
    L17:
        if (r105 >= this.numColumns) goto L26;
        int r106 = 0;
    L19:
        if (r106 >= r100) goto L22;
        int[] r107 = this.matrix[r113];
        r107[r105] = r107[r105] ^ ((r111[r103] & UByte.MAX_VALUE) << r106);
        r106 = r106 + 8;
        r103 = r103 + 1;
        goto L19
    L22:
        if (this.field.isElementOfThisField(this.matrix[r113][r105]) == false) goto L25;
        r105 = r105 + 1;
        goto L17
    L25:
        throw new IllegalArgumentException(" Error: given array is not encoded matrix over GF(2^m)");
    L26:
        r113 = r113 + 1;
        goto L14
    L27:
        return;
    L29:
        throw new IllegalArgumentException(" Error: given array is not encoded matrix over GF(2^m)");
    L31:
        throw new IllegalArgumentException(" Error: given array is not encoded matrix over GF(2^m)");
    }

    public GF2mMatrix(GF2mField r100, int[][] r101) {
        this.field = r100;
        this.matrix = r101;
        this.numRows = r101.length;
        this.numColumns = r101[0].length;
    }

    public GF2mMatrix(GF2mMatrix r100) {
        int r101 = r100.numRows;
        this.numRows = r101;
        this.numColumns = r100.numColumns;
        this.field = r100.field;
        this.matrix = new int[r101][];
        int r102 = 0;
    L4:
        if (r102 >= this.numRows) goto L6;
        this.matrix[r102] = IntUtils.clone(r100.matrix[r102]);
        r102 = r102 + 1;
        goto L4
    }

    private void addToRow(int[] r100, int[] r101) {
        int r102 = r101.length - 1;
    L3:
        if (r102 < 0) goto L5;
        r101[r102] = this.field.add(r100[r102], r101[r102]);
        r102 = r102 - 1;
        goto L3
    }

    private int[] multRowWithElement(int[] r100, int r101) {
        int[] r102 = new int[r100.length];
        int r103 = r100.length - 1;
    L3:
        if (r103 < 0) goto L5;
        r102[r103] = this.field.mult(r100[r103], r101);
        r103 = r103 - 1;
        goto L3
    L5:
        return r102;
    }

    private void multRowWithElementThis(int[] r100, int r101) {
        int r102 = r100.length - 1;
    L3:
        if (r102 < 0) goto L5;
        r100[r102] = this.field.mult(r100[r102], r101);
        r102 = r102 - 1;
        goto L3
    }

    private static void swapColumns(int[][] r100, int r101, int r102) {
        int[] r103 = r100[r101];
        r100[r101] = r100[r102];
        r100[r102] = r103;
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.Matrix
    public Matrix computeInverse() {
        int r100 = this.numRows;
        if (r100 != this.numColumns) goto L38;
        int[][] r101 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{r100, r100});
        int r102 = this.numRows - 1;
    L5:
        if (r102 < 0) goto L7;
        r101[r102] = IntUtils.clone(this.matrix[r102]);
        r102 = r102 - 1;
        goto L5
    L7:
        int r103 = this.numRows;
        int[][] r104 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{r103, r103});
        int r105 = this.numRows - 1;
    L8:
        if (r105 < 0) goto L10;
        r104[r105][r105] = 1;
        r105 = r105 - 1;
        goto L8
    L10:
        int r106 = 0;
    L12:
        if (r106 >= this.numRows) goto L36;
        if (r101[r106][r106] != 0) goto L26;
        int r107 = r106 + 1;
        boolean r108 = false;
    L17:
        if (r107 >= this.numRows) goto L22;
        if (r101[r107][r106] == 0) goto L21;
        swapColumns(r101, r106, r107);
        swapColumns(r104, r106, r107);
        r107 = this.numRows;
        r108 = true;
    L21:
        r107 = r107 + 1;
        goto L17
    L22:
        if (r108 == true) goto L26;
        throw new ArithmeticException("Matrix is not invertible.");
    L26:
        int r109 = this.field.inverse(r101[r106][r106]);
        multRowWithElementThis(r101[r106], r109);
        multRowWithElementThis(r104[r106], r109);
        int r110 = 0;
    L28:
        if (r110 >= this.numRows) goto L34;
        if (r110 == r106) goto L33;
        int r111 = r101[r110][r106];
        if (r111 == 0) goto L33;
        int[] r112 = multRowWithElement(r101[r106], r111);
        int[] r113 = multRowWithElement(r104[r106], r111);
        addToRow(r112, r101[r110]);
        addToRow(r113, r104[r110]);
    L33:
        r110 = r110 + 1;
        goto L28
    L34:
        r106 = r106 + 1;
        goto L12
    L36:
        return new GF2mMatrix(this.field, r104);
    L38:
        throw new ArithmeticException("Matrix is not invertible.");
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L5;
    L27:
        return false;
    L5:
        if ((r100 instanceof GF2mMatrix) == false) goto L27;
        GF2mMatrix r101 = (GF2mMatrix) r100;
        if (this.field.equals(r101.field) == false) goto L27;
        int r102 = r101.numRows;
        int r103 = this.numColumns;
        if (r102 != r103) goto L27;
        if (r101.numColumns != r103) goto L27;
        int r104 = 0;
    L16:
        if (r104 >= this.numRows) goto L25;
        int r105 = 0;
    L19:
        if (r105 >= this.numColumns) goto L24;
        if (this.matrix[r104][r105] != r101.matrix[r104][r105]) goto L22;
        r105 = r105 + 1;
        goto L19
    L22:
        return false;
    L24:
        r104 = r104 + 1;
        goto L16
    L25:
        return true;
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.Matrix
    public byte[] getEncoded() {
        int r100 = 8;
        int r101 = 1;
    L4:
        if (this.field.getDegree() <= r100) goto L6;
        r101 = r101 + 1;
        r100 = r100 + 8;
        goto L4
    L6:
        int r102 = this.numRows;
        int r103 = (this.numColumns * r102) * r101;
        int r104 = 4;
        byte[] r105 = new byte[r103 + 4];
        r105[0] = (byte) (r102 & 255);
        r105[1] = (byte) ((r102 >>> 8) & 255);
        r105[2] = (byte) ((r102 >>> 16) & 255);
        r105[3] = (byte) ((r102 >>> 24) & 255);
        int r106 = 0;
    L8:
        if (r106 >= this.numRows) goto L17;
        int r107 = 0;
    L11:
        if (r107 >= this.numColumns) goto L16;
        int r108 = 0;
    L13:
        if (r108 >= r100) goto L15;
        r105[r104] = (byte) (this.matrix[r106][r107] >>> r108);
        r108 = r108 + 8;
        r104 = r104 + 1;
        goto L13
    L15:
        r107 = r107 + 1;
        goto L11
    L16:
        r106 = r106 + 1;
        goto L8
    L17:
        return r105;
    }

    public int hashCode() {
        int r100 = (((this.field.hashCode() * 31) + this.numRows) * 31) + this.numColumns;
        int r101 = 0;
    L4:
        if (r101 >= this.numRows) goto L10;
        int r102 = 0;
    L7:
        if (r102 >= this.numColumns) goto L9;
        r100 = (r100 * 31) + this.matrix[r101][r102];
        r102 = r102 + 1;
        goto L7
    L9:
        r101 = r101 + 1;
        goto L4
    L10:
        return r100;
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.Matrix
    public boolean isZero() {
        int r100 = 0;
    L4:
        if (r100 >= this.numRows) goto L13;
        int r101 = 0;
    L7:
        if (r101 >= this.numColumns) goto L12;
        if (this.matrix[r100][r101] != 0) goto L10;
        r101 = r101 + 1;
        goto L7
    L10:
        return false;
    L12:
        r100 = r100 + 1;
        goto L4
    L13:
        return true;
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.Matrix
    public Vector leftMultiply(Vector r100) {
        throw new RuntimeException("Not implemented.");
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.Matrix
    public Matrix rightMultiply(Matrix r100) {
        throw new RuntimeException("Not implemented.");
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.Matrix
    public Matrix rightMultiply(Permutation r100) {
        throw new RuntimeException("Not implemented.");
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.Matrix
    public Vector rightMultiply(Vector r100) {
        throw new RuntimeException("Not implemented.");
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.Matrix
    public String toString() {
        String r100 = this.numRows + " x " + this.numColumns + " Matrix over " + this.field.toString() + ": \n";
        int r101 = 0;
    L4:
        if (r101 >= this.numRows) goto L10;
        int r102 = 0;
    L7:
        if (r102 >= this.numColumns) goto L9;
        r100 = r100 + this.field.elementToStr(this.matrix[r101][r102]) + " : ";
        r102 = r102 + 1;
        goto L7
    L9:
        r100 = r100 + "\n";
        r101 = r101 + 1;
        goto L4
    L10:
        return r100;
    }
}
