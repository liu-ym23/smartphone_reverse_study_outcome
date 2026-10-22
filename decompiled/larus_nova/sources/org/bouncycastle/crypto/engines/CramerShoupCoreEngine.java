package org.bouncycastle.crypto.engines;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.params.CramerShoupKeyParameters;
import org.bouncycastle.crypto.params.CramerShoupPrivateKeyParameters;
import org.bouncycastle.crypto.params.CramerShoupPublicKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.util.BigIntegers;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes42.dex */
public class CramerShoupCoreEngine {
    private static final BigInteger ONE = null;
    private boolean forEncryption;
    private CramerShoupKeyParameters key;
    private byte[] label;
    private SecureRandom random;

    public static class CramerShoupCiphertextException extends Exception {
        private static final long serialVersionUID = -6360977166495345076L;

        public CramerShoupCiphertextException(String r100) {
            super(r100);
        }
    }

    static {
        ONE = BigInteger.valueOf(1);
    }

    public CramerShoupCoreEngine() {
        this.label = null;
    }

    private BigInteger generateRandomElement(BigInteger r100, SecureRandom r101) {
        BigInteger r102 = ONE;
        return BigIntegers.createRandomInRange(r102, r100.subtract(r102), r101);
    }

    private boolean isValidMessage(BigInteger r100, BigInteger r101) {
        if (r100.compareTo(r101) >= 0) goto L5;
        return true;
    L5:
        return false;
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
        if (r104.compareTo(this.key.getParameters().getP()) >= 0) goto L19;
        return r104;
    L19:
        throw new DataLengthException("input too large for Cramer Shoup cipher.");
    L13:
        if (r102 == r100.length) goto L15;
    L7:
        if (this.forEncryption == false) goto L11;
        throw new DataLengthException("input too large for Cramer Shoup cipher.");
    L21:
        throw new DataLengthException("input too large for Cramer Shoup cipher.");
    }

    public byte[] convertOutput(BigInteger r100) {
        byte[] r101 = r100.toByteArray();
        if (this.forEncryption == true) goto L15;
        if (r101[0] != 0) goto L11;
        if (r101.length <= getOutputBlockSize()) goto L11;
        int r102 = r101.length - 1;
        byte[] r103 = new byte[r102];
        System.arraycopy(r101, 1, r103, 0, r102);
        return r103;
    L11:
        if (r101.length >= getOutputBlockSize()) goto L18;
        int r104 = getOutputBlockSize();
        byte[] r105 = new byte[r104];
        System.arraycopy(r101, 0, r105, r104 - r101.length, r101.length);
        return r105;
    L18:
        return r101;
    L15:
        if (r101[0] != 0) goto L18;
        int r106 = r101.length - 1;
        byte[] r107 = new byte[r106];
        System.arraycopy(r101, 1, r107, 0, r106);
        return r107;
    }

    public BigInteger decryptBlock(CramerShoupCiphertext r100) throws CramerShoupCiphertextException {
        if (this.key.isPrivate() == true) goto L5;
    L16:
        return null;
    L5:
        if (this.forEncryption == true) goto L16;
        CramerShoupKeyParameters r101 = this.key;
        if ((r101 instanceof CramerShoupPrivateKeyParameters) == false) goto L16;
        CramerShoupPrivateKeyParameters r102 = (CramerShoupPrivateKeyParameters) r101;
        BigInteger r103 = r102.getParameters().getP();
        Digest r104 = r102.getParameters().getH();
        byte[] r105 = r100.getU1().toByteArray();
        r104.update(r105, 0, r105.length);
        byte[] r106 = r100.getU2().toByteArray();
        r104.update(r106, 0, r106.length);
        byte[] r107 = r100.getE().toByteArray();
        r104.update(r107, 0, r107.length);
        byte[] r108 = this.label;
        if (r108 == null) goto L11;
        r104.update(r108, 0, r108.length);
    L11:
        byte[] r109 = new byte[r104.getDigestSize()];
        r104.doFinal(r109, 0);
        BigInteger r110 = new BigInteger(1, r109);
        BigInteger r111 = r100.f525175u1.modPow(r102.getX1().add(r102.getY1().multiply(r110)), r103).multiply(r100.f525176u2.modPow(r102.getX2().add(r102.getY2().multiply(r110)), r103)).mod(r103);
        if (r100.f525177v.equals(r111) == false) goto L15;
        return r100.f525174e.multiply(r100.f525175u1.modPow(r102.getZ(), r103).modInverse(r103)).mod(r103);
    L15:
        throw new CramerShoupCiphertextException("Sorry, that ciphertext is not correct");
    }

