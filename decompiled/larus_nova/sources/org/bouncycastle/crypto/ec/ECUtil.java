package org.bouncycastle.crypto.ec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes42.dex */
class ECUtil {
    public ECUtil() {
    }

    public static BigInteger generateK(BigInteger r100, SecureRandom r101) {
        int r102 = r100.bitLength();
    L3:
        BigInteger r103 = BigIntegers.createRandomBigInteger(r102, r101);
        if (r103.equals(ECConstants.ZERO) == true) goto L3;
        if (r103.compareTo(r100) >= 0) goto L3;
        return r103;
    }
}
