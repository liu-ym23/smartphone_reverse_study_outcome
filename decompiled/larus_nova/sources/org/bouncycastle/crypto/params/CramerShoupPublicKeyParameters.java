package org.bouncycastle.crypto.params;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes42.dex */
public class CramerShoupPublicKeyParameters extends CramerShoupKeyParameters {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private BigInteger f525287c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private BigInteger f525288d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private BigInteger f525289h;

    public CramerShoupPublicKeyParameters(CramerShoupParameters r100, BigInteger r101, BigInteger r102, BigInteger r103) {
        super(false, r100);
        this.f525287c = r101;
        this.f525288d = r102;
        this.f525289h = r103;
    }

    @Override // org.bouncycastle.crypto.params.CramerShoupKeyParameters
    public boolean equals(Object r100) {
        if ((r100 instanceof CramerShoupPublicKeyParameters) == true) goto L5;
        return false;
    L5:
        CramerShoupPublicKeyParameters r101 = (CramerShoupPublicKeyParameters) r100;
        if (r101.getC().equals(this.f525287c) == true) goto L8;
        return false;
    L8:
        if (r101.getD().equals(this.f525288d) == true) goto L10;
        return false;
    L10:
        if (r101.getH().equals(this.f525289h) == true) goto L12;
        return false;
    L12:
        if (super.equals(r100) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public BigInteger getC() {
        return this.f525287c;
    }

    public BigInteger getD() {
        return this.f525288d;
    }

    public BigInteger getH() {
        return this.f525289h;
    }

    @Override // org.bouncycastle.crypto.params.CramerShoupKeyParameters
    public int hashCode() {
        return ((this.f525287c.hashCode() ^ this.f525288d.hashCode()) ^ this.f525289h.hashCode()) ^ super.hashCode();
    }
}
