package com.bytedance.mira.core.res;

import android.content.res.Resources;
import android.util.ArrayMap;
import android.util.LongSparseArray;
import android.util.SparseArray;
import com.bytedance.mira.core.MiraResourcesManager;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.util.FieldUtils;
import com.bytedance.mira.util.MethodUtils;
import com.bytedance.mira.util.OSUtil;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public class ResCacheUtil {
    private static final String TAG = "ResCacheUtil";

    public ResCacheUtil() {
    }

    public static void pruneResourceCaches(Object r100) {
        if (OSUtil.isAndroidLHigher() == false) goto L11;
        Object r101 = FieldUtils.getField(Resources.class, "mTypedArrayPool").get(r100);     // Catch: Throwable -> L8
        Method r102 = MethodUtils.getAccessibleMethod(r101.getClass(), "acquire", new Class[0]);     // Catch: Throwable -> L8
    L5:
        if (r102.invoke(r101, new Object[0]) != null) goto L5;
    L8:
        th = move-exception;
        MiraLogger.w(MiraLogger.TAG_LOAD, "ResCacheUtil pruneResourceCaches acquire failed.", th);
    L11:
        if (OSUtil.isAndroidMHigher() == false) goto L17;
        r100 = FieldUtils.getField(Resources.class, "mResourcesImpl").get(r100);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        MiraLogger.w(MiraLogger.TAG_LOAD, "ResCacheUtil pruneResourceCaches get res.mResourcesImpl failed.", th);
    L17:
        if (OSUtil.isAndroidJ_MR2Higher() == false) goto L47;
        Object r103 = FieldUtils.getField(r100.getClass(), "mAccessLock").get(r100);     // Catch: Throwable -> L20
    L27:
        if (r103 != null) goto L29;
        r103 = MiraResourcesManager.class;
    L29:
        monitor-enter(r103);
        pruneResourceCache(r100, "mDrawableCache");     // Catch: Throwable -> L40
        pruneResourceCache(r100, "mColorDrawableCache");     // Catch: Throwable -> L40
        pruneResourceCache(r100, "mColorStateListCache");     // Catch: Throwable -> L40
        if (OSUtil.isAndroidMOrHigher() == false) goto L34;
        pruneResourceCache(r100, "mAnimatorCache");     // Catch: Throwable -> L40
        pruneResourceCache(r100, "mStateListAnimatorCache");     // Catch: Throwable -> L40
    L34:
        if (r100.getClass().getName().equals("com.huawei.android.content.res.ResourcesEx") == false) goto L36;
    L37:
        pruneResourceCache(r100, "mCacheColorInfoList");     // Catch: Throwable -> L40
        pruneResourceCache(r100, "mDrawableCacheEx");     // Catch: Throwable -> L40
    L38:
        monitor-exit(r103);     // Catch: Throwable -> L40
        return;
    L36:
        if (r100.getClass().getName().equals("android.content.res.ResourcesEx") == false) goto L38;
    L40:
        th = move-exception;
        throw th;
    L20:
        th = move-exception;
        MiraLogger.w(MiraLogger.TAG_LOAD, "ResCacheUtil pruneResourceCaches get res.mAccessLock failed.", th);
    L26:
        r103 = null;
        goto L27
    L47:
        r103 = FieldUtils.getField(Resources.class, "mTmpValue").get(r100);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        MiraLogger.w(MiraLogger.TAG_LOAD, "ResCacheUtil pruneResourceCaches get res.mTmpValue failed.", th);
        goto L26
    }

    private static boolean pruneResourceCache(Object r100, String r110) {
        Field r101 = FieldUtils.getField(r100.getClass(), r110);     // Catch: Throwable -> L44
        if (r101 != null) goto L6;
        r101 = FieldUtils.getField(Resources.class, r110);     // Catch: Throwable -> L44
    L6:
        Object r102 = r101.get(r100);     // Catch: Throwable -> L44
        Class<?> r103 = r101.getType();     // Catch: Throwable -> L44
        if (OSUtil.isAndroidJLower() == false) goto L19;
        if ((r102 instanceof SparseArray) == false) goto L13;
        ((SparseArray) r102).clear();     // Catch: Throwable -> L44
        return true;
    L13:
        if (OSUtil.isAndroidIHigher() == true) goto L15;
    L46:
        return false;
    L15:
        if ((r102 instanceof LongSparseArray) == false) goto L46;
        ((LongSparseArray) r102).clear();     // Catch: Throwable -> L44
        return true;
    L19:
        if (OSUtil.isAndroidMLower() == true) goto L21;
    L38:
        if (r103 == null) goto L46;
        MethodUtils.getAccessibleMethod(r103, "onConfigurationChange", new Class[]{Integer.TYPE}).invoke(r102, new Object[]{-1});     // Catch: Throwable -> L41
    L40:
        return true;
    L41:
        th = move-exception;
        MiraLogger.w(MiraLogger.TAG_LOAD, "ResCacheUtil pruneResourceCache onConfigurationChange failed.", th);     // Catch: Throwable -> L44
        r103 = r103.getSuperclass();     // Catch: Throwable -> L44
        goto L38
    L21:
        if ("mColorStateListCache".equals(r110) == false) goto L27;
        if ((r102 instanceof LongSparseArray) == false) goto L46;
        ((LongSparseArray) r102).clear();     // Catch: Throwable -> L44
        return true;
    L27:
        if (r103.isAssignableFrom(ArrayMap.class) == false) goto L31;
        MethodUtils.getAccessibleMethod(Resources.class, "clearDrawableCachesLocked", new Class[]{ArrayMap.class, Integer.TYPE}).invoke(r100, new Object[]{r102, -1});     // Catch: Throwable -> L44
        return true;
    L31:
        if (r103.isAssignableFrom(LongSparseArray.class) == false) goto L35;
        MethodUtils.getAccessibleMethod(Resources.class, "clearDrawableCacheLocked", new Class[]{LongSparseArray.class, Integer.TYPE}).invoke(r100, new Object[]{r102, -1});     // Catch: Throwable -> L44
        return true;
    L35:
        if ((r102 instanceof Map) == false) goto L46;
        ((Map) r102).clear();     // Catch: Throwable -> L44
        return true;
    L44:
        th = move-exception;
        MiraLogger.w(MiraLogger.TAG_LOAD, "ResCacheUtil pruneResourceCache failed.", th);
        goto L46
    }
}
