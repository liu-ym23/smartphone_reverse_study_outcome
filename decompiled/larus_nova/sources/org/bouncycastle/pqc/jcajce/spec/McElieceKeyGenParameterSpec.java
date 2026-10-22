package org.bouncycastle.pqc.jcajce.spec;

import java.security.InvalidParameterException;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.pqc.math.linearalgebra.PolynomialRingGF2;

/* JADX INFO: loaded from: classes42.dex */
public class McElieceKeyGenParameterSpec implements AlgorithmParameterSpec {
    public static final int DEFAULT_M = 11;
    public static final int DEFAULT_T = 50;
    private int fieldPoly;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f525600m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f525601n;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f525602t;

    public McElieceKeyGenParameterSpec() {
        this(11, 50);
    }

    public McElieceKeyGenParameterSpec(int r100) {
        if (r100 < 1) goto L11;
        this.f525600m = 0;
        this.f525601n = 1;
    L5:
        int r101 = this.f525601n;
        if (r101 >= r100) goto L8;
        this.f525601n = r101 << 1;
        this.f525600m++;
        goto L5
    L8:
        int r102 = r101 >>> 1;
        this.f525602t = r102;
        int r103 = this.f525600m;
        this.f525602t = r102 / r103;
        this.fieldPoly = PolynomialRingGF2.getIrreduciblePolynomial(r103);
        return;
    L11:
        throw new IllegalArgumentException("key size must be positive");
    }

    public McElieceKeyGenParameterSpec(int r100, int r101) throws InvalidParameterException {
        if (r100 < 1) goto L18;
        if (r100 > 32) goto L16;
        this.f525600m = r100;
        int r102 = 1 << r100;
        this.f525601n = r102;
        if (r101 < 0) goto L14;
        if (r101 > r102) goto L12;
        this.f525602t = r101;
        this.fieldPoly = PolynomialRingGF2.getIrreduciblePolynomial(r100);
        return;
    L12:
        throw new IllegalArgumentException("t must be less than n = 2^m");
    L14:
        throw new IllegalArgumentException("t must be positive");
    L16:
        throw new IllegalArgumentException("m is too large");
    L18:
        throw new IllegalArgumentException("m must be positive");
    }

    public McElieceKeyGenParameterSpec(int r100, int r101, int r102) {
        this.f525600m = r100;
        if (r100 < 1) goto L24;
        if (r100 > 32) goto L22;
        int r103 = 1 << r100;
        this.f525601n = r103;
        this.f525602t = r101;
        if (r101 < 0) goto L20;
        if (r101 > r103) goto L18;
        if (PolynomialRingGF2.degree(r102) != r100) goto L16;
        if (PolynomialRingGF2.isIrreducible(r102) == false) goto L16;
        this.fieldPoly = r102;
        return;
    L16:
        throw new IllegalArgumentException("polynomial is not a field polynomial for GF(2^m)");
    L18:
        throw new IllegalArgumentException("t must be less than n = 2^m");
    L20:
        throw new IllegalArgumentException("t must be positive");
    L22:
        throw new IllegalArgumentException(" m is too large");
    L24:
        throw new IllegalArgumentException("m must be positive");
    }

    public int getFieldPoly() {
        return this.fieldPoly;
    }

    public int getM() {
        return this.f525600m;
    }

    public int getN() {
        return this.f525601n;
    }

    public int getT() {
        return this.f525602t;
    }
}
