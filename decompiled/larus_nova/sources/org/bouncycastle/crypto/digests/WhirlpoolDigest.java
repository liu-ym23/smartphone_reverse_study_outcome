package org.bouncycastle.crypto.digests;

import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.model.VideoRef;
import kotlin.jvm.internal.ByteCompanionObject;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Memoable;

/* JADX INFO: loaded from: classes42.dex */
public final class WhirlpoolDigest implements ExtendedDigest, Memoable {
    private static final int BITCOUNT_ARRAY_SIZE = 32;
    private static final int BYTE_LENGTH = 64;
    private static final long[] C0 = null;
    private static final long[] C1 = null;
    private static final long[] C2 = null;
    private static final long[] C3 = null;
    private static final long[] C4 = null;
    private static final long[] C5 = null;
    private static final long[] C6 = null;
    private static final long[] C7 = null;
    private static final int DIGEST_LENGTH_BYTES = 64;
    private static final short[] EIGHT = null;
    private static final int REDUCTION_POLYNOMIAL = 285;
    private static final int ROUNDS = 10;
    private static final int[] SBOX = null;
    private long[] _K;
    private long[] _L;
    private short[] _bitCount;
    private long[] _block;
    private byte[] _buffer;
    private int _bufferPos;
    private long[] _hash;
    private final long[] _rc;
    private long[] _state;

    static {
        SBOX = new int[]{24, 35, 198, VideoRef.VALUE_VIDEO_REF_CATEGORY, 135, 184, 1, 79, 54, 166, 210, 245, 121, 111, 145, 82, 96, 188, 155, 142, 163, 12, 123, 53, 29, 224, 215, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY, 46, 75, 254, 87, 21, 119, 55, 229, 159, 240, 74, 218, 88, 201, 41, 10, 177, 160, 107, 133, 189, 93, 16, 244, 203, 62, 5, 103, VideoRef.VALUE_VIDEO_REF_CODEC_HAS_BYTEVC2, 39, 65, 139, 167, 125, 149, 216, 251, 238, 124, 102, 221, 23, 71, 158, 202, 45, 191, 7, 173, 90, 131, 51, 99, 2, 170, 113, 200, 25, 73, 217, 242, VideoRef.VALUE_VIDEO_REF_POPULARITY_LEVEL, 91, 136, 154, 38, 50, 176, 233, 15, 213, 128, 190, 205, 52, 72, 255, 122, 144, 95, 32, 104, 26, 174, 180, 84, 147, 34, 100, 241, 115, 18, 64, 8, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, VideoRef.VALUE_VIDEO_REF_CONST_DEPTH, 219, 161, 141, 61, 151, 0, 207, 43, 118, 130, 214, 27, 181, 175, 106, 80, 69, 243, 48, VideoRef.VALUE_VIDEO_REF_SUBTITLE_POSITION_X, 63, 85, 162, 234, 101, 186, 47, 192, 222, 28, 253, 77, 146, 117, 6, 138, 178, 230, 14, 31, 98, 212, 168, 150, 249, MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, 37, 89, 132, 114, 57, 76, 94, 120, 56, 140, 209, 165, 226, 97, 179, 33, 156, 30, 67, 199, 252, 4, 81, 153, 109, 13, 250, 223, 126, 36, 59, 171, 206, 17, 143, 78, 183, VideoRef.VALUE_VIDEO_REF_AI_BARRAGE_URL, 60, 129, 148, 247, 185, 19, 44, 211, 231, 110, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE, 3, 86, 68, 127, 169, 42, 187, 193, 83, 220, 11, 157, 108, 49, 116, 246, 70, 172, 137, 20, 225, 22, 58, 105, 9, 112, 182, 208, VideoRef.VALUE_VIDEO_REF_PALLAS_VID_LABELS, 204, 66, 152, 164, 40, 92, 248, 134};
        C0 = new long[256];
        C1 = new long[256];
        C2 = new long[256];
        C3 = new long[256];
        C4 = new long[256];
        C5 = new long[256];
        C6 = new long[256];
        C7 = new long[256];
        short[] r100 = new short[32];
        EIGHT = r100;
        r100[31] = 8;
    }

