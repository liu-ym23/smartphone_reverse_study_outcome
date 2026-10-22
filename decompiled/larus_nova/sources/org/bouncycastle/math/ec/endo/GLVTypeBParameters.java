package org.bouncycastle.math.ec.endo;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes42.dex */
public class GLVTypeBParameters {
    protected final BigInteger beta;
    protected final BigInteger lambda;
    protected final ScalarSplitParameters splitParams;

    public GLVTypeBParameters(BigInteger r100, BigInteger r101, ScalarSplitParameters r102) {
        this.beta = r100;
        this.lambda = r101;
        this.splitParams = r102;
    }

    public GLVTypeBParameters(BigInteger r100, BigInteger r101, BigInteger[] r102, BigInteger[] r110, BigInteger r111, BigInteger r112, int r113) {
        this.beta = r100;
        this.lambda = r101;
        this.splitParams = new ScalarSplitParameters(r102, r110, r111, r112, r113);
    }

    public BigInteger getBeta() {
        return this.beta;
    }

    public int getBits() {
        return getSplitParams().getBits();
    }

    public BigInteger getG1() {
        return getSplitParams().getG1();
    }

    public BigInteger getG2() {
        return getSplitParams().getG2();
    }

    public BigInteger getLambda() {
        return this.lambda;
    }

    public ScalarSplitParameters getSplitParams() {
        return this.splitParams;
    }

    public BigInteger getV1A() {
        return getSplitParams().getV1A();
    }

    public BigInteger getV1B() {
        return getSplitParams().getV1B();
    }

    public BigInteger getV2A() {
        return getSplitParams().getV2A();
    }

    public BigInteger getV2B() {
        return getSplitParams().getV2B();
    }
}
