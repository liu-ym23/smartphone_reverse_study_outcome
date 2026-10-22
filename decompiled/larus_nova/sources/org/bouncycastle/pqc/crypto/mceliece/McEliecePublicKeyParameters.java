package org.bouncycastle.pqc.crypto.mceliece;

import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;

/* JADX INFO: loaded from: classes42.dex */
public class McEliecePublicKeyParameters extends McElieceKeyParameters {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private GF2Matrix f525576g;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f525577n;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f525578t;

    public McEliecePublicKeyParameters(int r100, int r101, GF2Matrix r102) {
        super(false, null);
        this.f525577n = r100;
        this.f525578t = r101;
        this.f525576g = new GF2Matrix(r102);
    }

    public GF2Matrix getG() {
        return this.f525576g;
    }

    public int getK() {
        return this.f525576g.getNumRows();
    }

    public int getN() {
        return this.f525577n;
    }

    public int getT() {
        return this.f525578t;
    }
}
