package com.bytedance.android.ui.ec.widget.tools;

import android.graphics.Bitmap;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class BlurImage {
    private static final int DEFAULT_STEUP = 10;
    private static final String TAG = "BlurImage";

    public BlurImage() {
    }

    public static void blur(Bitmap r36, Bitmap r37, int r38) {
        int r0 = r38;
        if (r0 >= 1) goto L5;
        return;
    L5:
        int r10 = r37.getWidth();
        int r11 = r37.getHeight();
        int r12 = r10 * r11;
        int[] r13 = new int[r12];
        r36.getPixels(r13, 0, r10, 0, 0, r10, r11);
        int r2 = r10 - 1;
        int r3 = r11 - 1;
        int r4 = (r0 + r0) + 1;
        int[] r5 = new int[r12];
        int[] r6 = new int[r12];
        int[] r7 = new int[r12];
        int[] r8 = new int[Math.max(r10, r11)];
        int r9 = (r4 + 1) >> 1;
        int r14 = r9 * r9;
        int r15 = r14 * 256;
        int[] r16 = new int[r15];
        int r17 = 0;
    L6:
        if (r17 >= r15) goto L10;
        if (r14 == 0) goto L9;
        r16[r17] = r17 / r14;
    L9:
        r17 = r17 + 1;
        goto L6
    L10:
        int[][] r18 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{r4, 3});
        int r19 = r0 + 1;
        int r20 = 0;
        int r110 = 0;
        int r111 = 0;
    L11:
        if (r20 >= r11) goto L28;
        int r28 = r11;
        int r21 = 0;
        int r22 = 0;
        int r23 = 0;
        int r24 = 0;
        int r25 = 0;
        int r26 = 0;
        int r27 = 0;
        int r29 = 0;
        int r112 = -r0;
        int r1 = 0;
    L14:
        if (r112 > r0) goto L20;
        int r31 = r3;
        int[] r32 = r8;
        int r30 = r13[r110 + Math.min(r2, Math.max(r112, 0))];
        int[] r33 = r18[r112 + r0];
        r33[0] = (r30 & 16711680) >> 16;
        r33[1] = (r30 & 65280) >> 8;
        r33[2] = r30 & 255;
        int r34 = r19 - Math.abs(r112);
        int r210 = r33[0];
        r1 = r1 + (r210 * r34);
        int r35 = r33[1];
        r21 = r21 + (r35 * r34);
        int r39 = r33[2];
        r22 = r22 + (r34 * r39);
        if (r112 <= 0) goto L18;
        r26 = r26 + r210;
        r27 = r27 + r35;
        r29 = r29 + r39;
    L19:
        r112 = r112 + 1;
        r3 = r31;
        r8 = r32;
        goto L14
    L18:
        r23 = r23 + r210;
        r24 = r24 + r35;
        r25 = r25 + r39;
        goto L19
    L20:
        int r310 = r3;
        int[] r311 = r8;
        int r40 = r0;
        int r41 = r1;
        int r42 = 0;
    L21:
        if (r42 >= r10) goto L27;
        r5[r110] = r16[r41];
        r6[r110] = r16[r21];
        r7[r110] = r16[r22];
        int r43 = r41 - r23;
        int r211 = r21 - r24;
        int r212 = r22 - r25;
        int[] r113 = r18[((r40 - r0) + r4) % r4];
        int r213 = r23 - r113[0];
        int r214 = r24 - r113[1];
        int r215 = r25 - r113[2];
        if (r20 != 0) goto L26;
        r311[r42] = Math.min((r42 + r0) + 1, r2);
    L26:
        int r114 = r13[r111 + r311[r42]];
        int r312 = (r114 & 16711680) >> 16;
        r113[0] = r312;
        int r313 = (r114 & 65280) >> 8;
        r113[1] = r313;
        int r115 = r114 & 255;
        r113[2] = r115;
        int r216 = r26 + r312;
        int r217 = r27 + r313;
        int r218 = r29 + r115;
        r41 = r43 + r216;
        r21 = r211 + r217;
        r22 = r212 + r218;
        r40 = (r40 + 1) % r4;
        int[] r116 = r18[r40 % r4];
        int r314 = r116[0];
        r23 = r213 + r314;
        int r315 = r116[1];
        r24 = r214 + r315;
        int r117 = r116[2];
        r25 = r215 + r117;
        r26 = r216 - r314;
        r27 = r217 - r315;
        r29 = r218 - r117;
        r110 = r110 + 1;
        r42 = r42 + 1;
        r16 = r16;
        goto L21
    L27:
        r111 = r111 + r10;
        r20 = r20 + 1;
        r11 = r28;
        r3 = r310;
        r8 = r311;
        goto L11
    L28:
        int r316 = r3;
        int[] r317 = r8;
        int r219 = r11;
        int[] r318 = r16;
        int r44 = 0;
    L29:
        if (r44 >= r10) goto L47;
        int r45 = -r0;
        int r220 = r4;
        int[] r221 = r13;
        int r46 = 0;
        int r47 = 0;
        int r118 = 0;
        int r119 = 0;
        int r120 = 0;
        int r121 = 0;
        int r222 = 0;
        int r48 = r45;
        int r122 = r45 * r10;
        int r49 = 0;
        int r50 = 0;
    L31:
        if (r48 > r0) goto L40;
        int r223 = r10;
        int r224 = Math.max(0, r122) + r44;
        int[] r225 = r18[r48 + r0];
        r225[0] = r5[r224];
        r225[1] = r6[r224];
        r225[2] = r7[r224];
        int r123 = r19 - Math.abs(r48);
        r49 = r49 + (r5[r224] * r123);
        r50 = r50 + (r6[r224] * r123);
        r46 = r46 + (r7[r224] * r123);
        if (r48 <= 0) goto L35;
        r120 = r120 + r225[0];
        r121 = r121 + r225[1];
        r222 = r222 + r225[2];
    L36:
        int r124 = r316;
        if (r48 >= r124) goto L39;
        r122 = r122 + r223;
    L39:
        r48 = r48 + 1;
        r316 = r124;
        r10 = r223;
        goto L31
    L35:
        r47 = r47 + r225[0];
        r118 = r118 + r225[1];
        r119 = r119 + r225[2];
        goto L36
    L40:
        int r226 = r10;
        int r125 = r316;
        int r227 = r0;
        int r228 = r44;
        int r126 = r219;
        int r51 = 0;
    L41:
        if (r51 >= r126) goto L46;
        r221[r228] = (((r221[r228] & (-16777216)) | (r318[r49] << 16)) | (r318[r50] << 8)) | r318[r46];
        int r52 = r49 - r47;
        int r53 = r50 - r118;
        int r54 = r46 - r119;
        int[] r229 = r18[((r227 - r0) + r220) % r220];
        int r55 = r47 - r229[0];
        int r127 = r118 - r229[1];
        int r128 = r119 - r229[2];
        if (r44 != 0) goto L45;
        r317[r51] = Math.min(r51 + r19, r125) * r226;
    L45:
        int r56 = r317[r51] + r44;
        int r230 = r5[r56];
        r229[0] = r230;
        int r231 = r6[r56];
        r229[1] = r231;
        int r57 = r7[r56];
        r229[2] = r57;
        int r129 = r120 + r230;
        int r130 = r121 + r231;
        int r232 = r222 + r57;
        r49 = r52 + r129;
        r50 = r53 + r130;
        r46 = r54 + r232;
        r227 = (r227 + 1) % r220;
        int[] r58 = r18[r227];
        int r233 = r58[0];
        r47 = r55 + r233;
        int r234 = r58[1];
        r118 = r127 + r234;
        int r59 = r58[2];
        r119 = r128 + r59;
        r120 = r129 - r233;
        r121 = r130 - r234;
        r222 = r232 - r59;
        r228 = r228 + r226;
        r51 = r51 + 1;
        r0 = r38;
        goto L41
    L46:
        r44 = r44 + 1;
        r0 = r38;
        r316 = r125;
        r219 = r126;
        r4 = r220;
        r13 = r221;
        r10 = r226;
        goto L29
    L47:
        int r235 = r10;
        r37.setPixels(r13, 0, r235, 0, 0, r235, r219);
    }
}
