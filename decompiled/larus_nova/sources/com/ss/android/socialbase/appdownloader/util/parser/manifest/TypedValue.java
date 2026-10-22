package com.ss.android.socialbase.appdownloader.util.parser.manifest;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.monitor.cloudmessage.consts.CloudControlInf;

/* JADX INFO: loaded from: classes38.dex */
public class TypedValue {
    public static final int COMPLEX_MANTISSA_MASK = 16777215;
    public static final int COMPLEX_MANTISSA_SHIFT = 8;
    public static final int COMPLEX_RADIX_0p23 = 3;
    public static final int COMPLEX_RADIX_16p7 = 1;
    public static final int COMPLEX_RADIX_23p0 = 0;
    public static final int COMPLEX_RADIX_8p15 = 2;
    public static final int COMPLEX_RADIX_MASK = 3;
    public static final int COMPLEX_RADIX_SHIFT = 4;
    public static final int COMPLEX_UNIT_DIP = 1;
    public static final int COMPLEX_UNIT_FRACTION = 0;
    public static final int COMPLEX_UNIT_FRACTION_PARENT = 1;
    public static final int COMPLEX_UNIT_IN = 4;
    public static final int COMPLEX_UNIT_MASK = 15;
    public static final int COMPLEX_UNIT_MM = 5;
    public static final int COMPLEX_UNIT_PT = 3;
    public static final int COMPLEX_UNIT_PX = 0;
    public static final int COMPLEX_UNIT_SHIFT = 0;
    public static final int COMPLEX_UNIT_SP = 2;
    public static final int DATA_NULL_EMPTY = 1;
    public static final int DATA_NULL_UNDEFINED = 0;
    public static final int DENSITY_DEFAULT = 0;
    public static final int DENSITY_NONE = 65535;
    private static final String[] DIMENSION_UNIT_STRS = null;
    private static final String[] FRACTION_UNIT_STRS = null;
    private static final float MANTISSA_MULT = 0.00390625f;
    private static final float[] RADIX_MULTS = null;
    public static final int TYPE_ATTRIBUTE = 2;
    public static final int TYPE_DIMENSION = 5;
    public static final int TYPE_DYNAMIC_ATTRIBUTE = 8;
    public static final int TYPE_DYNAMIC_REFERENCE = 7;
    public static final int TYPE_FIRST_COLOR_INT = 28;
    public static final int TYPE_FIRST_INT = 16;
    public static final int TYPE_FLOAT = 4;
    public static final int TYPE_FRACTION = 6;
    public static final int TYPE_INT_BOOLEAN = 18;
    public static final int TYPE_INT_COLOR_ARGB4 = 30;
    public static final int TYPE_INT_COLOR_ARGB8 = 28;
    public static final int TYPE_INT_COLOR_RGB4 = 31;
    public static final int TYPE_INT_COLOR_RGB8 = 29;
    public static final int TYPE_INT_DEC = 16;
    public static final int TYPE_INT_HEX = 17;
    public static final int TYPE_LAST_COLOR_INT = 31;
    public static final int TYPE_LAST_INT = 31;
    public static final int TYPE_NULL = 0;
    public static final int TYPE_REFERENCE = 1;
    public static final int TYPE_STRING = 3;
    public int type;

    static {
        RADIX_MULTS = new float[]{0.00390625f, 3.0517578E-5f, 1.1920929E-7f, 4.656613E-10f};
        DIMENSION_UNIT_STRS = new String[]{GXTemplateKey.GAIAX_PX, "dip", CloudControlInf.SP, GXTemplateKey.GAIAX_PT, "in", "mm"};
        FRACTION_UNIT_STRS = new String[]{GXTemplateKey.GAIAX_PE, "%p"};
    }

    public TypedValue() {
    }

    public static float complexToFloat(int r100) {
        return (r100 & (-256)) * RADIX_MULTS[(r100 >> 4) & 3];
    }

    public static String coerceToString(int r100, int r101) {
        if (r100 != 0) goto L5;
        return null;
    L5:
        if (r100 == 1) goto L50;
        if (r100 == 2) goto L48;
        if (r100 == 4) goto L46;
        if (r100 == 5) goto L44;
        if (r100 == 6) goto L42;
        if (r100 == 17) goto L40;
        if (r100 != 18) goto L19;
        if (r101 == 0) goto L37;
        return "true";
    L37:
        return "false";
    L19:
        if (r100 < 28) goto L30;
        if (r100 > 31) goto L30;
        String r102 = String.format("%08x", new Object[]{Integer.valueOf(r101)});
        char[] r103 = r102.toCharArray();
        switch(r100) {
            case 29: goto L26;
            case 30: goto L25;
            case 31: goto L24;
            default: goto L28;
        };
    L24:
        r102 = String.valueOf(r103[2]) + r103[4] + r103[6];
        goto L28
    L25:
        r102 = String.valueOf(r103[0]) + r103[2] + r103[4] + r103[6];
        goto L28
    L26:
        r102 = r102.substring(2);
    L28:
        return "#" + r102;
    L30:
        if (r100 < 16) goto L52;
        if (r100 > 31) goto L53;
        if (r100 == 16) goto L34;
        return null;
    L34:
        return Integer.toString(r101);
    L53:
        return null;
    L52:
        return null;
    L40:
        return String.format("0x%08X", new Object[]{Integer.valueOf(r101)});
    L42:
        return (complexToFloat(r101) * 100.0f) + FRACTION_UNIT_STRS[(r101 >> 0) & 15];
    L44:
        return complexToFloat(r101) + DIMENSION_UNIT_STRS[(r101 >> 0) & 15];
    L46:
        return Float.toString(Float.intBitsToFloat(r101));
    L48:
        return "?" + r101;
    L50:
        return "@" + r101;
    }
}
