package com.bytedance.ugc.glue;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import androidx.camera.video.AudioStats;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import ep7.a;

/* JADX INFO: loaded from: classes22.dex */
public class UGCTools {
    public static final Handler mainHandler = null;

    public UGCTools() {
    }

    public static int round(double r100) {
        return (int) (r100 + 0.5d);
    }

    static {
        mainHandler = new Handler(Looper.getMainLooper());
    }

    public static boolean isTest() {
        int r100 = a.f473437a;
        return false;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_ugc_glue_UGCTools_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static String firstNotEmptyString(String... r100) {
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L8;
        String r103 = r100[r102];
        if (notEmpty(r103) == true) goto L6;
        r102 = r102 + 1;
        goto L3
    L6:
        return r103;
    L8:
        return null;
    }

    public static byte[] getBytes(String r100) {
        if (r100 == null) goto L6;
        return r100.getBytes("UTF-8");
    L6:
        return new byte[0];
    }

    public static int getColor(int r100) {
        int r101 = a.f473437a;
        return getColor(null, r100);
    }

    public static <T> T getDefaultValue(Class<T> r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        if (r100.isAssignableFrom(String.class) == false) goto L8;
        return "";
    L8:
        if (r100.isAssignableFrom(Integer.class) == true) goto L38;
        if (r100.isAssignableFrom(Integer.TYPE) == true) goto L38;
        if (r100.isAssignableFrom(Short.class) == true) goto L38;
        if (r100.isAssignableFrom(Short.TYPE) == true) goto L38;
        if (r100.isAssignableFrom(Long.class) == true) goto L44;
        if (r100.isAssignableFrom(Long.TYPE) == true) goto L44;
        if (r100.isAssignableFrom(Float.class) == true) goto L43;
        if (r100.isAssignableFrom(Float.TYPE) == true) goto L43;
        if (r100.isAssignableFrom(Double.class) == true) goto L42;
        if (r100.isAssignableFrom(Double.TYPE) == true) goto L42;
        if (r100.isAssignableFrom(Boolean.class) == true) goto L41;
        return "";
    L41:
        return (T) Boolean.FALSE;
    L42:
        return (T) Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
    L43:
        return (T) Float.valueOf(0.0f);
    L44:
        return (T) 0L;
    L38:
        return (T) 0;
    }

    public static Drawable getDrawable(int r100) {
        int r101 = a.f473437a;
        return getDrawable(null, r100);
    }

    public static int getPixelByDp(int r100) {
        return (int) (getPixelByDp(r100) + 0.5f);
    }

    public static int getPixelBySp(int r100) {
        return (int) (getPixelBySp(r100) + 0.5f);
    }

    public static int getPxByDp(float r100) {
        return round(getPxFByDp(r100));
    }

    public static int getPxBySp(float r100) {
        return round(getPxFBySp(r100));
    }

    public static float getPxFByDp(float r100) {
        int r101 = a.f473437a;
        return r100 * 2.0f;
    }

    public static float getPxFBySp(float r100) {
        int r101 = a.f473437a;
        return r100 * 2.0f;
    }

    public static boolean isEmpty(CharSequence r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (r100.length() == 0) goto L7;
        return false;
    }

    public static int mergeFlag(int... r100) {
        int r101 = 0;
        if (r100 == null) goto L10;
        int r102 = r100.length;
        int r103 = 0;
    L5:
        if (r101 >= r102) goto L8;
        r103 = r103 | r100[r101];
        r101 = r101 + 1;
        goto L5
    L8:
        return r103;
    L10:
        return 0;
    }

    public static boolean notEmpty(CharSequence r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.length() <= 0) goto L6;
        return true;
    }

