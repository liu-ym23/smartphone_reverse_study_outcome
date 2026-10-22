package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.ParametersWithIV;

/* JADX INFO: loaded from: classes42.dex */
public class PGPCFBBlockCipher implements BlockCipher {
    private byte[] FR;
    private byte[] FRE;
    private byte[] IV;
    private int blockSize;
    private BlockCipher cipher;
    private int count;
    private boolean forEncryption;
    private boolean inlineIv;
    private byte[] tmp;

    public PGPCFBBlockCipher(BlockCipher r100, boolean r101) {
        this.cipher = r100;
        this.inlineIv = r101;
        int r102 = r100.getBlockSize();
        this.blockSize = r102;
        this.IV = new byte[r102];
        this.FR = new byte[r102];
        this.FRE = new byte[r102];
        this.tmp = new byte[r102];
    }

    private int decryptBlock(byte[] r100, int r101, byte[] r102, int r103) throws DataLengthException, IllegalStateException {
        int r104 = this.blockSize;
        if ((r101 + r104) > r100.length) goto L17;
        if ((r104 + r103) > r102.length) goto L15;
        int r105 = 0;
        this.cipher.processBlock(this.FR, 0, this.FRE, 0);
        int r106 = 0;
    L8:
        if (r106 >= this.blockSize) goto L10;
        r102[r103 + r106] = encryptByte(r100[r101 + r106], r106);
        r106 = r106 + 1;
    L10:
        int r107 = this.blockSize;
        if (r105 >= r107) goto L13;
        this.FR[r105] = r100[r101 + r105];
        r105 = r105 + 1;
        goto L10
    L13:
        return r107;
    L15:
        throw new OutputLengthException("output buffer too short");
    L17:
        throw new DataLengthException("input buffer too short");
    }

    private int decryptBlockWithIV(byte[] r100, int r101, byte[] r102, int r110) throws DataLengthException, IllegalStateException {
        int r103 = this.blockSize;
        if ((r101 + r103) > r100.length) goto L34;
        if ((r110 + r103) > r102.length) goto L32;
        int r104 = this.count;
        if (r104 != 0) goto L15;
        int r105 = 0;
    L10:
        if (r105 >= this.blockSize) goto L12;
        this.FR[r105] = r100[r101 + r105];
        r105 = r105 + 1;
        goto L10
    L12:
        this.cipher.processBlock(this.FR, 0, this.FRE, 0);
        this.count += this.blockSize;
        return 0;
    L15:
        if (r104 != r103) goto L23;
        System.arraycopy(r100, r101, this.tmp, 0, r103);
        byte[] r106 = this.FR;
        System.arraycopy(r106, 2, r106, 0, this.blockSize - 2);
        byte[] r107 = this.FR;
        int r108 = this.blockSize;
        byte[] r109 = this.tmp;
        r107[r108 - 2] = r109[0];
        r107[r108 - 1] = r109[1];
        this.cipher.processBlock(r107, 0, this.FRE, 0);
        int r111 = 0;
    L17:
        int r112 = this.blockSize;
        if (r111 >= (r112 - 2)) goto L20;
        r102[r110 + r111] = encryptByte(this.tmp[r111 + 2], r111);
        r111 = r111 + 1;
        goto L17
    L20:
        System.arraycopy(this.tmp, 2, this.FR, 0, r112 - 2);
        this.count += 2;
        return this.blockSize - 2;
    L23:
        if (r104 < (r103 + 2)) goto L30;
        System.arraycopy(r100, r101, this.tmp, 0, r103);
        r102[r110 + 0] = encryptByte(this.tmp[0], this.blockSize - 2);
        r102[r110 + 1] = encryptByte(this.tmp[1], this.blockSize - 1);
        System.arraycopy(this.tmp, 0, this.FR, this.blockSize - 2, 2);
        this.cipher.processBlock(this.FR, 0, this.FRE, 0);
        int r113 = 0;
    L25:
        int r114 = this.blockSize;
        if (r113 >= (r114 - 2)) goto L28;
        r102[(r110 + r113) + 2] = encryptByte(this.tmp[r113 + 2], r113);
        r113 = r113 + 1;
        goto L25
    L28:
        System.arraycopy(this.tmp, 2, this.FR, 0, r114 - 2);
    L30:
        return this.blockSize;
    L32:
        throw new OutputLengthException("output buffer too short");
    L34:
        throw new DataLengthException("input buffer too short");
    }

    private int encryptBlock(byte[] r100, int r101, byte[] r102, int r103) throws DataLengthException, IllegalStateException {
        int r104 = this.blockSize;
        if ((r101 + r104) > r100.length) goto L17;
        if ((r104 + r103) > r102.length) goto L15;
        int r105 = 0;
        this.cipher.processBlock(this.FR, 0, this.FRE, 0);
        int r106 = 0;
    L8:
        if (r106 >= this.blockSize) goto L10;
        r102[r103 + r106] = encryptByte(r100[r101 + r106], r106);
        r106 = r106 + 1;
    L10:
        int r107 = this.blockSize;
        if (r105 >= r107) goto L13;
        this.FR[r105] = r102[r103 + r105];
        r105 = r105 + 1;
        goto L10
    L13:
        return r107;
    L15:
        throw new OutputLengthException("output buffer too short");
    L17:
        throw new DataLengthException("input buffer too short");
    }

