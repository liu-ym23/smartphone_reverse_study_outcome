package org.bouncycastle.crypto.encodings;

import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.util.DigestFactory;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class OAEPEncoding implements AsymmetricBlockCipher {
    private byte[] defHash;
    private AsymmetricBlockCipher engine;
    private boolean forEncryption;
    private Digest mgf1Hash;
    private SecureRandom random;

    public OAEPEncoding(AsymmetricBlockCipher r100) {
        this(r100, DigestFactory.createSHA1(), null);
    }

    public OAEPEncoding(AsymmetricBlockCipher r100, Digest r101) {
        this(r100, r101, null);
    }

    public OAEPEncoding(AsymmetricBlockCipher r100, Digest r101, Digest r102, byte[] r103) {
        this.engine = r100;
        this.mgf1Hash = r102;
        this.defHash = new byte[r101.getDigestSize()];
        r101.reset();
        if (r103 == null) goto L5;
        r101.update(r103, 0, r103.length);
    L5:
        r101.doFinal(this.defHash, 0);
    }

    public OAEPEncoding(AsymmetricBlockCipher r100, Digest r101, byte[] r102) {
        this(r100, r101, r101, r102);
    }

    private void ItoOSP(int r100, byte[] r101) {
        r101[0] = (byte) (r100 >>> 24);
        r101[1] = (byte) (r100 >>> 16);
        r101[2] = (byte) (r100 >>> 8);
        r101[3] = (byte) (r100 >>> 0);
    }

    private byte[] maskGeneratorFunction1(byte[] r100, int r110, int r111, int r112) {
        byte[] r101 = new byte[r112];
        int r102 = this.mgf1Hash.getDigestSize();
        byte[] r103 = new byte[r102];
        byte[] r104 = new byte[4];
        this.mgf1Hash.reset();
        int r105 = 0;
    L4:
        if (r105 >= (r112 / r102)) goto L6;
        ItoOSP(r105, r104);
        this.mgf1Hash.update(r100, r110, r111);
        this.mgf1Hash.update(r104, 0, 4);
        this.mgf1Hash.doFinal(r103, 0);
        System.arraycopy(r103, 0, r101, r105 * r102, r102);
        r105 = r105 + 1;
        goto L4
    L6:
        int r106 = r102 * r105;
        if (r106 >= r112) goto L9;
        ItoOSP(r105, r104);
        this.mgf1Hash.update(r100, r110, r111);
        this.mgf1Hash.update(r104, 0, 4);
        this.mgf1Hash.doFinal(r103, 0);
        System.arraycopy(r103, 0, r101, r106, r112 - r106);
    L9:
        return r101;
    }

    public byte[] decodeBlock(byte[] r100, int r101, int r110) throws InvalidCipherTextException {
        byte[] r102 = this.engine.processBlock(r100, r101, r110);
        int r103 = this.engine.getOutputBlockSize();
        byte[] r111 = new byte[r103];
        if (r103 >= ((this.defHash.length * 2) + 1)) goto L5;
        boolean r104 = true;
    L7:
        if (r102.length > r103) goto L9;
        System.arraycopy(r102, 0, r111, r103 - r102.length, r102.length);
    L10:
        byte[] r105 = this.defHash;
        byte[] r106 = maskGeneratorFunction1(r111, r105.length, r103 - r105.length, r105.length);
        int r107 = 0;
    L11:
        byte[] r108 = this.defHash;
        if (r107 == r108.length) goto L14;
        r111[r107] = (byte) (r111[r107] ^ r106[r107]);
        r107 = r107 + 1;
        goto L11
    L14:
        byte[] r109 = maskGeneratorFunction1(r111, 0, r108.length, r103 - r108.length);
        int r112 = this.defHash.length;
    L15:
        if (r112 == r103) goto L17;
        r111[r112] = (byte) (r111[r112] ^ r109[r112 - this.defHash.length]);
        r112 = r112 + 1;
        goto L15
    L17:
        int r113 = 0;
        boolean r114 = false;
    L18:
        byte[] r115 = this.defHash;
        if (r113 == r115.length) goto L24;
        if (r115[r113] == r111[r115.length + r113]) goto L23;
        r114 = true;
    L23:
        r113 = r113 + 1;
        goto L18
    L24:
        int r116 = r115.length * 2;
        int r117 = r103;
    L25:
        if (r116 == r103) goto L38;
        if (r111[r116] == 0) goto L29;
        boolean r118 = true;
    L30:
        if (r117 != r103) goto L32;
        boolean r119 = true;
    L34:
        if ((r118 & r119) == false) goto L36;
        r117 = r116;
    L36:
        r116 = r116 + 1;
        goto L25
    L32:
        r119 = false;
        goto L34
    L29:
        r118 = false;
        goto L30
    L38:
        if (r117 <= (r103 - 1)) goto L40;
        boolean r120 = true;
    L42:
        if (r111[r117] == 1) goto L44;
        boolean r121 = true;
    L45:
        int r122 = r117 + 1;
        if (((r120 | r121) | (r104 | r114)) == true) goto L49;
        int r123 = r103 - r122;
        byte[] r124 = new byte[r123];
        System.arraycopy(r111, r122, r124, 0, r123);
        Arrays.fill(r111, (byte) 0);
        return r124;
    L49:
        Arrays.fill(r111, (byte) 0);
        throw new InvalidCipherTextException("data wrong");
    L44:
        r121 = false;
        goto L45
    L40:
        r120 = false;
        goto L42
    L9:
        System.arraycopy(r102, 0, r111, 0, r103);
        r104 = true;
        goto L10
    L5:
        r104 = false;
        goto L7
    }

    public byte[] encodeBlock(byte[] r100, int r101, int r102) throws InvalidCipherTextException {
        if (r102 > getInputBlockSize()) goto L14;
        int r103 = (getInputBlockSize() + 1) + (this.defHash.length * 2);
        byte[] r104 = new byte[r103];
        int r105 = r103 - r102;
        System.arraycopy(r100, r101, r104, r105, r102);
        r104[r105 - 1] = 1;
        byte[] r106 = this.defHash;
        System.arraycopy(r106, 0, r104, r106.length, r106.length);
        int r107 = this.defHash.length;
        byte[] r108 = new byte[r107];
        this.random.nextBytes(r108);
        byte[] r109 = maskGeneratorFunction1(r108, 0, r107, r103 - this.defHash.length);
        int r110 = this.defHash.length;
    L5:
        if (r110 == r103) goto L7;
        r104[r110] = (byte) (r104[r110] ^ r109[r110 - this.defHash.length]);
        r110 = r110 + 1;
        goto L5
    L7:
        System.arraycopy(r108, 0, r104, 0, this.defHash.length);
        byte[] r111 = this.defHash;
        byte[] r112 = maskGeneratorFunction1(r104, r111.length, r103 - r111.length, r111.length);
        int r113 = 0;
    L9:
        if (r113 == this.defHash.length) goto L12;
        r104[r113] = (byte) (r104[r113] ^ r112[r113]);
        r113 = r113 + 1;
        goto L9
    L12:
        return this.engine.processBlock(r104, 0, r103);
    L14:
        throw new DataLengthException("input data too long");
    }

    @Override // org.bouncycastle.crypto.AsymmetricBlockCipher
    public int getInputBlockSize() {
        int r100 = this.engine.getInputBlockSize();
        if (this.forEncryption == true) goto L5;
        return r100;
    L5:
        return (r100 - 1) - (this.defHash.length * 2);
    }

    @Override // org.bouncycastle.crypto.AsymmetricBlockCipher
    public int getOutputBlockSize() {
        int r100 = this.engine.getOutputBlockSize();
        if (this.forEncryption == false) goto L6;
        return r100;
    L6:
        return (r100 - 1) - (this.defHash.length * 2);
    }

    public AsymmetricBlockCipher getUnderlyingCipher() {
        return this.engine;
    }

    @Override // org.bouncycastle.crypto.AsymmetricBlockCipher
    public void init(boolean r100, CipherParameters r101) {
        if ((r101 instanceof ParametersWithRandom) == false) goto L5;
        SecureRandom r102 = ((ParametersWithRandom) r101).getRandom();
    L6:
        this.random = r102;
        this.engine.init(r100, r101);
        this.forEncryption = r100;
        return;
    L5:
        r102 = CryptoServicesRegistrar.getSecureRandom();
        goto L6
    }

    @Override // org.bouncycastle.crypto.AsymmetricBlockCipher
    public byte[] processBlock(byte[] r100, int r101, int r102) throws InvalidCipherTextException {
        if (this.forEncryption == false) goto L7;
        return encodeBlock(r100, r101, r102);
    L7:
        return decodeBlock(r100, r101, r102);
    }
}
