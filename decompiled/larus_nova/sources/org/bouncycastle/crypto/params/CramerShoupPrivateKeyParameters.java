package org.bouncycastle.crypto.params;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes42.dex */
public class CramerShoupPrivateKeyParameters extends CramerShoupKeyParameters {

    /* JADX INFO: renamed from: pk, reason: collision with root package name */
    private CramerShoupPublicKeyParameters f525281pk;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    private BigInteger f525282x1;

    /* JADX INFO: renamed from: x2, reason: collision with root package name */
    private BigInteger f525283x2;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    private BigInteger f525284y1;

    /* JADX INFO: renamed from: y2, reason: collision with root package name */
    private BigInteger f525285y2;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private BigInteger f525286z;

    public CramerShoupPrivateKeyParameters(CramerShoupParameters r100, BigInteger r101, BigInteger r102, BigInteger r103, BigInteger r104, BigInteger r105) {
        super(true, r100);
        this.f525282x1 = r101;
        this.f525283x2 = r102;
        this.f525284y1 = r103;
        this.f525285y2 = r104;
        this.f525286z = r105;
    }

    @Override // org.bouncycastle.crypto.params.CramerShoupKeyParameters
    public boolean equals(Object r100) {
        if ((r100 instanceof CramerShoupPrivateKeyParameters) == true) goto L5;
        return false;
    L5:
        CramerShoupPrivateKeyParameters r101 = (CramerShoupPrivateKeyParameters) r100;
        if (r101.getX1().equals(this.f525282x1) == true) goto L8;
        return false;
    L8:
        if (r101.getX2().equals(this.f525283x2) == true) goto L10;
        return false;
    L10:
        if (r101.getY1().equals(this.f525284y1) == true) goto L12;
        return false;
    L12:
        if (r101.getY2().equals(this.f525285y2) == true) goto L14;
        return false;
    L14:
        if (r101.getZ().equals(this.f525286z) == true) goto L16;
        return false;
    L16:
        if (super.equals(r100) == false) goto L24;
        return true;
    L24:
        return false;
    }

    public CramerShoupPublicKeyParameters getPk() {
        return this.f525281pk;
    }

    public BigInteger getX1() {
        return this.f525282x1;
    }

    public BigInteger getX2() {
        return this.f525283x2;
    }

    public BigInteger getY1() {
        return this.f525284y1;
    }

    public BigInteger getY2() {
        return this.f525285y2;
    }

    public BigInteger getZ() {
        return this.f525286z;
    }

    @Override // org.bouncycastle.crypto.params.CramerShoupKeyParameters
    public int hashCode() {
        return ((((this.f525282x1.hashCode() ^ this.f525283x2.hashCode()) ^ this.f525284y1.hashCode()) ^ this.f525285y2.hashCode()) ^ this.f525286z.hashCode()) ^ super.hashCode();
    }

    public void setPk(CramerShoupPublicKeyParameters r100) {
        this.f525281pk = r100;
    }
}
