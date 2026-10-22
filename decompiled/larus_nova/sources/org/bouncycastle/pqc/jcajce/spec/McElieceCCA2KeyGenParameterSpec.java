package org.bouncycastle.pqc.jcajce.spec;

import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.pqc.math.linearalgebra.PolynomialRingGF2;

/* JADX INFO: loaded from: classes42.dex */
public class McElieceCCA2KeyGenParameterSpec implements AlgorithmParameterSpec {
    public static final int DEFAULT_M = 11;
    public static final int DEFAULT_T = 50;
    public static final String SHA1 = "SHA-1";
    public static final String SHA224 = "SHA-224";
    public static final String SHA256 = "SHA-256";
    public static final String SHA384 = "SHA-384";
    public static final String SHA512 = "SHA-512";
    private final String digest;
    private int fieldPoly;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f525597m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f525598n;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final int f525599t;

    public McElieceCCA2KeyGenParameterSpec() {
        this(11, 50, "SHA-256");
    }

    public McElieceCCA2KeyGenParameterSpec(int r100) {
        this(r100, "SHA-256");
    }

    public McElieceCCA2KeyGenParameterSpec(int r100, int r101) {
        this(r100, r101, "SHA-256");
    }

    public McElieceCCA2KeyGenParameterSpec(int r100, int r101, int r102) {
        this(r100, r101, r102, "SHA-256");
    }

    public McElieceCCA2KeyGenParameterSpec(int r100, int r101, int r102, String r103) {
        this.f525597m = r100;
        if (r100 < 1) goto L24;
        if (r100 > 32) goto L22;
        int r104 = 1 << r100;
        this.f525598n = r104;
        this.f525599t = r101;
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

    public McElieceCCA2KeyGenParameterSpec(int r100, int r101, String r102) {
        if (r100 < 1) goto L18;
        if (r100 > 32) goto L16;
        this.f525597m = r100;
        int r103 = 1 << r100;
        this.f525598n = r103;
        if (r101 < 0) goto L14;
        if (r101 > r103) goto L12;
        this.f525599t = r101;
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

    public McElieceCCA2KeyGenParameterSpec(int r100, String r101) {
        int r102 = 1;
        if (r100 < 1) goto L10;
        int r103 = 0;
    L5:
        if (r102 >= r100) goto L7;
        r102 = r102 << 1;
        r103 = r103 + 1;
        goto L5
    L7:
        this.f525599t = (r102 >>> 1) / r103;
        this.f525597m = r103;
        this.f525598n = r102;
        this.fieldPoly = PolynomialRingGF2.getIrreduciblePolynomial(r103);
        this.digest = r101;
        return;
    L10:
        throw new IllegalArgumentException("key size must be positive");
    }

    public String getDigest() {
        return this.digest;
    }

    public int getFieldPoly() {
        return this.fieldPoly;
    }

    public int getM() {
        return this.f525597m;
    }

    public int getN() {
        return this.f525598n;
    }

    public int getT() {
        return this.f525599t;
    }
}
