package com.bytedance.caijing.sdk.infra.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.os.IBinder;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes15.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f202785a = 0;

    static {
    }

    public static Object a(Object r100) {
    L13:
        return b(r100);
    L5:
        e = move-exception;
        int r101 = com.bytedance.caijing.sdk.infra.base.logger.a.f202761a;
        com.bytedance.caijing.sdk.infra.base.logger.a.e("CJReferrerUtils", "getField", e.getMessage());
    L9:
        return null;
    L7:
        e = move-exception;
        int r102 = com.bytedance.caijing.sdk.infra.base.logger.a.f202761a;
        com.bytedance.caijing.sdk.infra.base.logger.a.e("CJReferrerUtils", "getField", e.getMessage());
        goto L9
    }

    public static Object b(Object r100) throws NoSuchFieldException, IllegalAccessException {
        Class<?> r101 = r100.getClass();
        Field r102 = null;
    L4:
        if (r102 != null) goto L15;
        r102 = r101.getDeclaredField("mReferrer");     // Catch: NoSuchFieldException -> L10
        if (r102 == null) goto L11;
        r102.setAccessible(true);     // Catch: NoSuchFieldException -> L10
    L11:
        if (r101 != null) goto L4;
        throw new NoSuchFieldException();
    L10:
        r101 = r101.getSuperclass();
        goto L11
    L15:
        r102.setAccessible(true);
        return r102.get(r100);
    }

    public static String[] c(Activity r100) {
        Object r101 = ActivityManager.class.getMethod("getService", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L18
        Object r102 = Activity.class.getMethod("getActivityToken", new Class[0]).invoke(r100, new Object[0]);     // Catch: Throwable -> L18
        if ((r102 instanceof IBinder) == false) goto L6;
        IBinder r103 = (IBinder) r102;     // Catch: Throwable -> L18
    L7:
        if (r101 == null) goto L17;
        if (r103 == null) goto L17;
        Object r104 = r101.getClass().getMethod("getLaunchedFromUid", new Class[]{IBinder.class}).invoke(r101, new Object[]{r103});     // Catch: Throwable -> L18
        if ((r104 instanceof Integer) == false) goto L13;
        Integer r105 = (Integer) r104;     // Catch: Throwable -> L18
    L14:
        if (r105 == null) goto L17;
        return r100.getPackageManager().getPackagesForUid(r105.intValue());
    L13:
        r105 = null;
    L17:
        return null;
    L6:
        r103 = null;
    L18:
        th = move-exception;
        int r106 = com.bytedance.caijing.sdk.infra.base.logger.a.f202761a;
        com.bytedance.caijing.sdk.infra.base.logger.a.e("CJReferrerUtils", "reRealPackages", th.getMessage());
        return null;
    }
}