    public WhirlpoolDigest() {
        this._rc = new long[11];
        this._buffer = new byte[64];
        this._bufferPos = 0;
        this._bitCount = new short[32];
        this._hash = new long[8];
        this._K = new long[8];
        this._L = new long[8];
        this._block = new long[8];
        this._state = new long[8];
        int r110 = 0;
    L4:
        if (r110 >= 256) goto L6;
        int r111 = SBOX[r110];
        int r112 = maskWithReductionPolynomial(r111 << 1);
        int r113 = maskWithReductionPolynomial(r112 << 1);
        int r114 = r113 ^ r111;
        int r115 = maskWithReductionPolynomial(r113 << 1);
        int r116 = r115 ^ r111;
        C0[r110] = packIntoLong(r111, r111, r113, r111, r115, r114, r112, r116);
        C1[r110] = packIntoLong(r116, r111, r111, r113, r111, r115, r114, r112);
        C2[r110] = packIntoLong(r112, r116, r111, r111, r113, r111, r115, r114);
        C3[r110] = packIntoLong(r114, r112, r116, r111, r111, r113, r111, r115);
        C4[r110] = packIntoLong(r115, r114, r112, r116, r111, r111, r113, r111);
        C5[r110] = packIntoLong(r111, r115, r114, r112, r116, r111, r111, r113);
        C6[r110] = packIntoLong(r113, r111, r115, r114, r112, r116, r111, r111);
        C7[r110] = packIntoLong(r111, r113, r111, r115, r114, r112, r116, r111);
        r110 = r110 + 1;
        goto L4
    L6:
        this._rc[0] = 0;
        int r100 = 1;
    L8:
        if (r100 > 10) goto L10;
        int r101 = (r100 - 1) * 8;
        this._rc[r100] = (((((((C0[r101] & (-72057594037927936L)) ^ (C1[r101 + 1] & 71776119061217280L)) ^ (C2[r101 + 2] & 280375465082880L)) ^ (C3[r101 + 3] & 1095216660480L)) ^ (C4[r101 + 4] & 4278190080L)) ^ (C5[r101 + 5] & 16711680)) ^ (C6[r101 + 6] & 65280)) ^ (C7[r101 + 7] & 255);
        r100 = r100 + 1;
        goto L8
    }

    public WhirlpoolDigest(WhirlpoolDigest r100) {
        this._rc = new long[11];
        this._buffer = new byte[64];
        this._bufferPos = 0;
        this._bitCount = new short[32];
        this._hash = new long[8];
        this._K = new long[8];
        this._L = new long[8];
        this._block = new long[8];
        this._state = new long[8];
        reset(r100);
    }

    private long bytesToLongFromBuffer(byte[] r100, int r101) {
        long r102 = (((((((((long) r100[r101 + 0]) & 255) << 56) | ((((long) r100[r101 + 1]) & 255) << 48)) | ((((long) r100[r101 + 2]) & 255) << 40)) | ((((long) r100[r101 + 3]) & 255) << 32)) | ((((long) r100[r101 + 4]) & 255) << 24)) | ((((long) r100[r101 + 5]) & 255) << 16)) | ((((long) r100[r101 + 6]) & 255) << 8);
        return (((long) r100[r101 + 7]) & 255) | r102;
    }

    private void convertLongToByteArray(long r100, byte[] r101, int r110) {
        int r102 = 0;
    L4:
        if (r102 >= 8) goto L6;
        r101[r110 + r102] = (byte) ((r100 >> (56 - (r102 * 8))) & 255);
        r102 = r102 + 1;
        goto L4
    }

    private byte[] copyBitLength() {
        byte[] r100 = new byte[32];
        int r101 = 0;
    L3:
        if (r101 >= 32) goto L5;
        r100[r101] = (byte) (this._bitCount[r101] & 255);
        r101 = r101 + 1;
        goto L3
    L5:
        return r100;
    }

    private void finish() {
        byte[] r100 = copyBitLength();
        byte[] r101 = this._buffer;
        int r102 = this._bufferPos;
        int r103 = r102 + 1;
        this._bufferPos = r103;
        r101[r102] = (byte) (r101[r102] | ByteCompanionObject.MIN_VALUE);
        if (r103 != r101.length) goto L6;
        processFilledBuffer(r101, 0);
    L6:
        if (this._bufferPos <= 32) goto L11;
    L8:
        if (this._bufferPos == 0) goto L11;
        update((byte) 0);
    L11:
        if (this._bufferPos > 32) goto L13;
        update((byte) 0);
        goto L11
    L13:
        System.arraycopy(r100, 0, this._buffer, 32, r100.length);
        processFilledBuffer(this._buffer, 0);
    }

