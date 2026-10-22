package com.facebook.imagepipeline.blurhash;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.SparseArray;
import com.alipay.sdk.m.n.a;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.NamedPipe;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.OthersPermission;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Symlink;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.text.Typography;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

/* JADX INFO: loaded from: classes23.dex */
public final class BlurHashDecoder {
    private static final Map charMap = null;
    private static List<Character> testList;
    private final SparseArray<double[]> cacheCosinesX;
    private final SparseArray<double[]> cacheCosinesY;

    private float coerceIn(float r100, float r101, float r102) {
        if (r100 >= r101) goto L6;
        return r101;
    L6:
        if (r100 <= r102) goto L8;
        return r102;
    L8:
        return r100;
    }

    static {
        List<Character> r100 = Arrays.asList(new Character[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', Character.valueOf(Matrix.MATRIX_TYPE_RANDOM_LT), 'M', 'N', 'O', 'P', 'Q', Character.valueOf(Matrix.MATRIX_TYPE_RANDOM_REGULAR), 'S', Character.valueOf(OthersPermission.STICKY), Character.valueOf(Matrix.MATRIX_TYPE_RANDOM_UT), 'V', 'W', 'X', 'Y', Character.valueOf(Matrix.MATRIX_TYPE_ZERO), 'a', Character.valueOf(BlockDevice.UNIX_ID), Character.valueOf(CharacterDevice.UNIX_ID), Character.valueOf(Directory.UNIX_ID), 'e', 'f', 'g', 'h', 'i', 'j', 'k', Character.valueOf(Symlink.UNIX_ID), 'm', 'n', 'o', Character.valueOf(NamedPipe.UNIX_ID), 'q', Character.valueOf(Permission.READ), 's', Character.valueOf(OthersPermission.STICKY_E), 'u', 'v', Character.valueOf(Permission.WRITE), Character.valueOf(Permission.EXECUTE), 'y', 'z', '#', Character.valueOf(Typography.dollar), '%', '*', '+', ',', '-', '.', ':', ';', Character.valueOf(a.f25612h), '?', '@', '[', ']', '^', '_', '{', '|', '}', '~'});
        testList = r100;
        charMap = convertListBeforeJava8(r100);
    }

    public void clearCache() {
        this.cacheCosinesX.clear();
        this.cacheCosinesY.clear();
    }

    public BlurHashDecoder() {
        this.cacheCosinesX = new SparseArray();
        this.cacheCosinesY = new SparseArray();
    }

    public static Map<Character, Integer> convertListBeforeJava8(List<Character> r100) {
        HashMap r101 = new HashMap();
        int r102 = 0;
    L4:
        if (r102 >= r100.size()) goto L6;
        r101.put(r100.get(r102), Integer.valueOf(r102));
        r102 = r102 + 1;
        goto L4
    L6:
        return r101;
    }

    private float[] decodeDc(int r100) {
        return new float[]{srgbToLinear(r100 >> 16), srgbToLinear((r100 >> 8) & 255), srgbToLinear(r100 & 255)};
    }

    private int linearToSrgb(float r100) {
        float r101 = coerceIn(r100, 0.0f, 1.0f);
        if (r101 > 0.0031308f) goto L6;
        return (int) (((r101 * 12.92f) * 255.0f) + 0.5f);
    L6:
        return (int) ((((Math.pow(r101, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d) * 255.0d) + 0.5d);
    }

    private static float signedPow2(float r100) {
        return Math.copySign((float) Math.pow(r100, 2.0d), r100);
    }

    private float srgbToLinear(int r100) {
        float r101 = r100 / 255.0f;
        if (r101 > 0.04045f) goto L6;
        return r101 / 12.92f;
    L6:
        return (float) Math.pow((r101 + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    private float[] decodeAc(int r100, float r101) {
        return new float[]{signedPow2(((r100 / 361) - 9) / 9.0f) * r101, signedPow2((((r100 / 19) % 19) - 9) / 9.0f) * r101, signedPow2(((r100 % 19) - 9) / 9.0f) * r101};
    }

    private int decode83(String r100, int r101, int r102) {
        int r103 = 0;
    L3:
        if (r101 >= r102) goto L11;
        Integer r104 = (Integer) charMap.get(Character.valueOf(r100.charAt(r101)));
        if (r104 == null) goto L7;
        int r105 = r104.intValue();
    L8:
        if (r105 == (-1)) goto L10;
        r103 = (r103 * 83) + r105;
    L10:
        r101 = r101 + 1;
        goto L3
    L7:
        r105 = -1;
        goto L8
    L11:
        return r103;
    }

    private double[] getArrayForCosinesX(boolean r100, int r101, int r102) {
        if (r100 == false) goto L4;
        int r103 = r101 * r102;
        double[] r104 = new double[r103];
        this.cacheCosinesX.put(r103, r104);
        return r104;
    L4:
        double[] r105 = this.cacheCosinesX.get(r101 * r102);
        if (r105 != null) goto L10;
        return null;
    L10:
        return r105;
    }

    private double[] getArrayForCosinesY(boolean r100, int r101, int r102) {
        if (r100 == false) goto L4;
        int r103 = r101 * r102;
        double[] r104 = new double[r103];
        this.cacheCosinesY.put(r103, r104);
        return r104;
    L4:
        double[] r105 = this.cacheCosinesY.get(r101 * r102);
        if (r105 != null) goto L10;
        return null;
    L10:
        return r105;
    }

    public Bitmap decode(String r110, int r111, int r112, float r113, boolean r114) {
        if (r110 != null) goto L5;
    L18:
        return null;
    L5:
        if (r110.length() < 6) goto L18;
        int r100 = 0;
        int r101 = decode83(r110, 0, 1);
        int r102 = (r101 % 9) + 1;
        int r103 = (r101 / 9) + 1;
        if (r110.length() == (((r102 * 2) * r103) + 4)) goto L10;
        return null;
    L10:
        float r104 = (decode83(r110, 1, 2) + 1) / 166.0f;
        int r105 = r102 * r103;
        float[][] r106 = new float[r105][];
    L11:
        if (r100 >= r105) goto L17;
        if (r100 != 0) goto L14;
        r106[r100] = decodeDc(decode83(r110, 2, 6));
    L15:
        r100 = r100 + 1;
        goto L11
    L14:
        int r115 = (r100 * 2) + 4;
        r106[r100] = decodeAc(decode83(r110, r115, r115 + 2), r104 * r113);
        goto L15
    L17:
        return composeBitmap(r111, r112, r102, r103, r106, r114);
    }

    private Bitmap composeBitmap(int r210, int r310, int r311, int r312, float[][] r313, boolean r314) {
        int[] r110 = new int[r210 * r310];
        if (r314 == true) goto L5;
    L8:
        boolean r111 = true;
    L9:
        double[] r112 = getArrayForCosinesX(r111, r210, r311);
        if (r314 == true) goto L12;
    L15:
        boolean r100 = true;
    L16:
        double[] r113 = getArrayForCosinesY(r100, r310, r312);
        if (r112 == null) goto L34;
        if (r113 == null) goto L40;
        int r101 = 0;
    L21:
        if (r101 >= r310) goto L33;
        int r102 = 0;
    L23:
        if (r102 >= r210) goto L31;
        float r103 = 0.0f;
        float r104 = 0.0f;
        float r105 = 0.0f;
        int r106 = 0;
    L25:
        if (r106 >= r312) goto L30;
        float r114 = r103;
        float r115 = r104;
        float r211 = r105;
        int r107 = 0;
    L27:
        if (r107 >= r311) goto L29;
        int r212 = r107;
        int r213 = r106;
        int r214 = r102;
        boolean r215 = r100;
        double r216 = getCos(r112, r111, r212, r311, r214, r210);
        r101 = r101;
        float r108 = (float) (getCos(r113, r215, r213, r312, r101, r310) * r216);
        float[] r109 = r313[(r213 * r311) + r212];
        r114 = r114 + (r109[0] * r108);
        r115 = r115 + (r109[1] * r108);
        r211 = r211 + (r109[2] * r108);
        r107 = r212 + 1;
        r106 = r213;
        r102 = r214;
        r100 = r215;
        goto L27
    L29:
        r106 = r106 + 1;
        r103 = r114;
        r104 = r115;
        r105 = r211;
        goto L25
    L30:
        int r217 = r102;
        r110[r217 + (r210 * r101)] = Color.rgb(linearToSrgb(r103), linearToSrgb(r104), linearToSrgb(r105));
        r102 = r217 + 1;
        goto L23
    L31:
        r101 = r101 + 1;
        goto L21
    L33:
        return Bitmap.createBitmap(r110, r210, r310, Bitmap.Config.ARGB_8888);
    L40:
        return null;
    L34:
        return null;
    L12:
        if (this.cacheCosinesY.get(r310 * r312) == null) goto L15;
        r100 = false;
        goto L16
    L5:
        if (this.cacheCosinesX.get(r310 * r312) == null) goto L8;
        r111 = false;
        goto L9
    }

    private double getCos(double[] r100, boolean r101, int r102, int r103, int r104, int r110) {
        if (r101 == false) goto L5;
        r100[(r103 * r104) + r102] = Math.cos(((((double) r104) * 3.141592653589793d) * ((double) r102)) / ((double) r110));
    L5:
        return r100[r102 + (r103 * r104)];
    }
}
