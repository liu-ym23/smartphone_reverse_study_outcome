package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;

/* JADX INFO: loaded from: classes42.dex */
public class OpenPGPCFBBlockCipher implements BlockCipher {
    private byte[] FR;
    private byte[] FRE;
    private byte[] IV;
    private int blockSize;
    private BlockCipher cipher;
    private int count;
    private boolean forEncryption;

    public OpenPGPCFBBlockCipher(BlockCipher r100) {
        this.cipher = r100;
        int r101 = r100.getBlockSize();
        this.blockSize = r101;
        this.IV = new byte[r101];
        this.FR = new byte[r101];
        this.FRE = new byte[r101];
    }

    private int decryptBlock(byte[] r100, int r110, byte[] r111, int r112) throws DataLengthException, IllegalStateException {
        int r101 = this.blockSize;
        if ((r110 + r101) > r100.length) goto L30;
        if ((r112 + r101) > r111.length) goto L28;
        int r102 = this.count;
        int r103 = 2;
        int r104 = 0;
        if (r102 <= r101) goto L12;
        byte r105 = r100[r110];
        this.FR[r101 - 2] = r105;
        r111[r112] = encryptByte(r105, r101 - 2);
        byte r106 = r100[r110 + 1];
        byte[] r107 = this.FR;
        int r108 = this.blockSize;
        r107[r108 - 1] = r106;
        r111[r112 + 1] = encryptByte(r106, r108 - 1);
        this.cipher.processBlock(this.FR, 0, this.FRE, 0);
    L10:
        if (r103 >= this.blockSize) goto L26;
        byte r109 = r100[r110 + r103];
        int r113 = r103 - 2;
        this.FR[r113] = r109;
        r111[r112 + r103] = encryptByte(r109, r113);
        r103 = r103 + 1;
    L26:
        return this.blockSize;
    L12:
        if (r102 != 0) goto L19;
        this.cipher.processBlock(this.FR, 0, this.FRE, 0);
    L14:
        int r114 = this.blockSize;
        if (r104 >= r114) goto L17;
        int r115 = r110 + r104;
        this.FR[r104] = r100[r115];
        r111[r104] = encryptByte(r100[r115], r104);
        r104 = r104 + 1;
        goto L14
    L17:
        int r116 = this.count + r114;
    L18:
        this.count = r116;
        goto L26
    L19:
        if (r102 != r101) goto L26;
        this.cipher.processBlock(this.FR, 0, this.FRE, 0);
        byte r117 = r100[r110];
        byte r118 = r100[r110 + 1];
        r111[r112] = encryptByte(r117, 0);
        r111[r112 + 1] = encryptByte(r118, 1);
        byte[] r119 = this.FR;
        System.arraycopy(r119, 2, r119, 0, this.blockSize - 2);
        byte[] r120 = this.FR;
        int r121 = this.blockSize;
        r120[r121 - 2] = r117;
        r120[r121 - 1] = r118;
        this.cipher.processBlock(r120, 0, this.FRE, 0);
    L21:
        int r122 = this.blockSize;
        if (r103 >= r122) goto L24;
        byte r123 = r100[r110 + r103];
        int r124 = r103 - 2;
        this.FR[r124] = r123;
        r111[r112 + r103] = encryptByte(r123, r124);
        r103 = r103 + 1;
        goto L21
    L24:
        r116 = this.count + r122;
        goto L18
    L28:
        throw new OutputLengthException("output buffer too short");
    L30:
        throw new DataLengthException("input buffer too short");
    }

    private int encryptBlock(byte[] r100, int r110, byte[] r111, int r112) throws DataLengthException, IllegalStateException {
        int r101 = this.blockSize;
        if ((r110 + r101) > r100.length) goto L28;
        if ((r112 + r101) > r111.length) goto L26;
        int r102 = this.count;
        int r103 = 2;
        int r104 = 0;
        if (r102 <= r101) goto L12;
        byte[] r105 = this.FR;
        int r106 = r101 - 2;
        byte r107 = encryptByte(r100[r110], r101 - 2);
        r111[r112] = r107;
        r105[r106] = r107;
        byte[] r108 = this.FR;
        int r109 = this.blockSize;
        int r113 = r109 - 1;
        byte r114 = encryptByte(r100[r110 + 1], r109 - 1);
        r111[r112 + 1] = r114;
        r108[r113] = r114;
        this.cipher.processBlock(this.FR, 0, this.FRE, 0);
    L10:
        if (r103 >= this.blockSize) goto L24;
        byte[] r115 = this.FR;
        int r116 = r103 - 2;
        byte r117 = encryptByte(r100[r110 + r103], r116);
        r111[r112 + r103] = r117;
        r115[r116] = r117;
        r103 = r103 + 1;
    L24:
        return this.blockSize;
    L12:
        if (r102 != 0) goto L18;
        this.cipher.processBlock(this.FR, 0, this.FRE, 0);
    L14:
        int r118 = this.blockSize;
        if (r104 >= r118) goto L17;
        byte[] r119 = this.FR;
        byte r120 = encryptByte(r100[r110 + r104], r104);
        r111[r112 + r104] = r120;
        r119[r104] = r120;
        r104 = r104 + 1;
    L17:
        this.count += r118;
        goto L24
    L18:
        if (r102 != r101) goto L24;
        this.cipher.processBlock(this.FR, 0, this.FRE, 0);
        r111[r112] = encryptByte(r100[r110], 0);
        r111[r112 + 1] = encryptByte(r100[r110 + 1], 1);
        byte[] r121 = this.FR;
        System.arraycopy(r121, 2, r121, 0, this.blockSize - 2);
        System.arraycopy(r111, r112, this.FR, this.blockSize - 2, 2);
        this.cipher.processBlock(this.FR, 0, this.FRE, 0);
    L20:
        r118 = this.blockSize;
        if (r103 >= r118) goto L17;
        byte[] r122 = this.FR;
        int r123 = r103 - 2;
        byte r124 = encryptByte(r100[r110 + r103], r123);
        r111[r112 + r103] = r124;
        r122[r123] = r124;
        r103 = r103 + 1;
        goto L20
    L26:
        throw new OutputLengthException("output buffer too short");
    L28:
        throw new DataLengthException("input buffer too short");
    }

    private byte encryptByte(byte r100, int r101) {
        return (byte) (r100 ^ this.FRE[r101]);
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName() + "/OpenPGPCFB";
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
        reset();
        this.cipher.init(true, r101);
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] r100, int r101, byte[] r102, int r103) throws DataLengthException, IllegalStateException {
        if (this.forEncryption == false) goto L6;
        return encryptBlock(r100, r101, r102, r103);
    L6:
        return decryptBlock(r100, r101, r102, r103);
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
        this.count = 0;
        byte[] r100 = this.IV;
        byte[] r101 = this.FR;
        System.arraycopy(r100, 0, r101, 0, r101.length);
        this.cipher.reset();
    }
}
