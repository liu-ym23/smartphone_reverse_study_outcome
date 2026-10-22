package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class SipHash implements Mac {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final int f525249c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final int f525250d;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    protected long f525251k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    protected long f525252k1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected long f525253m;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    protected long f525254v0;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    protected long f525255v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    protected long f525256v2;

    /* JADX INFO: renamed from: v3, reason: collision with root package name */
    protected long f525257v3;
    protected int wordCount;
    protected int wordPos;

    public SipHash() {
        this.f525253m = 0;
        this.wordPos = 0;
        this.wordCount = 0;
        this.f525249c = 2;
        this.f525250d = 4;
    }

    public SipHash(int r100, int r101) {
        this.f525253m = 0;
        this.wordPos = 0;
        this.wordCount = 0;
        this.f525249c = r100;
        this.f525250d = r101;
    }

    public static long rotateLeft(long r100, int r101) {
        long r102 = r100 << r101;
        return (r100 >>> (-r101)) | r102;
    }

    public void applySipRounds(int r110) {
        long r100 = this.f525254v0;
        long r101 = this.f525255v1;
        long r102 = this.f525256v2;
        long r103 = this.f525257v3;
        int r104 = 0;
    L3:
        if (r104 >= r110) goto L5;
        long r105 = r100 + r101;
        long r106 = r102 + r103;
        long r107 = rotateLeft(r101, 13);
        long r108 = r107 ^ r105;
        long r109 = rotateLeft(r103, 16) ^ r106;
        long r111 = r106 + r108;
        r100 = rotateLeft(r105, 32) + r109;
        long r112 = rotateLeft(r108, 17);
        r101 = r112 ^ r111;
        r103 = rotateLeft(r109, 21) ^ r100;
        r102 = rotateLeft(r111, 32);
        r104 = r104 + 1;
        goto L3
    L5:
        this.f525254v0 = r100;
        this.f525255v1 = r101;
        this.f525256v2 = r102;
        this.f525257v3 = r103;
    }

    @Override // org.bouncycastle.crypto.Mac
    public int doFinal(byte[] r100, int r101) throws DataLengthException, IllegalStateException {
        Pack.longToLittleEndian(doFinal(), r100, r101);
        return 8;
    }

    public long doFinal() throws DataLengthException, IllegalStateException {
        long r100 = this.f525253m;
        int r101 = this.wordPos;
        this.f525253m = ((r100 >>> ((7 - r101) << 3)) >>> 8) | ((((long) ((this.wordCount << 3) + r101)) & 255) << 56);
        processMessageWord();
        this.f525256v2 ^= 255;
        applySipRounds(this.f525250d);
        long r102 = ((this.f525254v0 ^ this.f525255v1) ^ this.f525256v2) ^ this.f525257v3;
        reset();
        return r102;
    }

    @Override // org.bouncycastle.crypto.Mac
    public String getAlgorithmName() {
        return "SipHash-" + this.f525249c + "-" + this.f525250d;
    }

    @Override // org.bouncycastle.crypto.Mac
    public int getMacSize() {
        return 8;
    }

    @Override // org.bouncycastle.crypto.Mac
    public void init(CipherParameters r100) throws IllegalArgumentException {
        if ((r100 instanceof KeyParameter) == false) goto L11;
        byte[] r101 = ((KeyParameter) r100).getKey();
        if (r101.length != 16) goto L9;
        this.f525251k0 = Pack.littleEndianToLong(r101, 0);
        this.f525252k1 = Pack.littleEndianToLong(r101, 8);
        reset();
        return;
    L9:
        throw new IllegalArgumentException("'params' must be a 128-bit key");
    L11:
        throw new IllegalArgumentException("'params' must be an instance of KeyParameter");
    }

    public void processMessageWord() {
        this.wordCount++;
        this.f525257v3 ^= this.f525253m;
        applySipRounds(this.f525249c);
        this.f525254v0 ^= this.f525253m;
    }

    @Override // org.bouncycastle.crypto.Mac
    public void reset() {
        long r100 = this.f525251k0;
        this.f525254v0 = 8317987319222330741L ^ r100;
        long r101 = this.f525252k1;
        this.f525255v1 = 7237128888997146477L ^ r101;
        this.f525256v2 = r100 ^ 7816392313619706465L;
        this.f525257v3 = 8387220255154660723L ^ r101;
        this.f525253m = 0;
        this.wordPos = 0;
        this.wordCount = 0;
    }

    @Override // org.bouncycastle.crypto.Mac
    public void update(byte r100) throws IllegalStateException {
        this.f525253m = (this.f525253m >>> 8) | ((((long) r100) & 255) << 56);
        int r101 = this.wordPos + 1;
        this.wordPos = r101;
        if (r101 != 8) goto L6;
        processMessageWord();
        this.wordPos = 0;
        return;
    }

    @Override // org.bouncycastle.crypto.Mac
    public void update(byte[] r110, int r111, int r112) throws DataLengthException, IllegalStateException {
        int r100 = r112 & (-8);
        int r101 = this.wordPos;
        int r102 = 0;
        if (r101 != 0) goto L9;
    L4:
        if (r102 >= r100) goto L6;
        this.f525253m = Pack.littleEndianToLong(r110, r111 + r102);
        processMessageWord();
        r102 = r102 + 8;
    L6:
        if (r102 >= r112) goto L8;
        this.f525253m = (this.f525253m >>> 8) | ((((long) r110[r111 + r102]) & 255) << 56);
        r102 = r102 + 1;
        goto L6
    L8:
        this.wordPos = r112 - r100;
        return;
    L9:
        int r103 = r101 << 3;
        int r113 = 0;
    L10:
        if (r113 >= r100) goto L12;
        long r114 = Pack.littleEndianToLong(r110, r111 + r113);
        long r104 = this.f525253m >>> (-r103);
        this.f525253m = r104 | (r114 << r103);
        processMessageWord();
        this.f525253m = r114;
        r113 = r113 + 8;
    L12:
        if (r113 >= r112) goto L24;
        this.f525253m = (this.f525253m >>> 8) | ((((long) r110[r111 + r113]) & 255) << 56);
        int r105 = this.wordPos + 1;
        this.wordPos = r105;
        if (r105 != 8) goto L16;
        processMessageWord();
        this.wordPos = 0;
    L16:
        r113 = r113 + 1;
        goto L12
    }
}
