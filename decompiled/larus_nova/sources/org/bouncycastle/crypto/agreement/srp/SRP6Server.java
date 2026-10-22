package org.bouncycastle.crypto.agreement.srp;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.params.SRP6GroupParameters;

/* JADX INFO: loaded from: classes42.dex */
public class SRP6Server {
    protected BigInteger A;
    protected BigInteger B;
    protected BigInteger Key;
    protected BigInteger M1;
    protected BigInteger M2;
    protected BigInteger N;
    protected BigInteger S;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected BigInteger f525128b;
    protected Digest digest;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected BigInteger f525129g;
    protected SecureRandom random;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected BigInteger f525130u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    protected BigInteger f525131v;

    public SRP6Server() {
    }

    private BigInteger calculateS() {
        return this.f525131v.modPow(this.f525130u, this.N).multiply(this.A).mod(this.N).modPow(this.f525128b, this.N);
    }

    public BigInteger calculateSecret(BigInteger r100) throws CryptoException {
        BigInteger r101 = SRP6Util.validatePublicValue(this.N, r100);
        this.A = r101;
        this.f525130u = SRP6Util.calculateU(this.digest, this.N, r101, this.B);
        BigInteger r102 = calculateS();
        this.S = r102;
        return r102;
    }

    public BigInteger calculateServerEvidenceMessage() throws CryptoException {
        BigInteger r100 = this.A;
        if (r100 == null) goto L11;
        BigInteger r101 = this.M1;
        if (r101 == null) goto L11;
        BigInteger r102 = this.S;
        if (r102 == null) goto L11;
        BigInteger r103 = SRP6Util.calculateM2(this.digest, this.N, r100, r101, r102);
        this.M2 = r103;
        return r103;
    L11:
        throw new CryptoException("Impossible to compute M2: some data are missing from the previous operations (A,M1,S)");
    }

    public BigInteger calculateSessionKey() throws CryptoException {
        BigInteger r100 = this.S;
        if (r100 == null) goto L11;
        if (this.M1 == null) goto L11;
        if (this.M2 == null) goto L11;
        BigInteger r101 = SRP6Util.calculateKey(this.digest, this.N, r100);
        this.Key = r101;
        return r101;
    L11:
        throw new CryptoException("Impossible to compute Key: some data are missing from the previous operations (S,M1,M2)");
    }

    public BigInteger generateServerCredentials() {
        BigInteger r100 = SRP6Util.calculateK(this.digest, this.N, this.f525129g);
        this.f525128b = selectPrivateValue();
        BigInteger r101 = r100.multiply(this.f525131v).mod(this.N).add(this.f525129g.modPow(this.f525128b, this.N)).mod(this.N);
        this.B = r101;
        return r101;
    }

    public void init(BigInteger r100, BigInteger r101, BigInteger r102, Digest r103, SecureRandom r104) {
        this.N = r100;
        this.f525129g = r101;
        this.f525131v = r102;
        this.random = r104;
        this.digest = r103;
    }

    public void init(SRP6GroupParameters r100, BigInteger r101, Digest r102, SecureRandom r110) {
        init(r100.getN(), r100.getG(), r101, r102, r110);
    }

    public BigInteger selectPrivateValue() {
        return SRP6Util.generatePrivateValue(this.digest, this.N, this.f525129g, this.random);
    }

    public boolean verifyClientEvidenceMessage(BigInteger r100) throws CryptoException {
        BigInteger r101 = this.A;
        if (r101 == null) goto L15;
        BigInteger r102 = this.B;
        if (r102 == null) goto L15;
        BigInteger r103 = this.S;
        if (r103 == null) goto L15;
        if (SRP6Util.calculateM1(this.digest, this.N, r101, r102, r103).equals(r100) == false) goto L12;
        this.M1 = r100;
        return true;
    L12:
        return false;
    L15:
        throw new CryptoException("Impossible to compute and verify M1: some data are missing from the previous operations (A,B,S)");
    }
}
