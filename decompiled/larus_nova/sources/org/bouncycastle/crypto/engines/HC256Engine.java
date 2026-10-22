package org.bouncycastle.crypto.engines;

import com.obric.sva.sdk.data.ISmModel;
import com.ss.android.ttvecamera.TECameraUtils;
import kotlin.UByte;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

/* JADX INFO: loaded from: classes42.dex */
public class HC256Engine implements StreamCipher {
    private byte[] buf;
    private int cnt;
    private int idx;
    private boolean initialised;

    /* JADX INFO: renamed from: iv, reason: collision with root package name */
    private byte[] f525187iv;
    private byte[] key;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int[] f525188p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int[] f525189q;

    public HC256Engine() {
        this.f525188p = new int[1024];
        this.f525189q = new int[1024];
        this.cnt = 0;
        this.buf = new byte[4];
        this.idx = 0;
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

    private void init() {
        byte[] r100 = this.key;
        int r101 = 16;
        if (r100.length == 32) goto L10;
        if (r100.length == 16) goto L10;
        throw new IllegalArgumentException("The key must be 128/256 bits long");
    L10:
        if (this.f525187iv.length < 16) goto L32;
        if (r100.length == 32) goto L14;
        byte[] r102 = new byte[32];
        System.arraycopy(r100, 0, r102, 0, r100.length);
        byte[] r103 = this.key;
        System.arraycopy(r103, 0, r102, 16, r103.length);
        this.key = r102;
    L14:
        byte[] r104 = this.f525187iv;
        if (r104.length >= 32) goto L17;
        byte[] r105 = new byte[32];
        System.arraycopy(r104, 0, r105, 0, r104.length);
        byte[] r106 = this.f525187iv;
        System.arraycopy(r106, 0, r105, r106.length, 32 - r106.length);
        this.f525187iv = r105;
    L17:
        this.idx = 0;
        this.cnt = 0;
        int[] r107 = new int[TECameraUtils.CAPTURE_HQ_2X];
        int r108 = 0;
    L18:
        if (r108 >= 32) goto L20;
        int r109 = r108 >> 2;
        r107[r109] = r107[r109] | ((this.key[r108] & UByte.MAX_VALUE) << ((r108 & 3) * 8));
        r108 = r108 + 1;
        goto L18
    L20:
        int r110 = 0;
    L21:
        if (r110 >= 32) goto L23;
        int r111 = (r110 >> 2) + 8;
        r107[r111] = r107[r111] | ((this.f525187iv[r110] & UByte.MAX_VALUE) << ((r110 & 3) * 8));
        r110 = r110 + 1;
    L23:
        if (r101 >= 2560) goto L25;
        int r112 = r107[r101 - 2];
        int r113 = r107[r101 - 15];
        r107[r101] = (((((r112 >>> 10) ^ (rotateRight(r112, 17) ^ rotateRight(r112, 19))) + r107[r101 - 7]) + ((r113 >>> 3) ^ (rotateRight(r113, 7) ^ rotateRight(r113, 18)))) + r107[r101 - 16]) + r101;
        r101 = r101 + 1;
        goto L23
    L25:
        System.arraycopy(r107, 512, this.f525188p, 0, 1024);
        System.arraycopy(r107, ISmModel.VERSION_0600, this.f525189q, 0, 1024);
        int r114 = 0;
    L27:
        if (r114 >= 4096) goto L29;
        step();
        r114 = r114 + 1;
        goto L27
    L29:
        this.cnt = 0;
        return;
    L32:
        throw new IllegalArgumentException("The IV must be at least 128 bits long");
    }

    private static int rotateRight(int r100, int r101) {
        int r102 = r100 >>> r101;
        return (r100 << (-r101)) | r102;
    }

    private int step() {
        int r100 = this.cnt;
        int r101 = r100 & 1023;
        if (r100 >= 1024) goto L5;
        int[] r102 = this.f525188p;
        int r103 = r102[(r101 - 3) & 1023];
        int r104 = r102[(r101 - 1023) & 1023];
        int r105 = r102[r101];
        int r106 = r102[(r101 - 10) & 1023] + (rotateRight(r104, 23) ^ rotateRight(r103, 10));
        int[] r107 = this.f525189q;
        r102[r101] = r105 + (r106 + r107[(r103 ^ r104) & 1023]);
        int[] r108 = this.f525188p;
        int r109 = r108[(r101 - 12) & 1023];
        int r110 = ((r107[r109 & 255] + r107[((r109 >> 8) & 255) + 256]) + r107[((r109 >> 16) & 255) + 512]) + r107[((r109 >> 24) & 255) + ISmModel.VERSION_0300];
        int r111 = r108[r101];
    L6:
        int r112 = r111 ^ r110;
        this.cnt = (this.cnt + 1) & 2047;
        return r112;
    L5:
        int[] r113 = this.f525189q;
        int r114 = r113[(r101 - 3) & 1023];
        int r115 = r113[(r101 - 1023) & 1023];
        int r116 = r113[r101];
        int r117 = r113[(r101 - 10) & 1023] + (rotateRight(r115, 23) ^ rotateRight(r114, 10));
        int[] r118 = this.f525188p;
        r113[r101] = r116 + (r117 + r118[(r114 ^ r115) & 1023]);
        int[] r119 = this.f525189q;
        int r120 = r119[(r101 - 12) & 1023];
        r110 = ((r118[r120 & 255] + r118[((r120 >> 8) & 255) + 256]) + r118[((r120 >> 16) & 255) + 512]) + r118[((r120 >> 24) & 255) + ISmModel.VERSION_0300];
        r111 = r119[r101];
        goto L6
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public String getAlgorithmName() {
        return "HC-256";
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public void init(boolean r100, CipherParameters r101) throws IllegalArgumentException {
        if ((r101 instanceof ParametersWithIV) == false) goto L5;
        ParametersWithIV r102 = (ParametersWithIV) r101;
        this.f525187iv = r102.getIV();
        CipherParameters r103 = r102.getParameters();
    L7:
        if ((r103 instanceof KeyParameter) == false) goto L11;
        this.key = ((KeyParameter) r103).getKey();
        init();
        this.initialised = true;
        return;
    L11:
        throw new IllegalArgumentException("Invalid parameter passed to HC256 init - ".concat(r101.getClass().getName()));
    L5:
        this.f525187iv = new byte[0];
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