    public static boolean parseBoolean(String r100) {
        if ("1".equals(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if ("true".equalsIgnoreCase(r100) == true) goto L8;
        return false;
    }

    public static double parseDouble(String r100) {
        return parseDouble(r100, AudioStats.AUDIO_AMPLITUDE_NONE);
    }

    public static int parseInt(String r100) {
        return parseInt(r100, 0);
    }

    public static long parseLong(String r100) {
        return parseLong(r100, 0);
    }

    public static float getPixelByDp(float r100) {
        return getPxFByDp(r100);
    }

    public static float getPixelBySp(float r100) {
        return getPxFBySp(r100);
    }

    public static boolean equal(CharSequence r100, CharSequence r101) {
        if (isEmpty(r100) == true) goto L5;
    L6:
        if (r100 != null) goto L8;
    L10:
        return false;
    L8:
        if (r100.equals(r101) == false) goto L10;
    L9:
        return true;
    L5:
        if (isEmpty(r101) == true) goto L9;
        goto L6
    }

    public static int getColor(Context r100, int r101) {
        if (r100 != null) goto L4;
        return 0;
    L4:
        return r100.getResources().getColor(r101);
    }

    public static Drawable getDrawable(Context r100, int r101) {
        if (r100 != null) goto L4;
        return null;
    L4:
        return r100.getResources().getDrawable(r101);
    }

    public static String getString(int r100, Object... r101) {
        int r102 = a.f473437a;
        return getString(null, r100, r101);
    }

    public static double parseDouble(String r100, double r101) {
        return CastDoubleProtector.parseDouble(r100);
    L4:
        return r101;
    }

    public static int parseInt(String r100, int r101) {
        return CastIntegerProtector.parseInt(r100);
    L5:
        return round(parseDouble(r100, r101));
    }

    public static long parseLong(String r100, long r101) {
        return CastLongProtector.parseLong(r100);
    L5:
        return round(parseDouble(r100, r101));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.String] */
    public static <T> T get(Bundle r100, String r101, T r102) {
        if (r100 != null) goto L4;
        return r102;
    L4:
        Object r103 = r100.get(r101);
        if (r103 != null) goto L7;
        return r102;
    L7:
        ?? r104 = (T) String.valueOf(r103);
        if ((r102 instanceof String) == false) goto L11;
        return r104;
    L11:
        if ((r102 instanceof Integer) == false) goto L14;
        return (T) Integer.valueOf(parseInt(r104, ((Integer) r102).intValue()));
    L14:
        if ((r102 instanceof Short) == false) goto L17;
        return (T) Integer.valueOf(parseInt(r104, ((Short) r102).shortValue()));
    L17:
        if ((r102 instanceof Long) == false) goto L20;
        return (T) Long.valueOf(parseLong(r104, ((Long) r102).longValue()));
    L20:
        if ((r102 instanceof Double) == false) goto L23;
        return (T) Double.valueOf(parseDouble(r104, ((Double) r102).doubleValue()));
    L23:
        if ((r102 instanceof Float) == true) goto L25;
        return r104;
    L25:
        return (T) Double.valueOf(parseDouble(r104, ((Float) r102).floatValue()));
    }

    public static String getString(Context r100, int r101, Object... r102) {
        if (r100 != null) goto L4;
        return "";
    L4:
        return r100.getString(r101, r102);
    }

    public static <T> T get(Activity r100, String r101, T r102) {
        if (r100 != null) goto L5;
        return r102;
    L5:
        return (T) get(r100.getIntent(), r101, r102);
    }

    public static <T> T get(Intent r100, String r101, T r102) {
        if (r100 != null) goto L5;
        return r102;
    L5:
        return (T) get(r100.getExtras(), r101, r102);
    }

    public static <T> T get(Activity r100, String r101, Class<T> r102) {
        return (T) get(r100, r101, getDefaultValue(r102));
    }

    public static <T> T get(Intent r100, String r101, Class<T> r102) {
        return (T) get(r100, r101, getDefaultValue(r102));
    }

    public static <T> T get(Bundle r100, String r101, Class<T> r102) {
        return (T) get(r100, r101, getDefaultValue(r102));
    }
}
