package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import com.bytedance.bdlocation.utils.DimLocationCheckUtil;
import com.bytedance.mira.plugin.hook.flipped.Flipped;
import java.lang.reflect.Field;
import java.util.Locale;

/* JADX INFO: loaded from: classes22.dex */
public class FixXiaomiFindTypeIndex {
    private static final String TAG = "FixXiaomiFindTypeIndex";
    private static volatile boolean sInstalled;

    public FixXiaomiFindTypeIndex() {
    }

    private static native boolean nativeInstall();

    private static boolean shouldEnable() {
        if (Build.VERSION.SDK_INT == 36) goto L5;
        return false;
    L5:
        String r100 = Build.MANUFACTURER;
        String r101 = "";
        if (r100 != null) goto L8;
        String r102 = "";
    L9:
        String r103 = Build.BRAND;
        if (r103 == null) goto L14;
        r101 = r103.toLowerCase(Locale.ROOT);
    L14:
        if (r102.contains(DimLocationCheckUtil.XIAOMI) == false) goto L16;
    L21:
        return true;
    L16:
        if (r102.contains("redmi") == true) goto L21;
        if (r101.contains(DimLocationCheckUtil.XIAOMI) == true) goto L21;
        if (r101.contains("redmi") == true) goto L21;
        return false;
    L8:
        r102 = r100.toLowerCase(Locale.ROOT);
        goto L9
    }

    private static Object getDexCacheByReflection(Class<?> r100) {
        Flipped.invokeHiddenApiRestrictions();     // Catch: Throwable -> L8
        HackHelper.init();     // Catch: Throwable -> L8
        Field r101 = HackHelper.getField(Class.class, "dexCache");     // Catch: Throwable -> L8
        if (r101 != null) goto L6;
        return null;
    L6:
        return r101.get(r100);
    L8:
        return null;
    }

    public static boolean installIfNeeded(Context r100) {
        if (shouldEnable() == true) goto L6;
        return false;
    L6:
        if (sInstalled == false) goto L9;
        return true;
    L9:
        monitor-enter(FixXiaomiFindTypeIndex.class);
    L23:
        th = move-exception;
        throw th;
    L11:
        if (sInstalled == false) goto L15;
        monitor-exit(FixXiaomiFindTypeIndex.class);     // Catch: Throwable -> L23
        return true;
    L15:
        if (SysOptimizer.loadOptimizerLibrary(r100) == true) goto L26;
        monitor-exit(FixXiaomiFindTypeIndex.class);     // Catch: Throwable -> L23
        return false;
    L26:
        sInstalled = nativeInstall();     // Catch: Throwable -> L21
        boolean r101 = sInstalled;     // Catch: Throwable -> L21
        monitor-exit(FixXiaomiFindTypeIndex.class);     // Catch: Throwable -> L23
        return r101;
    L22:
        return false;
    }
}
