package org.bouncycastle.crypto.engines;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
class RSACoreEngine {
    private boolean forEncryption;
    private RSAKeyParameters key;

    public RSACoreEngine() {
    }

    public BigInteger convertInput(byte[] r100, int r101, int r102) {
        if (r102 > (getInputBlockSize() + 1)) goto L21;
        if (r102 == (getInputBlockSize() + 1)) goto L7;
    L11:
        if (r101 == 0) goto L13;
    L14:
        byte[] r103 = new byte[r102];
        System.arraycopy(r100, r101, r103, 0, r102);
        r100 = r103;
    L15:
        BigInteger r104 = new BigInteger(1, r100);
        if (r104.compareTo(this.key.getModulus()) >= 0) goto L19;
        return r104;
    L19:
        throw new DataLengthException("input too large for RSA cipher.");
    L13:
        if (r102 == r100.length) goto L15;
    L7:
        if (this.forEncryption == true) goto L11;
        throw new DataLengthException("input too large for RSA cipher.");
    L21:
        throw new DataLengthException("input too large for RSA cipher.");
    }

    public byte[] convertOutput(BigInteger r100) {
        byte[] r101 = r100.toByteArray();
        if (this.forEncryption == false) goto L16;
        if (r101[0] != 0) goto L11;
        if (r101.length <= getOutputBlockSize()) goto L11;
        int r102 = r101.length - 1;
        byte[] r103 = new byte[r102];
        System.arraycopy(r101, 1, r103, 0, r102);
        return r103;
    L11:
        if (r101.length >= getOutputBlockSize()) goto L14;
        int r104 = getOutputBlockSize();
        byte[] r105 = new byte[r104];
        System.arraycopy(r101, 0, r105, r104 - r101.length, r101.length);
        return r105;
    L14:
        return r101;
    L16:
        if (r101[0] != 0) goto L18;
        int r106 = r101.length - 1;
        byte[] r107 = new byte[r106];
        System.arraycopy(r101, 1, r107, 0, r106);
    L19:
        Arrays.fill(r101, (byte) 0);
        return r107;
    L18:
        int r108 = r101.length;
        r107 = new byte[r108];
        System.arraycopy(r101, 0, r107, 0, r108);
        goto L19
    }

    public int getInputBlockSize() {
        int r100 = (this.key.getModulus().bitLength() + 7) / 8;
        if (this.forEncryption == true) goto L5;
        return r100;
    L5:
        return r100 - 1;
    }

    public int getOutputBlockSize() {
        int r100 = (this.key.getModulus().bitLength() + 7) / 8;
        if (this.forEncryption == false) goto L6;
        return r100;
    L6:
        return r100 - 1;
    }

    public void init(boolean r100, CipherParameters r101) {
        if ((r101 instanceof ParametersWithRandom) == false) goto L5;
        r101 = ((ParametersWithRandom) r101).getParameters();
    L5:
        this.key = (RSAKeyParameters) r101;
        this.forEncryption = r100;
    }

    public BigInteger processBlock(BigInteger r100) {
        RSAKeyParameters r101 = this.key;
        if ((r101 instanceof RSAPrivateCrtKeyParameters) == false) goto L7;
        RSAPrivateCrtKeyParameters r102 = (RSAPrivateCrtKeyParameters) r101;
        BigInteger r103 = r102.getP();
        BigInteger r104 = r102.getQ();
        BigInteger r105 = r102.getDP();
        BigInteger r106 = r102.getDQ();
        BigInteger r107 = r102.getQInv();
        BigInteger r108 = r100.remainder(r103).modPow(r105, r103);
        BigInteger r109 = r100.remainder(r104).modPow(r106, r104);
        return r108.subtract(r109).multiply(r107).mod(r103).multiply(r104).add(r109);
    L7:
        return r100.modPow(r101.getExponent(), this.key.getModulus());
    }
}
