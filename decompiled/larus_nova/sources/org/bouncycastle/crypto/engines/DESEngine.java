package org.bouncycastle.crypto.engines;

import android.R;
import androidx.core.view.InputDeviceCompat;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.ss.ttm.player.MediaPlayer;
import kotlin.io.encoding.Base64;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class DESEngine implements BlockCipher {
    protected static final int BLOCK_SIZE = 8;
    private static final int[] SP1 = null;
    private static final int[] SP2 = null;
    private static final int[] SP3 = null;
    private static final int[] SP4 = null;
    private static final int[] SP5 = null;
    private static final int[] SP6 = null;
    private static final int[] SP7 = null;
    private static final int[] SP8 = null;
    private static final int[] bigbyte = null;
    private static final short[] bytebit = null;

    /* JADX INFO: renamed from: pc1, reason: collision with root package name */
    private static final byte[] f525178pc1 = null;

    /* JADX INFO: renamed from: pc2, reason: collision with root package name */
    private static final byte[] f525179pc2 = null;
    private static final byte[] totrot = null;
    private int[] workingKey;

    static {
        bytebit = new short[]{128, 64, 32, 16, 8, 4, 2, 1};
        bigbyte = new int[]{8388608, 4194304, 2097152, 1048576, 524288, 262144, 131072, 65536, 32768, 16384, 8192, 4096, 2048, 1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1};
        f525178pc1 = new byte[]{56, 48, 40, 32, 24, 16, 8, 0, 57, 49, 41, 33, 25, 17, 9, 1, 58, 50, 42, 34, 26, 18, 10, 2, 59, 51, 43, 35, 62, 54, 46, 38, 30, 22, 14, 6, Base64.padSymbol, 53, 45, 37, 29, 21, HTTP.CR, 5, 60, 52, 44, 36, 28, 20, 12, 4, 27, 19, 11, 3};
        totrot = new byte[]{1, 2, 4, 6, 8, 10, 12, 14, 15, 17, 19, 21, 23, 25, 27, 28};
        f525179pc2 = new byte[]{HTTP.CR, 16, 10, 23, 0, 4, 2, 27, 14, 5, 20, 9, 22, 18, 11, 3, 25, 7, 15, 6, 26, 19, 12, 1, 40, 51, 30, 36, 46, 54, 29, 39, 50, 44, 32, 47, 43, 48, 38, 55, 33, 52, 45, 41, 49, 35, 28, 31};
        SP1 = new int[]{R.attr.transitionName, 0, 65536, R.attr.fillColor, R.attr.manageSpaceActivity, 66564, 4, 65536, 1024, R.attr.transitionName, R.attr.fillColor, 1024, 16778244, R.attr.manageSpaceActivity, 16777216, 4, 1028, 16778240, 16778240, 66560, 66560, R.attr.theme, R.attr.theme, 16778244, InputDeviceCompat.SOURCE_TRACKBALL, 16777220, 16777220, InputDeviceCompat.SOURCE_TRACKBALL, 0, 1028, 66564, 16777216, 65536, R.attr.fillColor, 4, R.attr.theme, R.attr.transitionName, 16777216, 16777216, 1024, R.attr.manageSpaceActivity, 65536, 66560, 16777220, 1024, 4, 16778244, 66564, R.attr.fillColor, InputDeviceCompat.SOURCE_TRACKBALL, R.attr.theme, 16778244, 16777220, 1028, 66564, R.attr.transitionName, 1028, 16778240, 16778240, 0, InputDeviceCompat.SOURCE_TRACKBALL, 66560, 0, R.attr.manageSpaceActivity};
        SP2 = new int[]{-2146402272, -2147450880, 32768, 1081376, 1048576, 32, -2146435040, -2147450848, -2147483616, -2146402272, -2146402304, Integer.MIN_VALUE, -2147450880, 1048576, 32, -2146435040, 1081344, 1048608, -2147450848, 0, Integer.MIN_VALUE, 32768, 1081376, -2146435072, 1048608, -2147483616, 0, 1081344, 32800, -2146402304, -2146435072, 32800, 0, 1081376, -2146435040, 1048576, -2147450848, -2146435072, -2146402304, 32768, -2146435072, -2147450880, 32, -2146402272, 1081376, 32, 32768, Integer.MIN_VALUE, 32800, -2146402304, 1048576, -2147483616, 1048608, -2147450848, -2147483616, 1048608, 1081344, 0, -2147450880, 32800, Integer.MIN_VALUE, -2146435040, -2146402272, 1081344};
        SP3 = new int[]{520, 134349312, 0, 134348808, 134218240, 0, 131592, 134218240, 131080, 134217736, 134217736, 131072, 134349320, 131080, 134348800, 520, AMapEngineUtils.HALF_MAX_P20_WIDTH, 8, 134349312, 512, 131584, 134348800, 134348808, 131592, 134218248, 131584, 131072, 134218248, 8, 134349320, 512, AMapEngineUtils.HALF_MAX_P20_WIDTH, 134349312, AMapEngineUtils.HALF_MAX_P20_WIDTH, 131080, 520, 131072, 134349312, 134218240, 0, 512, 131080, 134349320, 134218240, 134217736, 512, 0, 134348808, 134218248, 131072, AMapEngineUtils.HALF_MAX_P20_WIDTH, 134349320, 8, 131592, 131584, 134217736, 134348800, 134218248, 520, 134348800, 131592, 8, 134348808, 131584};
        SP4 = new int[]{8396801, 8321, 8321, 128, 8396928, 8388737, 8388609, 8193, 0, 8396800, 8396800, 8396929, 129, 0, 8388736, 8388609, 1, 8192, 8388608, 8396801, 128, 8388608, 8193, 8320, 8388737, 1, 8320, 8388736, 8192, 8396928, 8396929, 129, 8388736, 8388609, 8396800, 8396929, 129, 0, 0, 8396800, 8320, 8388736, 8388737, 1, 8396801, 8321, 8321, 128, 8396929, 129, 1, 8192, 8388609, 8193, 8396928, 8388737, 8193, 8320, 8388608, 8396801, 128, 8388608, 8192, 8396928};
        SP5 = new int[]{256, 34078976, 34078720, 1107296512, 524288, 256, 1073741824, 34078720, 1074266368, 524288, 33554688, 1074266368, 1107296512, 1107820544, 524544, 1073741824, 33554432, 1074266112, 1074266112, 0, 1073742080, 1107820800, 1107820800, 33554688, 1107820544, 1073742080, 0, 1107296256, 34078976, 33554432, 1107296256, 524544, 524288, 1107296512, 256, 33554432, 1073741824, 34078720, 1107296512, 1074266368, 33554688, 1073741824, 1107820544, 34078976, 1074266368, 256, 33554432, 1107820544, 1107820800, 524544, 1107296256, 1107820800, 34078720, 0, 1074266112, 1107296256, 524544, 33554688, 1073742080, 524288, 0, 1074266112, 34078976, 1073742080};
        SP6 = new int[]{536870928, 541065216, 16384, 541081616, 541065216, 16, 541081616, 4194304, 536887296, 4210704, 4194304, 536870928, 4194320, 536887296, 536870912, 16400, 0, 4194320, 536887312, 16384, 4210688, 536887312, 16, 541065232, 541065232, 0, 4210704, 541081600, 16400, 4210688, 541081600, 536870912, 536887296, 16, 541065232, 4210688, 541081616, 4194304, 16400, 536870928, 4194304, 536887296, 536870912, 16400, 536870928, 541081616, 4210688, 541065216, 4210704, 541081600, 0, 541065232, 16, 16384, 541065216, 4210704, 16384, 4194320, 536887312, 0, 541081600, 536870912, 4194320, 536887312};
        SP7 = new int[]{2097152, 69206018, 67110914, 0, 2048, 67110914, 2099202, 69208064, 69208066, 2097152, 0, 67108866, 2, 67108864, 69206018, 2050, 67110912, 2099202, 2097154, 67110912, 67108866, 69206016, 69208064, 2097154, 69206016, 2048, 2050, 69208066, 2099200, 2, 67108864, 2099200, 67108864, 2099200, 2097152, 67110914, 67110914, 69206018, 69206018, 2, 2097154, 67108864, 67110912, 2097152, 69208064, 2050, 2099202, 69208064, 2050, 67108866, 69208066, 69206016, 2099200, 0, 2, 69208066, 0, 2099202, 69206016, 2048, 67108866, 67110912, 2048, 2097154};
        SP8 = new int[]{268439616, 4096, 262144, 268701760, 268435456, 268439616, 64, 268435456, 262208, 268697600, 268701760, 266240, 268701696, 266304, 4096, 64, 268697600, 268435520, 268439552, 4160, 266240, 262208, 268697664, 268701696, 4160, 0, 0, 268697664, 268435520, 268439552, 266304, 262144, 266304, 262144, 268701696, 4096, 64, 268697664, 4096, 266304, 268439552, 64, 268435520, 268697600, 268697664, 268435456, 262144, 268439616, 0, 268701760, 262208, 268435520, 268697600, 268439552, 268439616, 0, 268701760, 266240, 266240, 4160, 4160, 262208, 268435456, 268701696};
    }

    public DESEngine() {
        this.workingKey = null;
    }

    public void desFunc(int[] r210, byte[] r211, int r212, byte[] r213, int r214) {
        int r100 = Pack.bigEndianToInt(r211, r212);
        int r101 = Pack.bigEndianToInt(r211, r212 + 4);
        int r102 = ((r100 >>> 4) ^ r101) & 252645135;
        int r103 = r101 ^ r102;
        int r104 = r100 ^ (r102 << 4);
        int r105 = ((r104 >>> 16) ^ r103) & 65535;
        int r106 = r103 ^ r105;
        int r107 = r104 ^ (r105 << 16);
        int r108 = ((r106 >>> 2) ^ r107) & 858993459;
        int r109 = r107 ^ r108;
        int r110 = r106 ^ (r108 << 2);
        int r111 = ((r110 >>> 8) ^ r109) & 16711935;
        int r112 = r109 ^ r111;
        int r113 = r110 ^ (r111 << 8);
        int r114 = r113 << 1;
        int r115 = (r113 >>> 31) | r114;
        int r116 = (r112 ^ r115) & (-1431655766);
        int r117 = r112 ^ r116;
        int r118 = r115 ^ r116;
        int r119 = r117 << 1;
        int r120 = (r117 >>> 31) | r119;
        int r121 = 0;
    L3:
        if (r121 >= 8) goto L5;
        int r122 = (r118 << 28) | (r118 >>> 4);
        int r123 = r121 * 4;
        int r124 = r122 ^ r210[r123 + 0];
        int[] r125 = SP7;
        int r126 = r125[r124 & 63];
        int[] r127 = SP5;
        int r128 = r126 | r127[(r124 >>> 8) & 63];
        int[] r129 = SP3;
        int r130 = r128 | r129[(r124 >>> 16) & 63];
        int[] r131 = SP1;
        int r132 = r131[(r124 >>> 24) & 63] | r130;
        int r133 = r210[r123 + 1] ^ r118;
        int[] r134 = SP8;
        int r135 = r132 | r134[r133 & 63];
        int[] r136 = SP6;
        int r137 = r135 | r136[(r133 >>> 8) & 63];
        int[] r215 = SP4;
        int r138 = r137 | r215[(r133 >>> 16) & 63];
        int[] r216 = SP2;
        r120 = r120 ^ (r138 | r216[(r133 >>> 24) & 63]);
        int r139 = ((r120 << 28) | (r120 >>> 4)) ^ r210[r123 + 2];
        int r140 = (r125[r139 & 63] | r127[(r139 >>> 8) & 63]) | r129[(r139 >>> 16) & 63];
        int r141 = r131[(r139 >>> 24) & 63] | r140;
        int r142 = r210[r123 + 3] ^ r120;
        r118 = r118 ^ ((((r141 | r134[r142 & 63]) | r136[(r142 >>> 8) & 63]) | r215[(r142 >>> 16) & 63]) | r216[(r142 >>> 24) & 63]);
        r121 = r121 + 1;
        goto L3
    L5:
        int r143 = r118 << 31;
        int r144 = (r118 >>> 1) | r143;
        int r145 = (r120 ^ r144) & (-1431655766);
        int r146 = r120 ^ r145;
        int r147 = r144 ^ r145;
        int r148 = r146 << 31;
        int r149 = (r146 >>> 1) | r148;
        int r150 = ((r149 >>> 8) ^ r147) & 16711935;
        int r151 = r147 ^ r150;
        int r152 = r149 ^ (r150 << 8);
        int r153 = ((r152 >>> 2) ^ r151) & 858993459;
        int r154 = r151 ^ r153;
        int r155 = r152 ^ (r153 << 2);
        int r156 = ((r154 >>> 16) ^ r155) & 65535;
        int r157 = r155 ^ r156;
        int r158 = r154 ^ (r156 << 16);
        int r159 = ((r158 >>> 4) ^ r157) & 252645135;
        int r160 = r157 ^ r159;
        Pack.intToBigEndian(r158 ^ (r159 << 4), r213, r214);
        Pack.intToBigEndian(r160, r213, r214 + 4);
    }

    public int[] generateWorkingKey(boolean r110, byte[] r111) {
        int[] r100 = new int[32];
        boolean[] r101 = new boolean[56];
        boolean[] r102 = new boolean[56];
        int r103 = 0;
        int r104 = 0;
    L3:
        boolean r105 = true;
        if (r104 >= 56) goto L10;
        byte r106 = f525178pc1[r104];
        if ((bytebit[r106 & 7] & r111[r106 >>> 3]) != 0) goto L9;
        r105 = false;
    L9:
        r101[r104] = r105;
        r104 = r104 + 1;
        goto L3
    L10:
        int r112 = 0;
    L12:
        if (r112 >= 16) goto L41;
        if (r110 == false) goto L15;
        int r107 = r112 << 1;
    L16:
        int r108 = r107 + 1;
        r100[r108] = 0;
        r100[r107] = 0;
        int r109 = 0;
    L17:
        int r113 = 28;
        if (r109 >= 28) goto L24;
        int r114 = totrot[r112] + r109;
        if (r114 >= 28) goto L22;
        r102[r109] = r101[r114];
    L23:
        r109 = r109 + 1;
        goto L17
    L22:
        r102[r109] = r101[r114 - 28];
    L24:
        if (r113 >= 56) goto L30;
        int r115 = totrot[r112] + r113;
        if (r115 >= 56) goto L28;
        r102[r113] = r101[r115];
    L29:
        r113 = r113 + 1;
        goto L24
    L28:
        r102[r113] = r101[r115 - 28];
        goto L29
    L30:
        int r116 = 0;
    L32:
        if (r116 >= 24) goto L40;
        byte[] r117 = f525179pc2;
        if (r102[r117[r116]] == false) goto L37;
        r100[r107] = r100[r107] | bigbyte[r116];
    L37:
        if (r102[r117[r116 + 24]] == false) goto L39;
        r100[r108] = r100[r108] | bigbyte[r116];
    L39:
        r116 = r116 + 1;
        goto L32
    L40:
        r112 = r112 + 1;
        goto L12
    L15:
        r107 = (15 - r112) << 1;
    L41:
        if (r103 == 32) goto L43;
        int r118 = r100[r103];
        int r119 = r103 + 1;
        int r120 = r100[r119];
        r100[r103] = (((16515072 & r120) >>> 10) | (((r118 & 16515072) << 6) | ((r118 & MediaPlayer.MEDIA_PLAYER_OPTION_TAKE_SCREEN_SHOT_SYNC) << 10))) | ((r120 & MediaPlayer.MEDIA_PLAYER_OPTION_TAKE_SCREEN_SHOT_SYNC) >>> 6);
        r100[r119] = ((((r118 & 63) << 16) | ((r118 & 258048) << 12)) | ((258048 & r120) >>> 4)) | (r120 & 63);
        r103 = r103 + 2;
        goto L41
    L43:
        return r100;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "DES";
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 8;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean r100, CipherParameters r101) {
        if ((r101 instanceof KeyParameter) == false) goto L11;
        KeyParameter r102 = (KeyParameter) r101;
        if (r102.getKey().length > 8) goto L9;
        this.workingKey = generateWorkingKey(r100, r102.getKey());
        return;
    L9:
        throw new IllegalArgumentException("DES key too long - should be 8 bytes");
    L11:
        throw new IllegalArgumentException("invalid parameter passed to DES init - ".concat(r101.getClass().getName()));
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] r100, int r101, byte[] r102, int r110) {
        int[] r103 = this.workingKey;
        if (r103 == null) goto L15;
        if ((r101 + 8) > r100.length) goto L13;
        if ((r110 + 8) > r102.length) goto L11;
        desFunc(r103, r100, r101, r102, r110);
        return 8;
    L11:
        throw new OutputLengthException("output buffer too short");
    L13:
        throw new DataLengthException("input buffer too short");
    L15:
        throw new IllegalStateException("DES engine not initialised");
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
    }
}
