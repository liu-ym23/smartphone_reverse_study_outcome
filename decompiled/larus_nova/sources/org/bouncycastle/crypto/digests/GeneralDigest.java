package org.bouncycastle.crypto.digests;

import kotlin.jvm.internal.ByteCompanionObject;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public abstract class GeneralDigest implements ExtendedDigest, Memoable {
    private static final int BYTE_LENGTH = 64;
    private long byteCount;
    private final byte[] xBuf;
    private int xBufOff;

    public GeneralDigest() {
        this.xBuf = new byte[4];
        this.xBufOff = 0;
    }

    public GeneralDigest(GeneralDigest r100) {
        this.xBuf = new byte[4];
        copyIn(r100);
    }

    public GeneralDigest(byte[] r100) {
        byte[] r101 = new byte[4];
        this.xBuf = r101;
        System.arraycopy(r100, 0, r101, 0, r101.length);
        this.xBufOff = Pack.bigEndianToInt(r100, 4);
        this.byteCount = Pack.bigEndianToLong(r100, 8);
    }

    public void copyIn(GeneralDigest r100) {
        byte[] r101 = r100.xBuf;
        System.arraycopy(r101, 0, this.xBuf, 0, r101.length);
        this.xBufOff = r100.xBufOff;
        this.byteCount = r100.byteCount;
    }

    public void finish() {
        long r100 = this.byteCount << 3;
        byte r101 = ByteCompanionObject.MIN_VALUE;
    L3:
        update(r101);
        if (this.xBufOff == 0) goto L6;
        r101 = 0;
        goto L3
    L6:
        processLength(r100);
        processBlock();
    }

    @Override // org.bouncycastle.crypto.ExtendedDigest
    public int getByteLength() {
        return 64;
    }

    public void populateState(byte[] r100) {
        System.arraycopy(this.xBuf, 0, r100, 0, this.xBufOff);
        Pack.intToBigEndian(this.xBufOff, r100, 4);
        Pack.longToBigEndian(this.byteCount, r100, 8);
    }

    public abstract void processBlock();

    public abstract void processLength(long r100);

    public abstract void processWord(byte[] r100, int r101);

    @Override // org.bouncycastle.crypto.Digest
    public void reset() {
        this.byteCount = 0;
        this.xBufOff = 0;
        int r100 = 0;
    L3:
        byte[] r101 = this.xBuf;
        if (r100 >= r101.length) goto L6;
        r101[r100] = 0;
        r100 = r100 + 1;
        goto L3
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte r100) {
        byte[] r101 = this.xBuf;
        int r102 = this.xBufOff;
        int r103 = r102 + 1;
        this.xBufOff = r103;
        r101[r102] = r100;
        if (r103 != r101.length) goto L5;
        processWord(r101, 0);
        this.xBufOff = 0;
    L5:
        this.byteCount++;
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte[] r100, int r101, int r102) {
        int r103 = 0;
        int r104 = Math.max(0, r102);
        if (this.xBufOff == 0) goto L11;
        int r105 = 0;
    L5:
        if (r105 >= r104) goto L10;
        byte[] r106 = this.xBuf;
        int r107 = this.xBufOff;
        int r108 = r107 + 1;
        this.xBufOff = r108;
        int r109 = r105 + 1;
        r106[r107] = r100[r105 + r101];
        if (r108 == 4) goto L8;
        r105 = r109;
        goto L5
    L8:
        processWord(r106, 0);
        this.xBufOff = 0;
        r103 = r109;
        goto L11
    L10:
        r103 = r105;
    L11:
        int r110 = ((r104 - r103) & (-4)) + r103;
    L12:
        if (r103 >= r110) goto L14;
        processWord(r100, r101 + r103);
        r103 = r103 + 4;
    L14:
        if (r103 >= r104) goto L16;
        byte[] r111 = this.xBuf;
        int r112 = this.xBufOff;
        this.xBufOff = r112 + 1;
        r111[r112] = r100[r103 + r101];
        r103 = r103 + 1;
        goto L14
    L16:
        this.byteCount += (long) r104;
    }
}
