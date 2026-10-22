package org.bouncycastle.crypto.digests;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import kotlin.UByte;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.ByteCompanionObject;
import org.bouncycastle.asn1.cmc.BodyPartID;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class DSTU7564Digest implements ExtendedDigest, Memoable {
    private static final int NB_1024 = 16;
    private static final int NB_512 = 8;
    private static final int NR_1024 = 14;
    private static final int NR_512 = 10;
    private static final byte[] S0 = null;
    private static final byte[] S1 = null;
    private static final byte[] S2 = null;
    private static final byte[] S3 = null;
    private int blockSize;
    private byte[] buf;
    private int bufOff;
    private int columns;
    private int hashSize;
    private long inputBlocks;
    private int rounds;
    private long[] state;
    private long[] tempState1;
    private long[] tempState2;

    static {
        S0 = new byte[]{-88, 67, 95, 6, 107, 117, 108, 89, 113, -33, -121, -107, 23, -16, -40, 9, 109, -13, 29, -53, -55, 77, 44, -81, 121, -32, -105, -3, 111, 75, 69, 57, 62, -35, -93, 79, -76, -74, -102, 14, 31, -65, 21, -31, 73, -46, -109, -58, -110, 114, -98, 97, -47, 99, -6, -18, -12, 25, -43, -83, 88, -92, -69, -95, -36, -14, -125, 55, 66, -28, 122, 50, -100, -52, -85, 74, -113, 110, 4, 39, 46, -25, -30, 90, -106, 22, 35, 43, -62, 101, 102, 15, PSSSigner.TRAILER_IMPLICIT, -87, 71, 65, 52, 72, -4, -73, 106, -120, -91, 83, -122, -7, 91, -37, 56, 123, -61, 30, 34, 51, 36, 40, 54, -57, -78, 59, -114, 119, -70, -11, 20, -97, 8, 85, -101, 76, -2, 96, 92, -38, 24, 70, -51, 125, 33, -80, 63, 27, -119, -1, -21, -124, 105, 58, -99, -41, -45, 112, 103, 64, -75, -34, 93, 48, -111, -79, 120, 17, 1, -27, 0, 104, -104, -96, -59, 2, -90, 116, 45, 11, -94, 118, -77, -66, -50, -67, -82, -23, -118, 49, 28, -20, -15, -103, -108, -86, -10, 38, 47, -17, -24, -116, 53, 3, -44, ByteCompanionObject.MAX_VALUE, -5, 5, -63, 94, -112, 32, Base64.padSymbol, -126, -9, -22, 10, HTTP.CR, 126, -8, 80, 26, -60, 7, 87, -72, 60, 98, -29, -56, -84, 82, 100, 16, -48, -39, 19, 12, 18, 41, 81, -71, -49, -42, 115, -115, -127, 84, -64, -19, 78, 68, -89, 42, -123, 37, -26, -54, 124, -117, 86, ByteCompanionObject.MIN_VALUE};
        S1 = new byte[]{-50, -69, -21, -110, -22, -53, 19, -63, -23, 58, -42, -78, -46, -112, 23, -8, 66, 21, 86, -76, 101, 28, -120, 67, -59, 92, 54, -70, -11, 87, 103, -115, 49, -10, 100, 88, -98, -12, 34, -86, 117, 15, 2, -79, -33, 109, 115, 77, 124, 38, 46, -9, 8, 93, 68, 62, -97, 20, -56, -82, 84, 16, -40, PSSSigner.TRAILER_IMPLICIT, 26, 107, 105, -13, -67, 51, -85, -6, -47, -101, 104, 78, 22, -107, -111, -18, 76, 99, -114, 91, -52, 60, 25, -95, -127, 73, 123, -39, 111, 55, 96, -54, -25, 43, 72, -3, -106, 69, -4, 65, 18, HTTP.CR, 121, -27, -119, -116, -29, 32, 48, -36, -73, 108, 74, -75, 63, -105, -44, 98, 45, 6, -92, -91, -125, 95, 42, -38, -55, 0, 126, -94, 85, -65, 17, -43, -100, -49, 14, 10, Base64.padSymbol, 81, 125, -109, 27, -2, -60, 71, 9, -122, 11, -113, -99, 106, 7, -71, -80, -104, 24, 50, 113, 75, -17, 59, 112, -96, -28, 64, -1, -61, -87, -26, 120, -7, -117, 70, ByteCompanionObject.MIN_VALUE, 30, 56, -31, -72, -88, -32, 12, 35, 118, 29, 37, 36, 5, -15, 110, -108, 40, -102, -124, -24, -93, 79, 119, -45, -123, -30, 82, -14, -126, 80, 122, 47, 116, 83, -77, 97, -81, 57, 53, -34, -51, 31, -103, -84, -83, 114, 44, -35, -48, -121, -66, 94, -90, -20, 4, -58, 3, 52, -5, -37, 89, -74, -62, 1, -16, 90, -19, -89, 102, 33, ByteCompanionObject.MAX_VALUE, -118, 39, -57, -64, 41, -41};
        S2 = new byte[]{-109, -39, -102, -75, -104, 34, 69, -4, -70, 106, -33, 2, -97, -36, 81, 89, 74, 23, 43, -62, -108, -12, -69, -93, 98, -28, 113, -44, -51, 112, 22, -31, 73, 60, -64, -40, 92, -101, -83, -123, 83, -95, 122, -56, 45, -32, -47, 114, -90, 44, -60, -29, 118, 120, -73, -76, 9, 59, 14, 65, 76, -34, -78, -112, 37, -91, -41, 3, 17, 0, -61, 46, -110, -17, 78, 18, -99, 125, -53, 53, 16, -43, 79, -98, 77, -87, 85, -58, -48, 123, 24, -105, -45, 54, -26, 72, 86, -127, -113, 119, -52, -100, -71, -30, -84, -72, 47, 21, -92, 124, -38, 56, 30, 11, 5, -42, 20, 110, 108, 126, 102, -3, -79, -27, 96, -81, 94, 51, -121, -55, -16, 93, 109, 63, -120, -115, -57, -9, 29, -23, -20, -19, ByteCompanionObject.MIN_VALUE, 41, 39, -49, -103, -88, 80, 15, 55, 36, 40, 48, -107, -46, 62, 91, 64, -125, -77, 105, 87, 31, 7, 28, -118, PSSSigner.TRAILER_IMPLICIT, 32, -21, -50, -114, -85, -18, 49, -94, 115, -7, -54, 58, 26, -5, HTTP.CR, -63, -2, -6, -14, 111, -67, -106, -35, 67, 82, -74, 8, -13, -82, -66, 25, -119, 50, 38, -80, -22, 75, 100, -124, -126, 107, -11, 121, -65, 1, 95, 117, 99, 27, 35, Base64.padSymbol, 104, 42, 101, -24, -111, -10, -1, 19, 88, -15, 71, 10, ByteCompanionObject.MAX_VALUE, -59, -89, -25, 97, 90, 6, 70, 68, 66, 4, -96, -37, 57, -122, 84, -86, -116, 52, 33, -117, -8, 12, 116, 103};
        S3 = new byte[]{104, -115, -54, 77, 115, 75, 78, 42, -44, 82, 38, -77, 84, 30, 25, 31, 34, 3, 70, Base64.padSymbol, 45, 74, 83, -125, 19, -118, -73, -43, 37, 121, -11, -67, 88, 47, HTTP.CR, 2, -19, 81, -98, 17, -14, 62, 85, 94, -47, 22, 60, 102, 112, 93, -13, 69, 64, -52, -24, -108, 86, 8, -50, 26, 58, -46, -31, -33, -75, 56, 110, 14, -27, -12, -7, -122, -23, 79, -42, -123, 35, -49, 50, -103, 49, 20, -82, -18, -56, 72, -45, 48, -95, -110, 65, -79, 24, -60, 44, 113, 114, 68, 21, -3, 55, -66, 95, -86, -101, -120, -40, -85, -119, -100, -6, 96, -22, PSSSigner.TRAILER_IMPLICIT, 98, 12, 36, -90, -88, -20, 103, 32, -37, 124, 40, -35, -84, 91, 52, 126, 16, -15, 123, -113, 99, -96, 5, -102, 67, 119, 33, -65, 39, 9, -61, -97, -74, -41, 41, -62, -21, -64, -92, -117, -116, 29, -5, -1, -63, -78, -105, 46, -8, 101, -10, 117, 7, 4, 73, 51, -28, -39, -71, -48, 66, -57, 108, -112, 0, -114, 111, 80, 1, -59, -38, 71, 63, -51, 105, -94, -30, 122, -89, -58, -109, 15, 10, 6, -26, 43, -106, -93, 28, -81, 106, 18, -124, 57, -25, -80, -126, -9, -2, -99, -121, 92, -127, 53, -34, -76, -91, -4, ByteCompanionObject.MIN_VALUE, -17, -53, -69, 107, 118, -70, 90, 125, 120, 11, -107, -29, -83, 116, -104, 59, 54, 100, 109, -36, -16, 89, -87, 76, 23, ByteCompanionObject.MAX_VALUE, -111, -72, -55, 87, 27, -32, 97};
    }

    public DSTU7564Digest(int r100) {
        if (r100 != 256) goto L5;
    L11:
        this.hashSize = r100 >>> 3;
        if (r100 <= 256) goto L14;
        this.columns = 16;
        int r101 = 14;
    L15:
        this.rounds = r101;
        int r102 = this.columns;
        int r103 = r102 << 3;
        this.blockSize = r103;
        long[] r104 = new long[r102];
        this.state = r104;
        r104[0] = r103;
        this.tempState1 = new long[r102];
        this.tempState2 = new long[r102];
        this.buf = new byte[r103];
        return;
    L14:
        this.columns = 8;
        r101 = 10;
        goto L15
    L5:
        if (r100 == 384) goto L11;
        if (r100 == 512) goto L11;
        throw new IllegalArgumentException("Hash size is not recommended. Use 256/384/512 instead");
    }

    public DSTU7564Digest(DSTU7564Digest r100) {
        copyIn(r100);
    }

    private void P(long[] r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.rounds) goto L10;
        long r102 = r101;
        int r103 = 0;
    L7:
        if (r103 >= this.columns) goto L9;
        r100[r103] = r100[r103] ^ r102;
        r102 = r102 + 16;
        r103 = r103 + 1;
        goto L7
    L9:
        shiftRows(r100);
        subBytes(r100);
        mixColumns(r100);
        r101 = r101 + 1;
        goto L4
    }

    private void Q(long[] r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.rounds) goto L10;
        long r102 = (((long) (((this.columns - 1) << 4) ^ r101)) << 56) | 67818912035696883L;
        int r103 = 0;
    L7:
        if (r103 >= this.columns) goto L9;
        r100[r103] = r100[r103] + r102;
        r102 = r102 - 1152921504606846976L;
        r103 = r103 + 1;
        goto L7
    L9:
        shiftRows(r100);
        subBytes(r100);
        mixColumns(r100);
        r101 = r101 + 1;
        goto L4
    }

    private void copyIn(DSTU7564Digest r100) {
        this.hashSize = r100.hashSize;
        this.blockSize = r100.blockSize;
        this.rounds = r100.rounds;
        int r101 = this.columns;
        if (r101 > 0) goto L5;
    L7:
        this.columns = r100.columns;
        this.state = Arrays.clone(r100.state);
        int r102 = this.columns;
        this.tempState1 = new long[r102];
        this.tempState2 = new long[r102];
        this.buf = Arrays.clone(r100.buf);
    L8:
        this.inputBlocks = r100.inputBlocks;
        this.bufOff = r100.bufOff;
        return;
    L5:
        if (r101 != r100.columns) goto L7;
        System.arraycopy(r100.state, 0, this.state, 0, r101);
        System.arraycopy(r100.buf, 0, this.buf, 0, this.blockSize);
        goto L8
    }

    private static long mixColumn(long r110) {
        long r100 = ((9187201950435737471L & r110) << 1) ^ (((r110 & (-9187201950435737472L)) >>> 7) * 29);
        long r101 = rotate(8, r110) ^ r110;
        long r102 = (r101 ^ rotate(16, r101)) ^ rotate(48, r110);
        long r111 = (r110 ^ r102) ^ r100;
        long r103 = (((-9187201950435737472L) & r111) >>> 6) * 29;
        long r104 = r103 ^ ((4557430888798830399L & r111) << 2);
        return ((rotate(32, (((r111 & 4629771061636907072L) >>> 6) * 29) ^ r104) ^ r102) ^ rotate(40, r100)) ^ rotate(48, r100);
    }

    private void mixColumns(long[] r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.columns) goto L6;
        r100[r101] = mixColumn(r100[r101]);
        r101 = r101 + 1;
        goto L4
    }

    private void processBlock(byte[] r100, int r110) {
        int r101 = 0;
        int r102 = 0;
    L4:
        if (r102 >= this.columns) goto L6;
        long r103 = Pack.littleEndianToLong(r100, r110);
        r110 = r110 + 8;
        this.tempState1[r102] = this.state[r102] ^ r103;
        this.tempState2[r102] = r103;
        r102 = r102 + 1;
        goto L4
    L6:
        P(this.tempState1);
        Q(this.tempState2);
    L8:
        if (r101 >= this.columns) goto L10;
        long[] r104 = this.state;
        r104[r101] = r104[r101] ^ (this.tempState1[r101] ^ this.tempState2[r101]);
        r101 = r101 + 1;
        goto L8
    }

    private static long rotate(int r100, long r101) {
        long r102 = r101 >>> r100;
        return (r101 << (-r100)) | r102;
    }

    private void shiftRows(long[] r610) {
        int r100 = this.columns;
        if (r100 != 8) goto L5;
        long r110 = r610[0];
        long r210 = r610[1];
        long r211 = r610[2];
        long r212 = r610[3];
        long r213 = r610[4];
        long r310 = r610[5];
        long r311 = r610[6];
        long r312 = r610[7];
        long r101 = (r110 ^ r213) & (-4294967296L);
        long r111 = r110 ^ r101;
        long r102 = r213 ^ r101;
        long r103 = (r210 ^ r310) & 72057594021150720L;
        long r214 = r210 ^ r103;
        long r104 = r310 ^ r103;
        long r215 = (r211 ^ r311) & 281474976645120L;
        long r216 = r211 ^ r215;
        long r217 = r311 ^ r215;
        long r313 = (r212 ^ r312) & 1099511627520L;
        long r218 = r212 ^ r313;
        long r314 = r312 ^ r313;
        long r315 = (r111 ^ r216) & (-281470681808896L);
        long r112 = r111 ^ r315;
        long r219 = r216 ^ r315;
        long r316 = (r214 ^ r218) & 72056494543077120L;
        long r220 = r214 ^ r316;
        long r221 = r218 ^ r316;
        long r113 = (r102 ^ r217) & (-281470681808896L);
        long r105 = r102 ^ r113;
        long r106 = r217 ^ r113;
        long r114 = (r104 ^ r314) & 72056494543077120L;
        long r107 = r104 ^ r114;
        long r115 = r314 ^ r114;
        long r222 = (r112 ^ r220) & (-71777214294589696L);
        long r116 = r112 ^ r222;
        long r223 = r220 ^ r222;
        long r224 = (r219 ^ r221) & (-71777214294589696L);
        long r225 = r219 ^ r224;
        long r226 = r221 ^ r224;
        long r227 = (r105 ^ r107) & (-71777214294589696L);
        long r108 = r105 ^ r227;
        long r109 = r107 ^ r227;
        long r117 = (r106 ^ r115) & (-71777214294589696L);
        r610[0] = r116;
        r610[1] = r223;
        r610[2] = r225;
        r610[3] = r226;
        r610[4] = r108;
        r610[5] = r109;
        r610[6] = r106 ^ r117;
        r610[7] = r115 ^ r117;
        return;
    L5:
        if (r100 != 16) goto L8;
        long r118 = r610[0];
        long r228 = r610[1];
        long r229 = r610[2];
        long r230 = r610[3];
        long r231 = r610[4];
        long r317 = r610[5];
        long r318 = r610[6];
        long r319 = r610[7];
        long r320 = r610[8];
        long r321 = r610[9];
        long r410 = r610[10];
        long r411 = r610[11];
        long r412 = r610[12];
        long r510 = r610[13];
        long r511 = r610[14];
        long r512 = r610[15];
        long r513 = (r118 ^ r320) & (-72057594037927936L);
        long r119 = r118 ^ r513;
        long r322 = r320 ^ r513;
        long r514 = (r228 ^ r321) & (-72057594037927936L);
        long r232 = r228 ^ r514;
        long r323 = r321 ^ r514;
        long r515 = (r229 ^ r410) & (-281474976710656L);
        long r233 = r229 ^ r515;
        long r413 = r410 ^ r515;
        long r516 = (r230 ^ r411) & (-1099511627776L);
        long r234 = r230 ^ r516;
        long r414 = r411 ^ r516;
        long r120 = (r231 ^ r412) & (-4294967296L);
        long r235 = r231 ^ r120;
        long r121 = r412 ^ r120;
        long r122 = (r317 ^ r510) & 72057594021150720L;
        long r324 = r317 ^ r122;
        long r123 = r510 ^ r122;
        long r415 = (r318 ^ r511) & 72057594037862400L;
        long r325 = r318 ^ r415;
        long r416 = r511 ^ r415;
        long r517 = (r319 ^ r512) & 72057594037927680L;
        long r326 = r319 ^ r517;
        long r518 = r512 ^ r517;
        long r519 = (r119 ^ r235) & 72057589742960640L;
        long r124 = r119 ^ r519;
        long r236 = r235 ^ r519;
        long r520 = (r232 ^ r324) & (-16777216);
        long r237 = r232 ^ r520;
        long r327 = r324 ^ r520;
        long r521 = (r233 ^ r325) & (-71776119061282816L);
        long r238 = r233 ^ r521;
        long r328 = r325 ^ r521;
        long r522 = (r234 ^ r326) & (-72056494526300416L);
        long r239 = r234 ^ r522;
        long r329 = r326 ^ r522;
        long r523 = (r322 ^ r121) & 72057589742960640L;
        long r330 = r322 ^ r523;
        long r125 = r121 ^ r523;
        long r524 = (r323 ^ r123) & (-16777216);
        long r331 = r323 ^ r524;
        long r126 = r123 ^ r524;
        long r525 = (r413 ^ r416) & (-71776119061282816L);
        long r417 = r413 ^ r525;
        long r418 = r416 ^ r525;
        long r526 = (r414 ^ r518) & (-72056494526300416L);
        long r419 = r414 ^ r526;
        long r527 = r518 ^ r526;
        long r528 = (r124 ^ r238) & (-281470681808896L);
        long r127 = r124 ^ r528;
        long r240 = r238 ^ r528;
        long r529 = (r237 ^ r239) & 72056494543077120L;
        long r241 = r237 ^ r529;
        long r242 = r239 ^ r529;
        long r530 = (r236 ^ r328) & (-281470681808896L);
        long r243 = r236 ^ r530;
        long r332 = r328 ^ r530;
        long r531 = (r327 ^ r329) & 72056494543077120L;
        long r333 = r327 ^ r531;
        long r334 = r329 ^ r531;
        long r532 = (r330 ^ r417) & (-281470681808896L);
        long r335 = r330 ^ r532;
        long r420 = r417 ^ r532;
        long r533 = (r331 ^ r419) & 72056494543077120L;
        long r336 = r331 ^ r533;
        long r421 = r419 ^ r533;
        long r128 = (r125 ^ r418) & (-281470681808896L);
        long r129 = r125 ^ r128;
        long r130 = r418 ^ r128;
        long r244 = (r126 ^ r527) & 72056494543077120L;
        long r131 = r126 ^ r244;
        long r245 = r527 ^ r244;
        long r422 = (r127 ^ r241) & (-71777214294589696L);
        long r132 = r127 ^ r422;
        long r246 = r241 ^ r422;
        long r423 = (r240 ^ r242) & (-71777214294589696L);
        long r247 = r240 ^ r423;
        long r248 = r242 ^ r423;
        long r424 = (r243 ^ r333) & (-71777214294589696L);
        long r249 = r243 ^ r424;
        long r337 = r333 ^ r424;
        long r425 = (r332 ^ r334) & (-71777214294589696L);
        long r338 = r332 ^ r425;
        long r339 = r334 ^ r425;
        long r426 = (r335 ^ r336) & (-71777214294589696L);
        long r340 = r335 ^ r426;
        long r341 = r336 ^ r426;
        long r427 = (r420 ^ r421) & (-71777214294589696L);
        long r428 = r420 ^ r427;
        long r429 = r421 ^ r427;
        long r430 = (r129 ^ r131) & (-71777214294589696L);
        long r133 = r129 ^ r430;
        long r134 = r131 ^ r430;
        long r135 = (r130 ^ r245) & (-71777214294589696L);
        long r136 = r130 ^ r135;
        r610[0] = r132;
        r610[1] = r246;
        r610[2] = r247;
        r610[3] = r248;
        r610[4] = r249;
        r610[5] = r337;
        r610[6] = r338;
        r610[7] = r339;
        r610[8] = r340;
        r610[9] = r341;
        r610[10] = r428;
        r610[11] = r429;
        r610[12] = r133;
        r610[13] = r134;
        r610[14] = r136;
        r610[15] = r245 ^ r135;
        return;
    L8:
        throw new IllegalStateException("unsupported state size: only 512/1024 are allowed");
    }

    private void subBytes(long[] r110) {
        int r100 = 0;
    L4:
        if (r100 >= this.columns) goto L6;
        long r101 = r110[r100];
        int r102 = (int) r101;
        int r103 = (int) (r101 >>> 32);
        byte[] r104 = S0;
        byte r105 = r104[r102 & 255];
        byte[] r106 = S1;
        byte r107 = r106[(r102 >>> 8) & 255];
        byte[] r108 = S2;
        byte r109 = r108[(r102 >>> 16) & 255];
        byte[] r111 = S3;
        byte r112 = r111[r102 >>> 24];
        int r113 = r112 << 24;
        int r114 = r113 | (((r105 & UByte.MAX_VALUE) | ((r107 & UByte.MAX_VALUE) << 8)) | ((r109 & UByte.MAX_VALUE) << 16));
        byte r115 = r104[r103 & 255];
        byte r116 = r106[(r103 >>> 8) & 255];
        byte r117 = r108[(r103 >>> 16) & 255];
        byte r118 = r111[r103 >>> 24];
        int r119 = (((r115 & UByte.MAX_VALUE) | ((r116 & UByte.MAX_VALUE) << 8)) | ((r117 & UByte.MAX_VALUE) << 16)) | (r118 << 24);
        r110[r100] = (((long) r114) & BodyPartID.bodyIdMax) | (((long) r119) << 32);
        r100 = r100 + 1;
        goto L4
    }

    @Override // org.bouncycastle.util.Memoable
    public Memoable copy() {
        return new DSTU7564Digest(this);
    }

    @Override // org.bouncycastle.crypto.Digest
    public int doFinal(byte[] r110, int r111) {
        int r100 = this.bufOff;
        byte[] r101 = this.buf;
        int r102 = r100 + 1;
        this.bufOff = r102;
        r101[r100] = ByteCompanionObject.MIN_VALUE;
        int r103 = this.blockSize - 12;
        int r104 = 0;
        if (r102 <= r103) goto L8;
    L4:
        int r105 = this.bufOff;
        if (r105 >= this.blockSize) goto L7;
        byte[] r106 = this.buf;
        this.bufOff = r105 + 1;
        r106[r105] = 0;
        goto L4
    L7:
        this.bufOff = 0;
        processBlock(this.buf, 0);
    L8:
        int r107 = this.bufOff;
        if (r107 >= r103) goto L11;
        byte[] r108 = this.buf;
        this.bufOff = r107 + 1;
        r108[r107] = 0;
        goto L8
    L11:
        long r109 = (((this.inputBlocks & BodyPartID.bodyIdMax) * ((long) this.blockSize)) + ((long) r100)) << 3;
        Pack.intToLittleEndian((int) r109, this.buf, r107);
        int r112 = this.bufOff + 4;
        this.bufOff = r112;
        Pack.longToLittleEndian((r109 >>> 32) + (((this.inputBlocks >>> 32) * ((long) this.blockSize)) << 3), this.buf, r112);
        processBlock(this.buf, 0);
        System.arraycopy(this.state, 0, this.tempState1, 0, this.columns);
        P(this.tempState1);
    L12:
        int r113 = this.columns;
        if (r104 >= r113) goto L15;
        long[] r114 = this.state;
        r114[r104] = r114[r104] ^ this.tempState1[r104];
        r104 = r104 + 1;
        goto L12
    L15:
        int r115 = r113 - (this.hashSize >>> 3);
    L17:
        if (r115 >= this.columns) goto L19;
        Pack.longToLittleEndian(this.state[r115], r110, r111);
        r111 = r111 + 8;
        r115 = r115 + 1;
        goto L17
    L19:
        reset();
        return this.hashSize;
    }

    @Override // org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return "DSTU7564";
    }

    @Override // org.bouncycastle.crypto.ExtendedDigest
    public int getByteLength() {
        return this.blockSize;
    }

    @Override // org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return this.hashSize;
    }

    @Override // org.bouncycastle.crypto.Digest
    public void reset() {
        Arrays.fill(this.state, 0);
        this.state[0] = this.blockSize;
        this.inputBlocks = 0;
        this.bufOff = 0;
    }

    @Override // org.bouncycastle.util.Memoable
    public void reset(Memoable r100) {
        copyIn((DSTU7564Digest) r100);
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte r100) {
        byte[] r101 = this.buf;
        int r102 = this.bufOff;
        int r103 = r102 + 1;
        this.bufOff = r103;
        r101[r102] = r100;
        if (r103 != this.blockSize) goto L6;
        processBlock(r101, 0);
        this.bufOff = 0;
        this.inputBlocks++;
        return;
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte[] r100, int r101, int r102) {
    L3:
        if (this.bufOff == 0) goto L6;
        if (r102 <= 0) goto L6;
        update(r100[r101]);
        r102 = r102 - 1;
        r101 = r101 + 1;
    L6:
        if (r102 > 0) goto L8;
        return;
    L8:
        if (r102 < this.blockSize) goto L10;
        processBlock(r100, r101);
        int r103 = this.blockSize;
        r101 = r101 + r103;
        r102 = r102 - r103;
        this.inputBlocks++;
    L10:
        if (r102 <= 0) goto L17;
        update(r100[r101]);
        r102 = r102 - 1;
        r101 = r101 + 1;
        goto L10
    }
}
