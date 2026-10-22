package org.bouncycastle.crypto.digests;

import android.R;
import com.alipay.sdk.m.n.a;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Longs;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class Blake2bDigest implements ExtendedDigest {
    private static final int BLOCK_LENGTH_BYTES = 128;
    private static int ROUNDS;
    private static final long[] blake2b_IV = null;
    private static final byte[][] blake2b_sigma = null;
    private byte[] buffer;
    private int bufferPos;
    private long[] chainValue;
    private int digestLength;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private long f525133f0;
    private long[] internalState;
    private byte[] key;
    private int keyLength;
    private byte[] personalization;
    private byte[] salt;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private long f525134t0;

    /* JADX INFO: renamed from: t1, reason: collision with root package name */
    private long f525135t1;

    static {
        blake2b_IV = new long[]{7640891576956012808L, -4942790177534073029L, 4354685564936845355L, -6534734903238641935L, 5840696475078001361L, -7276294671716946913L, 2270897969802886507L, 6620516959819538809L};
        blake2b_sigma = new byte[][]{new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, HTTP.CR, 14, 15}, new byte[]{14, 10, 4, 8, 9, 15, HTTP.CR, 6, 1, 12, 0, 2, 11, 7, 5, 3}, new byte[]{11, 8, 12, 0, 5, 2, 15, HTTP.CR, 10, 14, 3, 6, 7, 1, 9, 4}, new byte[]{7, 9, 3, 1, HTTP.CR, 12, 11, 14, 2, 6, 5, 10, 4, 0, 15, 8}, new byte[]{9, 0, 5, 7, 2, 4, 10, 15, 14, 1, 11, 12, 6, 8, 3, HTTP.CR}, new byte[]{2, 12, 6, 10, 0, 11, 8, 3, 4, HTTP.CR, 7, 5, 15, 14, 1, 9}, new byte[]{12, 5, 1, 15, 14, HTTP.CR, 4, 10, 0, 7, 6, 3, 9, 2, 8, 11}, new byte[]{HTTP.CR, 11, 7, 14, 12, 1, 3, 9, 5, 0, 15, 4, 8, 6, 2, 10}, new byte[]{6, 15, 14, 9, 11, 3, 0, 8, 12, 2, HTTP.CR, 7, 1, 4, 10, 5}, new byte[]{10, 2, 8, 4, 7, 6, 1, 5, 15, 11, 9, 14, 3, 12, HTTP.CR, 0}, new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, HTTP.CR, 14, 15}, new byte[]{14, 10, 4, 8, 9, 15, HTTP.CR, 6, 1, 12, 0, 2, 11, 7, 5, 3}};
        ROUNDS = 12;
    }

    public Blake2bDigest() {
        this(512);
    }

    public Blake2bDigest(int r100) {
        this.digestLength = 64;
        this.keyLength = 0;
        this.salt = null;
        this.personalization = null;
        this.key = null;
        this.buffer = null;
        this.bufferPos = 0;
        this.internalState = new long[16];
        this.chainValue = null;
        this.f525134t0 = 0;
        this.f525135t1 = 0;
        this.f525133f0 = 0;
        if (r100 < 8) goto L11;
        if (r100 > 512) goto L11;
        if ((r100 % 8) != 0) goto L11;
        this.buffer = new byte[128];
        this.keyLength = 0;
        this.digestLength = r100 / 8;
        init();
        return;
    L11:
        throw new IllegalArgumentException("BLAKE2b digest bit length must be a multiple of 8 and not greater than 512");
    }

    public Blake2bDigest(Blake2bDigest r100) {
        this.digestLength = 64;
        this.keyLength = 0;
        this.salt = null;
        this.personalization = null;
        this.key = null;
        this.buffer = null;
        this.bufferPos = 0;
        this.internalState = new long[16];
        this.chainValue = null;
        this.f525134t0 = 0;
        this.f525135t1 = 0;
        this.f525133f0 = 0;
        this.bufferPos = r100.bufferPos;
        this.buffer = Arrays.clone(r100.buffer);
        this.keyLength = r100.keyLength;
        this.key = Arrays.clone(r100.key);
        this.digestLength = r100.digestLength;
        this.chainValue = Arrays.clone(r100.chainValue);
        this.personalization = Arrays.clone(r100.personalization);
        this.salt = Arrays.clone(r100.salt);
        this.f525134t0 = r100.f525134t0;
        this.f525135t1 = r100.f525135t1;
        this.f525133f0 = r100.f525133f0;
    }

    public Blake2bDigest(byte[] r100) {
        this.digestLength = 64;
        this.keyLength = 0;
        this.salt = null;
        this.personalization = null;
        this.key = null;
        this.bufferPos = 0;
        this.internalState = new long[16];
        this.chainValue = null;
        this.f525134t0 = 0;
        this.f525135t1 = 0;
        this.f525133f0 = 0;
        this.buffer = new byte[128];
        if (r100 == null) goto L9;
        byte[] r101 = new byte[r100.length];
        this.key = r101;
        System.arraycopy(r100, 0, r101, 0, r100.length);
        if (r100.length > 64) goto L8;
        this.keyLength = r100.length;
        System.arraycopy(r100, 0, this.buffer, 0, r100.length);
        this.bufferPos = 128;
        goto L9
    L8:
        throw new IllegalArgumentException("Keys > 64 are not supported");
    L9:
        this.digestLength = 64;
        init();
    }

    public Blake2bDigest(byte[] r100, int r101, byte[] r102, byte[] r110) {
        this.digestLength = 64;
        this.keyLength = 0;
        this.salt = null;
        this.personalization = null;
        this.key = null;
        this.bufferPos = 0;
        this.internalState = new long[16];
        this.chainValue = null;
        this.f525134t0 = 0;
        this.f525135t1 = 0;
        this.f525133f0 = 0;
        this.buffer = new byte[128];
        if (r101 < 1) goto L27;
        if (r101 > 64) goto L27;
        this.digestLength = r101;
        if (r102 != null) goto L8;
    L12:
        if (r110 != null) goto L14;
    L18:
        if (r100 == null) goto L24;
        byte[] r103 = new byte[r100.length];
        this.key = r103;
        System.arraycopy(r100, 0, r103, 0, r100.length);
        if (r100.length > 64) goto L23;
        this.keyLength = r100.length;
        System.arraycopy(r100, 0, this.buffer, 0, r100.length);
        this.bufferPos = 128;
        goto L24
    L23:
        throw new IllegalArgumentException("Keys > 64 are not supported");
    L24:
        init();
        return;
    L14:
        if (r110.length != 16) goto L17;
        byte[] r104 = new byte[16];
        this.personalization = r104;
        System.arraycopy(r110, 0, r104, 0, r110.length);
        goto L18
    L17:
        throw new IllegalArgumentException("personalization length must be exactly 16 bytes");
    L8:
        if (r102.length != 16) goto L11;
        byte[] r105 = new byte[16];
        this.salt = r105;
        System.arraycopy(r102, 0, r105, 0, r102.length);
        goto L12
    L11:
        throw new IllegalArgumentException("salt length must be exactly 16 bytes");
    L27:
        throw new IllegalArgumentException("Invalid digest length (required: 1 - 64)");
    }

    private void G(long r100, long r101, int r110, int r111, int r112, int r113) {
        long[] r102 = this.internalState;
        long r103 = (r102[r110] + r102[r111]) + r100;
        r102[r110] = r103;
        r102[r113] = Longs.rotateRight(r102[r113] ^ r103, 32);
        long[] r104 = this.internalState;
        long r105 = r104[r112] + r104[r113];
        r104[r112] = r105;
        r104[r111] = Longs.rotateRight(r105 ^ r104[r111], 24);
        long[] r106 = this.internalState;
        long r107 = (r106[r110] + r106[r111]) + r101;
        r106[r110] = r107;
        r106[r113] = Longs.rotateRight(r106[r113] ^ r107, 16);
        long[] r108 = this.internalState;
        long r109 = r108[r112] + r108[r113];
        r108[r112] = r109;
        r108[r111] = Longs.rotateRight(r109 ^ r108[r111], 63);
    }

    private void compress(byte[] r110, int r111) {
        initializeInternalState();
        long[] r100 = new long[16];
        int r101 = 0;
        int r102 = 0;
    L3:
        if (r102 >= 16) goto L5;
        r100[r102] = Pack.littleEndianToLong(r110, (r102 * 8) + r111);
        r102 = r102 + 1;
        goto L3
    L5:
        int r112 = 0;
    L7:
        if (r112 >= ROUNDS) goto L9;
        byte[][] r113 = blake2b_sigma;
        byte[] r103 = r113[r112];
        G(r100[r103[0]], r100[r103[1]], 0, 4, 8, 12);
        byte[] r104 = r113[r112];
        G(r100[r104[2]], r100[r104[3]], 1, 5, 9, 13);
        byte[] r105 = r113[r112];
        G(r100[r105[4]], r100[r105[5]], 2, 6, 10, 14);
        byte[] r106 = r113[r112];
        G(r100[r106[6]], r100[r106[7]], 3, 7, 11, 15);
        byte[] r107 = r113[r112];
        G(r100[r107[8]], r100[r107[9]], 0, 5, 10, 15);
        byte[] r108 = r113[r112];
        G(r100[r108[10]], r100[r108[11]], 1, 6, 11, 12);
        byte[] r109 = r113[r112];
        G(r100[r109[12]], r100[r109[13]], 2, 7, 8, 13);
        byte[] r114 = r113[r112];
        G(r100[r114[14]], r100[r114[15]], 3, 4, 9, 14);
        r112 = r112 + 1;
    L9:
        long[] r115 = this.chainValue;
        if (r101 >= r115.length) goto L12;
        long r116 = r115[r101];
        long[] r117 = this.internalState;
        r115[r101] = (r116 ^ r117[r101]) ^ r117[r101 + 8];
        r101 = r101 + 1;
        goto L9
    }

    private void init() {
        if (this.chainValue != null) goto L11;
        long[] r100 = {r2[0] ^ ((long) ((this.digestLength | (this.keyLength << 8)) | R.attr.theme)), r2[1], r2[2], r2[3], r5, r2[5], 0, 0};
        this.chainValue = r100;
        long[] r101 = blake2b_IV;
        long r102 = r101[4];
        byte[] r103 = this.salt;
        if (r103 == null) goto L7;
        r100[4] = r102 ^ Pack.littleEndianToLong(r103, 0);
        long[] r104 = this.chainValue;
        r104[5] = r104[5] ^ Pack.littleEndianToLong(this.salt, 8);
    L7:
        long[] r105 = this.chainValue;
        long r106 = r101[6];
        r105[6] = r106;
        r105[7] = r101[7];
        byte[] r107 = this.personalization;
        if (r107 == null) goto L12;
        r105[6] = Pack.littleEndianToLong(r107, 0) ^ r106;
        long[] r108 = this.chainValue;
        r108[7] = r108[7] ^ Pack.littleEndianToLong(this.personalization, 8);
        return;
    L12:
        return;
    }

    private void initializeInternalState() {
        long[] r100 = this.chainValue;
        System.arraycopy(r100, 0, this.internalState, 0, r100.length);
        long[] r101 = blake2b_IV;
        System.arraycopy(r101, 0, this.internalState, this.chainValue.length, 4);
        long[] r102 = this.internalState;
        r102[12] = this.f525134t0 ^ r101[4];
        r102[13] = this.f525135t1 ^ r101[5];
        r102[14] = this.f525133f0 ^ r101[6];
        r102[15] = r101[7];
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
    public int doFinal(byte[] r100, int r110) {
        this.f525133f0 = -1;
        long r101 = this.f525134t0;
        int r102 = this.bufferPos;
        long r103 = r101 + ((long) r102);
        this.f525134t0 = r103;
        if (r102 > 0) goto L5;
    L7:
        compress(this.buffer, 0);
        Arrays.fill(this.buffer, (byte) 0);
        Arrays.fill(this.internalState, 0);
        int r104 = 0;
    L8:
        long[] r105 = this.chainValue;
        if (r104 >= r105.length) goto L17;
        int r106 = r104 * 8;
        if (r106 >= this.digestLength) goto L17;
        byte[] r107 = Pack.longToLittleEndian(r105[r104]);
        int r108 = this.digestLength;
        if (r106 >= (r108 - 8)) goto L15;
        System.arraycopy(r107, 0, r100, r106 + r110, 8);
    L16:
        r104 = r104 + 1;
        goto L8
    L15:
        System.arraycopy(r107, 0, r100, r110 + r106, r108 - r106);
    L17:
        Arrays.fill(r105, 0);
        reset();
        return this.digestLength;
    L5:
        if (r103 != 0) goto L7;
        this.f525135t1++;
        goto L7
    }

    @Override // org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return "BLAKE2b";
    }

    @Override // org.bouncycastle.crypto.ExtendedDigest
    public int getByteLength() {
        return 128;
    }

    @Override // org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return this.digestLength;
    }

    @Override // org.bouncycastle.crypto.Digest
    public void reset() {
        this.bufferPos = 0;
        this.f525133f0 = 0;
        this.f525134t0 = 0;
        this.f525135t1 = 0;
        this.chainValue = null;
        Arrays.fill(this.buffer, (byte) 0);
        byte[] r100 = this.key;
        if (r100 == null) goto L5;
        System.arraycopy(r100, 0, this.buffer, 0, r100.length);
        this.bufferPos = 128;
    L5:
        init();
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte r100) {
        int r101 = this.bufferPos;
        if ((128 - r101) != 0) goto L9;
        long r102 = this.f525134t0 + 128;
        this.f525134t0 = r102;
        if (r102 != 0) goto L7;
        this.f525135t1++;
    L7:
        compress(this.buffer, 0);
        Arrays.fill(this.buffer, (byte) 0);
        this.buffer[0] = r100;
        this.bufferPos = 1;
        return;
    L9:
        this.buffer[r101] = r100;
        this.bufferPos = r101 + 1;
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte[] r110, int r111, int r112) {
        if (r110 == null) goto L24;
        if (r112 == 0) goto L28;
        int r100 = this.bufferPos;
        if (r100 == 0) goto L16;
        int r101 = 128 - r100;
        if (r101 >= r112) goto L13;
        System.arraycopy(r110, r111, this.buffer, r100, r101);
        long r102 = this.f525134t0 + 128;
        this.f525134t0 = r102;
        if (r102 != 0) goto L12;
        this.f525135t1++;
    L12:
        compress(this.buffer, 0);
        this.bufferPos = 0;
        Arrays.fill(this.buffer, (byte) 0);
    L17:
        int r113 = r112 + r111;
        int r103 = r113 + a.f25611g;
        int r114 = r111 + r101;
    L18:
        if (r114 >= r103) goto L23;
        long r104 = this.f525134t0 + 128;
        this.f525134t0 = r104;
        if (r104 != 0) goto L22;
        this.f525135t1++;
    L22:
        compress(r110, r114);
        r114 = r114 + 128;
        goto L18
    L23:
        r112 = r113 - r114;
        System.arraycopy(r110, r114, this.buffer, 0, r112);
    L14:
        this.bufferPos += r112;
        return;
    L13:
        System.arraycopy(r110, r111, this.buffer, r100, r112);
        goto L14
    L16:
        r101 = 0;
        goto L17
    L28:
        return;
    }
}
