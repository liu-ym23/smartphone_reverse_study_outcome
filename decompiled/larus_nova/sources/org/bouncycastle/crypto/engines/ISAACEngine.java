package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class ISAACEngine implements StreamCipher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f525191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f525192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f525193c;
    private int[] engineState;
    private int index;
    private boolean initialised;
    private byte[] keyStream;
    private int[] results;
    private final int sizeL;
    private final int stateArraySize;
    private byte[] workingKey;

    public ISAACEngine() {
        this.sizeL = 8;
        this.stateArraySize = 256;
        this.engineState = null;
        this.results = null;
        this.f525191a = 0;
        this.f525192b = 0;
        this.f525193c = 0;
        this.index = 0;
        this.keyStream = new byte[1024];
        this.workingKey = null;
        this.initialised = false;
    }

    private void isaac() {
        int r100 = this.f525192b;
        int r101 = this.f525193c + 1;
        this.f525193c = r101;
        this.f525192b = r100 + r101;
        int r102 = 0;
    L4:
        if (r102 >= 256) goto L19;
        int[] r103 = this.engineState;
        int r104 = r103[r102];
        int r105 = r102 & 3;
        if (r105 == 0) goto L16;
        if (r105 != 1) goto L9;
        int r106 = this.f525191a;
        int r107 = r106 >>> 6;
    L17:
        this.f525191a = r106 ^ r107;
    L18:
        int r108 = this.f525191a + r103[(r102 + 128) & 255];
        this.f525191a = r108;
        int r109 = (r103[(r104 >>> 2) & 255] + r108) + this.f525192b;
        r103[r102] = r109;
        int[] r110 = this.results;
        int r111 = r103[(r109 >>> 10) & 255] + r104;
        this.f525192b = r111;
        r110[r102] = r111;
        r102 = r102 + 1;
        goto L4
    L9:
        if (r105 != 2) goto L11;
        r106 = this.f525191a;
        r107 = r106 << 2;
        goto L17
    L11:
        if (r105 != 3) goto L18;
        r106 = this.f525191a;
        r107 = r106 >>> 16;
        goto L17
    L16:
        r106 = this.f525191a;
        r107 = r106 << 13;
        goto L17
    }

    private void mix(int[] r110) {
        int r100 = r110[0];
        int r101 = r110[1];
        int r102 = r100 ^ (r101 << 11);
        r110[0] = r102;
        int r103 = r110[3] + r102;
        r110[3] = r103;
        int r104 = r110[2];
        int r105 = r101 + r104;
        r110[1] = r105;
        int r106 = r105 ^ (r104 >>> 2);
        r110[1] = r106;
        int r107 = r110[4] + r106;
        r110[4] = r107;
        int r108 = r104 + r103;
        r110[2] = r108;
        int r109 = r108 ^ (r103 << 8);
        r110[2] = r109;
        int r111 = r110[5] + r109;
        r110[5] = r111;
        int r112 = r103 + r107;
        r110[3] = r112;
        int r113 = r112 ^ (r107 >>> 16);
        r110[3] = r113;
        int r114 = r110[6] + r113;
        r110[6] = r114;
        int r115 = r107 + r111;
        r110[4] = r115;
        int r116 = (r111 << 10) ^ r115;
        r110[4] = r116;
        int r117 = r110[7] + r116;
        r110[7] = r117;
        int r118 = r111 + r114;
        r110[5] = r118;
        int r119 = (r114 >>> 4) ^ r118;
        r110[5] = r119;
        int r120 = r102 + r119;
        r110[0] = r120;
        int r121 = r114 + r117;
        r110[6] = r121;
        int r122 = (r117 << 8) ^ r121;
        r110[6] = r122;
        int r123 = r106 + r122;
        r110[1] = r123;
        int r124 = r117 + r120;
        r110[7] = r124;
        int r125 = (r120 >>> 9) ^ r124;
        r110[7] = r125;
        r110[2] = r109 + r125;
        r110[0] = r120 + r123;
    }

    private void setKey(byte[] r110) {
        this.workingKey = r110;
        if (this.engineState != null) goto L6;
        this.engineState = new int[256];
    L6:
        if (this.results != null) goto L8;
        this.results = new int[256];
    L8:
        int r100 = 0;
    L9:
        if (r100 >= 256) goto L11;
        int[] r101 = this.engineState;
        this.results[r100] = 0;
        r101[r100] = 0;
        r100 = r100 + 1;
        goto L9
    L11:
        this.f525193c = 0;
        this.f525192b = 0;
        this.f525191a = 0;
        this.index = 0;
        int r102 = r110.length + (r110.length & 3);
        byte[] r103 = new byte[r102];
        System.arraycopy(r110, 0, r103, 0, r110.length);
        int r111 = 0;
    L12:
        if (r111 >= r102) goto L14;
        this.results[r111 >>> 2] = Pack.littleEndianToInt(r103, r111);
        r111 = r111 + 4;
        goto L12
    L14:
        int[] r104 = new int[8];
        int r105 = 0;
    L15:
        if (r105 >= 8) goto L17;
        r104[r105] = -1640531527;
        r105 = r105 + 1;
        goto L15
    L17:
        int r106 = 0;
    L19:
        if (r106 >= 4) goto L21;
        mix(r104);
        r106 = r106 + 1;
        goto L19
    L21:
        int r107 = 0;
    L23:
        if (r107 >= 2) goto L38;
        int r108 = 0;
    L25:
        if (r108 >= 256) goto L37;
        int r109 = 0;
    L27:
        if (r109 >= 8) goto L33;
        int r112 = r104[r109];
        if (r107 >= 1) goto L31;
        int r113 = this.results[r108 + r109];
    L32:
        r104[r109] = r112 + r113;
        r109 = r109 + 1;
        goto L27
    L31:
        r113 = this.engineState[r108 + r109];
        goto L32
    L33:
        mix(r104);
        int r114 = 0;
    L34:
        if (r114 >= 8) goto L36;
        this.engineState[r108 + r114] = r104[r114];
        r114 = r114 + 1;
        goto L34
    L36:
        r108 = r108 + 8;
        goto L25
    L37:
        r107 = r107 + 1;
        goto L23
    L38:
        isaac();
        this.initialised = true;
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public String getAlgorithmName() {
        return "ISAAC";
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public void init(boolean r100, CipherParameters r101) {
        if ((r101 instanceof KeyParameter) == false) goto L7;
        setKey(((KeyParameter) r101).getKey());
        return;
    L7:
        throw new IllegalArgumentException("invalid parameter passed to ISAAC init - ".concat(r101.getClass().getName()));
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public int processBytes(byte[] r100, int r101, int r102, byte[] r103, int r110) {
        if (this.initialised == false) goto L20;
        if ((r101 + r102) > r100.length) goto L18;
        if ((r110 + r102) > r103.length) goto L16;
        int r104 = 0;
    L9:
        if (r104 >= r102) goto L14;
        if (this.index != 0) goto L13;
        isaac();
        this.keyStream = Pack.intToBigEndian(this.results);
    L13:
        byte[] r105 = this.keyStream;
        int r106 = this.index;
        r103[r104 + r110] = (byte) (r105[r106] ^ r100[r104 + r101]);
        this.index = (r106 + 1) & 1023;
        r104 = r104 + 1;
        goto L9
    L14:
        return r102;
    L16:
        throw new OutputLengthException("output buffer too short");
    L18:
        throw new DataLengthException("input buffer too short");
    L20:
        throw new IllegalStateException(getAlgorithmName() + " not initialised");
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public void reset() {
        setKey(this.workingKey);
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public byte returnByte(byte r100) {
        if (this.index != 0) goto L5;
        isaac();
        this.keyStream = Pack.intToBigEndian(this.results);
    L5:
        byte[] r101 = this.keyStream;
        int r102 = this.index;
        byte r103 = (byte) (r100 ^ r101[r102]);
        this.index = (r102 + 1) & 1023;
        return r103;
    }
}
