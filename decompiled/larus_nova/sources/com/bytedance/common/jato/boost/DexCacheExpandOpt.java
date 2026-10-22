package com.bytedance.common.jato.boost;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.common.jato.JatoNativeLoader;
import com.bytedance.sysoptimizer.SmEditTextLeakOpt;

/* JADX INFO: loaded from: classes15.dex */
public class DexCacheExpandOpt {
    private static volatile boolean hasExpand;

    public DexCacheExpandOpt() {
    }

    public static native void checkHitExpand();

    private static native boolean disableExpandInner(ClassLoader r100);

    private static native boolean expandInner(ClassLoader r100, int r101, int r102, int r103, int r104);

    public static native void reclaim();

    public static boolean disableExpand() {
        if (hasExpand == true) goto L6;
        return true;
    L6:
        hasExpand = false;
        return disableExpandInner(DexCacheExpandOpt.class.getClassLoader());
    }

    private static String getVendorModel() {
        String r100 = Build.BRAND;
        String r101 = Build.MODEL;
        if (TextUtils.isEmpty(r101) == true) goto L5;
        if (r100 != null) goto L10;
    L13:
        return r101;
    L10:
        if (r101.contains(r100) == true) goto L13;
        return r100 + " " + r101;
    L5:
        if (TextUtils.isEmpty(r100) == false) goto L14;
        return "unknown";
    L14:
        return r100;
    }

    static {
        JatoNativeLoader.loadLibrary();
    }

    public static boolean expand(int r100) {
        if (r100 > 1024) goto L5;
    L9:
        return false;
    L5:
        if (hasExpand == true) goto L9;
        hasExpand = true;
        return expandInner(DexCacheExpandOpt.class.getClassLoader(), r100, 0, 0, 0);
    }

    public static boolean expand(int r100, int r101, int r102, int r103) {
        String r104 = getVendorModel();
        int r105 = 0;
        if (r104 != null) goto L5;
        return false;
    L5:
        String r106 = r104.toLowerCase();
        if (r106.contains("aosp") == false) goto L9;
        return false;
    L9:
        if (hasExpand == false) goto L12;
        return false;
    L12:
        if (r100 > 1024) goto L14;
        r100 = 0;
    L14:
        if (r101 > 1024) goto L16;
        r101 = 0;
    L16:
        if (r102 > 1024) goto L18;
        r102 = 0;
    L18:
        if (r103 > 1024) goto L20;
        r103 = 0;
    L20:
        if (r100 != 0) goto L25;
        if (r101 != 0) goto L25;
        if (r102 != 0) goto L25;
        if (r103 != 0) goto L25;
        return false;
    L25:
        if (r101 > 0) goto L27;
    L29:
        r105 = r101;
    L30:
        hasExpand = true;
        return expandInner(DexCacheExpandOpt.class.getClassLoader(), r100, r105, r102, r103);
    L27:
        if (r106.contains(SmEditTextLeakOpt.SAMSUNG) == false) goto L29;
        goto L29
    }
}
