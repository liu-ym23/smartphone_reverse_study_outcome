package org.bouncycastle.crypto.engines;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.crypto.utils.CryptoConst;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.model.VideoRef;
import java.lang.reflect.Array;
import kotlin.UByte;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.ByteCompanionObject;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class AESLightEngine implements BlockCipher {
    private static final int BLOCK_SIZE = 16;
    private static final byte[] S = null;
    private static final byte[] Si = null;

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    private static final int f525165m1 = -2139062144;

    /* JADX INFO: renamed from: m2, reason: collision with root package name */
    private static final int f525166m2 = 2139062143;

    /* JADX INFO: renamed from: m3, reason: collision with root package name */
    private static final int f525167m3 = 27;

    /* JADX INFO: renamed from: m4, reason: collision with root package name */
    private static final int f525168m4 = -1061109568;

    /* JADX INFO: renamed from: m5, reason: collision with root package name */
    private static final int f525169m5 = 1061109567;
    private static final int[] rcon = null;
    private int C0;
    private int C1;
    private int C2;
    private int C3;
    private int ROUNDS;
    private int[][] WorkingKey;
    private boolean forEncryption;

    static {
        S = new byte[]{99, 124, 119, 123, -14, 107, 111, -59, 48, 1, 103, 43, -2, -41, -85, 118, -54, -126, -55, 125, -6, 89, 71, -16, -83, -44, -94, -81, -100, -92, 114, -64, -73, -3, -109, 38, 54, 63, -9, -52, 52, -91, -27, -15, 113, -40, 49, 21, 4, -57, 35, -61, 24, -106, 5, -102, 7, 18, ByteCompanionObject.MIN_VALUE, -30, -21, 39, -78, 117, 9, -125, 44, 26, 27, 110, 90, -96, 82, 59, -42, -77, 41, -29, 47, -124, 83, -47, 0, -19, 32, -4, -79, 91, 106, -53, -66, 57, 74, 76, 88, -49, -48, -17, -86, -5, 67, 77, 51, -123, 69, -7, 2, ByteCompanionObject.MAX_VALUE, 80, 60, -97, -88, 81, -93, 64, -113, -110, -99, 56, -11, PSSSigner.TRAILER_IMPLICIT, -74, -38, 33, 16, -1, -13, -46, -51, 12, 19, -20, 95, -105, 68, 23, -60, -89, 126, Base64.padSymbol, 100, 93, 25, 115, 96, -127, 79, -36, 34, 42, -112, -120, 70, -18, -72, 20, -34, 94, 11, -37, -32, 50, 58, 10, 73, 6, 36, 92, -62, -45, -84, 98, -111, -107, -28, 121, -25, -56, 55, 109, -115, -43, 78, -87, 108, 86, -12, -22, 101, 122, -82, 8, -70, 120, 37, 46, 28, -90, -76, -58, -24, -35, 116, 31, 75, -67, -117, -118, 112, 62, -75, 102, 72, 3, -10, 14, 97, 53, 87, -71, -122, -63, 29, -98, -31, -8, -104, 17, 105, -39, -114, -108, -101, 30, -121, -23, -50, 85, 40, -33, -116, -95, -119, HTTP.CR, -65, -26, 66, 104, 65, -103, 45, 15, -80, 84, -69, 22};
        Si = new byte[]{82, 9, 106, -43, 48, 54, -91, 56, -65, 64, -93, -98, -127, -13, -41, -5, 124, -29, 57, -126, -101, 47, -1, -121, 52, -114, 67, 68, -60, -34, -23, -53, 84, 123, -108, 50, -90, -62, 35, Base64.padSymbol, -18, 76, -107, 11, 66, -6, -61, 78, 8, 46, -95, 102, 40, -39, 36, -78, 118, 91, -94, 73, 109, -117, -47, 37, 114, -8, -10, 100, -122, 104, -104, 22, -44, -92, 92, -52, 93, 101, -74, -110, 108, 112, 72, 80, -3, -19, -71, -38, 94, 21, 70, 87, -89, -115, -99, -124, -112, -40, -85, 0, -116, PSSSigner.TRAILER_IMPLICIT, -45, 10, -9, -28, 88, 5, -72, -77, 69, 6, -48, 44, 30, -113, -54, 63, 15, 2, -63, -81, -67, 3, 1, 19, -118, 107, 58, -111, 17, 65, 79, 103, -36, -22, -105, -14, -49, -50, -16, -76, -26, 115, -106, -84, 116, 34, -25, -83, 53, -123, -30, -7, 55, -24, 28, 117, -33, 110, 71, -15, 26, 113, 29, 41, -59, -119, 111, -73, 98, 14, -86, 24, -66, 27, -4, 86, 62, 75, -58, -46, 121, 32, -102, -37, -64, -2, 120, -51, 90, -12, 31, -35, -88, 51, -120, 7, -57, 49, -79, 18, 16, 89, 39, ByteCompanionObject.MIN_VALUE, -20, 95, 96, 81, ByteCompanionObject.MAX_VALUE, -87, 25, -75, 74, HTTP.CR, 45, -27, 122, -97, -109, -55, -100, -17, -96, -32, 59, 77, -82, 42, -11, -80, -56, -21, -69, 60, -125, 83, -103, 97, 23, 43, 4, 126, -70, 119, -42, 38, -31, 105, 20, 99, 85, 33, 12, 125};
        rcon = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 27, 54, 108, 216, 171, 77, 154, 47, 94, 188, 99, 198, 151, 53, 106, 212, 179, 125, 250, VideoRef.VALUE_VIDEO_REF_SUBTITLE_POSITION_X, MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, 145};
    }

    public AESLightEngine() {
        this.WorkingKey = null;
    }

    private static int FFmulX(int r100) {
        int r101 = (f525166m2 & r100) << 1;
        return (((r100 & f525165m1) >>> 7) * 27) ^ r101;
    }

    private static int FFmulX2(int r100) {
        int r101 = (f525169m5 & r100) << 2;
        int r102 = r100 & f525168m4;
        int r103 = r102 ^ (r102 >>> 1);
        int r104 = r101 ^ (r103 >>> 2);
        return (r103 >>> 5) ^ r104;
    }

    private void decryptBlock(int[][] r110) {
        int r100 = this.C0;
        int r101 = this.ROUNDS;
        int[] r102 = r110[r101];
        int r103 = r100 ^ r102[0];
        int r104 = this.C1 ^ r102[1];
        int r105 = this.C2 ^ r102[2];
        int r106 = r101 - 1;
        int r107 = r102[3] ^ this.C3;
    L3:
        byte[] r108 = Si;
        int r111 = r103 & 255;
        if (r106 <= 1) goto L6;
        int r112 = inv_mcol((((r108[r111] & UByte.MAX_VALUE) ^ ((r108[(r107 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((r108[(r105 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (r108[(r104 >> 24) & 255] << 24)) ^ r110[r106][0];
        int r113 = inv_mcol((((r108[r104 & 255] & UByte.MAX_VALUE) ^ ((r108[(r103 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((r108[(r107 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (r108[(r105 >> 24) & 255] << 24)) ^ r110[r106][1];
        int r114 = inv_mcol((((r108[r105 & 255] & UByte.MAX_VALUE) ^ ((r108[(r104 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((r108[(r103 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (r108[(r107 >> 24) & 255] << 24)) ^ r110[r106][2];
        int r109 = inv_mcol((r108[(r103 >> 24) & 255] << 24) ^ (((r108[r107 & 255] & UByte.MAX_VALUE) ^ ((r108[(r105 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((r108[(r104 >> 16) & 255] & UByte.MAX_VALUE) << 16)));
        int r115 = r106 - 1;
        int r116 = r109 ^ r110[r106][3];
        int r117 = inv_mcol((((r108[r112 & 255] & UByte.MAX_VALUE) ^ ((r108[(r116 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((r108[(r114 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (r108[(r113 >> 24) & 255] << 24)) ^ r110[r115][0];
        r104 = inv_mcol((((r108[r113 & 255] & UByte.MAX_VALUE) ^ ((r108[(r112 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((r108[(r116 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (r108[(r114 >> 24) & 255] << 24)) ^ r110[r115][1];
        r105 = inv_mcol((((r108[r114 & 255] & UByte.MAX_VALUE) ^ ((r108[(r113 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((r108[(r112 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (r108[(r116 >> 24) & 255] << 24)) ^ r110[r115][2];
        int r118 = inv_mcol((((r108[r116 & 255] & UByte.MAX_VALUE) ^ ((r108[(r114 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((r108[(r113 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (r108[(r112 >> 24) & 255] << 24));
        int r119 = r115 - 1;
        r107 = r110[r115][3] ^ r118;
        r103 = r117;
        r106 = r119;
        goto L3
    L6:
        int r120 = inv_mcol((((r108[r111] & UByte.MAX_VALUE) ^ ((r108[(r107 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((r108[(r105 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (r108[(r104 >> 24) & 255] << 24)) ^ r110[r106][0];
        int r121 = inv_mcol((((r108[r104 & 255] & UByte.MAX_VALUE) ^ ((r108[(r103 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((r108[(r107 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (r108[(r105 >> 24) & 255] << 24)) ^ r110[r106][1];
        int r122 = inv_mcol((((r108[r105 & 255] & UByte.MAX_VALUE) ^ ((r108[(r104 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((r108[(r103 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (r108[(r107 >> 24) & 255] << 24)) ^ r110[r106][2];
        int r123 = inv_mcol((r108[(r103 >> 24) & 255] << 24) ^ (((r108[r107 & 255] & UByte.MAX_VALUE) ^ ((r108[(r105 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((r108[(r104 >> 16) & 255] & UByte.MAX_VALUE) << 16))) ^ r110[r106][3];
        int r124 = (((r108[r120 & 255] & UByte.MAX_VALUE) ^ ((r108[(r123 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((r108[(r122 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (r108[(r121 >> 24) & 255] << 24);
        int[] r125 = r110[0];
        this.C0 = r124 ^ r125[0];
        this.C1 = ((((r108[r121 & 255] & UByte.MAX_VALUE) ^ ((r108[(r120 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((r108[(r123 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (r108[(r122 >> 24) & 255] << 24)) ^ r125[1];
        this.C2 = ((((r108[r122 & 255] & UByte.MAX_VALUE) ^ ((r108[(r121 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((r108[(r120 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (r108[(r123 >> 24) & 255] << 24)) ^ r125[2];
        this.C3 = r125[3] ^ ((((r108[r123 & 255] & UByte.MAX_VALUE) ^ ((r108[(r122 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((r108[(r121 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (r108[(r120 >> 24) & 255] << 24));
    }

    private void encryptBlock(int[][] r110) {
        int r100 = this.C0;
        int[] r101 = r110[0];
        int r102 = r100 ^ r101[0];
        int r103 = this.C1 ^ r101[1];
        int r104 = this.C2 ^ r101[2];
        int r105 = this.C3;
        int r106 = r101[3] ^ r105;
        int r107 = 1;
    L4:
        if (r107 >= (this.ROUNDS - 1)) goto L6;
        byte[] r108 = S;
        int r111 = mcol((((r108[r102 & 255] & UByte.MAX_VALUE) ^ ((r108[(r103 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((r108[(r104 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (r108[(r106 >> 24) & 255] << 24)) ^ r110[r107][0];
        int r112 = mcol((((r108[r103 & 255] & UByte.MAX_VALUE) ^ ((r108[(r104 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((r108[(r106 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (r108[(r102 >> 24) & 255] << 24)) ^ r110[r107][1];
        int r113 = mcol((((r108[r104 & 255] & UByte.MAX_VALUE) ^ ((r108[(r106 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((r108[(r102 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (r108[(r103 >> 24) & 255] << 24)) ^ r110[r107][2];
        int r109 = r108[r106 & 255] & UByte.MAX_VALUE;
        int r114 = mcol(((((r108[(r102 >> 8) & 255] & UByte.MAX_VALUE) << 8) ^ r109) ^ ((r108[(r103 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (r108[(r104 >> 24) & 255] << 24));
        int r115 = r107 + 1;
        int r116 = r114 ^ r110[r107][3];
        int r117 = mcol((((r108[r111 & 255] & UByte.MAX_VALUE) ^ ((r108[(r112 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((r108[(r113 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (r108[(r116 >> 24) & 255] << 24)) ^ r110[r115][0];
        int r118 = mcol((((r108[r112 & 255] & UByte.MAX_VALUE) ^ ((r108[(r113 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((r108[(r116 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (r108[(r111 >> 24) & 255] << 24)) ^ r110[r115][1];
        int r119 = mcol((((r108[r113 & 255] & UByte.MAX_VALUE) ^ ((r108[(r116 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((r108[(r111 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (r108[(r112 >> 24) & 255] << 24)) ^ r110[r115][2];
        int r120 = mcol((((r108[r116 & 255] & UByte.MAX_VALUE) ^ ((r108[(r111 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((r108[(r112 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (r108[(r113 >> 24) & 255] << 24));
        int r121 = r115 + 1;
        r106 = r110[r115][3] ^ r120;
        r102 = r117;
        r103 = r118;
        r104 = r119;
        r107 = r121;
        goto L4
    L6:
        byte[] r122 = S;
        int r123 = mcol((((r122[r102 & 255] & UByte.MAX_VALUE) ^ ((r122[(r103 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((r122[(r104 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (r122[(r106 >> 24) & 255] << 24)) ^ r110[r107][0];
        int r124 = mcol((((r122[r103 & 255] & UByte.MAX_VALUE) ^ ((r122[(r104 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((r122[(r106 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (r122[(r102 >> 24) & 255] << 24)) ^ r110[r107][1];
        int r125 = mcol((((r122[r104 & 255] & UByte.MAX_VALUE) ^ ((r122[(r106 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((r122[(r102 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (r122[(r103 >> 24) & 255] << 24)) ^ r110[r107][2];
        int r126 = r122[r106 & 255] & UByte.MAX_VALUE;
        int r127 = mcol(((((r122[(r102 >> 8) & 255] & UByte.MAX_VALUE) << 8) ^ r126) ^ ((r122[(r103 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (r122[(r104 >> 24) & 255] << 24));
        int r128 = r127 ^ r110[r107][3];
        int r129 = (((r122[r123 & 255] & UByte.MAX_VALUE) ^ ((r122[(r124 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((r122[(r125 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (r122[(r128 >> 24) & 255] << 24);
        int[] r130 = r110[r107 + 1];
        this.C0 = r130[0] ^ r129;
        this.C1 = ((((r122[r124 & 255] & UByte.MAX_VALUE) ^ ((r122[(r125 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((r122[(r128 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (r122[(r123 >> 24) & 255] << 24)) ^ r130[1];
        this.C2 = ((((r122[r125 & 255] & UByte.MAX_VALUE) ^ ((r122[(r128 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((r122[(r123 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (r122[(r124 >> 24) & 255] << 24)) ^ r130[2];
        int r131 = (((r122[r128 & 255] & UByte.MAX_VALUE) ^ ((r122[(r123 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((r122[(r124 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (r122[(r125 >> 24) & 255] << 24);
        this.C3 = r130[3] ^ r131;
    }

    private int[][] generateWorkingKey(byte[] r210, boolean r211) {
        int r100 = r210.length;
        if (r100 < 16) goto L38;
        if (r100 > 32) goto L38;
        if ((r100 & 7) != 0) goto L38;
        int r101 = r100 >>> 2;
        int r102 = r101 + 6;
        this.ROUNDS = r102;
        int r103 = 1;
        int[][] r104 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{r102 + 1, 4});
        int r110 = 8;
        char r111 = 3;
        if (r101 != 4) goto L11;
        int r105 = Pack.littleEndianToInt(r210, 0);
        r104[0][0] = r105;
        int r106 = Pack.littleEndianToInt(r210, 4);
        r104[0][1] = r106;
        int r112 = Pack.littleEndianToInt(r210, 8);
        r104[0][2] = r112;
        int r107 = Pack.littleEndianToInt(r210, 12);
        r104[0][3] = r107;
        int r108 = 1;
    L27:
        if (r108 > 10) goto L29;
        r105 = r105 ^ (subWord(shift(r107, 8)) ^ rcon[r108 - 1]);
        int[] r113 = r104[r108];
        r113[0] = r105;
        r106 = r106 ^ r105;
        r113[1] = r106;
        r112 = r112 ^ r106;
        r113[2] = r112;
        r107 = r107 ^ r112;
        r113[3] = r107;
        r108 = r108 + 1;
    L29:
        if (r211 == false) goto L31;
    L36:
        return r104;
    L31:
        if (r103 >= this.ROUNDS) goto L36;
        int r109 = 0;
    L33:
        if (r109 >= 4) goto L35;
        int[] r114 = r104[r103];
        r114[r109] = inv_mcol(r114[r109]);
        r109 = r109 + 1;
        goto L33
    L35:
        r103 = r103 + 1;
        goto L31
    L11:
        if (r101 == 6) goto L20;
        if (r101 != 8) goto L19;
        int r115 = Pack.littleEndianToInt(r210, 0);
        r104[0][0] = r115;
        int r116 = Pack.littleEndianToInt(r210, 4);
        r104[0][1] = r116;
        int r117 = Pack.littleEndianToInt(r210, 8);
        r104[0][2] = r117;
        int r118 = Pack.littleEndianToInt(r210, 12);
        r104[0][3] = r118;
        int r119 = Pack.littleEndianToInt(r210, 16);
        r104[1][0] = r119;
        int r120 = Pack.littleEndianToInt(r210, 20);
        r104[1][1] = r120;
        int r121 = Pack.littleEndianToInt(r210, 24);
        r104[1][2] = r121;
        int r122 = Pack.littleEndianToInt(r210, 28);
        r104[1][3] = r122;
        int r123 = 1;
        int r124 = 2;
    L14:
        int r125 = subWord(shift(r122, r110)) ^ r123;
        r123 = r123 << 1;
        r115 = r115 ^ r125;
        int[] r126 = r104[r124];
        r126[0] = r115;
        r116 = r116 ^ r115;
        r126[1] = r116;
        r117 = r117 ^ r116;
        r126[2] = r117;
        r118 = r118 ^ r117;
        r126[r111] = r118;
        int r127 = r124 + 1;
        if (r127 >= 15) goto L29;
        r119 = r119 ^ subWord(r118);
        int[] r128 = r104[r127];
        r128[0] = r119;
        r120 = r120 ^ r119;
        r128[1] = r120;
        r121 = r121 ^ r120;
        r128[2] = r121;
        r122 = r122 ^ r121;
        r128[3] = r122;
        r124 = r127 + 1;
        r110 = 8;
        r111 = 3;
        goto L14
    L19:
        throw new IllegalStateException("Should never get here");
    L20:
        int r129 = Pack.littleEndianToInt(r210, 0);
        r104[0][0] = r129;
        int r130 = Pack.littleEndianToInt(r210, 4);
        r104[0][1] = r130;
        int r131 = Pack.littleEndianToInt(r210, 8);
        r104[0][2] = r131;
        int r132 = Pack.littleEndianToInt(r210, 12);
        r104[0][3] = r132;
        int r133 = Pack.littleEndianToInt(r210, 16);
        int r134 = Pack.littleEndianToInt(r210, 20);
        int r135 = 1;
        int r136 = 1;
    L21:
        int[] r137 = r104[r135];
        r137[0] = r133;
        r137[1] = r134;
        int r138 = subWord(shift(r134, 8)) ^ r136;
        int r139 = r136 << 1;
        int r140 = r129 ^ r138;
        int[] r141 = r104[r135];
        r141[2] = r140;
        int r142 = r130 ^ r140;
        r141[3] = r142;
        int r143 = r131 ^ r142;
        int[] r144 = r104[r135 + 1];
        r144[0] = r143;
        int r145 = r132 ^ r143;
        r144[1] = r145;
        int r146 = r133 ^ r145;
        r144[2] = r146;
        int r147 = r134 ^ r146;
        r144[3] = r147;
        int r148 = subWord(shift(r147, 8)) ^ r139;
        r136 = r139 << 1;
        r129 = r140 ^ r148;
        int[] r149 = r104[r135 + 2];
        r149[0] = r129;
        r130 = r142 ^ r129;
        r149[1] = r130;
        r131 = r143 ^ r130;
        r149[2] = r131;
        r132 = r145 ^ r131;
        r149[3] = r132;
        r135 = r135 + 3;
        if (r135 >= 13) goto L29;
        r133 = r146 ^ r132;
        r134 = r147 ^ r133;
    L38:
        throw new IllegalArgumentException("Key length not 128/192/256 bits.");
    }

    private static int inv_mcol(int r100) {
        int r101 = shift(r100, 8) ^ r100;
        int r102 = r100 ^ FFmulX(r101);
        int r103 = r101 ^ FFmulX2(r102);
        return r102 ^ (r103 ^ shift(r103, 16));
    }

    private static int mcol(int r100) {
        int r101 = shift(r100, 8);
        int r102 = r100 ^ r101;
        int r103 = r101 ^ shift(r102, 16);
        return FFmulX(r102) ^ r103;
    }

    private void packBlock(byte[] r100, int r101) {
        int r102 = r101 + 1;
        int r103 = this.C0;
        r100[r101] = (byte) r103;
        int r104 = r102 + 1;
        r100[r102] = (byte) (r103 >> 8);
        int r105 = r104 + 1;
        r100[r104] = (byte) (r103 >> 16);
        int r106 = r105 + 1;
        r100[r105] = (byte) (r103 >> 24);
        int r107 = r106 + 1;
        int r108 = this.C1;
        r100[r106] = (byte) r108;
        int r109 = r107 + 1;
        r100[r107] = (byte) (r108 >> 8);
        int r110 = r109 + 1;
        r100[r109] = (byte) (r108 >> 16);
        int r111 = r110 + 1;
        r100[r110] = (byte) (r108 >> 24);
        int r112 = r111 + 1;
        int r113 = this.C2;
        r100[r111] = (byte) r113;
        int r114 = r112 + 1;
        r100[r112] = (byte) (r113 >> 8);
        int r115 = r114 + 1;
        r100[r114] = (byte) (r113 >> 16);
        int r116 = r115 + 1;
        r100[r115] = (byte) (r113 >> 24);
        int r117 = r116 + 1;
        int r118 = this.C3;
        r100[r116] = (byte) r118;
        int r119 = r117 + 1;
        r100[r117] = (byte) (r118 >> 8);
        r100[r119] = (byte) (r118 >> 16);
        r100[r119 + 1] = (byte) (r118 >> 24);
    }

    private static int shift(int r100, int r101) {
        int r102 = r100 >>> r101;
        return (r100 << (-r101)) | r102;
    }

    private static int subWord(int r100) {
        byte[] r101 = S;
        int r102 = ((r101[r100 & 255] & UByte.MAX_VALUE) | ((r101[(r100 >> 8) & 255] & UByte.MAX_VALUE) << 8)) | ((r101[(r100 >> 16) & 255] & UByte.MAX_VALUE) << 16);
        return (r101[(r100 >> 24) & 255] << 24) | r102;
    }

    private void unpackBlock(byte[] r100, int r101) {
        int r102 = r101 + 1;
        int r103 = r102 + 1;
        int r104 = (r100[r101] & UByte.MAX_VALUE) | ((r100[r102] & UByte.MAX_VALUE) << 8);
        int r105 = r103 + 1;
        int r106 = r104 | ((r100[r103] & UByte.MAX_VALUE) << 16);
        int r107 = r105 + 1;
        this.C0 = r106 | (r100[r105] << 24);
        int r108 = r107 + 1;
        int r109 = r100[r107] & UByte.MAX_VALUE;
        int r110 = r108 + 1;
        int r111 = ((r100[r108] & UByte.MAX_VALUE) << 8) | r109;
        int r112 = r110 + 1;
        int r113 = r111 | ((r100[r110] & UByte.MAX_VALUE) << 16);
        int r114 = r112 + 1;
        this.C1 = r113 | (r100[r112] << 24);
        int r115 = r114 + 1;
        int r116 = r100[r114] & UByte.MAX_VALUE;
        int r117 = r115 + 1;
        int r118 = ((r100[r115] & UByte.MAX_VALUE) << 8) | r116;
        int r119 = r117 + 1;
        int r120 = r118 | ((r100[r117] & UByte.MAX_VALUE) << 16);
        int r121 = r119 + 1;
        this.C2 = r120 | (r100[r119] << 24);
        int r122 = r121 + 1;
        int r123 = r100[r121] & UByte.MAX_VALUE;
        int r124 = r122 + 1;
        int r125 = ((r100[r122] & UByte.MAX_VALUE) << 8) | r123;
        int r126 = r124 + 1;
        int r127 = r125 | ((r100[r124] & UByte.MAX_VALUE) << 16);
        this.C3 = (r100[r126] << 24) | r127;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return CryptoConst.ALGORITHM_AES;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 16;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean r100, CipherParameters r101) {
        if ((r101 instanceof KeyParameter) == false) goto L7;
        this.WorkingKey = generateWorkingKey(((KeyParameter) r101).getKey(), r100);
        this.forEncryption = r100;
        return;
    L7:
        throw new IllegalArgumentException("invalid parameter passed to AES init - ".concat(r101.getClass().getName()));
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] r100, int r101, byte[] r102, int r103) {
        if (this.WorkingKey == null) goto L19;
        if ((r101 + 16) > r100.length) goto L17;
        if ((r103 + 16) > r102.length) goto L15;
        boolean r104 = this.forEncryption;
        unpackBlock(r100, r101);
        int[][] r105 = this.WorkingKey;
        if (r104 == false) goto L11;
        encryptBlock(r105);
    L12:
        packBlock(r102, r103);
        return 16;
    L11:
        decryptBlock(r105);
        goto L12
    L15:
        throw new OutputLengthException("output buffer too short");
    L17:
        throw new DataLengthException("input buffer too short");
    L19:
        throw new IllegalStateException("AES engine not initialised");
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
    }
}
