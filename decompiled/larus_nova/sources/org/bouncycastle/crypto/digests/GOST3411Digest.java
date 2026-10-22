package org.bouncycastle.crypto.digests;

import java.lang.reflect.Array;
import kotlin.UByte;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.crypto.engines.GOST28147Engine;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithSBox;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class GOST3411Digest implements ExtendedDigest, Memoable {
    private static final byte[] C2 = null;
    private static final int DIGEST_LENGTH = 32;
    private byte[][] C;
    private byte[] H;
    private byte[] K;
    private byte[] L;
    private byte[] M;
    byte[] S;
    private byte[] Sum;
    byte[] U;
    byte[] V;
    byte[] W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    byte[] f525140a;
    private long byteCount;
    private BlockCipher cipher;
    private byte[] sBox;
    short[] wS;
    short[] w_S;
    private byte[] xBuf;
    private int xBufOff;

    static {
        C2 = new byte[]{0, -1, 0, -1, 0, -1, 0, -1, -1, 0, -1, 0, -1, 0, -1, 0, 0, -1, -1, 0, -1, 0, 0, -1, -1, 0, 0, 0, -1, -1, 0, -1};
    }

    public GOST3411Digest() {
        this.H = new byte[32];
        this.L = new byte[32];
        this.M = new byte[32];
        this.Sum = new byte[32];
        Class r100 = Byte.TYPE;
        this.C = (byte[][]) Array.newInstance(r100, new int[]{4, 32});
        this.xBuf = new byte[32];
        this.cipher = new GOST28147Engine();
        this.K = new byte[32];
        this.f525140a = new byte[8];
        this.wS = new short[16];
        this.w_S = new short[16];
        this.S = new byte[32];
        this.U = new byte[32];
        this.V = new byte[32];
        this.W = new byte[32];
        byte[] r101 = GOST28147Engine.getSBox("D-A");
        this.sBox = r101;
        this.cipher.init(true, new ParametersWithSBox(null, r101));
        reset();
    }

    public GOST3411Digest(GOST3411Digest r100) {
        this.H = new byte[32];
        this.L = new byte[32];
        this.M = new byte[32];
        this.Sum = new byte[32];
        Class r101 = Byte.TYPE;
        this.C = (byte[][]) Array.newInstance(r101, new int[]{4, 32});
        this.xBuf = new byte[32];
        this.cipher = new GOST28147Engine();
        this.K = new byte[32];
        this.f525140a = new byte[8];
        this.wS = new short[16];
        this.w_S = new short[16];
        this.S = new byte[32];
        this.U = new byte[32];
        this.V = new byte[32];
        this.W = new byte[32];
        reset(r100);
    }

    public GOST3411Digest(byte[] r100) {
        this.H = new byte[32];
        this.L = new byte[32];
        this.M = new byte[32];
        this.Sum = new byte[32];
        Class r101 = Byte.TYPE;
        this.C = (byte[][]) Array.newInstance(r101, new int[]{4, 32});
        this.xBuf = new byte[32];
        this.cipher = new GOST28147Engine();
        this.K = new byte[32];
        this.f525140a = new byte[8];
        this.wS = new short[16];
        this.w_S = new short[16];
        this.S = new byte[32];
        this.U = new byte[32];
        this.V = new byte[32];
        this.W = new byte[32];
        byte[] r102 = Arrays.clone(r100);
        this.sBox = r102;
        this.cipher.init(true, new ParametersWithSBox(null, r102));
        reset();
    }

    private byte[] A(byte[] r100) {
        int r101 = 0;
    L4:
        if (r101 >= 8) goto L6;
        this.f525140a[r101] = (byte) (r100[r101] ^ r100[r101 + 8]);
        r101 = r101 + 1;
        goto L4
    L6:
        System.arraycopy(r100, 8, r100, 0, 24);
        System.arraycopy(this.f525140a, 0, r100, 24, 8);
        return r100;
    }

    private void E(byte[] r100, byte[] r101, int r102, byte[] r103, int r104) {
        this.cipher.init(true, new KeyParameter(r100));
        this.cipher.processBlock(r103, r104, r101, r102);
    }

    private byte[] P(byte[] r100) {
        int r101 = 0;
    L4:
        if (r101 >= 8) goto L7;
        byte[] r102 = this.K;
        int r103 = r101 * 4;
        r102[r103] = r100[r101];
        r102[r103 + 1] = r100[r101 + 8];
        r102[r103 + 2] = r100[r101 + 16];
        r102[r103 + 3] = r100[r101 + 24];
        r101 = r101 + 1;
        goto L4
    L7:
        return this.K;
    }

    private void cpyBytesToShort(byte[] r100, short[] r101) {
        int r102 = 0;
    L4:
        if (r102 >= (r100.length / 2)) goto L6;
        int r103 = r102 * 2;
        int r104 = (r100[r103 + 1] << 8) & 65280;
        r101[r102] = (short) ((r100[r103] & UByte.MAX_VALUE) | r104);
        r102 = r102 + 1;
        goto L4
    }

    private void cpyShortToBytes(short[] r100, byte[] r101) {
        int r102 = 0;
    L4:
        if (r102 >= (r101.length / 2)) goto L6;
        int r103 = r102 * 2;
        short r104 = r100[r102];
        r101[r103 + 1] = (byte) (r104 >> 8);
        r101[r103] = (byte) r104;
        r102 = r102 + 1;
        goto L4
    }

    private void finish() {
        Pack.longToLittleEndian(this.byteCount * 8, this.L, 0);
    L4:
        if (this.xBufOff == 0) goto L6;
        update((byte) 0);
        goto L4
    L6:
        processBlock(this.L, 0);
        processBlock(this.Sum, 0);
    }

    private void fw(byte[] r100) {
        cpyBytesToShort(r100, this.wS);
        short[] r101 = this.w_S;
        short[] r102 = this.wS;
        r101[15] = (short) (((((r102[0] ^ r102[1]) ^ r102[2]) ^ r102[3]) ^ r102[12]) ^ r102[15]);
        System.arraycopy(r102, 1, r101, 0, 15);
        cpyShortToBytes(this.w_S, r100);
    }

    private void sumByteArray(byte[] r100) {
        int r101 = 0;
        int r102 = 0;
    L3:
        byte[] r103 = this.Sum;
        if (r101 == r103.length) goto L6;
        int r104 = ((r103[r101] & UByte.MAX_VALUE) + (r100[r101] & UByte.MAX_VALUE)) + r102;
        r103[r101] = (byte) r104;
        r102 = r104 >>> 8;
        r101 = r101 + 1;
        goto L3
    }

    @Override // org.bouncycastle.util.Memoable
    public Memoable copy() {
        return new GOST3411Digest(this);
    }

    @Override // org.bouncycastle.crypto.Digest
    public int doFinal(byte[] r100, int r101) {
        finish();
        byte[] r102 = this.H;
        System.arraycopy(r102, 0, r100, r101, r102.length);
        reset();
        return 32;
    }

    @Override // org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return "GOST3411";
    }

    @Override // org.bouncycastle.crypto.ExtendedDigest
    public int getByteLength() {
        return 32;
    }

    @Override // org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return 32;
    }

    public void processBlock(byte[] r110, int r111) {
        System.arraycopy(r110, r111, this.M, 0, 32);
        System.arraycopy(this.H, 0, this.U, 0, 32);
        System.arraycopy(this.M, 0, this.V, 0, 32);
        int r112 = 0;
    L3:
        if (r112 >= 32) goto L5;
        this.W[r112] = (byte) (this.U[r112] ^ this.V[r112]);
        r112 = r112 + 1;
        goto L3
    L5:
        E(P(this.W), this.S, 0, this.H, 0);
        int r113 = 1;
    L7:
        if (r113 >= 4) goto L15;
        byte[] r114 = A(this.U);
        int r100 = 0;
    L9:
        if (r100 >= 32) goto L11;
        this.U[r100] = (byte) (r114[r100] ^ this.C[r113][r100]);
        r100 = r100 + 1;
        goto L9
    L11:
        this.V = A(A(this.V));
        int r115 = 0;
    L12:
        if (r115 >= 32) goto L14;
        this.W[r115] = (byte) (this.U[r115] ^ this.V[r115]);
        r115 = r115 + 1;
        goto L12
    L14:
        int r101 = r113 * 8;
        E(P(this.W), this.S, r101, this.H, r101);
        r113 = r113 + 1;
        goto L7
    L15:
        int r116 = 0;
    L17:
        if (r116 >= 12) goto L19;
        fw(this.S);
        r116 = r116 + 1;
        goto L17
    L19:
        int r117 = 0;
    L20:
        if (r117 >= 32) goto L22;
        byte[] r118 = this.S;
        r118[r117] = (byte) (r118[r117] ^ this.M[r117]);
        r117 = r117 + 1;
        goto L20
    L22:
        fw(this.S);
        int r119 = 0;
    L23:
        if (r119 >= 32) goto L25;
        byte[] r120 = this.S;
        r120[r119] = (byte) (this.H[r119] ^ r120[r119]);
        r119 = r119 + 1;
        goto L23
    L25:
        int r121 = 0;
    L27:
        if (r121 >= 61) goto L29;
        fw(this.S);
        r121 = r121 + 1;
        goto L27
    L29:
        byte[] r122 = this.S;
        byte[] r123 = this.H;
        System.arraycopy(r122, 0, r123, 0, r123.length);
    }

    @Override // org.bouncycastle.crypto.Digest
    public void reset() {
        this.byteCount = 0;
        this.xBufOff = 0;
        int r100 = 0;
    L3:
        byte[] r101 = this.H;
        if (r100 >= r101.length) goto L6;
        r101[r100] = 0;
        r100 = r100 + 1;
        goto L3
    L6:
        int r102 = 0;
    L7:
        byte[] r103 = this.L;
        if (r102 >= r103.length) goto L10;
        r103[r102] = 0;
        r102 = r102 + 1;
        goto L7
    L10:
        int r104 = 0;
    L11:
        byte[] r105 = this.M;
        if (r104 >= r105.length) goto L14;
        r105[r104] = 0;
        r104 = r104 + 1;
        goto L11
    L14:
        int r106 = 0;
    L15:
        byte[] r107 = this.C[1];
        if (r106 >= r107.length) goto L18;
        r107[r106] = 0;
        r106 = r106 + 1;
        goto L15
    L18:
        int r108 = 0;
    L19:
        byte[] r109 = this.C[3];
        if (r108 >= r109.length) goto L22;
        r109[r108] = 0;
        r108 = r108 + 1;
        goto L19
    L22:
        int r110 = 0;
    L23:
        byte[] r111 = this.Sum;
        if (r110 >= r111.length) goto L26;
        r111[r110] = 0;
        r110 = r110 + 1;
        goto L23
    L26:
        int r112 = 0;
    L27:
        byte[] r113 = this.xBuf;
        if (r112 >= r113.length) goto L30;
        r113[r112] = 0;
        r112 = r112 + 1;
        goto L27
    L30:
        byte[] r114 = C2;
        System.arraycopy(r114, 0, this.C[2], 0, r114.length);
    }

    @Override // org.bouncycastle.util.Memoable
    public void reset(Memoable r100) {
        GOST3411Digest r101 = (GOST3411Digest) r100;
        byte[] r102 = r101.sBox;
        this.sBox = r102;
        this.cipher.init(true, new ParametersWithSBox(null, r102));
        reset();
        byte[] r103 = r101.H;
        System.arraycopy(r103, 0, this.H, 0, r103.length);
        byte[] r104 = r101.L;
        System.arraycopy(r104, 0, this.L, 0, r104.length);
        byte[] r105 = r101.M;
        System.arraycopy(r105, 0, this.M, 0, r105.length);
        byte[] r106 = r101.Sum;
        System.arraycopy(r106, 0, this.Sum, 0, r106.length);
        byte[] r107 = r101.C[1];
        System.arraycopy(r107, 0, this.C[1], 0, r107.length);
        byte[] r108 = r101.C[2];
        System.arraycopy(r108, 0, this.C[2], 0, r108.length);
        byte[] r109 = r101.C[3];
        System.arraycopy(r109, 0, this.C[3], 0, r109.length);
        byte[] r110 = r101.xBuf;
        System.arraycopy(r110, 0, this.xBuf, 0, r110.length);
        this.xBufOff = r101.xBufOff;
        this.byteCount = r101.byteCount;
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte r100) {
        byte[] r101 = this.xBuf;
        int r102 = this.xBufOff;
        int r103 = r102 + 1;
        this.xBufOff = r103;
        r101[r102] = r100;
        if (r103 != r101.length) goto L5;
        sumByteArray(r101);
        processBlock(this.xBuf, 0);
        this.xBufOff = 0;
    L5:
        this.byteCount++;
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte[] r100, int r101, int r102) {
    L3:
        if (this.xBufOff == 0) goto L6;
        if (r102 <= 0) goto L6;
        update(r100[r101]);
        r101 = r101 + 1;
        r102 = r102 - 1;
    L6:
        byte[] r103 = this.xBuf;
        if (r102 <= r103.length) goto L9;
        System.arraycopy(r100, r101, r103, 0, r103.length);
        sumByteArray(this.xBuf);
        processBlock(this.xBuf, 0);
        byte[] r104 = this.xBuf;
        r101 = r101 + r104.length;
        r102 = r102 - r104.length;
        this.byteCount += (long) r104.length;
    L9:
        if (r102 <= 0) goto L11;
        update(r100[r101]);
        r101 = r101 + 1;
        r102 = r102 - 1;
        goto L9
    }
}
