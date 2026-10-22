package org.bouncycastle.math.ec.endo;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes42.dex */
public class ScalarSplitParameters {
    protected final int bits;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    protected final BigInteger f525480g1;

    /* JADX INFO: renamed from: g2, reason: collision with root package name */
    protected final BigInteger f525481g2;
    protected final BigInteger v1A;
    protected final BigInteger v1B;
    protected final BigInteger v2A;
    protected final BigInteger v2B;

    public ScalarSplitParameters(BigInteger[] r100, BigInteger[] r101, BigInteger r102, BigInteger r103, int r104) {
        checkVector(r100, "v1");
        checkVector(r101, "v2");
        this.v1A = r100[0];
        this.v1B = r100[1];
        this.v2A = r101[0];
        this.v2B = r101[1];
        this.f525480g1 = r102;
        this.f525481g2 = r103;
        this.bits = r104;
    }

    private static void checkVector(BigInteger[] r100, String r101) {
        if (r100 == null) goto L11;
        if (r100.length != 2) goto L11;
        if (r100[0] == null) goto L11;
        if (r100[1] == null) goto L11;
        return;
    L11:
        throw new IllegalArgumentException("'" + r101 + "' must consist of exactly 2 (non-null) values");
    }

    public int getBits() {
        return this.bits;
    }

    public BigInteger getG1() {
        return this.f525480g1;
    }

    public BigInteger getG2() {
        return this.f525481g2;
    }

    public BigInteger getV1A() {
        return this.v1A;
    }

    public BigInteger getV1B() {
        return this.v1B;
    }

    public BigInteger getV2A() {
        return this.v2A;
    }

    public BigInteger getV2B() {
        return this.v2B;
    }
}
