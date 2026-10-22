package org.bouncycastle.crypto.engines;

import kotlin.UByte;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

/* JADX INFO: loaded from: classes42.dex */
public class Grain128Engine implements StreamCipher {
    private static final int STATE_SIZE = 4;
    private int index;
    private boolean initialised;
    private int[] lfsr;
    private int[] nfsr;
    private byte[] out;
    private int output;
    private byte[] workingIV;
    private byte[] workingKey;

    public Grain128Engine() {
        this.index = 4;
        this.initialised = false;
    }

    private byte getKeyStream() {
        if (this.index <= 3) goto L5;
        oneRound();
        this.index = 0;
    L5:
        byte[] r100 = this.out;
        int r101 = this.index;
        this.index = r101 + 1;
        return r100[r101];
    }

    private int getOutput() {
        int[] r100 = this.nfsr;
        int r101 = r100[0];
        int r102 = r100[1];
        int r103 = (r101 >>> 2) | (r102 << 30);
        int r104 = (r101 >>> 12) | (r102 << 20);
        int r105 = (r101 >>> 15) | (r102 << 17);
        int r110 = r100[2];
        int r106 = (r102 >>> 4) | (r110 << 28);
        int r107 = (r102 >>> 13) | (r110 << 19);
        int r108 = r100[3];
        int r111 = (r110 >>> 9) | (r108 << 23);
        int r112 = (r110 >>> 25) | (r108 << 7);
        int r109 = r108 << 1;
        int r113 = r109 | (r110 >>> 31);
        int[] r114 = this.lfsr;
        int r115 = r114[0];
        int r116 = r114[1];
        int r117 = (r115 >>> 8) | (r116 << 24);
        int r118 = (r115 >>> 13) | (r116 << 19);
        int r119 = (r115 >>> 20) | (r116 << 12);
        int r120 = r114[2];
        int r121 = (r116 >>> 10) | (r120 << 22);
        int r122 = (r116 >>> 28) | (r120 << 4);
        int r123 = r114[3];
        int r124 = (r120 >>> 15) | (r123 << 17);
        int r125 = (r120 >>> 29) | (r123 << 3);
        int r126 = r123 << 1;
        int r127 = r126 | (r120 >>> 31);
        int r128 = r118 & r119;
        int r129 = ((r128 ^ (r104 & r117)) ^ (r113 & r121)) ^ (r122 & r124);
        return ((((((((((r113 & r104) & r127) ^ r129) ^ r125) ^ r103) ^ r105) ^ r106) ^ r107) ^ r110) ^ r111) ^ r112;
    }

    private int getOutputLFSR() {
        int[] r100 = this.lfsr;
        int r101 = r100[0];
        int r102 = r100[1];
        int r103 = (r101 >>> 7) | (r102 << 25);
        int r104 = r100[2];
        int r105 = (r102 >>> 6) | (r104 << 26);
        int r106 = r100[3];
        int r107 = (r104 >>> 6) | (r106 << 26);
        int r108 = ((r101 ^ r103) ^ r105) ^ r107;
        return r106 ^ (r108 ^ ((r104 >>> 17) | (r106 << 15)));
    }

    private int getOutputNFSR() {
        int[] r100 = this.nfsr;
        int r101 = r100[0];
        int r102 = r100[1];
        int r103 = (r101 >>> 3) | (r102 << 29);
        int r104 = (r101 >>> 11) | (r102 << 21);
        int r105 = (r101 >>> 13) | (r102 << 19);
        int r106 = (r101 >>> 17) | (r102 << 15);
        int r107 = (r101 >>> 18) | (r102 << 14);
        int r108 = (r101 >>> 26) | (r102 << 6);
        int r110 = (r101 >>> 27) | (r102 << 5);
        int r111 = r100[2];
        int r112 = (r102 >>> 8) | (r111 << 24);
        int r113 = (r102 >>> 16) | (r111 << 16);
        int r114 = (r102 >>> 24) | (r111 << 8);
        int r115 = (r102 >>> 27) | (r111 << 5);
        int r109 = (r102 >>> 29) | (r111 << 3);
        int r116 = r100[3];
        int r117 = (r111 >>> 1) | (r116 << 31);
        int r118 = (r111 >>> 3) | (r116 << 29);
        int r119 = (r111 >>> 4) | (r116 << 28);
        int r120 = (r111 >>> 20) | (r116 << 12);
        int r121 = (r101 ^ r108) ^ r114;
        return (((((((r116 ^ (r121 ^ ((r111 >>> 27) | (r116 << 5)))) ^ (r103 & r118)) ^ (r104 & r105)) ^ (r106 & r107)) ^ (r110 & r115)) ^ (r112 & r113)) ^ (r109 & r117)) ^ (r119 & r120);
    }

