package org.bouncycastle.jce.spec;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes42.dex */
public class GOST3410PublicKeyParameterSetSpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BigInteger f525416a;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private BigInteger f525417p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private BigInteger f525418q;

    public GOST3410PublicKeyParameterSetSpec(BigInteger r100, BigInteger r101, BigInteger r102) {
        this.f525417p = r100;
        this.f525418q = r101;
        this.f525416a = r102;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof GOST3410PublicKeyParameterSetSpec) == false) goto L12;
        GOST3410PublicKeyParameterSetSpec r101 = (GOST3410PublicKeyParameterSetSpec) r100;
        if (this.f525416a.equals(r101.f525416a) == true) goto L7;
        return false;
    L7:
        if (this.f525417p.equals(r101.f525417p) == true) goto L9;
        return false;
    L9:
        if (this.f525418q.equals(r101.f525418q) == false) goto L15;
        return true;
    L15:
        return false;
    L12:
        return false;
    }

    public BigInteger getA() {
        return this.f525416a;
    }

    public BigInteger getP() {
        return this.f525417p;
    }

    public BigInteger getQ() {
        return this.f525418q;
    }

    public int hashCode() {
        return (this.f525416a.hashCode() ^ this.f525417p.hashCode()) ^ this.f525418q.hashCode();
    }
}
