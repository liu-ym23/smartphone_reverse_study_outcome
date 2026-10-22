package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import java.util.Vector;

/* JADX INFO: loaded from: classes42.dex */
public class NaccacheSternPrivateKeyParameters extends NaccacheSternKeyParameters {
    private BigInteger phi_n;
    private Vector smallPrimes;

    public NaccacheSternPrivateKeyParameters(BigInteger r100, BigInteger r101, int r102, Vector r103, BigInteger r104) {
        super(true, r100, r101, r102);
        this.smallPrimes = r103;
        this.phi_n = r104;
    }

    public BigInteger getPhi_n() {
        return this.phi_n;
    }

    public Vector getSmallPrimes() {
        return this.smallPrimes;
    }
}
