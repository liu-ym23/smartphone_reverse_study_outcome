package org.bouncycastle.crypto.engines;

import com.obric.sva.sdk.data.ISmModel;
import kotlin.UByte;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

/* JADX INFO: loaded from: classes42.dex */
public class HC128Engine implements StreamCipher {
    private byte[] buf;
    private int cnt;
    private int idx;
    private boolean initialised;

    /* JADX INFO: renamed from: iv, reason: collision with root package name */
    private byte[] f525184iv;
    private byte[] key;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int[] f525185p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int[] f525186q;

    public HC128Engine() {
        this.f525185p = new int[512];
        this.f525186q = new int[512];
        this.cnt = 0;
        this.buf = new byte[4];
        this.idx = 0;
    }

    private static int dim(int r100, int r101) {
        return mod512(r100 - r101);
    }

    private static int f1(int r100) {
        int r101 = rotateRight(r100, 7) ^ rotateRight(r100, 18);
        return (r100 >>> 3) ^ r101;
    }

    private static int f2(int r100) {
        int r101 = rotateRight(r100, 17) ^ rotateRight(r100, 19);
        return (r100 >>> 10) ^ r101;
    }

    private int g1(int r100, int r101, int r102) {
        return (rotateRight(r100, 10) ^ rotateRight(r102, 23)) + rotateRight(r101, 8);
    }

    private int g2(int r100, int r101, int r102) {
        return (rotateLeft(r100, 10) ^ rotateLeft(r102, 23)) + rotateLeft(r101, 8);
    }

    private byte getByte() {
        if (this.idx != 0) goto L5;
        int r100 = step();
        byte[] r101 = this.buf;
        r101[0] = (byte) (r100 & 255);
        int r102 = r100 >> 8;
        r101[1] = (byte) (r102 & 255);
        int r103 = r102 >> 8;
        r101[2] = (byte) (r103 & 255);
        r101[3] = (byte) ((r103 >> 8) & 255);
    L5:
        byte[] r104 = this.buf;
        int r105 = this.idx;
        byte r106 = r104[r105];
        this.idx = 3 & (r105 + 1);
        return r106;
    }

    private int h1(int r100) {
        int[] r101 = this.f525186q;
        return r101[r100 & 255] + r101[((r100 >> 16) & 255) + 256];
    }

    private int h2(int r100) {
        int[] r101 = this.f525185p;
        return r101[r100 & 255] + r101[((r100 >> 16) & 255) + 256];
    }

    private void init() {
        int r100 = 16;
        if (this.key.length != 16) goto L25;
        this.idx = 0;
        this.cnt = 0;
        int[] r101 = new int[1280];
        int r102 = 0;
    L6:
        if (r102 >= 16) goto L8;
        int r103 = r102 >> 2;
        r101[r103] = ((this.key[r102] & UByte.MAX_VALUE) << ((r102 & 3) * 8)) | r101[r103];
        r102 = r102 + 1;
        goto L6
    L8:
        System.arraycopy(r101, 0, r101, 4, 4);
        int r104 = 0;
    L9:
        byte[] r105 = this.f525184iv;
        if (r104 >= r105.length) goto L13;
        if (r104 >= 16) goto L13;
        int r106 = (r104 >> 2) + 8;
        r101[r106] = ((r105[r104] & UByte.MAX_VALUE) << ((r104 & 3) * 8)) | r101[r106];
        r104 = r104 + 1;
    L13:
        System.arraycopy(r101, 8, r101, 12, 4);
    L14:
        if (r100 >= 1280) goto L16;
        r101[r100] = (((f2(r101[r100 - 2]) + r101[r100 - 7]) + f1(r101[r100 - 15])) + r101[r100 - 16]) + r100;
        r100 = r100 + 1;
        goto L14
    L16:
        System.arraycopy(r101, 256, this.f525185p, 0, 512);
        System.arraycopy(r101, ISmModel.VERSION_0300, this.f525186q, 0, 512);
        int r107 = 0;
    L17:
        if (r107 >= 512) goto L19;
        this.f525185p[r107] = step();
        r107 = r107 + 1;
        goto L17
    L19:
        int r108 = 0;
    L20:
        if (r108 >= 512) goto L22;
        this.f525186q[r108] = step();
        r108 = r108 + 1;
        goto L20
    L22:
        this.cnt = 0;
        return;
    L25:
        throw new IllegalArgumentException("The key must be 128 bits long");
    }

    private static int mod1024(int r100) {
        return r100 & 1023;
    }

    private static int mod512(int r100) {
        return r100 & 511;
    }

    private static int rotateLeft(int r100, int r101) {
        int r102 = r100 << r101;
        return (r100 >>> (-r101)) | r102;
    }

    private static int rotateRight(int r100, int r101) {
        int r102 = r100 >>> r101;
        return (r100 << (-r101)) | r102;
    }

    private int step() {
        int r100 = mod512(this.cnt);
        if (this.cnt >= 512) goto L5;
        int[] r101 = this.f525185p;
        r101[r100] = r101[r100] + g1(r101[dim(r100, 3)], this.f525185p[dim(r100, 10)], this.f525185p[dim(r100, 511)]);
        int r102 = h1(this.f525185p[dim(r100, 12)]);
        int r103 = this.f525185p[r100];
    L6:
        int r104 = r103 ^ r102;
        this.cnt = mod1024(this.cnt + 1);
        return r104;
    L5:
        int[] r105 = this.f525186q;
        r105[r100] = r105[r100] + g2(r105[dim(r100, 3)], this.f525186q[dim(r100, 10)], this.f525186q[dim(r100, 511)]);
        r102 = h2(this.f525186q[dim(r100, 12)]);
        r103 = this.f525186q[r100];
        goto L6
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public String getAlgorithmName() {
        return "HC-128";
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public void init(boolean r100, CipherParameters r101) throws IllegalArgumentException {
        if ((r101 instanceof ParametersWithIV) == false) goto L5;
        ParametersWithIV r102 = (ParametersWithIV) r101;
        this.f525184iv = r102.getIV();
        CipherParameters r103 = r102.getParameters();
    L7:
        if ((r103 instanceof KeyParameter) == false) goto L11;
        this.key = ((KeyParameter) r103).getKey();
        init();
        this.initialised = true;
        return;
    L11:
        throw new IllegalArgumentException("Invalid parameter passed to HC128 init - ".concat(r101.getClass().getName()));
    L5:
        this.f525184iv = new byte[0];
        r103 = r101;
        goto L7
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public int processBytes(byte[] r100, int r101, int r102, byte[] r103, int r104) throws DataLengthException {
        if (this.initialised == false) goto L17;
        if ((r101 + r102) > r100.length) goto L15;
        if ((r104 + r102) > r103.length) goto L13;
        int r105 = 0;
    L9:
        if (r105 >= r102) goto L11;
        r103[r104 + r105] = (byte) (r100[r101 + r105] ^ getByte());
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
        init();
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public byte returnByte(byte r100) {
        return (byte) (r100 ^ getByte());
    }
}
