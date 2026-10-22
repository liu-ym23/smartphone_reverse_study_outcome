package org.bouncycastle.pqc.crypto.mceliece;

import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;
import org.bouncycastle.pqc.math.linearalgebra.GF2mField;
import org.bouncycastle.pqc.math.linearalgebra.GoppaCode;
import org.bouncycastle.pqc.math.linearalgebra.Permutation;
import org.bouncycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;
import org.bouncycastle.pqc.math.linearalgebra.PolynomialRingGF2m;

/* JADX INFO: loaded from: classes42.dex */
public class McEliecePrivateKeyParameters extends McElieceKeyParameters {
    private GF2mField field;
    private PolynomialGF2mSmallM goppaPoly;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private GF2Matrix f525571h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f525572k;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f525573n;
    private String oid;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    private Permutation f525574p1;

    /* JADX INFO: renamed from: p2, reason: collision with root package name */
    private Permutation f525575p2;
    private PolynomialGF2mSmallM[] qInv;
    private GF2Matrix sInv;

    public McEliecePrivateKeyParameters(int r100, int r101, GF2mField r102, PolynomialGF2mSmallM r103, Permutation r104, Permutation r105, GF2Matrix r106) {
        super(true, null);
        this.f525572k = r101;
        this.f525573n = r100;
        this.field = r102;
        this.goppaPoly = r103;
        this.sInv = r106;
        this.f525574p1 = r104;
        this.f525575p2 = r105;
        this.f525571h = GoppaCode.createCanonicalCheckMatrix(r102, r103);
        this.qInv = new PolynomialRingGF2m(r102, r103).getSquareRootMatrix();
    }

    public McEliecePrivateKeyParameters(int r100, int r101, byte[] r102, byte[] r103, byte[] r104, byte[] r105, byte[] r106, byte[] r110, byte[][] r111) {
        super(true, null);
        this.f525573n = r100;
        this.f525572k = r101;
        GF2mField r107 = new GF2mField(r102);
        this.field = r107;
        this.goppaPoly = new PolynomialGF2mSmallM(r107, r103);
        this.sInv = new GF2Matrix(r104);
        this.f525574p1 = new Permutation(r105);
        this.f525575p2 = new Permutation(r106);
        this.f525571h = new GF2Matrix(r110);
        this.qInv = new PolynomialGF2mSmallM[r111.length];
        int r108 = 0;
    L4:
        if (r108 >= r111.length) goto L6;
        this.qInv[r108] = new PolynomialGF2mSmallM(this.field, r111[r108]);
        r108 = r108 + 1;
        goto L4
    }

    public GF2mField getField() {
        return this.field;
    }

    public PolynomialGF2mSmallM getGoppaPoly() {
        return this.goppaPoly;
    }

    public GF2Matrix getH() {
        return this.f525571h;
    }

    public int getK() {
        return this.f525572k;
    }

    public int getN() {
        return this.f525573n;
    }

    public Permutation getP1() {
        return this.f525574p1;
    }

    public Permutation getP2() {
        return this.f525575p2;
    }

    public PolynomialGF2mSmallM[] getQInv() {
        return this.qInv;
    }

    public GF2Matrix getSInv() {
        return this.sInv;
    }
}
