package org.bouncycastle.crypto.engines;

import java.math.BigInteger;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.params.RSABlindingParameters;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes42.dex */
public class RSABlindingEngine implements AsymmetricBlockCipher {
    private BigInteger blindingFactor;
    private RSACoreEngine core;
    private boolean forEncryption;
    private RSAKeyParameters key;

    public RSABlindingEngine() {
        this.core = new RSACoreEngine();
    }

    private BigInteger blindMessage(BigInteger r100) {
        return r100.multiply(this.blindingFactor.modPow(this.key.getExponent(), this.key.getModulus())).mod(this.key.getModulus());
    }

    private BigInteger unblindMessage(BigInteger r100) {
        BigInteger r101 = this.key.getModulus();
        return r100.multiply(BigIntegers.modOddInverse(r101, this.blindingFactor)).mod(r101);
    }

    @Override // org.bouncycastle.crypto.AsymmetricBlockCipher
    public int getInputBlockSize() {
        return this.core.getInputBlockSize();
    }

    @Override // org.bouncycastle.crypto.AsymmetricBlockCipher
    public int getOutputBlockSize() {
        return this.core.getOutputBlockSize();
    }

    @Override // org.bouncycastle.crypto.AsymmetricBlockCipher
    public void init(boolean r100, CipherParameters r101) {
        if ((r101 instanceof ParametersWithRandom) == false) goto L5;
        r101 = ((ParametersWithRandom) r101).getParameters();
    L5:
        RSABlindingParameters r102 = (RSABlindingParameters) r101;
        this.core.init(r100, r102.getPublicKey());
        this.forEncryption = r100;
        this.key = r102.getPublicKey();
        this.blindingFactor = r102.getBlindingFactor();
    }

    @Override // org.bouncycastle.crypto.AsymmetricBlockCipher
    public byte[] processBlock(byte[] r100, int r101, int r102) {
        BigInteger r103 = this.core.convertInput(r100, r101, r102);
        if (this.forEncryption == false) goto L5;
        BigInteger r104 = blindMessage(r103);
    L7:
        return this.core.convertOutput(r104);
    L5:
        r104 = unblindMessage(r103);
        goto L7
    }
}
