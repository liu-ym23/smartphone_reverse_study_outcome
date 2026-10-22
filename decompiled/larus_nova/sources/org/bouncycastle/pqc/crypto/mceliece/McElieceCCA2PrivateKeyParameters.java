package org.bouncycastle.pqc.crypto.mceliece;

import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;
import org.bouncycastle.pqc.math.linearalgebra.GF2mField;
import org.bouncycastle.pqc.math.linearalgebra.GoppaCode;
import org.bouncycastle.pqc.math.linearalgebra.Permutation;
import org.bouncycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;
import org.bouncycastle.pqc.math.linearalgebra.PolynomialRingGF2m;

/* JADX INFO: loaded from: classes42.dex */
public class McElieceCCA2PrivateKeyParameters extends McElieceCCA2KeyParameters {
    private GF2mField field;
    private PolynomialGF2mSmallM goppaPoly;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private GF2Matrix f525543h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f525544k;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f525545n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Permutation f525546p;
    private PolynomialGF2mSmallM[] qInv;

    public McElieceCCA2PrivateKeyParameters(int r100, int r101, GF2mField r102, PolynomialGF2mSmallM r103, GF2Matrix r104, Permutation r105, String r106) {
        super(true, r106);
        this.f525545n = r100;
        this.f525544k = r101;
        this.field = r102;
        this.goppaPoly = r103;
        this.f525543h = r104;
        this.f525546p = r105;
        this.qInv = new PolynomialRingGF2m(r102, r103).getSquareRootMatrix();
    }

    public McElieceCCA2PrivateKeyParameters(int r100, int r110, GF2mField r111, PolynomialGF2mSmallM r112, Permutation r113, String r114) {
        this(r100, r110, r111, r112, GoppaCode.createCanonicalCheckMatrix(r111, r112), r113, r114);
    }

    public GF2mField getField() {
        return this.field;
    }

    public PolynomialGF2mSmallM getGoppaPoly() {
        return this.goppaPoly;
    }

    public GF2Matrix getH() {
        return this.f525543h;
    }

    public int getK() {
        return this.f525544k;
    }

    public int getN() {
        return this.f525545n;
    }

    public Permutation getP() {
        return this.f525546p;
    }

    public PolynomialGF2mSmallM[] getQInv() {
        return this.qInv;
    }

    public int getT() {
        return this.goppaPoly.getDegree();
    }
}
