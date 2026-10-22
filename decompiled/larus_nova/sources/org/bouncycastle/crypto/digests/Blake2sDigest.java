package org.bouncycastle.crypto.digests;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class Blake2sDigest implements ExtendedDigest {
    private static final int BLOCK_LENGTH_BYTES = 64;
    private static final int ROUNDS = 10;
    private static final int[] blake2s_IV = null;
    private static final byte[][] blake2s_sigma = null;
    private byte[] buffer;
    private int bufferPos;
    private int[] chainValue;
    private int depth;
    private int digestLength;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private int f525136f0;
    private int fanout;
    private int innerHashLength;
    private int[] internalState;
    private byte[] key;
    private int keyLength;
    private int leafLength;
    private int nodeDepth;
    private long nodeOffset;
    private byte[] personalization;
    private byte[] salt;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private int f525137t0;

    /* JADX INFO: renamed from: t1, reason: collision with root package name */
    private int f525138t1;

    static {
        blake2s_IV = new int[]{1779033703, -1150833019, 1013904242, -1521486534, 1359893119, -1694144372, 528734635, 1541459225};
        blake2s_sigma = new byte[][]{new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, HTTP.CR, 14, 15}, new byte[]{14, 10, 4, 8, 9, 15, HTTP.CR, 6, 1, 12, 0, 2, 11, 7, 5, 3}, new byte[]{11, 8, 12, 0, 5, 2, 15, HTTP.CR, 10, 14, 3, 6, 7, 1, 9, 4}, new byte[]{7, 9, 3, 1, HTTP.CR, 12, 11, 14, 2, 6, 5, 10, 4, 0, 15, 8}, new byte[]{9, 0, 5, 7, 2, 4, 10, 15, 14, 1, 11, 12, 6, 8, 3, HTTP.CR}, new byte[]{2, 12, 6, 10, 0, 11, 8, 3, 4, HTTP.CR, 7, 5, 15, 14, 1, 9}, new byte[]{12, 5, 1, 15, 14, HTTP.CR, 4, 10, 0, 7, 6, 3, 9, 2, 8, 11}, new byte[]{HTTP.CR, 11, 7, 14, 12, 1, 3, 9, 5, 0, 15, 4, 8, 6, 2, 10}, new byte[]{6, 15, 14, 9, 11, 3, 0, 8, 12, 2, HTTP.CR, 7, 1, 4, 10, 5}, new byte[]{10, 2, 8, 4, 7, 6, 1, 5, 15, 11, 9, 14, 3, 12, HTTP.CR, 0}};
    }

    public Blake2sDigest() {
        this(256);
    }

    public Blake2sDigest(int r100) {
        this.digestLength = 32;
        this.keyLength = 0;
        this.salt = null;
        this.personalization = null;
        this.key = null;
        this.fanout = 1;
        this.depth = 1;
        this.leafLength = 0;
        this.nodeOffset = 0;
        this.nodeDepth = 0;
        this.innerHashLength = 0;
        this.buffer = null;
        this.bufferPos = 0;
        this.internalState = new int[16];
        this.chainValue = null;
        this.f525137t0 = 0;
        this.f525138t1 = 0;
        this.f525136f0 = 0;
        if (r100 < 8) goto L11;
        if (r100 > 256) goto L11;
        if ((r100 % 8) != 0) goto L11;
        this.digestLength = r100 / 8;
        init(null, null, null);
        return;
    L11:
        throw new IllegalArgumentException("BLAKE2s digest bit length must be a multiple of 8 and not greater than 256");
    }

    public Blake2sDigest(int r100, int r101, long r102) {
        this.keyLength = 0;
        this.salt = null;
        this.personalization = null;
        this.key = null;
        this.buffer = null;
        this.bufferPos = 0;
        this.internalState = new int[16];
        this.chainValue = null;
        this.f525137t0 = 0;
        this.f525138t1 = 0;
        this.f525136f0 = 0;
        this.digestLength = r100;
        this.nodeOffset = r102;
        this.fanout = 0;
        this.depth = 0;
        this.leafLength = r101;
        this.innerHashLength = r101;
        this.nodeDepth = 0;
        init(null, null, null);
    }

    public Blake2sDigest(int r100, byte[] r101, byte[] r102, byte[] r103, long r104) {
        this.keyLength = 0;
        this.salt = null;
        this.personalization = null;
        this.key = null;
        this.fanout = 1;
        this.depth = 1;
        this.leafLength = 0;
        this.nodeDepth = 0;
        this.innerHashLength = 0;
        this.buffer = null;
        this.bufferPos = 0;
        this.internalState = new int[16];
        this.chainValue = null;
        this.f525137t0 = 0;
        this.f525138t1 = 0;
        this.f525136f0 = 0;
        this.digestLength = r100;
        this.nodeOffset = r104;
        init(r102, r103, r101);
    }

    public Blake2sDigest(Blake2sDigest r100) {
        this.digestLength = 32;
        this.keyLength = 0;
        this.salt = null;
        this.personalization = null;
        this.key = null;
        this.fanout = 1;
        this.depth = 1;
        this.leafLength = 0;
        this.nodeOffset = 0;
        this.nodeDepth = 0;
        this.innerHashLength = 0;
        this.buffer = null;
        this.bufferPos = 0;
        this.internalState = new int[16];
        this.chainValue = null;
        this.f525137t0 = 0;
        this.f525138t1 = 0;
        this.f525136f0 = 0;
        this.bufferPos = r100.bufferPos;
        this.buffer = Arrays.clone(r100.buffer);
        this.keyLength = r100.keyLength;
        this.key = Arrays.clone(r100.key);
        this.digestLength = r100.digestLength;
        this.internalState = Arrays.clone(this.internalState);
        this.chainValue = Arrays.clone(r100.chainValue);
        this.f525137t0 = r100.f525137t0;
        this.f525138t1 = r100.f525138t1;
        this.f525136f0 = r100.f525136f0;
        this.salt = Arrays.clone(r100.salt);
        this.personalization = Arrays.clone(r100.personalization);
        this.fanout = r100.fanout;
        this.depth = r100.depth;
        this.leafLength = r100.leafLength;
        this.nodeOffset = r100.nodeOffset;
        this.nodeDepth = r100.nodeDepth;
        this.innerHashLength = r100.innerHashLength;
    }

    public Blake2sDigest(byte[] r100) {
        this.digestLength = 32;
        this.keyLength = 0;
        this.salt = null;
        this.personalization = null;
        this.key = null;
        this.fanout = 1;
        this.depth = 1;
        this.leafLength = 0;
        this.nodeOffset = 0;
        this.nodeDepth = 0;
        this.innerHashLength = 0;
        this.buffer = null;
        this.bufferPos = 0;
        this.internalState = new int[16];
        this.chainValue = null;
        this.f525137t0 = 0;
        this.f525138t1 = 0;
        this.f525136f0 = 0;
        init(null, null, r100);
    }

    public Blake2sDigest(byte[] r100, int r101, byte[] r102, byte[] r110) {
        this.digestLength = 32;
        this.keyLength = 0;
        this.salt = null;
        this.personalization = null;
        this.key = null;
        this.fanout = 1;
        this.depth = 1;
        this.leafLength = 0;
        this.nodeOffset = 0;
        this.nodeDepth = 0;
        this.innerHashLength = 0;
        this.buffer = null;
        this.bufferPos = 0;
        this.internalState = new int[16];
        this.chainValue = null;
        this.f525137t0 = 0;
        this.f525138t1 = 0;
        this.f525136f0 = 0;
        if (r101 < 1) goto L8;
        if (r101 > 32) goto L8;
        this.digestLength = r101;
        init(r102, r110, r100);
        return;
    L8:
        throw new IllegalArgumentException("Invalid digest length (required: 1 - 32)");
    }

    private void G(int r100, int r101, int r102, int r103, int r104, int r105) {
        int[] r106 = this.internalState;
        int r107 = (r106[r102] + r106[r103]) + r100;
        r106[r102] = r107;
        r106[r105] = rotr32(r106[r105] ^ r107, 16);
        int[] r108 = this.internalState;
        int r109 = r108[r104] + r108[r105];
        r108[r104] = r109;
        r108[r103] = rotr32(r109 ^ r108[r103], 12);
        int[] r110 = this.internalState;
        int r111 = (r110[r102] + r110[r103]) + r101;
        r110[r102] = r111;
        r110[r105] = rotr32(r110[r105] ^ r111, 8);
        int[] r112 = this.internalState;
        int r113 = r112[r104] + r112[r105];
        r112[r104] = r113;
        r112[r103] = rotr32(r113 ^ r112[r103], 7);
    }

    private void compress(byte[] r110, int r111) {
        initializeInternalState();
        int[] r100 = new int[16];
        int r101 = 0;
        int r102 = 0;
    L3:
        if (r102 >= 16) goto L5;
        r100[r102] = Pack.littleEndianToInt(r110, (r102 * 4) + r111);
        r102 = r102 + 1;
        goto L3
    L5:
        int r112 = 0;
    L7:
        if (r112 >= 10) goto L9;
        byte[][] r103 = blake2s_sigma;
        byte[] r104 = r103[r112];
        G(r100[r104[0]], r100[r104[1]], 0, 4, 8, 12);
        byte[] r105 = r103[r112];
        G(r100[r105[2]], r100[r105[3]], 1, 5, 9, 13);
        byte[] r106 = r103[r112];
        G(r100[r106[4]], r100[r106[5]], 2, 6, 10, 14);
        byte[] r107 = r103[r112];
        G(r100[r107[6]], r100[r107[7]], 3, 7, 11, 15);
        byte[] r108 = r103[r112];
        G(r100[r108[8]], r100[r108[9]], 0, 5, 10, 15);
        byte[] r109 = r103[r112];
        G(r100[r109[10]], r100[r109[11]], 1, 6, 11, 12);
        byte[] r113 = r103[r112];
        G(r100[r113[12]], r100[r113[13]], 2, 7, 8, 13);
        byte[] r114 = r103[r112];
        G(r100[r114[14]], r100[r114[15]], 3, 4, 9, 14);
        r112 = r112 + 1;
    L9:
        int[] r115 = this.chainValue;
        if (r101 >= r115.length) goto L12;
        int r116 = r115[r101];
        int[] r117 = this.internalState;
        r115[r101] = (r116 ^ r117[r101]) ^ r117[r101 + 8];
        r101 = r101 + 1;
        goto L9
    }

    private void init(byte[] r100, byte[] r110, byte[] r111) {
        this.buffer = new byte[64];
        if (r111 == null) goto L12;
        if (r111.length <= 0) goto L12;
        if (r111.length > 32) goto L10;
        byte[] r101 = new byte[r111.length];
        this.key = r101;
        System.arraycopy(r111, 0, r101, 0, r111.length);
        this.keyLength = r111.length;
        System.arraycopy(r111, 0, this.buffer, 0, r111.length);
        this.bufferPos = 64;
        goto L12
    L10:
        throw new IllegalArgumentException("Keys > 32 bytes are not supported");
    L12:
        if (this.chainValue != null) goto L27;
        this.chainValue = new int[]{r3[0] ^ ((this.digestLength | (this.keyLength << 8)) | ((this.fanout << 16) | (this.depth << 24))), r3[1] ^ this.leafLength, ((int) r4) ^ r3[2], ((r1 | (this.nodeDepth << 16)) | (this.innerHashLength << 24)) ^ r5, r3[4], r3[5], 0, 0};
        int[] r102 = blake2s_IV;
        long r103 = this.nodeOffset;
        int r104 = (int) (r103 >> 32);
        int r105 = r102[3];
        if (r100 != null) goto L16;
    L20:
        int[] r106 = this.chainValue;
        r106[6] = r102[6];
        r106[7] = r102[7];
        if (r110 != null) goto L23;
        return;
    L23:
        if (r110.length != 8) goto L26;
        byte[] r107 = new byte[8];
        this.personalization = r107;
        System.arraycopy(r110, 0, r107, 0, r110.length);
        int[] r108 = this.chainValue;
        r108[6] = r108[6] ^ Pack.littleEndianToInt(r110, 0);
        int[] r109 = this.chainValue;
        r109[7] = Pack.littleEndianToInt(r110, 4) ^ r109[7];
        return;
    L26:
        throw new IllegalArgumentException("Personalization length must be exactly 8 bytes");
    L16:
        if (r100.length != 8) goto L19;
        byte[] r112 = new byte[8];
        this.salt = r112;
        System.arraycopy(r100, 0, r112, 0, r100.length);
        int[] r113 = this.chainValue;
        r113[4] = r113[4] ^ Pack.littleEndianToInt(r100, 0);
        int[] r114 = this.chainValue;
        r114[5] = Pack.littleEndianToInt(r100, 4) ^ r114[5];
        goto L20
    L19:
        throw new IllegalArgumentException("Salt length must be exactly 8 bytes");
    }

    private void initializeInternalState() {
        int[] r100 = this.chainValue;
        System.arraycopy(r100, 0, this.internalState, 0, r100.length);
        int[] r101 = blake2s_IV;
        System.arraycopy(r101, 0, this.internalState, this.chainValue.length, 4);
        int[] r102 = this.internalState;
        r102[12] = this.f525137t0 ^ r101[4];
        r102[13] = this.f525138t1 ^ r101[5];
        r102[14] = this.f525136f0 ^ r101[6];
        r102[15] = r101[7];
    }

    private int rotr32(int r100, int r101) {
        int r102 = r100 >>> r101;
        return (r100 << (32 - r101)) | r102;
    }

    public void clearKey() {
        byte[] r100 = this.key;
        if (r100 == null) goto L6;
        Arrays.fill(r100, (byte) 0);
        Arrays.fill(this.buffer, (byte) 0);
        return;
    }

    public void clearSalt() {
        byte[] r100 = this.salt;
        if (r100 == null) goto L6;
        Arrays.fill(r100, (byte) 0);
        return;
    }

    @Override // org.bouncycastle.crypto.Digest
    public int doFinal(byte[] r100, int r101) {
        this.f525136f0 = -1;
        int r102 = this.f525137t0;
        int r103 = this.bufferPos;
        int r104 = r102 + r103;
        this.f525137t0 = r104;
        if (r104 < 0) goto L5;
    L7:
        compress(this.buffer, 0);
        Arrays.fill(this.buffer, (byte) 0);
        Arrays.fill(this.internalState, 0);
        int r105 = 0;
    L8:
        int[] r106 = this.chainValue;
        if (r105 >= r106.length) goto L17;
        int r107 = r105 * 4;
        if (r107 >= this.digestLength) goto L17;
        byte[] r108 = Pack.intToLittleEndian(r106[r105]);
        int r109 = this.digestLength;
        if (r107 >= (r109 - 4)) goto L15;
        System.arraycopy(r108, 0, r100, r107 + r101, 4);
    L16:
        r105 = r105 + 1;
        goto L8
    L15:
        System.arraycopy(r108, 0, r100, r101 + r107, r109 - r107);
    L17:
        Arrays.fill(r106, 0);
        reset();
        return this.digestLength;
    L5:
        if (r103 <= (-r104)) goto L7;
        this.f525138t1++;
        goto L7
    }

    @Override // org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return "BLAKE2s";
    }

    @Override // org.bouncycastle.crypto.ExtendedDigest
    public int getByteLength() {
        return 64;
    }

    @Override // org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return this.digestLength;
    }

    @Override // org.bouncycastle.crypto.Digest
    public void reset() {
        this.bufferPos = 0;
        this.f525136f0 = 0;
        this.f525137t0 = 0;
        this.f525138t1 = 0;
        this.chainValue = null;
        Arrays.fill(this.buffer, (byte) 0);
        byte[] r100 = this.key;
        if (r100 == null) goto L5;
        System.arraycopy(r100, 0, this.buffer, 0, r100.length);
        this.bufferPos = 64;
    L5:
        init(this.salt, this.personalization, this.key);
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte r100) {
        int r101 = this.bufferPos;
        if ((64 - r101) != 0) goto L8;
        int r102 = this.f525137t0 + 64;
        this.f525137t0 = r102;
        if (r102 != 0) goto L7;
        this.f525138t1++;
    L7:
        compress(this.buffer, 0);
        Arrays.fill(this.buffer, (byte) 0);
        this.buffer[0] = r100;
        this.bufferPos = 1;
        return;
    L8:
        this.buffer[r101] = r100;
        this.bufferPos = r101 + 1;
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte[] r100, int r101, int r102) {
        if (r100 == null) goto L24;
        if (r102 == 0) goto L28;
        int r103 = this.bufferPos;
        if (r103 == 0) goto L16;
        int r104 = 64 - r103;
        if (r104 >= r102) goto L13;
        System.arraycopy(r100, r101, this.buffer, r103, r104);
        int r105 = this.f525137t0 + 64;
        this.f525137t0 = r105;
        if (r105 != 0) goto L12;
        this.f525138t1++;
    L12:
        compress(this.buffer, 0);
        this.bufferPos = 0;
        Arrays.fill(this.buffer, (byte) 0);
    L17:
        int r106 = r102 + r101;
        int r107 = r106 - 64;
        int r108 = r101 + r104;
    L18:
        if (r108 >= r107) goto L23;
        int r109 = this.f525137t0 + 64;
        this.f525137t0 = r109;
        if (r109 != 0) goto L22;
        this.f525138t1++;
    L22:
        compress(r100, r108);
        r108 = r108 + 64;
        goto L18
    L23:
        r102 = r106 - r108;
        System.arraycopy(r100, r108, this.buffer, 0, r102);
    L14:
        this.bufferPos += r102;
        return;
    L13:
        System.arraycopy(r100, r101, this.buffer, r103, r102);
        goto L14
    L16:
        r104 = 0;
        goto L17
    L28:
        return;
    }
}