    private int encryptBlockWithIV(byte[] r100, int r101, byte[] r102, int r103) throws DataLengthException, IllegalStateException {
        int r104 = this.blockSize;
        if ((r101 + r104) > r100.length) goto L34;
        int r105 = this.count;
        if (r105 != 0) goto L21;
        if ((((r104 * 2) + r103) + 2) > r102.length) goto L19;
        this.cipher.processBlock(this.FR, 0, this.FRE, 0);
        int r106 = 0;
    L9:
        int r107 = this.blockSize;
        if (r106 >= r107) goto L12;
        r102[r103 + r106] = encryptByte(this.IV[r106], r106);
        r106 = r106 + 1;
        goto L9
    L12:
        System.arraycopy(r102, r103, this.FR, 0, r107);
        this.cipher.processBlock(this.FR, 0, this.FRE, 0);
        int r108 = this.blockSize;
        r102[r103 + r108] = encryptByte(this.IV[r108 - 2], 0);
        int r109 = this.blockSize;
        r102[(r103 + r109) + 1] = encryptByte(this.IV[r109 - 1], 1);
        System.arraycopy(r102, r103 + 2, this.FR, 0, this.blockSize);
        this.cipher.processBlock(this.FR, 0, this.FRE, 0);
        int r110 = 0;
    L13:
        int r111 = this.blockSize;
        if (r110 >= r111) goto L16;
        r102[((r111 + r103) + 2) + r110] = encryptByte(r100[r101 + r110], r110);
        r110 = r110 + 1;
        goto L13
    L16:
        System.arraycopy(r102, (r103 + r111) + 2, this.FR, 0, r111);
        int r112 = this.count;
        int r113 = this.blockSize;
        this.count = r112 + ((r113 * 2) + 2);
        return (r113 * 2) + 2;
    L19:
        throw new OutputLengthException("output buffer too short");
    L21:
        if (r105 < (r104 + 2)) goto L32;
        if ((r104 + r103) > r102.length) goto L30;
        this.cipher.processBlock(this.FR, 0, this.FRE, 0);
        int r114 = 0;
    L25:
        int r115 = this.blockSize;
        if (r114 >= r115) goto L28;
        r102[r103 + r114] = encryptByte(r100[r101 + r114], r114);
        r114 = r114 + 1;
        goto L25
    L28:
        System.arraycopy(r102, r103, this.FR, 0, r115);
        goto L32
    L30:
        throw new OutputLengthException("output buffer too short");
    L32:
        return this.blockSize;
    L34:
        throw new DataLengthException("input buffer too short");
    }

    private byte encryptByte(byte r100, int r101) {
        return (byte) (r100 ^ this.FRE[r101]);
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        if (this.inlineIv == false) goto L7;
        StringBuilder r100 = new StringBuilder();
        r100.append(this.cipher.getAlgorithmName());
        String r101 = "/PGPCFBwithIV";
    L5:
        r100.append(r101);
        return r100.toString();
    L7:
        r100 = new StringBuilder();
        r100.append(this.cipher.getAlgorithmName());
        r101 = "/PGPCFB";
        goto L5
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return this.cipher.getBlockSize();
    }

    public BlockCipher getUnderlyingCipher() {
        return this.cipher;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean r100, CipherParameters r101) throws IllegalArgumentException {
        this.forEncryption = r100;
        if ((r101 instanceof ParametersWithIV) == false) goto L12;
        ParametersWithIV r102 = (ParametersWithIV) r101;
        byte[] r103 = r102.getIV();
        int r104 = r103.length;
        byte[] r105 = this.IV;
        if (r104 >= r105.length) goto L10;
        System.arraycopy(r103, 0, r105, r105.length - r103.length, r103.length);
        int r106 = 0;
    L7:
        byte[] r107 = this.IV;
        if (r106 >= (r107.length - r103.length)) goto L11;
        r107[r106] = 0;
        r106 = r106 + 1;
    L11:
        reset();
        BlockCipher r108 = this.cipher;
        r101 = r102.getParameters();
    L13:
        r108.init(true, r101);
        return;
    L10:
        System.arraycopy(r103, 0, r105, 0, r105.length);
        goto L11
    L12:
        reset();
        r108 = this.cipher;
        goto L13
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] r100, int r101, byte[] r102, int r103) throws DataLengthException, IllegalStateException {
        if (this.inlineIv == false) goto L10;
        if (this.forEncryption == false) goto L8;
        return encryptBlockWithIV(r100, r101, r102, r103);
    L8:
        return decryptBlockWithIV(r100, r101, r102, r103);
    L10:
        if (this.forEncryption == false) goto L13;
        return encryptBlock(r100, r101, r102, r103);
    L13:
        return decryptBlock(r100, r101, r102, r103);
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
        this.count = 0;
        int r100 = 0;
    L3:
        byte[] r101 = this.FR;
        if (r100 == r101.length) goto L10;
        if (this.inlineIv == false) goto L8;
        r101[r100] = 0;
    L9:
        r100 = r100 + 1;
        goto L3
    L8:
        r101[r100] = this.IV[r100];
        goto L9
    L10:
        this.cipher.reset();
    }
}