    private void increment() {
        int r100 = this._bitCount.length - 1;
        int r101 = 0;
    L3:
        if (r100 < 0) goto L5;
        short[] r102 = this._bitCount;
        int r103 = ((r102[r100] & 255) + EIGHT[r100]) + r101;
        r101 = r103 >>> 8;
        r102[r100] = (short) (r103 & 255);
        r100 = r100 - 1;
        goto L3
    }

    private int maskWithReductionPolynomial(int r100) {
        if (r100 >= 256) goto L5;
        return r100;
    L5:
        return r100 ^ 285;
    }

    private long packIntoLong(int r100, int r101, int r102, int r103, int r104, int r105, int r110, int r111) {
        long r106 = ((long) r100) << 56;
        return (((((((((long) r101) << 48) ^ r106) ^ (((long) r102) << 40)) ^ (((long) r103) << 32)) ^ (((long) r104) << 24)) ^ (((long) r105) << 16)) ^ (((long) r110) << 8)) ^ ((long) r111);
    }

    private void processFilledBuffer(byte[] r100, int r101) {
        int r102 = 0;
    L4:
        if (r102 >= this._state.length) goto L6;
        this._block[r102] = bytesToLongFromBuffer(this._buffer, r102 * 8);
        r102 = r102 + 1;
        goto L4
    L6:
        processBlock();
        this._bufferPos = 0;
        Arrays.fill(this._buffer, (byte) 0);
    }

    @Override // org.bouncycastle.util.Memoable
    public Memoable copy() {
        return new WhirlpoolDigest(this);
    }

    @Override // org.bouncycastle.crypto.Digest
    public int doFinal(byte[] r100, int r101) {
        finish();
        int r102 = 0;
    L4:
        if (r102 >= 8) goto L6;
        convertLongToByteArray(this._hash[r102], r100, (r102 * 8) + r101);
        r102 = r102 + 1;
        goto L4
    L6:
        reset();
        return getDigestSize();
    }

