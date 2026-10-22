package org.bouncycastle.crypto.engines;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import kotlin.UByte;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.ByteCompanionObject;
import org.bouncycastle.asn1.cmc.BodyPartID;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class DSTU7624Engine implements BlockCipher {
    private static final int ROUNDS_128 = 10;
    private static final int ROUNDS_256 = 14;
    private static final int ROUNDS_512 = 18;
    private static final byte[] S0 = null;
    private static final byte[] S1 = null;
    private static final byte[] S2 = null;
    private static final byte[] S3 = null;
    private static final byte[] T0 = null;
    private static final byte[] T1 = null;
    private static final byte[] T2 = null;
    private static final byte[] T3 = null;
    private boolean forEncryption;
    private long[] internalState;
    private long[][] roundKeys;
    private int roundsAmount;
    private int wordsInBlock;
    private int wordsInKey;
    private long[] workingKey;

    static {
        S0 = new byte[]{-88, 67, 95, 6, 107, 117, 108, 89, 113, -33, -121, -107, 23, -16, -40, 9, 109, -13, 29, -53, -55, 77, 44, -81, 121, -32, -105, -3, 111, 75, 69, 57, 62, -35, -93, 79, -76, -74, -102, 14, 31, -65, 21, -31, 73, -46, -109, -58, -110, 114, -98, 97, -47, 99, -6, -18, -12, 25, -43, -83, 88, -92, -69, -95, -36, -14, -125, 55, 66, -28, 122, 50, -100, -52, -85, 74, -113, 110, 4, 39, 46, -25, -30, 90, -106, 22, 35, 43, -62, 101, 102, 15, PSSSigner.TRAILER_IMPLICIT, -87, 71, 65, 52, 72, -4, -73, 106, -120, -91, 83, -122, -7, 91, -37, 56, 123, -61, 30, 34, 51, 36, 40, 54, -57, -78, 59, -114, 119, -70, -11, 20, -97, 8, 85, -101, 76, -2, 96, 92, -38, 24, 70, -51, 125, 33, -80, 63, 27, -119, -1, -21, -124, 105, 58, -99, -41, -45, 112, 103, 64, -75, -34, 93, 48, -111, -79, 120, 17, 1, -27, 0, 104, -104, -96, -59, 2, -90, 116, 45, 11, -94, 118, -77, -66, -50, -67, -82, -23, -118, 49, 28, -20, -15, -103, -108, -86, -10, 38, 47, -17, -24, -116, 53, 3, -44, ByteCompanionObject.MAX_VALUE, -5, 5, -63, 94, -112, 32, Base64.padSymbol, -126, -9, -22, 10, HTTP.CR, 126, -8, 80, 26, -60, 7, 87, -72, 60, 98, -29, -56, -84, 82, 100, 16, -48, -39, 19, 12, 18, 41, 81, -71, -49, -42, 115, -115, -127, 84, -64, -19, 78, 68, -89, 42, -123, 37, -26, -54, 124, -117, 86, ByteCompanionObject.MIN_VALUE};
        S1 = new byte[]{-50, -69, -21, -110, -22, -53, 19, -63, -23, 58, -42, -78, -46, -112, 23, -8, 66, 21, 86, -76, 101, 28, -120, 67, -59, 92, 54, -70, -11, 87, 103, -115, 49, -10, 100, 88, -98, -12, 34, -86, 117, 15, 2, -79, -33, 109, 115, 77, 124, 38, 46, -9, 8, 93, 68, 62, -97, 20, -56, -82, 84, 16, -40, PSSSigner.TRAILER_IMPLICIT, 26, 107, 105, -13, -67, 51, -85, -6, -47, -101, 104, 78, 22, -107, -111, -18, 76, 99, -114, 91, -52, 60, 25, -95, -127, 73, 123, -39, 111, 55, 96, -54, -25, 43, 72, -3, -106, 69, -4, 65, 18, HTTP.CR, 121, -27, -119, -116, -29, 32, 48, -36, -73, 108, 74, -75, 63, -105, -44, 98, 45, 6, -92, -91, -125, 95, 42, -38, -55, 0, 126, -94, 85, -65, 17, -43, -100, -49, 14, 10, Base64.padSymbol, 81, 125, -109, 27, -2, -60, 71, 9, -122, 11, -113, -99, 106, 7, -71, -80, -104, 24, 50, 113, 75, -17, 59, 112, -96, -28, 64, -1, -61, -87, -26, 120, -7, -117, 70, ByteCompanionObject.MIN_VALUE, 30, 56, -31, -72, -88, -32, 12, 35, 118, 29, 37, 36, 5, -15, 110, -108, 40, -102, -124, -24, -93, 79, 119, -45, -123, -30, 82, -14, -126, 80, 122, 47, 116, 83, -77, 97, -81, 57, 53, -34, -51, 31, -103, -84, -83, 114, 44, -35, -48, -121, -66, 94, -90, -20, 4, -58, 3, 52, -5, -37, 89, -74, -62, 1, -16, 90, -19, -89, 102, 33, ByteCompanionObject.MAX_VALUE, -118, 39, -57, -64, 41, -41};
        S2 = new byte[]{-109, -39, -102, -75, -104, 34, 69, -4, -70, 106, -33, 2, -97, -36, 81, 89, 74, 23, 43, -62, -108, -12, -69, -93, 98, -28, 113, -44, -51, 112, 22, -31, 73, 60, -64, -40, 92, -101, -83, -123, 83, -95, 122, -56, 45, -32, -47, 114, -90, 44, -60, -29, 118, 120, -73, -76, 9, 59, 14, 65, 76, -34, -78, -112, 37, -91, -41, 3, 17, 0, -61, 46, -110, -17, 78, 18, -99, 125, -53, 53, 16, -43, 79, -98, 77, -87, 85, -58, -48, 123, 24, -105, -45, 54, -26, 72, 86, -127, -113, 119, -52, -100, -71, -30, -84, -72, 47, 21, -92, 124, -38, 56, 30, 11, 5, -42, 20, 110, 108, 126, 102, -3, -79, -27, 96, -81, 94, 51, -121, -55, -16, 93, 109, 63, -120, -115, -57, -9, 29, -23, -20, -19, ByteCompanionObject.MIN_VALUE, 41, 39, -49, -103, -88, 80, 15, 55, 36, 40, 48, -107, -46, 62, 91, 64, -125, -77, 105, 87, 31, 7, 28, -118, PSSSigner.TRAILER_IMPLICIT, 32, -21, -50, -114, -85, -18, 49, -94, 115, -7, -54, 58, 26, -5, HTTP.CR, -63, -2, -6, -14, 111, -67, -106, -35, 67, 82, -74, 8, -13, -82, -66, 25, -119, 50, 38, -80, -22, 75, 100, -124, -126, 107, -11, 121, -65, 1, 95, 117, 99, 27, 35, Base64.padSymbol, 104, 42, 101, -24, -111, -10, -1, 19, 88, -15, 71, 10, ByteCompanionObject.MAX_VALUE, -59, -89, -25, 97, 90, 6, 70, 68, 66, 4, -96, -37, 57, -122, 84, -86, -116, 52, 33, -117, -8, 12, 116, 103};
        S3 = new byte[]{104, -115, -54, 77, 115, 75, 78, 42, -44, 82, 38, -77, 84, 30, 25, 31, 34, 3, 70, Base64.padSymbol, 45, 74, 83, -125, 19, -118, -73, -43, 37, 121, -11, -67, 88, 47, HTTP.CR, 2, -19, 81, -98, 17, -14, 62, 85, 94, -47, 22, 60, 102, 112, 93, -13, 69, 64, -52, -24, -108, 86, 8, -50, 26, 58, -46, -31, -33, -75, 56, 110, 14, -27, -12, -7, -122, -23, 79, -42, -123, 35, -49, 50, -103, 49, 20, -82, -18, -56, 72, -45, 48, -95, -110, 65, -79, 24, -60, 44, 113, 114, 68, 21, -3, 55, -66, 95, -86, -101, -120, -40, -85, -119, -100, -6, 96, -22, PSSSigner.TRAILER_IMPLICIT, 98, 12, 36, -90, -88, -20, 103, 32, -37, 124, 40, -35, -84, 91, 52, 126, 16, -15, 123, -113, 99, -96, 5, -102, 67, 119, 33, -65, 39, 9, -61, -97, -74, -41, 41, -62, -21, -64, -92, -117, -116, 29, -5, -1, -63, -78, -105, 46, -8, 101, -10, 117, 7, 4, 73, 51, -28, -39, -71, -48, 66, -57, 108, -112, 0, -114, 111, 80, 1, -59, -38, 71, 63, -51, 105, -94, -30, 122, -89, -58, -109, 15, 10, 6, -26, 43, -106, -93, 28, -81, 106, 18, -124, 57, -25, -80, -126, -9, -2, -99, -121, 92, -127, 53, -34, -76, -91, -4, ByteCompanionObject.MIN_VALUE, -17, -53, -69, 107, 118, -70, 90, 125, 120, 11, -107, -29, -83, 116, -104, 59, 54, 100, 109, -36, -16, 89, -87, 76, 23, ByteCompanionObject.MAX_VALUE, -111, -72, -55, 87, 27, -32, 97};
        T0 = new byte[]{-92, -94, -87, -59, 78, -55, 3, -39, 126, 15, -46, -83, -25, -45, 39, 91, -29, -95, -24, -26, 124, 42, 85, 12, -122, 57, -41, -115, -72, 18, 111, 40, -51, -118, 112, 86, 114, -7, -65, 79, 115, -23, -9, 87, 22, -84, 80, -64, -99, -73, 71, 113, 96, -60, 116, 67, 108, 31, -109, 119, -36, -50, 32, -116, -103, 95, 68, 1, -11, 30, -121, 94, 97, 44, 75, 29, -127, 21, -12, 35, -42, -22, -31, 103, -15, ByteCompanionObject.MAX_VALUE, -2, -38, 60, 7, 83, 106, -124, -100, -53, 2, -125, 51, -35, 53, -30, 89, 90, -104, -91, -110, 100, 4, 6, 16, 77, 28, -105, 8, 49, -18, -85, 5, -81, 121, -96, 24, 70, 109, -4, -119, -44, -57, -1, -16, -49, 66, -111, -8, 104, 10, 101, -114, -74, -3, -61, -17, 120, 76, -52, -98, 48, 46, PSSSigner.TRAILER_IMPLICIT, 11, 84, 26, -90, -69, 38, ByteCompanionObject.MIN_VALUE, 72, -108, 50, 125, -89, 63, -82, 34, Base64.padSymbol, 102, -86, -10, 0, 93, -67, 74, -32, 59, -76, 23, -117, -97, 118, -80, 36, -102, 37, 99, -37, -21, 122, 62, 92, -77, -79, 41, -14, -54, 88, 110, -40, -88, 47, 117, -33, 20, -5, 19, 73, -120, -78, -20, -28, 52, 45, -106, -58, 58, -19, -107, 14, -27, -123, 107, 64, 33, -101, 9, 25, 43, 82, -34, 69, -93, -6, 81, -62, -75, -47, -112, -71, -13, 55, -63, HTTP.CR, -70, 65, 17, 56, 123, -66, -48, -43, 105, 54, -56, 98, 27, -126, -113};
        T1 = new byte[]{-125, -14, 42, -21, -23, -65, 123, -100, 52, -106, -115, -104, -71, 105, -116, 41, Base64.padSymbol, -120, 104, 6, 57, 17, 76, 14, -96, 86, 64, -110, 21, PSSSigner.TRAILER_IMPLICIT, -77, -36, 111, -8, 38, -70, -66, -67, 49, -5, -61, -2, ByteCompanionObject.MIN_VALUE, 97, -31, 122, 50, -46, 112, 32, -95, 69, -20, -39, 26, 93, -76, -40, 9, -91, 85, -114, 55, 118, -87, 103, 16, 23, 54, 101, -79, -107, 98, 89, 116, -93, 80, 47, 75, -56, -48, -113, -51, -44, 60, -122, 18, 29, 35, -17, -12, 83, 25, 53, -26, ByteCompanionObject.MAX_VALUE, 94, -42, 121, 81, 34, 20, -9, 30, 74, 66, -101, 65, 115, 45, -63, 92, -90, -94, -32, 46, -45, 40, -69, -55, -82, 106, -47, 90, 48, -112, -124, -7, -78, 88, -49, 126, -59, -53, -105, -28, 22, 108, -6, -80, 109, 31, 82, -103, HTTP.CR, 78, 3, -111, -62, 77, 100, 119, -97, -35, -60, 73, -118, -102, 36, 56, -89, 87, -123, -57, 124, 125, -25, -10, -73, -84, 39, 70, -34, -33, 59, -41, -98, 43, 11, -43, 19, 117, -16, 114, -74, -99, 27, 1, 63, 68, -27, -121, -3, 7, -15, -85, -108, 24, -22, -4, 58, -126, 95, 5, 84, -37, 0, -117, -29, 72, 12, -54, 120, -119, 10, -1, 62, 91, -127, -18, 113, -30, -38, 44, -72, -75, -52, 110, -88, 107, -83, 96, -58, 8, 4, 2, -24, -11, 79, -92, -13, -64, -50, 67, 37, 28, 33, 51, 15, -81, 71, -19, 102, 99, -109, -86};
        T2 = new byte[]{69, -44, 11, 67, -15, 114, -19, -92, -62, 56, -26, 113, -3, -74, 58, -107, 80, 68, 75, -30, 116, 107, 30, 17, 90, -58, -76, -40, -91, -118, 112, -93, -88, -6, 5, -39, -105, 64, -55, -112, -104, -113, -36, 18, 49, 44, 71, 106, -103, -82, -56, ByteCompanionObject.MAX_VALUE, -7, 79, 93, -106, 111, -12, -77, 57, 33, -38, -100, -123, -98, 59, -16, -65, -17, 6, -18, -27, 95, 32, 16, -52, 60, 84, 74, 82, -108, 14, -64, 40, -10, 86, 96, -94, -29, 15, -20, -99, 36, -125, 126, -43, 124, -21, 24, -41, -51, -35, 120, -1, -37, -95, 9, -48, 118, -124, 117, -69, 29, 26, 47, -80, -2, -42, 52, 99, 53, -46, 42, 89, 109, 77, 119, -25, -114, 97, -49, -97, -50, 39, -11, ByteCompanionObject.MIN_VALUE, -122, -57, -90, -5, -8, -121, -85, 98, 63, -33, 72, 0, 20, -102, -67, 91, 4, -110, 2, 37, 101, 76, 83, 12, -14, 41, -81, 23, 108, 65, 48, -23, -109, 85, -9, -84, 104, 38, -60, 125, -54, 122, 62, -96, 55, 3, -63, 54, 105, 102, 8, 22, -89, PSSSigner.TRAILER_IMPLICIT, -59, -45, 34, -73, 19, 70, 50, -24, 87, -120, 43, -127, -78, 78, 100, 28, -86, -111, 88, 46, -101, 92, 27, 81, 115, 66, 35, 1, 110, -13, HTTP.CR, -66, Base64.padSymbol, 10, 45, 31, 103, 51, 25, 123, 94, -22, -34, -117, -53, -87, -116, -115, -83, 73, -126, -28, -70, -61, 21, -47, -32, -119, -4, -79, -71, -75, 7, 121, -72, -31};
        T3 = new byte[]{-78, -74, 35, 17, -89, -120, -59, -90, 57, -113, -60, -24, 115, 34, 67, -61, -126, 39, -51, 24, 81, 98, 45, -9, 92, 14, 59, -3, -54, -101, HTTP.CR, 15, 121, -116, 16, 76, 116, 28, 10, -114, 124, -108, 7, -57, 94, 20, -95, 33, 87, 80, 78, -87, ByteCompanionObject.MIN_VALUE, -39, -17, 100, 65, -49, 60, -18, 46, 19, 41, -70, 52, 90, -82, -118, 97, 51, 18, -71, 85, -88, 21, 5, -10, 3, 6, 73, -75, 37, 9, 22, 12, 42, 56, -4, 32, -12, -27, ByteCompanionObject.MAX_VALUE, -41, 49, 43, 102, 111, -1, 114, -122, -16, -93, 47, 120, 0, PSSSigner.TRAILER_IMPLICIT, -52, -30, -80, -15, 66, -76, 48, 95, 96, 4, -20, -91, -29, -117, -25, 29, -65, -124, 123, -26, -127, -8, -34, -40, -46, 23, -50, 75, 71, -42, 105, 108, 25, -103, -102, 1, -77, -123, -79, -7, 89, -62, 55, -23, -56, -96, -19, 79, -119, 104, 109, -43, 38, -111, -121, 88, -67, -55, -104, -36, 117, -64, 118, -11, 103, 107, 126, -21, 82, -53, -47, 91, -97, 11, -37, 64, -110, 26, -6, -84, -28, -31, 113, 31, 101, -115, -105, -98, -107, -112, 93, -73, -63, -81, 84, -5, 2, -32, 53, -69, 58, 77, -83, 44, Base64.padSymbol, 86, 8, 27, 74, -109, 106, -85, -72, 122, -14, 125, -38, 63, -2, 62, -66, -22, -86, 68, -58, -48, 54, 72, 112, -106, 119, 36, 83, -33, -13, -125, 40, 50, 69, 30, -92, -45, -94, 70, 110, -100, -35, 99, -44, -99};
    }

    public DSTU7624Engine(int r100) throws IllegalArgumentException {
        if (r100 != 128) goto L5;
    L11:
        int r101 = r100 >>> 6;
        this.wordsInBlock = r101;
        this.internalState = new long[r101];
        return;
    L5:
        if (r100 == 256) goto L11;
        if (r100 == 512) goto L11;
        throw new IllegalArgumentException("unsupported block length: only 128/256/512 are allowed");
    }

    private void addRoundKey(int r100) {
        long[] r101 = this.roundKeys[r100];
        int r102 = 0;
    L4:
        if (r102 >= this.wordsInBlock) goto L6;
        long[] r103 = this.internalState;
        r103[r102] = r103[r102] + r101[r102];
        r102 = r102 + 1;
        goto L4
    }

    private void decryptBlock_128(byte[] r210, int r211, byte[] r212, int r213) {
        long r100 = Pack.littleEndianToLong(r210, r211);
        long r101 = Pack.littleEndianToLong(r210, r211 + 8);
        long[][] r102 = this.roundKeys;
        int r103 = this.roundsAmount;
        long[] r104 = r102[r103];
        long r105 = r100 - r104[0];
        long r106 = r101 - r104[1];
    L3:
        long r107 = mixColumnInv(r105);
        long r108 = mixColumnInv(r106);
        int r109 = (int) r107;
        int r110 = (int) (r107 >>> 32);
        int r111 = (int) r108;
        int r112 = (int) (r108 >>> 32);
        byte[] r113 = T0;
        byte r114 = r113[r109 & 255];
        byte[] r115 = T1;
        byte r116 = r115[(r109 >>> 8) & 255];
        byte[] r117 = T2;
        byte r118 = r117[(r109 >>> 16) & 255];
        byte[] r119 = T3;
        byte r120 = r119[r109 >>> 24];
        int r121 = r120 << 24;
        int r122 = r121 | (((r118 & UByte.MAX_VALUE) << 16) | ((r114 & UByte.MAX_VALUE) | ((r116 & UByte.MAX_VALUE) << 8)));
        byte r123 = r113[r112 & 255];
        byte r124 = r115[(r112 >>> 8) & 255];
        byte r125 = r117[(r112 >>> 16) & 255];
        long r126 = (((long) ((r119[r112 >>> 24] << 24) | (((r123 & UByte.MAX_VALUE) | ((r124 & UByte.MAX_VALUE) << 8)) | ((r125 & UByte.MAX_VALUE) << 16)))) << 32) | (((long) r122) & BodyPartID.bodyIdMax);
        byte r127 = r113[r111 & 255];
        byte r128 = r115[(r111 >>> 8) & 255];
        byte r129 = r117[(r111 >>> 16) & 255];
        int r130 = (r119[r111 >>> 24] << 24) | (((r127 & UByte.MAX_VALUE) | ((r128 & UByte.MAX_VALUE) << 8)) | ((r129 & UByte.MAX_VALUE) << 16));
        byte r131 = r113[r110 & 255];
        byte r132 = r115[(r110 >>> 8) & 255];
        byte r133 = r117[(r110 >>> 16) & 255];
        int r134 = (r119[r110 >>> 24] << 24) | (((r131 & UByte.MAX_VALUE) | ((r132 & UByte.MAX_VALUE) << 8)) | ((r133 & UByte.MAX_VALUE) << 16));
        long r135 = (((long) r134) << 32) | (((long) r130) & BodyPartID.bodyIdMax);
        r103 = r103 - 1;
        if (r103 == 0) goto L5;
        long[] r136 = this.roundKeys[r103];
        long r137 = r126 ^ r136[0];
        long r138 = r135 ^ r136[1];
        r105 = r137;
        r106 = r138;
        goto L3
    L5:
        long[] r139 = this.roundKeys[0];
        long r140 = r126 - r139[0];
        long r141 = r135 - r139[1];
        Pack.longToLittleEndian(r140, r212, r213);
        Pack.longToLittleEndian(r141, r212, r213 + 8);
    }

    private void encryptBlock_128(byte[] r210, int r211, byte[] r212, int r213) {
        long r100 = Pack.littleEndianToLong(r210, r211);
        long r101 = Pack.littleEndianToLong(r210, r211 + 8);
        long[] r102 = this.roundKeys[0];
        long r103 = r100 + r102[0];
        long r104 = r101 + r102[1];
        int r105 = 0;
    L3:
        int r110 = (int) r103;
        int r106 = (int) (r103 >>> 32);
        int r107 = (int) r104;
        int r108 = (int) (r104 >>> 32);
        byte[] r109 = S0;
        byte r111 = r109[r110 & 255];
        byte[] r112 = S1;
        byte r113 = r112[(r110 >>> 8) & 255];
        byte[] r114 = S2;
        byte r115 = r114[(r110 >>> 16) & 255];
        byte[] r116 = S3;
        byte r117 = r116[r110 >>> 24];
        int r118 = (r111 & UByte.MAX_VALUE) | ((r113 & UByte.MAX_VALUE) << 8);
        int r119 = (((r115 & UByte.MAX_VALUE) << 16) | r118) | (r117 << 24);
        byte r120 = r109[r108 & 255];
        byte r121 = r112[(r108 >>> 8) & 255];
        byte r122 = r114[(r108 >>> 16) & 255];
        byte r123 = r116[r108 >>> 24];
        int r124 = r123 << 24;
        int r125 = r124 | (((r120 & UByte.MAX_VALUE) | ((r121 & UByte.MAX_VALUE) << 8)) | ((r122 & UByte.MAX_VALUE) << 16));
        long r126 = ((long) r125) << 32;
        long r127 = r126 | (((long) r119) & BodyPartID.bodyIdMax);
        byte r128 = r109[r107 & 255];
        byte r129 = r112[(r107 >>> 8) & 255];
        byte r130 = r114[(r107 >>> 16) & 255];
        byte r131 = r116[r107 >>> 24];
        int r132 = r131 << 24;
        int r133 = r132 | (((r128 & UByte.MAX_VALUE) | ((r129 & UByte.MAX_VALUE) << 8)) | ((r130 & UByte.MAX_VALUE) << 16));
        byte r134 = r109[r106 & 255];
        byte r135 = r112[(r106 >>> 8) & 255];
        byte r136 = r114[(r106 >>> 16) & 255];
        byte r137 = r116[r106 >>> 24];
        int r138 = r137 << 24;
        int r139 = r138 | (((r134 & UByte.MAX_VALUE) | ((r135 & UByte.MAX_VALUE) << 8)) | ((r136 & UByte.MAX_VALUE) << 16));
        long r140 = ((long) r133) & BodyPartID.bodyIdMax;
        long r141 = mixColumn(r127);
        long r142 = mixColumn((((long) r139) << 32) | r140);
        r105 = r105 + 1;
        int r143 = this.roundsAmount;
        if (r105 == r143) goto L5;
        long[] r144 = this.roundKeys[r105];
        long r145 = r141 ^ r144[0];
        r104 = r142 ^ r144[1];
        r103 = r145;
        goto L3
    L5:
        long[] r146 = this.roundKeys[r143];
        long r147 = r141 + r146[0];
        long r148 = r142 + r146[1];
        Pack.longToLittleEndian(r147, r212, r213);
        Pack.longToLittleEndian(r148, r212, r213 + 8);
    }

    private void invShiftRows() {
        int r100 = this.wordsInBlock;
        if (r100 != 2) goto L5;
        long[] r101 = this.internalState;
        long r102 = r101[0];
        long r103 = r101[1];
        long r104 = (-4294967296L) & (r102 ^ r103);
        long r105 = r102 ^ r104;
        r101[0] = r105;
        r101[1] = r104 ^ r103;
        return;
    L5:
        if (r100 != 4) goto L7;
        long[] r106 = this.internalState;
        long r110 = r106[0];
        long r111 = r106[1];
        long r112 = r106[2];
        long r113 = r106[3];
        long r210 = (r110 ^ r111) & (-281470681808896L);
        long r114 = r110 ^ r210;
        long r115 = r111 ^ r210;
        long r107 = (r112 ^ r113) & (-281470681808896L);
        long r116 = r112 ^ r107;
        long r108 = r113 ^ r107;
        long r109 = (r114 ^ r116) & (-4294967296L);
        long r117 = r114 ^ r109;
        long r118 = r116 ^ r109;
        long r119 = (r115 ^ r108) & 281474976645120L;
        long r120 = r115 ^ r119;
        r106[0] = r117;
        r106[1] = r120;
        r106[2] = r118;
        r106[3] = r119 ^ r108;
        return;
    L7:
        if (r100 != 8) goto L10;
        long[] r121 = this.internalState;
        long r122 = r121[0];
        long r123 = r121[1];
        long r124 = r121[2];
        long r125 = r121[3];
        long r211 = r121[4];
        long r212 = r121[5];
        long r213 = r121[6];
        long r310 = r121[7];
        long r311 = (r122 ^ r123) & (-71777214294589696L);
        long r126 = r122 ^ r311;
        long r127 = r123 ^ r311;
        long r312 = (r124 ^ r125) & (-71777214294589696L);
        long r128 = r124 ^ r312;
        long r129 = r125 ^ r312;
        long r313 = (r211 ^ r212) & (-71777214294589696L);
        long r214 = r211 ^ r313;
        long r215 = r212 ^ r313;
        long r314 = (r213 ^ r310) & (-71777214294589696L);
        long r216 = r213 ^ r314;
        long r315 = r310 ^ r314;
        long r316 = (r126 ^ r128) & (-281470681808896L);
        long r130 = r126 ^ r316;
        long r131 = r128 ^ r316;
        long r317 = (r127 ^ r129) & 72056494543077120L;
        long r132 = r127 ^ r317;
        long r133 = r129 ^ r317;
        long r134 = (r214 ^ r216) & (-281470681808896L);
        long r217 = r214 ^ r134;
        long r135 = r216 ^ r134;
        long r218 = (r215 ^ r315) & 72056494543077120L;
        long r219 = r215 ^ r218;
        long r220 = r315 ^ r218;
        long r136 = (r130 ^ r217) & (-4294967296L);
        long r137 = r130 ^ r136;
        long r138 = r217 ^ r136;
        long r221 = (r132 ^ r219) & 72057594021150720L;
        long r139 = r132 ^ r221;
        long r222 = r219 ^ r221;
        long r140 = (r131 ^ r135) & 281474976645120L;
        long r141 = r131 ^ r140;
        long r142 = r140 ^ r135;
        long r143 = (r133 ^ r220) & 1099511627520L;
        long r144 = r133 ^ r143;
        r121[0] = r137;
        r121[1] = r139;
        r121[2] = r141;
        r121[3] = r144;
        r121[4] = r138;
        r121[5] = r222;
        r121[6] = r142;
        r121[7] = r220 ^ r143;
        return;
    L10:
        throw new IllegalStateException("unsupported block length: only 128/256/512 are allowed");
    }

    private void invSubBytes() {
        int r100 = 0;
    L4:
        if (r100 >= this.wordsInBlock) goto L6;
        long[] r101 = this.internalState;
        long r102 = r101[r100];
        int r103 = (int) r102;
        int r104 = (int) (r102 >>> 32);
        byte[] r105 = T0;
        byte r106 = r105[r103 & 255];
        byte[] r107 = T1;
        byte r108 = r107[(r103 >>> 8) & 255];
        byte[] r109 = T2;
        byte r110 = r109[(r103 >>> 16) & 255];
        byte[] r111 = T3;
        byte r112 = r111[r103 >>> 24];
        int r113 = r112 << 24;
        int r114 = r113 | (((r106 & UByte.MAX_VALUE) | ((r108 & UByte.MAX_VALUE) << 8)) | ((r110 & UByte.MAX_VALUE) << 16));
        byte r115 = r105[r104 & 255];
        byte r116 = r107[(r104 >>> 8) & 255];
        byte r117 = r109[(r104 >>> 16) & 255];
        byte r118 = r111[r104 >>> 24];
        int r119 = (((r115 & UByte.MAX_VALUE) | ((r116 & UByte.MAX_VALUE) << 8)) | ((r117 & UByte.MAX_VALUE) << 16)) | (r118 << 24);
        r101[r100] = (((long) r114) & BodyPartID.bodyIdMax) | (((long) r119) << 32);
        r100 = r100 + 1;
        goto L4
    }

    private static long mixColumn(long r100) {
        long r101 = mulX(r100);
        long r102 = rotate(8, r100) ^ r100;
        long r103 = (r102 ^ rotate(16, r102)) ^ rotate(48, r100);
        return ((rotate(32, mulX2((r100 ^ r103) ^ r101)) ^ r103) ^ rotate(40, r101)) ^ rotate(48, r101);
    }

    private static long mixColumnInv(long r110) {
        long r100 = rotate(8, r110) ^ r110;
        long r101 = (r100 ^ rotate(32, r100)) ^ rotate(48, r110);
        long r102 = r101 ^ r110;
        long r103 = rotate(48, r110);
        long r111 = rotate(56, r110);
        long r112 = rotate(56, r102);
        long r113 = mulX(r102 ^ r111) ^ r112;
        long r114 = rotate(16, r102) ^ r110;
        long r115 = rotate(40, mulX(r113) ^ r110) ^ r114;
        long r116 = mulX(r115);
        long r117 = r116 ^ (r102 ^ r103);
        long r118 = rotate(16, r101);
        long r119 = mulX(r117) ^ r118;
        long r104 = ((r103 ^ (rotate(24, r110) ^ r102)) ^ r111) ^ mulX(r119);
        return mulX(rotate(40, ((r110 ^ rotate(32, r102)) ^ r111) ^ mulX(r104))) ^ r101;
    }

    private void mixColumns() {
        int r100 = 0;
    L4:
        if (r100 >= this.wordsInBlock) goto L6;
        long[] r101 = this.internalState;
        r101[r100] = mixColumn(r101[r100]);
        r100 = r100 + 1;
        goto L4
    }

    private void mixColumnsInv() {
        int r100 = 0;
    L4:
        if (r100 >= this.wordsInBlock) goto L6;
        long[] r101 = this.internalState;
        r101[r100] = mixColumnInv(r101[r100]);
        r100 = r100 + 1;
        goto L4
    }

    private static long mulX(long r100) {
        long r101 = (9187201950435737471L & r100) << 1;
        return (((r100 & (-9187201950435737472L)) >>> 7) * 29) ^ r101;
    }

    private static long mulX2(long r100) {
        long r101 = ((4557430888798830399L & r100) << 2) ^ ((((-9187201950435737472L) & r100) >>> 6) * 29);
        return (((r100 & 4629771061636907072L) >>> 6) * 29) ^ r101;
    }

    private static long rotate(int r100, long r101) {
        long r102 = r101 >>> r100;
        return (r101 << (-r100)) | r102;
    }

    private void rotateLeft(long[] r310, long[] r311) {
        int r100 = this.wordsInBlock;
        if (r100 != 2) goto L5;
        long r101 = r310[0];
        long r102 = r310[1];
        r311[0] = (r101 >>> 56) | (r102 << 8);
        long r103 = r101 << 8;
        r311[1] = r103 | (r102 >>> 56);
        return;
    L5:
        if (r100 == 4) goto L10;
        if (r100 != 8) goto L9;
        long r104 = r310[0];
        long r110 = r310[1];
        long r111 = r310[2];
        long r112 = r310[3];
        long r113 = r310[4];
        long r114 = r310[5];
        long r210 = r310[6];
        long r211 = r310[7];
        r311[0] = (r111 >>> 24) | (r112 << 40);
        r311[1] = (r112 >>> 24) | (r113 << 40);
        r311[2] = (r113 >>> 24) | (r114 << 40);
        r311[3] = (r114 >>> 24) | (r210 << 40);
        r311[4] = (r210 >>> 24) | (r211 << 40);
        r311[5] = (r211 >>> 24) | (r104 << 40);
        r311[6] = (r104 >>> 24) | (r110 << 40);
        r311[7] = (r110 >>> 24) | (r111 << 40);
        return;
    L9:
        throw new IllegalStateException("unsupported block length: only 128/256/512 are allowed");
    L10:
        long r105 = r310[0];
        long r115 = r310[1];
        long r116 = r310[2];
        long r117 = r310[3];
        r311[0] = (r115 >>> 24) | (r116 << 40);
        r311[1] = (r116 >>> 24) | (r117 << 40);
        r311[2] = (r117 >>> 24) | (r105 << 40);
        r311[3] = (r105 >>> 24) | (r115 << 40);
    }

    private void shiftRows() {
        int r100 = this.wordsInBlock;
        if (r100 != 2) goto L5;
        long[] r101 = this.internalState;
        long r102 = r101[0];
        long r103 = r101[1];
        long r104 = (-4294967296L) & (r102 ^ r103);
        long r105 = r102 ^ r104;
        r101[0] = r105;
        r101[1] = r104 ^ r103;
        return;
    L5:
        if (r100 != 4) goto L7;
        long[] r106 = this.internalState;
        long r110 = r106[0];
        long r111 = r106[1];
        long r112 = r106[2];
        long r113 = r106[3];
        long r107 = (r110 ^ r112) & (-4294967296L);
        long r114 = r110 ^ r107;
        long r108 = r112 ^ r107;
        long r109 = (r111 ^ r113) & 281474976645120L;
        long r115 = r111 ^ r109;
        long r116 = r113 ^ r109;
        long r117 = (r114 ^ r115) & (-281470681808896L);
        long r118 = r114 ^ r117;
        long r119 = r115 ^ r117;
        long r120 = (r108 ^ r116) & (-281470681808896L);
        r106[0] = r118;
        r106[1] = r119;
        r106[2] = r108 ^ r120;
        r106[3] = r116 ^ r120;
        return;
    L7:
        if (r100 != 8) goto L10;
        long[] r121 = this.internalState;
        long r122 = r121[0];
        long r123 = r121[1];
        long r124 = r121[2];
        long r125 = r121[3];
        long r210 = r121[4];
        long r211 = r121[5];
        long r212 = r121[6];
        long r310 = r121[7];
        long r126 = (r122 ^ r210) & (-4294967296L);
        long r127 = r122 ^ r126;
        long r128 = r210 ^ r126;
        long r213 = (r123 ^ r211) & 72057594021150720L;
        long r129 = r123 ^ r213;
        long r214 = r211 ^ r213;
        long r130 = (r124 ^ r212) & 281474976645120L;
        long r131 = r124 ^ r130;
        long r132 = r212 ^ r130;
        long r215 = (r125 ^ r310) & 1099511627520L;
        long r133 = r125 ^ r215;
        long r216 = r310 ^ r215;
        long r217 = (r127 ^ r131) & (-281470681808896L);
        long r134 = r127 ^ r217;
        long r135 = r131 ^ r217;
        long r218 = (r129 ^ r133) & 72056494543077120L;
        long r136 = r129 ^ r218;
        long r137 = r133 ^ r218;
        long r138 = (r128 ^ r132) & (-281470681808896L);
        long r139 = r128 ^ r138;
        long r140 = r132 ^ r138;
        long r141 = (r214 ^ r216) & 72056494543077120L;
        long r219 = r214 ^ r141;
        long r142 = r216 ^ r141;
        long r220 = (r134 ^ r136) & (-71777214294589696L);
        long r143 = r134 ^ r220;
        long r144 = r136 ^ r220;
        long r221 = (r135 ^ r137) & (-71777214294589696L);
        long r145 = r135 ^ r221;
        long r146 = r137 ^ r221;
        long r222 = (r139 ^ r219) & (-71777214294589696L);
        long r147 = r139 ^ r222;
        long r223 = r219 ^ r222;
        long r224 = (r140 ^ r142) & (-71777214294589696L);
        r121[0] = r143;
        r121[1] = r144;
        r121[2] = r145;
        r121[3] = r146;
        r121[4] = r147;
        r121[5] = r223;
        r121[6] = r140 ^ r224;
        r121[7] = r142 ^ r224;
        return;
    L10:
        throw new IllegalStateException("unsupported block length: only 128/256/512 are allowed");
    }

    private void subBytes() {
        int r100 = 0;
    L4:
        if (r100 >= this.wordsInBlock) goto L6;
        long[] r101 = this.internalState;
        long r102 = r101[r100];
        int r103 = (int) r102;
        int r104 = (int) (r102 >>> 32);
        byte[] r105 = S0;
        byte r106 = r105[r103 & 255];
        byte[] r107 = S1;
        byte r108 = r107[(r103 >>> 8) & 255];
        byte[] r109 = S2;
        byte r110 = r109[(r103 >>> 16) & 255];
        byte[] r111 = S3;
        byte r112 = r111[r103 >>> 24];
        int r113 = r112 << 24;
        int r114 = r113 | (((r106 & UByte.MAX_VALUE) | ((r108 & UByte.MAX_VALUE) << 8)) | ((r110 & UByte.MAX_VALUE) << 16));
        byte r115 = r105[r104 & 255];
        byte r116 = r107[(r104 >>> 8) & 255];
        byte r117 = r109[(r104 >>> 16) & 255];
        byte r118 = r111[r104 >>> 24];
        int r119 = (((r115 & UByte.MAX_VALUE) | ((r116 & UByte.MAX_VALUE) << 8)) | ((r117 & UByte.MAX_VALUE) << 16)) | (r118 << 24);
        r101[r100] = (((long) r114) & BodyPartID.bodyIdMax) | (((long) r119) << 32);
        r100 = r100 + 1;
        goto L4
    }

    private void subRoundKey(int r100) {
        long[] r101 = this.roundKeys[r100];
        int r102 = 0;
    L4:
        if (r102 >= this.wordsInBlock) goto L6;
        long[] r103 = this.internalState;
        r103[r102] = r103[r102] - r101[r102];
        r102 = r102 + 1;
        goto L4
    }

    private void workingKeyExpandEven(long[] r110, long[] r111) {
        int r100 = this.wordsInKey;
        long[] r101 = new long[r100];
        long[] r102 = new long[this.wordsInBlock];
        System.arraycopy(r110, 0, r101, 0, r100);
        long r103 = 281479271743489L;
        int r104 = 0;
    L3:
        int r105 = 0;
    L5:
        if (r105 >= this.wordsInBlock) goto L7;
        r102[r105] = r111[r105] + r103;
        r105 = r105 + 1;
        goto L5
    L7:
        int r106 = 0;
    L9:
        if (r106 >= this.wordsInBlock) goto L11;
        this.internalState[r106] = r101[r106] + r102[r106];
        r106 = r106 + 1;
        goto L9
    L11:
        subBytes();
        shiftRows();
        mixColumns();
        int r107 = 0;
    L13:
        if (r107 >= this.wordsInBlock) goto L15;
        long[] r108 = this.internalState;
        r108[r107] = r108[r107] ^ r102[r107];
        r107 = r107 + 1;
        goto L13
    L15:
        subBytes();
        shiftRows();
        mixColumns();
        int r109 = 0;
    L16:
        int r112 = this.wordsInBlock;
        if (r109 >= r112) goto L19;
        long[] r113 = this.internalState;
        r113[r109] = r113[r109] + r102[r109];
        r109 = r109 + 1;
        goto L16
    L19:
        System.arraycopy(this.internalState, 0, this.roundKeys[r104], 0, r112);
        if (this.roundsAmount == r104) goto L42;
        int r114 = 1;
        if (this.wordsInBlock == this.wordsInKey) goto L43;
        r104 = r104 + 2;
        r103 = r103 << 1;
        int r115 = 0;
    L26:
        if (r115 >= this.wordsInBlock) goto L28;
        r102[r115] = r111[r115] + r103;
        r115 = r115 + 1;
        goto L26
    L28:
        int r116 = 0;
    L29:
        int r117 = this.wordsInBlock;
        if (r116 >= r117) goto L32;
        this.internalState[r116] = r101[r117 + r116] + r102[r116];
        r116 = r116 + 1;
        goto L29
    L32:
        subBytes();
        shiftRows();
        mixColumns();
        int r118 = 0;
    L34:
        if (r118 >= this.wordsInBlock) goto L36;
        long[] r119 = this.internalState;
        r119[r118] = r119[r118] ^ r102[r118];
        r118 = r118 + 1;
        goto L34
    L36:
        subBytes();
        shiftRows();
        mixColumns();
        int r120 = 0;
    L37:
        int r121 = this.wordsInBlock;
        if (r120 >= r121) goto L40;
        long[] r122 = this.internalState;
        r122[r120] = r122[r120] + r102[r120];
        r120 = r120 + 1;
        goto L37
    L40:
        System.arraycopy(this.internalState, 0, this.roundKeys[r104], 0, r121);
        if (this.roundsAmount != r104) goto L43;
        return;
    L43:
        r104 = r104 + 2;
        r103 = r103 << 1;
        long r123 = r101[0];
    L44:
        if (r114 >= r100) goto L46;
        r101[r114 - 1] = r101[r114];
        r114 = r114 + 1;
        goto L44
    L46:
        r101[r100 - 1] = r123;
        goto L3
    }

    private void workingKeyExpandKT(long[] r110, long[] r111) {
        int r100 = this.wordsInBlock;
        long[] r101 = new long[r100];
        long[] r102 = new long[r100];
        long[] r103 = new long[r100];
        this.internalState = r103;
        long r104 = r103[0];
        int r105 = this.wordsInKey;
        r103[0] = r104 + ((long) ((r100 + r105) + 1));
        System.arraycopy(r110, 0, r101, 0, r100);
        if (r100 != r105) goto L5;
        System.arraycopy(r110, 0, r102, 0, r100);
    L6:
        int r112 = 0;
    L7:
        long[] r106 = this.internalState;
        if (r112 >= r106.length) goto L10;
        r106[r112] = r106[r112] + r101[r112];
        r112 = r112 + 1;
        goto L7
    L10:
        subBytes();
        shiftRows();
        mixColumns();
        int r113 = 0;
    L11:
        long[] r107 = this.internalState;
        if (r113 >= r107.length) goto L14;
        r107[r113] = r107[r113] ^ r102[r113];
        r113 = r113 + 1;
        goto L11
    L14:
        subBytes();
        shiftRows();
        mixColumns();
        int r114 = 0;
    L15:
        long[] r108 = this.internalState;
        if (r114 >= r108.length) goto L18;
        r108[r114] = r108[r114] + r101[r114];
        r114 = r114 + 1;
        goto L15
    L18:
        subBytes();
        shiftRows();
        mixColumns();
        System.arraycopy(this.internalState, 0, r111, 0, this.wordsInBlock);
        return;
    L5:
        int r109 = this.wordsInBlock;
        System.arraycopy(r110, r109, r102, 0, r109);
        goto L6
    }

    private void workingKeyExpandOdd() {
        int r100 = 1;
    L4:
        if (r100 >= this.roundsAmount) goto L6;
        long[][] r101 = this.roundKeys;
        rotateLeft(r101[r100 - 1], r101[r100]);
        r100 = r100 + 2;
        goto L4
    }

    private void xorRoundKey(int r100) {
        long[] r101 = this.roundKeys[r100];
        int r102 = 0;
    L4:
        if (r102 >= this.wordsInBlock) goto L6;
        long[] r103 = this.internalState;
        r103[r102] = r103[r102] ^ r101[r102];
        r102 = r102 + 1;
        goto L4
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "DSTU7624";
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return this.wordsInBlock << 3;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean r100, CipherParameters r101) throws IllegalArgumentException {
        if ((r101 instanceof KeyParameter) == false) goto L36;
        this.forEncryption = r100;
        byte[] r102 = ((KeyParameter) r101).getKey();
        int r103 = r102.length << 3;
        int r104 = this.wordsInBlock << 6;
        if (r103 == 128) goto L11;
        if (r103 == 256) goto L11;
        if (r103 == 512) goto L11;
        throw new IllegalArgumentException("unsupported key length: only 128/256/512 are allowed");
    L11:
        if (r103 != r104) goto L13;
    L17:
        if (r103 == 128) goto L23;
        if (r103 == 256) goto L22;
        if (r103 != 512) goto L25;
        int r105 = 18;
    L24:
        this.roundsAmount = r105;
    L25:
        this.wordsInKey = r103 >>> 6;
        this.roundKeys = new long[this.roundsAmount + 1][];
        int r106 = 0;
    L26:
        long[][] r107 = this.roundKeys;
        if (r106 >= r107.length) goto L29;
        r107[r106] = new long[this.wordsInBlock];
        r106 = r106 + 1;
        goto L26
    L29:
        long[] r108 = new long[this.wordsInKey];
        this.workingKey = r108;
        if (r102.length != (r103 >>> 3)) goto L34;
        Pack.littleEndianToLong(r102, 0, r108);
        long[] r109 = new long[this.wordsInBlock];
        workingKeyExpandKT(this.workingKey, r109);
        workingKeyExpandEven(this.workingKey, r109);
        workingKeyExpandOdd();
        return;
    L34:
        throw new IllegalArgumentException("Invalid key parameter passed to DSTU7624Engine init");
    L22:
        r105 = 14;
        goto L24
    L23:
        r105 = 10;
        goto L24
    L13:
        if (r103 == (r104 * 2)) goto L17;
        throw new IllegalArgumentException("Unsupported key length");
    L36:
        throw new IllegalArgumentException("Invalid parameter passed to DSTU7624Engine init");
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] r100, int r101, byte[] r102, int r103) throws DataLengthException, IllegalStateException {
        if (this.workingKey == null) goto L33;
        if ((getBlockSize() + r101) > r100.length) goto L31;
        if ((getBlockSize() + r103) > r102.length) goto L29;
        int r104 = 0;
        if (this.forEncryption == false) goto L19;
        if (this.wordsInBlock == 2) goto L17;
        Pack.littleEndianToLong(r100, r101, this.internalState);
        addRoundKey(0);
    L13:
        subBytes();
        shiftRows();
        mixColumns();
        r104 = r104 + 1;
        int r105 = this.roundsAmount;
        if (r104 == r105) goto L15;
        xorRoundKey(r104);
        goto L13
    L15:
        addRoundKey(r105);
        Pack.longToLittleEndian(this.internalState, r102, r103);
    L27:
        return getBlockSize();
    L17:
        encryptBlock_128(r100, r101, r102, r103);
        goto L27
    L19:
        if (this.wordsInBlock == 2) goto L25;
        Pack.littleEndianToLong(r100, r101, this.internalState);
        subRoundKey(this.roundsAmount);
        int r106 = this.roundsAmount;
    L21:
        mixColumnsInv();
        invShiftRows();
        invSubBytes();
        r106 = r106 - 1;
        if (r106 == 0) goto L23;
        xorRoundKey(r106);
        goto L21
    L23:
        subRoundKey(0);
        Pack.longToLittleEndian(this.internalState, r102, r103);
        goto L27
    L25:
        decryptBlock_128(r100, r101, r102, r103);
        goto L27
    L29:
        throw new OutputLengthException("Output buffer too short");
    L31:
        throw new DataLengthException("Input buffer too short");
    L33:
        throw new IllegalStateException("DSTU7624Engine not initialised");
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
        Arrays.fill(this.internalState, 0);
    }
}
