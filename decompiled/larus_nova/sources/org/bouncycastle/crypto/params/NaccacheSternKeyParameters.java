package org.bouncycastle.crypto.params;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes42.dex */
public class NaccacheSternKeyParameters extends AsymmetricKeyParameter {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private BigInteger f525329g;
    int lowerSigmaBound;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private BigInteger f525330n;

    public NaccacheSternKeyParameters(boolean r100, BigInteger r101, BigInteger r102, int r103) {
        super(r100);
        this.f525329g = r101;
        this.f525330n = r102;
        this.lowerSigmaBound = r103;
    }

    public BigInteger getG() {
        return this.f525329g;
    }

    public int getLowerSigmaBound() {
        return this.lowerSigmaBound;
    }

    public BigInteger getModulus() {
        return this.f525330n;
    }
}