    @Override // org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return "Whirlpool";
    }

    @Override // org.bouncycastle.crypto.ExtendedDigest
    public int getByteLength() {
        return 64;
    }

    @Override // org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return 64;
    }

    public void processBlock() {
        int r100 = 0;
    L4:
        if (r100 >= 8) goto L6;
        long[] r101 = this._state;
        long r102 = this._block[r100];
        long[] r103 = this._K;
        long r104 = this._hash[r100];
        r103[r100] = r104;
        r101[r100] = r102 ^ r104;
        r100 = r100 + 1;
        goto L4
    L6:
        int r105 = 1;
    L8:
        if (r105 > 10) goto L18;
        int r106 = 0;
    L11:
        if (r106 >= 8) goto L13;
        long[] r110 = this._L;
        r110[r106] = 0;
        long[] r111 = C0;
        long[] r112 = this._K;
        long r107 = r111[((int) (r112[(r106 + 0) & 7] >>> 56)) & 255] ^ 0;
        r110[r106] = r107;
        long r108 = r107 ^ C1[((int) (r112[(r106 - 1) & 7] >>> 48)) & 255];
        r110[r106] = r108;
        long r109 = r108 ^ C2[((int) (r112[(r106 - 2) & 7] >>> 40)) & 255];
        r110[r106] = r109;
        long r113 = r109 ^ C3[((int) (r112[(r106 - 3) & 7] >>> 32)) & 255];
        r110[r106] = r113;
        long r114 = r113 ^ C4[((int) (r112[(r106 - 4) & 7] >>> 24)) & 255];
        r110[r106] = r114;
        long r115 = r114 ^ C5[((int) (r112[(r106 - 5) & 7] >>> 16)) & 255];
        r110[r106] = r115;
        long r116 = r115 ^ C6[((int) (r112[(r106 - 6) & 7] >>> 8)) & 255];
        r110[r106] = r116;
        r110[r106] = r116 ^ C7[((int) r112[(r106 - 7) & 7]) & 255];
        r106 = r106 + 1;
        r105 = r105;
        goto L11
    L13:
        int r117 = r105;
        long[] r118 = this._L;
        long[] r119 = this._K;
        System.arraycopy(r118, 0, r119, 0, r119.length);
        long[] r120 = this._K;
        r120[0] = r120[0] ^ this._rc[r117];
        int r121 = 0;
    L14:
        long[] r122 = this._L;
        if (r121 >= 8) goto L17;
        long r123 = this._K[r121];
        r122[r121] = r123;
        long[] r124 = C0;
        long[] r125 = this._state;
        long r126 = r123 ^ r124[((int) (r125[(r121 + 0) & 7] >>> 56)) & 255];
        r122[r121] = r126;
        long r127 = r126 ^ C1[((int) (r125[(r121 - 1) & 7] >>> 48)) & 255];
        r122[r121] = r127;
        long r128 = r127 ^ C2[((int) (r125[(r121 - 2) & 7] >>> 40)) & 255];
        r122[r121] = r128;
        long r129 = r128 ^ C3[((int) (r125[(r121 - 3) & 7] >>> 32)) & 255];
        r122[r121] = r129;
        long r130 = r129 ^ C4[((int) (r125[(r121 - 4) & 7] >>> 24)) & 255];
        r122[r121] = r130;
        long r131 = r130 ^ C5[((int) (r125[(r121 - 5) & 7] >>> 16)) & 255];
        r122[r121] = r131;
        long r132 = r131 ^ C6[((int) (r125[(r121 - 6) & 7] >>> 8)) & 255];
        r122[r121] = r132;
        r122[r121] = r132 ^ C7[((int) r125[(r121 - 7) & 7]) & 255];
        r121 = r121 + 1;
        goto L14
    L17:
        long[] r133 = this._state;
        System.arraycopy(r122, 0, r133, 0, r133.length);
        r105 = r117 + 1;
        goto L8
    L18:
        int r134 = 0;
    L19:
        if (r134 >= 8) goto L21;
        long[] r135 = this._hash;
        r135[r134] = r135[r134] ^ (this._state[r134] ^ this._block[r134]);
        r134 = r134 + 1;
        goto L19
    }

    @Override // org.bouncycastle.crypto.Digest
    public void reset() {
        this._bufferPos = 0;
        Arrays.fill(this._bitCount, 0);
        Arrays.fill(this._buffer, (byte) 0);
        Arrays.fill(this._hash, 0);
        Arrays.fill(this._K, 0);
        Arrays.fill(this._L, 0);
        Arrays.fill(this._block, 0);
        Arrays.fill(this._state, 0);
    }

    @Override // org.bouncycastle.util.Memoable
    public void reset(Memoable r100) {
        WhirlpoolDigest r101 = (WhirlpoolDigest) r100;
        long[] r102 = r101._rc;
        long[] r103 = this._rc;
        System.arraycopy(r102, 0, r103, 0, r103.length);
        byte[] r104 = r101._buffer;
        byte[] r105 = this._buffer;
        System.arraycopy(r104, 0, r105, 0, r105.length);
        this._bufferPos = r101._bufferPos;
        short[] r106 = r101._bitCount;
        short[] r107 = this._bitCount;
        System.arraycopy(r106, 0, r107, 0, r107.length);
        long[] r108 = r101._hash;
        long[] r109 = this._hash;
        System.arraycopy(r108, 0, r109, 0, r109.length);
        long[] r110 = r101._K;
        long[] r111 = this._K;
        System.arraycopy(r110, 0, r111, 0, r111.length);
        long[] r112 = r101._L;
        long[] r113 = this._L;
        System.arraycopy(r112, 0, r113, 0, r113.length);
        long[] r114 = r101._block;
        long[] r115 = this._block;
        System.arraycopy(r114, 0, r115, 0, r115.length);
        long[] r116 = r101._state;
        long[] r117 = this._state;
        System.arraycopy(r116, 0, r117, 0, r117.length);
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte r100) {
        byte[] r101 = this._buffer;
        int r102 = this._bufferPos;
        r101[r102] = r100;
        int r103 = r102 + 1;
        this._bufferPos = r103;
        if (r103 != r101.length) goto L5;
        processFilledBuffer(r101, 0);
    L5:
        increment();
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte[] r100, int r101, int r102) {
    L2:
        if (r102 <= 0) goto L4;
        update(r100[r101]);
        r101 = r101 + 1;
        r102 = r102 - 1;
        goto L2
    }
}
