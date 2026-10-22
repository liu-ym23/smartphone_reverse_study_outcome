package org.bouncycastle.crypto.engines;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.params.ElGamalKeyParameters;
import org.bouncycastle.crypto.params.ElGamalPrivateKeyParameters;
import org.bouncycastle.crypto.params.ElGamalPublicKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes42.dex */
public class ElGamalEngine implements AsymmetricBlockCipher {
    private static final BigInteger ONE = null;
    private static final BigInteger TWO = null;
    private static final BigInteger ZERO = null;
    private int bitSize;
    private boolean forEncryption;
    private ElGamalKeyParameters key;
    private SecureRandom random;

    static {
        ZERO = BigInteger.valueOf(0);
        ONE = BigInteger.valueOf(1);
        TWO = BigInteger.valueOf(2);
    }

    public ElGamalEngine() {
    }

    @Override // org.bouncycastle.crypto.AsymmetricBlockCipher
    public int getInputBlockSize() {
        if (this.forEncryption == false) goto L7;
        return (this.bitSize - 1) / 8;
    L7:
        return ((this.bitSize + 7) / 8) * 2;
    }

    @Override // org.bouncycastle.crypto.AsymmetricBlockCipher
    public int getOutputBlockSize() {
        if (this.forEncryption == false) goto L7;
        return ((this.bitSize + 7) / 8) * 2;
    L7:
        return (this.bitSize - 1) / 8;
    }

    @Override // org.bouncycastle.crypto.AsymmetricBlockCipher
    public void init(boolean r100, CipherParameters r101) {
        if ((r101 instanceof ParametersWithRandom) == false) goto L5;
        ParametersWithRandom r102 = (ParametersWithRandom) r101;
        this.key = (ElGamalKeyParameters) r102.getParameters();
        SecureRandom r103 = r102.getRandom();
    L6:
        this.random = r103;
        this.forEncryption = r100;
        this.bitSize = this.key.getParameters().getP().bitLength();
        if (r100 == false) goto L14;
        if ((this.key instanceof ElGamalPublicKeyParameters) == false) goto L12;
        return;
    L12:
        throw new IllegalArgumentException("ElGamalPublicKeyParameters are required for encryption.");
    L14:
        if ((this.key instanceof ElGamalPrivateKeyParameters) == false) goto L17;
        return;
    L17:
        throw new IllegalArgumentException("ElGamalPrivateKeyParameters are required for decryption.");
    L5:
        this.key = (ElGamalKeyParameters) r101;
        r103 = CryptoServicesRegistrar.getSecureRandom();
        goto L6
    }

    @Override // org.bouncycastle.crypto.AsymmetricBlockCipher
    public byte[] processBlock(byte[] r100, int r101, int r102) {
        if (this.key == null) goto L40;
        if (this.forEncryption == false) goto L7;
        int r103 = ((this.bitSize - 1) + 7) / 8;
    L9:
        if (r102 > r103) goto L38;
        BigInteger r104 = this.key.getParameters().getP();
        if ((this.key instanceof ElGamalPrivateKeyParameters) == false) goto L14;
        int r105 = r102 / 2;
        byte[] r106 = new byte[r105];
        byte[] r107 = new byte[r105];
        System.arraycopy(r100, r101, r106, 0, r105);
        System.arraycopy(r100, r101 + r105, r107, 0, r105);
        BigInteger r108 = new BigInteger(1, r106);
        BigInteger r109 = new BigInteger(1, r107);
        ElGamalPrivateKeyParameters r110 = (ElGamalPrivateKeyParameters) this.key;
        return BigIntegers.asUnsignedByteArray(r108.modPow(r104.subtract(ONE).subtract(r110.getX()), r104).multiply(r109).mod(r104));
    L14:
        if (r101 == 0) goto L16;
    L17:
        byte[] r111 = new byte[r102];
        System.arraycopy(r100, r101, r111, 0, r102);
        r100 = r111;
    L18:
        BigInteger r112 = new BigInteger(1, r100);
        if (r112.compareTo(r104) >= 0) goto L36;
        ElGamalPublicKeyParameters r113 = (ElGamalPublicKeyParameters) this.key;
        int r114 = r104.bitLength();
    L21:
        BigInteger r115 = BigIntegers.createRandomBigInteger(r114, this.random);
        if (r115.equals(ZERO) == true) goto L21;
        if (r115.compareTo(r104.subtract(TWO)) > 0) goto L21;
        BigInteger r116 = this.key.getParameters().getG().modPow(r115, r104);
        BigInteger r117 = r112.multiply(r113.getY().modPow(r115, r104)).mod(r104);
        byte[] r118 = r116.toByteArray();
        byte[] r119 = r117.toByteArray();
        int r120 = getOutputBlockSize();
        byte[] r121 = new byte[r120];
        int r122 = r120 / 2;
        if (r118.length <= r122) goto L29;
        System.arraycopy(r118, 1, r121, r122 - (r118.length - 1), r118.length - 1);
    L31:
        if (r119.length <= r122) goto L33;
        System.arraycopy(r119, 1, r121, r120 - (r119.length - 1), r119.length - 1);
    L34:
        return r121;
    L33:
        System.arraycopy(r119, 0, r121, r120 - r119.length, r119.length);
        goto L34
    L29:
        System.arraycopy(r118, 0, r121, r122 - r118.length, r118.length);
        goto L31
    L36:
        throw new DataLengthException("input too large for ElGamal cipher.\n");
    L16:
        if (r102 == r100.length) goto L18;
    L38:
        throw new DataLengthException("input too large for ElGamal cipher.\n");
    L7:
        r103 = getInputBlockSize();
        goto L9
    L40:
        throw new IllegalStateException("ElGamal engine not initialised");
    }
}
