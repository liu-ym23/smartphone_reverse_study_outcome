package org.bouncycastle.pqc.math.linearalgebra;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes42.dex */
public interface GFElement {
    GFElement add(GFElement r100) throws RuntimeException;

    void addToThis(GFElement r100) throws RuntimeException;

    Object clone();

    boolean equals(Object r100);

    int hashCode();

    GFElement invert() throws ArithmeticException;

    boolean isOne();

    boolean isZero();

    GFElement multiply(GFElement r100) throws RuntimeException;

    void multiplyThisBy(GFElement r100) throws RuntimeException;

    GFElement subtract(GFElement r100) throws RuntimeException;

    void subtractFromThis(GFElement r100);

    byte[] toByteArray();

    BigInteger toFlexiBigInt();

    String toString();

    String toString(int r100);
}
