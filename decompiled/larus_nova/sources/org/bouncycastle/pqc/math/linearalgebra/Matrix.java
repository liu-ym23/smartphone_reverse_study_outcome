package org.bouncycastle.pqc.math.linearalgebra;

/* JADX INFO: loaded from: classes42.dex */
public abstract class Matrix {
    public static final char MATRIX_TYPE_RANDOM_LT = 'L';
    public static final char MATRIX_TYPE_RANDOM_REGULAR = 'R';
    public static final char MATRIX_TYPE_RANDOM_UT = 'U';
    public static final char MATRIX_TYPE_UNIT = 'I';
    public static final char MATRIX_TYPE_ZERO = 'Z';
    protected int numColumns;
    protected int numRows;

    public Matrix() {
    }

    public abstract Matrix computeInverse();

    public abstract byte[] getEncoded();

    public int getNumColumns() {
        return this.numColumns;
    }

    public int getNumRows() {
        return this.numRows;
    }

    public abstract boolean isZero();

    public abstract Vector leftMultiply(Vector r100);

    public abstract Matrix rightMultiply(Matrix r100);

    public abstract Matrix rightMultiply(Permutation r100);

    public abstract Vector rightMultiply(Vector r100);

    public abstract String toString();
}
