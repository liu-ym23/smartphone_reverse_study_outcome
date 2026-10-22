package com.ss.texturerender.math;

/* JADX INFO: loaded from: classes40.dex */
public class ColorConversion {
    public static float[] matrix_BT2020_10bit_yuv_to_rgb_full;
    public static float[] matrix_BT2020_10bit_yuv_to_rgb_limite;
    public static float[] matrix_BT2020_8bit_yuv_to_rgb_full;
    public static float[] matrix_BT2020_8bit_yuv_to_rgb_limite;
    public static float[] matrix_Rec601_yuv_to_rgb_full;
    public static float[] matrix_Rec601_yuv_to_rgb_limit;
    public static float[] matrix_Rec709_yuv_to_rgb_full;
    public static float[] matrix_Rec709_yuv_to_rgb_limit;
    public static float[] offset_full;
    public static float[] offset_limite_10bit;
    public static float[] offset_limite_8bit;
    public float[] matrix;
    public float[] offset;

    static {
        matrix_Rec601_yuv_to_rgb_full = new float[]{1.0f, -0.0f, 1.402f, 1.0f, -0.344136f, -0.714136f, 1.0f, 1.772f, 0.0f};
        matrix_Rec601_yuv_to_rgb_limit = new float[]{1.164384f, -0.0f, 1.596027f, 1.164384f, -0.391762f, -0.812968f, 1.164384f, 2.017232f, 0.0f};
        matrix_Rec709_yuv_to_rgb_full = new float[]{1.0f, -0.0f, 1.5748f, 1.0f, -0.187324f, -0.468124f, 1.0f, 1.8556f, -0.0f};
        matrix_Rec709_yuv_to_rgb_limit = new float[]{1.164384f, -0.0f, 1.792741f, 1.164384f, -0.213249f, -0.532909f, 1.164384f, 2.112402f, -0.0f};
        matrix_BT2020_8bit_yuv_to_rgb_full = new float[]{1.0f, -0.0f, 1.4746f, 1.0f, -0.164553f, -0.571353f, 1.0f, 1.8814f, -0.0f};
        matrix_BT2020_8bit_yuv_to_rgb_limite = new float[]{1.164384f, -0.0f, 1.678674f, 1.164384f, -0.187326f, -0.650424f, 1.164384f, 2.141772f, -0.0f};
        matrix_BT2020_10bit_yuv_to_rgb_full = new float[]{1.0f, -0.0f, 1.4746f, 1.0f, -0.164553f, -0.571353f, 1.0f, 1.8814f, -0.0f};
        matrix_BT2020_10bit_yuv_to_rgb_limite = new float[]{1.167808f, -0.0f, 1.683611f, 1.167808f, -0.187877f, -0.652337f, 1.167808f, 2.148072f, -0.0f};
        offset_limite_8bit = new float[]{-0.062745f, -0.5f, -0.5f};
        offset_limite_10bit = new float[]{-0.06256109f, -0.5f, -0.5f};
        offset_full = new float[]{0.0f, -0.5f, -0.5f};
    }

    public ColorConversion(float[] r100, float[] r101) {
        this.matrix = r100;
        this.offset = r101;
    }

    public static ColorConversion getFromDataspace(int r100, int r101) {
        int r102 = r100 & 3;
        int r103 = (r100 >> 2) & 63;
        if (r102 == 0) goto L41;
        if (r103 == 2) goto L41;
        if (r103 == 0) goto L41;
        ColorConversion r104 = new ColorConversion(null, null);
        if (r102 != 2) goto L10;
        r104.offset = offset_full;
    L15:
        if (r103 != 5) goto L17;
    L36:
        if (r102 != 2) goto L38;
        float[] r105 = matrix_Rec601_yuv_to_rgb_full;
    L39:
        r104.matrix = r105;
    L40:
        return r104;
    L38:
        r105 = matrix_Rec601_yuv_to_rgb_limit;
        goto L39
    L17:
        if (r103 == 6) goto L36;
        if (r103 != 9) goto L22;
    L28:
        if (r102 != 2) goto L32;
        if (r101 != 8) goto L31;
        float[] r106 = matrix_BT2020_8bit_yuv_to_rgb_full;
    L35:
        r104.matrix = r106;
        goto L40
    L31:
        r106 = matrix_BT2020_10bit_yuv_to_rgb_full;
        goto L35
    L32:
        if (r101 != 8) goto L34;
        r106 = matrix_BT2020_8bit_yuv_to_rgb_limite;
        goto L35
    L34:
        r106 = matrix_BT2020_10bit_yuv_to_rgb_limite;
        goto L35
    L22:
        if (r103 == 10) goto L28;
        if (r102 != 2) goto L26;
        float[] r107 = matrix_Rec709_yuv_to_rgb_full;
    L27:
        r104.matrix = r107;
        goto L40
    L26:
        r107 = matrix_Rec709_yuv_to_rgb_limit;
        goto L27
    L10:
        if (r101 != 8) goto L12;
        float[] r108 = offset_limite_8bit;
    L13:
        r104.offset = r108;
        goto L15
    L12:
        r108 = offset_limite_10bit;
    L41:
        return null;
    }
}
