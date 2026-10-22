package com.lynx.tasm.base;

import android.os.Trace;
import com.bytedance.android.livehostapi.business.IHostShare;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: classes32.dex */
public class TraceEvent {
    public static final long CATEGORY_DEFAULT = 0;
    public static final long CATEGORY_FPS = 3;
    public static final long CATEGORY_SCREENSHOTS = 2;
    public static final long CATEGORY_VITALS = 1;
    public static final String DEFAULT_INSTANT_COLOR = "#FF0000";
    public static final String[] defualt_categories = null;
    private static boolean sDebugModeEnabled;
    private static boolean sPerfettoTraceEnabled;
    private static boolean sSystemTraceEnabled;
    private static boolean sTraceEnvInited;

    public TraceEvent() {
    }

    private static native void nativeBeginSection(String r100, String r101);

    private static native void nativeBeginSectionWithProps(String r100, String r101, Map<String, String> r102);

    private static native boolean nativeCategoryEnabled(String r100);

    private static native void nativeCounter(String r100, String r101, long r102);

    private static native void nativeEndSection(String r100, String r101);

    private static native void nativeEndSectionWithProps(String r100, String r101, Map<String, String> r102);

    private static native void nativeInstant(String r100, String r101, long r102, String r103);

    private static native void nativeInstantWithProps(String r100, String r101, long r102, Map<String, String> r103);

    private static native boolean nativePerfettoTraceEnabled();

    private static native boolean nativeSystemTraceEnabled();

    public static boolean registerTraceBackend(long r100) {
        return false;
    }

    static {
        defualt_categories = new String[]{"lynx", "vitals", IHostShare.ShareType.SCREENSHOT, "fps"};
        sTraceEnvInited = false;
        sDebugModeEnabled = false;
        sPerfettoTraceEnabled = false;
        sSystemTraceEnabled = false;
    }

    public static boolean enablePerfettoTrace() {
        if (sPerfettoTraceEnabled == true) goto L8;
        if (sTraceEnvInited == false) goto L8;
        sPerfettoTraceEnabled = nativePerfettoTraceEnabled();
    L8:
        return sPerfettoTraceEnabled;
    }

    public static boolean enableSystemTrace() {
        if (sSystemTraceEnabled == true) goto L8;
        if (sTraceEnvInited == false) goto L8;
        sSystemTraceEnabled = nativeSystemTraceEnabled();
    L8:
        return sSystemTraceEnabled;
    }

    public static boolean enableTrace() {
        if (sDebugModeEnabled == false) goto L5;
        return true;
    L5:
        return false;
    }

    private static String getRandomColor() {
        if (enableTrace() == true) goto L5;
    L13:
        return DEFAULT_INSTANT_COLOR;
    L5:
        if (isTracingStarted() == false) goto L13;
        StringBuilder r100 = new StringBuilder();     // Catch: Exception -> L14
        r100.append('#');     // Catch: Exception -> L14
        int r101 = 0;
    L9:
        if (r101 >= 6) goto L11;
        r100.append(Integer.toHexString(new Random().nextInt(16)));     // Catch: Exception -> L14
        r101 = r101 + 1;     // Catch: Exception -> L14
        goto L9
    L11:
        return r100.toString().toUpperCase();
    }

    public static boolean isTracingStarted() {
        return TraceController.isTracingStarted();
    }

    public static void beginSection(String r100) {
        beginSection(0, r100);
    }

    public static boolean categoryEnabled(String r100) {
        if (enableTrace() == true) goto L6;
        return false;
    L6:
        if (enablePerfettoTrace() == false) goto L14;
        if (isTracingStarted() == true) goto L10;
        return false;
    L10:
        if (nativeCategoryEnabled(r100) == false) goto L16;
        return true;
    L16:
        return false;
    L14:
        return nativeCategoryEnabled(r100);
    }

    public static void endSection(String r100) {
        endSection(0, r100);
    }

    public static void markTraceDebugMode(boolean r100) {
        sDebugModeEnabled = r100;
    }

    public static void markTraceEnvInited(boolean r100) {
        sTraceEnvInited = r100;
    }

    public static boolean categoryEnabled(long r100) {
        return categoryEnabled(defualt_categories[(int) r100]);
    }

    public static void beginSection(String r100, String r101) {
        if (enableTrace() == true) goto L6;
        return;
    L6:
        if (enablePerfettoTrace() == false) goto L11;
        if (isTracingStarted() == false) goto L11;
        nativeBeginSection(r100, r101);
        return;
    L11:
        if (enableSystemTrace() == false) goto L15;
        Trace.beginSection(r101);
        return;
    }

