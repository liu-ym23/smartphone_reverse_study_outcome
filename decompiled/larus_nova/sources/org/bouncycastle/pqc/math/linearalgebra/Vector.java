package org.bouncycastle.pqc.math.linearalgebra;

/* JADX INFO: loaded from: classes42.dex */
public abstract class Vector {
    protected int length;

    public Vector() {
    }

    public abstract Vector add(Vector r100);

    public abstract boolean equals(Object r100);

    public abstract byte[] getEncoded();

    public final int getLength() {
        return this.length;
    }

    public abstract int hashCode();

    public abstract boolean isZero();

    public abstract Vector multiply(Permutation r100);

    public abstract String toString();
}
