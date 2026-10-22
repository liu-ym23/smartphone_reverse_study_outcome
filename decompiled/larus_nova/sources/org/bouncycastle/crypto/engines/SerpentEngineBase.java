package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;

/* JADX INFO: loaded from: classes42.dex */
public abstract class SerpentEngineBase implements BlockCipher {
    protected static final int BLOCK_SIZE = 16;
    static final int PHI = -1640531527;
    static final int ROUNDS = 32;
    protected int X0;
    protected int X1;
    protected int X2;
    protected int X3;
    protected boolean encrypting;
    protected int[] wKey;

    public SerpentEngineBase() {
    }

    public static int rotateLeft(int r100, int r101) {
        int r102 = r100 << r101;
        return (r100 >>> (-r101)) | r102;
    }

    public static int rotateRight(int r100, int r101) {
        int r102 = r100 >>> r101;
        return (r100 << (-r101)) | r102;
    }

    public final void LT() {
        int r100 = rotateLeft(this.X0, 13);
        int r101 = rotateLeft(this.X2, 3);
        int r102 = (this.X1 ^ r100) ^ r101;
        int r103 = (this.X3 ^ r101) ^ (r100 << 3);
        this.X1 = rotateLeft(r102, 1);
        int r104 = rotateLeft(r103, 7);
        this.X3 = r104;
        this.X0 = rotateLeft((r100 ^ this.X1) ^ r104, 5);
        this.X2 = rotateLeft((this.X3 ^ r101) ^ (this.X1 << 7), 22);
    }

    public abstract void decryptBlock(byte[] r100, int r101, byte[] r102, int r103);

