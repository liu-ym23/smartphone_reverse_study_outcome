package org.bouncycastle.crypto.macs;

import androidx.compose.ui.spatial.RectListKt;
import org.bouncycastle.asn1.cmc.BodyPartID;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class Poly1305 implements Mac {
    private static final int BLOCK_SIZE = 16;
    private final BlockCipher cipher;
    private final byte[] currentBlock;
    private int currentBlockOffset;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private int f525231h0;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    private int f525232h1;

    /* JADX INFO: renamed from: h2, reason: collision with root package name */
    private int f525233h2;

    /* JADX INFO: renamed from: h3, reason: collision with root package name */
    private int f525234h3;

    /* JADX INFO: renamed from: h4, reason: collision with root package name */
    private int f525235h4;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private int f525236k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    private int f525237k1;

    /* JADX INFO: renamed from: k2, reason: collision with root package name */
    private int f525238k2;

    /* JADX INFO: renamed from: k3, reason: collision with root package name */
    private int f525239k3;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private int f525240r0;

    /* JADX INFO: renamed from: r1, reason: collision with root package name */
    private int f525241r1;

    /* JADX INFO: renamed from: r2, reason: collision with root package name */
    private int f525242r2;

    /* JADX INFO: renamed from: r3, reason: collision with root package name */
    private int f525243r3;

    /* JADX INFO: renamed from: r4, reason: collision with root package name */
    private int f525244r4;

    /* JADX INFO: renamed from: s1, reason: collision with root package name */
    private int f525245s1;

    /* JADX INFO: renamed from: s2, reason: collision with root package name */
    private int f525246s2;

    /* JADX INFO: renamed from: s3, reason: collision with root package name */
    private int f525247s3;

    /* JADX INFO: renamed from: s4, reason: collision with root package name */
    private int f525248s4;
    private final byte[] singleByte;

    public Poly1305() {
        this.singleByte = new byte[1];
        this.currentBlock = new byte[16];
        this.currentBlockOffset = 0;
        this.cipher = null;
    }

    public Poly1305(BlockCipher r100) {
        this.singleByte = new byte[1];
        this.currentBlock = new byte[16];
        this.currentBlockOffset = 0;
        if (r100.getBlockSize() != 16) goto L7;
        this.cipher = r100;
        return;
    L7:
        throw new IllegalArgumentException("Poly1305 requires a 128 bit block cipher.");
    }

    private static final long mul32x32_64(int r100, int r101) {
        return (((long) r100) & BodyPartID.bodyIdMax) * ((long) r101);
    }

    private void processBlock() {
        int r100 = this.currentBlockOffset;
        if (r100 >= 16) goto L7;
        this.currentBlock[r100] = 1;
        int r101 = r100 + 1;
    L5:
        if (r101 >= 16) goto L7;
        this.currentBlock[r101] = 0;
        r101 = r101 + 1;
    L7:
        long r102 = ((long) Pack.littleEndianToInt(this.currentBlock, 0)) & BodyPartID.bodyIdMax;
        long r103 = ((long) Pack.littleEndianToInt(this.currentBlock, 4)) & BodyPartID.bodyIdMax;
        long r110 = ((long) Pack.littleEndianToInt(this.currentBlock, 8)) & BodyPartID.bodyIdMax;
        long r104 = BodyPartID.bodyIdMax & ((long) Pack.littleEndianToInt(this.currentBlock, 12));
        int r105 = (int) (((long) this.f525231h0) + (r102 & 67108863));
        this.f525231h0 = r105;
        this.f525232h1 = (int) (((long) this.f525232h1) + ((((r103 << 32) | r102) >>> 26) & 67108863));
        this.f525233h2 = (int) (((long) this.f525233h2) + (((r103 | (r110 << 32)) >>> 20) & 67108863));
        this.f525234h3 = (int) (((long) this.f525234h3) + ((((r104 << 32) | r110) >>> 14) & 67108863));
        int r106 = (int) (((long) this.f525235h4) + (r104 >>> 8));
        this.f525235h4 = r106;
        if (this.currentBlockOffset != 16) goto L10;
        this.f525235h4 = r106 + 16777216;
    L10:
        long r107 = (((mul32x32_64(r105, this.f525240r0) + mul32x32_64(this.f525232h1, this.f525248s4)) + mul32x32_64(this.f525233h2, this.f525247s3)) + mul32x32_64(this.f525234h3, this.f525246s2)) + mul32x32_64(this.f525235h4, this.f525245s1);
        long r108 = (((mul32x32_64(this.f525231h0, this.f525241r1) + mul32x32_64(this.f525232h1, this.f525240r0)) + mul32x32_64(this.f525233h2, this.f525248s4)) + mul32x32_64(this.f525234h3, this.f525247s3)) + mul32x32_64(this.f525235h4, this.f525246s2);
        long r109 = (((mul32x32_64(this.f525231h0, this.f525242r2) + mul32x32_64(this.f525232h1, this.f525241r1)) + mul32x32_64(this.f525233h2, this.f525240r0)) + mul32x32_64(this.f525234h3, this.f525248s4)) + mul32x32_64(this.f525235h4, this.f525247s3);
        long r111 = (((mul32x32_64(this.f525231h0, this.f525243r3) + mul32x32_64(this.f525232h1, this.f525242r2)) + mul32x32_64(this.f525233h2, this.f525241r1)) + mul32x32_64(this.f525234h3, this.f525240r0)) + mul32x32_64(this.f525235h4, this.f525248s4);
        long r112 = (((mul32x32_64(this.f525231h0, this.f525244r4) + mul32x32_64(this.f525232h1, this.f525243r3)) + mul32x32_64(this.f525233h2, this.f525242r2)) + mul32x32_64(this.f525234h3, this.f525241r1)) + mul32x32_64(this.f525235h4, this.f525240r0);
        int r113 = ((int) r107) & RectListKt.Lower26Bits;
        long r114 = r108 + (r107 >>> 26);
        int r115 = ((int) r114) & RectListKt.Lower26Bits;
        long r116 = r109 + (r114 >>> 26);
        this.f525233h2 = ((int) r116) & RectListKt.Lower26Bits;
        long r117 = r111 + (r116 >>> 26);
        this.f525234h3 = ((int) r117) & RectListKt.Lower26Bits;
        long r118 = r112 + (r117 >>> 26);
        this.f525235h4 = ((int) r118) & RectListKt.Lower26Bits;
        int r119 = r113 + (((int) (r118 >>> 26)) * 5);
        this.f525232h1 = r115 + (r119 >>> 26);
        this.f525231h0 = r119 & RectListKt.Lower26Bits;
    }

    private void setKey(byte[] r110, byte[] r111) {
        if (r110.length != 32) goto L19;
        int r100 = 16;
        if (this.cipher == null) goto L12;
        if (r111 == null) goto L11;
        if (r111.length == 16) goto L12;
    L11:
        throw new IllegalArgumentException("Poly1305 requires a 128 bit IV.");
    L12:
        int r101 = Pack.littleEndianToInt(r110, 0);
        int r102 = Pack.littleEndianToInt(r110, 4);
        int r103 = Pack.littleEndianToInt(r110, 8);
        int r104 = Pack.littleEndianToInt(r110, 12);
        this.f525240r0 = 67108863 & r101;
        int r105 = ((r101 >>> 26) | (r102 << 6)) & 67108611;
        this.f525241r1 = r105;
        int r106 = ((r102 >>> 20) | (r103 << 12)) & 67092735;
        this.f525242r2 = r106;
        int r107 = ((r103 >>> 14) | (r104 << 18)) & 66076671;
        this.f525243r3 = r107;
        int r108 = (r104 >>> 8) & 1048575;
        this.f525244r4 = r108;
        this.f525245s1 = r105 * 5;
        this.f525246s2 = r106 * 5;
        this.f525247s3 = r107 * 5;
        this.f525248s4 = r108 * 5;
        BlockCipher r109 = this.cipher;
        if (r109 == null) goto L16;
        byte[] r112 = new byte[16];
        r109.init(true, new KeyParameter(r110, 16, 16));
        this.cipher.processBlock(r111, 0, r112, 0);
        r110 = r112;
        r100 = 0;
    L16:
        this.f525236k0 = Pack.littleEndianToInt(r110, r100 + 0);
        this.f525237k1 = Pack.littleEndianToInt(r110, r100 + 4);
        this.f525238k2 = Pack.littleEndianToInt(r110, r100 + 8);
        this.f525239k3 = Pack.littleEndianToInt(r110, r100 + 12);
        return;
    L19:
        throw new IllegalArgumentException("Poly1305 key must be 256 bits.");
    }

    @Override // org.bouncycastle.crypto.Mac
    public int doFinal(byte[] r110, int r111) throws DataLengthException, IllegalStateException {
        if ((r111 + 16) > r110.length) goto L10;
        if (this.currentBlockOffset <= 0) goto L7;
        processBlock();
    L7:
        int r100 = this.f525232h1;
        int r101 = this.f525231h0;
        int r102 = r100 + (r101 >>> 26);
        int r103 = r101 & RectListKt.Lower26Bits;
        int r104 = this.f525233h2 + (r102 >>> 26);
        int r105 = r102 & RectListKt.Lower26Bits;
        int r106 = this.f525234h3 + (r104 >>> 26);
        int r107 = r104 & RectListKt.Lower26Bits;
        int r108 = this.f525235h4 + (r106 >>> 26);
        int r109 = r106 & RectListKt.Lower26Bits;
        int r112 = r103 + ((r108 >>> 26) * 5);
        int r113 = r108 & RectListKt.Lower26Bits;
        int r114 = r105 + (r112 >>> 26);
        int r115 = r112 & RectListKt.Lower26Bits;
        int r116 = r115 + 5;
        int r117 = r116 >>> 26;
        int r118 = r116 & RectListKt.Lower26Bits;
        int r119 = r117 + r114;
        int r120 = r119 >>> 26;
        int r121 = r119 & RectListKt.Lower26Bits;
        int r122 = r120 + r107;
        int r123 = r122 >>> 26;
        int r124 = r122 & RectListKt.Lower26Bits;
        int r125 = r123 + r109;
        int r126 = 67108863 & r125;
        int r127 = ((r125 >>> 26) + r113) - 67108864;
        int r128 = (r127 >>> 31) - 1;
        int r129 = ~r128;
        int r130 = (r115 & r129) | (r118 & r128);
        this.f525231h0 = r130;
        int r131 = (r114 & r129) | (r121 & r128);
        this.f525232h1 = r131;
        int r132 = (r107 & r129) | (r124 & r128);
        this.f525233h2 = r132;
        int r133 = (r126 & r128) | (r109 & r129);
        this.f525234h3 = r133;
        int r134 = (r113 & r129) | (r127 & r128);
        this.f525235h4 = r134;
        long r135 = (((long) (r130 | (r131 << 26))) & BodyPartID.bodyIdMax) + (((long) this.f525236k0) & BodyPartID.bodyIdMax);
        long r136 = (((long) ((r131 >>> 6) | (r132 << 20))) & BodyPartID.bodyIdMax) + (((long) this.f525237k1) & BodyPartID.bodyIdMax);
        long r137 = (((long) ((r132 >>> 12) | (r133 << 14))) & BodyPartID.bodyIdMax) + (((long) this.f525238k2) & BodyPartID.bodyIdMax);
        long r138 = (((long) ((r133 >>> 18) | (r134 << 8))) & BodyPartID.bodyIdMax) + (BodyPartID.bodyIdMax & ((long) this.f525239k3));
        Pack.intToLittleEndian((int) r135, r110, r111);
        long r139 = r136 + (r135 >>> 32);
        Pack.intToLittleEndian((int) r139, r110, r111 + 4);
        long r140 = r137 + (r139 >>> 32);
        Pack.intToLittleEndian((int) r140, r110, r111 + 8);
        Pack.intToLittleEndian((int) (r138 + (r140 >>> 32)), r110, r111 + 12);
        reset();
        return 16;
    L10:
        throw new OutputLengthException("Output buffer is too short.");
    }

    @Override // org.bouncycastle.crypto.Mac
    public String getAlgorithmName() {
        if (this.cipher != null) goto L6;
        return "Poly1305";
    L6:
        return "Poly1305-" + this.cipher.getAlgorithmName();
    }

    @Override // org.bouncycastle.crypto.Mac
    public int getMacSize() {
        return 16;
    }

    @Override // org.bouncycastle.crypto.Mac
    public void init(CipherParameters r100) throws IllegalArgumentException {
        if (this.cipher != null) goto L5;
        byte[] r101 = null;
    L11:
        if ((r100 instanceof KeyParameter) == false) goto L15;
        setKey(((KeyParameter) r100).getKey(), r101);
        reset();
        return;
    L15:
        throw new IllegalArgumentException("Poly1305 requires a key.");
    L5:
        if ((r100 instanceof ParametersWithIV) == false) goto L8;
        ParametersWithIV r102 = (ParametersWithIV) r100;
        r101 = r102.getIV();
        r100 = r102.getParameters();
        goto L11
    L8:
        throw new IllegalArgumentException("Poly1305 requires an IV when used with a block cipher.");
    }

    @Override // org.bouncycastle.crypto.Mac
    public void reset() {
        this.currentBlockOffset = 0;
        this.f525235h4 = 0;
        this.f525234h3 = 0;
        this.f525233h2 = 0;
        this.f525232h1 = 0;
        this.f525231h0 = 0;
    }

    @Override // org.bouncycastle.crypto.Mac
    public void update(byte r100) throws IllegalStateException {
        byte[] r101 = this.singleByte;
        r101[0] = r100;
        update(r101, 0, 1);
    }

    @Override // org.bouncycastle.crypto.Mac
    public void update(byte[] r100, int r101, int r102) throws DataLengthException, IllegalStateException {
        int r103 = 0;
    L3:
        if (r102 <= r103) goto L8;
        if (this.currentBlockOffset != 16) goto L7;
        processBlock();
        this.currentBlockOffset = 0;
    L7:
        int r104 = Math.min(r102 - r103, 16 - this.currentBlockOffset);
        System.arraycopy(r100, r103 + r101, this.currentBlock, this.currentBlockOffset, r104);
        r103 = r103 + r104;
        this.currentBlockOffset += r104;
        goto L3
    }
}
