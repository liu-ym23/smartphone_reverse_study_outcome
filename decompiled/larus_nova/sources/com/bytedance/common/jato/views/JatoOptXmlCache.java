package com.bytedance.common.jato.views;

import android.content.res.Resources;
import java.lang.reflect.Array;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes15.dex */
public class JatoOptXmlCache {
    public static void expandXmlArraySize(Resources r110, int r111) {
        Object r112 = reflectObject(r110, "mResourcesImpl");     // Catch: IllegalAccessException -> L25 Throwable -> L27
        if (r112 != null) goto L5;
        return;
    L5:
        Field r100 = r112.getClass().getDeclaredField("mCachedXmlBlocks");     // Catch: IllegalAccessException -> L25 Throwable -> L27
        if (r100 != null) goto L8;
        return;
    L8:
        r100.setAccessible(true);     // Catch: IllegalAccessException -> L25 Throwable -> L27
        Object r101 = r100.get(r112);     // Catch: IllegalAccessException -> L25 Throwable -> L27
        monitor-enter(r101);     // Catch: IllegalAccessException -> L25 Throwable -> L27
        Field r102 = r112.getClass().getDeclaredField("mCachedXmlBlockFiles");     // Catch: Throwable -> L22
        if (r102 != null) goto L14;
        monitor-exit(r101);     // Catch: Throwable -> L22
        return;
    L14:
        r102.setAccessible(true);     // Catch: Throwable -> L22
        String[] r103 = (String[]) r102.get(r112);     // Catch: Throwable -> L22
        if (r103.length != 4) goto L20;
        String[] r104 = new String[r111];     // Catch: Throwable -> L22
        Field r105 = r112.getClass().getDeclaredField("mCachedXmlBlockCookies");     // Catch: Throwable -> L22
        r105.setAccessible(true);     // Catch: Throwable -> L22
        int[] r106 = new int[r111];     // Catch: Throwable -> L22
        int[] r107 = (int[]) r105.get(r112);     // Catch: Throwable -> L22
        Object[] r113 = (Object[]) Array.newInstance(r100.getType().getComponentType(), r111);     // Catch: Throwable -> L22
        Object[] r108 = (Object[]) r100.get(r112);     // Catch: Throwable -> L22
        int r114 = 0;
    L17:
        if (r114 >= 4) goto L19;
        r104[r114] = r103[r114];     // Catch: Throwable -> L22
        r106[r114] = r107[r114];     // Catch: Throwable -> L22
        r113[r114] = r108[r114];     // Catch: Throwable -> L22
        r114 = r114 + 1;     // Catch: Throwable -> L22
        goto L17
    L19:
        r102.set(r112, r104);     // Catch: Throwable -> L22
        r105.set(r112, r106);     // Catch: Throwable -> L22
        r100.set(r112, r113);     // Catch: Throwable -> L22
    L20:
        monitor-exit(r101);     // Catch: Throwable -> L22
        return;
    L22:
        th = move-exception;
        throw th;     // Catch: IllegalAccessException -> L25 Throwable -> L27
    L27:
        e = move-exception;
        e.printStackTrace();
    }

    private static <T> T reflectObject(Object r100, String r101) {
        Field r102 = r100.getClass().getDeclaredField(r101);     // Catch: Exception -> L4
        r102.setAccessible(true);     // Catch: Exception -> L4
        return (T) r102.get(r100);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
