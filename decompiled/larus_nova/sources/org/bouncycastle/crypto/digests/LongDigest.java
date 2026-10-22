package org.bouncycastle.crypto.digests;

import androidx.compose.ui.spatial.RectListKt;
import kotlin.jvm.internal.ByteCompanionObject;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public abstract class LongDigest implements ExtendedDigest, Memoable, EncodableDigest {
    private static final int BYTE_LENGTH = 128;
    static final long[] K = null;
    protected long H1;
    protected long H2;
    protected long H3;
    protected long H4;
    protected long H5;
    protected long H6;
    protected long H7;
    protected long H8;
    private long[] W;
    private long byteCount1;
    private long byteCount2;
    private int wOff;
    private byte[] xBuf;
    private int xBufOff;

    static {
        K = new long[]{4794697086780616226L, 8158064640168781261L, -5349999486874862801L, -1606136188198331460L, 4131703408338449720L, 6480981068601479193L, -7908458776815382629L, -6116909921290321640L, -2880145864133508542L, 1334009975649890238L, 2608012711638119052L, 6128411473006802146L, 8268148722764581231L, -9160688886553864527L, -7215885187991268811L, -4495734319001033068L, -1973867731355612462L, -1171420211273849373L, 1135362057144423861L, 2597628984639134821L, 3308224258029322869L, 5365058923640841347L, 6679025012923562964L, 8573033837759648693L, -7476448914759557205L, -6327057829258317296L, -5763719355590565569L, -4658551843659510044L, -4116276920077217854L, -3051310485924567259L, 489312712824947311L, 1452737877330783856L, 2861767655752347644L, 3322285676063803686L, 5560940570517711597L, 5996557281743188959L, 7280758554555802590L, 8532644243296465576L, -9096487096722542874L, -7894198246740708037L, -6719396339535248540L, -6333637450476146687L, -4446306890439682159L, -4076793802049405392L, -3345356375505022440L, -2983346525034927856L, -860691631967231958L, 1182934255886127544L, 1847814050463011016L, 2177327727835720531L, 2830643537854262169L, 3796741975233480872L, 4115178125766777443L, 5681478168544905931L, 6601373596472566643L, 7507060721942968483L, 8399075790359081724L, 8693463985226723168L, -8878714635349349518L, -8302665154208450068L, -8016688836872298968L, -6606660893046293015L, -4685533653050689259L, -4147400797238176981L, -3880063495543823972L, -3348786107499101689L, -1523767162380948706L, -757361751448694408L, 500013540394364858L, 748580250866718886L, 1242879168328830382L, 1977374033974150939L, 2944078676154940804L, 3659926193048069267L, 4368137639120453308L, 4836135668995329356L, 5532061633213252278L, 6448918945643986474L, 6902733635092675308L, 7801388544844847127L};
    }

    public LongDigest() {
        this.xBuf = new byte[8];
        this.W = new long[80];
        this.xBufOff = 0;
        reset();
    }

    public LongDigest(LongDigest r100) {
        this.xBuf = new byte[8];
        this.W = new long[80];
        copyIn(r100);
    }

    private long Ch(long r100, long r101, long r102) {
        long r103 = r101 & r100;
        return ((~r100) & r102) ^ r103;
    }

    private long Maj(long r100, long r101, long r102) {
        long r103 = r100 & r101;
        return ((r100 & r102) ^ r103) ^ (r101 & r102);
    }

    private long Sigma0(long r100) {
        long r101 = ((r100 << 63) | (r100 >>> 1)) ^ ((r100 << 56) | (r100 >>> 8));
        return (r100 >>> 7) ^ r101;
    }

    private long Sigma1(long r100) {
        long r101 = ((r100 << 45) | (r100 >>> 19)) ^ ((r100 << 3) | (r100 >>> 61));
        return (r100 >>> 6) ^ r101;
    }

    private long Sum0(long r100) {
        long r101 = ((r100 << 36) | (r100 >>> 28)) ^ ((r100 << 30) | (r100 >>> 34));
        long r102 = r100 << 25;
        return ((r100 >>> 39) | r102) ^ r101;
    }

    private long Sum1(long r100) {
        long r101 = ((r100 << 50) | (r100 >>> 14)) ^ ((r100 << 46) | (r100 >>> 18));
        long r102 = r100 << 23;
        return ((r100 >>> 41) | r102) ^ r101;
    }

    private void adjustByteCounts() {
        long r100 = this.byteCount1;
        if (r100 <= RectListKt.TombStone) goto L6;
        this.byteCount2 += r100 >>> 61;
        this.byteCount1 = r100 & RectListKt.TombStone;
        return;
    }

    public void copyIn(LongDigest r100) {
        byte[] r101 = r100.xBuf;
        System.arraycopy(r101, 0, this.xBuf, 0, r101.length);
        this.xBufOff = r100.xBufOff;
        this.byteCount1 = r100.byteCount1;
        this.byteCount2 = r100.byteCount2;
        this.H1 = r100.H1;
        this.H2 = r100.H2;
        this.H3 = r100.H3;
        this.H4 = r100.H4;
        this.H5 = r100.H5;
        this.H6 = r100.H6;
        this.H7 = r100.H7;
        this.H8 = r100.H8;
        long[] r102 = r100.W;
        System.arraycopy(r102, 0, this.W, 0, r102.length);
        this.wOff = r100.wOff;
    }

    public void finish() {
        adjustByteCounts();
        long r100 = this.byteCount1 << 3;
        long r101 = this.byteCount2;
        byte r102 = ByteCompanionObject.MIN_VALUE;
    L3:
        update(r102);
        if (this.xBufOff == 0) goto L6;
        r102 = 0;
        goto L3
    L6:
        processLength(r100, r101);
        processBlock();
    }

    @Override // org.bouncycastle.crypto.ExtendedDigest
    public int getByteLength() {
        return 128;
    }

    public int getEncodedStateSize() {
        return (this.wOff * 8) + 96;
    }

    public void populateState(byte[] r100) {
        int r101 = 0;
        System.arraycopy(this.xBuf, 0, r100, 0, this.xBufOff);
        Pack.intToBigEndian(this.xBufOff, r100, 8);
        Pack.longToBigEndian(this.byteCount1, r100, 12);
        Pack.longToBigEndian(this.byteCount2, r100, 20);
        Pack.longToBigEndian(this.H1, r100, 28);
        Pack.longToBigEndian(this.H2, r100, 36);
        Pack.longToBigEndian(this.H3, r100, 44);
        Pack.longToBigEndian(this.H4, r100, 52);
        Pack.longToBigEndian(this.H5, r100, 60);
        Pack.longToBigEndian(this.H6, r100, 68);
        Pack.longToBigEndian(this.H7, r100, 76);
        Pack.longToBigEndian(this.H8, r100, 84);
        Pack.intToBigEndian(this.wOff, r100, 92);
    L4:
        if (r101 >= this.wOff) goto L6;
        Pack.longToBigEndian(this.W[r101], r100, (r101 * 8) + 96);
        r101 = r101 + 1;
        goto L4
    }

    public void processBlock() {
        adjustByteCounts();
        int r100 = 16;
    L4:
        if (r100 > 79) goto L6;
        long[] r101 = this.W;
        long r102 = Sigma1(r101[r100 - 2]);
        long[] r103 = this.W;
        r101[r100] = ((r102 + r103[r100 - 7]) + Sigma0(r103[r100 - 15])) + this.W[r100 - 16];
        r100 = r100 + 1;
        goto L4
    L6:
        long r104 = this.H1;
        long r105 = this.H2;
        long r106 = this.H3;
        long r107 = this.H4;
        long r110 = this.H5;
        long r111 = this.H6;
        long r108 = this.H7;
        long r210 = r111;
        long r112 = r107;
        int r211 = 0;
        long r113 = r105;
        long r114 = r106;
        long r109 = r110;
        int r115 = 0;
        long r116 = this.H8;
        long r117 = r104;
        long r118 = r108;
    L8:
        if (r115 >= 10) goto L10;
        long r212 = r109;
        long r213 = Sum1(r109) + Ch(r109, r210, r118);
        long[] r214 = K;
        int r310 = r211 + 1;
        long r119 = r116 + ((r213 + r214[r211]) + this.W[r211]);
        long r120 = r112 + r119;
        long r121 = r119 + (Sum0(r117) + Maj(r117, r113, r114));
        int r215 = r310 + 1;
        long r122 = r118 + (((Sum1(r120) + Ch(r120, r212, r210)) + r214[r310]) + this.W[r310]);
        long r123 = r114 + r122;
        long r124 = r122 + (Sum0(r121) + Maj(r121, r117, r113));
        int r125 = r215 + 1;
        long r216 = r210 + (((Sum1(r123) + Ch(r123, r120, r212)) + r214[r215]) + this.W[r215]);
        long r126 = r113 + r216;
        long r127 = r216 + (Sum0(r124) + Maj(r124, r121, r117));
        int r217 = r125 + 1;
        long r128 = r212 + (((Sum1(r126) + Ch(r126, r123, r120)) + r214[r125]) + this.W[r125]);
        long r129 = r117 + r128;
        long r130 = r128 + (Sum0(r127) + Maj(r127, r124, r121));
        int r131 = r217 + 1;
        long r132 = r120 + (((Sum1(r129) + Ch(r129, r126, r123)) + r214[r217]) + this.W[r217]);
        long r133 = r121 + r132;
        long r134 = r132 + (Sum0(r130) + Maj(r130, r127, r124));
        int r218 = r131 + 1;
        long r135 = r123 + (((Sum1(r133) + Ch(r133, r129, r126)) + r214[r131]) + this.W[r131]);
        long r136 = r124 + r135;
        long r137 = r135 + (Sum0(r134) + Maj(r134, r130, r127));
        r118 = r136;
        int r138 = r218 + 1;
        long r139 = r126 + (((Sum1(r136) + Ch(r136, r133, r129)) + r214[r218]) + this.W[r218]);
        long r140 = r127 + r139;
        r210 = r140;
        r113 = r139 + (Sum0(r137) + Maj(r137, r134, r130));
        long r141 = r129 + (((Sum1(r140) + Ch(r140, r118, r133)) + r214[r138]) + this.W[r138]);
        long r142 = r141 + (Sum0(r113) + Maj(r113, r137, r134));
        r115 = r115 + 1;
        r109 = r130 + r141;
        r114 = r137;
        r116 = r133;
        r112 = r134;
        r211 = r138 + 1;
        r117 = r142;
        goto L8
    L10:
        this.H1 += r117;
        this.H2 += r113;
        this.H3 += r114;
        this.H4 += r112;
        this.H5 = this.H5 + r109;
        this.H6 += r210;
        this.H7 += r118;
        this.H8 += r116;
        this.wOff = 0;
        int r143 = 0;
    L11:
        if (r143 >= 16) goto L13;
        this.W[r143] = 0;
        r143 = r143 + 1;
        goto L11
    }

    public void processLength(long r100, long r101) {
        if (this.wOff <= 14) goto L5;
        processBlock();
    L5:
        long[] r102 = this.W;
        r102[14] = r101;
        r102[15] = r100;
    }

    public void processWord(byte[] r100, int r101) {
        this.W[this.wOff] = Pack.bigEndianToLong(r100, r101);
        int r102 = this.wOff + 1;
        this.wOff = r102;
        if (r102 != 16) goto L6;
        processBlock();
        return;
    }

    @Override // org.bouncycastle.crypto.Digest
    public void reset() {
        this.byteCount1 = 0;
        this.byteCount2 = 0;
        int r100 = 0;
        this.xBufOff = 0;
        int r101 = 0;
    L3:
        byte[] r102 = this.xBuf;
        if (r101 >= r102.length) goto L6;
        r102[r101] = 0;
        r101 = r101 + 1;
        goto L3
    L6:
        this.wOff = 0;
    L7:
        long[] r103 = this.W;
        if (r100 == r103.length) goto L10;
        r103[r100] = 0;
        r100 = r100 + 1;
        goto L7
    }

    public void restoreState(byte[] r100) {
        int r101 = Pack.bigEndianToInt(r100, 8);
        this.xBufOff = r101;
        int r102 = 0;
        System.arraycopy(r100, 0, this.xBuf, 0, r101);
        this.byteCount1 = Pack.bigEndianToLong(r100, 12);
        this.byteCount2 = Pack.bigEndianToLong(r100, 20);
        this.H1 = Pack.bigEndianToLong(r100, 28);
        this.H2 = Pack.bigEndianToLong(r100, 36);
        this.H3 = Pack.bigEndianToLong(r100, 44);
        this.H4 = Pack.bigEndianToLong(r100, 52);
        this.H5 = Pack.bigEndianToLong(r100, 60);
        this.H6 = Pack.bigEndianToLong(r100, 68);
        this.H7 = Pack.bigEndianToLong(r100, 76);
        this.H8 = Pack.bigEndianToLong(r100, 84);
        this.wOff = Pack.bigEndianToInt(r100, 92);
    L4:
        if (r102 >= this.wOff) goto L6;
        this.W[r102] = Pack.bigEndianToLong(r100, (r102 * 8) + 96);
        r102 = r102 + 1;
        goto L4
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
        this.byteCount1++;
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte[] r100, int r101, int r102) {
    L3:
        if (this.xBufOff == 0) goto L7;
        if (r102 <= 0) goto L7;
        update(r100[r101]);
        r101 = r101 + 1;
        r102 = r102 - 1;
    L7:
        if (r102 <= this.xBuf.length) goto L9;
        processWord(r100, r101);
        byte[] r103 = this.xBuf;
        r101 = r101 + r103.length;
        r102 = r102 - r103.length;
        this.byteCount1 += (long) r103.length;
    L9:
        if (r102 <= 0) goto L11;
        update(r100[r101]);
        r101 = r101 + 1;
        r102 = r102 - 1;
        goto L9
    }
}
