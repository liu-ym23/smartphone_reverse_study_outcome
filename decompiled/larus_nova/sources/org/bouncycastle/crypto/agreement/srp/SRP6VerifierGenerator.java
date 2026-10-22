package org.bouncycastle.crypto.agreement.srp;

import java.math.BigInteger;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.params.SRP6GroupParameters;

/* JADX INFO: loaded from: classes42.dex */
public class SRP6VerifierGenerator {
    protected BigInteger N;
    protected Digest digest;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected BigInteger f525132g;

    public SRP6VerifierGenerator() {
    }

    public BigInteger generateVerifier(byte[] r100, byte[] r101, byte[] r102) {
        BigInteger r103 = SRP6Util.calculateX(this.digest, this.N, r100, r101, r102);
        return this.f525132g.modPow(r103, this.N);
    }

    public void init(BigInteger r100, BigInteger r101, Digest r102) {
        this.N = r100;
        this.f525132g = r101;
        this.digest = r102;
    }

    public void init(SRP6GroupParameters r100, Digest r101) {
        this.N = r100.getN();
        this.f525132g = r100.getG();
        this.digest = r101;
    }
}
