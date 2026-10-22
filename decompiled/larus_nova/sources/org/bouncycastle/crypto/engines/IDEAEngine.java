package org.bouncycastle.crypto.engines;

import kotlin.UByte;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;

/* JADX INFO: loaded from: classes42.dex */
public class IDEAEngine implements BlockCipher {
    private static final int BASE = 65537;
    protected static final int BLOCK_SIZE = 8;
    private static final int MASK = 65535;
    private int[] workingKey;

    public IDEAEngine() {
        this.workingKey = null;
    }

    private int bytesToWord(byte[] r100, int r101) {
        return ((r100[r101] << 8) & 65280) + (r100[r101 + 1] & UByte.MAX_VALUE);
    }

    private int[] expandKey(byte[] r100) {
        int[] r101 = new int[52];
        int r102 = 0;
        if (r100.length >= 16) goto L5;
        byte[] r103 = new byte[16];
        System.arraycopy(r100, 0, r103, 16 - r100.length, r100.length);
        r100 = r103;
    L5:
        int r104 = 8;
        if (r102 >= 8) goto L8;
        r101[r102] = bytesToWord(r100, r102 * 2);
        r102 = r102 + 1;
    L8:
        if (r104 >= 52) goto L16;
        int r105 = r104 & 7;
        if (r105 >= 6) goto L12;
        r101[r104] = (((r101[r104 - 7] & 127) << 9) | (r101[r104 - 6] >> 7)) & 65535;
    L15:
        r104 = r104 + 1;
        goto L8
    L12:
        if (r105 != 6) goto L14;
        r101[r104] = (((r101[r104 - 7] & 127) << 9) | (r101[r104 - 14] >> 7)) & 65535;
        goto L15
    L14:
        r101[r104] = (((r101[r104 - 15] & 127) << 9) | (r101[r104 - 14] >> 7)) & 65535;
        goto L15
    L16:
        return r101;
    }

    private int[] generateWorkingKey(boolean r100, byte[] r101) {
        if (r100 == false) goto L6;
        return expandKey(r101);
    L6:
        return invertKey(expandKey(r101));
    }

    private void ideaFunc(int[] r100, byte[] r110, int r111, byte[] r112, int r113) {
        int r101 = bytesToWord(r110, r111);
        int r102 = bytesToWord(r110, r111 + 2);
        int r103 = bytesToWord(r110, r111 + 4);
        int r114 = bytesToWord(r110, r111 + 6);
        int r115 = 0;
        int r104 = r103;
        int r105 = r102;
        int r106 = r101;
        int r107 = 0;
    L4:
        if (r115 >= 8) goto L6;
        int r108 = r107 + 1;
        int r109 = mul(r106, r100[r107]);
        int r116 = r108 + 1;
        int r117 = (r105 + r100[r108]) & 65535;
        int r118 = r116 + 1;
        int r119 = (r104 + r100[r116]) & 65535;
        int r120 = r118 + 1;
        int r121 = mul(r114, r100[r118]);
        int r122 = r120 + 1;
        int r123 = mul(r119 ^ r109, r100[r120]);
        int r124 = ((r117 ^ r121) + r123) & 65535;
        int r125 = r122 + 1;
        int r126 = mul(r124, r100[r122]);
        int r127 = (r123 + r126) & 65535;
        r114 = r121 ^ r127;
        r104 = r127 ^ r117;
        r115 = r115 + 1;
        r105 = r119 ^ r126;
        r106 = r109 ^ r126;
        r107 = r125;
        goto L4
    L6:
        int r128 = r107 + 1;
        wordToBytes(mul(r106, r100[r107]), r112, r113);
        int r129 = r128 + 1;
        wordToBytes(r104 + r100[r128], r112, r113 + 2);
        int r130 = r129 + 1;
        wordToBytes(r105 + r100[r129], r112, r113 + 4);
        wordToBytes(mul(r114, r100[r130]), r112, r113 + 6);
    }

