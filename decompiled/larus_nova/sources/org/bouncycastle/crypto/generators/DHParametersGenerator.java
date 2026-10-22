package org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.params.DHParameters;

/* JADX INFO: loaded from: classes42.dex */
public class DHParametersGenerator {
    private static final BigInteger TWO = null;
    private int certainty;
    private SecureRandom random;
    private int size;

    static {
        TWO = BigInteger.valueOf(2);
    }

    public DHParametersGenerator() {
    }

    public DHParameters generateParameters() {
        BigInteger[] r100 = DHParametersHelper.generateSafePrimes(this.size, this.certainty, this.random);
        BigInteger r101 = r100[0];
        BigInteger r102 = r100[1];
        return new DHParameters(r101, DHParametersHelper.selectGenerator(r101, r102, this.random), r102, TWO, null);
    }

    public void init(int r100, int r101, SecureRandom r102) {
        this.size = r100;
        this.certainty = r101;
        this.random = r102;
    }
}
