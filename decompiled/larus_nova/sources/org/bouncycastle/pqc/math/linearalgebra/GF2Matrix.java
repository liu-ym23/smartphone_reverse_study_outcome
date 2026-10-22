package org.bouncycastle.pqc.math.linearalgebra;

import androidx.camera.video.AudioStats;
import java.lang.reflect.Array;
import java.security.SecureRandom;
import kotlin.UByte;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class GF2Matrix extends Matrix {
    private int length;
    private int[][] matrix;

    public GF2Matrix(int r100, char r101) {
        this(r100, r101, new SecureRandom());
    }

    public GF2Matrix(int r100, char r101, SecureRandom r102) {
        if (r100 <= 0) goto L23;
        if (r101 != 'I') goto L7;
        assignUnitMatrix(r100);
        return;
    L7:
        if (r101 != 'L') goto L9;
        assignRandomLowerTriangularMatrix(r100, r102);
        return;
    L9:
        if (r101 != 'R') goto L11;
        assignRandomRegularMatrix(r100, r102);
        return;
    L11:
        if (r101 != 'U') goto L13;
        assignRandomUpperTriangularMatrix(r100, r102);
        return;
    L13:
        if (r101 != 'Z') goto L16;
        assignZeroMatrix(r100, r100);
        return;
    L16:
        throw new ArithmeticException("Unknown matrix type.");
    L23:
        throw new ArithmeticException("Size of matrix is non-positive.");
    }

    private GF2Matrix(int r100, int r101) {
        if (r101 <= 0) goto L8;
        if (r100 <= 0) goto L8;
        assignZeroMatrix(r100, r101);
        return;
    L8:
        throw new ArithmeticException("size of matrix is non-positive");
    }

    public GF2Matrix(int r100, int[][] r101) {
        int r102 = 0;
        int[] r103 = r101[0];
        if (r103.length != ((r100 + 31) >> 5)) goto L14;
        this.numColumns = r100;
        this.numRows = r101.length;
        this.length = r103.length;
        int r104 = r100 & 31;
        if (r104 != 0) goto L7;
        int r105 = -1;
    L9:
        if (r102 >= this.numRows) goto L11;
        int[] r106 = r101[r102];
        int r107 = this.length - 1;
        r106[r107] = r106[r107] & r105;
        r102 = r102 + 1;
        goto L9
    L11:
        this.matrix = r101;
        return;
    L7:
        r105 = (1 << r104) - 1;
        goto L9
    L14:
        throw new ArithmeticException("Int array does not match given number of columns.");
    }

    public GF2Matrix(GF2Matrix r100) {
        this.numColumns = r100.getNumColumns();
        this.numRows = r100.getNumRows();
        this.length = r100.length;
        this.matrix = new int[r100.matrix.length][];
        int r101 = 0;
    L3:
        int[][] r102 = this.matrix;
        if (r101 >= r102.length) goto L6;
        r102[r101] = IntUtils.clone(r100.matrix[r101]);
        r101 = r101 + 1;
        goto L3
    }

    public GF2Matrix(byte[] r110) {
        if (r110.length < 9) goto L22;
        this.numRows = LittleEndianConversions.OS2IP(r110, 0);
        int r100 = LittleEndianConversions.OS2IP(r110, 4);
        this.numColumns = r100;
        int r101 = this.numRows;
        int r102 = ((r100 + 7) >>> 3) * r101;
        if (r101 <= 0) goto L20;
        int r103 = 8;
        if (r102 != (r110.length - 8)) goto L20;
        int r104 = (r100 + 31) >>> 5;
        this.length = r104;
        this.matrix = (int[][]) Array.newInstance(Integer.TYPE, new int[]{r101, r104});
        int r105 = this.numColumns;
        int r106 = r105 >> 5;
        int r107 = r105 & 31;
        int r108 = 0;
    L10:
        if (r108 >= this.numRows) goto L18;
        int r109 = 0;
    L12:
        if (r109 >= r106) goto L14;
        this.matrix[r108][r109] = LittleEndianConversions.OS2IP(r110, r103);
        r109 = r109 + 1;
        r103 = r103 + 4;
        goto L12
    L14:
        int r111 = 0;
    L15:
        if (r111 >= r107) goto L17;
        int[] r112 = this.matrix[r108];
        r112[r106] = ((r110[r103] & UByte.MAX_VALUE) << r111) ^ r112[r106];
        r111 = r111 + 8;
        r103 = r103 + 1;
        goto L15
    L17:
        r108 = r108 + 1;
        goto L10
    L18:
        return;
    L20:
        throw new ArithmeticException("given array is not an encoded matrix over GF(2)");
    L22:
        throw new ArithmeticException("given array is not an encoded matrix over GF(2)");
    }

    private static void addToRow(int[] r100, int[] r101, int r102) {
        int r103 = r101.length - 1;
    L3:
        if (r103 < r102) goto L5;
        r101[r103] = r100[r103] ^ r101[r103];
        r103 = r103 - 1;
        goto L3
    }

    private void assignRandomLowerTriangularMatrix(int r100, SecureRandom r110) {
        this.numRows = r100;
        this.numColumns = r100;
        int r101 = (r100 + 31) >>> 5;
        this.length = r101;
        this.matrix = (int[][]) Array.newInstance(Integer.TYPE, new int[]{r100, r101});
        int r102 = 0;
    L4:
        if (r102 >= this.numRows) goto L13;
        int r103 = r102 >>> 5;
        int r104 = r102 & 31;
        int r105 = 31 - r104;
        int r106 = 1 << r104;
        int r107 = 0;
    L6:
        if (r107 >= r103) goto L8;
        this.matrix[r102][r107] = r110.nextInt();
        r107 = r107 + 1;
        goto L6
    L8:
        this.matrix[r102][r103] = r106 | (r110.nextInt() >>> r105);
    L9:
        r103 = r103 + 1;
        if (r103 >= this.length) goto L12;
        this.matrix[r102][r103] = 0;
        goto L9
    L12:
        r102 = r102 + 1;
        goto L4
    }

    private void assignRandomRegularMatrix(int r100, SecureRandom r101) {
        this.numRows = r100;
        this.numColumns = r100;
        int r102 = (r100 + 31) >>> 5;
        this.length = r102;
        this.matrix = (int[][]) Array.newInstance(Integer.TYPE, new int[]{r100, r102});
        GF2Matrix r103 = (GF2Matrix) new GF2Matrix(r100, Matrix.MATRIX_TYPE_RANDOM_LT, r101).rightMultiply(new GF2Matrix(r100, Matrix.MATRIX_TYPE_RANDOM_UT, r101));
        int[] r104 = new Permutation(r100, r101).getVector();
        int r105 = 0;
    L3:
        if (r105 >= r100) goto L5;
        System.arraycopy(r103.matrix[r105], 0, this.matrix[r104[r105]], 0, this.length);
        r105 = r105 + 1;
        goto L3
    }

    private void assignRandomUpperTriangularMatrix(int r100, SecureRandom r110) {
        this.numRows = r100;
        this.numColumns = r100;
        int r101 = (r100 + 31) >>> 5;
        this.length = r101;
        this.matrix = (int[][]) Array.newInstance(Integer.TYPE, new int[]{r100, r101});
        int r102 = r100 & 31;
        if (r102 != 0) goto L5;
        int r103 = -1;
    L6:
        int r104 = 0;
    L8:
        if (r104 >= this.numRows) goto L17;
        int r105 = r104 >>> 5;
        int r106 = r104 & 31;
        int r107 = 1 << r106;
        int r108 = 0;
    L10:
        if (r108 >= r105) goto L12;
        this.matrix[r104][r108] = 0;
        r108 = r108 + 1;
        goto L10
    L12:
        this.matrix[r104][r105] = (r110.nextInt() << r106) | r107;
    L13:
        r105 = r105 + 1;
        int r109 = this.length;
        if (r105 >= r109) goto L16;
        this.matrix[r104][r105] = r110.nextInt();
        goto L13
    L16:
        int[] r111 = this.matrix[r104];
        int r112 = r109 - 1;
        r111[r112] = r111[r112] & r103;
        r104 = r104 + 1;
        goto L8
    L17:
        return;
    L5:
        r103 = (1 << r102) - 1;
        goto L6
    }

    private void assignUnitMatrix(int r100) {
        this.numRows = r100;
        this.numColumns = r100;
        int r101 = (r100 + 31) >>> 5;
        this.length = r101;
        int[] r102 = {r100, r101};
        int r103 = 0;
        this.matrix = (int[][]) Array.newInstance(Integer.TYPE, r102);
        int r104 = 0;
    L4:
        if (r104 >= this.numRows) goto L11;
        int r105 = 0;
    L7:
        if (r105 >= this.length) goto L9;
        this.matrix[r104][r105] = 0;
        r105 = r105 + 1;
        goto L7
    L9:
        r104 = r104 + 1;
    L11:
        if (r103 >= this.numRows) goto L13;
        this.matrix[r103][r103 >>> 5] = 1 << (r103 & 31);
        r103 = r103 + 1;
        goto L11
    }

    private void assignZeroMatrix(int r100, int r101) {
        this.numRows = r100;
        this.numColumns = r101;
        int r102 = (r101 + 31) >>> 5;
        this.length = r102;
        this.matrix = (int[][]) Array.newInstance(Integer.TYPE, new int[]{r100, r102});
        int r103 = 0;
    L4:
        if (r103 >= this.numRows) goto L10;
        int r104 = 0;
    L7:
        if (r104 >= this.length) goto L9;
        this.matrix[r103][r104] = 0;
        r104 = r104 + 1;
        goto L7
    L9:
        r103 = r103 + 1;
        goto L4
    }

    public static GF2Matrix[] createRandomRegularMatrixAndItsInverse(int r110, SecureRandom r111) {
        GF2Matrix[] r100 = new GF2Matrix[2];
        int r101 = (r110 + 31) >> 5;
        GF2Matrix r102 = new GF2Matrix(r110, Matrix.MATRIX_TYPE_RANDOM_LT, r111);
        GF2Matrix r103 = new GF2Matrix(r110, Matrix.MATRIX_TYPE_RANDOM_UT, r111);
        GF2Matrix r104 = (GF2Matrix) r102.rightMultiply(r103);
        Permutation r105 = new Permutation(r110, r111);
        int[] r106 = r105.getVector();
        int[][] r107 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{r110, r101});
        int r112 = 0;
    L3:
        if (r112 >= r110) goto L5;
        System.arraycopy(r104.matrix[r106[r112]], 0, r107[r112], 0, r101);
        r112 = r112 + 1;
        goto L3
    L5:
        r100[0] = new GF2Matrix(r110, r107);
        GF2Matrix r108 = new GF2Matrix(r110, 'I');
        int r109 = 0;
    L6:
        if (r109 >= r110) goto L16;
        int r113 = r109 >>> 5;
        int r114 = 1 << (r109 & 31);
        int r115 = r109 + 1;
        int r116 = r115;
    L8:
        if (r116 >= r110) goto L15;
        if ((r102.matrix[r116][r113] & r114) == 0) goto L14;
        int r117 = 0;
    L12:
        if (r117 > r113) goto L14;
        int[][] r118 = r108.matrix;
        int[] r119 = r118[r116];
        r119[r117] = r119[r117] ^ r118[r109][r117];
        r117 = r117 + 1;
    L14:
        r116 = r116 + 1;
        goto L8
    L15:
        r109 = r115;
        goto L6
    L16:
        GF2Matrix r120 = new GF2Matrix(r110, 'I');
        int r121 = r110 - 1;
    L17:
        if (r121 < 0) goto L27;
        int r122 = r121 >>> 5;
        int r123 = 1 << (r121 & 31);
        int r124 = r121 - 1;
    L19:
        if (r124 < 0) goto L26;
        if ((r103.matrix[r124][r122] & r123) == 0) goto L25;
        int r125 = r122;
    L23:
        if (r125 >= r101) goto L25;
        int[][] r126 = r120.matrix;
        int[] r127 = r126[r124];
        r127[r125] = r126[r121][r125] ^ r127[r125];
        r125 = r125 + 1;
    L25:
        r124 = r124 - 1;
        goto L19
    L26:
        r121 = r121 - 1;
        goto L17
    L27:
        r100[1] = (GF2Matrix) r120.rightMultiply(r108.rightMultiply(r105));
        return r100;
    }

    private static void swapRows(int[][] r100, int r101, int r102) {
        int[] r103 = r100[r101];
        r100[r101] = r100[r102];
        r100[r102] = r103;
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.Matrix
    public Matrix computeInverse() {
        int r100 = this.numRows;
        if (r100 != this.numColumns) goto L37;
        int[][] r101 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{r100, this.length});
        int r102 = this.numRows - 1;
    L5:
        if (r102 < 0) goto L7;
        r101[r102] = IntUtils.clone(this.matrix[r102]);
        r102 = r102 - 1;
        goto L5
    L7:
        int[][] r103 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{this.numRows, this.length});
        int r104 = this.numRows - 1;
    L8:
        if (r104 < 0) goto L10;
        r103[r104][r104 >> 5] = 1 << (r104 & 31);
        r104 = r104 - 1;
        goto L8
    L10:
        int r105 = 0;
    L12:
        if (r105 >= this.numRows) goto L35;
        int r106 = r105 >> 5;
        int r107 = 1 << (r105 & 31);
        if ((r101[r105][r106] & r107) != 0) goto L26;
        int r108 = r105 + 1;
        boolean r109 = false;
    L17:
        if (r108 >= this.numRows) goto L22;
        if ((r101[r108][r106] & r107) == 0) goto L21;
        swapRows(r101, r105, r108);
        swapRows(r103, r105, r108);
        r108 = this.numRows;
        r109 = true;
    L21:
        r108 = r108 + 1;
        goto L17
    L22:
        if (r109 == true) goto L26;
        throw new ArithmeticException("Matrix is not invertible.");
    L26:
        int r110 = this.numRows - 1;
    L27:
        if (r110 < 0) goto L33;
        if (r110 == r105) goto L32;
        int[] r111 = r101[r110];
        if ((r111[r106] & r107) == 0) goto L32;
        addToRow(r101[r105], r111, r106);
        addToRow(r103[r105], r103[r110], 0);
    L32:
        r110 = r110 - 1;
        goto L27
    L33:
        r105 = r105 + 1;
        goto L12
    L35:
        return new GF2Matrix(this.numColumns, r103);
    L37:
        throw new ArithmeticException("Matrix is not invertible.");
    }

    public Matrix computeTranspose() {
        int[][] r100 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{this.numColumns, (this.numRows + 31) >>> 5});
        int r101 = 0;
    L3:
        int r102 = this.numRows;
        if (r101 >= r102) goto L14;
        int r103 = 0;
    L7:
        if (r103 >= this.numColumns) goto L12;
        int r104 = r101 >>> 5;
        int r105 = r101 & 31;
        if (((this.matrix[r101][r103 >>> 5] >>> (r103 & 31)) & 1) != 1) goto L11;
        int[] r106 = r100[r103];
        r106[r104] = (1 << r105) | r106[r104];
    L11:
        r103 = r103 + 1;
        goto L7
    L12:
        r101 = r101 + 1;
        goto L3
    L14:
        return new GF2Matrix(r102, r100);
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof GF2Matrix) == true) goto L5;
        return false;
    L5:
        GF2Matrix r101 = (GF2Matrix) r100;
        if (this.numRows == r101.numRows) goto L8;
    L21:
        return false;
    L8:
        if (this.numColumns != r101.numColumns) goto L21;
        if (this.length != r101.length) goto L21;
        int r102 = 0;
    L14:
        if (r102 >= this.numRows) goto L19;
        if (IntUtils.equals(this.matrix[r102], r101.matrix[r102]) == false) goto L17;
        r102 = r102 + 1;
        goto L14
    L17:
        return false;
    L19:
        return true;
    }

    public GF2Matrix extendLeftCompactForm() {
        int r100 = this.numColumns;
        int r101 = this.numRows;
        GF2Matrix r102 = new GF2Matrix(r101, r100 + r101);
        int r103 = this.numRows;
        int r104 = (r103 - 1) + this.numColumns;
        int r105 = r103 - 1;
    L3:
        if (r105 < 0) goto L5;
        System.arraycopy(this.matrix[r105], 0, r102.matrix[r105], 0, this.length);
        int[] r106 = r102.matrix[r105];
        int r107 = r104 >> 5;
        r106[r107] = r106[r107] | (1 << (r104 & 31));
        r105 = r105 - 1;
        r104 = r104 - 1;
        goto L3
    L5:
        return r102;
    }

    public GF2Matrix extendRightCompactForm() {
        int r100 = this.numRows;
        GF2Matrix r101 = new GF2Matrix(r100, this.numColumns + r100);
        int r102 = this.numRows;
        int r103 = r102 >> 5;
        int r104 = r102 & 31;
        int r105 = r102 - 1;
    L3:
        if (r105 < 0) goto L15;
        int[] r106 = r101.matrix[r105];
        int r107 = r105 >> 5;
        r106[r107] = r106[r107] | (1 << (r105 & 31));
        int r108 = 0;
        if (r104 == 0) goto L13;
        int r109 = r103;
    L7:
        int r110 = this.length;
        if (r108 >= (r110 - 1)) goto L10;
        int r111 = this.matrix[r105][r108];
        int[] r112 = r101.matrix[r105];
        int r113 = r109 + 1;
        r112[r109] = r112[r109] | (r111 << r104);
        r112[r113] = r112[r113] | (r111 >>> (32 - r104));
        r108 = r108 + 1;
        r109 = r113;
        goto L7
    L10:
        int r114 = this.matrix[r105][r110 - 1];
        int[] r115 = r101.matrix[r105];
        int r116 = r109 + 1;
        r115[r109] = r115[r109] | (r114 << r104);
        if (r116 >= r101.length) goto L14;
        r115[r116] = r115[r116] | (r114 >>> (32 - r104));
    L14:
        r105 = r105 - 1;
        goto L3
    L13:
        System.arraycopy(this.matrix[r105], 0, r106, r103, this.length);
        goto L14
    L15:
        return r101;
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.Matrix
    public byte[] getEncoded() {
        int r100 = (this.numColumns + 7) >>> 3;
        int r101 = this.numRows;
        int r102 = 8;
        byte[] r103 = new byte[(r100 * r101) + 8];
        LittleEndianConversions.I2OSP(r101, r103, 0);
        LittleEndianConversions.I2OSP(this.numColumns, r103, 4);
        int r104 = this.numColumns;
        int r105 = r104 >>> 5;
        int r106 = r104 & 31;
        int r107 = 0;
    L4:
        if (r107 >= this.numRows) goto L12;
        int r108 = 0;
    L6:
        if (r108 >= r105) goto L8;
        LittleEndianConversions.I2OSP(this.matrix[r107][r108], r103, r102);
        r108 = r108 + 1;
        r102 = r102 + 4;
        goto L6
    L8:
        int r109 = 0;
    L9:
        if (r109 >= r106) goto L11;
        r103[r102] = (byte) ((this.matrix[r107][r105] >>> r109) & 255);
        r109 = r109 + 8;
        r102 = r102 + 1;
        goto L9
    L11:
        r107 = r107 + 1;
        goto L4
    L12:
        return r103;
    }

    public double getHammingWeight() {
        int r100 = this.numColumns & 31;
        int r101 = this.length;
        if (r100 == 0) goto L6;
        r101 = r101 - 1;
    L6:
        double r102 = AudioStats.AUDIO_AMPLITUDE_NONE;
        double r103 = 0.0d;
        int r104 = 0;
    L8:
        if (r104 >= this.numRows) goto L22;
        int r105 = 0;
    L11:
        if (r105 >= r101) goto L17;
        int r110 = this.matrix[r104][r105];
        int r111 = 0;
    L14:
        if (r111 >= 32) goto L16;
        r102 = r102 + ((double) ((r110 >>> r111) & 1));
        r103 = r103 + 1.0d;
        r111 = r111 + 1;
        goto L14
    L16:
        r105 = r105 + 1;
        goto L11
    L17:
        int r106 = this.matrix[r104][this.length - 1];
        int r112 = 0;
    L18:
        if (r112 >= r100) goto L20;
        r102 = r102 + ((double) ((r106 >>> r112) & 1));
        r103 = r103 + 1.0d;
        r112 = r112 + 1;
        goto L18
    L20:
        r104 = r104 + 1;
        goto L8
    L22:
        return r102 / r103;
    }

    public int[][] getIntArray() {
        return this.matrix;
    }

    public GF2Matrix getLeftSubMatrix() {
        int r100 = this.numColumns;
        int r101 = this.numRows;
        if (r100 <= r101) goto L13;
        int r102 = (r101 + 31) >> 5;
        int[][] r103 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{r101, r102});
        int r104 = this.numRows;
        int r105 = (1 << (r104 & 31)) - 1;
        if (r105 != 0) goto L7;
        r105 = -1;
    L7:
        int r106 = r104 - 1;
    L8:
        if (r106 < 0) goto L11;
        System.arraycopy(this.matrix[r106], 0, r103[r106], 0, r102);
        int[] r107 = r103[r106];
        int r108 = r102 - 1;
        r107[r108] = r107[r108] & r105;
        r106 = r106 - 1;
        goto L8
    L11:
        return new GF2Matrix(this.numRows, r103);
    L13:
        throw new ArithmeticException("empty submatrix");
    }

    public int getLength() {
        return this.length;
    }

    public GF2Matrix getRightSubMatrix() {
        int r100 = this.numColumns;
        int r101 = this.numRows;
        if (r100 <= r101) goto L19;
        int r102 = r101 >> 5;
        int r103 = r101 & 31;
        GF2Matrix r104 = new GF2Matrix(r101, r100 - r101);
        int r105 = this.numRows - 1;
    L5:
        if (r105 < 0) goto L17;
        int r106 = 0;
        if (r103 == 0) goto L15;
        int r107 = r102;
    L9:
        int r108 = r104.length;
        if (r106 >= (r108 - 1)) goto L12;
        int[] r109 = r104.matrix[r105];
        int[] r110 = this.matrix[r105];
        int r111 = r107 + 1;
        r109[r106] = (r110[r107] >>> r103) | (r110[r111] << (32 - r103));
        r106 = r106 + 1;
        r107 = r111;
        goto L9
    L12:
        int[] r112 = r104.matrix[r105];
        int[] r113 = this.matrix[r105];
        int r114 = r107 + 1;
        r112[r108 - 1] = r113[r107] >>> r103;
        if (r114 >= this.length) goto L16;
        int r115 = r108 - 1;
        r112[r115] = r112[r115] | (r113[r114] << (32 - r103));
    L16:
        r105 = r105 - 1;
        goto L5
    L15:
        System.arraycopy(this.matrix[r105], r102, r104.matrix[r105], 0, r104.length);
        goto L16
    L17:
        return r104;
    L19:
        throw new ArithmeticException("empty submatrix");
    }

    public int[] getRow(int r100) {
        return this.matrix[r100];
    }

    public int hashCode() {
        int r100 = (((this.numRows * 31) + this.numColumns) * 31) + this.length;
        int r101 = 0;
    L4:
        if (r101 >= this.numRows) goto L6;
        r100 = (r100 * 31) + Arrays.hashCode(this.matrix[r101]);
        r101 = r101 + 1;
        goto L4
    L6:
        return r100;
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.Matrix
    public boolean isZero() {
        int r100 = 0;
    L4:
        if (r100 >= this.numRows) goto L13;
        int r101 = 0;
    L7:
        if (r101 >= this.length) goto L12;
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

    public Matrix leftMultiply(Permutation r100) {
        int[] r101 = r100.getVector();
        int r102 = r101.length;
        int r103 = this.numRows;
        if (r102 != r103) goto L10;
        int[][] r104 = new int[r103][];
        int r105 = r103 - 1;
    L5:
        if (r105 < 0) goto L8;
        r104[r105] = IntUtils.clone(this.matrix[r101[r105]]);
        r105 = r105 - 1;
        goto L5
    L8:
        return new GF2Matrix(this.numRows, r104);
    L10:
        throw new ArithmeticException("length mismatch");
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.Matrix
    public Vector leftMultiply(Vector r110) {
        if ((r110 instanceof GF2Vector) == false) goto L31;
        if (r110.length != this.numRows) goto L29;
        int[] r111 = ((GF2Vector) r110).getVecArray();
        int[] r100 = new int[this.length];
        int r101 = this.numRows;
        int r102 = r101 >> 5;
        int r103 = 1;
        int r104 = 1 << (r101 & 31);
        int r105 = 0;
        int r106 = 0;
    L7:
        if (r105 >= r102) goto L18;
        int r107 = 1;
    L10:
        if ((r111[r105] & r107) == 0) goto L15;
        int r108 = 0;
    L13:
        if (r108 >= this.length) goto L15;
        r100[r108] = r100[r108] ^ this.matrix[r106][r108];
        r108 = r108 + 1;
    L15:
        r106 = r106 + 1;
        r107 = r107 << 1;
        if (r107 != 0) goto L10;
        r105 = r105 + 1;
    L18:
        if (r103 == r104) goto L27;
        if ((r111[r102] & r103) == 0) goto L25;
        int r109 = 0;
    L23:
        if (r109 >= this.length) goto L25;
        r100[r109] = r100[r109] ^ this.matrix[r106][r109];
        r109 = r109 + 1;
    L25:
        r106 = r106 + 1;
        r103 = r103 << 1;
        goto L18
    L27:
        return new GF2Vector(r100, this.numColumns);
    L29:
        throw new ArithmeticException("length mismatch");
    L31:
        throw new ArithmeticException("vector is not defined over GF(2)");
    }

    public Vector leftMultiplyLeftCompactForm(Vector r110) {
        if ((r110 instanceof GF2Vector) == false) goto L35;
        if (r110.length != this.numRows) goto L33;
        int[] r111 = ((GF2Vector) r110).getVecArray();
        int r100 = this.numRows;
        int[] r101 = new int[((this.numColumns + r100) + 31) >>> 5];
        int r102 = r100 >>> 5;
        int r103 = 0;
        int r104 = 0;
    L8:
        if (r103 >= r102) goto L20;
        int r105 = 1;
    L11:
        if ((r111[r103] & r105) == 0) goto L17;
        int r106 = 0;
    L14:
        if (r106 >= this.length) goto L16;
        r101[r106] = r101[r106] ^ this.matrix[r104][r106];
        r106 = r106 + 1;
        goto L14
    L16:
        int r107 = this.numColumns;
        int r108 = (r107 + r104) >>> 5;
        int r109 = 1 << ((r107 + r104) & 31);
        r101[r108] = r109 | r101[r108];
    L17:
        r104 = r104 + 1;
        r105 = r105 << 1;
        if (r105 != 0) goto L11;
        r103 = r103 + 1;
        goto L8
    L20:
        int r112 = 1 << (this.numRows & 31);
        int r113 = 1;
    L21:
        if (r113 == r112) goto L31;
        if ((r111[r102] & r113) == 0) goto L29;
        int r114 = 0;
    L26:
        if (r114 >= this.length) goto L28;
        r101[r114] = r101[r114] ^ this.matrix[r104][r114];
        r114 = r114 + 1;
        goto L26
    L28:
        int r115 = this.numColumns;
        int r116 = (r115 + r104) >>> 5;
        int r117 = 1 << ((r115 + r104) & 31);
        r101[r116] = r117 | r101[r116];
    L29:
        r104 = r104 + 1;
        r113 = r113 << 1;
        goto L21
    L31:
        return new GF2Vector(r101, this.numRows + this.numColumns);
    L33:
        throw new ArithmeticException("length mismatch");
    L35:
        throw new ArithmeticException("vector is not defined over GF(2)");
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.Matrix
    public Matrix rightMultiply(Matrix r110) {
        if ((r110 instanceof GF2Matrix) == false) goto L40;
        if (r110.numRows != this.numColumns) goto L38;
        GF2Matrix r100 = (GF2Matrix) r110;
        GF2Matrix r101 = new GF2Matrix(this.numRows, r110.numColumns);
        int r111 = this.numColumns & 31;
        int r102 = this.length;
        if (r111 == 0) goto L10;
        r102 = r102 - 1;
    L10:
        int r103 = 0;
    L12:
        if (r103 >= this.numRows) goto L36;
        int r104 = 0;
        int r105 = 0;
    L14:
        if (r104 >= r102) goto L26;
        int r106 = this.matrix[r103][r104];
        int r107 = 0;
    L17:
        if (r107 >= 32) goto L25;
        if (((1 << r107) & r106) == 0) goto L24;
        int r112 = 0;
    L22:
        if (r112 >= r100.length) goto L24;
        int[] r113 = r101.matrix[r103];
        r113[r112] = r113[r112] ^ r100.matrix[r105][r112];
        r112 = r112 + 1;
    L24:
        r105 = r105 + 1;
        r107 = r107 + 1;
        goto L17
    L25:
        r104 = r104 + 1;
        goto L14
    L26:
        int r108 = this.matrix[r103][this.length - 1];
        int r109 = 0;
    L27:
        if (r109 >= r111) goto L35;
        if (((1 << r109) & r108) == 0) goto L34;
        int r114 = 0;
    L32:
        if (r114 >= r100.length) goto L34;
        int[] r115 = r101.matrix[r103];
        r115[r114] = r115[r114] ^ r100.matrix[r105][r114];
        r114 = r114 + 1;
    L34:
        r105 = r105 + 1;
        r109 = r109 + 1;
        goto L27
    L35:
        r103 = r103 + 1;
        goto L12
    L36:
        return r101;
    L38:
        throw new ArithmeticException("length mismatch");
    L40:
        throw new ArithmeticException("matrix is not defined over GF(2)");
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.Matrix
    public Matrix rightMultiply(Permutation r110) {
        int[] r111 = r110.getVector();
        int r100 = r111.length;
        int r101 = this.numColumns;
        if (r100 != r101) goto L12;
        GF2Matrix r102 = new GF2Matrix(this.numRows, r101);
        int r103 = this.numColumns - 1;
    L5:
        if (r103 < 0) goto L10;
        int r104 = r103 >>> 5;
        int r105 = r103 & 31;
        int r106 = r111[r103];
        int r107 = r106 >>> 5;
        int r108 = r106 & 31;
        int r109 = this.numRows - 1;
    L7:
        if (r109 < 0) goto L9;
        int[] r112 = r102.matrix[r109];
        r112[r104] = r112[r104] | (((this.matrix[r109][r107] >>> r108) & 1) << r105);
        r109 = r109 - 1;
        goto L7
    L9:
        r103 = r103 - 1;
        goto L5
    L10:
        return r102;
    L12:
        throw new ArithmeticException("length mismatch");
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.Matrix
    public Vector rightMultiply(Vector r100) {
        if ((r100 instanceof GF2Vector) == false) goto L25;
        if (r100.length != this.numColumns) goto L23;
        int[] r101 = ((GF2Vector) r100).getVecArray();
        int[] r102 = new int[(this.numRows + 31) >>> 5];
        int r103 = 0;
    L7:
        int r104 = this.numRows;
        if (r103 >= r104) goto L21;
        int r105 = 0;
        int r106 = 0;
    L11:
        if (r105 >= this.length) goto L13;
        r106 = r106 ^ (this.matrix[r103][r105] & r101[r105]);
        r105 = r105 + 1;
        goto L11
    L13:
        int r107 = 0;
        int r108 = 0;
    L15:
        if (r107 >= 32) goto L17;
        r108 = r108 ^ ((r106 >>> r107) & 1);
        r107 = r107 + 1;
        goto L15
    L17:
        if (r108 != 1) goto L19;
        int r109 = r103 >>> 5;
        r102[r109] = r102[r109] | (1 << (r103 & 31));
    L19:
        r103 = r103 + 1;
        goto L7
    L21:
        return new GF2Vector(r102, r104);
    L23:
        throw new ArithmeticException("length mismatch");
    L25:
        throw new ArithmeticException("vector is not defined over GF(2)");
    }

    public Vector rightMultiplyRightCompactForm(Vector r110) {
        if ((r110 instanceof GF2Vector) == false) goto L33;
        if (r110.length != (this.numColumns + this.numRows)) goto L31;
        int[] r111 = ((GF2Vector) r110).getVecArray();
        int r100 = this.numRows;
        int[] r101 = new int[(r100 + 31) >>> 5];
        int r102 = r100 >> 5;
        int r103 = r100 & 31;
        int r104 = 0;
    L7:
        int r105 = this.numRows;
        if (r104 >= r105) goto L29;
        int r106 = r104 >> 5;
        int r107 = r104 & 31;
        int r108 = (r111[r106] >>> r107) & 1;
        int r112 = r102;
        int r109 = 0;
        if (r103 == 0) goto L19;
    L11:
        int r113 = this.length;
        if (r109 >= (r113 - 1)) goto L14;
        int r114 = r112 + 1;
        r108 = r108 ^ (((r111[r112] >>> r103) | (r111[r114] << (32 - r103))) & this.matrix[r104][r109]);
        r109 = r109 + 1;
        r112 = r114;
        goto L11
    L14:
        int r115 = r112 + 1;
        int r116 = r111[r112] >>> r103;
        if (r115 >= r111.length) goto L17;
        r116 = r116 | (r111[r115] << (32 - r103));
    L17:
        r108 = r108 ^ (this.matrix[r104][r113 - 1] & r116);
    L21:
        int r117 = 0;
        int r118 = 0;
    L23:
        if (r117 >= 32) goto L25;
        r118 = r118 ^ (r108 & 1);
        r108 = r108 >>> 1;
        r117 = r117 + 1;
        goto L23
    L25:
        if (r118 != 1) goto L27;
        r101[r106] = r101[r106] | (1 << r107);
    L27:
        r104 = r104 + 1;
    L19:
        if (r109 >= this.length) goto L21;
        r108 = r108 ^ (r111[r112] & this.matrix[r104][r109]);
        r109 = r109 + 1;
        r112 = r112 + 1;
        goto L19
    L29:
        return new GF2Vector(r101, r105);
    L31:
        throw new ArithmeticException("length mismatch");
    L33:
        throw new ArithmeticException("vector is not defined over GF(2)");
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.Matrix
    public String toString() {
        int r100 = this.numColumns & 31;
        int r101 = this.length;
        if (r100 == 0) goto L6;
        r101 = r101 - 1;
    L6:
        StringBuffer r102 = new StringBuffer();
        int r103 = 0;
    L8:
        if (r103 >= this.numRows) goto L30;
        r102.append(r103 + ": ");
        int r104 = 0;
    L11:
        if (r104 >= r101) goto L21;
        int r105 = this.matrix[r103][r104];
        int r106 = 0;
    L14:
        if (r106 >= 32) goto L20;
        if (((r105 >>> r106) & 1) != 0) goto L18;
        r102.append('0');
    L19:
        r106 = r106 + 1;
        goto L14
    L18:
        r102.append('1');
        goto L19
    L20:
        r102.append(' ');
        r104 = r104 + 1;
        goto L11
    L21:
        int r107 = this.matrix[r103][this.length - 1];
        int r108 = 0;
    L22:
        if (r108 >= r100) goto L28;
        if (((r107 >>> r108) & 1) != 0) goto L26;
        r102.append('0');
    L27:
        r108 = r108 + 1;
        goto L22
    L26:
        r102.append('1');
        goto L27
    L28:
        r102.append('\n');
        r103 = r103 + 1;
        goto L8
    L30:
        return r102.toString();
    }
}
