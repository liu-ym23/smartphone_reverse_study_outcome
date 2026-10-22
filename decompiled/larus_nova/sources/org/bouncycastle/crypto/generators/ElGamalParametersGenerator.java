package org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.params.ElGamalParameters;

/* JADX INFO: loaded from: classes42.dex */
public class ElGamalParametersGenerator {
    private int certainty;
    private SecureRandom random;
    private int size;

    public ElGamalParametersGenerator() {
    }

    public ElGamalParameters generateParameters() {
        BigInteger[] r100 = DHParametersHelper.generateSafePrimes(this.size, this.certainty, this.random);
        BigInteger r101 = r100[0];
        return new ElGamalParameters(r101, DHParametersHelper.selectGenerator(r101, r100[1], this.random));
    }

    public void init(int r100, int r101, SecureRandom r102) {
        this.size = r100;
        this.certainty = r101;
        this.random = r102;
    }
}
