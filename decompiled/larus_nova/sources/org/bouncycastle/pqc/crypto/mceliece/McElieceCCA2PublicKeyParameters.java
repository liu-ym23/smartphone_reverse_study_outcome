package org.bouncycastle.pqc.crypto.mceliece;

import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;

/* JADX INFO: loaded from: classes42.dex */
public class McElieceCCA2PublicKeyParameters extends McElieceCCA2KeyParameters {
    private GF2Matrix matrixG;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f525547n;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f525548t;

    public McElieceCCA2PublicKeyParameters(int r100, int r101, GF2Matrix r102, String r103) {
        super(false, r103);
        this.f525547n = r100;
        this.f525548t = r101;
        this.matrixG = new GF2Matrix(r102);
    }

    public GF2Matrix getG() {
        return this.matrixG;
    }

    public int getK() {
        return this.matrixG.getNumRows();
    }

    public int getN() {
        return this.f525547n;
    }

    public int getT() {
        return this.f525548t;
    }
}
