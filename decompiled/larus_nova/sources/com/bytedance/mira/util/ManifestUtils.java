package com.bytedance.mira.util;

import android.content.Context;

/* JADX INFO: loaded from: classes21.dex */
public class ManifestUtils {
    public ManifestUtils() {
    }

    public static Object get(Context r100, String r101) {
        return readKey(r100, r101);
    }

    public static boolean getBoolean(Context r100, String r101) {
        Object r102 = readKey(r100, r101);
        if (r102 != null) goto L5;
        return false;
    L5:
        return ((Boolean) r102).booleanValue();
    }

    public static int getInt(Context r100, String r101) {
        Object r102 = readKey(r100, r101);
        if (r102 != null) goto L5;
        return -1;
    L5:
        return ((Integer) r102).intValue();
    }

    public static String getString(Context r100, String r101) {
        Object r102 = readKey(r100, r101);
        if (r102 != null) goto L5;
        return null;
    L5:
        return (String) r102;
    }

    private static Object readKey(Context r100, String r101) {
        return r100.getPackageManager().getApplicationInfo(r100.getPackageName(), 128).metaData.get(r101);
    L4:
        return null;
    }
}