    private void initGrain() {
        int r100 = 0;
    L4:
        if (r100 >= 8) goto L6;
        this.output = getOutput();
        this.nfsr = shift(this.nfsr, (getOutputNFSR() ^ this.lfsr[0]) ^ this.output);
        this.lfsr = shift(this.lfsr, getOutputLFSR() ^ this.output);
        r100 = r100 + 1;
        goto L4
    L6:
        this.initialised = true;
    }

    private void oneRound() {
        int r100 = getOutput();
        this.output = r100;
        byte[] r101 = this.out;
        r101[0] = (byte) r100;
        r101[1] = (byte) (r100 >> 8);
        r101[2] = (byte) (r100 >> 16);
        r101[3] = (byte) (r100 >> 24);
        this.nfsr = shift(this.nfsr, getOutputNFSR() ^ this.lfsr[0]);
        this.lfsr = shift(this.lfsr, getOutputLFSR());
    }

    private void setKey(byte[] r110, byte[] r111) {
        r111[12] = -1;
        r111[13] = -1;
        r111[14] = -1;
        r111[15] = -1;
        this.workingKey = r110;
        this.workingIV = r111;
        int r112 = 0;
        int r113 = 0;
    L3:
        int[] r100 = this.nfsr;
        if (r112 >= r100.length) goto L6;
        byte[] r101 = this.workingKey;
        int r102 = r113 + 3;
        int r103 = r113 + 2;
        int r104 = (r101[r102] << 24) | ((r101[r103] << 16) & 16711680);
        int r105 = r113 + 1;
        int r106 = r104 | ((r101[r105] << 8) & 65280);
        r100[r112] = (r101[r113] & UByte.MAX_VALUE) | r106;
        int[] r107 = this.lfsr;
        byte[] r108 = this.workingIV;
        int r109 = ((r108[r102] << 24) | ((r108[r103] << 16) & 16711680)) | ((r108[r105] << 8) & 65280);
        r107[r112] = (r108[r113] & UByte.MAX_VALUE) | r109;
        r113 = r113 + 4;
        r112 = r112 + 1;
        goto L3
    }

    private int[] shift(int[] r100, int r101) {
        r100[0] = r100[1];
        r100[1] = r100[2];
        r100[2] = r100[3];
        r100[3] = r101;
        return r100;
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public String getAlgorithmName() {
        return "Grain-128";
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public void init(boolean r100, CipherParameters r101) throws IllegalArgumentException {
        if ((r101 instanceof ParametersWithIV) == false) goto L17;
        ParametersWithIV r102 = (ParametersWithIV) r101;
        byte[] r103 = r102.getIV();
        if (r103 == null) goto L15;
        if (r103.length != 12) goto L15;
        if ((r102.getParameters() instanceof KeyParameter) == false) goto L13;
        KeyParameter r104 = (KeyParameter) r102.getParameters();
        this.workingIV = new byte[r104.getKey().length];
        this.workingKey = new byte[r104.getKey().length];
        this.lfsr = new int[4];
        this.nfsr = new int[4];
        this.out = new byte[4];
        System.arraycopy(r103, 0, this.workingIV, 0, r103.length);
        System.arraycopy(r104.getKey(), 0, this.workingKey, 0, r104.getKey().length);
        reset();
        return;
    L13:
        throw new IllegalArgumentException("Grain-128 Init parameters must include a key");
    L15:
        throw new IllegalArgumentException("Grain-128  requires exactly 12 bytes of IV");
    L17:
        throw new IllegalArgumentException("Grain-128 Init parameters must include an IV");
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public int processBytes(byte[] r100, int r101, int r102, byte[] r103, int r104) throws DataLengthException {
        if (this.initialised == false) goto L17;
        if ((r101 + r102) > r100.length) goto L15;
        if ((r104 + r102) > r103.length) goto L13;
        int r105 = 0;
    L9:
        if (r105 >= r102) goto L11;
        r103[r104 + r105] = (byte) (r100[r101 + r105] ^ getKeyStream());
        r105 = r105 + 1;
        goto L9
    L11:
        return r102;
    L13:
        throw new OutputLengthException("output buffer too short");
    L15:
        throw new DataLengthException("input buffer too short");
    L17:
        throw new IllegalStateException(getAlgorithmName() + " not initialised");
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public void reset() {
        this.index = 4;
        setKey(this.workingKey, this.workingIV);
        initGrain();
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public byte returnByte(byte r100) {
        if (this.initialised == false) goto L7;
        return (byte) (r100 ^ getKeyStream());
    L7:
        throw new IllegalStateException(getAlgorithmName() + " not initialised");
    }
}
