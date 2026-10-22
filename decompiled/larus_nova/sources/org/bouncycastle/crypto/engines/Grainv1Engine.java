package org.bouncycastle.crypto.engines;

import kotlin.UByte;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

/* JADX INFO: loaded from: classes42.dex */
public class Grainv1Engine implements StreamCipher {
    private static final int STATE_SIZE = 5;
    private int index;
    private boolean initialised;
    private int[] lfsr;
    private int[] nfsr;
    private byte[] out;
    private int output;
    private byte[] workingIV;
    private byte[] workingKey;

    public Grainv1Engine() {
        this.index = 2;
        this.initialised = false;
    }

    private byte getKeyStream() {
        if (this.index <= 1) goto L5;
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
        int r103 = (r101 >>> 1) | (r102 << 15);
        int r104 = (r101 >>> 2) | (r102 << 14);
        int r105 = (r101 >>> 4) | (r102 << 12);
        int r106 = (r101 >>> 10) | (r102 << 6);
        int r110 = r100[2];
        int r107 = (r102 >>> 15) | (r110 << 1);
        int r111 = r100[3];
        int r112 = (r110 >>> 11) | (r111 << 5);
        int r108 = r100[4];
        int r113 = (r111 >>> 8) | (r108 << 8);
        int r109 = r108 << 1;
        int r114 = r109 | (r111 >>> 15);
        int[] r115 = this.lfsr;
        int r116 = r115[0] >>> 3;
        int r117 = r115[1];
        int r118 = r116 | (r117 << 13);
        int r119 = r115[2];
        int r120 = (r117 >>> 9) | (r119 << 7);
        int r121 = r115[3] << 2;
        int r122 = r121 | (r119 >>> 14);
        int r123 = r115[4];
        int r124 = (r120 ^ r114) ^ (r118 & r123);
        int r125 = r122 & r123;
        int r126 = ((r124 ^ r125) ^ (r123 & r114)) ^ ((r118 & r120) & r122);
        int r127 = r118 & r122;
        int r128 = (r123 & r127) ^ r126;
        int r129 = ((r127 & r114) ^ r128) ^ ((r120 & r122) & r114);
        return (((((((((r114 & r125) ^ r129) ^ r103) ^ r104) ^ r105) ^ r106) ^ r107) ^ r112) ^ r113) & 65535;
    }

    private int getOutputLFSR() {
        int[] r100 = this.lfsr;
        int r101 = r100[0];
        int r102 = r100[1];
        int r103 = (r101 >>> 13) | (r102 << 3);
        int r104 = r100[2];
        int r105 = (r102 >>> 7) | (r104 << 9);
        int r106 = r100[3];
        int r107 = (r104 >>> 6) | (r106 << 10);
        int r108 = r100[4];
        int r109 = (r106 >>> 3) | (r108 << 13);
        int r110 = r108 << 2;
        return ((r110 | (r106 >>> 14)) ^ ((((r101 ^ r103) ^ r105) ^ r107) ^ r109)) & 65535;
    }

    private int getOutputNFSR() {
        int[] r100 = this.nfsr;
        int r101 = r100[0];
        int r102 = r100[1];
        int r103 = (r101 >>> 9) | (r102 << 7);
        int r104 = (r101 >>> 14) | (r102 << 2);
        int r105 = (r101 >>> 15) | (r102 << 1);
        int r106 = r100[2];
        int r107 = (r102 >>> 5) | (r106 << 11);
        int r108 = (r102 >>> 12) | (r106 << 4);
        int r110 = r100[3];
        int r111 = (r106 >>> 1) | (r110 << 15);
        int r112 = (r106 >>> 5) | (r110 << 11);
        int r109 = (r106 >>> 13) | (r110 << 3);
        int r113 = r100[4];
        int r114 = (r110 >>> 4) | (r113 << 12);
        int r115 = (r110 >>> 12) | (r113 << 4);
        int r116 = (r110 >>> 14) | (r113 << 2);
        int r117 = r113 << 1;
        int r118 = r117 | (r110 >>> 15);
        int r119 = r101 ^ (((((((((r116 ^ r115) ^ r114) ^ r109) ^ r112) ^ r111) ^ r108) ^ r107) ^ r104) ^ r103);
        int r120 = r118 & r115;
        int r121 = ((r119 ^ r120) ^ (r112 & r111)) ^ (r105 & r103);
        int r122 = r115 & r114;
        int r123 = r121 ^ (r122 & r109);
        int r124 = (r111 & r108) & r107;
        int r125 = ((r118 & r109) & r108) & r103;
        return ((((((r125 ^ (r123 ^ r124)) ^ ((r122 & r112) & r111)) ^ ((r120 & r107) & r105)) ^ (((r120 & r114) & r109) & r112)) ^ ((r124 & r105) & r103)) ^ (((((r114 & r109) & r112) & r111) & r108) & r107)) & 65535;
    }

    private void initGrain() {
        int r100 = 0;
    L4:
        if (r100 >= 10) goto L6;
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
        this.nfsr = shift(this.nfsr, getOutputNFSR() ^ this.lfsr[0]);
        this.lfsr = shift(this.lfsr, getOutputLFSR());
    }

    private void setKey(byte[] r100, byte[] r101) {
        r101[8] = -1;
        r101[9] = -1;
        this.workingKey = r100;
        this.workingIV = r101;
        int r102 = 0;
        int r103 = 0;
    L3:
        int[] r104 = this.nfsr;
        if (r102 >= r104.length) goto L6;
        byte[] r105 = this.workingKey;
        int r106 = r103 + 1;
        int r107 = r105[r106] << 8;
        r104[r102] = ((r105[r103] & UByte.MAX_VALUE) | r107) & 65535;
        int[] r108 = this.lfsr;
        byte[] r109 = this.workingIV;
        int r110 = r109[r106] << 8;
        r108[r102] = ((r109[r103] & UByte.MAX_VALUE) | r110) & 65535;
        r103 = r103 + 2;
        r102 = r102 + 1;
        goto L3
    }

    private int[] shift(int[] r100, int r101) {
        r100[0] = r100[1];
        r100[1] = r100[2];
        r100[2] = r100[3];
        r100[3] = r100[4];
        r100[4] = r101;
        return r100;
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public String getAlgorithmName() {
        return "Grain v1";
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public void init(boolean r100, CipherParameters r101) throws IllegalArgumentException {
        if ((r101 instanceof ParametersWithIV) == false) goto L17;
        ParametersWithIV r102 = (ParametersWithIV) r101;
        byte[] r103 = r102.getIV();
        if (r103 == null) goto L15;
        if (r103.length != 8) goto L15;
        if ((r102.getParameters() instanceof KeyParameter) == false) goto L13;
        KeyParameter r104 = (KeyParameter) r102.getParameters();
        this.workingIV = new byte[r104.getKey().length];
        this.workingKey = new byte[r104.getKey().length];
        this.lfsr = new int[5];
        this.nfsr = new int[5];
        this.out = new byte[2];
        System.arraycopy(r103, 0, this.workingIV, 0, r103.length);
        System.arraycopy(r104.getKey(), 0, this.workingKey, 0, r104.getKey().length);
        reset();
        return;
    L13:
        throw new IllegalArgumentException("Grain v1 Init parameters must include a key");
    L15:
        throw new IllegalArgumentException("Grain v1 requires exactly 8 bytes of IV");
    L17:
        throw new IllegalArgumentException("Grain v1 Init parameters must include an IV");
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
        this.index = 2;
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