    public abstract void encryptBlock(byte[] r100, int r101, byte[] r102, int r103);

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "Serpent";
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 16;
    }

    public final void ib0(int r100, int r101, int r102, int r103) {
        int r104 = ~r100;
        int r105 = r101 ^ r100;
        int r106 = (r104 | r105) ^ r103;
        int r107 = r102 ^ r106;
        int r108 = r105 ^ r107;
        this.X2 = r108;
        int r109 = (r105 & r103) ^ r104;
        int r110 = (r108 & r109) ^ r106;
        this.X1 = r110;
        int r111 = (r100 & r106) ^ (r110 | r107);
        this.X3 = r111;
        this.X0 = r111 ^ (r109 ^ r107);
    }

    public final void ib1(int r100, int r101, int r102, int r103) {
        int r104 = r103 ^ r101;
        int r105 = r100 ^ (r101 & r104);
        int r106 = r104 ^ r105;
        int r107 = r102 ^ r106;
        this.X3 = r107;
        int r108 = r101 ^ (r104 & r105);
        int r109 = r105 ^ (r107 | r108);
        this.X1 = r109;
        int r110 = ~r109;
        int r111 = r108 ^ r107;
        this.X0 = r110 ^ r111;
        this.X2 = (r110 | r111) ^ r106;
    }

    public final void ib2(int r100, int r101, int r102, int r103) {
        int r104 = r101 ^ r103;
        int r105 = ~r104;
        int r106 = r100 ^ r102;
        int r107 = r102 ^ r104;
        int r108 = (r101 & r107) ^ r106;
        this.X0 = r108;
        int r109 = (((r100 | r105) ^ r103) | r106) ^ r104;
        this.X3 = r109;
        int r110 = ~r107;
        int r111 = r109 | r108;
        this.X1 = r110 ^ r111;
        int r112 = r111 ^ r106;
        this.X2 = r112 ^ (r103 & r110);
    }

    public final void ib3(int r100, int r101, int r102, int r103) {
        int r104 = r100 | r101;
        int r105 = r101 ^ r102;
        int r106 = r100 ^ (r101 & r105);
        int r107 = r102 ^ r106;
        int r108 = r103 | r106;
        int r109 = r105 ^ r108;
        this.X0 = r109;
        int r110 = (r108 | r105) ^ r103;
        this.X2 = r107 ^ r110;
        int r111 = r104 ^ r110;
        int r112 = r106 ^ (r109 & r111);
        this.X3 = r112;
        this.X1 = r112 ^ (r111 ^ r109);
    }

    public final void ib4(int r100, int r101, int r102, int r103) {
        int r104 = r101 ^ ((r102 | r103) & r100);
        int r105 = r102 ^ (r100 & r104);
        int r106 = r103 ^ r105;
        this.X1 = r106;
        int r107 = ~r100;
        int r108 = (r105 & r106) ^ r104;
        this.X3 = r108;
        int r109 = r103 ^ (r106 | r107);
        this.X0 = r108 ^ r109;
        int r110 = r107 ^ r106;
        this.X2 = r110 ^ (r104 & r109);
    }

    public final void ib5(int r100, int r101, int r102, int r103) {
        int r104 = ~r102;
        int r105 = (r101 & r104) ^ r103;
        int r106 = r100 & r105;
        int r107 = (r101 ^ r104) ^ r106;
        this.X3 = r107;
        int r108 = r107 | r101;
        this.X1 = r105 ^ (r100 & r108);
        int r109 = r103 | r100;
        this.X0 = (r104 ^ r108) ^ r109;
        int r110 = (r100 ^ r102) | r106;
        this.X2 = r110 ^ (r101 & r109);
    }

    public final void ib6(int r100, int r101, int r102, int r103) {
        int r104 = ~r100;
        int r105 = r100 ^ r101;
        int r106 = r102 ^ r105;
        int r107 = (r102 | r104) ^ r103;
        this.X1 = r106 ^ r107;
        int r108 = r105 ^ (r106 & r107);
        int r109 = r107 ^ (r101 | r108);
        this.X3 = r109;
        int r110 = r101 | r109;
        this.X0 = r108 ^ r110;
        this.X2 = (r103 & r104) ^ (r110 ^ r106);
    }

    public final void ib7(int r100, int r101, int r102, int r103) {
        int r104 = (r100 & r101) | r102;
        int r105 = (r100 | r101) & r103;
        int r106 = r104 ^ r105;
        this.X3 = r106;
        int r107 = r101 ^ r105;
        int r108 = ((r106 ^ (~r103)) | r107) ^ r100;
        this.X1 = r108;
        int r109 = (r107 ^ r102) ^ (r103 | r108);
        this.X0 = r109;
        int r110 = (r100 & r106) ^ r109;
        this.X2 = r110 ^ (r104 ^ r108);
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean r100, CipherParameters r101) {
        if ((r101 instanceof KeyParameter) == false) goto L7;
        this.encrypting = r100;
        this.wKey = makeWorkingKey(((KeyParameter) r101).getKey());
        return;
    L7:
        throw new IllegalArgumentException("invalid parameter passed to " + getAlgorithmName() + " init - " + r101.getClass().getName());
    }

    public final void inverseLT() {
        int r100 = (rotateRight(this.X2, 22) ^ this.X3) ^ (this.X1 << 7);
        int r101 = rotateRight(this.X0, 5) ^ this.X1;
        int r102 = this.X3;
        int r103 = r101 ^ r102;
        int r104 = rotateRight(r102, 7);
        int r105 = rotateRight(this.X1, 1);
        this.X3 = (r104 ^ r100) ^ (r103 << 3);
        this.X1 = (r105 ^ r103) ^ r100;
        this.X2 = rotateRight(r100, 3);
        this.X0 = rotateRight(r103, 13);
    }

    public abstract int[] makeWorkingKey(byte[] r100);

    @Override // org.bouncycastle.crypto.BlockCipher
    public final int processBlock(byte[] r100, int r101, byte[] r102, int r103) {
        if (this.wKey == null) goto L19;
        if ((r101 + 16) > r100.length) goto L17;
        if ((r103 + 16) > r102.length) goto L15;
        if (this.encrypting == false) goto L11;
        encryptBlock(r100, r101, r102, r103);
        return 16;
    L11:
        decryptBlock(r100, r101, r102, r103);
        return 16;
    L15:
        throw new OutputLengthException("output buffer too short");
    L17:
        throw new DataLengthException("input buffer too short");
    L19:
        throw new IllegalStateException(getAlgorithmName() + " not initialised");
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
    }

    public final void sb0(int r100, int r101, int r102, int r103) {
        int r104 = r100 ^ r103;
        int r105 = r102 ^ r104;
        int r106 = r101 ^ r105;
        int r107 = (r103 & r100) ^ r106;
        this.X3 = r107;
        int r108 = r100 ^ (r101 & r104);
        this.X2 = (r102 | r108) ^ r106;
        int r109 = (r105 ^ r108) & r107;
        this.X1 = (~r105) ^ r109;
        this.X0 = (~r108) ^ r109;
    }

    public final void sb1(int r100, int r101, int r102, int r103) {
        int r104 = (~r100) ^ r101;
        int r105 = (r100 | r104) ^ r102;
        int r106 = r103 ^ r105;
        this.X2 = r106;
        int r107 = r101 ^ (r103 | r104);
        int r108 = r106 ^ r104;
        int r109 = (r105 & r107) ^ r108;
        this.X3 = r109;
        int r110 = r107 ^ r105;
        this.X1 = r109 ^ r110;
        this.X0 = r105 ^ (r110 & r108);
    }

    public final void sb2(int r100, int r101, int r102, int r103) {
        int r104 = ~r100;
        int r105 = r101 ^ r103;
        int r106 = (r102 & r104) ^ r105;
        this.X0 = r106;
        int r107 = r102 ^ r104;
        int r108 = r101 & (r102 ^ r106);
        int r109 = r107 ^ r108;
        this.X3 = r109;
        int r110 = r100 ^ ((r108 | r103) & (r106 | r107));
        this.X2 = r110;
        int r111 = r105 ^ r109;
        this.X1 = (r110 ^ (r103 | r104)) ^ r111;
    }

    public final void sb3(int r100, int r101, int r102, int r103) {
        int r104 = r100 ^ r101;
        int r105 = r100 & r102;
        int r106 = r100 | r103;
        int r107 = r102 ^ r103;
        int r108 = r105 | (r104 & r106);
        int r109 = r107 ^ r108;
        this.X2 = r109;
        int r110 = (r106 ^ r101) ^ r108;
        int r111 = r104 ^ (r107 & r110);
        this.X0 = r111;
        int r112 = r111 & r109;
        this.X1 = r110 ^ r112;
        this.X3 = (r101 | r103) ^ (r107 ^ r112);
    }

    public final void sb4(int r100, int r101, int r102, int r103) {
        int r104 = r100 ^ r103;
        int r105 = r102 ^ (r103 & r104);
        int r106 = r101 | r105;
        this.X3 = r104 ^ r106;
        int r107 = ~r101;
        int r108 = (r104 | r107) ^ r105;
        this.X0 = r108;
        int r109 = r107 ^ r104;
        int r110 = r106 & r109;
        int r111 = r110 ^ (r108 & r100);
        this.X2 = r111;
        this.X1 = (r100 ^ r105) ^ (r109 & r111);
    }

    public final void sb5(int r100, int r101, int r102, int r103) {
        int r104 = ~r100;
        int r105 = r100 ^ r101;
        int r106 = r100 ^ r103;
        int r107 = (r102 ^ r104) ^ (r105 | r106);
        this.X0 = r107;
        int r108 = r103 & r107;
        int r109 = (r105 ^ r107) ^ r108;
        this.X1 = r109;
        int r110 = r107 | r104;
        int r111 = r106 ^ r110;
        this.X2 = (r105 | r108) ^ r111;
        int r112 = r111 & r109;
        this.X3 = r112 ^ (r101 ^ r108);
    }

    public final void sb6(int r100, int r101, int r102, int r103) {
        int r104 = ~r100;
        int r105 = r100 ^ r103;
        int r106 = r101 ^ r105;
        int r107 = r102 ^ (r104 | r105);
        int r108 = r101 ^ r107;
        this.X1 = r108;
        int r109 = (r105 | r108) ^ r103;
        int r110 = (r107 & r109) ^ r106;
        this.X2 = r110;
        int r111 = r109 ^ r107;
        this.X0 = r110 ^ r111;
        int r112 = r111 & r106;
        this.X3 = r112 ^ (~r107);
    }

    public final void sb7(int r100, int r101, int r102, int r103) {
        int r104 = r101 ^ r102;
        int r105 = (r102 & r104) ^ r103;
        int r106 = r100 ^ r105;
        int r107 = r101 ^ ((r103 | r104) & r106);
        this.X1 = r107;
        int r108 = (r100 & r106) ^ r104;
        this.X3 = r108;
        int r109 = (r107 | r105) ^ r106;
        int r110 = r105 ^ (r108 & r109);
        this.X2 = r110;
        int r111 = r108 & r110;
        this.X0 = r111 ^ (~r109);
    }
}
