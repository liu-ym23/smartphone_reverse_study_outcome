package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.Xof;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class Blake2xsDigest implements Xof {
    private static final int DIGEST_LENGTH = 32;
    private static final long MAX_NUMBER_BLOCKS = 4294967296L;
    public static final int UNKNOWN_DIGEST_LENGTH = 65535;
    private long blockPos;
    private byte[] buf;
    private int bufPos;
    private int digestLength;
    private int digestPos;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private byte[] f525139h0;
    private Blake2sDigest hash;
    private long nodeOffset;

    public Blake2xsDigest() {
        this(65535);
    }

    public Blake2xsDigest(int r100) {
        this(r100, null, null, null);
    }

    public Blake2xsDigest(int r100, byte[] r101) {
        this(r100, r101, null, null);
    }

    public Blake2xsDigest(int r100, byte[] r110, byte[] r111, byte[] r112) {
        this.f525139h0 = null;
        this.buf = new byte[32];
        this.bufPos = 32;
        this.digestPos = 0;
        this.blockPos = 0;
        if (r100 < 1) goto L9;
        if (r100 > 65535) goto L9;
        this.digestLength = r100;
        long r101 = computeNodeOffset();
        this.nodeOffset = r101;
        this.hash = new Blake2sDigest(32, r110, r111, r112, r101);
        return;
    L9:
        throw new IllegalArgumentException("BLAKE2xs digest length must be between 1 and 2^16-1");
    }

    public Blake2xsDigest(Blake2xsDigest r100) {
        this.f525139h0 = null;
        this.buf = new byte[32];
        this.bufPos = 32;
        this.digestPos = 0;
        this.blockPos = 0;
        this.digestLength = r100.digestLength;
        this.hash = new Blake2sDigest(r100.hash);
        this.f525139h0 = Arrays.clone(r100.f525139h0);
        this.buf = Arrays.clone(r100.buf);
        this.bufPos = r100.bufPos;
        this.digestPos = r100.digestPos;
        this.blockPos = r100.blockPos;
        this.nodeOffset = r100.nodeOffset;
    }

    private long computeNodeOffset() {
        return ((long) this.digestLength) * MAX_NUMBER_BLOCKS;
    }

    private int computeStepLength() {
        int r100 = this.digestLength;
        if (r100 != 65535) goto L6;
        return 32;
    L6:
        return Math.min(32, r100 - this.digestPos);
    }

    @Override // org.bouncycastle.crypto.Digest
    public int doFinal(byte[] r100, int r101) {
        return doFinal(r100, r101, r100.length);
    }

    @Override // org.bouncycastle.crypto.Xof
    public int doFinal(byte[] r100, int r101, int r102) {
        int r103 = doOutput(r100, r101, r102);
        reset();
        return r103;
    }

    @Override // org.bouncycastle.crypto.Xof
    public int doOutput(byte[] r100, int r101, int r102) {
        if (this.f525139h0 != null) goto L5;
        byte[] r103 = new byte[this.hash.getDigestSize()];
        this.f525139h0 = r103;
        this.hash.doFinal(r103, 0);
    L5:
        int r104 = this.digestLength;
        if (r104 == 65535) goto L13;
        if ((this.digestPos + r102) > r104) goto L11;
    L14:
        int r105 = 0;
    L15:
        if (r105 >= r102) goto L20;
        if (this.bufPos < 32) goto L19;
        Blake2sDigest r106 = new Blake2sDigest(computeStepLength(), 32, this.nodeOffset);
        byte[] r107 = this.f525139h0;
        r106.update(r107, 0, r107.length);
        Arrays.fill(this.buf, (byte) 0);
        r106.doFinal(this.buf, 0);
        this.bufPos = 0;
        this.nodeOffset++;
        this.blockPos++;
    L19:
        byte[] r108 = this.buf;
        int r109 = this.bufPos;
        r100[r105] = r108[r109];
        this.bufPos = r109 + 1;
        this.digestPos++;
        r105 = r105 + 1;
        goto L15
    L20:
        return r102;
    L11:
        throw new IllegalArgumentException("Output length is above the digest length");
    L13:
        if ((this.blockPos << 5) < getUnknownMaxLength()) goto L14;
        throw new IllegalArgumentException("Maximum length is 2^32 blocks of 32 bytes");
    }

    @Override // org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return "BLAKE2xs";
    }

    @Override // org.bouncycastle.crypto.ExtendedDigest
    public int getByteLength() {
        return this.hash.getByteLength();
    }

    @Override // org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return this.digestLength;
    }

    public long getUnknownMaxLength() {
        return 137438953472L;
    }

    @Override // org.bouncycastle.crypto.Digest
    public void reset() {
        this.hash.reset();
        this.f525139h0 = null;
        this.bufPos = 32;
        this.digestPos = 0;
        this.blockPos = 0;
        this.nodeOffset = computeNodeOffset();
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte r100) {
        this.hash.update(r100);
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte[] r100, int r101, int r102) {
        this.hash.update(r100, r101, r102);
    }
}
