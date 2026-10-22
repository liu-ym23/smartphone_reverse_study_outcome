package org.bouncycastle.pqc.math.linearalgebra;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.collection.SieveCacheKt;
import androidx.compose.ui.spatial.RectListKt;
import com.baidu.bbalbscesium.i.j;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import com.larus.dora.impl.ota.g2.j0;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.asn1.cmc.BodyPartID;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class GF2nONBElement extends GF2nElement {
    private static final int MAXLONG = 64;
    private static final long[] mBitmask = null;
    private static final int[] mIBY64 = null;
    private static final long[] mMaxmask = null;
    private int mBit;
    private int mLength;
    private long[] mPol;

    static {
        mBitmask = new long[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, PlaybackStateCompat.ACTION_PLAY_FROM_URI, 16384, PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID, PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH, PlaybackStateCompat.ACTION_PREPARE_FROM_URI, PlaybackStateCompat.ACTION_SET_REPEAT_MODE, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED, 1048576, 2097152, 4194304, 8388608, 16777216, 33554432, 67108864, 134217728, 268435456, 536870912, 1073741824, j0.G2_OTA_SPACE_RESERVE_BYTES, 4294967296L, 8589934592L, 17179869184L, 34359738368L, 68719476736L, 137438953472L, 274877906944L, 549755813888L, DownloadConstants.TB, 2199023255552L, 4398046511104L, 8796093022208L, 17592186044416L, 35184372088832L, 70368744177664L, 140737488355328L, 281474976710656L, 562949953421312L, 1125899906842624L, 2251799813685248L, 4503599627370496L, 9007199254740992L, 18014398509481984L, 36028797018963968L, 72057594037927936L, 144115188075855872L, 288230376151711744L, 576460752303423488L, 1152921504606846976L, 2305843009213693952L, SieveCacheKt.NodeVisitedBit, Long.MIN_VALUE};
        mMaxmask = new long[]{1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, SieveCacheKt.NodeLinkMask, BodyPartID.bodyIdMax, 8589934591L, 17179869183L, 34359738367L, 68719476735L, 137438953471L, 274877906943L, 549755813887L, j.f30151d, 2199023255551L, 4398046511103L, 8796093022207L, 17592186044415L, 35184372088831L, 70368744177663L, 140737488355327L, 281474976710655L, 562949953421311L, 1125899906842623L, 2251799813685247L, 4503599627370495L, 9007199254740991L, 18014398509481983L, 36028797018963967L, 72057594037927935L, 144115188075855871L, 288230376151711743L, 576460752303423487L, 1152921504606846975L, RectListKt.TombStone, 4611686018427387903L, Long.MAX_VALUE, -1};
        mIBY64 = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
    }

    public GF2nONBElement(GF2nONBElement r100) {
        GF2nField r101 = r100.mField;
        this.mField = r101;
        this.mDegree = r101.getDegree();
        this.mLength = ((GF2nONBField) this.mField).getONBLength();
        this.mBit = ((GF2nONBField) this.mField).getONBBit();
        this.mPol = new long[this.mLength];
        assign(r100.getElement());
    }

    public GF2nONBElement(GF2nONBField r100, BigInteger r101) {
        this.mField = r100;
        this.mDegree = r100.getDegree();
        this.mLength = r100.getONBLength();
        this.mBit = r100.getONBBit();
        this.mPol = new long[this.mLength];
        assign(r101);
    }

    public GF2nONBElement(GF2nONBField r100, SecureRandom r101) {
        this.mField = r100;
        this.mDegree = r100.getDegree();
        this.mLength = r100.getONBLength();
        this.mBit = r100.getONBBit();
        int r102 = this.mLength;
        long[] r103 = new long[r102];
        this.mPol = r103;
        int r104 = 0;
        if (r102 > 1) goto L5;
        r103[0] = r101.nextLong();
        long[] r105 = this.mPol;
        r105[0] = r105[0] >>> (64 - this.mBit);
        return;
    L5:
        if (r104 >= (this.mLength - 1)) goto L7;
        this.mPol[r104] = r101.nextLong();
        r104 = r104 + 1;
        goto L5
    L7:
        long r106 = r101.nextLong();
        this.mPol[this.mLength - 1] = r106 >>> (64 - this.mBit);
    }

    public GF2nONBElement(GF2nONBField r100, byte[] r101) {
        this.mField = r100;
        this.mDegree = r100.getDegree();
        this.mLength = r100.getONBLength();
        this.mBit = r100.getONBBit();
        this.mPol = new long[this.mLength];
        assign(r101);
    }

    private GF2nONBElement(GF2nONBField r100, long[] r101) {
        this.mField = r100;
        this.mDegree = r100.getDegree();
        this.mLength = r100.getONBLength();
        this.mBit = r100.getONBBit();
        this.mPol = r101;
    }

    public static GF2nONBElement ONE(GF2nONBField r100) {
        int r101 = r100.getONBLength();
        long[] r102 = new long[r101];
        int r103 = 0;
    L3:
        int r104 = r101 - 1;
        if (r103 >= r104) goto L6;
        r102[r103] = -1;
        r103 = r103 + 1;
        goto L3
    L6:
        r102[r104] = mMaxmask[r100.getONBBit() - 1];
        return new GF2nONBElement(r100, r102);
    }

    public static GF2nONBElement ZERO(GF2nONBField r100) {
        return new GF2nONBElement(r100, new long[r100.getONBLength()]);
    }

    private void assign(BigInteger r100) {
        assign(r100.toByteArray());
    }

    private void assign(byte[] r110) {
        this.mPol = new long[this.mLength];
        int r100 = 0;
    L4:
        if (r100 >= r110.length) goto L6;
        long[] r101 = this.mPol;
        int r102 = r100 >>> 3;
        r101[r102] = r101[r102] | ((((long) r110[(r110.length - 1) - r100]) & 255) << ((r100 & 7) << 3));
        r100 = r100 + 1;
        goto L4
    }

    private void assign(long[] r100) {
        System.arraycopy(r100, 0, this.mPol, 0, this.mLength);
    }

    private long[] getElement() {
        long[] r100 = this.mPol;
        long[] r101 = new long[r100.length];
        System.arraycopy(r100, 0, r101, 0, r100.length);
        return r101;
    }

    private long[] getElementReverseOrder() {
        long[] r100 = new long[this.mPol.length];
        int r101 = 0;
    L3:
        int r102 = this.mDegree;
        if (r101 >= r102) goto L9;
        if (testBit((r102 - r101) - 1) == false) goto L8;
        int r103 = r101 >>> 6;
        r100[r103] = r100[r103] | mBitmask[r101 & 63];
    L8:
        r101 = r101 + 1;
        goto L3
    L9:
        return r100;
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GFElement
    public GFElement add(GFElement r100) throws RuntimeException {
        GF2nONBElement r101 = new GF2nONBElement(this);
        r101.addToThis(r100);
        return r101;
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GFElement
    public void addToThis(GFElement r100) throws RuntimeException {
        if ((r100 instanceof GF2nONBElement) == false) goto L14;
        GF2nONBElement r101 = (GF2nONBElement) r100;
        if (this.mField.equals(r101.mField) == false) goto L12;
        int r102 = 0;
    L8:
        if (r102 >= this.mLength) goto L10;
        long[] r103 = this.mPol;
        r103[r102] = r103[r102] ^ r101.mPol[r102];
        r102 = r102 + 1;
        goto L8
    L10:
        return;
    L12:
        throw new RuntimeException();
    L14:
        throw new RuntimeException();
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GF2nElement
    public void assignOne() {
        int r100 = 0;
    L3:
        int r101 = this.mLength;
        if (r100 >= (r101 - 1)) goto L6;
        this.mPol[r100] = -1;
        r100 = r100 + 1;
        goto L3
    L6:
        this.mPol[r101 - 1] = mMaxmask[this.mBit - 1];
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GF2nElement
    public void assignZero() {
        this.mPol = new long[this.mLength];
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GF2nElement, org.bouncycastle.pqc.math.linearalgebra.GFElement
    public Object clone() {
        return new GF2nONBElement(this);
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GFElement
    public boolean equals(Object r100) {
        if (r100 != null) goto L5;
    L16:
        return false;
    L5:
        if ((r100 instanceof GF2nONBElement) == false) goto L16;
        GF2nONBElement r101 = (GF2nONBElement) r100;
        int r102 = 0;
    L9:
        if (r102 >= this.mLength) goto L14;
        if (this.mPol[r102] != r101.mPol[r102]) goto L12;
        r102 = r102 + 1;
        goto L9
    L12:
        return false;
    L14:
        return true;
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GFElement
    public int hashCode() {
        return Arrays.hashCode(this.mPol);
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GF2nElement
    public GF2nElement increase() {
        GF2nONBElement r100 = new GF2nONBElement(this);
        r100.increaseThis();
        return r100;
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GF2nElement
    public void increaseThis() {
        addToThis(ONE((GF2nONBField) this.mField));
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GFElement
    public GFElement invert() throws ArithmeticException {
        GF2nONBElement r100 = new GF2nONBElement(this);
        r100.invertThis();
        return r100;
    }

    public void invertThis() throws ArithmeticException {
        if (isZero() == true) goto L24;
        int r100 = 31;
        boolean r101 = false;
    L6:
        if (r101 == true) goto L12;
        if (r100 < 0) goto L12;
        if ((((long) (this.mDegree - 1)) & mBitmask[r100]) == 0) goto L11;
        r101 = true;
    L11:
        r100 = r100 - 1;
    L12:
        ZERO((GF2nONBField) this.mField);
        GF2nONBElement r102 = new GF2nONBElement(this);
        int r103 = (r100 + 1) - 1;
        int r104 = 1;
    L13:
        if (r103 < 0) goto L21;
        GF2nElement r105 = (GF2nElement) r102.clone();
        int r106 = 1;
    L15:
        if (r106 > r104) goto L17;
        r105.squareThis();
        r106 = r106 + 1;
        goto L15
    L17:
        r102.multiplyThisBy(r105);
        r104 = r104 << 1;
        if ((((long) (this.mDegree - 1)) & mBitmask[r103]) == 0) goto L20;
        r102.squareThis();
        r102.multiplyThisBy(this);
        r104 = r104 + 1;
    L20:
        r103 = r103 - 1;
        goto L13
    L21:
        r102.squareThis();
        return;
    L24:
        throw new ArithmeticException();
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GFElement
    public boolean isOne() {
        boolean r100 = true;
        int r101 = 0;
        boolean r102 = true;
    L3:
        int r103 = this.mLength;
        if (r101 >= (r103 - 1)) goto L12;
        if (r102 == false) goto L12;
        if (r102 == true) goto L8;
    L10:
        r102 = false;
    L11:
        r101 = r101 + 1;
        goto L3
    L8:
        if ((this.mPol[r101] & (-1)) != (-1)) goto L10;
        r102 = true;
    L12:
        if (r102 == false) goto L24;
        if (r102 == false) goto L17;
        long r104 = this.mPol[r103 - 1];
        long[] r105 = mMaxmask;
        int r106 = this.mBit;
        if ((r104 & r105[r106 - 1]) != r105[r106 - 1]) goto L17;
    L19:
        return r100;
    L17:
        r100 = false;
        goto L19
    L24:
        return r102;
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GFElement
    public boolean isZero() {
        int r100 = 0;
        boolean r101 = true;
    L4:
        if (r100 >= this.mLength) goto L12;
        if (r101 == false) goto L12;
        if (r101 == true) goto L8;
    L10:
        r101 = false;
    L11:
        r100 = r100 + 1;
        goto L4
    L8:
        if ((this.mPol[r100] & (-1)) != 0) goto L10;
        r101 = true;
    L12:
        return r101;
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GFElement
    public GFElement multiply(GFElement r100) throws RuntimeException {
        GF2nONBElement r101 = new GF2nONBElement(this);
        r101.multiplyThisBy(r100);
        return r101;
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GFElement
    public void multiplyThisBy(GFElement r210) throws RuntimeException {
        if ((r210 instanceof GF2nONBElement) == false) goto L85;
        GF2nONBElement r100 = (GF2nONBElement) r210;
        if (this.mField.equals(r100.mField) == false) goto L83;
        if (equals(r210) == false) goto L9;
        squareThis();
        return;
    L9:
        long[] r101 = this.mPol;
        long[] r102 = r100.mPol;
        int r103 = this.mLength;
        long[] r104 = new long[r103];
        int[][] r105 = ((GF2nONBField) this.mField).mMult;
        int r106 = r103 - 1;
        int r107 = this.mBit - 1;
        long[] r108 = mBitmask;
        long r110 = r108[63];
        long r109 = r108[r107];
        char r111 = 0;
        int r112 = 0;
    L11:
        if (r112 >= this.mDegree) goto L80;
        int r113 = 0;
        boolean r114 = false;
    L14:
        if (r113 >= this.mDegree) goto L26;
        int[] r115 = mIBY64;
        int r116 = r115[r113];
        int[] r211 = r105[r113];
        int r212 = r211[r111];
        int r213 = r115[r212];
        int r214 = r212 & 63;
        long r215 = r101[r116];
        long[] r117 = mBitmask;
        if ((r215 & r117[r113 & 63]) == 0) goto L25;
        if ((r102[r213] & r117[r214]) == 0) goto L20;
        r114 = !r114;
    L20:
        int r118 = r211[1];
        if (r118 == (-1)) goto L25;
        if ((r102[r115[r118]] & r117[r118 & 63]) == 0) goto L25;
        r114 = !r114;
    L25:
        r113 = r113 + 1;
        r111 = 0;
        goto L14
    L26:
        int r119 = mIBY64[r112];
        int r120 = r112 & 63;
        if (r114 == false) goto L30;
        r104[r119] = r104[r119] ^ mBitmask[r120];
    L30:
        if (this.mLength > 1) goto L32;
        long r121 = r101[0];
        if ((r121 & 1) != 1) goto L68;
        char r122 = 1;
        boolean r123 = true;
    L69:
        long r124 = r121 >>> r122;
        r101[0] = r124;
        if (r123 == false) goto L72;
        r101[0] = r124 ^ r109;
    L72:
        long r125 = r102[0];
        if ((r125 & 1) != 1) goto L75;
        char r126 = 1;
        boolean r127 = true;
    L76:
        long r128 = r125 >>> r126;
        r102[0] = r128;
        if (r127 == false) goto L79;
        r102[0] = r128 ^ r109;
    L79:
        r112 = r112 + 1;
        r111 = 0;
        goto L11
    L75:
        r126 = 1;
        r127 = false;
        goto L76
    L68:
        r122 = 1;
        r123 = false;
        goto L69
    L32:
        if ((r101[r106] & 1) != 1) goto L34;
        boolean r129 = true;
    L35:
        int r130 = r106 - 1;
        int r131 = r130;
    L36:
        if (r131 < 0) goto L45;
        long r216 = r101[r131];
        if ((r216 & 1) == 0) goto L40;
        boolean r132 = true;
    L41:
        long r217 = r216 >>> 1;
        r101[r131] = r217;
        if (r129 == false) goto L44;
        r101[r131] = r217 ^ r110;
    L44:
        r131 = r131 - 1;
        r129 = r132;
        goto L36
    L40:
        r132 = false;
        goto L41
    L45:
        long r218 = r101[r106] >>> 1;
        r101[r106] = r218;
        if (r129 == false) goto L49;
        r101[r106] = r218 ^ r109;
    L49:
        if ((r102[r106] & 1) != 1) goto L51;
        boolean r133 = true;
    L52:
        if (r130 < 0) goto L61;
        long r219 = r102[r130];
        if ((r219 & 1) == 0) goto L56;
        boolean r134 = true;
    L57:
        long r220 = r219 >>> 1;
        r102[r130] = r220;
        if (r133 == false) goto L60;
        r102[r130] = r220 ^ r110;
    L60:
        r130 = r130 - 1;
        r133 = r134;
        goto L52
    L56:
        r134 = false;
        goto L57
    L61:
        long r135 = r102[r106] >>> 1;
        r102[r106] = r135;
        if (r133 == false) goto L79;
        r102[r106] = r135 ^ r109;
        goto L79
    L51:
        r133 = false;
        goto L52
    L34:
        r129 = false;
        goto L35
    L80:
        assign(r104);
        return;
    L83:
        throw new RuntimeException();
    L85:
        throw new RuntimeException("The elements have different representation: not yet implemented");
    }

    public void reverseOrder() {
        this.mPol = getElementReverseOrder();
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GF2nElement
    public GF2nElement solveQuadraticEquation() throws RuntimeException {
        if (trace() == 1) goto L45;
        long r100 = mBitmask[63];
        long[] r101 = new long[this.mLength];
        int r102 = 0;
        long r103 = 0;
    L5:
        int r110 = this.mLength;
        if (r102 >= (r110 - 1)) goto L30;
        int r111 = 1;
    L9:
        if (r111 >= 64) goto L20;
        long[] r112 = mBitmask;
        long r113 = r112[r111];
        long r114 = this.mPol[r102];
        if ((r113 & r114) == 0) goto L15;
        if ((r103 & r112[r111 - 1]) == 0) goto L15;
    L19:
        r111 = r111 + 1;
    L15:
        if ((r114 & r113) == 0) goto L17;
    L18:
        r103 = r103 ^ r113;
        goto L19
    L17:
        if ((r112[r111 - 1] & r103) == 0) goto L19;
    L20:
        r101[r102] = r103;
        long r104 = r103 & r100;
        if (r104 != 0) goto L23;
    L24:
        if (r104 == 0) goto L26;
    L28:
        r103 = 1;
    L29:
        r102 = r102 + 1;
        goto L5
    L26:
        if ((1 & this.mPol[r102 + 1]) != 0) goto L28;
    L27:
        r103 = 0;
        goto L29
    L23:
        if ((1 & this.mPol[r102 + 1]) == 1) goto L27;
    L30:
        int r105 = 63 & this.mDegree;
        long r115 = this.mPol[r110 - 1];
        int r106 = 1;
    L31:
        if (r106 >= r105) goto L42;
        long[] r107 = mBitmask;
        long r116 = r107[r106];
        if ((r116 & r115) == 0) goto L37;
        if ((r107[r106 - 1] & r103) == 0) goto L37;
    L41:
        r106 = r106 + 1;
    L37:
        if ((r116 & r115) == 0) goto L39;
    L40:
        r103 = r103 ^ r116;
        goto L41
    L39:
        if ((r107[r106 - 1] & r103) == 0) goto L41;
    L42:
        r101[this.mLength - 1] = r103;
        return new GF2nONBElement((GF2nONBField) this.mField, r101);
    L45:
        throw new RuntimeException();
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GF2nElement
    public GF2nElement square() {
        GF2nONBElement r100 = new GF2nONBElement(this);
        r100.squareThis();
        return r100;
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GF2nElement
    public GF2nElement squareRoot() {
        GF2nONBElement r100 = new GF2nONBElement(this);
        r100.squareRootThis();
        return r100;
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GF2nElement
    public void squareRootThis() {
        long[] r100 = getElement();
        int r101 = this.mLength - 1;
        int r102 = this.mBit - 1;
        long r103 = mBitmask[63];
        if ((r100[0] & 1) == 0) goto L5;
        boolean r104 = true;
    L6:
        int r105 = r101;
    L7:
        if (r105 < 0) goto L18;
        long r110 = r100[r105];
        if ((r110 & 1) == 0) goto L11;
        boolean r111 = true;
    L12:
        long r112 = r110 >>> 1;
        r100[r105] = r112;
        if (r104 == false) goto L17;
        if (r105 != r101) goto L16;
        r100[r105] = r112 ^ mBitmask[r102];
        goto L17
    L16:
        r100[r105] = r112 ^ r103;
    L17:
        r105 = r105 - 1;
        r104 = r111;
        goto L7
    L11:
        r111 = false;
        goto L12
    L18:
        assign(r100);
        return;
    L5:
        r104 = false;
        goto L6
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GF2nElement
    public void squareThis() {
        long[] r100 = getElement();
        int r101 = this.mLength - 1;
        int r102 = this.mBit - 1;
        long[] r103 = mBitmask;
        long r104 = r103[63];
        long r105 = r100[r101] & r103[r102];
        boolean r106 = false;
        if (r105 == 0) goto L5;
        boolean r107 = true;
    L6:
        int r108 = 0;
    L8:
        if (r108 >= r101) goto L17;
        long r110 = r100[r108];
        if ((r110 & r104) == 0) goto L12;
        boolean r111 = true;
    L13:
        long r112 = r110 << 1;
        r100[r108] = r112;
        if (r107 == false) goto L16;
        r100[r108] = 1 ^ r112;
    L16:
        r108 = r108 + 1;
        r107 = r111;
        goto L8
    L12:
        r111 = false;
        goto L13
    L17:
        long r109 = r100[r101];
        long[] r113 = mBitmask;
        if ((r113[r102] & r109) == 0) goto L20;
        r106 = true;
    L20:
        long r114 = r109 << 1;
        r100[r101] = r114;
        if (r107 == false) goto L23;
        r100[r101] = r114 ^ 1;
    L23:
        if (r106 == false) goto L25;
        long r115 = r100[r101];
        r100[r101] = r113[r102 + 1] ^ r115;
    L25:
        assign(r100);
        return;
    L5:
        r107 = false;
        goto L6
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GF2nElement
    public boolean testBit(int r100) {
        if (r100 >= 0) goto L5;
        return false;
    L5:
        if (r100 <= this.mDegree) goto L8;
        return false;
    L8:
        if ((this.mPol[r100 >>> 6] & mBitmask[r100 & 63]) == 0) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GF2nElement
    public boolean testRightmostBit() {
        if ((this.mPol[this.mLength - 1] & mBitmask[this.mBit - 1]) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GFElement
    public byte[] toByteArray() {
        int r100 = ((this.mDegree - 1) >> 3) + 1;
        byte[] r101 = new byte[r100];
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L5;
        int r103 = (r102 & 7) << 3;
        r101[(r100 - r102) - 1] = (byte) ((this.mPol[r102 >>> 3] & (255 << r103)) >>> r103);
        r102 = r102 + 1;
        goto L3
    L5:
        return r101;
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GFElement
    public BigInteger toFlexiBigInt() {
        return new BigInteger(1, toByteArray());
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GFElement
    public String toString() {
        return toString(16);
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GFElement
    public String toString(int r110) {
        long[] r100 = getElement();
        int r101 = this.mBit;
        String r102 = "";
        if (r110 != 2) goto L23;
    L5:
        r101 = r101 - 1;
        if (r101 < 0) goto L12;
        if ((r100[r100.length - 1] & (1 << r101)) != 0) goto L10;
        String r111 = r102 + "0";
    L11:
        r102 = r111;
        goto L5
    L10:
        r111 = r102 + "1";
        goto L11
    L12:
        int r103 = r100.length - 2;
    L13:
        if (r103 < 0) goto L27;
        int r104 = 63;
    L15:
        if (r104 < 0) goto L21;
        if ((r100[r103] & mBitmask[r104]) != 0) goto L19;
        StringBuilder r105 = new StringBuilder();
        r105.append(r102);
        r105.append("0");
    L20:
        r102 = r105.toString();
        r104 = r104 - 1;
        goto L15
    L19:
        r105 = new StringBuilder();
        r105.append(r102);
        r105.append("1");
        goto L20
    L21:
        r103 = r103 - 1;
    L27:
        return r102;
    L23:
        if (r110 != 16) goto L27;
        char[] r112 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f'};
        int r106 = r100.length - 1;
    L25:
        if (r106 < 0) goto L27;
        r102 = ((((((((((((((((r102 + r112[((int) (r100[r106] >>> 60)) & 15]) + r112[((int) (r100[r106] >>> 56)) & 15]) + r112[((int) (r100[r106] >>> 52)) & 15]) + r112[((int) (r100[r106] >>> 48)) & 15]) + r112[((int) (r100[r106] >>> 44)) & 15]) + r112[((int) (r100[r106] >>> 40)) & 15]) + r112[((int) (r100[r106] >>> 36)) & 15]) + r112[((int) (r100[r106] >>> 32)) & 15]) + r112[((int) (r100[r106] >>> 28)) & 15]) + r112[((int) (r100[r106] >>> 24)) & 15]) + r112[((int) (r100[r106] >>> 20)) & 15]) + r112[((int) (r100[r106] >>> 16)) & 15]) + r112[((int) (r100[r106] >>> 12)) & 15]) + r112[((int) (r100[r106] >>> 8)) & 15]) + r112[((int) (r100[r106] >>> 4)) & 15]) + r112[((int) r100[r106]) & 15]) + " ";
        r106 = r106 - 1;
        goto L25
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GF2nElement
    public int trace() {
        int r100 = this.mLength - 1;
        int r101 = 0;
        int r102 = 0;
        int r103 = 0;
    L4:
        if (r102 >= r100) goto L13;
        int r104 = 0;
    L7:
        if (r104 >= 64) goto L12;
        if ((this.mPol[r102] & mBitmask[r104]) == 0) goto L11;
        r103 = r103 ^ 1;
    L11:
        r104 = r104 + 1;
        goto L7
    L12:
        r102 = r102 + 1;
        goto L4
    L13:
        int r105 = this.mBit;
    L14:
        if (r101 >= r105) goto L19;
        if ((this.mPol[r100] & mBitmask[r101]) == 0) goto L18;
        r103 = r103 ^ 1;
    L18:
        r101 = r101 + 1;
        goto L14
    L19:
        return r103;
    }
}
