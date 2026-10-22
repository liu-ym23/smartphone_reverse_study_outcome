package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes22.dex */
public class GetThreadTraceOptimizer {
    private static final StackTraceElement[] FALLBACK_STACK_TRACE = null;
    private static final String TAG = "GetThreadTraceOptimizer";
    private static volatile boolean sInstalled;

    public static final class FixPair {
        public final String brand;
        public final String filterKeyword;
        public final int maxOsVersion;
        public final int minOsVersion;

        private FixPair() {
            this.brand = null;
            this.minOsVersion = 0;
            this.maxOsVersion = 0;
            this.filterKeyword = null;
        }

        public FixPair(String r100, int r101, int r102, String r103) {
            this.brand = r100;
            this.minOsVersion = r101;
            this.maxOsVersion = r102;
            this.filterKeyword = r103;
        }
    }

    static {
        FALLBACK_STACK_TRACE = new StackTraceElement[]{new StackTraceElement(TAG, "optimize", "GetThreadTraceOptimizer.java", 66)};
        sInstalled = false;
    }

    public GetThreadTraceOptimizer() {
    }

    private static native boolean nativeInstall(String r100, StackTraceElement[] r101);

    private static String matchFilterKeyword(ArrayList<FixPair> r100) {
        if (r100 != null) goto L5;
    L41:
        return null;
    L5:
        if (r100.isEmpty() == true) goto L41;
        int r101 = Build.VERSION.SDK_INT;
        String r102 = Build.BRAND;
        String r103 = "";
        if (r102 != null) goto L10;
        String r104 = "";
    L11:
        String r105 = Build.MANUFACTURER;
        if (r105 == null) goto L15;
        r103 = r105.toLowerCase(Locale.ROOT);
    L15:
        Iterator<FixPair> r106 = r100.iterator();
    L17:
        if (r106.hasNext() == false) goto L41;
        FixPair r107 = r106.next();
        if (r107 == null) goto L17;
        if (TextUtils.isEmpty(r107.brand) == true) goto L17;
        if (TextUtils.isEmpty(r107.filterKeyword) == true) goto L17;
        String r108 = r107.brand.toLowerCase(Locale.ROOT);
        boolean r109 = false;
        if (r104.contains(r108) == false) goto L28;
    L31:
        boolean r110 = true;
    L33:
        if (r101 >= r107.minOsVersion) goto L35;
    L37:
        if (r110 == false) goto L17;
        if (r109 == false) goto L17;
        return r107.filterKeyword;
    L35:
        if (r101 > r107.maxOsVersion) goto L37;
        r109 = true;
        goto L37
    L28:
        if (r103.contains(r108) == true) goto L31;
        r110 = false;
        goto L33
    L10:
        r104 = r102.toLowerCase(Locale.ROOT);
        goto L11
    }

    public static boolean installIfNeeded(Context r100, ArrayList<FixPair> r101) {
        String r102 = matchFilterKeyword(r101);
        if (TextUtils.isEmpty(r102) == false) goto L6;
        return false;
    L6:
        if (sInstalled == false) goto L9;
        return true;
    L9:
        monitor-enter(GetThreadTraceOptimizer.class);
    L23:
        th = move-exception;
        throw th;
    L11:
        if (sInstalled == false) goto L15;
        monitor-exit(GetThreadTraceOptimizer.class);     // Catch: Throwable -> L23
        return true;
    L15:
        if (SysOptimizer.loadOptimizerLibrary(r100) == true) goto L27;
        monitor-exit(GetThreadTraceOptimizer.class);     // Catch: Throwable -> L23
        return false;
    L27:
        boolean r103 = nativeInstall(r102, FALLBACK_STACK_TRACE);     // Catch: Throwable -> L21
        sInstalled = r103;     // Catch: Throwable -> L21
        monitor-exit(GetThreadTraceOptimizer.class);     // Catch: Throwable -> L23
        return r103;
    L22:
        return false;
    }
}