    public CramerShoupCiphertext encryptBlock(BigInteger r110) {
        if (this.key.isPrivate() == false) goto L5;
        return null;
    L5:
        if (this.forEncryption == false) goto L17;
        CramerShoupKeyParameters r100 = this.key;
        if ((r100 instanceof CramerShoupPublicKeyParameters) == false) goto L18;
        CramerShoupPublicKeyParameters r101 = (CramerShoupPublicKeyParameters) r100;
        BigInteger r102 = r101.getParameters().getP();
        BigInteger r103 = r101.getParameters().getG1();
        BigInteger r104 = r101.getParameters().getG2();
        BigInteger r105 = r101.getH();
        if (isValidMessage(r110, r102) == true) goto L11;
        return null;
    L11:
        BigInteger r106 = generateRandomElement(r102, this.random);
        BigInteger r107 = r103.modPow(r106, r102);
        BigInteger r108 = r104.modPow(r106, r102);
        BigInteger r111 = r105.modPow(r106, r102).multiply(r110).mod(r102);
        Digest r109 = r101.getParameters().getH();
        byte[] r112 = r107.toByteArray();
        r109.update(r112, 0, r112.length);
        byte[] r113 = r108.toByteArray();
        r109.update(r113, 0, r113.length);
        byte[] r114 = r111.toByteArray();
        r109.update(r114, 0, r114.length);
        byte[] r115 = this.label;
        if (r115 == null) goto L14;
        r109.update(r115, 0, r115.length);
    L14:
        byte[] r116 = new byte[r109.getDigestSize()];
        r109.doFinal(r116, 0);
        BigInteger r117 = new BigInteger(1, r116);
        return new CramerShoupCiphertext(r107, r108, r111, r101.getC().modPow(r106, r102).multiply(r101.getD().modPow(r106.multiply(r117), r102)).mod(r102));
    L18:
        return null;
    L17:
        return null;
    }

    public int getInputBlockSize() {
        int r100 = (this.key.getParameters().getP().bitLength() + 7) / 8;
        if (this.forEncryption == true) goto L5;
        return r100;
    L5:
        return r100 - 1;
    }

    public int getOutputBlockSize() {
        int r100 = (this.key.getParameters().getP().bitLength() + 7) / 8;
        if (this.forEncryption == false) goto L6;
        return r100;
    L6:
        return r100 - 1;
    }

    public void init(boolean r100, CipherParameters r101) {
        if ((r101 instanceof ParametersWithRandom) == false) goto L5;
        ParametersWithRandom r102 = (ParametersWithRandom) r101;
        this.key = (CramerShoupKeyParameters) r102.getParameters();
        SecureRandom r103 = r102.getRandom();
    L6:
        this.random = initSecureRandom(r100, r103);
        this.forEncryption = r100;
        return;
    L5:
        this.key = (CramerShoupKeyParameters) r101;
        r103 = null;
        goto L6
    }

    public void init(boolean r100, CipherParameters r101, String r102) {
        init(r100, r101);
        this.label = Strings.toUTF8ByteArray(r102);
    }

    public SecureRandom initSecureRandom(boolean r100, SecureRandom r101) {
        if (r100 == true) goto L6;
        return null;
    L6:
        return CryptoServicesRegistrar.getSecureRandom(r101);
    }
}
