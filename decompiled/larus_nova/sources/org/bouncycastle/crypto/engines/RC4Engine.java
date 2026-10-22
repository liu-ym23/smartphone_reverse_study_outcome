package org.bouncycastle.crypto.engines;

import kotlin.UByte;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.params.KeyParameter;

/* JADX INFO: loaded from: classes42.dex */
public class RC4Engine implements StreamCipher {
    private static final int STATE_LENGTH = 256;
    private byte[] engineState;
    private byte[] workingKey;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f525197x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f525198y;

    public RC4Engine() {
        this.engineState = null;
        this.f525197x = 0;
        this.f525198y = 0;
        this.workingKey = null;
    }

    private void setKey(byte[] r100) {
        this.workingKey = r100;
        int r101 = 0;
        this.f525197x = 0;
        this.f525198y = 0;
        if (this.engineState != null) goto L5;
        this.engineState = new byte[256];
    L5:
        int r102 = 0;
    L6:
        if (r102 >= 256) goto L8;
        this.engineState[r102] = (byte) r102;
        r102 = r102 + 1;
        goto L6
    L8:
        int r103 = 0;
        int r104 = 0;
    L9:
        if (r101 >= 256) goto L11;
        int r105 = r100[r103] & UByte.MAX_VALUE;
        byte[] r106 = this.engineState;
        byte r107 = r106[r101];
        r104 = ((r105 + r107) + r104) & 255;
        r106[r101] = r106[r104];
        r106[r104] = r107;
        r103 = (r103 + 1) % r100.length;
        r101 = r101 + 1;
        goto L9
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public String getAlgorithmName() {
        return "RC4";
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public void init(boolean r100, CipherParameters r101) {
        if ((r101 instanceof KeyParameter) == false) goto L7;
        byte[] r102 = ((KeyParameter) r101).getKey();
        this.workingKey = r102;
        setKey(r102);
        return;
    L7:
        throw new IllegalArgumentException("invalid parameter passed to RC4 init - ".concat(r101.getClass().getName()));
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public int processBytes(byte[] r100, int r101, int r102, byte[] r110, int r111) {
        if ((r101 + r102) > r100.length) goto L13;
        if ((r111 + r102) > r110.length) goto L11;
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L9;
        int r104 = (this.f525197x + 1) & 255;
        this.f525197x = r104;
        byte[] r105 = this.engineState;
        byte r106 = r105[r104];
        int r107 = (this.f525198y + r106) & 255;
        this.f525198y = r107;
        r105[r104] = r105[r107];
        r105[r107] = r106;
        byte r108 = r100[r103 + r101];
        r110[r103 + r111] = (byte) (r105[(r105[r104] + r106) & 255] ^ r108);
        r103 = r103 + 1;
        goto L7
    L9:
        return r102;
    L11:
        throw new OutputLengthException("output buffer too short");
    L13:
        throw new DataLengthException("input buffer too short");
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public void reset() {
        setKey(this.workingKey);
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public byte returnByte(byte r100) {
        int r101 = (this.f525197x + 1) & 255;
        this.f525197x = r101;
        byte[] r102 = this.engineState;
        byte r103 = r102[r101];
        int r104 = (this.f525198y + r103) & 255;
        this.f525198y = r104;
        r102[r101] = r102[r104];
        r102[r104] = r103;
        return (byte) (r100 ^ r102[(r102[r101] + r103) & 255]);
    }
}
