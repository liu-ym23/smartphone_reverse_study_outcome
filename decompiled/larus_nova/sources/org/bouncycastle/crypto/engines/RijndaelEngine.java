package org.bouncycastle.crypto.engines;

import com.baidu.bbalbscesium.i.j;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.model.VideoRef;
import java.lang.reflect.Array;
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

/* JADX INFO: loaded from: classes42.dex */
public class RijndaelEngine implements BlockCipher {
    private static final int MAXKC = 64;
    private static final int MAXROUNDS = 14;
    private static final byte[] S = null;
    private static final byte[] Si = null;
    private static final byte[] aLogtable = null;
    private static final byte[] logtable = null;
    private static final int[] rcon = null;
    static byte[][] shifts0;
    static byte[][] shifts1;
    private long A0;
    private long A1;
    private long A2;
    private long A3;
    private int BC;
    private long BC_MASK;
    private int ROUNDS;
    private int blockBits;
    private boolean forEncryption;
    private byte[] shifts0SC;
    private byte[] shifts1SC;
    private long[][] workingKey;

    static {
        logtable = new byte[]{0, 0, 25, 1, 50, 2, 26, -58, 75, -57, 27, 104, 51, -18, -33, 3, 100, 4, -32, 14, 52, -115, -127, -17, 76, 113, 8, -56, -8, 105, 28, -63, 125, -62, 29, -75, -7, -71, 39, 106, 77, -28, -90, 114, -102, -55, 9, 120, 101, 47, -118, 5, 33, 15, -31, 36, 18, -16, -126, 69, 53, -109, -38, -114, -106, -113, -37, -67, 54, -48, -50, -108, 19, 92, -46, -15, 64, 70, -125, 56, 102, -35, -3, 48, -65, 6, -117, 98, -77, 37, -30, -104, 34, -120, -111, 16, 126, 110, 72, -61, -93, -74, 30, 66, 58, 107, 40, 84, -6, -123, Base64.padSymbol, -70, 43, 121, 10, 21, -101, -97, 94, -54, 78, -44, -84, -27, -13, 115, -89, 87, -81, 88, -88, 80, -12, -22, -42, 116, 79, -82, -23, -43, -25, -26, -83, -24, 44, -41, 117, 122, -21, 22, 11, -11, 89, -53, 95, -80, -100, -87, 81, -96, ByteCompanionObject.MAX_VALUE, 12, -10, 111, 23, -60, 73, -20, -40, 67, 31, 45, -92, 118, 123, -73, -52, -69, 62, 90, -5, 96, -79, -122, 59, 82, -95, 108, -86, 85, 41, -99, -105, -78, -121, -112, 97, -66, -36, -4, PSSSigner.TRAILER_IMPLICIT, -107, -49, -51, 55, 63, 91, -47, 83, 57, -124, 60, 65, -94, 109, 71, 20, 42, -98, 93, 86, -14, -45, -85, 68, 17, -110, -39, 35, 32, 46, -119, -76, 124, -72, 38, 119, -103, -29, -91, 103, 74, -19, -34, -59, 49, -2, 24, HTTP.CR, 99, -116, ByteCompanionObject.MIN_VALUE, -64, -9, 112, 7};
        aLogtable = new byte[]{0, 3, 5, 15, 17, 51, 85, -1, 26, 46, 114, -106, -95, -8, 19, 53, 95, -31, 56, 72, -40, 115, -107, -92, -9, 2, 6, 10, 30, 34, 102, -86, -27, 52, 92, -28, 55, 89, -21, 38, 106, -66, -39, 112, -112, -85, -26, 49, 83, -11, 4, 12, 20, 60, 68, -52, 79, -47, 104, -72, -45, 110, -78, -51, 76, -44, 103, -87, -32, 59, 77, -41, 98, -90, -15, 8, 24, 40, 120, -120, -125, -98, -71, -48, 107, -67, -36, ByteCompanionObject.MAX_VALUE, -127, -104, -77, -50, 73, -37, 118, -102, -75, -60, 87, -7, 16, 48, 80, -16, 11, 29, 39, 105, -69, -42, 97, -93, -2, 25, 43, 125, -121, -110, -83, -20, 47, 113, -109, -82, -23, 32, 96, -96, -5, 22, 58, 78, -46, 109, -73, -62, 93, -25, 50, 86, -6, 21, 63, 65, -61, 94, -30, Base64.padSymbol, 71, -55, 64, -64, 91, -19, 44, 116, -100, -65, -38, 117, -97, -70, -43, 100, -84, -17, 42, 126, -126, -99, PSSSigner.TRAILER_IMPLICIT, -33, 122, -114, -119, ByteCompanionObject.MIN_VALUE, -101, -74, -63, 88, -24, 35, 101, -81, -22, 37, 111, -79, -56, 67, -59, 84, -4, 31, 33, 99, -91, -12, 7, 9, 27, 45, 119, -103, -80, -53, 70, -54, 69, -49, 74, -34, 121, -117, -122, -111, -88, -29, 62, 66, -58, 81, -13, 14, 18, 54, 90, -18, 41, 123, -115, -116, -113, -118, -123, -108, -89, -14, HTTP.CR, 23, 57, 75, -35, 124, -124, -105, -94, -3, 28, 36, 108, -76, -57, 82, -10, 1, 3, 5, 15, 17, 51, 85, -1, 26, 46, 114, -106, -95, -8, 19, 53, 95, -31, 56, 72, -40, 115, -107, -92, -9, 2, 6, 10, 30, 34, 102, -86, -27, 52, 92, -28, 55, 89, -21, 38, 106, -66, -39, 112, -112, -85, -26, 49, 83, -11, 4, 12, 20, 60, 68, -52, 79, -47, 104, -72, -45, 110, -78, -51, 76, -44, 103, -87, -32, 59, 77, -41, 98, -90, -15, 8, 24, 40, 120, -120, -125, -98, -71, -48, 107, -67, -36, ByteCompanionObject.MAX_VALUE, -127, -104, -77, -50, 73, -37, 118, -102, -75, -60, 87, -7, 16, 48, 80, -16, 11, 29, 39, 105, -69, -42, 97, -93, -2, 25, 43, 125, -121, -110, -83, -20, 47, 113, -109, -82, -23, 32, 96, -96, -5, 22, 58, 78, -46, 109, -73, -62, 93, -25, 50, 86, -6, 21, 63, 65, -61, 94, -30, Base64.padSymbol, 71, -55, 64, -64, 91, -19, 44, 116, -100, -65, -38, 117, -97, -70, -43, 100, -84, -17, 42, 126, -126, -99, PSSSigner.TRAILER_IMPLICIT, -33, 122, -114, -119, ByteCompanionObject.MIN_VALUE, -101, -74, -63, 88, -24, 35, 101, -81, -22, 37, 111, -79, -56, 67, -59, 84, -4, 31, 33, 99, -91, -12, 7, 9, 27, 45, 119, -103, -80, -53, 70, -54, 69, -49, 74, -34, 121, -117, -122, -111, -88, -29, 62, 66, -58, 81, -13, 14, 18, 54, 90, -18, 41, 123, -115, -116, -113, -118, -123, -108, -89, -14, HTTP.CR, 23, 57, 75, -35, 124, -124, -105, -94, -3, 28, 36, 108, -76, -57, 82, -10, 1};
        S = new byte[]{99, 124, 119, 123, -14, 107, 111, -59, 48, 1, 103, 43, -2, -41, -85, 118, -54, -126, -55, 125, -6, 89, 71, -16, -83, -44, -94, -81, -100, -92, 114, -64, -73, -3, -109, 38, 54, 63, -9, -52, 52, -91, -27, -15, 113, -40, 49, 21, 4, -57, 35, -61, 24, -106, 5, -102, 7, 18, ByteCompanionObject.MIN_VALUE, -30, -21, 39, -78, 117, 9, -125, 44, 26, 27, 110, 90, -96, 82, 59, -42, -77, 41, -29, 47, -124, 83, -47, 0, -19, 32, -4, -79, 91, 106, -53, -66, 57, 74, 76, 88, -49, -48, -17, -86, -5, 67, 77, 51, -123, 69, -7, 2, ByteCompanionObject.MAX_VALUE, 80, 60, -97, -88, 81, -93, 64, -113, -110, -99, 56, -11, PSSSigner.TRAILER_IMPLICIT, -74, -38, 33, 16, -1, -13, -46, -51, 12, 19, -20, 95, -105, 68, 23, -60, -89, 126, Base64.padSymbol, 100, 93, 25, 115, 96, -127, 79, -36, 34, 42, -112, -120, 70, -18, -72, 20, -34, 94, 11, -37, -32, 50, 58, 10, 73, 6, 36, 92, -62, -45, -84, 98, -111, -107, -28, 121, -25, -56, 55, 109, -115, -43, 78, -87, 108, 86, -12, -22, 101, 122, -82, 8, -70, 120, 37, 46, 28, -90, -76, -58, -24, -35, 116, 31, 75, -67, -117, -118, 112, 62, -75, 102, 72, 3, -10, 14, 97, 53, 87, -71, -122, -63, 29, -98, -31, -8, -104, 17, 105, -39, -114, -108, -101, 30, -121, -23, -50, 85, 40, -33, -116, -95, -119, HTTP.CR, -65, -26, 66, 104, 65, -103, 45, 15, -80, 84, -69, 22};
        Si = new byte[]{82, 9, 106, -43, 48, 54, -91, 56, -65, 64, -93, -98, -127, -13, -41, -5, 124, -29, 57, -126, -101, 47, -1, -121, 52, -114, 67, 68, -60, -34, -23, -53, 84, 123, -108, 50, -90, -62, 35, Base64.padSymbol, -18, 76, -107, 11, 66, -6, -61, 78, 8, 46, -95, 102, 40, -39, 36, -78, 118, 91, -94, 73, 109, -117, -47, 37, 114, -8, -10, 100, -122, 104, -104, 22, -44, -92, 92, -52, 93, 101, -74, -110, 108, 112, 72, 80, -3, -19, -71, -38, 94, 21, 70, 87, -89, -115, -99, -124, -112, -40, -85, 0, -116, PSSSigner.TRAILER_IMPLICIT, -45, 10, -9, -28, 88, 5, -72, -77, 69, 6, -48, 44, 30, -113, -54, 63, 15, 2, -63, -81, -67, 3, 1, 19, -118, 107, 58, -111, 17, 65, 79, 103, -36, -22, -105, -14, -49, -50, -16, -76, -26, 115, -106, -84, 116, 34, -25, -83, 53, -123, -30, -7, 55, -24, 28, 117, -33, 110, 71, -15, 26, 113, 29, 41, -59, -119, 111, -73, 98, 14, -86, 24, -66, 27, -4, 86, 62, 75, -58, -46, 121, 32, -102, -37, -64, -2, 120, -51, 90, -12, 31, -35, -88, 51, -120, 7, -57, 49, -79, 18, 16, 89, 39, ByteCompanionObject.MIN_VALUE, -20, 95, 96, 81, ByteCompanionObject.MAX_VALUE, -87, 25, -75, 74, HTTP.CR, 45, -27, 122, -97, -109, -55, -100, -17, -96, -32, 59, 77, -82, 42, -11, -80, -56, -21, -69, 60, -125, 83, -103, 97, 23, 43, 4, 126, -70, 119, -42, 38, -31, 105, 20, 99, 85, 33, 12, 125};
        rcon = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 27, 54, 108, 216, 171, 77, 154, 47, 94, 188, 99, 198, 151, 53, 106, 212, 179, 125, 250, VideoRef.VALUE_VIDEO_REF_SUBTITLE_POSITION_X, MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, 145};
        shifts0 = new byte[][]{new byte[]{0, 8, 16, 24}, new byte[]{0, 8, 16, 24}, new byte[]{0, 8, 16, 24}, new byte[]{0, 8, 16, 32}, new byte[]{0, 8, 24, 32}};
        shifts1 = new byte[][]{new byte[]{0, 24, 16, 8}, new byte[]{0, 32, 24, 16}, new byte[]{0, 40, 32, 24}, new byte[]{0, 48, 40, 24}, new byte[]{0, 56, 40, 32}};
    }

    public RijndaelEngine() {
        this(128);
    }

    public RijndaelEngine(int r100) {
        if (r100 != 128) goto L5;
        this.BC = 32;
        this.BC_MASK = BodyPartID.bodyIdMax;
        this.shifts0SC = shifts0[0];
        this.shifts1SC = shifts1[0];
    L19:
        this.blockBits = r100;
        return;
    L5:
        if (r100 != 160) goto L7;
        this.BC = 40;
        this.BC_MASK = j.f30151d;
        this.shifts0SC = shifts0[1];
        this.shifts1SC = shifts1[1];
        goto L19
    L7:
        if (r100 != 192) goto L9;
        this.BC = 48;
        this.BC_MASK = 281474976710655L;
        this.shifts0SC = shifts0[2];
        this.shifts1SC = shifts1[2];
        goto L19
    L9:
        if (r100 != 224) goto L11;
        this.BC = 56;
        this.BC_MASK = 72057594037927935L;
        this.shifts0SC = shifts0[3];
        this.shifts1SC = shifts1[3];
        goto L19
    L11:
        if (r100 != 256) goto L14;
        this.BC = 64;
        this.BC_MASK = -1;
        this.shifts0SC = shifts0[4];
        this.shifts1SC = shifts1[4];
        goto L19
    L14:
        throw new IllegalArgumentException("unknown blocksize to Rijndael");
    }

    private void InvMixColumn() {
        long r100 = 0;
        long r101 = 0;
        long r102 = 0;
        long r103 = 0;
        int r104 = 0;
    L4:
        if (r104 >= this.BC) goto L18;
        int r110 = (int) ((this.A0 >> r104) & 255);
        int r111 = (int) ((this.A1 >> r104) & 255);
        int r112 = (int) ((this.A2 >> r104) & 255);
        long r113 = r103;
        int r105 = (int) ((this.A3 >> r104) & 255);
        int r106 = -1;
        if (r110 == 0) goto L8;
        int r114 = logtable[r110 & 255] & UByte.MAX_VALUE;
    L9:
        if (r111 == 0) goto L11;
        int r115 = logtable[r111 & 255] & UByte.MAX_VALUE;
    L12:
        if (r112 == 0) goto L14;
        int r116 = logtable[r112 & 255] & UByte.MAX_VALUE;
    L15:
        if (r105 == 0) goto L17;
        r106 = logtable[r105 & 255] & UByte.MAX_VALUE;
    L17:
        r100 = r100 | (((long) ((((mul0xe(r114) ^ mul0xb(r115)) ^ mul0xd(r116)) ^ mul0x9(r106)) & 255)) << r104);
        r101 = r101 | (((long) ((((mul0xe(r115) ^ mul0xb(r116)) ^ mul0xd(r106)) ^ mul0x9(r114)) & 255)) << r104);
        r102 = r102 | (((long) ((((mul0xe(r116) ^ mul0xb(r106)) ^ mul0xd(r114)) ^ mul0x9(r115)) & 255)) << r104);
        r103 = r113 | (((long) ((((mul0xe(r106) ^ mul0xb(r114)) ^ mul0xd(r115)) ^ mul0x9(r116)) & 255)) << r104);
        r104 = r104 + 8;
        goto L4
    L14:
        r116 = -1;
        goto L15
    L11:
        r115 = -1;
        goto L12
    L8:
        r114 = -1;
        goto L9
    L18:
        this.A0 = r100;
        this.A1 = r101;
        this.A2 = r102;
        this.A3 = r103;
    }

    private void KeyAddition(long[] r100) {
        this.A0 ^= r100[0];
        this.A1 ^= r100[1];
        this.A2 ^= r100[2];
        this.A3 ^= r100[3];
    }

    private void MixColumn() {
        long r100 = 0;
        long r101 = 0;
        long r102 = 0;
        long r103 = 0;
        int r104 = 0;
    L4:
        if (r104 >= this.BC) goto L6;
        int r110 = (int) ((this.A0 >> r104) & 255);
        int r111 = (int) ((this.A1 >> r104) & 255);
        int r112 = (int) ((this.A2 >> r104) & 255);
        int r105 = (int) ((this.A3 >> r104) & 255);
        r100 = r100 | (((long) ((((mul0x2(r110) ^ mul0x3(r111)) ^ r112) ^ r105) & 255)) << r104);
        r101 = r101 | (((long) ((((mul0x2(r111) ^ mul0x3(r112)) ^ r105) ^ r110) & 255)) << r104);
        r102 = r102 | (((long) ((((mul0x2(r112) ^ mul0x3(r105)) ^ r110) ^ r111) & 255)) << r104);
        r103 = r103 | (((long) ((((mul0x2(r105) ^ mul0x3(r110)) ^ r111) ^ r112) & 255)) << r104);
        r104 = r104 + 8;
        goto L4
    L6:
        this.A0 = r100;
        this.A1 = r101;
        this.A2 = r102;
        this.A3 = r103;
    }

    private void ShiftRow(byte[] r100) {
        this.A1 = shift(this.A1, r100[1]);
        this.A2 = shift(this.A2, r100[2]);
        this.A3 = shift(this.A3, r100[3]);
    }

    private void Substitution(byte[] r100) {
        this.A0 = applyS(this.A0, r100);
        this.A1 = applyS(this.A1, r100);
        this.A2 = applyS(this.A2, r100);
        this.A3 = applyS(this.A3, r100);
    }

    private long applyS(long r100, byte[] r110) {
        long r101 = 0;
        int r102 = 0;
    L4:
        if (r102 >= this.BC) goto L6;
        r101 = r101 | (((long) (r110[(int) ((r100 >> r102) & 255)] & UByte.MAX_VALUE)) << r102);
        r102 = r102 + 8;
        goto L4
    L6:
        return r101;
    }

    private void decryptBlock(long[][] r100) {
        KeyAddition(r100[this.ROUNDS]);
        Substitution(Si);
        ShiftRow(this.shifts1SC);
        int r101 = this.ROUNDS - 1;
    L3:
        if (r101 <= 0) goto L5;
        KeyAddition(r100[r101]);
        InvMixColumn();
        Substitution(Si);
        ShiftRow(this.shifts1SC);
        r101 = r101 - 1;
        goto L3
    L5:
        KeyAddition(r100[0]);
    }

    private void encryptBlock(long[][] r100) {
        KeyAddition(r100[0]);
        int r101 = 1;
    L4:
        if (r101 >= this.ROUNDS) goto L6;
        Substitution(S);
        ShiftRow(this.shifts0SC);
        MixColumn();
        KeyAddition(r100[r101]);
        r101 = r101 + 1;
        goto L4
    L6:
        Substitution(S);
        ShiftRow(this.shifts0SC);
        KeyAddition(r100[this.ROUNDS]);
    }

    private long[][] generateWorkingKey(byte[] r110) {
        int r100 = 8;
        int r101 = r110.length * 8;
        byte[][] r102 = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{4, 64});
        long[][] r103 = (long[][]) Array.newInstance(Long.TYPE, new int[]{15, 4});
        int r104 = 4;
        if (r101 != 128) goto L5;
        int r105 = 4;
    L20:
        if (r101 < this.blockBits) goto L22;
        int r106 = r105 + 6;
    L23:
        this.ROUNDS = r106;
        char r107 = 0;
        int r111 = 0;
        int r112 = 0;
    L25:
        if (r111 >= r110.length) goto L27;
        r102[r111 % 4][r111 / 4] = r110[r112];
        r111 = r111 + 1;
        r112 = r112 + 1;
        goto L25
    L27:
        int r108 = 0;
        int r113 = 0;
    L29:
        if (r108 >= r105) goto L36;
        if (r113 >= ((this.ROUNDS + 1) * (this.BC / 8))) goto L36;
        int r114 = 0;
    L33:
        if (r114 >= r104) goto L35;
        int r115 = this.BC;
        long[] r116 = r103[r113 / (r115 / 8)];
        r116[r114] = (((long) (r102[r114][r108] & UByte.MAX_VALUE)) << ((r113 * 8) % r115)) | r116[r114];
        r114 = r114 + 1;
        r104 = 4;
        goto L33
    L35:
        r108 = r108 + 1;
        r113 = r113 + 1;
        r104 = 4;
    L36:
        int r109 = 0;
    L38:
        if (r113 >= ((this.ROUNDS + 1) * (this.BC / r100))) goto L75;
        int r117 = 0;
    L41:
        if (r117 >= 4) goto L43;
        byte[] r118 = r102[r117];
        r117 = r117 + 1;
        r118[r107] = (byte) (r118[r107] ^ S[r102[r117 % 4][r105 - 1] & UByte.MAX_VALUE]);
        goto L41
    L43:
        byte[] r119 = r102[r107];
        int r120 = r109 + 1;
        r119[r107] = (byte) (rcon[r109] ^ r119[r107]);
        int r121 = 1;
        if (r105 > 6) goto L51;
    L45:
        if (r121 >= r105) goto L66;
        int r122 = 0;
    L48:
        if (r122 >= 4) goto L50;
        byte[] r123 = r102[r122];
        r123[r121] = (byte) (r123[r121] ^ r123[r121 - 1]);
        r122 = r122 + 1;
        goto L48
    L50:
        r121 = r121 + 1;
    L66:
        int r124 = 0;
    L67:
        if (r124 >= r105) goto L74;
        if (r113 >= ((this.ROUNDS + 1) * (this.BC / r100))) goto L74;
        int r125 = 0;
    L71:
        if (r125 >= 4) goto L73;
        int r126 = this.BC;
        long[] r127 = r103[r113 / (r126 / 8)];
        r127[r125] = (((long) (r102[r125][r124] & UByte.MAX_VALUE)) << ((r113 * 8) % r126)) | r127[r125];
        r125 = r125 + 1;
        goto L71
    L73:
        r124 = r124 + 1;
        r113 = r113 + 1;
        r100 = 8;
    L74:
        r109 = r120;
        r107 = 0;
        r100 = 8;
    L51:
        int r128 = 4;
        if (r121 >= 4) goto L57;
        int r129 = 0;
    L54:
        if (r129 >= r128) goto L56;
        byte[] r130 = r102[r129];
        r130[r121] = (byte) (r130[r121] ^ r130[r121 - 1]);
        r129 = r129 + 1;
        r128 = 4;
        goto L54
    L56:
        r121 = r121 + 1;
        goto L51
    L57:
        int r131 = 0;
    L58:
        if (r131 >= 4) goto L60;
        byte[] r132 = r102[r131];
        r132[4] = (byte) (r132[4] ^ S[r132[3] & UByte.MAX_VALUE]);
        r131 = r131 + 1;
        goto L58
    L60:
        int r133 = 5;
    L61:
        if (r133 >= r105) goto L66;
        int r134 = 0;
    L63:
        if (r134 >= r128) goto L65;
        byte[] r135 = r102[r134];
        r135[r133] = (byte) (r135[r133] ^ r135[r133 - 1]);
        r134 = r134 + 1;
        r128 = 4;
        goto L63
    L65:
        r133 = r133 + 1;
        r128 = 4;
        goto L61
    L75:
        return r103;
    L22:
        r106 = (this.BC / 8) + 6;
        goto L23
    L5:
        if (r101 != 160) goto L7;
        r105 = 5;
        goto L20
    L7:
        if (r101 != 192) goto L9;
        r105 = 6;
        goto L20
    L9:
        if (r101 != 224) goto L11;
        r105 = 7;
        goto L20
    L11:
        if (r101 != 256) goto L14;
        r105 = 8;
        goto L20
    L14:
        throw new IllegalArgumentException("Key length not 128/160/192/224/256 bits.");
    }

    private byte mul0x2(int r100) {
        if (r100 != 0) goto L4;
        return 0;
    L4:
        return aLogtable[(logtable[r100] & UByte.MAX_VALUE) + 25];
    }

    private byte mul0x3(int r100) {
        if (r100 != 0) goto L4;
        return 0;
    L4:
        return aLogtable[(logtable[r100] & UByte.MAX_VALUE) + 1];
    }

    private byte mul0x9(int r100) {
        if (r100 >= 0) goto L4;
        return 0;
    L4:
        return aLogtable[r100 + 199];
    }

    private byte mul0xb(int r100) {
        if (r100 >= 0) goto L4;
        return 0;
    L4:
        return aLogtable[r100 + 104];
    }

    private byte mul0xd(int r100) {
        if (r100 >= 0) goto L4;
        return 0;
    L4:
        return aLogtable[r100 + 238];
    }

    private byte mul0xe(int r100) {
        if (r100 >= 0) goto L4;
        return 0;
    L4:
        return aLogtable[r100 + 223];
    }

    private void packBlock(byte[] r100, int r101) {
        int r102 = 0;
    L4:
        if (r102 == this.BC) goto L6;
        int r103 = r101 + 1;
        r100[r101] = (byte) (this.A0 >> r102);
        int r104 = r103 + 1;
        r100[r103] = (byte) (this.A1 >> r102);
        int r105 = r104 + 1;
        r100[r104] = (byte) (this.A2 >> r102);
        r101 = r105 + 1;
        r100[r105] = (byte) (this.A3 >> r102);
        r102 = r102 + 8;
        goto L4
    }

    private long shift(long r100, int r101) {
        long r102 = r100 >>> r101;
        return ((r100 << (this.BC - r101)) | r102) & this.BC_MASK;
    }

    private void unpackBlock(byte[] r100, int r101) {
        int r102 = r101 + 1;
        this.A0 = r100[r101] & UByte.MAX_VALUE;
        int r103 = r102 + 1;
        this.A1 = r100[r102] & UByte.MAX_VALUE;
        int r104 = r103 + 1;
        this.A2 = r100[r103] & UByte.MAX_VALUE;
        int r105 = r104 + 1;
        this.A3 = r100[r104] & UByte.MAX_VALUE;
        int r106 = 8;
    L4:
        if (r106 == this.BC) goto L6;
        int r107 = r105 + 1;
        this.A0 |= ((long) (r100[r105] & UByte.MAX_VALUE)) << r106;
        int r108 = r107 + 1;
        this.A1 |= ((long) (r100[r107] & UByte.MAX_VALUE)) << r106;
        int r109 = r108 + 1;
        this.A2 |= ((long) (r100[r108] & UByte.MAX_VALUE)) << r106;
        r105 = r109 + 1;
        this.A3 |= ((long) (r100[r109] & UByte.MAX_VALUE)) << r106;
        r106 = r106 + 8;
        goto L4
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "Rijndael";
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return this.BC / 2;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean r100, CipherParameters r101) {
        if ((r101 instanceof KeyParameter) == false) goto L7;
        this.workingKey = generateWorkingKey(((KeyParameter) r101).getKey());
        this.forEncryption = r100;
        return;
    L7:
        throw new IllegalArgumentException("invalid parameter passed to Rijndael init - ".concat(r101.getClass().getName()));
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] r100, int r101, byte[] r102, int r103) {
        if (this.workingKey == null) goto L19;
        int r104 = this.BC;
        if (((r104 / 2) + r101) > r100.length) goto L17;
        if (((r104 / 2) + r103) > r102.length) goto L15;
        boolean r105 = this.forEncryption;
        unpackBlock(r100, r101);
        long[][] r106 = this.workingKey;
        if (r105 == false) goto L11;
        encryptBlock(r106);
    L12:
        packBlock(r102, r103);
        return this.BC / 2;
    L11:
        decryptBlock(r106);
        goto L12
    L15:
        throw new OutputLengthException("output buffer too short");
    L17:
        throw new DataLengthException("input buffer too short");
    L19:
        throw new IllegalStateException("Rijndael engine not initialised");
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
    }
}
