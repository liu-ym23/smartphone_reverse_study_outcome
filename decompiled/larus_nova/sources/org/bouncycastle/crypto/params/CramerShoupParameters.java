package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.util.Memoable;

/* JADX INFO: loaded from: classes42.dex */
public class CramerShoupParameters implements CipherParameters {
    private Digest H;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    private BigInteger f525278g1;

    /* JADX INFO: renamed from: g2, reason: collision with root package name */
    private BigInteger f525279g2;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private BigInteger f525280p;

    public CramerShoupParameters(BigInteger r100, BigInteger r101, BigInteger r102, Digest r103) {
        this.f525280p = r100;
        this.f525278g1 = r101;
        this.f525279g2 = r102;
        Digest r104 = (Digest) ((Memoable) r103).copy();
        this.H = r104;
        r104.reset();
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof CramerShoupParameters) == true) goto L5;
        return false;
    L5:
        CramerShoupParameters r101 = (CramerShoupParameters) r100;
        if (r101.getP().equals(this.f525280p) == true) goto L8;
        return false;
    L8:
        if (r101.getG1().equals(this.f525278g1) == true) goto L10;
        return false;
    L10:
        if (r101.getG2().equals(this.f525279g2) == false) goto L15;
        return true;
    L15:
        return false;
    }

    public BigInteger getG1() {
        return this.f525278g1;
    }

    public BigInteger getG2() {
        return this.f525279g2;
    }

    public Digest getH() {
        return (Digest) ((Memoable) this.H).copy();
    }

    public BigInteger getP() {
        return this.f525280p;
    }

    public int hashCode() {
        return (getP().hashCode() ^ getG1().hashCode()) ^ getG2().hashCode();
    }
}
