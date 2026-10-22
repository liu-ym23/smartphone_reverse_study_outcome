package org.bouncycastle.pqc.crypto.mceliece;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.pqc.math.linearalgebra.PolynomialRingGF2;

/* JADX INFO: loaded from: classes42.dex */
public class McElieceParameters implements CipherParameters {
    public static final int DEFAULT_M = 11;
    public static final int DEFAULT_T = 50;
    private Digest digest;
    private int fieldPoly;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f525564m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f525565n;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f525566t;

    public McElieceParameters() {
        this(11, 50);
    }

    public McElieceParameters(int r100) {
        this(r100, null);
    }

    public McElieceParameters(int r100, int r101) {
        this(r100, r101, null);
    }

    public McElieceParameters(int r100, int r101, int r102) {
        this(r100, r101, r102, null);
    }

    public McElieceParameters(int r100, int r101, int r102, Digest r103) {
        this.f525564m = r100;
        if (r100 < 1) goto L24;
        if (r100 > 32) goto L22;
        int r104 = 1 << r100;
        this.f525565n = r104;
        this.f525566t = r101;
        if (r101 < 0) goto L20;
        if (r101 > r104) goto L18;
        if (PolynomialRingGF2.degree(r102) != r100) goto L16;
        if (PolynomialRingGF2.isIrreducible(r102) == false) goto L16;
        this.fieldPoly = r102;
        this.digest = r103;
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

    public McElieceParameters(int r100, int r101, Digest r102) {
        if (r100 < 1) goto L18;
        if (r100 > 32) goto L16;
        this.f525564m = r100;
        int r103 = 1 << r100;
        this.f525565n = r103;
        if (r101 < 0) goto L14;
        if (r101 > r103) goto L12;
        this.f525566t = r101;
        this.fieldPoly = PolynomialRingGF2.getIrreduciblePolynomial(r100);
        this.digest = r102;
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

    public McElieceParameters(int r100, Digest r101) {
        if (r100 < 1) goto L11;
        this.f525564m = 0;
        this.f525565n = 1;
    L5:
        int r102 = this.f525565n;
        if (r102 >= r100) goto L8;
        this.f525565n = r102 << 1;
        this.f525564m++;
        goto L5
    L8:
        int r103 = r102 >>> 1;
        this.f525566t = r103;
        int r104 = this.f525564m;
        this.f525566t = r103 / r104;
        this.fieldPoly = PolynomialRingGF2.getIrreduciblePolynomial(r104);
        this.digest = r101;
        return;
    L11:
        throw new IllegalArgumentException("key size must be positive");
    }

    public McElieceParameters(Digest r100) {
        this(11, 50, r100);
    }

    public int getFieldPoly() {
        return this.fieldPoly;
    }

    public int getM() {
        return this.f525564m;
    }

    public int getN() {
        return this.f525565n;
    }

    public int getT() {
        return this.f525566t;
    }
}
