package org.bouncycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;

/* JADX INFO: loaded from: classes42.dex */
public class ECParameterSpec implements AlgorithmParameterSpec {
    private ECPoint G;
    private ECCurve curve;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private BigInteger f525404h;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private BigInteger f525405n;
    private byte[] seed;

    public ECParameterSpec(ECCurve r100, ECPoint r101, BigInteger r102) {
        this.curve = r100;
        this.G = r101.normalize();
        this.f525405n = r102;
        this.f525404h = BigInteger.valueOf(1);
        this.seed = null;
    }

    public ECParameterSpec(ECCurve r100, ECPoint r101, BigInteger r102, BigInteger r103) {
        this.curve = r100;
        this.G = r101.normalize();
        this.f525405n = r102;
        this.f525404h = r103;
        this.seed = null;
    }

    public ECParameterSpec(ECCurve r100, ECPoint r101, BigInteger r102, BigInteger r103, byte[] r104) {
        this.curve = r100;
        this.G = r101.normalize();
        this.f525405n = r102;
        this.f525404h = r103;
        this.seed = r104;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof ECParameterSpec) == true) goto L5;
        return false;
    L5:
        ECParameterSpec r101 = (ECParameterSpec) r100;
        if (getCurve().equals(r101.getCurve()) == true) goto L8;
        return false;
    L8:
        if (getG().equals(r101.getG()) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public ECCurve getCurve() {
        return this.curve;
    }

    public ECPoint getG() {
        return this.G;
    }

    public BigInteger getH() {
        return this.f525404h;
    }

    public BigInteger getN() {
        return this.f525405n;
    }

    public byte[] getSeed() {
        return this.seed;
    }

    public int hashCode() {
        return getCurve().hashCode() ^ getG().hashCode();
    }
}
