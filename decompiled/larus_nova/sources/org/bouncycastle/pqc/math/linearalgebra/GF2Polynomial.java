package org.bouncycastle.pqc.math.linearalgebra;

import androidx.compose.ui.spatial.RectListKt;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import com.obric.miniapp.alarm.AccountType;
import com.ss.android.lark.batterymonitor.stragety.AbsBatteryStrategy;
import com.ss.android.socialbase.appdownloader.util.parser.manifest.ARSCHeader;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import java.math.BigInteger;
import java.util.Random;
import kotlin.UByte;
import org.bouncycastle.asn1.cmc.BodyPartID;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class GF2Polynomial {
    private static final int[] bitMask = null;
    private static final boolean[] parity = null;
    private static Random rand;
    private static final int[] reverseRightMask = null;
    private static final short[] squaringTable = null;
    private int blocks;
    private int len;
    private int[] value;

    static {
        rand = new Random();
        parity = new boolean[]{false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false};
        squaringTable = new short[]{0, 1, 4, 5, 16, 17, 20, 21, 64, 65, 68, 69, 80, 81, 84, 85, 256, ARSCHeader.RES_XML_END_NAMESPACE_TYPE, ARSCHeader.RES_XML_CDATA_TYPE, 261, 272, 273, 276, 277, 320, 321, 324, 325, 336, 337, 340, 341, 1024, 1025, 1028, 1029, 1040, 1041, 1044, 1045, 1088, 1089, 1092, 1093, 1104, 1105, 1108, 1109, 1280, 1281, 1284, 1285, 1296, 1297, 1300, 1301, 1344, 1345, 1348, 1349, 1360, 1361, 1364, 1365, 4096, 4097, 4100, 4101, 4112, 4113, 4116, 4117, 4160, 4161, 4164, 4165, 4176, 4177, 4180, 4181, 4352, 4353, 4356, 4357, 4368, 4369, 4372, 4373, 4416, 4417, 4420, 4421, 4432, 4433, 4436, 4437, 5120, 5121, 5124, 5125, 5136, 5137, 5140, 5141, 5184, 5185, 5188, 5189, 5200, 5201, 5204, 5205, 5376, 5377, 5380, 5381, 5392, 5393, 5396, 5397, 5440, 5441, 5444, 5445, 5456, 5457, 5460, 5461, 16384, 16385, 16388, 16389, 16400, 16401, 16404, 16405, 16448, 16449, 16452, 16453, 16464, 16465, 16468, 16469, 16640, 16641, 16644, 16645, 16656, 16657, 16660, 16661, 16704, 16705, 16708, 16709, 16720, 16721, 16724, 16725, 17408, 17409, 17412, 17413, 17424, 17425, 17428, 17429, 17472, 17473, 17476, 17477, 17488, 17489, 17492, 17493, 17664, 17665, 17668, 17669, 17680, 17681, 17684, 17685, 17728, 17729, 17732, 17733, 17744, 17745, 17748, 17749, 20480, 20481, 20484, 20485, 20496, 20497, 20500, 20501, 20544, 20545, 20548, 20549, 20560, 20561, 20564, 20565, 20736, 20737, 20740, 20741, 20752, 20753, 20756, 20757, 20800, 20801, 20804, 20805, 20816, 20817, 20820, 20821, 21504, 21505, 21508, 21509, 21520, 21521, 21524, 21525, 21568, 21569, 21572, 21573, 21584, 21585, 21588, 21589, 21760, 21761, 21764, 21765, 21776, 21777, 21780, 21781, 21824, 21825, 21828, 21829, 21840, 21841, 21844, 21845};
        bitMask = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608, 16777216, 33554432, 67108864, AMapEngineUtils.HALF_MAX_P20_WIDTH, 268435456, 536870912, 1073741824, Integer.MIN_VALUE, 0};
        reverseRightMask = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, UnixStat.PERM_MASK, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, RectListKt.Lower26Bits, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
    }

    public GF2Polynomial(int r100) {
        if (r100 >= 1) goto L5;
        r100 = 1;
    L5:
        int r101 = ((r100 - 1) >> 5) + 1;
        this.blocks = r101;
        this.value = new int[r101];
        this.len = r100;
    }

    public GF2Polynomial(int r100, String r101) {
        if (r100 >= 1) goto L5;
        r100 = 1;
    L5:
        int r102 = ((r100 - 1) >> 5) + 1;
        this.blocks = r102;
        this.value = new int[r102];
        this.len = r100;
        if (r101.equalsIgnoreCase("ZERO") == false) goto L9;
        assignZero();
        return;
    L9:
        if (r101.equalsIgnoreCase("ONE") == false) goto L12;
        assignOne();
        return;
    L12:
        if (r101.equalsIgnoreCase("RANDOM") == false) goto L15;
        randomize();
        return;
    L15:
        if (r101.equalsIgnoreCase("X") == false) goto L18;
        assignX();
        return;
    L18:
        if (r101.equalsIgnoreCase(AccountType.ALL) == false) goto L22;
        assignAll();
        return;
    L22:
        throw new IllegalArgumentException("Error: GF2Polynomial was called using " + r101 + " as value!");
    }

    public GF2Polynomial(int r110, BigInteger r111) {
        if (r110 >= 1) goto L5;
        r110 = 1;
    L5:
        int r100 = ((r110 - 1) >> 5) + 1;
        this.blocks = r100;
        this.value = new int[r100];
        this.len = r110;
        byte[] r112 = r111.toByteArray();
        int r113 = 0;
        if (r112[0] != 0) goto L8;
        int r101 = r112.length - 1;
        byte[] r102 = new byte[r101];
        System.arraycopy(r112, 1, r102, 0, r101);
        r112 = r102;
    L8:
        int r103 = r112.length & 3;
        int r104 = ((r112.length - 1) >> 2) + 1;
        int r105 = 0;
    L9:
        if (r105 >= r103) goto L12;
        int[] r106 = this.value;
        int r107 = r104 - 1;
        r106[r107] = r106[r107] | ((r112[r105] & UByte.MAX_VALUE) << (((r103 - 1) - r105) << 3));
        r105 = r105 + 1;
    L12:
        if (r113 > ((r112.length - 4) >> 2)) goto L14;
        int r108 = (r112.length - 1) - (r113 << 2);
        int[] r109 = this.value;
        int r114 = r112[r108] & UByte.MAX_VALUE;
        r109[r113] = r114;
        int r115 = r114 | ((r112[r108 - 1] << 8) & 65280);
        r109[r113] = r115;
        int r116 = r115 | ((r112[r108 - 2] << 16) & 16711680);
        r109[r113] = r116;
        r109[r113] = ((r112[r108 - 3] << 24) & (-16777216)) | r116;
        r113 = r113 + 1;
        goto L12
    L14:
        int r117 = this.len;
        if ((r117 & 31) == 0) goto L17;
        int[] r118 = this.value;
        int r119 = this.blocks - 1;
        r118[r119] = reverseRightMask[r117 & 31] & r118[r119];
    L17:
        reduceN();
    }

    public GF2Polynomial(int r100, Random r101) {
        if (r100 >= 1) goto L5;
        r100 = 1;
    L5:
        int r102 = ((r100 - 1) >> 5) + 1;
        this.blocks = r102;
        this.value = new int[r102];
        this.len = r100;
        randomize(r101);
    }

    public GF2Polynomial(int r110, byte[] r111) {
        if (r110 >= 1) goto L5;
        r110 = 1;
    L5:
        int r100 = ((r110 - 1) >> 5) + 1;
        this.blocks = r100;
        this.value = new int[r100];
        this.len = r110;
        int r112 = Math.min(((r111.length - 1) >> 2) + 1, r100);
        int r101 = 0;
    L6:
        int r102 = r112 - 1;
        if (r101 >= r102) goto L9;
        int r103 = (r111.length - (r101 << 2)) - 1;
        int[] r104 = this.value;
        int r105 = r111[r103] & UByte.MAX_VALUE;
        r104[r101] = r105;
        int r106 = (65280 & (r111[r103 - 1] << 8)) | r105;
        r104[r101] = r106;
        int r107 = (16711680 & (r111[r103 - 2] << 16)) | r106;
        r104[r101] = r107;
        r104[r101] = ((r111[r103 - 3] << 24) & (-16777216)) | r107;
        r101 = r101 + 1;
        goto L6
    L9:
        int r113 = (r111.length - (r102 << 2)) - 1;
        int[] r108 = this.value;
        int r109 = r111[r113] & UByte.MAX_VALUE;
        r108[r102] = r109;
        if (r113 <= 0) goto L12;
        r108[r102] = (65280 & (r111[r113 - 1] << 8)) | r109;
    L12:
        if (r113 <= 1) goto L14;
        r108[r102] = r108[r102] | (16711680 & (r111[r113 - 2] << 16));
    L14:
        if (r113 <= 2) goto L16;
        r108[r102] = ((r111[r113 - 3] << 24) & (-16777216)) | r108[r102];
    L16:
        zeroUnusedBits();
        reduceN();
    }

    public GF2Polynomial(int r100, int[] r101) {
        if (r100 >= 1) goto L5;
        r100 = 1;
    L5:
        int r102 = ((r100 - 1) >> 5) + 1;
        this.blocks = r102;
        this.value = new int[r102];
        this.len = r100;
        System.arraycopy(r101, 0, this.value, 0, Math.min(r102, r101.length));
        zeroUnusedBits();
    }

    public GF2Polynomial(GF2Polynomial r100) {
        this.len = r100.len;
        this.blocks = r100.blocks;
        this.value = IntUtils.clone(r100.value);
    }

    private void doShiftBlocksLeft(int r100) {
        int r101 = this.blocks;
        int[] r102 = this.value;
        if (r101 > r102.length) goto L10;
        int r103 = r101 - 1;
    L5:
        if (r103 < r100) goto L7;
        int[] r104 = this.value;
        r104[r103] = r104[r103 - r100];
        r103 = r103 - 1;
        goto L5
    L7:
        int r105 = 0;
    L8:
        if (r105 >= r100) goto L14;
        this.value[r105] = 0;
        r105 = r105 + 1;
        goto L8
    L14:
        return;
    L10:
        int[] r106 = new int[r101];
        System.arraycopy(r102, 0, r106, r100, r101 - r100);
        this.value = r106;
    }

    private GF2Polynomial karaMult(GF2Polynomial r100) {
        GF2Polynomial r101 = new GF2Polynomial(this.len << 1);
        int r102 = this.len;
        if (r102 > 32) goto L7;
        r101.value = mult32(this.value[0], r100.value[0]);
        return r101;
    L7:
        if (r102 > 64) goto L11;
        r101.value = mult64(this.value, r100.value);
        return r101;
    L11:
        if (r102 > 128) goto L15;
        r101.value = mult128(this.value, r100.value);
        return r101;
    L15:
        if (r102 > 256) goto L19;
        r101.value = mult256(this.value, r100.value);
        return r101;
    L19:
        if (r102 > 512) goto L22;
        r101.value = mult512(this.value, r100.value);
        return r101;
    L22:
        int r103 = bitMask[IntegerFunctions.floorLog(r102 - 1)];
        int r104 = ((r103 - 1) >> 5) + 1;
        GF2Polynomial r105 = lower(r104);
        GF2Polynomial r106 = upper(r104);
        GF2Polynomial r107 = r100.lower(r104);
        GF2Polynomial r108 = r100.upper(r104);
        GF2Polynomial r109 = r106.karaMult(r108);
        GF2Polynomial r110 = r105.karaMult(r107);
        r105.addToThis(r106);
        r107.addToThis(r108);
        GF2Polynomial r111 = r105.karaMult(r107);
        r101.shiftLeftAddThis(r109, r103 << 1);
        r101.shiftLeftAddThis(r109, r103);
        r101.shiftLeftAddThis(r111, r103);
        r101.shiftLeftAddThis(r110, r103);
        r101.addToThis(r110);
        return r101;
    }

    private GF2Polynomial lower(int r100) {
        GF2Polynomial r101 = new GF2Polynomial(r100 << 5);
        System.arraycopy(this.value, 0, r101.value, 0, Math.min(r100, this.blocks));
        return r101;
    }

    private static int[] mult128(int[] r110, int[] r111) {
        int[] r100 = new int[8];
        int[] r101 = new int[2];
        System.arraycopy(r110, 0, r101, 0, Math.min(2, r110.length));
        int[] r102 = new int[2];
        if (r110.length <= 2) goto L5;
        System.arraycopy(r110, 2, r102, 0, Math.min(2, r110.length - 2));
    L5:
        int[] r112 = new int[2];
        System.arraycopy(r111, 0, r112, 0, Math.min(2, r111.length));
        int[] r103 = new int[2];
        if (r111.length <= 2) goto L9;
        System.arraycopy(r111, 2, r103, 0, Math.min(2, r111.length - 2));
    L9:
        if (r102[1] == 0) goto L11;
    L17:
        int[] r104 = mult64(r102, r103);
        int r113 = r100[7];
        int r114 = r104[3];
        r100[7] = r113 ^ r114;
        int r115 = r100[6];
        int r116 = r104[2];
        r100[6] = r115 ^ r116;
        int r117 = r100[5];
        int r118 = r104[1];
        r100[5] = r117 ^ (r114 ^ r118);
        int r119 = r100[4];
        int r105 = r104[0];
        r100[4] = r119 ^ (r105 ^ r116);
        r100[3] = r100[3] ^ r118;
        r100[2] = r105 ^ r100[2];
    L18:
        r102[0] = r102[0] ^ r101[0];
        r102[1] = r102[1] ^ r101[1];
        int r106 = r103[0] ^ r112[0];
        r103[0] = r106;
        int r120 = r103[1] ^ r112[1];
        r103[1] = r120;
        if (r102[1] != 0) goto L22;
        if (r120 != 0) goto L22;
        int[] r107 = mult32(r102[0], r106);
        r100[3] = r100[3] ^ r107[1];
        int r108 = r100[2];
        r100[2] = r107[0] ^ r108;
    L24:
        if (r101[1] == 0) goto L26;
    L28:
        int[] r121 = mult64(r101, r112);
        int r109 = r100[5];
        int r122 = r121[3];
        r100[5] = r109 ^ r122;
        int r123 = r100[4];
        int r124 = r121[2];
        r100[4] = r123 ^ r124;
        int r125 = r100[3];
        int r126 = r121[1];
        r100[3] = r125 ^ (r122 ^ r126);
        int r127 = r100[2];
        int r128 = r121[0];
        r100[2] = r127 ^ (r128 ^ r124);
        r100[1] = r100[1] ^ r126;
        r100[0] = r128 ^ r100[0];
    L29:
        return r100;
    L26:
        if (r112[1] != 0) goto L28;
        int[] r129 = mult32(r101[0], r112[0]);
        int r130 = r100[3];
        int r131 = r129[1];
        r100[3] = r130 ^ r131;
        int r132 = r100[2];
        int r133 = r129[0];
        r100[2] = r132 ^ r133;
        r100[1] = r100[1] ^ r131;
        r100[0] = r133 ^ r100[0];
    L22:
        int[] r134 = mult64(r102, r103);
        r100[5] = r100[5] ^ r134[3];
        r100[4] = r100[4] ^ r134[2];
        r100[3] = r100[3] ^ r134[1];
        int r135 = r100[2];
        r100[2] = r134[0] ^ r135;
        goto L24
    L11:
        if (r103[1] != 0) goto L17;
        int r136 = r102[0];
        if (r136 == 0) goto L15;
    L16:
        int[] r137 = mult32(r136, r103[0]);
        int r138 = r100[5];
        int r139 = r137[1];
        r100[5] = r138 ^ r139;
        int r140 = r100[4];
        int r141 = r137[0];
        r100[4] = r140 ^ r141;
        r100[3] = r100[3] ^ r139;
        r100[2] = r141 ^ r100[2];
        goto L18
    L15:
        if (r103[0] == 0) goto L18;
        goto L16
    }

    private static int[] mult256(int[] r210, int[] r211) {
        int[] r100 = new int[16];
        int[] r101 = new int[4];
        System.arraycopy(r210, 0, r101, 0, Math.min(4, r210.length));
        int[] r102 = new int[4];
        if (r210.length <= 4) goto L5;
        System.arraycopy(r210, 4, r102, 0, Math.min(4, r210.length - 4));
    L5:
        int[] r103 = new int[4];
        System.arraycopy(r211, 0, r103, 0, Math.min(4, r211.length));
        int[] r104 = new int[4];
        if (r211.length <= 4) goto L9;
        System.arraycopy(r211, 4, r104, 0, Math.min(4, r211.length - 4));
    L9:
        if (r102[3] == 0) goto L11;
    L26:
        int[] r105 = mult128(r102, r104);
        int r110 = r100[15];
        int r111 = r105[7];
        r100[15] = r110 ^ r111;
        int r112 = r100[14];
        int r212 = r105[6];
        r100[14] = r112 ^ r212;
        int r113 = r100[13];
        int r213 = r105[5];
        r100[13] = r113 ^ r213;
        int r114 = r100[12];
        int r214 = r105[4];
        r100[12] = r114 ^ r214;
        int r115 = r100[11];
        int r116 = r105[3];
        r100[11] = r115 ^ (r116 ^ r111);
        int r117 = r100[10];
        int r118 = r105[2];
        r100[10] = r117 ^ (r118 ^ r212);
        int r119 = r100[9];
        int r215 = r105[1];
        r100[9] = r119 ^ (r215 ^ r213);
        int r120 = r100[8];
        int r106 = r105[0];
        r100[8] = r120 ^ (r106 ^ r214);
        r100[7] = r100[7] ^ r116;
        r100[6] = r100[6] ^ r118;
        r100[5] = r100[5] ^ r215;
        r100[4] = r106 ^ r100[4];
    L27:
        r102[0] = r102[0] ^ r101[0];
        r102[1] = r102[1] ^ r101[1];
        r102[2] = r102[2] ^ r101[2];
        r102[3] = r102[3] ^ r101[3];
        r104[0] = r104[0] ^ r103[0];
        r104[1] = r104[1] ^ r103[1];
        r104[2] = r104[2] ^ r103[2];
        r104[3] = r104[3] ^ r103[3];
        int[] r107 = mult128(r102, r104);
        r100[11] = r100[11] ^ r107[7];
        r100[10] = r100[10] ^ r107[6];
        r100[9] = r100[9] ^ r107[5];
        r100[8] = r100[8] ^ r107[4];
        r100[7] = r100[7] ^ r107[3];
        r100[6] = r100[6] ^ r107[2];
        r100[5] = r100[5] ^ r107[1];
        int r108 = r100[4];
        r100[4] = r107[0] ^ r108;
        int[] r109 = mult128(r101, r103);
        int r121 = r100[11];
        int r122 = r109[7];
        r100[11] = r121 ^ r122;
        int r123 = r100[10];
        int r124 = r109[6];
        r100[10] = r123 ^ r124;
        int r125 = r100[9];
        int r126 = r109[5];
        r100[9] = r125 ^ r126;
        int r127 = r100[8];
        int r128 = r109[4];
        r100[8] = r127 ^ r128;
        int r129 = r100[7];
        int r130 = r109[3];
        r100[7] = r129 ^ (r122 ^ r130);
        int r131 = r100[6];
        int r132 = r109[2];
        r100[6] = r131 ^ (r124 ^ r132);
        int r133 = r100[5];
        int r134 = r109[1];
        r100[5] = r133 ^ (r126 ^ r134);
        int r135 = r100[4];
        int r136 = r109[0];
        r100[4] = r135 ^ (r136 ^ r128);
        r100[3] = r100[3] ^ r130;
        r100[2] = r100[2] ^ r132;
        r100[1] = r100[1] ^ r134;
        r100[0] = r136 ^ r100[0];
        return r100;
    L11:
        if (r102[2] != 0) goto L26;
        if (r104[3] != 0) goto L26;
        if (r104[2] != 0) goto L26;
        if (r102[1] == 0) goto L19;
    L25:
        int[] r137 = mult64(r102, r104);
        int r138 = r100[11];
        int r139 = r137[3];
        r100[11] = r138 ^ r139;
        int r140 = r100[10];
        int r141 = r137[2];
        r100[10] = r140 ^ r141;
        int r142 = r100[9];
        int r216 = r137[1];
        r100[9] = r142 ^ r216;
        int r143 = r100[8];
        int r144 = r137[0];
        r100[8] = r143 ^ r144;
        r100[7] = r100[7] ^ r139;
        r100[6] = r100[6] ^ r141;
        r100[5] = r100[5] ^ r216;
        r100[4] = r144 ^ r100[4];
        goto L27
    L19:
        if (r104[1] != 0) goto L25;
        int r145 = r102[0];
        if (r145 == 0) goto L23;
    L24:
        int[] r146 = mult32(r145, r104[0]);
        int r147 = r100[9];
        int r148 = r146[1];
        r100[9] = r147 ^ r148;
        int r149 = r100[8];
        int r150 = r146[0];
        r100[8] = r149 ^ r150;
        r100[5] = r100[5] ^ r148;
        r100[4] = r150 ^ r100[4];
        goto L27
    L23:
        if (r104[0] == 0) goto L27;
        goto L24
    }

    private static int[] mult32(int r110, int r111) {
        int[] r100 = new int[2];
        if (r110 == 0) goto L14;
        if (r111 == 0) goto L14;
        long r101 = ((long) r111) & BodyPartID.bodyIdMax;
        long r102 = 0;
        int r103 = 1;
    L8:
        if (r103 > 32) goto L13;
        if ((bitMask[r103 - 1] & r110) == 0) goto L12;
        r102 = r102 ^ r101;
    L12:
        r101 = r101 << 1;
        r103 = r103 + 1;
        goto L8
    L13:
        r100[1] = (int) (r102 >>> 32);
        r100[0] = (int) (r102 & BodyPartID.bodyIdMax);
    L14:
        return r100;
    }

    private static int[] mult512(int[] r310, int[] r410) {
        int[] r100 = new int[32];
        int[] r101 = new int[8];
        System.arraycopy(r310, 0, r101, 0, Math.min(8, r310.length));
        int[] r102 = new int[8];
        if (r310.length <= 8) goto L5;
        System.arraycopy(r310, 8, r102, 0, Math.min(8, r310.length - 8));
    L5:
        int[] r103 = new int[8];
        System.arraycopy(r410, 0, r103, 0, Math.min(8, r410.length));
        int[] r104 = new int[8];
        if (r410.length <= 8) goto L8;
        System.arraycopy(r410, 8, r104, 0, Math.min(8, r410.length - 8));
    L8:
        int[] r105 = mult256(r102, r104);
        int r106 = r100[31];
        int r110 = r105[15];
        r100[31] = r106 ^ r110;
        int r107 = r100[30];
        int r111 = r105[14];
        r100[30] = r107 ^ r111;
        int r108 = r100[29];
        int r112 = r105[13];
        r100[29] = r108 ^ r112;
        int r109 = r100[28];
        int r113 = r105[12];
        r100[28] = r109 ^ r113;
        int r114 = r100[27];
        int r115 = r105[11];
        r100[27] = r114 ^ r115;
        int r116 = r100[26];
        int r210 = r105[10];
        r100[26] = r116 ^ r210;
        int r117 = r100[25];
        int r211 = r105[9];
        r100[25] = r117 ^ r211;
        int r118 = r100[24];
        int r212 = r105[8];
        r100[24] = r118 ^ r212;
        int r119 = r100[23];
        int r213 = r105[7];
        r100[23] = r119 ^ (r213 ^ r110);
        int r120 = r100[22];
        int r214 = r105[6];
        r100[22] = r120 ^ (r214 ^ r111);
        int r121 = r100[21];
        int r311 = r105[5];
        r100[21] = r121 ^ (r311 ^ r112);
        int r122 = r100[20];
        int r312 = r105[4];
        r100[20] = r122 ^ (r312 ^ r113);
        int r123 = r100[19];
        int r313 = r105[3];
        r100[19] = r123 ^ (r313 ^ r115);
        int r124 = r100[18];
        int r314 = r105[2];
        r100[18] = r124 ^ (r314 ^ r210);
        int r215 = r100[17];
        int r315 = r105[1];
        r100[17] = r215 ^ (r315 ^ r211);
        int r216 = r100[16];
        int r125 = r105[0];
        r100[16] = r216 ^ (r125 ^ r212);
        r100[15] = r100[15] ^ r213;
        r100[14] = r100[14] ^ r214;
        r100[13] = r100[13] ^ r311;
        r100[12] = r100[12] ^ r312;
        r100[11] = r100[11] ^ r313;
        r100[10] = r100[10] ^ r314;
        r100[9] = r100[9] ^ r315;
        r100[8] = r100[8] ^ r125;
        r102[0] = r102[0] ^ r101[0];
        r102[1] = r102[1] ^ r101[1];
        r102[2] = r102[2] ^ r101[2];
        r102[3] = r102[3] ^ r101[3];
        r102[4] = r102[4] ^ r101[4];
        r102[5] = r102[5] ^ r101[5];
        r102[6] = r102[6] ^ r101[6];
        r102[7] = r102[7] ^ r101[7];
        r104[0] = r104[0] ^ r103[0];
        r104[1] = r104[1] ^ r103[1];
        r104[2] = r104[2] ^ r103[2];
        r104[3] = r104[3] ^ r103[3];
        r104[4] = r104[4] ^ r103[4];
        r104[5] = r104[5] ^ r103[5];
        r104[6] = r104[6] ^ r103[6];
        r104[7] = r104[7] ^ r103[7];
        int[] r126 = mult256(r102, r104);
        r100[23] = r100[23] ^ r126[15];
        r100[22] = r100[22] ^ r126[14];
        r100[21] = r100[21] ^ r126[13];
        r100[20] = r100[20] ^ r126[12];
        r100[19] = r100[19] ^ r126[11];
        r100[18] = r100[18] ^ r126[10];
        r100[17] = r100[17] ^ r126[9];
        r100[16] = r100[16] ^ r126[8];
        r100[15] = r100[15] ^ r126[7];
        r100[14] = r100[14] ^ r126[6];
        r100[13] = r100[13] ^ r126[5];
        r100[12] = r100[12] ^ r126[4];
        r100[11] = r100[11] ^ r126[3];
        r100[10] = r100[10] ^ r126[2];
        r100[9] = r100[9] ^ r126[1];
        int r127 = r100[8];
        r100[8] = r126[0] ^ r127;
        int[] r128 = mult256(r101, r103);
        int r129 = r100[23];
        int r130 = r128[15];
        r100[23] = r129 ^ r130;
        int r131 = r100[22];
        int r132 = r128[14];
        r100[22] = r131 ^ r132;
        int r133 = r100[21];
        int r134 = r128[13];
        r100[21] = r133 ^ r134;
        int r135 = r100[20];
        int r136 = r128[12];
        r100[20] = r135 ^ r136;
        int r137 = r100[19];
        int r138 = r128[11];
        r100[19] = r137 ^ r138;
        int r139 = r100[18];
        int r140 = r128[10];
        r100[18] = r139 ^ r140;
        int r141 = r100[17];
        int r142 = r128[9];
        r100[17] = r141 ^ r142;
        int r143 = r100[16];
        int r144 = r128[8];
        r100[16] = r143 ^ r144;
        int r145 = r100[15];
        int r146 = r128[7];
        r100[15] = r145 ^ (r130 ^ r146);
        int r147 = r100[14];
        int r148 = r128[6];
        r100[14] = r147 ^ (r132 ^ r148);
        int r149 = r100[13];
        int r150 = r128[5];
        r100[13] = r149 ^ (r134 ^ r150);
        int r151 = r100[12];
        int r152 = r128[4];
        r100[12] = r151 ^ (r136 ^ r152);
        int r153 = r100[11];
        int r154 = r128[3];
        r100[11] = r153 ^ (r138 ^ r154);
        int r155 = r100[10];
        int r156 = r128[2];
        r100[10] = r155 ^ (r156 ^ r140);
        int r157 = r100[9];
        int r158 = r128[1];
        r100[9] = r157 ^ (r158 ^ r142);
        int r159 = r100[8];
        int r160 = r128[0];
        r100[8] = r159 ^ (r160 ^ r144);
        r100[7] = r100[7] ^ r146;
        r100[6] = r100[6] ^ r148;
        r100[5] = r100[5] ^ r150;
        r100[4] = r100[4] ^ r152;
        r100[3] = r100[3] ^ r154;
        r100[2] = r100[2] ^ r156;
        r100[1] = r100[1] ^ r158;
        r100[0] = r160 ^ r100[0];
        return r100;
    }

    private static int[] mult64(int[] r110, int[] r111) {
        int[] r100 = new int[4];
        int r101 = r110[0];
        if (r110.length <= 1) goto L5;
        int r112 = r110[1];
    L6:
        int r102 = r111[0];
        if (r111.length <= 1) goto L9;
        int r113 = r111[1];
    L11:
        if (r112 != 0) goto L13;
        if (r113 != 0) goto L13;
    L14:
        int[] r114 = mult32(r112 ^ r101, r113 ^ r102);
        r100[2] = r100[2] ^ r114[1];
        int r115 = r100[1];
        r100[1] = r114[0] ^ r115;
        int[] r116 = mult32(r101, r102);
        int r117 = r100[2];
        int r103 = r116[1];
        r100[2] = r117 ^ r103;
        int r118 = r100[1];
        int r119 = r116[0];
        r100[1] = r118 ^ (r103 ^ r119);
        r100[0] = r119 ^ r100[0];
        return r100;
    L13:
        int[] r104 = mult32(r112, r113);
        int r105 = r100[3];
        int r106 = r104[1];
        r100[3] = r105 ^ r106;
        int r107 = r100[2];
        int r108 = r104[0];
        r100[2] = r107 ^ (r108 ^ r106);
        r100[1] = r108 ^ r100[1];
        goto L14
    L9:
        r113 = 0;
        goto L11
    L5:
        r112 = 0;
        goto L6
    }

    private GF2Polynomial upper(int r100) {
        int r101 = Math.min(r100, this.blocks - r100);
        GF2Polynomial r102 = new GF2Polynomial(r101 << 5);
        if (this.blocks < r100) goto L5;
        System.arraycopy(this.value, r100, r102.value, 0, r101);
    L5:
        return r102;
    }

    private void zeroUnusedBits() {
        int r100 = this.len;
        if ((r100 & 31) == 0) goto L6;
        int[] r101 = this.value;
        int r102 = this.blocks - 1;
        r101[r102] = reverseRightMask[r100 & 31] & r101[r102];
        return;
    }

    public GF2Polynomial add(GF2Polynomial r100) {
        return xor(r100);
    }

    public void addToThis(GF2Polynomial r100) {
        expandN(r100.len);
        xorThisBy(r100);
    }

    public void assignAll() {
        int r100 = 0;
    L4:
        if (r100 >= this.blocks) goto L6;
        this.value[r100] = -1;
        r100 = r100 + 1;
        goto L4
    L6:
        zeroUnusedBits();
    }

    public void assignOne() {
        int r100 = 1;
    L4:
        if (r100 >= this.blocks) goto L6;
        this.value[r100] = 0;
        r100 = r100 + 1;
        goto L4
    L6:
        this.value[0] = 1;
    }

    public void assignX() {
        int r100 = 1;
    L4:
        if (r100 >= this.blocks) goto L6;
        this.value[r100] = 0;
        r100 = r100 + 1;
        goto L4
    L6:
        this.value[0] = 2;
    }

    public void assignZero() {
        int r100 = 0;
    L4:
        if (r100 >= this.blocks) goto L6;
        this.value[r100] = 0;
        r100 = r100 + 1;
        goto L4
    }

    public Object clone() {
        return new GF2Polynomial(this);
    }

    public GF2Polynomial[] divide(GF2Polynomial r100) throws RuntimeException {
        GF2Polynomial[] r101 = new GF2Polynomial[2];
        GF2Polynomial r102 = new GF2Polynomial(this.len);
        GF2Polynomial r103 = new GF2Polynomial(this);
        GF2Polynomial r104 = new GF2Polynomial(r100);
        if (r104.isZero() == true) goto L14;
        r103.reduceN();
        r104.reduceN();
        int r105 = r103.len;
        int r106 = r104.len;
        if (r105 >= r106) goto L8;
        r101[0] = new GF2Polynomial(0);
        r101[1] = r103;
        return r101;
    L8:
        int r107 = r105 - r106;
        r102.expandN(r107 + 1);
    L9:
        if (r107 < 0) goto L11;
        r103.subtractFromThis(r104.shiftLeft(r107));
        r103.reduceN();
        r102.xorBit(r107);
        r107 = r103.len - r104.len;
        goto L9
    L11:
        r101[0] = r102;
        r101[1] = r103;
        return r101;
    L14:
        throw new RuntimeException();
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L5;
    L19:
        return false;
    L5:
        if ((r100 instanceof GF2Polynomial) == false) goto L19;
        GF2Polynomial r101 = (GF2Polynomial) r100;
        if (this.len == r101.len) goto L10;
        return false;
    L10:
        int r102 = 0;
    L12:
        if (r102 >= this.blocks) goto L17;
        if (this.value[r102] != r101.value[r102]) goto L15;
        r102 = r102 + 1;
        goto L12
    L15:
        return false;
    L17:
        return true;
    }

    public void expandN(int r100) {
        if (this.len < r100) goto L5;
        return;
    L5:
        this.len = r100;
        int r101 = ((r100 - 1) >>> 5) + 1;
        int r102 = this.blocks;
        if (r102 < r101) goto L8;
        return;
    L8:
        int[] r103 = this.value;
        if (r103.length < r101) goto L14;
    L10:
        if (r102 >= r101) goto L12;
        this.value[r102] = 0;
        r102 = r102 + 1;
        goto L10
    L12:
        this.blocks = r101;
        return;
    L14:
        int[] r104 = new int[r101];
        System.arraycopy(r103, 0, r104, 0, r102);
        this.blocks = r101;
        this.value = r104;
    }

    public GF2Polynomial gcd(GF2Polynomial r100) throws RuntimeException {
        if (isZero() == false) goto L10;
        if (r100.isZero() == false) goto L10;
        throw new ArithmeticException("Both operands of gcd equal zero.");
    L10:
        if (isZero() == false) goto L14;
        return new GF2Polynomial(r100);
    L14:
        if (r100.isZero() == true) goto L16;
        GF2Polynomial r101 = new GF2Polynomial(this);
        GF2Polynomial r102 = new GF2Polynomial(r100);
        GF2Polynomial r103 = r101;
        GF2Polynomial r104 = r102;
    L19:
        if (r104.isZero() == true) goto L21;
        GF2Polynomial r105 = r104;
        r104 = r103.remainder(r104);
        r103 = r105;
        goto L19
    L21:
        return r103;
    L16:
        return new GF2Polynomial(this);
    }

    public int getBit(int r100) {
        if (r100 < 0) goto L12;
        if (r100 <= (this.len - 1)) goto L6;
        return 0;
    L6:
        int r101 = this.value[r100 >>> 5];
        if ((bitMask[r100 & 31] & r101) != 0) goto L13;
        return 0;
    L13:
        return 1;
    L12:
        throw new RuntimeException();
    }

    public int getLength() {
        return this.len;
    }

    public int hashCode() {
        return this.len + Arrays.hashCode(this.value);
    }

    public GF2Polynomial increase() {
        GF2Polynomial r100 = new GF2Polynomial(this);
        r100.increaseThis();
        return r100;
    }

    public void increaseThis() {
        xorBit(0);
    }

    public boolean isIrreducible() {
        if (isZero() == false) goto L5;
        return false;
    L5:
        GF2Polynomial r100 = new GF2Polynomial(this);
        r100.reduceN();
        int r101 = r100.len;
        int r102 = r101 - 1;
        GF2Polynomial r103 = new GF2Polynomial(r101, "X");
        int r104 = 1;
    L7:
        if (r104 > (r102 >> 1)) goto L15;
        r103.squareThisPreCalc();
        r103 = r103.remainder(r100);
        GF2Polynomial r105 = r103.add(new GF2Polynomial(32, "X"));
        if (r105.isZero() == true) goto L14;
        if (r100.gcd(r105).isOne() == false) goto L12;
        r104 = r104 + 1;
        goto L7
    L12:
        return false;
    L14:
        return false;
    L15:
        return true;
    }

    public boolean isOne() {
        int r100 = 1;
    L4:
        if (r100 >= this.blocks) goto L10;
        if (this.value[r100] != 0) goto L7;
        r100 = r100 + 1;
        goto L4
    L7:
        return false;
    L10:
        if (this.value[0] == 1) goto L12;
        return false;
    L12:
        return true;
    }

    public boolean isZero() {
        if (this.len != 0) goto L5;
        return true;
    L5:
        int r100 = 0;
    L7:
        if (r100 >= this.blocks) goto L12;
        if (this.value[r100] != 0) goto L10;
        r100 = r100 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }

    public GF2Polynomial multiply(GF2Polynomial r100) {
        int r101 = Math.max(this.len, r100.len);
        expandN(r101);
        r100.expandN(r101);
        return karaMult(r100);
    }

    public GF2Polynomial multiplyClassic(GF2Polynomial r100) {
        int r101 = 1;
        GF2Polynomial r102 = new GF2Polynomial(Math.max(this.len, r100.len) << 1);
        GF2Polynomial[] r103 = new GF2Polynomial[32];
        r103[0] = new GF2Polynomial(this);
    L4:
        if (r101 > 31) goto L6;
        r103[r101] = r103[r101 - 1].shiftLeft();
        r101 = r101 + 1;
        goto L4
    L6:
        int r104 = 0;
    L8:
        if (r104 >= r100.blocks) goto L19;
        int r105 = 0;
    L10:
        if (r105 > 31) goto L15;
        if ((r100.value[r104] & bitMask[r105]) == 0) goto L14;
        r102.xorThisBy(r103[r105]);
    L14:
        r105 = r105 + 1;
        goto L10
    L15:
        int r106 = 0;
    L16:
        if (r106 > 31) goto L18;
        r103[r106].shiftBlocksLeft();
        r106 = r106 + 1;
        goto L16
    L18:
        r104 = r104 + 1;
        goto L8
    L19:
        return r102;
    }

    public GF2Polynomial quotient(GF2Polynomial r100) throws RuntimeException {
        GF2Polynomial r101 = new GF2Polynomial(this.len);
        GF2Polynomial r102 = new GF2Polynomial(this);
        GF2Polynomial r103 = new GF2Polynomial(r100);
        if (r103.isZero() == true) goto L13;
        r102.reduceN();
        r103.reduceN();
        int r104 = r102.len;
        int r105 = r103.len;
        if (r104 < r105) goto L7;
        int r106 = r104 - r105;
        r101.expandN(r106 + 1);
    L9:
        if (r106 < 0) goto L11;
        r102.subtractFromThis(r103.shiftLeft(r106));
        r102.reduceN();
        r101.xorBit(r106);
        r106 = r102.len - r103.len;
        goto L9
    L11:
        return r101;
    L7:
        return new GF2Polynomial(0);
    L13:
        throw new RuntimeException();
    }

    public void randomize() {
        int r100 = 0;
    L4:
        if (r100 >= this.blocks) goto L6;
        this.value[r100] = rand.nextInt();
        r100 = r100 + 1;
        goto L4
    L6:
        zeroUnusedBits();
    }

    public void randomize(Random r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.blocks) goto L6;
        this.value[r101] = r100.nextInt();
        r101 = r101 + 1;
        goto L4
    L6:
        zeroUnusedBits();
    }

    public void reduceN() {
        int r100 = this.blocks;
    L3:
        r100 = r100 - 1;
        int r101 = this.value[r100];
        if (r101 != 0) goto L7;
        if (r100 > 0) goto L3;
    L7:
        int r102 = 0;
    L8:
        if (r101 == 0) goto L10;
        r101 = r101 >>> 1;
        r102 = r102 + 1;
        goto L8
    L10:
        this.len = (r100 << 5) + r102;
        this.blocks = r100 + 1;
    }

    public void reducePentanomial(int r210, int[] r211) {
        int r100 = r210 >>> 5;
        int r101 = r210 & 31;
        int r102 = 32 - r101;
        int r103 = r211[0];
        int r104 = (r210 - r103) >>> 5;
        int r105 = 32 - ((r210 - r103) & 31);
        int r106 = r211[1];
        int r110 = (r210 - r106) >>> 5;
        int r107 = 32 - ((r210 - r106) & 31);
        int r111 = r211[2];
        int r112 = (r210 - r111) >>> 5;
        int r113 = 32 - ((r210 - r111) & 31);
        int r114 = ((r210 << 1) - 2) >>> 5;
    L4:
        if (r114 <= r100) goto L6;
        int[] r108 = this.value;
        long r109 = ((long) r108[r114]) & BodyPartID.bodyIdMax;
        int r115 = r114 - r100;
        int r116 = r115 - 1;
        int r117 = r100;
        int r118 = r101;
        r108[r116] = r108[r116] ^ ((int) (r109 << r102));
        r108[r115] = (int) (((long) r108[r115]) ^ (r109 >>> (32 - r102)));
        int r119 = r114 - r104;
        int r120 = r119 - 1;
        r108[r120] = r108[r120] ^ ((int) (r109 << r105));
        r108[r119] = (int) (((long) r108[r119]) ^ (r109 >>> (32 - r105)));
        int r121 = r114 - r110;
        int r122 = r121 - 1;
        r108[r122] = r108[r122] ^ ((int) (r109 << r107));
        r108[r121] = (int) (((long) r108[r121]) ^ (r109 >>> (32 - r107)));
        int r123 = r114 - r112;
        int r124 = r123 - 1;
        r108[r124] = r108[r124] ^ ((int) (r109 << r113));
        r108[r123] = (int) ((r109 >>> (32 - r113)) ^ r108[r123]);
        r108[r114] = 0;
        r114 = r114 - 1;
        r100 = r117;
        r101 = r118;
        goto L4
    L6:
        int r125 = r100;
        int r126 = r101;
        int[] r127 = this.value;
        long r128 = (((long) r127[r125]) & BodyPartID.bodyIdMax) & (BodyPartID.bodyIdMax << r126);
        r127[0] = (int) ((r128 >>> (32 - r102)) ^ ((long) r127[0]));
        int r129 = r125 - r104;
        int r130 = r129 - 1;
        if (r130 < 0) goto L9;
        r127[r130] = r127[r130] ^ ((int) (r128 << r105));
    L9:
        r127[r129] = (int) (((long) r127[r129]) ^ (r128 >>> (32 - r105)));
        int r131 = r125 - r110;
        int r132 = r131 - 1;
        if (r132 < 0) goto L12;
        r127[r132] = r127[r132] ^ ((int) (r128 << r107));
    L12:
        r127[r131] = (int) (((long) r127[r131]) ^ (r128 >>> (32 - r107)));
        int r133 = r125 - r112;
        int r134 = r133 - 1;
        if (r134 < 0) goto L15;
        r127[r134] = r127[r134] ^ ((int) (r128 << r113));
    L15:
        r127[r133] = (int) ((r128 >>> (32 - r113)) ^ ((long) r127[r133]));
        r127[r125] = r127[r125] & reverseRightMask[r126];
        this.blocks = ((r210 - 1) >>> 5) + 1;
        this.len = r210;
    }

    public void reduceTrinomial(int r110, int r111) {
        int r100 = r110 >>> 5;
        int r101 = r110 & 31;
        int r102 = 32 - r101;
        int r103 = r110 - r111;
        int r104 = r103 >>> 5;
        int r105 = 32 - (r103 & 31);
        int r106 = ((r110 << 1) - 2) >>> 5;
    L4:
        if (r106 <= r100) goto L6;
        int[] r112 = this.value;
        long r107 = BodyPartID.bodyIdMax & ((long) r112[r106]);
        int r113 = r106 - r100;
        int r114 = r113 - 1;
        int r115 = r100;
        r112[r114] = r112[r114] ^ ((int) (r107 << r102));
        r112[r113] = (int) (((long) r112[r113]) ^ (r107 >>> (32 - r102)));
        int r108 = r106 - r104;
        int r109 = r108 - 1;
        r112[r109] = r112[r109] ^ ((int) (r107 << r105));
        r112[r108] = (int) ((r107 >>> (32 - r105)) ^ r112[r108]);
        r112[r106] = 0;
        r106 = r106 - 1;
        r100 = r115;
        goto L4
    L6:
        int r116 = r100;
        int[] r117 = this.value;
        long r118 = (BodyPartID.bodyIdMax << r101) & (((long) r117[r116]) & BodyPartID.bodyIdMax);
        r117[0] = (int) (((long) r117[0]) ^ (r118 >>> (32 - r102)));
        int r119 = r116 - r104;
        int r120 = r119 - 1;
        if (r120 < 0) goto L9;
        r117[r120] = r117[r120] ^ ((int) (r118 << r105));
    L9:
        r117[r119] = (int) ((r118 >>> (32 - r105)) ^ r117[r119]);
        r117[r116] = r117[r116] & reverseRightMask[r101];
        this.blocks = ((r110 - 1) >>> 5) + 1;
        this.len = r110;
    }

    public GF2Polynomial remainder(GF2Polynomial r100) throws RuntimeException {
        GF2Polynomial r101 = new GF2Polynomial(this);
        GF2Polynomial r102 = new GF2Polynomial(r100);
        if (r102.isZero() == true) goto L12;
        r101.reduceN();
        r102.reduceN();
        int r103 = r101.len;
        int r104 = r102.len;
        if (r103 >= r104) goto L7;
        return r101;
    L7:
        int r105 = r103 - r104;
        if (r105 < 0) goto L10;
        r101.subtractFromThis(r102.shiftLeft(r105));
        r101.reduceN();
        r103 = r101.len;
        r104 = r102.len;
        goto L7
    L10:
        return r101;
    L12:
        throw new RuntimeException();
    }

    public void resetBit(int r100) throws RuntimeException {
        if (r100 < 0) goto L9;
        if (r100 <= (this.len - 1)) goto L6;
        return;
    L6:
        int[] r101 = this.value;
        int r102 = r100 >>> 5;
        r101[r102] = (~bitMask[r100 & 31]) & r101[r102];
        return;
    L9:
        throw new RuntimeException();
    }

    public void setBit(int r100) throws RuntimeException {
        if (r100 < 0) goto L8;
        if (r100 > (this.len - 1)) goto L8;
        int[] r101 = this.value;
        int r102 = r100 >>> 5;
        r101[r102] = bitMask[r100 & 31] | r101[r102];
        return;
    L8:
        throw new RuntimeException();
    }

    public void shiftBlocksLeft() {
        int r100 = this.blocks + 1;
        this.blocks = r100;
        this.len += 32;
        int[] r101 = this.value;
        if (r100 > r101.length) goto L8;
        int r102 = r100 - 1;
    L5:
        if (r102 < 1) goto L7;
        int[] r103 = this.value;
        r103[r102] = r103[r102 - 1];
        r102 = r102 - 1;
        goto L5
    L7:
        this.value[0] = 0;
        return;
    L8:
        int[] r104 = new int[r100];
        System.arraycopy(r101, 0, r104, 1, r100 - 1);
        this.value = r104;
    }

    public GF2Polynomial shiftLeft() {
        GF2Polynomial r100 = new GF2Polynomial(this.len + 1, this.value);
        int r101 = r100.blocks - 1;
    L3:
        if (r101 < 1) goto L5;
        int[] r102 = r100.value;
        int r103 = r102[r101] << 1;
        r102[r101] = r103;
        r102[r101] = r103 | (r102[r101 - 1] >>> 31);
        r101 = r101 - 1;
        goto L3
    L5:
        int[] r104 = r100.value;
        r104[0] = r104[0] << 1;
        return r100;
    }

    public GF2Polynomial shiftLeft(int r100) {
        GF2Polynomial r101 = new GF2Polynomial(this.len + r100, this.value);
        if (r100 < 32) goto L5;
        r101.doShiftBlocksLeft(r100 >>> 5);
    L5:
        int r102 = r100 & 31;
        if (r102 == 0) goto L11;
        int r103 = r101.blocks - 1;
    L8:
        if (r103 < 1) goto L10;
        int[] r104 = r101.value;
        int r105 = r104[r103] << r102;
        r104[r103] = r105;
        r104[r103] = r105 | (r104[r103 - 1] >>> (32 - r102));
        r103 = r103 - 1;
        goto L8
    L10:
        int[] r106 = r101.value;
        r106[0] = r106[0] << r102;
    L11:
        return r101;
    }

    public void shiftLeftAddThis(GF2Polynomial r100, int r110) {
        if (r110 != 0) goto L5;
        addToThis(r100);
        return;
    L5:
        expandN(r100.len + r110);
        int r101 = r110 >>> 5;
        int r102 = r100.blocks - 1;
    L6:
        if (r102 < 0) goto L13;
        int r103 = r102 + r101;
        int r104 = r103 + 1;
        if (r104 >= this.blocks) goto L12;
        int r105 = r110 & 31;
        if (r105 == 0) goto L12;
        int[] r106 = this.value;
        r106[r104] = (r100.value[r102] >>> (32 - r105)) ^ r106[r104];
    L12:
        int[] r107 = this.value;
        r107[r103] = r107[r103] ^ (r100.value[r102] << (r110 & 31));
        r102 = r102 - 1;
        goto L6
    }

    public void shiftLeftThis() {
        int r100 = this.len;
        int r101 = r100 & 31;
        this.len = r100 + 1;
        int r102 = this.blocks;
        if (r101 != 0) goto L10;
        int r103 = r102 + 1;
        this.blocks = r103;
        int[] r104 = this.value;
        if (r103 <= r104.length) goto L7;
        int[] r105 = new int[r103];
        System.arraycopy(r104, 0, r105, 0, r104.length);
        this.value = r105;
    L7:
        int r106 = this.blocks - 1;
    L8:
        if (r106 < 1) goto L17;
        int[] r107 = this.value;
        int r108 = r106 - 1;
        r107[r106] = r107[r106] | (r107[r108] >>> 31);
        r107[r108] = r107[r108] << 1;
        r106 = r106 - 1;
        goto L8
    L17:
        return;
    L10:
        int r109 = r102 - 1;
    L11:
        if (r109 < 1) goto L13;
        int[] r110 = this.value;
        int r111 = r110[r109] << 1;
        r110[r109] = r111;
        r110[r109] = r111 | (r110[r109 - 1] >>> 31);
        r109 = r109 - 1;
        goto L11
    L13:
        int[] r112 = this.value;
        r112[0] = r112[0] << 1;
    }

    public GF2Polynomial shiftRight() {
        GF2Polynomial r100 = new GF2Polynomial(this.len - 1);
        int r101 = 0;
        System.arraycopy(this.value, 0, r100.value, 0, r100.blocks);
    L3:
        int r102 = r100.blocks;
        if (r101 > (r102 - 2)) goto L6;
        int[] r103 = r100.value;
        int r104 = r103[r101] >>> 1;
        r103[r101] = r104;
        int r105 = r101 + 1;
        r103[r101] = r104 | (r103[r105] << 31);
        r101 = r105;
        goto L3
    L6:
        int[] r106 = r100.value;
        int r107 = r102 - 1;
        r106[r107] = r106[r107] >>> 1;
        if (r102 >= this.blocks) goto L9;
        int r108 = r102 - 1;
        r106[r108] = (this.value[r102] << 31) | r106[r108];
    L9:
        return r100;
    }

    public void shiftRightThis() {
        int r100 = this.len - 1;
        this.len = r100;
        this.blocks = ((r100 - 1) >>> 5) + 1;
        int r101 = 0;
    L3:
        int r102 = this.blocks;
        if (r101 > (r102 - 2)) goto L6;
        int[] r103 = this.value;
        int r104 = r103[r101] >>> 1;
        r103[r101] = r104;
        int r105 = r101 + 1;
        r103[r101] = r104 | (r103[r105] << 31);
        r101 = r105;
        goto L3
    L6:
        int[] r106 = this.value;
        int r107 = r102 - 1;
        r106[r107] = r106[r107] >>> 1;
        if ((this.len & 31) != 0) goto L11;
        int r108 = r102 - 1;
        r106[r108] = (r106[r102] << 31) | r106[r108];
        return;
    }

    public void squareThisBitwise() {
        if (isZero() == false) goto L5;
        return;
    L5:
        int r100 = this.blocks;
        int r101 = r100 << 1;
        int[] r102 = new int[r101];
        int r103 = r100 - 1;
    L6:
        if (r103 < 0) goto L18;
        int r104 = this.value[r103];
        int r105 = 0;
        int r106 = 1;
    L9:
        if (r105 >= 16) goto L17;
        if ((r104 & 1) == 0) goto L14;
        int r107 = r103 << 1;
        r102[r107] = r102[r107] | r106;
    L14:
        if ((65536 & r104) == 0) goto L16;
        int r108 = (r103 << 1) + 1;
        r102[r108] = r102[r108] | r106;
    L16:
        r106 = r106 << 2;
        r104 = r104 >>> 1;
        r105 = r105 + 1;
        goto L9
    L17:
        r103 = r103 - 1;
        goto L6
    L18:
        this.value = r102;
        this.blocks = r101;
        this.len = (this.len << 1) - 1;
    }

    public void squareThisPreCalc() {
        if (isZero() == false) goto L5;
        return;
    L5:
        int r100 = this.value.length;
        int r101 = this.blocks;
        if (r100 < (r101 << 1)) goto L11;
        int r102 = r101 - 1;
    L8:
        if (r102 < 0) goto L10;
        int[] r103 = this.value;
        int r104 = r102 << 1;
        short[] r105 = squaringTable;
        int r106 = r103[r102];
        r103[r104 + 1] = (r105[(r106 & (-16777216)) >>> 24] << 16) | r105[(r106 & 16711680) >>> 16];
        int r107 = r103[r102];
        r103[r104] = (r105[(r107 & 65280) >>> 8] << 16) | r105[r107 & 255];
        r102 = r102 - 1;
        goto L8
    L10:
        int r108 = this.blocks << 1;
    L16:
        this.blocks = r108;
        this.len = (this.len << 1) - 1;
        return;
    L11:
        int[] r109 = new int[r101 << 1];
        int r110 = 0;
    L12:
        int r111 = this.blocks;
        if (r110 >= r111) goto L15;
        int r112 = r110 << 1;
        short[] r113 = squaringTable;
        int[] r114 = this.value;
        int r115 = r114[r110];
        r109[r112] = (r113[(r115 & 65280) >>> 8] << 16) | r113[r115 & 255];
        int r116 = r114[r110];
        r109[r112 + 1] = (r113[(r116 & (-16777216)) >>> 24] << 16) | r113[(r116 & 16711680) >>> 16];
        r110 = r110 + 1;
        goto L12
    L15:
        this.value = r109;
        r108 = r111 << 1;
        goto L16
    }

    public GF2Polynomial subtract(GF2Polynomial r100) {
        return xor(r100);
    }

    public void subtractFromThis(GF2Polynomial r100) {
        expandN(r100.len);
        xorThisBy(r100);
    }

    public boolean testBit(int r100) {
        if (r100 < 0) goto L12;
        if (r100 <= (this.len - 1)) goto L6;
        return false;
    L6:
        int r101 = this.value[r100 >>> 5];
        if ((bitMask[r100 & 31] & r101) != 0) goto L13;
        return false;
    L13:
        return true;
    L12:
        throw new RuntimeException();
    }

    public byte[] toByteArray() {
        int r100 = ((this.len - 1) >> 3) + 1;
        int r101 = r100 & 3;
        byte[] r102 = new byte[r100];
        int r103 = 0;
        int r104 = 0;
    L4:
        if (r104 >= (r100 >> 2)) goto L6;
        int r105 = (r100 - (r104 << 2)) - 1;
        int r106 = this.value[r104];
        r102[r105] = (byte) (r106 & 255);
        r102[r105 - 1] = (byte) ((65280 & r106) >>> 8);
        r102[r105 - 2] = (byte) ((16711680 & r106) >>> 16);
        r102[r105 - 3] = (byte) ((r106 & (-16777216)) >>> 24);
        r104 = r104 + 1;
    L6:
        if (r103 >= r101) goto L8;
        int r107 = ((r101 - r103) - 1) << 3;
        r102[r103] = (byte) ((this.value[this.blocks - 1] & (255 << r107)) >>> r107);
        r103 = r103 + 1;
        goto L6
    L8:
        return r102;
    }

    public BigInteger toFlexiBigInt() {
        if (this.len == 0) goto L10;
        if (isZero() == true) goto L10;
        return new BigInteger(1, toByteArray());
    L10:
        return new BigInteger(0, new byte[0]);
    }

    public int[] toIntegerArray() {
        int r100 = this.blocks;
        int[] r101 = new int[r100];
        System.arraycopy(this.value, 0, r101, 0, r100);
        return r101;
    }

    public String toString(int r210) {
        char[] r100 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f'};
        String[] r101 = {AbsBatteryStrategy.AppFgCombination.APP_FG__CHARGE_IN__NETWORK_WIFI__SCREEN_ON, "0001", AbsBatteryStrategy.AppFgCombination.APP_FG__CHARGE_IN__NETWORK_NOT_WIFI__SCREEN_ON, "0011", AbsBatteryStrategy.AppFgCombination.APP_FG__CHARGE_OUT__NETWORK_WIFI__SCREEN_ON, "0101", AbsBatteryStrategy.AppFgCombination.APP_FG__CHARGE_OUT__NETWORK_NOT_WIFI__SCREEN_ON, "0111", "1000", AbsBatteryStrategy.AppBgCombination.APP_BG__CHARGE_IN__NETWORK_WIFI__SCREEN_OFF, AbsBatteryStrategy.AppBgCombination.APP_BG__CHARGE_IN__NETWORK_NOT_WIFI__SCREEN_ON, AbsBatteryStrategy.AppBgCombination.APP_BG__CHARGE_IN__NETWORK_NOT_WIFI__SCREEN_OFF, AbsBatteryStrategy.AppBgCombination.APP_BG__CHARGE_OUT__NETWORK_WIFI__SCREEN_ON, AbsBatteryStrategy.AppBgCombination.APP_BG__CHARGE_OUT__NETWORK_WIFI__SCREEN_OFF, AbsBatteryStrategy.AppBgCombination.APP_BG__CHARGE_OUT__NETWORK_NOT_WIFI__SCREEN_ON, AbsBatteryStrategy.AppBgCombination.APP_BG__CHARGE_OUT__NETWORK_NOT_WIFI__SCREEN_OFF};
        String r102 = new String();
        if (r210 != 16) goto L7;
        int r103 = this.blocks - 1;
    L5:
        if (r103 < 0) goto L10;
        r102 = ((((((((r102 + r100[(this.value[r103] >>> 28) & 15]) + r100[(this.value[r103] >>> 24) & 15]) + r100[(this.value[r103] >>> 20) & 15]) + r100[(this.value[r103] >>> 16) & 15]) + r100[(this.value[r103] >>> 12) & 15]) + r100[(this.value[r103] >>> 8) & 15]) + r100[(this.value[r103] >>> 4) & 15]) + r100[this.value[r103] & 15]) + " ";
        r103 = r103 - 1;
    L10:
        return r102;
    L7:
        int r104 = this.blocks - 1;
    L8:
        if (r104 < 0) goto L10;
        r102 = ((((((((r102 + r101[(this.value[r104] >>> 28) & 15]) + r101[(this.value[r104] >>> 24) & 15]) + r101[(this.value[r104] >>> 20) & 15]) + r101[(this.value[r104] >>> 16) & 15]) + r101[(this.value[r104] >>> 12) & 15]) + r101[(this.value[r104] >>> 8) & 15]) + r101[(this.value[r104] >>> 4) & 15]) + r101[this.value[r104] & 15]) + " ";
        r104 = r104 - 1;
        goto L8
    }

    public boolean vectorMult(GF2Polynomial r100) throws RuntimeException {
        if (this.len != r100.len) goto L10;
        int r101 = 0;
        boolean r102 = false;
    L6:
        if (r101 >= this.blocks) goto L8;
        int r103 = this.value[r101] & r100.value[r101];
        boolean[] r104 = parity;
        r102 = (((r102 ^ r104[r103 & 255]) ^ r104[(r103 >>> 8) & 255]) ^ r104[(r103 >>> 16) & 255]) ^ r104[(r103 >>> 24) & 255];
        r101 = r101 + 1;
        goto L6
    L8:
        return r102;
    L10:
        throw new RuntimeException();
    }

    public GF2Polynomial xor(GF2Polynomial r100) {
        int r101 = Math.min(this.blocks, r100.blocks);
        int r102 = 0;
        if (this.len < r100.len) goto L7;
        GF2Polynomial r103 = new GF2Polynomial(this);
    L5:
        if (r102 >= r101) goto L10;
        int[] r104 = r103.value;
        r104[r102] = r104[r102] ^ r100.value[r102];
        r102 = r102 + 1;
    L10:
        r103.zeroUnusedBits();
        return r103;
    L7:
        r103 = new GF2Polynomial(r100);
    L8:
        if (r102 >= r101) goto L10;
        int[] r105 = r103.value;
        r105[r102] = r105[r102] ^ this.value[r102];
        r102 = r102 + 1;
        goto L8
    }

    public void xorBit(int r100) throws RuntimeException {
        if (r100 < 0) goto L8;
        if (r100 > (this.len - 1)) goto L8;
        int[] r101 = this.value;
        int r102 = r100 >>> 5;
        r101[r102] = bitMask[r100 & 31] ^ r101[r102];
        return;
    L8:
        throw new RuntimeException();
    }

    public void xorThisBy(GF2Polynomial r100) {
        int r101 = 0;
    L4:
        if (r101 >= Math.min(this.blocks, r100.blocks)) goto L6;
        int[] r102 = this.value;
        r102[r101] = r102[r101] ^ r100.value[r101];
        r101 = r101 + 1;
        goto L4
    L6:
        zeroUnusedBits();
    }
}
