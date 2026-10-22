package com.ss.android.vesdk.filterparam;

/* JADX INFO: loaded from: classes40.dex */
public class HslParam {
    public static final int VEHSLColorType_BLUE = 5;
    public static final int VEHSLColorType_CYAN = 4;
    public static final int VEHSLColorType_GREEN = 3;
    public static final int VEHSLColorType_MAGENTA = 7;
    public static final int VEHSLColorType_ORANGE = 1;
    public static final int VEHSLColorType_PURPLE = 6;
    public static final int VEHSLColorType_RED = 0;
    public static final int VEHSLColorType_YELLOW = 2;
    public int colorType;
    public int[] hslValue;

    public HslParam() {
        this.colorType = 0;
        this.hslValue = new int[]{0, 0, 0};
    }

    public int getColorType() {
        return this.colorType;
    }

    public int[] getHslValue() {
        return this.hslValue;
    }

    public void setColorType(int r100) {
        this.colorType = r100;
    }

    public void setHsl(int[] r100) {
        this.hslValue = r100;
    }
}