    public static void endSection(String r100, String r101) {
        if (enableTrace() == true) goto L6;
        return;
    L6:
        if (enablePerfettoTrace() == false) goto L11;
        if (isTracingStarted() == false) goto L11;
        nativeEndSection(r100, r101);
        return;
    L11:
        if (enableSystemTrace() == false) goto L15;
        Trace.endSection();
        return;
    }

    public static void instant(long r100, String r101) {
        instant(defualt_categories[(int) r100], r101, System.nanoTime() / 1000);
    }

    public static void beginSection(long r100, String r101) {
        beginSection(defualt_categories[(int) r100], r101);
    }

    public static void endSection(long r100, String r101) {
        endSection(defualt_categories[(int) r100], r101);
    }

    public static void instant(String r100, String r101) {
        instant(r100, r101, System.nanoTime() / 1000);
    }

    public static void beginSection(String r100, Map<String, String> r101) {
        beginSection(0, r100, r101);
    }

    public static void beginSection(String r100, String r101, Map<String, String> r102) {
        if (enableTrace() == true) goto L6;
        return;
    L6:
        if (enablePerfettoTrace() == false) goto L11;
        if (isTracingStarted() == false) goto L11;
        nativeBeginSectionWithProps(r100, r101, r102);
        return;
    L11:
        if (enableSystemTrace() == false) goto L15;
        Trace.beginSection(r101);
        return;
    }

    public static void counter(String r100, String r101, long r102) {
        if (enableTrace() == true) goto L5;
        return;
    L5:
        if (isTracingStarted() == false) goto L9;
        nativeCounter(r100, r101, r102);
        return;
    }

    public static void endSection(String r100, String r101, Map<String, String> r102) {
        if (enableTrace() == true) goto L6;
        return;
    L6:
        if (enablePerfettoTrace() == false) goto L11;
        if (isTracingStarted() == false) goto L11;
        nativeEndSectionWithProps(r100, r101, r102);
        return;
    L11:
        if (enableSystemTrace() == false) goto L15;
        Trace.endSection();
        return;
    }

    public static void instant(String r100, String r101, Map<String, String> r102) {
        if (enableTrace() == true) goto L6;
        return;
    L6:
        if (enablePerfettoTrace() == false) goto L11;
        if (isTracingStarted() == false) goto L11;
        nativeInstantWithProps(r100, r101, System.nanoTime() / 1000, r102);
        return;
    L11:
        if (enableSystemTrace() == false) goto L15;
        Trace.beginSection(r101);
        Trace.endSection();
        return;
    }

    public static void beginSection(long r100, String r101, Map<String, String> r102) {
        beginSection(defualt_categories[(int) r100], r101, r102);
    }

    public static void counter(long r100, String r101, long r102) {
        counter(defualt_categories[(int) r100], r101, r102);
    }

    public static void endSection(long r100, String r101, Map<String, String> r102) {
        endSection(defualt_categories[(int) r100], r101, r102);
    }

    public static void instant(long r100, String r101, String r102) {
        instant(defualt_categories[(int) r100], r101, System.nanoTime() / 1000, r102);
    }

    public static void instant(long r100, String r101, long r102) {
        instant(defualt_categories[(int) r100], r101, r102, getRandomColor());
    }

    public static void instant(String r100, String r101, String r102) {
        instant(r100, r101, System.nanoTime() / 1000, r102);
    }

    public static void instant(long r100, String r101, Map<String, String> r102) {
        instant(defualt_categories[(int) r100], r101, r102);
    }

    public static void instant(String r100, String r101, long r102) {
        instant(r100, r101, r102, getRandomColor());
    }

    public static void instant(String r100, String r101, long r102, Map<String, String> r103) {
        if (enableTrace() == true) goto L6;
        return;
    L6:
        if (enablePerfettoTrace() == false) goto L15;
        if (isTracingStarted() == false) goto L15;
        if (r102 > 0) goto L13;
        r102 = System.nanoTime() / 1000;
    L13:
        nativeInstantWithProps(r100, r101, r102, r103);
        return;
    L15:
        if (enableSystemTrace() == false) goto L19;
        Trace.beginSection(r101);
        Trace.endSection();
        return;
    }

    private static void instant(String r100, String r101, long r102, String r103) {
        if (enableTrace() == true) goto L6;
        return;
    L6:
        if (enablePerfettoTrace() == false) goto L11;
        if (isTracingStarted() == false) goto L11;
        nativeInstant(r100, r101, r102, r103);
        return;
    L11:
        if (enableSystemTrace() == false) goto L15;
        Trace.beginSection(r101);
        Trace.endSection();
        return;
    }
}
