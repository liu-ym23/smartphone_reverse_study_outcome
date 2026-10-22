package org.bouncycastle.math.ec.endo;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes42.dex */
public class GLVTypeAParameters {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected final BigInteger f525479i;
    protected final BigInteger lambda;
    protected final ScalarSplitParameters splitParams;

    public GLVTypeAParameters(BigInteger r100, BigInteger r101, ScalarSplitParameters r102) {
        this.f525479i = r100;
        this.lambda = r101;
        this.splitParams = r102;
    }

    public BigInteger getI() {
        return this.f525479i;
    }

    public BigInteger getLambda() {
        return this.lambda;
    }

    public ScalarSplitParameters getSplitParams() {
        return this.splitParams;
    }
}
