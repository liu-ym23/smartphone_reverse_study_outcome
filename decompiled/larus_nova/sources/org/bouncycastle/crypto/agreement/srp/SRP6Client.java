package org.bouncycastle.crypto.agreement.srp;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.params.SRP6GroupParameters;

/* JADX INFO: loaded from: classes42.dex */
public class SRP6Client {
    protected BigInteger A;
    protected BigInteger B;
    protected BigInteger Key;
    protected BigInteger M1;
    protected BigInteger M2;
    protected BigInteger N;
    protected BigInteger S;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected BigInteger f525124a;
    protected Digest digest;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected BigInteger f525125g;
    protected SecureRandom random;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected BigInteger f525126u;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    protected BigInteger f525127x;

    public SRP6Client() {
    }

    private BigInteger calculateS() {
        BigInteger r100 = SRP6Util.calculateK(this.digest, this.N, this.f525125g);
        BigInteger r101 = this.f525126u.multiply(this.f525127x).add(this.f525124a);
        BigInteger r102 = this.f525125g.modPow(this.f525127x, this.N).multiply(r100).mod(this.N);
        return this.B.subtract(r102).mod(this.N).modPow(r101, this.N);
    }

    public BigInteger calculateClientEvidenceMessage() throws CryptoException {
        BigInteger r100 = this.A;
        if (r100 == null) goto L11;
        BigInteger r101 = this.B;
        if (r101 == null) goto L11;
        BigInteger r102 = this.S;
        if (r102 == null) goto L11;
        BigInteger r103 = SRP6Util.calculateM1(this.digest, this.N, r100, r101, r102);
        this.M1 = r103;
        return r103;
    L11:
        throw new CryptoException("Impossible to compute M1: some data are missing from the previous operations (A,B,S)");
    }

    public BigInteger calculateSecret(BigInteger r100) throws CryptoException {
        BigInteger r101 = SRP6Util.validatePublicValue(this.N, r100);
        this.B = r101;
        this.f525126u = SRP6Util.calculateU(this.digest, this.N, this.A, r101);
        BigInteger r102 = calculateS();
        this.S = r102;
        return r102;
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

    public BigInteger generateClientCredentials(byte[] r100, byte[] r101, byte[] r102) {
        this.f525127x = SRP6Util.calculateX(this.digest, this.N, r100, r101, r102);
        BigInteger r103 = selectPrivateValue();
        this.f525124a = r103;
        BigInteger r104 = this.f525125g.modPow(r103, this.N);
        this.A = r104;
        return r104;
    }

    public void init(BigInteger r100, BigInteger r101, Digest r102, SecureRandom r103) {
        this.N = r100;
        this.f525125g = r101;
        this.digest = r102;
        this.random = r103;
    }

    public void init(SRP6GroupParameters r100, Digest r101, SecureRandom r102) {
        init(r100.getN(), r100.getG(), r101, r102);
    }

    public BigInteger selectPrivateValue() {
        return SRP6Util.generatePrivateValue(this.digest, this.N, this.f525125g, this.random);
    }

    public boolean verifyServerEvidenceMessage(BigInteger r100) throws CryptoException {
        BigInteger r101 = this.A;
        if (r101 == null) goto L15;
        BigInteger r102 = this.M1;
        if (r102 == null) goto L15;
        BigInteger r103 = this.S;
        if (r103 == null) goto L15;
        if (SRP6Util.calculateM2(this.digest, this.N, r101, r102, r103).equals(r100) == false) goto L12;
        this.M2 = r100;
        return true;
    L12:
        return false;
    L15:
        throw new CryptoException("Impossible to compute and verify M2: some data are missing from the previous operations (A,M1,S)");
    }
}
