package org.apache.commons.lang3.math;

import androidx.camera.video.AudioStats;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;

/* JADX INFO: loaded from: classes42.dex */
public class NumberUtils {
    public static final Byte BYTE_MINUS_ONE = null;
    public static final Byte BYTE_ONE = null;
    public static final Byte BYTE_ZERO = null;
    public static final Double DOUBLE_MINUS_ONE = null;
    public static final Double DOUBLE_ONE = null;
    public static final Double DOUBLE_ZERO = null;
    public static final Float FLOAT_MINUS_ONE = null;
    public static final Float FLOAT_ONE = null;
    public static final Float FLOAT_ZERO = null;
    public static final Integer INTEGER_MINUS_ONE = null;
    public static final Integer INTEGER_ONE = null;
    public static final Integer INTEGER_TWO = null;
    public static final Integer INTEGER_ZERO = null;
    public static final Long LONG_MINUS_ONE = null;
    public static final Long LONG_ONE = null;
    public static final Long LONG_ZERO = null;
    public static final Short SHORT_MINUS_ONE = null;
    public static final Short SHORT_ONE = null;
    public static final Short SHORT_ZERO = null;

    public static int compare(byte r100, byte r101) {
        return r100 - r101;
    }

    public static int compare(int r100, int r101) {
        if (r100 != r101) goto L5;
        return 0;
    L5:
        if (r100 >= r101) goto L7;
        return -1;
    L7:
        return 1;
    }

    public static int compare(long r100, long r101) {
        if (r100 != r101) goto L6;
        return 0;
    L6:
        if (r100 >= r101) goto L8;
        return -1;
    L8:
        return 1;
    }

    public static int compare(short r100, short r101) {
        if (r100 != r101) goto L5;
        return 0;
    L5:
        if (r100 >= r101) goto L7;
        return -1;
    L7:
        return 1;
    }

    static {
        LONG_ZERO = 0L;
        LONG_ONE = 1L;
        LONG_MINUS_ONE = -1L;
        INTEGER_ZERO = 0;
        INTEGER_ONE = 1;
        INTEGER_TWO = 2;
        INTEGER_MINUS_ONE = -1;
        SHORT_ZERO = 0;
        SHORT_ONE = 1;
        SHORT_MINUS_ONE = -1;
        BYTE_ZERO = (byte) 0;
        BYTE_ONE = (byte) 1;
        BYTE_MINUS_ONE = (byte) -1;
        DOUBLE_ZERO = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
        DOUBLE_ONE = Double.valueOf(1.0d);
        DOUBLE_MINUS_ONE = Double.valueOf(-1.0d);
        FLOAT_ZERO = Float.valueOf(0.0f);
        FLOAT_ONE = Float.valueOf(1.0f);
        FLOAT_MINUS_ONE = Float.valueOf(-1.0f);
    }

    public static float toFloat(String r100, float r101) {
        if (r100 != null) goto L7;
        return r101;
    L7:
        return CastFloatProtector.parseFloat(r100);
    L6:
        return r101;
    }
}
