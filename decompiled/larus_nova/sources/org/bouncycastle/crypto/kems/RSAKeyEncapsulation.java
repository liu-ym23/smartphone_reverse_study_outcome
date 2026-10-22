package org.bouncycastle.crypto.kems;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.crypto.KeyEncapsulation;
import org.bouncycastle.crypto.params.KDFParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes42.dex */
public class RSAKeyEncapsulation implements KeyEncapsulation {
    private static final BigInteger ONE = null;
    private static final BigInteger ZERO = null;
    private DerivationFunction kdf;
    private RSAKeyParameters key;
    private SecureRandom rnd;

    static {
        ZERO = BigInteger.valueOf(0);
        ONE = BigInteger.valueOf(1);
    }

    public RSAKeyEncapsulation(DerivationFunction r100, SecureRandom r101) {
        this.kdf = r100;
        this.rnd = r101;
    }

    public CipherParameters decrypt(byte[] r100, int r101) {
        return decrypt(r100, 0, r100.length, r101);
    }

    @Override // org.bouncycastle.crypto.KeyEncapsulation
    public CipherParameters decrypt(byte[] r100, int r101, int r102, int r103) throws IllegalArgumentException {
        if (this.key.isPrivate() == false) goto L7;
        BigInteger r104 = this.key.getModulus();
        BigInteger r105 = this.key.getExponent();
        byte[] r106 = new byte[r102];
        System.arraycopy(r100, r101, r106, 0, r102);
        return generateKey(r104, new BigInteger(1, r106).modPow(r105, r104), r103);
    L7:
        throw new IllegalArgumentException("Private key required for decryption");
    }

    public CipherParameters encrypt(byte[] r100, int r101) {
        return encrypt(r100, 0, r101);
    }

    @Override // org.bouncycastle.crypto.KeyEncapsulation
    public CipherParameters encrypt(byte[] r100, int r101, int r102) throws IllegalArgumentException {
        if (this.key.isPrivate() == true) goto L7;
        BigInteger r103 = this.key.getModulus();
        BigInteger r104 = this.key.getExponent();
        BigInteger r105 = BigIntegers.createRandomInRange(ZERO, r103.subtract(ONE), this.rnd);
        BigInteger r106 = r105.modPow(r104, r103);
        byte[] r107 = BigIntegers.asUnsignedByteArray((r103.bitLength() + 7) / 8, r106);
        System.arraycopy(r107, 0, r100, r101, r107.length);
        return generateKey(r103, r105, r102);
    L7:
        throw new IllegalArgumentException("Public key required for encryption");
    }

    public KeyParameter generateKey(BigInteger r100, BigInteger r101, int r102) {
        byte[] r103 = BigIntegers.asUnsignedByteArray((r100.bitLength() + 7) / 8, r101);
        this.kdf.init(new KDFParameters(r103, null));
        byte[] r104 = new byte[r102];
        this.kdf.generateBytes(r104, 0, r102);
        return new KeyParameter(r104);
    }

    @Override // org.bouncycastle.crypto.KeyEncapsulation
    public void init(CipherParameters r100) throws IllegalArgumentException {
        if ((r100 instanceof RSAKeyParameters) == false) goto L7;
        this.key = (RSAKeyParameters) r100;
        return;
    L7:
        throw new IllegalArgumentException("RSA key required");
    }
}
