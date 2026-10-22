package org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.params.CramerShoupParameters;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes42.dex */
public class CramerShoupParametersGenerator {
    private static final BigInteger ONE = null;
    private int certainty;
    private SecureRandom random;
    private int size;

    public static class ParametersHelper {
        private static final BigInteger TWO = null;

        static {
            TWO = BigInteger.valueOf(2);
        }

        private ParametersHelper() {
        }

        public static BigInteger[] generateSafePrimes(int r100, int r101, SecureRandom r102) {
            int r103 = r100 - 1;
        L3:
            BigInteger r104 = BigIntegers.createRandomPrime(r103, 2, r102);
            BigInteger r105 = r104.shiftLeft(1).add(CramerShoupParametersGenerator.access$000());
            if (r105.isProbablePrime(r101) == false) goto L3;
            if (r101 <= 2) goto L9;
            if (r104.isProbablePrime(r101) == false) goto L3;
        L9:
            return new BigInteger[]{r105, r104};
        }

        public static BigInteger selectGenerator(BigInteger r100, SecureRandom r101) {
            BigInteger r102 = r100.subtract(TWO);
        L3:
            BigInteger r103 = TWO;
            BigInteger r104 = BigIntegers.createRandomInRange(r103, r102, r101).modPow(r103, r100);
            if (r104.equals(CramerShoupParametersGenerator.access$000()) == true) goto L3;
            return r104;
        }
    }

    static {
        ONE = BigInteger.valueOf(1);
    }

    public CramerShoupParametersGenerator() {
    }

    public static /* synthetic */ BigInteger access$000() {
        return ONE;
    }

    public CramerShoupParameters generateParameters() {
        BigInteger r100 = ParametersHelper.generateSafePrimes(this.size, this.certainty, this.random)[1];
        BigInteger r101 = ParametersHelper.selectGenerator(r100, this.random);
    L3:
        BigInteger r102 = ParametersHelper.selectGenerator(r100, this.random);
        if (r101.equals(r102) == true) goto L3;
        return new CramerShoupParameters(r100, r101, r102, new SHA256Digest());
    }

    public CramerShoupParameters generateParameters(DHParameters r100) {
        BigInteger r101 = r100.getP();
        BigInteger r102 = r100.getG();
    L3:
        BigInteger r103 = ParametersHelper.selectGenerator(r101, this.random);
        if (r102.equals(r103) == true) goto L3;
        return new CramerShoupParameters(r101, r102, r103, new SHA256Digest());
    }

    public void init(int r100, int r101, SecureRandom r102) {
        this.size = r100;
        this.certainty = r101;
        this.random = r102;
    }
}