    private int[] invertKey(int[] r100) {
        int[] r101 = new int[52];
        int r102 = mulInv(r100[0]);
        int r103 = 1;
        int r104 = addInv(r100[1]);
        int r105 = addInv(r100[2]);
        r101[51] = mulInv(r100[3]);
        r101[50] = r105;
        r101[49] = r104;
        int r106 = 48;
        r101[48] = r102;
        int r107 = 4;
    L4:
        if (r103 >= 8) goto L6;
        int r108 = r107 + 1;
        int r109 = r100[r107];
        int r110 = r108 + 1;
        int r111 = r106 - 1;
        r101[r111] = r100[r108];
        int r112 = r111 - 1;
        r101[r112] = r109;
        int r113 = r110 + 1;
        int r114 = mulInv(r100[r110]);
        int r115 = r113 + 1;
        int r116 = addInv(r100[r113]);
        int r117 = r115 + 1;
        int r118 = addInv(r100[r115]);
        int r119 = r112 - 1;
        r101[r119] = mulInv(r100[r117]);
        int r120 = r119 - 1;
        r101[r120] = r116;
        int r121 = r120 - 1;
        r101[r121] = r118;
        r106 = r121 - 1;
        r101[r106] = r114;
        r103 = r103 + 1;
        r107 = r117 + 1;
        goto L4
    L6:
        int r122 = r107 + 1;
        int r123 = r100[r107];
        int r124 = r122 + 1;
        int r125 = r106 - 1;
        r101[r125] = r100[r122];
        int r126 = r125 - 1;
        r101[r126] = r123;
        int r127 = r124 + 1;
        int r128 = mulInv(r100[r124]);
        int r129 = r127 + 1;
        int r130 = addInv(r100[r127]);
        int r131 = r129 + 1;
        int r132 = addInv(r100[r129]);
        int r133 = r126 - 1;
        r101[r133] = mulInv(r100[r131]);
        int r134 = r133 - 1;
        r101[r134] = r132;
        int r135 = r134 - 1;
        r101[r135] = r130;
        r101[r135 - 1] = r128;
        return r101;
    }

    private int mul(int r100, int r101) {
        if (r100 != 0) goto L5;
        int r102 = 65537 - r101;
    L13:
        return r102 & 65535;
    L5:
        if (r101 != 0) goto L7;
        r102 = 65537 - r100;
        goto L13
    L7:
        int r103 = r100 * r101;
        int r104 = r103 & 65535;
        int r105 = r103 >>> 16;
        int r106 = r104 - r105;
        if (r104 >= r105) goto L10;
        int r107 = 1;
    L11:
        r102 = r106 + r107;
        goto L13
    L10:
        r107 = 0;
        goto L11
    }

    private int mulInv(int r100) {
        if (r100 >= 2) goto L5;
        return r100;
    L5:
        int r101 = 65537 / r100;
        int r102 = 65537 % r100;
        int r103 = 1;
    L7:
        if (r102 == 1) goto L13;
        int r104 = r100 / r102;
        r100 = r100 % r102;
        r103 = (r103 + (r104 * r101)) & 65535;
        if (r100 == 1) goto L10;
        int r105 = r102 / r100;
        r102 = r102 % r100;
        r101 = (r101 + (r105 * r103)) & 65535;
        goto L7
    L10:
        return r103;
    L13:
        return (1 - r101) & 65535;
    }

    private void wordToBytes(int r100, byte[] r101, int r102) {
        r101[r102] = (byte) (r100 >>> 8);
        r101[r102 + 1] = (byte) r100;
    }

    public int addInv(int r100) {
        return (0 - r100) & 65535;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "IDEA";
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 8;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean r100, CipherParameters r101) {
        if ((r101 instanceof KeyParameter) == false) goto L7;
        this.workingKey = generateWorkingKey(r100, ((KeyParameter) r101).getKey());
        return;
    L7:
        throw new IllegalArgumentException("invalid parameter passed to IDEA init - ".concat(r101.getClass().getName()));
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] r100, int r101, byte[] r102, int r110) {
        int[] r103 = this.workingKey;
        if (r103 == null) goto L15;
        if ((r101 + 8) > r100.length) goto L13;
        if ((r110 + 8) > r102.length) goto L11;
        ideaFunc(r103, r100, r101, r102, r110);
        return 8;
    L11:
        throw new OutputLengthException("output buffer too short");
    L13:
        throw new DataLengthException("input buffer too short");
    L15:
        throw new IllegalStateException("IDEA engine not initialised");
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
    }
}
